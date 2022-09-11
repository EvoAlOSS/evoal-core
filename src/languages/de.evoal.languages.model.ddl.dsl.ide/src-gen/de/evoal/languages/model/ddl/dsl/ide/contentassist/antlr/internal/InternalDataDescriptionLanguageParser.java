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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'real'", "'integer'", "'boolean'", "'string'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'types'", "':'", "'data'", "'constraints'", "'use'", "';'", "'type'", "'description'", "'with'", "'of'", "'value'", "'OR'", "'XOR'", "'AND'", "'^'", "'('", "')'", "','", "'.'", "'!'", "'true'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_ID=5;
    public static final int RULE_QUOTED_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
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
    // InternalDataDescriptionLanguage.g:739:1: ruleDoubleLiteralRule : ( ( rule__DoubleLiteralRule__ValueAssignment ) ) ;
    public final void ruleDoubleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:743:2: ( ( ( rule__DoubleLiteralRule__ValueAssignment ) ) )
            // InternalDataDescriptionLanguage.g:744:2: ( ( rule__DoubleLiteralRule__ValueAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:744:2: ( ( rule__DoubleLiteralRule__ValueAssignment ) )
            // InternalDataDescriptionLanguage.g:745:3: ( rule__DoubleLiteralRule__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getValueAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:746:3: ( rule__DoubleLiteralRule__ValueAssignment )
            // InternalDataDescriptionLanguage.g:746:4: rule__DoubleLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleLiteralRuleAccess().getValueAssignment()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:764:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__ValueAssignment ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:768:2: ( ( ( rule__IntegerLiteralRule__ValueAssignment ) ) )
            // InternalDataDescriptionLanguage.g:769:2: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:769:2: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            // InternalDataDescriptionLanguage.g:770:3: ( rule__IntegerLiteralRule__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getValueAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:771:3: ( rule__IntegerLiteralRule__ValueAssignment )
            // InternalDataDescriptionLanguage.g:771:4: rule__IntegerLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralRuleAccess().getValueAssignment()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__DataDescriptionRule__Alternatives"
    // InternalDataDescriptionLanguage.g:959:1: rule__DataDescriptionRule__Alternatives : ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) );
    public final void rule__DataDescriptionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:963:1: ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:964:2: ( ruleTypedDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:964:2: ( ruleTypedDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:965:3: ruleTypedDataDescriptionRule
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
                    // InternalDataDescriptionLanguage.g:970:2: ( ruleUntypedDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:970:2: ( ruleUntypedDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:971:3: ruleUntypedDataDescriptionRule
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
    // InternalDataDescriptionLanguage.g:980:1: rule__ValueReferenceRule__Alternatives : ( ( ruleDataReferenceRule ) | ( ruleSelfReferenceRule ) );
    public final void rule__ValueReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:984:1: ( ( ruleDataReferenceRule ) | ( ruleSelfReferenceRule ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_QUOTED_ID && LA2_0<=RULE_ID)) ) {
                alt2=1;
            }
            else if ( (LA2_0==42) ) {
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
                    // InternalDataDescriptionLanguage.g:985:2: ( ruleDataReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:985:2: ( ruleDataReferenceRule )
                    // InternalDataDescriptionLanguage.g:986:3: ruleDataReferenceRule
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
                    // InternalDataDescriptionLanguage.g:991:2: ( ruleSelfReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:991:2: ( ruleSelfReferenceRule )
                    // InternalDataDescriptionLanguage.g:992:3: ruleSelfReferenceRule
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
    // InternalDataDescriptionLanguage.g:1001:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );
    public final void rule__LiteralOrReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1005:1: ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==47) ) {
                    alt3=1;
                }
                else if ( (LA3_1==EOF||(LA3_1>=21 && LA3_1<=31)||LA3_1==37||(LA3_1>=43 && LA3_1<=46)||(LA3_1>=48 && LA3_1<=49)) ) {
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
            case 52:
                {
                alt3=2;
                }
                break;
            case 47:
                {
                alt3=3;
                }
                break;
            case RULE_QUOTED_ID:
            case 42:
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
                    // InternalDataDescriptionLanguage.g:1006:2: ( ruleCallRule )
                    {
                    // InternalDataDescriptionLanguage.g:1006:2: ( ruleCallRule )
                    // InternalDataDescriptionLanguage.g:1007:3: ruleCallRule
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
                    // InternalDataDescriptionLanguage.g:1012:2: ( ruleLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1012:2: ( ruleLiteralRule )
                    // InternalDataDescriptionLanguage.g:1013:3: ruleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1018:2: ( ruleParanthesesRule )
                    {
                    // InternalDataDescriptionLanguage.g:1018:2: ( ruleParanthesesRule )
                    // InternalDataDescriptionLanguage.g:1019:3: ruleParanthesesRule
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
                    // InternalDataDescriptionLanguage.g:1024:2: ( ruleValueReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1024:2: ( ruleValueReferenceRule )
                    // InternalDataDescriptionLanguage.g:1025:3: ruleValueReferenceRule
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
    // InternalDataDescriptionLanguage.g:1034:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1038:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) )
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
            case 52:
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
                    // InternalDataDescriptionLanguage.g:1039:2: ( ruleNumberLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1039:2: ( ruleNumberLiteralRule )
                    // InternalDataDescriptionLanguage.g:1040:3: ruleNumberLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1045:2: ( ruleStringLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1045:2: ( ruleStringLiteralRule )
                    // InternalDataDescriptionLanguage.g:1046:3: ruleStringLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1051:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1051:2: ( ruleBooleanLiteralRule )
                    // InternalDataDescriptionLanguage.g:1052:3: ruleBooleanLiteralRule
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
    // InternalDataDescriptionLanguage.g:1061:1: rule__NumberLiteralRule__Alternatives : ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1065:1: ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==EOF||(LA5_1>=21 && LA5_1<=31)||LA5_1==37||(LA5_1>=43 && LA5_1<=46)||(LA5_1>=48 && LA5_1<=49)) ) {
                    alt5=2;
                }
                else if ( (LA5_1==50) ) {
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
                    // InternalDataDescriptionLanguage.g:1066:2: ( ruleDoubleLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1066:2: ( ruleDoubleLiteralRule )
                    // InternalDataDescriptionLanguage.g:1067:3: ruleDoubleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1072:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1072:2: ( ruleIntegerLiteralRule )
                    // InternalDataDescriptionLanguage.g:1073:3: ruleIntegerLiteralRule
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
    // InternalDataDescriptionLanguage.g:1082:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1086:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==52) ) {
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
                    // InternalDataDescriptionLanguage.g:1087:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalDataDescriptionLanguage.g:1087:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalDataDescriptionLanguage.g:1088:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1089:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalDataDescriptionLanguage.g:1089:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalDataDescriptionLanguage.g:1093:2: ( 'false' )
                    {
                    // InternalDataDescriptionLanguage.g:1093:2: ( 'false' )
                    // InternalDataDescriptionLanguage.g:1094:3: 'false'
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
    // InternalDataDescriptionLanguage.g:1103:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1107:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
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
                    // InternalDataDescriptionLanguage.g:1108:2: ( RULE_QUOTED_ID )
                    {
                    // InternalDataDescriptionLanguage.g:1108:2: ( RULE_QUOTED_ID )
                    // InternalDataDescriptionLanguage.g:1109:3: RULE_QUOTED_ID
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
                    // InternalDataDescriptionLanguage.g:1114:2: ( RULE_ID )
                    {
                    // InternalDataDescriptionLanguage.g:1114:2: ( RULE_ID )
                    // InternalDataDescriptionLanguage.g:1115:3: RULE_ID
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
    // InternalDataDescriptionLanguage.g:1124:1: rule__ScaleType__Alternatives : ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) );
    public final void rule__ScaleType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1128:1: ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) )
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
                    // InternalDataDescriptionLanguage.g:1129:2: ( ( 'nominal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1129:2: ( ( 'nominal' ) )
                    // InternalDataDescriptionLanguage.g:1130:3: ( 'nominal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1131:3: ( 'nominal' )
                    // InternalDataDescriptionLanguage.g:1131:4: 'nominal'
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
                    // InternalDataDescriptionLanguage.g:1135:2: ( ( 'ordinal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1135:2: ( ( 'ordinal' ) )
                    // InternalDataDescriptionLanguage.g:1136:3: ( 'ordinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1137:3: ( 'ordinal' )
                    // InternalDataDescriptionLanguage.g:1137:4: 'ordinal'
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
                    // InternalDataDescriptionLanguage.g:1141:2: ( ( 'cardinal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1141:2: ( ( 'cardinal' ) )
                    // InternalDataDescriptionLanguage.g:1142:3: ( 'cardinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1143:3: ( 'cardinal' )
                    // InternalDataDescriptionLanguage.g:1143:4: 'cardinal'
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
                    // InternalDataDescriptionLanguage.g:1147:2: ( ( 'quotient' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1147:2: ( ( 'quotient' ) )
                    // InternalDataDescriptionLanguage.g:1148:3: ( 'quotient' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getQuotientEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1149:3: ( 'quotient' )
                    // InternalDataDescriptionLanguage.g:1149:4: 'quotient'
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
    // InternalDataDescriptionLanguage.g:1157:1: rule__RepresentationType__Alternatives : ( ( ( 'real' ) ) | ( ( 'integer' ) ) | ( ( 'boolean' ) ) | ( ( 'string' ) ) );
    public final void rule__RepresentationType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1161:1: ( ( ( 'real' ) ) | ( ( 'integer' ) ) | ( ( 'boolean' ) ) | ( ( 'string' ) ) )
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
                    // InternalDataDescriptionLanguage.g:1162:2: ( ( 'real' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1162:2: ( ( 'real' ) )
                    // InternalDataDescriptionLanguage.g:1163:3: ( 'real' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1164:3: ( 'real' )
                    // InternalDataDescriptionLanguage.g:1164:4: 'real'
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
                    // InternalDataDescriptionLanguage.g:1168:2: ( ( 'integer' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1168:2: ( ( 'integer' ) )
                    // InternalDataDescriptionLanguage.g:1169:3: ( 'integer' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1170:3: ( 'integer' )
                    // InternalDataDescriptionLanguage.g:1170:4: 'integer'
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
                    // InternalDataDescriptionLanguage.g:1174:2: ( ( 'boolean' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1174:2: ( ( 'boolean' ) )
                    // InternalDataDescriptionLanguage.g:1175:3: ( 'boolean' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1176:3: ( 'boolean' )
                    // InternalDataDescriptionLanguage.g:1176:4: 'boolean'
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
                    // InternalDataDescriptionLanguage.g:1180:2: ( ( 'string' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1180:2: ( ( 'string' ) )
                    // InternalDataDescriptionLanguage.g:1181:3: ( 'string' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getStringEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1182:3: ( 'string' )
                    // InternalDataDescriptionLanguage.g:1182:4: 'string'
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
    // InternalDataDescriptionLanguage.g:1190:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1194:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
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
                    // InternalDataDescriptionLanguage.g:1195:2: ( ( '>=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1195:2: ( ( '>=' ) )
                    // InternalDataDescriptionLanguage.g:1196:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1197:3: ( '>=' )
                    // InternalDataDescriptionLanguage.g:1197:4: '>='
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
                    // InternalDataDescriptionLanguage.g:1201:2: ( ( '>' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1201:2: ( ( '>' ) )
                    // InternalDataDescriptionLanguage.g:1202:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1203:3: ( '>' )
                    // InternalDataDescriptionLanguage.g:1203:4: '>'
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
                    // InternalDataDescriptionLanguage.g:1207:2: ( ( '=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1207:2: ( ( '=' ) )
                    // InternalDataDescriptionLanguage.g:1208:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1209:3: ( '=' )
                    // InternalDataDescriptionLanguage.g:1209:4: '='
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
                    // InternalDataDescriptionLanguage.g:1213:2: ( ( '!=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1213:2: ( ( '!=' ) )
                    // InternalDataDescriptionLanguage.g:1214:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1215:3: ( '!=' )
                    // InternalDataDescriptionLanguage.g:1215:4: '!='
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
                    // InternalDataDescriptionLanguage.g:1219:2: ( ( '<' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1219:2: ( ( '<' ) )
                    // InternalDataDescriptionLanguage.g:1220:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalDataDescriptionLanguage.g:1221:3: ( '<' )
                    // InternalDataDescriptionLanguage.g:1221:4: '<'
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
                    // InternalDataDescriptionLanguage.g:1225:2: ( ( '<=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1225:2: ( ( '<=' ) )
                    // InternalDataDescriptionLanguage.g:1226:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalDataDescriptionLanguage.g:1227:3: ( '<=' )
                    // InternalDataDescriptionLanguage.g:1227:4: '<='
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
    // InternalDataDescriptionLanguage.g:1235:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1239:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
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
                    // InternalDataDescriptionLanguage.g:1240:2: ( ( '+' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1240:2: ( ( '+' ) )
                    // InternalDataDescriptionLanguage.g:1241:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1242:3: ( '+' )
                    // InternalDataDescriptionLanguage.g:1242:4: '+'
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
                    // InternalDataDescriptionLanguage.g:1246:2: ( ( '-' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1246:2: ( ( '-' ) )
                    // InternalDataDescriptionLanguage.g:1247:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1248:3: ( '-' )
                    // InternalDataDescriptionLanguage.g:1248:4: '-'
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
    // InternalDataDescriptionLanguage.g:1256:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1260:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
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
                    // InternalDataDescriptionLanguage.g:1261:2: ( ( '*' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1261:2: ( ( '*' ) )
                    // InternalDataDescriptionLanguage.g:1262:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1263:3: ( '*' )
                    // InternalDataDescriptionLanguage.g:1263:4: '*'
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
                    // InternalDataDescriptionLanguage.g:1267:2: ( ( '/' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1267:2: ( ( '/' ) )
                    // InternalDataDescriptionLanguage.g:1268:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1269:3: ( '/' )
                    // InternalDataDescriptionLanguage.g:1269:4: '/'
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
                    // InternalDataDescriptionLanguage.g:1273:2: ( ( '%' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1273:2: ( ( '%' ) )
                    // InternalDataDescriptionLanguage.g:1274:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1275:3: ( '%' )
                    // InternalDataDescriptionLanguage.g:1275:4: '%'
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


    // $ANTLR start "rule__DataDescriptionModelRule__Group__0"
    // InternalDataDescriptionLanguage.g:1283:1: rule__DataDescriptionModelRule__Group__0 : rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1 ;
    public final void rule__DataDescriptionModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1287:1: ( rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1 )
            // InternalDataDescriptionLanguage.g:1288:2: rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1
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
    // InternalDataDescriptionLanguage.g:1295:1: rule__DataDescriptionModelRule__Group__0__Impl : ( () ) ;
    public final void rule__DataDescriptionModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1299:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:1300:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:1300:1: ( () )
            // InternalDataDescriptionLanguage.g:1301:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDataDescriptionModelAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:1302:2: ()
            // InternalDataDescriptionLanguage.g:1302:3: 
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
    // InternalDataDescriptionLanguage.g:1310:1: rule__DataDescriptionModelRule__Group__1 : rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2 ;
    public final void rule__DataDescriptionModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1314:1: ( rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2 )
            // InternalDataDescriptionLanguage.g:1315:2: rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2
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
    // InternalDataDescriptionLanguage.g:1322:1: rule__DataDescriptionModelRule__Group__1__Impl : ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* ) ;
    public final void rule__DataDescriptionModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1326:1: ( ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* ) )
            // InternalDataDescriptionLanguage.g:1327:1: ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* )
            {
            // InternalDataDescriptionLanguage.g:1327:1: ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* )
            // InternalDataDescriptionLanguage.g:1328:2: ( rule__DataDescriptionModelRule__UsesAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getUsesAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:1329:2: ( rule__DataDescriptionModelRule__UsesAssignment_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==36) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1329:3: rule__DataDescriptionModelRule__UsesAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__DataDescriptionModelRule__UsesAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalDataDescriptionLanguage.g:1337:1: rule__DataDescriptionModelRule__Group__2 : rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3 ;
    public final void rule__DataDescriptionModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1341:1: ( rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3 )
            // InternalDataDescriptionLanguage.g:1342:2: rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3
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
    // InternalDataDescriptionLanguage.g:1349:1: rule__DataDescriptionModelRule__Group__2__Impl : ( ( rule__DataDescriptionModelRule__Group_2__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1353:1: ( ( ( rule__DataDescriptionModelRule__Group_2__0 )? ) )
            // InternalDataDescriptionLanguage.g:1354:1: ( ( rule__DataDescriptionModelRule__Group_2__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1354:1: ( ( rule__DataDescriptionModelRule__Group_2__0 )? )
            // InternalDataDescriptionLanguage.g:1355:2: ( rule__DataDescriptionModelRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_2()); 
            }
            // InternalDataDescriptionLanguage.g:1356:2: ( rule__DataDescriptionModelRule__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==32) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1356:3: rule__DataDescriptionModelRule__Group_2__0
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
    // InternalDataDescriptionLanguage.g:1364:1: rule__DataDescriptionModelRule__Group__3 : rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4 ;
    public final void rule__DataDescriptionModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1368:1: ( rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4 )
            // InternalDataDescriptionLanguage.g:1369:2: rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4
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
    // InternalDataDescriptionLanguage.g:1376:1: rule__DataDescriptionModelRule__Group__3__Impl : ( ( rule__DataDescriptionModelRule__Group_3__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1380:1: ( ( ( rule__DataDescriptionModelRule__Group_3__0 )? ) )
            // InternalDataDescriptionLanguage.g:1381:1: ( ( rule__DataDescriptionModelRule__Group_3__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1381:1: ( ( rule__DataDescriptionModelRule__Group_3__0 )? )
            // InternalDataDescriptionLanguage.g:1382:2: ( rule__DataDescriptionModelRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:1383:2: ( rule__DataDescriptionModelRule__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1383:3: rule__DataDescriptionModelRule__Group_3__0
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
    // InternalDataDescriptionLanguage.g:1391:1: rule__DataDescriptionModelRule__Group__4 : rule__DataDescriptionModelRule__Group__4__Impl ;
    public final void rule__DataDescriptionModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1395:1: ( rule__DataDescriptionModelRule__Group__4__Impl )
            // InternalDataDescriptionLanguage.g:1396:2: rule__DataDescriptionModelRule__Group__4__Impl
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
    // InternalDataDescriptionLanguage.g:1402:1: rule__DataDescriptionModelRule__Group__4__Impl : ( ( rule__DataDescriptionModelRule__Group_4__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1406:1: ( ( ( rule__DataDescriptionModelRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:1407:1: ( ( rule__DataDescriptionModelRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1407:1: ( ( rule__DataDescriptionModelRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:1408:2: ( rule__DataDescriptionModelRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:1409:2: ( rule__DataDescriptionModelRule__Group_4__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1409:3: rule__DataDescriptionModelRule__Group_4__0
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
    // InternalDataDescriptionLanguage.g:1418:1: rule__DataDescriptionModelRule__Group_2__0 : rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1 ;
    public final void rule__DataDescriptionModelRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1422:1: ( rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1 )
            // InternalDataDescriptionLanguage.g:1423:2: rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1
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
    // InternalDataDescriptionLanguage.g:1430:1: rule__DataDescriptionModelRule__Group_2__0__Impl : ( 'types' ) ;
    public final void rule__DataDescriptionModelRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1434:1: ( ( 'types' ) )
            // InternalDataDescriptionLanguage.g:1435:1: ( 'types' )
            {
            // InternalDataDescriptionLanguage.g:1435:1: ( 'types' )
            // InternalDataDescriptionLanguage.g:1436:2: 'types'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesKeyword_2_0()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1445:1: rule__DataDescriptionModelRule__Group_2__1 : rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2 ;
    public final void rule__DataDescriptionModelRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1449:1: ( rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2 )
            // InternalDataDescriptionLanguage.g:1450:2: rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2
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
    // InternalDataDescriptionLanguage.g:1457:1: rule__DataDescriptionModelRule__Group_2__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1461:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:1462:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:1462:1: ( ':' )
            // InternalDataDescriptionLanguage.g:1463:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_2_1()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1472:1: rule__DataDescriptionModelRule__Group_2__2 : rule__DataDescriptionModelRule__Group_2__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1476:1: ( rule__DataDescriptionModelRule__Group_2__2__Impl )
            // InternalDataDescriptionLanguage.g:1477:2: rule__DataDescriptionModelRule__Group_2__2__Impl
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
    // InternalDataDescriptionLanguage.g:1483:1: rule__DataDescriptionModelRule__Group_2__2__Impl : ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1487:1: ( ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* ) )
            // InternalDataDescriptionLanguage.g:1488:1: ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* )
            {
            // InternalDataDescriptionLanguage.g:1488:1: ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* )
            // InternalDataDescriptionLanguage.g:1489:2: ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesAssignment_2_2()); 
            }
            // InternalDataDescriptionLanguage.g:1490:2: ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=13 && LA17_0<=16)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1490:3: rule__DataDescriptionModelRule__TypesAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__DataDescriptionModelRule__TypesAssignment_2_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalDataDescriptionLanguage.g:1499:1: rule__DataDescriptionModelRule__Group_3__0 : rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1 ;
    public final void rule__DataDescriptionModelRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1503:1: ( rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:1504:2: rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1
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
    // InternalDataDescriptionLanguage.g:1511:1: rule__DataDescriptionModelRule__Group_3__0__Impl : ( 'data' ) ;
    public final void rule__DataDescriptionModelRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1515:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:1516:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:1516:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:1517:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDataKeyword_3_0()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1526:1: rule__DataDescriptionModelRule__Group_3__1 : rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2 ;
    public final void rule__DataDescriptionModelRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1530:1: ( rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2 )
            // InternalDataDescriptionLanguage.g:1531:2: rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2
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
    // InternalDataDescriptionLanguage.g:1538:1: rule__DataDescriptionModelRule__Group_3__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1542:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:1543:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:1543:1: ( ':' )
            // InternalDataDescriptionLanguage.g:1544:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_3_1()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1553:1: rule__DataDescriptionModelRule__Group_3__2 : rule__DataDescriptionModelRule__Group_3__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1557:1: ( rule__DataDescriptionModelRule__Group_3__2__Impl )
            // InternalDataDescriptionLanguage.g:1558:2: rule__DataDescriptionModelRule__Group_3__2__Impl
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
    // InternalDataDescriptionLanguage.g:1564:1: rule__DataDescriptionModelRule__Group_3__2__Impl : ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1568:1: ( ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* ) )
            // InternalDataDescriptionLanguage.g:1569:1: ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* )
            {
            // InternalDataDescriptionLanguage.g:1569:1: ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* )
            // InternalDataDescriptionLanguage.g:1570:2: ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsAssignment_3_2()); 
            }
            // InternalDataDescriptionLanguage.g:1571:2: ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=13 && LA18_0<=20)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1571:3: rule__DataDescriptionModelRule__DescriptionsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataDescriptionModelRule__DescriptionsAssignment_3_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalDataDescriptionLanguage.g:1580:1: rule__DataDescriptionModelRule__Group_4__0 : rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1 ;
    public final void rule__DataDescriptionModelRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1584:1: ( rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:1585:2: rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1
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
    // InternalDataDescriptionLanguage.g:1592:1: rule__DataDescriptionModelRule__Group_4__0__Impl : ( 'constraints' ) ;
    public final void rule__DataDescriptionModelRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1596:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:1597:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:1597:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:1598:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsKeyword_4_0()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1607:1: rule__DataDescriptionModelRule__Group_4__1 : rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2 ;
    public final void rule__DataDescriptionModelRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1611:1: ( rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:1612:2: rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2
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
    // InternalDataDescriptionLanguage.g:1619:1: rule__DataDescriptionModelRule__Group_4__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1623:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:1624:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:1624:1: ( ':' )
            // InternalDataDescriptionLanguage.g:1625:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_4_1()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1634:1: rule__DataDescriptionModelRule__Group_4__2 : rule__DataDescriptionModelRule__Group_4__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1638:1: ( rule__DataDescriptionModelRule__Group_4__2__Impl )
            // InternalDataDescriptionLanguage.g:1639:2: rule__DataDescriptionModelRule__Group_4__2__Impl
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
    // InternalDataDescriptionLanguage.g:1645:1: rule__DataDescriptionModelRule__Group_4__2__Impl : ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1649:1: ( ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* ) )
            // InternalDataDescriptionLanguage.g:1650:1: ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* )
            {
            // InternalDataDescriptionLanguage.g:1650:1: ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* )
            // InternalDataDescriptionLanguage.g:1651:2: ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsAssignment_4_2()); 
            }
            // InternalDataDescriptionLanguage.g:1652:2: ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_QUOTED_ID && LA19_0<=RULE_STRING)||LA19_0==12||(LA19_0>=27 && LA19_0<=28)||LA19_0==42||LA19_0==47||(LA19_0>=51 && LA19_0<=52)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1652:3: rule__DataDescriptionModelRule__ConstraintsAssignment_4_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__DataDescriptionModelRule__ConstraintsAssignment_4_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalDataDescriptionLanguage.g:1661:1: rule__UseRule__Group__0 : rule__UseRule__Group__0__Impl rule__UseRule__Group__1 ;
    public final void rule__UseRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1665:1: ( rule__UseRule__Group__0__Impl rule__UseRule__Group__1 )
            // InternalDataDescriptionLanguage.g:1666:2: rule__UseRule__Group__0__Impl rule__UseRule__Group__1
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
    // InternalDataDescriptionLanguage.g:1673:1: rule__UseRule__Group__0__Impl : ( 'use' ) ;
    public final void rule__UseRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1677:1: ( ( 'use' ) )
            // InternalDataDescriptionLanguage.g:1678:1: ( 'use' )
            {
            // InternalDataDescriptionLanguage.g:1678:1: ( 'use' )
            // InternalDataDescriptionLanguage.g:1679:2: 'use'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getUseKeyword_0()); 
            }
            match(input,36,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1688:1: rule__UseRule__Group__1 : rule__UseRule__Group__1__Impl rule__UseRule__Group__2 ;
    public final void rule__UseRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1692:1: ( rule__UseRule__Group__1__Impl rule__UseRule__Group__2 )
            // InternalDataDescriptionLanguage.g:1693:2: rule__UseRule__Group__1__Impl rule__UseRule__Group__2
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
    // InternalDataDescriptionLanguage.g:1700:1: rule__UseRule__Group__1__Impl : ( ( rule__UseRule__ImportURIAssignment_1 ) ) ;
    public final void rule__UseRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1704:1: ( ( ( rule__UseRule__ImportURIAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:1705:1: ( ( rule__UseRule__ImportURIAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:1705:1: ( ( rule__UseRule__ImportURIAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:1706:2: ( rule__UseRule__ImportURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getImportURIAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:1707:2: ( rule__UseRule__ImportURIAssignment_1 )
            // InternalDataDescriptionLanguage.g:1707:3: rule__UseRule__ImportURIAssignment_1
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
    // InternalDataDescriptionLanguage.g:1715:1: rule__UseRule__Group__2 : rule__UseRule__Group__2__Impl ;
    public final void rule__UseRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1719:1: ( rule__UseRule__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:1720:2: rule__UseRule__Group__2__Impl
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
    // InternalDataDescriptionLanguage.g:1726:1: rule__UseRule__Group__2__Impl : ( ';' ) ;
    public final void rule__UseRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1730:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:1731:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:1731:1: ( ';' )
            // InternalDataDescriptionLanguage.g:1732:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getSemicolonKeyword_2()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1742:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1746:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:1747:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
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
    // InternalDataDescriptionLanguage.g:1754:1: rule__DataTypeRule__Group__0__Impl : ( ( rule__DataTypeRule__ScaleAssignment_0 ) ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1758:1: ( ( ( rule__DataTypeRule__ScaleAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:1759:1: ( ( rule__DataTypeRule__ScaleAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:1759:1: ( ( rule__DataTypeRule__ScaleAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:1760:2: ( rule__DataTypeRule__ScaleAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getScaleAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:1761:2: ( rule__DataTypeRule__ScaleAssignment_0 )
            // InternalDataDescriptionLanguage.g:1761:3: rule__DataTypeRule__ScaleAssignment_0
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
    // InternalDataDescriptionLanguage.g:1769:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl rule__DataTypeRule__Group__2 ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1773:1: ( rule__DataTypeRule__Group__1__Impl rule__DataTypeRule__Group__2 )
            // InternalDataDescriptionLanguage.g:1774:2: rule__DataTypeRule__Group__1__Impl rule__DataTypeRule__Group__2
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
    // InternalDataDescriptionLanguage.g:1781:1: rule__DataTypeRule__Group__1__Impl : ( 'type' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1785:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:1786:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:1786:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:1787:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getTypeKeyword_1()); 
            }
            match(input,38,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1796:1: rule__DataTypeRule__Group__2 : rule__DataTypeRule__Group__2__Impl rule__DataTypeRule__Group__3 ;
    public final void rule__DataTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1800:1: ( rule__DataTypeRule__Group__2__Impl rule__DataTypeRule__Group__3 )
            // InternalDataDescriptionLanguage.g:1801:2: rule__DataTypeRule__Group__2__Impl rule__DataTypeRule__Group__3
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
    // InternalDataDescriptionLanguage.g:1808:1: rule__DataTypeRule__Group__2__Impl : ( ( rule__DataTypeRule__NameAssignment_2 ) ) ;
    public final void rule__DataTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1812:1: ( ( ( rule__DataTypeRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:1813:1: ( ( rule__DataTypeRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:1813:1: ( ( rule__DataTypeRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:1814:2: ( rule__DataTypeRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:1815:2: ( rule__DataTypeRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:1815:3: rule__DataTypeRule__NameAssignment_2
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
    // InternalDataDescriptionLanguage.g:1823:1: rule__DataTypeRule__Group__3 : rule__DataTypeRule__Group__3__Impl rule__DataTypeRule__Group__4 ;
    public final void rule__DataTypeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1827:1: ( rule__DataTypeRule__Group__3__Impl rule__DataTypeRule__Group__4 )
            // InternalDataDescriptionLanguage.g:1828:2: rule__DataTypeRule__Group__3__Impl rule__DataTypeRule__Group__4
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
    // InternalDataDescriptionLanguage.g:1835:1: rule__DataTypeRule__Group__3__Impl : ( ( rule__DataTypeRule__Group_3__0 )? ) ;
    public final void rule__DataTypeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1839:1: ( ( ( rule__DataTypeRule__Group_3__0 )? ) )
            // InternalDataDescriptionLanguage.g:1840:1: ( ( rule__DataTypeRule__Group_3__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1840:1: ( ( rule__DataTypeRule__Group_3__0 )? )
            // InternalDataDescriptionLanguage.g:1841:2: ( rule__DataTypeRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:1842:2: ( rule__DataTypeRule__Group_3__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==39) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1842:3: rule__DataTypeRule__Group_3__0
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
    // InternalDataDescriptionLanguage.g:1850:1: rule__DataTypeRule__Group__4 : rule__DataTypeRule__Group__4__Impl rule__DataTypeRule__Group__5 ;
    public final void rule__DataTypeRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1854:1: ( rule__DataTypeRule__Group__4__Impl rule__DataTypeRule__Group__5 )
            // InternalDataDescriptionLanguage.g:1855:2: rule__DataTypeRule__Group__4__Impl rule__DataTypeRule__Group__5
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
    // InternalDataDescriptionLanguage.g:1862:1: rule__DataTypeRule__Group__4__Impl : ( ( rule__DataTypeRule__Group_4__0 )? ) ;
    public final void rule__DataTypeRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1866:1: ( ( ( rule__DataTypeRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:1867:1: ( ( rule__DataTypeRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1867:1: ( ( rule__DataTypeRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:1868:2: ( rule__DataTypeRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:1869:2: ( rule__DataTypeRule__Group_4__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==40) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1869:3: rule__DataTypeRule__Group_4__0
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
    // InternalDataDescriptionLanguage.g:1877:1: rule__DataTypeRule__Group__5 : rule__DataTypeRule__Group__5__Impl ;
    public final void rule__DataTypeRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1881:1: ( rule__DataTypeRule__Group__5__Impl )
            // InternalDataDescriptionLanguage.g:1882:2: rule__DataTypeRule__Group__5__Impl
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
    // InternalDataDescriptionLanguage.g:1888:1: rule__DataTypeRule__Group__5__Impl : ( ';' ) ;
    public final void rule__DataTypeRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1892:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:1893:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:1893:1: ( ';' )
            // InternalDataDescriptionLanguage.g:1894:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1904:1: rule__DataTypeRule__Group_3__0 : rule__DataTypeRule__Group_3__0__Impl rule__DataTypeRule__Group_3__1 ;
    public final void rule__DataTypeRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1908:1: ( rule__DataTypeRule__Group_3__0__Impl rule__DataTypeRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:1909:2: rule__DataTypeRule__Group_3__0__Impl rule__DataTypeRule__Group_3__1
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
    // InternalDataDescriptionLanguage.g:1916:1: rule__DataTypeRule__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__DataTypeRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1920:1: ( ( 'description' ) )
            // InternalDataDescriptionLanguage.g:1921:1: ( 'description' )
            {
            // InternalDataDescriptionLanguage.g:1921:1: ( 'description' )
            // InternalDataDescriptionLanguage.g:1922:2: 'description'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDescriptionKeyword_3_0()); 
            }
            match(input,39,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1931:1: rule__DataTypeRule__Group_3__1 : rule__DataTypeRule__Group_3__1__Impl rule__DataTypeRule__Group_3__2 ;
    public final void rule__DataTypeRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1935:1: ( rule__DataTypeRule__Group_3__1__Impl rule__DataTypeRule__Group_3__2 )
            // InternalDataDescriptionLanguage.g:1936:2: rule__DataTypeRule__Group_3__1__Impl rule__DataTypeRule__Group_3__2
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
    // InternalDataDescriptionLanguage.g:1943:1: rule__DataTypeRule__Group_3__1__Impl : ( ':' ) ;
    public final void rule__DataTypeRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1947:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:1948:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:1948:1: ( ':' )
            // InternalDataDescriptionLanguage.g:1949:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getColonKeyword_3_1()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:1958:1: rule__DataTypeRule__Group_3__2 : rule__DataTypeRule__Group_3__2__Impl ;
    public final void rule__DataTypeRule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1962:1: ( rule__DataTypeRule__Group_3__2__Impl )
            // InternalDataDescriptionLanguage.g:1963:2: rule__DataTypeRule__Group_3__2__Impl
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
    // InternalDataDescriptionLanguage.g:1969:1: rule__DataTypeRule__Group_3__2__Impl : ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) ) ;
    public final void rule__DataTypeRule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1973:1: ( ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) ) )
            // InternalDataDescriptionLanguage.g:1974:1: ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) )
            {
            // InternalDataDescriptionLanguage.g:1974:1: ( ( rule__DataTypeRule__DescriptionAssignment_3_2 ) )
            // InternalDataDescriptionLanguage.g:1975:2: ( rule__DataTypeRule__DescriptionAssignment_3_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDescriptionAssignment_3_2()); 
            }
            // InternalDataDescriptionLanguage.g:1976:2: ( rule__DataTypeRule__DescriptionAssignment_3_2 )
            // InternalDataDescriptionLanguage.g:1976:3: rule__DataTypeRule__DescriptionAssignment_3_2
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
    // InternalDataDescriptionLanguage.g:1985:1: rule__DataTypeRule__Group_4__0 : rule__DataTypeRule__Group_4__0__Impl rule__DataTypeRule__Group_4__1 ;
    public final void rule__DataTypeRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1989:1: ( rule__DataTypeRule__Group_4__0__Impl rule__DataTypeRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:1990:2: rule__DataTypeRule__Group_4__0__Impl rule__DataTypeRule__Group_4__1
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
    // InternalDataDescriptionLanguage.g:1997:1: rule__DataTypeRule__Group_4__0__Impl : ( 'with' ) ;
    public final void rule__DataTypeRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2001:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2002:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2002:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2003:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getWithKeyword_4_0()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2012:1: rule__DataTypeRule__Group_4__1 : rule__DataTypeRule__Group_4__1__Impl rule__DataTypeRule__Group_4__2 ;
    public final void rule__DataTypeRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2016:1: ( rule__DataTypeRule__Group_4__1__Impl rule__DataTypeRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:2017:2: rule__DataTypeRule__Group_4__1__Impl rule__DataTypeRule__Group_4__2
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
    // InternalDataDescriptionLanguage.g:2024:1: rule__DataTypeRule__Group_4__1__Impl : ( 'constraints' ) ;
    public final void rule__DataTypeRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2028:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2029:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2029:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2030:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getConstraintsKeyword_4_1()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2039:1: rule__DataTypeRule__Group_4__2 : rule__DataTypeRule__Group_4__2__Impl rule__DataTypeRule__Group_4__3 ;
    public final void rule__DataTypeRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2043:1: ( rule__DataTypeRule__Group_4__2__Impl rule__DataTypeRule__Group_4__3 )
            // InternalDataDescriptionLanguage.g:2044:2: rule__DataTypeRule__Group_4__2__Impl rule__DataTypeRule__Group_4__3
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
    // InternalDataDescriptionLanguage.g:2051:1: rule__DataTypeRule__Group_4__2__Impl : ( ':' ) ;
    public final void rule__DataTypeRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2055:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2056:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2056:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2057:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getColonKeyword_4_2()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2066:1: rule__DataTypeRule__Group_4__3 : rule__DataTypeRule__Group_4__3__Impl ;
    public final void rule__DataTypeRule__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2070:1: ( rule__DataTypeRule__Group_4__3__Impl )
            // InternalDataDescriptionLanguage.g:2071:2: rule__DataTypeRule__Group_4__3__Impl
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
    // InternalDataDescriptionLanguage.g:2077:1: rule__DataTypeRule__Group_4__3__Impl : ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* ) ;
    public final void rule__DataTypeRule__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2081:1: ( ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* ) )
            // InternalDataDescriptionLanguage.g:2082:1: ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2082:1: ( ( rule__DataTypeRule__ConstraintsAssignment_4_3 )* )
            // InternalDataDescriptionLanguage.g:2083:2: ( rule__DataTypeRule__ConstraintsAssignment_4_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getConstraintsAssignment_4_3()); 
            }
            // InternalDataDescriptionLanguage.g:2084:2: ( rule__DataTypeRule__ConstraintsAssignment_4_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=RULE_QUOTED_ID && LA22_0<=RULE_STRING)||LA22_0==12||(LA22_0>=27 && LA22_0<=28)||LA22_0==42||LA22_0==47||(LA22_0>=51 && LA22_0<=52)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2084:3: rule__DataTypeRule__ConstraintsAssignment_4_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__DataTypeRule__ConstraintsAssignment_4_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalDataDescriptionLanguage.g:2093:1: rule__TypedDataDescriptionRule__Group__0 : rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1 ;
    public final void rule__TypedDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2097:1: ( rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2098:2: rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2105:1: rule__TypedDataDescriptionRule__Group__0__Impl : ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2109:1: ( ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:2110:1: ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:2110:1: ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:2111:2: ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getRepresentationAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2112:2: ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 )
            // InternalDataDescriptionLanguage.g:2112:3: rule__TypedDataDescriptionRule__RepresentationAssignment_0
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
    // InternalDataDescriptionLanguage.g:2120:1: rule__TypedDataDescriptionRule__Group__1 : rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2 ;
    public final void rule__TypedDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2124:1: ( rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2125:2: rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2
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
    // InternalDataDescriptionLanguage.g:2132:1: rule__TypedDataDescriptionRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__TypedDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2136:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:2137:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:2137:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:2138:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getDataKeyword_1()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2147:1: rule__TypedDataDescriptionRule__Group__2 : rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3 ;
    public final void rule__TypedDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2151:1: ( rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2152:2: rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3
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
    // InternalDataDescriptionLanguage.g:2159:1: rule__TypedDataDescriptionRule__Group__2__Impl : ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2163:1: ( ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:2164:1: ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:2164:1: ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:2165:2: ( rule__TypedDataDescriptionRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:2166:2: ( rule__TypedDataDescriptionRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:2166:3: rule__TypedDataDescriptionRule__NameAssignment_2
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
    // InternalDataDescriptionLanguage.g:2174:1: rule__TypedDataDescriptionRule__Group__3 : rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4 ;
    public final void rule__TypedDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2178:1: ( rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2179:2: rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4
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
    // InternalDataDescriptionLanguage.g:2186:1: rule__TypedDataDescriptionRule__Group__3__Impl : ( 'of' ) ;
    public final void rule__TypedDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2190:1: ( ( 'of' ) )
            // InternalDataDescriptionLanguage.g:2191:1: ( 'of' )
            {
            // InternalDataDescriptionLanguage.g:2191:1: ( 'of' )
            // InternalDataDescriptionLanguage.g:2192:2: 'of'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getOfKeyword_3()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2201:1: rule__TypedDataDescriptionRule__Group__4 : rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5 ;
    public final void rule__TypedDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2205:1: ( rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2206:2: rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5
            {
            pushFollow(FOLLOW_20);
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
    // InternalDataDescriptionLanguage.g:2213:1: rule__TypedDataDescriptionRule__Group__4__Impl : ( 'type' ) ;
    public final void rule__TypedDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2217:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:2218:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:2218:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:2219:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeKeyword_4()); 
            }
            match(input,38,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2228:1: rule__TypedDataDescriptionRule__Group__5 : rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6 ;
    public final void rule__TypedDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2232:1: ( rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6 )
            // InternalDataDescriptionLanguage.g:2233:2: rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6
            {
            pushFollow(FOLLOW_21);
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
    // InternalDataDescriptionLanguage.g:2240:1: rule__TypedDataDescriptionRule__Group__5__Impl : ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2244:1: ( ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) ) )
            // InternalDataDescriptionLanguage.g:2245:1: ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) )
            {
            // InternalDataDescriptionLanguage.g:2245:1: ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) )
            // InternalDataDescriptionLanguage.g:2246:2: ( rule__TypedDataDescriptionRule__TypeAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeAssignment_5()); 
            }
            // InternalDataDescriptionLanguage.g:2247:2: ( rule__TypedDataDescriptionRule__TypeAssignment_5 )
            // InternalDataDescriptionLanguage.g:2247:3: rule__TypedDataDescriptionRule__TypeAssignment_5
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
    // InternalDataDescriptionLanguage.g:2255:1: rule__TypedDataDescriptionRule__Group__6 : rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7 ;
    public final void rule__TypedDataDescriptionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2259:1: ( rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7 )
            // InternalDataDescriptionLanguage.g:2260:2: rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7
            {
            pushFollow(FOLLOW_21);
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
    // InternalDataDescriptionLanguage.g:2267:1: rule__TypedDataDescriptionRule__Group__6__Impl : ( ( rule__TypedDataDescriptionRule__Group_6__0 )? ) ;
    public final void rule__TypedDataDescriptionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2271:1: ( ( ( rule__TypedDataDescriptionRule__Group_6__0 )? ) )
            // InternalDataDescriptionLanguage.g:2272:1: ( ( rule__TypedDataDescriptionRule__Group_6__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2272:1: ( ( rule__TypedDataDescriptionRule__Group_6__0 )? )
            // InternalDataDescriptionLanguage.g:2273:2: ( rule__TypedDataDescriptionRule__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getGroup_6()); 
            }
            // InternalDataDescriptionLanguage.g:2274:2: ( rule__TypedDataDescriptionRule__Group_6__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==40) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2274:3: rule__TypedDataDescriptionRule__Group_6__0
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
    // InternalDataDescriptionLanguage.g:2282:1: rule__TypedDataDescriptionRule__Group__7 : rule__TypedDataDescriptionRule__Group__7__Impl ;
    public final void rule__TypedDataDescriptionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2286:1: ( rule__TypedDataDescriptionRule__Group__7__Impl )
            // InternalDataDescriptionLanguage.g:2287:2: rule__TypedDataDescriptionRule__Group__7__Impl
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
    // InternalDataDescriptionLanguage.g:2293:1: rule__TypedDataDescriptionRule__Group__7__Impl : ( ';' ) ;
    public final void rule__TypedDataDescriptionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2297:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2298:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2298:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2299:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getSemicolonKeyword_7()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2309:1: rule__TypedDataDescriptionRule__Group_6__0 : rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1 ;
    public final void rule__TypedDataDescriptionRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2313:1: ( rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1 )
            // InternalDataDescriptionLanguage.g:2314:2: rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1
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
    // InternalDataDescriptionLanguage.g:2321:1: rule__TypedDataDescriptionRule__Group_6__0__Impl : ( 'with' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2325:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2326:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2326:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2327:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getWithKeyword_6_0()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2336:1: rule__TypedDataDescriptionRule__Group_6__1 : rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2 ;
    public final void rule__TypedDataDescriptionRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2340:1: ( rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2 )
            // InternalDataDescriptionLanguage.g:2341:2: rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2
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
    // InternalDataDescriptionLanguage.g:2348:1: rule__TypedDataDescriptionRule__Group_6__1__Impl : ( 'constraints' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2352:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2353:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2353:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2354:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsKeyword_6_1()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2363:1: rule__TypedDataDescriptionRule__Group_6__2 : rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3 ;
    public final void rule__TypedDataDescriptionRule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2367:1: ( rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3 )
            // InternalDataDescriptionLanguage.g:2368:2: rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3
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
    // InternalDataDescriptionLanguage.g:2375:1: rule__TypedDataDescriptionRule__Group_6__2__Impl : ( ':' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2379:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2380:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2380:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2381:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getColonKeyword_6_2()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2390:1: rule__TypedDataDescriptionRule__Group_6__3 : rule__TypedDataDescriptionRule__Group_6__3__Impl ;
    public final void rule__TypedDataDescriptionRule__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2394:1: ( rule__TypedDataDescriptionRule__Group_6__3__Impl )
            // InternalDataDescriptionLanguage.g:2395:2: rule__TypedDataDescriptionRule__Group_6__3__Impl
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
    // InternalDataDescriptionLanguage.g:2401:1: rule__TypedDataDescriptionRule__Group_6__3__Impl : ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2405:1: ( ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* ) )
            // InternalDataDescriptionLanguage.g:2406:1: ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2406:1: ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* )
            // InternalDataDescriptionLanguage.g:2407:2: ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsAssignment_6_3()); 
            }
            // InternalDataDescriptionLanguage.g:2408:2: ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=RULE_QUOTED_ID && LA24_0<=RULE_STRING)||LA24_0==12||(LA24_0>=27 && LA24_0<=28)||LA24_0==42||LA24_0==47||(LA24_0>=51 && LA24_0<=52)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2408:3: rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalDataDescriptionLanguage.g:2417:1: rule__UntypedDataDescriptionRule__Group__0 : rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1 ;
    public final void rule__UntypedDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2421:1: ( rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2422:2: rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2429:1: rule__UntypedDataDescriptionRule__Group__0__Impl : ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? ) ;
    public final void rule__UntypedDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2433:1: ( ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? ) )
            // InternalDataDescriptionLanguage.g:2434:1: ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? )
            {
            // InternalDataDescriptionLanguage.g:2434:1: ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? )
            // InternalDataDescriptionLanguage.g:2435:2: ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getScaleAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2436:2: ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=13 && LA25_0<=16)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2436:3: rule__UntypedDataDescriptionRule__ScaleAssignment_0
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
    // InternalDataDescriptionLanguage.g:2444:1: rule__UntypedDataDescriptionRule__Group__1 : rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2 ;
    public final void rule__UntypedDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2448:1: ( rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2449:2: rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2
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
    // InternalDataDescriptionLanguage.g:2456:1: rule__UntypedDataDescriptionRule__Group__1__Impl : ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) ) ;
    public final void rule__UntypedDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2460:1: ( ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:2461:1: ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:2461:1: ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:2462:2: ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getRepresentationAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:2463:2: ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 )
            // InternalDataDescriptionLanguage.g:2463:3: rule__UntypedDataDescriptionRule__RepresentationAssignment_1
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
    // InternalDataDescriptionLanguage.g:2471:1: rule__UntypedDataDescriptionRule__Group__2 : rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3 ;
    public final void rule__UntypedDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2475:1: ( rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2476:2: rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3
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
    // InternalDataDescriptionLanguage.g:2483:1: rule__UntypedDataDescriptionRule__Group__2__Impl : ( 'data' ) ;
    public final void rule__UntypedDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2487:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:2488:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:2488:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:2489:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getDataKeyword_2()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2498:1: rule__UntypedDataDescriptionRule__Group__3 : rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4 ;
    public final void rule__UntypedDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2502:1: ( rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2503:2: rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4
            {
            pushFollow(FOLLOW_21);
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
    // InternalDataDescriptionLanguage.g:2510:1: rule__UntypedDataDescriptionRule__Group__3__Impl : ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) ) ;
    public final void rule__UntypedDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2514:1: ( ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) ) )
            // InternalDataDescriptionLanguage.g:2515:1: ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) )
            {
            // InternalDataDescriptionLanguage.g:2515:1: ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) )
            // InternalDataDescriptionLanguage.g:2516:2: ( rule__UntypedDataDescriptionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDataDescriptionLanguage.g:2517:2: ( rule__UntypedDataDescriptionRule__NameAssignment_3 )
            // InternalDataDescriptionLanguage.g:2517:3: rule__UntypedDataDescriptionRule__NameAssignment_3
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
    // InternalDataDescriptionLanguage.g:2525:1: rule__UntypedDataDescriptionRule__Group__4 : rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5 ;
    public final void rule__UntypedDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2529:1: ( rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2530:2: rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5
            {
            pushFollow(FOLLOW_21);
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
    // InternalDataDescriptionLanguage.g:2537:1: rule__UntypedDataDescriptionRule__Group__4__Impl : ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? ) ;
    public final void rule__UntypedDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2541:1: ( ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:2542:1: ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2542:1: ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:2543:2: ( rule__UntypedDataDescriptionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:2544:2: ( rule__UntypedDataDescriptionRule__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==40) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2544:3: rule__UntypedDataDescriptionRule__Group_4__0
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
    // InternalDataDescriptionLanguage.g:2552:1: rule__UntypedDataDescriptionRule__Group__5 : rule__UntypedDataDescriptionRule__Group__5__Impl ;
    public final void rule__UntypedDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2556:1: ( rule__UntypedDataDescriptionRule__Group__5__Impl )
            // InternalDataDescriptionLanguage.g:2557:2: rule__UntypedDataDescriptionRule__Group__5__Impl
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
    // InternalDataDescriptionLanguage.g:2563:1: rule__UntypedDataDescriptionRule__Group__5__Impl : ( ';' ) ;
    public final void rule__UntypedDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2567:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2568:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2568:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2569:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2579:1: rule__UntypedDataDescriptionRule__Group_4__0 : rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2583:1: ( rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:2584:2: rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1
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
    // InternalDataDescriptionLanguage.g:2591:1: rule__UntypedDataDescriptionRule__Group_4__0__Impl : ( 'with' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2595:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2596:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2596:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2597:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getWithKeyword_4_0()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2606:1: rule__UntypedDataDescriptionRule__Group_4__1 : rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2610:1: ( rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:2611:2: rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2
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
    // InternalDataDescriptionLanguage.g:2618:1: rule__UntypedDataDescriptionRule__Group_4__1__Impl : ( 'constraints' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2622:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2623:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2623:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2624:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsKeyword_4_1()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2633:1: rule__UntypedDataDescriptionRule__Group_4__2 : rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2637:1: ( rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3 )
            // InternalDataDescriptionLanguage.g:2638:2: rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3
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
    // InternalDataDescriptionLanguage.g:2645:1: rule__UntypedDataDescriptionRule__Group_4__2__Impl : ( ':' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2649:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2650:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2650:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2651:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getColonKeyword_4_2()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2660:1: rule__UntypedDataDescriptionRule__Group_4__3 : rule__UntypedDataDescriptionRule__Group_4__3__Impl ;
    public final void rule__UntypedDataDescriptionRule__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2664:1: ( rule__UntypedDataDescriptionRule__Group_4__3__Impl )
            // InternalDataDescriptionLanguage.g:2665:2: rule__UntypedDataDescriptionRule__Group_4__3__Impl
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
    // InternalDataDescriptionLanguage.g:2671:1: rule__UntypedDataDescriptionRule__Group_4__3__Impl : ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2675:1: ( ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* ) )
            // InternalDataDescriptionLanguage.g:2676:1: ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2676:1: ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* )
            // InternalDataDescriptionLanguage.g:2677:2: ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsAssignment_4_3()); 
            }
            // InternalDataDescriptionLanguage.g:2678:2: ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=RULE_QUOTED_ID && LA27_0<=RULE_STRING)||LA27_0==12||(LA27_0>=27 && LA27_0<=28)||LA27_0==42||LA27_0==47||(LA27_0>=51 && LA27_0<=52)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2678:3: rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalDataDescriptionLanguage.g:2687:1: rule__StatementRule__Group__0 : rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 ;
    public final void rule__StatementRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2691:1: ( rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2692:2: rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2699:1: rule__StatementRule__Group__0__Impl : ( ruleExpressionRule ) ;
    public final void rule__StatementRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2703:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:2704:1: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:2704:1: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:2705:2: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:2714:1: rule__StatementRule__Group__1 : rule__StatementRule__Group__1__Impl ;
    public final void rule__StatementRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2718:1: ( rule__StatementRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:2719:2: rule__StatementRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:2725:1: rule__StatementRule__Group__1__Impl : ( ';' ) ;
    public final void rule__StatementRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2729:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2730:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2730:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2731:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRuleAccess().getSemicolonKeyword_1()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2741:1: rule__SelfReferenceRule__Group__0 : rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1 ;
    public final void rule__SelfReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2745:1: ( rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2746:2: rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2753:1: rule__SelfReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2757:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:2758:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:2758:1: ( () )
            // InternalDataDescriptionLanguage.g:2759:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:2760:2: ()
            // InternalDataDescriptionLanguage.g:2760:3: 
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
    // InternalDataDescriptionLanguage.g:2768:1: rule__SelfReferenceRule__Group__1 : rule__SelfReferenceRule__Group__1__Impl ;
    public final void rule__SelfReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2772:1: ( rule__SelfReferenceRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:2773:2: rule__SelfReferenceRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:2779:1: rule__SelfReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__SelfReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2783:1: ( ( 'value' ) )
            // InternalDataDescriptionLanguage.g:2784:1: ( 'value' )
            {
            // InternalDataDescriptionLanguage.g:2784:1: ( 'value' )
            // InternalDataDescriptionLanguage.g:2785:2: 'value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1()); 
            }
            match(input,42,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2795:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2799:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2800:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalDataDescriptionLanguage.g:2807:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2811:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:2812:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:2812:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:2813:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2814:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:2814:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:2822:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2826:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:2827:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:2833:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2837:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:2838:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:2838:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:2839:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:2840:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==43) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2840:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalDataDescriptionLanguage.g:2849:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2853:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:2854:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:2861:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2865:1: ( ( 'OR' ) )
            // InternalDataDescriptionLanguage.g:2866:1: ( 'OR' )
            {
            // InternalDataDescriptionLanguage.g:2866:1: ( 'OR' )
            // InternalDataDescriptionLanguage.g:2867:2: 'OR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2876:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2880:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:2881:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:2887:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2891:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:2892:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:2892:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:2893:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:2894:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:2894:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:2903:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2907:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2908:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalDataDescriptionLanguage.g:2915:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2919:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:2920:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:2920:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:2921:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2922:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:2922:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:2930:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2934:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:2935:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:2941:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2945:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:2946:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:2946:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:2947:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:2948:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==44) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2948:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalDataDescriptionLanguage.g:2957:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2961:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:2962:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:2969:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2973:1: ( ( 'XOR' ) )
            // InternalDataDescriptionLanguage.g:2974:1: ( 'XOR' )
            {
            // InternalDataDescriptionLanguage.g:2974:1: ( 'XOR' )
            // InternalDataDescriptionLanguage.g:2975:2: 'XOR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2984:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2988:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:2989:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:2995:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2999:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3000:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3000:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3001:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3002:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3002:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3011:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3015:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3016:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalDataDescriptionLanguage.g:3023:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3027:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3028:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3028:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3029:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3030:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:3030:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:3038:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3042:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3043:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3049:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3053:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3054:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3054:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3055:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3056:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==45) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3056:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalDataDescriptionLanguage.g:3065:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3069:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3070:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3077:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3081:1: ( ( 'AND' ) )
            // InternalDataDescriptionLanguage.g:3082:1: ( 'AND' )
            {
            // InternalDataDescriptionLanguage.g:3082:1: ( 'AND' )
            // InternalDataDescriptionLanguage.g:3083:2: 'AND'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3092:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3096:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3097:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3103:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3107:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3108:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3108:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3109:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3110:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3110:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3119:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3123:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3124:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3131:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3135:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalDataDescriptionLanguage.g:3136:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalDataDescriptionLanguage.g:3136:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalDataDescriptionLanguage.g:3137:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3138:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==51) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3138:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalDataDescriptionLanguage.g:3146:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3150:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3151:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3157:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3161:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3162:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3162:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3163:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3164:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalDataDescriptionLanguage.g:3164:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalDataDescriptionLanguage.g:3173:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3177:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3178:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDataDescriptionLanguage.g:3185:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3189:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3190:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3190:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3191:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3192:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3192:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3200:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3204:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3205:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3211:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3215:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalDataDescriptionLanguage.g:3216:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalDataDescriptionLanguage.g:3216:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalDataDescriptionLanguage.g:3217:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3218:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=21 && LA32_0<=26)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3218:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalDataDescriptionLanguage.g:3227:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3231:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3232:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3239:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3243:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3244:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3244:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3245:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3246:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalDataDescriptionLanguage.g:3246:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalDataDescriptionLanguage.g:3254:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3258:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3259:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3265:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3269:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3270:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3270:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3271:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3272:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:3272:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:3281:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3285:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3286:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalDataDescriptionLanguage.g:3293:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3297:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3298:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3298:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3299:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3300:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3300:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3308:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3312:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3313:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3319:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3323:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3324:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3324:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3325:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3326:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=27 && LA33_0<=28)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3326:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalDataDescriptionLanguage.g:3335:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3339:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3340:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3347:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3351:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDataDescriptionLanguage.g:3352:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3352:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDataDescriptionLanguage.g:3353:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:3354:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalDataDescriptionLanguage.g:3354:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalDataDescriptionLanguage.g:3362:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3366:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3367:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3373:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3377:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3378:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3378:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3379:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3380:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3380:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3389:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3393:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3394:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalDataDescriptionLanguage.g:3401:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3405:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3406:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3406:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3407:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3408:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3408:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3416:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3420:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3421:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3427:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3431:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3432:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3432:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3433:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3434:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=29 && LA34_0<=31)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3434:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalDataDescriptionLanguage.g:3443:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3447:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3448:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3455:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3459:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDataDescriptionLanguage.g:3460:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3460:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDataDescriptionLanguage.g:3461:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:3462:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalDataDescriptionLanguage.g:3462:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalDataDescriptionLanguage.g:3470:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3474:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3475:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3481:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3485:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3486:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3486:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3487:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3488:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3488:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3497:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3501:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3502:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalDataDescriptionLanguage.g:3509:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3513:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3514:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3514:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3515:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3516:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3516:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3524:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3528:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3529:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3535:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3539:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalDataDescriptionLanguage.g:3540:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalDataDescriptionLanguage.g:3540:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalDataDescriptionLanguage.g:3541:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3542:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==46) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3542:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalDataDescriptionLanguage.g:3551:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3555:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3556:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3563:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3567:1: ( ( '^' ) )
            // InternalDataDescriptionLanguage.g:3568:1: ( '^' )
            {
            // InternalDataDescriptionLanguage.g:3568:1: ( '^' )
            // InternalDataDescriptionLanguage.g:3569:2: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            }
            match(input,46,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3578:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3582:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3583:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3589:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3593:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3594:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3594:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3595:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3596:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3596:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3605:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3609:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3610:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3617:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3621:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:3622:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:3622:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:3623:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3624:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=27 && LA36_0<=28)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3624:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalDataDescriptionLanguage.g:3632:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3636:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3637:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3643:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3647:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3648:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3648:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3649:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3650:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:3650:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:3659:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3663:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3664:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3671:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3675:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:3676:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:3676:1: ( '(' )
            // InternalDataDescriptionLanguage.g:3677:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3686:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3690:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalDataDescriptionLanguage.g:3691:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_35);
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
    // InternalDataDescriptionLanguage.g:3698:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3702:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3703:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3703:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3704:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3705:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:3705:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:3713:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3717:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:3718:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalDataDescriptionLanguage.g:3724:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3728:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:3729:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:3729:1: ( ')' )
            // InternalDataDescriptionLanguage.g:3730:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3740:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3744:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3745:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalDataDescriptionLanguage.g:3752:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3756:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3757:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3757:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3758:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3759:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalDataDescriptionLanguage.g:3759:3: rule__CallRule__FunctionAssignment_0
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
    // InternalDataDescriptionLanguage.g:3767:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3771:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalDataDescriptionLanguage.g:3772:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_37);
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
    // InternalDataDescriptionLanguage.g:3779:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3783:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:3784:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:3784:1: ( '(' )
            // InternalDataDescriptionLanguage.g:3785:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3794:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3798:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalDataDescriptionLanguage.g:3799:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_37);
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
    // InternalDataDescriptionLanguage.g:3806:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3810:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalDataDescriptionLanguage.g:3811:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalDataDescriptionLanguage.g:3811:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalDataDescriptionLanguage.g:3812:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalDataDescriptionLanguage.g:3813:2: ( rule__CallRule__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_QUOTED_ID && LA37_0<=RULE_STRING)||LA37_0==12||(LA37_0>=27 && LA37_0<=28)||LA37_0==42||LA37_0==47||(LA37_0>=51 && LA37_0<=52)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3813:3: rule__CallRule__Group_2__0
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
    // InternalDataDescriptionLanguage.g:3821:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3825:1: ( rule__CallRule__Group__3__Impl )
            // InternalDataDescriptionLanguage.g:3826:2: rule__CallRule__Group__3__Impl
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
    // InternalDataDescriptionLanguage.g:3832:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3836:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:3837:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:3837:1: ( ')' )
            // InternalDataDescriptionLanguage.g:3838:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3848:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3852:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalDataDescriptionLanguage.g:3853:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalDataDescriptionLanguage.g:3860:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3864:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalDataDescriptionLanguage.g:3865:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3865:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalDataDescriptionLanguage.g:3866:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalDataDescriptionLanguage.g:3867:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalDataDescriptionLanguage.g:3867:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalDataDescriptionLanguage.g:3875:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3879:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalDataDescriptionLanguage.g:3880:2: rule__CallRule__Group_2__1__Impl
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
    // InternalDataDescriptionLanguage.g:3886:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3890:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3891:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3891:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalDataDescriptionLanguage.g:3892:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalDataDescriptionLanguage.g:3893:2: ( rule__CallRule__Group_2_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==49) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3893:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_39);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
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
    // InternalDataDescriptionLanguage.g:3902:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3906:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalDataDescriptionLanguage.g:3907:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
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
    // InternalDataDescriptionLanguage.g:3914:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3918:1: ( ( ',' ) )
            // InternalDataDescriptionLanguage.g:3919:1: ( ',' )
            {
            // InternalDataDescriptionLanguage.g:3919:1: ( ',' )
            // InternalDataDescriptionLanguage.g:3920:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:3929:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3933:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3934:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3940:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3944:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3945:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3945:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalDataDescriptionLanguage.g:3946:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3947:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalDataDescriptionLanguage.g:3947:3: rule__CallRule__ParametersAssignment_2_1_1
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


    // $ANTLR start "rule__BooleanLiteralRule__Group__0"
    // InternalDataDescriptionLanguage.g:3956:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3960:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3961:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3968:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3972:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:3973:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:3973:1: ( () )
            // InternalDataDescriptionLanguage.g:3974:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:3975:2: ()
            // InternalDataDescriptionLanguage.g:3975:3: 
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
    // InternalDataDescriptionLanguage.g:3983:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3987:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3988:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3994:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3998:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalDataDescriptionLanguage.g:3999:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3999:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalDataDescriptionLanguage.g:4000:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalDataDescriptionLanguage.g:4001:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalDataDescriptionLanguage.g:4001:3: rule__BooleanLiteralRule__Alternatives_1
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
    // InternalDataDescriptionLanguage.g:4010:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4014:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // InternalDataDescriptionLanguage.g:4015:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
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
    // InternalDataDescriptionLanguage.g:4022:1: rule__DOUBLE__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4026:1: ( ( RULE_INT ) )
            // InternalDataDescriptionLanguage.g:4027:1: ( RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:4027:1: ( RULE_INT )
            // InternalDataDescriptionLanguage.g:4028:2: RULE_INT
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
    // InternalDataDescriptionLanguage.g:4037:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4041:1: ( rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 )
            // InternalDataDescriptionLanguage.g:4042:2: rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2
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
    // InternalDataDescriptionLanguage.g:4049:1: rule__DOUBLE__Group__1__Impl : ( '.' ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4053:1: ( ( '.' ) )
            // InternalDataDescriptionLanguage.g:4054:1: ( '.' )
            {
            // InternalDataDescriptionLanguage.g:4054:1: ( '.' )
            // InternalDataDescriptionLanguage.g:4055:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4064:1: rule__DOUBLE__Group__2 : rule__DOUBLE__Group__2__Impl ;
    public final void rule__DOUBLE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4068:1: ( rule__DOUBLE__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:4069:2: rule__DOUBLE__Group__2__Impl
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
    // InternalDataDescriptionLanguage.g:4075:1: rule__DOUBLE__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4079:1: ( ( RULE_INT ) )
            // InternalDataDescriptionLanguage.g:4080:1: ( RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:4080:1: ( RULE_INT )
            // InternalDataDescriptionLanguage.g:4081:2: RULE_INT
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
    // InternalDataDescriptionLanguage.g:4091:1: rule__DataDescriptionModelRule__UsesAssignment_1 : ( ruleUseRule ) ;
    public final void rule__DataDescriptionModelRule__UsesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4095:1: ( ( ruleUseRule ) )
            // InternalDataDescriptionLanguage.g:4096:2: ( ruleUseRule )
            {
            // InternalDataDescriptionLanguage.g:4096:2: ( ruleUseRule )
            // InternalDataDescriptionLanguage.g:4097:3: ruleUseRule
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
    // InternalDataDescriptionLanguage.g:4106:1: rule__DataDescriptionModelRule__TypesAssignment_2_2 : ( ruleDataTypeRule ) ;
    public final void rule__DataDescriptionModelRule__TypesAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4110:1: ( ( ruleDataTypeRule ) )
            // InternalDataDescriptionLanguage.g:4111:2: ( ruleDataTypeRule )
            {
            // InternalDataDescriptionLanguage.g:4111:2: ( ruleDataTypeRule )
            // InternalDataDescriptionLanguage.g:4112:3: ruleDataTypeRule
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
    // InternalDataDescriptionLanguage.g:4121:1: rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 : ( ruleDataDescriptionRule ) ;
    public final void rule__DataDescriptionModelRule__DescriptionsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4125:1: ( ( ruleDataDescriptionRule ) )
            // InternalDataDescriptionLanguage.g:4126:2: ( ruleDataDescriptionRule )
            {
            // InternalDataDescriptionLanguage.g:4126:2: ( ruleDataDescriptionRule )
            // InternalDataDescriptionLanguage.g:4127:3: ruleDataDescriptionRule
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
    // InternalDataDescriptionLanguage.g:4136:1: rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 : ( ruleStatementRule ) ;
    public final void rule__DataDescriptionModelRule__ConstraintsAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4140:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4141:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4141:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4142:3: ruleStatementRule
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
    // InternalDataDescriptionLanguage.g:4151:1: rule__UseRule__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__UseRule__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4155:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:4156:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:4156:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:4157:3: RULE_STRING
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
    // InternalDataDescriptionLanguage.g:4166:1: rule__DataTypeRule__ScaleAssignment_0 : ( ruleScaleType ) ;
    public final void rule__DataTypeRule__ScaleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4170:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:4171:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:4171:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:4172:3: ruleScaleType
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
    // InternalDataDescriptionLanguage.g:4181:1: rule__DataTypeRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__DataTypeRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4185:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4186:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:4186:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4187:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:4196:1: rule__DataTypeRule__DescriptionAssignment_3_2 : ( RULE_STRING ) ;
    public final void rule__DataTypeRule__DescriptionAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4200:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:4201:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:4201:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:4202:3: RULE_STRING
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
    // InternalDataDescriptionLanguage.g:4211:1: rule__DataTypeRule__ConstraintsAssignment_4_3 : ( ruleStatementRule ) ;
    public final void rule__DataTypeRule__ConstraintsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4215:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4216:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4216:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4217:3: ruleStatementRule
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
    // InternalDataDescriptionLanguage.g:4226:1: rule__TypedDataDescriptionRule__RepresentationAssignment_0 : ( ruleRepresentationType ) ;
    public final void rule__TypedDataDescriptionRule__RepresentationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4230:1: ( ( ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:4231:2: ( ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:4231:2: ( ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:4232:3: ruleRepresentationType
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
    // InternalDataDescriptionLanguage.g:4241:1: rule__TypedDataDescriptionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__TypedDataDescriptionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4245:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4246:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:4246:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4247:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:4256:1: rule__TypedDataDescriptionRule__TypeAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__TypedDataDescriptionRule__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4260:1: ( ( ( RULE_ID ) ) )
            // InternalDataDescriptionLanguage.g:4261:2: ( ( RULE_ID ) )
            {
            // InternalDataDescriptionLanguage.g:4261:2: ( ( RULE_ID ) )
            // InternalDataDescriptionLanguage.g:4262:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeCrossReference_5_0()); 
            }
            // InternalDataDescriptionLanguage.g:4263:3: ( RULE_ID )
            // InternalDataDescriptionLanguage.g:4264:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeIDTerminalRuleCall_5_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeIDTerminalRuleCall_5_0_1()); 
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
    // InternalDataDescriptionLanguage.g:4275:1: rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 : ( ruleStatementRule ) ;
    public final void rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4279:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4280:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4280:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4281:3: ruleStatementRule
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
    // InternalDataDescriptionLanguage.g:4290:1: rule__UntypedDataDescriptionRule__ScaleAssignment_0 : ( ruleScaleType ) ;
    public final void rule__UntypedDataDescriptionRule__ScaleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4294:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:4295:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:4295:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:4296:3: ruleScaleType
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
    // InternalDataDescriptionLanguage.g:4305:1: rule__UntypedDataDescriptionRule__RepresentationAssignment_1 : ( ruleRepresentationType ) ;
    public final void rule__UntypedDataDescriptionRule__RepresentationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4309:1: ( ( ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:4310:2: ( ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:4310:2: ( ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:4311:3: ruleRepresentationType
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
    // InternalDataDescriptionLanguage.g:4320:1: rule__UntypedDataDescriptionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__UntypedDataDescriptionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4324:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4325:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:4325:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4326:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:4335:1: rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 : ( ruleStatementRule ) ;
    public final void rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4339:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:4340:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:4340:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:4341:3: ruleStatementRule
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
    // InternalDataDescriptionLanguage.g:4350:1: rule__FunctionNameRule__DefinitionAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FunctionNameRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4354:1: ( ( ( RULE_ID ) ) )
            // InternalDataDescriptionLanguage.g:4355:2: ( ( RULE_ID ) )
            {
            // InternalDataDescriptionLanguage.g:4355:2: ( ( RULE_ID ) )
            // InternalDataDescriptionLanguage.g:4356:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
            }
            // InternalDataDescriptionLanguage.g:4357:3: ( RULE_ID )
            // InternalDataDescriptionLanguage.g:4358:4: RULE_ID
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
    // InternalDataDescriptionLanguage.g:4369:1: rule__DataReferenceRule__DefinitionAssignment : ( ( ruleStringOrId ) ) ;
    public final void rule__DataReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4373:1: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:4374:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:4374:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:4375:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_0()); 
            }
            // InternalDataDescriptionLanguage.g:4376:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:4377:4: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:4388:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4392:1: ( ( ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4393:2: ( ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4393:2: ( ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:4394:3: ruleXorExpressionRule
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
    // InternalDataDescriptionLanguage.g:4403:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4407:1: ( ( ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4408:2: ( ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4408:2: ( ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:4409:3: ruleXorExpressionRule
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
    // InternalDataDescriptionLanguage.g:4418:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4422:1: ( ( ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4423:2: ( ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4423:2: ( ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:4424:3: ruleAndExpressionRule
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
    // InternalDataDescriptionLanguage.g:4433:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4437:1: ( ( ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4438:2: ( ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4438:2: ( ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:4439:3: ruleAndExpressionRule
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
    // InternalDataDescriptionLanguage.g:4448:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4452:1: ( ( ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4453:2: ( ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4453:2: ( ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:4454:3: ruleNotExpressionRule
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
    // InternalDataDescriptionLanguage.g:4463:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4467:1: ( ( ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4468:2: ( ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4468:2: ( ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:4469:3: ruleNotExpressionRule
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
    // InternalDataDescriptionLanguage.g:4478:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4482:1: ( ( ( '!' ) ) )
            // InternalDataDescriptionLanguage.g:4483:2: ( ( '!' ) )
            {
            // InternalDataDescriptionLanguage.g:4483:2: ( ( '!' ) )
            // InternalDataDescriptionLanguage.g:4484:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:4485:3: ( '!' )
            // InternalDataDescriptionLanguage.g:4486:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4497:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4501:1: ( ( ruleComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4502:2: ( ruleComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4502:2: ( ruleComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:4503:3: ruleComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:4512:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4516:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4517:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4517:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:4518:3: ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:4527:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4531:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4532:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4532:2: ( rulePartialComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:4533:3: rulePartialComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:4542:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4546:1: ( ( ruleComparisonOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4547:2: ( ruleComparisonOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4547:2: ( ruleComparisonOperatorRule )
            // InternalDataDescriptionLanguage.g:4548:3: ruleComparisonOperatorRule
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
    // InternalDataDescriptionLanguage.g:4557:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4561:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4562:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4562:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:4563:3: ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:4572:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4576:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4577:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4577:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:4578:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDataDescriptionLanguage.g:4587:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4591:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4592:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4592:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDataDescriptionLanguage.g:4593:3: ruleAddOrSubtractOperatorRule
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
    // InternalDataDescriptionLanguage.g:4602:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4606:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4607:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4607:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:4608:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDataDescriptionLanguage.g:4617:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4621:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4622:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4622:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:4623:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:4632:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4636:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4637:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4637:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalDataDescriptionLanguage.g:4638:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalDataDescriptionLanguage.g:4647:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4651:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4652:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4652:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:4653:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:4662:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4666:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4667:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4667:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:4668:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:4677:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4681:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4682:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4682:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:4683:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:4692:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4696:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDataDescriptionLanguage.g:4697:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:4697:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDataDescriptionLanguage.g:4698:3: ruleAddOrSubtractOperatorRule
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
    // InternalDataDescriptionLanguage.g:4707:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleLiteralOrReferenceRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4711:1: ( ( ruleLiteralOrReferenceRule ) )
            // InternalDataDescriptionLanguage.g:4712:2: ( ruleLiteralOrReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:4712:2: ( ruleLiteralOrReferenceRule )
            // InternalDataDescriptionLanguage.g:4713:3: ruleLiteralOrReferenceRule
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
    // InternalDataDescriptionLanguage.g:4722:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4726:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4727:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4727:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:4728:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:4737:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4741:1: ( ( ruleFunctionNameRule ) )
            // InternalDataDescriptionLanguage.g:4742:2: ( ruleFunctionNameRule )
            {
            // InternalDataDescriptionLanguage.g:4742:2: ( ruleFunctionNameRule )
            // InternalDataDescriptionLanguage.g:4743:3: ruleFunctionNameRule
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
    // InternalDataDescriptionLanguage.g:4752:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4756:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4757:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4757:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:4758:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:4767:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4771:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4772:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4772:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:4773:3: ruleExpressionRule
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


    // $ANTLR start "rule__DoubleLiteralRule__ValueAssignment"
    // InternalDataDescriptionLanguage.g:4782:1: rule__DoubleLiteralRule__ValueAssignment : ( ruleDOUBLE ) ;
    public final void rule__DoubleLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4786:1: ( ( ruleDOUBLE ) )
            // InternalDataDescriptionLanguage.g:4787:2: ( ruleDOUBLE )
            {
            // InternalDataDescriptionLanguage.g:4787:2: ( ruleDOUBLE )
            // InternalDataDescriptionLanguage.g:4788:3: ruleDOUBLE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getValueDOUBLEParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDOUBLE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleLiteralRuleAccess().getValueDOUBLEParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleLiteralRule__ValueAssignment"


    // $ANTLR start "rule__IntegerLiteralRule__ValueAssignment"
    // InternalDataDescriptionLanguage.g:4797:1: rule__IntegerLiteralRule__ValueAssignment : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4801:1: ( ( RULE_INT ) )
            // InternalDataDescriptionLanguage.g:4802:2: ( RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:4802:2: ( RULE_INT )
            // InternalDataDescriptionLanguage.g:4803:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getValueINTTerminalRuleCall_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralRuleAccess().getValueINTTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteralRule__ValueAssignment"


    // $ANTLR start "rule__StringLiteralRule__ValueAssignment"
    // InternalDataDescriptionLanguage.g:4812:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4816:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:4817:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:4817:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:4818:3: RULE_STRING
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
    // InternalDataDescriptionLanguage.g:4827:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4831:1: ( ( ( 'true' ) ) )
            // InternalDataDescriptionLanguage.g:4832:2: ( ( 'true' ) )
            {
            // InternalDataDescriptionLanguage.g:4832:2: ( ( 'true' ) )
            // InternalDataDescriptionLanguage.g:4833:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:4834:3: ( 'true' )
            // InternalDataDescriptionLanguage.g:4835:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
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
    static final String dfa_2s = "\1\15\4\42\1\uffff\1\4\2\45\1\uffff";
    static final String dfa_3s = "\1\24\4\42\1\uffff\1\5\2\51\1\uffff";
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
            return "959:1: rule__DataDescriptionRule__Alternatives : ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000001D00000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000001FE000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000001FE002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00188400180010F0L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00188400180010F2L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000001A000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000012000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000007E00000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000007E00002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000000E0000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00198400180010F0L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00100000000010C0L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000040L});

}
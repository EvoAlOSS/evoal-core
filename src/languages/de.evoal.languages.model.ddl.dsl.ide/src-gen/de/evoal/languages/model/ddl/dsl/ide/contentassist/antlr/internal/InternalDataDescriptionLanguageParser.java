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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_STRING", "RULE_DOUBLE", "RULE_INT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'real'", "'integer'", "'boolean'", "'string'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'types'", "':'", "'data'", "'constraints'", "'use'", "';'", "'type'", "'description'", "'with'", "'of'", "'value'", "'OR'", "'XOR'", "'AND'", "'^'", "'('", "')'", "','", "'{'", "'}'", "'extends'", "':='", "'literal'", "'instance'", "'|'", "'expression'", "'int'", "'float'", "'void'", "'array'", "'.'", "'!'", "'true'", "'abstract'"
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
    public static final int T__88=88;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

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


    // $ANTLR start "entryRuleDataTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:105:1: entryRuleDataTypeDefinitionRule : ruleDataTypeDefinitionRule EOF ;
    public final void entryRuleDataTypeDefinitionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:106:1: ( ruleDataTypeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:107:1: ruleDataTypeDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDataTypeDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataTypeDefinitionRule"


    // $ANTLR start "ruleDataTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:114:1: ruleDataTypeDefinitionRule : ( ( rule__DataTypeDefinitionRule__Group__0 ) ) ;
    public final void ruleDataTypeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:118:2: ( ( ( rule__DataTypeDefinitionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:119:2: ( ( rule__DataTypeDefinitionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:119:2: ( ( rule__DataTypeDefinitionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:120:3: ( rule__DataTypeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:121:3: ( rule__DataTypeDefinitionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:121:4: rule__DataTypeDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataTypeDefinitionRule"


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


    // $ANTLR start "entryRuleValueReferenceRule"
    // InternalDataDescriptionLanguage.g:230:1: entryRuleValueReferenceRule : ruleValueReferenceRule EOF ;
    public final void entryRuleValueReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:231:1: ( ruleValueReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:232:1: ruleValueReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:239:1: ruleValueReferenceRule : ( ( rule__ValueReferenceRule__Alternatives ) ) ;
    public final void ruleValueReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:243:2: ( ( ( rule__ValueReferenceRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:244:2: ( ( rule__ValueReferenceRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:244:2: ( ( rule__ValueReferenceRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:245:3: ( rule__ValueReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueReferenceRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:246:3: ( rule__ValueReferenceRule__Alternatives )
            // InternalDataDescriptionLanguage.g:246:4: rule__ValueReferenceRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:255:1: entryRuleDataReferenceRule : ruleDataReferenceRule EOF ;
    public final void entryRuleDataReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:256:1: ( ruleDataReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:257:1: ruleDataReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:264:1: ruleDataReferenceRule : ( ( rule__DataReferenceRule__DefinitionAssignment ) ) ;
    public final void ruleDataReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:268:2: ( ( ( rule__DataReferenceRule__DefinitionAssignment ) ) )
            // InternalDataDescriptionLanguage.g:269:2: ( ( rule__DataReferenceRule__DefinitionAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:269:2: ( ( rule__DataReferenceRule__DefinitionAssignment ) )
            // InternalDataDescriptionLanguage.g:270:3: ( rule__DataReferenceRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:271:3: ( rule__DataReferenceRule__DefinitionAssignment )
            // InternalDataDescriptionLanguage.g:271:4: rule__DataReferenceRule__DefinitionAssignment
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
    // InternalDataDescriptionLanguage.g:280:1: entryRuleSelfReferenceRule : ruleSelfReferenceRule EOF ;
    public final void entryRuleSelfReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:281:1: ( ruleSelfReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:282:1: ruleSelfReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:289:1: ruleSelfReferenceRule : ( ( rule__SelfReferenceRule__Group__0 ) ) ;
    public final void ruleSelfReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:293:2: ( ( ( rule__SelfReferenceRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:294:2: ( ( rule__SelfReferenceRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:294:2: ( ( rule__SelfReferenceRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:295:3: ( rule__SelfReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:296:3: ( rule__SelfReferenceRule__Group__0 )
            // InternalDataDescriptionLanguage.g:296:4: rule__SelfReferenceRule__Group__0
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
    // InternalDataDescriptionLanguage.g:305:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:306:1: ( ruleExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:307:1: ruleExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:314:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:318:2: ( ( ruleOrExpressionRule ) )
            // InternalDataDescriptionLanguage.g:319:2: ( ruleOrExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:319:2: ( ruleOrExpressionRule )
            // InternalDataDescriptionLanguage.g:320:3: ruleOrExpressionRule
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
    // InternalDataDescriptionLanguage.g:330:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:331:1: ( ruleOrExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:332:1: ruleOrExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:339:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:343:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:344:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:344:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:345:3: ( rule__OrExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:346:3: ( rule__OrExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:346:4: rule__OrExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:355:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:356:1: ( ruleXorExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:357:1: ruleXorExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:364:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:368:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:369:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:369:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:370:3: ( rule__XorExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:371:3: ( rule__XorExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:371:4: rule__XorExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:380:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:381:1: ( ruleAndExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:382:1: ruleAndExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:389:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:393:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:394:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:394:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:395:3: ( rule__AndExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:396:3: ( rule__AndExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:396:4: rule__AndExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:405:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:406:1: ( ruleNotExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:407:1: ruleNotExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:414:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:418:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:419:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:419:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:420:3: ( rule__NotExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:421:3: ( rule__NotExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:421:4: rule__NotExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:430:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:431:1: ( ruleComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:432:1: ruleComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:439:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:443:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:444:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:444:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:445:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:446:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:446:4: rule__ComparisonExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:455:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:456:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:457:1: rulePartialComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:464:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:468:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:469:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:469:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:470:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:471:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:471:4: rule__PartialComparisonExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:480:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:481:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:482:1: ruleAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:489:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:493:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:494:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:494:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:495:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:496:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:496:4: rule__AddOrSubtractExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:505:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:506:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:507:1: ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:514:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:518:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:519:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:519:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:520:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:521:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:521:4: rule__MultiplyDivideModuloExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:530:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:531:1: ( rulePowerOfExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:532:1: rulePowerOfExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:539:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:543:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:544:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:544:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:545:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:546:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:546:4: rule__PowerOfExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:555:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:556:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:557:1: ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:564:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:568:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:569:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:569:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:570:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:571:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:571:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:580:1: entryRuleLiteralOrReferenceRule : ruleLiteralOrReferenceRule EOF ;
    public final void entryRuleLiteralOrReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:581:1: ( ruleLiteralOrReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:582:1: ruleLiteralOrReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:589:1: ruleLiteralOrReferenceRule : ( ( rule__LiteralOrReferenceRule__Alternatives ) ) ;
    public final void ruleLiteralOrReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:593:2: ( ( ( rule__LiteralOrReferenceRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:594:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:594:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:595:3: ( rule__LiteralOrReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralOrReferenceRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:596:3: ( rule__LiteralOrReferenceRule__Alternatives )
            // InternalDataDescriptionLanguage.g:596:4: rule__LiteralOrReferenceRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:605:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:606:1: ( ruleParanthesesRule EOF )
            // InternalDataDescriptionLanguage.g:607:1: ruleParanthesesRule EOF
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
    // InternalDataDescriptionLanguage.g:614:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:618:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:619:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:619:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:620:3: ( rule__ParanthesesRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:621:3: ( rule__ParanthesesRule__Group__0 )
            // InternalDataDescriptionLanguage.g:621:4: rule__ParanthesesRule__Group__0
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
    // InternalDataDescriptionLanguage.g:630:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:631:1: ( ruleCallRule EOF )
            // InternalDataDescriptionLanguage.g:632:1: ruleCallRule EOF
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
    // InternalDataDescriptionLanguage.g:639:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:643:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:644:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:644:2: ( ( rule__CallRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:645:3: ( rule__CallRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:646:3: ( rule__CallRule__Group__0 )
            // InternalDataDescriptionLanguage.g:646:4: rule__CallRule__Group__0
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
    // InternalDataDescriptionLanguage.g:655:1: entryRuleConstantReferenceRule : ruleConstantReferenceRule EOF ;
    public final void entryRuleConstantReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:656:1: ( ruleConstantReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:657:1: ruleConstantReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:664:1: ruleConstantReferenceRule : ( ( rule__ConstantReferenceRule__DefinitionAssignment ) ) ;
    public final void ruleConstantReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:668:2: ( ( ( rule__ConstantReferenceRule__DefinitionAssignment ) ) )
            // InternalDataDescriptionLanguage.g:669:2: ( ( rule__ConstantReferenceRule__DefinitionAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:669:2: ( ( rule__ConstantReferenceRule__DefinitionAssignment ) )
            // InternalDataDescriptionLanguage.g:670:3: ( rule__ConstantReferenceRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantReferenceRuleAccess().getDefinitionAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:671:3: ( rule__ConstantReferenceRule__DefinitionAssignment )
            // InternalDataDescriptionLanguage.g:671:4: rule__ConstantReferenceRule__DefinitionAssignment
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


    // $ANTLR start "entryRuleTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:830:1: entryRuleTypeDefinitionRule : ruleTypeDefinitionRule EOF ;
    public final void entryRuleTypeDefinitionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:831:1: ( ruleTypeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:832:1: ruleTypeDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypeDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

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
    // InternalDataDescriptionLanguage.g:839:1: ruleTypeDefinitionRule : ( ( rule__TypeDefinitionRule__Group__0 ) ) ;
    public final void ruleTypeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:843:2: ( ( ( rule__TypeDefinitionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:844:2: ( ( rule__TypeDefinitionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:844:2: ( ( rule__TypeDefinitionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:845:3: ( rule__TypeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:846:3: ( rule__TypeDefinitionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:846:4: rule__TypeDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:855:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:856:1: ( ruleAttributeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:857:1: ruleAttributeDefinitionRule EOF
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
    // InternalDataDescriptionLanguage.g:864:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:868:2: ( ( ( rule__AttributeDefinitionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:869:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:869:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:870:3: ( rule__AttributeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:871:3: ( rule__AttributeDefinitionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:871:4: rule__AttributeDefinitionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:880:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:881:1: ( ruleTypeRule EOF )
            // InternalDataDescriptionLanguage.g:882:1: ruleTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:889:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:893:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:894:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:894:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:895:3: ( rule__TypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:896:3: ( rule__TypeRule__Alternatives )
            // InternalDataDescriptionLanguage.g:896:4: rule__TypeRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:905:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:906:1: ( ruleLiteralTypeRule EOF )
            // InternalDataDescriptionLanguage.g:907:1: ruleLiteralTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:914:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:918:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:919:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:919:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:920:3: ( rule__LiteralTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:921:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:921:4: rule__LiteralTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:930:1: entryRuleInstanceTypeRule : ruleInstanceTypeRule EOF ;
    public final void entryRuleInstanceTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:931:1: ( ruleInstanceTypeRule EOF )
            // InternalDataDescriptionLanguage.g:932:1: ruleInstanceTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:939:1: ruleInstanceTypeRule : ( ( rule__InstanceTypeRule__Group__0 ) ) ;
    public final void ruleInstanceTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:943:2: ( ( ( rule__InstanceTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:944:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:944:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:945:3: ( rule__InstanceTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:946:3: ( rule__InstanceTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:946:4: rule__InstanceTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:955:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:956:1: ( ruleStringTypeRule EOF )
            // InternalDataDescriptionLanguage.g:957:1: ruleStringTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:964:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:968:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:969:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:969:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:970:3: ( rule__StringTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:971:3: ( rule__StringTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:971:4: rule__StringTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:980:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:981:1: ( ruleExpressionTypeRule EOF )
            // InternalDataDescriptionLanguage.g:982:1: ruleExpressionTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:989:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:993:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:994:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:994:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:995:3: ( rule__ExpressionTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:996:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:996:4: rule__ExpressionTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1005:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1006:1: ( ruleIntTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1007:1: ruleIntTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1014:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1018:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1019:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1019:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1020:3: ( rule__IntTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1021:3: ( rule__IntTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1021:4: rule__IntTypeRule__Group__0
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


    // $ANTLR start "entryRuleFloatTypeRule"
    // InternalDataDescriptionLanguage.g:1030:1: entryRuleFloatTypeRule : ruleFloatTypeRule EOF ;
    public final void entryRuleFloatTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1031:1: ( ruleFloatTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1032:1: ruleFloatTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFloatTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFloatTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFloatTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

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
    // InternalDataDescriptionLanguage.g:1039:1: ruleFloatTypeRule : ( ( rule__FloatTypeRule__Group__0 ) ) ;
    public final void ruleFloatTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1043:2: ( ( ( rule__FloatTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1044:2: ( ( rule__FloatTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1044:2: ( ( rule__FloatTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1045:3: ( rule__FloatTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFloatTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1046:3: ( rule__FloatTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1046:4: rule__FloatTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FloatTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFloatTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:1055:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1056:1: ( ruleBooleanTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1057:1: ruleBooleanTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1064:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1068:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1069:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1069:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1070:3: ( rule__BooleanTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1071:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1071:4: rule__BooleanTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1080:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1081:1: ( ruleVoidTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1082:1: ruleVoidTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1089:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1093:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1094:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1094:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1095:3: ( rule__VoidTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1096:3: ( rule__VoidTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1096:4: rule__VoidTypeRule__Group__0
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


    // $ANTLR start "entryRuleDataTypeRule"
    // InternalDataDescriptionLanguage.g:1105:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1106:1: ( ruleDataTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1107:1: ruleDataTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1114:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1118:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1119:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1119:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1120:3: ( rule__DataTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1121:3: ( rule__DataTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1121:4: rule__DataTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1130:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1131:1: ( ruleArrayTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1132:1: ruleArrayTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1139:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1143:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1144:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1144:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1145:3: ( rule__ArrayTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1146:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1146:4: rule__ArrayTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1155:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1156:1: ( ruleParameterRule EOF )
            // InternalDataDescriptionLanguage.g:1157:1: ruleParameterRule EOF
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
    // InternalDataDescriptionLanguage.g:1164:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1168:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1169:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1169:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1170:3: ( rule__ParameterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1171:3: ( rule__ParameterRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1171:4: rule__ParameterRule__Group__0
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


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalDataDescriptionLanguage.g:1180:1: entryRuleFunctionNameRule : ruleFunctionNameRule EOF ;
    public final void entryRuleFunctionNameRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1181:1: ( ruleFunctionNameRule EOF )
            // InternalDataDescriptionLanguage.g:1182:1: ruleFunctionNameRule EOF
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
    // InternalDataDescriptionLanguage.g:1189:1: ruleFunctionNameRule : ( ( rule__FunctionNameRule__DefinitionAssignment ) ) ;
    public final void ruleFunctionNameRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1193:2: ( ( ( rule__FunctionNameRule__DefinitionAssignment ) ) )
            // InternalDataDescriptionLanguage.g:1194:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:1194:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            // InternalDataDescriptionLanguage.g:1195:3: ( rule__FunctionNameRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleAccess().getDefinitionAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:1196:3: ( rule__FunctionNameRule__DefinitionAssignment )
            // InternalDataDescriptionLanguage.g:1196:4: rule__FunctionNameRule__DefinitionAssignment
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
    // InternalDataDescriptionLanguage.g:1205:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1206:1: ( ruleQualifiedName EOF )
            // InternalDataDescriptionLanguage.g:1207:1: ruleQualifiedName EOF
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
    // InternalDataDescriptionLanguage.g:1214:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1218:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1219:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1219:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1220:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1221:3: ( rule__QualifiedName__Group__0 )
            // InternalDataDescriptionLanguage.g:1221:4: rule__QualifiedName__Group__0
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
    // InternalDataDescriptionLanguage.g:1230:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1231:1: ( ruleStringOrId EOF )
            // InternalDataDescriptionLanguage.g:1232:1: ruleStringOrId EOF
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
    // InternalDataDescriptionLanguage.g:1239:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1243:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1244:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1244:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1245:3: ( rule__StringOrId__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1246:3: ( rule__StringOrId__Alternatives )
            // InternalDataDescriptionLanguage.g:1246:4: rule__StringOrId__Alternatives
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
    // InternalDataDescriptionLanguage.g:1255:1: ruleScaleType : ( ( rule__ScaleType__Alternatives ) ) ;
    public final void ruleScaleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1259:1: ( ( ( rule__ScaleType__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1260:2: ( ( rule__ScaleType__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1260:2: ( ( rule__ScaleType__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1261:3: ( rule__ScaleType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScaleTypeAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1262:3: ( rule__ScaleType__Alternatives )
            // InternalDataDescriptionLanguage.g:1262:4: rule__ScaleType__Alternatives
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
    // InternalDataDescriptionLanguage.g:1271:1: ruleRepresentationType : ( ( rule__RepresentationType__Alternatives ) ) ;
    public final void ruleRepresentationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1275:1: ( ( ( rule__RepresentationType__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1276:2: ( ( rule__RepresentationType__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1276:2: ( ( rule__RepresentationType__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1277:3: ( rule__RepresentationType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRepresentationTypeAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1278:3: ( rule__RepresentationType__Alternatives )
            // InternalDataDescriptionLanguage.g:1278:4: rule__RepresentationType__Alternatives
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
    // InternalDataDescriptionLanguage.g:1287:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1291:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1292:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1292:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1293:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1294:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:1294:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:1303:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1307:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1308:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1308:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1309:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1310:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:1310:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:1319:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1323:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1324:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1324:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1325:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1326:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:1326:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:1335:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1339:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1340:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1340:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1341:3: ( rule__FactorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1342:3: ( rule__FactorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:1342:4: rule__FactorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:1350:1: rule__DataDescriptionRule__Alternatives : ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) );
    public final void rule__DataDescriptionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1354:1: ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1355:2: ( ruleTypedDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1355:2: ( ruleTypedDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:1356:3: ruleTypedDataDescriptionRule
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
                    // InternalDataDescriptionLanguage.g:1361:2: ( ruleUntypedDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1361:2: ( ruleUntypedDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:1362:3: ruleUntypedDataDescriptionRule
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
    // InternalDataDescriptionLanguage.g:1371:1: rule__ValueReferenceRule__Alternatives : ( ( ruleConstantReferenceRule ) | ( ruleDataReferenceRule ) | ( ruleSelfReferenceRule ) );
    public final void rule__ValueReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1375:1: ( ( ruleConstantReferenceRule ) | ( ruleDataReferenceRule ) | ( ruleSelfReferenceRule ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
                {
                int LA2_1 = input.LA(2);

                if ( (synpred2_InternalDataDescriptionLanguage()) ) {
                    alt2=1;
                }
                else if ( (synpred3_InternalDataDescriptionLanguage()) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA2_2 = input.LA(2);

                if ( (synpred2_InternalDataDescriptionLanguage()) ) {
                    alt2=1;
                }
                else if ( (synpred3_InternalDataDescriptionLanguage()) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
                }
                break;
            case 65:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1376:2: ( ruleConstantReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1376:2: ( ruleConstantReferenceRule )
                    // InternalDataDescriptionLanguage.g:1377:3: ruleConstantReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueReferenceRuleAccess().getConstantReferenceRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleConstantReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueReferenceRuleAccess().getConstantReferenceRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1382:2: ( ruleDataReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1382:2: ( ruleDataReferenceRule )
                    // InternalDataDescriptionLanguage.g:1383:3: ruleDataReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueReferenceRuleAccess().getDataReferenceRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDataReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueReferenceRuleAccess().getDataReferenceRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1388:2: ( ruleSelfReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1388:2: ( ruleSelfReferenceRule )
                    // InternalDataDescriptionLanguage.g:1389:3: ruleSelfReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueReferenceRuleAccess().getSelfReferenceRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSelfReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueReferenceRuleAccess().getSelfReferenceRuleParserRuleCall_2()); 
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
    // InternalDataDescriptionLanguage.g:1398:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );
    public final void rule__LiteralOrReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1402:1: ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) )
            int alt3=4;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1403:2: ( ruleCallRule )
                    {
                    // InternalDataDescriptionLanguage.g:1403:2: ( ruleCallRule )
                    // InternalDataDescriptionLanguage.g:1404:3: ruleCallRule
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
                    // InternalDataDescriptionLanguage.g:1409:2: ( ruleLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1409:2: ( ruleLiteralRule )
                    // InternalDataDescriptionLanguage.g:1410:3: ruleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1415:2: ( ruleParanthesesRule )
                    {
                    // InternalDataDescriptionLanguage.g:1415:2: ( ruleParanthesesRule )
                    // InternalDataDescriptionLanguage.g:1416:3: ruleParanthesesRule
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
                    // InternalDataDescriptionLanguage.g:1421:2: ( ruleValueReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1421:2: ( ruleValueReferenceRule )
                    // InternalDataDescriptionLanguage.g:1422:3: ruleValueReferenceRule
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
    // InternalDataDescriptionLanguage.g:1431:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1435:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) )
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
            case 87:
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
                    // InternalDataDescriptionLanguage.g:1436:2: ( ruleNumberLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1436:2: ( ruleNumberLiteralRule )
                    // InternalDataDescriptionLanguage.g:1437:3: ruleNumberLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1442:2: ( ruleStringLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1442:2: ( ruleStringLiteralRule )
                    // InternalDataDescriptionLanguage.g:1443:3: ruleStringLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1448:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1448:2: ( ruleBooleanLiteralRule )
                    // InternalDataDescriptionLanguage.g:1449:3: ruleBooleanLiteralRule
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
    // InternalDataDescriptionLanguage.g:1458:1: rule__NumberLiteralRule__Alternatives : ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1462:1: ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) )
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
                    // InternalDataDescriptionLanguage.g:1463:2: ( ruleDoubleLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1463:2: ( ruleDoubleLiteralRule )
                    // InternalDataDescriptionLanguage.g:1464:3: ruleDoubleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1469:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1469:2: ( ruleIntegerLiteralRule )
                    // InternalDataDescriptionLanguage.g:1470:3: ruleIntegerLiteralRule
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
    // InternalDataDescriptionLanguage.g:1479:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1483:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==87) ) {
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
                    // InternalDataDescriptionLanguage.g:1484:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalDataDescriptionLanguage.g:1484:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalDataDescriptionLanguage.g:1485:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1486:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalDataDescriptionLanguage.g:1486:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalDataDescriptionLanguage.g:1490:2: ( 'false' )
                    {
                    // InternalDataDescriptionLanguage.g:1490:2: ( 'false' )
                    // InternalDataDescriptionLanguage.g:1491:3: 'false'
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
    // InternalDataDescriptionLanguage.g:1500:1: rule__TypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1504:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) )
            int alt7=10;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt7=1;
                }
                break;
            case 81:
                {
                alt7=2;
                }
                break;
            case 82:
                {
                alt7=3;
                }
                break;
            case 22:
                {
                alt7=4;
                }
                break;
            case 77:
                {
                alt7=5;
                }
                break;
            case 84:
                {
                alt7=6;
                }
                break;
            case 78:
                {
                alt7=7;
                }
                break;
            case 83:
                {
                alt7=8;
                }
                break;
            case 80:
                {
                alt7=9;
                }
                break;
            case 57:
                {
                alt7=10;
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
                    // InternalDataDescriptionLanguage.g:1505:2: ( ruleStringTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1505:2: ( ruleStringTypeRule )
                    // InternalDataDescriptionLanguage.g:1506:3: ruleStringTypeRule
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
                    // InternalDataDescriptionLanguage.g:1511:2: ( ruleIntTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1511:2: ( ruleIntTypeRule )
                    // InternalDataDescriptionLanguage.g:1512:3: ruleIntTypeRule
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
                    // InternalDataDescriptionLanguage.g:1517:2: ( ruleFloatTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1517:2: ( ruleFloatTypeRule )
                    // InternalDataDescriptionLanguage.g:1518:3: ruleFloatTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getFloatTypeRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleFloatTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getFloatTypeRuleParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:1523:2: ( ruleBooleanTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1523:2: ( ruleBooleanTypeRule )
                    // InternalDataDescriptionLanguage.g:1524:3: ruleBooleanTypeRule
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
                    // InternalDataDescriptionLanguage.g:1529:2: ( ruleLiteralTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1529:2: ( ruleLiteralTypeRule )
                    // InternalDataDescriptionLanguage.g:1530:3: ruleLiteralTypeRule
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
                    // InternalDataDescriptionLanguage.g:1535:2: ( ruleArrayTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1535:2: ( ruleArrayTypeRule )
                    // InternalDataDescriptionLanguage.g:1536:3: ruleArrayTypeRule
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
                    // InternalDataDescriptionLanguage.g:1541:2: ( ruleInstanceTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1541:2: ( ruleInstanceTypeRule )
                    // InternalDataDescriptionLanguage.g:1542:3: ruleInstanceTypeRule
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
                    // InternalDataDescriptionLanguage.g:1547:2: ( ruleVoidTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1547:2: ( ruleVoidTypeRule )
                    // InternalDataDescriptionLanguage.g:1548:3: ruleVoidTypeRule
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
                    // InternalDataDescriptionLanguage.g:1553:2: ( ruleExpressionTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1553:2: ( ruleExpressionTypeRule )
                    // InternalDataDescriptionLanguage.g:1554:3: ruleExpressionTypeRule
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
                    // InternalDataDescriptionLanguage.g:1559:2: ( ruleDataTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1559:2: ( ruleDataTypeRule )
                    // InternalDataDescriptionLanguage.g:1560:3: ruleDataTypeRule
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
    // InternalDataDescriptionLanguage.g:1569:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1573:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_QUOTED_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
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
                    // InternalDataDescriptionLanguage.g:1574:2: ( RULE_QUOTED_ID )
                    {
                    // InternalDataDescriptionLanguage.g:1574:2: ( RULE_QUOTED_ID )
                    // InternalDataDescriptionLanguage.g:1575:3: RULE_QUOTED_ID
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
                    // InternalDataDescriptionLanguage.g:1580:2: ( RULE_ID )
                    {
                    // InternalDataDescriptionLanguage.g:1580:2: ( RULE_ID )
                    // InternalDataDescriptionLanguage.g:1581:3: RULE_ID
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
    // InternalDataDescriptionLanguage.g:1590:1: rule__ScaleType__Alternatives : ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) );
    public final void rule__ScaleType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1594:1: ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt9=1;
                }
                break;
            case 17:
                {
                alt9=2;
                }
                break;
            case 18:
                {
                alt9=3;
                }
                break;
            case 19:
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
                    // InternalDataDescriptionLanguage.g:1595:2: ( ( 'nominal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1595:2: ( ( 'nominal' ) )
                    // InternalDataDescriptionLanguage.g:1596:3: ( 'nominal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1597:3: ( 'nominal' )
                    // InternalDataDescriptionLanguage.g:1597:4: 'nominal'
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
                    // InternalDataDescriptionLanguage.g:1601:2: ( ( 'ordinal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1601:2: ( ( 'ordinal' ) )
                    // InternalDataDescriptionLanguage.g:1602:3: ( 'ordinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1603:3: ( 'ordinal' )
                    // InternalDataDescriptionLanguage.g:1603:4: 'ordinal'
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
                    // InternalDataDescriptionLanguage.g:1607:2: ( ( 'cardinal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1607:2: ( ( 'cardinal' ) )
                    // InternalDataDescriptionLanguage.g:1608:3: ( 'cardinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1609:3: ( 'cardinal' )
                    // InternalDataDescriptionLanguage.g:1609:4: 'cardinal'
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
                    // InternalDataDescriptionLanguage.g:1613:2: ( ( 'quotient' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1613:2: ( ( 'quotient' ) )
                    // InternalDataDescriptionLanguage.g:1614:3: ( 'quotient' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getQuotientEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1615:3: ( 'quotient' )
                    // InternalDataDescriptionLanguage.g:1615:4: 'quotient'
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
    // InternalDataDescriptionLanguage.g:1623:1: rule__RepresentationType__Alternatives : ( ( ( 'real' ) ) | ( ( 'integer' ) ) | ( ( 'boolean' ) ) | ( ( 'string' ) ) );
    public final void rule__RepresentationType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1627:1: ( ( ( 'real' ) ) | ( ( 'integer' ) ) | ( ( 'boolean' ) ) | ( ( 'string' ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt10=1;
                }
                break;
            case 21:
                {
                alt10=2;
                }
                break;
            case 22:
                {
                alt10=3;
                }
                break;
            case 23:
                {
                alt10=4;
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
                    // InternalDataDescriptionLanguage.g:1628:2: ( ( 'real' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1628:2: ( ( 'real' ) )
                    // InternalDataDescriptionLanguage.g:1629:3: ( 'real' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1630:3: ( 'real' )
                    // InternalDataDescriptionLanguage.g:1630:4: 'real'
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
                    // InternalDataDescriptionLanguage.g:1634:2: ( ( 'integer' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1634:2: ( ( 'integer' ) )
                    // InternalDataDescriptionLanguage.g:1635:3: ( 'integer' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1636:3: ( 'integer' )
                    // InternalDataDescriptionLanguage.g:1636:4: 'integer'
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
                    // InternalDataDescriptionLanguage.g:1640:2: ( ( 'boolean' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1640:2: ( ( 'boolean' ) )
                    // InternalDataDescriptionLanguage.g:1641:3: ( 'boolean' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1642:3: ( 'boolean' )
                    // InternalDataDescriptionLanguage.g:1642:4: 'boolean'
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
                    // InternalDataDescriptionLanguage.g:1646:2: ( ( 'string' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1646:2: ( ( 'string' ) )
                    // InternalDataDescriptionLanguage.g:1647:3: ( 'string' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getStringEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1648:3: ( 'string' )
                    // InternalDataDescriptionLanguage.g:1648:4: 'string'
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
    // InternalDataDescriptionLanguage.g:1656:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1660:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt11=6;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt11=1;
                }
                break;
            case 25:
                {
                alt11=2;
                }
                break;
            case 26:
                {
                alt11=3;
                }
                break;
            case 27:
                {
                alt11=4;
                }
                break;
            case 28:
                {
                alt11=5;
                }
                break;
            case 29:
                {
                alt11=6;
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
                    // InternalDataDescriptionLanguage.g:1661:2: ( ( '>=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1661:2: ( ( '>=' ) )
                    // InternalDataDescriptionLanguage.g:1662:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1663:3: ( '>=' )
                    // InternalDataDescriptionLanguage.g:1663:4: '>='
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
                    // InternalDataDescriptionLanguage.g:1667:2: ( ( '>' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1667:2: ( ( '>' ) )
                    // InternalDataDescriptionLanguage.g:1668:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1669:3: ( '>' )
                    // InternalDataDescriptionLanguage.g:1669:4: '>'
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
                    // InternalDataDescriptionLanguage.g:1673:2: ( ( '=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1673:2: ( ( '=' ) )
                    // InternalDataDescriptionLanguage.g:1674:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1675:3: ( '=' )
                    // InternalDataDescriptionLanguage.g:1675:4: '='
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
                    // InternalDataDescriptionLanguage.g:1679:2: ( ( '!=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1679:2: ( ( '!=' ) )
                    // InternalDataDescriptionLanguage.g:1680:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1681:3: ( '!=' )
                    // InternalDataDescriptionLanguage.g:1681:4: '!='
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
                    // InternalDataDescriptionLanguage.g:1685:2: ( ( '<' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1685:2: ( ( '<' ) )
                    // InternalDataDescriptionLanguage.g:1686:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalDataDescriptionLanguage.g:1687:3: ( '<' )
                    // InternalDataDescriptionLanguage.g:1687:4: '<'
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
                    // InternalDataDescriptionLanguage.g:1691:2: ( ( '<=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1691:2: ( ( '<=' ) )
                    // InternalDataDescriptionLanguage.g:1692:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalDataDescriptionLanguage.g:1693:3: ( '<=' )
                    // InternalDataDescriptionLanguage.g:1693:4: '<='
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
    // InternalDataDescriptionLanguage.g:1701:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1705:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==30) ) {
                alt12=1;
            }
            else if ( (LA12_0==31) ) {
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
                    // InternalDataDescriptionLanguage.g:1706:2: ( ( '+' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1706:2: ( ( '+' ) )
                    // InternalDataDescriptionLanguage.g:1707:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1708:3: ( '+' )
                    // InternalDataDescriptionLanguage.g:1708:4: '+'
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
                    // InternalDataDescriptionLanguage.g:1712:2: ( ( '-' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1712:2: ( ( '-' ) )
                    // InternalDataDescriptionLanguage.g:1713:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1714:3: ( '-' )
                    // InternalDataDescriptionLanguage.g:1714:4: '-'
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
    // InternalDataDescriptionLanguage.g:1722:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1726:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt13=3;
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
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1727:2: ( ( '*' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1727:2: ( ( '*' ) )
                    // InternalDataDescriptionLanguage.g:1728:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1729:3: ( '*' )
                    // InternalDataDescriptionLanguage.g:1729:4: '*'
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
                    // InternalDataDescriptionLanguage.g:1733:2: ( ( '/' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1733:2: ( ( '/' ) )
                    // InternalDataDescriptionLanguage.g:1734:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1735:3: ( '/' )
                    // InternalDataDescriptionLanguage.g:1735:4: '/'
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
                    // InternalDataDescriptionLanguage.g:1739:2: ( ( '%' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1739:2: ( ( '%' ) )
                    // InternalDataDescriptionLanguage.g:1740:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1741:3: ( '%' )
                    // InternalDataDescriptionLanguage.g:1741:4: '%'
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
    // InternalDataDescriptionLanguage.g:1749:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1753:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt14=20;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt14=1;
                }
                break;
            case 36:
                {
                alt14=2;
                }
                break;
            case 37:
                {
                alt14=3;
                }
                break;
            case 38:
                {
                alt14=4;
                }
                break;
            case 39:
                {
                alt14=5;
                }
                break;
            case 40:
                {
                alt14=6;
                }
                break;
            case 41:
                {
                alt14=7;
                }
                break;
            case 42:
                {
                alt14=8;
                }
                break;
            case 43:
                {
                alt14=9;
                }
                break;
            case 44:
                {
                alt14=10;
                }
                break;
            case 45:
                {
                alt14=11;
                }
                break;
            case 46:
                {
                alt14=12;
                }
                break;
            case 47:
                {
                alt14=13;
                }
                break;
            case 48:
                {
                alt14=14;
                }
                break;
            case 49:
                {
                alt14=15;
                }
                break;
            case 50:
                {
                alt14=16;
                }
                break;
            case 51:
                {
                alt14=17;
                }
                break;
            case 52:
                {
                alt14=18;
                }
                break;
            case 53:
                {
                alt14=19;
                }
                break;
            case 54:
                {
                alt14=20;
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
                    // InternalDataDescriptionLanguage.g:1754:2: ( ( 'Y' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1754:2: ( ( 'Y' ) )
                    // InternalDataDescriptionLanguage.g:1755:3: ( 'Y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1756:3: ( 'Y' )
                    // InternalDataDescriptionLanguage.g:1756:4: 'Y'
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
                    // InternalDataDescriptionLanguage.g:1760:2: ( ( 'Z' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1760:2: ( ( 'Z' ) )
                    // InternalDataDescriptionLanguage.g:1761:3: ( 'Z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1762:3: ( 'Z' )
                    // InternalDataDescriptionLanguage.g:1762:4: 'Z'
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
                    // InternalDataDescriptionLanguage.g:1766:2: ( ( 'E' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1766:2: ( ( 'E' ) )
                    // InternalDataDescriptionLanguage.g:1767:3: ( 'E' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1768:3: ( 'E' )
                    // InternalDataDescriptionLanguage.g:1768:4: 'E'
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
                    // InternalDataDescriptionLanguage.g:1772:2: ( ( 'P' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1772:2: ( ( 'P' ) )
                    // InternalDataDescriptionLanguage.g:1773:3: ( 'P' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1774:3: ( 'P' )
                    // InternalDataDescriptionLanguage.g:1774:4: 'P'
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
                    // InternalDataDescriptionLanguage.g:1778:2: ( ( 'T' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1778:2: ( ( 'T' ) )
                    // InternalDataDescriptionLanguage.g:1779:3: ( 'T' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }
                    // InternalDataDescriptionLanguage.g:1780:3: ( 'T' )
                    // InternalDataDescriptionLanguage.g:1780:4: 'T'
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
                    // InternalDataDescriptionLanguage.g:1784:2: ( ( 'G' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1784:2: ( ( 'G' ) )
                    // InternalDataDescriptionLanguage.g:1785:3: ( 'G' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }
                    // InternalDataDescriptionLanguage.g:1786:3: ( 'G' )
                    // InternalDataDescriptionLanguage.g:1786:4: 'G'
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
                    // InternalDataDescriptionLanguage.g:1790:2: ( ( 'M' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1790:2: ( ( 'M' ) )
                    // InternalDataDescriptionLanguage.g:1791:3: ( 'M' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }
                    // InternalDataDescriptionLanguage.g:1792:3: ( 'M' )
                    // InternalDataDescriptionLanguage.g:1792:4: 'M'
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
                    // InternalDataDescriptionLanguage.g:1796:2: ( ( 'k' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1796:2: ( ( 'k' ) )
                    // InternalDataDescriptionLanguage.g:1797:3: ( 'k' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }
                    // InternalDataDescriptionLanguage.g:1798:3: ( 'k' )
                    // InternalDataDescriptionLanguage.g:1798:4: 'k'
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
                    // InternalDataDescriptionLanguage.g:1802:2: ( ( 'h' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1802:2: ( ( 'h' ) )
                    // InternalDataDescriptionLanguage.g:1803:3: ( 'h' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }
                    // InternalDataDescriptionLanguage.g:1804:3: ( 'h' )
                    // InternalDataDescriptionLanguage.g:1804:4: 'h'
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
                    // InternalDataDescriptionLanguage.g:1808:2: ( ( 'da' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1808:2: ( ( 'da' ) )
                    // InternalDataDescriptionLanguage.g:1809:3: ( 'da' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }
                    // InternalDataDescriptionLanguage.g:1810:3: ( 'da' )
                    // InternalDataDescriptionLanguage.g:1810:4: 'da'
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
                    // InternalDataDescriptionLanguage.g:1814:2: ( ( 'd' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1814:2: ( ( 'd' ) )
                    // InternalDataDescriptionLanguage.g:1815:3: ( 'd' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }
                    // InternalDataDescriptionLanguage.g:1816:3: ( 'd' )
                    // InternalDataDescriptionLanguage.g:1816:4: 'd'
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
                    // InternalDataDescriptionLanguage.g:1820:2: ( ( 'c' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1820:2: ( ( 'c' ) )
                    // InternalDataDescriptionLanguage.g:1821:3: ( 'c' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }
                    // InternalDataDescriptionLanguage.g:1822:3: ( 'c' )
                    // InternalDataDescriptionLanguage.g:1822:4: 'c'
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
                    // InternalDataDescriptionLanguage.g:1826:2: ( ( 'm' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1826:2: ( ( 'm' ) )
                    // InternalDataDescriptionLanguage.g:1827:3: ( 'm' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }
                    // InternalDataDescriptionLanguage.g:1828:3: ( 'm' )
                    // InternalDataDescriptionLanguage.g:1828:4: 'm'
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
                    // InternalDataDescriptionLanguage.g:1832:2: ( ( '\\u00B5' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1832:2: ( ( '\\u00B5' ) )
                    // InternalDataDescriptionLanguage.g:1833:3: ( '\\u00B5' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }
                    // InternalDataDescriptionLanguage.g:1834:3: ( '\\u00B5' )
                    // InternalDataDescriptionLanguage.g:1834:4: '\\u00B5'
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
                    // InternalDataDescriptionLanguage.g:1838:2: ( ( 'n' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1838:2: ( ( 'n' ) )
                    // InternalDataDescriptionLanguage.g:1839:3: ( 'n' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }
                    // InternalDataDescriptionLanguage.g:1840:3: ( 'n' )
                    // InternalDataDescriptionLanguage.g:1840:4: 'n'
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
                    // InternalDataDescriptionLanguage.g:1844:2: ( ( 'p' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1844:2: ( ( 'p' ) )
                    // InternalDataDescriptionLanguage.g:1845:3: ( 'p' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }
                    // InternalDataDescriptionLanguage.g:1846:3: ( 'p' )
                    // InternalDataDescriptionLanguage.g:1846:4: 'p'
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
                    // InternalDataDescriptionLanguage.g:1850:2: ( ( 'f' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1850:2: ( ( 'f' ) )
                    // InternalDataDescriptionLanguage.g:1851:3: ( 'f' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }
                    // InternalDataDescriptionLanguage.g:1852:3: ( 'f' )
                    // InternalDataDescriptionLanguage.g:1852:4: 'f'
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
                    // InternalDataDescriptionLanguage.g:1856:2: ( ( 'a' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1856:2: ( ( 'a' ) )
                    // InternalDataDescriptionLanguage.g:1857:3: ( 'a' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }
                    // InternalDataDescriptionLanguage.g:1858:3: ( 'a' )
                    // InternalDataDescriptionLanguage.g:1858:4: 'a'
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
                    // InternalDataDescriptionLanguage.g:1862:2: ( ( 'z' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1862:2: ( ( 'z' ) )
                    // InternalDataDescriptionLanguage.g:1863:3: ( 'z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }
                    // InternalDataDescriptionLanguage.g:1864:3: ( 'z' )
                    // InternalDataDescriptionLanguage.g:1864:4: 'z'
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
                    // InternalDataDescriptionLanguage.g:1868:2: ( ( 'y' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1868:2: ( ( 'y' ) )
                    // InternalDataDescriptionLanguage.g:1869:3: ( 'y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }
                    // InternalDataDescriptionLanguage.g:1870:3: ( 'y' )
                    // InternalDataDescriptionLanguage.g:1870:4: 'y'
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
    // InternalDataDescriptionLanguage.g:1878:1: rule__DataDescriptionModelRule__Group__0 : rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1 ;
    public final void rule__DataDescriptionModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1882:1: ( rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1 )
            // InternalDataDescriptionLanguage.g:1883:2: rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1
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
    // InternalDataDescriptionLanguage.g:1890:1: rule__DataDescriptionModelRule__Group__0__Impl : ( () ) ;
    public final void rule__DataDescriptionModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1894:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:1895:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:1895:1: ( () )
            // InternalDataDescriptionLanguage.g:1896:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDataDescriptionModelAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:1897:2: ()
            // InternalDataDescriptionLanguage.g:1897:3: 
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
    // InternalDataDescriptionLanguage.g:1905:1: rule__DataDescriptionModelRule__Group__1 : rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2 ;
    public final void rule__DataDescriptionModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1909:1: ( rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2 )
            // InternalDataDescriptionLanguage.g:1910:2: rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2
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
    // InternalDataDescriptionLanguage.g:1917:1: rule__DataDescriptionModelRule__Group__1__Impl : ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* ) ;
    public final void rule__DataDescriptionModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1921:1: ( ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* ) )
            // InternalDataDescriptionLanguage.g:1922:1: ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* )
            {
            // InternalDataDescriptionLanguage.g:1922:1: ( ( rule__DataDescriptionModelRule__UsesAssignment_1 )* )
            // InternalDataDescriptionLanguage.g:1923:2: ( rule__DataDescriptionModelRule__UsesAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getUsesAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:1924:2: ( rule__DataDescriptionModelRule__UsesAssignment_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==59) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1924:3: rule__DataDescriptionModelRule__UsesAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__DataDescriptionModelRule__UsesAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalDataDescriptionLanguage.g:1932:1: rule__DataDescriptionModelRule__Group__2 : rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3 ;
    public final void rule__DataDescriptionModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1936:1: ( rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3 )
            // InternalDataDescriptionLanguage.g:1937:2: rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3
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
    // InternalDataDescriptionLanguage.g:1944:1: rule__DataDescriptionModelRule__Group__2__Impl : ( ( rule__DataDescriptionModelRule__Group_2__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1948:1: ( ( ( rule__DataDescriptionModelRule__Group_2__0 )? ) )
            // InternalDataDescriptionLanguage.g:1949:1: ( ( rule__DataDescriptionModelRule__Group_2__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1949:1: ( ( rule__DataDescriptionModelRule__Group_2__0 )? )
            // InternalDataDescriptionLanguage.g:1950:2: ( rule__DataDescriptionModelRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_2()); 
            }
            // InternalDataDescriptionLanguage.g:1951:2: ( rule__DataDescriptionModelRule__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==55) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1951:3: rule__DataDescriptionModelRule__Group_2__0
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
    // InternalDataDescriptionLanguage.g:1959:1: rule__DataDescriptionModelRule__Group__3 : rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4 ;
    public final void rule__DataDescriptionModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1963:1: ( rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4 )
            // InternalDataDescriptionLanguage.g:1964:2: rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4
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
    // InternalDataDescriptionLanguage.g:1971:1: rule__DataDescriptionModelRule__Group__3__Impl : ( ( rule__DataDescriptionModelRule__Group_3__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1975:1: ( ( ( rule__DataDescriptionModelRule__Group_3__0 )? ) )
            // InternalDataDescriptionLanguage.g:1976:1: ( ( rule__DataDescriptionModelRule__Group_3__0 )? )
            {
            // InternalDataDescriptionLanguage.g:1976:1: ( ( rule__DataDescriptionModelRule__Group_3__0 )? )
            // InternalDataDescriptionLanguage.g:1977:2: ( rule__DataDescriptionModelRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:1978:2: ( rule__DataDescriptionModelRule__Group_3__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==57) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1978:3: rule__DataDescriptionModelRule__Group_3__0
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
    // InternalDataDescriptionLanguage.g:1986:1: rule__DataDescriptionModelRule__Group__4 : rule__DataDescriptionModelRule__Group__4__Impl ;
    public final void rule__DataDescriptionModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1990:1: ( rule__DataDescriptionModelRule__Group__4__Impl )
            // InternalDataDescriptionLanguage.g:1991:2: rule__DataDescriptionModelRule__Group__4__Impl
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
    // InternalDataDescriptionLanguage.g:1997:1: rule__DataDescriptionModelRule__Group__4__Impl : ( ( rule__DataDescriptionModelRule__Group_4__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2001:1: ( ( ( rule__DataDescriptionModelRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:2002:1: ( ( rule__DataDescriptionModelRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2002:1: ( ( rule__DataDescriptionModelRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:2003:2: ( rule__DataDescriptionModelRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:2004:2: ( rule__DataDescriptionModelRule__Group_4__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==58) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2004:3: rule__DataDescriptionModelRule__Group_4__0
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
    // InternalDataDescriptionLanguage.g:2013:1: rule__DataDescriptionModelRule__Group_2__0 : rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1 ;
    public final void rule__DataDescriptionModelRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2017:1: ( rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1 )
            // InternalDataDescriptionLanguage.g:2018:2: rule__DataDescriptionModelRule__Group_2__0__Impl rule__DataDescriptionModelRule__Group_2__1
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
    // InternalDataDescriptionLanguage.g:2025:1: rule__DataDescriptionModelRule__Group_2__0__Impl : ( 'types' ) ;
    public final void rule__DataDescriptionModelRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2029:1: ( ( 'types' ) )
            // InternalDataDescriptionLanguage.g:2030:1: ( 'types' )
            {
            // InternalDataDescriptionLanguage.g:2030:1: ( 'types' )
            // InternalDataDescriptionLanguage.g:2031:2: 'types'
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
    // InternalDataDescriptionLanguage.g:2040:1: rule__DataDescriptionModelRule__Group_2__1 : rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2 ;
    public final void rule__DataDescriptionModelRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2044:1: ( rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2 )
            // InternalDataDescriptionLanguage.g:2045:2: rule__DataDescriptionModelRule__Group_2__1__Impl rule__DataDescriptionModelRule__Group_2__2
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
    // InternalDataDescriptionLanguage.g:2052:1: rule__DataDescriptionModelRule__Group_2__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2056:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2057:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2057:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2058:2: ':'
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
    // InternalDataDescriptionLanguage.g:2067:1: rule__DataDescriptionModelRule__Group_2__2 : rule__DataDescriptionModelRule__Group_2__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2071:1: ( rule__DataDescriptionModelRule__Group_2__2__Impl )
            // InternalDataDescriptionLanguage.g:2072:2: rule__DataDescriptionModelRule__Group_2__2__Impl
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
    // InternalDataDescriptionLanguage.g:2078:1: rule__DataDescriptionModelRule__Group_2__2__Impl : ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2082:1: ( ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* ) )
            // InternalDataDescriptionLanguage.g:2083:1: ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* )
            {
            // InternalDataDescriptionLanguage.g:2083:1: ( ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )* )
            // InternalDataDescriptionLanguage.g:2084:2: ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesAssignment_2_2()); 
            }
            // InternalDataDescriptionLanguage.g:2085:2: ( rule__DataDescriptionModelRule__TypesAssignment_2_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=16 && LA19_0<=19)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2085:3: rule__DataDescriptionModelRule__TypesAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__DataDescriptionModelRule__TypesAssignment_2_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalDataDescriptionLanguage.g:2094:1: rule__DataDescriptionModelRule__Group_3__0 : rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1 ;
    public final void rule__DataDescriptionModelRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2098:1: ( rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:2099:2: rule__DataDescriptionModelRule__Group_3__0__Impl rule__DataDescriptionModelRule__Group_3__1
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
    // InternalDataDescriptionLanguage.g:2106:1: rule__DataDescriptionModelRule__Group_3__0__Impl : ( 'data' ) ;
    public final void rule__DataDescriptionModelRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2110:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:2111:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:2111:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:2112:2: 'data'
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
    // InternalDataDescriptionLanguage.g:2121:1: rule__DataDescriptionModelRule__Group_3__1 : rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2 ;
    public final void rule__DataDescriptionModelRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2125:1: ( rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2 )
            // InternalDataDescriptionLanguage.g:2126:2: rule__DataDescriptionModelRule__Group_3__1__Impl rule__DataDescriptionModelRule__Group_3__2
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
    // InternalDataDescriptionLanguage.g:2133:1: rule__DataDescriptionModelRule__Group_3__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2137:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2138:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2138:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2139:2: ':'
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
    // InternalDataDescriptionLanguage.g:2148:1: rule__DataDescriptionModelRule__Group_3__2 : rule__DataDescriptionModelRule__Group_3__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2152:1: ( rule__DataDescriptionModelRule__Group_3__2__Impl )
            // InternalDataDescriptionLanguage.g:2153:2: rule__DataDescriptionModelRule__Group_3__2__Impl
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
    // InternalDataDescriptionLanguage.g:2159:1: rule__DataDescriptionModelRule__Group_3__2__Impl : ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2163:1: ( ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* ) )
            // InternalDataDescriptionLanguage.g:2164:1: ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* )
            {
            // InternalDataDescriptionLanguage.g:2164:1: ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )* )
            // InternalDataDescriptionLanguage.g:2165:2: ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsAssignment_3_2()); 
            }
            // InternalDataDescriptionLanguage.g:2166:2: ( rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=16 && LA20_0<=23)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2166:3: rule__DataDescriptionModelRule__DescriptionsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataDescriptionModelRule__DescriptionsAssignment_3_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalDataDescriptionLanguage.g:2175:1: rule__DataDescriptionModelRule__Group_4__0 : rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1 ;
    public final void rule__DataDescriptionModelRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2179:1: ( rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:2180:2: rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1
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
    // InternalDataDescriptionLanguage.g:2187:1: rule__DataDescriptionModelRule__Group_4__0__Impl : ( 'constraints' ) ;
    public final void rule__DataDescriptionModelRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2191:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2192:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2192:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2193:2: 'constraints'
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
    // InternalDataDescriptionLanguage.g:2202:1: rule__DataDescriptionModelRule__Group_4__1 : rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2 ;
    public final void rule__DataDescriptionModelRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2206:1: ( rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:2207:2: rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2
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
    // InternalDataDescriptionLanguage.g:2214:1: rule__DataDescriptionModelRule__Group_4__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2218:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2219:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2219:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2220:2: ':'
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
    // InternalDataDescriptionLanguage.g:2229:1: rule__DataDescriptionModelRule__Group_4__2 : rule__DataDescriptionModelRule__Group_4__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2233:1: ( rule__DataDescriptionModelRule__Group_4__2__Impl )
            // InternalDataDescriptionLanguage.g:2234:2: rule__DataDescriptionModelRule__Group_4__2__Impl
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
    // InternalDataDescriptionLanguage.g:2240:1: rule__DataDescriptionModelRule__Group_4__2__Impl : ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2244:1: ( ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* ) )
            // InternalDataDescriptionLanguage.g:2245:1: ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* )
            {
            // InternalDataDescriptionLanguage.g:2245:1: ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )* )
            // InternalDataDescriptionLanguage.g:2246:2: ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsAssignment_4_2()); 
            }
            // InternalDataDescriptionLanguage.g:2247:2: ( rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=RULE_QUOTED_ID && LA21_0<=RULE_INT)||LA21_0==15||(LA21_0>=30 && LA21_0<=31)||LA21_0==65||LA21_0==70||(LA21_0>=86 && LA21_0<=87)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2247:3: rule__DataDescriptionModelRule__ConstraintsAssignment_4_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__DataDescriptionModelRule__ConstraintsAssignment_4_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalDataDescriptionLanguage.g:2256:1: rule__UseRule__Group__0 : rule__UseRule__Group__0__Impl rule__UseRule__Group__1 ;
    public final void rule__UseRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2260:1: ( rule__UseRule__Group__0__Impl rule__UseRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2261:2: rule__UseRule__Group__0__Impl rule__UseRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2268:1: rule__UseRule__Group__0__Impl : ( 'use' ) ;
    public final void rule__UseRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2272:1: ( ( 'use' ) )
            // InternalDataDescriptionLanguage.g:2273:1: ( 'use' )
            {
            // InternalDataDescriptionLanguage.g:2273:1: ( 'use' )
            // InternalDataDescriptionLanguage.g:2274:2: 'use'
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
    // InternalDataDescriptionLanguage.g:2283:1: rule__UseRule__Group__1 : rule__UseRule__Group__1__Impl rule__UseRule__Group__2 ;
    public final void rule__UseRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2287:1: ( rule__UseRule__Group__1__Impl rule__UseRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2288:2: rule__UseRule__Group__1__Impl rule__UseRule__Group__2
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
    // InternalDataDescriptionLanguage.g:2295:1: rule__UseRule__Group__1__Impl : ( ( rule__UseRule__ImportURIAssignment_1 ) ) ;
    public final void rule__UseRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2299:1: ( ( ( rule__UseRule__ImportURIAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:2300:1: ( ( rule__UseRule__ImportURIAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:2300:1: ( ( rule__UseRule__ImportURIAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:2301:2: ( rule__UseRule__ImportURIAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUseRuleAccess().getImportURIAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:2302:2: ( rule__UseRule__ImportURIAssignment_1 )
            // InternalDataDescriptionLanguage.g:2302:3: rule__UseRule__ImportURIAssignment_1
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
    // InternalDataDescriptionLanguage.g:2310:1: rule__UseRule__Group__2 : rule__UseRule__Group__2__Impl ;
    public final void rule__UseRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2314:1: ( rule__UseRule__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:2315:2: rule__UseRule__Group__2__Impl
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
    // InternalDataDescriptionLanguage.g:2321:1: rule__UseRule__Group__2__Impl : ( ';' ) ;
    public final void rule__UseRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2325:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2326:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2326:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2327:2: ';'
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


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__0"
    // InternalDataDescriptionLanguage.g:2337:1: rule__DataTypeDefinitionRule__Group__0 : rule__DataTypeDefinitionRule__Group__0__Impl rule__DataTypeDefinitionRule__Group__1 ;
    public final void rule__DataTypeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2341:1: ( rule__DataTypeDefinitionRule__Group__0__Impl rule__DataTypeDefinitionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2342:2: rule__DataTypeDefinitionRule__Group__0__Impl rule__DataTypeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__DataTypeDefinitionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__0"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:2349:1: rule__DataTypeDefinitionRule__Group__0__Impl : ( ( rule__DataTypeDefinitionRule__ScaleAssignment_0 ) ) ;
    public final void rule__DataTypeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2353:1: ( ( ( rule__DataTypeDefinitionRule__ScaleAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:2354:1: ( ( rule__DataTypeDefinitionRule__ScaleAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:2354:1: ( ( rule__DataTypeDefinitionRule__ScaleAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:2355:2: ( rule__DataTypeDefinitionRule__ScaleAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getScaleAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2356:2: ( rule__DataTypeDefinitionRule__ScaleAssignment_0 )
            // InternalDataDescriptionLanguage.g:2356:3: rule__DataTypeDefinitionRule__ScaleAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__ScaleAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getScaleAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__1"
    // InternalDataDescriptionLanguage.g:2364:1: rule__DataTypeDefinitionRule__Group__1 : rule__DataTypeDefinitionRule__Group__1__Impl rule__DataTypeDefinitionRule__Group__2 ;
    public final void rule__DataTypeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2368:1: ( rule__DataTypeDefinitionRule__Group__1__Impl rule__DataTypeDefinitionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2369:2: rule__DataTypeDefinitionRule__Group__1__Impl rule__DataTypeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__DataTypeDefinitionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__1"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:2376:1: rule__DataTypeDefinitionRule__Group__1__Impl : ( 'type' ) ;
    public final void rule__DataTypeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2380:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:2381:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:2381:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:2382:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getTypeKeyword_1()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getTypeKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__2"
    // InternalDataDescriptionLanguage.g:2391:1: rule__DataTypeDefinitionRule__Group__2 : rule__DataTypeDefinitionRule__Group__2__Impl rule__DataTypeDefinitionRule__Group__3 ;
    public final void rule__DataTypeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2395:1: ( rule__DataTypeDefinitionRule__Group__2__Impl rule__DataTypeDefinitionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2396:2: rule__DataTypeDefinitionRule__Group__2__Impl rule__DataTypeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__DataTypeDefinitionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__2"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:2403:1: rule__DataTypeDefinitionRule__Group__2__Impl : ( ( rule__DataTypeDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__DataTypeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2407:1: ( ( ( rule__DataTypeDefinitionRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:2408:1: ( ( rule__DataTypeDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:2408:1: ( ( rule__DataTypeDefinitionRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:2409:2: ( rule__DataTypeDefinitionRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:2410:2: ( rule__DataTypeDefinitionRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:2410:3: rule__DataTypeDefinitionRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__3"
    // InternalDataDescriptionLanguage.g:2418:1: rule__DataTypeDefinitionRule__Group__3 : rule__DataTypeDefinitionRule__Group__3__Impl rule__DataTypeDefinitionRule__Group__4 ;
    public final void rule__DataTypeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2422:1: ( rule__DataTypeDefinitionRule__Group__3__Impl rule__DataTypeDefinitionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2423:2: rule__DataTypeDefinitionRule__Group__3__Impl rule__DataTypeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__DataTypeDefinitionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__3"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__3__Impl"
    // InternalDataDescriptionLanguage.g:2430:1: rule__DataTypeDefinitionRule__Group__3__Impl : ( ( rule__DataTypeDefinitionRule__Group_3__0 )? ) ;
    public final void rule__DataTypeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2434:1: ( ( ( rule__DataTypeDefinitionRule__Group_3__0 )? ) )
            // InternalDataDescriptionLanguage.g:2435:1: ( ( rule__DataTypeDefinitionRule__Group_3__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2435:1: ( ( rule__DataTypeDefinitionRule__Group_3__0 )? )
            // InternalDataDescriptionLanguage.g:2436:2: ( rule__DataTypeDefinitionRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:2437:2: ( rule__DataTypeDefinitionRule__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==62) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2437:3: rule__DataTypeDefinitionRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataTypeDefinitionRule__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__4"
    // InternalDataDescriptionLanguage.g:2445:1: rule__DataTypeDefinitionRule__Group__4 : rule__DataTypeDefinitionRule__Group__4__Impl rule__DataTypeDefinitionRule__Group__5 ;
    public final void rule__DataTypeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2449:1: ( rule__DataTypeDefinitionRule__Group__4__Impl rule__DataTypeDefinitionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2450:2: rule__DataTypeDefinitionRule__Group__4__Impl rule__DataTypeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__DataTypeDefinitionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__4"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__4__Impl"
    // InternalDataDescriptionLanguage.g:2457:1: rule__DataTypeDefinitionRule__Group__4__Impl : ( ( rule__DataTypeDefinitionRule__Group_4__0 )? ) ;
    public final void rule__DataTypeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2461:1: ( ( ( rule__DataTypeDefinitionRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:2462:1: ( ( rule__DataTypeDefinitionRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2462:1: ( ( rule__DataTypeDefinitionRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:2463:2: ( rule__DataTypeDefinitionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:2464:2: ( rule__DataTypeDefinitionRule__Group_4__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==63) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2464:3: rule__DataTypeDefinitionRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataTypeDefinitionRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__4__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__5"
    // InternalDataDescriptionLanguage.g:2472:1: rule__DataTypeDefinitionRule__Group__5 : rule__DataTypeDefinitionRule__Group__5__Impl ;
    public final void rule__DataTypeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2476:1: ( rule__DataTypeDefinitionRule__Group__5__Impl )
            // InternalDataDescriptionLanguage.g:2477:2: rule__DataTypeDefinitionRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__5"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group__5__Impl"
    // InternalDataDescriptionLanguage.g:2483:1: rule__DataTypeDefinitionRule__Group__5__Impl : ( ';' ) ;
    public final void rule__DataTypeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2487:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2488:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2488:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2489:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getSemicolonKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group__5__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_3__0"
    // InternalDataDescriptionLanguage.g:2499:1: rule__DataTypeDefinitionRule__Group_3__0 : rule__DataTypeDefinitionRule__Group_3__0__Impl rule__DataTypeDefinitionRule__Group_3__1 ;
    public final void rule__DataTypeDefinitionRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2503:1: ( rule__DataTypeDefinitionRule__Group_3__0__Impl rule__DataTypeDefinitionRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:2504:2: rule__DataTypeDefinitionRule__Group_3__0__Impl rule__DataTypeDefinitionRule__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__DataTypeDefinitionRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_3__0"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_3__0__Impl"
    // InternalDataDescriptionLanguage.g:2511:1: rule__DataTypeDefinitionRule__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__DataTypeDefinitionRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2515:1: ( ( 'description' ) )
            // InternalDataDescriptionLanguage.g:2516:1: ( 'description' )
            {
            // InternalDataDescriptionLanguage.g:2516:1: ( 'description' )
            // InternalDataDescriptionLanguage.g:2517:2: 'description'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getDescriptionKeyword_3_0()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getDescriptionKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_3__0__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_3__1"
    // InternalDataDescriptionLanguage.g:2526:1: rule__DataTypeDefinitionRule__Group_3__1 : rule__DataTypeDefinitionRule__Group_3__1__Impl rule__DataTypeDefinitionRule__Group_3__2 ;
    public final void rule__DataTypeDefinitionRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2530:1: ( rule__DataTypeDefinitionRule__Group_3__1__Impl rule__DataTypeDefinitionRule__Group_3__2 )
            // InternalDataDescriptionLanguage.g:2531:2: rule__DataTypeDefinitionRule__Group_3__1__Impl rule__DataTypeDefinitionRule__Group_3__2
            {
            pushFollow(FOLLOW_12);
            rule__DataTypeDefinitionRule__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group_3__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_3__1"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_3__1__Impl"
    // InternalDataDescriptionLanguage.g:2538:1: rule__DataTypeDefinitionRule__Group_3__1__Impl : ( ':' ) ;
    public final void rule__DataTypeDefinitionRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2542:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2543:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2543:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2544:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getColonKeyword_3_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getColonKeyword_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_3__1__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_3__2"
    // InternalDataDescriptionLanguage.g:2553:1: rule__DataTypeDefinitionRule__Group_3__2 : rule__DataTypeDefinitionRule__Group_3__2__Impl ;
    public final void rule__DataTypeDefinitionRule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2557:1: ( rule__DataTypeDefinitionRule__Group_3__2__Impl )
            // InternalDataDescriptionLanguage.g:2558:2: rule__DataTypeDefinitionRule__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_3__2"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_3__2__Impl"
    // InternalDataDescriptionLanguage.g:2564:1: rule__DataTypeDefinitionRule__Group_3__2__Impl : ( ( rule__DataTypeDefinitionRule__DescriptionAssignment_3_2 ) ) ;
    public final void rule__DataTypeDefinitionRule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2568:1: ( ( ( rule__DataTypeDefinitionRule__DescriptionAssignment_3_2 ) ) )
            // InternalDataDescriptionLanguage.g:2569:1: ( ( rule__DataTypeDefinitionRule__DescriptionAssignment_3_2 ) )
            {
            // InternalDataDescriptionLanguage.g:2569:1: ( ( rule__DataTypeDefinitionRule__DescriptionAssignment_3_2 ) )
            // InternalDataDescriptionLanguage.g:2570:2: ( rule__DataTypeDefinitionRule__DescriptionAssignment_3_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getDescriptionAssignment_3_2()); 
            }
            // InternalDataDescriptionLanguage.g:2571:2: ( rule__DataTypeDefinitionRule__DescriptionAssignment_3_2 )
            // InternalDataDescriptionLanguage.g:2571:3: rule__DataTypeDefinitionRule__DescriptionAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__DescriptionAssignment_3_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getDescriptionAssignment_3_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_3__2__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_4__0"
    // InternalDataDescriptionLanguage.g:2580:1: rule__DataTypeDefinitionRule__Group_4__0 : rule__DataTypeDefinitionRule__Group_4__0__Impl rule__DataTypeDefinitionRule__Group_4__1 ;
    public final void rule__DataTypeDefinitionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2584:1: ( rule__DataTypeDefinitionRule__Group_4__0__Impl rule__DataTypeDefinitionRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:2585:2: rule__DataTypeDefinitionRule__Group_4__0__Impl rule__DataTypeDefinitionRule__Group_4__1
            {
            pushFollow(FOLLOW_17);
            rule__DataTypeDefinitionRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_4__0"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_4__0__Impl"
    // InternalDataDescriptionLanguage.g:2592:1: rule__DataTypeDefinitionRule__Group_4__0__Impl : ( 'with' ) ;
    public final void rule__DataTypeDefinitionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2596:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2597:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2597:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2598:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getWithKeyword_4_0()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getWithKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_4__0__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_4__1"
    // InternalDataDescriptionLanguage.g:2607:1: rule__DataTypeDefinitionRule__Group_4__1 : rule__DataTypeDefinitionRule__Group_4__1__Impl rule__DataTypeDefinitionRule__Group_4__2 ;
    public final void rule__DataTypeDefinitionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2611:1: ( rule__DataTypeDefinitionRule__Group_4__1__Impl rule__DataTypeDefinitionRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:2612:2: rule__DataTypeDefinitionRule__Group_4__1__Impl rule__DataTypeDefinitionRule__Group_4__2
            {
            pushFollow(FOLLOW_5);
            rule__DataTypeDefinitionRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_4__1"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_4__1__Impl"
    // InternalDataDescriptionLanguage.g:2619:1: rule__DataTypeDefinitionRule__Group_4__1__Impl : ( 'constraints' ) ;
    public final void rule__DataTypeDefinitionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2623:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2624:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2624:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2625:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getConstraintsKeyword_4_1()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getConstraintsKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_4__1__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_4__2"
    // InternalDataDescriptionLanguage.g:2634:1: rule__DataTypeDefinitionRule__Group_4__2 : rule__DataTypeDefinitionRule__Group_4__2__Impl rule__DataTypeDefinitionRule__Group_4__3 ;
    public final void rule__DataTypeDefinitionRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2638:1: ( rule__DataTypeDefinitionRule__Group_4__2__Impl rule__DataTypeDefinitionRule__Group_4__3 )
            // InternalDataDescriptionLanguage.g:2639:2: rule__DataTypeDefinitionRule__Group_4__2__Impl rule__DataTypeDefinitionRule__Group_4__3
            {
            pushFollow(FOLLOW_10);
            rule__DataTypeDefinitionRule__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group_4__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_4__2"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_4__2__Impl"
    // InternalDataDescriptionLanguage.g:2646:1: rule__DataTypeDefinitionRule__Group_4__2__Impl : ( ':' ) ;
    public final void rule__DataTypeDefinitionRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2650:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2651:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2651:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2652:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getColonKeyword_4_2()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getColonKeyword_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_4__2__Impl"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_4__3"
    // InternalDataDescriptionLanguage.g:2661:1: rule__DataTypeDefinitionRule__Group_4__3 : rule__DataTypeDefinitionRule__Group_4__3__Impl ;
    public final void rule__DataTypeDefinitionRule__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2665:1: ( rule__DataTypeDefinitionRule__Group_4__3__Impl )
            // InternalDataDescriptionLanguage.g:2666:2: rule__DataTypeDefinitionRule__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Group_4__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_4__3"


    // $ANTLR start "rule__DataTypeDefinitionRule__Group_4__3__Impl"
    // InternalDataDescriptionLanguage.g:2672:1: rule__DataTypeDefinitionRule__Group_4__3__Impl : ( ( rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3 )* ) ;
    public final void rule__DataTypeDefinitionRule__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2676:1: ( ( ( rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3 )* ) )
            // InternalDataDescriptionLanguage.g:2677:1: ( ( rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2677:1: ( ( rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3 )* )
            // InternalDataDescriptionLanguage.g:2678:2: ( rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getConstraintsAssignment_4_3()); 
            }
            // InternalDataDescriptionLanguage.g:2679:2: ( rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=RULE_QUOTED_ID && LA24_0<=RULE_INT)||LA24_0==15||(LA24_0>=30 && LA24_0<=31)||LA24_0==65||LA24_0==70||(LA24_0>=86 && LA24_0<=87)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2679:3: rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getConstraintsAssignment_4_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__Group_4__3__Impl"


    // $ANTLR start "rule__TypedDataDescriptionRule__Group__0"
    // InternalDataDescriptionLanguage.g:2688:1: rule__TypedDataDescriptionRule__Group__0 : rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1 ;
    public final void rule__TypedDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2692:1: ( rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2693:2: rule__TypedDataDescriptionRule__Group__0__Impl rule__TypedDataDescriptionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2700:1: rule__TypedDataDescriptionRule__Group__0__Impl : ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2704:1: ( ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:2705:1: ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:2705:1: ( ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:2706:2: ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getRepresentationAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2707:2: ( rule__TypedDataDescriptionRule__RepresentationAssignment_0 )
            // InternalDataDescriptionLanguage.g:2707:3: rule__TypedDataDescriptionRule__RepresentationAssignment_0
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
    // InternalDataDescriptionLanguage.g:2715:1: rule__TypedDataDescriptionRule__Group__1 : rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2 ;
    public final void rule__TypedDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2719:1: ( rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2720:2: rule__TypedDataDescriptionRule__Group__1__Impl rule__TypedDataDescriptionRule__Group__2
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
    // InternalDataDescriptionLanguage.g:2727:1: rule__TypedDataDescriptionRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__TypedDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2731:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:2732:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:2732:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:2733:2: 'data'
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
    // InternalDataDescriptionLanguage.g:2742:1: rule__TypedDataDescriptionRule__Group__2 : rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3 ;
    public final void rule__TypedDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2746:1: ( rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2747:2: rule__TypedDataDescriptionRule__Group__2__Impl rule__TypedDataDescriptionRule__Group__3
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
    // InternalDataDescriptionLanguage.g:2754:1: rule__TypedDataDescriptionRule__Group__2__Impl : ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2758:1: ( ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:2759:1: ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:2759:1: ( ( rule__TypedDataDescriptionRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:2760:2: ( rule__TypedDataDescriptionRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:2761:2: ( rule__TypedDataDescriptionRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:2761:3: rule__TypedDataDescriptionRule__NameAssignment_2
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
    // InternalDataDescriptionLanguage.g:2769:1: rule__TypedDataDescriptionRule__Group__3 : rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4 ;
    public final void rule__TypedDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2773:1: ( rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2774:2: rule__TypedDataDescriptionRule__Group__3__Impl rule__TypedDataDescriptionRule__Group__4
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
    // InternalDataDescriptionLanguage.g:2781:1: rule__TypedDataDescriptionRule__Group__3__Impl : ( 'of' ) ;
    public final void rule__TypedDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2785:1: ( ( 'of' ) )
            // InternalDataDescriptionLanguage.g:2786:1: ( 'of' )
            {
            // InternalDataDescriptionLanguage.g:2786:1: ( 'of' )
            // InternalDataDescriptionLanguage.g:2787:2: 'of'
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
    // InternalDataDescriptionLanguage.g:2796:1: rule__TypedDataDescriptionRule__Group__4 : rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5 ;
    public final void rule__TypedDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2800:1: ( rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2801:2: rule__TypedDataDescriptionRule__Group__4__Impl rule__TypedDataDescriptionRule__Group__5
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
    // InternalDataDescriptionLanguage.g:2808:1: rule__TypedDataDescriptionRule__Group__4__Impl : ( 'type' ) ;
    public final void rule__TypedDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2812:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:2813:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:2813:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:2814:2: 'type'
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
    // InternalDataDescriptionLanguage.g:2823:1: rule__TypedDataDescriptionRule__Group__5 : rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6 ;
    public final void rule__TypedDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2827:1: ( rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6 )
            // InternalDataDescriptionLanguage.g:2828:2: rule__TypedDataDescriptionRule__Group__5__Impl rule__TypedDataDescriptionRule__Group__6
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
    // InternalDataDescriptionLanguage.g:2835:1: rule__TypedDataDescriptionRule__Group__5__Impl : ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) ) ;
    public final void rule__TypedDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2839:1: ( ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) ) )
            // InternalDataDescriptionLanguage.g:2840:1: ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) )
            {
            // InternalDataDescriptionLanguage.g:2840:1: ( ( rule__TypedDataDescriptionRule__TypeAssignment_5 ) )
            // InternalDataDescriptionLanguage.g:2841:2: ( rule__TypedDataDescriptionRule__TypeAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeAssignment_5()); 
            }
            // InternalDataDescriptionLanguage.g:2842:2: ( rule__TypedDataDescriptionRule__TypeAssignment_5 )
            // InternalDataDescriptionLanguage.g:2842:3: rule__TypedDataDescriptionRule__TypeAssignment_5
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
    // InternalDataDescriptionLanguage.g:2850:1: rule__TypedDataDescriptionRule__Group__6 : rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7 ;
    public final void rule__TypedDataDescriptionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2854:1: ( rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7 )
            // InternalDataDescriptionLanguage.g:2855:2: rule__TypedDataDescriptionRule__Group__6__Impl rule__TypedDataDescriptionRule__Group__7
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
    // InternalDataDescriptionLanguage.g:2862:1: rule__TypedDataDescriptionRule__Group__6__Impl : ( ( rule__TypedDataDescriptionRule__Group_6__0 )? ) ;
    public final void rule__TypedDataDescriptionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2866:1: ( ( ( rule__TypedDataDescriptionRule__Group_6__0 )? ) )
            // InternalDataDescriptionLanguage.g:2867:1: ( ( rule__TypedDataDescriptionRule__Group_6__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2867:1: ( ( rule__TypedDataDescriptionRule__Group_6__0 )? )
            // InternalDataDescriptionLanguage.g:2868:2: ( rule__TypedDataDescriptionRule__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getGroup_6()); 
            }
            // InternalDataDescriptionLanguage.g:2869:2: ( rule__TypedDataDescriptionRule__Group_6__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==63) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2869:3: rule__TypedDataDescriptionRule__Group_6__0
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
    // InternalDataDescriptionLanguage.g:2877:1: rule__TypedDataDescriptionRule__Group__7 : rule__TypedDataDescriptionRule__Group__7__Impl ;
    public final void rule__TypedDataDescriptionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2881:1: ( rule__TypedDataDescriptionRule__Group__7__Impl )
            // InternalDataDescriptionLanguage.g:2882:2: rule__TypedDataDescriptionRule__Group__7__Impl
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
    // InternalDataDescriptionLanguage.g:2888:1: rule__TypedDataDescriptionRule__Group__7__Impl : ( ';' ) ;
    public final void rule__TypedDataDescriptionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2892:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2893:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2893:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2894:2: ';'
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
    // InternalDataDescriptionLanguage.g:2904:1: rule__TypedDataDescriptionRule__Group_6__0 : rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1 ;
    public final void rule__TypedDataDescriptionRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2908:1: ( rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1 )
            // InternalDataDescriptionLanguage.g:2909:2: rule__TypedDataDescriptionRule__Group_6__0__Impl rule__TypedDataDescriptionRule__Group_6__1
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
    // InternalDataDescriptionLanguage.g:2916:1: rule__TypedDataDescriptionRule__Group_6__0__Impl : ( 'with' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2920:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2921:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2921:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2922:2: 'with'
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
    // InternalDataDescriptionLanguage.g:2931:1: rule__TypedDataDescriptionRule__Group_6__1 : rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2 ;
    public final void rule__TypedDataDescriptionRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2935:1: ( rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2 )
            // InternalDataDescriptionLanguage.g:2936:2: rule__TypedDataDescriptionRule__Group_6__1__Impl rule__TypedDataDescriptionRule__Group_6__2
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
    // InternalDataDescriptionLanguage.g:2943:1: rule__TypedDataDescriptionRule__Group_6__1__Impl : ( 'constraints' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2947:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2948:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2948:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2949:2: 'constraints'
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
    // InternalDataDescriptionLanguage.g:2958:1: rule__TypedDataDescriptionRule__Group_6__2 : rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3 ;
    public final void rule__TypedDataDescriptionRule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2962:1: ( rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3 )
            // InternalDataDescriptionLanguage.g:2963:2: rule__TypedDataDescriptionRule__Group_6__2__Impl rule__TypedDataDescriptionRule__Group_6__3
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
    // InternalDataDescriptionLanguage.g:2970:1: rule__TypedDataDescriptionRule__Group_6__2__Impl : ( ':' ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2974:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2975:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2975:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2976:2: ':'
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
    // InternalDataDescriptionLanguage.g:2985:1: rule__TypedDataDescriptionRule__Group_6__3 : rule__TypedDataDescriptionRule__Group_6__3__Impl ;
    public final void rule__TypedDataDescriptionRule__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2989:1: ( rule__TypedDataDescriptionRule__Group_6__3__Impl )
            // InternalDataDescriptionLanguage.g:2990:2: rule__TypedDataDescriptionRule__Group_6__3__Impl
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
    // InternalDataDescriptionLanguage.g:2996:1: rule__TypedDataDescriptionRule__Group_6__3__Impl : ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* ) ;
    public final void rule__TypedDataDescriptionRule__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3000:1: ( ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* ) )
            // InternalDataDescriptionLanguage.g:3001:1: ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* )
            {
            // InternalDataDescriptionLanguage.g:3001:1: ( ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )* )
            // InternalDataDescriptionLanguage.g:3002:2: ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsAssignment_6_3()); 
            }
            // InternalDataDescriptionLanguage.g:3003:2: ( rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=RULE_QUOTED_ID && LA26_0<=RULE_INT)||LA26_0==15||(LA26_0>=30 && LA26_0<=31)||LA26_0==65||LA26_0==70||(LA26_0>=86 && LA26_0<=87)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3003:3: rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalDataDescriptionLanguage.g:3012:1: rule__UntypedDataDescriptionRule__Group__0 : rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1 ;
    public final void rule__UntypedDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3016:1: ( rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3017:2: rule__UntypedDataDescriptionRule__Group__0__Impl rule__UntypedDataDescriptionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3024:1: rule__UntypedDataDescriptionRule__Group__0__Impl : ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? ) ;
    public final void rule__UntypedDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3028:1: ( ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? ) )
            // InternalDataDescriptionLanguage.g:3029:1: ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? )
            {
            // InternalDataDescriptionLanguage.g:3029:1: ( ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )? )
            // InternalDataDescriptionLanguage.g:3030:2: ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getScaleAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3031:2: ( rule__UntypedDataDescriptionRule__ScaleAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=16 && LA27_0<=19)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3031:3: rule__UntypedDataDescriptionRule__ScaleAssignment_0
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
    // InternalDataDescriptionLanguage.g:3039:1: rule__UntypedDataDescriptionRule__Group__1 : rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2 ;
    public final void rule__UntypedDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3043:1: ( rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:3044:2: rule__UntypedDataDescriptionRule__Group__1__Impl rule__UntypedDataDescriptionRule__Group__2
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
    // InternalDataDescriptionLanguage.g:3051:1: rule__UntypedDataDescriptionRule__Group__1__Impl : ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) ) ;
    public final void rule__UntypedDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3055:1: ( ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3056:1: ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3056:1: ( ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3057:2: ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getRepresentationAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3058:2: ( rule__UntypedDataDescriptionRule__RepresentationAssignment_1 )
            // InternalDataDescriptionLanguage.g:3058:3: rule__UntypedDataDescriptionRule__RepresentationAssignment_1
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
    // InternalDataDescriptionLanguage.g:3066:1: rule__UntypedDataDescriptionRule__Group__2 : rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3 ;
    public final void rule__UntypedDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3070:1: ( rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:3071:2: rule__UntypedDataDescriptionRule__Group__2__Impl rule__UntypedDataDescriptionRule__Group__3
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
    // InternalDataDescriptionLanguage.g:3078:1: rule__UntypedDataDescriptionRule__Group__2__Impl : ( 'data' ) ;
    public final void rule__UntypedDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3082:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:3083:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:3083:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:3084:2: 'data'
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
    // InternalDataDescriptionLanguage.g:3093:1: rule__UntypedDataDescriptionRule__Group__3 : rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4 ;
    public final void rule__UntypedDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3097:1: ( rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:3098:2: rule__UntypedDataDescriptionRule__Group__3__Impl rule__UntypedDataDescriptionRule__Group__4
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
    // InternalDataDescriptionLanguage.g:3105:1: rule__UntypedDataDescriptionRule__Group__3__Impl : ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) ) ;
    public final void rule__UntypedDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3109:1: ( ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) ) )
            // InternalDataDescriptionLanguage.g:3110:1: ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) )
            {
            // InternalDataDescriptionLanguage.g:3110:1: ( ( rule__UntypedDataDescriptionRule__NameAssignment_3 ) )
            // InternalDataDescriptionLanguage.g:3111:2: ( rule__UntypedDataDescriptionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDataDescriptionLanguage.g:3112:2: ( rule__UntypedDataDescriptionRule__NameAssignment_3 )
            // InternalDataDescriptionLanguage.g:3112:3: rule__UntypedDataDescriptionRule__NameAssignment_3
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
    // InternalDataDescriptionLanguage.g:3120:1: rule__UntypedDataDescriptionRule__Group__4 : rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5 ;
    public final void rule__UntypedDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3124:1: ( rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:3125:2: rule__UntypedDataDescriptionRule__Group__4__Impl rule__UntypedDataDescriptionRule__Group__5
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
    // InternalDataDescriptionLanguage.g:3132:1: rule__UntypedDataDescriptionRule__Group__4__Impl : ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? ) ;
    public final void rule__UntypedDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3136:1: ( ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:3137:1: ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:3137:1: ( ( rule__UntypedDataDescriptionRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:3138:2: ( rule__UntypedDataDescriptionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:3139:2: ( rule__UntypedDataDescriptionRule__Group_4__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==63) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3139:3: rule__UntypedDataDescriptionRule__Group_4__0
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
    // InternalDataDescriptionLanguage.g:3147:1: rule__UntypedDataDescriptionRule__Group__5 : rule__UntypedDataDescriptionRule__Group__5__Impl ;
    public final void rule__UntypedDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3151:1: ( rule__UntypedDataDescriptionRule__Group__5__Impl )
            // InternalDataDescriptionLanguage.g:3152:2: rule__UntypedDataDescriptionRule__Group__5__Impl
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
    // InternalDataDescriptionLanguage.g:3158:1: rule__UntypedDataDescriptionRule__Group__5__Impl : ( ';' ) ;
    public final void rule__UntypedDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3162:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:3163:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:3163:1: ( ';' )
            // InternalDataDescriptionLanguage.g:3164:2: ';'
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
    // InternalDataDescriptionLanguage.g:3174:1: rule__UntypedDataDescriptionRule__Group_4__0 : rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3178:1: ( rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:3179:2: rule__UntypedDataDescriptionRule__Group_4__0__Impl rule__UntypedDataDescriptionRule__Group_4__1
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
    // InternalDataDescriptionLanguage.g:3186:1: rule__UntypedDataDescriptionRule__Group_4__0__Impl : ( 'with' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3190:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:3191:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:3191:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:3192:2: 'with'
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
    // InternalDataDescriptionLanguage.g:3201:1: rule__UntypedDataDescriptionRule__Group_4__1 : rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3205:1: ( rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:3206:2: rule__UntypedDataDescriptionRule__Group_4__1__Impl rule__UntypedDataDescriptionRule__Group_4__2
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
    // InternalDataDescriptionLanguage.g:3213:1: rule__UntypedDataDescriptionRule__Group_4__1__Impl : ( 'constraints' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3217:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:3218:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:3218:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:3219:2: 'constraints'
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
    // InternalDataDescriptionLanguage.g:3228:1: rule__UntypedDataDescriptionRule__Group_4__2 : rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3 ;
    public final void rule__UntypedDataDescriptionRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3232:1: ( rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3 )
            // InternalDataDescriptionLanguage.g:3233:2: rule__UntypedDataDescriptionRule__Group_4__2__Impl rule__UntypedDataDescriptionRule__Group_4__3
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
    // InternalDataDescriptionLanguage.g:3240:1: rule__UntypedDataDescriptionRule__Group_4__2__Impl : ( ':' ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3244:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:3245:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:3245:1: ( ':' )
            // InternalDataDescriptionLanguage.g:3246:2: ':'
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
    // InternalDataDescriptionLanguage.g:3255:1: rule__UntypedDataDescriptionRule__Group_4__3 : rule__UntypedDataDescriptionRule__Group_4__3__Impl ;
    public final void rule__UntypedDataDescriptionRule__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3259:1: ( rule__UntypedDataDescriptionRule__Group_4__3__Impl )
            // InternalDataDescriptionLanguage.g:3260:2: rule__UntypedDataDescriptionRule__Group_4__3__Impl
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
    // InternalDataDescriptionLanguage.g:3266:1: rule__UntypedDataDescriptionRule__Group_4__3__Impl : ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* ) ;
    public final void rule__UntypedDataDescriptionRule__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3270:1: ( ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* ) )
            // InternalDataDescriptionLanguage.g:3271:1: ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* )
            {
            // InternalDataDescriptionLanguage.g:3271:1: ( ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )* )
            // InternalDataDescriptionLanguage.g:3272:2: ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsAssignment_4_3()); 
            }
            // InternalDataDescriptionLanguage.g:3273:2: ( rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=RULE_QUOTED_ID && LA29_0<=RULE_INT)||LA29_0==15||(LA29_0>=30 && LA29_0<=31)||LA29_0==65||LA29_0==70||(LA29_0>=86 && LA29_0<=87)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3273:3: rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalDataDescriptionLanguage.g:3282:1: rule__StatementRule__Group__0 : rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 ;
    public final void rule__StatementRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3286:1: ( rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3287:2: rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3294:1: rule__StatementRule__Group__0__Impl : ( ruleExpressionRule ) ;
    public final void rule__StatementRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3298:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:3299:1: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:3299:1: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:3300:2: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:3309:1: rule__StatementRule__Group__1 : rule__StatementRule__Group__1__Impl ;
    public final void rule__StatementRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3313:1: ( rule__StatementRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3314:2: rule__StatementRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3320:1: rule__StatementRule__Group__1__Impl : ( ';' ) ;
    public final void rule__StatementRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3324:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:3325:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:3325:1: ( ';' )
            // InternalDataDescriptionLanguage.g:3326:2: ';'
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
    // InternalDataDescriptionLanguage.g:3336:1: rule__SelfReferenceRule__Group__0 : rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1 ;
    public final void rule__SelfReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3340:1: ( rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3341:2: rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3348:1: rule__SelfReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3352:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:3353:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:3353:1: ( () )
            // InternalDataDescriptionLanguage.g:3354:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:3355:2: ()
            // InternalDataDescriptionLanguage.g:3355:3: 
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
    // InternalDataDescriptionLanguage.g:3363:1: rule__SelfReferenceRule__Group__1 : rule__SelfReferenceRule__Group__1__Impl ;
    public final void rule__SelfReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3367:1: ( rule__SelfReferenceRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3368:2: rule__SelfReferenceRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3374:1: rule__SelfReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__SelfReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3378:1: ( ( 'value' ) )
            // InternalDataDescriptionLanguage.g:3379:1: ( 'value' )
            {
            // InternalDataDescriptionLanguage.g:3379:1: ( 'value' )
            // InternalDataDescriptionLanguage.g:3380:2: 'value'
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
    // InternalDataDescriptionLanguage.g:3390:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3394:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3395:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3402:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3406:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3407:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3407:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3408:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3409:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:3409:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:3417:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3421:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3422:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3428:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3432:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3433:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3433:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3434:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3435:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==66) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3435:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalDataDescriptionLanguage.g:3444:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3448:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3449:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3456:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3460:1: ( ( 'OR' ) )
            // InternalDataDescriptionLanguage.g:3461:1: ( 'OR' )
            {
            // InternalDataDescriptionLanguage.g:3461:1: ( 'OR' )
            // InternalDataDescriptionLanguage.g:3462:2: 'OR'
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
    // InternalDataDescriptionLanguage.g:3471:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3475:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3476:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3482:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3486:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3487:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3487:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3488:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3489:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3489:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3498:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3502:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3503:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3510:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3514:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3515:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3515:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3516:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3517:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:3517:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:3525:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3529:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3530:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3536:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3540:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3541:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3541:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3542:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3543:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==67) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3543:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalDataDescriptionLanguage.g:3552:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3556:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3557:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3564:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3568:1: ( ( 'XOR' ) )
            // InternalDataDescriptionLanguage.g:3569:1: ( 'XOR' )
            {
            // InternalDataDescriptionLanguage.g:3569:1: ( 'XOR' )
            // InternalDataDescriptionLanguage.g:3570:2: 'XOR'
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
    // InternalDataDescriptionLanguage.g:3579:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3583:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3584:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3590:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3594:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3595:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3595:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3596:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3597:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3597:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3606:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3610:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3611:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3618:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3622:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3623:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3623:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3624:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3625:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:3625:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:3633:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3637:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3638:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3644:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3648:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3649:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3649:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3650:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3651:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==68) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3651:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalDataDescriptionLanguage.g:3660:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3664:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3665:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3672:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3676:1: ( ( 'AND' ) )
            // InternalDataDescriptionLanguage.g:3677:1: ( 'AND' )
            {
            // InternalDataDescriptionLanguage.g:3677:1: ( 'AND' )
            // InternalDataDescriptionLanguage.g:3678:2: 'AND'
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
    // InternalDataDescriptionLanguage.g:3687:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3691:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3692:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3698:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3702:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3703:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3703:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3704:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3705:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3705:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3714:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3718:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3719:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3726:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3730:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalDataDescriptionLanguage.g:3731:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalDataDescriptionLanguage.g:3731:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalDataDescriptionLanguage.g:3732:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3733:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==86) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3733:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalDataDescriptionLanguage.g:3741:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3745:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3746:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3752:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3756:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3757:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3757:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3758:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3759:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalDataDescriptionLanguage.g:3759:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalDataDescriptionLanguage.g:3768:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3772:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3773:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3780:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3784:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3785:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3785:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3786:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3787:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3787:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3795:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3799:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3800:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3806:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3810:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalDataDescriptionLanguage.g:3811:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalDataDescriptionLanguage.g:3811:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalDataDescriptionLanguage.g:3812:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3813:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=24 && LA34_0<=29)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3813:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalDataDescriptionLanguage.g:3822:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3826:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3827:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3834:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3838:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3839:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3839:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3840:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3841:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalDataDescriptionLanguage.g:3841:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalDataDescriptionLanguage.g:3849:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3853:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3854:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3860:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3864:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3865:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3865:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3866:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3867:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:3867:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:3876:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3880:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3881:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3888:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3892:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:3893:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3893:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:3894:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3895:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:3895:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:3903:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3907:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:3908:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:3914:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3918:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:3919:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:3919:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:3920:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:3921:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=30 && LA35_0<=31)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3921:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalDataDescriptionLanguage.g:3930:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3934:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:3935:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:3942:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3946:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDataDescriptionLanguage.g:3947:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDataDescriptionLanguage.g:3947:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDataDescriptionLanguage.g:3948:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:3949:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalDataDescriptionLanguage.g:3949:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalDataDescriptionLanguage.g:3957:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3961:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:3962:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:3968:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3972:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:3973:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3973:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:3974:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:3975:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:3975:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:3984:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3988:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3989:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:3996:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4000:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4001:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4001:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4002:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4003:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:4003:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:4011:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4015:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4016:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4022:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4026:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:4027:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:4027:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:4028:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:4029:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=32 && LA36_0<=34)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4029:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalDataDescriptionLanguage.g:4038:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4042:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:4043:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:4050:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4054:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDataDescriptionLanguage.g:4055:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4055:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDataDescriptionLanguage.g:4056:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:4057:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalDataDescriptionLanguage.g:4057:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalDataDescriptionLanguage.g:4065:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4069:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4070:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4076:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4080:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4081:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4081:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:4082:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4083:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:4083:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:4092:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4096:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4097:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4104:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4108:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4109:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4109:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4110:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4111:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:4111:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:4119:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4123:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4124:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4130:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4134:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalDataDescriptionLanguage.g:4135:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalDataDescriptionLanguage.g:4135:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalDataDescriptionLanguage.g:4136:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:4137:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==69) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:4137:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalDataDescriptionLanguage.g:4146:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4150:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:4151:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
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
    // InternalDataDescriptionLanguage.g:4158:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4162:1: ( ( '^' ) )
            // InternalDataDescriptionLanguage.g:4163:1: ( '^' )
            {
            // InternalDataDescriptionLanguage.g:4163:1: ( '^' )
            // InternalDataDescriptionLanguage.g:4164:2: '^'
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
    // InternalDataDescriptionLanguage.g:4173:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4177:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4178:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4184:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4188:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4189:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4189:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:4190:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4191:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:4191:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:4200:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4204:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4205:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4212:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4216:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:4217:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:4217:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:4218:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4219:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=30 && LA38_0<=31)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4219:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
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
    // InternalDataDescriptionLanguage.g:4227:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4231:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4232:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4238:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4242:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:4243:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4243:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:4244:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4245:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:4245:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:4254:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4258:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4259:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4266:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4270:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:4271:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:4271:1: ( '(' )
            // InternalDataDescriptionLanguage.g:4272:2: '('
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
    // InternalDataDescriptionLanguage.g:4281:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4285:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalDataDescriptionLanguage.g:4286:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
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
    // InternalDataDescriptionLanguage.g:4293:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4297:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:4298:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4298:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:4299:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4300:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:4300:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:4308:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4312:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:4313:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalDataDescriptionLanguage.g:4319:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4323:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:4324:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:4324:1: ( ')' )
            // InternalDataDescriptionLanguage.g:4325:2: ')'
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
    // InternalDataDescriptionLanguage.g:4335:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4339:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4340:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4347:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4351:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4352:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4352:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4353:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4354:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalDataDescriptionLanguage.g:4354:3: rule__CallRule__FunctionAssignment_0
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
    // InternalDataDescriptionLanguage.g:4362:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4366:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalDataDescriptionLanguage.g:4367:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
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
    // InternalDataDescriptionLanguage.g:4374:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4378:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:4379:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:4379:1: ( '(' )
            // InternalDataDescriptionLanguage.g:4380:2: '('
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
    // InternalDataDescriptionLanguage.g:4389:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4393:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalDataDescriptionLanguage.g:4394:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
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
    // InternalDataDescriptionLanguage.g:4401:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4405:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalDataDescriptionLanguage.g:4406:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalDataDescriptionLanguage.g:4406:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalDataDescriptionLanguage.g:4407:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalDataDescriptionLanguage.g:4408:2: ( rule__CallRule__Group_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_QUOTED_ID && LA39_0<=RULE_INT)||LA39_0==15||(LA39_0>=30 && LA39_0<=31)||LA39_0==65||LA39_0==70||(LA39_0>=86 && LA39_0<=87)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:4408:3: rule__CallRule__Group_2__0
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
    // InternalDataDescriptionLanguage.g:4416:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4420:1: ( rule__CallRule__Group__3__Impl )
            // InternalDataDescriptionLanguage.g:4421:2: rule__CallRule__Group__3__Impl
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
    // InternalDataDescriptionLanguage.g:4427:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4431:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:4432:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:4432:1: ( ')' )
            // InternalDataDescriptionLanguage.g:4433:2: ')'
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
    // InternalDataDescriptionLanguage.g:4443:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4447:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalDataDescriptionLanguage.g:4448:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
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
    // InternalDataDescriptionLanguage.g:4455:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4459:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalDataDescriptionLanguage.g:4460:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4460:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalDataDescriptionLanguage.g:4461:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalDataDescriptionLanguage.g:4462:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalDataDescriptionLanguage.g:4462:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalDataDescriptionLanguage.g:4470:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4474:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalDataDescriptionLanguage.g:4475:2: rule__CallRule__Group_2__1__Impl
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
    // InternalDataDescriptionLanguage.g:4481:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4485:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:4486:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:4486:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalDataDescriptionLanguage.g:4487:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalDataDescriptionLanguage.g:4488:2: ( rule__CallRule__Group_2_1__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==72) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4488:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop40;
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
    // InternalDataDescriptionLanguage.g:4497:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4501:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalDataDescriptionLanguage.g:4502:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
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
    // InternalDataDescriptionLanguage.g:4509:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4513:1: ( ( ',' ) )
            // InternalDataDescriptionLanguage.g:4514:1: ( ',' )
            {
            // InternalDataDescriptionLanguage.g:4514:1: ( ',' )
            // InternalDataDescriptionLanguage.g:4515:2: ','
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
    // InternalDataDescriptionLanguage.g:4524:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4528:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4529:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4535:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4539:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4540:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4540:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalDataDescriptionLanguage.g:4541:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4542:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalDataDescriptionLanguage.g:4542:3: rule__CallRule__ParametersAssignment_2_1_1
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
    // InternalDataDescriptionLanguage.g:4551:1: rule__DoubleLiteralRule__Group__0 : rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 ;
    public final void rule__DoubleLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4555:1: ( rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4556:2: rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4563:1: rule__DoubleLiteralRule__Group__0__Impl : ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__DoubleLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4567:1: ( ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4568:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4568:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4569:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4570:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            // InternalDataDescriptionLanguage.g:4570:3: rule__DoubleLiteralRule__LiteralAssignment_0
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
    // InternalDataDescriptionLanguage.g:4578:1: rule__DoubleLiteralRule__Group__1 : rule__DoubleLiteralRule__Group__1__Impl ;
    public final void rule__DoubleLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4582:1: ( rule__DoubleLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4583:2: rule__DoubleLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4589:1: rule__DoubleLiteralRule__Group__1__Impl : ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__DoubleLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4593:1: ( ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) )
            // InternalDataDescriptionLanguage.g:4594:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDataDescriptionLanguage.g:4594:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            // InternalDataDescriptionLanguage.g:4595:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4596:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=35 && LA41_0<=54)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:4596:3: rule__DoubleLiteralRule__FactorAssignment_1
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
    // InternalDataDescriptionLanguage.g:4605:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4609:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4610:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4617:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4621:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4622:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4622:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4623:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4624:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalDataDescriptionLanguage.g:4624:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalDataDescriptionLanguage.g:4632:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4636:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4637:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4643:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4647:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalDataDescriptionLanguage.g:4648:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDataDescriptionLanguage.g:4648:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalDataDescriptionLanguage.g:4649:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4650:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=35 && LA42_0<=54)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:4650:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalDataDescriptionLanguage.g:4659:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4663:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4664:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4671:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4675:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:4676:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:4676:1: ( () )
            // InternalDataDescriptionLanguage.g:4677:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:4678:2: ()
            // InternalDataDescriptionLanguage.g:4678:3: 
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
    // InternalDataDescriptionLanguage.g:4686:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4690:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4691:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4697:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4701:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalDataDescriptionLanguage.g:4702:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4702:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalDataDescriptionLanguage.g:4703:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalDataDescriptionLanguage.g:4704:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalDataDescriptionLanguage.g:4704:3: rule__BooleanLiteralRule__Alternatives_1
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


    // $ANTLR start "rule__TypeDefinitionRule__Group__0"
    // InternalDataDescriptionLanguage.g:4713:1: rule__TypeDefinitionRule__Group__0 : rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1 ;
    public final void rule__TypeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4717:1: ( rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4718:2: rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__TypeDefinitionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4725:1: rule__TypeDefinitionRule__Group__0__Impl : ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? ) ;
    public final void rule__TypeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4729:1: ( ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? ) )
            // InternalDataDescriptionLanguage.g:4730:1: ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? )
            {
            // InternalDataDescriptionLanguage.g:4730:1: ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? )
            // InternalDataDescriptionLanguage.g:4731:2: ( rule__TypeDefinitionRule__AbstractAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4732:2: ( rule__TypeDefinitionRule__AbstractAssignment_0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==88) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:4732:3: rule__TypeDefinitionRule__AbstractAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeDefinitionRule__AbstractAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAssignment_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4740:1: rule__TypeDefinitionRule__Group__1 : rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2 ;
    public final void rule__TypeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4744:1: ( rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:4745:2: rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__TypeDefinitionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4752:1: rule__TypeDefinitionRule__Group__1__Impl : ( 'type' ) ;
    public final void rule__TypeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4756:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:4757:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:4757:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:4758:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getTypeKeyword_1()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getTypeKeyword_1()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4767:1: rule__TypeDefinitionRule__Group__2 : rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3 ;
    public final void rule__TypeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4771:1: ( rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:4772:2: rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_41);
            rule__TypeDefinitionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4779:1: rule__TypeDefinitionRule__Group__2__Impl : ( ( rule__TypeDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__TypeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4783:1: ( ( ( rule__TypeDefinitionRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:4784:1: ( ( rule__TypeDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:4784:1: ( ( rule__TypeDefinitionRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:4785:2: ( rule__TypeDefinitionRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:4786:2: ( rule__TypeDefinitionRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:4786:3: rule__TypeDefinitionRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getNameAssignment_2()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4794:1: rule__TypeDefinitionRule__Group__3 : rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4 ;
    public final void rule__TypeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4798:1: ( rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:4799:2: rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_41);
            rule__TypeDefinitionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4806:1: rule__TypeDefinitionRule__Group__3__Impl : ( ( rule__TypeDefinitionRule__Group_3__0 )? ) ;
    public final void rule__TypeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4810:1: ( ( ( rule__TypeDefinitionRule__Group_3__0 )? ) )
            // InternalDataDescriptionLanguage.g:4811:1: ( ( rule__TypeDefinitionRule__Group_3__0 )? )
            {
            // InternalDataDescriptionLanguage.g:4811:1: ( ( rule__TypeDefinitionRule__Group_3__0 )? )
            // InternalDataDescriptionLanguage.g:4812:2: ( rule__TypeDefinitionRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:4813:2: ( rule__TypeDefinitionRule__Group_3__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==75) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:4813:3: rule__TypeDefinitionRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeDefinitionRule__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getGroup_3()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4821:1: rule__TypeDefinitionRule__Group__4 : rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5 ;
    public final void rule__TypeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4825:1: ( rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:4826:2: rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_42);
            rule__TypeDefinitionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4833:1: rule__TypeDefinitionRule__Group__4__Impl : ( '{' ) ;
    public final void rule__TypeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4837:1: ( ( '{' ) )
            // InternalDataDescriptionLanguage.g:4838:1: ( '{' )
            {
            // InternalDataDescriptionLanguage.g:4838:1: ( '{' )
            // InternalDataDescriptionLanguage.g:4839:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getLeftCurlyBracketKeyword_4()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4848:1: rule__TypeDefinitionRule__Group__5 : rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6 ;
    public final void rule__TypeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4852:1: ( rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6 )
            // InternalDataDescriptionLanguage.g:4853:2: rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_42);
            rule__TypeDefinitionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4860:1: rule__TypeDefinitionRule__Group__5__Impl : ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* ) ;
    public final void rule__TypeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4864:1: ( ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* ) )
            // InternalDataDescriptionLanguage.g:4865:1: ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* )
            {
            // InternalDataDescriptionLanguage.g:4865:1: ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* )
            // InternalDataDescriptionLanguage.g:4866:2: ( rule__TypeDefinitionRule__AttributesAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAssignment_5()); 
            }
            // InternalDataDescriptionLanguage.g:4867:2: ( rule__TypeDefinitionRule__AttributesAssignment_5 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=RULE_QUOTED_ID && LA45_0<=RULE_ID)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4867:3: rule__TypeDefinitionRule__AttributesAssignment_5
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__TypeDefinitionRule__AttributesAssignment_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAssignment_5()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4875:1: rule__TypeDefinitionRule__Group__6 : rule__TypeDefinitionRule__Group__6__Impl ;
    public final void rule__TypeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4879:1: ( rule__TypeDefinitionRule__Group__6__Impl )
            // InternalDataDescriptionLanguage.g:4880:2: rule__TypeDefinitionRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4886:1: rule__TypeDefinitionRule__Group__6__Impl : ( '}' ) ;
    public final void rule__TypeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4890:1: ( ( '}' ) )
            // InternalDataDescriptionLanguage.g:4891:1: ( '}' )
            {
            // InternalDataDescriptionLanguage.g:4891:1: ( '}' )
            // InternalDataDescriptionLanguage.g:4892:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getRightCurlyBracketKeyword_6()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4902:1: rule__TypeDefinitionRule__Group_3__0 : rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1 ;
    public final void rule__TypeDefinitionRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4906:1: ( rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:4907:2: rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1
            {
            pushFollow(FOLLOW_15);
            rule__TypeDefinitionRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4914:1: rule__TypeDefinitionRule__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__TypeDefinitionRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4918:1: ( ( 'extends' ) )
            // InternalDataDescriptionLanguage.g:4919:1: ( 'extends' )
            {
            // InternalDataDescriptionLanguage.g:4919:1: ( 'extends' )
            // InternalDataDescriptionLanguage.g:4920:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getExtendsKeyword_3_0()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getExtendsKeyword_3_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4929:1: rule__TypeDefinitionRule__Group_3__1 : rule__TypeDefinitionRule__Group_3__1__Impl ;
    public final void rule__TypeDefinitionRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4933:1: ( rule__TypeDefinitionRule__Group_3__1__Impl )
            // InternalDataDescriptionLanguage.g:4934:2: rule__TypeDefinitionRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:4940:1: rule__TypeDefinitionRule__Group_3__1__Impl : ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) ) ;
    public final void rule__TypeDefinitionRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4944:1: ( ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) ) )
            // InternalDataDescriptionLanguage.g:4945:1: ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4945:1: ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) )
            // InternalDataDescriptionLanguage.g:4946:2: ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeAssignment_3_1()); 
            }
            // InternalDataDescriptionLanguage.g:4947:2: ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 )
            // InternalDataDescriptionLanguage.g:4947:3: rule__TypeDefinitionRule__SuperTypeAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__SuperTypeAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeAssignment_3_1()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:4956:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4960:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4961:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:4968:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4972:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4973:1: ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4973:1: ( ( rule__AttributeDefinitionRule__NameAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4974:2: ( rule__AttributeDefinitionRule__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4975:2: ( rule__AttributeDefinitionRule__NameAssignment_0 )
            // InternalDataDescriptionLanguage.g:4975:3: rule__AttributeDefinitionRule__NameAssignment_0
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
    // InternalDataDescriptionLanguage.g:4983:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4987:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:4988:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_44);
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
    // InternalDataDescriptionLanguage.g:4995:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4999:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:5000:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:5000:1: ( ':' )
            // InternalDataDescriptionLanguage.g:5001:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5010:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5014:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:5015:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_45);
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
    // InternalDataDescriptionLanguage.g:5022:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5026:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:5027:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:5027:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:5028:2: ( rule__AttributeDefinitionRule__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:5029:2: ( rule__AttributeDefinitionRule__TypeAssignment_2 )
            // InternalDataDescriptionLanguage.g:5029:3: rule__AttributeDefinitionRule__TypeAssignment_2
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
    // InternalDataDescriptionLanguage.g:5037:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5041:1: ( rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:5042:2: rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_45);
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
    // InternalDataDescriptionLanguage.g:5049:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ( rule__AttributeDefinitionRule__Group_3__0 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5053:1: ( ( ( rule__AttributeDefinitionRule__Group_3__0 )? ) )
            // InternalDataDescriptionLanguage.g:5054:1: ( ( rule__AttributeDefinitionRule__Group_3__0 )? )
            {
            // InternalDataDescriptionLanguage.g:5054:1: ( ( rule__AttributeDefinitionRule__Group_3__0 )? )
            // InternalDataDescriptionLanguage.g:5055:2: ( rule__AttributeDefinitionRule__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:5056:2: ( rule__AttributeDefinitionRule__Group_3__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==76) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:5056:3: rule__AttributeDefinitionRule__Group_3__0
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
    // InternalDataDescriptionLanguage.g:5064:1: rule__AttributeDefinitionRule__Group__4 : rule__AttributeDefinitionRule__Group__4__Impl ;
    public final void rule__AttributeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5068:1: ( rule__AttributeDefinitionRule__Group__4__Impl )
            // InternalDataDescriptionLanguage.g:5069:2: rule__AttributeDefinitionRule__Group__4__Impl
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
    // InternalDataDescriptionLanguage.g:5075:1: rule__AttributeDefinitionRule__Group__4__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5079:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:5080:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:5080:1: ( ';' )
            // InternalDataDescriptionLanguage.g:5081:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_4()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5091:1: rule__AttributeDefinitionRule__Group_3__0 : rule__AttributeDefinitionRule__Group_3__0__Impl rule__AttributeDefinitionRule__Group_3__1 ;
    public final void rule__AttributeDefinitionRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5095:1: ( rule__AttributeDefinitionRule__Group_3__0__Impl rule__AttributeDefinitionRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:5096:2: rule__AttributeDefinitionRule__Group_3__0__Impl rule__AttributeDefinitionRule__Group_3__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDataDescriptionLanguage.g:5103:1: rule__AttributeDefinitionRule__Group_3__0__Impl : ( ':=' ) ;
    public final void rule__AttributeDefinitionRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5107:1: ( ( ':=' ) )
            // InternalDataDescriptionLanguage.g:5108:1: ( ':=' )
            {
            // InternalDataDescriptionLanguage.g:5108:1: ( ':=' )
            // InternalDataDescriptionLanguage.g:5109:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_3_0()); 
            }
            match(input,76,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5118:1: rule__AttributeDefinitionRule__Group_3__1 : rule__AttributeDefinitionRule__Group_3__1__Impl ;
    public final void rule__AttributeDefinitionRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5122:1: ( rule__AttributeDefinitionRule__Group_3__1__Impl )
            // InternalDataDescriptionLanguage.g:5123:2: rule__AttributeDefinitionRule__Group_3__1__Impl
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
    // InternalDataDescriptionLanguage.g:5129:1: rule__AttributeDefinitionRule__Group_3__1__Impl : ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5133:1: ( ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) ) )
            // InternalDataDescriptionLanguage.g:5134:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) )
            {
            // InternalDataDescriptionLanguage.g:5134:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 ) )
            // InternalDataDescriptionLanguage.g:5135:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_3_1()); 
            }
            // InternalDataDescriptionLanguage.g:5136:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_3_1 )
            // InternalDataDescriptionLanguage.g:5136:3: rule__AttributeDefinitionRule__InitialisationAssignment_3_1
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
    // InternalDataDescriptionLanguage.g:5145:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5149:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5150:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalDataDescriptionLanguage.g:5157:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5161:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5162:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5162:1: ( () )
            // InternalDataDescriptionLanguage.g:5163:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5164:2: ()
            // InternalDataDescriptionLanguage.g:5164:3: 
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
    // InternalDataDescriptionLanguage.g:5172:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5176:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5177:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5183:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5187:1: ( ( 'literal' ) )
            // InternalDataDescriptionLanguage.g:5188:1: ( 'literal' )
            {
            // InternalDataDescriptionLanguage.g:5188:1: ( 'literal' )
            // InternalDataDescriptionLanguage.g:5189:2: 'literal'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5199:1: rule__InstanceTypeRule__Group__0 : rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 ;
    public final void rule__InstanceTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5203:1: ( rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5204:2: rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalDataDescriptionLanguage.g:5211:1: rule__InstanceTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__InstanceTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5215:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5216:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5216:1: ( () )
            // InternalDataDescriptionLanguage.g:5217:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5218:2: ()
            // InternalDataDescriptionLanguage.g:5218:3: 
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
    // InternalDataDescriptionLanguage.g:5226:1: rule__InstanceTypeRule__Group__1 : rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 ;
    public final void rule__InstanceTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5230:1: ( rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 )
            // InternalDataDescriptionLanguage.g:5231:2: rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2
            {
            pushFollow(FOLLOW_15);
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
    // InternalDataDescriptionLanguage.g:5238:1: rule__InstanceTypeRule__Group__1__Impl : ( 'instance' ) ;
    public final void rule__InstanceTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5242:1: ( ( 'instance' ) )
            // InternalDataDescriptionLanguage.g:5243:1: ( 'instance' )
            {
            // InternalDataDescriptionLanguage.g:5243:1: ( 'instance' )
            // InternalDataDescriptionLanguage.g:5244:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 
            }
            match(input,78,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5253:1: rule__InstanceTypeRule__Group__2 : rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 ;
    public final void rule__InstanceTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5257:1: ( rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 )
            // InternalDataDescriptionLanguage.g:5258:2: rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3
            {
            pushFollow(FOLLOW_48);
            rule__InstanceTypeRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:5265:1: rule__InstanceTypeRule__Group__2__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) ;
    public final void rule__InstanceTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5269:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:5270:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:5270:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:5271:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:5272:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            // InternalDataDescriptionLanguage.g:5272:3: rule__InstanceTypeRule__DefinitionsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__DefinitionsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_2()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:5280:1: rule__InstanceTypeRule__Group__3 : rule__InstanceTypeRule__Group__3__Impl ;
    public final void rule__InstanceTypeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5284:1: ( rule__InstanceTypeRule__Group__3__Impl )
            // InternalDataDescriptionLanguage.g:5285:2: rule__InstanceTypeRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:5291:1: rule__InstanceTypeRule__Group__3__Impl : ( ( rule__InstanceTypeRule__Group_3__0 )* ) ;
    public final void rule__InstanceTypeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5295:1: ( ( ( rule__InstanceTypeRule__Group_3__0 )* ) )
            // InternalDataDescriptionLanguage.g:5296:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            {
            // InternalDataDescriptionLanguage.g:5296:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            // InternalDataDescriptionLanguage.g:5297:2: ( rule__InstanceTypeRule__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getGroup_3()); 
            }
            // InternalDataDescriptionLanguage.g:5298:2: ( rule__InstanceTypeRule__Group_3__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==79) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:5298:3: rule__InstanceTypeRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_49);
            	    rule__InstanceTypeRule__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getGroup_3()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:5307:1: rule__InstanceTypeRule__Group_3__0 : rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 ;
    public final void rule__InstanceTypeRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5311:1: ( rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 )
            // InternalDataDescriptionLanguage.g:5312:2: rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1
            {
            pushFollow(FOLLOW_15);
            rule__InstanceTypeRule__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:5319:1: rule__InstanceTypeRule__Group_3__0__Impl : ( '|' ) ;
    public final void rule__InstanceTypeRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5323:1: ( ( '|' ) )
            // InternalDataDescriptionLanguage.g:5324:1: ( '|' )
            {
            // InternalDataDescriptionLanguage.g:5324:1: ( '|' )
            // InternalDataDescriptionLanguage.g:5325:2: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0()); 
            }
            match(input,79,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:5334:1: rule__InstanceTypeRule__Group_3__1 : rule__InstanceTypeRule__Group_3__1__Impl ;
    public final void rule__InstanceTypeRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5338:1: ( rule__InstanceTypeRule__Group_3__1__Impl )
            // InternalDataDescriptionLanguage.g:5339:2: rule__InstanceTypeRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:5345:1: rule__InstanceTypeRule__Group_3__1__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) ;
    public final void rule__InstanceTypeRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5349:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) )
            // InternalDataDescriptionLanguage.g:5350:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            {
            // InternalDataDescriptionLanguage.g:5350:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            // InternalDataDescriptionLanguage.g:5351:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_3_1()); 
            }
            // InternalDataDescriptionLanguage.g:5352:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            // InternalDataDescriptionLanguage.g:5352:3: rule__InstanceTypeRule__DefinitionsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__InstanceTypeRule__DefinitionsAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_3_1()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:5361:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5365:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5366:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalDataDescriptionLanguage.g:5373:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5377:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5378:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5378:1: ( () )
            // InternalDataDescriptionLanguage.g:5379:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5380:2: ()
            // InternalDataDescriptionLanguage.g:5380:3: 
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
    // InternalDataDescriptionLanguage.g:5388:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5392:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5393:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5399:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5403:1: ( ( 'string' ) )
            // InternalDataDescriptionLanguage.g:5404:1: ( 'string' )
            {
            // InternalDataDescriptionLanguage.g:5404:1: ( 'string' )
            // InternalDataDescriptionLanguage.g:5405:2: 'string'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5415:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5419:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5420:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_51);
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
    // InternalDataDescriptionLanguage.g:5427:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5431:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5432:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5432:1: ( () )
            // InternalDataDescriptionLanguage.g:5433:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5434:2: ()
            // InternalDataDescriptionLanguage.g:5434:3: 
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
    // InternalDataDescriptionLanguage.g:5442:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5446:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5447:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5453:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5457:1: ( ( 'expression' ) )
            // InternalDataDescriptionLanguage.g:5458:1: ( 'expression' )
            {
            // InternalDataDescriptionLanguage.g:5458:1: ( 'expression' )
            // InternalDataDescriptionLanguage.g:5459:2: 'expression'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            }
            match(input,80,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5469:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5473:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5474:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_52);
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
    // InternalDataDescriptionLanguage.g:5481:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5485:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5486:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5486:1: ( () )
            // InternalDataDescriptionLanguage.g:5487:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5488:2: ()
            // InternalDataDescriptionLanguage.g:5488:3: 
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
    // InternalDataDescriptionLanguage.g:5496:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5500:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5501:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5507:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5511:1: ( ( 'int' ) )
            // InternalDataDescriptionLanguage.g:5512:1: ( 'int' )
            {
            // InternalDataDescriptionLanguage.g:5512:1: ( 'int' )
            // InternalDataDescriptionLanguage.g:5513:2: 'int'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            }
            match(input,81,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__FloatTypeRule__Group__0"
    // InternalDataDescriptionLanguage.g:5523:1: rule__FloatTypeRule__Group__0 : rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 ;
    public final void rule__FloatTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5527:1: ( rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5528:2: rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1
            {
            pushFollow(FOLLOW_53);
            rule__FloatTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FloatTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:5535:1: rule__FloatTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__FloatTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5539:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5540:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5540:1: ( () )
            // InternalDataDescriptionLanguage.g:5541:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5542:2: ()
            // InternalDataDescriptionLanguage.g:5542:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0()); 
            }

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
    // InternalDataDescriptionLanguage.g:5550:1: rule__FloatTypeRule__Group__1 : rule__FloatTypeRule__Group__1__Impl ;
    public final void rule__FloatTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5554:1: ( rule__FloatTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5555:2: rule__FloatTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FloatTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:5561:1: rule__FloatTypeRule__Group__1__Impl : ( 'float' ) ;
    public final void rule__FloatTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5565:1: ( ( 'float' ) )
            // InternalDataDescriptionLanguage.g:5566:1: ( 'float' )
            {
            // InternalDataDescriptionLanguage.g:5566:1: ( 'float' )
            // InternalDataDescriptionLanguage.g:5567:2: 'float'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFloatTypeRuleAccess().getFloatKeyword_1()); 
            }
            match(input,82,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFloatTypeRuleAccess().getFloatKeyword_1()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:5577:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5581:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5582:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_54);
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
    // InternalDataDescriptionLanguage.g:5589:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5593:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5594:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5594:1: ( () )
            // InternalDataDescriptionLanguage.g:5595:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5596:2: ()
            // InternalDataDescriptionLanguage.g:5596:3: 
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
    // InternalDataDescriptionLanguage.g:5604:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5608:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5609:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5615:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5619:1: ( ( 'boolean' ) )
            // InternalDataDescriptionLanguage.g:5620:1: ( 'boolean' )
            {
            // InternalDataDescriptionLanguage.g:5620:1: ( 'boolean' )
            // InternalDataDescriptionLanguage.g:5621:2: 'boolean'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5631:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5635:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5636:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_55);
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
    // InternalDataDescriptionLanguage.g:5643:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5647:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5648:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5648:1: ( () )
            // InternalDataDescriptionLanguage.g:5649:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5650:2: ()
            // InternalDataDescriptionLanguage.g:5650:3: 
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
    // InternalDataDescriptionLanguage.g:5658:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5662:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5663:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5669:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5673:1: ( ( 'void' ) )
            // InternalDataDescriptionLanguage.g:5674:1: ( 'void' )
            {
            // InternalDataDescriptionLanguage.g:5674:1: ( 'void' )
            // InternalDataDescriptionLanguage.g:5675:2: 'void'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            }
            match(input,83,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__DataTypeRule__Group__0"
    // InternalDataDescriptionLanguage.g:5685:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5689:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5690:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalDataDescriptionLanguage.g:5697:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5701:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5702:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5702:1: ( () )
            // InternalDataDescriptionLanguage.g:5703:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5704:2: ()
            // InternalDataDescriptionLanguage.g:5704:3: 
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
    // InternalDataDescriptionLanguage.g:5712:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5716:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5717:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5723:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5727:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:5728:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:5728:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:5729:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5739:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5743:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5744:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalDataDescriptionLanguage.g:5751:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5755:1: ( ( 'array' ) )
            // InternalDataDescriptionLanguage.g:5756:1: ( 'array' )
            {
            // InternalDataDescriptionLanguage.g:5756:1: ( 'array' )
            // InternalDataDescriptionLanguage.g:5757:2: 'array'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            }
            match(input,84,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5766:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5770:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5771:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5777:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5781:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:5782:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:5782:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:5783:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:5784:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalDataDescriptionLanguage.g:5784:3: rule__ArrayTypeRule__ElementsAssignment_1
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
    // InternalDataDescriptionLanguage.g:5793:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5797:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5798:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalDataDescriptionLanguage.g:5805:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5809:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:5810:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:5810:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:5811:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:5812:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalDataDescriptionLanguage.g:5812:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalDataDescriptionLanguage.g:5820:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5824:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5825:2: rule__ParameterRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5831:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5835:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:5836:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:5836:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:5837:2: ( rule__ParameterRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:5838:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalDataDescriptionLanguage.g:5838:3: rule__ParameterRule__NameAssignment_1
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


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalDataDescriptionLanguage.g:5847:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5851:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDataDescriptionLanguage.g:5852:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_56);
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
    // InternalDataDescriptionLanguage.g:5859:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5863:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:5864:1: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:5864:1: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:5865:2: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:5874:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5878:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5879:2: rule__QualifiedName__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5885:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5889:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:5890:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:5890:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:5891:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:5892:2: ( rule__QualifiedName__Group_1__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==85) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:5892:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_57);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop48;
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
    // InternalDataDescriptionLanguage.g:5901:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5905:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDataDescriptionLanguage.g:5906:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalDataDescriptionLanguage.g:5913:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5917:1: ( ( '.' ) )
            // InternalDataDescriptionLanguage.g:5918:1: ( '.' )
            {
            // InternalDataDescriptionLanguage.g:5918:1: ( '.' )
            // InternalDataDescriptionLanguage.g:5919:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,85,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5928:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5932:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:5933:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:5939:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5943:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:5944:1: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:5944:1: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:5945:2: ruleStringOrId
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


    // $ANTLR start "rule__DataDescriptionModelRule__UsesAssignment_1"
    // InternalDataDescriptionLanguage.g:5955:1: rule__DataDescriptionModelRule__UsesAssignment_1 : ( ruleUseRule ) ;
    public final void rule__DataDescriptionModelRule__UsesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5959:1: ( ( ruleUseRule ) )
            // InternalDataDescriptionLanguage.g:5960:2: ( ruleUseRule )
            {
            // InternalDataDescriptionLanguage.g:5960:2: ( ruleUseRule )
            // InternalDataDescriptionLanguage.g:5961:3: ruleUseRule
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
    // InternalDataDescriptionLanguage.g:5970:1: rule__DataDescriptionModelRule__TypesAssignment_2_2 : ( ruleDataTypeDefinitionRule ) ;
    public final void rule__DataDescriptionModelRule__TypesAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5974:1: ( ( ruleDataTypeDefinitionRule ) )
            // InternalDataDescriptionLanguage.g:5975:2: ( ruleDataTypeDefinitionRule )
            {
            // InternalDataDescriptionLanguage.g:5975:2: ( ruleDataTypeDefinitionRule )
            // InternalDataDescriptionLanguage.g:5976:3: ruleDataTypeDefinitionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesDataTypeDefinitionRuleParserRuleCall_2_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDataTypeDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getTypesDataTypeDefinitionRuleParserRuleCall_2_2_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:5985:1: rule__DataDescriptionModelRule__DescriptionsAssignment_3_2 : ( ruleDataDescriptionRule ) ;
    public final void rule__DataDescriptionModelRule__DescriptionsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5989:1: ( ( ruleDataDescriptionRule ) )
            // InternalDataDescriptionLanguage.g:5990:2: ( ruleDataDescriptionRule )
            {
            // InternalDataDescriptionLanguage.g:5990:2: ( ruleDataDescriptionRule )
            // InternalDataDescriptionLanguage.g:5991:3: ruleDataDescriptionRule
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
    // InternalDataDescriptionLanguage.g:6000:1: rule__DataDescriptionModelRule__ConstraintsAssignment_4_2 : ( ruleStatementRule ) ;
    public final void rule__DataDescriptionModelRule__ConstraintsAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6004:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:6005:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:6005:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:6006:3: ruleStatementRule
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
    // InternalDataDescriptionLanguage.g:6015:1: rule__UseRule__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__UseRule__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6019:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:6020:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:6020:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:6021:3: RULE_STRING
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


    // $ANTLR start "rule__DataTypeDefinitionRule__ScaleAssignment_0"
    // InternalDataDescriptionLanguage.g:6030:1: rule__DataTypeDefinitionRule__ScaleAssignment_0 : ( ruleScaleType ) ;
    public final void rule__DataTypeDefinitionRule__ScaleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6034:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:6035:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:6035:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:6036:3: ruleScaleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getScaleScaleTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleScaleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getScaleScaleTypeEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__ScaleAssignment_0"


    // $ANTLR start "rule__DataTypeDefinitionRule__NameAssignment_2"
    // InternalDataDescriptionLanguage.g:6045:1: rule__DataTypeDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__DataTypeDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6049:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:6050:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:6050:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:6051:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__NameAssignment_2"


    // $ANTLR start "rule__DataTypeDefinitionRule__DescriptionAssignment_3_2"
    // InternalDataDescriptionLanguage.g:6060:1: rule__DataTypeDefinitionRule__DescriptionAssignment_3_2 : ( RULE_STRING ) ;
    public final void rule__DataTypeDefinitionRule__DescriptionAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6064:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:6065:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:6065:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:6066:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getDescriptionSTRINGTerminalRuleCall_3_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getDescriptionSTRINGTerminalRuleCall_3_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__DescriptionAssignment_3_2"


    // $ANTLR start "rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3"
    // InternalDataDescriptionLanguage.g:6075:1: rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3 : ( ruleStatementRule ) ;
    public final void rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6079:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:6080:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:6080:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:6081:3: ruleStatementRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinitionRule__ConstraintsAssignment_4_3"


    // $ANTLR start "rule__TypedDataDescriptionRule__RepresentationAssignment_0"
    // InternalDataDescriptionLanguage.g:6090:1: rule__TypedDataDescriptionRule__RepresentationAssignment_0 : ( ruleRepresentationType ) ;
    public final void rule__TypedDataDescriptionRule__RepresentationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6094:1: ( ( ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:6095:2: ( ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:6095:2: ( ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:6096:3: ruleRepresentationType
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
    // InternalDataDescriptionLanguage.g:6105:1: rule__TypedDataDescriptionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__TypedDataDescriptionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6109:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:6110:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:6110:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:6111:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:6120:1: rule__TypedDataDescriptionRule__TypeAssignment_5 : ( ( ruleStringOrId ) ) ;
    public final void rule__TypedDataDescriptionRule__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6124:1: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:6125:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:6125:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:6126:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeDefinitionCrossReference_5_0()); 
            }
            // InternalDataDescriptionLanguage.g:6127:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:6128:4: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeDefinitionStringOrIdParserRuleCall_5_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeDefinitionStringOrIdParserRuleCall_5_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeDefinitionCrossReference_5_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:6139:1: rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3 : ( ruleStatementRule ) ;
    public final void rule__TypedDataDescriptionRule__ConstraintsAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6143:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:6144:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:6144:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:6145:3: ruleStatementRule
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
    // InternalDataDescriptionLanguage.g:6154:1: rule__UntypedDataDescriptionRule__ScaleAssignment_0 : ( ruleScaleType ) ;
    public final void rule__UntypedDataDescriptionRule__ScaleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6158:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:6159:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:6159:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:6160:3: ruleScaleType
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
    // InternalDataDescriptionLanguage.g:6169:1: rule__UntypedDataDescriptionRule__RepresentationAssignment_1 : ( ruleRepresentationType ) ;
    public final void rule__UntypedDataDescriptionRule__RepresentationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6173:1: ( ( ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:6174:2: ( ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:6174:2: ( ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:6175:3: ruleRepresentationType
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
    // InternalDataDescriptionLanguage.g:6184:1: rule__UntypedDataDescriptionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__UntypedDataDescriptionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6188:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:6189:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:6189:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:6190:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:6199:1: rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3 : ( ruleStatementRule ) ;
    public final void rule__UntypedDataDescriptionRule__ConstraintsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6203:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:6204:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:6204:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:6205:3: ruleStatementRule
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


    // $ANTLR start "rule__DataReferenceRule__DefinitionAssignment"
    // InternalDataDescriptionLanguage.g:6214:1: rule__DataReferenceRule__DefinitionAssignment : ( ( ruleStringOrId ) ) ;
    public final void rule__DataReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6218:1: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:6219:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:6219:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:6220:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_0()); 
            }
            // InternalDataDescriptionLanguage.g:6221:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:6222:4: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:6233:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6237:1: ( ( ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6238:2: ( ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6238:2: ( ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:6239:3: ruleXorExpressionRule
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
    // InternalDataDescriptionLanguage.g:6248:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6252:1: ( ( ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6253:2: ( ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6253:2: ( ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:6254:3: ruleXorExpressionRule
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
    // InternalDataDescriptionLanguage.g:6263:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6267:1: ( ( ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6268:2: ( ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6268:2: ( ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:6269:3: ruleAndExpressionRule
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
    // InternalDataDescriptionLanguage.g:6278:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6282:1: ( ( ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6283:2: ( ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6283:2: ( ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:6284:3: ruleAndExpressionRule
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
    // InternalDataDescriptionLanguage.g:6293:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6297:1: ( ( ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6298:2: ( ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6298:2: ( ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:6299:3: ruleNotExpressionRule
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
    // InternalDataDescriptionLanguage.g:6308:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6312:1: ( ( ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6313:2: ( ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6313:2: ( ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:6314:3: ruleNotExpressionRule
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
    // InternalDataDescriptionLanguage.g:6323:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6327:1: ( ( ( '!' ) ) )
            // InternalDataDescriptionLanguage.g:6328:2: ( ( '!' ) )
            {
            // InternalDataDescriptionLanguage.g:6328:2: ( ( '!' ) )
            // InternalDataDescriptionLanguage.g:6329:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:6330:3: ( '!' )
            // InternalDataDescriptionLanguage.g:6331:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,86,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6342:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6346:1: ( ( ruleComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6347:2: ( ruleComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6347:2: ( ruleComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:6348:3: ruleComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:6357:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6361:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6362:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6362:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:6363:3: ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:6372:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6376:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6377:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6377:2: ( rulePartialComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:6378:3: rulePartialComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:6387:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6391:1: ( ( ruleComparisonOperatorRule ) )
            // InternalDataDescriptionLanguage.g:6392:2: ( ruleComparisonOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:6392:2: ( ruleComparisonOperatorRule )
            // InternalDataDescriptionLanguage.g:6393:3: ruleComparisonOperatorRule
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
    // InternalDataDescriptionLanguage.g:6402:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6406:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6407:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6407:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:6408:3: ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:6417:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6421:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6422:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6422:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:6423:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDataDescriptionLanguage.g:6432:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6436:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDataDescriptionLanguage.g:6437:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:6437:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDataDescriptionLanguage.g:6438:3: ruleAddOrSubtractOperatorRule
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
    // InternalDataDescriptionLanguage.g:6447:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6451:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6452:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6452:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:6453:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDataDescriptionLanguage.g:6462:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6466:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6467:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6467:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:6468:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:6477:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6481:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalDataDescriptionLanguage.g:6482:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:6482:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalDataDescriptionLanguage.g:6483:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalDataDescriptionLanguage.g:6492:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6496:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6497:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6497:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:6498:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:6507:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6511:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6512:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6512:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:6513:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:6522:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6526:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6527:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6527:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:6528:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:6537:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6541:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDataDescriptionLanguage.g:6542:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:6542:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDataDescriptionLanguage.g:6543:3: ruleAddOrSubtractOperatorRule
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
    // InternalDataDescriptionLanguage.g:6552:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleLiteralOrReferenceRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6556:1: ( ( ruleLiteralOrReferenceRule ) )
            // InternalDataDescriptionLanguage.g:6557:2: ( ruleLiteralOrReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:6557:2: ( ruleLiteralOrReferenceRule )
            // InternalDataDescriptionLanguage.g:6558:3: ruleLiteralOrReferenceRule
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
    // InternalDataDescriptionLanguage.g:6567:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6571:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6572:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6572:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:6573:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:6582:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6586:1: ( ( ruleFunctionNameRule ) )
            // InternalDataDescriptionLanguage.g:6587:2: ( ruleFunctionNameRule )
            {
            // InternalDataDescriptionLanguage.g:6587:2: ( ruleFunctionNameRule )
            // InternalDataDescriptionLanguage.g:6588:3: ruleFunctionNameRule
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
    // InternalDataDescriptionLanguage.g:6597:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6601:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6602:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6602:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:6603:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:6612:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6616:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6617:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6617:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:6618:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:6627:1: rule__ConstantReferenceRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__ConstantReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6631:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:6632:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:6632:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:6633:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantReferenceRuleAccess().getDefinitionConstantDefinitionCrossReference_0()); 
            }
            // InternalDataDescriptionLanguage.g:6634:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:6635:4: ruleQualifiedName
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


    // $ANTLR start "rule__DoubleLiteralRule__LiteralAssignment_0"
    // InternalDataDescriptionLanguage.g:6646:1: rule__DoubleLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__DoubleLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6650:1: ( ( RULE_DOUBLE ) )
            // InternalDataDescriptionLanguage.g:6651:2: ( RULE_DOUBLE )
            {
            // InternalDataDescriptionLanguage.g:6651:2: ( RULE_DOUBLE )
            // InternalDataDescriptionLanguage.g:6652:3: RULE_DOUBLE
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
    // InternalDataDescriptionLanguage.g:6661:1: rule__DoubleLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__DoubleLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6665:1: ( ( ruleFactorRule ) )
            // InternalDataDescriptionLanguage.g:6666:2: ( ruleFactorRule )
            {
            // InternalDataDescriptionLanguage.g:6666:2: ( ruleFactorRule )
            // InternalDataDescriptionLanguage.g:6667:3: ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:6676:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6680:1: ( ( RULE_INT ) )
            // InternalDataDescriptionLanguage.g:6681:2: ( RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:6681:2: ( RULE_INT )
            // InternalDataDescriptionLanguage.g:6682:3: RULE_INT
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
    // InternalDataDescriptionLanguage.g:6691:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6695:1: ( ( ruleFactorRule ) )
            // InternalDataDescriptionLanguage.g:6696:2: ( ruleFactorRule )
            {
            // InternalDataDescriptionLanguage.g:6696:2: ( ruleFactorRule )
            // InternalDataDescriptionLanguage.g:6697:3: ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:6706:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6710:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:6711:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:6711:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:6712:3: RULE_STRING
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
    // InternalDataDescriptionLanguage.g:6721:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6725:1: ( ( ( 'true' ) ) )
            // InternalDataDescriptionLanguage.g:6726:2: ( ( 'true' ) )
            {
            // InternalDataDescriptionLanguage.g:6726:2: ( ( 'true' ) )
            // InternalDataDescriptionLanguage.g:6727:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:6728:3: ( 'true' )
            // InternalDataDescriptionLanguage.g:6729:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            match(input,87,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__TypeDefinitionRule__AbstractAssignment_0"
    // InternalDataDescriptionLanguage.g:6740:1: rule__TypeDefinitionRule__AbstractAssignment_0 : ( ( 'abstract' ) ) ;
    public final void rule__TypeDefinitionRule__AbstractAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6744:1: ( ( ( 'abstract' ) ) )
            // InternalDataDescriptionLanguage.g:6745:2: ( ( 'abstract' ) )
            {
            // InternalDataDescriptionLanguage.g:6745:2: ( ( 'abstract' ) )
            // InternalDataDescriptionLanguage.g:6746:3: ( 'abstract' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:6747:3: ( 'abstract' )
            // InternalDataDescriptionLanguage.g:6748:4: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 
            }
            match(input,88,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:6759:1: rule__TypeDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__TypeDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6763:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:6764:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:6764:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:6765:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:6774:1: rule__TypeDefinitionRule__SuperTypeAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TypeDefinitionRule__SuperTypeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6778:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:6779:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:6779:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:6780:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionCrossReference_3_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:6781:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:6782:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionCrossReference_3_1_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:6793:1: rule__TypeDefinitionRule__AttributesAssignment_5 : ( ruleAttributeDefinitionRule ) ;
    public final void rule__TypeDefinitionRule__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6797:1: ( ( ruleAttributeDefinitionRule ) )
            // InternalDataDescriptionLanguage.g:6798:2: ( ruleAttributeDefinitionRule )
            {
            // InternalDataDescriptionLanguage.g:6798:2: ( ruleAttributeDefinitionRule )
            // InternalDataDescriptionLanguage.g:6799:3: ruleAttributeDefinitionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAttributeDefinitionRuleParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAttributeDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAttributeDefinitionRuleParserRuleCall_5_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:6808:1: rule__AttributeDefinitionRule__NameAssignment_0 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6812:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:6813:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:6813:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:6814:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:6823:1: rule__AttributeDefinitionRule__TypeAssignment_2 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6827:1: ( ( ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:6828:2: ( ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:6828:2: ( ruleTypeRule )
            // InternalDataDescriptionLanguage.g:6829:3: ruleTypeRule
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
    // InternalDataDescriptionLanguage.g:6838:1: rule__AttributeDefinitionRule__InitialisationAssignment_3_1 : ( ruleExpressionRule ) ;
    public final void rule__AttributeDefinitionRule__InitialisationAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6842:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:6843:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:6843:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:6844:3: ruleExpressionRule
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


    // $ANTLR start "rule__InstanceTypeRule__DefinitionsAssignment_2"
    // InternalDataDescriptionLanguage.g:6853:1: rule__InstanceTypeRule__DefinitionsAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6857:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:6858:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:6858:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:6859:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_2_0()); 
            }
            // InternalDataDescriptionLanguage.g:6860:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:6861:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionQualifiedNameParserRuleCall_2_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionQualifiedNameParserRuleCall_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_2_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:6872:1: rule__InstanceTypeRule__DefinitionsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6876:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:6877:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:6877:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:6878:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_3_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:6879:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:6880:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_3_1_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:6891:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6895:1: ( ( ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:6896:2: ( ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:6896:2: ( ruleTypeRule )
            // InternalDataDescriptionLanguage.g:6897:3: ruleTypeRule
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
    // InternalDataDescriptionLanguage.g:6906:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6910:1: ( ( ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:6911:2: ( ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:6911:2: ( ruleTypeRule )
            // InternalDataDescriptionLanguage.g:6912:3: ruleTypeRule
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
    // InternalDataDescriptionLanguage.g:6921:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6925:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:6926:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:6926:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:6927:3: ruleStringOrId
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


    // $ANTLR start "rule__FunctionNameRule__DefinitionAssignment"
    // InternalDataDescriptionLanguage.g:6936:1: rule__FunctionNameRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__FunctionNameRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6940:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:6941:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:6941:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:6942:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
            }
            // InternalDataDescriptionLanguage.g:6943:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:6944:4: ruleQualifiedName
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

    // $ANTLR start synpred2_InternalDataDescriptionLanguage
    public final void synpred2_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        // InternalDataDescriptionLanguage.g:1376:2: ( ( ruleConstantReferenceRule ) )
        // InternalDataDescriptionLanguage.g:1376:2: ( ruleConstantReferenceRule )
        {
        // InternalDataDescriptionLanguage.g:1376:2: ( ruleConstantReferenceRule )
        // InternalDataDescriptionLanguage.g:1377:3: ruleConstantReferenceRule
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getValueReferenceRuleAccess().getConstantReferenceRuleParserRuleCall_0()); 
        }
        pushFollow(FOLLOW_2);
        ruleConstantReferenceRule();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalDataDescriptionLanguage

    // $ANTLR start synpred3_InternalDataDescriptionLanguage
    public final void synpred3_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        // InternalDataDescriptionLanguage.g:1382:2: ( ( ruleDataReferenceRule ) )
        // InternalDataDescriptionLanguage.g:1382:2: ( ruleDataReferenceRule )
        {
        // InternalDataDescriptionLanguage.g:1382:2: ( ruleDataReferenceRule )
        // InternalDataDescriptionLanguage.g:1383:3: ruleDataReferenceRule
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getValueReferenceRuleAccess().getDataReferenceRuleParserRuleCall_1()); 
        }
        pushFollow(FOLLOW_2);
        ruleDataReferenceRule();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalDataDescriptionLanguage

    // Delegated rules

    public final boolean synpred3_InternalDataDescriptionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalDataDescriptionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalDataDescriptionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalDataDescriptionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA3 dfa3 = new DFA3(this);
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
            return "1350:1: rule__DataDescriptionRule__Alternatives : ( ( ruleTypedDataDescriptionRule ) | ( ruleUntypedDataDescriptionRule ) );";
        }
    }
    static final String dfa_7s = "\1\uffff\2\5\5\uffff\2\5";
    static final String dfa_8s = "\1\4\2\30\3\uffff\1\4\1\uffff\2\30";
    static final String dfa_9s = "\1\127\2\125\3\uffff\1\5\1\uffff\2\125";
    static final String dfa_10s = "\3\uffff\1\2\1\3\1\4\1\uffff\1\1\2\uffff";
    static final String[] dfa_11s = {
            "\1\1\1\2\3\3\6\uffff\1\3\61\uffff\1\5\4\uffff\1\4\20\uffff\1\3",
            "\13\5\31\uffff\1\5\5\uffff\4\5\1\7\2\5\14\uffff\1\6",
            "\13\5\31\uffff\1\5\5\uffff\4\5\1\7\2\5\14\uffff\1\6",
            "",
            "",
            "",
            "\1\10\1\11",
            "",
            "\13\5\31\uffff\1\5\5\uffff\4\5\1\7\2\5\14\uffff\1\6",
            "\13\5\31\uffff\1\5\5\uffff\4\5\1\7\2\5\14\uffff\1\6"
    };
    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[][] dfa_11 = unpackEncodedStringArray(dfa_11s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_5;
            this.transition = dfa_11;
        }
        public String getDescription() {
            return "1398:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );";
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
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000C00081F0L,0x0000000000C00042L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000C00081F2L,0x0000000000C00042L});
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
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00000000C00081F0L,0x0000000000C000C2L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x007FFFF800000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00000000000081C0L,0x0000000000800000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000400L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0200000000C00000L,0x00000000001F6000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x1000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});

}
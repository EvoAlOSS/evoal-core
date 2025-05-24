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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'real'", "'integer'", "'boolean'", "'string'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'module'", "'{'", "'}'", "'types'", "':'", "'data'", "'constraints'", "'type'", "';'", "'with'", "'enum'", "'('", "')'", "','", "'of'", "'instance'", "'value'", "'OR'", "'XOR'", "'AND'", "'^'", "'['", "']'", "':='", "'@'", "'literal'", "'expression'", "'int'", "'void'", "'array'", "'import'", "'from'", "'.'", "'!'", "'true'"
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
    public static final int T__88=88;
    public static final int T__45=45;
    public static final int T__89=89;
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


    // $ANTLR start "entryRuleDataTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:80:1: entryRuleDataTypeDefinitionRule : ruleDataTypeDefinitionRule EOF ;
    public final void entryRuleDataTypeDefinitionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:81:1: ( ruleDataTypeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:82:1: ruleDataTypeDefinitionRule EOF
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
    // InternalDataDescriptionLanguage.g:89:1: ruleDataTypeDefinitionRule : ( ( rule__DataTypeDefinitionRule__Alternatives ) ) ;
    public final void ruleDataTypeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:93:2: ( ( ( rule__DataTypeDefinitionRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:94:2: ( ( rule__DataTypeDefinitionRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:94:2: ( ( rule__DataTypeDefinitionRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:95:3: ( rule__DataTypeDefinitionRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeDefinitionRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:96:3: ( rule__DataTypeDefinitionRule__Alternatives )
            // InternalDataDescriptionLanguage.g:96:4: rule__DataTypeDefinitionRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinitionRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataTypeDefinitionRuleAccess().getAlternatives()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleBaseDataTypeTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:105:1: entryRuleBaseDataTypeTypeDefinitionRule : ruleBaseDataTypeTypeDefinitionRule EOF ;
    public final void entryRuleBaseDataTypeTypeDefinitionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:106:1: ( ruleBaseDataTypeTypeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:107:1: ruleBaseDataTypeTypeDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBaseDataTypeTypeDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBaseDataTypeTypeDefinitionRule"


    // $ANTLR start "ruleBaseDataTypeTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:114:1: ruleBaseDataTypeTypeDefinitionRule : ( ( rule__BaseDataTypeTypeDefinitionRule__Group__0 ) ) ;
    public final void ruleBaseDataTypeTypeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:118:2: ( ( ( rule__BaseDataTypeTypeDefinitionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:119:2: ( ( rule__BaseDataTypeTypeDefinitionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:119:2: ( ( rule__BaseDataTypeTypeDefinitionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:120:3: ( rule__BaseDataTypeTypeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:121:3: ( rule__BaseDataTypeTypeDefinitionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:121:4: rule__BaseDataTypeTypeDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBaseDataTypeTypeDefinitionRule"


    // $ANTLR start "entryRuleEnumLiteralRule"
    // InternalDataDescriptionLanguage.g:130:1: entryRuleEnumLiteralRule : ruleEnumLiteralRule EOF ;
    public final void entryRuleEnumLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:131:1: ( ruleEnumLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:132:1: ruleEnumLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEnumLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumLiteralRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumLiteralRule"


    // $ANTLR start "ruleEnumLiteralRule"
    // InternalDataDescriptionLanguage.g:139:1: ruleEnumLiteralRule : ( ( rule__EnumLiteralRule__NameAssignment ) ) ;
    public final void ruleEnumLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:143:2: ( ( ( rule__EnumLiteralRule__NameAssignment ) ) )
            // InternalDataDescriptionLanguage.g:144:2: ( ( rule__EnumLiteralRule__NameAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:144:2: ( ( rule__EnumLiteralRule__NameAssignment ) )
            // InternalDataDescriptionLanguage.g:145:3: ( rule__EnumLiteralRule__NameAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumLiteralRuleAccess().getNameAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:146:3: ( rule__EnumLiteralRule__NameAssignment )
            // InternalDataDescriptionLanguage.g:146:4: rule__EnumLiteralRule__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__EnumLiteralRule__NameAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumLiteralRuleAccess().getNameAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumLiteralRule"


    // $ANTLR start "entryRuleEnumTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:155:1: entryRuleEnumTypeDefinitionRule : ruleEnumTypeDefinitionRule EOF ;
    public final void entryRuleEnumTypeDefinitionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:156:1: ( ruleEnumTypeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:157:1: ruleEnumTypeDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEnumTypeDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumTypeDefinitionRule"


    // $ANTLR start "ruleEnumTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:164:1: ruleEnumTypeDefinitionRule : ( ( rule__EnumTypeDefinitionRule__Group__0 ) ) ;
    public final void ruleEnumTypeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:168:2: ( ( ( rule__EnumTypeDefinitionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:169:2: ( ( rule__EnumTypeDefinitionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:169:2: ( ( rule__EnumTypeDefinitionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:170:3: ( rule__EnumTypeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:171:3: ( rule__EnumTypeDefinitionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:171:4: rule__EnumTypeDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumTypeDefinitionRule"


    // $ANTLR start "entryRuleDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:180:1: entryRuleDataDescriptionRule : ruleDataDescriptionRule EOF ;
    public final void entryRuleDataDescriptionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:181:1: ( ruleDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:182:1: ruleDataDescriptionRule EOF
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
    // InternalDataDescriptionLanguage.g:189:1: ruleDataDescriptionRule : ( ( rule__DataDescriptionRule__Alternatives ) ) ;
    public final void ruleDataDescriptionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:193:2: ( ( ( rule__DataDescriptionRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:194:2: ( ( rule__DataDescriptionRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:194:2: ( ( rule__DataDescriptionRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:195:3: ( rule__DataDescriptionRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:196:3: ( rule__DataDescriptionRule__Alternatives )
            // InternalDataDescriptionLanguage.g:196:4: rule__DataDescriptionRule__Alternatives
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


    // $ANTLR start "entryRuleTypedBaseDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:205:1: entryRuleTypedBaseDataDescriptionRule : ruleTypedBaseDataDescriptionRule EOF ;
    public final void entryRuleTypedBaseDataDescriptionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:206:1: ( ruleTypedBaseDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:207:1: ruleTypedBaseDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypedBaseDataDescriptionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypedBaseDataDescriptionRule"


    // $ANTLR start "ruleTypedBaseDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:214:1: ruleTypedBaseDataDescriptionRule : ( ( rule__TypedBaseDataDescriptionRule__Group__0 ) ) ;
    public final void ruleTypedBaseDataDescriptionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:218:2: ( ( ( rule__TypedBaseDataDescriptionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:219:2: ( ( rule__TypedBaseDataDescriptionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:219:2: ( ( rule__TypedBaseDataDescriptionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:220:3: ( rule__TypedBaseDataDescriptionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:221:3: ( rule__TypedBaseDataDescriptionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:221:4: rule__TypedBaseDataDescriptionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypedBaseDataDescriptionRule"


    // $ANTLR start "entryRuleUntypedBaseDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:230:1: entryRuleUntypedBaseDataDescriptionRule : ruleUntypedBaseDataDescriptionRule EOF ;
    public final void entryRuleUntypedBaseDataDescriptionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:231:1: ( ruleUntypedBaseDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:232:1: ruleUntypedBaseDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleUntypedBaseDataDescriptionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUntypedBaseDataDescriptionRule"


    // $ANTLR start "ruleUntypedBaseDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:239:1: ruleUntypedBaseDataDescriptionRule : ( ( rule__UntypedBaseDataDescriptionRule__Group__0 ) ) ;
    public final void ruleUntypedBaseDataDescriptionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:243:2: ( ( ( rule__UntypedBaseDataDescriptionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:244:2: ( ( rule__UntypedBaseDataDescriptionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:244:2: ( ( rule__UntypedBaseDataDescriptionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:245:3: ( rule__UntypedBaseDataDescriptionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:246:3: ( rule__UntypedBaseDataDescriptionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:246:4: rule__UntypedBaseDataDescriptionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUntypedBaseDataDescriptionRule"


    // $ANTLR start "entryRuleStructuredDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:255:1: entryRuleStructuredDataDescriptionRule : ruleStructuredDataDescriptionRule EOF ;
    public final void entryRuleStructuredDataDescriptionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:256:1: ( ruleStructuredDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:257:1: ruleStructuredDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStructuredDataDescriptionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStructuredDataDescriptionRule"


    // $ANTLR start "ruleStructuredDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:264:1: ruleStructuredDataDescriptionRule : ( ( rule__StructuredDataDescriptionRule__Group__0 ) ) ;
    public final void ruleStructuredDataDescriptionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:268:2: ( ( ( rule__StructuredDataDescriptionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:269:2: ( ( rule__StructuredDataDescriptionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:269:2: ( ( rule__StructuredDataDescriptionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:270:3: ( rule__StructuredDataDescriptionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:271:3: ( rule__StructuredDataDescriptionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:271:4: rule__StructuredDataDescriptionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStructuredDataDescriptionRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalDataDescriptionLanguage.g:280:1: entryRuleStatementRule : ruleStatementRule EOF ;
    public final void entryRuleStatementRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:281:1: ( ruleStatementRule EOF )
            // InternalDataDescriptionLanguage.g:282:1: ruleStatementRule EOF
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
    // InternalDataDescriptionLanguage.g:289:1: ruleStatementRule : ( ( rule__StatementRule__Group__0 ) ) ;
    public final void ruleStatementRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:293:2: ( ( ( rule__StatementRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:294:2: ( ( rule__StatementRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:294:2: ( ( rule__StatementRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:295:3: ( rule__StatementRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:296:3: ( rule__StatementRule__Group__0 )
            // InternalDataDescriptionLanguage.g:296:4: rule__StatementRule__Group__0
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


    // $ANTLR start "entryRuleReferenceRule"
    // InternalDataDescriptionLanguage.g:305:1: entryRuleReferenceRule : ruleReferenceRule EOF ;
    public final void entryRuleReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:306:1: ( ruleReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:307:1: ruleReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:314:1: ruleReferenceRule : ( ( rule__ReferenceRule__Alternatives ) ) ;
    public final void ruleReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:318:2: ( ( ( rule__ReferenceRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:319:2: ( ( rule__ReferenceRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:319:2: ( ( rule__ReferenceRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:320:3: ( rule__ReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:321:3: ( rule__ReferenceRule__Alternatives )
            // InternalDataDescriptionLanguage.g:321:4: rule__ReferenceRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:330:1: entryRuleSelfReferenceRule : ruleSelfReferenceRule EOF ;
    public final void entryRuleSelfReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:331:1: ( ruleSelfReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:332:1: ruleSelfReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:339:1: ruleSelfReferenceRule : ( ( rule__SelfReferenceRule__Group__0 ) ) ;
    public final void ruleSelfReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:343:2: ( ( ( rule__SelfReferenceRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:344:2: ( ( rule__SelfReferenceRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:344:2: ( ( rule__SelfReferenceRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:345:3: ( rule__SelfReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:346:3: ( rule__SelfReferenceRule__Group__0 )
            // InternalDataDescriptionLanguage.g:346:4: rule__SelfReferenceRule__Group__0
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
    // InternalDataDescriptionLanguage.g:355:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:356:1: ( ruleExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:357:1: ruleExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:364:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:368:2: ( ( ruleOrExpressionRule ) )
            // InternalDataDescriptionLanguage.g:369:2: ( ruleOrExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:369:2: ( ruleOrExpressionRule )
            // InternalDataDescriptionLanguage.g:370:3: ruleOrExpressionRule
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
    // InternalDataDescriptionLanguage.g:380:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:381:1: ( ruleOrExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:382:1: ruleOrExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:389:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:393:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:394:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:394:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:395:3: ( rule__OrExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:396:3: ( rule__OrExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:396:4: rule__OrExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:405:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:406:1: ( ruleXorExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:407:1: ruleXorExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:414:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:418:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:419:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:419:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:420:3: ( rule__XorExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:421:3: ( rule__XorExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:421:4: rule__XorExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:430:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:431:1: ( ruleAndExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:432:1: ruleAndExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:439:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:443:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:444:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:444:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:445:3: ( rule__AndExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:446:3: ( rule__AndExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:446:4: rule__AndExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:455:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:456:1: ( ruleNotExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:457:1: ruleNotExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:464:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:468:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:469:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:469:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:470:3: ( rule__NotExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:471:3: ( rule__NotExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:471:4: rule__NotExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:480:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:481:1: ( ruleComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:482:1: ruleComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:489:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:493:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:494:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:494:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:495:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:496:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:496:4: rule__ComparisonExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:505:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:506:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:507:1: rulePartialComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:514:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:518:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:519:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:519:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:520:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:521:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:521:4: rule__PartialComparisonExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:530:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:531:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:532:1: ruleAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:539:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:543:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:544:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:544:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:545:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:546:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:546:4: rule__AddOrSubtractExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:555:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:556:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:557:1: ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:564:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:568:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:569:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:569:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:570:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:571:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:571:4: rule__MultiplyDivideModuloExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:580:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:581:1: ( rulePowerOfExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:582:1: rulePowerOfExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:589:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:593:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:594:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:594:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:595:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:596:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:596:4: rule__PowerOfExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:605:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:606:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:607:1: ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:614:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:618:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:619:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:619:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:620:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:621:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:621:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:630:1: entryRuleValueRule : ruleValueRule EOF ;
    public final void entryRuleValueRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:631:1: ( ruleValueRule EOF )
            // InternalDataDescriptionLanguage.g:632:1: ruleValueRule EOF
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
    // InternalDataDescriptionLanguage.g:639:1: ruleValueRule : ( ( rule__ValueRule__Alternatives ) ) ;
    public final void ruleValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:643:2: ( ( ( rule__ValueRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:644:2: ( ( rule__ValueRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:644:2: ( ( rule__ValueRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:645:3: ( rule__ValueRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:646:3: ( rule__ValueRule__Alternatives )
            // InternalDataDescriptionLanguage.g:646:4: rule__ValueRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:655:1: entryRuleArrayRule : ruleArrayRule EOF ;
    public final void entryRuleArrayRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:656:1: ( ruleArrayRule EOF )
            // InternalDataDescriptionLanguage.g:657:1: ruleArrayRule EOF
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
    // InternalDataDescriptionLanguage.g:664:1: ruleArrayRule : ( ( rule__ArrayRule__Group__0 ) ) ;
    public final void ruleArrayRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:668:2: ( ( ( rule__ArrayRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:669:2: ( ( rule__ArrayRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:669:2: ( ( rule__ArrayRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:670:3: ( rule__ArrayRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:671:3: ( rule__ArrayRule__Group__0 )
            // InternalDataDescriptionLanguage.g:671:4: rule__ArrayRule__Group__0
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
    // InternalDataDescriptionLanguage.g:680:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:681:1: ( ruleParanthesesRule EOF )
            // InternalDataDescriptionLanguage.g:682:1: ruleParanthesesRule EOF
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
    // InternalDataDescriptionLanguage.g:689:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:693:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:694:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:694:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:695:3: ( rule__ParanthesesRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:696:3: ( rule__ParanthesesRule__Group__0 )
            // InternalDataDescriptionLanguage.g:696:4: rule__ParanthesesRule__Group__0
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
    // InternalDataDescriptionLanguage.g:705:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:706:1: ( ruleCallRule EOF )
            // InternalDataDescriptionLanguage.g:707:1: ruleCallRule EOF
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
    // InternalDataDescriptionLanguage.g:714:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:718:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:719:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:719:2: ( ( rule__CallRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:720:3: ( rule__CallRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:721:3: ( rule__CallRule__Group__0 )
            // InternalDataDescriptionLanguage.g:721:4: rule__CallRule__Group__0
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


    // $ANTLR start "entryRuleDataReferenceRule"
    // InternalDataDescriptionLanguage.g:730:1: entryRuleDataReferenceRule : ruleDataReferenceRule EOF ;
    public final void entryRuleDataReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:731:1: ( ruleDataReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:732:1: ruleDataReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:739:1: ruleDataReferenceRule : ( ( rule__DataReferenceRule__Group__0 ) ) ;
    public final void ruleDataReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:743:2: ( ( ( rule__DataReferenceRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:744:2: ( ( rule__DataReferenceRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:744:2: ( ( rule__DataReferenceRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:745:3: ( rule__DataReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:746:3: ( rule__DataReferenceRule__Group__0 )
            // InternalDataDescriptionLanguage.g:746:4: rule__DataReferenceRule__Group__0
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
    // InternalDataDescriptionLanguage.g:755:1: entryRuleConstantReferenceRule : ruleConstantReferenceRule EOF ;
    public final void entryRuleConstantReferenceRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:756:1: ( ruleConstantReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:757:1: ruleConstantReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:764:1: ruleConstantReferenceRule : ( ( rule__ConstantReferenceRule__DefinitionAssignment ) ) ;
    public final void ruleConstantReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:768:2: ( ( ( rule__ConstantReferenceRule__DefinitionAssignment ) ) )
            // InternalDataDescriptionLanguage.g:769:2: ( ( rule__ConstantReferenceRule__DefinitionAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:769:2: ( ( rule__ConstantReferenceRule__DefinitionAssignment ) )
            // InternalDataDescriptionLanguage.g:770:3: ( rule__ConstantReferenceRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantReferenceRuleAccess().getDefinitionAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:771:3: ( rule__ConstantReferenceRule__DefinitionAssignment )
            // InternalDataDescriptionLanguage.g:771:4: rule__ConstantReferenceRule__DefinitionAssignment
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
    // InternalDataDescriptionLanguage.g:780:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:781:1: ( ruleLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:782:1: ruleLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:789:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:793:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:794:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:794:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:795:3: ( rule__LiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:796:3: ( rule__LiteralRule__Alternatives )
            // InternalDataDescriptionLanguage.g:796:4: rule__LiteralRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:805:1: entryRuleInstanceLiteralRule : ruleInstanceLiteralRule EOF ;
    public final void entryRuleInstanceLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:806:1: ( ruleInstanceLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:807:1: ruleInstanceLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:814:1: ruleInstanceLiteralRule : ( ( rule__InstanceLiteralRule__Group__0 ) ) ;
    public final void ruleInstanceLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:818:2: ( ( ( rule__InstanceLiteralRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:819:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:819:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:820:3: ( rule__InstanceLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:821:3: ( rule__InstanceLiteralRule__Group__0 )
            // InternalDataDescriptionLanguage.g:821:4: rule__InstanceLiteralRule__Group__0
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
    // InternalDataDescriptionLanguage.g:830:1: entryRuleAttributeRule : ruleAttributeRule EOF ;
    public final void entryRuleAttributeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:831:1: ( ruleAttributeRule EOF )
            // InternalDataDescriptionLanguage.g:832:1: ruleAttributeRule EOF
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
    // InternalDataDescriptionLanguage.g:839:1: ruleAttributeRule : ( ( rule__AttributeRule__Group__0 ) ) ;
    public final void ruleAttributeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:843:2: ( ( ( rule__AttributeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:844:2: ( ( rule__AttributeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:844:2: ( ( rule__AttributeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:845:3: ( rule__AttributeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:846:3: ( rule__AttributeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:846:4: rule__AttributeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:855:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:856:1: ( ruleNumberLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:857:1: ruleNumberLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:864:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:868:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:869:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:869:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:870:3: ( rule__NumberLiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:871:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalDataDescriptionLanguage.g:871:4: rule__NumberLiteralRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:880:1: entryRuleRealLiteralRule : ruleRealLiteralRule EOF ;
    public final void entryRuleRealLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:881:1: ( ruleRealLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:882:1: ruleRealLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:889:1: ruleRealLiteralRule : ( ( rule__RealLiteralRule__Group__0 ) ) ;
    public final void ruleRealLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:893:2: ( ( ( rule__RealLiteralRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:894:2: ( ( rule__RealLiteralRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:894:2: ( ( rule__RealLiteralRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:895:3: ( rule__RealLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:896:3: ( rule__RealLiteralRule__Group__0 )
            // InternalDataDescriptionLanguage.g:896:4: rule__RealLiteralRule__Group__0
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
    // InternalDataDescriptionLanguage.g:905:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:906:1: ( ruleIntegerLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:907:1: ruleIntegerLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:914:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:918:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:919:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:919:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:920:3: ( rule__IntegerLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:921:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalDataDescriptionLanguage.g:921:4: rule__IntegerLiteralRule__Group__0
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
    // InternalDataDescriptionLanguage.g:930:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:931:1: ( ruleStringLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:932:1: ruleStringLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:939:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:943:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // InternalDataDescriptionLanguage.g:944:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // InternalDataDescriptionLanguage.g:944:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // InternalDataDescriptionLanguage.g:945:3: ( rule__StringLiteralRule__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            }
            // InternalDataDescriptionLanguage.g:946:3: ( rule__StringLiteralRule__ValueAssignment )
            // InternalDataDescriptionLanguage.g:946:4: rule__StringLiteralRule__ValueAssignment
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
    // InternalDataDescriptionLanguage.g:955:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:956:1: ( ruleBooleanLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:957:1: ruleBooleanLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:964:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:968:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:969:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:969:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:970:3: ( rule__BooleanLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:971:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalDataDescriptionLanguage.g:971:4: rule__BooleanLiteralRule__Group__0
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
    // InternalDataDescriptionLanguage.g:980:1: entryRuleConstraintRule : ruleConstraintRule EOF ;
    public final void entryRuleConstraintRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:981:1: ( ruleConstraintRule EOF )
            // InternalDataDescriptionLanguage.g:982:1: ruleConstraintRule EOF
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
    // InternalDataDescriptionLanguage.g:989:1: ruleConstraintRule : ( ( rule__ConstraintRule__Group__0 ) ) ;
    public final void ruleConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:993:2: ( ( ( rule__ConstraintRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:994:2: ( ( rule__ConstraintRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:994:2: ( ( rule__ConstraintRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:995:3: ( rule__ConstraintRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:996:3: ( rule__ConstraintRule__Group__0 )
            // InternalDataDescriptionLanguage.g:996:4: rule__ConstraintRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1005:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1006:1: ( ruleAttributeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:1007:1: ruleAttributeDefinitionRule EOF
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
    // InternalDataDescriptionLanguage.g:1014:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1018:2: ( ( ( rule__AttributeDefinitionRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1019:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1019:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1020:3: ( rule__AttributeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1021:3: ( rule__AttributeDefinitionRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1021:4: rule__AttributeDefinitionRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1030:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1031:1: ( ruleTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1032:1: ruleTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1039:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1043:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1044:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1044:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1045:3: ( rule__TypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1046:3: ( rule__TypeRule__Alternatives )
            // InternalDataDescriptionLanguage.g:1046:4: rule__TypeRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:1055:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1056:1: ( ruleLiteralTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1057:1: ruleLiteralTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1064:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1068:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1069:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1069:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1070:3: ( rule__LiteralTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1071:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1071:4: rule__LiteralTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1080:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1081:1: ( ruleDataTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1082:1: ruleDataTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1089:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1093:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1094:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1094:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1095:3: ( rule__DataTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1096:3: ( rule__DataTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1096:4: rule__DataTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1105:1: entryRuleInstanceTypeRule : ruleInstanceTypeRule EOF ;
    public final void entryRuleInstanceTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1106:1: ( ruleInstanceTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1107:1: ruleInstanceTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1114:1: ruleInstanceTypeRule : ( ( rule__InstanceTypeRule__Group__0 ) ) ;
    public final void ruleInstanceTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1118:2: ( ( ( rule__InstanceTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1119:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1119:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1120:3: ( rule__InstanceTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1121:3: ( rule__InstanceTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1121:4: rule__InstanceTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1130:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1131:1: ( ruleStringTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1132:1: ruleStringTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1139:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1143:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1144:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1144:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1145:3: ( rule__StringTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1146:3: ( rule__StringTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1146:4: rule__StringTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1155:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1156:1: ( ruleExpressionTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1157:1: ruleExpressionTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1164:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1168:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1169:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1169:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1170:3: ( rule__ExpressionTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1171:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1171:4: rule__ExpressionTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1180:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1181:1: ( ruleIntTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1182:1: ruleIntTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1189:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1193:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1194:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1194:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1195:3: ( rule__IntTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1196:3: ( rule__IntTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1196:4: rule__IntTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1205:1: entryRuleRealTypeRule : ruleRealTypeRule EOF ;
    public final void entryRuleRealTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1206:1: ( ruleRealTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1207:1: ruleRealTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1214:1: ruleRealTypeRule : ( ( rule__RealTypeRule__Group__0 ) ) ;
    public final void ruleRealTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1218:2: ( ( ( rule__RealTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1219:2: ( ( rule__RealTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1219:2: ( ( rule__RealTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1220:3: ( rule__RealTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1221:3: ( rule__RealTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1221:4: rule__RealTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1230:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1231:1: ( ruleBooleanTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1232:1: ruleBooleanTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1239:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1243:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1244:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1244:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1245:3: ( rule__BooleanTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1246:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1246:4: rule__BooleanTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1255:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1256:1: ( ruleVoidTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1257:1: ruleVoidTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1264:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1268:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1269:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1269:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1270:3: ( rule__VoidTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1271:3: ( rule__VoidTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1271:4: rule__VoidTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1280:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1281:1: ( ruleArrayTypeRule EOF )
            // InternalDataDescriptionLanguage.g:1282:1: ruleArrayTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:1289:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1293:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1294:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1294:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1295:3: ( rule__ArrayTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1296:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1296:4: rule__ArrayTypeRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1305:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1306:1: ( ruleParameterRule EOF )
            // InternalDataDescriptionLanguage.g:1307:1: ruleParameterRule EOF
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
    // InternalDataDescriptionLanguage.g:1314:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1318:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1319:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1319:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1320:3: ( rule__ParameterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1321:3: ( rule__ParameterRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1321:4: rule__ParameterRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1330:1: entryRuleImportRule : ruleImportRule EOF ;
    public final void entryRuleImportRule() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1331:1: ( ruleImportRule EOF )
            // InternalDataDescriptionLanguage.g:1332:1: ruleImportRule EOF
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
    // InternalDataDescriptionLanguage.g:1339:1: ruleImportRule : ( ( rule__ImportRule__Group__0 ) ) ;
    public final void ruleImportRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1343:2: ( ( ( rule__ImportRule__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1344:2: ( ( rule__ImportRule__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1344:2: ( ( rule__ImportRule__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1345:3: ( rule__ImportRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1346:3: ( rule__ImportRule__Group__0 )
            // InternalDataDescriptionLanguage.g:1346:4: rule__ImportRule__Group__0
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
    // InternalDataDescriptionLanguage.g:1355:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1356:1: ( ruleQualifiedName EOF )
            // InternalDataDescriptionLanguage.g:1357:1: ruleQualifiedName EOF
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
    // InternalDataDescriptionLanguage.g:1364:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1368:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalDataDescriptionLanguage.g:1369:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalDataDescriptionLanguage.g:1369:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalDataDescriptionLanguage.g:1370:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalDataDescriptionLanguage.g:1371:3: ( rule__QualifiedName__Group__0 )
            // InternalDataDescriptionLanguage.g:1371:4: rule__QualifiedName__Group__0
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
    // InternalDataDescriptionLanguage.g:1380:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalDataDescriptionLanguage.g:1381:1: ( ruleStringOrId EOF )
            // InternalDataDescriptionLanguage.g:1382:1: ruleStringOrId EOF
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
    // InternalDataDescriptionLanguage.g:1389:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1393:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1394:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1394:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1395:3: ( rule__StringOrId__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1396:3: ( rule__StringOrId__Alternatives )
            // InternalDataDescriptionLanguage.g:1396:4: rule__StringOrId__Alternatives
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
    // InternalDataDescriptionLanguage.g:1405:1: ruleScaleType : ( ( rule__ScaleType__Alternatives ) ) ;
    public final void ruleScaleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1409:1: ( ( ( rule__ScaleType__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1410:2: ( ( rule__ScaleType__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1410:2: ( ( rule__ScaleType__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1411:3: ( rule__ScaleType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScaleTypeAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1412:3: ( rule__ScaleType__Alternatives )
            // InternalDataDescriptionLanguage.g:1412:4: rule__ScaleType__Alternatives
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
    // InternalDataDescriptionLanguage.g:1421:1: ruleRepresentationType : ( ( rule__RepresentationType__Alternatives ) ) ;
    public final void ruleRepresentationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1425:1: ( ( ( rule__RepresentationType__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1426:2: ( ( rule__RepresentationType__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1426:2: ( ( rule__RepresentationType__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1427:3: ( rule__RepresentationType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRepresentationTypeAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1428:3: ( rule__RepresentationType__Alternatives )
            // InternalDataDescriptionLanguage.g:1428:4: rule__RepresentationType__Alternatives
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
    // InternalDataDescriptionLanguage.g:1437:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1441:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1442:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1442:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1443:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1444:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:1444:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:1453:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1457:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1458:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1458:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1459:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1460:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:1460:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:1469:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1473:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1474:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1474:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1475:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1476:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:1476:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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
    // InternalDataDescriptionLanguage.g:1485:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1489:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalDataDescriptionLanguage.g:1490:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalDataDescriptionLanguage.g:1490:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalDataDescriptionLanguage.g:1491:3: ( rule__FactorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            }
            // InternalDataDescriptionLanguage.g:1492:3: ( rule__FactorRule__Alternatives )
            // InternalDataDescriptionLanguage.g:1492:4: rule__FactorRule__Alternatives
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


    // $ANTLR start "rule__DataTypeDefinitionRule__Alternatives"
    // InternalDataDescriptionLanguage.g:1500:1: rule__DataTypeDefinitionRule__Alternatives : ( ( ruleBaseDataTypeTypeDefinitionRule ) | ( ruleEnumTypeDefinitionRule ) );
    public final void rule__DataTypeDefinitionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1504:1: ( ( ruleBaseDataTypeTypeDefinitionRule ) | ( ruleEnumTypeDefinitionRule ) )
            int alt1=2;
            switch ( input.LA(1) ) {
            case 79:
                {
                int LA1_1 = input.LA(2);

                if ( (synpred1_InternalDataDescriptionLanguage()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA1_2 = input.LA(2);

                if ( (synpred1_InternalDataDescriptionLanguage()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA1_3 = input.LA(2);

                if ( (synpred1_InternalDataDescriptionLanguage()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                int LA1_4 = input.LA(2);

                if ( (synpred1_InternalDataDescriptionLanguage()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 4, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA1_5 = input.LA(2);

                if ( (synpred1_InternalDataDescriptionLanguage()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 5, input);

                    throw nvae;
                }
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
                    // InternalDataDescriptionLanguage.g:1505:2: ( ruleBaseDataTypeTypeDefinitionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1505:2: ( ruleBaseDataTypeTypeDefinitionRule )
                    // InternalDataDescriptionLanguage.g:1506:3: ruleBaseDataTypeTypeDefinitionRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDataTypeDefinitionRuleAccess().getBaseDataTypeTypeDefinitionRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBaseDataTypeTypeDefinitionRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDataTypeDefinitionRuleAccess().getBaseDataTypeTypeDefinitionRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1511:2: ( ruleEnumTypeDefinitionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1511:2: ( ruleEnumTypeDefinitionRule )
                    // InternalDataDescriptionLanguage.g:1512:3: ruleEnumTypeDefinitionRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDataTypeDefinitionRuleAccess().getEnumTypeDefinitionRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleEnumTypeDefinitionRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDataTypeDefinitionRuleAccess().getEnumTypeDefinitionRuleParserRuleCall_1()); 
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
    // $ANTLR end "rule__DataTypeDefinitionRule__Alternatives"


    // $ANTLR start "rule__DataDescriptionRule__Alternatives"
    // InternalDataDescriptionLanguage.g:1521:1: rule__DataDescriptionRule__Alternatives : ( ( ruleTypedBaseDataDescriptionRule ) | ( ruleUntypedBaseDataDescriptionRule ) | ( ruleStructuredDataDescriptionRule ) );
    public final void rule__DataDescriptionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1525:1: ( ( ruleTypedBaseDataDescriptionRule ) | ( ruleUntypedBaseDataDescriptionRule ) | ( ruleStructuredDataDescriptionRule ) )
            int alt2=3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1526:2: ( ruleTypedBaseDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1526:2: ( ruleTypedBaseDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:1527:3: ruleTypedBaseDataDescriptionRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDataDescriptionRuleAccess().getTypedBaseDataDescriptionRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleTypedBaseDataDescriptionRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDataDescriptionRuleAccess().getTypedBaseDataDescriptionRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:1532:2: ( ruleUntypedBaseDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1532:2: ( ruleUntypedBaseDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:1533:3: ruleUntypedBaseDataDescriptionRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDataDescriptionRuleAccess().getUntypedBaseDataDescriptionRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleUntypedBaseDataDescriptionRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDataDescriptionRuleAccess().getUntypedBaseDataDescriptionRuleParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:1538:2: ( ruleStructuredDataDescriptionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1538:2: ( ruleStructuredDataDescriptionRule )
                    // InternalDataDescriptionLanguage.g:1539:3: ruleStructuredDataDescriptionRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDataDescriptionRuleAccess().getStructuredDataDescriptionRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleStructuredDataDescriptionRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDataDescriptionRuleAccess().getStructuredDataDescriptionRuleParserRuleCall_2()); 
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


    // $ANTLR start "rule__ReferenceRule__Alternatives"
    // InternalDataDescriptionLanguage.g:1548:1: rule__ReferenceRule__Alternatives : ( ( ruleConstantReferenceRule ) | ( ruleDataReferenceRule ) | ( ruleSelfReferenceRule ) );
    public final void rule__ReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1552:1: ( ( ruleConstantReferenceRule ) | ( ruleDataReferenceRule ) | ( ruleSelfReferenceRule ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt3=1;
                }
                break;
            case 60:
                {
                alt3=2;
                }
                break;
            case 71:
                {
                alt3=3;
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
                    // InternalDataDescriptionLanguage.g:1553:2: ( ruleConstantReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1553:2: ( ruleConstantReferenceRule )
                    // InternalDataDescriptionLanguage.g:1554:3: ruleConstantReferenceRule
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
                    // InternalDataDescriptionLanguage.g:1559:2: ( ruleDataReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1559:2: ( ruleDataReferenceRule )
                    // InternalDataDescriptionLanguage.g:1560:3: ruleDataReferenceRule
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
                case 3 :
                    // InternalDataDescriptionLanguage.g:1565:2: ( ruleSelfReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1565:2: ( ruleSelfReferenceRule )
                    // InternalDataDescriptionLanguage.g:1566:3: ruleSelfReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceRuleAccess().getSelfReferenceRuleParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSelfReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceRuleAccess().getSelfReferenceRuleParserRuleCall_2()); 
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
    // InternalDataDescriptionLanguage.g:1575:1: rule__ValueRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );
    public final void rule__ValueRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1579:1: ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) )
            int alt4=5;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1580:2: ( ruleArrayRule )
                    {
                    // InternalDataDescriptionLanguage.g:1580:2: ( ruleArrayRule )
                    // InternalDataDescriptionLanguage.g:1581:3: ruleArrayRule
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
                    // InternalDataDescriptionLanguage.g:1586:2: ( ruleCallRule )
                    {
                    // InternalDataDescriptionLanguage.g:1586:2: ( ruleCallRule )
                    // InternalDataDescriptionLanguage.g:1587:3: ruleCallRule
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
                    // InternalDataDescriptionLanguage.g:1592:2: ( ruleLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1592:2: ( ruleLiteralRule )
                    // InternalDataDescriptionLanguage.g:1593:3: ruleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1598:2: ( ruleParanthesesRule )
                    {
                    // InternalDataDescriptionLanguage.g:1598:2: ( ruleParanthesesRule )
                    // InternalDataDescriptionLanguage.g:1599:3: ruleParanthesesRule
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
                    // InternalDataDescriptionLanguage.g:1604:2: ( ruleReferenceRule )
                    {
                    // InternalDataDescriptionLanguage.g:1604:2: ( ruleReferenceRule )
                    // InternalDataDescriptionLanguage.g:1605:3: ruleReferenceRule
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
    // InternalDataDescriptionLanguage.g:1614:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1618:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt5=1;
                }
                break;
            case RULE_STRING:
                {
                alt5=2;
                }
                break;
            case 15:
            case 89:
                {
                alt5=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt5=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1619:2: ( ruleNumberLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1619:2: ( ruleNumberLiteralRule )
                    // InternalDataDescriptionLanguage.g:1620:3: ruleNumberLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1625:2: ( ruleStringLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1625:2: ( ruleStringLiteralRule )
                    // InternalDataDescriptionLanguage.g:1626:3: ruleStringLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1631:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1631:2: ( ruleBooleanLiteralRule )
                    // InternalDataDescriptionLanguage.g:1632:3: ruleBooleanLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1637:2: ( ruleInstanceLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1637:2: ( ruleInstanceLiteralRule )
                    // InternalDataDescriptionLanguage.g:1638:3: ruleInstanceLiteralRule
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
    // InternalDataDescriptionLanguage.g:1647:1: rule__NumberLiteralRule__Alternatives : ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1651:1: ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_DOUBLE) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_INT) ) {
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
                    // InternalDataDescriptionLanguage.g:1652:2: ( ruleRealLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1652:2: ( ruleRealLiteralRule )
                    // InternalDataDescriptionLanguage.g:1653:3: ruleRealLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1658:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalDataDescriptionLanguage.g:1658:2: ( ruleIntegerLiteralRule )
                    // InternalDataDescriptionLanguage.g:1659:3: ruleIntegerLiteralRule
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
    // InternalDataDescriptionLanguage.g:1668:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1672:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==89) ) {
                alt7=1;
            }
            else if ( (LA7_0==15) ) {
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
                    // InternalDataDescriptionLanguage.g:1673:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalDataDescriptionLanguage.g:1673:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalDataDescriptionLanguage.g:1674:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1675:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalDataDescriptionLanguage.g:1675:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalDataDescriptionLanguage.g:1679:2: ( 'false' )
                    {
                    // InternalDataDescriptionLanguage.g:1679:2: ( 'false' )
                    // InternalDataDescriptionLanguage.g:1680:3: 'false'
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
    // InternalDataDescriptionLanguage.g:1689:1: rule__TypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1693:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) )
            int alt8=10;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt8=1;
                }
                break;
            case 82:
                {
                alt8=2;
                }
                break;
            case 20:
                {
                alt8=3;
                }
                break;
            case 22:
                {
                alt8=4;
                }
                break;
            case 84:
                {
                alt8=5;
                }
                break;
            case 70:
                {
                alt8=6;
                }
                break;
            case 83:
                {
                alt8=7;
                }
                break;
            case 81:
                {
                alt8=8;
                }
                break;
            case 80:
                {
                alt8=9;
                }
                break;
            case 60:
                {
                alt8=10;
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
                    // InternalDataDescriptionLanguage.g:1694:2: ( ruleStringTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1694:2: ( ruleStringTypeRule )
                    // InternalDataDescriptionLanguage.g:1695:3: ruleStringTypeRule
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
                    // InternalDataDescriptionLanguage.g:1700:2: ( ruleIntTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1700:2: ( ruleIntTypeRule )
                    // InternalDataDescriptionLanguage.g:1701:3: ruleIntTypeRule
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
                    // InternalDataDescriptionLanguage.g:1706:2: ( ruleRealTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1706:2: ( ruleRealTypeRule )
                    // InternalDataDescriptionLanguage.g:1707:3: ruleRealTypeRule
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
                    // InternalDataDescriptionLanguage.g:1712:2: ( ruleBooleanTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1712:2: ( ruleBooleanTypeRule )
                    // InternalDataDescriptionLanguage.g:1713:3: ruleBooleanTypeRule
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
                    // InternalDataDescriptionLanguage.g:1718:2: ( ruleArrayTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1718:2: ( ruleArrayTypeRule )
                    // InternalDataDescriptionLanguage.g:1719:3: ruleArrayTypeRule
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
                    // InternalDataDescriptionLanguage.g:1724:2: ( ruleInstanceTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1724:2: ( ruleInstanceTypeRule )
                    // InternalDataDescriptionLanguage.g:1725:3: ruleInstanceTypeRule
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
                    // InternalDataDescriptionLanguage.g:1730:2: ( ruleVoidTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1730:2: ( ruleVoidTypeRule )
                    // InternalDataDescriptionLanguage.g:1731:3: ruleVoidTypeRule
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
                    // InternalDataDescriptionLanguage.g:1736:2: ( ruleExpressionTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1736:2: ( ruleExpressionTypeRule )
                    // InternalDataDescriptionLanguage.g:1737:3: ruleExpressionTypeRule
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
                    // InternalDataDescriptionLanguage.g:1742:2: ( ruleLiteralTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1742:2: ( ruleLiteralTypeRule )
                    // InternalDataDescriptionLanguage.g:1743:3: ruleLiteralTypeRule
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
                    // InternalDataDescriptionLanguage.g:1748:2: ( ruleDataTypeRule )
                    {
                    // InternalDataDescriptionLanguage.g:1748:2: ( ruleDataTypeRule )
                    // InternalDataDescriptionLanguage.g:1749:3: ruleDataTypeRule
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
    // InternalDataDescriptionLanguage.g:1758:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1762:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_QUOTED_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
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
                    // InternalDataDescriptionLanguage.g:1763:2: ( RULE_QUOTED_ID )
                    {
                    // InternalDataDescriptionLanguage.g:1763:2: ( RULE_QUOTED_ID )
                    // InternalDataDescriptionLanguage.g:1764:3: RULE_QUOTED_ID
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
                    // InternalDataDescriptionLanguage.g:1769:2: ( RULE_ID )
                    {
                    // InternalDataDescriptionLanguage.g:1769:2: ( RULE_ID )
                    // InternalDataDescriptionLanguage.g:1770:3: RULE_ID
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
    // InternalDataDescriptionLanguage.g:1779:1: rule__ScaleType__Alternatives : ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) );
    public final void rule__ScaleType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1783:1: ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt10=1;
                }
                break;
            case 17:
                {
                alt10=2;
                }
                break;
            case 18:
                {
                alt10=3;
                }
                break;
            case 19:
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
                    // InternalDataDescriptionLanguage.g:1784:2: ( ( 'nominal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1784:2: ( ( 'nominal' ) )
                    // InternalDataDescriptionLanguage.g:1785:3: ( 'nominal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1786:3: ( 'nominal' )
                    // InternalDataDescriptionLanguage.g:1786:4: 'nominal'
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
                    // InternalDataDescriptionLanguage.g:1790:2: ( ( 'ordinal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1790:2: ( ( 'ordinal' ) )
                    // InternalDataDescriptionLanguage.g:1791:3: ( 'ordinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1792:3: ( 'ordinal' )
                    // InternalDataDescriptionLanguage.g:1792:4: 'ordinal'
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
                    // InternalDataDescriptionLanguage.g:1796:2: ( ( 'cardinal' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1796:2: ( ( 'cardinal' ) )
                    // InternalDataDescriptionLanguage.g:1797:3: ( 'cardinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1798:3: ( 'cardinal' )
                    // InternalDataDescriptionLanguage.g:1798:4: 'cardinal'
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
                    // InternalDataDescriptionLanguage.g:1802:2: ( ( 'quotient' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1802:2: ( ( 'quotient' ) )
                    // InternalDataDescriptionLanguage.g:1803:3: ( 'quotient' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getQuotientEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1804:3: ( 'quotient' )
                    // InternalDataDescriptionLanguage.g:1804:4: 'quotient'
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
    // InternalDataDescriptionLanguage.g:1812:1: rule__RepresentationType__Alternatives : ( ( ( 'real' ) ) | ( ( 'integer' ) ) | ( ( 'boolean' ) ) | ( ( 'string' ) ) );
    public final void rule__RepresentationType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1816:1: ( ( ( 'real' ) ) | ( ( 'integer' ) ) | ( ( 'boolean' ) ) | ( ( 'string' ) ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt11=1;
                }
                break;
            case 21:
                {
                alt11=2;
                }
                break;
            case 22:
                {
                alt11=3;
                }
                break;
            case 23:
                {
                alt11=4;
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
                    // InternalDataDescriptionLanguage.g:1817:2: ( ( 'real' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1817:2: ( ( 'real' ) )
                    // InternalDataDescriptionLanguage.g:1818:3: ( 'real' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1819:3: ( 'real' )
                    // InternalDataDescriptionLanguage.g:1819:4: 'real'
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
                    // InternalDataDescriptionLanguage.g:1823:2: ( ( 'integer' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1823:2: ( ( 'integer' ) )
                    // InternalDataDescriptionLanguage.g:1824:3: ( 'integer' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1825:3: ( 'integer' )
                    // InternalDataDescriptionLanguage.g:1825:4: 'integer'
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
                    // InternalDataDescriptionLanguage.g:1829:2: ( ( 'boolean' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1829:2: ( ( 'boolean' ) )
                    // InternalDataDescriptionLanguage.g:1830:3: ( 'boolean' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1831:3: ( 'boolean' )
                    // InternalDataDescriptionLanguage.g:1831:4: 'boolean'
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
                    // InternalDataDescriptionLanguage.g:1835:2: ( ( 'string' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1835:2: ( ( 'string' ) )
                    // InternalDataDescriptionLanguage.g:1836:3: ( 'string' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRepresentationTypeAccess().getStringEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1837:3: ( 'string' )
                    // InternalDataDescriptionLanguage.g:1837:4: 'string'
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
    // InternalDataDescriptionLanguage.g:1845:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1849:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt12=6;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt12=1;
                }
                break;
            case 25:
                {
                alt12=2;
                }
                break;
            case 26:
                {
                alt12=3;
                }
                break;
            case 27:
                {
                alt12=4;
                }
                break;
            case 28:
                {
                alt12=5;
                }
                break;
            case 29:
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
                    // InternalDataDescriptionLanguage.g:1850:2: ( ( '>=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1850:2: ( ( '>=' ) )
                    // InternalDataDescriptionLanguage.g:1851:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1852:3: ( '>=' )
                    // InternalDataDescriptionLanguage.g:1852:4: '>='
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
                    // InternalDataDescriptionLanguage.g:1856:2: ( ( '>' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1856:2: ( ( '>' ) )
                    // InternalDataDescriptionLanguage.g:1857:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1858:3: ( '>' )
                    // InternalDataDescriptionLanguage.g:1858:4: '>'
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
                    // InternalDataDescriptionLanguage.g:1862:2: ( ( '=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1862:2: ( ( '=' ) )
                    // InternalDataDescriptionLanguage.g:1863:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1864:3: ( '=' )
                    // InternalDataDescriptionLanguage.g:1864:4: '='
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
                    // InternalDataDescriptionLanguage.g:1868:2: ( ( '!=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1868:2: ( ( '!=' ) )
                    // InternalDataDescriptionLanguage.g:1869:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1870:3: ( '!=' )
                    // InternalDataDescriptionLanguage.g:1870:4: '!='
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
                    // InternalDataDescriptionLanguage.g:1874:2: ( ( '<' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1874:2: ( ( '<' ) )
                    // InternalDataDescriptionLanguage.g:1875:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalDataDescriptionLanguage.g:1876:3: ( '<' )
                    // InternalDataDescriptionLanguage.g:1876:4: '<'
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
                    // InternalDataDescriptionLanguage.g:1880:2: ( ( '<=' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1880:2: ( ( '<=' ) )
                    // InternalDataDescriptionLanguage.g:1881:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalDataDescriptionLanguage.g:1882:3: ( '<=' )
                    // InternalDataDescriptionLanguage.g:1882:4: '<='
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
    // InternalDataDescriptionLanguage.g:1890:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1894:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==30) ) {
                alt13=1;
            }
            else if ( (LA13_0==31) ) {
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
                    // InternalDataDescriptionLanguage.g:1895:2: ( ( '+' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1895:2: ( ( '+' ) )
                    // InternalDataDescriptionLanguage.g:1896:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1897:3: ( '+' )
                    // InternalDataDescriptionLanguage.g:1897:4: '+'
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
                    // InternalDataDescriptionLanguage.g:1901:2: ( ( '-' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1901:2: ( ( '-' ) )
                    // InternalDataDescriptionLanguage.g:1902:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1903:3: ( '-' )
                    // InternalDataDescriptionLanguage.g:1903:4: '-'
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
    // InternalDataDescriptionLanguage.g:1911:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1915:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt14=1;
                }
                break;
            case 33:
                {
                alt14=2;
                }
                break;
            case 34:
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
                    // InternalDataDescriptionLanguage.g:1916:2: ( ( '*' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1916:2: ( ( '*' ) )
                    // InternalDataDescriptionLanguage.g:1917:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1918:3: ( '*' )
                    // InternalDataDescriptionLanguage.g:1918:4: '*'
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
                    // InternalDataDescriptionLanguage.g:1922:2: ( ( '/' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1922:2: ( ( '/' ) )
                    // InternalDataDescriptionLanguage.g:1923:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1924:3: ( '/' )
                    // InternalDataDescriptionLanguage.g:1924:4: '/'
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
                    // InternalDataDescriptionLanguage.g:1928:2: ( ( '%' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1928:2: ( ( '%' ) )
                    // InternalDataDescriptionLanguage.g:1929:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1930:3: ( '%' )
                    // InternalDataDescriptionLanguage.g:1930:4: '%'
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
    // InternalDataDescriptionLanguage.g:1938:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:1942:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt15=20;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt15=1;
                }
                break;
            case 36:
                {
                alt15=2;
                }
                break;
            case 37:
                {
                alt15=3;
                }
                break;
            case 38:
                {
                alt15=4;
                }
                break;
            case 39:
                {
                alt15=5;
                }
                break;
            case 40:
                {
                alt15=6;
                }
                break;
            case 41:
                {
                alt15=7;
                }
                break;
            case 42:
                {
                alt15=8;
                }
                break;
            case 43:
                {
                alt15=9;
                }
                break;
            case 44:
                {
                alt15=10;
                }
                break;
            case 45:
                {
                alt15=11;
                }
                break;
            case 46:
                {
                alt15=12;
                }
                break;
            case 47:
                {
                alt15=13;
                }
                break;
            case 48:
                {
                alt15=14;
                }
                break;
            case 49:
                {
                alt15=15;
                }
                break;
            case 50:
                {
                alt15=16;
                }
                break;
            case 51:
                {
                alt15=17;
                }
                break;
            case 52:
                {
                alt15=18;
                }
                break;
            case 53:
                {
                alt15=19;
                }
                break;
            case 54:
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
                    // InternalDataDescriptionLanguage.g:1943:2: ( ( 'Y' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1943:2: ( ( 'Y' ) )
                    // InternalDataDescriptionLanguage.g:1944:3: ( 'Y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }
                    // InternalDataDescriptionLanguage.g:1945:3: ( 'Y' )
                    // InternalDataDescriptionLanguage.g:1945:4: 'Y'
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
                    // InternalDataDescriptionLanguage.g:1949:2: ( ( 'Z' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1949:2: ( ( 'Z' ) )
                    // InternalDataDescriptionLanguage.g:1950:3: ( 'Z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }
                    // InternalDataDescriptionLanguage.g:1951:3: ( 'Z' )
                    // InternalDataDescriptionLanguage.g:1951:4: 'Z'
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
                    // InternalDataDescriptionLanguage.g:1955:2: ( ( 'E' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1955:2: ( ( 'E' ) )
                    // InternalDataDescriptionLanguage.g:1956:3: ( 'E' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }
                    // InternalDataDescriptionLanguage.g:1957:3: ( 'E' )
                    // InternalDataDescriptionLanguage.g:1957:4: 'E'
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
                    // InternalDataDescriptionLanguage.g:1961:2: ( ( 'P' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1961:2: ( ( 'P' ) )
                    // InternalDataDescriptionLanguage.g:1962:3: ( 'P' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }
                    // InternalDataDescriptionLanguage.g:1963:3: ( 'P' )
                    // InternalDataDescriptionLanguage.g:1963:4: 'P'
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
                    // InternalDataDescriptionLanguage.g:1967:2: ( ( 'T' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1967:2: ( ( 'T' ) )
                    // InternalDataDescriptionLanguage.g:1968:3: ( 'T' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }
                    // InternalDataDescriptionLanguage.g:1969:3: ( 'T' )
                    // InternalDataDescriptionLanguage.g:1969:4: 'T'
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
                    // InternalDataDescriptionLanguage.g:1973:2: ( ( 'G' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1973:2: ( ( 'G' ) )
                    // InternalDataDescriptionLanguage.g:1974:3: ( 'G' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }
                    // InternalDataDescriptionLanguage.g:1975:3: ( 'G' )
                    // InternalDataDescriptionLanguage.g:1975:4: 'G'
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
                    // InternalDataDescriptionLanguage.g:1979:2: ( ( 'M' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1979:2: ( ( 'M' ) )
                    // InternalDataDescriptionLanguage.g:1980:3: ( 'M' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }
                    // InternalDataDescriptionLanguage.g:1981:3: ( 'M' )
                    // InternalDataDescriptionLanguage.g:1981:4: 'M'
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
                    // InternalDataDescriptionLanguage.g:1985:2: ( ( 'k' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1985:2: ( ( 'k' ) )
                    // InternalDataDescriptionLanguage.g:1986:3: ( 'k' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }
                    // InternalDataDescriptionLanguage.g:1987:3: ( 'k' )
                    // InternalDataDescriptionLanguage.g:1987:4: 'k'
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
                    // InternalDataDescriptionLanguage.g:1991:2: ( ( 'h' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1991:2: ( ( 'h' ) )
                    // InternalDataDescriptionLanguage.g:1992:3: ( 'h' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }
                    // InternalDataDescriptionLanguage.g:1993:3: ( 'h' )
                    // InternalDataDescriptionLanguage.g:1993:4: 'h'
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
                    // InternalDataDescriptionLanguage.g:1997:2: ( ( 'da' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1997:2: ( ( 'da' ) )
                    // InternalDataDescriptionLanguage.g:1998:3: ( 'da' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }
                    // InternalDataDescriptionLanguage.g:1999:3: ( 'da' )
                    // InternalDataDescriptionLanguage.g:1999:4: 'da'
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
                    // InternalDataDescriptionLanguage.g:2003:2: ( ( 'd' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2003:2: ( ( 'd' ) )
                    // InternalDataDescriptionLanguage.g:2004:3: ( 'd' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }
                    // InternalDataDescriptionLanguage.g:2005:3: ( 'd' )
                    // InternalDataDescriptionLanguage.g:2005:4: 'd'
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
                    // InternalDataDescriptionLanguage.g:2009:2: ( ( 'c' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2009:2: ( ( 'c' ) )
                    // InternalDataDescriptionLanguage.g:2010:3: ( 'c' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }
                    // InternalDataDescriptionLanguage.g:2011:3: ( 'c' )
                    // InternalDataDescriptionLanguage.g:2011:4: 'c'
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
                    // InternalDataDescriptionLanguage.g:2015:2: ( ( 'm' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2015:2: ( ( 'm' ) )
                    // InternalDataDescriptionLanguage.g:2016:3: ( 'm' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }
                    // InternalDataDescriptionLanguage.g:2017:3: ( 'm' )
                    // InternalDataDescriptionLanguage.g:2017:4: 'm'
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
                    // InternalDataDescriptionLanguage.g:2021:2: ( ( '\\u00B5' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2021:2: ( ( '\\u00B5' ) )
                    // InternalDataDescriptionLanguage.g:2022:3: ( '\\u00B5' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }
                    // InternalDataDescriptionLanguage.g:2023:3: ( '\\u00B5' )
                    // InternalDataDescriptionLanguage.g:2023:4: '\\u00B5'
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
                    // InternalDataDescriptionLanguage.g:2027:2: ( ( 'n' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2027:2: ( ( 'n' ) )
                    // InternalDataDescriptionLanguage.g:2028:3: ( 'n' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }
                    // InternalDataDescriptionLanguage.g:2029:3: ( 'n' )
                    // InternalDataDescriptionLanguage.g:2029:4: 'n'
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
                    // InternalDataDescriptionLanguage.g:2033:2: ( ( 'p' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2033:2: ( ( 'p' ) )
                    // InternalDataDescriptionLanguage.g:2034:3: ( 'p' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }
                    // InternalDataDescriptionLanguage.g:2035:3: ( 'p' )
                    // InternalDataDescriptionLanguage.g:2035:4: 'p'
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
                    // InternalDataDescriptionLanguage.g:2039:2: ( ( 'f' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2039:2: ( ( 'f' ) )
                    // InternalDataDescriptionLanguage.g:2040:3: ( 'f' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }
                    // InternalDataDescriptionLanguage.g:2041:3: ( 'f' )
                    // InternalDataDescriptionLanguage.g:2041:4: 'f'
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
                    // InternalDataDescriptionLanguage.g:2045:2: ( ( 'a' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2045:2: ( ( 'a' ) )
                    // InternalDataDescriptionLanguage.g:2046:3: ( 'a' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }
                    // InternalDataDescriptionLanguage.g:2047:3: ( 'a' )
                    // InternalDataDescriptionLanguage.g:2047:4: 'a'
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
                    // InternalDataDescriptionLanguage.g:2051:2: ( ( 'z' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2051:2: ( ( 'z' ) )
                    // InternalDataDescriptionLanguage.g:2052:3: ( 'z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }
                    // InternalDataDescriptionLanguage.g:2053:3: ( 'z' )
                    // InternalDataDescriptionLanguage.g:2053:4: 'z'
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
                    // InternalDataDescriptionLanguage.g:2057:2: ( ( 'y' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2057:2: ( ( 'y' ) )
                    // InternalDataDescriptionLanguage.g:2058:3: ( 'y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }
                    // InternalDataDescriptionLanguage.g:2059:3: ( 'y' )
                    // InternalDataDescriptionLanguage.g:2059:4: 'y'
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
    // InternalDataDescriptionLanguage.g:2067:1: rule__DataDescriptionModelRule__Group__0 : rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1 ;
    public final void rule__DataDescriptionModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2071:1: ( rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2072:2: rule__DataDescriptionModelRule__Group__0__Impl rule__DataDescriptionModelRule__Group__1
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
    // InternalDataDescriptionLanguage.g:2079:1: rule__DataDescriptionModelRule__Group__0__Impl : ( ( rule__DataDescriptionModelRule__ImportsAssignment_0 )* ) ;
    public final void rule__DataDescriptionModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2083:1: ( ( ( rule__DataDescriptionModelRule__ImportsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:2084:1: ( ( rule__DataDescriptionModelRule__ImportsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:2084:1: ( ( rule__DataDescriptionModelRule__ImportsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:2085:2: ( rule__DataDescriptionModelRule__ImportsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getImportsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2086:2: ( rule__DataDescriptionModelRule__ImportsAssignment_0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==85) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2086:3: rule__DataDescriptionModelRule__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__DataDescriptionModelRule__ImportsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getImportsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__0__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__1"
    // InternalDataDescriptionLanguage.g:2094:1: rule__DataDescriptionModelRule__Group__1 : rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2 ;
    public final void rule__DataDescriptionModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2098:1: ( rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2099:2: rule__DataDescriptionModelRule__Group__1__Impl rule__DataDescriptionModelRule__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalDataDescriptionLanguage.g:2106:1: rule__DataDescriptionModelRule__Group__1__Impl : ( 'module' ) ;
    public final void rule__DataDescriptionModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2110:1: ( ( 'module' ) )
            // InternalDataDescriptionLanguage.g:2111:1: ( 'module' )
            {
            // InternalDataDescriptionLanguage.g:2111:1: ( 'module' )
            // InternalDataDescriptionLanguage.g:2112:2: 'module'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getModuleKeyword_1()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getModuleKeyword_1()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:2121:1: rule__DataDescriptionModelRule__Group__2 : rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3 ;
    public final void rule__DataDescriptionModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2125:1: ( rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2126:2: rule__DataDescriptionModelRule__Group__2__Impl rule__DataDescriptionModelRule__Group__3
            {
            pushFollow(FOLLOW_6);
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
    // InternalDataDescriptionLanguage.g:2133:1: rule__DataDescriptionModelRule__Group__2__Impl : ( ( rule__DataDescriptionModelRule__NameAssignment_2 ) ) ;
    public final void rule__DataDescriptionModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2137:1: ( ( ( rule__DataDescriptionModelRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:2138:1: ( ( rule__DataDescriptionModelRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:2138:1: ( ( rule__DataDescriptionModelRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:2139:2: ( rule__DataDescriptionModelRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:2140:2: ( rule__DataDescriptionModelRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:2140:3: rule__DataDescriptionModelRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getNameAssignment_2()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:2148:1: rule__DataDescriptionModelRule__Group__3 : rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4 ;
    public final void rule__DataDescriptionModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2152:1: ( rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2153:2: rule__DataDescriptionModelRule__Group__3__Impl rule__DataDescriptionModelRule__Group__4
            {
            pushFollow(FOLLOW_7);
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
    // InternalDataDescriptionLanguage.g:2160:1: rule__DataDescriptionModelRule__Group__3__Impl : ( '{' ) ;
    public final void rule__DataDescriptionModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2164:1: ( ( '{' ) )
            // InternalDataDescriptionLanguage.g:2165:1: ( '{' )
            {
            // InternalDataDescriptionLanguage.g:2165:1: ( '{' )
            // InternalDataDescriptionLanguage.g:2166:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getLeftCurlyBracketKeyword_3()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:2175:1: rule__DataDescriptionModelRule__Group__4 : rule__DataDescriptionModelRule__Group__4__Impl rule__DataDescriptionModelRule__Group__5 ;
    public final void rule__DataDescriptionModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2179:1: ( rule__DataDescriptionModelRule__Group__4__Impl rule__DataDescriptionModelRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2180:2: rule__DataDescriptionModelRule__Group__4__Impl rule__DataDescriptionModelRule__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__DataDescriptionModelRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDataDescriptionLanguage.g:2187:1: rule__DataDescriptionModelRule__Group__4__Impl : ( ( rule__DataDescriptionModelRule__Group_4__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2191:1: ( ( ( rule__DataDescriptionModelRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:2192:1: ( ( rule__DataDescriptionModelRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2192:1: ( ( rule__DataDescriptionModelRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:2193:2: ( rule__DataDescriptionModelRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:2194:2: ( rule__DataDescriptionModelRule__Group_4__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==58) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2194:3: rule__DataDescriptionModelRule__Group_4__0
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


    // $ANTLR start "rule__DataDescriptionModelRule__Group__5"
    // InternalDataDescriptionLanguage.g:2202:1: rule__DataDescriptionModelRule__Group__5 : rule__DataDescriptionModelRule__Group__5__Impl rule__DataDescriptionModelRule__Group__6 ;
    public final void rule__DataDescriptionModelRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2206:1: ( rule__DataDescriptionModelRule__Group__5__Impl rule__DataDescriptionModelRule__Group__6 )
            // InternalDataDescriptionLanguage.g:2207:2: rule__DataDescriptionModelRule__Group__5__Impl rule__DataDescriptionModelRule__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__DataDescriptionModelRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__5"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__5__Impl"
    // InternalDataDescriptionLanguage.g:2214:1: rule__DataDescriptionModelRule__Group__5__Impl : ( ( rule__DataDescriptionModelRule__Group_5__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2218:1: ( ( ( rule__DataDescriptionModelRule__Group_5__0 )? ) )
            // InternalDataDescriptionLanguage.g:2219:1: ( ( rule__DataDescriptionModelRule__Group_5__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2219:1: ( ( rule__DataDescriptionModelRule__Group_5__0 )? )
            // InternalDataDescriptionLanguage.g:2220:2: ( rule__DataDescriptionModelRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_5()); 
            }
            // InternalDataDescriptionLanguage.g:2221:2: ( rule__DataDescriptionModelRule__Group_5__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==60) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2221:3: rule__DataDescriptionModelRule__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataDescriptionModelRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__5__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__6"
    // InternalDataDescriptionLanguage.g:2229:1: rule__DataDescriptionModelRule__Group__6 : rule__DataDescriptionModelRule__Group__6__Impl rule__DataDescriptionModelRule__Group__7 ;
    public final void rule__DataDescriptionModelRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2233:1: ( rule__DataDescriptionModelRule__Group__6__Impl rule__DataDescriptionModelRule__Group__7 )
            // InternalDataDescriptionLanguage.g:2234:2: rule__DataDescriptionModelRule__Group__6__Impl rule__DataDescriptionModelRule__Group__7
            {
            pushFollow(FOLLOW_7);
            rule__DataDescriptionModelRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__6"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__6__Impl"
    // InternalDataDescriptionLanguage.g:2241:1: rule__DataDescriptionModelRule__Group__6__Impl : ( ( rule__DataDescriptionModelRule__Group_6__0 )? ) ;
    public final void rule__DataDescriptionModelRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2245:1: ( ( ( rule__DataDescriptionModelRule__Group_6__0 )? ) )
            // InternalDataDescriptionLanguage.g:2246:1: ( ( rule__DataDescriptionModelRule__Group_6__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2246:1: ( ( rule__DataDescriptionModelRule__Group_6__0 )? )
            // InternalDataDescriptionLanguage.g:2247:2: ( rule__DataDescriptionModelRule__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_6()); 
            }
            // InternalDataDescriptionLanguage.g:2248:2: ( rule__DataDescriptionModelRule__Group_6__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==61) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2248:3: rule__DataDescriptionModelRule__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataDescriptionModelRule__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__6__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__7"
    // InternalDataDescriptionLanguage.g:2256:1: rule__DataDescriptionModelRule__Group__7 : rule__DataDescriptionModelRule__Group__7__Impl ;
    public final void rule__DataDescriptionModelRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2260:1: ( rule__DataDescriptionModelRule__Group__7__Impl )
            // InternalDataDescriptionLanguage.g:2261:2: rule__DataDescriptionModelRule__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__7"


    // $ANTLR start "rule__DataDescriptionModelRule__Group__7__Impl"
    // InternalDataDescriptionLanguage.g:2267:1: rule__DataDescriptionModelRule__Group__7__Impl : ( '}' ) ;
    public final void rule__DataDescriptionModelRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2271:1: ( ( '}' ) )
            // InternalDataDescriptionLanguage.g:2272:1: ( '}' )
            {
            // InternalDataDescriptionLanguage.g:2272:1: ( '}' )
            // InternalDataDescriptionLanguage.g:2273:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getRightCurlyBracketKeyword_7()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getRightCurlyBracketKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group__7__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_4__0"
    // InternalDataDescriptionLanguage.g:2283:1: rule__DataDescriptionModelRule__Group_4__0 : rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1 ;
    public final void rule__DataDescriptionModelRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2287:1: ( rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:2288:2: rule__DataDescriptionModelRule__Group_4__0__Impl rule__DataDescriptionModelRule__Group_4__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalDataDescriptionLanguage.g:2295:1: rule__DataDescriptionModelRule__Group_4__0__Impl : ( 'types' ) ;
    public final void rule__DataDescriptionModelRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2299:1: ( ( 'types' ) )
            // InternalDataDescriptionLanguage.g:2300:1: ( 'types' )
            {
            // InternalDataDescriptionLanguage.g:2300:1: ( 'types' )
            // InternalDataDescriptionLanguage.g:2301:2: 'types'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesKeyword_4_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getTypesKeyword_4_0()); 
            }

            }


            }

        }
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
    // InternalDataDescriptionLanguage.g:2310:1: rule__DataDescriptionModelRule__Group_4__1 : rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2 ;
    public final void rule__DataDescriptionModelRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2314:1: ( rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:2315:2: rule__DataDescriptionModelRule__Group_4__1__Impl rule__DataDescriptionModelRule__Group_4__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalDataDescriptionLanguage.g:2322:1: rule__DataDescriptionModelRule__Group_4__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2326:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2327:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2327:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2328:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_4_1()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:2337:1: rule__DataDescriptionModelRule__Group_4__2 : rule__DataDescriptionModelRule__Group_4__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2341:1: ( rule__DataDescriptionModelRule__Group_4__2__Impl )
            // InternalDataDescriptionLanguage.g:2342:2: rule__DataDescriptionModelRule__Group_4__2__Impl
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
    // InternalDataDescriptionLanguage.g:2348:1: rule__DataDescriptionModelRule__Group_4__2__Impl : ( ( rule__DataDescriptionModelRule__TypesAssignment_4_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2352:1: ( ( ( rule__DataDescriptionModelRule__TypesAssignment_4_2 )* ) )
            // InternalDataDescriptionLanguage.g:2353:1: ( ( rule__DataDescriptionModelRule__TypesAssignment_4_2 )* )
            {
            // InternalDataDescriptionLanguage.g:2353:1: ( ( rule__DataDescriptionModelRule__TypesAssignment_4_2 )* )
            // InternalDataDescriptionLanguage.g:2354:2: ( rule__DataDescriptionModelRule__TypesAssignment_4_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesAssignment_4_2()); 
            }
            // InternalDataDescriptionLanguage.g:2355:2: ( rule__DataDescriptionModelRule__TypesAssignment_4_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=16 && LA20_0<=19)||LA20_0==79) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2355:3: rule__DataDescriptionModelRule__TypesAssignment_4_2
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__DataDescriptionModelRule__TypesAssignment_4_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getTypesAssignment_4_2()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__DataDescriptionModelRule__Group_5__0"
    // InternalDataDescriptionLanguage.g:2364:1: rule__DataDescriptionModelRule__Group_5__0 : rule__DataDescriptionModelRule__Group_5__0__Impl rule__DataDescriptionModelRule__Group_5__1 ;
    public final void rule__DataDescriptionModelRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2368:1: ( rule__DataDescriptionModelRule__Group_5__0__Impl rule__DataDescriptionModelRule__Group_5__1 )
            // InternalDataDescriptionLanguage.g:2369:2: rule__DataDescriptionModelRule__Group_5__0__Impl rule__DataDescriptionModelRule__Group_5__1
            {
            pushFollow(FOLLOW_8);
            rule__DataDescriptionModelRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_5__0"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_5__0__Impl"
    // InternalDataDescriptionLanguage.g:2376:1: rule__DataDescriptionModelRule__Group_5__0__Impl : ( 'data' ) ;
    public final void rule__DataDescriptionModelRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2380:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:2381:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:2381:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:2382:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDataKeyword_5_0()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getDataKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_5__0__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_5__1"
    // InternalDataDescriptionLanguage.g:2391:1: rule__DataDescriptionModelRule__Group_5__1 : rule__DataDescriptionModelRule__Group_5__1__Impl rule__DataDescriptionModelRule__Group_5__2 ;
    public final void rule__DataDescriptionModelRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2395:1: ( rule__DataDescriptionModelRule__Group_5__1__Impl rule__DataDescriptionModelRule__Group_5__2 )
            // InternalDataDescriptionLanguage.g:2396:2: rule__DataDescriptionModelRule__Group_5__1__Impl rule__DataDescriptionModelRule__Group_5__2
            {
            pushFollow(FOLLOW_11);
            rule__DataDescriptionModelRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_5__1"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_5__1__Impl"
    // InternalDataDescriptionLanguage.g:2403:1: rule__DataDescriptionModelRule__Group_5__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2407:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2408:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2408:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2409:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_5_1()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_5__1__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_5__2"
    // InternalDataDescriptionLanguage.g:2418:1: rule__DataDescriptionModelRule__Group_5__2 : rule__DataDescriptionModelRule__Group_5__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2422:1: ( rule__DataDescriptionModelRule__Group_5__2__Impl )
            // InternalDataDescriptionLanguage.g:2423:2: rule__DataDescriptionModelRule__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_5__2"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_5__2__Impl"
    // InternalDataDescriptionLanguage.g:2429:1: rule__DataDescriptionModelRule__Group_5__2__Impl : ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_5_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2433:1: ( ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_5_2 )* ) )
            // InternalDataDescriptionLanguage.g:2434:1: ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_5_2 )* )
            {
            // InternalDataDescriptionLanguage.g:2434:1: ( ( rule__DataDescriptionModelRule__DescriptionsAssignment_5_2 )* )
            // InternalDataDescriptionLanguage.g:2435:2: ( rule__DataDescriptionModelRule__DescriptionsAssignment_5_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsAssignment_5_2()); 
            }
            // InternalDataDescriptionLanguage.g:2436:2: ( rule__DataDescriptionModelRule__DescriptionsAssignment_5_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=16 && LA21_0<=23)||LA21_0==60||LA21_0==79) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2436:3: rule__DataDescriptionModelRule__DescriptionsAssignment_5_2
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__DataDescriptionModelRule__DescriptionsAssignment_5_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsAssignment_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_5__2__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_6__0"
    // InternalDataDescriptionLanguage.g:2445:1: rule__DataDescriptionModelRule__Group_6__0 : rule__DataDescriptionModelRule__Group_6__0__Impl rule__DataDescriptionModelRule__Group_6__1 ;
    public final void rule__DataDescriptionModelRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2449:1: ( rule__DataDescriptionModelRule__Group_6__0__Impl rule__DataDescriptionModelRule__Group_6__1 )
            // InternalDataDescriptionLanguage.g:2450:2: rule__DataDescriptionModelRule__Group_6__0__Impl rule__DataDescriptionModelRule__Group_6__1
            {
            pushFollow(FOLLOW_8);
            rule__DataDescriptionModelRule__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_6__0"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_6__0__Impl"
    // InternalDataDescriptionLanguage.g:2457:1: rule__DataDescriptionModelRule__Group_6__0__Impl : ( 'constraints' ) ;
    public final void rule__DataDescriptionModelRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2461:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2462:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2462:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2463:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsKeyword_6_0()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_6__0__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_6__1"
    // InternalDataDescriptionLanguage.g:2472:1: rule__DataDescriptionModelRule__Group_6__1 : rule__DataDescriptionModelRule__Group_6__1__Impl rule__DataDescriptionModelRule__Group_6__2 ;
    public final void rule__DataDescriptionModelRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2476:1: ( rule__DataDescriptionModelRule__Group_6__1__Impl rule__DataDescriptionModelRule__Group_6__2 )
            // InternalDataDescriptionLanguage.g:2477:2: rule__DataDescriptionModelRule__Group_6__1__Impl rule__DataDescriptionModelRule__Group_6__2
            {
            pushFollow(FOLLOW_13);
            rule__DataDescriptionModelRule__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_6__1"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_6__1__Impl"
    // InternalDataDescriptionLanguage.g:2484:1: rule__DataDescriptionModelRule__Group_6__1__Impl : ( ':' ) ;
    public final void rule__DataDescriptionModelRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2488:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2489:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2489:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2490:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_6_1()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_6__1__Impl"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_6__2"
    // InternalDataDescriptionLanguage.g:2499:1: rule__DataDescriptionModelRule__Group_6__2 : rule__DataDescriptionModelRule__Group_6__2__Impl ;
    public final void rule__DataDescriptionModelRule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2503:1: ( rule__DataDescriptionModelRule__Group_6__2__Impl )
            // InternalDataDescriptionLanguage.g:2504:2: rule__DataDescriptionModelRule__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDescriptionModelRule__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_6__2"


    // $ANTLR start "rule__DataDescriptionModelRule__Group_6__2__Impl"
    // InternalDataDescriptionLanguage.g:2510:1: rule__DataDescriptionModelRule__Group_6__2__Impl : ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_6_2 )* ) ;
    public final void rule__DataDescriptionModelRule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2514:1: ( ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_6_2 )* ) )
            // InternalDataDescriptionLanguage.g:2515:1: ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_6_2 )* )
            {
            // InternalDataDescriptionLanguage.g:2515:1: ( ( rule__DataDescriptionModelRule__ConstraintsAssignment_6_2 )* )
            // InternalDataDescriptionLanguage.g:2516:2: ( rule__DataDescriptionModelRule__ConstraintsAssignment_6_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsAssignment_6_2()); 
            }
            // InternalDataDescriptionLanguage.g:2517:2: ( rule__DataDescriptionModelRule__ConstraintsAssignment_6_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=RULE_QUOTED_ID && LA22_0<=RULE_STRING)||LA22_0==15||(LA22_0>=30 && LA22_0<=31)||LA22_0==60||LA22_0==66||LA22_0==71||LA22_0==76||(LA22_0>=88 && LA22_0<=89)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2517:3: rule__DataDescriptionModelRule__ConstraintsAssignment_6_2
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__DataDescriptionModelRule__ConstraintsAssignment_6_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsAssignment_6_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__Group_6__2__Impl"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__0"
    // InternalDataDescriptionLanguage.g:2526:1: rule__BaseDataTypeTypeDefinitionRule__Group__0 : rule__BaseDataTypeTypeDefinitionRule__Group__0__Impl rule__BaseDataTypeTypeDefinitionRule__Group__1 ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2530:1: ( rule__BaseDataTypeTypeDefinitionRule__Group__0__Impl rule__BaseDataTypeTypeDefinitionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2531:2: rule__BaseDataTypeTypeDefinitionRule__Group__0__Impl rule__BaseDataTypeTypeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__BaseDataTypeTypeDefinitionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__0"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:2538:1: rule__BaseDataTypeTypeDefinitionRule__Group__0__Impl : ( ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2542:1: ( ( ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:2543:1: ( ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:2543:1: ( ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:2544:2: ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2545:2: ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==79) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2545:3: rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__1"
    // InternalDataDescriptionLanguage.g:2553:1: rule__BaseDataTypeTypeDefinitionRule__Group__1 : rule__BaseDataTypeTypeDefinitionRule__Group__1__Impl rule__BaseDataTypeTypeDefinitionRule__Group__2 ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2557:1: ( rule__BaseDataTypeTypeDefinitionRule__Group__1__Impl rule__BaseDataTypeTypeDefinitionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2558:2: rule__BaseDataTypeTypeDefinitionRule__Group__1__Impl rule__BaseDataTypeTypeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__BaseDataTypeTypeDefinitionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__1"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:2565:1: rule__BaseDataTypeTypeDefinitionRule__Group__1__Impl : ( ( rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1 ) ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2569:1: ( ( ( rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:2570:1: ( ( rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:2570:1: ( ( rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:2571:2: ( rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getScaleAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:2572:2: ( rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1 )
            // InternalDataDescriptionLanguage.g:2572:3: rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getScaleAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__2"
    // InternalDataDescriptionLanguage.g:2580:1: rule__BaseDataTypeTypeDefinitionRule__Group__2 : rule__BaseDataTypeTypeDefinitionRule__Group__2__Impl rule__BaseDataTypeTypeDefinitionRule__Group__3 ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2584:1: ( rule__BaseDataTypeTypeDefinitionRule__Group__2__Impl rule__BaseDataTypeTypeDefinitionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2585:2: rule__BaseDataTypeTypeDefinitionRule__Group__2__Impl rule__BaseDataTypeTypeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__BaseDataTypeTypeDefinitionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__2"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:2592:1: rule__BaseDataTypeTypeDefinitionRule__Group__2__Impl : ( 'type' ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2596:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:2597:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:2597:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:2598:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getTypeKeyword_2()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getTypeKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__3"
    // InternalDataDescriptionLanguage.g:2607:1: rule__BaseDataTypeTypeDefinitionRule__Group__3 : rule__BaseDataTypeTypeDefinitionRule__Group__3__Impl rule__BaseDataTypeTypeDefinitionRule__Group__4 ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2611:1: ( rule__BaseDataTypeTypeDefinitionRule__Group__3__Impl rule__BaseDataTypeTypeDefinitionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2612:2: rule__BaseDataTypeTypeDefinitionRule__Group__3__Impl rule__BaseDataTypeTypeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_17);
            rule__BaseDataTypeTypeDefinitionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__3"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__3__Impl"
    // InternalDataDescriptionLanguage.g:2619:1: rule__BaseDataTypeTypeDefinitionRule__Group__3__Impl : ( ( rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3 ) ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2623:1: ( ( ( rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3 ) ) )
            // InternalDataDescriptionLanguage.g:2624:1: ( ( rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3 ) )
            {
            // InternalDataDescriptionLanguage.g:2624:1: ( ( rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3 ) )
            // InternalDataDescriptionLanguage.g:2625:2: ( rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDataDescriptionLanguage.g:2626:2: ( rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3 )
            // InternalDataDescriptionLanguage.g:2626:3: rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__4"
    // InternalDataDescriptionLanguage.g:2634:1: rule__BaseDataTypeTypeDefinitionRule__Group__4 : rule__BaseDataTypeTypeDefinitionRule__Group__4__Impl rule__BaseDataTypeTypeDefinitionRule__Group__5 ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2638:1: ( rule__BaseDataTypeTypeDefinitionRule__Group__4__Impl rule__BaseDataTypeTypeDefinitionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2639:2: rule__BaseDataTypeTypeDefinitionRule__Group__4__Impl rule__BaseDataTypeTypeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__BaseDataTypeTypeDefinitionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__4"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__4__Impl"
    // InternalDataDescriptionLanguage.g:2646:1: rule__BaseDataTypeTypeDefinitionRule__Group__4__Impl : ( ( rule__BaseDataTypeTypeDefinitionRule__Group_4__0 )? ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2650:1: ( ( ( rule__BaseDataTypeTypeDefinitionRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:2651:1: ( ( rule__BaseDataTypeTypeDefinitionRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:2651:1: ( ( rule__BaseDataTypeTypeDefinitionRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:2652:2: ( rule__BaseDataTypeTypeDefinitionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:2653:2: ( rule__BaseDataTypeTypeDefinitionRule__Group_4__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==64) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2653:3: rule__BaseDataTypeTypeDefinitionRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BaseDataTypeTypeDefinitionRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__4__Impl"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__5"
    // InternalDataDescriptionLanguage.g:2661:1: rule__BaseDataTypeTypeDefinitionRule__Group__5 : rule__BaseDataTypeTypeDefinitionRule__Group__5__Impl ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2665:1: ( rule__BaseDataTypeTypeDefinitionRule__Group__5__Impl )
            // InternalDataDescriptionLanguage.g:2666:2: rule__BaseDataTypeTypeDefinitionRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__5"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group__5__Impl"
    // InternalDataDescriptionLanguage.g:2672:1: rule__BaseDataTypeTypeDefinitionRule__Group__5__Impl : ( ';' ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2676:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:2677:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:2677:1: ( ';' )
            // InternalDataDescriptionLanguage.g:2678:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getSemicolonKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group__5__Impl"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group_4__0"
    // InternalDataDescriptionLanguage.g:2688:1: rule__BaseDataTypeTypeDefinitionRule__Group_4__0 : rule__BaseDataTypeTypeDefinitionRule__Group_4__0__Impl rule__BaseDataTypeTypeDefinitionRule__Group_4__1 ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2692:1: ( rule__BaseDataTypeTypeDefinitionRule__Group_4__0__Impl rule__BaseDataTypeTypeDefinitionRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:2693:2: rule__BaseDataTypeTypeDefinitionRule__Group_4__0__Impl rule__BaseDataTypeTypeDefinitionRule__Group_4__1
            {
            pushFollow(FOLLOW_18);
            rule__BaseDataTypeTypeDefinitionRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group_4__0"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group_4__0__Impl"
    // InternalDataDescriptionLanguage.g:2700:1: rule__BaseDataTypeTypeDefinitionRule__Group_4__0__Impl : ( 'with' ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2704:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:2705:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:2705:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:2706:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getWithKeyword_4_0()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getWithKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group_4__0__Impl"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group_4__1"
    // InternalDataDescriptionLanguage.g:2715:1: rule__BaseDataTypeTypeDefinitionRule__Group_4__1 : rule__BaseDataTypeTypeDefinitionRule__Group_4__1__Impl rule__BaseDataTypeTypeDefinitionRule__Group_4__2 ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2719:1: ( rule__BaseDataTypeTypeDefinitionRule__Group_4__1__Impl rule__BaseDataTypeTypeDefinitionRule__Group_4__2 )
            // InternalDataDescriptionLanguage.g:2720:2: rule__BaseDataTypeTypeDefinitionRule__Group_4__1__Impl rule__BaseDataTypeTypeDefinitionRule__Group_4__2
            {
            pushFollow(FOLLOW_8);
            rule__BaseDataTypeTypeDefinitionRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group_4__1"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group_4__1__Impl"
    // InternalDataDescriptionLanguage.g:2727:1: rule__BaseDataTypeTypeDefinitionRule__Group_4__1__Impl : ( 'constraints' ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2731:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:2732:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:2732:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:2733:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getConstraintsKeyword_4_1()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getConstraintsKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group_4__1__Impl"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group_4__2"
    // InternalDataDescriptionLanguage.g:2742:1: rule__BaseDataTypeTypeDefinitionRule__Group_4__2 : rule__BaseDataTypeTypeDefinitionRule__Group_4__2__Impl rule__BaseDataTypeTypeDefinitionRule__Group_4__3 ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2746:1: ( rule__BaseDataTypeTypeDefinitionRule__Group_4__2__Impl rule__BaseDataTypeTypeDefinitionRule__Group_4__3 )
            // InternalDataDescriptionLanguage.g:2747:2: rule__BaseDataTypeTypeDefinitionRule__Group_4__2__Impl rule__BaseDataTypeTypeDefinitionRule__Group_4__3
            {
            pushFollow(FOLLOW_13);
            rule__BaseDataTypeTypeDefinitionRule__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group_4__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group_4__2"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group_4__2__Impl"
    // InternalDataDescriptionLanguage.g:2754:1: rule__BaseDataTypeTypeDefinitionRule__Group_4__2__Impl : ( ':' ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2758:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:2759:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:2759:1: ( ':' )
            // InternalDataDescriptionLanguage.g:2760:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getColonKeyword_4_2()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getColonKeyword_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group_4__2__Impl"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group_4__3"
    // InternalDataDescriptionLanguage.g:2769:1: rule__BaseDataTypeTypeDefinitionRule__Group_4__3 : rule__BaseDataTypeTypeDefinitionRule__Group_4__3__Impl ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2773:1: ( rule__BaseDataTypeTypeDefinitionRule__Group_4__3__Impl )
            // InternalDataDescriptionLanguage.g:2774:2: rule__BaseDataTypeTypeDefinitionRule__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BaseDataTypeTypeDefinitionRule__Group_4__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group_4__3"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__Group_4__3__Impl"
    // InternalDataDescriptionLanguage.g:2780:1: rule__BaseDataTypeTypeDefinitionRule__Group_4__3__Impl : ( ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3 )* ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2784:1: ( ( ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3 )* ) )
            // InternalDataDescriptionLanguage.g:2785:1: ( ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3 )* )
            {
            // InternalDataDescriptionLanguage.g:2785:1: ( ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3 )* )
            // InternalDataDescriptionLanguage.g:2786:2: ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getConstraintsAssignment_4_3()); 
            }
            // InternalDataDescriptionLanguage.g:2787:2: ( rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_QUOTED_ID && LA25_0<=RULE_STRING)||LA25_0==15||(LA25_0>=30 && LA25_0<=31)||LA25_0==60||LA25_0==66||LA25_0==71||LA25_0==76||(LA25_0>=88 && LA25_0<=89)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2787:3: rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getConstraintsAssignment_4_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__Group_4__3__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__0"
    // InternalDataDescriptionLanguage.g:2796:1: rule__EnumTypeDefinitionRule__Group__0 : rule__EnumTypeDefinitionRule__Group__0__Impl rule__EnumTypeDefinitionRule__Group__1 ;
    public final void rule__EnumTypeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2800:1: ( rule__EnumTypeDefinitionRule__Group__0__Impl rule__EnumTypeDefinitionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:2801:2: rule__EnumTypeDefinitionRule__Group__0__Impl rule__EnumTypeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__EnumTypeDefinitionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__0"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:2808:1: rule__EnumTypeDefinitionRule__Group__0__Impl : ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__EnumTypeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2812:1: ( ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:2813:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:2813:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:2814:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:2815:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==79) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2815:3: rule__EnumTypeDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__EnumTypeDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__1"
    // InternalDataDescriptionLanguage.g:2823:1: rule__EnumTypeDefinitionRule__Group__1 : rule__EnumTypeDefinitionRule__Group__1__Impl rule__EnumTypeDefinitionRule__Group__2 ;
    public final void rule__EnumTypeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2827:1: ( rule__EnumTypeDefinitionRule__Group__1__Impl rule__EnumTypeDefinitionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:2828:2: rule__EnumTypeDefinitionRule__Group__1__Impl rule__EnumTypeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__EnumTypeDefinitionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__1"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:2835:1: rule__EnumTypeDefinitionRule__Group__1__Impl : ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2839:1: ( ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:2840:1: ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:2840:1: ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:2841:2: ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getScaleAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:2842:2: ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 )
            // InternalDataDescriptionLanguage.g:2842:3: rule__EnumTypeDefinitionRule__ScaleAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__ScaleAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getScaleAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__2"
    // InternalDataDescriptionLanguage.g:2850:1: rule__EnumTypeDefinitionRule__Group__2 : rule__EnumTypeDefinitionRule__Group__2__Impl rule__EnumTypeDefinitionRule__Group__3 ;
    public final void rule__EnumTypeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2854:1: ( rule__EnumTypeDefinitionRule__Group__2__Impl rule__EnumTypeDefinitionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:2855:2: rule__EnumTypeDefinitionRule__Group__2__Impl rule__EnumTypeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__EnumTypeDefinitionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__2"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:2862:1: rule__EnumTypeDefinitionRule__Group__2__Impl : ( 'enum' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2866:1: ( ( 'enum' ) )
            // InternalDataDescriptionLanguage.g:2867:1: ( 'enum' )
            {
            // InternalDataDescriptionLanguage.g:2867:1: ( 'enum' )
            // InternalDataDescriptionLanguage.g:2868:2: 'enum'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getEnumKeyword_2()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getEnumKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__3"
    // InternalDataDescriptionLanguage.g:2877:1: rule__EnumTypeDefinitionRule__Group__3 : rule__EnumTypeDefinitionRule__Group__3__Impl rule__EnumTypeDefinitionRule__Group__4 ;
    public final void rule__EnumTypeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2881:1: ( rule__EnumTypeDefinitionRule__Group__3__Impl rule__EnumTypeDefinitionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:2882:2: rule__EnumTypeDefinitionRule__Group__3__Impl rule__EnumTypeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__EnumTypeDefinitionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__3"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__3__Impl"
    // InternalDataDescriptionLanguage.g:2889:1: rule__EnumTypeDefinitionRule__Group__3__Impl : ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2893:1: ( ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) ) )
            // InternalDataDescriptionLanguage.g:2894:1: ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) )
            {
            // InternalDataDescriptionLanguage.g:2894:1: ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) )
            // InternalDataDescriptionLanguage.g:2895:2: ( rule__EnumTypeDefinitionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDataDescriptionLanguage.g:2896:2: ( rule__EnumTypeDefinitionRule__NameAssignment_3 )
            // InternalDataDescriptionLanguage.g:2896:3: rule__EnumTypeDefinitionRule__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__4"
    // InternalDataDescriptionLanguage.g:2904:1: rule__EnumTypeDefinitionRule__Group__4 : rule__EnumTypeDefinitionRule__Group__4__Impl rule__EnumTypeDefinitionRule__Group__5 ;
    public final void rule__EnumTypeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2908:1: ( rule__EnumTypeDefinitionRule__Group__4__Impl rule__EnumTypeDefinitionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:2909:2: rule__EnumTypeDefinitionRule__Group__4__Impl rule__EnumTypeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__EnumTypeDefinitionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__4"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__4__Impl"
    // InternalDataDescriptionLanguage.g:2916:1: rule__EnumTypeDefinitionRule__Group__4__Impl : ( '(' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2920:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:2921:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:2921:1: ( '(' )
            // InternalDataDescriptionLanguage.g:2922:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getLeftParenthesisKeyword_4()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getLeftParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__4__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__5"
    // InternalDataDescriptionLanguage.g:2931:1: rule__EnumTypeDefinitionRule__Group__5 : rule__EnumTypeDefinitionRule__Group__5__Impl rule__EnumTypeDefinitionRule__Group__6 ;
    public final void rule__EnumTypeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2935:1: ( rule__EnumTypeDefinitionRule__Group__5__Impl rule__EnumTypeDefinitionRule__Group__6 )
            // InternalDataDescriptionLanguage.g:2936:2: rule__EnumTypeDefinitionRule__Group__5__Impl rule__EnumTypeDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__EnumTypeDefinitionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__5"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__5__Impl"
    // InternalDataDescriptionLanguage.g:2943:1: rule__EnumTypeDefinitionRule__Group__5__Impl : ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2947:1: ( ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) ) )
            // InternalDataDescriptionLanguage.g:2948:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) )
            {
            // InternalDataDescriptionLanguage.g:2948:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) )
            // InternalDataDescriptionLanguage.g:2949:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsAssignment_5()); 
            }
            // InternalDataDescriptionLanguage.g:2950:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 )
            // InternalDataDescriptionLanguage.g:2950:3: rule__EnumTypeDefinitionRule__LiteralsAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__LiteralsAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__5__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__6"
    // InternalDataDescriptionLanguage.g:2958:1: rule__EnumTypeDefinitionRule__Group__6 : rule__EnumTypeDefinitionRule__Group__6__Impl rule__EnumTypeDefinitionRule__Group__7 ;
    public final void rule__EnumTypeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2962:1: ( rule__EnumTypeDefinitionRule__Group__6__Impl rule__EnumTypeDefinitionRule__Group__7 )
            // InternalDataDescriptionLanguage.g:2963:2: rule__EnumTypeDefinitionRule__Group__6__Impl rule__EnumTypeDefinitionRule__Group__7
            {
            pushFollow(FOLLOW_21);
            rule__EnumTypeDefinitionRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__6"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__6__Impl"
    // InternalDataDescriptionLanguage.g:2970:1: rule__EnumTypeDefinitionRule__Group__6__Impl : ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* ) ;
    public final void rule__EnumTypeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2974:1: ( ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* ) )
            // InternalDataDescriptionLanguage.g:2975:1: ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* )
            {
            // InternalDataDescriptionLanguage.g:2975:1: ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* )
            // InternalDataDescriptionLanguage.g:2976:2: ( rule__EnumTypeDefinitionRule__Group_6__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup_6()); 
            }
            // InternalDataDescriptionLanguage.g:2977:2: ( rule__EnumTypeDefinitionRule__Group_6__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==68) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2977:3: rule__EnumTypeDefinitionRule__Group_6__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__EnumTypeDefinitionRule__Group_6__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__6__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__7"
    // InternalDataDescriptionLanguage.g:2985:1: rule__EnumTypeDefinitionRule__Group__7 : rule__EnumTypeDefinitionRule__Group__7__Impl rule__EnumTypeDefinitionRule__Group__8 ;
    public final void rule__EnumTypeDefinitionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:2989:1: ( rule__EnumTypeDefinitionRule__Group__7__Impl rule__EnumTypeDefinitionRule__Group__8 )
            // InternalDataDescriptionLanguage.g:2990:2: rule__EnumTypeDefinitionRule__Group__7__Impl rule__EnumTypeDefinitionRule__Group__8
            {
            pushFollow(FOLLOW_17);
            rule__EnumTypeDefinitionRule__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__7"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__7__Impl"
    // InternalDataDescriptionLanguage.g:2997:1: rule__EnumTypeDefinitionRule__Group__7__Impl : ( ')' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3001:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:3002:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:3002:1: ( ')' )
            // InternalDataDescriptionLanguage.g:3003:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getRightParenthesisKeyword_7()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getRightParenthesisKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__7__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__8"
    // InternalDataDescriptionLanguage.g:3012:1: rule__EnumTypeDefinitionRule__Group__8 : rule__EnumTypeDefinitionRule__Group__8__Impl rule__EnumTypeDefinitionRule__Group__9 ;
    public final void rule__EnumTypeDefinitionRule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3016:1: ( rule__EnumTypeDefinitionRule__Group__8__Impl rule__EnumTypeDefinitionRule__Group__9 )
            // InternalDataDescriptionLanguage.g:3017:2: rule__EnumTypeDefinitionRule__Group__8__Impl rule__EnumTypeDefinitionRule__Group__9
            {
            pushFollow(FOLLOW_17);
            rule__EnumTypeDefinitionRule__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__9();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__8"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__8__Impl"
    // InternalDataDescriptionLanguage.g:3024:1: rule__EnumTypeDefinitionRule__Group__8__Impl : ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? ) ;
    public final void rule__EnumTypeDefinitionRule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3028:1: ( ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? ) )
            // InternalDataDescriptionLanguage.g:3029:1: ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? )
            {
            // InternalDataDescriptionLanguage.g:3029:1: ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? )
            // InternalDataDescriptionLanguage.g:3030:2: ( rule__EnumTypeDefinitionRule__Group_8__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup_8()); 
            }
            // InternalDataDescriptionLanguage.g:3031:2: ( rule__EnumTypeDefinitionRule__Group_8__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==64) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3031:3: rule__EnumTypeDefinitionRule__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EnumTypeDefinitionRule__Group_8__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__8__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__9"
    // InternalDataDescriptionLanguage.g:3039:1: rule__EnumTypeDefinitionRule__Group__9 : rule__EnumTypeDefinitionRule__Group__9__Impl ;
    public final void rule__EnumTypeDefinitionRule__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3043:1: ( rule__EnumTypeDefinitionRule__Group__9__Impl )
            // InternalDataDescriptionLanguage.g:3044:2: rule__EnumTypeDefinitionRule__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__9"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__9__Impl"
    // InternalDataDescriptionLanguage.g:3050:1: rule__EnumTypeDefinitionRule__Group__9__Impl : ( ';' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3054:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:3055:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:3055:1: ( ';' )
            // InternalDataDescriptionLanguage.g:3056:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getSemicolonKeyword_9()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getSemicolonKeyword_9()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group__9__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_6__0"
    // InternalDataDescriptionLanguage.g:3066:1: rule__EnumTypeDefinitionRule__Group_6__0 : rule__EnumTypeDefinitionRule__Group_6__0__Impl rule__EnumTypeDefinitionRule__Group_6__1 ;
    public final void rule__EnumTypeDefinitionRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3070:1: ( rule__EnumTypeDefinitionRule__Group_6__0__Impl rule__EnumTypeDefinitionRule__Group_6__1 )
            // InternalDataDescriptionLanguage.g:3071:2: rule__EnumTypeDefinitionRule__Group_6__0__Impl rule__EnumTypeDefinitionRule__Group_6__1
            {
            pushFollow(FOLLOW_5);
            rule__EnumTypeDefinitionRule__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_6__0"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_6__0__Impl"
    // InternalDataDescriptionLanguage.g:3078:1: rule__EnumTypeDefinitionRule__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3082:1: ( ( ',' ) )
            // InternalDataDescriptionLanguage.g:3083:1: ( ',' )
            {
            // InternalDataDescriptionLanguage.g:3083:1: ( ',' )
            // InternalDataDescriptionLanguage.g:3084:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getCommaKeyword_6_0()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getCommaKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_6__0__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_6__1"
    // InternalDataDescriptionLanguage.g:3093:1: rule__EnumTypeDefinitionRule__Group_6__1 : rule__EnumTypeDefinitionRule__Group_6__1__Impl ;
    public final void rule__EnumTypeDefinitionRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3097:1: ( rule__EnumTypeDefinitionRule__Group_6__1__Impl )
            // InternalDataDescriptionLanguage.g:3098:2: rule__EnumTypeDefinitionRule__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_6__1"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_6__1__Impl"
    // InternalDataDescriptionLanguage.g:3104:1: rule__EnumTypeDefinitionRule__Group_6__1__Impl : ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3108:1: ( ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) ) )
            // InternalDataDescriptionLanguage.g:3109:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3109:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) )
            // InternalDataDescriptionLanguage.g:3110:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsAssignment_6_1()); 
            }
            // InternalDataDescriptionLanguage.g:3111:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 )
            // InternalDataDescriptionLanguage.g:3111:3: rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsAssignment_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_6__1__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_8__0"
    // InternalDataDescriptionLanguage.g:3120:1: rule__EnumTypeDefinitionRule__Group_8__0 : rule__EnumTypeDefinitionRule__Group_8__0__Impl rule__EnumTypeDefinitionRule__Group_8__1 ;
    public final void rule__EnumTypeDefinitionRule__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3124:1: ( rule__EnumTypeDefinitionRule__Group_8__0__Impl rule__EnumTypeDefinitionRule__Group_8__1 )
            // InternalDataDescriptionLanguage.g:3125:2: rule__EnumTypeDefinitionRule__Group_8__0__Impl rule__EnumTypeDefinitionRule__Group_8__1
            {
            pushFollow(FOLLOW_18);
            rule__EnumTypeDefinitionRule__Group_8__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group_8__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_8__0"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_8__0__Impl"
    // InternalDataDescriptionLanguage.g:3132:1: rule__EnumTypeDefinitionRule__Group_8__0__Impl : ( 'with' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3136:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:3137:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:3137:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:3138:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getWithKeyword_8_0()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getWithKeyword_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_8__0__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_8__1"
    // InternalDataDescriptionLanguage.g:3147:1: rule__EnumTypeDefinitionRule__Group_8__1 : rule__EnumTypeDefinitionRule__Group_8__1__Impl rule__EnumTypeDefinitionRule__Group_8__2 ;
    public final void rule__EnumTypeDefinitionRule__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3151:1: ( rule__EnumTypeDefinitionRule__Group_8__1__Impl rule__EnumTypeDefinitionRule__Group_8__2 )
            // InternalDataDescriptionLanguage.g:3152:2: rule__EnumTypeDefinitionRule__Group_8__1__Impl rule__EnumTypeDefinitionRule__Group_8__2
            {
            pushFollow(FOLLOW_8);
            rule__EnumTypeDefinitionRule__Group_8__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group_8__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_8__1"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_8__1__Impl"
    // InternalDataDescriptionLanguage.g:3159:1: rule__EnumTypeDefinitionRule__Group_8__1__Impl : ( 'constraints' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3163:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:3164:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:3164:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:3165:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsKeyword_8_1()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsKeyword_8_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_8__1__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_8__2"
    // InternalDataDescriptionLanguage.g:3174:1: rule__EnumTypeDefinitionRule__Group_8__2 : rule__EnumTypeDefinitionRule__Group_8__2__Impl rule__EnumTypeDefinitionRule__Group_8__3 ;
    public final void rule__EnumTypeDefinitionRule__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3178:1: ( rule__EnumTypeDefinitionRule__Group_8__2__Impl rule__EnumTypeDefinitionRule__Group_8__3 )
            // InternalDataDescriptionLanguage.g:3179:2: rule__EnumTypeDefinitionRule__Group_8__2__Impl rule__EnumTypeDefinitionRule__Group_8__3
            {
            pushFollow(FOLLOW_13);
            rule__EnumTypeDefinitionRule__Group_8__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group_8__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_8__2"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_8__2__Impl"
    // InternalDataDescriptionLanguage.g:3186:1: rule__EnumTypeDefinitionRule__Group_8__2__Impl : ( ':' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3190:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:3191:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:3191:1: ( ':' )
            // InternalDataDescriptionLanguage.g:3192:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getColonKeyword_8_2()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getColonKeyword_8_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_8__2__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_8__3"
    // InternalDataDescriptionLanguage.g:3201:1: rule__EnumTypeDefinitionRule__Group_8__3 : rule__EnumTypeDefinitionRule__Group_8__3__Impl ;
    public final void rule__EnumTypeDefinitionRule__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3205:1: ( rule__EnumTypeDefinitionRule__Group_8__3__Impl )
            // InternalDataDescriptionLanguage.g:3206:2: rule__EnumTypeDefinitionRule__Group_8__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumTypeDefinitionRule__Group_8__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_8__3"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group_8__3__Impl"
    // InternalDataDescriptionLanguage.g:3212:1: rule__EnumTypeDefinitionRule__Group_8__3__Impl : ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3216:1: ( ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* ) )
            // InternalDataDescriptionLanguage.g:3217:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* )
            {
            // InternalDataDescriptionLanguage.g:3217:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* )
            // InternalDataDescriptionLanguage.g:3218:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsAssignment_8_3()); 
            }
            // InternalDataDescriptionLanguage.g:3219:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=RULE_QUOTED_ID && LA29_0<=RULE_STRING)||LA29_0==15||(LA29_0>=30 && LA29_0<=31)||LA29_0==60||LA29_0==66||LA29_0==71||LA29_0==76||(LA29_0>=88 && LA29_0<=89)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3219:3: rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsAssignment_8_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__Group_8__3__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__0"
    // InternalDataDescriptionLanguage.g:3228:1: rule__TypedBaseDataDescriptionRule__Group__0 : rule__TypedBaseDataDescriptionRule__Group__0__Impl rule__TypedBaseDataDescriptionRule__Group__1 ;
    public final void rule__TypedBaseDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3232:1: ( rule__TypedBaseDataDescriptionRule__Group__0__Impl rule__TypedBaseDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3233:2: rule__TypedBaseDataDescriptionRule__Group__0__Impl rule__TypedBaseDataDescriptionRule__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__TypedBaseDataDescriptionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__0"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:3240:1: rule__TypedBaseDataDescriptionRule__Group__0__Impl : ( ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3244:1: ( ( ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:3245:1: ( ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:3245:1: ( ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:3246:2: ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3247:2: ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==79) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3247:3: rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__0__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__1"
    // InternalDataDescriptionLanguage.g:3255:1: rule__TypedBaseDataDescriptionRule__Group__1 : rule__TypedBaseDataDescriptionRule__Group__1__Impl rule__TypedBaseDataDescriptionRule__Group__2 ;
    public final void rule__TypedBaseDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3259:1: ( rule__TypedBaseDataDescriptionRule__Group__1__Impl rule__TypedBaseDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:3260:2: rule__TypedBaseDataDescriptionRule__Group__1__Impl rule__TypedBaseDataDescriptionRule__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__TypedBaseDataDescriptionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__1"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:3267:1: rule__TypedBaseDataDescriptionRule__Group__1__Impl : ( ( rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1 ) ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3271:1: ( ( ( rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:3272:1: ( ( rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:3272:1: ( ( rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:3273:2: ( rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getRepresentationAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3274:2: ( rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1 )
            // InternalDataDescriptionLanguage.g:3274:3: rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getRepresentationAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__1__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__2"
    // InternalDataDescriptionLanguage.g:3282:1: rule__TypedBaseDataDescriptionRule__Group__2 : rule__TypedBaseDataDescriptionRule__Group__2__Impl rule__TypedBaseDataDescriptionRule__Group__3 ;
    public final void rule__TypedBaseDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3286:1: ( rule__TypedBaseDataDescriptionRule__Group__2__Impl rule__TypedBaseDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:3287:2: rule__TypedBaseDataDescriptionRule__Group__2__Impl rule__TypedBaseDataDescriptionRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__TypedBaseDataDescriptionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__2"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:3294:1: rule__TypedBaseDataDescriptionRule__Group__2__Impl : ( 'data' ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3298:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:3299:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:3299:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:3300:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getDataKeyword_2()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getDataKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__2__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__3"
    // InternalDataDescriptionLanguage.g:3309:1: rule__TypedBaseDataDescriptionRule__Group__3 : rule__TypedBaseDataDescriptionRule__Group__3__Impl rule__TypedBaseDataDescriptionRule__Group__4 ;
    public final void rule__TypedBaseDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3313:1: ( rule__TypedBaseDataDescriptionRule__Group__3__Impl rule__TypedBaseDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:3314:2: rule__TypedBaseDataDescriptionRule__Group__3__Impl rule__TypedBaseDataDescriptionRule__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__TypedBaseDataDescriptionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__3"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__3__Impl"
    // InternalDataDescriptionLanguage.g:3321:1: rule__TypedBaseDataDescriptionRule__Group__3__Impl : ( ( rule__TypedBaseDataDescriptionRule__NameAssignment_3 ) ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3325:1: ( ( ( rule__TypedBaseDataDescriptionRule__NameAssignment_3 ) ) )
            // InternalDataDescriptionLanguage.g:3326:1: ( ( rule__TypedBaseDataDescriptionRule__NameAssignment_3 ) )
            {
            // InternalDataDescriptionLanguage.g:3326:1: ( ( rule__TypedBaseDataDescriptionRule__NameAssignment_3 ) )
            // InternalDataDescriptionLanguage.g:3327:2: ( rule__TypedBaseDataDescriptionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDataDescriptionLanguage.g:3328:2: ( rule__TypedBaseDataDescriptionRule__NameAssignment_3 )
            // InternalDataDescriptionLanguage.g:3328:3: rule__TypedBaseDataDescriptionRule__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__3__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__4"
    // InternalDataDescriptionLanguage.g:3336:1: rule__TypedBaseDataDescriptionRule__Group__4 : rule__TypedBaseDataDescriptionRule__Group__4__Impl rule__TypedBaseDataDescriptionRule__Group__5 ;
    public final void rule__TypedBaseDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3340:1: ( rule__TypedBaseDataDescriptionRule__Group__4__Impl rule__TypedBaseDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:3341:2: rule__TypedBaseDataDescriptionRule__Group__4__Impl rule__TypedBaseDataDescriptionRule__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__TypedBaseDataDescriptionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__4"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__4__Impl"
    // InternalDataDescriptionLanguage.g:3348:1: rule__TypedBaseDataDescriptionRule__Group__4__Impl : ( 'of' ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3352:1: ( ( 'of' ) )
            // InternalDataDescriptionLanguage.g:3353:1: ( 'of' )
            {
            // InternalDataDescriptionLanguage.g:3353:1: ( 'of' )
            // InternalDataDescriptionLanguage.g:3354:2: 'of'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getOfKeyword_4()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getOfKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__4__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__5"
    // InternalDataDescriptionLanguage.g:3363:1: rule__TypedBaseDataDescriptionRule__Group__5 : rule__TypedBaseDataDescriptionRule__Group__5__Impl rule__TypedBaseDataDescriptionRule__Group__6 ;
    public final void rule__TypedBaseDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3367:1: ( rule__TypedBaseDataDescriptionRule__Group__5__Impl rule__TypedBaseDataDescriptionRule__Group__6 )
            // InternalDataDescriptionLanguage.g:3368:2: rule__TypedBaseDataDescriptionRule__Group__5__Impl rule__TypedBaseDataDescriptionRule__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__TypedBaseDataDescriptionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__5"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__5__Impl"
    // InternalDataDescriptionLanguage.g:3375:1: rule__TypedBaseDataDescriptionRule__Group__5__Impl : ( 'type' ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3379:1: ( ( 'type' ) )
            // InternalDataDescriptionLanguage.g:3380:1: ( 'type' )
            {
            // InternalDataDescriptionLanguage.g:3380:1: ( 'type' )
            // InternalDataDescriptionLanguage.g:3381:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeKeyword_5()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__5__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__6"
    // InternalDataDescriptionLanguage.g:3390:1: rule__TypedBaseDataDescriptionRule__Group__6 : rule__TypedBaseDataDescriptionRule__Group__6__Impl rule__TypedBaseDataDescriptionRule__Group__7 ;
    public final void rule__TypedBaseDataDescriptionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3394:1: ( rule__TypedBaseDataDescriptionRule__Group__6__Impl rule__TypedBaseDataDescriptionRule__Group__7 )
            // InternalDataDescriptionLanguage.g:3395:2: rule__TypedBaseDataDescriptionRule__Group__6__Impl rule__TypedBaseDataDescriptionRule__Group__7
            {
            pushFollow(FOLLOW_17);
            rule__TypedBaseDataDescriptionRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__6"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__6__Impl"
    // InternalDataDescriptionLanguage.g:3402:1: rule__TypedBaseDataDescriptionRule__Group__6__Impl : ( ( rule__TypedBaseDataDescriptionRule__TypeAssignment_6 ) ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3406:1: ( ( ( rule__TypedBaseDataDescriptionRule__TypeAssignment_6 ) ) )
            // InternalDataDescriptionLanguage.g:3407:1: ( ( rule__TypedBaseDataDescriptionRule__TypeAssignment_6 ) )
            {
            // InternalDataDescriptionLanguage.g:3407:1: ( ( rule__TypedBaseDataDescriptionRule__TypeAssignment_6 ) )
            // InternalDataDescriptionLanguage.g:3408:2: ( rule__TypedBaseDataDescriptionRule__TypeAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeAssignment_6()); 
            }
            // InternalDataDescriptionLanguage.g:3409:2: ( rule__TypedBaseDataDescriptionRule__TypeAssignment_6 )
            // InternalDataDescriptionLanguage.g:3409:3: rule__TypedBaseDataDescriptionRule__TypeAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__TypeAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeAssignment_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__6__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__7"
    // InternalDataDescriptionLanguage.g:3417:1: rule__TypedBaseDataDescriptionRule__Group__7 : rule__TypedBaseDataDescriptionRule__Group__7__Impl rule__TypedBaseDataDescriptionRule__Group__8 ;
    public final void rule__TypedBaseDataDescriptionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3421:1: ( rule__TypedBaseDataDescriptionRule__Group__7__Impl rule__TypedBaseDataDescriptionRule__Group__8 )
            // InternalDataDescriptionLanguage.g:3422:2: rule__TypedBaseDataDescriptionRule__Group__7__Impl rule__TypedBaseDataDescriptionRule__Group__8
            {
            pushFollow(FOLLOW_17);
            rule__TypedBaseDataDescriptionRule__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__7"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__7__Impl"
    // InternalDataDescriptionLanguage.g:3429:1: rule__TypedBaseDataDescriptionRule__Group__7__Impl : ( ( rule__TypedBaseDataDescriptionRule__Group_7__0 )? ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3433:1: ( ( ( rule__TypedBaseDataDescriptionRule__Group_7__0 )? ) )
            // InternalDataDescriptionLanguage.g:3434:1: ( ( rule__TypedBaseDataDescriptionRule__Group_7__0 )? )
            {
            // InternalDataDescriptionLanguage.g:3434:1: ( ( rule__TypedBaseDataDescriptionRule__Group_7__0 )? )
            // InternalDataDescriptionLanguage.g:3435:2: ( rule__TypedBaseDataDescriptionRule__Group_7__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getGroup_7()); 
            }
            // InternalDataDescriptionLanguage.g:3436:2: ( rule__TypedBaseDataDescriptionRule__Group_7__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==64) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3436:3: rule__TypedBaseDataDescriptionRule__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypedBaseDataDescriptionRule__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getGroup_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__7__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__8"
    // InternalDataDescriptionLanguage.g:3444:1: rule__TypedBaseDataDescriptionRule__Group__8 : rule__TypedBaseDataDescriptionRule__Group__8__Impl ;
    public final void rule__TypedBaseDataDescriptionRule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3448:1: ( rule__TypedBaseDataDescriptionRule__Group__8__Impl )
            // InternalDataDescriptionLanguage.g:3449:2: rule__TypedBaseDataDescriptionRule__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__8"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group__8__Impl"
    // InternalDataDescriptionLanguage.g:3455:1: rule__TypedBaseDataDescriptionRule__Group__8__Impl : ( ';' ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3459:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:3460:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:3460:1: ( ';' )
            // InternalDataDescriptionLanguage.g:3461:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getSemicolonKeyword_8()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getSemicolonKeyword_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group__8__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group_7__0"
    // InternalDataDescriptionLanguage.g:3471:1: rule__TypedBaseDataDescriptionRule__Group_7__0 : rule__TypedBaseDataDescriptionRule__Group_7__0__Impl rule__TypedBaseDataDescriptionRule__Group_7__1 ;
    public final void rule__TypedBaseDataDescriptionRule__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3475:1: ( rule__TypedBaseDataDescriptionRule__Group_7__0__Impl rule__TypedBaseDataDescriptionRule__Group_7__1 )
            // InternalDataDescriptionLanguage.g:3476:2: rule__TypedBaseDataDescriptionRule__Group_7__0__Impl rule__TypedBaseDataDescriptionRule__Group_7__1
            {
            pushFollow(FOLLOW_18);
            rule__TypedBaseDataDescriptionRule__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group_7__0"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group_7__0__Impl"
    // InternalDataDescriptionLanguage.g:3483:1: rule__TypedBaseDataDescriptionRule__Group_7__0__Impl : ( 'with' ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3487:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:3488:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:3488:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:3489:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getWithKeyword_7_0()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getWithKeyword_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group_7__0__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group_7__1"
    // InternalDataDescriptionLanguage.g:3498:1: rule__TypedBaseDataDescriptionRule__Group_7__1 : rule__TypedBaseDataDescriptionRule__Group_7__1__Impl rule__TypedBaseDataDescriptionRule__Group_7__2 ;
    public final void rule__TypedBaseDataDescriptionRule__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3502:1: ( rule__TypedBaseDataDescriptionRule__Group_7__1__Impl rule__TypedBaseDataDescriptionRule__Group_7__2 )
            // InternalDataDescriptionLanguage.g:3503:2: rule__TypedBaseDataDescriptionRule__Group_7__1__Impl rule__TypedBaseDataDescriptionRule__Group_7__2
            {
            pushFollow(FOLLOW_8);
            rule__TypedBaseDataDescriptionRule__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group_7__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group_7__1"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group_7__1__Impl"
    // InternalDataDescriptionLanguage.g:3510:1: rule__TypedBaseDataDescriptionRule__Group_7__1__Impl : ( 'constraints' ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3514:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:3515:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:3515:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:3516:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsKeyword_7_1()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsKeyword_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group_7__1__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group_7__2"
    // InternalDataDescriptionLanguage.g:3525:1: rule__TypedBaseDataDescriptionRule__Group_7__2 : rule__TypedBaseDataDescriptionRule__Group_7__2__Impl rule__TypedBaseDataDescriptionRule__Group_7__3 ;
    public final void rule__TypedBaseDataDescriptionRule__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3529:1: ( rule__TypedBaseDataDescriptionRule__Group_7__2__Impl rule__TypedBaseDataDescriptionRule__Group_7__3 )
            // InternalDataDescriptionLanguage.g:3530:2: rule__TypedBaseDataDescriptionRule__Group_7__2__Impl rule__TypedBaseDataDescriptionRule__Group_7__3
            {
            pushFollow(FOLLOW_13);
            rule__TypedBaseDataDescriptionRule__Group_7__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group_7__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group_7__2"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group_7__2__Impl"
    // InternalDataDescriptionLanguage.g:3537:1: rule__TypedBaseDataDescriptionRule__Group_7__2__Impl : ( ':' ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3541:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:3542:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:3542:1: ( ':' )
            // InternalDataDescriptionLanguage.g:3543:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getColonKeyword_7_2()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getColonKeyword_7_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group_7__2__Impl"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group_7__3"
    // InternalDataDescriptionLanguage.g:3552:1: rule__TypedBaseDataDescriptionRule__Group_7__3 : rule__TypedBaseDataDescriptionRule__Group_7__3__Impl ;
    public final void rule__TypedBaseDataDescriptionRule__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3556:1: ( rule__TypedBaseDataDescriptionRule__Group_7__3__Impl )
            // InternalDataDescriptionLanguage.g:3557:2: rule__TypedBaseDataDescriptionRule__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypedBaseDataDescriptionRule__Group_7__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group_7__3"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__Group_7__3__Impl"
    // InternalDataDescriptionLanguage.g:3563:1: rule__TypedBaseDataDescriptionRule__Group_7__3__Impl : ( ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3 )* ) ;
    public final void rule__TypedBaseDataDescriptionRule__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3567:1: ( ( ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3 )* ) )
            // InternalDataDescriptionLanguage.g:3568:1: ( ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3 )* )
            {
            // InternalDataDescriptionLanguage.g:3568:1: ( ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3 )* )
            // InternalDataDescriptionLanguage.g:3569:2: ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsAssignment_7_3()); 
            }
            // InternalDataDescriptionLanguage.g:3570:2: ( rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_QUOTED_ID && LA32_0<=RULE_STRING)||LA32_0==15||(LA32_0>=30 && LA32_0<=31)||LA32_0==60||LA32_0==66||LA32_0==71||LA32_0==76||(LA32_0>=88 && LA32_0<=89)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3570:3: rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsAssignment_7_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__Group_7__3__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__0"
    // InternalDataDescriptionLanguage.g:3579:1: rule__UntypedBaseDataDescriptionRule__Group__0 : rule__UntypedBaseDataDescriptionRule__Group__0__Impl rule__UntypedBaseDataDescriptionRule__Group__1 ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3583:1: ( rule__UntypedBaseDataDescriptionRule__Group__0__Impl rule__UntypedBaseDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3584:2: rule__UntypedBaseDataDescriptionRule__Group__0__Impl rule__UntypedBaseDataDescriptionRule__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__UntypedBaseDataDescriptionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__0"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:3591:1: rule__UntypedBaseDataDescriptionRule__Group__0__Impl : ( ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3595:1: ( ( ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:3596:1: ( ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:3596:1: ( ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:3597:2: ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3598:2: ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==79) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3598:3: rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__0__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__1"
    // InternalDataDescriptionLanguage.g:3606:1: rule__UntypedBaseDataDescriptionRule__Group__1 : rule__UntypedBaseDataDescriptionRule__Group__1__Impl rule__UntypedBaseDataDescriptionRule__Group__2 ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3610:1: ( rule__UntypedBaseDataDescriptionRule__Group__1__Impl rule__UntypedBaseDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:3611:2: rule__UntypedBaseDataDescriptionRule__Group__1__Impl rule__UntypedBaseDataDescriptionRule__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__UntypedBaseDataDescriptionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__1"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:3618:1: rule__UntypedBaseDataDescriptionRule__Group__1__Impl : ( ( rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1 )? ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3622:1: ( ( ( rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1 )? ) )
            // InternalDataDescriptionLanguage.g:3623:1: ( ( rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1 )? )
            {
            // InternalDataDescriptionLanguage.g:3623:1: ( ( rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1 )? )
            // InternalDataDescriptionLanguage.g:3624:2: ( rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getScaleAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:3625:2: ( rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=16 && LA34_0<=19)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3625:3: rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getScaleAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__1__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__2"
    // InternalDataDescriptionLanguage.g:3633:1: rule__UntypedBaseDataDescriptionRule__Group__2 : rule__UntypedBaseDataDescriptionRule__Group__2__Impl rule__UntypedBaseDataDescriptionRule__Group__3 ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3637:1: ( rule__UntypedBaseDataDescriptionRule__Group__2__Impl rule__UntypedBaseDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:3638:2: rule__UntypedBaseDataDescriptionRule__Group__2__Impl rule__UntypedBaseDataDescriptionRule__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__UntypedBaseDataDescriptionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__2"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:3645:1: rule__UntypedBaseDataDescriptionRule__Group__2__Impl : ( ( rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2 ) ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3649:1: ( ( ( rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:3650:1: ( ( rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:3650:1: ( ( rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:3651:2: ( rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getRepresentationAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:3652:2: ( rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2 )
            // InternalDataDescriptionLanguage.g:3652:3: rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getRepresentationAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__2__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__3"
    // InternalDataDescriptionLanguage.g:3660:1: rule__UntypedBaseDataDescriptionRule__Group__3 : rule__UntypedBaseDataDescriptionRule__Group__3__Impl rule__UntypedBaseDataDescriptionRule__Group__4 ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3664:1: ( rule__UntypedBaseDataDescriptionRule__Group__3__Impl rule__UntypedBaseDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:3665:2: rule__UntypedBaseDataDescriptionRule__Group__3__Impl rule__UntypedBaseDataDescriptionRule__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__UntypedBaseDataDescriptionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__3"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__3__Impl"
    // InternalDataDescriptionLanguage.g:3672:1: rule__UntypedBaseDataDescriptionRule__Group__3__Impl : ( 'data' ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3676:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:3677:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:3677:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:3678:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getDataKeyword_3()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getDataKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__3__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__4"
    // InternalDataDescriptionLanguage.g:3687:1: rule__UntypedBaseDataDescriptionRule__Group__4 : rule__UntypedBaseDataDescriptionRule__Group__4__Impl rule__UntypedBaseDataDescriptionRule__Group__5 ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3691:1: ( rule__UntypedBaseDataDescriptionRule__Group__4__Impl rule__UntypedBaseDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:3692:2: rule__UntypedBaseDataDescriptionRule__Group__4__Impl rule__UntypedBaseDataDescriptionRule__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__UntypedBaseDataDescriptionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__4"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__4__Impl"
    // InternalDataDescriptionLanguage.g:3699:1: rule__UntypedBaseDataDescriptionRule__Group__4__Impl : ( ( rule__UntypedBaseDataDescriptionRule__NameAssignment_4 ) ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3703:1: ( ( ( rule__UntypedBaseDataDescriptionRule__NameAssignment_4 ) ) )
            // InternalDataDescriptionLanguage.g:3704:1: ( ( rule__UntypedBaseDataDescriptionRule__NameAssignment_4 ) )
            {
            // InternalDataDescriptionLanguage.g:3704:1: ( ( rule__UntypedBaseDataDescriptionRule__NameAssignment_4 ) )
            // InternalDataDescriptionLanguage.g:3705:2: ( rule__UntypedBaseDataDescriptionRule__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getNameAssignment_4()); 
            }
            // InternalDataDescriptionLanguage.g:3706:2: ( rule__UntypedBaseDataDescriptionRule__NameAssignment_4 )
            // InternalDataDescriptionLanguage.g:3706:3: rule__UntypedBaseDataDescriptionRule__NameAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__NameAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getNameAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__4__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__5"
    // InternalDataDescriptionLanguage.g:3714:1: rule__UntypedBaseDataDescriptionRule__Group__5 : rule__UntypedBaseDataDescriptionRule__Group__5__Impl rule__UntypedBaseDataDescriptionRule__Group__6 ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3718:1: ( rule__UntypedBaseDataDescriptionRule__Group__5__Impl rule__UntypedBaseDataDescriptionRule__Group__6 )
            // InternalDataDescriptionLanguage.g:3719:2: rule__UntypedBaseDataDescriptionRule__Group__5__Impl rule__UntypedBaseDataDescriptionRule__Group__6
            {
            pushFollow(FOLLOW_17);
            rule__UntypedBaseDataDescriptionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__5"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__5__Impl"
    // InternalDataDescriptionLanguage.g:3726:1: rule__UntypedBaseDataDescriptionRule__Group__5__Impl : ( ( rule__UntypedBaseDataDescriptionRule__Group_5__0 )? ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3730:1: ( ( ( rule__UntypedBaseDataDescriptionRule__Group_5__0 )? ) )
            // InternalDataDescriptionLanguage.g:3731:1: ( ( rule__UntypedBaseDataDescriptionRule__Group_5__0 )? )
            {
            // InternalDataDescriptionLanguage.g:3731:1: ( ( rule__UntypedBaseDataDescriptionRule__Group_5__0 )? )
            // InternalDataDescriptionLanguage.g:3732:2: ( rule__UntypedBaseDataDescriptionRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getGroup_5()); 
            }
            // InternalDataDescriptionLanguage.g:3733:2: ( rule__UntypedBaseDataDescriptionRule__Group_5__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==64) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3733:3: rule__UntypedBaseDataDescriptionRule__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UntypedBaseDataDescriptionRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__5__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__6"
    // InternalDataDescriptionLanguage.g:3741:1: rule__UntypedBaseDataDescriptionRule__Group__6 : rule__UntypedBaseDataDescriptionRule__Group__6__Impl ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3745:1: ( rule__UntypedBaseDataDescriptionRule__Group__6__Impl )
            // InternalDataDescriptionLanguage.g:3746:2: rule__UntypedBaseDataDescriptionRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__6"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group__6__Impl"
    // InternalDataDescriptionLanguage.g:3752:1: rule__UntypedBaseDataDescriptionRule__Group__6__Impl : ( ';' ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3756:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:3757:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:3757:1: ( ';' )
            // InternalDataDescriptionLanguage.g:3758:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getSemicolonKeyword_6()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getSemicolonKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group__6__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group_5__0"
    // InternalDataDescriptionLanguage.g:3768:1: rule__UntypedBaseDataDescriptionRule__Group_5__0 : rule__UntypedBaseDataDescriptionRule__Group_5__0__Impl rule__UntypedBaseDataDescriptionRule__Group_5__1 ;
    public final void rule__UntypedBaseDataDescriptionRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3772:1: ( rule__UntypedBaseDataDescriptionRule__Group_5__0__Impl rule__UntypedBaseDataDescriptionRule__Group_5__1 )
            // InternalDataDescriptionLanguage.g:3773:2: rule__UntypedBaseDataDescriptionRule__Group_5__0__Impl rule__UntypedBaseDataDescriptionRule__Group_5__1
            {
            pushFollow(FOLLOW_18);
            rule__UntypedBaseDataDescriptionRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group_5__0"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group_5__0__Impl"
    // InternalDataDescriptionLanguage.g:3780:1: rule__UntypedBaseDataDescriptionRule__Group_5__0__Impl : ( 'with' ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3784:1: ( ( 'with' ) )
            // InternalDataDescriptionLanguage.g:3785:1: ( 'with' )
            {
            // InternalDataDescriptionLanguage.g:3785:1: ( 'with' )
            // InternalDataDescriptionLanguage.g:3786:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getWithKeyword_5_0()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getWithKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group_5__0__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group_5__1"
    // InternalDataDescriptionLanguage.g:3795:1: rule__UntypedBaseDataDescriptionRule__Group_5__1 : rule__UntypedBaseDataDescriptionRule__Group_5__1__Impl rule__UntypedBaseDataDescriptionRule__Group_5__2 ;
    public final void rule__UntypedBaseDataDescriptionRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3799:1: ( rule__UntypedBaseDataDescriptionRule__Group_5__1__Impl rule__UntypedBaseDataDescriptionRule__Group_5__2 )
            // InternalDataDescriptionLanguage.g:3800:2: rule__UntypedBaseDataDescriptionRule__Group_5__1__Impl rule__UntypedBaseDataDescriptionRule__Group_5__2
            {
            pushFollow(FOLLOW_8);
            rule__UntypedBaseDataDescriptionRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group_5__1"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group_5__1__Impl"
    // InternalDataDescriptionLanguage.g:3807:1: rule__UntypedBaseDataDescriptionRule__Group_5__1__Impl : ( 'constraints' ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3811:1: ( ( 'constraints' ) )
            // InternalDataDescriptionLanguage.g:3812:1: ( 'constraints' )
            {
            // InternalDataDescriptionLanguage.g:3812:1: ( 'constraints' )
            // InternalDataDescriptionLanguage.g:3813:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsKeyword_5_1()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsKeyword_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group_5__1__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group_5__2"
    // InternalDataDescriptionLanguage.g:3822:1: rule__UntypedBaseDataDescriptionRule__Group_5__2 : rule__UntypedBaseDataDescriptionRule__Group_5__2__Impl rule__UntypedBaseDataDescriptionRule__Group_5__3 ;
    public final void rule__UntypedBaseDataDescriptionRule__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3826:1: ( rule__UntypedBaseDataDescriptionRule__Group_5__2__Impl rule__UntypedBaseDataDescriptionRule__Group_5__3 )
            // InternalDataDescriptionLanguage.g:3827:2: rule__UntypedBaseDataDescriptionRule__Group_5__2__Impl rule__UntypedBaseDataDescriptionRule__Group_5__3
            {
            pushFollow(FOLLOW_13);
            rule__UntypedBaseDataDescriptionRule__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group_5__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group_5__2"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group_5__2__Impl"
    // InternalDataDescriptionLanguage.g:3834:1: rule__UntypedBaseDataDescriptionRule__Group_5__2__Impl : ( ':' ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3838:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:3839:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:3839:1: ( ':' )
            // InternalDataDescriptionLanguage.g:3840:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getColonKeyword_5_2()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getColonKeyword_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group_5__2__Impl"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group_5__3"
    // InternalDataDescriptionLanguage.g:3849:1: rule__UntypedBaseDataDescriptionRule__Group_5__3 : rule__UntypedBaseDataDescriptionRule__Group_5__3__Impl ;
    public final void rule__UntypedBaseDataDescriptionRule__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3853:1: ( rule__UntypedBaseDataDescriptionRule__Group_5__3__Impl )
            // InternalDataDescriptionLanguage.g:3854:2: rule__UntypedBaseDataDescriptionRule__Group_5__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UntypedBaseDataDescriptionRule__Group_5__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group_5__3"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__Group_5__3__Impl"
    // InternalDataDescriptionLanguage.g:3860:1: rule__UntypedBaseDataDescriptionRule__Group_5__3__Impl : ( ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3 )* ) ;
    public final void rule__UntypedBaseDataDescriptionRule__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3864:1: ( ( ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3 )* ) )
            // InternalDataDescriptionLanguage.g:3865:1: ( ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3 )* )
            {
            // InternalDataDescriptionLanguage.g:3865:1: ( ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3 )* )
            // InternalDataDescriptionLanguage.g:3866:2: ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsAssignment_5_3()); 
            }
            // InternalDataDescriptionLanguage.g:3867:2: ( rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=RULE_QUOTED_ID && LA36_0<=RULE_STRING)||LA36_0==15||(LA36_0>=30 && LA36_0<=31)||LA36_0==60||LA36_0==66||LA36_0==71||LA36_0==76||(LA36_0>=88 && LA36_0<=89)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3867:3: rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsAssignment_5_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__Group_5__3__Impl"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__0"
    // InternalDataDescriptionLanguage.g:3876:1: rule__StructuredDataDescriptionRule__Group__0 : rule__StructuredDataDescriptionRule__Group__0__Impl rule__StructuredDataDescriptionRule__Group__1 ;
    public final void rule__StructuredDataDescriptionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3880:1: ( rule__StructuredDataDescriptionRule__Group__0__Impl rule__StructuredDataDescriptionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:3881:2: rule__StructuredDataDescriptionRule__Group__0__Impl rule__StructuredDataDescriptionRule__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__StructuredDataDescriptionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__0"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__0__Impl"
    // InternalDataDescriptionLanguage.g:3888:1: rule__StructuredDataDescriptionRule__Group__0__Impl : ( ( rule__StructuredDataDescriptionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__StructuredDataDescriptionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3892:1: ( ( ( rule__StructuredDataDescriptionRule__ConstraintsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:3893:1: ( ( rule__StructuredDataDescriptionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:3893:1: ( ( rule__StructuredDataDescriptionRule__ConstraintsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:3894:2: ( rule__StructuredDataDescriptionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:3895:2: ( rule__StructuredDataDescriptionRule__ConstraintsAssignment_0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==79) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3895:3: rule__StructuredDataDescriptionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__StructuredDataDescriptionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getConstraintsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__0__Impl"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__1"
    // InternalDataDescriptionLanguage.g:3903:1: rule__StructuredDataDescriptionRule__Group__1 : rule__StructuredDataDescriptionRule__Group__1__Impl rule__StructuredDataDescriptionRule__Group__2 ;
    public final void rule__StructuredDataDescriptionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3907:1: ( rule__StructuredDataDescriptionRule__Group__1__Impl rule__StructuredDataDescriptionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:3908:2: rule__StructuredDataDescriptionRule__Group__1__Impl rule__StructuredDataDescriptionRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__StructuredDataDescriptionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__1"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__1__Impl"
    // InternalDataDescriptionLanguage.g:3915:1: rule__StructuredDataDescriptionRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__StructuredDataDescriptionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3919:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:3920:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:3920:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:3921:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getDataKeyword_1()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getDataKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__1__Impl"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__2"
    // InternalDataDescriptionLanguage.g:3930:1: rule__StructuredDataDescriptionRule__Group__2 : rule__StructuredDataDescriptionRule__Group__2__Impl rule__StructuredDataDescriptionRule__Group__3 ;
    public final void rule__StructuredDataDescriptionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3934:1: ( rule__StructuredDataDescriptionRule__Group__2__Impl rule__StructuredDataDescriptionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:3935:2: rule__StructuredDataDescriptionRule__Group__2__Impl rule__StructuredDataDescriptionRule__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__StructuredDataDescriptionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__2"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__2__Impl"
    // InternalDataDescriptionLanguage.g:3942:1: rule__StructuredDataDescriptionRule__Group__2__Impl : ( ( rule__StructuredDataDescriptionRule__NameAssignment_2 ) ) ;
    public final void rule__StructuredDataDescriptionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3946:1: ( ( ( rule__StructuredDataDescriptionRule__NameAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:3947:1: ( ( rule__StructuredDataDescriptionRule__NameAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:3947:1: ( ( rule__StructuredDataDescriptionRule__NameAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:3948:2: ( rule__StructuredDataDescriptionRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getNameAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:3949:2: ( rule__StructuredDataDescriptionRule__NameAssignment_2 )
            // InternalDataDescriptionLanguage.g:3949:3: rule__StructuredDataDescriptionRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__2__Impl"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__3"
    // InternalDataDescriptionLanguage.g:3957:1: rule__StructuredDataDescriptionRule__Group__3 : rule__StructuredDataDescriptionRule__Group__3__Impl rule__StructuredDataDescriptionRule__Group__4 ;
    public final void rule__StructuredDataDescriptionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3961:1: ( rule__StructuredDataDescriptionRule__Group__3__Impl rule__StructuredDataDescriptionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:3962:2: rule__StructuredDataDescriptionRule__Group__3__Impl rule__StructuredDataDescriptionRule__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__StructuredDataDescriptionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__3"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__3__Impl"
    // InternalDataDescriptionLanguage.g:3969:1: rule__StructuredDataDescriptionRule__Group__3__Impl : ( 'of' ) ;
    public final void rule__StructuredDataDescriptionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3973:1: ( ( 'of' ) )
            // InternalDataDescriptionLanguage.g:3974:1: ( 'of' )
            {
            // InternalDataDescriptionLanguage.g:3974:1: ( 'of' )
            // InternalDataDescriptionLanguage.g:3975:2: 'of'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getOfKeyword_3()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getOfKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__3__Impl"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__4"
    // InternalDataDescriptionLanguage.g:3984:1: rule__StructuredDataDescriptionRule__Group__4 : rule__StructuredDataDescriptionRule__Group__4__Impl rule__StructuredDataDescriptionRule__Group__5 ;
    public final void rule__StructuredDataDescriptionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:3988:1: ( rule__StructuredDataDescriptionRule__Group__4__Impl rule__StructuredDataDescriptionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:3989:2: rule__StructuredDataDescriptionRule__Group__4__Impl rule__StructuredDataDescriptionRule__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__StructuredDataDescriptionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__4"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__4__Impl"
    // InternalDataDescriptionLanguage.g:3996:1: rule__StructuredDataDescriptionRule__Group__4__Impl : ( 'instance' ) ;
    public final void rule__StructuredDataDescriptionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4000:1: ( ( 'instance' ) )
            // InternalDataDescriptionLanguage.g:4001:1: ( 'instance' )
            {
            // InternalDataDescriptionLanguage.g:4001:1: ( 'instance' )
            // InternalDataDescriptionLanguage.g:4002:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getInstanceKeyword_4()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getInstanceKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__4__Impl"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__5"
    // InternalDataDescriptionLanguage.g:4011:1: rule__StructuredDataDescriptionRule__Group__5 : rule__StructuredDataDescriptionRule__Group__5__Impl rule__StructuredDataDescriptionRule__Group__6 ;
    public final void rule__StructuredDataDescriptionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4015:1: ( rule__StructuredDataDescriptionRule__Group__5__Impl rule__StructuredDataDescriptionRule__Group__6 )
            // InternalDataDescriptionLanguage.g:4016:2: rule__StructuredDataDescriptionRule__Group__5__Impl rule__StructuredDataDescriptionRule__Group__6
            {
            pushFollow(FOLLOW_28);
            rule__StructuredDataDescriptionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__5"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__5__Impl"
    // InternalDataDescriptionLanguage.g:4023:1: rule__StructuredDataDescriptionRule__Group__5__Impl : ( ( rule__StructuredDataDescriptionRule__TypeAssignment_5 ) ) ;
    public final void rule__StructuredDataDescriptionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4027:1: ( ( ( rule__StructuredDataDescriptionRule__TypeAssignment_5 ) ) )
            // InternalDataDescriptionLanguage.g:4028:1: ( ( rule__StructuredDataDescriptionRule__TypeAssignment_5 ) )
            {
            // InternalDataDescriptionLanguage.g:4028:1: ( ( rule__StructuredDataDescriptionRule__TypeAssignment_5 ) )
            // InternalDataDescriptionLanguage.g:4029:2: ( rule__StructuredDataDescriptionRule__TypeAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getTypeAssignment_5()); 
            }
            // InternalDataDescriptionLanguage.g:4030:2: ( rule__StructuredDataDescriptionRule__TypeAssignment_5 )
            // InternalDataDescriptionLanguage.g:4030:3: rule__StructuredDataDescriptionRule__TypeAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionRule__TypeAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getTypeAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__5__Impl"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__6"
    // InternalDataDescriptionLanguage.g:4038:1: rule__StructuredDataDescriptionRule__Group__6 : rule__StructuredDataDescriptionRule__Group__6__Impl ;
    public final void rule__StructuredDataDescriptionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4042:1: ( rule__StructuredDataDescriptionRule__Group__6__Impl )
            // InternalDataDescriptionLanguage.g:4043:2: rule__StructuredDataDescriptionRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StructuredDataDescriptionRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__6"


    // $ANTLR start "rule__StructuredDataDescriptionRule__Group__6__Impl"
    // InternalDataDescriptionLanguage.g:4049:1: rule__StructuredDataDescriptionRule__Group__6__Impl : ( ';' ) ;
    public final void rule__StructuredDataDescriptionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4053:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:4054:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:4054:1: ( ';' )
            // InternalDataDescriptionLanguage.g:4055:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getSemicolonKeyword_6()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getSemicolonKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__Group__6__Impl"


    // $ANTLR start "rule__StatementRule__Group__0"
    // InternalDataDescriptionLanguage.g:4065:1: rule__StatementRule__Group__0 : rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 ;
    public final void rule__StatementRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4069:1: ( rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4070:2: rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDataDescriptionLanguage.g:4077:1: rule__StatementRule__Group__0__Impl : ( ruleExpressionRule ) ;
    public final void rule__StatementRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4081:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:4082:1: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:4082:1: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:4083:2: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:4092:1: rule__StatementRule__Group__1 : rule__StatementRule__Group__1__Impl ;
    public final void rule__StatementRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4096:1: ( rule__StatementRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4097:2: rule__StatementRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4103:1: rule__StatementRule__Group__1__Impl : ( ';' ) ;
    public final void rule__StatementRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4107:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:4108:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:4108:1: ( ';' )
            // InternalDataDescriptionLanguage.g:4109:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRuleAccess().getSemicolonKeyword_1()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4119:1: rule__SelfReferenceRule__Group__0 : rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1 ;
    public final void rule__SelfReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4123:1: ( rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4124:2: rule__SelfReferenceRule__Group__0__Impl rule__SelfReferenceRule__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:4131:1: rule__SelfReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4135:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:4136:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:4136:1: ( () )
            // InternalDataDescriptionLanguage.g:4137:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:4138:2: ()
            // InternalDataDescriptionLanguage.g:4138:3: 
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
    // InternalDataDescriptionLanguage.g:4146:1: rule__SelfReferenceRule__Group__1 : rule__SelfReferenceRule__Group__1__Impl ;
    public final void rule__SelfReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4150:1: ( rule__SelfReferenceRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4151:2: rule__SelfReferenceRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4157:1: rule__SelfReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__SelfReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4161:1: ( ( 'value' ) )
            // InternalDataDescriptionLanguage.g:4162:1: ( 'value' )
            {
            // InternalDataDescriptionLanguage.g:4162:1: ( 'value' )
            // InternalDataDescriptionLanguage.g:4163:2: 'value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4173:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4177:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4178:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalDataDescriptionLanguage.g:4185:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4189:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4190:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4190:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4191:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4192:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:4192:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:4200:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4204:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4205:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4211:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4215:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:4216:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:4216:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:4217:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:4218:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==72) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4218:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
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
    // InternalDataDescriptionLanguage.g:4227:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4231:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:4232:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:4239:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4243:1: ( ( 'OR' ) )
            // InternalDataDescriptionLanguage.g:4244:1: ( 'OR' )
            {
            // InternalDataDescriptionLanguage.g:4244:1: ( 'OR' )
            // InternalDataDescriptionLanguage.g:4245:2: 'OR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4254:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4258:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4259:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4265:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4269:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4270:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4270:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:4271:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4272:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:4272:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:4281:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4285:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4286:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalDataDescriptionLanguage.g:4293:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4297:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4298:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4298:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4299:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4300:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:4300:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:4308:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4312:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4313:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4319:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4323:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:4324:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:4324:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:4325:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:4326:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==73) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4326:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalDataDescriptionLanguage.g:4335:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4339:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:4340:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:4347:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4351:1: ( ( 'XOR' ) )
            // InternalDataDescriptionLanguage.g:4352:1: ( 'XOR' )
            {
            // InternalDataDescriptionLanguage.g:4352:1: ( 'XOR' )
            // InternalDataDescriptionLanguage.g:4353:2: 'XOR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4362:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4366:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4367:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4373:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4377:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4378:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4378:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:4379:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4380:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:4380:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:4389:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4393:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4394:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalDataDescriptionLanguage.g:4401:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4405:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4406:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4406:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4407:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4408:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalDataDescriptionLanguage.g:4408:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalDataDescriptionLanguage.g:4416:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4420:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4421:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4427:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4431:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:4432:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:4432:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:4433:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:4434:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==74) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4434:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop40;
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
    // InternalDataDescriptionLanguage.g:4443:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4447:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:4448:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:4455:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4459:1: ( ( 'AND' ) )
            // InternalDataDescriptionLanguage.g:4460:1: ( 'AND' )
            {
            // InternalDataDescriptionLanguage.g:4460:1: ( 'AND' )
            // InternalDataDescriptionLanguage.g:4461:2: 'AND'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4470:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4474:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4475:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4481:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4485:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4486:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4486:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:4487:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4488:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:4488:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:4497:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4501:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4502:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:4509:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4513:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalDataDescriptionLanguage.g:4514:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalDataDescriptionLanguage.g:4514:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalDataDescriptionLanguage.g:4515:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4516:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==88) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:4516:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalDataDescriptionLanguage.g:4524:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4528:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4529:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4535:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4539:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:4540:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4540:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:4541:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4542:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalDataDescriptionLanguage.g:4542:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalDataDescriptionLanguage.g:4551:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4555:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4556:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalDataDescriptionLanguage.g:4563:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4567:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4568:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4568:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4569:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4570:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:4570:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:4578:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4582:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4583:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4589:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4593:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalDataDescriptionLanguage.g:4594:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalDataDescriptionLanguage.g:4594:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalDataDescriptionLanguage.g:4595:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4596:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=24 && LA42_0<=29)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4596:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // InternalDataDescriptionLanguage.g:4605:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4609:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4610:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:4617:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4621:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4622:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4622:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4623:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4624:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalDataDescriptionLanguage.g:4624:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalDataDescriptionLanguage.g:4632:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4636:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4637:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4643:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4647:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:4648:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4648:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:4649:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:4650:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:4650:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:4659:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4663:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4664:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalDataDescriptionLanguage.g:4671:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4675:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4676:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4676:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4677:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4678:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:4678:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:4686:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4690:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4691:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4697:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4701:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:4702:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:4702:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:4703:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:4704:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=30 && LA43_0<=31)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4704:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop43;
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
    // InternalDataDescriptionLanguage.g:4713:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4717:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:4718:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:4725:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4729:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDataDescriptionLanguage.g:4730:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4730:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDataDescriptionLanguage.g:4731:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:4732:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalDataDescriptionLanguage.g:4732:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalDataDescriptionLanguage.g:4740:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4744:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4745:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4751:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4755:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4756:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4756:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:4757:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4758:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:4758:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:4767:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4771:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4772:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalDataDescriptionLanguage.g:4779:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4783:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4784:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4784:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4785:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4786:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:4786:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:4794:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4798:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4799:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4805:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4809:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:4810:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:4810:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:4811:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:4812:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=32 && LA44_0<=34)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:4812:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_40);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
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
    // InternalDataDescriptionLanguage.g:4821:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4825:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:4826:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:4833:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4837:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDataDescriptionLanguage.g:4838:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4838:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDataDescriptionLanguage.g:4839:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:4840:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalDataDescriptionLanguage.g:4840:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalDataDescriptionLanguage.g:4848:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4852:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4853:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4859:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4863:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4864:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4864:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:4865:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4866:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:4866:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:4875:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4879:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4880:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalDataDescriptionLanguage.g:4887:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4891:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:4892:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:4892:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:4893:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:4894:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalDataDescriptionLanguage.g:4894:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalDataDescriptionLanguage.g:4902:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4906:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:4907:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:4913:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4917:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalDataDescriptionLanguage.g:4918:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalDataDescriptionLanguage.g:4918:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalDataDescriptionLanguage.g:4919:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:4920:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==75) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:4920:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalDataDescriptionLanguage.g:4929:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4933:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalDataDescriptionLanguage.g:4934:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:4941:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4945:1: ( ( '^' ) )
            // InternalDataDescriptionLanguage.g:4946:1: ( '^' )
            {
            // InternalDataDescriptionLanguage.g:4946:1: ( '^' )
            // InternalDataDescriptionLanguage.g:4947:2: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:4956:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4960:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:4961:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:4967:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4971:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:4972:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:4972:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalDataDescriptionLanguage.g:4973:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:4974:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalDataDescriptionLanguage.g:4974:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalDataDescriptionLanguage.g:4983:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4987:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:4988:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:4995:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:4999:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:5000:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:5000:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:5001:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:5002:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=30 && LA46_0<=31)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:5002:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop46;
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
    // InternalDataDescriptionLanguage.g:5010:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5014:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5015:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5021:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5025:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:5026:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:5026:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:5027:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:5028:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:5028:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:5037:1: rule__ArrayRule__Group__0 : rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 ;
    public final void rule__ArrayRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5041:1: ( rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5042:2: rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalDataDescriptionLanguage.g:5049:1: rule__ArrayRule__Group__0__Impl : ( () ) ;
    public final void rule__ArrayRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5053:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5054:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5054:1: ( () )
            // InternalDataDescriptionLanguage.g:5055:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5056:2: ()
            // InternalDataDescriptionLanguage.g:5056:3: 
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
    // InternalDataDescriptionLanguage.g:5064:1: rule__ArrayRule__Group__1 : rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 ;
    public final void rule__ArrayRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5068:1: ( rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 )
            // InternalDataDescriptionLanguage.g:5069:2: rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2
            {
            pushFollow(FOLLOW_43);
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
    // InternalDataDescriptionLanguage.g:5076:1: rule__ArrayRule__Group__1__Impl : ( '[' ) ;
    public final void rule__ArrayRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5080:1: ( ( '[' ) )
            // InternalDataDescriptionLanguage.g:5081:1: ( '[' )
            {
            // InternalDataDescriptionLanguage.g:5081:1: ( '[' )
            // InternalDataDescriptionLanguage.g:5082:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,76,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5091:1: rule__ArrayRule__Group__2 : rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 ;
    public final void rule__ArrayRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5095:1: ( rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 )
            // InternalDataDescriptionLanguage.g:5096:2: rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3
            {
            pushFollow(FOLLOW_43);
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
    // InternalDataDescriptionLanguage.g:5103:1: rule__ArrayRule__Group__2__Impl : ( ( rule__ArrayRule__Group_2__0 )? ) ;
    public final void rule__ArrayRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5107:1: ( ( ( rule__ArrayRule__Group_2__0 )? ) )
            // InternalDataDescriptionLanguage.g:5108:1: ( ( rule__ArrayRule__Group_2__0 )? )
            {
            // InternalDataDescriptionLanguage.g:5108:1: ( ( rule__ArrayRule__Group_2__0 )? )
            // InternalDataDescriptionLanguage.g:5109:2: ( rule__ArrayRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2()); 
            }
            // InternalDataDescriptionLanguage.g:5110:2: ( rule__ArrayRule__Group_2__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=RULE_QUOTED_ID && LA47_0<=RULE_STRING)||LA47_0==15||LA47_0==60||LA47_0==66||LA47_0==71||LA47_0==76||LA47_0==89) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:5110:3: rule__ArrayRule__Group_2__0
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
    // InternalDataDescriptionLanguage.g:5118:1: rule__ArrayRule__Group__3 : rule__ArrayRule__Group__3__Impl ;
    public final void rule__ArrayRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5122:1: ( rule__ArrayRule__Group__3__Impl )
            // InternalDataDescriptionLanguage.g:5123:2: rule__ArrayRule__Group__3__Impl
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
    // InternalDataDescriptionLanguage.g:5129:1: rule__ArrayRule__Group__3__Impl : ( ']' ) ;
    public final void rule__ArrayRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5133:1: ( ( ']' ) )
            // InternalDataDescriptionLanguage.g:5134:1: ( ']' )
            {
            // InternalDataDescriptionLanguage.g:5134:1: ( ']' )
            // InternalDataDescriptionLanguage.g:5135:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5145:1: rule__ArrayRule__Group_2__0 : rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 ;
    public final void rule__ArrayRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5149:1: ( rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 )
            // InternalDataDescriptionLanguage.g:5150:2: rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalDataDescriptionLanguage.g:5157:1: rule__ArrayRule__Group_2__0__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) ;
    public final void rule__ArrayRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5161:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) )
            // InternalDataDescriptionLanguage.g:5162:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            {
            // InternalDataDescriptionLanguage.g:5162:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            // InternalDataDescriptionLanguage.g:5163:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 
            }
            // InternalDataDescriptionLanguage.g:5164:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            // InternalDataDescriptionLanguage.g:5164:3: rule__ArrayRule__ValuesAssignment_2_0
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
    // InternalDataDescriptionLanguage.g:5172:1: rule__ArrayRule__Group_2__1 : rule__ArrayRule__Group_2__1__Impl ;
    public final void rule__ArrayRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5176:1: ( rule__ArrayRule__Group_2__1__Impl )
            // InternalDataDescriptionLanguage.g:5177:2: rule__ArrayRule__Group_2__1__Impl
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
    // InternalDataDescriptionLanguage.g:5183:1: rule__ArrayRule__Group_2__1__Impl : ( ( rule__ArrayRule__Group_2_1__0 )* ) ;
    public final void rule__ArrayRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5187:1: ( ( ( rule__ArrayRule__Group_2_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:5188:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:5188:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            // InternalDataDescriptionLanguage.g:5189:2: ( rule__ArrayRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 
            }
            // InternalDataDescriptionLanguage.g:5190:2: ( rule__ArrayRule__Group_2_1__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==68) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:5190:3: rule__ArrayRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__ArrayRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop48;
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
    // InternalDataDescriptionLanguage.g:5199:1: rule__ArrayRule__Group_2_1__0 : rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 ;
    public final void rule__ArrayRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5203:1: ( rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 )
            // InternalDataDescriptionLanguage.g:5204:2: rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:5211:1: rule__ArrayRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ArrayRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5215:1: ( ( ',' ) )
            // InternalDataDescriptionLanguage.g:5216:1: ( ',' )
            {
            // InternalDataDescriptionLanguage.g:5216:1: ( ',' )
            // InternalDataDescriptionLanguage.g:5217:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5226:1: rule__ArrayRule__Group_2_1__1 : rule__ArrayRule__Group_2_1__1__Impl ;
    public final void rule__ArrayRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5230:1: ( rule__ArrayRule__Group_2_1__1__Impl )
            // InternalDataDescriptionLanguage.g:5231:2: rule__ArrayRule__Group_2_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:5237:1: rule__ArrayRule__Group_2_1__1__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__ArrayRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5241:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:5242:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:5242:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            // InternalDataDescriptionLanguage.g:5243:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:5244:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            // InternalDataDescriptionLanguage.g:5244:3: rule__ArrayRule__ValuesAssignment_2_1_1
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
    // InternalDataDescriptionLanguage.g:5253:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5257:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5258:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:5265:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5269:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:5270:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:5270:1: ( '(' )
            // InternalDataDescriptionLanguage.g:5271:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5280:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5284:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalDataDescriptionLanguage.g:5285:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_45);
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
    // InternalDataDescriptionLanguage.g:5292:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5296:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:5297:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:5297:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:5298:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:5299:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalDataDescriptionLanguage.g:5299:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalDataDescriptionLanguage.g:5307:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5311:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:5312:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalDataDescriptionLanguage.g:5318:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5322:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:5323:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:5323:1: ( ')' )
            // InternalDataDescriptionLanguage.g:5324:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5334:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5338:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5339:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalDataDescriptionLanguage.g:5346:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5350:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:5351:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:5351:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:5352:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:5353:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalDataDescriptionLanguage.g:5353:3: rule__CallRule__FunctionAssignment_0
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
    // InternalDataDescriptionLanguage.g:5361:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5365:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalDataDescriptionLanguage.g:5366:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_46);
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
    // InternalDataDescriptionLanguage.g:5373:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5377:1: ( ( '(' ) )
            // InternalDataDescriptionLanguage.g:5378:1: ( '(' )
            {
            // InternalDataDescriptionLanguage.g:5378:1: ( '(' )
            // InternalDataDescriptionLanguage.g:5379:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5388:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5392:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalDataDescriptionLanguage.g:5393:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_46);
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
    // InternalDataDescriptionLanguage.g:5400:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5404:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalDataDescriptionLanguage.g:5405:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalDataDescriptionLanguage.g:5405:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalDataDescriptionLanguage.g:5406:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalDataDescriptionLanguage.g:5407:2: ( rule__CallRule__Group_2__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_QUOTED_ID && LA49_0<=RULE_STRING)||LA49_0==15||(LA49_0>=30 && LA49_0<=31)||LA49_0==60||LA49_0==66||LA49_0==71||LA49_0==76||(LA49_0>=88 && LA49_0<=89)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:5407:3: rule__CallRule__Group_2__0
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
    // InternalDataDescriptionLanguage.g:5415:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5419:1: ( rule__CallRule__Group__3__Impl )
            // InternalDataDescriptionLanguage.g:5420:2: rule__CallRule__Group__3__Impl
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
    // InternalDataDescriptionLanguage.g:5426:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5430:1: ( ( ')' ) )
            // InternalDataDescriptionLanguage.g:5431:1: ( ')' )
            {
            // InternalDataDescriptionLanguage.g:5431:1: ( ')' )
            // InternalDataDescriptionLanguage.g:5432:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5442:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5446:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalDataDescriptionLanguage.g:5447:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalDataDescriptionLanguage.g:5454:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5458:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalDataDescriptionLanguage.g:5459:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalDataDescriptionLanguage.g:5459:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalDataDescriptionLanguage.g:5460:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalDataDescriptionLanguage.g:5461:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalDataDescriptionLanguage.g:5461:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalDataDescriptionLanguage.g:5469:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5473:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalDataDescriptionLanguage.g:5474:2: rule__CallRule__Group_2__1__Impl
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
    // InternalDataDescriptionLanguage.g:5480:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5484:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:5485:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:5485:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalDataDescriptionLanguage.g:5486:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalDataDescriptionLanguage.g:5487:2: ( rule__CallRule__Group_2_1__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==68) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:5487:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop50;
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
    // InternalDataDescriptionLanguage.g:5496:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5500:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalDataDescriptionLanguage.g:5501:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:5508:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5512:1: ( ( ',' ) )
            // InternalDataDescriptionLanguage.g:5513:1: ( ',' )
            {
            // InternalDataDescriptionLanguage.g:5513:1: ( ',' )
            // InternalDataDescriptionLanguage.g:5514:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5523:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5527:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalDataDescriptionLanguage.g:5528:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:5534:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5538:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalDataDescriptionLanguage.g:5539:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalDataDescriptionLanguage.g:5539:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalDataDescriptionLanguage.g:5540:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalDataDescriptionLanguage.g:5541:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalDataDescriptionLanguage.g:5541:3: rule__CallRule__ParametersAssignment_2_1_1
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
    // InternalDataDescriptionLanguage.g:5550:1: rule__DataReferenceRule__Group__0 : rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1 ;
    public final void rule__DataReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5554:1: ( rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5555:2: rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalDataDescriptionLanguage.g:5562:1: rule__DataReferenceRule__Group__0__Impl : ( 'data' ) ;
    public final void rule__DataReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5566:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:5567:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:5567:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:5568:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDataKeyword_0()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5577:1: rule__DataReferenceRule__Group__1 : rule__DataReferenceRule__Group__1__Impl ;
    public final void rule__DataReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5581:1: ( rule__DataReferenceRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5582:2: rule__DataReferenceRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5588:1: rule__DataReferenceRule__Group__1__Impl : ( ( rule__DataReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__DataReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5592:1: ( ( ( rule__DataReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:5593:1: ( ( rule__DataReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:5593:1: ( ( rule__DataReferenceRule__DefinitionAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:5594:2: ( rule__DataReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:5595:2: ( rule__DataReferenceRule__DefinitionAssignment_1 )
            // InternalDataDescriptionLanguage.g:5595:3: rule__DataReferenceRule__DefinitionAssignment_1
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
    // InternalDataDescriptionLanguage.g:5604:1: rule__InstanceLiteralRule__Group__0 : rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 ;
    public final void rule__InstanceLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5608:1: ( rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5609:2: rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1
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
    // InternalDataDescriptionLanguage.g:5616:1: rule__InstanceLiteralRule__Group__0__Impl : ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) ;
    public final void rule__InstanceLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5620:1: ( ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:5621:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:5621:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:5622:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:5623:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            // InternalDataDescriptionLanguage.g:5623:3: rule__InstanceLiteralRule__DefinitionAssignment_0
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
    // InternalDataDescriptionLanguage.g:5631:1: rule__InstanceLiteralRule__Group__1 : rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 ;
    public final void rule__InstanceLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5635:1: ( rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 )
            // InternalDataDescriptionLanguage.g:5636:2: rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2
            {
            pushFollow(FOLLOW_47);
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
    // InternalDataDescriptionLanguage.g:5643:1: rule__InstanceLiteralRule__Group__1__Impl : ( '{' ) ;
    public final void rule__InstanceLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5647:1: ( ( '{' ) )
            // InternalDataDescriptionLanguage.g:5648:1: ( '{' )
            {
            // InternalDataDescriptionLanguage.g:5648:1: ( '{' )
            // InternalDataDescriptionLanguage.g:5649:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5658:1: rule__InstanceLiteralRule__Group__2 : rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 ;
    public final void rule__InstanceLiteralRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5662:1: ( rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 )
            // InternalDataDescriptionLanguage.g:5663:2: rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3
            {
            pushFollow(FOLLOW_47);
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
    // InternalDataDescriptionLanguage.g:5670:1: rule__InstanceLiteralRule__Group__2__Impl : ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) ;
    public final void rule__InstanceLiteralRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5674:1: ( ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) )
            // InternalDataDescriptionLanguage.g:5675:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            {
            // InternalDataDescriptionLanguage.g:5675:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            // InternalDataDescriptionLanguage.g:5676:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:5677:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0>=RULE_QUOTED_ID && LA51_0<=RULE_ID)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:5677:3: rule__InstanceLiteralRule__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__InstanceLiteralRule__AttributesAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop51;
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
    // InternalDataDescriptionLanguage.g:5685:1: rule__InstanceLiteralRule__Group__3 : rule__InstanceLiteralRule__Group__3__Impl ;
    public final void rule__InstanceLiteralRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5689:1: ( rule__InstanceLiteralRule__Group__3__Impl )
            // InternalDataDescriptionLanguage.g:5690:2: rule__InstanceLiteralRule__Group__3__Impl
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
    // InternalDataDescriptionLanguage.g:5696:1: rule__InstanceLiteralRule__Group__3__Impl : ( '}' ) ;
    public final void rule__InstanceLiteralRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5700:1: ( ( '}' ) )
            // InternalDataDescriptionLanguage.g:5701:1: ( '}' )
            {
            // InternalDataDescriptionLanguage.g:5701:1: ( '}' )
            // InternalDataDescriptionLanguage.g:5702:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5712:1: rule__AttributeRule__Group__0 : rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 ;
    public final void rule__AttributeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5716:1: ( rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5717:2: rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1
            {
            pushFollow(FOLLOW_49);
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
    // InternalDataDescriptionLanguage.g:5724:1: rule__AttributeRule__Group__0__Impl : ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) ;
    public final void rule__AttributeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5728:1: ( ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:5729:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:5729:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:5730:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:5731:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            // InternalDataDescriptionLanguage.g:5731:3: rule__AttributeRule__DefinitionAssignment_0
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
    // InternalDataDescriptionLanguage.g:5739:1: rule__AttributeRule__Group__1 : rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 ;
    public final void rule__AttributeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5743:1: ( rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 )
            // InternalDataDescriptionLanguage.g:5744:2: rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:5751:1: rule__AttributeRule__Group__1__Impl : ( ':=' ) ;
    public final void rule__AttributeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5755:1: ( ( ':=' ) )
            // InternalDataDescriptionLanguage.g:5756:1: ( ':=' )
            {
            // InternalDataDescriptionLanguage.g:5756:1: ( ':=' )
            // InternalDataDescriptionLanguage.g:5757:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1()); 
            }
            match(input,78,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5766:1: rule__AttributeRule__Group__2 : rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 ;
    public final void rule__AttributeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5770:1: ( rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 )
            // InternalDataDescriptionLanguage.g:5771:2: rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3
            {
            pushFollow(FOLLOW_28);
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
    // InternalDataDescriptionLanguage.g:5778:1: rule__AttributeRule__Group__2__Impl : ( ( rule__AttributeRule__ValueAssignment_2 ) ) ;
    public final void rule__AttributeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5782:1: ( ( ( rule__AttributeRule__ValueAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:5783:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:5783:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:5784:2: ( rule__AttributeRule__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:5785:2: ( rule__AttributeRule__ValueAssignment_2 )
            // InternalDataDescriptionLanguage.g:5785:3: rule__AttributeRule__ValueAssignment_2
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
    // InternalDataDescriptionLanguage.g:5793:1: rule__AttributeRule__Group__3 : rule__AttributeRule__Group__3__Impl ;
    public final void rule__AttributeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5797:1: ( rule__AttributeRule__Group__3__Impl )
            // InternalDataDescriptionLanguage.g:5798:2: rule__AttributeRule__Group__3__Impl
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
    // InternalDataDescriptionLanguage.g:5804:1: rule__AttributeRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5808:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:5809:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:5809:1: ( ';' )
            // InternalDataDescriptionLanguage.g:5810:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:5820:1: rule__RealLiteralRule__Group__0 : rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 ;
    public final void rule__RealLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5824:1: ( rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5825:2: rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalDataDescriptionLanguage.g:5832:1: rule__RealLiteralRule__Group__0__Impl : ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__RealLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5836:1: ( ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:5837:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:5837:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:5838:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:5839:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            // InternalDataDescriptionLanguage.g:5839:3: rule__RealLiteralRule__LiteralAssignment_0
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
    // InternalDataDescriptionLanguage.g:5847:1: rule__RealLiteralRule__Group__1 : rule__RealLiteralRule__Group__1__Impl ;
    public final void rule__RealLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5851:1: ( rule__RealLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5852:2: rule__RealLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5858:1: rule__RealLiteralRule__Group__1__Impl : ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__RealLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5862:1: ( ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) )
            // InternalDataDescriptionLanguage.g:5863:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDataDescriptionLanguage.g:5863:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            // InternalDataDescriptionLanguage.g:5864:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:5865:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=35 && LA52_0<=54)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:5865:3: rule__RealLiteralRule__FactorAssignment_1
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
    // InternalDataDescriptionLanguage.g:5874:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5878:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5879:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalDataDescriptionLanguage.g:5886:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5890:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:5891:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:5891:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:5892:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:5893:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalDataDescriptionLanguage.g:5893:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalDataDescriptionLanguage.g:5901:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5905:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5906:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5912:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5916:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalDataDescriptionLanguage.g:5917:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDataDescriptionLanguage.g:5917:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalDataDescriptionLanguage.g:5918:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:5919:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=35 && LA53_0<=54)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:5919:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalDataDescriptionLanguage.g:5928:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5932:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5933:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_51);
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
    // InternalDataDescriptionLanguage.g:5940:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5944:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:5945:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:5945:1: ( () )
            // InternalDataDescriptionLanguage.g:5946:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:5947:2: ()
            // InternalDataDescriptionLanguage.g:5947:3: 
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
    // InternalDataDescriptionLanguage.g:5955:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5959:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:5960:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:5966:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5970:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalDataDescriptionLanguage.g:5971:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalDataDescriptionLanguage.g:5971:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalDataDescriptionLanguage.g:5972:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalDataDescriptionLanguage.g:5973:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalDataDescriptionLanguage.g:5973:3: rule__BooleanLiteralRule__Alternatives_1
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
    // InternalDataDescriptionLanguage.g:5982:1: rule__ConstraintRule__Group__0 : rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 ;
    public final void rule__ConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5986:1: ( rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 )
            // InternalDataDescriptionLanguage.g:5987:2: rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1
            {
            pushFollow(FOLLOW_52);
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
    // InternalDataDescriptionLanguage.g:5994:1: rule__ConstraintRule__Group__0__Impl : ( '@' ) ;
    public final void rule__ConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:5998:1: ( ( '@' ) )
            // InternalDataDescriptionLanguage.g:5999:1: ( '@' )
            {
            // InternalDataDescriptionLanguage.g:5999:1: ( '@' )
            // InternalDataDescriptionLanguage.g:6000:2: '@'
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
    // InternalDataDescriptionLanguage.g:6009:1: rule__ConstraintRule__Group__1 : rule__ConstraintRule__Group__1__Impl ;
    public final void rule__ConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6013:1: ( rule__ConstraintRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6014:2: rule__ConstraintRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6020:1: rule__ConstraintRule__Group__1__Impl : ( ruleInstanceLiteralRule ) ;
    public final void rule__ConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6024:1: ( ( ruleInstanceLiteralRule ) )
            // InternalDataDescriptionLanguage.g:6025:1: ( ruleInstanceLiteralRule )
            {
            // InternalDataDescriptionLanguage.g:6025:1: ( ruleInstanceLiteralRule )
            // InternalDataDescriptionLanguage.g:6026:2: ruleInstanceLiteralRule
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
    // InternalDataDescriptionLanguage.g:6036:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6040:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6041:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
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
    // InternalDataDescriptionLanguage.g:6048:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6052:1: ( ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalDataDescriptionLanguage.g:6053:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDataDescriptionLanguage.g:6053:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalDataDescriptionLanguage.g:6054:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:6055:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==79) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:6055:3: rule__AttributeDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__AttributeDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop54;
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
    // InternalDataDescriptionLanguage.g:6063:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6067:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalDataDescriptionLanguage.g:6068:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalDataDescriptionLanguage.g:6075:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6079:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:6080:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:6080:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:6081:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:6082:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            // InternalDataDescriptionLanguage.g:6082:3: rule__AttributeDefinitionRule__NameAssignment_1
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
    // InternalDataDescriptionLanguage.g:6090:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6094:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalDataDescriptionLanguage.g:6095:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_53);
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
    // InternalDataDescriptionLanguage.g:6102:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6106:1: ( ( ':' ) )
            // InternalDataDescriptionLanguage.g:6107:1: ( ':' )
            {
            // InternalDataDescriptionLanguage.g:6107:1: ( ':' )
            // InternalDataDescriptionLanguage.g:6108:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6117:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6121:1: ( rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 )
            // InternalDataDescriptionLanguage.g:6122:2: rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_54);
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
    // InternalDataDescriptionLanguage.g:6129:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_3 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6133:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_3 ) ) )
            // InternalDataDescriptionLanguage.g:6134:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_3 ) )
            {
            // InternalDataDescriptionLanguage.g:6134:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_3 ) )
            // InternalDataDescriptionLanguage.g:6135:2: ( rule__AttributeDefinitionRule__TypeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_3()); 
            }
            // InternalDataDescriptionLanguage.g:6136:2: ( rule__AttributeDefinitionRule__TypeAssignment_3 )
            // InternalDataDescriptionLanguage.g:6136:3: rule__AttributeDefinitionRule__TypeAssignment_3
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
    // InternalDataDescriptionLanguage.g:6144:1: rule__AttributeDefinitionRule__Group__4 : rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 ;
    public final void rule__AttributeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6148:1: ( rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 )
            // InternalDataDescriptionLanguage.g:6149:2: rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_54);
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
    // InternalDataDescriptionLanguage.g:6156:1: rule__AttributeDefinitionRule__Group__4__Impl : ( ( rule__AttributeDefinitionRule__Group_4__0 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6160:1: ( ( ( rule__AttributeDefinitionRule__Group_4__0 )? ) )
            // InternalDataDescriptionLanguage.g:6161:1: ( ( rule__AttributeDefinitionRule__Group_4__0 )? )
            {
            // InternalDataDescriptionLanguage.g:6161:1: ( ( rule__AttributeDefinitionRule__Group_4__0 )? )
            // InternalDataDescriptionLanguage.g:6162:2: ( rule__AttributeDefinitionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_4()); 
            }
            // InternalDataDescriptionLanguage.g:6163:2: ( rule__AttributeDefinitionRule__Group_4__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==78) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:6163:3: rule__AttributeDefinitionRule__Group_4__0
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
    // InternalDataDescriptionLanguage.g:6171:1: rule__AttributeDefinitionRule__Group__5 : rule__AttributeDefinitionRule__Group__5__Impl ;
    public final void rule__AttributeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6175:1: ( rule__AttributeDefinitionRule__Group__5__Impl )
            // InternalDataDescriptionLanguage.g:6176:2: rule__AttributeDefinitionRule__Group__5__Impl
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
    // InternalDataDescriptionLanguage.g:6182:1: rule__AttributeDefinitionRule__Group__5__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6186:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:6187:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:6187:1: ( ';' )
            // InternalDataDescriptionLanguage.g:6188:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6198:1: rule__AttributeDefinitionRule__Group_4__0 : rule__AttributeDefinitionRule__Group_4__0__Impl rule__AttributeDefinitionRule__Group_4__1 ;
    public final void rule__AttributeDefinitionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6202:1: ( rule__AttributeDefinitionRule__Group_4__0__Impl rule__AttributeDefinitionRule__Group_4__1 )
            // InternalDataDescriptionLanguage.g:6203:2: rule__AttributeDefinitionRule__Group_4__0__Impl rule__AttributeDefinitionRule__Group_4__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDataDescriptionLanguage.g:6210:1: rule__AttributeDefinitionRule__Group_4__0__Impl : ( ':=' ) ;
    public final void rule__AttributeDefinitionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6214:1: ( ( ':=' ) )
            // InternalDataDescriptionLanguage.g:6215:1: ( ':=' )
            {
            // InternalDataDescriptionLanguage.g:6215:1: ( ':=' )
            // InternalDataDescriptionLanguage.g:6216:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_4_0()); 
            }
            match(input,78,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6225:1: rule__AttributeDefinitionRule__Group_4__1 : rule__AttributeDefinitionRule__Group_4__1__Impl ;
    public final void rule__AttributeDefinitionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6229:1: ( rule__AttributeDefinitionRule__Group_4__1__Impl )
            // InternalDataDescriptionLanguage.g:6230:2: rule__AttributeDefinitionRule__Group_4__1__Impl
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
    // InternalDataDescriptionLanguage.g:6236:1: rule__AttributeDefinitionRule__Group_4__1__Impl : ( ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6240:1: ( ( ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 ) ) )
            // InternalDataDescriptionLanguage.g:6241:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 ) )
            {
            // InternalDataDescriptionLanguage.g:6241:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 ) )
            // InternalDataDescriptionLanguage.g:6242:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_4_1()); 
            }
            // InternalDataDescriptionLanguage.g:6243:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_4_1 )
            // InternalDataDescriptionLanguage.g:6243:3: rule__AttributeDefinitionRule__InitialisationAssignment_4_1
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
    // InternalDataDescriptionLanguage.g:6252:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6256:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6257:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
            {
            pushFollow(FOLLOW_55);
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
    // InternalDataDescriptionLanguage.g:6264:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6268:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:6269:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:6269:1: ( () )
            // InternalDataDescriptionLanguage.g:6270:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:6271:2: ()
            // InternalDataDescriptionLanguage.g:6271:3: 
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
    // InternalDataDescriptionLanguage.g:6279:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6283:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6284:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6290:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6294:1: ( ( 'literal' ) )
            // InternalDataDescriptionLanguage.g:6295:1: ( 'literal' )
            {
            // InternalDataDescriptionLanguage.g:6295:1: ( 'literal' )
            // InternalDataDescriptionLanguage.g:6296:2: 'literal'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            }
            match(input,80,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6306:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6310:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6311:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalDataDescriptionLanguage.g:6318:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6322:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:6323:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:6323:1: ( () )
            // InternalDataDescriptionLanguage.g:6324:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:6325:2: ()
            // InternalDataDescriptionLanguage.g:6325:3: 
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
    // InternalDataDescriptionLanguage.g:6333:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6337:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6338:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6344:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6348:1: ( ( 'data' ) )
            // InternalDataDescriptionLanguage.g:6349:1: ( 'data' )
            {
            // InternalDataDescriptionLanguage.g:6349:1: ( 'data' )
            // InternalDataDescriptionLanguage.g:6350:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6360:1: rule__InstanceTypeRule__Group__0 : rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 ;
    public final void rule__InstanceTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6364:1: ( rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6365:2: rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalDataDescriptionLanguage.g:6372:1: rule__InstanceTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__InstanceTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6376:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:6377:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:6377:1: ( () )
            // InternalDataDescriptionLanguage.g:6378:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:6379:2: ()
            // InternalDataDescriptionLanguage.g:6379:3: 
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
    // InternalDataDescriptionLanguage.g:6387:1: rule__InstanceTypeRule__Group__1 : rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 ;
    public final void rule__InstanceTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6391:1: ( rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 )
            // InternalDataDescriptionLanguage.g:6392:2: rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2
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
    // InternalDataDescriptionLanguage.g:6399:1: rule__InstanceTypeRule__Group__1__Impl : ( 'instance' ) ;
    public final void rule__InstanceTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6403:1: ( ( 'instance' ) )
            // InternalDataDescriptionLanguage.g:6404:1: ( 'instance' )
            {
            // InternalDataDescriptionLanguage.g:6404:1: ( 'instance' )
            // InternalDataDescriptionLanguage.g:6405:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6414:1: rule__InstanceTypeRule__Group__2 : rule__InstanceTypeRule__Group__2__Impl ;
    public final void rule__InstanceTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6418:1: ( rule__InstanceTypeRule__Group__2__Impl )
            // InternalDataDescriptionLanguage.g:6419:2: rule__InstanceTypeRule__Group__2__Impl
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
    // InternalDataDescriptionLanguage.g:6425:1: rule__InstanceTypeRule__Group__2__Impl : ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) ) ;
    public final void rule__InstanceTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6429:1: ( ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) ) )
            // InternalDataDescriptionLanguage.g:6430:1: ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) )
            {
            // InternalDataDescriptionLanguage.g:6430:1: ( ( rule__InstanceTypeRule__DefinitionAssignment_2 ) )
            // InternalDataDescriptionLanguage.g:6431:2: ( rule__InstanceTypeRule__DefinitionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionAssignment_2()); 
            }
            // InternalDataDescriptionLanguage.g:6432:2: ( rule__InstanceTypeRule__DefinitionAssignment_2 )
            // InternalDataDescriptionLanguage.g:6432:3: rule__InstanceTypeRule__DefinitionAssignment_2
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
    // InternalDataDescriptionLanguage.g:6441:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6445:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6446:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_56);
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
    // InternalDataDescriptionLanguage.g:6453:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6457:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:6458:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:6458:1: ( () )
            // InternalDataDescriptionLanguage.g:6459:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:6460:2: ()
            // InternalDataDescriptionLanguage.g:6460:3: 
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
    // InternalDataDescriptionLanguage.g:6468:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6472:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6473:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6479:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6483:1: ( ( 'string' ) )
            // InternalDataDescriptionLanguage.g:6484:1: ( 'string' )
            {
            // InternalDataDescriptionLanguage.g:6484:1: ( 'string' )
            // InternalDataDescriptionLanguage.g:6485:2: 'string'
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
    // InternalDataDescriptionLanguage.g:6495:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6499:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6500:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_57);
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
    // InternalDataDescriptionLanguage.g:6507:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6511:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:6512:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:6512:1: ( () )
            // InternalDataDescriptionLanguage.g:6513:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:6514:2: ()
            // InternalDataDescriptionLanguage.g:6514:3: 
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
    // InternalDataDescriptionLanguage.g:6522:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6526:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6527:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6533:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6537:1: ( ( 'expression' ) )
            // InternalDataDescriptionLanguage.g:6538:1: ( 'expression' )
            {
            // InternalDataDescriptionLanguage.g:6538:1: ( 'expression' )
            // InternalDataDescriptionLanguage.g:6539:2: 'expression'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            }
            match(input,81,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6549:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6553:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6554:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_58);
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
    // InternalDataDescriptionLanguage.g:6561:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6565:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:6566:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:6566:1: ( () )
            // InternalDataDescriptionLanguage.g:6567:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:6568:2: ()
            // InternalDataDescriptionLanguage.g:6568:3: 
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
    // InternalDataDescriptionLanguage.g:6576:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6580:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6581:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6587:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6591:1: ( ( 'int' ) )
            // InternalDataDescriptionLanguage.g:6592:1: ( 'int' )
            {
            // InternalDataDescriptionLanguage.g:6592:1: ( 'int' )
            // InternalDataDescriptionLanguage.g:6593:2: 'int'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            }
            match(input,82,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6603:1: rule__RealTypeRule__Group__0 : rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 ;
    public final void rule__RealTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6607:1: ( rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6608:2: rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1
            {
            pushFollow(FOLLOW_59);
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
    // InternalDataDescriptionLanguage.g:6615:1: rule__RealTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__RealTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6619:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:6620:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:6620:1: ( () )
            // InternalDataDescriptionLanguage.g:6621:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:6622:2: ()
            // InternalDataDescriptionLanguage.g:6622:3: 
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
    // InternalDataDescriptionLanguage.g:6630:1: rule__RealTypeRule__Group__1 : rule__RealTypeRule__Group__1__Impl ;
    public final void rule__RealTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6634:1: ( rule__RealTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6635:2: rule__RealTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6641:1: rule__RealTypeRule__Group__1__Impl : ( 'real' ) ;
    public final void rule__RealTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6645:1: ( ( 'real' ) )
            // InternalDataDescriptionLanguage.g:6646:1: ( 'real' )
            {
            // InternalDataDescriptionLanguage.g:6646:1: ( 'real' )
            // InternalDataDescriptionLanguage.g:6647:2: 'real'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealKeyword_1()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6657:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6661:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6662:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_60);
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
    // InternalDataDescriptionLanguage.g:6669:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6673:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:6674:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:6674:1: ( () )
            // InternalDataDescriptionLanguage.g:6675:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:6676:2: ()
            // InternalDataDescriptionLanguage.g:6676:3: 
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
    // InternalDataDescriptionLanguage.g:6684:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6688:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6689:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6695:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6699:1: ( ( 'boolean' ) )
            // InternalDataDescriptionLanguage.g:6700:1: ( 'boolean' )
            {
            // InternalDataDescriptionLanguage.g:6700:1: ( 'boolean' )
            // InternalDataDescriptionLanguage.g:6701:2: 'boolean'
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
    // InternalDataDescriptionLanguage.g:6711:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6715:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6716:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_61);
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
    // InternalDataDescriptionLanguage.g:6723:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6727:1: ( ( () ) )
            // InternalDataDescriptionLanguage.g:6728:1: ( () )
            {
            // InternalDataDescriptionLanguage.g:6728:1: ( () )
            // InternalDataDescriptionLanguage.g:6729:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            }
            // InternalDataDescriptionLanguage.g:6730:2: ()
            // InternalDataDescriptionLanguage.g:6730:3: 
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
    // InternalDataDescriptionLanguage.g:6738:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6742:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6743:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6749:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6753:1: ( ( 'void' ) )
            // InternalDataDescriptionLanguage.g:6754:1: ( 'void' )
            {
            // InternalDataDescriptionLanguage.g:6754:1: ( 'void' )
            // InternalDataDescriptionLanguage.g:6755:2: 'void'
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


    // $ANTLR start "rule__ArrayTypeRule__Group__0"
    // InternalDataDescriptionLanguage.g:6765:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6769:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6770:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalDataDescriptionLanguage.g:6777:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6781:1: ( ( 'array' ) )
            // InternalDataDescriptionLanguage.g:6782:1: ( 'array' )
            {
            // InternalDataDescriptionLanguage.g:6782:1: ( 'array' )
            // InternalDataDescriptionLanguage.g:6783:2: 'array'
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
    // InternalDataDescriptionLanguage.g:6792:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6796:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6797:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6803:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6807:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:6808:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:6808:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:6809:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:6810:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalDataDescriptionLanguage.g:6810:3: rule__ArrayTypeRule__ElementsAssignment_1
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
    // InternalDataDescriptionLanguage.g:6819:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6823:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6824:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
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
    // InternalDataDescriptionLanguage.g:6831:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6835:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalDataDescriptionLanguage.g:6836:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalDataDescriptionLanguage.g:6836:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalDataDescriptionLanguage.g:6837:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            }
            // InternalDataDescriptionLanguage.g:6838:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalDataDescriptionLanguage.g:6838:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalDataDescriptionLanguage.g:6846:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6850:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:6851:2: rule__ParameterRule__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:6857:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6861:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:6862:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:6862:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:6863:2: ( rule__ParameterRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:6864:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalDataDescriptionLanguage.g:6864:3: rule__ParameterRule__NameAssignment_1
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
    // InternalDataDescriptionLanguage.g:6873:1: rule__ImportRule__Group__0 : rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 ;
    public final void rule__ImportRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6877:1: ( rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 )
            // InternalDataDescriptionLanguage.g:6878:2: rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1
            {
            pushFollow(FOLLOW_62);
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
    // InternalDataDescriptionLanguage.g:6885:1: rule__ImportRule__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6889:1: ( ( 'import' ) )
            // InternalDataDescriptionLanguage.g:6890:1: ( 'import' )
            {
            // InternalDataDescriptionLanguage.g:6890:1: ( 'import' )
            // InternalDataDescriptionLanguage.g:6891:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportKeyword_0()); 
            }
            match(input,85,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6900:1: rule__ImportRule__Group__1 : rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 ;
    public final void rule__ImportRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6904:1: ( rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 )
            // InternalDataDescriptionLanguage.g:6905:2: rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2
            {
            pushFollow(FOLLOW_63);
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
    // InternalDataDescriptionLanguage.g:6912:1: rule__ImportRule__Group__1__Impl : ( ( rule__ImportRule__LanguageAssignment_1 ) ) ;
    public final void rule__ImportRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6916:1: ( ( ( rule__ImportRule__LanguageAssignment_1 ) ) )
            // InternalDataDescriptionLanguage.g:6917:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            {
            // InternalDataDescriptionLanguage.g:6917:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            // InternalDataDescriptionLanguage.g:6918:2: ( rule__ImportRule__LanguageAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getLanguageAssignment_1()); 
            }
            // InternalDataDescriptionLanguage.g:6919:2: ( rule__ImportRule__LanguageAssignment_1 )
            // InternalDataDescriptionLanguage.g:6919:3: rule__ImportRule__LanguageAssignment_1
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
    // InternalDataDescriptionLanguage.g:6927:1: rule__ImportRule__Group__2 : rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 ;
    public final void rule__ImportRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6931:1: ( rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 )
            // InternalDataDescriptionLanguage.g:6932:2: rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3
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
    // InternalDataDescriptionLanguage.g:6939:1: rule__ImportRule__Group__2__Impl : ( 'from' ) ;
    public final void rule__ImportRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6943:1: ( ( 'from' ) )
            // InternalDataDescriptionLanguage.g:6944:1: ( 'from' )
            {
            // InternalDataDescriptionLanguage.g:6944:1: ( 'from' )
            // InternalDataDescriptionLanguage.g:6945:2: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getFromKeyword_2()); 
            }
            match(input,86,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:6954:1: rule__ImportRule__Group__3 : rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 ;
    public final void rule__ImportRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6958:1: ( rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 )
            // InternalDataDescriptionLanguage.g:6959:2: rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4
            {
            pushFollow(FOLLOW_28);
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
    // InternalDataDescriptionLanguage.g:6966:1: rule__ImportRule__Group__3__Impl : ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) ;
    public final void rule__ImportRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6970:1: ( ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) )
            // InternalDataDescriptionLanguage.g:6971:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            {
            // InternalDataDescriptionLanguage.g:6971:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            // InternalDataDescriptionLanguage.g:6972:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_3()); 
            }
            // InternalDataDescriptionLanguage.g:6973:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            // InternalDataDescriptionLanguage.g:6973:3: rule__ImportRule__ImportedNamespaceAssignment_3
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
    // InternalDataDescriptionLanguage.g:6981:1: rule__ImportRule__Group__4 : rule__ImportRule__Group__4__Impl ;
    public final void rule__ImportRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6985:1: ( rule__ImportRule__Group__4__Impl )
            // InternalDataDescriptionLanguage.g:6986:2: rule__ImportRule__Group__4__Impl
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
    // InternalDataDescriptionLanguage.g:6992:1: rule__ImportRule__Group__4__Impl : ( ';' ) ;
    public final void rule__ImportRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:6996:1: ( ( ';' ) )
            // InternalDataDescriptionLanguage.g:6997:1: ( ';' )
            {
            // InternalDataDescriptionLanguage.g:6997:1: ( ';' )
            // InternalDataDescriptionLanguage.g:6998:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getSemicolonKeyword_4()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:7008:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7012:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDataDescriptionLanguage.g:7013:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_64);
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
    // InternalDataDescriptionLanguage.g:7020:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7024:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:7025:1: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:7025:1: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:7026:2: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:7035:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7039:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDataDescriptionLanguage.g:7040:2: rule__QualifiedName__Group__1__Impl
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
    // InternalDataDescriptionLanguage.g:7046:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7050:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDataDescriptionLanguage.g:7051:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDataDescriptionLanguage.g:7051:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDataDescriptionLanguage.g:7052:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalDataDescriptionLanguage.g:7053:2: ( rule__QualifiedName__Group_1__0 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==87) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:7053:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_65);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop56;
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
    // InternalDataDescriptionLanguage.g:7062:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7066:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDataDescriptionLanguage.g:7067:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalDataDescriptionLanguage.g:7074:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7078:1: ( ( '.' ) )
            // InternalDataDescriptionLanguage.g:7079:1: ( '.' )
            {
            // InternalDataDescriptionLanguage.g:7079:1: ( '.' )
            // InternalDataDescriptionLanguage.g:7080:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,87,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:7089:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7093:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDataDescriptionLanguage.g:7094:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalDataDescriptionLanguage.g:7100:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7104:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:7105:1: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:7105:1: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:7106:2: ruleStringOrId
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


    // $ANTLR start "rule__DataDescriptionModelRule__ImportsAssignment_0"
    // InternalDataDescriptionLanguage.g:7116:1: rule__DataDescriptionModelRule__ImportsAssignment_0 : ( ruleImportRule ) ;
    public final void rule__DataDescriptionModelRule__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7120:1: ( ( ruleImportRule ) )
            // InternalDataDescriptionLanguage.g:7121:2: ( ruleImportRule )
            {
            // InternalDataDescriptionLanguage.g:7121:2: ( ruleImportRule )
            // InternalDataDescriptionLanguage.g:7122:3: ruleImportRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getImportsImportRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleImportRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getImportsImportRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__ImportsAssignment_0"


    // $ANTLR start "rule__DataDescriptionModelRule__NameAssignment_2"
    // InternalDataDescriptionLanguage.g:7131:1: rule__DataDescriptionModelRule__NameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__DataDescriptionModelRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7135:1: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:7136:2: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:7136:2: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:7137:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__NameAssignment_2"


    // $ANTLR start "rule__DataDescriptionModelRule__TypesAssignment_4_2"
    // InternalDataDescriptionLanguage.g:7146:1: rule__DataDescriptionModelRule__TypesAssignment_4_2 : ( ruleDataTypeDefinitionRule ) ;
    public final void rule__DataDescriptionModelRule__TypesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7150:1: ( ( ruleDataTypeDefinitionRule ) )
            // InternalDataDescriptionLanguage.g:7151:2: ( ruleDataTypeDefinitionRule )
            {
            // InternalDataDescriptionLanguage.g:7151:2: ( ruleDataTypeDefinitionRule )
            // InternalDataDescriptionLanguage.g:7152:3: ruleDataTypeDefinitionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getTypesDataTypeDefinitionRuleParserRuleCall_4_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDataTypeDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getTypesDataTypeDefinitionRuleParserRuleCall_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__TypesAssignment_4_2"


    // $ANTLR start "rule__DataDescriptionModelRule__DescriptionsAssignment_5_2"
    // InternalDataDescriptionLanguage.g:7161:1: rule__DataDescriptionModelRule__DescriptionsAssignment_5_2 : ( ruleDataDescriptionRule ) ;
    public final void rule__DataDescriptionModelRule__DescriptionsAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7165:1: ( ( ruleDataDescriptionRule ) )
            // InternalDataDescriptionLanguage.g:7166:2: ( ruleDataDescriptionRule )
            {
            // InternalDataDescriptionLanguage.g:7166:2: ( ruleDataDescriptionRule )
            // InternalDataDescriptionLanguage.g:7167:3: ruleDataDescriptionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsDataDescriptionRuleParserRuleCall_5_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDataDescriptionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsDataDescriptionRuleParserRuleCall_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__DescriptionsAssignment_5_2"


    // $ANTLR start "rule__DataDescriptionModelRule__ConstraintsAssignment_6_2"
    // InternalDataDescriptionLanguage.g:7176:1: rule__DataDescriptionModelRule__ConstraintsAssignment_6_2 : ( ruleStatementRule ) ;
    public final void rule__DataDescriptionModelRule__ConstraintsAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7180:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:7181:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:7181:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:7182:3: ruleStatementRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsStatementRuleParserRuleCall_6_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsStatementRuleParserRuleCall_6_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDescriptionModelRule__ConstraintsAssignment_6_2"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0"
    // InternalDataDescriptionLanguage.g:7191:1: rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7195:1: ( ( ruleConstraintRule ) )
            // InternalDataDescriptionLanguage.g:7196:2: ( ruleConstraintRule )
            {
            // InternalDataDescriptionLanguage.g:7196:2: ( ruleConstraintRule )
            // InternalDataDescriptionLanguage.g:7197:3: ruleConstraintRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstraintRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_0"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1"
    // InternalDataDescriptionLanguage.g:7206:1: rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1 : ( ruleScaleType ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7210:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:7211:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:7211:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:7212:3: ruleScaleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getScaleScaleTypeEnumRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleScaleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getScaleScaleTypeEnumRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__ScaleAssignment_1"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3"
    // InternalDataDescriptionLanguage.g:7221:1: rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7225:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:7226:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:7226:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:7227:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__NameAssignment_3"


    // $ANTLR start "rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3"
    // InternalDataDescriptionLanguage.g:7236:1: rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3 : ( ruleStatementRule ) ;
    public final void rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7240:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:7241:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:7241:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:7242:3: ruleStatementRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseDataTypeTypeDefinitionRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BaseDataTypeTypeDefinitionRule__ConstraintsAssignment_4_3"


    // $ANTLR start "rule__EnumLiteralRule__NameAssignment"
    // InternalDataDescriptionLanguage.g:7251:1: rule__EnumLiteralRule__NameAssignment : ( ruleStringOrId ) ;
    public final void rule__EnumLiteralRule__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7255:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:7256:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:7256:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:7257:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumLiteralRuleAccess().getNameStringOrIdParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumLiteralRuleAccess().getNameStringOrIdParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralRule__NameAssignment"


    // $ANTLR start "rule__EnumTypeDefinitionRule__ConstraintsAssignment_0"
    // InternalDataDescriptionLanguage.g:7266:1: rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__EnumTypeDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7270:1: ( ( ruleConstraintRule ) )
            // InternalDataDescriptionLanguage.g:7271:2: ( ruleConstraintRule )
            {
            // InternalDataDescriptionLanguage.g:7271:2: ( ruleConstraintRule )
            // InternalDataDescriptionLanguage.g:7272:3: ruleConstraintRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstraintRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__ConstraintsAssignment_0"


    // $ANTLR start "rule__EnumTypeDefinitionRule__ScaleAssignment_1"
    // InternalDataDescriptionLanguage.g:7281:1: rule__EnumTypeDefinitionRule__ScaleAssignment_1 : ( ruleScaleType ) ;
    public final void rule__EnumTypeDefinitionRule__ScaleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7285:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:7286:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:7286:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:7287:3: ruleScaleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getScaleScaleTypeEnumRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleScaleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getScaleScaleTypeEnumRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__ScaleAssignment_1"


    // $ANTLR start "rule__EnumTypeDefinitionRule__NameAssignment_3"
    // InternalDataDescriptionLanguage.g:7296:1: rule__EnumTypeDefinitionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__EnumTypeDefinitionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7300:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:7301:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:7301:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:7302:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__NameAssignment_3"


    // $ANTLR start "rule__EnumTypeDefinitionRule__LiteralsAssignment_5"
    // InternalDataDescriptionLanguage.g:7311:1: rule__EnumTypeDefinitionRule__LiteralsAssignment_5 : ( ruleEnumLiteralRule ) ;
    public final void rule__EnumTypeDefinitionRule__LiteralsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7315:1: ( ( ruleEnumLiteralRule ) )
            // InternalDataDescriptionLanguage.g:7316:2: ( ruleEnumLiteralRule )
            {
            // InternalDataDescriptionLanguage.g:7316:2: ( ruleEnumLiteralRule )
            // InternalDataDescriptionLanguage.g:7317:3: ruleEnumLiteralRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsEnumLiteralRuleParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEnumLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsEnumLiteralRuleParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__LiteralsAssignment_5"


    // $ANTLR start "rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1"
    // InternalDataDescriptionLanguage.g:7326:1: rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 : ( ruleEnumLiteralRule ) ;
    public final void rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7330:1: ( ( ruleEnumLiteralRule ) )
            // InternalDataDescriptionLanguage.g:7331:2: ( ruleEnumLiteralRule )
            {
            // InternalDataDescriptionLanguage.g:7331:2: ( ruleEnumLiteralRule )
            // InternalDataDescriptionLanguage.g:7332:3: ruleEnumLiteralRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsEnumLiteralRuleParserRuleCall_6_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEnumLiteralRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsEnumLiteralRuleParserRuleCall_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1"


    // $ANTLR start "rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3"
    // InternalDataDescriptionLanguage.g:7341:1: rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 : ( ruleStatementRule ) ;
    public final void rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7345:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:7346:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:7346:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:7347:3: ruleStatementRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsStatementRuleParserRuleCall_8_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsStatementRuleParserRuleCall_8_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0"
    // InternalDataDescriptionLanguage.g:7356:1: rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7360:1: ( ( ruleConstraintRule ) )
            // InternalDataDescriptionLanguage.g:7361:2: ( ruleConstraintRule )
            {
            // InternalDataDescriptionLanguage.g:7361:2: ( ruleConstraintRule )
            // InternalDataDescriptionLanguage.g:7362:3: ruleConstraintRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstraintRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_0"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1"
    // InternalDataDescriptionLanguage.g:7371:1: rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1 : ( ruleRepresentationType ) ;
    public final void rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7375:1: ( ( ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:7376:2: ( ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:7376:2: ( ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:7377:3: ruleRepresentationType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRepresentationType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__RepresentationAssignment_1"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__NameAssignment_3"
    // InternalDataDescriptionLanguage.g:7386:1: rule__TypedBaseDataDescriptionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__TypedBaseDataDescriptionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7390:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:7391:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:7391:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:7392:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__NameAssignment_3"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__TypeAssignment_6"
    // InternalDataDescriptionLanguage.g:7401:1: rule__TypedBaseDataDescriptionRule__TypeAssignment_6 : ( ( ruleStringOrId ) ) ;
    public final void rule__TypedBaseDataDescriptionRule__TypeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7405:1: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:7406:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:7406:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:7407:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeDataTypeTypeDefinitionCrossReference_6_0()); 
            }
            // InternalDataDescriptionLanguage.g:7408:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:7409:4: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeDataTypeTypeDefinitionStringOrIdParserRuleCall_6_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeDataTypeTypeDefinitionStringOrIdParserRuleCall_6_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeDataTypeTypeDefinitionCrossReference_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__TypeAssignment_6"


    // $ANTLR start "rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3"
    // InternalDataDescriptionLanguage.g:7420:1: rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3 : ( ruleStatementRule ) ;
    public final void rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7424:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:7425:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:7425:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:7426:3: ruleStatementRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_7_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_7_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedBaseDataDescriptionRule__ConstraintsAssignment_7_3"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0"
    // InternalDataDescriptionLanguage.g:7435:1: rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7439:1: ( ( ruleConstraintRule ) )
            // InternalDataDescriptionLanguage.g:7440:2: ( ruleConstraintRule )
            {
            // InternalDataDescriptionLanguage.g:7440:2: ( ruleConstraintRule )
            // InternalDataDescriptionLanguage.g:7441:3: ruleConstraintRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstraintRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_0"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1"
    // InternalDataDescriptionLanguage.g:7450:1: rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1 : ( ruleScaleType ) ;
    public final void rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7454:1: ( ( ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:7455:2: ( ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:7455:2: ( ruleScaleType )
            // InternalDataDescriptionLanguage.g:7456:3: ruleScaleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getScaleScaleTypeEnumRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleScaleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getScaleScaleTypeEnumRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__ScaleAssignment_1"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2"
    // InternalDataDescriptionLanguage.g:7465:1: rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2 : ( ruleRepresentationType ) ;
    public final void rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7469:1: ( ( ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:7470:2: ( ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:7470:2: ( ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:7471:3: ruleRepresentationType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRepresentationType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__RepresentationAssignment_2"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__NameAssignment_4"
    // InternalDataDescriptionLanguage.g:7480:1: rule__UntypedBaseDataDescriptionRule__NameAssignment_4 : ( ruleStringOrId ) ;
    public final void rule__UntypedBaseDataDescriptionRule__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7484:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:7485:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:7485:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:7486:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__NameAssignment_4"


    // $ANTLR start "rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3"
    // InternalDataDescriptionLanguage.g:7495:1: rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3 : ( ruleStatementRule ) ;
    public final void rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7499:1: ( ( ruleStatementRule ) )
            // InternalDataDescriptionLanguage.g:7500:2: ( ruleStatementRule )
            {
            // InternalDataDescriptionLanguage.g:7500:2: ( ruleStatementRule )
            // InternalDataDescriptionLanguage.g:7501:3: ruleStatementRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_5_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatementRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_5_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntypedBaseDataDescriptionRule__ConstraintsAssignment_5_3"


    // $ANTLR start "rule__StructuredDataDescriptionRule__ConstraintsAssignment_0"
    // InternalDataDescriptionLanguage.g:7510:1: rule__StructuredDataDescriptionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__StructuredDataDescriptionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7514:1: ( ( ruleConstraintRule ) )
            // InternalDataDescriptionLanguage.g:7515:2: ( ruleConstraintRule )
            {
            // InternalDataDescriptionLanguage.g:7515:2: ( ruleConstraintRule )
            // InternalDataDescriptionLanguage.g:7516:3: ruleConstraintRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstraintRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__ConstraintsAssignment_0"


    // $ANTLR start "rule__StructuredDataDescriptionRule__NameAssignment_2"
    // InternalDataDescriptionLanguage.g:7525:1: rule__StructuredDataDescriptionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__StructuredDataDescriptionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7529:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:7530:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:7530:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:7531:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__NameAssignment_2"


    // $ANTLR start "rule__StructuredDataDescriptionRule__TypeAssignment_5"
    // InternalDataDescriptionLanguage.g:7540:1: rule__StructuredDataDescriptionRule__TypeAssignment_5 : ( ( ruleQualifiedName ) ) ;
    public final void rule__StructuredDataDescriptionRule__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7544:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:7545:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:7545:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:7546:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getTypeTypeDefinitionCrossReference_5_0()); 
            }
            // InternalDataDescriptionLanguage.g:7547:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:7548:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionRuleAccess().getTypeTypeDefinitionQualifiedNameParserRuleCall_5_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getTypeTypeDefinitionQualifiedNameParserRuleCall_5_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructuredDataDescriptionRuleAccess().getTypeTypeDefinitionCrossReference_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StructuredDataDescriptionRule__TypeAssignment_5"


    // $ANTLR start "rule__OrExpressionRule__SubExpressionsAssignment_0"
    // InternalDataDescriptionLanguage.g:7559:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7563:1: ( ( ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7564:2: ( ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7564:2: ( ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:7565:3: ruleXorExpressionRule
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
    // InternalDataDescriptionLanguage.g:7574:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7578:1: ( ( ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7579:2: ( ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7579:2: ( ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:7580:3: ruleXorExpressionRule
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
    // InternalDataDescriptionLanguage.g:7589:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7593:1: ( ( ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7594:2: ( ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7594:2: ( ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:7595:3: ruleAndExpressionRule
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
    // InternalDataDescriptionLanguage.g:7604:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7608:1: ( ( ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7609:2: ( ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7609:2: ( ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:7610:3: ruleAndExpressionRule
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
    // InternalDataDescriptionLanguage.g:7619:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7623:1: ( ( ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7624:2: ( ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7624:2: ( ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:7625:3: ruleNotExpressionRule
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
    // InternalDataDescriptionLanguage.g:7634:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7638:1: ( ( ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7639:2: ( ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7639:2: ( ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:7640:3: ruleNotExpressionRule
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
    // InternalDataDescriptionLanguage.g:7649:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7653:1: ( ( ( '!' ) ) )
            // InternalDataDescriptionLanguage.g:7654:2: ( ( '!' ) )
            {
            // InternalDataDescriptionLanguage.g:7654:2: ( ( '!' ) )
            // InternalDataDescriptionLanguage.g:7655:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:7656:3: ( '!' )
            // InternalDataDescriptionLanguage.g:7657:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,88,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:7668:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7672:1: ( ( ruleComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7673:2: ( ruleComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7673:2: ( ruleComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:7674:3: ruleComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:7683:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7687:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7688:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7688:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:7689:3: ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:7698:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7702:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7703:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7703:2: ( rulePartialComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:7704:3: rulePartialComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:7713:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7717:1: ( ( ruleComparisonOperatorRule ) )
            // InternalDataDescriptionLanguage.g:7718:2: ( ruleComparisonOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:7718:2: ( ruleComparisonOperatorRule )
            // InternalDataDescriptionLanguage.g:7719:3: ruleComparisonOperatorRule
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
    // InternalDataDescriptionLanguage.g:7728:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7732:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7733:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7733:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:7734:3: ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:7743:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7747:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7748:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7748:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:7749:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDataDescriptionLanguage.g:7758:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7762:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDataDescriptionLanguage.g:7763:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:7763:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDataDescriptionLanguage.g:7764:3: ruleAddOrSubtractOperatorRule
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
    // InternalDataDescriptionLanguage.g:7773:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7777:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7778:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7778:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:7779:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDataDescriptionLanguage.g:7788:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7792:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7793:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7793:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:7794:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:7803:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7807:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalDataDescriptionLanguage.g:7808:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:7808:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalDataDescriptionLanguage.g:7809:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalDataDescriptionLanguage.g:7818:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7822:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7823:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7823:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:7824:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:7833:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7837:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7838:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7838:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:7839:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:7848:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7852:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7853:2: ( rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7853:2: ( rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:7854:3: rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:7863:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7867:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDataDescriptionLanguage.g:7868:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:7868:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDataDescriptionLanguage.g:7869:3: ruleAddOrSubtractOperatorRule
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
    // InternalDataDescriptionLanguage.g:7878:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleValueRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7882:1: ( ( ruleValueRule ) )
            // InternalDataDescriptionLanguage.g:7883:2: ( ruleValueRule )
            {
            // InternalDataDescriptionLanguage.g:7883:2: ( ruleValueRule )
            // InternalDataDescriptionLanguage.g:7884:3: ruleValueRule
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
    // InternalDataDescriptionLanguage.g:7893:1: rule__ArrayRule__ValuesAssignment_2_0 : ( ruleValueRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7897:1: ( ( ruleValueRule ) )
            // InternalDataDescriptionLanguage.g:7898:2: ( ruleValueRule )
            {
            // InternalDataDescriptionLanguage.g:7898:2: ( ruleValueRule )
            // InternalDataDescriptionLanguage.g:7899:3: ruleValueRule
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
    // InternalDataDescriptionLanguage.g:7908:1: rule__ArrayRule__ValuesAssignment_2_1_1 : ( ruleValueRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7912:1: ( ( ruleValueRule ) )
            // InternalDataDescriptionLanguage.g:7913:2: ( ruleValueRule )
            {
            // InternalDataDescriptionLanguage.g:7913:2: ( ruleValueRule )
            // InternalDataDescriptionLanguage.g:7914:3: ruleValueRule
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
    // InternalDataDescriptionLanguage.g:7923:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7927:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7928:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7928:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:7929:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:7938:1: rule__CallRule__FunctionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7942:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:7943:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:7943:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:7944:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionCrossReference_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:7945:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:7946:4: ruleQualifiedName
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
    // InternalDataDescriptionLanguage.g:7957:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7961:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7962:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7962:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:7963:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:7972:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7976:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:7977:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:7977:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:7978:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:7987:1: rule__DataReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:7991:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:7992:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:7992:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:7993:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_1_0()); 
            }
            // InternalDataDescriptionLanguage.g:7994:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:7995:4: ruleQualifiedName
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
    // InternalDataDescriptionLanguage.g:8006:1: rule__ConstantReferenceRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__ConstantReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8010:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:8011:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:8011:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:8012:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantReferenceRuleAccess().getDefinitionConstantDefinitionCrossReference_0()); 
            }
            // InternalDataDescriptionLanguage.g:8013:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:8014:4: ruleQualifiedName
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
    // InternalDataDescriptionLanguage.g:8025:1: rule__InstanceLiteralRule__DefinitionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceLiteralRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8029:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:8030:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:8030:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:8031:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionTypeDefinitionCrossReference_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:8032:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:8033:4: ruleQualifiedName
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
    // InternalDataDescriptionLanguage.g:8044:1: rule__InstanceLiteralRule__AttributesAssignment_2 : ( ruleAttributeRule ) ;
    public final void rule__InstanceLiteralRule__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8048:1: ( ( ruleAttributeRule ) )
            // InternalDataDescriptionLanguage.g:8049:2: ( ruleAttributeRule )
            {
            // InternalDataDescriptionLanguage.g:8049:2: ( ruleAttributeRule )
            // InternalDataDescriptionLanguage.g:8050:3: ruleAttributeRule
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
    // InternalDataDescriptionLanguage.g:8059:1: rule__AttributeRule__DefinitionAssignment_0 : ( ( ruleStringOrId ) ) ;
    public final void rule__AttributeRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8063:1: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:8064:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:8064:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:8065:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:8066:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:8067:4: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:8078:1: rule__AttributeRule__ValueAssignment_2 : ( ruleExpressionRule ) ;
    public final void rule__AttributeRule__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8082:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:8083:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:8083:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:8084:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:8093:1: rule__RealLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__RealLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8097:1: ( ( RULE_DOUBLE ) )
            // InternalDataDescriptionLanguage.g:8098:2: ( RULE_DOUBLE )
            {
            // InternalDataDescriptionLanguage.g:8098:2: ( RULE_DOUBLE )
            // InternalDataDescriptionLanguage.g:8099:3: RULE_DOUBLE
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
    // InternalDataDescriptionLanguage.g:8108:1: rule__RealLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__RealLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8112:1: ( ( ruleFactorRule ) )
            // InternalDataDescriptionLanguage.g:8113:2: ( ruleFactorRule )
            {
            // InternalDataDescriptionLanguage.g:8113:2: ( ruleFactorRule )
            // InternalDataDescriptionLanguage.g:8114:3: ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:8123:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8127:1: ( ( RULE_INT ) )
            // InternalDataDescriptionLanguage.g:8128:2: ( RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:8128:2: ( RULE_INT )
            // InternalDataDescriptionLanguage.g:8129:3: RULE_INT
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
    // InternalDataDescriptionLanguage.g:8138:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8142:1: ( ( ruleFactorRule ) )
            // InternalDataDescriptionLanguage.g:8143:2: ( ruleFactorRule )
            {
            // InternalDataDescriptionLanguage.g:8143:2: ( ruleFactorRule )
            // InternalDataDescriptionLanguage.g:8144:3: ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:8153:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8157:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:8158:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:8158:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:8159:3: RULE_STRING
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
    // InternalDataDescriptionLanguage.g:8168:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8172:1: ( ( ( 'true' ) ) )
            // InternalDataDescriptionLanguage.g:8173:2: ( ( 'true' ) )
            {
            // InternalDataDescriptionLanguage.g:8173:2: ( ( 'true' ) )
            // InternalDataDescriptionLanguage.g:8174:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            // InternalDataDescriptionLanguage.g:8175:3: ( 'true' )
            // InternalDataDescriptionLanguage.g:8176:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            }
            match(input,89,FOLLOW_2); if (state.failed) return ;
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
    // InternalDataDescriptionLanguage.g:8187:1: rule__AttributeDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__AttributeDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8191:1: ( ( ruleConstraintRule ) )
            // InternalDataDescriptionLanguage.g:8192:2: ( ruleConstraintRule )
            {
            // InternalDataDescriptionLanguage.g:8192:2: ( ruleConstraintRule )
            // InternalDataDescriptionLanguage.g:8193:3: ruleConstraintRule
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
    // InternalDataDescriptionLanguage.g:8202:1: rule__AttributeDefinitionRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8206:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:8207:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:8207:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:8208:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:8217:1: rule__AttributeDefinitionRule__TypeAssignment_3 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8221:1: ( ( ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:8222:2: ( ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:8222:2: ( ruleTypeRule )
            // InternalDataDescriptionLanguage.g:8223:3: ruleTypeRule
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
    // InternalDataDescriptionLanguage.g:8232:1: rule__AttributeDefinitionRule__InitialisationAssignment_4_1 : ( ruleExpressionRule ) ;
    public final void rule__AttributeDefinitionRule__InitialisationAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8236:1: ( ( ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:8237:2: ( ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:8237:2: ( ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:8238:3: ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:8247:1: rule__InstanceTypeRule__DefinitionAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceTypeRule__DefinitionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8251:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:8252:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:8252:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:8253:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionTypeDefinitionCrossReference_2_0()); 
            }
            // InternalDataDescriptionLanguage.g:8254:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:8255:4: ruleQualifiedName
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
    // InternalDataDescriptionLanguage.g:8266:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8270:1: ( ( ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:8271:2: ( ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:8271:2: ( ruleTypeRule )
            // InternalDataDescriptionLanguage.g:8272:3: ruleTypeRule
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
    // InternalDataDescriptionLanguage.g:8281:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8285:1: ( ( ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:8286:2: ( ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:8286:2: ( ruleTypeRule )
            // InternalDataDescriptionLanguage.g:8287:3: ruleTypeRule
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
    // InternalDataDescriptionLanguage.g:8296:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8300:1: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:8301:2: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:8301:2: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:8302:3: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:8311:1: rule__ImportRule__LanguageAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ImportRule__LanguageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8315:1: ( ( RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:8316:2: ( RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:8316:2: ( RULE_STRING )
            // InternalDataDescriptionLanguage.g:8317:3: RULE_STRING
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
    // InternalDataDescriptionLanguage.g:8326:1: rule__ImportRule__ImportedNamespaceAssignment_3 : ( ruleQualifiedName ) ;
    public final void rule__ImportRule__ImportedNamespaceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDescriptionLanguage.g:8330:1: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:8331:2: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:8331:2: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:8332:3: ruleQualifiedName
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

    // $ANTLR start synpred1_InternalDataDescriptionLanguage
    public final void synpred1_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        // InternalDataDescriptionLanguage.g:1505:2: ( ( ruleBaseDataTypeTypeDefinitionRule ) )
        // InternalDataDescriptionLanguage.g:1505:2: ( ruleBaseDataTypeTypeDefinitionRule )
        {
        // InternalDataDescriptionLanguage.g:1505:2: ( ruleBaseDataTypeTypeDefinitionRule )
        // InternalDataDescriptionLanguage.g:1506:3: ruleBaseDataTypeTypeDefinitionRule
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getDataTypeDefinitionRuleAccess().getBaseDataTypeTypeDefinitionRuleParserRuleCall_0()); 
        }
        pushFollow(FOLLOW_2);
        ruleBaseDataTypeTypeDefinitionRule();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalDataDescriptionLanguage

    // $ANTLR start synpred2_InternalDataDescriptionLanguage
    public final void synpred2_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        // InternalDataDescriptionLanguage.g:1526:2: ( ( ruleTypedBaseDataDescriptionRule ) )
        // InternalDataDescriptionLanguage.g:1526:2: ( ruleTypedBaseDataDescriptionRule )
        {
        // InternalDataDescriptionLanguage.g:1526:2: ( ruleTypedBaseDataDescriptionRule )
        // InternalDataDescriptionLanguage.g:1527:3: ruleTypedBaseDataDescriptionRule
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getDataDescriptionRuleAccess().getTypedBaseDataDescriptionRuleParserRuleCall_0()); 
        }
        pushFollow(FOLLOW_2);
        ruleTypedBaseDataDescriptionRule();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalDataDescriptionLanguage

    // $ANTLR start synpred3_InternalDataDescriptionLanguage
    public final void synpred3_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        // InternalDataDescriptionLanguage.g:1532:2: ( ( ruleUntypedBaseDataDescriptionRule ) )
        // InternalDataDescriptionLanguage.g:1532:2: ( ruleUntypedBaseDataDescriptionRule )
        {
        // InternalDataDescriptionLanguage.g:1532:2: ( ruleUntypedBaseDataDescriptionRule )
        // InternalDataDescriptionLanguage.g:1533:3: ruleUntypedBaseDataDescriptionRule
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getDataDescriptionRuleAccess().getUntypedBaseDataDescriptionRuleParserRuleCall_1()); 
        }
        pushFollow(FOLLOW_2);
        ruleUntypedBaseDataDescriptionRule();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalDataDescriptionLanguage

    // Delegated rules

    public final boolean synpred1_InternalDataDescriptionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalDataDescriptionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\20\5\0\6\uffff";
    static final String dfa_3s = "\1\117\5\0\6\uffff";
    static final String dfa_4s = "\6\uffff\1\2\3\uffff\1\3\1\1";
    static final String dfa_5s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\6\uffff}>";
    static final String[] dfa_6s = {
            "\4\6\1\2\1\3\1\4\1\5\44\uffff\1\12\22\uffff\1\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1521:1: rule__DataDescriptionRule__Alternatives : ( ( ruleTypedBaseDataDescriptionRule ) | ( ruleUntypedBaseDataDescriptionRule ) | ( ruleStructuredDataDescriptionRule ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_1 = input.LA(1);

                         
                        int index2_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalDataDescriptionLanguage()) ) {s = 11;}

                        else if ( (synpred3_InternalDataDescriptionLanguage()) ) {s = 6;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index2_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_2 = input.LA(1);

                         
                        int index2_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalDataDescriptionLanguage()) ) {s = 11;}

                        else if ( (synpred3_InternalDataDescriptionLanguage()) ) {s = 6;}

                         
                        input.seek(index2_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalDataDescriptionLanguage()) ) {s = 11;}

                        else if ( (synpred3_InternalDataDescriptionLanguage()) ) {s = 6;}

                         
                        input.seek(index2_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_4 = input.LA(1);

                         
                        int index2_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalDataDescriptionLanguage()) ) {s = 11;}

                        else if ( (synpred3_InternalDataDescriptionLanguage()) ) {s = 6;}

                         
                        input.seek(index2_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_5 = input.LA(1);

                         
                        int index2_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalDataDescriptionLanguage()) ) {s = 11;}

                        else if ( (synpred3_InternalDataDescriptionLanguage()) ) {s = 6;}

                         
                        input.seek(index2_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_9s = "\1\4\1\uffff\2\30\3\uffff\1\4\1\uffff\2\30";
    static final String dfa_10s = "\1\131\1\uffff\2\127\3\uffff\1\5\1\uffff\2\127";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\1\3\3\4\6\uffff\1\4\54\uffff\1\6\5\uffff\1\5\4\uffff\1\6\4\uffff\1\1\14\uffff\1\4",
            "",
            "\13\6\25\uffff\1\4\6\uffff\1\6\2\uffff\1\10\2\6\3\uffff\4\6\1\uffff\1\6\11\uffff\1\7",
            "\13\6\25\uffff\1\4\6\uffff\1\6\2\uffff\1\10\2\6\3\uffff\4\6\1\uffff\1\6\11\uffff\1\7",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\13\6\25\uffff\1\4\6\uffff\1\6\2\uffff\1\10\2\6\3\uffff\4\6\1\uffff\1\6\11\uffff\1\7",
            "\13\6\25\uffff\1\4\6\uffff\1\6\2\uffff\1\10\2\6\3\uffff\4\6\1\uffff\1\6\11\uffff\1\7"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1575:1: rule__ValueRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x3600000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000F0000L,0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000F0002L,0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x1000000000FF0000L,0x0000000000008000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x1000000000FF0002L,0x0000000000008000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x10000000C00081F0L,0x0000000003001084L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x10000000C00081F2L,0x0000000003001084L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000F00000L,0x0000000000008000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000FF0000L,0x0000000000008000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000000003F000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000000003F000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000700000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x10000000C00081F0L,0x0000000003003084L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x10000000C00081F0L,0x000000000300108CL});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0200000000000030L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x007FFFF800000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000008000L,0x0000000002000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x00000000000081F0L,0x0000000002000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x1000000000D00000L,0x00000000001F0040L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x8000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});

}
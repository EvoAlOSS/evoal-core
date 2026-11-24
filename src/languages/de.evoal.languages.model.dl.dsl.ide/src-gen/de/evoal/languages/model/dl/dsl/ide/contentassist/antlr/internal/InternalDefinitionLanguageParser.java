package de.evoal.languages.model.dl.dsl.ide.contentassist.antlr.internal;

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
import de.evoal.languages.model.dl.dsl.services.DefinitionLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalDefinitionLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_STRING", "RULE_DOUBLE", "RULE_INT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'>'", "'>='", "'='", "'!='", "'<='", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'module'", "'{'", "'}'", "'enum'", "'('", "')'", "';'", "','", "'with'", "'constraints'", "':'", "'OR'", "'XOR'", "'AND'", "'^'", "'['", "']'", "'path'", "'self'", "'value'", "'.'", "'tree'", "'data'", "'instance'", "':='", "'type'", "'extends'", "'@'", "'literal'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'def'", "'const'", "'import'", "'from'", "'!'", "'true'", "'abstract'", "'optional'"
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
    public static final int RULE_INT=8;
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
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_DOUBLE=7;
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


        public InternalDefinitionLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDefinitionLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDefinitionLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDefinitionLanguage.g"; }


    	private DefinitionLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(DefinitionLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleDefinitionModelRule"
    // InternalDefinitionLanguage.g:55:1: entryRuleDefinitionModelRule : ruleDefinitionModelRule EOF ;
    public final void entryRuleDefinitionModelRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:56:1: ( ruleDefinitionModelRule EOF )
            // InternalDefinitionLanguage.g:57:1: ruleDefinitionModelRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDefinitionModelRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDefinitionModelRule"


    // $ANTLR start "ruleDefinitionModelRule"
    // InternalDefinitionLanguage.g:64:1: ruleDefinitionModelRule : ( ( rule__DefinitionModelRule__Group__0 ) ) ;
    public final void ruleDefinitionModelRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:68:2: ( ( ( rule__DefinitionModelRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:69:2: ( ( rule__DefinitionModelRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:69:2: ( ( rule__DefinitionModelRule__Group__0 ) )
            // InternalDefinitionLanguage.g:70:3: ( rule__DefinitionModelRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:71:3: ( rule__DefinitionModelRule__Group__0 )
            // InternalDefinitionLanguage.g:71:4: rule__DefinitionModelRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDefinitionModelRule"


    // $ANTLR start "entryRuleEnumLiteralRule"
    // InternalDefinitionLanguage.g:80:1: entryRuleEnumLiteralRule : ruleEnumLiteralRule EOF ;
    public final void entryRuleEnumLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:81:1: ( ruleEnumLiteralRule EOF )
            // InternalDefinitionLanguage.g:82:1: ruleEnumLiteralRule EOF
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
    // InternalDefinitionLanguage.g:89:1: ruleEnumLiteralRule : ( ( rule__EnumLiteralRule__NameAssignment ) ) ;
    public final void ruleEnumLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:93:2: ( ( ( rule__EnumLiteralRule__NameAssignment ) ) )
            // InternalDefinitionLanguage.g:94:2: ( ( rule__EnumLiteralRule__NameAssignment ) )
            {
            // InternalDefinitionLanguage.g:94:2: ( ( rule__EnumLiteralRule__NameAssignment ) )
            // InternalDefinitionLanguage.g:95:3: ( rule__EnumLiteralRule__NameAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumLiteralRuleAccess().getNameAssignment()); 
            }
            // InternalDefinitionLanguage.g:96:3: ( rule__EnumLiteralRule__NameAssignment )
            // InternalDefinitionLanguage.g:96:4: rule__EnumLiteralRule__NameAssignment
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
    // InternalDefinitionLanguage.g:105:1: entryRuleEnumTypeDefinitionRule : ruleEnumTypeDefinitionRule EOF ;
    public final void entryRuleEnumTypeDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:106:1: ( ruleEnumTypeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:107:1: ruleEnumTypeDefinitionRule EOF
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
    // InternalDefinitionLanguage.g:114:1: ruleEnumTypeDefinitionRule : ( ( rule__EnumTypeDefinitionRule__Group__0 ) ) ;
    public final void ruleEnumTypeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:118:2: ( ( ( rule__EnumTypeDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:119:2: ( ( rule__EnumTypeDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:119:2: ( ( rule__EnumTypeDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:120:3: ( rule__EnumTypeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:121:3: ( rule__EnumTypeDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:121:4: rule__EnumTypeDefinitionRule__Group__0
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


    // $ANTLR start "entryRuleStatementRule"
    // InternalDefinitionLanguage.g:130:1: entryRuleStatementRule : ruleStatementRule EOF ;
    public final void entryRuleStatementRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:131:1: ( ruleStatementRule EOF )
            // InternalDefinitionLanguage.g:132:1: ruleStatementRule EOF
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
    // InternalDefinitionLanguage.g:139:1: ruleStatementRule : ( ( rule__StatementRule__Group__0 ) ) ;
    public final void ruleStatementRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:143:2: ( ( ( rule__StatementRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:144:2: ( ( rule__StatementRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:144:2: ( ( rule__StatementRule__Group__0 ) )
            // InternalDefinitionLanguage.g:145:3: ( rule__StatementRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:146:3: ( rule__StatementRule__Group__0 )
            // InternalDefinitionLanguage.g:146:4: rule__StatementRule__Group__0
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


    // $ANTLR start "entryRuleExpressionRule"
    // InternalDefinitionLanguage.g:155:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:156:1: ( ruleExpressionRule EOF )
            // InternalDefinitionLanguage.g:157:1: ruleExpressionRule EOF
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
    // InternalDefinitionLanguage.g:164:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:168:2: ( ( ruleOrExpressionRule ) )
            // InternalDefinitionLanguage.g:169:2: ( ruleOrExpressionRule )
            {
            // InternalDefinitionLanguage.g:169:2: ( ruleOrExpressionRule )
            // InternalDefinitionLanguage.g:170:3: ruleOrExpressionRule
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
    // InternalDefinitionLanguage.g:180:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:181:1: ( ruleOrExpressionRule EOF )
            // InternalDefinitionLanguage.g:182:1: ruleOrExpressionRule EOF
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
    // InternalDefinitionLanguage.g:189:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:193:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:194:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:194:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:195:3: ( rule__OrExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:196:3: ( rule__OrExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:196:4: rule__OrExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:205:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:206:1: ( ruleXorExpressionRule EOF )
            // InternalDefinitionLanguage.g:207:1: ruleXorExpressionRule EOF
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
    // InternalDefinitionLanguage.g:214:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:218:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:219:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:219:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:220:3: ( rule__XorExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:221:3: ( rule__XorExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:221:4: rule__XorExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:230:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:231:1: ( ruleAndExpressionRule EOF )
            // InternalDefinitionLanguage.g:232:1: ruleAndExpressionRule EOF
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
    // InternalDefinitionLanguage.g:239:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:243:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:244:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:244:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:245:3: ( rule__AndExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:246:3: ( rule__AndExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:246:4: rule__AndExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:255:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:256:1: ( ruleNotExpressionRule EOF )
            // InternalDefinitionLanguage.g:257:1: ruleNotExpressionRule EOF
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
    // InternalDefinitionLanguage.g:264:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:268:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:269:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:269:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:270:3: ( rule__NotExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:271:3: ( rule__NotExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:271:4: rule__NotExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:280:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:281:1: ( ruleComparisonExpressionRule EOF )
            // InternalDefinitionLanguage.g:282:1: ruleComparisonExpressionRule EOF
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
    // InternalDefinitionLanguage.g:289:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:293:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:294:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:294:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:295:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:296:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:296:4: rule__ComparisonExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:305:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:306:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalDefinitionLanguage.g:307:1: rulePartialComparisonExpressionRule EOF
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
    // InternalDefinitionLanguage.g:314:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:318:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:319:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:319:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:320:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:321:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:321:4: rule__PartialComparisonExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:330:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:331:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalDefinitionLanguage.g:332:1: ruleAddOrSubtractExpressionRule EOF
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
    // InternalDefinitionLanguage.g:339:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:343:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:344:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:344:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:345:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:346:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:346:4: rule__AddOrSubtractExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:355:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:356:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDefinitionLanguage.g:357:1: ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalDefinitionLanguage.g:364:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:368:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:369:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:369:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:370:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:371:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:371:4: rule__MultiplyDivideModuloExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:380:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:381:1: ( rulePowerOfExpressionRule EOF )
            // InternalDefinitionLanguage.g:382:1: rulePowerOfExpressionRule EOF
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
    // InternalDefinitionLanguage.g:389:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:393:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:394:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:394:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:395:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:396:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:396:4: rule__PowerOfExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:405:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:406:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDefinitionLanguage.g:407:1: ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalDefinitionLanguage.g:414:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:418:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:419:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:419:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:420:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:421:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:421:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:430:1: entryRuleReadExpressionRule : ruleReadExpressionRule EOF ;
    public final void entryRuleReadExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:431:1: ( ruleReadExpressionRule EOF )
            // InternalDefinitionLanguage.g:432:1: ruleReadExpressionRule EOF
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
    // InternalDefinitionLanguage.g:439:1: ruleReadExpressionRule : ( ( rule__ReadExpressionRule__Alternatives ) ) ;
    public final void ruleReadExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:443:2: ( ( ( rule__ReadExpressionRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:444:2: ( ( rule__ReadExpressionRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:444:2: ( ( rule__ReadExpressionRule__Alternatives ) )
            // InternalDefinitionLanguage.g:445:3: ( rule__ReadExpressionRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReadExpressionRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:446:3: ( rule__ReadExpressionRule__Alternatives )
            // InternalDefinitionLanguage.g:446:4: rule__ReadExpressionRule__Alternatives
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
    // InternalDefinitionLanguage.g:455:1: entryRuleArrayRule : ruleArrayRule EOF ;
    public final void entryRuleArrayRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:456:1: ( ruleArrayRule EOF )
            // InternalDefinitionLanguage.g:457:1: ruleArrayRule EOF
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
    // InternalDefinitionLanguage.g:464:1: ruleArrayRule : ( ( rule__ArrayRule__Group__0 ) ) ;
    public final void ruleArrayRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:468:2: ( ( ( rule__ArrayRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:469:2: ( ( rule__ArrayRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:469:2: ( ( rule__ArrayRule__Group__0 ) )
            // InternalDefinitionLanguage.g:470:3: ( rule__ArrayRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:471:3: ( rule__ArrayRule__Group__0 )
            // InternalDefinitionLanguage.g:471:4: rule__ArrayRule__Group__0
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
    // InternalDefinitionLanguage.g:480:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:481:1: ( ruleParanthesesRule EOF )
            // InternalDefinitionLanguage.g:482:1: ruleParanthesesRule EOF
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
    // InternalDefinitionLanguage.g:489:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:493:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:494:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:494:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalDefinitionLanguage.g:495:3: ( rule__ParanthesesRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:496:3: ( rule__ParanthesesRule__Group__0 )
            // InternalDefinitionLanguage.g:496:4: rule__ParanthesesRule__Group__0
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


    // $ANTLR start "entryRulePathExpressionRule"
    // InternalDefinitionLanguage.g:505:1: entryRulePathExpressionRule : rulePathExpressionRule EOF ;
    public final void entryRulePathExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:506:1: ( rulePathExpressionRule EOF )
            // InternalDefinitionLanguage.g:507:1: rulePathExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePathExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathExpressionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePathExpressionRule"


    // $ANTLR start "rulePathExpressionRule"
    // InternalDefinitionLanguage.g:514:1: rulePathExpressionRule : ( ( rule__PathExpressionRule__Group__0 ) ) ;
    public final void rulePathExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:518:2: ( ( ( rule__PathExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:519:2: ( ( rule__PathExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:519:2: ( ( rule__PathExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:520:3: ( rule__PathExpressionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathExpressionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:521:3: ( rule__PathExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:521:4: rule__PathExpressionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PathExpressionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathExpressionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePathExpressionRule"


    // $ANTLR start "entryRuleCallRule"
    // InternalDefinitionLanguage.g:530:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:531:1: ( ruleCallRule EOF )
            // InternalDefinitionLanguage.g:532:1: ruleCallRule EOF
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
    // InternalDefinitionLanguage.g:539:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:543:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:544:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:544:2: ( ( rule__CallRule__Group__0 ) )
            // InternalDefinitionLanguage.g:545:3: ( rule__CallRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:546:3: ( rule__CallRule__Group__0 )
            // InternalDefinitionLanguage.g:546:4: rule__CallRule__Group__0
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
    // InternalDefinitionLanguage.g:555:1: entryRuleReferenceRule : ruleReferenceRule EOF ;
    public final void entryRuleReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:556:1: ( ruleReferenceRule EOF )
            // InternalDefinitionLanguage.g:557:1: ruleReferenceRule EOF
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
    // InternalDefinitionLanguage.g:564:1: ruleReferenceRule : ( ( rule__ReferenceRule__Alternatives ) ) ;
    public final void ruleReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:568:2: ( ( ( rule__ReferenceRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:569:2: ( ( rule__ReferenceRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:569:2: ( ( rule__ReferenceRule__Alternatives ) )
            // InternalDefinitionLanguage.g:570:3: ( rule__ReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:571:3: ( rule__ReferenceRule__Alternatives )
            // InternalDefinitionLanguage.g:571:4: rule__ReferenceRule__Alternatives
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
    // InternalDefinitionLanguage.g:580:1: entryRuleSelfReferenceRule : ruleSelfReferenceRule EOF ;
    public final void entryRuleSelfReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:581:1: ( ruleSelfReferenceRule EOF )
            // InternalDefinitionLanguage.g:582:1: ruleSelfReferenceRule EOF
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
    // InternalDefinitionLanguage.g:589:1: ruleSelfReferenceRule : ( ( rule__SelfReferenceRule__Alternatives ) ) ;
    public final void ruleSelfReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:593:2: ( ( ( rule__SelfReferenceRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:594:2: ( ( rule__SelfReferenceRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:594:2: ( ( rule__SelfReferenceRule__Alternatives ) )
            // InternalDefinitionLanguage.g:595:3: ( rule__SelfReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:596:3: ( rule__SelfReferenceRule__Alternatives )
            // InternalDefinitionLanguage.g:596:4: rule__SelfReferenceRule__Alternatives
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
    // InternalDefinitionLanguage.g:605:1: entryRuleAttributeReferenceRule : ruleAttributeReferenceRule EOF ;
    public final void entryRuleAttributeReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:606:1: ( ruleAttributeReferenceRule EOF )
            // InternalDefinitionLanguage.g:607:1: ruleAttributeReferenceRule EOF
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
    // InternalDefinitionLanguage.g:614:1: ruleAttributeReferenceRule : ( ( rule__AttributeReferenceRule__Group__0 ) ) ;
    public final void ruleAttributeReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:618:2: ( ( ( rule__AttributeReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:619:2: ( ( rule__AttributeReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:619:2: ( ( rule__AttributeReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:620:3: ( rule__AttributeReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:621:3: ( rule__AttributeReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:621:4: rule__AttributeReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:630:1: entryRuleConfigurationReferenceRule : ruleConfigurationReferenceRule EOF ;
    public final void entryRuleConfigurationReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:631:1: ( ruleConfigurationReferenceRule EOF )
            // InternalDefinitionLanguage.g:632:1: ruleConfigurationReferenceRule EOF
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
    // InternalDefinitionLanguage.g:639:1: ruleConfigurationReferenceRule : ( ( rule__ConfigurationReferenceRule__Group__0 ) ) ;
    public final void ruleConfigurationReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:643:2: ( ( ( rule__ConfigurationReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:644:2: ( ( rule__ConfigurationReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:644:2: ( ( rule__ConfigurationReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:645:3: ( rule__ConfigurationReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigurationReferenceRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:646:3: ( rule__ConfigurationReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:646:4: rule__ConfigurationReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:655:1: entryRuleValuelDefinitionReferenceRule : ruleValuelDefinitionReferenceRule EOF ;
    public final void entryRuleValuelDefinitionReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:656:1: ( ruleValuelDefinitionReferenceRule EOF )
            // InternalDefinitionLanguage.g:657:1: ruleValuelDefinitionReferenceRule EOF
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
    // InternalDefinitionLanguage.g:664:1: ruleValuelDefinitionReferenceRule : ( ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment ) ) ;
    public final void ruleValuelDefinitionReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:668:2: ( ( ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment ) ) )
            // InternalDefinitionLanguage.g:669:2: ( ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment ) )
            {
            // InternalDefinitionLanguage.g:669:2: ( ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment ) )
            // InternalDefinitionLanguage.g:670:3: ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionAssignment()); 
            }
            // InternalDefinitionLanguage.g:671:3: ( rule__ValuelDefinitionReferenceRule__DefinitionAssignment )
            // InternalDefinitionLanguage.g:671:4: rule__ValuelDefinitionReferenceRule__DefinitionAssignment
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
    // InternalDefinitionLanguage.g:680:1: entryRuleTypeDefinitionReferenceRule : ruleTypeDefinitionReferenceRule EOF ;
    public final void entryRuleTypeDefinitionReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:681:1: ( ruleTypeDefinitionReferenceRule EOF )
            // InternalDefinitionLanguage.g:682:1: ruleTypeDefinitionReferenceRule EOF
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
    // InternalDefinitionLanguage.g:689:1: ruleTypeDefinitionReferenceRule : ( ( rule__TypeDefinitionReferenceRule__Alternatives ) ) ;
    public final void ruleTypeDefinitionReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:693:2: ( ( ( rule__TypeDefinitionReferenceRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:694:2: ( ( rule__TypeDefinitionReferenceRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:694:2: ( ( rule__TypeDefinitionReferenceRule__Alternatives ) )
            // InternalDefinitionLanguage.g:695:3: ( rule__TypeDefinitionReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionReferenceRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:696:3: ( rule__TypeDefinitionReferenceRule__Alternatives )
            // InternalDefinitionLanguage.g:696:4: rule__TypeDefinitionReferenceRule__Alternatives
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
    // InternalDefinitionLanguage.g:705:1: entryRuleBaseDataReferenceRule : ruleBaseDataReferenceRule EOF ;
    public final void entryRuleBaseDataReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:706:1: ( ruleBaseDataReferenceRule EOF )
            // InternalDefinitionLanguage.g:707:1: ruleBaseDataReferenceRule EOF
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
    // InternalDefinitionLanguage.g:714:1: ruleBaseDataReferenceRule : ( ( rule__BaseDataReferenceRule__Group__0 ) ) ;
    public final void ruleBaseDataReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:718:2: ( ( ( rule__BaseDataReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:719:2: ( ( rule__BaseDataReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:719:2: ( ( rule__BaseDataReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:720:3: ( rule__BaseDataReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:721:3: ( rule__BaseDataReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:721:4: rule__BaseDataReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:730:1: entryRuleStructuredDataDescriptionReferenceRule : ruleStructuredDataDescriptionReferenceRule EOF ;
    public final void entryRuleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:731:1: ( ruleStructuredDataDescriptionReferenceRule EOF )
            // InternalDefinitionLanguage.g:732:1: ruleStructuredDataDescriptionReferenceRule EOF
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
    // InternalDefinitionLanguage.g:739:1: ruleStructuredDataDescriptionReferenceRule : ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) ) ;
    public final void ruleStructuredDataDescriptionReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:743:2: ( ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:744:2: ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:744:2: ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:745:3: ( rule__StructuredDataDescriptionReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:746:3: ( rule__StructuredDataDescriptionReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:746:4: rule__StructuredDataDescriptionReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:755:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:756:1: ( ruleLiteralRule EOF )
            // InternalDefinitionLanguage.g:757:1: ruleLiteralRule EOF
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
    // InternalDefinitionLanguage.g:764:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:768:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:769:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:769:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalDefinitionLanguage.g:770:3: ( rule__LiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:771:3: ( rule__LiteralRule__Alternatives )
            // InternalDefinitionLanguage.g:771:4: rule__LiteralRule__Alternatives
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
    // InternalDefinitionLanguage.g:780:1: entryRuleInstanceLiteralRule : ruleInstanceLiteralRule EOF ;
    public final void entryRuleInstanceLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:781:1: ( ruleInstanceLiteralRule EOF )
            // InternalDefinitionLanguage.g:782:1: ruleInstanceLiteralRule EOF
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
    // InternalDefinitionLanguage.g:789:1: ruleInstanceLiteralRule : ( ( rule__InstanceLiteralRule__Group__0 ) ) ;
    public final void ruleInstanceLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:793:2: ( ( ( rule__InstanceLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:794:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:794:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:795:3: ( rule__InstanceLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:796:3: ( rule__InstanceLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:796:4: rule__InstanceLiteralRule__Group__0
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
    // InternalDefinitionLanguage.g:805:1: entryRuleAttributeRule : ruleAttributeRule EOF ;
    public final void entryRuleAttributeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:806:1: ( ruleAttributeRule EOF )
            // InternalDefinitionLanguage.g:807:1: ruleAttributeRule EOF
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
    // InternalDefinitionLanguage.g:814:1: ruleAttributeRule : ( ( rule__AttributeRule__Group__0 ) ) ;
    public final void ruleAttributeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:818:2: ( ( ( rule__AttributeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:819:2: ( ( rule__AttributeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:819:2: ( ( rule__AttributeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:820:3: ( rule__AttributeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:821:3: ( rule__AttributeRule__Group__0 )
            // InternalDefinitionLanguage.g:821:4: rule__AttributeRule__Group__0
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
    // InternalDefinitionLanguage.g:830:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:831:1: ( ruleNumberLiteralRule EOF )
            // InternalDefinitionLanguage.g:832:1: ruleNumberLiteralRule EOF
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
    // InternalDefinitionLanguage.g:839:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:843:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:844:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:844:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalDefinitionLanguage.g:845:3: ( rule__NumberLiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:846:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalDefinitionLanguage.g:846:4: rule__NumberLiteralRule__Alternatives
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
    // InternalDefinitionLanguage.g:855:1: entryRuleRealLiteralRule : ruleRealLiteralRule EOF ;
    public final void entryRuleRealLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:856:1: ( ruleRealLiteralRule EOF )
            // InternalDefinitionLanguage.g:857:1: ruleRealLiteralRule EOF
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
    // InternalDefinitionLanguage.g:864:1: ruleRealLiteralRule : ( ( rule__RealLiteralRule__Group__0 ) ) ;
    public final void ruleRealLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:868:2: ( ( ( rule__RealLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:869:2: ( ( rule__RealLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:869:2: ( ( rule__RealLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:870:3: ( rule__RealLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:871:3: ( rule__RealLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:871:4: rule__RealLiteralRule__Group__0
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
    // InternalDefinitionLanguage.g:880:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:881:1: ( ruleIntegerLiteralRule EOF )
            // InternalDefinitionLanguage.g:882:1: ruleIntegerLiteralRule EOF
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
    // InternalDefinitionLanguage.g:889:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:893:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:894:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:894:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:895:3: ( rule__IntegerLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:896:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:896:4: rule__IntegerLiteralRule__Group__0
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
    // InternalDefinitionLanguage.g:905:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:906:1: ( ruleStringLiteralRule EOF )
            // InternalDefinitionLanguage.g:907:1: ruleStringLiteralRule EOF
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
    // InternalDefinitionLanguage.g:914:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__LiteralAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:918:2: ( ( ( rule__StringLiteralRule__LiteralAssignment ) ) )
            // InternalDefinitionLanguage.g:919:2: ( ( rule__StringLiteralRule__LiteralAssignment ) )
            {
            // InternalDefinitionLanguage.g:919:2: ( ( rule__StringLiteralRule__LiteralAssignment ) )
            // InternalDefinitionLanguage.g:920:3: ( rule__StringLiteralRule__LiteralAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRuleAccess().getLiteralAssignment()); 
            }
            // InternalDefinitionLanguage.g:921:3: ( rule__StringLiteralRule__LiteralAssignment )
            // InternalDefinitionLanguage.g:921:4: rule__StringLiteralRule__LiteralAssignment
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
    // InternalDefinitionLanguage.g:930:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:931:1: ( ruleBooleanLiteralRule EOF )
            // InternalDefinitionLanguage.g:932:1: ruleBooleanLiteralRule EOF
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
    // InternalDefinitionLanguage.g:939:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:943:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:944:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:944:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:945:3: ( rule__BooleanLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:946:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:946:4: rule__BooleanLiteralRule__Group__0
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


    // $ANTLR start "entryRuleClassDefinitionRule"
    // InternalDefinitionLanguage.g:955:1: entryRuleClassDefinitionRule : ruleClassDefinitionRule EOF ;
    public final void entryRuleClassDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:956:1: ( ruleClassDefinitionRule EOF )
            // InternalDefinitionLanguage.g:957:1: ruleClassDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleClassDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassDefinitionRule"


    // $ANTLR start "ruleClassDefinitionRule"
    // InternalDefinitionLanguage.g:964:1: ruleClassDefinitionRule : ( ( rule__ClassDefinitionRule__Group__0 ) ) ;
    public final void ruleClassDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:968:2: ( ( ( rule__ClassDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:969:2: ( ( rule__ClassDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:969:2: ( ( rule__ClassDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:970:3: ( rule__ClassDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:971:3: ( rule__ClassDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:971:4: rule__ClassDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassDefinitionRule"


    // $ANTLR start "entryRuleConstraintRule"
    // InternalDefinitionLanguage.g:980:1: entryRuleConstraintRule : ruleConstraintRule EOF ;
    public final void entryRuleConstraintRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:981:1: ( ruleConstraintRule EOF )
            // InternalDefinitionLanguage.g:982:1: ruleConstraintRule EOF
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
    // InternalDefinitionLanguage.g:989:1: ruleConstraintRule : ( ( rule__ConstraintRule__Group__0 ) ) ;
    public final void ruleConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:993:2: ( ( ( rule__ConstraintRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:994:2: ( ( rule__ConstraintRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:994:2: ( ( rule__ConstraintRule__Group__0 ) )
            // InternalDefinitionLanguage.g:995:3: ( rule__ConstraintRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:996:3: ( rule__ConstraintRule__Group__0 )
            // InternalDefinitionLanguage.g:996:4: rule__ConstraintRule__Group__0
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
    // InternalDefinitionLanguage.g:1005:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1006:1: ( ruleAttributeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:1007:1: ruleAttributeDefinitionRule EOF
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
    // InternalDefinitionLanguage.g:1014:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1018:2: ( ( ( rule__AttributeDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1019:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1019:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1020:3: ( rule__AttributeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1021:3: ( rule__AttributeDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:1021:4: rule__AttributeDefinitionRule__Group__0
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
    // InternalDefinitionLanguage.g:1030:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1031:1: ( ruleTypeRule EOF )
            // InternalDefinitionLanguage.g:1032:1: ruleTypeRule EOF
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
    // InternalDefinitionLanguage.g:1039:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1043:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1044:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1044:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1045:3: ( rule__TypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1046:3: ( rule__TypeRule__Alternatives )
            // InternalDefinitionLanguage.g:1046:4: rule__TypeRule__Alternatives
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
    // InternalDefinitionLanguage.g:1055:1: entryRuleBaseTypeRule : ruleBaseTypeRule EOF ;
    public final void entryRuleBaseTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1056:1: ( ruleBaseTypeRule EOF )
            // InternalDefinitionLanguage.g:1057:1: ruleBaseTypeRule EOF
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
    // InternalDefinitionLanguage.g:1064:1: ruleBaseTypeRule : ( ( rule__BaseTypeRule__Alternatives ) ) ;
    public final void ruleBaseTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1068:2: ( ( ( rule__BaseTypeRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1069:2: ( ( rule__BaseTypeRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1069:2: ( ( rule__BaseTypeRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1070:3: ( rule__BaseTypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseTypeRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1071:3: ( rule__BaseTypeRule__Alternatives )
            // InternalDefinitionLanguage.g:1071:4: rule__BaseTypeRule__Alternatives
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
    // InternalDefinitionLanguage.g:1080:1: entryRuleEnumReferenceRule : ruleEnumReferenceRule EOF ;
    public final void entryRuleEnumReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1081:1: ( ruleEnumReferenceRule EOF )
            // InternalDefinitionLanguage.g:1082:1: ruleEnumReferenceRule EOF
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
    // InternalDefinitionLanguage.g:1089:1: ruleEnumReferenceRule : ( ( rule__EnumReferenceRule__Group__0 ) ) ;
    public final void ruleEnumReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1093:2: ( ( ( rule__EnumReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1094:2: ( ( rule__EnumReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1094:2: ( ( rule__EnumReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1095:3: ( rule__EnumReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1096:3: ( rule__EnumReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:1096:4: rule__EnumReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:1105:1: entryRuleTypeReferenceRule : ruleTypeReferenceRule EOF ;
    public final void entryRuleTypeReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1106:1: ( ruleTypeReferenceRule EOF )
            // InternalDefinitionLanguage.g:1107:1: ruleTypeReferenceRule EOF
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
    // InternalDefinitionLanguage.g:1114:1: ruleTypeReferenceRule : ( ( rule__TypeReferenceRule__Group__0 ) ) ;
    public final void ruleTypeReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1118:2: ( ( ( rule__TypeReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1119:2: ( ( rule__TypeReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1119:2: ( ( rule__TypeReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1120:3: ( rule__TypeReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1121:3: ( rule__TypeReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:1121:4: rule__TypeReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:1130:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1131:1: ( ruleLiteralTypeRule EOF )
            // InternalDefinitionLanguage.g:1132:1: ruleLiteralTypeRule EOF
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
    // InternalDefinitionLanguage.g:1139:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1143:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1144:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1144:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1145:3: ( rule__LiteralTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1146:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1146:4: rule__LiteralTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1155:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1156:1: ( ruleDataTypeRule EOF )
            // InternalDefinitionLanguage.g:1157:1: ruleDataTypeRule EOF
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
    // InternalDefinitionLanguage.g:1164:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1168:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1169:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1169:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1170:3: ( rule__DataTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1171:3: ( rule__DataTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1171:4: rule__DataTypeRule__Group__0
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


    // $ANTLR start "entryRulePathTypeRule"
    // InternalDefinitionLanguage.g:1180:1: entryRulePathTypeRule : rulePathTypeRule EOF ;
    public final void entryRulePathTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1181:1: ( rulePathTypeRule EOF )
            // InternalDefinitionLanguage.g:1182:1: rulePathTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePathTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePathTypeRule"


    // $ANTLR start "rulePathTypeRule"
    // InternalDefinitionLanguage.g:1189:1: rulePathTypeRule : ( ( rule__PathTypeRule__Group__0 ) ) ;
    public final void rulePathTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1193:2: ( ( ( rule__PathTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1194:2: ( ( rule__PathTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1194:2: ( ( rule__PathTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1195:3: ( rule__PathTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1196:3: ( rule__PathTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1196:4: rule__PathTypeRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PathTypeRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePathTypeRule"


    // $ANTLR start "entryRuleStringTypeRule"
    // InternalDefinitionLanguage.g:1205:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1206:1: ( ruleStringTypeRule EOF )
            // InternalDefinitionLanguage.g:1207:1: ruleStringTypeRule EOF
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
    // InternalDefinitionLanguage.g:1214:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1218:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1219:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1219:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1220:3: ( rule__StringTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1221:3: ( rule__StringTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1221:4: rule__StringTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1230:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1231:1: ( ruleExpressionTypeRule EOF )
            // InternalDefinitionLanguage.g:1232:1: ruleExpressionTypeRule EOF
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
    // InternalDefinitionLanguage.g:1239:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1243:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1244:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1244:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1245:3: ( rule__ExpressionTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1246:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1246:4: rule__ExpressionTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1255:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1256:1: ( ruleIntTypeRule EOF )
            // InternalDefinitionLanguage.g:1257:1: ruleIntTypeRule EOF
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
    // InternalDefinitionLanguage.g:1264:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1268:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1269:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1269:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1270:3: ( rule__IntTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1271:3: ( rule__IntTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1271:4: rule__IntTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1280:1: entryRuleRealTypeRule : ruleRealTypeRule EOF ;
    public final void entryRuleRealTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1281:1: ( ruleRealTypeRule EOF )
            // InternalDefinitionLanguage.g:1282:1: ruleRealTypeRule EOF
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
    // InternalDefinitionLanguage.g:1289:1: ruleRealTypeRule : ( ( rule__RealTypeRule__Group__0 ) ) ;
    public final void ruleRealTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1293:2: ( ( ( rule__RealTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1294:2: ( ( rule__RealTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1294:2: ( ( rule__RealTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1295:3: ( rule__RealTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1296:3: ( rule__RealTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1296:4: rule__RealTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1305:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1306:1: ( ruleBooleanTypeRule EOF )
            // InternalDefinitionLanguage.g:1307:1: ruleBooleanTypeRule EOF
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
    // InternalDefinitionLanguage.g:1314:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1318:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1319:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1319:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1320:3: ( rule__BooleanTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1321:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1321:4: rule__BooleanTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1330:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1331:1: ( ruleVoidTypeRule EOF )
            // InternalDefinitionLanguage.g:1332:1: ruleVoidTypeRule EOF
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
    // InternalDefinitionLanguage.g:1339:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1343:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1344:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1344:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1345:3: ( rule__VoidTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1346:3: ( rule__VoidTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1346:4: rule__VoidTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1355:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1356:1: ( ruleArrayTypeRule EOF )
            // InternalDefinitionLanguage.g:1357:1: ruleArrayTypeRule EOF
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
    // InternalDefinitionLanguage.g:1364:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1368:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1369:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1369:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1370:3: ( rule__ArrayTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1371:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1371:4: rule__ArrayTypeRule__Group__0
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


    // $ANTLR start "entryRuleFunctionDefinitionRule"
    // InternalDefinitionLanguage.g:1380:1: entryRuleFunctionDefinitionRule : ruleFunctionDefinitionRule EOF ;
    public final void entryRuleFunctionDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1381:1: ( ruleFunctionDefinitionRule EOF )
            // InternalDefinitionLanguage.g:1382:1: ruleFunctionDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFunctionDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFunctionDefinitionRule"


    // $ANTLR start "ruleFunctionDefinitionRule"
    // InternalDefinitionLanguage.g:1389:1: ruleFunctionDefinitionRule : ( ( rule__FunctionDefinitionRule__Group__0 ) ) ;
    public final void ruleFunctionDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1393:2: ( ( ( rule__FunctionDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1394:2: ( ( rule__FunctionDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1394:2: ( ( rule__FunctionDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1395:3: ( rule__FunctionDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1396:3: ( rule__FunctionDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:1396:4: rule__FunctionDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunctionDefinitionRule"


    // $ANTLR start "entryRuleConstantDefinitionRule"
    // InternalDefinitionLanguage.g:1405:1: entryRuleConstantDefinitionRule : ruleConstantDefinitionRule EOF ;
    public final void entryRuleConstantDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1406:1: ( ruleConstantDefinitionRule EOF )
            // InternalDefinitionLanguage.g:1407:1: ruleConstantDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConstantDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstantDefinitionRule"


    // $ANTLR start "ruleConstantDefinitionRule"
    // InternalDefinitionLanguage.g:1414:1: ruleConstantDefinitionRule : ( ( rule__ConstantDefinitionRule__Group__0 ) ) ;
    public final void ruleConstantDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1418:2: ( ( ( rule__ConstantDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1419:2: ( ( rule__ConstantDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1419:2: ( ( rule__ConstantDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1420:3: ( rule__ConstantDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1421:3: ( rule__ConstantDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:1421:4: rule__ConstantDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConstantDefinitionRule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstantDefinitionRule"


    // $ANTLR start "entryRuleParameterRule"
    // InternalDefinitionLanguage.g:1430:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1431:1: ( ruleParameterRule EOF )
            // InternalDefinitionLanguage.g:1432:1: ruleParameterRule EOF
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
    // InternalDefinitionLanguage.g:1439:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1443:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1444:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1444:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1445:3: ( rule__ParameterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1446:3: ( rule__ParameterRule__Group__0 )
            // InternalDefinitionLanguage.g:1446:4: rule__ParameterRule__Group__0
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
    // InternalDefinitionLanguage.g:1455:1: entryRuleImportRule : ruleImportRule EOF ;
    public final void entryRuleImportRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1456:1: ( ruleImportRule EOF )
            // InternalDefinitionLanguage.g:1457:1: ruleImportRule EOF
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
    // InternalDefinitionLanguage.g:1464:1: ruleImportRule : ( ( rule__ImportRule__Group__0 ) ) ;
    public final void ruleImportRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1468:2: ( ( ( rule__ImportRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1469:2: ( ( rule__ImportRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1469:2: ( ( rule__ImportRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1470:3: ( rule__ImportRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1471:3: ( rule__ImportRule__Group__0 )
            // InternalDefinitionLanguage.g:1471:4: rule__ImportRule__Group__0
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
    // InternalDefinitionLanguage.g:1480:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1481:1: ( ruleQualifiedName EOF )
            // InternalDefinitionLanguage.g:1482:1: ruleQualifiedName EOF
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
    // InternalDefinitionLanguage.g:1489:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1493:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1494:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1494:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalDefinitionLanguage.g:1495:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1496:3: ( rule__QualifiedName__Group__0 )
            // InternalDefinitionLanguage.g:1496:4: rule__QualifiedName__Group__0
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
    // InternalDefinitionLanguage.g:1505:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1506:1: ( ruleStringOrId EOF )
            // InternalDefinitionLanguage.g:1507:1: ruleStringOrId EOF
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
    // InternalDefinitionLanguage.g:1514:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1518:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1519:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1519:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalDefinitionLanguage.g:1520:3: ( rule__StringOrId__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1521:3: ( rule__StringOrId__Alternatives )
            // InternalDefinitionLanguage.g:1521:4: rule__StringOrId__Alternatives
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
    // InternalDefinitionLanguage.g:1530:1: ruleScaleType : ( ( rule__ScaleType__Alternatives ) ) ;
    public final void ruleScaleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1534:1: ( ( ( rule__ScaleType__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1535:2: ( ( rule__ScaleType__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1535:2: ( ( rule__ScaleType__Alternatives ) )
            // InternalDefinitionLanguage.g:1536:3: ( rule__ScaleType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScaleTypeAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1537:3: ( rule__ScaleType__Alternatives )
            // InternalDefinitionLanguage.g:1537:4: rule__ScaleType__Alternatives
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


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalDefinitionLanguage.g:1546:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1550:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1551:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1551:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1552:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1553:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1553:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalDefinitionLanguage.g:1562:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1566:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1567:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1567:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1568:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1569:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1569:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalDefinitionLanguage.g:1578:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1582:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1583:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1583:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1584:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1585:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1585:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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
    // InternalDefinitionLanguage.g:1594:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1598:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1599:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1599:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1600:3: ( rule__FactorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1601:3: ( rule__FactorRule__Alternatives )
            // InternalDefinitionLanguage.g:1601:4: rule__FactorRule__Alternatives
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


    // $ANTLR start "rule__DefinitionModelRule__Alternatives_4"
    // InternalDefinitionLanguage.g:1609:1: rule__DefinitionModelRule__Alternatives_4 : ( ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) ) | ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) ) | ( ( rule__DefinitionModelRule__ConstantsAssignment_4_3 ) ) );
    public final void rule__DefinitionModelRule__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1613:1: ( ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) ) | ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) ) | ( ( rule__DefinitionModelRule__ConstantsAssignment_4_3 ) ) )
            int alt1=4;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalDefinitionLanguage.g:1614:2: ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) )
                    {
                    // InternalDefinitionLanguage.g:1614:2: ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) )
                    // InternalDefinitionLanguage.g:1615:3: ( rule__DefinitionModelRule__EnumsAssignment_4_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDefinitionModelRuleAccess().getEnumsAssignment_4_0()); 
                    }
                    // InternalDefinitionLanguage.g:1616:3: ( rule__DefinitionModelRule__EnumsAssignment_4_0 )
                    // InternalDefinitionLanguage.g:1616:4: rule__DefinitionModelRule__EnumsAssignment_4_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DefinitionModelRule__EnumsAssignment_4_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDefinitionModelRuleAccess().getEnumsAssignment_4_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1620:2: ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) )
                    {
                    // InternalDefinitionLanguage.g:1620:2: ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) )
                    // InternalDefinitionLanguage.g:1621:3: ( rule__DefinitionModelRule__TypesAssignment_4_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDefinitionModelRuleAccess().getTypesAssignment_4_1()); 
                    }
                    // InternalDefinitionLanguage.g:1622:3: ( rule__DefinitionModelRule__TypesAssignment_4_1 )
                    // InternalDefinitionLanguage.g:1622:4: rule__DefinitionModelRule__TypesAssignment_4_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DefinitionModelRule__TypesAssignment_4_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDefinitionModelRuleAccess().getTypesAssignment_4_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1626:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) )
                    {
                    // InternalDefinitionLanguage.g:1626:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) )
                    // InternalDefinitionLanguage.g:1627:3: ( rule__DefinitionModelRule__FunctionsAssignment_4_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDefinitionModelRuleAccess().getFunctionsAssignment_4_2()); 
                    }
                    // InternalDefinitionLanguage.g:1628:3: ( rule__DefinitionModelRule__FunctionsAssignment_4_2 )
                    // InternalDefinitionLanguage.g:1628:4: rule__DefinitionModelRule__FunctionsAssignment_4_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__DefinitionModelRule__FunctionsAssignment_4_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDefinitionModelRuleAccess().getFunctionsAssignment_4_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:1632:2: ( ( rule__DefinitionModelRule__ConstantsAssignment_4_3 ) )
                    {
                    // InternalDefinitionLanguage.g:1632:2: ( ( rule__DefinitionModelRule__ConstantsAssignment_4_3 ) )
                    // InternalDefinitionLanguage.g:1633:3: ( rule__DefinitionModelRule__ConstantsAssignment_4_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDefinitionModelRuleAccess().getConstantsAssignment_4_3()); 
                    }
                    // InternalDefinitionLanguage.g:1634:3: ( rule__DefinitionModelRule__ConstantsAssignment_4_3 )
                    // InternalDefinitionLanguage.g:1634:4: rule__DefinitionModelRule__ConstantsAssignment_4_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__DefinitionModelRule__ConstantsAssignment_4_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDefinitionModelRuleAccess().getConstantsAssignment_4_3()); 
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
    // $ANTLR end "rule__DefinitionModelRule__Alternatives_4"


    // $ANTLR start "rule__ReadExpressionRule__Alternatives"
    // InternalDefinitionLanguage.g:1642:1: rule__ReadExpressionRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( rulePathExpressionRule ) | ( ruleReferenceRule ) );
    public final void rule__ReadExpressionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1646:1: ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( rulePathExpressionRule ) | ( ruleReferenceRule ) )
            int alt2=6;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalDefinitionLanguage.g:1647:2: ( ruleArrayRule )
                    {
                    // InternalDefinitionLanguage.g:1647:2: ( ruleArrayRule )
                    // InternalDefinitionLanguage.g:1648:3: ruleArrayRule
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
                    // InternalDefinitionLanguage.g:1653:2: ( ruleCallRule )
                    {
                    // InternalDefinitionLanguage.g:1653:2: ( ruleCallRule )
                    // InternalDefinitionLanguage.g:1654:3: ruleCallRule
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
                    // InternalDefinitionLanguage.g:1659:2: ( ruleLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1659:2: ( ruleLiteralRule )
                    // InternalDefinitionLanguage.g:1660:3: ruleLiteralRule
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
                    // InternalDefinitionLanguage.g:1665:2: ( ruleParanthesesRule )
                    {
                    // InternalDefinitionLanguage.g:1665:2: ( ruleParanthesesRule )
                    // InternalDefinitionLanguage.g:1666:3: ruleParanthesesRule
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
                    // InternalDefinitionLanguage.g:1671:2: ( rulePathExpressionRule )
                    {
                    // InternalDefinitionLanguage.g:1671:2: ( rulePathExpressionRule )
                    // InternalDefinitionLanguage.g:1672:3: rulePathExpressionRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReadExpressionRuleAccess().getPathExpressionRuleParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePathExpressionRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReadExpressionRuleAccess().getPathExpressionRuleParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:1677:2: ( ruleReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1677:2: ( ruleReferenceRule )
                    // InternalDefinitionLanguage.g:1678:3: ruleReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReadExpressionRuleAccess().getReferenceRuleParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReadExpressionRuleAccess().getReferenceRuleParserRuleCall_5()); 
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
    // InternalDefinitionLanguage.g:1687:1: rule__ReferenceRule__Alternatives : ( ( ruleValuelDefinitionReferenceRule ) | ( ruleConfigurationReferenceRule ) | ( ruleTypeDefinitionReferenceRule ) | ( ruleAttributeReferenceRule ) );
    public final void rule__ReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1691:1: ( ( ruleValuelDefinitionReferenceRule ) | ( ruleConfigurationReferenceRule ) | ( ruleTypeDefinitionReferenceRule ) | ( ruleAttributeReferenceRule ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt3=1;
                }
                break;
            case 72:
                {
                alt3=2;
                }
                break;
            case 73:
            case 74:
                {
                alt3=3;
                }
                break;
            case 69:
            case 70:
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
                    // InternalDefinitionLanguage.g:1692:2: ( ruleValuelDefinitionReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1692:2: ( ruleValuelDefinitionReferenceRule )
                    // InternalDefinitionLanguage.g:1693:3: ruleValuelDefinitionReferenceRule
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
                    // InternalDefinitionLanguage.g:1698:2: ( ruleConfigurationReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1698:2: ( ruleConfigurationReferenceRule )
                    // InternalDefinitionLanguage.g:1699:3: ruleConfigurationReferenceRule
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
                    // InternalDefinitionLanguage.g:1704:2: ( ruleTypeDefinitionReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1704:2: ( ruleTypeDefinitionReferenceRule )
                    // InternalDefinitionLanguage.g:1705:3: ruleTypeDefinitionReferenceRule
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
                    // InternalDefinitionLanguage.g:1710:2: ( ruleAttributeReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1710:2: ( ruleAttributeReferenceRule )
                    // InternalDefinitionLanguage.g:1711:3: ruleAttributeReferenceRule
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
    // InternalDefinitionLanguage.g:1720:1: rule__SelfReferenceRule__Alternatives : ( ( ( rule__SelfReferenceRule__Group_0__0 ) ) | ( ( rule__SelfReferenceRule__Group_1__0 ) ) );
    public final void rule__SelfReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1724:1: ( ( ( rule__SelfReferenceRule__Group_0__0 ) ) | ( ( rule__SelfReferenceRule__Group_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==69) ) {
                alt4=1;
            }
            else if ( (LA4_0==70) ) {
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
                    // InternalDefinitionLanguage.g:1725:2: ( ( rule__SelfReferenceRule__Group_0__0 ) )
                    {
                    // InternalDefinitionLanguage.g:1725:2: ( ( rule__SelfReferenceRule__Group_0__0 ) )
                    // InternalDefinitionLanguage.g:1726:3: ( rule__SelfReferenceRule__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSelfReferenceRuleAccess().getGroup_0()); 
                    }
                    // InternalDefinitionLanguage.g:1727:3: ( rule__SelfReferenceRule__Group_0__0 )
                    // InternalDefinitionLanguage.g:1727:4: rule__SelfReferenceRule__Group_0__0
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
                    // InternalDefinitionLanguage.g:1731:2: ( ( rule__SelfReferenceRule__Group_1__0 ) )
                    {
                    // InternalDefinitionLanguage.g:1731:2: ( ( rule__SelfReferenceRule__Group_1__0 ) )
                    // InternalDefinitionLanguage.g:1732:3: ( rule__SelfReferenceRule__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSelfReferenceRuleAccess().getGroup_1()); 
                    }
                    // InternalDefinitionLanguage.g:1733:3: ( rule__SelfReferenceRule__Group_1__0 )
                    // InternalDefinitionLanguage.g:1733:4: rule__SelfReferenceRule__Group_1__0
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
    // InternalDefinitionLanguage.g:1741:1: rule__TypeDefinitionReferenceRule__Alternatives : ( ( ruleBaseDataReferenceRule ) | ( ruleStructuredDataDescriptionReferenceRule ) );
    public final void rule__TypeDefinitionReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1745:1: ( ( ruleBaseDataReferenceRule ) | ( ruleStructuredDataDescriptionReferenceRule ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==73) ) {
                alt5=1;
            }
            else if ( (LA5_0==74) ) {
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
                    // InternalDefinitionLanguage.g:1746:2: ( ruleBaseDataReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1746:2: ( ruleBaseDataReferenceRule )
                    // InternalDefinitionLanguage.g:1747:3: ruleBaseDataReferenceRule
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
                    // InternalDefinitionLanguage.g:1752:2: ( ruleStructuredDataDescriptionReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1752:2: ( ruleStructuredDataDescriptionReferenceRule )
                    // InternalDefinitionLanguage.g:1753:3: ruleStructuredDataDescriptionReferenceRule
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
    // InternalDefinitionLanguage.g:1762:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1766:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) )
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
            case 92:
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
                    // InternalDefinitionLanguage.g:1767:2: ( ruleNumberLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1767:2: ( ruleNumberLiteralRule )
                    // InternalDefinitionLanguage.g:1768:3: ruleNumberLiteralRule
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
                    // InternalDefinitionLanguage.g:1773:2: ( ruleStringLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1773:2: ( ruleStringLiteralRule )
                    // InternalDefinitionLanguage.g:1774:3: ruleStringLiteralRule
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
                    // InternalDefinitionLanguage.g:1779:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1779:2: ( ruleBooleanLiteralRule )
                    // InternalDefinitionLanguage.g:1780:3: ruleBooleanLiteralRule
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
                    // InternalDefinitionLanguage.g:1785:2: ( ruleInstanceLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1785:2: ( ruleInstanceLiteralRule )
                    // InternalDefinitionLanguage.g:1786:3: ruleInstanceLiteralRule
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
    // InternalDefinitionLanguage.g:1795:1: rule__NumberLiteralRule__Alternatives : ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1799:1: ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) )
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
                    // InternalDefinitionLanguage.g:1800:2: ( ruleRealLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1800:2: ( ruleRealLiteralRule )
                    // InternalDefinitionLanguage.g:1801:3: ruleRealLiteralRule
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
                    // InternalDefinitionLanguage.g:1806:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1806:2: ( ruleIntegerLiteralRule )
                    // InternalDefinitionLanguage.g:1807:3: ruleIntegerLiteralRule
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
    // InternalDefinitionLanguage.g:1816:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1820:1: ( ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) ) | ( 'false' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==92) ) {
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
                    // InternalDefinitionLanguage.g:1821:2: ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) )
                    {
                    // InternalDefinitionLanguage.g:1821:2: ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) )
                    // InternalDefinitionLanguage.g:1822:3: ( rule__BooleanLiteralRule__LiteralAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralAssignment_1_0()); 
                    }
                    // InternalDefinitionLanguage.g:1823:3: ( rule__BooleanLiteralRule__LiteralAssignment_1_0 )
                    // InternalDefinitionLanguage.g:1823:4: rule__BooleanLiteralRule__LiteralAssignment_1_0
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
                    // InternalDefinitionLanguage.g:1827:2: ( 'false' )
                    {
                    // InternalDefinitionLanguage.g:1827:2: ( 'false' )
                    // InternalDefinitionLanguage.g:1828:3: 'false'
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
    // InternalDefinitionLanguage.g:1837:1: rule__TypeRule__Alternatives : ( ( ruleArrayTypeRule ) | ( ruleBaseTypeRule ) | ( ruleTypeReferenceRule ) | ( ruleEnumReferenceRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) | ( rulePathTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1841:1: ( ( ruleArrayTypeRule ) | ( ruleBaseTypeRule ) | ( ruleTypeReferenceRule ) | ( ruleEnumReferenceRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) | ( rulePathTypeRule ) )
            int alt9=8;
            switch ( input.LA(1) ) {
            case 86:
                {
                alt9=1;
                }
                break;
            case 80:
            case 82:
            case 83:
            case 84:
            case 85:
                {
                alt9=2;
                }
                break;
            case 74:
                {
                alt9=3;
                }
                break;
            case 54:
                {
                alt9=4;
                }
                break;
            case 81:
                {
                alt9=5;
                }
                break;
            case 79:
                {
                alt9=6;
                }
                break;
            case 73:
                {
                alt9=7;
                }
                break;
            case 68:
                {
                alt9=8;
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
                    // InternalDefinitionLanguage.g:1842:2: ( ruleArrayTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1842:2: ( ruleArrayTypeRule )
                    // InternalDefinitionLanguage.g:1843:3: ruleArrayTypeRule
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
                    // InternalDefinitionLanguage.g:1848:2: ( ruleBaseTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1848:2: ( ruleBaseTypeRule )
                    // InternalDefinitionLanguage.g:1849:3: ruleBaseTypeRule
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
                    // InternalDefinitionLanguage.g:1854:2: ( ruleTypeReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1854:2: ( ruleTypeReferenceRule )
                    // InternalDefinitionLanguage.g:1855:3: ruleTypeReferenceRule
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
                    // InternalDefinitionLanguage.g:1860:2: ( ruleEnumReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1860:2: ( ruleEnumReferenceRule )
                    // InternalDefinitionLanguage.g:1861:3: ruleEnumReferenceRule
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
                    // InternalDefinitionLanguage.g:1866:2: ( ruleExpressionTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1866:2: ( ruleExpressionTypeRule )
                    // InternalDefinitionLanguage.g:1867:3: ruleExpressionTypeRule
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
                    // InternalDefinitionLanguage.g:1872:2: ( ruleLiteralTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1872:2: ( ruleLiteralTypeRule )
                    // InternalDefinitionLanguage.g:1873:3: ruleLiteralTypeRule
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
                    // InternalDefinitionLanguage.g:1878:2: ( ruleDataTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1878:2: ( ruleDataTypeRule )
                    // InternalDefinitionLanguage.g:1879:3: ruleDataTypeRule
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
                case 8 :
                    // InternalDefinitionLanguage.g:1884:2: ( rulePathTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1884:2: ( rulePathTypeRule )
                    // InternalDefinitionLanguage.g:1885:3: rulePathTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRuleAccess().getPathTypeRuleParserRuleCall_7()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePathTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRuleAccess().getPathTypeRuleParserRuleCall_7()); 
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
    // InternalDefinitionLanguage.g:1894:1: rule__BaseTypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleVoidTypeRule ) );
    public final void rule__BaseTypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1898:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleVoidTypeRule ) )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt10=1;
                }
                break;
            case 82:
                {
                alt10=2;
                }
                break;
            case 83:
                {
                alt10=3;
                }
                break;
            case 84:
                {
                alt10=4;
                }
                break;
            case 85:
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
                    // InternalDefinitionLanguage.g:1899:2: ( ruleStringTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1899:2: ( ruleStringTypeRule )
                    // InternalDefinitionLanguage.g:1900:3: ruleStringTypeRule
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
                    // InternalDefinitionLanguage.g:1905:2: ( ruleIntTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1905:2: ( ruleIntTypeRule )
                    // InternalDefinitionLanguage.g:1906:3: ruleIntTypeRule
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
                    // InternalDefinitionLanguage.g:1911:2: ( ruleRealTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1911:2: ( ruleRealTypeRule )
                    // InternalDefinitionLanguage.g:1912:3: ruleRealTypeRule
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
                    // InternalDefinitionLanguage.g:1917:2: ( ruleBooleanTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1917:2: ( ruleBooleanTypeRule )
                    // InternalDefinitionLanguage.g:1918:3: ruleBooleanTypeRule
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
                    // InternalDefinitionLanguage.g:1923:2: ( ruleVoidTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1923:2: ( ruleVoidTypeRule )
                    // InternalDefinitionLanguage.g:1924:3: ruleVoidTypeRule
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
    // InternalDefinitionLanguage.g:1933:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1937:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
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
                    // InternalDefinitionLanguage.g:1938:2: ( RULE_QUOTED_ID )
                    {
                    // InternalDefinitionLanguage.g:1938:2: ( RULE_QUOTED_ID )
                    // InternalDefinitionLanguage.g:1939:3: RULE_QUOTED_ID
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
                    // InternalDefinitionLanguage.g:1944:2: ( RULE_ID )
                    {
                    // InternalDefinitionLanguage.g:1944:2: ( RULE_ID )
                    // InternalDefinitionLanguage.g:1945:3: RULE_ID
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
    // InternalDefinitionLanguage.g:1954:1: rule__ScaleType__Alternatives : ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) );
    public final void rule__ScaleType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1958:1: ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) )
            int alt12=4;
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
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalDefinitionLanguage.g:1959:2: ( ( 'nominal' ) )
                    {
                    // InternalDefinitionLanguage.g:1959:2: ( ( 'nominal' ) )
                    // InternalDefinitionLanguage.g:1960:3: ( 'nominal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0()); 
                    }
                    // InternalDefinitionLanguage.g:1961:3: ( 'nominal' )
                    // InternalDefinitionLanguage.g:1961:4: 'nominal'
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
                    // InternalDefinitionLanguage.g:1965:2: ( ( 'ordinal' ) )
                    {
                    // InternalDefinitionLanguage.g:1965:2: ( ( 'ordinal' ) )
                    // InternalDefinitionLanguage.g:1966:3: ( 'ordinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1()); 
                    }
                    // InternalDefinitionLanguage.g:1967:3: ( 'ordinal' )
                    // InternalDefinitionLanguage.g:1967:4: 'ordinal'
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
                    // InternalDefinitionLanguage.g:1971:2: ( ( 'cardinal' ) )
                    {
                    // InternalDefinitionLanguage.g:1971:2: ( ( 'cardinal' ) )
                    // InternalDefinitionLanguage.g:1972:3: ( 'cardinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2()); 
                    }
                    // InternalDefinitionLanguage.g:1973:3: ( 'cardinal' )
                    // InternalDefinitionLanguage.g:1973:4: 'cardinal'
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
                    // InternalDefinitionLanguage.g:1977:2: ( ( 'quotient' ) )
                    {
                    // InternalDefinitionLanguage.g:1977:2: ( ( 'quotient' ) )
                    // InternalDefinitionLanguage.g:1978:3: ( 'quotient' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getQuotientEnumLiteralDeclaration_3()); 
                    }
                    // InternalDefinitionLanguage.g:1979:3: ( 'quotient' )
                    // InternalDefinitionLanguage.g:1979:4: 'quotient'
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


    // $ANTLR start "rule__ComparisonOperatorRule__Alternatives"
    // InternalDefinitionLanguage.g:1987:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<=' ) ) | ( ( '<' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1991:1: ( ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<=' ) ) | ( ( '<' ) ) )
            int alt13=6;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt13=1;
                }
                break;
            case 21:
                {
                alt13=2;
                }
                break;
            case 22:
                {
                alt13=3;
                }
                break;
            case 23:
                {
                alt13=4;
                }
                break;
            case 24:
                {
                alt13=5;
                }
                break;
            case 25:
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
                    // InternalDefinitionLanguage.g:1992:2: ( ( '>' ) )
                    {
                    // InternalDefinitionLanguage.g:1992:2: ( ( '>' ) )
                    // InternalDefinitionLanguage.g:1993:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalDefinitionLanguage.g:1994:3: ( '>' )
                    // InternalDefinitionLanguage.g:1994:4: '>'
                    {
                    match(input,20,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1998:2: ( ( '>=' ) )
                    {
                    // InternalDefinitionLanguage.g:1998:2: ( ( '>=' ) )
                    // InternalDefinitionLanguage.g:1999:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalDefinitionLanguage.g:2000:3: ( '>=' )
                    // InternalDefinitionLanguage.g:2000:4: '>='
                    {
                    match(input,21,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:2004:2: ( ( '=' ) )
                    {
                    // InternalDefinitionLanguage.g:2004:2: ( ( '=' ) )
                    // InternalDefinitionLanguage.g:2005:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalDefinitionLanguage.g:2006:3: ( '=' )
                    // InternalDefinitionLanguage.g:2006:4: '='
                    {
                    match(input,22,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:2010:2: ( ( '!=' ) )
                    {
                    // InternalDefinitionLanguage.g:2010:2: ( ( '!=' ) )
                    // InternalDefinitionLanguage.g:2011:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalDefinitionLanguage.g:2012:3: ( '!=' )
                    // InternalDefinitionLanguage.g:2012:4: '!='
                    {
                    match(input,23,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:2016:2: ( ( '<=' ) )
                    {
                    // InternalDefinitionLanguage.g:2016:2: ( ( '<=' ) )
                    // InternalDefinitionLanguage.g:2017:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalDefinitionLanguage.g:2018:3: ( '<=' )
                    // InternalDefinitionLanguage.g:2018:4: '<='
                    {
                    match(input,24,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:2022:2: ( ( '<' ) )
                    {
                    // InternalDefinitionLanguage.g:2022:2: ( ( '<' ) )
                    // InternalDefinitionLanguage.g:2023:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalDefinitionLanguage.g:2024:3: ( '<' )
                    // InternalDefinitionLanguage.g:2024:4: '<'
                    {
                    match(input,25,FOLLOW_2); if (state.failed) return ;

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
    // InternalDefinitionLanguage.g:2032:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2036:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            else if ( (LA14_0==27) ) {
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
                    // InternalDefinitionLanguage.g:2037:2: ( ( '+' ) )
                    {
                    // InternalDefinitionLanguage.g:2037:2: ( ( '+' ) )
                    // InternalDefinitionLanguage.g:2038:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalDefinitionLanguage.g:2039:3: ( '+' )
                    // InternalDefinitionLanguage.g:2039:4: '+'
                    {
                    match(input,26,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:2043:2: ( ( '-' ) )
                    {
                    // InternalDefinitionLanguage.g:2043:2: ( ( '-' ) )
                    // InternalDefinitionLanguage.g:2044:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalDefinitionLanguage.g:2045:3: ( '-' )
                    // InternalDefinitionLanguage.g:2045:4: '-'
                    {
                    match(input,27,FOLLOW_2); if (state.failed) return ;

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
    // InternalDefinitionLanguage.g:2053:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2057:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt15=1;
                }
                break;
            case 29:
                {
                alt15=2;
                }
                break;
            case 30:
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
                    // InternalDefinitionLanguage.g:2058:2: ( ( '*' ) )
                    {
                    // InternalDefinitionLanguage.g:2058:2: ( ( '*' ) )
                    // InternalDefinitionLanguage.g:2059:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalDefinitionLanguage.g:2060:3: ( '*' )
                    // InternalDefinitionLanguage.g:2060:4: '*'
                    {
                    match(input,28,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:2064:2: ( ( '/' ) )
                    {
                    // InternalDefinitionLanguage.g:2064:2: ( ( '/' ) )
                    // InternalDefinitionLanguage.g:2065:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalDefinitionLanguage.g:2066:3: ( '/' )
                    // InternalDefinitionLanguage.g:2066:4: '/'
                    {
                    match(input,29,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:2070:2: ( ( '%' ) )
                    {
                    // InternalDefinitionLanguage.g:2070:2: ( ( '%' ) )
                    // InternalDefinitionLanguage.g:2071:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalDefinitionLanguage.g:2072:3: ( '%' )
                    // InternalDefinitionLanguage.g:2072:4: '%'
                    {
                    match(input,30,FOLLOW_2); if (state.failed) return ;

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
    // InternalDefinitionLanguage.g:2080:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2084:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt16=20;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt16=1;
                }
                break;
            case 32:
                {
                alt16=2;
                }
                break;
            case 33:
                {
                alt16=3;
                }
                break;
            case 34:
                {
                alt16=4;
                }
                break;
            case 35:
                {
                alt16=5;
                }
                break;
            case 36:
                {
                alt16=6;
                }
                break;
            case 37:
                {
                alt16=7;
                }
                break;
            case 38:
                {
                alt16=8;
                }
                break;
            case 39:
                {
                alt16=9;
                }
                break;
            case 40:
                {
                alt16=10;
                }
                break;
            case 41:
                {
                alt16=11;
                }
                break;
            case 42:
                {
                alt16=12;
                }
                break;
            case 43:
                {
                alt16=13;
                }
                break;
            case 44:
                {
                alt16=14;
                }
                break;
            case 45:
                {
                alt16=15;
                }
                break;
            case 46:
                {
                alt16=16;
                }
                break;
            case 47:
                {
                alt16=17;
                }
                break;
            case 48:
                {
                alt16=18;
                }
                break;
            case 49:
                {
                alt16=19;
                }
                break;
            case 50:
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
                    // InternalDefinitionLanguage.g:2085:2: ( ( 'Y' ) )
                    {
                    // InternalDefinitionLanguage.g:2085:2: ( ( 'Y' ) )
                    // InternalDefinitionLanguage.g:2086:3: ( 'Y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }
                    // InternalDefinitionLanguage.g:2087:3: ( 'Y' )
                    // InternalDefinitionLanguage.g:2087:4: 'Y'
                    {
                    match(input,31,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:2091:2: ( ( 'Z' ) )
                    {
                    // InternalDefinitionLanguage.g:2091:2: ( ( 'Z' ) )
                    // InternalDefinitionLanguage.g:2092:3: ( 'Z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }
                    // InternalDefinitionLanguage.g:2093:3: ( 'Z' )
                    // InternalDefinitionLanguage.g:2093:4: 'Z'
                    {
                    match(input,32,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:2097:2: ( ( 'E' ) )
                    {
                    // InternalDefinitionLanguage.g:2097:2: ( ( 'E' ) )
                    // InternalDefinitionLanguage.g:2098:3: ( 'E' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }
                    // InternalDefinitionLanguage.g:2099:3: ( 'E' )
                    // InternalDefinitionLanguage.g:2099:4: 'E'
                    {
                    match(input,33,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:2103:2: ( ( 'P' ) )
                    {
                    // InternalDefinitionLanguage.g:2103:2: ( ( 'P' ) )
                    // InternalDefinitionLanguage.g:2104:3: ( 'P' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }
                    // InternalDefinitionLanguage.g:2105:3: ( 'P' )
                    // InternalDefinitionLanguage.g:2105:4: 'P'
                    {
                    match(input,34,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:2109:2: ( ( 'T' ) )
                    {
                    // InternalDefinitionLanguage.g:2109:2: ( ( 'T' ) )
                    // InternalDefinitionLanguage.g:2110:3: ( 'T' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }
                    // InternalDefinitionLanguage.g:2111:3: ( 'T' )
                    // InternalDefinitionLanguage.g:2111:4: 'T'
                    {
                    match(input,35,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:2115:2: ( ( 'G' ) )
                    {
                    // InternalDefinitionLanguage.g:2115:2: ( ( 'G' ) )
                    // InternalDefinitionLanguage.g:2116:3: ( 'G' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }
                    // InternalDefinitionLanguage.g:2117:3: ( 'G' )
                    // InternalDefinitionLanguage.g:2117:4: 'G'
                    {
                    match(input,36,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalDefinitionLanguage.g:2121:2: ( ( 'M' ) )
                    {
                    // InternalDefinitionLanguage.g:2121:2: ( ( 'M' ) )
                    // InternalDefinitionLanguage.g:2122:3: ( 'M' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }
                    // InternalDefinitionLanguage.g:2123:3: ( 'M' )
                    // InternalDefinitionLanguage.g:2123:4: 'M'
                    {
                    match(input,37,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalDefinitionLanguage.g:2127:2: ( ( 'k' ) )
                    {
                    // InternalDefinitionLanguage.g:2127:2: ( ( 'k' ) )
                    // InternalDefinitionLanguage.g:2128:3: ( 'k' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }
                    // InternalDefinitionLanguage.g:2129:3: ( 'k' )
                    // InternalDefinitionLanguage.g:2129:4: 'k'
                    {
                    match(input,38,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalDefinitionLanguage.g:2133:2: ( ( 'h' ) )
                    {
                    // InternalDefinitionLanguage.g:2133:2: ( ( 'h' ) )
                    // InternalDefinitionLanguage.g:2134:3: ( 'h' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }
                    // InternalDefinitionLanguage.g:2135:3: ( 'h' )
                    // InternalDefinitionLanguage.g:2135:4: 'h'
                    {
                    match(input,39,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalDefinitionLanguage.g:2139:2: ( ( 'da' ) )
                    {
                    // InternalDefinitionLanguage.g:2139:2: ( ( 'da' ) )
                    // InternalDefinitionLanguage.g:2140:3: ( 'da' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }
                    // InternalDefinitionLanguage.g:2141:3: ( 'da' )
                    // InternalDefinitionLanguage.g:2141:4: 'da'
                    {
                    match(input,40,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalDefinitionLanguage.g:2145:2: ( ( 'd' ) )
                    {
                    // InternalDefinitionLanguage.g:2145:2: ( ( 'd' ) )
                    // InternalDefinitionLanguage.g:2146:3: ( 'd' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }
                    // InternalDefinitionLanguage.g:2147:3: ( 'd' )
                    // InternalDefinitionLanguage.g:2147:4: 'd'
                    {
                    match(input,41,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalDefinitionLanguage.g:2151:2: ( ( 'c' ) )
                    {
                    // InternalDefinitionLanguage.g:2151:2: ( ( 'c' ) )
                    // InternalDefinitionLanguage.g:2152:3: ( 'c' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }
                    // InternalDefinitionLanguage.g:2153:3: ( 'c' )
                    // InternalDefinitionLanguage.g:2153:4: 'c'
                    {
                    match(input,42,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalDefinitionLanguage.g:2157:2: ( ( 'm' ) )
                    {
                    // InternalDefinitionLanguage.g:2157:2: ( ( 'm' ) )
                    // InternalDefinitionLanguage.g:2158:3: ( 'm' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }
                    // InternalDefinitionLanguage.g:2159:3: ( 'm' )
                    // InternalDefinitionLanguage.g:2159:4: 'm'
                    {
                    match(input,43,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalDefinitionLanguage.g:2163:2: ( ( '\\u00B5' ) )
                    {
                    // InternalDefinitionLanguage.g:2163:2: ( ( '\\u00B5' ) )
                    // InternalDefinitionLanguage.g:2164:3: ( '\\u00B5' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }
                    // InternalDefinitionLanguage.g:2165:3: ( '\\u00B5' )
                    // InternalDefinitionLanguage.g:2165:4: '\\u00B5'
                    {
                    match(input,44,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalDefinitionLanguage.g:2169:2: ( ( 'n' ) )
                    {
                    // InternalDefinitionLanguage.g:2169:2: ( ( 'n' ) )
                    // InternalDefinitionLanguage.g:2170:3: ( 'n' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }
                    // InternalDefinitionLanguage.g:2171:3: ( 'n' )
                    // InternalDefinitionLanguage.g:2171:4: 'n'
                    {
                    match(input,45,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalDefinitionLanguage.g:2175:2: ( ( 'p' ) )
                    {
                    // InternalDefinitionLanguage.g:2175:2: ( ( 'p' ) )
                    // InternalDefinitionLanguage.g:2176:3: ( 'p' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }
                    // InternalDefinitionLanguage.g:2177:3: ( 'p' )
                    // InternalDefinitionLanguage.g:2177:4: 'p'
                    {
                    match(input,46,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalDefinitionLanguage.g:2181:2: ( ( 'f' ) )
                    {
                    // InternalDefinitionLanguage.g:2181:2: ( ( 'f' ) )
                    // InternalDefinitionLanguage.g:2182:3: ( 'f' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }
                    // InternalDefinitionLanguage.g:2183:3: ( 'f' )
                    // InternalDefinitionLanguage.g:2183:4: 'f'
                    {
                    match(input,47,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalDefinitionLanguage.g:2187:2: ( ( 'a' ) )
                    {
                    // InternalDefinitionLanguage.g:2187:2: ( ( 'a' ) )
                    // InternalDefinitionLanguage.g:2188:3: ( 'a' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }
                    // InternalDefinitionLanguage.g:2189:3: ( 'a' )
                    // InternalDefinitionLanguage.g:2189:4: 'a'
                    {
                    match(input,48,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalDefinitionLanguage.g:2193:2: ( ( 'z' ) )
                    {
                    // InternalDefinitionLanguage.g:2193:2: ( ( 'z' ) )
                    // InternalDefinitionLanguage.g:2194:3: ( 'z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }
                    // InternalDefinitionLanguage.g:2195:3: ( 'z' )
                    // InternalDefinitionLanguage.g:2195:4: 'z'
                    {
                    match(input,49,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalDefinitionLanguage.g:2199:2: ( ( 'y' ) )
                    {
                    // InternalDefinitionLanguage.g:2199:2: ( ( 'y' ) )
                    // InternalDefinitionLanguage.g:2200:3: ( 'y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }
                    // InternalDefinitionLanguage.g:2201:3: ( 'y' )
                    // InternalDefinitionLanguage.g:2201:4: 'y'
                    {
                    match(input,50,FOLLOW_2); if (state.failed) return ;

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


    // $ANTLR start "rule__DefinitionModelRule__Group__0"
    // InternalDefinitionLanguage.g:2209:1: rule__DefinitionModelRule__Group__0 : rule__DefinitionModelRule__Group__0__Impl rule__DefinitionModelRule__Group__1 ;
    public final void rule__DefinitionModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2213:1: ( rule__DefinitionModelRule__Group__0__Impl rule__DefinitionModelRule__Group__1 )
            // InternalDefinitionLanguage.g:2214:2: rule__DefinitionModelRule__Group__0__Impl rule__DefinitionModelRule__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__DefinitionModelRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__0"


    // $ANTLR start "rule__DefinitionModelRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2221:1: rule__DefinitionModelRule__Group__0__Impl : ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* ) ;
    public final void rule__DefinitionModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2225:1: ( ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:2226:1: ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:2226:1: ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* )
            // InternalDefinitionLanguage.g:2227:2: ( rule__DefinitionModelRule__ImportsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getImportsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:2228:2: ( rule__DefinitionModelRule__ImportsAssignment_0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==89) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2228:3: rule__DefinitionModelRule__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__DefinitionModelRule__ImportsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getImportsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__0__Impl"


    // $ANTLR start "rule__DefinitionModelRule__Group__1"
    // InternalDefinitionLanguage.g:2236:1: rule__DefinitionModelRule__Group__1 : rule__DefinitionModelRule__Group__1__Impl rule__DefinitionModelRule__Group__2 ;
    public final void rule__DefinitionModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2240:1: ( rule__DefinitionModelRule__Group__1__Impl rule__DefinitionModelRule__Group__2 )
            // InternalDefinitionLanguage.g:2241:2: rule__DefinitionModelRule__Group__1__Impl rule__DefinitionModelRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__DefinitionModelRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__1"


    // $ANTLR start "rule__DefinitionModelRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2248:1: rule__DefinitionModelRule__Group__1__Impl : ( 'module' ) ;
    public final void rule__DefinitionModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2252:1: ( ( 'module' ) )
            // InternalDefinitionLanguage.g:2253:1: ( 'module' )
            {
            // InternalDefinitionLanguage.g:2253:1: ( 'module' )
            // InternalDefinitionLanguage.g:2254:2: 'module'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getModuleKeyword_1()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getModuleKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__1__Impl"


    // $ANTLR start "rule__DefinitionModelRule__Group__2"
    // InternalDefinitionLanguage.g:2263:1: rule__DefinitionModelRule__Group__2 : rule__DefinitionModelRule__Group__2__Impl rule__DefinitionModelRule__Group__3 ;
    public final void rule__DefinitionModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2267:1: ( rule__DefinitionModelRule__Group__2__Impl rule__DefinitionModelRule__Group__3 )
            // InternalDefinitionLanguage.g:2268:2: rule__DefinitionModelRule__Group__2__Impl rule__DefinitionModelRule__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__DefinitionModelRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__2"


    // $ANTLR start "rule__DefinitionModelRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:2275:1: rule__DefinitionModelRule__Group__2__Impl : ( ( rule__DefinitionModelRule__NameAssignment_2 ) ) ;
    public final void rule__DefinitionModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2279:1: ( ( ( rule__DefinitionModelRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:2280:1: ( ( rule__DefinitionModelRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:2280:1: ( ( rule__DefinitionModelRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:2281:2: ( rule__DefinitionModelRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getNameAssignment_2()); 
            }
            // InternalDefinitionLanguage.g:2282:2: ( rule__DefinitionModelRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:2282:3: rule__DefinitionModelRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__2__Impl"


    // $ANTLR start "rule__DefinitionModelRule__Group__3"
    // InternalDefinitionLanguage.g:2290:1: rule__DefinitionModelRule__Group__3 : rule__DefinitionModelRule__Group__3__Impl rule__DefinitionModelRule__Group__4 ;
    public final void rule__DefinitionModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2294:1: ( rule__DefinitionModelRule__Group__3__Impl rule__DefinitionModelRule__Group__4 )
            // InternalDefinitionLanguage.g:2295:2: rule__DefinitionModelRule__Group__3__Impl rule__DefinitionModelRule__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__DefinitionModelRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__3"


    // $ANTLR start "rule__DefinitionModelRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:2302:1: rule__DefinitionModelRule__Group__3__Impl : ( '{' ) ;
    public final void rule__DefinitionModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2306:1: ( ( '{' ) )
            // InternalDefinitionLanguage.g:2307:1: ( '{' )
            {
            // InternalDefinitionLanguage.g:2307:1: ( '{' )
            // InternalDefinitionLanguage.g:2308:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getLeftCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__3__Impl"


    // $ANTLR start "rule__DefinitionModelRule__Group__4"
    // InternalDefinitionLanguage.g:2317:1: rule__DefinitionModelRule__Group__4 : rule__DefinitionModelRule__Group__4__Impl rule__DefinitionModelRule__Group__5 ;
    public final void rule__DefinitionModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2321:1: ( rule__DefinitionModelRule__Group__4__Impl rule__DefinitionModelRule__Group__5 )
            // InternalDefinitionLanguage.g:2322:2: rule__DefinitionModelRule__Group__4__Impl rule__DefinitionModelRule__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__DefinitionModelRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__4"


    // $ANTLR start "rule__DefinitionModelRule__Group__4__Impl"
    // InternalDefinitionLanguage.g:2329:1: rule__DefinitionModelRule__Group__4__Impl : ( ( rule__DefinitionModelRule__Alternatives_4 )* ) ;
    public final void rule__DefinitionModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2333:1: ( ( ( rule__DefinitionModelRule__Alternatives_4 )* ) )
            // InternalDefinitionLanguage.g:2334:1: ( ( rule__DefinitionModelRule__Alternatives_4 )* )
            {
            // InternalDefinitionLanguage.g:2334:1: ( ( rule__DefinitionModelRule__Alternatives_4 )* )
            // InternalDefinitionLanguage.g:2335:2: ( rule__DefinitionModelRule__Alternatives_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getAlternatives_4()); 
            }
            // InternalDefinitionLanguage.g:2336:2: ( rule__DefinitionModelRule__Alternatives_4 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=16 && LA18_0<=19)||LA18_0==76||LA18_0==78||(LA18_0>=87 && LA18_0<=88)||LA18_0==93) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2336:3: rule__DefinitionModelRule__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__DefinitionModelRule__Alternatives_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getAlternatives_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__4__Impl"


    // $ANTLR start "rule__DefinitionModelRule__Group__5"
    // InternalDefinitionLanguage.g:2344:1: rule__DefinitionModelRule__Group__5 : rule__DefinitionModelRule__Group__5__Impl ;
    public final void rule__DefinitionModelRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2348:1: ( rule__DefinitionModelRule__Group__5__Impl )
            // InternalDefinitionLanguage.g:2349:2: rule__DefinitionModelRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DefinitionModelRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__5"


    // $ANTLR start "rule__DefinitionModelRule__Group__5__Impl"
    // InternalDefinitionLanguage.g:2355:1: rule__DefinitionModelRule__Group__5__Impl : ( '}' ) ;
    public final void rule__DefinitionModelRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2359:1: ( ( '}' ) )
            // InternalDefinitionLanguage.g:2360:1: ( '}' )
            {
            // InternalDefinitionLanguage.g:2360:1: ( '}' )
            // InternalDefinitionLanguage.g:2361:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getRightCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__Group__5__Impl"


    // $ANTLR start "rule__EnumTypeDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:2371:1: rule__EnumTypeDefinitionRule__Group__0 : rule__EnumTypeDefinitionRule__Group__0__Impl rule__EnumTypeDefinitionRule__Group__1 ;
    public final void rule__EnumTypeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2375:1: ( rule__EnumTypeDefinitionRule__Group__0__Impl rule__EnumTypeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:2376:2: rule__EnumTypeDefinitionRule__Group__0__Impl rule__EnumTypeDefinitionRule__Group__1
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
    // InternalDefinitionLanguage.g:2383:1: rule__EnumTypeDefinitionRule__Group__0__Impl : ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__EnumTypeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2387:1: ( ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:2388:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:2388:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalDefinitionLanguage.g:2389:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:2390:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==78) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2390:3: rule__EnumTypeDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__EnumTypeDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalDefinitionLanguage.g:2398:1: rule__EnumTypeDefinitionRule__Group__1 : rule__EnumTypeDefinitionRule__Group__1__Impl rule__EnumTypeDefinitionRule__Group__2 ;
    public final void rule__EnumTypeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2402:1: ( rule__EnumTypeDefinitionRule__Group__1__Impl rule__EnumTypeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:2403:2: rule__EnumTypeDefinitionRule__Group__1__Impl rule__EnumTypeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_11);
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
    // InternalDefinitionLanguage.g:2410:1: rule__EnumTypeDefinitionRule__Group__1__Impl : ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2414:1: ( ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2415:1: ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2415:1: ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) )
            // InternalDefinitionLanguage.g:2416:2: ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getScaleAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:2417:2: ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 )
            // InternalDefinitionLanguage.g:2417:3: rule__EnumTypeDefinitionRule__ScaleAssignment_1
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
    // InternalDefinitionLanguage.g:2425:1: rule__EnumTypeDefinitionRule__Group__2 : rule__EnumTypeDefinitionRule__Group__2__Impl rule__EnumTypeDefinitionRule__Group__3 ;
    public final void rule__EnumTypeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2429:1: ( rule__EnumTypeDefinitionRule__Group__2__Impl rule__EnumTypeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:2430:2: rule__EnumTypeDefinitionRule__Group__2__Impl rule__EnumTypeDefinitionRule__Group__3
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
    // InternalDefinitionLanguage.g:2437:1: rule__EnumTypeDefinitionRule__Group__2__Impl : ( 'enum' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2441:1: ( ( 'enum' ) )
            // InternalDefinitionLanguage.g:2442:1: ( 'enum' )
            {
            // InternalDefinitionLanguage.g:2442:1: ( 'enum' )
            // InternalDefinitionLanguage.g:2443:2: 'enum'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getEnumKeyword_2()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:2452:1: rule__EnumTypeDefinitionRule__Group__3 : rule__EnumTypeDefinitionRule__Group__3__Impl rule__EnumTypeDefinitionRule__Group__4 ;
    public final void rule__EnumTypeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2456:1: ( rule__EnumTypeDefinitionRule__Group__3__Impl rule__EnumTypeDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:2457:2: rule__EnumTypeDefinitionRule__Group__3__Impl rule__EnumTypeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalDefinitionLanguage.g:2464:1: rule__EnumTypeDefinitionRule__Group__3__Impl : ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2468:1: ( ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) ) )
            // InternalDefinitionLanguage.g:2469:1: ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) )
            {
            // InternalDefinitionLanguage.g:2469:1: ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) )
            // InternalDefinitionLanguage.g:2470:2: ( rule__EnumTypeDefinitionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDefinitionLanguage.g:2471:2: ( rule__EnumTypeDefinitionRule__NameAssignment_3 )
            // InternalDefinitionLanguage.g:2471:3: rule__EnumTypeDefinitionRule__NameAssignment_3
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
    // InternalDefinitionLanguage.g:2479:1: rule__EnumTypeDefinitionRule__Group__4 : rule__EnumTypeDefinitionRule__Group__4__Impl rule__EnumTypeDefinitionRule__Group__5 ;
    public final void rule__EnumTypeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2483:1: ( rule__EnumTypeDefinitionRule__Group__4__Impl rule__EnumTypeDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:2484:2: rule__EnumTypeDefinitionRule__Group__4__Impl rule__EnumTypeDefinitionRule__Group__5
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
    // InternalDefinitionLanguage.g:2491:1: rule__EnumTypeDefinitionRule__Group__4__Impl : ( '(' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2495:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:2496:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:2496:1: ( '(' )
            // InternalDefinitionLanguage.g:2497:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getLeftParenthesisKeyword_4()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:2506:1: rule__EnumTypeDefinitionRule__Group__5 : rule__EnumTypeDefinitionRule__Group__5__Impl rule__EnumTypeDefinitionRule__Group__6 ;
    public final void rule__EnumTypeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2510:1: ( rule__EnumTypeDefinitionRule__Group__5__Impl rule__EnumTypeDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:2511:2: rule__EnumTypeDefinitionRule__Group__5__Impl rule__EnumTypeDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_13);
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
    // InternalDefinitionLanguage.g:2518:1: rule__EnumTypeDefinitionRule__Group__5__Impl : ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2522:1: ( ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) ) )
            // InternalDefinitionLanguage.g:2523:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) )
            {
            // InternalDefinitionLanguage.g:2523:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) )
            // InternalDefinitionLanguage.g:2524:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsAssignment_5()); 
            }
            // InternalDefinitionLanguage.g:2525:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 )
            // InternalDefinitionLanguage.g:2525:3: rule__EnumTypeDefinitionRule__LiteralsAssignment_5
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
    // InternalDefinitionLanguage.g:2533:1: rule__EnumTypeDefinitionRule__Group__6 : rule__EnumTypeDefinitionRule__Group__6__Impl rule__EnumTypeDefinitionRule__Group__7 ;
    public final void rule__EnumTypeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2537:1: ( rule__EnumTypeDefinitionRule__Group__6__Impl rule__EnumTypeDefinitionRule__Group__7 )
            // InternalDefinitionLanguage.g:2538:2: rule__EnumTypeDefinitionRule__Group__6__Impl rule__EnumTypeDefinitionRule__Group__7
            {
            pushFollow(FOLLOW_13);
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
    // InternalDefinitionLanguage.g:2545:1: rule__EnumTypeDefinitionRule__Group__6__Impl : ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* ) ;
    public final void rule__EnumTypeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2549:1: ( ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* ) )
            // InternalDefinitionLanguage.g:2550:1: ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* )
            {
            // InternalDefinitionLanguage.g:2550:1: ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* )
            // InternalDefinitionLanguage.g:2551:2: ( rule__EnumTypeDefinitionRule__Group_6__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup_6()); 
            }
            // InternalDefinitionLanguage.g:2552:2: ( rule__EnumTypeDefinitionRule__Group_6__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==58) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2552:3: rule__EnumTypeDefinitionRule__Group_6__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__EnumTypeDefinitionRule__Group_6__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalDefinitionLanguage.g:2560:1: rule__EnumTypeDefinitionRule__Group__7 : rule__EnumTypeDefinitionRule__Group__7__Impl rule__EnumTypeDefinitionRule__Group__8 ;
    public final void rule__EnumTypeDefinitionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2564:1: ( rule__EnumTypeDefinitionRule__Group__7__Impl rule__EnumTypeDefinitionRule__Group__8 )
            // InternalDefinitionLanguage.g:2565:2: rule__EnumTypeDefinitionRule__Group__7__Impl rule__EnumTypeDefinitionRule__Group__8
            {
            pushFollow(FOLLOW_15);
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
    // InternalDefinitionLanguage.g:2572:1: rule__EnumTypeDefinitionRule__Group__7__Impl : ( ')' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2576:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:2577:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:2577:1: ( ')' )
            // InternalDefinitionLanguage.g:2578:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getRightParenthesisKeyword_7()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:2587:1: rule__EnumTypeDefinitionRule__Group__8 : rule__EnumTypeDefinitionRule__Group__8__Impl rule__EnumTypeDefinitionRule__Group__9 ;
    public final void rule__EnumTypeDefinitionRule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2591:1: ( rule__EnumTypeDefinitionRule__Group__8__Impl rule__EnumTypeDefinitionRule__Group__9 )
            // InternalDefinitionLanguage.g:2592:2: rule__EnumTypeDefinitionRule__Group__8__Impl rule__EnumTypeDefinitionRule__Group__9
            {
            pushFollow(FOLLOW_15);
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
    // InternalDefinitionLanguage.g:2599:1: rule__EnumTypeDefinitionRule__Group__8__Impl : ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? ) ;
    public final void rule__EnumTypeDefinitionRule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2603:1: ( ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? ) )
            // InternalDefinitionLanguage.g:2604:1: ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? )
            {
            // InternalDefinitionLanguage.g:2604:1: ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? )
            // InternalDefinitionLanguage.g:2605:2: ( rule__EnumTypeDefinitionRule__Group_8__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup_8()); 
            }
            // InternalDefinitionLanguage.g:2606:2: ( rule__EnumTypeDefinitionRule__Group_8__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==59) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDefinitionLanguage.g:2606:3: rule__EnumTypeDefinitionRule__Group_8__0
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
    // InternalDefinitionLanguage.g:2614:1: rule__EnumTypeDefinitionRule__Group__9 : rule__EnumTypeDefinitionRule__Group__9__Impl ;
    public final void rule__EnumTypeDefinitionRule__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2618:1: ( rule__EnumTypeDefinitionRule__Group__9__Impl )
            // InternalDefinitionLanguage.g:2619:2: rule__EnumTypeDefinitionRule__Group__9__Impl
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
    // InternalDefinitionLanguage.g:2625:1: rule__EnumTypeDefinitionRule__Group__9__Impl : ( ';' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2629:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:2630:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:2630:1: ( ';' )
            // InternalDefinitionLanguage.g:2631:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getSemicolonKeyword_9()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:2641:1: rule__EnumTypeDefinitionRule__Group_6__0 : rule__EnumTypeDefinitionRule__Group_6__0__Impl rule__EnumTypeDefinitionRule__Group_6__1 ;
    public final void rule__EnumTypeDefinitionRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2645:1: ( rule__EnumTypeDefinitionRule__Group_6__0__Impl rule__EnumTypeDefinitionRule__Group_6__1 )
            // InternalDefinitionLanguage.g:2646:2: rule__EnumTypeDefinitionRule__Group_6__0__Impl rule__EnumTypeDefinitionRule__Group_6__1
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
    // InternalDefinitionLanguage.g:2653:1: rule__EnumTypeDefinitionRule__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2657:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:2658:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:2658:1: ( ',' )
            // InternalDefinitionLanguage.g:2659:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getCommaKeyword_6_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:2668:1: rule__EnumTypeDefinitionRule__Group_6__1 : rule__EnumTypeDefinitionRule__Group_6__1__Impl ;
    public final void rule__EnumTypeDefinitionRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2672:1: ( rule__EnumTypeDefinitionRule__Group_6__1__Impl )
            // InternalDefinitionLanguage.g:2673:2: rule__EnumTypeDefinitionRule__Group_6__1__Impl
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
    // InternalDefinitionLanguage.g:2679:1: rule__EnumTypeDefinitionRule__Group_6__1__Impl : ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2683:1: ( ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) ) )
            // InternalDefinitionLanguage.g:2684:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) )
            {
            // InternalDefinitionLanguage.g:2684:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) )
            // InternalDefinitionLanguage.g:2685:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsAssignment_6_1()); 
            }
            // InternalDefinitionLanguage.g:2686:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 )
            // InternalDefinitionLanguage.g:2686:3: rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1
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
    // InternalDefinitionLanguage.g:2695:1: rule__EnumTypeDefinitionRule__Group_8__0 : rule__EnumTypeDefinitionRule__Group_8__0__Impl rule__EnumTypeDefinitionRule__Group_8__1 ;
    public final void rule__EnumTypeDefinitionRule__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2699:1: ( rule__EnumTypeDefinitionRule__Group_8__0__Impl rule__EnumTypeDefinitionRule__Group_8__1 )
            // InternalDefinitionLanguage.g:2700:2: rule__EnumTypeDefinitionRule__Group_8__0__Impl rule__EnumTypeDefinitionRule__Group_8__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalDefinitionLanguage.g:2707:1: rule__EnumTypeDefinitionRule__Group_8__0__Impl : ( 'with' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2711:1: ( ( 'with' ) )
            // InternalDefinitionLanguage.g:2712:1: ( 'with' )
            {
            // InternalDefinitionLanguage.g:2712:1: ( 'with' )
            // InternalDefinitionLanguage.g:2713:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getWithKeyword_8_0()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:2722:1: rule__EnumTypeDefinitionRule__Group_8__1 : rule__EnumTypeDefinitionRule__Group_8__1__Impl rule__EnumTypeDefinitionRule__Group_8__2 ;
    public final void rule__EnumTypeDefinitionRule__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2726:1: ( rule__EnumTypeDefinitionRule__Group_8__1__Impl rule__EnumTypeDefinitionRule__Group_8__2 )
            // InternalDefinitionLanguage.g:2727:2: rule__EnumTypeDefinitionRule__Group_8__1__Impl rule__EnumTypeDefinitionRule__Group_8__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalDefinitionLanguage.g:2734:1: rule__EnumTypeDefinitionRule__Group_8__1__Impl : ( 'constraints' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2738:1: ( ( 'constraints' ) )
            // InternalDefinitionLanguage.g:2739:1: ( 'constraints' )
            {
            // InternalDefinitionLanguage.g:2739:1: ( 'constraints' )
            // InternalDefinitionLanguage.g:2740:2: 'constraints'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsKeyword_8_1()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:2749:1: rule__EnumTypeDefinitionRule__Group_8__2 : rule__EnumTypeDefinitionRule__Group_8__2__Impl rule__EnumTypeDefinitionRule__Group_8__3 ;
    public final void rule__EnumTypeDefinitionRule__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2753:1: ( rule__EnumTypeDefinitionRule__Group_8__2__Impl rule__EnumTypeDefinitionRule__Group_8__3 )
            // InternalDefinitionLanguage.g:2754:2: rule__EnumTypeDefinitionRule__Group_8__2__Impl rule__EnumTypeDefinitionRule__Group_8__3
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:2761:1: rule__EnumTypeDefinitionRule__Group_8__2__Impl : ( ':' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2765:1: ( ( ':' ) )
            // InternalDefinitionLanguage.g:2766:1: ( ':' )
            {
            // InternalDefinitionLanguage.g:2766:1: ( ':' )
            // InternalDefinitionLanguage.g:2767:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getColonKeyword_8_2()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:2776:1: rule__EnumTypeDefinitionRule__Group_8__3 : rule__EnumTypeDefinitionRule__Group_8__3__Impl ;
    public final void rule__EnumTypeDefinitionRule__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2780:1: ( rule__EnumTypeDefinitionRule__Group_8__3__Impl )
            // InternalDefinitionLanguage.g:2781:2: rule__EnumTypeDefinitionRule__Group_8__3__Impl
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
    // InternalDefinitionLanguage.g:2787:1: rule__EnumTypeDefinitionRule__Group_8__3__Impl : ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2791:1: ( ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* ) )
            // InternalDefinitionLanguage.g:2792:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* )
            {
            // InternalDefinitionLanguage.g:2792:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* )
            // InternalDefinitionLanguage.g:2793:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsAssignment_8_3()); 
            }
            // InternalDefinitionLanguage.g:2794:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=RULE_QUOTED_ID && LA22_0<=RULE_INT)||LA22_0==15||(LA22_0>=26 && LA22_0<=27)||LA22_0==55||LA22_0==66||(LA22_0>=68 && LA22_0<=70)||(LA22_0>=72 && LA22_0<=74)||(LA22_0>=91 && LA22_0<=92)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2794:3: rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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


    // $ANTLR start "rule__StatementRule__Group__0"
    // InternalDefinitionLanguage.g:2803:1: rule__StatementRule__Group__0 : rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 ;
    public final void rule__StatementRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2807:1: ( rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 )
            // InternalDefinitionLanguage.g:2808:2: rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalDefinitionLanguage.g:2815:1: rule__StatementRule__Group__0__Impl : ( ruleExpressionRule ) ;
    public final void rule__StatementRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2819:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:2820:1: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:2820:1: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:2821:2: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:2830:1: rule__StatementRule__Group__1 : rule__StatementRule__Group__1__Impl ;
    public final void rule__StatementRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2834:1: ( rule__StatementRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2835:2: rule__StatementRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2841:1: rule__StatementRule__Group__1__Impl : ( ';' ) ;
    public final void rule__StatementRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2845:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:2846:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:2846:1: ( ';' )
            // InternalDefinitionLanguage.g:2847:2: ';'
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


    // $ANTLR start "rule__OrExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:2857:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2861:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2862:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:2869:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2873:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2874:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2874:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:2875:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:2876:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:2876:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:2884:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2888:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2889:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2895:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2899:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:2900:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2900:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:2901:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:2902:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==62) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2902:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalDefinitionLanguage.g:2911:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2915:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:2916:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:2923:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2927:1: ( ( 'OR' ) )
            // InternalDefinitionLanguage.g:2928:1: ( 'OR' )
            {
            // InternalDefinitionLanguage.g:2928:1: ( 'OR' )
            // InternalDefinitionLanguage.g:2929:2: 'OR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:2938:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2942:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:2943:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:2949:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2953:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:2954:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:2954:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:2955:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:2956:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:2956:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:2965:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2969:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2970:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:2977:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2981:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2982:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2982:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:2983:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:2984:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:2984:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:2992:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2996:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2997:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3003:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3007:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3008:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3008:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3009:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:3010:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==63) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3010:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalDefinitionLanguage.g:3019:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3023:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3024:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:3031:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3035:1: ( ( 'XOR' ) )
            // InternalDefinitionLanguage.g:3036:1: ( 'XOR' )
            {
            // InternalDefinitionLanguage.g:3036:1: ( 'XOR' )
            // InternalDefinitionLanguage.g:3037:2: 'XOR'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:3046:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3050:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3051:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3057:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3061:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3062:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3062:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3063:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:3064:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3064:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3073:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3077:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3078:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3085:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3089:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3090:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3090:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:3091:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3092:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:3092:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:3100:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3104:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3105:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3111:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3115:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3116:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3116:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3117:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:3118:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==64) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3118:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalDefinitionLanguage.g:3127:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3131:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3132:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:3139:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3143:1: ( ( 'AND' ) )
            // InternalDefinitionLanguage.g:3144:1: ( 'AND' )
            {
            // InternalDefinitionLanguage.g:3144:1: ( 'AND' )
            // InternalDefinitionLanguage.g:3145:2: 'AND'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:3154:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3158:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3159:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3165:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3169:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3170:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3170:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3171:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:3172:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3172:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3181:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3185:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3186:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:3193:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3197:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalDefinitionLanguage.g:3198:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalDefinitionLanguage.g:3198:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalDefinitionLanguage.g:3199:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3200:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==91) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDefinitionLanguage.g:3200:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalDefinitionLanguage.g:3208:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3212:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3213:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3219:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3223:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3224:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3224:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalDefinitionLanguage.g:3225:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:3226:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalDefinitionLanguage.g:3226:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalDefinitionLanguage.g:3235:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3239:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3240:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3247:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3251:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3252:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3252:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3253:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3254:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3254:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3262:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3266:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3267:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3273:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3277:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalDefinitionLanguage.g:3278:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalDefinitionLanguage.g:3278:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalDefinitionLanguage.g:3279:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:3280:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=20 && LA27_0<=25)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3280:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalDefinitionLanguage.g:3289:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3293:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3294:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:3301:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3305:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3306:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3306:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalDefinitionLanguage.g:3307:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3308:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalDefinitionLanguage.g:3308:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalDefinitionLanguage.g:3316:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3320:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3321:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3327:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3331:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3332:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3332:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3333:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:3334:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3334:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3343:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3347:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3348:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3355:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3359:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3360:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3360:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3361:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3362:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3362:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3370:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3374:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3375:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3381:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3385:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3386:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3386:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3387:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:3388:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=26 && LA28_0<=27)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3388:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalDefinitionLanguage.g:3397:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3401:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3402:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:3409:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3413:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDefinitionLanguage.g:3414:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDefinitionLanguage.g:3414:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDefinitionLanguage.g:3415:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDefinitionLanguage.g:3416:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalDefinitionLanguage.g:3416:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalDefinitionLanguage.g:3424:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3428:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3429:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3435:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3439:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3440:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3440:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3441:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:3442:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3442:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3451:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3455:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3456:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3463:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3467:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3468:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3468:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3469:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3470:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3470:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3478:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3482:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3483:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3489:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3493:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3494:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3494:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3495:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:3496:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=28 && LA29_0<=30)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3496:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalDefinitionLanguage.g:3505:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3509:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3510:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:3517:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3521:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDefinitionLanguage.g:3522:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDefinitionLanguage.g:3522:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDefinitionLanguage.g:3523:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDefinitionLanguage.g:3524:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalDefinitionLanguage.g:3524:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalDefinitionLanguage.g:3532:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3536:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3537:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3543:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3547:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3548:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3548:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3549:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:3550:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3550:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3559:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3563:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3564:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3571:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3575:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3576:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3576:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3577:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3578:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3578:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3586:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3590:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3591:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3597:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3601:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalDefinitionLanguage.g:3602:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalDefinitionLanguage.g:3602:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalDefinitionLanguage.g:3603:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:3604:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==65) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalDefinitionLanguage.g:3604:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalDefinitionLanguage.g:3613:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3617:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3618:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:3625:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3629:1: ( ( '^' ) )
            // InternalDefinitionLanguage.g:3630:1: ( '^' )
            {
            // InternalDefinitionLanguage.g:3630:1: ( '^' )
            // InternalDefinitionLanguage.g:3631:2: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:3640:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3644:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3645:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3651:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3655:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3656:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3656:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3657:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:3658:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalDefinitionLanguage.g:3658:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalDefinitionLanguage.g:3667:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3671:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3672:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:3679:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3683:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:3684:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:3684:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalDefinitionLanguage.g:3685:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3686:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=26 && LA31_0<=27)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3686:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalDefinitionLanguage.g:3694:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3698:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3699:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3705:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3709:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3710:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3710:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3711:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:3712:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3712:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3721:1: rule__ArrayRule__Group__0 : rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 ;
    public final void rule__ArrayRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3725:1: ( rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 )
            // InternalDefinitionLanguage.g:3726:2: rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalDefinitionLanguage.g:3733:1: rule__ArrayRule__Group__0__Impl : ( () ) ;
    public final void rule__ArrayRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3737:1: ( ( () ) )
            // InternalDefinitionLanguage.g:3738:1: ( () )
            {
            // InternalDefinitionLanguage.g:3738:1: ( () )
            // InternalDefinitionLanguage.g:3739:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 
            }
            // InternalDefinitionLanguage.g:3740:2: ()
            // InternalDefinitionLanguage.g:3740:3: 
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
    // InternalDefinitionLanguage.g:3748:1: rule__ArrayRule__Group__1 : rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 ;
    public final void rule__ArrayRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3752:1: ( rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 )
            // InternalDefinitionLanguage.g:3753:2: rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2
            {
            pushFollow(FOLLOW_35);
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
    // InternalDefinitionLanguage.g:3760:1: rule__ArrayRule__Group__1__Impl : ( '[' ) ;
    public final void rule__ArrayRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3764:1: ( ( '[' ) )
            // InternalDefinitionLanguage.g:3765:1: ( '[' )
            {
            // InternalDefinitionLanguage.g:3765:1: ( '[' )
            // InternalDefinitionLanguage.g:3766:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:3775:1: rule__ArrayRule__Group__2 : rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 ;
    public final void rule__ArrayRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3779:1: ( rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 )
            // InternalDefinitionLanguage.g:3780:2: rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3
            {
            pushFollow(FOLLOW_35);
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
    // InternalDefinitionLanguage.g:3787:1: rule__ArrayRule__Group__2__Impl : ( ( rule__ArrayRule__Group_2__0 )? ) ;
    public final void rule__ArrayRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3791:1: ( ( ( rule__ArrayRule__Group_2__0 )? ) )
            // InternalDefinitionLanguage.g:3792:1: ( ( rule__ArrayRule__Group_2__0 )? )
            {
            // InternalDefinitionLanguage.g:3792:1: ( ( rule__ArrayRule__Group_2__0 )? )
            // InternalDefinitionLanguage.g:3793:2: ( rule__ArrayRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2()); 
            }
            // InternalDefinitionLanguage.g:3794:2: ( rule__ArrayRule__Group_2__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_QUOTED_ID && LA32_0<=RULE_INT)||LA32_0==15||(LA32_0>=26 && LA32_0<=27)||LA32_0==55||LA32_0==66||(LA32_0>=68 && LA32_0<=70)||(LA32_0>=72 && LA32_0<=74)||(LA32_0>=91 && LA32_0<=92)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalDefinitionLanguage.g:3794:3: rule__ArrayRule__Group_2__0
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
    // InternalDefinitionLanguage.g:3802:1: rule__ArrayRule__Group__3 : rule__ArrayRule__Group__3__Impl ;
    public final void rule__ArrayRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3806:1: ( rule__ArrayRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:3807:2: rule__ArrayRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:3813:1: rule__ArrayRule__Group__3__Impl : ( ']' ) ;
    public final void rule__ArrayRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3817:1: ( ( ']' ) )
            // InternalDefinitionLanguage.g:3818:1: ( ']' )
            {
            // InternalDefinitionLanguage.g:3818:1: ( ']' )
            // InternalDefinitionLanguage.g:3819:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:3829:1: rule__ArrayRule__Group_2__0 : rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 ;
    public final void rule__ArrayRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3833:1: ( rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 )
            // InternalDefinitionLanguage.g:3834:2: rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalDefinitionLanguage.g:3841:1: rule__ArrayRule__Group_2__0__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) ;
    public final void rule__ArrayRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3845:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) )
            // InternalDefinitionLanguage.g:3846:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            {
            // InternalDefinitionLanguage.g:3846:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            // InternalDefinitionLanguage.g:3847:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 
            }
            // InternalDefinitionLanguage.g:3848:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            // InternalDefinitionLanguage.g:3848:3: rule__ArrayRule__ValuesAssignment_2_0
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
    // InternalDefinitionLanguage.g:3856:1: rule__ArrayRule__Group_2__1 : rule__ArrayRule__Group_2__1__Impl ;
    public final void rule__ArrayRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3860:1: ( rule__ArrayRule__Group_2__1__Impl )
            // InternalDefinitionLanguage.g:3861:2: rule__ArrayRule__Group_2__1__Impl
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
    // InternalDefinitionLanguage.g:3867:1: rule__ArrayRule__Group_2__1__Impl : ( ( rule__ArrayRule__Group_2_1__0 )* ) ;
    public final void rule__ArrayRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3871:1: ( ( ( rule__ArrayRule__Group_2_1__0 )* ) )
            // InternalDefinitionLanguage.g:3872:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3872:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            // InternalDefinitionLanguage.g:3873:2: ( rule__ArrayRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 
            }
            // InternalDefinitionLanguage.g:3874:2: ( rule__ArrayRule__Group_2_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==58) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3874:3: rule__ArrayRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__ArrayRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalDefinitionLanguage.g:3883:1: rule__ArrayRule__Group_2_1__0 : rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 ;
    public final void rule__ArrayRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3887:1: ( rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 )
            // InternalDefinitionLanguage.g:3888:2: rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:3895:1: rule__ArrayRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ArrayRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3899:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:3900:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:3900:1: ( ',' )
            // InternalDefinitionLanguage.g:3901:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:3910:1: rule__ArrayRule__Group_2_1__1 : rule__ArrayRule__Group_2_1__1__Impl ;
    public final void rule__ArrayRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3914:1: ( rule__ArrayRule__Group_2_1__1__Impl )
            // InternalDefinitionLanguage.g:3915:2: rule__ArrayRule__Group_2_1__1__Impl
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
    // InternalDefinitionLanguage.g:3921:1: rule__ArrayRule__Group_2_1__1__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__ArrayRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3925:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) )
            // InternalDefinitionLanguage.g:3926:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3926:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            // InternalDefinitionLanguage.g:3927:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 
            }
            // InternalDefinitionLanguage.g:3928:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            // InternalDefinitionLanguage.g:3928:3: rule__ArrayRule__ValuesAssignment_2_1_1
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
    // InternalDefinitionLanguage.g:3937:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3941:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalDefinitionLanguage.g:3942:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:3949:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3953:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:3954:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:3954:1: ( '(' )
            // InternalDefinitionLanguage.g:3955:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:3964:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3968:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalDefinitionLanguage.g:3969:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_37);
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
    // InternalDefinitionLanguage.g:3976:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3980:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3981:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3981:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3982:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:3983:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3983:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3991:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3995:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalDefinitionLanguage.g:3996:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalDefinitionLanguage.g:4002:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4006:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:4007:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:4007:1: ( ')' )
            // InternalDefinitionLanguage.g:4008:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__PathExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:4018:1: rule__PathExpressionRule__Group__0 : rule__PathExpressionRule__Group__0__Impl rule__PathExpressionRule__Group__1 ;
    public final void rule__PathExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4022:1: ( rule__PathExpressionRule__Group__0__Impl rule__PathExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:4023:2: rule__PathExpressionRule__Group__0__Impl rule__PathExpressionRule__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__PathExpressionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PathExpressionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathExpressionRule__Group__0"


    // $ANTLR start "rule__PathExpressionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:4030:1: rule__PathExpressionRule__Group__0__Impl : ( 'path' ) ;
    public final void rule__PathExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4034:1: ( ( 'path' ) )
            // InternalDefinitionLanguage.g:4035:1: ( 'path' )
            {
            // InternalDefinitionLanguage.g:4035:1: ( 'path' )
            // InternalDefinitionLanguage.g:4036:2: 'path'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathExpressionRuleAccess().getPathKeyword_0()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathExpressionRuleAccess().getPathKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathExpressionRule__Group__0__Impl"


    // $ANTLR start "rule__PathExpressionRule__Group__1"
    // InternalDefinitionLanguage.g:4045:1: rule__PathExpressionRule__Group__1 : rule__PathExpressionRule__Group__1__Impl ;
    public final void rule__PathExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4049:1: ( rule__PathExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4050:2: rule__PathExpressionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PathExpressionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathExpressionRule__Group__1"


    // $ANTLR start "rule__PathExpressionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:4056:1: rule__PathExpressionRule__Group__1__Impl : ( ( rule__PathExpressionRule__PathAssignment_1 ) ) ;
    public final void rule__PathExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4060:1: ( ( ( rule__PathExpressionRule__PathAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:4061:1: ( ( rule__PathExpressionRule__PathAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:4061:1: ( ( rule__PathExpressionRule__PathAssignment_1 ) )
            // InternalDefinitionLanguage.g:4062:2: ( rule__PathExpressionRule__PathAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathExpressionRuleAccess().getPathAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4063:2: ( rule__PathExpressionRule__PathAssignment_1 )
            // InternalDefinitionLanguage.g:4063:3: rule__PathExpressionRule__PathAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PathExpressionRule__PathAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathExpressionRuleAccess().getPathAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathExpressionRule__Group__1__Impl"


    // $ANTLR start "rule__CallRule__Group__0"
    // InternalDefinitionLanguage.g:4072:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4076:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalDefinitionLanguage.g:4077:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalDefinitionLanguage.g:4084:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4088:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4089:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4089:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalDefinitionLanguage.g:4090:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4091:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalDefinitionLanguage.g:4091:3: rule__CallRule__FunctionAssignment_0
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
    // InternalDefinitionLanguage.g:4099:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4103:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalDefinitionLanguage.g:4104:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_39);
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
    // InternalDefinitionLanguage.g:4111:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4115:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:4116:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:4116:1: ( '(' )
            // InternalDefinitionLanguage.g:4117:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4126:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4130:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalDefinitionLanguage.g:4131:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_39);
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
    // InternalDefinitionLanguage.g:4138:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4142:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalDefinitionLanguage.g:4143:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalDefinitionLanguage.g:4143:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalDefinitionLanguage.g:4144:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalDefinitionLanguage.g:4145:2: ( rule__CallRule__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_QUOTED_ID && LA34_0<=RULE_INT)||LA34_0==15||(LA34_0>=26 && LA34_0<=27)||LA34_0==55||LA34_0==66||(LA34_0>=68 && LA34_0<=70)||(LA34_0>=72 && LA34_0<=74)||(LA34_0>=91 && LA34_0<=92)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalDefinitionLanguage.g:4145:3: rule__CallRule__Group_2__0
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
    // InternalDefinitionLanguage.g:4153:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4157:1: ( rule__CallRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:4158:2: rule__CallRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:4164:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4168:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:4169:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:4169:1: ( ')' )
            // InternalDefinitionLanguage.g:4170:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4180:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4184:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalDefinitionLanguage.g:4185:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalDefinitionLanguage.g:4192:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4196:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalDefinitionLanguage.g:4197:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalDefinitionLanguage.g:4197:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalDefinitionLanguage.g:4198:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalDefinitionLanguage.g:4199:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalDefinitionLanguage.g:4199:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalDefinitionLanguage.g:4207:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4211:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalDefinitionLanguage.g:4212:2: rule__CallRule__Group_2__1__Impl
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
    // InternalDefinitionLanguage.g:4218:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4222:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalDefinitionLanguage.g:4223:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalDefinitionLanguage.g:4223:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalDefinitionLanguage.g:4224:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalDefinitionLanguage.g:4225:2: ( rule__CallRule__Group_2_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==58) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4225:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalDefinitionLanguage.g:4234:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4238:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalDefinitionLanguage.g:4239:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:4246:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4250:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:4251:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:4251:1: ( ',' )
            // InternalDefinitionLanguage.g:4252:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4261:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4265:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalDefinitionLanguage.g:4266:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalDefinitionLanguage.g:4272:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4276:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalDefinitionLanguage.g:4277:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalDefinitionLanguage.g:4277:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalDefinitionLanguage.g:4278:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalDefinitionLanguage.g:4279:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalDefinitionLanguage.g:4279:3: rule__CallRule__ParametersAssignment_2_1_1
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
    // InternalDefinitionLanguage.g:4288:1: rule__SelfReferenceRule__Group_0__0 : rule__SelfReferenceRule__Group_0__0__Impl rule__SelfReferenceRule__Group_0__1 ;
    public final void rule__SelfReferenceRule__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4292:1: ( rule__SelfReferenceRule__Group_0__0__Impl rule__SelfReferenceRule__Group_0__1 )
            // InternalDefinitionLanguage.g:4293:2: rule__SelfReferenceRule__Group_0__0__Impl rule__SelfReferenceRule__Group_0__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalDefinitionLanguage.g:4300:1: rule__SelfReferenceRule__Group_0__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4304:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4305:1: ( () )
            {
            // InternalDefinitionLanguage.g:4305:1: ( () )
            // InternalDefinitionLanguage.g:4306:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0_0()); 
            }
            // InternalDefinitionLanguage.g:4307:2: ()
            // InternalDefinitionLanguage.g:4307:3: 
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
    // InternalDefinitionLanguage.g:4315:1: rule__SelfReferenceRule__Group_0__1 : rule__SelfReferenceRule__Group_0__1__Impl ;
    public final void rule__SelfReferenceRule__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4319:1: ( rule__SelfReferenceRule__Group_0__1__Impl )
            // InternalDefinitionLanguage.g:4320:2: rule__SelfReferenceRule__Group_0__1__Impl
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
    // InternalDefinitionLanguage.g:4326:1: rule__SelfReferenceRule__Group_0__1__Impl : ( 'self' ) ;
    public final void rule__SelfReferenceRule__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4330:1: ( ( 'self' ) )
            // InternalDefinitionLanguage.g:4331:1: ( 'self' )
            {
            // InternalDefinitionLanguage.g:4331:1: ( 'self' )
            // InternalDefinitionLanguage.g:4332:2: 'self'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfKeyword_0_1()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4342:1: rule__SelfReferenceRule__Group_1__0 : rule__SelfReferenceRule__Group_1__0__Impl rule__SelfReferenceRule__Group_1__1 ;
    public final void rule__SelfReferenceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4346:1: ( rule__SelfReferenceRule__Group_1__0__Impl rule__SelfReferenceRule__Group_1__1 )
            // InternalDefinitionLanguage.g:4347:2: rule__SelfReferenceRule__Group_1__0__Impl rule__SelfReferenceRule__Group_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:4354:1: rule__SelfReferenceRule__Group_1__0__Impl : ( () ) ;
    public final void rule__SelfReferenceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4358:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4359:1: ( () )
            {
            // InternalDefinitionLanguage.g:4359:1: ( () )
            // InternalDefinitionLanguage.g:4360:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_1_0()); 
            }
            // InternalDefinitionLanguage.g:4361:2: ()
            // InternalDefinitionLanguage.g:4361:3: 
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
    // InternalDefinitionLanguage.g:4369:1: rule__SelfReferenceRule__Group_1__1 : rule__SelfReferenceRule__Group_1__1__Impl ;
    public final void rule__SelfReferenceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4373:1: ( rule__SelfReferenceRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:4374:2: rule__SelfReferenceRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:4380:1: rule__SelfReferenceRule__Group_1__1__Impl : ( 'value' ) ;
    public final void rule__SelfReferenceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4384:1: ( ( 'value' ) )
            // InternalDefinitionLanguage.g:4385:1: ( 'value' )
            {
            // InternalDefinitionLanguage.g:4385:1: ( 'value' )
            // InternalDefinitionLanguage.g:4386:2: 'value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1_1()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4396:1: rule__AttributeReferenceRule__Group__0 : rule__AttributeReferenceRule__Group__0__Impl rule__AttributeReferenceRule__Group__1 ;
    public final void rule__AttributeReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4400:1: ( rule__AttributeReferenceRule__Group__0__Impl rule__AttributeReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:4401:2: rule__AttributeReferenceRule__Group__0__Impl rule__AttributeReferenceRule__Group__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalDefinitionLanguage.g:4408:1: rule__AttributeReferenceRule__Group__0__Impl : ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) ) ;
    public final void rule__AttributeReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4412:1: ( ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4413:1: ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4413:1: ( ( rule__AttributeReferenceRule__SelfAssignment_0 ) )
            // InternalDefinitionLanguage.g:4414:2: ( rule__AttributeReferenceRule__SelfAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getSelfAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4415:2: ( rule__AttributeReferenceRule__SelfAssignment_0 )
            // InternalDefinitionLanguage.g:4415:3: rule__AttributeReferenceRule__SelfAssignment_0
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
    // InternalDefinitionLanguage.g:4423:1: rule__AttributeReferenceRule__Group__1 : rule__AttributeReferenceRule__Group__1__Impl ;
    public final void rule__AttributeReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4427:1: ( rule__AttributeReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4428:2: rule__AttributeReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4434:1: rule__AttributeReferenceRule__Group__1__Impl : ( ( rule__AttributeReferenceRule__Group_1__0 )* ) ;
    public final void rule__AttributeReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4438:1: ( ( ( rule__AttributeReferenceRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:4439:1: ( ( rule__AttributeReferenceRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:4439:1: ( ( rule__AttributeReferenceRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:4440:2: ( rule__AttributeReferenceRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:4441:2: ( rule__AttributeReferenceRule__Group_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==71) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4441:3: rule__AttributeReferenceRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_42);
            	    rule__AttributeReferenceRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalDefinitionLanguage.g:4450:1: rule__AttributeReferenceRule__Group_1__0 : rule__AttributeReferenceRule__Group_1__0__Impl rule__AttributeReferenceRule__Group_1__1 ;
    public final void rule__AttributeReferenceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4454:1: ( rule__AttributeReferenceRule__Group_1__0__Impl rule__AttributeReferenceRule__Group_1__1 )
            // InternalDefinitionLanguage.g:4455:2: rule__AttributeReferenceRule__Group_1__0__Impl rule__AttributeReferenceRule__Group_1__1
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
    // InternalDefinitionLanguage.g:4462:1: rule__AttributeReferenceRule__Group_1__0__Impl : ( '.' ) ;
    public final void rule__AttributeReferenceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4466:1: ( ( '.' ) )
            // InternalDefinitionLanguage.g:4467:1: ( '.' )
            {
            // InternalDefinitionLanguage.g:4467:1: ( '.' )
            // InternalDefinitionLanguage.g:4468:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getFullStopKeyword_1_0()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4477:1: rule__AttributeReferenceRule__Group_1__1 : rule__AttributeReferenceRule__Group_1__1__Impl ;
    public final void rule__AttributeReferenceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4481:1: ( rule__AttributeReferenceRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:4482:2: rule__AttributeReferenceRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:4488:1: rule__AttributeReferenceRule__Group_1__1__Impl : ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) ) ;
    public final void rule__AttributeReferenceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4492:1: ( ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:4493:1: ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:4493:1: ( ( rule__AttributeReferenceRule__ChainAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:4494:2: ( rule__AttributeReferenceRule__ChainAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeReferenceRuleAccess().getChainAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:4495:2: ( rule__AttributeReferenceRule__ChainAssignment_1_1 )
            // InternalDefinitionLanguage.g:4495:3: rule__AttributeReferenceRule__ChainAssignment_1_1
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
    // InternalDefinitionLanguage.g:4504:1: rule__ConfigurationReferenceRule__Group__0 : rule__ConfigurationReferenceRule__Group__0__Impl rule__ConfigurationReferenceRule__Group__1 ;
    public final void rule__ConfigurationReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4508:1: ( rule__ConfigurationReferenceRule__Group__0__Impl rule__ConfigurationReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:4509:2: rule__ConfigurationReferenceRule__Group__0__Impl rule__ConfigurationReferenceRule__Group__1
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
    // InternalDefinitionLanguage.g:4516:1: rule__ConfigurationReferenceRule__Group__0__Impl : ( 'tree' ) ;
    public final void rule__ConfigurationReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4520:1: ( ( 'tree' ) )
            // InternalDefinitionLanguage.g:4521:1: ( 'tree' )
            {
            // InternalDefinitionLanguage.g:4521:1: ( 'tree' )
            // InternalDefinitionLanguage.g:4522:2: 'tree'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigurationReferenceRuleAccess().getTreeKeyword_0()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4531:1: rule__ConfigurationReferenceRule__Group__1 : rule__ConfigurationReferenceRule__Group__1__Impl ;
    public final void rule__ConfigurationReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4535:1: ( rule__ConfigurationReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4536:2: rule__ConfigurationReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4542:1: rule__ConfigurationReferenceRule__Group__1__Impl : ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) ) ;
    public final void rule__ConfigurationReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4546:1: ( ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:4547:1: ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:4547:1: ( ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 ) )
            // InternalDefinitionLanguage.g:4548:2: ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigurationReferenceRuleAccess().getReferenceAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4549:2: ( rule__ConfigurationReferenceRule__ReferenceAssignment_1 )
            // InternalDefinitionLanguage.g:4549:3: rule__ConfigurationReferenceRule__ReferenceAssignment_1
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
    // InternalDefinitionLanguage.g:4558:1: rule__BaseDataReferenceRule__Group__0 : rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1 ;
    public final void rule__BaseDataReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4562:1: ( rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:4563:2: rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1
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
    // InternalDefinitionLanguage.g:4570:1: rule__BaseDataReferenceRule__Group__0__Impl : ( 'data' ) ;
    public final void rule__BaseDataReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4574:1: ( ( 'data' ) )
            // InternalDefinitionLanguage.g:4575:1: ( 'data' )
            {
            // InternalDefinitionLanguage.g:4575:1: ( 'data' )
            // InternalDefinitionLanguage.g:4576:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDataKeyword_0()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4585:1: rule__BaseDataReferenceRule__Group__1 : rule__BaseDataReferenceRule__Group__1__Impl ;
    public final void rule__BaseDataReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4589:1: ( rule__BaseDataReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4590:2: rule__BaseDataReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4596:1: rule__BaseDataReferenceRule__Group__1__Impl : ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__BaseDataReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4600:1: ( ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:4601:1: ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:4601:1: ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) )
            // InternalDefinitionLanguage.g:4602:2: ( rule__BaseDataReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4603:2: ( rule__BaseDataReferenceRule__DefinitionAssignment_1 )
            // InternalDefinitionLanguage.g:4603:3: rule__BaseDataReferenceRule__DefinitionAssignment_1
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
    // InternalDefinitionLanguage.g:4612:1: rule__StructuredDataDescriptionReferenceRule__Group__0 : rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1 ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4616:1: ( rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:4617:2: rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1
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
    // InternalDefinitionLanguage.g:4624:1: rule__StructuredDataDescriptionReferenceRule__Group__0__Impl : ( 'instance' ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4628:1: ( ( 'instance' ) )
            // InternalDefinitionLanguage.g:4629:1: ( 'instance' )
            {
            // InternalDefinitionLanguage.g:4629:1: ( 'instance' )
            // InternalDefinitionLanguage.g:4630:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getInstanceKeyword_0()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4639:1: rule__StructuredDataDescriptionReferenceRule__Group__1 : rule__StructuredDataDescriptionReferenceRule__Group__1__Impl ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4643:1: ( rule__StructuredDataDescriptionReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4644:2: rule__StructuredDataDescriptionReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4650:1: rule__StructuredDataDescriptionReferenceRule__Group__1__Impl : ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4654:1: ( ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:4655:1: ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:4655:1: ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) )
            // InternalDefinitionLanguage.g:4656:2: ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4657:2: ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 )
            // InternalDefinitionLanguage.g:4657:3: rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1
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
    // InternalDefinitionLanguage.g:4666:1: rule__InstanceLiteralRule__Group__0 : rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 ;
    public final void rule__InstanceLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4670:1: ( rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4671:2: rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1
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
    // InternalDefinitionLanguage.g:4678:1: rule__InstanceLiteralRule__Group__0__Impl : ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) ;
    public final void rule__InstanceLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4682:1: ( ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4683:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4683:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            // InternalDefinitionLanguage.g:4684:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4685:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            // InternalDefinitionLanguage.g:4685:3: rule__InstanceLiteralRule__DefinitionAssignment_0
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
    // InternalDefinitionLanguage.g:4693:1: rule__InstanceLiteralRule__Group__1 : rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 ;
    public final void rule__InstanceLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4697:1: ( rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 )
            // InternalDefinitionLanguage.g:4698:2: rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2
            {
            pushFollow(FOLLOW_43);
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
    // InternalDefinitionLanguage.g:4705:1: rule__InstanceLiteralRule__Group__1__Impl : ( '{' ) ;
    public final void rule__InstanceLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4709:1: ( ( '{' ) )
            // InternalDefinitionLanguage.g:4710:1: ( '{' )
            {
            // InternalDefinitionLanguage.g:4710:1: ( '{' )
            // InternalDefinitionLanguage.g:4711:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4720:1: rule__InstanceLiteralRule__Group__2 : rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 ;
    public final void rule__InstanceLiteralRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4724:1: ( rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 )
            // InternalDefinitionLanguage.g:4725:2: rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3
            {
            pushFollow(FOLLOW_43);
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
    // InternalDefinitionLanguage.g:4732:1: rule__InstanceLiteralRule__Group__2__Impl : ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) ;
    public final void rule__InstanceLiteralRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4736:1: ( ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) )
            // InternalDefinitionLanguage.g:4737:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            {
            // InternalDefinitionLanguage.g:4737:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            // InternalDefinitionLanguage.g:4738:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAssignment_2()); 
            }
            // InternalDefinitionLanguage.g:4739:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_QUOTED_ID && LA37_0<=RULE_ID)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4739:3: rule__InstanceLiteralRule__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_44);
            	    rule__InstanceLiteralRule__AttributesAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalDefinitionLanguage.g:4747:1: rule__InstanceLiteralRule__Group__3 : rule__InstanceLiteralRule__Group__3__Impl ;
    public final void rule__InstanceLiteralRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4751:1: ( rule__InstanceLiteralRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:4752:2: rule__InstanceLiteralRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:4758:1: rule__InstanceLiteralRule__Group__3__Impl : ( '}' ) ;
    public final void rule__InstanceLiteralRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4762:1: ( ( '}' ) )
            // InternalDefinitionLanguage.g:4763:1: ( '}' )
            {
            // InternalDefinitionLanguage.g:4763:1: ( '}' )
            // InternalDefinitionLanguage.g:4764:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4774:1: rule__AttributeRule__Group__0 : rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 ;
    public final void rule__AttributeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4778:1: ( rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 )
            // InternalDefinitionLanguage.g:4779:2: rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1
            {
            pushFollow(FOLLOW_45);
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
    // InternalDefinitionLanguage.g:4786:1: rule__AttributeRule__Group__0__Impl : ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) ;
    public final void rule__AttributeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4790:1: ( ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4791:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4791:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            // InternalDefinitionLanguage.g:4792:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4793:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            // InternalDefinitionLanguage.g:4793:3: rule__AttributeRule__DefinitionAssignment_0
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
    // InternalDefinitionLanguage.g:4801:1: rule__AttributeRule__Group__1 : rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 ;
    public final void rule__AttributeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4805:1: ( rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 )
            // InternalDefinitionLanguage.g:4806:2: rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:4813:1: rule__AttributeRule__Group__1__Impl : ( ':=' ) ;
    public final void rule__AttributeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4817:1: ( ( ':=' ) )
            // InternalDefinitionLanguage.g:4818:1: ( ':=' )
            {
            // InternalDefinitionLanguage.g:4818:1: ( ':=' )
            // InternalDefinitionLanguage.g:4819:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4828:1: rule__AttributeRule__Group__2 : rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 ;
    public final void rule__AttributeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4832:1: ( rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 )
            // InternalDefinitionLanguage.g:4833:2: rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3
            {
            pushFollow(FOLLOW_20);
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
    // InternalDefinitionLanguage.g:4840:1: rule__AttributeRule__Group__2__Impl : ( ( rule__AttributeRule__ValueAssignment_2 ) ) ;
    public final void rule__AttributeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4844:1: ( ( ( rule__AttributeRule__ValueAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:4845:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:4845:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            // InternalDefinitionLanguage.g:4846:2: ( rule__AttributeRule__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 
            }
            // InternalDefinitionLanguage.g:4847:2: ( rule__AttributeRule__ValueAssignment_2 )
            // InternalDefinitionLanguage.g:4847:3: rule__AttributeRule__ValueAssignment_2
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
    // InternalDefinitionLanguage.g:4855:1: rule__AttributeRule__Group__3 : rule__AttributeRule__Group__3__Impl ;
    public final void rule__AttributeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4859:1: ( rule__AttributeRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:4860:2: rule__AttributeRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:4866:1: rule__AttributeRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4870:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:4871:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:4871:1: ( ';' )
            // InternalDefinitionLanguage.g:4872:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4882:1: rule__RealLiteralRule__Group__0 : rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 ;
    public final void rule__RealLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4886:1: ( rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4887:2: rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalDefinitionLanguage.g:4894:1: rule__RealLiteralRule__Group__0__Impl : ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__RealLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4898:1: ( ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4899:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4899:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            // InternalDefinitionLanguage.g:4900:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4901:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            // InternalDefinitionLanguage.g:4901:3: rule__RealLiteralRule__LiteralAssignment_0
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
    // InternalDefinitionLanguage.g:4909:1: rule__RealLiteralRule__Group__1 : rule__RealLiteralRule__Group__1__Impl ;
    public final void rule__RealLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4913:1: ( rule__RealLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4914:2: rule__RealLiteralRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4920:1: rule__RealLiteralRule__Group__1__Impl : ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__RealLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4924:1: ( ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) )
            // InternalDefinitionLanguage.g:4925:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDefinitionLanguage.g:4925:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            // InternalDefinitionLanguage.g:4926:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4927:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=31 && LA38_0<=50)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalDefinitionLanguage.g:4927:3: rule__RealLiteralRule__FactorAssignment_1
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
    // InternalDefinitionLanguage.g:4936:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4940:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4941:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalDefinitionLanguage.g:4948:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4952:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4953:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4953:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalDefinitionLanguage.g:4954:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4955:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalDefinitionLanguage.g:4955:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalDefinitionLanguage.g:4963:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4967:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4968:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4974:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4978:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalDefinitionLanguage.g:4979:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDefinitionLanguage.g:4979:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalDefinitionLanguage.g:4980:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4981:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=31 && LA39_0<=50)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalDefinitionLanguage.g:4981:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalDefinitionLanguage.g:4990:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4994:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4995:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalDefinitionLanguage.g:5002:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5006:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5007:1: ( () )
            {
            // InternalDefinitionLanguage.g:5007:1: ( () )
            // InternalDefinitionLanguage.g:5008:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalDefinitionLanguage.g:5009:2: ()
            // InternalDefinitionLanguage.g:5009:3: 
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
    // InternalDefinitionLanguage.g:5017:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5021:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5022:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5028:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5032:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalDefinitionLanguage.g:5033:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalDefinitionLanguage.g:5033:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalDefinitionLanguage.g:5034:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalDefinitionLanguage.g:5035:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalDefinitionLanguage.g:5035:3: rule__BooleanLiteralRule__Alternatives_1
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


    // $ANTLR start "rule__ClassDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:5044:1: rule__ClassDefinitionRule__Group__0 : rule__ClassDefinitionRule__Group__0__Impl rule__ClassDefinitionRule__Group__1 ;
    public final void rule__ClassDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5048:1: ( rule__ClassDefinitionRule__Group__0__Impl rule__ClassDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:5049:2: rule__ClassDefinitionRule__Group__0__Impl rule__ClassDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_48);
            rule__ClassDefinitionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__0"


    // $ANTLR start "rule__ClassDefinitionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:5056:1: rule__ClassDefinitionRule__Group__0__Impl : ( ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__ClassDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5060:1: ( ( ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:5061:1: ( ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:5061:1: ( ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalDefinitionLanguage.g:5062:2: ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:5063:2: ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==78) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:5063:3: rule__ClassDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__ClassDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__ClassDefinitionRule__Group__1"
    // InternalDefinitionLanguage.g:5071:1: rule__ClassDefinitionRule__Group__1 : rule__ClassDefinitionRule__Group__1__Impl rule__ClassDefinitionRule__Group__2 ;
    public final void rule__ClassDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5075:1: ( rule__ClassDefinitionRule__Group__1__Impl rule__ClassDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:5076:2: rule__ClassDefinitionRule__Group__1__Impl rule__ClassDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_48);
            rule__ClassDefinitionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__1"


    // $ANTLR start "rule__ClassDefinitionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:5083:1: rule__ClassDefinitionRule__Group__1__Impl : ( ( rule__ClassDefinitionRule__AbstractAssignment_1 )? ) ;
    public final void rule__ClassDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5087:1: ( ( ( rule__ClassDefinitionRule__AbstractAssignment_1 )? ) )
            // InternalDefinitionLanguage.g:5088:1: ( ( rule__ClassDefinitionRule__AbstractAssignment_1 )? )
            {
            // InternalDefinitionLanguage.g:5088:1: ( ( rule__ClassDefinitionRule__AbstractAssignment_1 )? )
            // InternalDefinitionLanguage.g:5089:2: ( rule__ClassDefinitionRule__AbstractAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getAbstractAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:5090:2: ( rule__ClassDefinitionRule__AbstractAssignment_1 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==93) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalDefinitionLanguage.g:5090:3: rule__ClassDefinitionRule__AbstractAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassDefinitionRule__AbstractAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getAbstractAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__ClassDefinitionRule__Group__2"
    // InternalDefinitionLanguage.g:5098:1: rule__ClassDefinitionRule__Group__2 : rule__ClassDefinitionRule__Group__2__Impl rule__ClassDefinitionRule__Group__3 ;
    public final void rule__ClassDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5102:1: ( rule__ClassDefinitionRule__Group__2__Impl rule__ClassDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:5103:2: rule__ClassDefinitionRule__Group__2__Impl rule__ClassDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__ClassDefinitionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__2"


    // $ANTLR start "rule__ClassDefinitionRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:5110:1: rule__ClassDefinitionRule__Group__2__Impl : ( 'type' ) ;
    public final void rule__ClassDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5114:1: ( ( 'type' ) )
            // InternalDefinitionLanguage.g:5115:1: ( 'type' )
            {
            // InternalDefinitionLanguage.g:5115:1: ( 'type' )
            // InternalDefinitionLanguage.g:5116:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getTypeKeyword_2()); 
            }
            match(input,76,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getTypeKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__ClassDefinitionRule__Group__3"
    // InternalDefinitionLanguage.g:5125:1: rule__ClassDefinitionRule__Group__3 : rule__ClassDefinitionRule__Group__3__Impl rule__ClassDefinitionRule__Group__4 ;
    public final void rule__ClassDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5129:1: ( rule__ClassDefinitionRule__Group__3__Impl rule__ClassDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:5130:2: rule__ClassDefinitionRule__Group__3__Impl rule__ClassDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_49);
            rule__ClassDefinitionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__3"


    // $ANTLR start "rule__ClassDefinitionRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:5137:1: rule__ClassDefinitionRule__Group__3__Impl : ( ( rule__ClassDefinitionRule__NameAssignment_3 ) ) ;
    public final void rule__ClassDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5141:1: ( ( ( rule__ClassDefinitionRule__NameAssignment_3 ) ) )
            // InternalDefinitionLanguage.g:5142:1: ( ( rule__ClassDefinitionRule__NameAssignment_3 ) )
            {
            // InternalDefinitionLanguage.g:5142:1: ( ( rule__ClassDefinitionRule__NameAssignment_3 ) )
            // InternalDefinitionLanguage.g:5143:2: ( rule__ClassDefinitionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDefinitionLanguage.g:5144:2: ( rule__ClassDefinitionRule__NameAssignment_3 )
            // InternalDefinitionLanguage.g:5144:3: rule__ClassDefinitionRule__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__ClassDefinitionRule__Group__4"
    // InternalDefinitionLanguage.g:5152:1: rule__ClassDefinitionRule__Group__4 : rule__ClassDefinitionRule__Group__4__Impl rule__ClassDefinitionRule__Group__5 ;
    public final void rule__ClassDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5156:1: ( rule__ClassDefinitionRule__Group__4__Impl rule__ClassDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:5157:2: rule__ClassDefinitionRule__Group__4__Impl rule__ClassDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_49);
            rule__ClassDefinitionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__4"


    // $ANTLR start "rule__ClassDefinitionRule__Group__4__Impl"
    // InternalDefinitionLanguage.g:5164:1: rule__ClassDefinitionRule__Group__4__Impl : ( ( rule__ClassDefinitionRule__Group_4__0 )? ) ;
    public final void rule__ClassDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5168:1: ( ( ( rule__ClassDefinitionRule__Group_4__0 )? ) )
            // InternalDefinitionLanguage.g:5169:1: ( ( rule__ClassDefinitionRule__Group_4__0 )? )
            {
            // InternalDefinitionLanguage.g:5169:1: ( ( rule__ClassDefinitionRule__Group_4__0 )? )
            // InternalDefinitionLanguage.g:5170:2: ( rule__ClassDefinitionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getGroup_4()); 
            }
            // InternalDefinitionLanguage.g:5171:2: ( rule__ClassDefinitionRule__Group_4__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==77) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalDefinitionLanguage.g:5171:3: rule__ClassDefinitionRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassDefinitionRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__4__Impl"


    // $ANTLR start "rule__ClassDefinitionRule__Group__5"
    // InternalDefinitionLanguage.g:5179:1: rule__ClassDefinitionRule__Group__5 : rule__ClassDefinitionRule__Group__5__Impl rule__ClassDefinitionRule__Group__6 ;
    public final void rule__ClassDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5183:1: ( rule__ClassDefinitionRule__Group__5__Impl rule__ClassDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:5184:2: rule__ClassDefinitionRule__Group__5__Impl rule__ClassDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_50);
            rule__ClassDefinitionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__5"


    // $ANTLR start "rule__ClassDefinitionRule__Group__5__Impl"
    // InternalDefinitionLanguage.g:5191:1: rule__ClassDefinitionRule__Group__5__Impl : ( '{' ) ;
    public final void rule__ClassDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5195:1: ( ( '{' ) )
            // InternalDefinitionLanguage.g:5196:1: ( '{' )
            {
            // InternalDefinitionLanguage.g:5196:1: ( '{' )
            // InternalDefinitionLanguage.g:5197:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getLeftCurlyBracketKeyword_5()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getLeftCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__5__Impl"


    // $ANTLR start "rule__ClassDefinitionRule__Group__6"
    // InternalDefinitionLanguage.g:5206:1: rule__ClassDefinitionRule__Group__6 : rule__ClassDefinitionRule__Group__6__Impl rule__ClassDefinitionRule__Group__7 ;
    public final void rule__ClassDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5210:1: ( rule__ClassDefinitionRule__Group__6__Impl rule__ClassDefinitionRule__Group__7 )
            // InternalDefinitionLanguage.g:5211:2: rule__ClassDefinitionRule__Group__6__Impl rule__ClassDefinitionRule__Group__7
            {
            pushFollow(FOLLOW_50);
            rule__ClassDefinitionRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__6"


    // $ANTLR start "rule__ClassDefinitionRule__Group__6__Impl"
    // InternalDefinitionLanguage.g:5218:1: rule__ClassDefinitionRule__Group__6__Impl : ( ( rule__ClassDefinitionRule__AttributesAssignment_6 )* ) ;
    public final void rule__ClassDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5222:1: ( ( ( rule__ClassDefinitionRule__AttributesAssignment_6 )* ) )
            // InternalDefinitionLanguage.g:5223:1: ( ( rule__ClassDefinitionRule__AttributesAssignment_6 )* )
            {
            // InternalDefinitionLanguage.g:5223:1: ( ( rule__ClassDefinitionRule__AttributesAssignment_6 )* )
            // InternalDefinitionLanguage.g:5224:2: ( rule__ClassDefinitionRule__AttributesAssignment_6 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getAttributesAssignment_6()); 
            }
            // InternalDefinitionLanguage.g:5225:2: ( rule__ClassDefinitionRule__AttributesAssignment_6 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=RULE_QUOTED_ID && LA43_0<=RULE_ID)||LA43_0==78) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:5225:3: rule__ClassDefinitionRule__AttributesAssignment_6
            	    {
            	    pushFollow(FOLLOW_51);
            	    rule__ClassDefinitionRule__AttributesAssignment_6();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getAttributesAssignment_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__6__Impl"


    // $ANTLR start "rule__ClassDefinitionRule__Group__7"
    // InternalDefinitionLanguage.g:5233:1: rule__ClassDefinitionRule__Group__7 : rule__ClassDefinitionRule__Group__7__Impl ;
    public final void rule__ClassDefinitionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5237:1: ( rule__ClassDefinitionRule__Group__7__Impl )
            // InternalDefinitionLanguage.g:5238:2: rule__ClassDefinitionRule__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__7"


    // $ANTLR start "rule__ClassDefinitionRule__Group__7__Impl"
    // InternalDefinitionLanguage.g:5244:1: rule__ClassDefinitionRule__Group__7__Impl : ( '}' ) ;
    public final void rule__ClassDefinitionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5248:1: ( ( '}' ) )
            // InternalDefinitionLanguage.g:5249:1: ( '}' )
            {
            // InternalDefinitionLanguage.g:5249:1: ( '}' )
            // InternalDefinitionLanguage.g:5250:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getRightCurlyBracketKeyword_7()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getRightCurlyBracketKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group__7__Impl"


    // $ANTLR start "rule__ClassDefinitionRule__Group_4__0"
    // InternalDefinitionLanguage.g:5260:1: rule__ClassDefinitionRule__Group_4__0 : rule__ClassDefinitionRule__Group_4__0__Impl rule__ClassDefinitionRule__Group_4__1 ;
    public final void rule__ClassDefinitionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5264:1: ( rule__ClassDefinitionRule__Group_4__0__Impl rule__ClassDefinitionRule__Group_4__1 )
            // InternalDefinitionLanguage.g:5265:2: rule__ClassDefinitionRule__Group_4__0__Impl rule__ClassDefinitionRule__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__ClassDefinitionRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group_4__0"


    // $ANTLR start "rule__ClassDefinitionRule__Group_4__0__Impl"
    // InternalDefinitionLanguage.g:5272:1: rule__ClassDefinitionRule__Group_4__0__Impl : ( 'extends' ) ;
    public final void rule__ClassDefinitionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5276:1: ( ( 'extends' ) )
            // InternalDefinitionLanguage.g:5277:1: ( 'extends' )
            {
            // InternalDefinitionLanguage.g:5277:1: ( 'extends' )
            // InternalDefinitionLanguage.g:5278:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getExtendsKeyword_4_0()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getExtendsKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group_4__0__Impl"


    // $ANTLR start "rule__ClassDefinitionRule__Group_4__1"
    // InternalDefinitionLanguage.g:5287:1: rule__ClassDefinitionRule__Group_4__1 : rule__ClassDefinitionRule__Group_4__1__Impl ;
    public final void rule__ClassDefinitionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5291:1: ( rule__ClassDefinitionRule__Group_4__1__Impl )
            // InternalDefinitionLanguage.g:5292:2: rule__ClassDefinitionRule__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group_4__1"


    // $ANTLR start "rule__ClassDefinitionRule__Group_4__1__Impl"
    // InternalDefinitionLanguage.g:5298:1: rule__ClassDefinitionRule__Group_4__1__Impl : ( ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 ) ) ;
    public final void rule__ClassDefinitionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5302:1: ( ( ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 ) ) )
            // InternalDefinitionLanguage.g:5303:1: ( ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 ) )
            {
            // InternalDefinitionLanguage.g:5303:1: ( ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 ) )
            // InternalDefinitionLanguage.g:5304:2: ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getSuperTypeAssignment_4_1()); 
            }
            // InternalDefinitionLanguage.g:5305:2: ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 )
            // InternalDefinitionLanguage.g:5305:3: rule__ClassDefinitionRule__SuperTypeAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassDefinitionRule__SuperTypeAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getSuperTypeAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__Group_4__1__Impl"


    // $ANTLR start "rule__ConstraintRule__Group__0"
    // InternalDefinitionLanguage.g:5314:1: rule__ConstraintRule__Group__0 : rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 ;
    public final void rule__ConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5318:1: ( rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 )
            // InternalDefinitionLanguage.g:5319:2: rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1
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
    // InternalDefinitionLanguage.g:5326:1: rule__ConstraintRule__Group__0__Impl : ( '@' ) ;
    public final void rule__ConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5330:1: ( ( '@' ) )
            // InternalDefinitionLanguage.g:5331:1: ( '@' )
            {
            // InternalDefinitionLanguage.g:5331:1: ( '@' )
            // InternalDefinitionLanguage.g:5332:2: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleAccess().getCommercialAtKeyword_0()); 
            }
            match(input,78,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5341:1: rule__ConstraintRule__Group__1 : rule__ConstraintRule__Group__1__Impl ;
    public final void rule__ConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5345:1: ( rule__ConstraintRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5346:2: rule__ConstraintRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5352:1: rule__ConstraintRule__Group__1__Impl : ( ruleInstanceLiteralRule ) ;
    public final void rule__ConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5356:1: ( ( ruleInstanceLiteralRule ) )
            // InternalDefinitionLanguage.g:5357:1: ( ruleInstanceLiteralRule )
            {
            // InternalDefinitionLanguage.g:5357:1: ( ruleInstanceLiteralRule )
            // InternalDefinitionLanguage.g:5358:2: ruleInstanceLiteralRule
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
    // InternalDefinitionLanguage.g:5368:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5372:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:5373:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalDefinitionLanguage.g:5380:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5384:1: ( ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:5385:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:5385:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalDefinitionLanguage.g:5386:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:5387:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==78) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:5387:3: rule__AttributeDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__AttributeDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
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
    // InternalDefinitionLanguage.g:5395:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5399:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:5400:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalDefinitionLanguage.g:5407:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5411:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:5412:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:5412:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            // InternalDefinitionLanguage.g:5413:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:5414:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            // InternalDefinitionLanguage.g:5414:3: rule__AttributeDefinitionRule__NameAssignment_1
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
    // InternalDefinitionLanguage.g:5422:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5426:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:5427:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_54);
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
    // InternalDefinitionLanguage.g:5434:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5438:1: ( ( ':' ) )
            // InternalDefinitionLanguage.g:5439:1: ( ':' )
            {
            // InternalDefinitionLanguage.g:5439:1: ( ':' )
            // InternalDefinitionLanguage.g:5440:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5449:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5453:1: ( rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:5454:2: rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4
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
    // InternalDefinitionLanguage.g:5461:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5465:1: ( ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? ) )
            // InternalDefinitionLanguage.g:5466:1: ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? )
            {
            // InternalDefinitionLanguage.g:5466:1: ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? )
            // InternalDefinitionLanguage.g:5467:2: ( rule__AttributeDefinitionRule__OptionalAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalAssignment_3()); 
            }
            // InternalDefinitionLanguage.g:5468:2: ( rule__AttributeDefinitionRule__OptionalAssignment_3 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==94) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalDefinitionLanguage.g:5468:3: rule__AttributeDefinitionRule__OptionalAssignment_3
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
    // InternalDefinitionLanguage.g:5476:1: rule__AttributeDefinitionRule__Group__4 : rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 ;
    public final void rule__AttributeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5480:1: ( rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:5481:2: rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_55);
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
    // InternalDefinitionLanguage.g:5488:1: rule__AttributeDefinitionRule__Group__4__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5492:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) ) )
            // InternalDefinitionLanguage.g:5493:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) )
            {
            // InternalDefinitionLanguage.g:5493:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) )
            // InternalDefinitionLanguage.g:5494:2: ( rule__AttributeDefinitionRule__TypeAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_4()); 
            }
            // InternalDefinitionLanguage.g:5495:2: ( rule__AttributeDefinitionRule__TypeAssignment_4 )
            // InternalDefinitionLanguage.g:5495:3: rule__AttributeDefinitionRule__TypeAssignment_4
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
    // InternalDefinitionLanguage.g:5503:1: rule__AttributeDefinitionRule__Group__5 : rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6 ;
    public final void rule__AttributeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5507:1: ( rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:5508:2: rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_55);
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
    // InternalDefinitionLanguage.g:5515:1: rule__AttributeDefinitionRule__Group__5__Impl : ( ( rule__AttributeDefinitionRule__Group_5__0 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5519:1: ( ( ( rule__AttributeDefinitionRule__Group_5__0 )? ) )
            // InternalDefinitionLanguage.g:5520:1: ( ( rule__AttributeDefinitionRule__Group_5__0 )? )
            {
            // InternalDefinitionLanguage.g:5520:1: ( ( rule__AttributeDefinitionRule__Group_5__0 )? )
            // InternalDefinitionLanguage.g:5521:2: ( rule__AttributeDefinitionRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_5()); 
            }
            // InternalDefinitionLanguage.g:5522:2: ( rule__AttributeDefinitionRule__Group_5__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==75) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalDefinitionLanguage.g:5522:3: rule__AttributeDefinitionRule__Group_5__0
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
    // InternalDefinitionLanguage.g:5530:1: rule__AttributeDefinitionRule__Group__6 : rule__AttributeDefinitionRule__Group__6__Impl ;
    public final void rule__AttributeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5534:1: ( rule__AttributeDefinitionRule__Group__6__Impl )
            // InternalDefinitionLanguage.g:5535:2: rule__AttributeDefinitionRule__Group__6__Impl
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
    // InternalDefinitionLanguage.g:5541:1: rule__AttributeDefinitionRule__Group__6__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5545:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:5546:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:5546:1: ( ';' )
            // InternalDefinitionLanguage.g:5547:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_6()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5557:1: rule__AttributeDefinitionRule__Group_5__0 : rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1 ;
    public final void rule__AttributeDefinitionRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5561:1: ( rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1 )
            // InternalDefinitionLanguage.g:5562:2: rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:5569:1: rule__AttributeDefinitionRule__Group_5__0__Impl : ( ':=' ) ;
    public final void rule__AttributeDefinitionRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5573:1: ( ( ':=' ) )
            // InternalDefinitionLanguage.g:5574:1: ( ':=' )
            {
            // InternalDefinitionLanguage.g:5574:1: ( ':=' )
            // InternalDefinitionLanguage.g:5575:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_5_0()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5584:1: rule__AttributeDefinitionRule__Group_5__1 : rule__AttributeDefinitionRule__Group_5__1__Impl ;
    public final void rule__AttributeDefinitionRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5588:1: ( rule__AttributeDefinitionRule__Group_5__1__Impl )
            // InternalDefinitionLanguage.g:5589:2: rule__AttributeDefinitionRule__Group_5__1__Impl
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
    // InternalDefinitionLanguage.g:5595:1: rule__AttributeDefinitionRule__Group_5__1__Impl : ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5599:1: ( ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) ) )
            // InternalDefinitionLanguage.g:5600:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) )
            {
            // InternalDefinitionLanguage.g:5600:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) )
            // InternalDefinitionLanguage.g:5601:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_5_1()); 
            }
            // InternalDefinitionLanguage.g:5602:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 )
            // InternalDefinitionLanguage.g:5602:3: rule__AttributeDefinitionRule__InitialisationAssignment_5_1
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
    // InternalDefinitionLanguage.g:5611:1: rule__EnumReferenceRule__Group__0 : rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1 ;
    public final void rule__EnumReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5615:1: ( rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:5616:2: rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1
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
    // InternalDefinitionLanguage.g:5623:1: rule__EnumReferenceRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5627:1: ( ( 'enum' ) )
            // InternalDefinitionLanguage.g:5628:1: ( 'enum' )
            {
            // InternalDefinitionLanguage.g:5628:1: ( 'enum' )
            // InternalDefinitionLanguage.g:5629:2: 'enum'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getEnumKeyword_0()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5638:1: rule__EnumReferenceRule__Group__1 : rule__EnumReferenceRule__Group__1__Impl ;
    public final void rule__EnumReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5642:1: ( rule__EnumReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5643:2: rule__EnumReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5649:1: rule__EnumReferenceRule__Group__1__Impl : ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__EnumReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5653:1: ( ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:5654:1: ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:5654:1: ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) )
            // InternalDefinitionLanguage.g:5655:2: ( rule__EnumReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:5656:2: ( rule__EnumReferenceRule__DefinitionAssignment_1 )
            // InternalDefinitionLanguage.g:5656:3: rule__EnumReferenceRule__DefinitionAssignment_1
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
    // InternalDefinitionLanguage.g:5665:1: rule__TypeReferenceRule__Group__0 : rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1 ;
    public final void rule__TypeReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5669:1: ( rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:5670:2: rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1
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
    // InternalDefinitionLanguage.g:5677:1: rule__TypeReferenceRule__Group__0__Impl : ( 'instance' ) ;
    public final void rule__TypeReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5681:1: ( ( 'instance' ) )
            // InternalDefinitionLanguage.g:5682:1: ( 'instance' )
            {
            // InternalDefinitionLanguage.g:5682:1: ( 'instance' )
            // InternalDefinitionLanguage.g:5683:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getInstanceKeyword_0()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5692:1: rule__TypeReferenceRule__Group__1 : rule__TypeReferenceRule__Group__1__Impl ;
    public final void rule__TypeReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5696:1: ( rule__TypeReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5697:2: rule__TypeReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5703:1: rule__TypeReferenceRule__Group__1__Impl : ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__TypeReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5707:1: ( ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:5708:1: ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:5708:1: ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) )
            // InternalDefinitionLanguage.g:5709:2: ( rule__TypeReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:5710:2: ( rule__TypeReferenceRule__DefinitionAssignment_1 )
            // InternalDefinitionLanguage.g:5710:3: rule__TypeReferenceRule__DefinitionAssignment_1
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
    // InternalDefinitionLanguage.g:5719:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5723:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5724:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
            {
            pushFollow(FOLLOW_56);
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
    // InternalDefinitionLanguage.g:5731:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5735:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5736:1: ( () )
            {
            // InternalDefinitionLanguage.g:5736:1: ( () )
            // InternalDefinitionLanguage.g:5737:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5738:2: ()
            // InternalDefinitionLanguage.g:5738:3: 
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
    // InternalDefinitionLanguage.g:5746:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5750:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5751:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5757:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5761:1: ( ( 'literal' ) )
            // InternalDefinitionLanguage.g:5762:1: ( 'literal' )
            {
            // InternalDefinitionLanguage.g:5762:1: ( 'literal' )
            // InternalDefinitionLanguage.g:5763:2: 'literal'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            }
            match(input,79,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5773:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5777:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5778:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_57);
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
    // InternalDefinitionLanguage.g:5785:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5789:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5790:1: ( () )
            {
            // InternalDefinitionLanguage.g:5790:1: ( () )
            // InternalDefinitionLanguage.g:5791:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5792:2: ()
            // InternalDefinitionLanguage.g:5792:3: 
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
    // InternalDefinitionLanguage.g:5800:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5804:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5805:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5811:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5815:1: ( ( 'data' ) )
            // InternalDefinitionLanguage.g:5816:1: ( 'data' )
            {
            // InternalDefinitionLanguage.g:5816:1: ( 'data' )
            // InternalDefinitionLanguage.g:5817:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__PathTypeRule__Group__0"
    // InternalDefinitionLanguage.g:5827:1: rule__PathTypeRule__Group__0 : rule__PathTypeRule__Group__0__Impl rule__PathTypeRule__Group__1 ;
    public final void rule__PathTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5831:1: ( rule__PathTypeRule__Group__0__Impl rule__PathTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5832:2: rule__PathTypeRule__Group__0__Impl rule__PathTypeRule__Group__1
            {
            pushFollow(FOLLOW_54);
            rule__PathTypeRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PathTypeRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathTypeRule__Group__0"


    // $ANTLR start "rule__PathTypeRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:5839:1: rule__PathTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__PathTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5843:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5844:1: ( () )
            {
            // InternalDefinitionLanguage.g:5844:1: ( () )
            // InternalDefinitionLanguage.g:5845:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeRuleAccess().getPathTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5846:2: ()
            // InternalDefinitionLanguage.g:5846:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeRuleAccess().getPathTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathTypeRule__Group__0__Impl"


    // $ANTLR start "rule__PathTypeRule__Group__1"
    // InternalDefinitionLanguage.g:5854:1: rule__PathTypeRule__Group__1 : rule__PathTypeRule__Group__1__Impl ;
    public final void rule__PathTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5858:1: ( rule__PathTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5859:2: rule__PathTypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PathTypeRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathTypeRule__Group__1"


    // $ANTLR start "rule__PathTypeRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:5865:1: rule__PathTypeRule__Group__1__Impl : ( 'path' ) ;
    public final void rule__PathTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5869:1: ( ( 'path' ) )
            // InternalDefinitionLanguage.g:5870:1: ( 'path' )
            {
            // InternalDefinitionLanguage.g:5870:1: ( 'path' )
            // InternalDefinitionLanguage.g:5871:2: 'path'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeRuleAccess().getPathKeyword_1()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeRuleAccess().getPathKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathTypeRule__Group__1__Impl"


    // $ANTLR start "rule__StringTypeRule__Group__0"
    // InternalDefinitionLanguage.g:5881:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5885:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5886:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_58);
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
    // InternalDefinitionLanguage.g:5893:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5897:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5898:1: ( () )
            {
            // InternalDefinitionLanguage.g:5898:1: ( () )
            // InternalDefinitionLanguage.g:5899:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5900:2: ()
            // InternalDefinitionLanguage.g:5900:3: 
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
    // InternalDefinitionLanguage.g:5908:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5912:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5913:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5919:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5923:1: ( ( 'string' ) )
            // InternalDefinitionLanguage.g:5924:1: ( 'string' )
            {
            // InternalDefinitionLanguage.g:5924:1: ( 'string' )
            // InternalDefinitionLanguage.g:5925:2: 'string'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            }
            match(input,80,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5935:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5939:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5940:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_59);
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
    // InternalDefinitionLanguage.g:5947:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5951:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5952:1: ( () )
            {
            // InternalDefinitionLanguage.g:5952:1: ( () )
            // InternalDefinitionLanguage.g:5953:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5954:2: ()
            // InternalDefinitionLanguage.g:5954:3: 
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
    // InternalDefinitionLanguage.g:5962:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5966:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5967:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5973:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5977:1: ( ( 'expression' ) )
            // InternalDefinitionLanguage.g:5978:1: ( 'expression' )
            {
            // InternalDefinitionLanguage.g:5978:1: ( 'expression' )
            // InternalDefinitionLanguage.g:5979:2: 'expression'
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
    // InternalDefinitionLanguage.g:5989:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5993:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5994:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_60);
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
    // InternalDefinitionLanguage.g:6001:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6005:1: ( ( () ) )
            // InternalDefinitionLanguage.g:6006:1: ( () )
            {
            // InternalDefinitionLanguage.g:6006:1: ( () )
            // InternalDefinitionLanguage.g:6007:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:6008:2: ()
            // InternalDefinitionLanguage.g:6008:3: 
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
    // InternalDefinitionLanguage.g:6016:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6020:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:6021:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:6027:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6031:1: ( ( 'int' ) )
            // InternalDefinitionLanguage.g:6032:1: ( 'int' )
            {
            // InternalDefinitionLanguage.g:6032:1: ( 'int' )
            // InternalDefinitionLanguage.g:6033:2: 'int'
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
    // InternalDefinitionLanguage.g:6043:1: rule__RealTypeRule__Group__0 : rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 ;
    public final void rule__RealTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6047:1: ( rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:6048:2: rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1
            {
            pushFollow(FOLLOW_61);
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
    // InternalDefinitionLanguage.g:6055:1: rule__RealTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__RealTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6059:1: ( ( () ) )
            // InternalDefinitionLanguage.g:6060:1: ( () )
            {
            // InternalDefinitionLanguage.g:6060:1: ( () )
            // InternalDefinitionLanguage.g:6061:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:6062:2: ()
            // InternalDefinitionLanguage.g:6062:3: 
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
    // InternalDefinitionLanguage.g:6070:1: rule__RealTypeRule__Group__1 : rule__RealTypeRule__Group__1__Impl ;
    public final void rule__RealTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6074:1: ( rule__RealTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:6075:2: rule__RealTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:6081:1: rule__RealTypeRule__Group__1__Impl : ( 'real' ) ;
    public final void rule__RealTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6085:1: ( ( 'real' ) )
            // InternalDefinitionLanguage.g:6086:1: ( 'real' )
            {
            // InternalDefinitionLanguage.g:6086:1: ( 'real' )
            // InternalDefinitionLanguage.g:6087:2: 'real'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealKeyword_1()); 
            }
            match(input,83,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6097:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6101:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:6102:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_62);
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
    // InternalDefinitionLanguage.g:6109:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6113:1: ( ( () ) )
            // InternalDefinitionLanguage.g:6114:1: ( () )
            {
            // InternalDefinitionLanguage.g:6114:1: ( () )
            // InternalDefinitionLanguage.g:6115:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:6116:2: ()
            // InternalDefinitionLanguage.g:6116:3: 
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
    // InternalDefinitionLanguage.g:6124:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6128:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:6129:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:6135:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6139:1: ( ( 'boolean' ) )
            // InternalDefinitionLanguage.g:6140:1: ( 'boolean' )
            {
            // InternalDefinitionLanguage.g:6140:1: ( 'boolean' )
            // InternalDefinitionLanguage.g:6141:2: 'boolean'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            }
            match(input,84,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6151:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6155:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:6156:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_63);
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
    // InternalDefinitionLanguage.g:6163:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6167:1: ( ( () ) )
            // InternalDefinitionLanguage.g:6168:1: ( () )
            {
            // InternalDefinitionLanguage.g:6168:1: ( () )
            // InternalDefinitionLanguage.g:6169:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:6170:2: ()
            // InternalDefinitionLanguage.g:6170:3: 
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
    // InternalDefinitionLanguage.g:6178:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6182:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:6183:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:6189:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6193:1: ( ( 'void' ) )
            // InternalDefinitionLanguage.g:6194:1: ( 'void' )
            {
            // InternalDefinitionLanguage.g:6194:1: ( 'void' )
            // InternalDefinitionLanguage.g:6195:2: 'void'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            }
            match(input,85,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6205:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6209:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:6210:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
            {
            pushFollow(FOLLOW_54);
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
    // InternalDefinitionLanguage.g:6217:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6221:1: ( ( 'array' ) )
            // InternalDefinitionLanguage.g:6222:1: ( 'array' )
            {
            // InternalDefinitionLanguage.g:6222:1: ( 'array' )
            // InternalDefinitionLanguage.g:6223:2: 'array'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            }
            match(input,86,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6232:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6236:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:6237:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:6243:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6247:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:6248:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:6248:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalDefinitionLanguage.g:6249:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:6250:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalDefinitionLanguage.g:6250:3: rule__ArrayTypeRule__ElementsAssignment_1
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


    // $ANTLR start "rule__FunctionDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:6259:1: rule__FunctionDefinitionRule__Group__0 : rule__FunctionDefinitionRule__Group__0__Impl rule__FunctionDefinitionRule__Group__1 ;
    public final void rule__FunctionDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6263:1: ( rule__FunctionDefinitionRule__Group__0__Impl rule__FunctionDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:6264:2: rule__FunctionDefinitionRule__Group__0__Impl rule__FunctionDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_64);
            rule__FunctionDefinitionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__0"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:6271:1: rule__FunctionDefinitionRule__Group__0__Impl : ( ( rule__FunctionDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__FunctionDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6275:1: ( ( ( rule__FunctionDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:6276:1: ( ( rule__FunctionDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:6276:1: ( ( rule__FunctionDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalDefinitionLanguage.g:6277:2: ( rule__FunctionDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:6278:2: ( rule__FunctionDefinitionRule__ConstraintsAssignment_0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==78) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:6278:3: rule__FunctionDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__FunctionDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__1"
    // InternalDefinitionLanguage.g:6286:1: rule__FunctionDefinitionRule__Group__1 : rule__FunctionDefinitionRule__Group__1__Impl rule__FunctionDefinitionRule__Group__2 ;
    public final void rule__FunctionDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6290:1: ( rule__FunctionDefinitionRule__Group__1__Impl rule__FunctionDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:6291:2: rule__FunctionDefinitionRule__Group__1__Impl rule__FunctionDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_54);
            rule__FunctionDefinitionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__1"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:6298:1: rule__FunctionDefinitionRule__Group__1__Impl : ( 'def' ) ;
    public final void rule__FunctionDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6302:1: ( ( 'def' ) )
            // InternalDefinitionLanguage.g:6303:1: ( 'def' )
            {
            // InternalDefinitionLanguage.g:6303:1: ( 'def' )
            // InternalDefinitionLanguage.g:6304:2: 'def'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getDefKeyword_1()); 
            }
            match(input,87,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getDefKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__2"
    // InternalDefinitionLanguage.g:6313:1: rule__FunctionDefinitionRule__Group__2 : rule__FunctionDefinitionRule__Group__2__Impl rule__FunctionDefinitionRule__Group__3 ;
    public final void rule__FunctionDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6317:1: ( rule__FunctionDefinitionRule__Group__2__Impl rule__FunctionDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:6318:2: rule__FunctionDefinitionRule__Group__2__Impl rule__FunctionDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__FunctionDefinitionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__2"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:6325:1: rule__FunctionDefinitionRule__Group__2__Impl : ( ( rule__FunctionDefinitionRule__TypeAssignment_2 ) ) ;
    public final void rule__FunctionDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6329:1: ( ( ( rule__FunctionDefinitionRule__TypeAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:6330:1: ( ( rule__FunctionDefinitionRule__TypeAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:6330:1: ( ( rule__FunctionDefinitionRule__TypeAssignment_2 ) )
            // InternalDefinitionLanguage.g:6331:2: ( rule__FunctionDefinitionRule__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getTypeAssignment_2()); 
            }
            // InternalDefinitionLanguage.g:6332:2: ( rule__FunctionDefinitionRule__TypeAssignment_2 )
            // InternalDefinitionLanguage.g:6332:3: rule__FunctionDefinitionRule__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__TypeAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getTypeAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__3"
    // InternalDefinitionLanguage.g:6340:1: rule__FunctionDefinitionRule__Group__3 : rule__FunctionDefinitionRule__Group__3__Impl rule__FunctionDefinitionRule__Group__4 ;
    public final void rule__FunctionDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6344:1: ( rule__FunctionDefinitionRule__Group__3__Impl rule__FunctionDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:6345:2: rule__FunctionDefinitionRule__Group__3__Impl rule__FunctionDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__FunctionDefinitionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__3"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:6352:1: rule__FunctionDefinitionRule__Group__3__Impl : ( ( rule__FunctionDefinitionRule__NameAssignment_3 ) ) ;
    public final void rule__FunctionDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6356:1: ( ( ( rule__FunctionDefinitionRule__NameAssignment_3 ) ) )
            // InternalDefinitionLanguage.g:6357:1: ( ( rule__FunctionDefinitionRule__NameAssignment_3 ) )
            {
            // InternalDefinitionLanguage.g:6357:1: ( ( rule__FunctionDefinitionRule__NameAssignment_3 ) )
            // InternalDefinitionLanguage.g:6358:2: ( rule__FunctionDefinitionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDefinitionLanguage.g:6359:2: ( rule__FunctionDefinitionRule__NameAssignment_3 )
            // InternalDefinitionLanguage.g:6359:3: rule__FunctionDefinitionRule__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__4"
    // InternalDefinitionLanguage.g:6367:1: rule__FunctionDefinitionRule__Group__4 : rule__FunctionDefinitionRule__Group__4__Impl rule__FunctionDefinitionRule__Group__5 ;
    public final void rule__FunctionDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6371:1: ( rule__FunctionDefinitionRule__Group__4__Impl rule__FunctionDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:6372:2: rule__FunctionDefinitionRule__Group__4__Impl rule__FunctionDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_65);
            rule__FunctionDefinitionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__4"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__4__Impl"
    // InternalDefinitionLanguage.g:6379:1: rule__FunctionDefinitionRule__Group__4__Impl : ( '(' ) ;
    public final void rule__FunctionDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6383:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:6384:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:6384:1: ( '(' )
            // InternalDefinitionLanguage.g:6385:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getLeftParenthesisKeyword_4()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getLeftParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__4__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__5"
    // InternalDefinitionLanguage.g:6394:1: rule__FunctionDefinitionRule__Group__5 : rule__FunctionDefinitionRule__Group__5__Impl rule__FunctionDefinitionRule__Group__6 ;
    public final void rule__FunctionDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6398:1: ( rule__FunctionDefinitionRule__Group__5__Impl rule__FunctionDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:6399:2: rule__FunctionDefinitionRule__Group__5__Impl rule__FunctionDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_65);
            rule__FunctionDefinitionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__5"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__5__Impl"
    // InternalDefinitionLanguage.g:6406:1: rule__FunctionDefinitionRule__Group__5__Impl : ( ( rule__FunctionDefinitionRule__Group_5__0 )? ) ;
    public final void rule__FunctionDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6410:1: ( ( ( rule__FunctionDefinitionRule__Group_5__0 )? ) )
            // InternalDefinitionLanguage.g:6411:1: ( ( rule__FunctionDefinitionRule__Group_5__0 )? )
            {
            // InternalDefinitionLanguage.g:6411:1: ( ( rule__FunctionDefinitionRule__Group_5__0 )? )
            // InternalDefinitionLanguage.g:6412:2: ( rule__FunctionDefinitionRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_5()); 
            }
            // InternalDefinitionLanguage.g:6413:2: ( rule__FunctionDefinitionRule__Group_5__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==54||LA48_0==68||(LA48_0>=73 && LA48_0<=74)||(LA48_0>=79 && LA48_0<=86)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalDefinitionLanguage.g:6413:3: rule__FunctionDefinitionRule__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FunctionDefinitionRule__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__5__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__6"
    // InternalDefinitionLanguage.g:6421:1: rule__FunctionDefinitionRule__Group__6 : rule__FunctionDefinitionRule__Group__6__Impl rule__FunctionDefinitionRule__Group__7 ;
    public final void rule__FunctionDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6425:1: ( rule__FunctionDefinitionRule__Group__6__Impl rule__FunctionDefinitionRule__Group__7 )
            // InternalDefinitionLanguage.g:6426:2: rule__FunctionDefinitionRule__Group__6__Impl rule__FunctionDefinitionRule__Group__7
            {
            pushFollow(FOLLOW_20);
            rule__FunctionDefinitionRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__6"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__6__Impl"
    // InternalDefinitionLanguage.g:6433:1: rule__FunctionDefinitionRule__Group__6__Impl : ( ')' ) ;
    public final void rule__FunctionDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6437:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:6438:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:6438:1: ( ')' )
            // InternalDefinitionLanguage.g:6439:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getRightParenthesisKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__6__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__7"
    // InternalDefinitionLanguage.g:6448:1: rule__FunctionDefinitionRule__Group__7 : rule__FunctionDefinitionRule__Group__7__Impl ;
    public final void rule__FunctionDefinitionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6452:1: ( rule__FunctionDefinitionRule__Group__7__Impl )
            // InternalDefinitionLanguage.g:6453:2: rule__FunctionDefinitionRule__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__7"


    // $ANTLR start "rule__FunctionDefinitionRule__Group__7__Impl"
    // InternalDefinitionLanguage.g:6459:1: rule__FunctionDefinitionRule__Group__7__Impl : ( ';' ) ;
    public final void rule__FunctionDefinitionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6463:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:6464:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:6464:1: ( ';' )
            // InternalDefinitionLanguage.g:6465:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getSemicolonKeyword_7()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getSemicolonKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group__7__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_5__0"
    // InternalDefinitionLanguage.g:6475:1: rule__FunctionDefinitionRule__Group_5__0 : rule__FunctionDefinitionRule__Group_5__0__Impl rule__FunctionDefinitionRule__Group_5__1 ;
    public final void rule__FunctionDefinitionRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6479:1: ( rule__FunctionDefinitionRule__Group_5__0__Impl rule__FunctionDefinitionRule__Group_5__1 )
            // InternalDefinitionLanguage.g:6480:2: rule__FunctionDefinitionRule__Group_5__0__Impl rule__FunctionDefinitionRule__Group_5__1
            {
            pushFollow(FOLLOW_36);
            rule__FunctionDefinitionRule__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_5__0"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_5__0__Impl"
    // InternalDefinitionLanguage.g:6487:1: rule__FunctionDefinitionRule__Group_5__0__Impl : ( ( rule__FunctionDefinitionRule__ParametersAssignment_5_0 ) ) ;
    public final void rule__FunctionDefinitionRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6491:1: ( ( ( rule__FunctionDefinitionRule__ParametersAssignment_5_0 ) ) )
            // InternalDefinitionLanguage.g:6492:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_5_0 ) )
            {
            // InternalDefinitionLanguage.g:6492:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_5_0 ) )
            // InternalDefinitionLanguage.g:6493:2: ( rule__FunctionDefinitionRule__ParametersAssignment_5_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_5_0()); 
            }
            // InternalDefinitionLanguage.g:6494:2: ( rule__FunctionDefinitionRule__ParametersAssignment_5_0 )
            // InternalDefinitionLanguage.g:6494:3: rule__FunctionDefinitionRule__ParametersAssignment_5_0
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__ParametersAssignment_5_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_5__0__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_5__1"
    // InternalDefinitionLanguage.g:6502:1: rule__FunctionDefinitionRule__Group_5__1 : rule__FunctionDefinitionRule__Group_5__1__Impl ;
    public final void rule__FunctionDefinitionRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6506:1: ( rule__FunctionDefinitionRule__Group_5__1__Impl )
            // InternalDefinitionLanguage.g:6507:2: rule__FunctionDefinitionRule__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_5__1"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_5__1__Impl"
    // InternalDefinitionLanguage.g:6513:1: rule__FunctionDefinitionRule__Group_5__1__Impl : ( ( rule__FunctionDefinitionRule__Group_5_1__0 )* ) ;
    public final void rule__FunctionDefinitionRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6517:1: ( ( ( rule__FunctionDefinitionRule__Group_5_1__0 )* ) )
            // InternalDefinitionLanguage.g:6518:1: ( ( rule__FunctionDefinitionRule__Group_5_1__0 )* )
            {
            // InternalDefinitionLanguage.g:6518:1: ( ( rule__FunctionDefinitionRule__Group_5_1__0 )* )
            // InternalDefinitionLanguage.g:6519:2: ( rule__FunctionDefinitionRule__Group_5_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_5_1()); 
            }
            // InternalDefinitionLanguage.g:6520:2: ( rule__FunctionDefinitionRule__Group_5_1__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==58) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:6520:3: rule__FunctionDefinitionRule__Group_5_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__FunctionDefinitionRule__Group_5_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_5__1__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_5_1__0"
    // InternalDefinitionLanguage.g:6529:1: rule__FunctionDefinitionRule__Group_5_1__0 : rule__FunctionDefinitionRule__Group_5_1__0__Impl rule__FunctionDefinitionRule__Group_5_1__1 ;
    public final void rule__FunctionDefinitionRule__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6533:1: ( rule__FunctionDefinitionRule__Group_5_1__0__Impl rule__FunctionDefinitionRule__Group_5_1__1 )
            // InternalDefinitionLanguage.g:6534:2: rule__FunctionDefinitionRule__Group_5_1__0__Impl rule__FunctionDefinitionRule__Group_5_1__1
            {
            pushFollow(FOLLOW_54);
            rule__FunctionDefinitionRule__Group_5_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_5_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_5_1__0"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_5_1__0__Impl"
    // InternalDefinitionLanguage.g:6541:1: rule__FunctionDefinitionRule__Group_5_1__0__Impl : ( ',' ) ;
    public final void rule__FunctionDefinitionRule__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6545:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:6546:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:6546:1: ( ',' )
            // InternalDefinitionLanguage.g:6547:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getCommaKeyword_5_1_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getCommaKeyword_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_5_1__0__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_5_1__1"
    // InternalDefinitionLanguage.g:6556:1: rule__FunctionDefinitionRule__Group_5_1__1 : rule__FunctionDefinitionRule__Group_5_1__1__Impl ;
    public final void rule__FunctionDefinitionRule__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6560:1: ( rule__FunctionDefinitionRule__Group_5_1__1__Impl )
            // InternalDefinitionLanguage.g:6561:2: rule__FunctionDefinitionRule__Group_5_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_5_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_5_1__1"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_5_1__1__Impl"
    // InternalDefinitionLanguage.g:6567:1: rule__FunctionDefinitionRule__Group_5_1__1__Impl : ( ( rule__FunctionDefinitionRule__ParametersAssignment_5_1_1 ) ) ;
    public final void rule__FunctionDefinitionRule__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6571:1: ( ( ( rule__FunctionDefinitionRule__ParametersAssignment_5_1_1 ) ) )
            // InternalDefinitionLanguage.g:6572:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_5_1_1 ) )
            {
            // InternalDefinitionLanguage.g:6572:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_5_1_1 ) )
            // InternalDefinitionLanguage.g:6573:2: ( rule__FunctionDefinitionRule__ParametersAssignment_5_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_5_1_1()); 
            }
            // InternalDefinitionLanguage.g:6574:2: ( rule__FunctionDefinitionRule__ParametersAssignment_5_1_1 )
            // InternalDefinitionLanguage.g:6574:3: rule__FunctionDefinitionRule__ParametersAssignment_5_1_1
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__ParametersAssignment_5_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_5_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_5_1__1__Impl"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:6583:1: rule__ConstantDefinitionRule__Group__0 : rule__ConstantDefinitionRule__Group__0__Impl rule__ConstantDefinitionRule__Group__1 ;
    public final void rule__ConstantDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6587:1: ( rule__ConstantDefinitionRule__Group__0__Impl rule__ConstantDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:6588:2: rule__ConstantDefinitionRule__Group__0__Impl rule__ConstantDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_54);
            rule__ConstantDefinitionRule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConstantDefinitionRule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__0"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:6595:1: rule__ConstantDefinitionRule__Group__0__Impl : ( 'const' ) ;
    public final void rule__ConstantDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6599:1: ( ( 'const' ) )
            // InternalDefinitionLanguage.g:6600:1: ( 'const' )
            {
            // InternalDefinitionLanguage.g:6600:1: ( 'const' )
            // InternalDefinitionLanguage.g:6601:2: 'const'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getConstKeyword_0()); 
            }
            match(input,88,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleAccess().getConstKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__1"
    // InternalDefinitionLanguage.g:6610:1: rule__ConstantDefinitionRule__Group__1 : rule__ConstantDefinitionRule__Group__1__Impl rule__ConstantDefinitionRule__Group__2 ;
    public final void rule__ConstantDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6614:1: ( rule__ConstantDefinitionRule__Group__1__Impl rule__ConstantDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:6615:2: rule__ConstantDefinitionRule__Group__1__Impl rule__ConstantDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__ConstantDefinitionRule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConstantDefinitionRule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__1"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:6622:1: rule__ConstantDefinitionRule__Group__1__Impl : ( ( rule__ConstantDefinitionRule__TypeAssignment_1 ) ) ;
    public final void rule__ConstantDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6626:1: ( ( ( rule__ConstantDefinitionRule__TypeAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:6627:1: ( ( rule__ConstantDefinitionRule__TypeAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:6627:1: ( ( rule__ConstantDefinitionRule__TypeAssignment_1 ) )
            // InternalDefinitionLanguage.g:6628:2: ( rule__ConstantDefinitionRule__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getTypeAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:6629:2: ( rule__ConstantDefinitionRule__TypeAssignment_1 )
            // InternalDefinitionLanguage.g:6629:3: rule__ConstantDefinitionRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ConstantDefinitionRule__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__2"
    // InternalDefinitionLanguage.g:6637:1: rule__ConstantDefinitionRule__Group__2 : rule__ConstantDefinitionRule__Group__2__Impl rule__ConstantDefinitionRule__Group__3 ;
    public final void rule__ConstantDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6641:1: ( rule__ConstantDefinitionRule__Group__2__Impl rule__ConstantDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:6642:2: rule__ConstantDefinitionRule__Group__2__Impl rule__ConstantDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_45);
            rule__ConstantDefinitionRule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConstantDefinitionRule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__2"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:6649:1: rule__ConstantDefinitionRule__Group__2__Impl : ( ( rule__ConstantDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__ConstantDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6653:1: ( ( ( rule__ConstantDefinitionRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:6654:1: ( ( rule__ConstantDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:6654:1: ( ( rule__ConstantDefinitionRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:6655:2: ( rule__ConstantDefinitionRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getNameAssignment_2()); 
            }
            // InternalDefinitionLanguage.g:6656:2: ( rule__ConstantDefinitionRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:6656:3: rule__ConstantDefinitionRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ConstantDefinitionRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__3"
    // InternalDefinitionLanguage.g:6664:1: rule__ConstantDefinitionRule__Group__3 : rule__ConstantDefinitionRule__Group__3__Impl rule__ConstantDefinitionRule__Group__4 ;
    public final void rule__ConstantDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6668:1: ( rule__ConstantDefinitionRule__Group__3__Impl rule__ConstantDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:6669:2: rule__ConstantDefinitionRule__Group__3__Impl rule__ConstantDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__ConstantDefinitionRule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConstantDefinitionRule__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__3"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:6676:1: rule__ConstantDefinitionRule__Group__3__Impl : ( ':=' ) ;
    public final void rule__ConstantDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6680:1: ( ( ':=' ) )
            // InternalDefinitionLanguage.g:6681:1: ( ':=' )
            {
            // InternalDefinitionLanguage.g:6681:1: ( ':=' )
            // InternalDefinitionLanguage.g:6682:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getColonEqualsSignKeyword_3()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleAccess().getColonEqualsSignKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__4"
    // InternalDefinitionLanguage.g:6691:1: rule__ConstantDefinitionRule__Group__4 : rule__ConstantDefinitionRule__Group__4__Impl rule__ConstantDefinitionRule__Group__5 ;
    public final void rule__ConstantDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6695:1: ( rule__ConstantDefinitionRule__Group__4__Impl rule__ConstantDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:6696:2: rule__ConstantDefinitionRule__Group__4__Impl rule__ConstantDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_20);
            rule__ConstantDefinitionRule__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConstantDefinitionRule__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__4"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__4__Impl"
    // InternalDefinitionLanguage.g:6703:1: rule__ConstantDefinitionRule__Group__4__Impl : ( ( rule__ConstantDefinitionRule__ValueAssignment_4 ) ) ;
    public final void rule__ConstantDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6707:1: ( ( ( rule__ConstantDefinitionRule__ValueAssignment_4 ) ) )
            // InternalDefinitionLanguage.g:6708:1: ( ( rule__ConstantDefinitionRule__ValueAssignment_4 ) )
            {
            // InternalDefinitionLanguage.g:6708:1: ( ( rule__ConstantDefinitionRule__ValueAssignment_4 ) )
            // InternalDefinitionLanguage.g:6709:2: ( rule__ConstantDefinitionRule__ValueAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getValueAssignment_4()); 
            }
            // InternalDefinitionLanguage.g:6710:2: ( rule__ConstantDefinitionRule__ValueAssignment_4 )
            // InternalDefinitionLanguage.g:6710:3: rule__ConstantDefinitionRule__ValueAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ConstantDefinitionRule__ValueAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleAccess().getValueAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__4__Impl"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__5"
    // InternalDefinitionLanguage.g:6718:1: rule__ConstantDefinitionRule__Group__5 : rule__ConstantDefinitionRule__Group__5__Impl ;
    public final void rule__ConstantDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6722:1: ( rule__ConstantDefinitionRule__Group__5__Impl )
            // InternalDefinitionLanguage.g:6723:2: rule__ConstantDefinitionRule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConstantDefinitionRule__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__5"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__5__Impl"
    // InternalDefinitionLanguage.g:6729:1: rule__ConstantDefinitionRule__Group__5__Impl : ( ';' ) ;
    public final void rule__ConstantDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6733:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:6734:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:6734:1: ( ';' )
            // InternalDefinitionLanguage.g:6735:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getSemicolonKeyword_5()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleAccess().getSemicolonKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__Group__5__Impl"


    // $ANTLR start "rule__ParameterRule__Group__0"
    // InternalDefinitionLanguage.g:6745:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6749:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalDefinitionLanguage.g:6750:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
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
    // InternalDefinitionLanguage.g:6757:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6761:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:6762:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:6762:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalDefinitionLanguage.g:6763:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:6764:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalDefinitionLanguage.g:6764:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalDefinitionLanguage.g:6772:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6776:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:6777:2: rule__ParameterRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:6783:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6787:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:6788:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:6788:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalDefinitionLanguage.g:6789:2: ( rule__ParameterRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:6790:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalDefinitionLanguage.g:6790:3: rule__ParameterRule__NameAssignment_1
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
    // InternalDefinitionLanguage.g:6799:1: rule__ImportRule__Group__0 : rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 ;
    public final void rule__ImportRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6803:1: ( rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 )
            // InternalDefinitionLanguage.g:6804:2: rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalDefinitionLanguage.g:6811:1: rule__ImportRule__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6815:1: ( ( 'import' ) )
            // InternalDefinitionLanguage.g:6816:1: ( 'import' )
            {
            // InternalDefinitionLanguage.g:6816:1: ( 'import' )
            // InternalDefinitionLanguage.g:6817:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportKeyword_0()); 
            }
            match(input,89,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6826:1: rule__ImportRule__Group__1 : rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 ;
    public final void rule__ImportRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6830:1: ( rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 )
            // InternalDefinitionLanguage.g:6831:2: rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2
            {
            pushFollow(FOLLOW_66);
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
    // InternalDefinitionLanguage.g:6838:1: rule__ImportRule__Group__1__Impl : ( ( rule__ImportRule__LanguageAssignment_1 ) ) ;
    public final void rule__ImportRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6842:1: ( ( ( rule__ImportRule__LanguageAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:6843:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:6843:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            // InternalDefinitionLanguage.g:6844:2: ( rule__ImportRule__LanguageAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getLanguageAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:6845:2: ( rule__ImportRule__LanguageAssignment_1 )
            // InternalDefinitionLanguage.g:6845:3: rule__ImportRule__LanguageAssignment_1
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
    // InternalDefinitionLanguage.g:6853:1: rule__ImportRule__Group__2 : rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 ;
    public final void rule__ImportRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6857:1: ( rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 )
            // InternalDefinitionLanguage.g:6858:2: rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3
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
    // InternalDefinitionLanguage.g:6865:1: rule__ImportRule__Group__2__Impl : ( 'from' ) ;
    public final void rule__ImportRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6869:1: ( ( 'from' ) )
            // InternalDefinitionLanguage.g:6870:1: ( 'from' )
            {
            // InternalDefinitionLanguage.g:6870:1: ( 'from' )
            // InternalDefinitionLanguage.g:6871:2: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getFromKeyword_2()); 
            }
            match(input,90,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6880:1: rule__ImportRule__Group__3 : rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 ;
    public final void rule__ImportRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6884:1: ( rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 )
            // InternalDefinitionLanguage.g:6885:2: rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4
            {
            pushFollow(FOLLOW_20);
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
    // InternalDefinitionLanguage.g:6892:1: rule__ImportRule__Group__3__Impl : ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) ;
    public final void rule__ImportRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6896:1: ( ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) )
            // InternalDefinitionLanguage.g:6897:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            {
            // InternalDefinitionLanguage.g:6897:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            // InternalDefinitionLanguage.g:6898:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_3()); 
            }
            // InternalDefinitionLanguage.g:6899:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            // InternalDefinitionLanguage.g:6899:3: rule__ImportRule__ImportedNamespaceAssignment_3
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
    // InternalDefinitionLanguage.g:6907:1: rule__ImportRule__Group__4 : rule__ImportRule__Group__4__Impl ;
    public final void rule__ImportRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6911:1: ( rule__ImportRule__Group__4__Impl )
            // InternalDefinitionLanguage.g:6912:2: rule__ImportRule__Group__4__Impl
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
    // InternalDefinitionLanguage.g:6918:1: rule__ImportRule__Group__4__Impl : ( ';' ) ;
    public final void rule__ImportRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6922:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:6923:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:6923:1: ( ';' )
            // InternalDefinitionLanguage.g:6924:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getSemicolonKeyword_4()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6934:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6938:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDefinitionLanguage.g:6939:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalDefinitionLanguage.g:6946:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6950:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:6951:1: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:6951:1: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:6952:2: ruleStringOrId
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
    // InternalDefinitionLanguage.g:6961:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6965:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDefinitionLanguage.g:6966:2: rule__QualifiedName__Group__1__Impl
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
    // InternalDefinitionLanguage.g:6972:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6976:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:6977:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:6977:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDefinitionLanguage.g:6978:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:6979:2: ( rule__QualifiedName__Group_1__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==71) ) {
                    int LA50_2 = input.LA(2);

                    if ( (LA50_2==RULE_QUOTED_ID) ) {
                        int LA50_3 = input.LA(3);

                        if ( (synpred94_InternalDefinitionLanguage()) ) {
                            alt50=1;
                        }


                    }
                    else if ( (LA50_2==RULE_ID) ) {
                        int LA50_4 = input.LA(3);

                        if ( (synpred94_InternalDefinitionLanguage()) ) {
                            alt50=1;
                        }


                    }


                }


                switch (alt50) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:6979:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_42);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop50;
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
    // InternalDefinitionLanguage.g:6988:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6992:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDefinitionLanguage.g:6993:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalDefinitionLanguage.g:7000:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7004:1: ( ( '.' ) )
            // InternalDefinitionLanguage.g:7005:1: ( '.' )
            {
            // InternalDefinitionLanguage.g:7005:1: ( '.' )
            // InternalDefinitionLanguage.g:7006:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:7015:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7019:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:7020:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:7026:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7030:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7031:1: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:7031:1: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7032:2: ruleStringOrId
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


    // $ANTLR start "rule__DefinitionModelRule__ImportsAssignment_0"
    // InternalDefinitionLanguage.g:7042:1: rule__DefinitionModelRule__ImportsAssignment_0 : ( ruleImportRule ) ;
    public final void rule__DefinitionModelRule__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7046:1: ( ( ruleImportRule ) )
            // InternalDefinitionLanguage.g:7047:2: ( ruleImportRule )
            {
            // InternalDefinitionLanguage.g:7047:2: ( ruleImportRule )
            // InternalDefinitionLanguage.g:7048:3: ruleImportRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getImportsImportRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleImportRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getImportsImportRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__ImportsAssignment_0"


    // $ANTLR start "rule__DefinitionModelRule__NameAssignment_2"
    // InternalDefinitionLanguage.g:7057:1: rule__DefinitionModelRule__NameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__DefinitionModelRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7061:1: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7062:2: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:7062:2: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7063:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__NameAssignment_2"


    // $ANTLR start "rule__DefinitionModelRule__EnumsAssignment_4_0"
    // InternalDefinitionLanguage.g:7072:1: rule__DefinitionModelRule__EnumsAssignment_4_0 : ( ruleEnumTypeDefinitionRule ) ;
    public final void rule__DefinitionModelRule__EnumsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7076:1: ( ( ruleEnumTypeDefinitionRule ) )
            // InternalDefinitionLanguage.g:7077:2: ( ruleEnumTypeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:7077:2: ( ruleEnumTypeDefinitionRule )
            // InternalDefinitionLanguage.g:7078:3: ruleEnumTypeDefinitionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getEnumsEnumTypeDefinitionRuleParserRuleCall_4_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEnumTypeDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getEnumsEnumTypeDefinitionRuleParserRuleCall_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__EnumsAssignment_4_0"


    // $ANTLR start "rule__DefinitionModelRule__TypesAssignment_4_1"
    // InternalDefinitionLanguage.g:7087:1: rule__DefinitionModelRule__TypesAssignment_4_1 : ( ruleClassDefinitionRule ) ;
    public final void rule__DefinitionModelRule__TypesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7091:1: ( ( ruleClassDefinitionRule ) )
            // InternalDefinitionLanguage.g:7092:2: ( ruleClassDefinitionRule )
            {
            // InternalDefinitionLanguage.g:7092:2: ( ruleClassDefinitionRule )
            // InternalDefinitionLanguage.g:7093:3: ruleClassDefinitionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getTypesClassDefinitionRuleParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleClassDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getTypesClassDefinitionRuleParserRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__TypesAssignment_4_1"


    // $ANTLR start "rule__DefinitionModelRule__FunctionsAssignment_4_2"
    // InternalDefinitionLanguage.g:7102:1: rule__DefinitionModelRule__FunctionsAssignment_4_2 : ( ruleFunctionDefinitionRule ) ;
    public final void rule__DefinitionModelRule__FunctionsAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7106:1: ( ( ruleFunctionDefinitionRule ) )
            // InternalDefinitionLanguage.g:7107:2: ( ruleFunctionDefinitionRule )
            {
            // InternalDefinitionLanguage.g:7107:2: ( ruleFunctionDefinitionRule )
            // InternalDefinitionLanguage.g:7108:3: ruleFunctionDefinitionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getFunctionsFunctionDefinitionRuleParserRuleCall_4_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFunctionDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getFunctionsFunctionDefinitionRuleParserRuleCall_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__FunctionsAssignment_4_2"


    // $ANTLR start "rule__DefinitionModelRule__ConstantsAssignment_4_3"
    // InternalDefinitionLanguage.g:7117:1: rule__DefinitionModelRule__ConstantsAssignment_4_3 : ( ruleConstantDefinitionRule ) ;
    public final void rule__DefinitionModelRule__ConstantsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7121:1: ( ( ruleConstantDefinitionRule ) )
            // InternalDefinitionLanguage.g:7122:2: ( ruleConstantDefinitionRule )
            {
            // InternalDefinitionLanguage.g:7122:2: ( ruleConstantDefinitionRule )
            // InternalDefinitionLanguage.g:7123:3: ruleConstantDefinitionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getConstantsConstantDefinitionRuleParserRuleCall_4_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstantDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDefinitionModelRuleAccess().getConstantsConstantDefinitionRuleParserRuleCall_4_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__ConstantsAssignment_4_3"


    // $ANTLR start "rule__EnumLiteralRule__NameAssignment"
    // InternalDefinitionLanguage.g:7132:1: rule__EnumLiteralRule__NameAssignment : ( ruleStringOrId ) ;
    public final void rule__EnumLiteralRule__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7136:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7137:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:7137:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7138:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:7147:1: rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__EnumTypeDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7151:1: ( ( ruleConstraintRule ) )
            // InternalDefinitionLanguage.g:7152:2: ( ruleConstraintRule )
            {
            // InternalDefinitionLanguage.g:7152:2: ( ruleConstraintRule )
            // InternalDefinitionLanguage.g:7153:3: ruleConstraintRule
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
    // InternalDefinitionLanguage.g:7162:1: rule__EnumTypeDefinitionRule__ScaleAssignment_1 : ( ruleScaleType ) ;
    public final void rule__EnumTypeDefinitionRule__ScaleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7166:1: ( ( ruleScaleType ) )
            // InternalDefinitionLanguage.g:7167:2: ( ruleScaleType )
            {
            // InternalDefinitionLanguage.g:7167:2: ( ruleScaleType )
            // InternalDefinitionLanguage.g:7168:3: ruleScaleType
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
    // InternalDefinitionLanguage.g:7177:1: rule__EnumTypeDefinitionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__EnumTypeDefinitionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7181:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7182:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:7182:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7183:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:7192:1: rule__EnumTypeDefinitionRule__LiteralsAssignment_5 : ( ruleEnumLiteralRule ) ;
    public final void rule__EnumTypeDefinitionRule__LiteralsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7196:1: ( ( ruleEnumLiteralRule ) )
            // InternalDefinitionLanguage.g:7197:2: ( ruleEnumLiteralRule )
            {
            // InternalDefinitionLanguage.g:7197:2: ( ruleEnumLiteralRule )
            // InternalDefinitionLanguage.g:7198:3: ruleEnumLiteralRule
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
    // InternalDefinitionLanguage.g:7207:1: rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 : ( ruleEnumLiteralRule ) ;
    public final void rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7211:1: ( ( ruleEnumLiteralRule ) )
            // InternalDefinitionLanguage.g:7212:2: ( ruleEnumLiteralRule )
            {
            // InternalDefinitionLanguage.g:7212:2: ( ruleEnumLiteralRule )
            // InternalDefinitionLanguage.g:7213:3: ruleEnumLiteralRule
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
    // InternalDefinitionLanguage.g:7222:1: rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 : ( ruleStatementRule ) ;
    public final void rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7226:1: ( ( ruleStatementRule ) )
            // InternalDefinitionLanguage.g:7227:2: ( ruleStatementRule )
            {
            // InternalDefinitionLanguage.g:7227:2: ( ruleStatementRule )
            // InternalDefinitionLanguage.g:7228:3: ruleStatementRule
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


    // $ANTLR start "rule__OrExpressionRule__SubExpressionsAssignment_0"
    // InternalDefinitionLanguage.g:7237:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7241:1: ( ( ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:7242:2: ( ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:7242:2: ( ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:7243:3: ruleXorExpressionRule
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
    // InternalDefinitionLanguage.g:7252:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7256:1: ( ( ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:7257:2: ( ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:7257:2: ( ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:7258:3: ruleXorExpressionRule
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
    // InternalDefinitionLanguage.g:7267:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7271:1: ( ( ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:7272:2: ( ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:7272:2: ( ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:7273:3: ruleAndExpressionRule
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
    // InternalDefinitionLanguage.g:7282:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7286:1: ( ( ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:7287:2: ( ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:7287:2: ( ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:7288:3: ruleAndExpressionRule
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
    // InternalDefinitionLanguage.g:7297:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7301:1: ( ( ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:7302:2: ( ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:7302:2: ( ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:7303:3: ruleNotExpressionRule
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
    // InternalDefinitionLanguage.g:7312:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7316:1: ( ( ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:7317:2: ( ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:7317:2: ( ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:7318:3: ruleNotExpressionRule
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
    // InternalDefinitionLanguage.g:7327:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7331:1: ( ( ( '!' ) ) )
            // InternalDefinitionLanguage.g:7332:2: ( ( '!' ) )
            {
            // InternalDefinitionLanguage.g:7332:2: ( ( '!' ) )
            // InternalDefinitionLanguage.g:7333:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalDefinitionLanguage.g:7334:3: ( '!' )
            // InternalDefinitionLanguage.g:7335:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,91,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:7346:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7350:1: ( ( ruleComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:7351:2: ( ruleComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:7351:2: ( ruleComparisonExpressionRule )
            // InternalDefinitionLanguage.g:7352:3: ruleComparisonExpressionRule
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
    // InternalDefinitionLanguage.g:7361:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7365:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:7366:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:7366:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:7367:3: ruleAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:7376:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7380:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:7381:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:7381:2: ( rulePartialComparisonExpressionRule )
            // InternalDefinitionLanguage.g:7382:3: rulePartialComparisonExpressionRule
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
    // InternalDefinitionLanguage.g:7391:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7395:1: ( ( ruleComparisonOperatorRule ) )
            // InternalDefinitionLanguage.g:7396:2: ( ruleComparisonOperatorRule )
            {
            // InternalDefinitionLanguage.g:7396:2: ( ruleComparisonOperatorRule )
            // InternalDefinitionLanguage.g:7397:3: ruleComparisonOperatorRule
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
    // InternalDefinitionLanguage.g:7406:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7410:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:7411:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:7411:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:7412:3: ruleAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:7421:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7425:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:7426:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:7426:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:7427:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDefinitionLanguage.g:7436:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7440:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDefinitionLanguage.g:7441:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDefinitionLanguage.g:7441:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDefinitionLanguage.g:7442:3: ruleAddOrSubtractOperatorRule
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
    // InternalDefinitionLanguage.g:7451:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7455:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:7456:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:7456:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:7457:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDefinitionLanguage.g:7466:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7470:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:7471:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:7471:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:7472:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:7481:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7485:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalDefinitionLanguage.g:7486:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalDefinitionLanguage.g:7486:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalDefinitionLanguage.g:7487:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalDefinitionLanguage.g:7496:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7500:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:7501:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:7501:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:7502:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:7511:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7515:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:7516:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:7516:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:7517:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:7526:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7530:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:7531:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:7531:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:7532:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:7541:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7545:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDefinitionLanguage.g:7546:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDefinitionLanguage.g:7546:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDefinitionLanguage.g:7547:3: ruleAddOrSubtractOperatorRule
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
    // InternalDefinitionLanguage.g:7556:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleReadExpressionRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7560:1: ( ( ruleReadExpressionRule ) )
            // InternalDefinitionLanguage.g:7561:2: ( ruleReadExpressionRule )
            {
            // InternalDefinitionLanguage.g:7561:2: ( ruleReadExpressionRule )
            // InternalDefinitionLanguage.g:7562:3: ruleReadExpressionRule
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
    // InternalDefinitionLanguage.g:7571:1: rule__ArrayRule__ValuesAssignment_2_0 : ( ruleOrExpressionRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7575:1: ( ( ruleOrExpressionRule ) )
            // InternalDefinitionLanguage.g:7576:2: ( ruleOrExpressionRule )
            {
            // InternalDefinitionLanguage.g:7576:2: ( ruleOrExpressionRule )
            // InternalDefinitionLanguage.g:7577:3: ruleOrExpressionRule
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
    // InternalDefinitionLanguage.g:7586:1: rule__ArrayRule__ValuesAssignment_2_1_1 : ( ruleOrExpressionRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7590:1: ( ( ruleOrExpressionRule ) )
            // InternalDefinitionLanguage.g:7591:2: ( ruleOrExpressionRule )
            {
            // InternalDefinitionLanguage.g:7591:2: ( ruleOrExpressionRule )
            // InternalDefinitionLanguage.g:7592:3: ruleOrExpressionRule
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
    // InternalDefinitionLanguage.g:7601:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7605:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:7606:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:7606:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:7607:3: ruleExpressionRule
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


    // $ANTLR start "rule__PathExpressionRule__PathAssignment_1"
    // InternalDefinitionLanguage.g:7616:1: rule__PathExpressionRule__PathAssignment_1 : ( RULE_STRING ) ;
    public final void rule__PathExpressionRule__PathAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7620:1: ( ( RULE_STRING ) )
            // InternalDefinitionLanguage.g:7621:2: ( RULE_STRING )
            {
            // InternalDefinitionLanguage.g:7621:2: ( RULE_STRING )
            // InternalDefinitionLanguage.g:7622:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathExpressionRuleAccess().getPathSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathExpressionRuleAccess().getPathSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathExpressionRule__PathAssignment_1"


    // $ANTLR start "rule__CallRule__FunctionAssignment_0"
    // InternalDefinitionLanguage.g:7631:1: rule__CallRule__FunctionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7635:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7636:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7636:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7637:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionCrossReference_0_0()); 
            }
            // InternalDefinitionLanguage.g:7638:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7639:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7650:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7654:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:7655:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:7655:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:7656:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:7665:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7669:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:7670:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:7670:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:7671:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:7680:1: rule__AttributeReferenceRule__SelfAssignment_0 : ( ruleSelfReferenceRule ) ;
    public final void rule__AttributeReferenceRule__SelfAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7684:1: ( ( ruleSelfReferenceRule ) )
            // InternalDefinitionLanguage.g:7685:2: ( ruleSelfReferenceRule )
            {
            // InternalDefinitionLanguage.g:7685:2: ( ruleSelfReferenceRule )
            // InternalDefinitionLanguage.g:7686:3: ruleSelfReferenceRule
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
    // InternalDefinitionLanguage.g:7695:1: rule__AttributeReferenceRule__ChainAssignment_1_1 : ( ruleValuelDefinitionReferenceRule ) ;
    public final void rule__AttributeReferenceRule__ChainAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7699:1: ( ( ruleValuelDefinitionReferenceRule ) )
            // InternalDefinitionLanguage.g:7700:2: ( ruleValuelDefinitionReferenceRule )
            {
            // InternalDefinitionLanguage.g:7700:2: ( ruleValuelDefinitionReferenceRule )
            // InternalDefinitionLanguage.g:7701:3: ruleValuelDefinitionReferenceRule
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
    // InternalDefinitionLanguage.g:7710:1: rule__ConfigurationReferenceRule__ReferenceAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ConfigurationReferenceRule__ReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7714:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7715:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:7715:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7716:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:7725:1: rule__ValuelDefinitionReferenceRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__ValuelDefinitionReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7729:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7730:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7730:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7731:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionValueDefinitionCrossReference_0()); 
            }
            // InternalDefinitionLanguage.g:7732:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7733:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7744:1: rule__BaseDataReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__BaseDataReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7748:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7749:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7749:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7750:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionBaseDataDescriptionCrossReference_1_0()); 
            }
            // InternalDefinitionLanguage.g:7751:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7752:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7763:1: rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7767:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7768:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7768:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7769:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionStructuredDataDescriptionCrossReference_1_0()); 
            }
            // InternalDefinitionLanguage.g:7770:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7771:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7782:1: rule__InstanceLiteralRule__DefinitionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceLiteralRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7786:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7787:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7787:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7788:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionClassDefinitionCrossReference_0_0()); 
            }
            // InternalDefinitionLanguage.g:7789:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7790:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7801:1: rule__InstanceLiteralRule__AttributesAssignment_2 : ( ruleAttributeRule ) ;
    public final void rule__InstanceLiteralRule__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7805:1: ( ( ruleAttributeRule ) )
            // InternalDefinitionLanguage.g:7806:2: ( ruleAttributeRule )
            {
            // InternalDefinitionLanguage.g:7806:2: ( ruleAttributeRule )
            // InternalDefinitionLanguage.g:7807:3: ruleAttributeRule
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
    // InternalDefinitionLanguage.g:7816:1: rule__AttributeRule__DefinitionAssignment_0 : ( ( ruleStringOrId ) ) ;
    public final void rule__AttributeRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7820:1: ( ( ( ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:7821:2: ( ( ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:7821:2: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7822:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0()); 
            }
            // InternalDefinitionLanguage.g:7823:3: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7824:4: ruleStringOrId
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
    // InternalDefinitionLanguage.g:7835:1: rule__AttributeRule__ValueAssignment_2 : ( ruleExpressionRule ) ;
    public final void rule__AttributeRule__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7839:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:7840:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:7840:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:7841:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:7850:1: rule__RealLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__RealLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7854:1: ( ( RULE_DOUBLE ) )
            // InternalDefinitionLanguage.g:7855:2: ( RULE_DOUBLE )
            {
            // InternalDefinitionLanguage.g:7855:2: ( RULE_DOUBLE )
            // InternalDefinitionLanguage.g:7856:3: RULE_DOUBLE
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
    // InternalDefinitionLanguage.g:7865:1: rule__RealLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__RealLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7869:1: ( ( ruleFactorRule ) )
            // InternalDefinitionLanguage.g:7870:2: ( ruleFactorRule )
            {
            // InternalDefinitionLanguage.g:7870:2: ( ruleFactorRule )
            // InternalDefinitionLanguage.g:7871:3: ruleFactorRule
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
    // InternalDefinitionLanguage.g:7880:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7884:1: ( ( RULE_INT ) )
            // InternalDefinitionLanguage.g:7885:2: ( RULE_INT )
            {
            // InternalDefinitionLanguage.g:7885:2: ( RULE_INT )
            // InternalDefinitionLanguage.g:7886:3: RULE_INT
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
    // InternalDefinitionLanguage.g:7895:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7899:1: ( ( ruleFactorRule ) )
            // InternalDefinitionLanguage.g:7900:2: ( ruleFactorRule )
            {
            // InternalDefinitionLanguage.g:7900:2: ( ruleFactorRule )
            // InternalDefinitionLanguage.g:7901:3: ruleFactorRule
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
    // InternalDefinitionLanguage.g:7910:1: rule__StringLiteralRule__LiteralAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__LiteralAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7914:1: ( ( RULE_STRING ) )
            // InternalDefinitionLanguage.g:7915:2: ( RULE_STRING )
            {
            // InternalDefinitionLanguage.g:7915:2: ( RULE_STRING )
            // InternalDefinitionLanguage.g:7916:3: RULE_STRING
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
    // InternalDefinitionLanguage.g:7925:1: rule__BooleanLiteralRule__LiteralAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__LiteralAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7929:1: ( ( ( 'true' ) ) )
            // InternalDefinitionLanguage.g:7930:2: ( ( 'true' ) )
            {
            // InternalDefinitionLanguage.g:7930:2: ( ( 'true' ) )
            // InternalDefinitionLanguage.g:7931:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0()); 
            }
            // InternalDefinitionLanguage.g:7932:3: ( 'true' )
            // InternalDefinitionLanguage.g:7933:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0()); 
            }
            match(input,92,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__ClassDefinitionRule__ConstraintsAssignment_0"
    // InternalDefinitionLanguage.g:7944:1: rule__ClassDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__ClassDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7948:1: ( ( ruleConstraintRule ) )
            // InternalDefinitionLanguage.g:7949:2: ( ruleConstraintRule )
            {
            // InternalDefinitionLanguage.g:7949:2: ( ruleConstraintRule )
            // InternalDefinitionLanguage.g:7950:3: ruleConstraintRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstraintRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__ConstraintsAssignment_0"


    // $ANTLR start "rule__ClassDefinitionRule__AbstractAssignment_1"
    // InternalDefinitionLanguage.g:7959:1: rule__ClassDefinitionRule__AbstractAssignment_1 : ( ( 'abstract' ) ) ;
    public final void rule__ClassDefinitionRule__AbstractAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7963:1: ( ( ( 'abstract' ) ) )
            // InternalDefinitionLanguage.g:7964:2: ( ( 'abstract' ) )
            {
            // InternalDefinitionLanguage.g:7964:2: ( ( 'abstract' ) )
            // InternalDefinitionLanguage.g:7965:3: ( 'abstract' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getAbstractAbstractKeyword_1_0()); 
            }
            // InternalDefinitionLanguage.g:7966:3: ( 'abstract' )
            // InternalDefinitionLanguage.g:7967:4: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getAbstractAbstractKeyword_1_0()); 
            }
            match(input,93,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getAbstractAbstractKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getAbstractAbstractKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__AbstractAssignment_1"


    // $ANTLR start "rule__ClassDefinitionRule__NameAssignment_3"
    // InternalDefinitionLanguage.g:7978:1: rule__ClassDefinitionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__ClassDefinitionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7982:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7983:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:7983:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7984:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__NameAssignment_3"


    // $ANTLR start "rule__ClassDefinitionRule__SuperTypeAssignment_4_1"
    // InternalDefinitionLanguage.g:7993:1: rule__ClassDefinitionRule__SuperTypeAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ClassDefinitionRule__SuperTypeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7997:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7998:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7998:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7999:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getSuperTypeClassDefinitionCrossReference_4_1_0()); 
            }
            // InternalDefinitionLanguage.g:8000:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:8001:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getSuperTypeClassDefinitionQualifiedNameParserRuleCall_4_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getSuperTypeClassDefinitionQualifiedNameParserRuleCall_4_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getSuperTypeClassDefinitionCrossReference_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__SuperTypeAssignment_4_1"


    // $ANTLR start "rule__ClassDefinitionRule__AttributesAssignment_6"
    // InternalDefinitionLanguage.g:8012:1: rule__ClassDefinitionRule__AttributesAssignment_6 : ( ruleAttributeDefinitionRule ) ;
    public final void rule__ClassDefinitionRule__AttributesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8016:1: ( ( ruleAttributeDefinitionRule ) )
            // InternalDefinitionLanguage.g:8017:2: ( ruleAttributeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:8017:2: ( ruleAttributeDefinitionRule )
            // InternalDefinitionLanguage.g:8018:3: ruleAttributeDefinitionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getAttributesAttributeDefinitionRuleParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAttributeDefinitionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassDefinitionRuleAccess().getAttributesAttributeDefinitionRuleParserRuleCall_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassDefinitionRule__AttributesAssignment_6"


    // $ANTLR start "rule__AttributeDefinitionRule__ConstraintsAssignment_0"
    // InternalDefinitionLanguage.g:8027:1: rule__AttributeDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__AttributeDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8031:1: ( ( ruleConstraintRule ) )
            // InternalDefinitionLanguage.g:8032:2: ( ruleConstraintRule )
            {
            // InternalDefinitionLanguage.g:8032:2: ( ruleConstraintRule )
            // InternalDefinitionLanguage.g:8033:3: ruleConstraintRule
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
    // InternalDefinitionLanguage.g:8042:1: rule__AttributeDefinitionRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8046:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:8047:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:8047:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:8048:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:8057:1: rule__AttributeDefinitionRule__OptionalAssignment_3 : ( ( 'optional' ) ) ;
    public final void rule__AttributeDefinitionRule__OptionalAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8061:1: ( ( ( 'optional' ) ) )
            // InternalDefinitionLanguage.g:8062:2: ( ( 'optional' ) )
            {
            // InternalDefinitionLanguage.g:8062:2: ( ( 'optional' ) )
            // InternalDefinitionLanguage.g:8063:3: ( 'optional' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0()); 
            }
            // InternalDefinitionLanguage.g:8064:3: ( 'optional' )
            // InternalDefinitionLanguage.g:8065:4: 'optional'
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
    // InternalDefinitionLanguage.g:8076:1: rule__AttributeDefinitionRule__TypeAssignment_4 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8080:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:8081:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:8081:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:8082:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:8091:1: rule__AttributeDefinitionRule__InitialisationAssignment_5_1 : ( ruleExpressionRule ) ;
    public final void rule__AttributeDefinitionRule__InitialisationAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8095:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:8096:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:8096:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:8097:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:8106:1: rule__EnumReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__EnumReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8110:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:8111:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:8111:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:8112:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getDefinitionEnumDefinitionCrossReference_1_0()); 
            }
            // InternalDefinitionLanguage.g:8113:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:8114:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:8125:1: rule__TypeReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TypeReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8129:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:8130:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:8130:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:8131:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }
            // InternalDefinitionLanguage.g:8132:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:8133:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:8144:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8148:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:8149:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:8149:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:8150:3: ruleTypeRule
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


    // $ANTLR start "rule__FunctionDefinitionRule__ConstraintsAssignment_0"
    // InternalDefinitionLanguage.g:8159:1: rule__FunctionDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__FunctionDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8163:1: ( ( ruleConstraintRule ) )
            // InternalDefinitionLanguage.g:8164:2: ( ruleConstraintRule )
            {
            // InternalDefinitionLanguage.g:8164:2: ( ruleConstraintRule )
            // InternalDefinitionLanguage.g:8165:3: ruleConstraintRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstraintRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__ConstraintsAssignment_0"


    // $ANTLR start "rule__FunctionDefinitionRule__TypeAssignment_2"
    // InternalDefinitionLanguage.g:8174:1: rule__FunctionDefinitionRule__TypeAssignment_2 : ( ruleTypeRule ) ;
    public final void rule__FunctionDefinitionRule__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8178:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:8179:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:8179:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:8180:3: ruleTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__TypeAssignment_2"


    // $ANTLR start "rule__FunctionDefinitionRule__NameAssignment_3"
    // InternalDefinitionLanguage.g:8189:1: rule__FunctionDefinitionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__FunctionDefinitionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8193:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:8194:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:8194:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:8195:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__NameAssignment_3"


    // $ANTLR start "rule__FunctionDefinitionRule__ParametersAssignment_5_0"
    // InternalDefinitionLanguage.g:8204:1: rule__FunctionDefinitionRule__ParametersAssignment_5_0 : ( ruleParameterRule ) ;
    public final void rule__FunctionDefinitionRule__ParametersAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8208:1: ( ( ruleParameterRule ) )
            // InternalDefinitionLanguage.g:8209:2: ( ruleParameterRule )
            {
            // InternalDefinitionLanguage.g:8209:2: ( ruleParameterRule )
            // InternalDefinitionLanguage.g:8210:3: ruleParameterRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_5_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleParameterRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_5_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__ParametersAssignment_5_0"


    // $ANTLR start "rule__FunctionDefinitionRule__ParametersAssignment_5_1_1"
    // InternalDefinitionLanguage.g:8219:1: rule__FunctionDefinitionRule__ParametersAssignment_5_1_1 : ( ruleParameterRule ) ;
    public final void rule__FunctionDefinitionRule__ParametersAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8223:1: ( ( ruleParameterRule ) )
            // InternalDefinitionLanguage.g:8224:2: ( ruleParameterRule )
            {
            // InternalDefinitionLanguage.g:8224:2: ( ruleParameterRule )
            // InternalDefinitionLanguage.g:8225:3: ruleParameterRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_5_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleParameterRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_5_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__ParametersAssignment_5_1_1"


    // $ANTLR start "rule__ConstantDefinitionRule__TypeAssignment_1"
    // InternalDefinitionLanguage.g:8234:1: rule__ConstantDefinitionRule__TypeAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ConstantDefinitionRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8238:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:8239:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:8239:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:8240:3: ruleTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__TypeAssignment_1"


    // $ANTLR start "rule__ConstantDefinitionRule__NameAssignment_2"
    // InternalDefinitionLanguage.g:8249:1: rule__ConstantDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__ConstantDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8253:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:8254:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:8254:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:8255:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__NameAssignment_2"


    // $ANTLR start "rule__ConstantDefinitionRule__ValueAssignment_4"
    // InternalDefinitionLanguage.g:8264:1: rule__ConstantDefinitionRule__ValueAssignment_4 : ( ruleExpressionRule ) ;
    public final void rule__ConstantDefinitionRule__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8268:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:8269:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:8269:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:8270:3: ruleExpressionRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getValueExpressionRuleParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpressionRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantDefinitionRuleAccess().getValueExpressionRuleParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinitionRule__ValueAssignment_4"


    // $ANTLR start "rule__ParameterRule__TypeAssignment_0"
    // InternalDefinitionLanguage.g:8279:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8283:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:8284:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:8284:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:8285:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:8294:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8298:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:8299:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:8299:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:8300:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:8309:1: rule__ImportRule__LanguageAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ImportRule__LanguageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8313:1: ( ( RULE_STRING ) )
            // InternalDefinitionLanguage.g:8314:2: ( RULE_STRING )
            {
            // InternalDefinitionLanguage.g:8314:2: ( RULE_STRING )
            // InternalDefinitionLanguage.g:8315:3: RULE_STRING
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
    // InternalDefinitionLanguage.g:8324:1: rule__ImportRule__ImportedNamespaceAssignment_3 : ( ruleQualifiedName ) ;
    public final void rule__ImportRule__ImportedNamespaceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:8328:1: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:8329:2: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:8329:2: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:8330:3: ruleQualifiedName
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

    // $ANTLR start synpred1_InternalDefinitionLanguage
    public final void synpred1_InternalDefinitionLanguage_fragment() throws RecognitionException {   
        // InternalDefinitionLanguage.g:1614:2: ( ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) ) )
        // InternalDefinitionLanguage.g:1614:2: ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) )
        {
        // InternalDefinitionLanguage.g:1614:2: ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) )
        // InternalDefinitionLanguage.g:1615:3: ( rule__DefinitionModelRule__EnumsAssignment_4_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getDefinitionModelRuleAccess().getEnumsAssignment_4_0()); 
        }
        // InternalDefinitionLanguage.g:1616:3: ( rule__DefinitionModelRule__EnumsAssignment_4_0 )
        // InternalDefinitionLanguage.g:1616:4: rule__DefinitionModelRule__EnumsAssignment_4_0
        {
        pushFollow(FOLLOW_2);
        rule__DefinitionModelRule__EnumsAssignment_4_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred1_InternalDefinitionLanguage

    // $ANTLR start synpred2_InternalDefinitionLanguage
    public final void synpred2_InternalDefinitionLanguage_fragment() throws RecognitionException {   
        // InternalDefinitionLanguage.g:1620:2: ( ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) ) )
        // InternalDefinitionLanguage.g:1620:2: ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) )
        {
        // InternalDefinitionLanguage.g:1620:2: ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) )
        // InternalDefinitionLanguage.g:1621:3: ( rule__DefinitionModelRule__TypesAssignment_4_1 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getDefinitionModelRuleAccess().getTypesAssignment_4_1()); 
        }
        // InternalDefinitionLanguage.g:1622:3: ( rule__DefinitionModelRule__TypesAssignment_4_1 )
        // InternalDefinitionLanguage.g:1622:4: rule__DefinitionModelRule__TypesAssignment_4_1
        {
        pushFollow(FOLLOW_2);
        rule__DefinitionModelRule__TypesAssignment_4_1();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_InternalDefinitionLanguage

    // $ANTLR start synpred3_InternalDefinitionLanguage
    public final void synpred3_InternalDefinitionLanguage_fragment() throws RecognitionException {   
        // InternalDefinitionLanguage.g:1626:2: ( ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) ) )
        // InternalDefinitionLanguage.g:1626:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) )
        {
        // InternalDefinitionLanguage.g:1626:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) )
        // InternalDefinitionLanguage.g:1627:3: ( rule__DefinitionModelRule__FunctionsAssignment_4_2 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getDefinitionModelRuleAccess().getFunctionsAssignment_4_2()); 
        }
        // InternalDefinitionLanguage.g:1628:3: ( rule__DefinitionModelRule__FunctionsAssignment_4_2 )
        // InternalDefinitionLanguage.g:1628:4: rule__DefinitionModelRule__FunctionsAssignment_4_2
        {
        pushFollow(FOLLOW_2);
        rule__DefinitionModelRule__FunctionsAssignment_4_2();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalDefinitionLanguage

    // $ANTLR start synpred94_InternalDefinitionLanguage
    public final void synpred94_InternalDefinitionLanguage_fragment() throws RecognitionException {   
        // InternalDefinitionLanguage.g:6979:3: ( rule__QualifiedName__Group_1__0 )
        // InternalDefinitionLanguage.g:6979:3: rule__QualifiedName__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__QualifiedName__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred94_InternalDefinitionLanguage

    // Delegated rules

    public final boolean synpred2_InternalDefinitionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalDefinitionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_InternalDefinitionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_InternalDefinitionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalDefinitionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalDefinitionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalDefinitionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalDefinitionLanguage_fragment(); // can never throw exception
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
    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\20\1\0\10\uffff";
    static final String dfa_3s = "\1\135\1\0\10\uffff";
    static final String dfa_4s = "\2\uffff\1\1\3\uffff\1\2\1\uffff\1\3\1\4";
    static final String dfa_5s = "\1\uffff\1\0\10\uffff}>";
    static final String[] dfa_6s = {
            "\4\2\70\uffff\1\6\1\uffff\1\1\10\uffff\1\10\1\11\4\uffff\1\6",
            "\1\uffff",
            "",
            "",
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
            return "1609:1: rule__DefinitionModelRule__Alternatives_4 : ( ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) ) | ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) ) | ( ( rule__DefinitionModelRule__ConstantsAssignment_4_3 ) ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_1 = input.LA(1);

                         
                        int index1_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalDefinitionLanguage()) ) {s = 2;}

                        else if ( (synpred2_InternalDefinitionLanguage()) ) {s = 6;}

                        else if ( (synpred3_InternalDefinitionLanguage()) ) {s = 8;}

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\14\uffff";
    static final String dfa_8s = "\2\uffff\2\7\6\uffff\2\7";
    static final String dfa_9s = "\1\4\1\uffff\2\24\4\uffff\1\4\1\uffff\2\24";
    static final String dfa_10s = "\1\134\1\uffff\2\107\4\uffff\1\5\1\uffff\2\107";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\6\1\uffff\1\2\2\uffff";
    static final String dfa_12s = "\14\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\1\3\3\4\6\uffff\1\4\47\uffff\1\5\12\uffff\1\1\1\uffff\1\6\2\7\1\uffff\3\7\21\uffff\1\4",
            "",
            "\13\7\25\uffff\1\4\2\uffff\1\11\3\7\3\uffff\4\7\1\uffff\1\7\3\uffff\1\10",
            "\13\7\25\uffff\1\4\2\uffff\1\11\3\7\3\uffff\4\7\1\uffff\1\7\3\uffff\1\10",
            "",
            "",
            "",
            "",
            "\1\12\1\13",
            "",
            "\13\7\25\uffff\1\4\2\uffff\1\11\3\7\3\uffff\4\7\1\uffff\1\7\3\uffff\1\10",
            "\13\7\25\uffff\1\4\2\uffff\1\11\3\7\3\uffff\4\7\1\uffff\1\7\3\uffff\1\10"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1642:1: rule__ReadExpressionRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( rulePathExpressionRule ) | ( ruleReferenceRule ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00200000000F0000L,0x0000000021805000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000F0002L,0x0000000021805000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000F0000L,0x0000000000004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0500000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0A00000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x008000000C0081F0L,0x0000000018000774L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x008000000C0081F2L,0x0000000018000774L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000003F00000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000003F00002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000070000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x008000000C0081F0L,0x000000001800077CL});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x018000000C0081F0L,0x0000000018000774L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0020000000000030L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0007FFFF80000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000008000L,0x0000000010000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000020005000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0010000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0020000000000030L,0x0000000000004000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000032L,0x0000000000004000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x00000000000081F0L,0x0000000010000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000030L,0x0000000000004000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0040000000000000L,0x00000000407F8610L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x00000000003D0000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000804000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0140000000000000L,0x00000000407F8610L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});

}
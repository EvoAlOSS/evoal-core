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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'module'", "'{'", "'}'", "'enum'", "'('", "')'", "';'", "','", "'with'", "'constraints'", "':'", "'OR'", "'XOR'", "'AND'", "'^'", "'['", "']'", "'data'", "'instance'", "':='", "'type'", "'extends'", "'@'", "'literal'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'def'", "'const'", "'import'", "'from'", "'.'", "'!'", "'true'", "'abstract'", "'optional'"
    };
    public static final int T__50=50;
    public static final int T__90=90;
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


    // $ANTLR start "entryRuleCallRule"
    // InternalDefinitionLanguage.g:505:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:506:1: ( ruleCallRule EOF )
            // InternalDefinitionLanguage.g:507:1: ruleCallRule EOF
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
    // InternalDefinitionLanguage.g:514:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:518:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:519:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:519:2: ( ( rule__CallRule__Group__0 ) )
            // InternalDefinitionLanguage.g:520:3: ( rule__CallRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:521:3: ( rule__CallRule__Group__0 )
            // InternalDefinitionLanguage.g:521:4: rule__CallRule__Group__0
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
    // InternalDefinitionLanguage.g:530:1: entryRuleReferenceRule : ruleReferenceRule EOF ;
    public final void entryRuleReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:531:1: ( ruleReferenceRule EOF )
            // InternalDefinitionLanguage.g:532:1: ruleReferenceRule EOF
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
    // InternalDefinitionLanguage.g:539:1: ruleReferenceRule : ( ( rule__ReferenceRule__Alternatives ) ) ;
    public final void ruleReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:543:2: ( ( ( rule__ReferenceRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:544:2: ( ( rule__ReferenceRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:544:2: ( ( rule__ReferenceRule__Alternatives ) )
            // InternalDefinitionLanguage.g:545:3: ( rule__ReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:546:3: ( rule__ReferenceRule__Alternatives )
            // InternalDefinitionLanguage.g:546:4: rule__ReferenceRule__Alternatives
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


    // $ANTLR start "entryRuleLiteralDefinitionReferenceRule"
    // InternalDefinitionLanguage.g:555:1: entryRuleLiteralDefinitionReferenceRule : ruleLiteralDefinitionReferenceRule EOF ;
    public final void entryRuleLiteralDefinitionReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:556:1: ( ruleLiteralDefinitionReferenceRule EOF )
            // InternalDefinitionLanguage.g:557:1: ruleLiteralDefinitionReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralDefinitionReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLiteralDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralDefinitionReferenceRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralDefinitionReferenceRule"


    // $ANTLR start "ruleLiteralDefinitionReferenceRule"
    // InternalDefinitionLanguage.g:564:1: ruleLiteralDefinitionReferenceRule : ( ( rule__LiteralDefinitionReferenceRule__DefinitionAssignment ) ) ;
    public final void ruleLiteralDefinitionReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:568:2: ( ( ( rule__LiteralDefinitionReferenceRule__DefinitionAssignment ) ) )
            // InternalDefinitionLanguage.g:569:2: ( ( rule__LiteralDefinitionReferenceRule__DefinitionAssignment ) )
            {
            // InternalDefinitionLanguage.g:569:2: ( ( rule__LiteralDefinitionReferenceRule__DefinitionAssignment ) )
            // InternalDefinitionLanguage.g:570:3: ( rule__LiteralDefinitionReferenceRule__DefinitionAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralDefinitionReferenceRuleAccess().getDefinitionAssignment()); 
            }
            // InternalDefinitionLanguage.g:571:3: ( rule__LiteralDefinitionReferenceRule__DefinitionAssignment )
            // InternalDefinitionLanguage.g:571:4: rule__LiteralDefinitionReferenceRule__DefinitionAssignment
            {
            pushFollow(FOLLOW_2);
            rule__LiteralDefinitionReferenceRule__DefinitionAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralDefinitionReferenceRuleAccess().getDefinitionAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralDefinitionReferenceRule"


    // $ANTLR start "entryRuleTypeDefinitionReferenceRule"
    // InternalDefinitionLanguage.g:580:1: entryRuleTypeDefinitionReferenceRule : ruleTypeDefinitionReferenceRule EOF ;
    public final void entryRuleTypeDefinitionReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:581:1: ( ruleTypeDefinitionReferenceRule EOF )
            // InternalDefinitionLanguage.g:582:1: ruleTypeDefinitionReferenceRule EOF
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
    // InternalDefinitionLanguage.g:589:1: ruleTypeDefinitionReferenceRule : ( ( rule__TypeDefinitionReferenceRule__Alternatives ) ) ;
    public final void ruleTypeDefinitionReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:593:2: ( ( ( rule__TypeDefinitionReferenceRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:594:2: ( ( rule__TypeDefinitionReferenceRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:594:2: ( ( rule__TypeDefinitionReferenceRule__Alternatives ) )
            // InternalDefinitionLanguage.g:595:3: ( rule__TypeDefinitionReferenceRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionReferenceRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:596:3: ( rule__TypeDefinitionReferenceRule__Alternatives )
            // InternalDefinitionLanguage.g:596:4: rule__TypeDefinitionReferenceRule__Alternatives
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
    // InternalDefinitionLanguage.g:605:1: entryRuleBaseDataReferenceRule : ruleBaseDataReferenceRule EOF ;
    public final void entryRuleBaseDataReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:606:1: ( ruleBaseDataReferenceRule EOF )
            // InternalDefinitionLanguage.g:607:1: ruleBaseDataReferenceRule EOF
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
    // InternalDefinitionLanguage.g:614:1: ruleBaseDataReferenceRule : ( ( rule__BaseDataReferenceRule__Group__0 ) ) ;
    public final void ruleBaseDataReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:618:2: ( ( ( rule__BaseDataReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:619:2: ( ( rule__BaseDataReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:619:2: ( ( rule__BaseDataReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:620:3: ( rule__BaseDataReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:621:3: ( rule__BaseDataReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:621:4: rule__BaseDataReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:630:1: entryRuleStructuredDataDescriptionReferenceRule : ruleStructuredDataDescriptionReferenceRule EOF ;
    public final void entryRuleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:631:1: ( ruleStructuredDataDescriptionReferenceRule EOF )
            // InternalDefinitionLanguage.g:632:1: ruleStructuredDataDescriptionReferenceRule EOF
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
    // InternalDefinitionLanguage.g:639:1: ruleStructuredDataDescriptionReferenceRule : ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) ) ;
    public final void ruleStructuredDataDescriptionReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:643:2: ( ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:644:2: ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:644:2: ( ( rule__StructuredDataDescriptionReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:645:3: ( rule__StructuredDataDescriptionReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:646:3: ( rule__StructuredDataDescriptionReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:646:4: rule__StructuredDataDescriptionReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:655:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:656:1: ( ruleLiteralRule EOF )
            // InternalDefinitionLanguage.g:657:1: ruleLiteralRule EOF
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
    // InternalDefinitionLanguage.g:664:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:668:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:669:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:669:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalDefinitionLanguage.g:670:3: ( rule__LiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:671:3: ( rule__LiteralRule__Alternatives )
            // InternalDefinitionLanguage.g:671:4: rule__LiteralRule__Alternatives
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
    // InternalDefinitionLanguage.g:680:1: entryRuleInstanceLiteralRule : ruleInstanceLiteralRule EOF ;
    public final void entryRuleInstanceLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:681:1: ( ruleInstanceLiteralRule EOF )
            // InternalDefinitionLanguage.g:682:1: ruleInstanceLiteralRule EOF
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
    // InternalDefinitionLanguage.g:689:1: ruleInstanceLiteralRule : ( ( rule__InstanceLiteralRule__Group__0 ) ) ;
    public final void ruleInstanceLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:693:2: ( ( ( rule__InstanceLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:694:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:694:2: ( ( rule__InstanceLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:695:3: ( rule__InstanceLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:696:3: ( rule__InstanceLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:696:4: rule__InstanceLiteralRule__Group__0
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
    // InternalDefinitionLanguage.g:705:1: entryRuleAttributeRule : ruleAttributeRule EOF ;
    public final void entryRuleAttributeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:706:1: ( ruleAttributeRule EOF )
            // InternalDefinitionLanguage.g:707:1: ruleAttributeRule EOF
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
    // InternalDefinitionLanguage.g:714:1: ruleAttributeRule : ( ( rule__AttributeRule__Group__0 ) ) ;
    public final void ruleAttributeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:718:2: ( ( ( rule__AttributeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:719:2: ( ( rule__AttributeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:719:2: ( ( rule__AttributeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:720:3: ( rule__AttributeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:721:3: ( rule__AttributeRule__Group__0 )
            // InternalDefinitionLanguage.g:721:4: rule__AttributeRule__Group__0
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
    // InternalDefinitionLanguage.g:730:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:731:1: ( ruleNumberLiteralRule EOF )
            // InternalDefinitionLanguage.g:732:1: ruleNumberLiteralRule EOF
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
    // InternalDefinitionLanguage.g:739:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:743:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:744:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:744:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalDefinitionLanguage.g:745:3: ( rule__NumberLiteralRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:746:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalDefinitionLanguage.g:746:4: rule__NumberLiteralRule__Alternatives
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
    // InternalDefinitionLanguage.g:755:1: entryRuleRealLiteralRule : ruleRealLiteralRule EOF ;
    public final void entryRuleRealLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:756:1: ( ruleRealLiteralRule EOF )
            // InternalDefinitionLanguage.g:757:1: ruleRealLiteralRule EOF
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
    // InternalDefinitionLanguage.g:764:1: ruleRealLiteralRule : ( ( rule__RealLiteralRule__Group__0 ) ) ;
    public final void ruleRealLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:768:2: ( ( ( rule__RealLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:769:2: ( ( rule__RealLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:769:2: ( ( rule__RealLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:770:3: ( rule__RealLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:771:3: ( rule__RealLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:771:4: rule__RealLiteralRule__Group__0
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
    // InternalDefinitionLanguage.g:780:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:781:1: ( ruleIntegerLiteralRule EOF )
            // InternalDefinitionLanguage.g:782:1: ruleIntegerLiteralRule EOF
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
    // InternalDefinitionLanguage.g:789:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:793:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:794:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:794:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:795:3: ( rule__IntegerLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:796:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:796:4: rule__IntegerLiteralRule__Group__0
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
    // InternalDefinitionLanguage.g:805:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:806:1: ( ruleStringLiteralRule EOF )
            // InternalDefinitionLanguage.g:807:1: ruleStringLiteralRule EOF
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
    // InternalDefinitionLanguage.g:814:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__LiteralAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:818:2: ( ( ( rule__StringLiteralRule__LiteralAssignment ) ) )
            // InternalDefinitionLanguage.g:819:2: ( ( rule__StringLiteralRule__LiteralAssignment ) )
            {
            // InternalDefinitionLanguage.g:819:2: ( ( rule__StringLiteralRule__LiteralAssignment ) )
            // InternalDefinitionLanguage.g:820:3: ( rule__StringLiteralRule__LiteralAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRuleAccess().getLiteralAssignment()); 
            }
            // InternalDefinitionLanguage.g:821:3: ( rule__StringLiteralRule__LiteralAssignment )
            // InternalDefinitionLanguage.g:821:4: rule__StringLiteralRule__LiteralAssignment
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
    // InternalDefinitionLanguage.g:830:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:831:1: ( ruleBooleanLiteralRule EOF )
            // InternalDefinitionLanguage.g:832:1: ruleBooleanLiteralRule EOF
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
    // InternalDefinitionLanguage.g:839:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:843:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:844:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:844:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:845:3: ( rule__BooleanLiteralRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:846:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:846:4: rule__BooleanLiteralRule__Group__0
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
    // InternalDefinitionLanguage.g:855:1: entryRuleClassDefinitionRule : ruleClassDefinitionRule EOF ;
    public final void entryRuleClassDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:856:1: ( ruleClassDefinitionRule EOF )
            // InternalDefinitionLanguage.g:857:1: ruleClassDefinitionRule EOF
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
    // InternalDefinitionLanguage.g:864:1: ruleClassDefinitionRule : ( ( rule__ClassDefinitionRule__Group__0 ) ) ;
    public final void ruleClassDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:868:2: ( ( ( rule__ClassDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:869:2: ( ( rule__ClassDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:869:2: ( ( rule__ClassDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:870:3: ( rule__ClassDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:871:3: ( rule__ClassDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:871:4: rule__ClassDefinitionRule__Group__0
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
    // InternalDefinitionLanguage.g:880:1: entryRuleConstraintRule : ruleConstraintRule EOF ;
    public final void entryRuleConstraintRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:881:1: ( ruleConstraintRule EOF )
            // InternalDefinitionLanguage.g:882:1: ruleConstraintRule EOF
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
    // InternalDefinitionLanguage.g:889:1: ruleConstraintRule : ( ( rule__ConstraintRule__Group__0 ) ) ;
    public final void ruleConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:893:2: ( ( ( rule__ConstraintRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:894:2: ( ( rule__ConstraintRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:894:2: ( ( rule__ConstraintRule__Group__0 ) )
            // InternalDefinitionLanguage.g:895:3: ( rule__ConstraintRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:896:3: ( rule__ConstraintRule__Group__0 )
            // InternalDefinitionLanguage.g:896:4: rule__ConstraintRule__Group__0
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
    // InternalDefinitionLanguage.g:905:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:906:1: ( ruleAttributeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:907:1: ruleAttributeDefinitionRule EOF
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
    // InternalDefinitionLanguage.g:914:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:918:2: ( ( ( rule__AttributeDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:919:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:919:2: ( ( rule__AttributeDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:920:3: ( rule__AttributeDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:921:3: ( rule__AttributeDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:921:4: rule__AttributeDefinitionRule__Group__0
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
    // InternalDefinitionLanguage.g:930:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:931:1: ( ruleTypeRule EOF )
            // InternalDefinitionLanguage.g:932:1: ruleTypeRule EOF
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
    // InternalDefinitionLanguage.g:939:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:943:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:944:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:944:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalDefinitionLanguage.g:945:3: ( rule__TypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:946:3: ( rule__TypeRule__Alternatives )
            // InternalDefinitionLanguage.g:946:4: rule__TypeRule__Alternatives
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
    // InternalDefinitionLanguage.g:955:1: entryRuleBaseTypeRule : ruleBaseTypeRule EOF ;
    public final void entryRuleBaseTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:956:1: ( ruleBaseTypeRule EOF )
            // InternalDefinitionLanguage.g:957:1: ruleBaseTypeRule EOF
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
    // InternalDefinitionLanguage.g:964:1: ruleBaseTypeRule : ( ( rule__BaseTypeRule__Alternatives ) ) ;
    public final void ruleBaseTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:968:2: ( ( ( rule__BaseTypeRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:969:2: ( ( rule__BaseTypeRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:969:2: ( ( rule__BaseTypeRule__Alternatives ) )
            // InternalDefinitionLanguage.g:970:3: ( rule__BaseTypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseTypeRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:971:3: ( rule__BaseTypeRule__Alternatives )
            // InternalDefinitionLanguage.g:971:4: rule__BaseTypeRule__Alternatives
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
    // InternalDefinitionLanguage.g:980:1: entryRuleEnumReferenceRule : ruleEnumReferenceRule EOF ;
    public final void entryRuleEnumReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:981:1: ( ruleEnumReferenceRule EOF )
            // InternalDefinitionLanguage.g:982:1: ruleEnumReferenceRule EOF
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
    // InternalDefinitionLanguage.g:989:1: ruleEnumReferenceRule : ( ( rule__EnumReferenceRule__Group__0 ) ) ;
    public final void ruleEnumReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:993:2: ( ( ( rule__EnumReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:994:2: ( ( rule__EnumReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:994:2: ( ( rule__EnumReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:995:3: ( rule__EnumReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:996:3: ( rule__EnumReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:996:4: rule__EnumReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:1005:1: entryRuleTypeReferenceRule : ruleTypeReferenceRule EOF ;
    public final void entryRuleTypeReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1006:1: ( ruleTypeReferenceRule EOF )
            // InternalDefinitionLanguage.g:1007:1: ruleTypeReferenceRule EOF
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
    // InternalDefinitionLanguage.g:1014:1: ruleTypeReferenceRule : ( ( rule__TypeReferenceRule__Group__0 ) ) ;
    public final void ruleTypeReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1018:2: ( ( ( rule__TypeReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1019:2: ( ( rule__TypeReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1019:2: ( ( rule__TypeReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1020:3: ( rule__TypeReferenceRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1021:3: ( rule__TypeReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:1021:4: rule__TypeReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:1030:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1031:1: ( ruleLiteralTypeRule EOF )
            // InternalDefinitionLanguage.g:1032:1: ruleLiteralTypeRule EOF
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
    // InternalDefinitionLanguage.g:1039:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1043:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1044:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1044:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1045:3: ( rule__LiteralTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1046:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1046:4: rule__LiteralTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1055:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1056:1: ( ruleDataTypeRule EOF )
            // InternalDefinitionLanguage.g:1057:1: ruleDataTypeRule EOF
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
    // InternalDefinitionLanguage.g:1064:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1068:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1069:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1069:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1070:3: ( rule__DataTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1071:3: ( rule__DataTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1071:4: rule__DataTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1080:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1081:1: ( ruleStringTypeRule EOF )
            // InternalDefinitionLanguage.g:1082:1: ruleStringTypeRule EOF
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
    // InternalDefinitionLanguage.g:1089:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1093:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1094:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1094:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1095:3: ( rule__StringTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1096:3: ( rule__StringTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1096:4: rule__StringTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1105:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1106:1: ( ruleExpressionTypeRule EOF )
            // InternalDefinitionLanguage.g:1107:1: ruleExpressionTypeRule EOF
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
    // InternalDefinitionLanguage.g:1114:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1118:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1119:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1119:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1120:3: ( rule__ExpressionTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1121:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1121:4: rule__ExpressionTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1130:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1131:1: ( ruleIntTypeRule EOF )
            // InternalDefinitionLanguage.g:1132:1: ruleIntTypeRule EOF
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
    // InternalDefinitionLanguage.g:1139:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1143:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1144:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1144:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1145:3: ( rule__IntTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1146:3: ( rule__IntTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1146:4: rule__IntTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1155:1: entryRuleRealTypeRule : ruleRealTypeRule EOF ;
    public final void entryRuleRealTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1156:1: ( ruleRealTypeRule EOF )
            // InternalDefinitionLanguage.g:1157:1: ruleRealTypeRule EOF
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
    // InternalDefinitionLanguage.g:1164:1: ruleRealTypeRule : ( ( rule__RealTypeRule__Group__0 ) ) ;
    public final void ruleRealTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1168:2: ( ( ( rule__RealTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1169:2: ( ( rule__RealTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1169:2: ( ( rule__RealTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1170:3: ( rule__RealTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1171:3: ( rule__RealTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1171:4: rule__RealTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1180:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1181:1: ( ruleBooleanTypeRule EOF )
            // InternalDefinitionLanguage.g:1182:1: ruleBooleanTypeRule EOF
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
    // InternalDefinitionLanguage.g:1189:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1193:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1194:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1194:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1195:3: ( rule__BooleanTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1196:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1196:4: rule__BooleanTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1205:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1206:1: ( ruleVoidTypeRule EOF )
            // InternalDefinitionLanguage.g:1207:1: ruleVoidTypeRule EOF
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
    // InternalDefinitionLanguage.g:1214:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1218:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1219:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1219:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1220:3: ( rule__VoidTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1221:3: ( rule__VoidTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1221:4: rule__VoidTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1230:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1231:1: ( ruleArrayTypeRule EOF )
            // InternalDefinitionLanguage.g:1232:1: ruleArrayTypeRule EOF
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
    // InternalDefinitionLanguage.g:1239:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1243:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1244:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1244:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1245:3: ( rule__ArrayTypeRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1246:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:1246:4: rule__ArrayTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:1255:1: entryRuleFunctionDefinitionRule : ruleFunctionDefinitionRule EOF ;
    public final void entryRuleFunctionDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1256:1: ( ruleFunctionDefinitionRule EOF )
            // InternalDefinitionLanguage.g:1257:1: ruleFunctionDefinitionRule EOF
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
    // InternalDefinitionLanguage.g:1264:1: ruleFunctionDefinitionRule : ( ( rule__FunctionDefinitionRule__Group__0 ) ) ;
    public final void ruleFunctionDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1268:2: ( ( ( rule__FunctionDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1269:2: ( ( rule__FunctionDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1269:2: ( ( rule__FunctionDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1270:3: ( rule__FunctionDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1271:3: ( rule__FunctionDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:1271:4: rule__FunctionDefinitionRule__Group__0
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
    // InternalDefinitionLanguage.g:1280:1: entryRuleConstantDefinitionRule : ruleConstantDefinitionRule EOF ;
    public final void entryRuleConstantDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1281:1: ( ruleConstantDefinitionRule EOF )
            // InternalDefinitionLanguage.g:1282:1: ruleConstantDefinitionRule EOF
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
    // InternalDefinitionLanguage.g:1289:1: ruleConstantDefinitionRule : ( ( rule__ConstantDefinitionRule__Group__0 ) ) ;
    public final void ruleConstantDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1293:2: ( ( ( rule__ConstantDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1294:2: ( ( rule__ConstantDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1294:2: ( ( rule__ConstantDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1295:3: ( rule__ConstantDefinitionRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1296:3: ( rule__ConstantDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:1296:4: rule__ConstantDefinitionRule__Group__0
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
    // InternalDefinitionLanguage.g:1305:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1306:1: ( ruleParameterRule EOF )
            // InternalDefinitionLanguage.g:1307:1: ruleParameterRule EOF
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
    // InternalDefinitionLanguage.g:1314:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1318:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1319:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1319:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1320:3: ( rule__ParameterRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1321:3: ( rule__ParameterRule__Group__0 )
            // InternalDefinitionLanguage.g:1321:4: rule__ParameterRule__Group__0
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
    // InternalDefinitionLanguage.g:1330:1: entryRuleImportRule : ruleImportRule EOF ;
    public final void entryRuleImportRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1331:1: ( ruleImportRule EOF )
            // InternalDefinitionLanguage.g:1332:1: ruleImportRule EOF
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
    // InternalDefinitionLanguage.g:1339:1: ruleImportRule : ( ( rule__ImportRule__Group__0 ) ) ;
    public final void ruleImportRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1343:2: ( ( ( rule__ImportRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1344:2: ( ( rule__ImportRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1344:2: ( ( rule__ImportRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1345:3: ( rule__ImportRule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1346:3: ( rule__ImportRule__Group__0 )
            // InternalDefinitionLanguage.g:1346:4: rule__ImportRule__Group__0
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
    // InternalDefinitionLanguage.g:1355:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1356:1: ( ruleQualifiedName EOF )
            // InternalDefinitionLanguage.g:1357:1: ruleQualifiedName EOF
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
    // InternalDefinitionLanguage.g:1364:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1368:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1369:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1369:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalDefinitionLanguage.g:1370:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalDefinitionLanguage.g:1371:3: ( rule__QualifiedName__Group__0 )
            // InternalDefinitionLanguage.g:1371:4: rule__QualifiedName__Group__0
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
    // InternalDefinitionLanguage.g:1380:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1381:1: ( ruleStringOrId EOF )
            // InternalDefinitionLanguage.g:1382:1: ruleStringOrId EOF
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
    // InternalDefinitionLanguage.g:1389:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1393:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1394:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1394:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalDefinitionLanguage.g:1395:3: ( rule__StringOrId__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1396:3: ( rule__StringOrId__Alternatives )
            // InternalDefinitionLanguage.g:1396:4: rule__StringOrId__Alternatives
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
    // InternalDefinitionLanguage.g:1405:1: ruleScaleType : ( ( rule__ScaleType__Alternatives ) ) ;
    public final void ruleScaleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1409:1: ( ( ( rule__ScaleType__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1410:2: ( ( rule__ScaleType__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1410:2: ( ( rule__ScaleType__Alternatives ) )
            // InternalDefinitionLanguage.g:1411:3: ( rule__ScaleType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScaleTypeAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1412:3: ( rule__ScaleType__Alternatives )
            // InternalDefinitionLanguage.g:1412:4: rule__ScaleType__Alternatives
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
    // InternalDefinitionLanguage.g:1421:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1425:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1426:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1426:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1427:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1428:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1428:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalDefinitionLanguage.g:1437:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1441:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1442:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1442:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1443:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1444:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1444:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalDefinitionLanguage.g:1453:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1457:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1458:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1458:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1459:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1460:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1460:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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
    // InternalDefinitionLanguage.g:1469:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1473:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1474:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1474:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1475:3: ( rule__FactorRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            }
            // InternalDefinitionLanguage.g:1476:3: ( rule__FactorRule__Alternatives )
            // InternalDefinitionLanguage.g:1476:4: rule__FactorRule__Alternatives
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
    // InternalDefinitionLanguage.g:1484:1: rule__DefinitionModelRule__Alternatives_4 : ( ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) ) | ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) ) | ( ( rule__DefinitionModelRule__ConstantsAssignment_4_3 ) ) );
    public final void rule__DefinitionModelRule__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1488:1: ( ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) ) | ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) ) | ( ( rule__DefinitionModelRule__ConstantsAssignment_4_3 ) ) )
            int alt1=4;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalDefinitionLanguage.g:1489:2: ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) )
                    {
                    // InternalDefinitionLanguage.g:1489:2: ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) )
                    // InternalDefinitionLanguage.g:1490:3: ( rule__DefinitionModelRule__EnumsAssignment_4_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDefinitionModelRuleAccess().getEnumsAssignment_4_0()); 
                    }
                    // InternalDefinitionLanguage.g:1491:3: ( rule__DefinitionModelRule__EnumsAssignment_4_0 )
                    // InternalDefinitionLanguage.g:1491:4: rule__DefinitionModelRule__EnumsAssignment_4_0
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
                    // InternalDefinitionLanguage.g:1495:2: ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) )
                    {
                    // InternalDefinitionLanguage.g:1495:2: ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) )
                    // InternalDefinitionLanguage.g:1496:3: ( rule__DefinitionModelRule__TypesAssignment_4_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDefinitionModelRuleAccess().getTypesAssignment_4_1()); 
                    }
                    // InternalDefinitionLanguage.g:1497:3: ( rule__DefinitionModelRule__TypesAssignment_4_1 )
                    // InternalDefinitionLanguage.g:1497:4: rule__DefinitionModelRule__TypesAssignment_4_1
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
                    // InternalDefinitionLanguage.g:1501:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) )
                    {
                    // InternalDefinitionLanguage.g:1501:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) )
                    // InternalDefinitionLanguage.g:1502:3: ( rule__DefinitionModelRule__FunctionsAssignment_4_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDefinitionModelRuleAccess().getFunctionsAssignment_4_2()); 
                    }
                    // InternalDefinitionLanguage.g:1503:3: ( rule__DefinitionModelRule__FunctionsAssignment_4_2 )
                    // InternalDefinitionLanguage.g:1503:4: rule__DefinitionModelRule__FunctionsAssignment_4_2
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
                    // InternalDefinitionLanguage.g:1507:2: ( ( rule__DefinitionModelRule__ConstantsAssignment_4_3 ) )
                    {
                    // InternalDefinitionLanguage.g:1507:2: ( ( rule__DefinitionModelRule__ConstantsAssignment_4_3 ) )
                    // InternalDefinitionLanguage.g:1508:3: ( rule__DefinitionModelRule__ConstantsAssignment_4_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDefinitionModelRuleAccess().getConstantsAssignment_4_3()); 
                    }
                    // InternalDefinitionLanguage.g:1509:3: ( rule__DefinitionModelRule__ConstantsAssignment_4_3 )
                    // InternalDefinitionLanguage.g:1509:4: rule__DefinitionModelRule__ConstantsAssignment_4_3
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
    // InternalDefinitionLanguage.g:1517:1: rule__ReadExpressionRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );
    public final void rule__ReadExpressionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1521:1: ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) )
            int alt2=5;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalDefinitionLanguage.g:1522:2: ( ruleArrayRule )
                    {
                    // InternalDefinitionLanguage.g:1522:2: ( ruleArrayRule )
                    // InternalDefinitionLanguage.g:1523:3: ruleArrayRule
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
                    // InternalDefinitionLanguage.g:1528:2: ( ruleCallRule )
                    {
                    // InternalDefinitionLanguage.g:1528:2: ( ruleCallRule )
                    // InternalDefinitionLanguage.g:1529:3: ruleCallRule
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
                    // InternalDefinitionLanguage.g:1534:2: ( ruleLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1534:2: ( ruleLiteralRule )
                    // InternalDefinitionLanguage.g:1535:3: ruleLiteralRule
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
                    // InternalDefinitionLanguage.g:1540:2: ( ruleParanthesesRule )
                    {
                    // InternalDefinitionLanguage.g:1540:2: ( ruleParanthesesRule )
                    // InternalDefinitionLanguage.g:1541:3: ruleParanthesesRule
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
                    // InternalDefinitionLanguage.g:1546:2: ( ruleReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1546:2: ( ruleReferenceRule )
                    // InternalDefinitionLanguage.g:1547:3: ruleReferenceRule
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
    // InternalDefinitionLanguage.g:1556:1: rule__ReferenceRule__Alternatives : ( ( ruleLiteralDefinitionReferenceRule ) | ( ruleTypeDefinitionReferenceRule ) );
    public final void rule__ReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1560:1: ( ( ruleLiteralDefinitionReferenceRule ) | ( ruleTypeDefinitionReferenceRule ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_QUOTED_ID && LA3_0<=RULE_ID)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=68 && LA3_0<=69)) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalDefinitionLanguage.g:1561:2: ( ruleLiteralDefinitionReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1561:2: ( ruleLiteralDefinitionReferenceRule )
                    // InternalDefinitionLanguage.g:1562:3: ruleLiteralDefinitionReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceRuleAccess().getLiteralDefinitionReferenceRuleParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteralDefinitionReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceRuleAccess().getLiteralDefinitionReferenceRuleParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1567:2: ( ruleTypeDefinitionReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1567:2: ( ruleTypeDefinitionReferenceRule )
                    // InternalDefinitionLanguage.g:1568:3: ruleTypeDefinitionReferenceRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceRuleAccess().getTypeDefinitionReferenceRuleParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleTypeDefinitionReferenceRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceRuleAccess().getTypeDefinitionReferenceRuleParserRuleCall_1()); 
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


    // $ANTLR start "rule__TypeDefinitionReferenceRule__Alternatives"
    // InternalDefinitionLanguage.g:1577:1: rule__TypeDefinitionReferenceRule__Alternatives : ( ( ruleBaseDataReferenceRule ) | ( ruleStructuredDataDescriptionReferenceRule ) );
    public final void rule__TypeDefinitionReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1581:1: ( ( ruleBaseDataReferenceRule ) | ( ruleStructuredDataDescriptionReferenceRule ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==68) ) {
                alt4=1;
            }
            else if ( (LA4_0==69) ) {
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
                    // InternalDefinitionLanguage.g:1582:2: ( ruleBaseDataReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1582:2: ( ruleBaseDataReferenceRule )
                    // InternalDefinitionLanguage.g:1583:3: ruleBaseDataReferenceRule
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
                    // InternalDefinitionLanguage.g:1588:2: ( ruleStructuredDataDescriptionReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1588:2: ( ruleStructuredDataDescriptionReferenceRule )
                    // InternalDefinitionLanguage.g:1589:3: ruleStructuredDataDescriptionReferenceRule
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
    // InternalDefinitionLanguage.g:1598:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1602:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleInstanceLiteralRule ) )
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
            case 88:
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
                    // InternalDefinitionLanguage.g:1603:2: ( ruleNumberLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1603:2: ( ruleNumberLiteralRule )
                    // InternalDefinitionLanguage.g:1604:3: ruleNumberLiteralRule
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
                    // InternalDefinitionLanguage.g:1609:2: ( ruleStringLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1609:2: ( ruleStringLiteralRule )
                    // InternalDefinitionLanguage.g:1610:3: ruleStringLiteralRule
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
                    // InternalDefinitionLanguage.g:1615:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1615:2: ( ruleBooleanLiteralRule )
                    // InternalDefinitionLanguage.g:1616:3: ruleBooleanLiteralRule
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
                    // InternalDefinitionLanguage.g:1621:2: ( ruleInstanceLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1621:2: ( ruleInstanceLiteralRule )
                    // InternalDefinitionLanguage.g:1622:3: ruleInstanceLiteralRule
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
    // InternalDefinitionLanguage.g:1631:1: rule__NumberLiteralRule__Alternatives : ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1635:1: ( ( ruleRealLiteralRule ) | ( ruleIntegerLiteralRule ) )
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
                    // InternalDefinitionLanguage.g:1636:2: ( ruleRealLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1636:2: ( ruleRealLiteralRule )
                    // InternalDefinitionLanguage.g:1637:3: ruleRealLiteralRule
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
                    // InternalDefinitionLanguage.g:1642:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1642:2: ( ruleIntegerLiteralRule )
                    // InternalDefinitionLanguage.g:1643:3: ruleIntegerLiteralRule
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
    // InternalDefinitionLanguage.g:1652:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1656:1: ( ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) ) | ( 'false' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==88) ) {
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
                    // InternalDefinitionLanguage.g:1657:2: ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) )
                    {
                    // InternalDefinitionLanguage.g:1657:2: ( ( rule__BooleanLiteralRule__LiteralAssignment_1_0 ) )
                    // InternalDefinitionLanguage.g:1658:3: ( rule__BooleanLiteralRule__LiteralAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralAssignment_1_0()); 
                    }
                    // InternalDefinitionLanguage.g:1659:3: ( rule__BooleanLiteralRule__LiteralAssignment_1_0 )
                    // InternalDefinitionLanguage.g:1659:4: rule__BooleanLiteralRule__LiteralAssignment_1_0
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
                    // InternalDefinitionLanguage.g:1663:2: ( 'false' )
                    {
                    // InternalDefinitionLanguage.g:1663:2: ( 'false' )
                    // InternalDefinitionLanguage.g:1664:3: 'false'
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
    // InternalDefinitionLanguage.g:1673:1: rule__TypeRule__Alternatives : ( ( ruleArrayTypeRule ) | ( ruleBaseTypeRule ) | ( ruleTypeReferenceRule ) | ( ruleEnumReferenceRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1677:1: ( ( ruleArrayTypeRule ) | ( ruleBaseTypeRule ) | ( ruleTypeReferenceRule ) | ( ruleEnumReferenceRule ) | ( ruleExpressionTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleDataTypeRule ) )
            int alt8=7;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt8=1;
                }
                break;
            case 75:
            case 77:
            case 78:
            case 79:
            case 80:
                {
                alt8=2;
                }
                break;
            case 69:
                {
                alt8=3;
                }
                break;
            case 54:
                {
                alt8=4;
                }
                break;
            case 76:
                {
                alt8=5;
                }
                break;
            case 74:
                {
                alt8=6;
                }
                break;
            case 68:
                {
                alt8=7;
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
                    // InternalDefinitionLanguage.g:1678:2: ( ruleArrayTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1678:2: ( ruleArrayTypeRule )
                    // InternalDefinitionLanguage.g:1679:3: ruleArrayTypeRule
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
                    // InternalDefinitionLanguage.g:1684:2: ( ruleBaseTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1684:2: ( ruleBaseTypeRule )
                    // InternalDefinitionLanguage.g:1685:3: ruleBaseTypeRule
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
                    // InternalDefinitionLanguage.g:1690:2: ( ruleTypeReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1690:2: ( ruleTypeReferenceRule )
                    // InternalDefinitionLanguage.g:1691:3: ruleTypeReferenceRule
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
                    // InternalDefinitionLanguage.g:1696:2: ( ruleEnumReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1696:2: ( ruleEnumReferenceRule )
                    // InternalDefinitionLanguage.g:1697:3: ruleEnumReferenceRule
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
                    // InternalDefinitionLanguage.g:1702:2: ( ruleExpressionTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1702:2: ( ruleExpressionTypeRule )
                    // InternalDefinitionLanguage.g:1703:3: ruleExpressionTypeRule
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
                    // InternalDefinitionLanguage.g:1708:2: ( ruleLiteralTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1708:2: ( ruleLiteralTypeRule )
                    // InternalDefinitionLanguage.g:1709:3: ruleLiteralTypeRule
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
                    // InternalDefinitionLanguage.g:1714:2: ( ruleDataTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1714:2: ( ruleDataTypeRule )
                    // InternalDefinitionLanguage.g:1715:3: ruleDataTypeRule
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
    // InternalDefinitionLanguage.g:1724:1: rule__BaseTypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleVoidTypeRule ) );
    public final void rule__BaseTypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1728:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleRealTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleVoidTypeRule ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt9=1;
                }
                break;
            case 77:
                {
                alt9=2;
                }
                break;
            case 78:
                {
                alt9=3;
                }
                break;
            case 79:
                {
                alt9=4;
                }
                break;
            case 80:
                {
                alt9=5;
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
                    // InternalDefinitionLanguage.g:1729:2: ( ruleStringTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1729:2: ( ruleStringTypeRule )
                    // InternalDefinitionLanguage.g:1730:3: ruleStringTypeRule
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
                    // InternalDefinitionLanguage.g:1735:2: ( ruleIntTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1735:2: ( ruleIntTypeRule )
                    // InternalDefinitionLanguage.g:1736:3: ruleIntTypeRule
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
                    // InternalDefinitionLanguage.g:1741:2: ( ruleRealTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1741:2: ( ruleRealTypeRule )
                    // InternalDefinitionLanguage.g:1742:3: ruleRealTypeRule
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
                    // InternalDefinitionLanguage.g:1747:2: ( ruleBooleanTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1747:2: ( ruleBooleanTypeRule )
                    // InternalDefinitionLanguage.g:1748:3: ruleBooleanTypeRule
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
                    // InternalDefinitionLanguage.g:1753:2: ( ruleVoidTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1753:2: ( ruleVoidTypeRule )
                    // InternalDefinitionLanguage.g:1754:3: ruleVoidTypeRule
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
    // InternalDefinitionLanguage.g:1763:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1767:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_QUOTED_ID) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalDefinitionLanguage.g:1768:2: ( RULE_QUOTED_ID )
                    {
                    // InternalDefinitionLanguage.g:1768:2: ( RULE_QUOTED_ID )
                    // InternalDefinitionLanguage.g:1769:3: RULE_QUOTED_ID
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
                    // InternalDefinitionLanguage.g:1774:2: ( RULE_ID )
                    {
                    // InternalDefinitionLanguage.g:1774:2: ( RULE_ID )
                    // InternalDefinitionLanguage.g:1775:3: RULE_ID
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
    // InternalDefinitionLanguage.g:1784:1: rule__ScaleType__Alternatives : ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) );
    public final void rule__ScaleType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1788:1: ( ( ( 'nominal' ) ) | ( ( 'ordinal' ) ) | ( ( 'cardinal' ) ) | ( ( 'quotient' ) ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt11=1;
                }
                break;
            case 17:
                {
                alt11=2;
                }
                break;
            case 18:
                {
                alt11=3;
                }
                break;
            case 19:
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
                    // InternalDefinitionLanguage.g:1789:2: ( ( 'nominal' ) )
                    {
                    // InternalDefinitionLanguage.g:1789:2: ( ( 'nominal' ) )
                    // InternalDefinitionLanguage.g:1790:3: ( 'nominal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0()); 
                    }
                    // InternalDefinitionLanguage.g:1791:3: ( 'nominal' )
                    // InternalDefinitionLanguage.g:1791:4: 'nominal'
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
                    // InternalDefinitionLanguage.g:1795:2: ( ( 'ordinal' ) )
                    {
                    // InternalDefinitionLanguage.g:1795:2: ( ( 'ordinal' ) )
                    // InternalDefinitionLanguage.g:1796:3: ( 'ordinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1()); 
                    }
                    // InternalDefinitionLanguage.g:1797:3: ( 'ordinal' )
                    // InternalDefinitionLanguage.g:1797:4: 'ordinal'
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
                    // InternalDefinitionLanguage.g:1801:2: ( ( 'cardinal' ) )
                    {
                    // InternalDefinitionLanguage.g:1801:2: ( ( 'cardinal' ) )
                    // InternalDefinitionLanguage.g:1802:3: ( 'cardinal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2()); 
                    }
                    // InternalDefinitionLanguage.g:1803:3: ( 'cardinal' )
                    // InternalDefinitionLanguage.g:1803:4: 'cardinal'
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
                    // InternalDefinitionLanguage.g:1807:2: ( ( 'quotient' ) )
                    {
                    // InternalDefinitionLanguage.g:1807:2: ( ( 'quotient' ) )
                    // InternalDefinitionLanguage.g:1808:3: ( 'quotient' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getScaleTypeAccess().getQuotientEnumLiteralDeclaration_3()); 
                    }
                    // InternalDefinitionLanguage.g:1809:3: ( 'quotient' )
                    // InternalDefinitionLanguage.g:1809:4: 'quotient'
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
    // InternalDefinitionLanguage.g:1817:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1821:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt12=6;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt12=1;
                }
                break;
            case 21:
                {
                alt12=2;
                }
                break;
            case 22:
                {
                alt12=3;
                }
                break;
            case 23:
                {
                alt12=4;
                }
                break;
            case 24:
                {
                alt12=5;
                }
                break;
            case 25:
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
                    // InternalDefinitionLanguage.g:1822:2: ( ( '>=' ) )
                    {
                    // InternalDefinitionLanguage.g:1822:2: ( ( '>=' ) )
                    // InternalDefinitionLanguage.g:1823:3: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    }
                    // InternalDefinitionLanguage.g:1824:3: ( '>=' )
                    // InternalDefinitionLanguage.g:1824:4: '>='
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
                    // InternalDefinitionLanguage.g:1828:2: ( ( '>' ) )
                    {
                    // InternalDefinitionLanguage.g:1828:2: ( ( '>' ) )
                    // InternalDefinitionLanguage.g:1829:3: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    }
                    // InternalDefinitionLanguage.g:1830:3: ( '>' )
                    // InternalDefinitionLanguage.g:1830:4: '>'
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
                    // InternalDefinitionLanguage.g:1834:2: ( ( '=' ) )
                    {
                    // InternalDefinitionLanguage.g:1834:2: ( ( '=' ) )
                    // InternalDefinitionLanguage.g:1835:3: ( '=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    }
                    // InternalDefinitionLanguage.g:1836:3: ( '=' )
                    // InternalDefinitionLanguage.g:1836:4: '='
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
                    // InternalDefinitionLanguage.g:1840:2: ( ( '!=' ) )
                    {
                    // InternalDefinitionLanguage.g:1840:2: ( ( '!=' ) )
                    // InternalDefinitionLanguage.g:1841:3: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    }
                    // InternalDefinitionLanguage.g:1842:3: ( '!=' )
                    // InternalDefinitionLanguage.g:1842:4: '!='
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
                    // InternalDefinitionLanguage.g:1846:2: ( ( '<' ) )
                    {
                    // InternalDefinitionLanguage.g:1846:2: ( ( '<' ) )
                    // InternalDefinitionLanguage.g:1847:3: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    }
                    // InternalDefinitionLanguage.g:1848:3: ( '<' )
                    // InternalDefinitionLanguage.g:1848:4: '<'
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
                    // InternalDefinitionLanguage.g:1852:2: ( ( '<=' ) )
                    {
                    // InternalDefinitionLanguage.g:1852:2: ( ( '<=' ) )
                    // InternalDefinitionLanguage.g:1853:3: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    }
                    // InternalDefinitionLanguage.g:1854:3: ( '<=' )
                    // InternalDefinitionLanguage.g:1854:4: '<='
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
    // InternalDefinitionLanguage.g:1862:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1866:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            else if ( (LA13_0==27) ) {
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
                    // InternalDefinitionLanguage.g:1867:2: ( ( '+' ) )
                    {
                    // InternalDefinitionLanguage.g:1867:2: ( ( '+' ) )
                    // InternalDefinitionLanguage.g:1868:3: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    }
                    // InternalDefinitionLanguage.g:1869:3: ( '+' )
                    // InternalDefinitionLanguage.g:1869:4: '+'
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
                    // InternalDefinitionLanguage.g:1873:2: ( ( '-' ) )
                    {
                    // InternalDefinitionLanguage.g:1873:2: ( ( '-' ) )
                    // InternalDefinitionLanguage.g:1874:3: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    }
                    // InternalDefinitionLanguage.g:1875:3: ( '-' )
                    // InternalDefinitionLanguage.g:1875:4: '-'
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
    // InternalDefinitionLanguage.g:1883:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1887:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt14=1;
                }
                break;
            case 29:
                {
                alt14=2;
                }
                break;
            case 30:
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
                    // InternalDefinitionLanguage.g:1888:2: ( ( '*' ) )
                    {
                    // InternalDefinitionLanguage.g:1888:2: ( ( '*' ) )
                    // InternalDefinitionLanguage.g:1889:3: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    }
                    // InternalDefinitionLanguage.g:1890:3: ( '*' )
                    // InternalDefinitionLanguage.g:1890:4: '*'
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
                    // InternalDefinitionLanguage.g:1894:2: ( ( '/' ) )
                    {
                    // InternalDefinitionLanguage.g:1894:2: ( ( '/' ) )
                    // InternalDefinitionLanguage.g:1895:3: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    }
                    // InternalDefinitionLanguage.g:1896:3: ( '/' )
                    // InternalDefinitionLanguage.g:1896:4: '/'
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
                    // InternalDefinitionLanguage.g:1900:2: ( ( '%' ) )
                    {
                    // InternalDefinitionLanguage.g:1900:2: ( ( '%' ) )
                    // InternalDefinitionLanguage.g:1901:3: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    }
                    // InternalDefinitionLanguage.g:1902:3: ( '%' )
                    // InternalDefinitionLanguage.g:1902:4: '%'
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
    // InternalDefinitionLanguage.g:1910:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1914:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt15=20;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt15=1;
                }
                break;
            case 32:
                {
                alt15=2;
                }
                break;
            case 33:
                {
                alt15=3;
                }
                break;
            case 34:
                {
                alt15=4;
                }
                break;
            case 35:
                {
                alt15=5;
                }
                break;
            case 36:
                {
                alt15=6;
                }
                break;
            case 37:
                {
                alt15=7;
                }
                break;
            case 38:
                {
                alt15=8;
                }
                break;
            case 39:
                {
                alt15=9;
                }
                break;
            case 40:
                {
                alt15=10;
                }
                break;
            case 41:
                {
                alt15=11;
                }
                break;
            case 42:
                {
                alt15=12;
                }
                break;
            case 43:
                {
                alt15=13;
                }
                break;
            case 44:
                {
                alt15=14;
                }
                break;
            case 45:
                {
                alt15=15;
                }
                break;
            case 46:
                {
                alt15=16;
                }
                break;
            case 47:
                {
                alt15=17;
                }
                break;
            case 48:
                {
                alt15=18;
                }
                break;
            case 49:
                {
                alt15=19;
                }
                break;
            case 50:
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
                    // InternalDefinitionLanguage.g:1915:2: ( ( 'Y' ) )
                    {
                    // InternalDefinitionLanguage.g:1915:2: ( ( 'Y' ) )
                    // InternalDefinitionLanguage.g:1916:3: ( 'Y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    }
                    // InternalDefinitionLanguage.g:1917:3: ( 'Y' )
                    // InternalDefinitionLanguage.g:1917:4: 'Y'
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
                    // InternalDefinitionLanguage.g:1921:2: ( ( 'Z' ) )
                    {
                    // InternalDefinitionLanguage.g:1921:2: ( ( 'Z' ) )
                    // InternalDefinitionLanguage.g:1922:3: ( 'Z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    }
                    // InternalDefinitionLanguage.g:1923:3: ( 'Z' )
                    // InternalDefinitionLanguage.g:1923:4: 'Z'
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
                    // InternalDefinitionLanguage.g:1927:2: ( ( 'E' ) )
                    {
                    // InternalDefinitionLanguage.g:1927:2: ( ( 'E' ) )
                    // InternalDefinitionLanguage.g:1928:3: ( 'E' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    }
                    // InternalDefinitionLanguage.g:1929:3: ( 'E' )
                    // InternalDefinitionLanguage.g:1929:4: 'E'
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
                    // InternalDefinitionLanguage.g:1933:2: ( ( 'P' ) )
                    {
                    // InternalDefinitionLanguage.g:1933:2: ( ( 'P' ) )
                    // InternalDefinitionLanguage.g:1934:3: ( 'P' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    }
                    // InternalDefinitionLanguage.g:1935:3: ( 'P' )
                    // InternalDefinitionLanguage.g:1935:4: 'P'
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
                    // InternalDefinitionLanguage.g:1939:2: ( ( 'T' ) )
                    {
                    // InternalDefinitionLanguage.g:1939:2: ( ( 'T' ) )
                    // InternalDefinitionLanguage.g:1940:3: ( 'T' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    }
                    // InternalDefinitionLanguage.g:1941:3: ( 'T' )
                    // InternalDefinitionLanguage.g:1941:4: 'T'
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
                    // InternalDefinitionLanguage.g:1945:2: ( ( 'G' ) )
                    {
                    // InternalDefinitionLanguage.g:1945:2: ( ( 'G' ) )
                    // InternalDefinitionLanguage.g:1946:3: ( 'G' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    }
                    // InternalDefinitionLanguage.g:1947:3: ( 'G' )
                    // InternalDefinitionLanguage.g:1947:4: 'G'
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
                    // InternalDefinitionLanguage.g:1951:2: ( ( 'M' ) )
                    {
                    // InternalDefinitionLanguage.g:1951:2: ( ( 'M' ) )
                    // InternalDefinitionLanguage.g:1952:3: ( 'M' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    }
                    // InternalDefinitionLanguage.g:1953:3: ( 'M' )
                    // InternalDefinitionLanguage.g:1953:4: 'M'
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
                    // InternalDefinitionLanguage.g:1957:2: ( ( 'k' ) )
                    {
                    // InternalDefinitionLanguage.g:1957:2: ( ( 'k' ) )
                    // InternalDefinitionLanguage.g:1958:3: ( 'k' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    }
                    // InternalDefinitionLanguage.g:1959:3: ( 'k' )
                    // InternalDefinitionLanguage.g:1959:4: 'k'
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
                    // InternalDefinitionLanguage.g:1963:2: ( ( 'h' ) )
                    {
                    // InternalDefinitionLanguage.g:1963:2: ( ( 'h' ) )
                    // InternalDefinitionLanguage.g:1964:3: ( 'h' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    }
                    // InternalDefinitionLanguage.g:1965:3: ( 'h' )
                    // InternalDefinitionLanguage.g:1965:4: 'h'
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
                    // InternalDefinitionLanguage.g:1969:2: ( ( 'da' ) )
                    {
                    // InternalDefinitionLanguage.g:1969:2: ( ( 'da' ) )
                    // InternalDefinitionLanguage.g:1970:3: ( 'da' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    }
                    // InternalDefinitionLanguage.g:1971:3: ( 'da' )
                    // InternalDefinitionLanguage.g:1971:4: 'da'
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
                    // InternalDefinitionLanguage.g:1975:2: ( ( 'd' ) )
                    {
                    // InternalDefinitionLanguage.g:1975:2: ( ( 'd' ) )
                    // InternalDefinitionLanguage.g:1976:3: ( 'd' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    }
                    // InternalDefinitionLanguage.g:1977:3: ( 'd' )
                    // InternalDefinitionLanguage.g:1977:4: 'd'
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
                    // InternalDefinitionLanguage.g:1981:2: ( ( 'c' ) )
                    {
                    // InternalDefinitionLanguage.g:1981:2: ( ( 'c' ) )
                    // InternalDefinitionLanguage.g:1982:3: ( 'c' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    }
                    // InternalDefinitionLanguage.g:1983:3: ( 'c' )
                    // InternalDefinitionLanguage.g:1983:4: 'c'
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
                    // InternalDefinitionLanguage.g:1987:2: ( ( 'm' ) )
                    {
                    // InternalDefinitionLanguage.g:1987:2: ( ( 'm' ) )
                    // InternalDefinitionLanguage.g:1988:3: ( 'm' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    }
                    // InternalDefinitionLanguage.g:1989:3: ( 'm' )
                    // InternalDefinitionLanguage.g:1989:4: 'm'
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
                    // InternalDefinitionLanguage.g:1993:2: ( ( '\\u00B5' ) )
                    {
                    // InternalDefinitionLanguage.g:1993:2: ( ( '\\u00B5' ) )
                    // InternalDefinitionLanguage.g:1994:3: ( '\\u00B5' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    }
                    // InternalDefinitionLanguage.g:1995:3: ( '\\u00B5' )
                    // InternalDefinitionLanguage.g:1995:4: '\\u00B5'
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
                    // InternalDefinitionLanguage.g:1999:2: ( ( 'n' ) )
                    {
                    // InternalDefinitionLanguage.g:1999:2: ( ( 'n' ) )
                    // InternalDefinitionLanguage.g:2000:3: ( 'n' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    }
                    // InternalDefinitionLanguage.g:2001:3: ( 'n' )
                    // InternalDefinitionLanguage.g:2001:4: 'n'
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
                    // InternalDefinitionLanguage.g:2005:2: ( ( 'p' ) )
                    {
                    // InternalDefinitionLanguage.g:2005:2: ( ( 'p' ) )
                    // InternalDefinitionLanguage.g:2006:3: ( 'p' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    }
                    // InternalDefinitionLanguage.g:2007:3: ( 'p' )
                    // InternalDefinitionLanguage.g:2007:4: 'p'
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
                    // InternalDefinitionLanguage.g:2011:2: ( ( 'f' ) )
                    {
                    // InternalDefinitionLanguage.g:2011:2: ( ( 'f' ) )
                    // InternalDefinitionLanguage.g:2012:3: ( 'f' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    }
                    // InternalDefinitionLanguage.g:2013:3: ( 'f' )
                    // InternalDefinitionLanguage.g:2013:4: 'f'
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
                    // InternalDefinitionLanguage.g:2017:2: ( ( 'a' ) )
                    {
                    // InternalDefinitionLanguage.g:2017:2: ( ( 'a' ) )
                    // InternalDefinitionLanguage.g:2018:3: ( 'a' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    }
                    // InternalDefinitionLanguage.g:2019:3: ( 'a' )
                    // InternalDefinitionLanguage.g:2019:4: 'a'
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
                    // InternalDefinitionLanguage.g:2023:2: ( ( 'z' ) )
                    {
                    // InternalDefinitionLanguage.g:2023:2: ( ( 'z' ) )
                    // InternalDefinitionLanguage.g:2024:3: ( 'z' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    }
                    // InternalDefinitionLanguage.g:2025:3: ( 'z' )
                    // InternalDefinitionLanguage.g:2025:4: 'z'
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
                    // InternalDefinitionLanguage.g:2029:2: ( ( 'y' ) )
                    {
                    // InternalDefinitionLanguage.g:2029:2: ( ( 'y' ) )
                    // InternalDefinitionLanguage.g:2030:3: ( 'y' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    }
                    // InternalDefinitionLanguage.g:2031:3: ( 'y' )
                    // InternalDefinitionLanguage.g:2031:4: 'y'
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
    // InternalDefinitionLanguage.g:2039:1: rule__DefinitionModelRule__Group__0 : rule__DefinitionModelRule__Group__0__Impl rule__DefinitionModelRule__Group__1 ;
    public final void rule__DefinitionModelRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2043:1: ( rule__DefinitionModelRule__Group__0__Impl rule__DefinitionModelRule__Group__1 )
            // InternalDefinitionLanguage.g:2044:2: rule__DefinitionModelRule__Group__0__Impl rule__DefinitionModelRule__Group__1
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
    // InternalDefinitionLanguage.g:2051:1: rule__DefinitionModelRule__Group__0__Impl : ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* ) ;
    public final void rule__DefinitionModelRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2055:1: ( ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:2056:1: ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:2056:1: ( ( rule__DefinitionModelRule__ImportsAssignment_0 )* )
            // InternalDefinitionLanguage.g:2057:2: ( rule__DefinitionModelRule__ImportsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getImportsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:2058:2: ( rule__DefinitionModelRule__ImportsAssignment_0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==84) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2058:3: rule__DefinitionModelRule__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__DefinitionModelRule__ImportsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalDefinitionLanguage.g:2066:1: rule__DefinitionModelRule__Group__1 : rule__DefinitionModelRule__Group__1__Impl rule__DefinitionModelRule__Group__2 ;
    public final void rule__DefinitionModelRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2070:1: ( rule__DefinitionModelRule__Group__1__Impl rule__DefinitionModelRule__Group__2 )
            // InternalDefinitionLanguage.g:2071:2: rule__DefinitionModelRule__Group__1__Impl rule__DefinitionModelRule__Group__2
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
    // InternalDefinitionLanguage.g:2078:1: rule__DefinitionModelRule__Group__1__Impl : ( 'module' ) ;
    public final void rule__DefinitionModelRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2082:1: ( ( 'module' ) )
            // InternalDefinitionLanguage.g:2083:1: ( 'module' )
            {
            // InternalDefinitionLanguage.g:2083:1: ( 'module' )
            // InternalDefinitionLanguage.g:2084:2: 'module'
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
    // InternalDefinitionLanguage.g:2093:1: rule__DefinitionModelRule__Group__2 : rule__DefinitionModelRule__Group__2__Impl rule__DefinitionModelRule__Group__3 ;
    public final void rule__DefinitionModelRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2097:1: ( rule__DefinitionModelRule__Group__2__Impl rule__DefinitionModelRule__Group__3 )
            // InternalDefinitionLanguage.g:2098:2: rule__DefinitionModelRule__Group__2__Impl rule__DefinitionModelRule__Group__3
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
    // InternalDefinitionLanguage.g:2105:1: rule__DefinitionModelRule__Group__2__Impl : ( ( rule__DefinitionModelRule__NameAssignment_2 ) ) ;
    public final void rule__DefinitionModelRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2109:1: ( ( ( rule__DefinitionModelRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:2110:1: ( ( rule__DefinitionModelRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:2110:1: ( ( rule__DefinitionModelRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:2111:2: ( rule__DefinitionModelRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getNameAssignment_2()); 
            }
            // InternalDefinitionLanguage.g:2112:2: ( rule__DefinitionModelRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:2112:3: rule__DefinitionModelRule__NameAssignment_2
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
    // InternalDefinitionLanguage.g:2120:1: rule__DefinitionModelRule__Group__3 : rule__DefinitionModelRule__Group__3__Impl rule__DefinitionModelRule__Group__4 ;
    public final void rule__DefinitionModelRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2124:1: ( rule__DefinitionModelRule__Group__3__Impl rule__DefinitionModelRule__Group__4 )
            // InternalDefinitionLanguage.g:2125:2: rule__DefinitionModelRule__Group__3__Impl rule__DefinitionModelRule__Group__4
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
    // InternalDefinitionLanguage.g:2132:1: rule__DefinitionModelRule__Group__3__Impl : ( '{' ) ;
    public final void rule__DefinitionModelRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2136:1: ( ( '{' ) )
            // InternalDefinitionLanguage.g:2137:1: ( '{' )
            {
            // InternalDefinitionLanguage.g:2137:1: ( '{' )
            // InternalDefinitionLanguage.g:2138:2: '{'
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
    // InternalDefinitionLanguage.g:2147:1: rule__DefinitionModelRule__Group__4 : rule__DefinitionModelRule__Group__4__Impl rule__DefinitionModelRule__Group__5 ;
    public final void rule__DefinitionModelRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2151:1: ( rule__DefinitionModelRule__Group__4__Impl rule__DefinitionModelRule__Group__5 )
            // InternalDefinitionLanguage.g:2152:2: rule__DefinitionModelRule__Group__4__Impl rule__DefinitionModelRule__Group__5
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
    // InternalDefinitionLanguage.g:2159:1: rule__DefinitionModelRule__Group__4__Impl : ( ( rule__DefinitionModelRule__Alternatives_4 )* ) ;
    public final void rule__DefinitionModelRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2163:1: ( ( ( rule__DefinitionModelRule__Alternatives_4 )* ) )
            // InternalDefinitionLanguage.g:2164:1: ( ( rule__DefinitionModelRule__Alternatives_4 )* )
            {
            // InternalDefinitionLanguage.g:2164:1: ( ( rule__DefinitionModelRule__Alternatives_4 )* )
            // InternalDefinitionLanguage.g:2165:2: ( rule__DefinitionModelRule__Alternatives_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDefinitionModelRuleAccess().getAlternatives_4()); 
            }
            // InternalDefinitionLanguage.g:2166:2: ( rule__DefinitionModelRule__Alternatives_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=16 && LA17_0<=19)||LA17_0==71||LA17_0==73||(LA17_0>=82 && LA17_0<=83)||LA17_0==89) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2166:3: rule__DefinitionModelRule__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__DefinitionModelRule__Alternatives_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalDefinitionLanguage.g:2174:1: rule__DefinitionModelRule__Group__5 : rule__DefinitionModelRule__Group__5__Impl ;
    public final void rule__DefinitionModelRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2178:1: ( rule__DefinitionModelRule__Group__5__Impl )
            // InternalDefinitionLanguage.g:2179:2: rule__DefinitionModelRule__Group__5__Impl
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
    // InternalDefinitionLanguage.g:2185:1: rule__DefinitionModelRule__Group__5__Impl : ( '}' ) ;
    public final void rule__DefinitionModelRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2189:1: ( ( '}' ) )
            // InternalDefinitionLanguage.g:2190:1: ( '}' )
            {
            // InternalDefinitionLanguage.g:2190:1: ( '}' )
            // InternalDefinitionLanguage.g:2191:2: '}'
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
    // InternalDefinitionLanguage.g:2201:1: rule__EnumTypeDefinitionRule__Group__0 : rule__EnumTypeDefinitionRule__Group__0__Impl rule__EnumTypeDefinitionRule__Group__1 ;
    public final void rule__EnumTypeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2205:1: ( rule__EnumTypeDefinitionRule__Group__0__Impl rule__EnumTypeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:2206:2: rule__EnumTypeDefinitionRule__Group__0__Impl rule__EnumTypeDefinitionRule__Group__1
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
    // InternalDefinitionLanguage.g:2213:1: rule__EnumTypeDefinitionRule__Group__0__Impl : ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__EnumTypeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2217:1: ( ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:2218:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:2218:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalDefinitionLanguage.g:2219:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:2220:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==73) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2220:3: rule__EnumTypeDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__EnumTypeDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalDefinitionLanguage.g:2228:1: rule__EnumTypeDefinitionRule__Group__1 : rule__EnumTypeDefinitionRule__Group__1__Impl rule__EnumTypeDefinitionRule__Group__2 ;
    public final void rule__EnumTypeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2232:1: ( rule__EnumTypeDefinitionRule__Group__1__Impl rule__EnumTypeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:2233:2: rule__EnumTypeDefinitionRule__Group__1__Impl rule__EnumTypeDefinitionRule__Group__2
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
    // InternalDefinitionLanguage.g:2240:1: rule__EnumTypeDefinitionRule__Group__1__Impl : ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2244:1: ( ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2245:1: ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2245:1: ( ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 ) )
            // InternalDefinitionLanguage.g:2246:2: ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getScaleAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:2247:2: ( rule__EnumTypeDefinitionRule__ScaleAssignment_1 )
            // InternalDefinitionLanguage.g:2247:3: rule__EnumTypeDefinitionRule__ScaleAssignment_1
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
    // InternalDefinitionLanguage.g:2255:1: rule__EnumTypeDefinitionRule__Group__2 : rule__EnumTypeDefinitionRule__Group__2__Impl rule__EnumTypeDefinitionRule__Group__3 ;
    public final void rule__EnumTypeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2259:1: ( rule__EnumTypeDefinitionRule__Group__2__Impl rule__EnumTypeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:2260:2: rule__EnumTypeDefinitionRule__Group__2__Impl rule__EnumTypeDefinitionRule__Group__3
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
    // InternalDefinitionLanguage.g:2267:1: rule__EnumTypeDefinitionRule__Group__2__Impl : ( 'enum' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2271:1: ( ( 'enum' ) )
            // InternalDefinitionLanguage.g:2272:1: ( 'enum' )
            {
            // InternalDefinitionLanguage.g:2272:1: ( 'enum' )
            // InternalDefinitionLanguage.g:2273:2: 'enum'
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
    // InternalDefinitionLanguage.g:2282:1: rule__EnumTypeDefinitionRule__Group__3 : rule__EnumTypeDefinitionRule__Group__3__Impl rule__EnumTypeDefinitionRule__Group__4 ;
    public final void rule__EnumTypeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2286:1: ( rule__EnumTypeDefinitionRule__Group__3__Impl rule__EnumTypeDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:2287:2: rule__EnumTypeDefinitionRule__Group__3__Impl rule__EnumTypeDefinitionRule__Group__4
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
    // InternalDefinitionLanguage.g:2294:1: rule__EnumTypeDefinitionRule__Group__3__Impl : ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2298:1: ( ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) ) )
            // InternalDefinitionLanguage.g:2299:1: ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) )
            {
            // InternalDefinitionLanguage.g:2299:1: ( ( rule__EnumTypeDefinitionRule__NameAssignment_3 ) )
            // InternalDefinitionLanguage.g:2300:2: ( rule__EnumTypeDefinitionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDefinitionLanguage.g:2301:2: ( rule__EnumTypeDefinitionRule__NameAssignment_3 )
            // InternalDefinitionLanguage.g:2301:3: rule__EnumTypeDefinitionRule__NameAssignment_3
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
    // InternalDefinitionLanguage.g:2309:1: rule__EnumTypeDefinitionRule__Group__4 : rule__EnumTypeDefinitionRule__Group__4__Impl rule__EnumTypeDefinitionRule__Group__5 ;
    public final void rule__EnumTypeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2313:1: ( rule__EnumTypeDefinitionRule__Group__4__Impl rule__EnumTypeDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:2314:2: rule__EnumTypeDefinitionRule__Group__4__Impl rule__EnumTypeDefinitionRule__Group__5
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
    // InternalDefinitionLanguage.g:2321:1: rule__EnumTypeDefinitionRule__Group__4__Impl : ( '(' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2325:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:2326:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:2326:1: ( '(' )
            // InternalDefinitionLanguage.g:2327:2: '('
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
    // InternalDefinitionLanguage.g:2336:1: rule__EnumTypeDefinitionRule__Group__5 : rule__EnumTypeDefinitionRule__Group__5__Impl rule__EnumTypeDefinitionRule__Group__6 ;
    public final void rule__EnumTypeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2340:1: ( rule__EnumTypeDefinitionRule__Group__5__Impl rule__EnumTypeDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:2341:2: rule__EnumTypeDefinitionRule__Group__5__Impl rule__EnumTypeDefinitionRule__Group__6
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
    // InternalDefinitionLanguage.g:2348:1: rule__EnumTypeDefinitionRule__Group__5__Impl : ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2352:1: ( ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) ) )
            // InternalDefinitionLanguage.g:2353:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) )
            {
            // InternalDefinitionLanguage.g:2353:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 ) )
            // InternalDefinitionLanguage.g:2354:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsAssignment_5()); 
            }
            // InternalDefinitionLanguage.g:2355:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_5 )
            // InternalDefinitionLanguage.g:2355:3: rule__EnumTypeDefinitionRule__LiteralsAssignment_5
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
    // InternalDefinitionLanguage.g:2363:1: rule__EnumTypeDefinitionRule__Group__6 : rule__EnumTypeDefinitionRule__Group__6__Impl rule__EnumTypeDefinitionRule__Group__7 ;
    public final void rule__EnumTypeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2367:1: ( rule__EnumTypeDefinitionRule__Group__6__Impl rule__EnumTypeDefinitionRule__Group__7 )
            // InternalDefinitionLanguage.g:2368:2: rule__EnumTypeDefinitionRule__Group__6__Impl rule__EnumTypeDefinitionRule__Group__7
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
    // InternalDefinitionLanguage.g:2375:1: rule__EnumTypeDefinitionRule__Group__6__Impl : ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* ) ;
    public final void rule__EnumTypeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2379:1: ( ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* ) )
            // InternalDefinitionLanguage.g:2380:1: ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* )
            {
            // InternalDefinitionLanguage.g:2380:1: ( ( rule__EnumTypeDefinitionRule__Group_6__0 )* )
            // InternalDefinitionLanguage.g:2381:2: ( rule__EnumTypeDefinitionRule__Group_6__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup_6()); 
            }
            // InternalDefinitionLanguage.g:2382:2: ( rule__EnumTypeDefinitionRule__Group_6__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==58) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2382:3: rule__EnumTypeDefinitionRule__Group_6__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__EnumTypeDefinitionRule__Group_6__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalDefinitionLanguage.g:2390:1: rule__EnumTypeDefinitionRule__Group__7 : rule__EnumTypeDefinitionRule__Group__7__Impl rule__EnumTypeDefinitionRule__Group__8 ;
    public final void rule__EnumTypeDefinitionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2394:1: ( rule__EnumTypeDefinitionRule__Group__7__Impl rule__EnumTypeDefinitionRule__Group__8 )
            // InternalDefinitionLanguage.g:2395:2: rule__EnumTypeDefinitionRule__Group__7__Impl rule__EnumTypeDefinitionRule__Group__8
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
    // InternalDefinitionLanguage.g:2402:1: rule__EnumTypeDefinitionRule__Group__7__Impl : ( ')' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2406:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:2407:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:2407:1: ( ')' )
            // InternalDefinitionLanguage.g:2408:2: ')'
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
    // InternalDefinitionLanguage.g:2417:1: rule__EnumTypeDefinitionRule__Group__8 : rule__EnumTypeDefinitionRule__Group__8__Impl rule__EnumTypeDefinitionRule__Group__9 ;
    public final void rule__EnumTypeDefinitionRule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2421:1: ( rule__EnumTypeDefinitionRule__Group__8__Impl rule__EnumTypeDefinitionRule__Group__9 )
            // InternalDefinitionLanguage.g:2422:2: rule__EnumTypeDefinitionRule__Group__8__Impl rule__EnumTypeDefinitionRule__Group__9
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
    // InternalDefinitionLanguage.g:2429:1: rule__EnumTypeDefinitionRule__Group__8__Impl : ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? ) ;
    public final void rule__EnumTypeDefinitionRule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2433:1: ( ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? ) )
            // InternalDefinitionLanguage.g:2434:1: ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? )
            {
            // InternalDefinitionLanguage.g:2434:1: ( ( rule__EnumTypeDefinitionRule__Group_8__0 )? )
            // InternalDefinitionLanguage.g:2435:2: ( rule__EnumTypeDefinitionRule__Group_8__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getGroup_8()); 
            }
            // InternalDefinitionLanguage.g:2436:2: ( rule__EnumTypeDefinitionRule__Group_8__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==59) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDefinitionLanguage.g:2436:3: rule__EnumTypeDefinitionRule__Group_8__0
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
    // InternalDefinitionLanguage.g:2444:1: rule__EnumTypeDefinitionRule__Group__9 : rule__EnumTypeDefinitionRule__Group__9__Impl ;
    public final void rule__EnumTypeDefinitionRule__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2448:1: ( rule__EnumTypeDefinitionRule__Group__9__Impl )
            // InternalDefinitionLanguage.g:2449:2: rule__EnumTypeDefinitionRule__Group__9__Impl
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
    // InternalDefinitionLanguage.g:2455:1: rule__EnumTypeDefinitionRule__Group__9__Impl : ( ';' ) ;
    public final void rule__EnumTypeDefinitionRule__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2459:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:2460:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:2460:1: ( ';' )
            // InternalDefinitionLanguage.g:2461:2: ';'
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
    // InternalDefinitionLanguage.g:2471:1: rule__EnumTypeDefinitionRule__Group_6__0 : rule__EnumTypeDefinitionRule__Group_6__0__Impl rule__EnumTypeDefinitionRule__Group_6__1 ;
    public final void rule__EnumTypeDefinitionRule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2475:1: ( rule__EnumTypeDefinitionRule__Group_6__0__Impl rule__EnumTypeDefinitionRule__Group_6__1 )
            // InternalDefinitionLanguage.g:2476:2: rule__EnumTypeDefinitionRule__Group_6__0__Impl rule__EnumTypeDefinitionRule__Group_6__1
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
    // InternalDefinitionLanguage.g:2483:1: rule__EnumTypeDefinitionRule__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2487:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:2488:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:2488:1: ( ',' )
            // InternalDefinitionLanguage.g:2489:2: ','
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
    // InternalDefinitionLanguage.g:2498:1: rule__EnumTypeDefinitionRule__Group_6__1 : rule__EnumTypeDefinitionRule__Group_6__1__Impl ;
    public final void rule__EnumTypeDefinitionRule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2502:1: ( rule__EnumTypeDefinitionRule__Group_6__1__Impl )
            // InternalDefinitionLanguage.g:2503:2: rule__EnumTypeDefinitionRule__Group_6__1__Impl
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
    // InternalDefinitionLanguage.g:2509:1: rule__EnumTypeDefinitionRule__Group_6__1__Impl : ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) ) ;
    public final void rule__EnumTypeDefinitionRule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2513:1: ( ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) ) )
            // InternalDefinitionLanguage.g:2514:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) )
            {
            // InternalDefinitionLanguage.g:2514:1: ( ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 ) )
            // InternalDefinitionLanguage.g:2515:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsAssignment_6_1()); 
            }
            // InternalDefinitionLanguage.g:2516:2: ( rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 )
            // InternalDefinitionLanguage.g:2516:3: rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1
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
    // InternalDefinitionLanguage.g:2525:1: rule__EnumTypeDefinitionRule__Group_8__0 : rule__EnumTypeDefinitionRule__Group_8__0__Impl rule__EnumTypeDefinitionRule__Group_8__1 ;
    public final void rule__EnumTypeDefinitionRule__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2529:1: ( rule__EnumTypeDefinitionRule__Group_8__0__Impl rule__EnumTypeDefinitionRule__Group_8__1 )
            // InternalDefinitionLanguage.g:2530:2: rule__EnumTypeDefinitionRule__Group_8__0__Impl rule__EnumTypeDefinitionRule__Group_8__1
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
    // InternalDefinitionLanguage.g:2537:1: rule__EnumTypeDefinitionRule__Group_8__0__Impl : ( 'with' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2541:1: ( ( 'with' ) )
            // InternalDefinitionLanguage.g:2542:1: ( 'with' )
            {
            // InternalDefinitionLanguage.g:2542:1: ( 'with' )
            // InternalDefinitionLanguage.g:2543:2: 'with'
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
    // InternalDefinitionLanguage.g:2552:1: rule__EnumTypeDefinitionRule__Group_8__1 : rule__EnumTypeDefinitionRule__Group_8__1__Impl rule__EnumTypeDefinitionRule__Group_8__2 ;
    public final void rule__EnumTypeDefinitionRule__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2556:1: ( rule__EnumTypeDefinitionRule__Group_8__1__Impl rule__EnumTypeDefinitionRule__Group_8__2 )
            // InternalDefinitionLanguage.g:2557:2: rule__EnumTypeDefinitionRule__Group_8__1__Impl rule__EnumTypeDefinitionRule__Group_8__2
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
    // InternalDefinitionLanguage.g:2564:1: rule__EnumTypeDefinitionRule__Group_8__1__Impl : ( 'constraints' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2568:1: ( ( 'constraints' ) )
            // InternalDefinitionLanguage.g:2569:1: ( 'constraints' )
            {
            // InternalDefinitionLanguage.g:2569:1: ( 'constraints' )
            // InternalDefinitionLanguage.g:2570:2: 'constraints'
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
    // InternalDefinitionLanguage.g:2579:1: rule__EnumTypeDefinitionRule__Group_8__2 : rule__EnumTypeDefinitionRule__Group_8__2__Impl rule__EnumTypeDefinitionRule__Group_8__3 ;
    public final void rule__EnumTypeDefinitionRule__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2583:1: ( rule__EnumTypeDefinitionRule__Group_8__2__Impl rule__EnumTypeDefinitionRule__Group_8__3 )
            // InternalDefinitionLanguage.g:2584:2: rule__EnumTypeDefinitionRule__Group_8__2__Impl rule__EnumTypeDefinitionRule__Group_8__3
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
    // InternalDefinitionLanguage.g:2591:1: rule__EnumTypeDefinitionRule__Group_8__2__Impl : ( ':' ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2595:1: ( ( ':' ) )
            // InternalDefinitionLanguage.g:2596:1: ( ':' )
            {
            // InternalDefinitionLanguage.g:2596:1: ( ':' )
            // InternalDefinitionLanguage.g:2597:2: ':'
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
    // InternalDefinitionLanguage.g:2606:1: rule__EnumTypeDefinitionRule__Group_8__3 : rule__EnumTypeDefinitionRule__Group_8__3__Impl ;
    public final void rule__EnumTypeDefinitionRule__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2610:1: ( rule__EnumTypeDefinitionRule__Group_8__3__Impl )
            // InternalDefinitionLanguage.g:2611:2: rule__EnumTypeDefinitionRule__Group_8__3__Impl
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
    // InternalDefinitionLanguage.g:2617:1: rule__EnumTypeDefinitionRule__Group_8__3__Impl : ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* ) ;
    public final void rule__EnumTypeDefinitionRule__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2621:1: ( ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* ) )
            // InternalDefinitionLanguage.g:2622:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* )
            {
            // InternalDefinitionLanguage.g:2622:1: ( ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )* )
            // InternalDefinitionLanguage.g:2623:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsAssignment_8_3()); 
            }
            // InternalDefinitionLanguage.g:2624:2: ( rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=RULE_QUOTED_ID && LA21_0<=RULE_STRING)||LA21_0==15||(LA21_0>=26 && LA21_0<=27)||LA21_0==55||LA21_0==66||(LA21_0>=68 && LA21_0<=69)||(LA21_0>=87 && LA21_0<=88)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2624:3: rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalDefinitionLanguage.g:2633:1: rule__StatementRule__Group__0 : rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 ;
    public final void rule__StatementRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2637:1: ( rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1 )
            // InternalDefinitionLanguage.g:2638:2: rule__StatementRule__Group__0__Impl rule__StatementRule__Group__1
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
    // InternalDefinitionLanguage.g:2645:1: rule__StatementRule__Group__0__Impl : ( ruleExpressionRule ) ;
    public final void rule__StatementRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2649:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:2650:1: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:2650:1: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:2651:2: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:2660:1: rule__StatementRule__Group__1 : rule__StatementRule__Group__1__Impl ;
    public final void rule__StatementRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2664:1: ( rule__StatementRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2665:2: rule__StatementRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2671:1: rule__StatementRule__Group__1__Impl : ( ';' ) ;
    public final void rule__StatementRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2675:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:2676:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:2676:1: ( ';' )
            // InternalDefinitionLanguage.g:2677:2: ';'
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
    // InternalDefinitionLanguage.g:2687:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2691:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2692:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:2699:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2703:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2704:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2704:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:2705:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:2706:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:2706:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:2714:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2718:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2719:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2725:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2729:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:2730:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2730:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:2731:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:2732:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==62) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2732:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalDefinitionLanguage.g:2741:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2745:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:2746:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:2753:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2757:1: ( ( 'OR' ) )
            // InternalDefinitionLanguage.g:2758:1: ( 'OR' )
            {
            // InternalDefinitionLanguage.g:2758:1: ( 'OR' )
            // InternalDefinitionLanguage.g:2759:2: 'OR'
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
    // InternalDefinitionLanguage.g:2768:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2772:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:2773:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:2779:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2783:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:2784:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:2784:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:2785:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:2786:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:2786:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:2795:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2799:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2800:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:2807:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2811:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2812:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2812:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:2813:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:2814:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:2814:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:2822:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2826:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2827:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2833:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2837:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:2838:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2838:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:2839:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:2840:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==63) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2840:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalDefinitionLanguage.g:2849:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2853:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:2854:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:2861:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2865:1: ( ( 'XOR' ) )
            // InternalDefinitionLanguage.g:2866:1: ( 'XOR' )
            {
            // InternalDefinitionLanguage.g:2866:1: ( 'XOR' )
            // InternalDefinitionLanguage.g:2867:2: 'XOR'
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
    // InternalDefinitionLanguage.g:2876:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2880:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:2881:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:2887:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2891:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:2892:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:2892:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:2893:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:2894:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:2894:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:2903:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2907:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2908:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:2915:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2919:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2920:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2920:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:2921:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:2922:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:2922:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:2930:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2934:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2935:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2941:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2945:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:2946:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2946:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:2947:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:2948:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==64) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2948:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalDefinitionLanguage.g:2957:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2961:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:2962:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:2969:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2973:1: ( ( 'AND' ) )
            // InternalDefinitionLanguage.g:2974:1: ( 'AND' )
            {
            // InternalDefinitionLanguage.g:2974:1: ( 'AND' )
            // InternalDefinitionLanguage.g:2975:2: 'AND'
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
    // InternalDefinitionLanguage.g:2984:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2988:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:2989:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:2995:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2999:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3000:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3000:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3001:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:3002:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3002:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3011:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3015:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3016:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3023:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3027:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalDefinitionLanguage.g:3028:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalDefinitionLanguage.g:3028:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalDefinitionLanguage.g:3029:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3030:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==87) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDefinitionLanguage.g:3030:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalDefinitionLanguage.g:3038:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3042:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3043:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3049:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3053:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3054:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3054:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalDefinitionLanguage.g:3055:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:3056:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalDefinitionLanguage.g:3056:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalDefinitionLanguage.g:3065:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3069:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3070:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3077:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3081:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3082:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3082:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3083:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3084:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3084:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3092:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3096:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3097:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3103:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3107:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalDefinitionLanguage.g:3108:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalDefinitionLanguage.g:3108:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalDefinitionLanguage.g:3109:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:3110:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=20 && LA26_0<=25)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3110:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalDefinitionLanguage.g:3119:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3123:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3124:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3131:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3135:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3136:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3136:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalDefinitionLanguage.g:3137:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3138:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalDefinitionLanguage.g:3138:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalDefinitionLanguage.g:3146:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3150:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3151:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3157:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3161:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3162:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3162:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3163:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:3164:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3164:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3173:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3177:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3178:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3185:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3189:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3190:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3190:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3191:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3192:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3192:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3200:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3204:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3205:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3211:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3215:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3216:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3216:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3217:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:3218:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=26 && LA27_0<=27)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3218:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalDefinitionLanguage.g:3227:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3231:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3232:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:3239:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3243:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDefinitionLanguage.g:3244:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDefinitionLanguage.g:3244:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDefinitionLanguage.g:3245:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDefinitionLanguage.g:3246:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalDefinitionLanguage.g:3246:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalDefinitionLanguage.g:3254:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3258:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3259:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3265:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3269:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3270:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3270:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3271:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:3272:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3272:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3281:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3285:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3286:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3293:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3297:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3298:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3298:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3299:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3300:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3300:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3308:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3312:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3313:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3319:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3323:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3324:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3324:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3325:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:3326:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=28 && LA28_0<=30)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3326:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalDefinitionLanguage.g:3335:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3339:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3340:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:3347:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3351:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDefinitionLanguage.g:3352:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDefinitionLanguage.g:3352:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDefinitionLanguage.g:3353:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            }
            // InternalDefinitionLanguage.g:3354:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalDefinitionLanguage.g:3354:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalDefinitionLanguage.g:3362:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3366:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3367:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3373:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3377:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3378:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3378:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3379:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:3380:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3380:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3389:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3393:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3394:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3401:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3405:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3406:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3406:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3407:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3408:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3408:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3416:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3420:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3421:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3427:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3431:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalDefinitionLanguage.g:3432:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalDefinitionLanguage.g:3432:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalDefinitionLanguage.g:3433:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:3434:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==65) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDefinitionLanguage.g:3434:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalDefinitionLanguage.g:3443:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3447:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3448:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:3455:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3459:1: ( ( '^' ) )
            // InternalDefinitionLanguage.g:3460:1: ( '^' )
            {
            // InternalDefinitionLanguage.g:3460:1: ( '^' )
            // InternalDefinitionLanguage.g:3461:2: '^'
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
    // InternalDefinitionLanguage.g:3470:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3474:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3475:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3481:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3485:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3486:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3486:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3487:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalDefinitionLanguage.g:3488:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalDefinitionLanguage.g:3488:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalDefinitionLanguage.g:3497:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3501:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3502:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3509:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3513:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:3514:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:3514:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalDefinitionLanguage.g:3515:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3516:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=26 && LA30_0<=27)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3516:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalDefinitionLanguage.g:3524:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3528:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3529:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3535:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3539:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3540:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3540:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3541:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:3542:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3542:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3551:1: rule__ArrayRule__Group__0 : rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 ;
    public final void rule__ArrayRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3555:1: ( rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 )
            // InternalDefinitionLanguage.g:3556:2: rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1
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
    // InternalDefinitionLanguage.g:3563:1: rule__ArrayRule__Group__0__Impl : ( () ) ;
    public final void rule__ArrayRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3567:1: ( ( () ) )
            // InternalDefinitionLanguage.g:3568:1: ( () )
            {
            // InternalDefinitionLanguage.g:3568:1: ( () )
            // InternalDefinitionLanguage.g:3569:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 
            }
            // InternalDefinitionLanguage.g:3570:2: ()
            // InternalDefinitionLanguage.g:3570:3: 
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
    // InternalDefinitionLanguage.g:3578:1: rule__ArrayRule__Group__1 : rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 ;
    public final void rule__ArrayRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3582:1: ( rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 )
            // InternalDefinitionLanguage.g:3583:2: rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2
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
    // InternalDefinitionLanguage.g:3590:1: rule__ArrayRule__Group__1__Impl : ( '[' ) ;
    public final void rule__ArrayRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3594:1: ( ( '[' ) )
            // InternalDefinitionLanguage.g:3595:1: ( '[' )
            {
            // InternalDefinitionLanguage.g:3595:1: ( '[' )
            // InternalDefinitionLanguage.g:3596:2: '['
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
    // InternalDefinitionLanguage.g:3605:1: rule__ArrayRule__Group__2 : rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 ;
    public final void rule__ArrayRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3609:1: ( rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 )
            // InternalDefinitionLanguage.g:3610:2: rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3
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
    // InternalDefinitionLanguage.g:3617:1: rule__ArrayRule__Group__2__Impl : ( ( rule__ArrayRule__Group_2__0 )? ) ;
    public final void rule__ArrayRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3621:1: ( ( ( rule__ArrayRule__Group_2__0 )? ) )
            // InternalDefinitionLanguage.g:3622:1: ( ( rule__ArrayRule__Group_2__0 )? )
            {
            // InternalDefinitionLanguage.g:3622:1: ( ( rule__ArrayRule__Group_2__0 )? )
            // InternalDefinitionLanguage.g:3623:2: ( rule__ArrayRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2()); 
            }
            // InternalDefinitionLanguage.g:3624:2: ( rule__ArrayRule__Group_2__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_QUOTED_ID && LA31_0<=RULE_STRING)||LA31_0==15||LA31_0==55||LA31_0==66||(LA31_0>=68 && LA31_0<=69)||LA31_0==88) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDefinitionLanguage.g:3624:3: rule__ArrayRule__Group_2__0
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
    // InternalDefinitionLanguage.g:3632:1: rule__ArrayRule__Group__3 : rule__ArrayRule__Group__3__Impl ;
    public final void rule__ArrayRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3636:1: ( rule__ArrayRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:3637:2: rule__ArrayRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:3643:1: rule__ArrayRule__Group__3__Impl : ( ']' ) ;
    public final void rule__ArrayRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3647:1: ( ( ']' ) )
            // InternalDefinitionLanguage.g:3648:1: ( ']' )
            {
            // InternalDefinitionLanguage.g:3648:1: ( ']' )
            // InternalDefinitionLanguage.g:3649:2: ']'
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
    // InternalDefinitionLanguage.g:3659:1: rule__ArrayRule__Group_2__0 : rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 ;
    public final void rule__ArrayRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3663:1: ( rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 )
            // InternalDefinitionLanguage.g:3664:2: rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1
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
    // InternalDefinitionLanguage.g:3671:1: rule__ArrayRule__Group_2__0__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) ;
    public final void rule__ArrayRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3675:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) )
            // InternalDefinitionLanguage.g:3676:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            {
            // InternalDefinitionLanguage.g:3676:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            // InternalDefinitionLanguage.g:3677:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 
            }
            // InternalDefinitionLanguage.g:3678:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            // InternalDefinitionLanguage.g:3678:3: rule__ArrayRule__ValuesAssignment_2_0
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
    // InternalDefinitionLanguage.g:3686:1: rule__ArrayRule__Group_2__1 : rule__ArrayRule__Group_2__1__Impl ;
    public final void rule__ArrayRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3690:1: ( rule__ArrayRule__Group_2__1__Impl )
            // InternalDefinitionLanguage.g:3691:2: rule__ArrayRule__Group_2__1__Impl
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
    // InternalDefinitionLanguage.g:3697:1: rule__ArrayRule__Group_2__1__Impl : ( ( rule__ArrayRule__Group_2_1__0 )* ) ;
    public final void rule__ArrayRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3701:1: ( ( ( rule__ArrayRule__Group_2_1__0 )* ) )
            // InternalDefinitionLanguage.g:3702:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3702:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            // InternalDefinitionLanguage.g:3703:2: ( rule__ArrayRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 
            }
            // InternalDefinitionLanguage.g:3704:2: ( rule__ArrayRule__Group_2_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==58) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3704:3: rule__ArrayRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__ArrayRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalDefinitionLanguage.g:3713:1: rule__ArrayRule__Group_2_1__0 : rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 ;
    public final void rule__ArrayRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3717:1: ( rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 )
            // InternalDefinitionLanguage.g:3718:2: rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1
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
    // InternalDefinitionLanguage.g:3725:1: rule__ArrayRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ArrayRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3729:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:3730:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:3730:1: ( ',' )
            // InternalDefinitionLanguage.g:3731:2: ','
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
    // InternalDefinitionLanguage.g:3740:1: rule__ArrayRule__Group_2_1__1 : rule__ArrayRule__Group_2_1__1__Impl ;
    public final void rule__ArrayRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3744:1: ( rule__ArrayRule__Group_2_1__1__Impl )
            // InternalDefinitionLanguage.g:3745:2: rule__ArrayRule__Group_2_1__1__Impl
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
    // InternalDefinitionLanguage.g:3751:1: rule__ArrayRule__Group_2_1__1__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__ArrayRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3755:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) )
            // InternalDefinitionLanguage.g:3756:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3756:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            // InternalDefinitionLanguage.g:3757:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 
            }
            // InternalDefinitionLanguage.g:3758:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            // InternalDefinitionLanguage.g:3758:3: rule__ArrayRule__ValuesAssignment_2_1_1
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
    // InternalDefinitionLanguage.g:3767:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3771:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalDefinitionLanguage.g:3772:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
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
    // InternalDefinitionLanguage.g:3779:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3783:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:3784:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:3784:1: ( '(' )
            // InternalDefinitionLanguage.g:3785:2: '('
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
    // InternalDefinitionLanguage.g:3794:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3798:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalDefinitionLanguage.g:3799:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
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
    // InternalDefinitionLanguage.g:3806:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3810:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3811:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3811:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3812:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:3813:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3813:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3821:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3825:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalDefinitionLanguage.g:3826:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalDefinitionLanguage.g:3832:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3836:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:3837:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:3837:1: ( ')' )
            // InternalDefinitionLanguage.g:3838:2: ')'
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


    // $ANTLR start "rule__CallRule__Group__0"
    // InternalDefinitionLanguage.g:3848:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3852:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalDefinitionLanguage.g:3853:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
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
    // InternalDefinitionLanguage.g:3860:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3864:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3865:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3865:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalDefinitionLanguage.g:3866:2: ( rule__CallRule__FunctionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:3867:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalDefinitionLanguage.g:3867:3: rule__CallRule__FunctionAssignment_0
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
    // InternalDefinitionLanguage.g:3875:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3879:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalDefinitionLanguage.g:3880:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_38);
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
    // InternalDefinitionLanguage.g:3887:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3891:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:3892:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:3892:1: ( '(' )
            // InternalDefinitionLanguage.g:3893:2: '('
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
    // InternalDefinitionLanguage.g:3902:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3906:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalDefinitionLanguage.g:3907:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_38);
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
    // InternalDefinitionLanguage.g:3914:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3918:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalDefinitionLanguage.g:3919:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalDefinitionLanguage.g:3919:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalDefinitionLanguage.g:3920:2: ( rule__CallRule__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            }
            // InternalDefinitionLanguage.g:3921:2: ( rule__CallRule__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_QUOTED_ID && LA33_0<=RULE_STRING)||LA33_0==15||(LA33_0>=26 && LA33_0<=27)||LA33_0==55||LA33_0==66||(LA33_0>=68 && LA33_0<=69)||(LA33_0>=87 && LA33_0<=88)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalDefinitionLanguage.g:3921:3: rule__CallRule__Group_2__0
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
    // InternalDefinitionLanguage.g:3929:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3933:1: ( rule__CallRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:3934:2: rule__CallRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:3940:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3944:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:3945:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:3945:1: ( ')' )
            // InternalDefinitionLanguage.g:3946:2: ')'
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
    // InternalDefinitionLanguage.g:3956:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3960:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalDefinitionLanguage.g:3961:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
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
    // InternalDefinitionLanguage.g:3968:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3972:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalDefinitionLanguage.g:3973:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalDefinitionLanguage.g:3973:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalDefinitionLanguage.g:3974:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            }
            // InternalDefinitionLanguage.g:3975:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalDefinitionLanguage.g:3975:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalDefinitionLanguage.g:3983:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3987:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalDefinitionLanguage.g:3988:2: rule__CallRule__Group_2__1__Impl
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
    // InternalDefinitionLanguage.g:3994:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3998:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalDefinitionLanguage.g:3999:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3999:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalDefinitionLanguage.g:4000:2: ( rule__CallRule__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            }
            // InternalDefinitionLanguage.g:4001:2: ( rule__CallRule__Group_2_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==58) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4001:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalDefinitionLanguage.g:4010:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4014:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalDefinitionLanguage.g:4015:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
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
    // InternalDefinitionLanguage.g:4022:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4026:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:4027:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:4027:1: ( ',' )
            // InternalDefinitionLanguage.g:4028:2: ','
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
    // InternalDefinitionLanguage.g:4037:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4041:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalDefinitionLanguage.g:4042:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalDefinitionLanguage.g:4048:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4052:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalDefinitionLanguage.g:4053:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalDefinitionLanguage.g:4053:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalDefinitionLanguage.g:4054:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            }
            // InternalDefinitionLanguage.g:4055:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalDefinitionLanguage.g:4055:3: rule__CallRule__ParametersAssignment_2_1_1
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


    // $ANTLR start "rule__BaseDataReferenceRule__Group__0"
    // InternalDefinitionLanguage.g:4064:1: rule__BaseDataReferenceRule__Group__0 : rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1 ;
    public final void rule__BaseDataReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4068:1: ( rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:4069:2: rule__BaseDataReferenceRule__Group__0__Impl rule__BaseDataReferenceRule__Group__1
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
    // InternalDefinitionLanguage.g:4076:1: rule__BaseDataReferenceRule__Group__0__Impl : ( 'data' ) ;
    public final void rule__BaseDataReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4080:1: ( ( 'data' ) )
            // InternalDefinitionLanguage.g:4081:1: ( 'data' )
            {
            // InternalDefinitionLanguage.g:4081:1: ( 'data' )
            // InternalDefinitionLanguage.g:4082:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDataKeyword_0()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4091:1: rule__BaseDataReferenceRule__Group__1 : rule__BaseDataReferenceRule__Group__1__Impl ;
    public final void rule__BaseDataReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4095:1: ( rule__BaseDataReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4096:2: rule__BaseDataReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4102:1: rule__BaseDataReferenceRule__Group__1__Impl : ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__BaseDataReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4106:1: ( ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:4107:1: ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:4107:1: ( ( rule__BaseDataReferenceRule__DefinitionAssignment_1 ) )
            // InternalDefinitionLanguage.g:4108:2: ( rule__BaseDataReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4109:2: ( rule__BaseDataReferenceRule__DefinitionAssignment_1 )
            // InternalDefinitionLanguage.g:4109:3: rule__BaseDataReferenceRule__DefinitionAssignment_1
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
    // InternalDefinitionLanguage.g:4118:1: rule__StructuredDataDescriptionReferenceRule__Group__0 : rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1 ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4122:1: ( rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:4123:2: rule__StructuredDataDescriptionReferenceRule__Group__0__Impl rule__StructuredDataDescriptionReferenceRule__Group__1
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
    // InternalDefinitionLanguage.g:4130:1: rule__StructuredDataDescriptionReferenceRule__Group__0__Impl : ( 'instance' ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4134:1: ( ( 'instance' ) )
            // InternalDefinitionLanguage.g:4135:1: ( 'instance' )
            {
            // InternalDefinitionLanguage.g:4135:1: ( 'instance' )
            // InternalDefinitionLanguage.g:4136:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getInstanceKeyword_0()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4145:1: rule__StructuredDataDescriptionReferenceRule__Group__1 : rule__StructuredDataDescriptionReferenceRule__Group__1__Impl ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4149:1: ( rule__StructuredDataDescriptionReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4150:2: rule__StructuredDataDescriptionReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4156:1: rule__StructuredDataDescriptionReferenceRule__Group__1__Impl : ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4160:1: ( ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:4161:1: ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:4161:1: ( ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 ) )
            // InternalDefinitionLanguage.g:4162:2: ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4163:2: ( rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 )
            // InternalDefinitionLanguage.g:4163:3: rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1
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
    // InternalDefinitionLanguage.g:4172:1: rule__InstanceLiteralRule__Group__0 : rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 ;
    public final void rule__InstanceLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4176:1: ( rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4177:2: rule__InstanceLiteralRule__Group__0__Impl rule__InstanceLiteralRule__Group__1
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
    // InternalDefinitionLanguage.g:4184:1: rule__InstanceLiteralRule__Group__0__Impl : ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) ;
    public final void rule__InstanceLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4188:1: ( ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4189:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4189:1: ( ( rule__InstanceLiteralRule__DefinitionAssignment_0 ) )
            // InternalDefinitionLanguage.g:4190:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4191:2: ( rule__InstanceLiteralRule__DefinitionAssignment_0 )
            // InternalDefinitionLanguage.g:4191:3: rule__InstanceLiteralRule__DefinitionAssignment_0
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
    // InternalDefinitionLanguage.g:4199:1: rule__InstanceLiteralRule__Group__1 : rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 ;
    public final void rule__InstanceLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4203:1: ( rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2 )
            // InternalDefinitionLanguage.g:4204:2: rule__InstanceLiteralRule__Group__1__Impl rule__InstanceLiteralRule__Group__2
            {
            pushFollow(FOLLOW_39);
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
    // InternalDefinitionLanguage.g:4211:1: rule__InstanceLiteralRule__Group__1__Impl : ( '{' ) ;
    public final void rule__InstanceLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4215:1: ( ( '{' ) )
            // InternalDefinitionLanguage.g:4216:1: ( '{' )
            {
            // InternalDefinitionLanguage.g:4216:1: ( '{' )
            // InternalDefinitionLanguage.g:4217:2: '{'
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
    // InternalDefinitionLanguage.g:4226:1: rule__InstanceLiteralRule__Group__2 : rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 ;
    public final void rule__InstanceLiteralRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4230:1: ( rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3 )
            // InternalDefinitionLanguage.g:4231:2: rule__InstanceLiteralRule__Group__2__Impl rule__InstanceLiteralRule__Group__3
            {
            pushFollow(FOLLOW_39);
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
    // InternalDefinitionLanguage.g:4238:1: rule__InstanceLiteralRule__Group__2__Impl : ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) ;
    public final void rule__InstanceLiteralRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4242:1: ( ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* ) )
            // InternalDefinitionLanguage.g:4243:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            {
            // InternalDefinitionLanguage.g:4243:1: ( ( rule__InstanceLiteralRule__AttributesAssignment_2 )* )
            // InternalDefinitionLanguage.g:4244:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAssignment_2()); 
            }
            // InternalDefinitionLanguage.g:4245:2: ( rule__InstanceLiteralRule__AttributesAssignment_2 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_QUOTED_ID && LA35_0<=RULE_ID)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4245:3: rule__InstanceLiteralRule__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_40);
            	    rule__InstanceLiteralRule__AttributesAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalDefinitionLanguage.g:4253:1: rule__InstanceLiteralRule__Group__3 : rule__InstanceLiteralRule__Group__3__Impl ;
    public final void rule__InstanceLiteralRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4257:1: ( rule__InstanceLiteralRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:4258:2: rule__InstanceLiteralRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:4264:1: rule__InstanceLiteralRule__Group__3__Impl : ( '}' ) ;
    public final void rule__InstanceLiteralRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4268:1: ( ( '}' ) )
            // InternalDefinitionLanguage.g:4269:1: ( '}' )
            {
            // InternalDefinitionLanguage.g:4269:1: ( '}' )
            // InternalDefinitionLanguage.g:4270:2: '}'
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
    // InternalDefinitionLanguage.g:4280:1: rule__AttributeRule__Group__0 : rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 ;
    public final void rule__AttributeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4284:1: ( rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 )
            // InternalDefinitionLanguage.g:4285:2: rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalDefinitionLanguage.g:4292:1: rule__AttributeRule__Group__0__Impl : ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) ;
    public final void rule__AttributeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4296:1: ( ( ( rule__AttributeRule__DefinitionAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4297:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4297:1: ( ( rule__AttributeRule__DefinitionAssignment_0 ) )
            // InternalDefinitionLanguage.g:4298:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4299:2: ( rule__AttributeRule__DefinitionAssignment_0 )
            // InternalDefinitionLanguage.g:4299:3: rule__AttributeRule__DefinitionAssignment_0
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
    // InternalDefinitionLanguage.g:4307:1: rule__AttributeRule__Group__1 : rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 ;
    public final void rule__AttributeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4311:1: ( rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 )
            // InternalDefinitionLanguage.g:4312:2: rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2
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
    // InternalDefinitionLanguage.g:4319:1: rule__AttributeRule__Group__1__Impl : ( ':=' ) ;
    public final void rule__AttributeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4323:1: ( ( ':=' ) )
            // InternalDefinitionLanguage.g:4324:1: ( ':=' )
            {
            // InternalDefinitionLanguage.g:4324:1: ( ':=' )
            // InternalDefinitionLanguage.g:4325:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4334:1: rule__AttributeRule__Group__2 : rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 ;
    public final void rule__AttributeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4338:1: ( rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 )
            // InternalDefinitionLanguage.g:4339:2: rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3
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
    // InternalDefinitionLanguage.g:4346:1: rule__AttributeRule__Group__2__Impl : ( ( rule__AttributeRule__ValueAssignment_2 ) ) ;
    public final void rule__AttributeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4350:1: ( ( ( rule__AttributeRule__ValueAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:4351:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:4351:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            // InternalDefinitionLanguage.g:4352:2: ( rule__AttributeRule__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 
            }
            // InternalDefinitionLanguage.g:4353:2: ( rule__AttributeRule__ValueAssignment_2 )
            // InternalDefinitionLanguage.g:4353:3: rule__AttributeRule__ValueAssignment_2
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
    // InternalDefinitionLanguage.g:4361:1: rule__AttributeRule__Group__3 : rule__AttributeRule__Group__3__Impl ;
    public final void rule__AttributeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4365:1: ( rule__AttributeRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:4366:2: rule__AttributeRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:4372:1: rule__AttributeRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4376:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:4377:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:4377:1: ( ';' )
            // InternalDefinitionLanguage.g:4378:2: ';'
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
    // InternalDefinitionLanguage.g:4388:1: rule__RealLiteralRule__Group__0 : rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 ;
    public final void rule__RealLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4392:1: ( rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4393:2: rule__RealLiteralRule__Group__0__Impl rule__RealLiteralRule__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalDefinitionLanguage.g:4400:1: rule__RealLiteralRule__Group__0__Impl : ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__RealLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4404:1: ( ( ( rule__RealLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4405:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4405:1: ( ( rule__RealLiteralRule__LiteralAssignment_0 ) )
            // InternalDefinitionLanguage.g:4406:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4407:2: ( rule__RealLiteralRule__LiteralAssignment_0 )
            // InternalDefinitionLanguage.g:4407:3: rule__RealLiteralRule__LiteralAssignment_0
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
    // InternalDefinitionLanguage.g:4415:1: rule__RealLiteralRule__Group__1 : rule__RealLiteralRule__Group__1__Impl ;
    public final void rule__RealLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4419:1: ( rule__RealLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4420:2: rule__RealLiteralRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4426:1: rule__RealLiteralRule__Group__1__Impl : ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__RealLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4430:1: ( ( ( rule__RealLiteralRule__FactorAssignment_1 )? ) )
            // InternalDefinitionLanguage.g:4431:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDefinitionLanguage.g:4431:1: ( ( rule__RealLiteralRule__FactorAssignment_1 )? )
            // InternalDefinitionLanguage.g:4432:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4433:2: ( rule__RealLiteralRule__FactorAssignment_1 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=31 && LA36_0<=50)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDefinitionLanguage.g:4433:3: rule__RealLiteralRule__FactorAssignment_1
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
    // InternalDefinitionLanguage.g:4442:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4446:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4447:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalDefinitionLanguage.g:4454:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4458:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4459:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4459:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalDefinitionLanguage.g:4460:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4461:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalDefinitionLanguage.g:4461:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalDefinitionLanguage.g:4469:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4473:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4474:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4480:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4484:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalDefinitionLanguage.g:4485:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDefinitionLanguage.g:4485:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalDefinitionLanguage.g:4486:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4487:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=31 && LA37_0<=50)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalDefinitionLanguage.g:4487:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalDefinitionLanguage.g:4496:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4500:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4501:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalDefinitionLanguage.g:4508:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4512:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4513:1: ( () )
            {
            // InternalDefinitionLanguage.g:4513:1: ( () )
            // InternalDefinitionLanguage.g:4514:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            }
            // InternalDefinitionLanguage.g:4515:2: ()
            // InternalDefinitionLanguage.g:4515:3: 
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
    // InternalDefinitionLanguage.g:4523:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4527:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4528:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4534:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4538:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalDefinitionLanguage.g:4539:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalDefinitionLanguage.g:4539:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalDefinitionLanguage.g:4540:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            }
            // InternalDefinitionLanguage.g:4541:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalDefinitionLanguage.g:4541:3: rule__BooleanLiteralRule__Alternatives_1
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
    // InternalDefinitionLanguage.g:4550:1: rule__ClassDefinitionRule__Group__0 : rule__ClassDefinitionRule__Group__0__Impl rule__ClassDefinitionRule__Group__1 ;
    public final void rule__ClassDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4554:1: ( rule__ClassDefinitionRule__Group__0__Impl rule__ClassDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:4555:2: rule__ClassDefinitionRule__Group__0__Impl rule__ClassDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalDefinitionLanguage.g:4562:1: rule__ClassDefinitionRule__Group__0__Impl : ( ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__ClassDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4566:1: ( ( ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:4567:1: ( ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:4567:1: ( ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalDefinitionLanguage.g:4568:2: ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4569:2: ( rule__ClassDefinitionRule__ConstraintsAssignment_0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==73) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4569:3: rule__ClassDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__ClassDefinitionRule__ConstraintsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
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
    // InternalDefinitionLanguage.g:4577:1: rule__ClassDefinitionRule__Group__1 : rule__ClassDefinitionRule__Group__1__Impl rule__ClassDefinitionRule__Group__2 ;
    public final void rule__ClassDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4581:1: ( rule__ClassDefinitionRule__Group__1__Impl rule__ClassDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:4582:2: rule__ClassDefinitionRule__Group__1__Impl rule__ClassDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_44);
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
    // InternalDefinitionLanguage.g:4589:1: rule__ClassDefinitionRule__Group__1__Impl : ( ( rule__ClassDefinitionRule__AbstractAssignment_1 )? ) ;
    public final void rule__ClassDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4593:1: ( ( ( rule__ClassDefinitionRule__AbstractAssignment_1 )? ) )
            // InternalDefinitionLanguage.g:4594:1: ( ( rule__ClassDefinitionRule__AbstractAssignment_1 )? )
            {
            // InternalDefinitionLanguage.g:4594:1: ( ( rule__ClassDefinitionRule__AbstractAssignment_1 )? )
            // InternalDefinitionLanguage.g:4595:2: ( rule__ClassDefinitionRule__AbstractAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getAbstractAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4596:2: ( rule__ClassDefinitionRule__AbstractAssignment_1 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==89) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalDefinitionLanguage.g:4596:3: rule__ClassDefinitionRule__AbstractAssignment_1
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
    // InternalDefinitionLanguage.g:4604:1: rule__ClassDefinitionRule__Group__2 : rule__ClassDefinitionRule__Group__2__Impl rule__ClassDefinitionRule__Group__3 ;
    public final void rule__ClassDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4608:1: ( rule__ClassDefinitionRule__Group__2__Impl rule__ClassDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:4609:2: rule__ClassDefinitionRule__Group__2__Impl rule__ClassDefinitionRule__Group__3
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
    // InternalDefinitionLanguage.g:4616:1: rule__ClassDefinitionRule__Group__2__Impl : ( 'type' ) ;
    public final void rule__ClassDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4620:1: ( ( 'type' ) )
            // InternalDefinitionLanguage.g:4621:1: ( 'type' )
            {
            // InternalDefinitionLanguage.g:4621:1: ( 'type' )
            // InternalDefinitionLanguage.g:4622:2: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getTypeKeyword_2()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4631:1: rule__ClassDefinitionRule__Group__3 : rule__ClassDefinitionRule__Group__3__Impl rule__ClassDefinitionRule__Group__4 ;
    public final void rule__ClassDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4635:1: ( rule__ClassDefinitionRule__Group__3__Impl rule__ClassDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:4636:2: rule__ClassDefinitionRule__Group__3__Impl rule__ClassDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_45);
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
    // InternalDefinitionLanguage.g:4643:1: rule__ClassDefinitionRule__Group__3__Impl : ( ( rule__ClassDefinitionRule__NameAssignment_3 ) ) ;
    public final void rule__ClassDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4647:1: ( ( ( rule__ClassDefinitionRule__NameAssignment_3 ) ) )
            // InternalDefinitionLanguage.g:4648:1: ( ( rule__ClassDefinitionRule__NameAssignment_3 ) )
            {
            // InternalDefinitionLanguage.g:4648:1: ( ( rule__ClassDefinitionRule__NameAssignment_3 ) )
            // InternalDefinitionLanguage.g:4649:2: ( rule__ClassDefinitionRule__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getNameAssignment_3()); 
            }
            // InternalDefinitionLanguage.g:4650:2: ( rule__ClassDefinitionRule__NameAssignment_3 )
            // InternalDefinitionLanguage.g:4650:3: rule__ClassDefinitionRule__NameAssignment_3
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
    // InternalDefinitionLanguage.g:4658:1: rule__ClassDefinitionRule__Group__4 : rule__ClassDefinitionRule__Group__4__Impl rule__ClassDefinitionRule__Group__5 ;
    public final void rule__ClassDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4662:1: ( rule__ClassDefinitionRule__Group__4__Impl rule__ClassDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:4663:2: rule__ClassDefinitionRule__Group__4__Impl rule__ClassDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_45);
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
    // InternalDefinitionLanguage.g:4670:1: rule__ClassDefinitionRule__Group__4__Impl : ( ( rule__ClassDefinitionRule__Group_4__0 )? ) ;
    public final void rule__ClassDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4674:1: ( ( ( rule__ClassDefinitionRule__Group_4__0 )? ) )
            // InternalDefinitionLanguage.g:4675:1: ( ( rule__ClassDefinitionRule__Group_4__0 )? )
            {
            // InternalDefinitionLanguage.g:4675:1: ( ( rule__ClassDefinitionRule__Group_4__0 )? )
            // InternalDefinitionLanguage.g:4676:2: ( rule__ClassDefinitionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getGroup_4()); 
            }
            // InternalDefinitionLanguage.g:4677:2: ( rule__ClassDefinitionRule__Group_4__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==72) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalDefinitionLanguage.g:4677:3: rule__ClassDefinitionRule__Group_4__0
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
    // InternalDefinitionLanguage.g:4685:1: rule__ClassDefinitionRule__Group__5 : rule__ClassDefinitionRule__Group__5__Impl rule__ClassDefinitionRule__Group__6 ;
    public final void rule__ClassDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4689:1: ( rule__ClassDefinitionRule__Group__5__Impl rule__ClassDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:4690:2: rule__ClassDefinitionRule__Group__5__Impl rule__ClassDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_46);
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
    // InternalDefinitionLanguage.g:4697:1: rule__ClassDefinitionRule__Group__5__Impl : ( '{' ) ;
    public final void rule__ClassDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4701:1: ( ( '{' ) )
            // InternalDefinitionLanguage.g:4702:1: ( '{' )
            {
            // InternalDefinitionLanguage.g:4702:1: ( '{' )
            // InternalDefinitionLanguage.g:4703:2: '{'
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
    // InternalDefinitionLanguage.g:4712:1: rule__ClassDefinitionRule__Group__6 : rule__ClassDefinitionRule__Group__6__Impl rule__ClassDefinitionRule__Group__7 ;
    public final void rule__ClassDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4716:1: ( rule__ClassDefinitionRule__Group__6__Impl rule__ClassDefinitionRule__Group__7 )
            // InternalDefinitionLanguage.g:4717:2: rule__ClassDefinitionRule__Group__6__Impl rule__ClassDefinitionRule__Group__7
            {
            pushFollow(FOLLOW_46);
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
    // InternalDefinitionLanguage.g:4724:1: rule__ClassDefinitionRule__Group__6__Impl : ( ( rule__ClassDefinitionRule__AttributesAssignment_6 )* ) ;
    public final void rule__ClassDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4728:1: ( ( ( rule__ClassDefinitionRule__AttributesAssignment_6 )* ) )
            // InternalDefinitionLanguage.g:4729:1: ( ( rule__ClassDefinitionRule__AttributesAssignment_6 )* )
            {
            // InternalDefinitionLanguage.g:4729:1: ( ( rule__ClassDefinitionRule__AttributesAssignment_6 )* )
            // InternalDefinitionLanguage.g:4730:2: ( rule__ClassDefinitionRule__AttributesAssignment_6 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getAttributesAssignment_6()); 
            }
            // InternalDefinitionLanguage.g:4731:2: ( rule__ClassDefinitionRule__AttributesAssignment_6 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_QUOTED_ID && LA41_0<=RULE_ID)||LA41_0==73) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4731:3: rule__ClassDefinitionRule__AttributesAssignment_6
            	    {
            	    pushFollow(FOLLOW_47);
            	    rule__ClassDefinitionRule__AttributesAssignment_6();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // InternalDefinitionLanguage.g:4739:1: rule__ClassDefinitionRule__Group__7 : rule__ClassDefinitionRule__Group__7__Impl ;
    public final void rule__ClassDefinitionRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4743:1: ( rule__ClassDefinitionRule__Group__7__Impl )
            // InternalDefinitionLanguage.g:4744:2: rule__ClassDefinitionRule__Group__7__Impl
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
    // InternalDefinitionLanguage.g:4750:1: rule__ClassDefinitionRule__Group__7__Impl : ( '}' ) ;
    public final void rule__ClassDefinitionRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4754:1: ( ( '}' ) )
            // InternalDefinitionLanguage.g:4755:1: ( '}' )
            {
            // InternalDefinitionLanguage.g:4755:1: ( '}' )
            // InternalDefinitionLanguage.g:4756:2: '}'
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
    // InternalDefinitionLanguage.g:4766:1: rule__ClassDefinitionRule__Group_4__0 : rule__ClassDefinitionRule__Group_4__0__Impl rule__ClassDefinitionRule__Group_4__1 ;
    public final void rule__ClassDefinitionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4770:1: ( rule__ClassDefinitionRule__Group_4__0__Impl rule__ClassDefinitionRule__Group_4__1 )
            // InternalDefinitionLanguage.g:4771:2: rule__ClassDefinitionRule__Group_4__0__Impl rule__ClassDefinitionRule__Group_4__1
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
    // InternalDefinitionLanguage.g:4778:1: rule__ClassDefinitionRule__Group_4__0__Impl : ( 'extends' ) ;
    public final void rule__ClassDefinitionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4782:1: ( ( 'extends' ) )
            // InternalDefinitionLanguage.g:4783:1: ( 'extends' )
            {
            // InternalDefinitionLanguage.g:4783:1: ( 'extends' )
            // InternalDefinitionLanguage.g:4784:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getExtendsKeyword_4_0()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4793:1: rule__ClassDefinitionRule__Group_4__1 : rule__ClassDefinitionRule__Group_4__1__Impl ;
    public final void rule__ClassDefinitionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4797:1: ( rule__ClassDefinitionRule__Group_4__1__Impl )
            // InternalDefinitionLanguage.g:4798:2: rule__ClassDefinitionRule__Group_4__1__Impl
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
    // InternalDefinitionLanguage.g:4804:1: rule__ClassDefinitionRule__Group_4__1__Impl : ( ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 ) ) ;
    public final void rule__ClassDefinitionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4808:1: ( ( ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 ) ) )
            // InternalDefinitionLanguage.g:4809:1: ( ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 ) )
            {
            // InternalDefinitionLanguage.g:4809:1: ( ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 ) )
            // InternalDefinitionLanguage.g:4810:2: ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getSuperTypeAssignment_4_1()); 
            }
            // InternalDefinitionLanguage.g:4811:2: ( rule__ClassDefinitionRule__SuperTypeAssignment_4_1 )
            // InternalDefinitionLanguage.g:4811:3: rule__ClassDefinitionRule__SuperTypeAssignment_4_1
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
    // InternalDefinitionLanguage.g:4820:1: rule__ConstraintRule__Group__0 : rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 ;
    public final void rule__ConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4824:1: ( rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1 )
            // InternalDefinitionLanguage.g:4825:2: rule__ConstraintRule__Group__0__Impl rule__ConstraintRule__Group__1
            {
            pushFollow(FOLLOW_48);
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
    // InternalDefinitionLanguage.g:4832:1: rule__ConstraintRule__Group__0__Impl : ( '@' ) ;
    public final void rule__ConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4836:1: ( ( '@' ) )
            // InternalDefinitionLanguage.g:4837:1: ( '@' )
            {
            // InternalDefinitionLanguage.g:4837:1: ( '@' )
            // InternalDefinitionLanguage.g:4838:2: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintRuleAccess().getCommercialAtKeyword_0()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:4847:1: rule__ConstraintRule__Group__1 : rule__ConstraintRule__Group__1__Impl ;
    public final void rule__ConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4851:1: ( rule__ConstraintRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4852:2: rule__ConstraintRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4858:1: rule__ConstraintRule__Group__1__Impl : ( ruleInstanceLiteralRule ) ;
    public final void rule__ConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4862:1: ( ( ruleInstanceLiteralRule ) )
            // InternalDefinitionLanguage.g:4863:1: ( ruleInstanceLiteralRule )
            {
            // InternalDefinitionLanguage.g:4863:1: ( ruleInstanceLiteralRule )
            // InternalDefinitionLanguage.g:4864:2: ruleInstanceLiteralRule
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
    // InternalDefinitionLanguage.g:4874:1: rule__AttributeDefinitionRule__Group__0 : rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 ;
    public final void rule__AttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4878:1: ( rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:4879:2: rule__AttributeDefinitionRule__Group__0__Impl rule__AttributeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_49);
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
    // InternalDefinitionLanguage.g:4886:1: rule__AttributeDefinitionRule__Group__0__Impl : ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) ;
    public final void rule__AttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4890:1: ( ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:4891:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:4891:1: ( ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )* )
            // InternalDefinitionLanguage.g:4892:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:4893:2: ( rule__AttributeDefinitionRule__ConstraintsAssignment_0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==73) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4893:3: rule__AttributeDefinitionRule__ConstraintsAssignment_0
            	    {
            	    pushFollow(FOLLOW_10);
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
    // InternalDefinitionLanguage.g:4901:1: rule__AttributeDefinitionRule__Group__1 : rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 ;
    public final void rule__AttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4905:1: ( rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:4906:2: rule__AttributeDefinitionRule__Group__1__Impl rule__AttributeDefinitionRule__Group__2
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
    // InternalDefinitionLanguage.g:4913:1: rule__AttributeDefinitionRule__Group__1__Impl : ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4917:1: ( ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:4918:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:4918:1: ( ( rule__AttributeDefinitionRule__NameAssignment_1 ) )
            // InternalDefinitionLanguage.g:4919:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getNameAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:4920:2: ( rule__AttributeDefinitionRule__NameAssignment_1 )
            // InternalDefinitionLanguage.g:4920:3: rule__AttributeDefinitionRule__NameAssignment_1
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
    // InternalDefinitionLanguage.g:4928:1: rule__AttributeDefinitionRule__Group__2 : rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 ;
    public final void rule__AttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4932:1: ( rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:4933:2: rule__AttributeDefinitionRule__Group__2__Impl rule__AttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_50);
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
    // InternalDefinitionLanguage.g:4940:1: rule__AttributeDefinitionRule__Group__2__Impl : ( ':' ) ;
    public final void rule__AttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4944:1: ( ( ':' ) )
            // InternalDefinitionLanguage.g:4945:1: ( ':' )
            {
            // InternalDefinitionLanguage.g:4945:1: ( ':' )
            // InternalDefinitionLanguage.g:4946:2: ':'
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
    // InternalDefinitionLanguage.g:4955:1: rule__AttributeDefinitionRule__Group__3 : rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 ;
    public final void rule__AttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4959:1: ( rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:4960:2: rule__AttributeDefinitionRule__Group__3__Impl rule__AttributeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_50);
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
    // InternalDefinitionLanguage.g:4967:1: rule__AttributeDefinitionRule__Group__3__Impl : ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4971:1: ( ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? ) )
            // InternalDefinitionLanguage.g:4972:1: ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? )
            {
            // InternalDefinitionLanguage.g:4972:1: ( ( rule__AttributeDefinitionRule__OptionalAssignment_3 )? )
            // InternalDefinitionLanguage.g:4973:2: ( rule__AttributeDefinitionRule__OptionalAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalAssignment_3()); 
            }
            // InternalDefinitionLanguage.g:4974:2: ( rule__AttributeDefinitionRule__OptionalAssignment_3 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==90) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalDefinitionLanguage.g:4974:3: rule__AttributeDefinitionRule__OptionalAssignment_3
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
    // InternalDefinitionLanguage.g:4982:1: rule__AttributeDefinitionRule__Group__4 : rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 ;
    public final void rule__AttributeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4986:1: ( rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:4987:2: rule__AttributeDefinitionRule__Group__4__Impl rule__AttributeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_51);
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
    // InternalDefinitionLanguage.g:4994:1: rule__AttributeDefinitionRule__Group__4__Impl : ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) ) ;
    public final void rule__AttributeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4998:1: ( ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) ) )
            // InternalDefinitionLanguage.g:4999:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) )
            {
            // InternalDefinitionLanguage.g:4999:1: ( ( rule__AttributeDefinitionRule__TypeAssignment_4 ) )
            // InternalDefinitionLanguage.g:5000:2: ( rule__AttributeDefinitionRule__TypeAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getTypeAssignment_4()); 
            }
            // InternalDefinitionLanguage.g:5001:2: ( rule__AttributeDefinitionRule__TypeAssignment_4 )
            // InternalDefinitionLanguage.g:5001:3: rule__AttributeDefinitionRule__TypeAssignment_4
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
    // InternalDefinitionLanguage.g:5009:1: rule__AttributeDefinitionRule__Group__5 : rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6 ;
    public final void rule__AttributeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5013:1: ( rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:5014:2: rule__AttributeDefinitionRule__Group__5__Impl rule__AttributeDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_51);
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
    // InternalDefinitionLanguage.g:5021:1: rule__AttributeDefinitionRule__Group__5__Impl : ( ( rule__AttributeDefinitionRule__Group_5__0 )? ) ;
    public final void rule__AttributeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5025:1: ( ( ( rule__AttributeDefinitionRule__Group_5__0 )? ) )
            // InternalDefinitionLanguage.g:5026:1: ( ( rule__AttributeDefinitionRule__Group_5__0 )? )
            {
            // InternalDefinitionLanguage.g:5026:1: ( ( rule__AttributeDefinitionRule__Group_5__0 )? )
            // InternalDefinitionLanguage.g:5027:2: ( rule__AttributeDefinitionRule__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getGroup_5()); 
            }
            // InternalDefinitionLanguage.g:5028:2: ( rule__AttributeDefinitionRule__Group_5__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==70) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalDefinitionLanguage.g:5028:3: rule__AttributeDefinitionRule__Group_5__0
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
    // InternalDefinitionLanguage.g:5036:1: rule__AttributeDefinitionRule__Group__6 : rule__AttributeDefinitionRule__Group__6__Impl ;
    public final void rule__AttributeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5040:1: ( rule__AttributeDefinitionRule__Group__6__Impl )
            // InternalDefinitionLanguage.g:5041:2: rule__AttributeDefinitionRule__Group__6__Impl
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
    // InternalDefinitionLanguage.g:5047:1: rule__AttributeDefinitionRule__Group__6__Impl : ( ';' ) ;
    public final void rule__AttributeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5051:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:5052:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:5052:1: ( ';' )
            // InternalDefinitionLanguage.g:5053:2: ';'
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
    // InternalDefinitionLanguage.g:5063:1: rule__AttributeDefinitionRule__Group_5__0 : rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1 ;
    public final void rule__AttributeDefinitionRule__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5067:1: ( rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1 )
            // InternalDefinitionLanguage.g:5068:2: rule__AttributeDefinitionRule__Group_5__0__Impl rule__AttributeDefinitionRule__Group_5__1
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
    // InternalDefinitionLanguage.g:5075:1: rule__AttributeDefinitionRule__Group_5__0__Impl : ( ':=' ) ;
    public final void rule__AttributeDefinitionRule__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5079:1: ( ( ':=' ) )
            // InternalDefinitionLanguage.g:5080:1: ( ':=' )
            {
            // InternalDefinitionLanguage.g:5080:1: ( ':=' )
            // InternalDefinitionLanguage.g:5081:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_5_0()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5090:1: rule__AttributeDefinitionRule__Group_5__1 : rule__AttributeDefinitionRule__Group_5__1__Impl ;
    public final void rule__AttributeDefinitionRule__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5094:1: ( rule__AttributeDefinitionRule__Group_5__1__Impl )
            // InternalDefinitionLanguage.g:5095:2: rule__AttributeDefinitionRule__Group_5__1__Impl
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
    // InternalDefinitionLanguage.g:5101:1: rule__AttributeDefinitionRule__Group_5__1__Impl : ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) ) ;
    public final void rule__AttributeDefinitionRule__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5105:1: ( ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) ) )
            // InternalDefinitionLanguage.g:5106:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) )
            {
            // InternalDefinitionLanguage.g:5106:1: ( ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 ) )
            // InternalDefinitionLanguage.g:5107:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationAssignment_5_1()); 
            }
            // InternalDefinitionLanguage.g:5108:2: ( rule__AttributeDefinitionRule__InitialisationAssignment_5_1 )
            // InternalDefinitionLanguage.g:5108:3: rule__AttributeDefinitionRule__InitialisationAssignment_5_1
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
    // InternalDefinitionLanguage.g:5117:1: rule__EnumReferenceRule__Group__0 : rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1 ;
    public final void rule__EnumReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5121:1: ( rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:5122:2: rule__EnumReferenceRule__Group__0__Impl rule__EnumReferenceRule__Group__1
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
    // InternalDefinitionLanguage.g:5129:1: rule__EnumReferenceRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5133:1: ( ( 'enum' ) )
            // InternalDefinitionLanguage.g:5134:1: ( 'enum' )
            {
            // InternalDefinitionLanguage.g:5134:1: ( 'enum' )
            // InternalDefinitionLanguage.g:5135:2: 'enum'
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
    // InternalDefinitionLanguage.g:5144:1: rule__EnumReferenceRule__Group__1 : rule__EnumReferenceRule__Group__1__Impl ;
    public final void rule__EnumReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5148:1: ( rule__EnumReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5149:2: rule__EnumReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5155:1: rule__EnumReferenceRule__Group__1__Impl : ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__EnumReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5159:1: ( ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:5160:1: ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:5160:1: ( ( rule__EnumReferenceRule__DefinitionAssignment_1 ) )
            // InternalDefinitionLanguage.g:5161:2: ( rule__EnumReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:5162:2: ( rule__EnumReferenceRule__DefinitionAssignment_1 )
            // InternalDefinitionLanguage.g:5162:3: rule__EnumReferenceRule__DefinitionAssignment_1
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
    // InternalDefinitionLanguage.g:5171:1: rule__TypeReferenceRule__Group__0 : rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1 ;
    public final void rule__TypeReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5175:1: ( rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:5176:2: rule__TypeReferenceRule__Group__0__Impl rule__TypeReferenceRule__Group__1
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
    // InternalDefinitionLanguage.g:5183:1: rule__TypeReferenceRule__Group__0__Impl : ( 'instance' ) ;
    public final void rule__TypeReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5187:1: ( ( 'instance' ) )
            // InternalDefinitionLanguage.g:5188:1: ( 'instance' )
            {
            // InternalDefinitionLanguage.g:5188:1: ( 'instance' )
            // InternalDefinitionLanguage.g:5189:2: 'instance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getInstanceKeyword_0()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5198:1: rule__TypeReferenceRule__Group__1 : rule__TypeReferenceRule__Group__1__Impl ;
    public final void rule__TypeReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5202:1: ( rule__TypeReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5203:2: rule__TypeReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5209:1: rule__TypeReferenceRule__Group__1__Impl : ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) ) ;
    public final void rule__TypeReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5213:1: ( ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:5214:1: ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:5214:1: ( ( rule__TypeReferenceRule__DefinitionAssignment_1 ) )
            // InternalDefinitionLanguage.g:5215:2: ( rule__TypeReferenceRule__DefinitionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getDefinitionAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:5216:2: ( rule__TypeReferenceRule__DefinitionAssignment_1 )
            // InternalDefinitionLanguage.g:5216:3: rule__TypeReferenceRule__DefinitionAssignment_1
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
    // InternalDefinitionLanguage.g:5225:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5229:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5230:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
            {
            pushFollow(FOLLOW_52);
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
    // InternalDefinitionLanguage.g:5237:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5241:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5242:1: ( () )
            {
            // InternalDefinitionLanguage.g:5242:1: ( () )
            // InternalDefinitionLanguage.g:5243:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5244:2: ()
            // InternalDefinitionLanguage.g:5244:3: 
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
    // InternalDefinitionLanguage.g:5252:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5256:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5257:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5263:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5267:1: ( ( 'literal' ) )
            // InternalDefinitionLanguage.g:5268:1: ( 'literal' )
            {
            // InternalDefinitionLanguage.g:5268:1: ( 'literal' )
            // InternalDefinitionLanguage.g:5269:2: 'literal'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5279:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5283:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5284:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalDefinitionLanguage.g:5291:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5295:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5296:1: ( () )
            {
            // InternalDefinitionLanguage.g:5296:1: ( () )
            // InternalDefinitionLanguage.g:5297:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5298:2: ()
            // InternalDefinitionLanguage.g:5298:3: 
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
    // InternalDefinitionLanguage.g:5306:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5310:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5311:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5317:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5321:1: ( ( 'data' ) )
            // InternalDefinitionLanguage.g:5322:1: ( 'data' )
            {
            // InternalDefinitionLanguage.g:5322:1: ( 'data' )
            // InternalDefinitionLanguage.g:5323:2: 'data'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5333:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5337:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5338:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalDefinitionLanguage.g:5345:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5349:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5350:1: ( () )
            {
            // InternalDefinitionLanguage.g:5350:1: ( () )
            // InternalDefinitionLanguage.g:5351:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5352:2: ()
            // InternalDefinitionLanguage.g:5352:3: 
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
    // InternalDefinitionLanguage.g:5360:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5364:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5365:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5371:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5375:1: ( ( 'string' ) )
            // InternalDefinitionLanguage.g:5376:1: ( 'string' )
            {
            // InternalDefinitionLanguage.g:5376:1: ( 'string' )
            // InternalDefinitionLanguage.g:5377:2: 'string'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5387:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5391:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5392:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_54);
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
    // InternalDefinitionLanguage.g:5399:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5403:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5404:1: ( () )
            {
            // InternalDefinitionLanguage.g:5404:1: ( () )
            // InternalDefinitionLanguage.g:5405:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5406:2: ()
            // InternalDefinitionLanguage.g:5406:3: 
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
    // InternalDefinitionLanguage.g:5414:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5418:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5419:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5425:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5429:1: ( ( 'expression' ) )
            // InternalDefinitionLanguage.g:5430:1: ( 'expression' )
            {
            // InternalDefinitionLanguage.g:5430:1: ( 'expression' )
            // InternalDefinitionLanguage.g:5431:2: 'expression'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            }
            match(input,76,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5441:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5445:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5446:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_55);
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
    // InternalDefinitionLanguage.g:5453:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5457:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5458:1: ( () )
            {
            // InternalDefinitionLanguage.g:5458:1: ( () )
            // InternalDefinitionLanguage.g:5459:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5460:2: ()
            // InternalDefinitionLanguage.g:5460:3: 
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
    // InternalDefinitionLanguage.g:5468:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5472:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5473:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5479:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5483:1: ( ( 'int' ) )
            // InternalDefinitionLanguage.g:5484:1: ( 'int' )
            {
            // InternalDefinitionLanguage.g:5484:1: ( 'int' )
            // InternalDefinitionLanguage.g:5485:2: 'int'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5495:1: rule__RealTypeRule__Group__0 : rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 ;
    public final void rule__RealTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5499:1: ( rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5500:2: rule__RealTypeRule__Group__0__Impl rule__RealTypeRule__Group__1
            {
            pushFollow(FOLLOW_56);
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
    // InternalDefinitionLanguage.g:5507:1: rule__RealTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__RealTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5511:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5512:1: ( () )
            {
            // InternalDefinitionLanguage.g:5512:1: ( () )
            // InternalDefinitionLanguage.g:5513:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5514:2: ()
            // InternalDefinitionLanguage.g:5514:3: 
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
    // InternalDefinitionLanguage.g:5522:1: rule__RealTypeRule__Group__1 : rule__RealTypeRule__Group__1__Impl ;
    public final void rule__RealTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5526:1: ( rule__RealTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5527:2: rule__RealTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5533:1: rule__RealTypeRule__Group__1__Impl : ( 'real' ) ;
    public final void rule__RealTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5537:1: ( ( 'real' ) )
            // InternalDefinitionLanguage.g:5538:1: ( 'real' )
            {
            // InternalDefinitionLanguage.g:5538:1: ( 'real' )
            // InternalDefinitionLanguage.g:5539:2: 'real'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealTypeRuleAccess().getRealKeyword_1()); 
            }
            match(input,78,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5549:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5553:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5554:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_57);
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
    // InternalDefinitionLanguage.g:5561:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5565:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5566:1: ( () )
            {
            // InternalDefinitionLanguage.g:5566:1: ( () )
            // InternalDefinitionLanguage.g:5567:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5568:2: ()
            // InternalDefinitionLanguage.g:5568:3: 
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
    // InternalDefinitionLanguage.g:5576:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5580:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5581:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5587:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5591:1: ( ( 'boolean' ) )
            // InternalDefinitionLanguage.g:5592:1: ( 'boolean' )
            {
            // InternalDefinitionLanguage.g:5592:1: ( 'boolean' )
            // InternalDefinitionLanguage.g:5593:2: 'boolean'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            }
            match(input,79,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5603:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5607:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5608:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_58);
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
    // InternalDefinitionLanguage.g:5615:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5619:1: ( ( () ) )
            // InternalDefinitionLanguage.g:5620:1: ( () )
            {
            // InternalDefinitionLanguage.g:5620:1: ( () )
            // InternalDefinitionLanguage.g:5621:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            }
            // InternalDefinitionLanguage.g:5622:2: ()
            // InternalDefinitionLanguage.g:5622:3: 
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
    // InternalDefinitionLanguage.g:5630:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5634:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5635:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5641:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5645:1: ( ( 'void' ) )
            // InternalDefinitionLanguage.g:5646:1: ( 'void' )
            {
            // InternalDefinitionLanguage.g:5646:1: ( 'void' )
            // InternalDefinitionLanguage.g:5647:2: 'void'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            }
            match(input,80,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5657:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5661:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:5662:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalDefinitionLanguage.g:5669:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5673:1: ( ( 'array' ) )
            // InternalDefinitionLanguage.g:5674:1: ( 'array' )
            {
            // InternalDefinitionLanguage.g:5674:1: ( 'array' )
            // InternalDefinitionLanguage.g:5675:2: 'array'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            }
            match(input,81,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:5684:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5688:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:5689:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:5695:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5699:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:5700:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:5700:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalDefinitionLanguage.g:5701:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:5702:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalDefinitionLanguage.g:5702:3: rule__ArrayTypeRule__ElementsAssignment_1
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
    // InternalDefinitionLanguage.g:5711:1: rule__FunctionDefinitionRule__Group__0 : rule__FunctionDefinitionRule__Group__0__Impl rule__FunctionDefinitionRule__Group__1 ;
    public final void rule__FunctionDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5715:1: ( rule__FunctionDefinitionRule__Group__0__Impl rule__FunctionDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:5716:2: rule__FunctionDefinitionRule__Group__0__Impl rule__FunctionDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalDefinitionLanguage.g:5723:1: rule__FunctionDefinitionRule__Group__0__Impl : ( 'def' ) ;
    public final void rule__FunctionDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5727:1: ( ( 'def' ) )
            // InternalDefinitionLanguage.g:5728:1: ( 'def' )
            {
            // InternalDefinitionLanguage.g:5728:1: ( 'def' )
            // InternalDefinitionLanguage.g:5729:2: 'def'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getDefKeyword_0()); 
            }
            match(input,82,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getDefKeyword_0()); 
            }

            }


            }

        }
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
    // InternalDefinitionLanguage.g:5738:1: rule__FunctionDefinitionRule__Group__1 : rule__FunctionDefinitionRule__Group__1__Impl rule__FunctionDefinitionRule__Group__2 ;
    public final void rule__FunctionDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5742:1: ( rule__FunctionDefinitionRule__Group__1__Impl rule__FunctionDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:5743:2: rule__FunctionDefinitionRule__Group__1__Impl rule__FunctionDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalDefinitionLanguage.g:5750:1: rule__FunctionDefinitionRule__Group__1__Impl : ( ( rule__FunctionDefinitionRule__TypeAssignment_1 ) ) ;
    public final void rule__FunctionDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5754:1: ( ( ( rule__FunctionDefinitionRule__TypeAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:5755:1: ( ( rule__FunctionDefinitionRule__TypeAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:5755:1: ( ( rule__FunctionDefinitionRule__TypeAssignment_1 ) )
            // InternalDefinitionLanguage.g:5756:2: ( rule__FunctionDefinitionRule__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getTypeAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:5757:2: ( rule__FunctionDefinitionRule__TypeAssignment_1 )
            // InternalDefinitionLanguage.g:5757:3: rule__FunctionDefinitionRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
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
    // InternalDefinitionLanguage.g:5765:1: rule__FunctionDefinitionRule__Group__2 : rule__FunctionDefinitionRule__Group__2__Impl rule__FunctionDefinitionRule__Group__3 ;
    public final void rule__FunctionDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5769:1: ( rule__FunctionDefinitionRule__Group__2__Impl rule__FunctionDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:5770:2: rule__FunctionDefinitionRule__Group__2__Impl rule__FunctionDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_12);
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
    // InternalDefinitionLanguage.g:5777:1: rule__FunctionDefinitionRule__Group__2__Impl : ( ( rule__FunctionDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__FunctionDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5781:1: ( ( ( rule__FunctionDefinitionRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:5782:1: ( ( rule__FunctionDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:5782:1: ( ( rule__FunctionDefinitionRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:5783:2: ( rule__FunctionDefinitionRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getNameAssignment_2()); 
            }
            // InternalDefinitionLanguage.g:5784:2: ( rule__FunctionDefinitionRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:5784:3: rule__FunctionDefinitionRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getNameAssignment_2()); 
            }

            }


            }

        }
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
    // InternalDefinitionLanguage.g:5792:1: rule__FunctionDefinitionRule__Group__3 : rule__FunctionDefinitionRule__Group__3__Impl rule__FunctionDefinitionRule__Group__4 ;
    public final void rule__FunctionDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5796:1: ( rule__FunctionDefinitionRule__Group__3__Impl rule__FunctionDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:5797:2: rule__FunctionDefinitionRule__Group__3__Impl rule__FunctionDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_59);
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
    // InternalDefinitionLanguage.g:5804:1: rule__FunctionDefinitionRule__Group__3__Impl : ( '(' ) ;
    public final void rule__FunctionDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5808:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:5809:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:5809:1: ( '(' )
            // InternalDefinitionLanguage.g:5810:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getLeftParenthesisKeyword_3()); 
            }

            }


            }

        }
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
    // InternalDefinitionLanguage.g:5819:1: rule__FunctionDefinitionRule__Group__4 : rule__FunctionDefinitionRule__Group__4__Impl rule__FunctionDefinitionRule__Group__5 ;
    public final void rule__FunctionDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5823:1: ( rule__FunctionDefinitionRule__Group__4__Impl rule__FunctionDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:5824:2: rule__FunctionDefinitionRule__Group__4__Impl rule__FunctionDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_59);
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
    // InternalDefinitionLanguage.g:5831:1: rule__FunctionDefinitionRule__Group__4__Impl : ( ( rule__FunctionDefinitionRule__Group_4__0 )? ) ;
    public final void rule__FunctionDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5835:1: ( ( ( rule__FunctionDefinitionRule__Group_4__0 )? ) )
            // InternalDefinitionLanguage.g:5836:1: ( ( rule__FunctionDefinitionRule__Group_4__0 )? )
            {
            // InternalDefinitionLanguage.g:5836:1: ( ( rule__FunctionDefinitionRule__Group_4__0 )? )
            // InternalDefinitionLanguage.g:5837:2: ( rule__FunctionDefinitionRule__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_4()); 
            }
            // InternalDefinitionLanguage.g:5838:2: ( rule__FunctionDefinitionRule__Group_4__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==54||(LA45_0>=68 && LA45_0<=69)||(LA45_0>=74 && LA45_0<=81)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalDefinitionLanguage.g:5838:3: rule__FunctionDefinitionRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FunctionDefinitionRule__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_4()); 
            }

            }


            }

        }
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
    // InternalDefinitionLanguage.g:5846:1: rule__FunctionDefinitionRule__Group__5 : rule__FunctionDefinitionRule__Group__5__Impl rule__FunctionDefinitionRule__Group__6 ;
    public final void rule__FunctionDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5850:1: ( rule__FunctionDefinitionRule__Group__5__Impl rule__FunctionDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:5851:2: rule__FunctionDefinitionRule__Group__5__Impl rule__FunctionDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_20);
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
    // InternalDefinitionLanguage.g:5858:1: rule__FunctionDefinitionRule__Group__5__Impl : ( ')' ) ;
    public final void rule__FunctionDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5862:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:5863:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:5863:1: ( ')' )
            // InternalDefinitionLanguage.g:5864:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getRightParenthesisKeyword_5()); 
            }

            }


            }

        }
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
    // InternalDefinitionLanguage.g:5873:1: rule__FunctionDefinitionRule__Group__6 : rule__FunctionDefinitionRule__Group__6__Impl ;
    public final void rule__FunctionDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5877:1: ( rule__FunctionDefinitionRule__Group__6__Impl )
            // InternalDefinitionLanguage.g:5878:2: rule__FunctionDefinitionRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalDefinitionLanguage.g:5884:1: rule__FunctionDefinitionRule__Group__6__Impl : ( ';' ) ;
    public final void rule__FunctionDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5888:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:5889:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:5889:1: ( ';' )
            // InternalDefinitionLanguage.g:5890:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getSemicolonKeyword_6()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getSemicolonKeyword_6()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4__0"
    // InternalDefinitionLanguage.g:5900:1: rule__FunctionDefinitionRule__Group_4__0 : rule__FunctionDefinitionRule__Group_4__0__Impl rule__FunctionDefinitionRule__Group_4__1 ;
    public final void rule__FunctionDefinitionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5904:1: ( rule__FunctionDefinitionRule__Group_4__0__Impl rule__FunctionDefinitionRule__Group_4__1 )
            // InternalDefinitionLanguage.g:5905:2: rule__FunctionDefinitionRule__Group_4__0__Impl rule__FunctionDefinitionRule__Group_4__1
            {
            pushFollow(FOLLOW_36);
            rule__FunctionDefinitionRule__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4__0"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4__0__Impl"
    // InternalDefinitionLanguage.g:5912:1: rule__FunctionDefinitionRule__Group_4__0__Impl : ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 ) ) ;
    public final void rule__FunctionDefinitionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5916:1: ( ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 ) ) )
            // InternalDefinitionLanguage.g:5917:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 ) )
            {
            // InternalDefinitionLanguage.g:5917:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 ) )
            // InternalDefinitionLanguage.g:5918:2: ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_4_0()); 
            }
            // InternalDefinitionLanguage.g:5919:2: ( rule__FunctionDefinitionRule__ParametersAssignment_4_0 )
            // InternalDefinitionLanguage.g:5919:3: rule__FunctionDefinitionRule__ParametersAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__ParametersAssignment_4_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4__0__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4__1"
    // InternalDefinitionLanguage.g:5927:1: rule__FunctionDefinitionRule__Group_4__1 : rule__FunctionDefinitionRule__Group_4__1__Impl ;
    public final void rule__FunctionDefinitionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5931:1: ( rule__FunctionDefinitionRule__Group_4__1__Impl )
            // InternalDefinitionLanguage.g:5932:2: rule__FunctionDefinitionRule__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4__1"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4__1__Impl"
    // InternalDefinitionLanguage.g:5938:1: rule__FunctionDefinitionRule__Group_4__1__Impl : ( ( rule__FunctionDefinitionRule__Group_4_1__0 )* ) ;
    public final void rule__FunctionDefinitionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5942:1: ( ( ( rule__FunctionDefinitionRule__Group_4_1__0 )* ) )
            // InternalDefinitionLanguage.g:5943:1: ( ( rule__FunctionDefinitionRule__Group_4_1__0 )* )
            {
            // InternalDefinitionLanguage.g:5943:1: ( ( rule__FunctionDefinitionRule__Group_4_1__0 )* )
            // InternalDefinitionLanguage.g:5944:2: ( rule__FunctionDefinitionRule__Group_4_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_4_1()); 
            }
            // InternalDefinitionLanguage.g:5945:2: ( rule__FunctionDefinitionRule__Group_4_1__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==58) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:5945:3: rule__FunctionDefinitionRule__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__FunctionDefinitionRule__Group_4_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getGroup_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4__1__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4_1__0"
    // InternalDefinitionLanguage.g:5954:1: rule__FunctionDefinitionRule__Group_4_1__0 : rule__FunctionDefinitionRule__Group_4_1__0__Impl rule__FunctionDefinitionRule__Group_4_1__1 ;
    public final void rule__FunctionDefinitionRule__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5958:1: ( rule__FunctionDefinitionRule__Group_4_1__0__Impl rule__FunctionDefinitionRule__Group_4_1__1 )
            // InternalDefinitionLanguage.g:5959:2: rule__FunctionDefinitionRule__Group_4_1__0__Impl rule__FunctionDefinitionRule__Group_4_1__1
            {
            pushFollow(FOLLOW_50);
            rule__FunctionDefinitionRule__Group_4_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_4_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4_1__0"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4_1__0__Impl"
    // InternalDefinitionLanguage.g:5966:1: rule__FunctionDefinitionRule__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__FunctionDefinitionRule__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5970:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:5971:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:5971:1: ( ',' )
            // InternalDefinitionLanguage.g:5972:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getCommaKeyword_4_1_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getCommaKeyword_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4_1__0__Impl"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4_1__1"
    // InternalDefinitionLanguage.g:5981:1: rule__FunctionDefinitionRule__Group_4_1__1 : rule__FunctionDefinitionRule__Group_4_1__1__Impl ;
    public final void rule__FunctionDefinitionRule__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5985:1: ( rule__FunctionDefinitionRule__Group_4_1__1__Impl )
            // InternalDefinitionLanguage.g:5986:2: rule__FunctionDefinitionRule__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__Group_4_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4_1__1"


    // $ANTLR start "rule__FunctionDefinitionRule__Group_4_1__1__Impl"
    // InternalDefinitionLanguage.g:5992:1: rule__FunctionDefinitionRule__Group_4_1__1__Impl : ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 ) ) ;
    public final void rule__FunctionDefinitionRule__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5996:1: ( ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 ) ) )
            // InternalDefinitionLanguage.g:5997:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 ) )
            {
            // InternalDefinitionLanguage.g:5997:1: ( ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 ) )
            // InternalDefinitionLanguage.g:5998:2: ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_4_1_1()); 
            }
            // InternalDefinitionLanguage.g:5999:2: ( rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 )
            // InternalDefinitionLanguage.g:5999:3: rule__FunctionDefinitionRule__ParametersAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__FunctionDefinitionRule__ParametersAssignment_4_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersAssignment_4_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__Group_4_1__1__Impl"


    // $ANTLR start "rule__ConstantDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:6008:1: rule__ConstantDefinitionRule__Group__0 : rule__ConstantDefinitionRule__Group__0__Impl rule__ConstantDefinitionRule__Group__1 ;
    public final void rule__ConstantDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6012:1: ( rule__ConstantDefinitionRule__Group__0__Impl rule__ConstantDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:6013:2: rule__ConstantDefinitionRule__Group__0__Impl rule__ConstantDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalDefinitionLanguage.g:6020:1: rule__ConstantDefinitionRule__Group__0__Impl : ( 'const' ) ;
    public final void rule__ConstantDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6024:1: ( ( 'const' ) )
            // InternalDefinitionLanguage.g:6025:1: ( 'const' )
            {
            // InternalDefinitionLanguage.g:6025:1: ( 'const' )
            // InternalDefinitionLanguage.g:6026:2: 'const'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getConstKeyword_0()); 
            }
            match(input,83,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6035:1: rule__ConstantDefinitionRule__Group__1 : rule__ConstantDefinitionRule__Group__1__Impl rule__ConstantDefinitionRule__Group__2 ;
    public final void rule__ConstantDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6039:1: ( rule__ConstantDefinitionRule__Group__1__Impl rule__ConstantDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:6040:2: rule__ConstantDefinitionRule__Group__1__Impl rule__ConstantDefinitionRule__Group__2
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
    // InternalDefinitionLanguage.g:6047:1: rule__ConstantDefinitionRule__Group__1__Impl : ( ( rule__ConstantDefinitionRule__TypeAssignment_1 ) ) ;
    public final void rule__ConstantDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6051:1: ( ( ( rule__ConstantDefinitionRule__TypeAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:6052:1: ( ( rule__ConstantDefinitionRule__TypeAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:6052:1: ( ( rule__ConstantDefinitionRule__TypeAssignment_1 ) )
            // InternalDefinitionLanguage.g:6053:2: ( rule__ConstantDefinitionRule__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getTypeAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:6054:2: ( rule__ConstantDefinitionRule__TypeAssignment_1 )
            // InternalDefinitionLanguage.g:6054:3: rule__ConstantDefinitionRule__TypeAssignment_1
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
    // InternalDefinitionLanguage.g:6062:1: rule__ConstantDefinitionRule__Group__2 : rule__ConstantDefinitionRule__Group__2__Impl rule__ConstantDefinitionRule__Group__3 ;
    public final void rule__ConstantDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6066:1: ( rule__ConstantDefinitionRule__Group__2__Impl rule__ConstantDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:6067:2: rule__ConstantDefinitionRule__Group__2__Impl rule__ConstantDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_41);
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
    // InternalDefinitionLanguage.g:6074:1: rule__ConstantDefinitionRule__Group__2__Impl : ( ( rule__ConstantDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__ConstantDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6078:1: ( ( ( rule__ConstantDefinitionRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:6079:1: ( ( rule__ConstantDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:6079:1: ( ( rule__ConstantDefinitionRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:6080:2: ( rule__ConstantDefinitionRule__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getNameAssignment_2()); 
            }
            // InternalDefinitionLanguage.g:6081:2: ( rule__ConstantDefinitionRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:6081:3: rule__ConstantDefinitionRule__NameAssignment_2
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
    // InternalDefinitionLanguage.g:6089:1: rule__ConstantDefinitionRule__Group__3 : rule__ConstantDefinitionRule__Group__3__Impl rule__ConstantDefinitionRule__Group__4 ;
    public final void rule__ConstantDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6093:1: ( rule__ConstantDefinitionRule__Group__3__Impl rule__ConstantDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:6094:2: rule__ConstantDefinitionRule__Group__3__Impl rule__ConstantDefinitionRule__Group__4
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
    // InternalDefinitionLanguage.g:6101:1: rule__ConstantDefinitionRule__Group__3__Impl : ( ':=' ) ;
    public final void rule__ConstantDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6105:1: ( ( ':=' ) )
            // InternalDefinitionLanguage.g:6106:1: ( ':=' )
            {
            // InternalDefinitionLanguage.g:6106:1: ( ':=' )
            // InternalDefinitionLanguage.g:6107:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getColonEqualsSignKeyword_3()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6116:1: rule__ConstantDefinitionRule__Group__4 : rule__ConstantDefinitionRule__Group__4__Impl rule__ConstantDefinitionRule__Group__5 ;
    public final void rule__ConstantDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6120:1: ( rule__ConstantDefinitionRule__Group__4__Impl rule__ConstantDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:6121:2: rule__ConstantDefinitionRule__Group__4__Impl rule__ConstantDefinitionRule__Group__5
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
    // InternalDefinitionLanguage.g:6128:1: rule__ConstantDefinitionRule__Group__4__Impl : ( ( rule__ConstantDefinitionRule__ValueAssignment_4 ) ) ;
    public final void rule__ConstantDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6132:1: ( ( ( rule__ConstantDefinitionRule__ValueAssignment_4 ) ) )
            // InternalDefinitionLanguage.g:6133:1: ( ( rule__ConstantDefinitionRule__ValueAssignment_4 ) )
            {
            // InternalDefinitionLanguage.g:6133:1: ( ( rule__ConstantDefinitionRule__ValueAssignment_4 ) )
            // InternalDefinitionLanguage.g:6134:2: ( rule__ConstantDefinitionRule__ValueAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantDefinitionRuleAccess().getValueAssignment_4()); 
            }
            // InternalDefinitionLanguage.g:6135:2: ( rule__ConstantDefinitionRule__ValueAssignment_4 )
            // InternalDefinitionLanguage.g:6135:3: rule__ConstantDefinitionRule__ValueAssignment_4
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
    // InternalDefinitionLanguage.g:6143:1: rule__ConstantDefinitionRule__Group__5 : rule__ConstantDefinitionRule__Group__5__Impl ;
    public final void rule__ConstantDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6147:1: ( rule__ConstantDefinitionRule__Group__5__Impl )
            // InternalDefinitionLanguage.g:6148:2: rule__ConstantDefinitionRule__Group__5__Impl
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
    // InternalDefinitionLanguage.g:6154:1: rule__ConstantDefinitionRule__Group__5__Impl : ( ';' ) ;
    public final void rule__ConstantDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6158:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:6159:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:6159:1: ( ';' )
            // InternalDefinitionLanguage.g:6160:2: ';'
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
    // InternalDefinitionLanguage.g:6170:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6174:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalDefinitionLanguage.g:6175:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
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
    // InternalDefinitionLanguage.g:6182:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6186:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:6187:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:6187:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalDefinitionLanguage.g:6188:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            }
            // InternalDefinitionLanguage.g:6189:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalDefinitionLanguage.g:6189:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalDefinitionLanguage.g:6197:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6201:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:6202:2: rule__ParameterRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:6208:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6212:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:6213:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:6213:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalDefinitionLanguage.g:6214:2: ( rule__ParameterRule__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:6215:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalDefinitionLanguage.g:6215:3: rule__ParameterRule__NameAssignment_1
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
    // InternalDefinitionLanguage.g:6224:1: rule__ImportRule__Group__0 : rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 ;
    public final void rule__ImportRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6228:1: ( rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1 )
            // InternalDefinitionLanguage.g:6229:2: rule__ImportRule__Group__0__Impl rule__ImportRule__Group__1
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
    // InternalDefinitionLanguage.g:6236:1: rule__ImportRule__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6240:1: ( ( 'import' ) )
            // InternalDefinitionLanguage.g:6241:1: ( 'import' )
            {
            // InternalDefinitionLanguage.g:6241:1: ( 'import' )
            // InternalDefinitionLanguage.g:6242:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportKeyword_0()); 
            }
            match(input,84,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6251:1: rule__ImportRule__Group__1 : rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 ;
    public final void rule__ImportRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6255:1: ( rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2 )
            // InternalDefinitionLanguage.g:6256:2: rule__ImportRule__Group__1__Impl rule__ImportRule__Group__2
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
    // InternalDefinitionLanguage.g:6263:1: rule__ImportRule__Group__1__Impl : ( ( rule__ImportRule__LanguageAssignment_1 ) ) ;
    public final void rule__ImportRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6267:1: ( ( ( rule__ImportRule__LanguageAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:6268:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:6268:1: ( ( rule__ImportRule__LanguageAssignment_1 ) )
            // InternalDefinitionLanguage.g:6269:2: ( rule__ImportRule__LanguageAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getLanguageAssignment_1()); 
            }
            // InternalDefinitionLanguage.g:6270:2: ( rule__ImportRule__LanguageAssignment_1 )
            // InternalDefinitionLanguage.g:6270:3: rule__ImportRule__LanguageAssignment_1
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
    // InternalDefinitionLanguage.g:6278:1: rule__ImportRule__Group__2 : rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 ;
    public final void rule__ImportRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6282:1: ( rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3 )
            // InternalDefinitionLanguage.g:6283:2: rule__ImportRule__Group__2__Impl rule__ImportRule__Group__3
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
    // InternalDefinitionLanguage.g:6290:1: rule__ImportRule__Group__2__Impl : ( 'from' ) ;
    public final void rule__ImportRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6294:1: ( ( 'from' ) )
            // InternalDefinitionLanguage.g:6295:1: ( 'from' )
            {
            // InternalDefinitionLanguage.g:6295:1: ( 'from' )
            // InternalDefinitionLanguage.g:6296:2: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getFromKeyword_2()); 
            }
            match(input,85,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6305:1: rule__ImportRule__Group__3 : rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 ;
    public final void rule__ImportRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6309:1: ( rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4 )
            // InternalDefinitionLanguage.g:6310:2: rule__ImportRule__Group__3__Impl rule__ImportRule__Group__4
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
    // InternalDefinitionLanguage.g:6317:1: rule__ImportRule__Group__3__Impl : ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) ;
    public final void rule__ImportRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6321:1: ( ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) ) )
            // InternalDefinitionLanguage.g:6322:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            {
            // InternalDefinitionLanguage.g:6322:1: ( ( rule__ImportRule__ImportedNamespaceAssignment_3 ) )
            // InternalDefinitionLanguage.g:6323:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRuleAccess().getImportedNamespaceAssignment_3()); 
            }
            // InternalDefinitionLanguage.g:6324:2: ( rule__ImportRule__ImportedNamespaceAssignment_3 )
            // InternalDefinitionLanguage.g:6324:3: rule__ImportRule__ImportedNamespaceAssignment_3
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
    // InternalDefinitionLanguage.g:6332:1: rule__ImportRule__Group__4 : rule__ImportRule__Group__4__Impl ;
    public final void rule__ImportRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6336:1: ( rule__ImportRule__Group__4__Impl )
            // InternalDefinitionLanguage.g:6337:2: rule__ImportRule__Group__4__Impl
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
    // InternalDefinitionLanguage.g:6343:1: rule__ImportRule__Group__4__Impl : ( ';' ) ;
    public final void rule__ImportRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6347:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:6348:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:6348:1: ( ';' )
            // InternalDefinitionLanguage.g:6349:2: ';'
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
    // InternalDefinitionLanguage.g:6359:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6363:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDefinitionLanguage.g:6364:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_62);
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
    // InternalDefinitionLanguage.g:6371:1: rule__QualifiedName__Group__0__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6375:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:6376:1: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:6376:1: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:6377:2: ruleStringOrId
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
    // InternalDefinitionLanguage.g:6386:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6390:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDefinitionLanguage.g:6391:2: rule__QualifiedName__Group__1__Impl
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
    // InternalDefinitionLanguage.g:6397:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6401:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:6402:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:6402:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDefinitionLanguage.g:6403:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalDefinitionLanguage.g:6404:2: ( rule__QualifiedName__Group_1__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==86) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:6404:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_63);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // InternalDefinitionLanguage.g:6413:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6417:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDefinitionLanguage.g:6418:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalDefinitionLanguage.g:6425:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6429:1: ( ( '.' ) )
            // InternalDefinitionLanguage.g:6430:1: ( '.' )
            {
            // InternalDefinitionLanguage.g:6430:1: ( '.' )
            // InternalDefinitionLanguage.g:6431:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,86,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6440:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6444:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:6445:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:6451:1: rule__QualifiedName__Group_1__1__Impl : ( ruleStringOrId ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6455:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:6456:1: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:6456:1: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:6457:2: ruleStringOrId
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
    // InternalDefinitionLanguage.g:6467:1: rule__DefinitionModelRule__ImportsAssignment_0 : ( ruleImportRule ) ;
    public final void rule__DefinitionModelRule__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6471:1: ( ( ruleImportRule ) )
            // InternalDefinitionLanguage.g:6472:2: ( ruleImportRule )
            {
            // InternalDefinitionLanguage.g:6472:2: ( ruleImportRule )
            // InternalDefinitionLanguage.g:6473:3: ruleImportRule
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
    // InternalDefinitionLanguage.g:6482:1: rule__DefinitionModelRule__NameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__DefinitionModelRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6486:1: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:6487:2: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:6487:2: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:6488:3: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:6497:1: rule__DefinitionModelRule__EnumsAssignment_4_0 : ( ruleEnumTypeDefinitionRule ) ;
    public final void rule__DefinitionModelRule__EnumsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6501:1: ( ( ruleEnumTypeDefinitionRule ) )
            // InternalDefinitionLanguage.g:6502:2: ( ruleEnumTypeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:6502:2: ( ruleEnumTypeDefinitionRule )
            // InternalDefinitionLanguage.g:6503:3: ruleEnumTypeDefinitionRule
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
    // InternalDefinitionLanguage.g:6512:1: rule__DefinitionModelRule__TypesAssignment_4_1 : ( ruleClassDefinitionRule ) ;
    public final void rule__DefinitionModelRule__TypesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6516:1: ( ( ruleClassDefinitionRule ) )
            // InternalDefinitionLanguage.g:6517:2: ( ruleClassDefinitionRule )
            {
            // InternalDefinitionLanguage.g:6517:2: ( ruleClassDefinitionRule )
            // InternalDefinitionLanguage.g:6518:3: ruleClassDefinitionRule
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
    // InternalDefinitionLanguage.g:6527:1: rule__DefinitionModelRule__FunctionsAssignment_4_2 : ( ruleFunctionDefinitionRule ) ;
    public final void rule__DefinitionModelRule__FunctionsAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6531:1: ( ( ruleFunctionDefinitionRule ) )
            // InternalDefinitionLanguage.g:6532:2: ( ruleFunctionDefinitionRule )
            {
            // InternalDefinitionLanguage.g:6532:2: ( ruleFunctionDefinitionRule )
            // InternalDefinitionLanguage.g:6533:3: ruleFunctionDefinitionRule
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
    // InternalDefinitionLanguage.g:6542:1: rule__DefinitionModelRule__ConstantsAssignment_4_3 : ( ruleConstantDefinitionRule ) ;
    public final void rule__DefinitionModelRule__ConstantsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6546:1: ( ( ruleConstantDefinitionRule ) )
            // InternalDefinitionLanguage.g:6547:2: ( ruleConstantDefinitionRule )
            {
            // InternalDefinitionLanguage.g:6547:2: ( ruleConstantDefinitionRule )
            // InternalDefinitionLanguage.g:6548:3: ruleConstantDefinitionRule
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
    // InternalDefinitionLanguage.g:6557:1: rule__EnumLiteralRule__NameAssignment : ( ruleStringOrId ) ;
    public final void rule__EnumLiteralRule__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6561:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:6562:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:6562:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:6563:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:6572:1: rule__EnumTypeDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__EnumTypeDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6576:1: ( ( ruleConstraintRule ) )
            // InternalDefinitionLanguage.g:6577:2: ( ruleConstraintRule )
            {
            // InternalDefinitionLanguage.g:6577:2: ( ruleConstraintRule )
            // InternalDefinitionLanguage.g:6578:3: ruleConstraintRule
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
    // InternalDefinitionLanguage.g:6587:1: rule__EnumTypeDefinitionRule__ScaleAssignment_1 : ( ruleScaleType ) ;
    public final void rule__EnumTypeDefinitionRule__ScaleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6591:1: ( ( ruleScaleType ) )
            // InternalDefinitionLanguage.g:6592:2: ( ruleScaleType )
            {
            // InternalDefinitionLanguage.g:6592:2: ( ruleScaleType )
            // InternalDefinitionLanguage.g:6593:3: ruleScaleType
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
    // InternalDefinitionLanguage.g:6602:1: rule__EnumTypeDefinitionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__EnumTypeDefinitionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6606:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:6607:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:6607:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:6608:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:6617:1: rule__EnumTypeDefinitionRule__LiteralsAssignment_5 : ( ruleEnumLiteralRule ) ;
    public final void rule__EnumTypeDefinitionRule__LiteralsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6621:1: ( ( ruleEnumLiteralRule ) )
            // InternalDefinitionLanguage.g:6622:2: ( ruleEnumLiteralRule )
            {
            // InternalDefinitionLanguage.g:6622:2: ( ruleEnumLiteralRule )
            // InternalDefinitionLanguage.g:6623:3: ruleEnumLiteralRule
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
    // InternalDefinitionLanguage.g:6632:1: rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1 : ( ruleEnumLiteralRule ) ;
    public final void rule__EnumTypeDefinitionRule__LiteralsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6636:1: ( ( ruleEnumLiteralRule ) )
            // InternalDefinitionLanguage.g:6637:2: ( ruleEnumLiteralRule )
            {
            // InternalDefinitionLanguage.g:6637:2: ( ruleEnumLiteralRule )
            // InternalDefinitionLanguage.g:6638:3: ruleEnumLiteralRule
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
    // InternalDefinitionLanguage.g:6647:1: rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3 : ( ruleStatementRule ) ;
    public final void rule__EnumTypeDefinitionRule__ConstraintsAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6651:1: ( ( ruleStatementRule ) )
            // InternalDefinitionLanguage.g:6652:2: ( ruleStatementRule )
            {
            // InternalDefinitionLanguage.g:6652:2: ( ruleStatementRule )
            // InternalDefinitionLanguage.g:6653:3: ruleStatementRule
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
    // InternalDefinitionLanguage.g:6662:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6666:1: ( ( ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:6667:2: ( ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:6667:2: ( ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:6668:3: ruleXorExpressionRule
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
    // InternalDefinitionLanguage.g:6677:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6681:1: ( ( ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:6682:2: ( ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:6682:2: ( ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:6683:3: ruleXorExpressionRule
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
    // InternalDefinitionLanguage.g:6692:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6696:1: ( ( ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:6697:2: ( ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:6697:2: ( ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:6698:3: ruleAndExpressionRule
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
    // InternalDefinitionLanguage.g:6707:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6711:1: ( ( ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:6712:2: ( ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:6712:2: ( ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:6713:3: ruleAndExpressionRule
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
    // InternalDefinitionLanguage.g:6722:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6726:1: ( ( ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:6727:2: ( ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:6727:2: ( ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:6728:3: ruleNotExpressionRule
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
    // InternalDefinitionLanguage.g:6737:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6741:1: ( ( ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:6742:2: ( ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:6742:2: ( ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:6743:3: ruleNotExpressionRule
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
    // InternalDefinitionLanguage.g:6752:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6756:1: ( ( ( '!' ) ) )
            // InternalDefinitionLanguage.g:6757:2: ( ( '!' ) )
            {
            // InternalDefinitionLanguage.g:6757:2: ( ( '!' ) )
            // InternalDefinitionLanguage.g:6758:3: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            // InternalDefinitionLanguage.g:6759:3: ( '!' )
            // InternalDefinitionLanguage.g:6760:4: '!'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            }
            match(input,87,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:6771:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6775:1: ( ( ruleComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:6776:2: ( ruleComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:6776:2: ( ruleComparisonExpressionRule )
            // InternalDefinitionLanguage.g:6777:3: ruleComparisonExpressionRule
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
    // InternalDefinitionLanguage.g:6786:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6790:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:6791:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:6791:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:6792:3: ruleAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:6801:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6805:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:6806:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:6806:2: ( rulePartialComparisonExpressionRule )
            // InternalDefinitionLanguage.g:6807:3: rulePartialComparisonExpressionRule
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
    // InternalDefinitionLanguage.g:6816:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6820:1: ( ( ruleComparisonOperatorRule ) )
            // InternalDefinitionLanguage.g:6821:2: ( ruleComparisonOperatorRule )
            {
            // InternalDefinitionLanguage.g:6821:2: ( ruleComparisonOperatorRule )
            // InternalDefinitionLanguage.g:6822:3: ruleComparisonOperatorRule
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
    // InternalDefinitionLanguage.g:6831:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6835:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:6836:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:6836:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:6837:3: ruleAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:6846:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6850:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:6851:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:6851:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:6852:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDefinitionLanguage.g:6861:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6865:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDefinitionLanguage.g:6866:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDefinitionLanguage.g:6866:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDefinitionLanguage.g:6867:3: ruleAddOrSubtractOperatorRule
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
    // InternalDefinitionLanguage.g:6876:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6880:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:6881:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:6881:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:6882:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDefinitionLanguage.g:6891:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6895:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:6896:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:6896:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:6897:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:6906:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6910:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalDefinitionLanguage.g:6911:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalDefinitionLanguage.g:6911:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalDefinitionLanguage.g:6912:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalDefinitionLanguage.g:6921:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6925:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:6926:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:6926:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:6927:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:6936:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6940:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:6941:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:6941:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:6942:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:6951:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6955:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:6956:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:6956:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:6957:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:6966:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6970:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDefinitionLanguage.g:6971:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDefinitionLanguage.g:6971:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDefinitionLanguage.g:6972:3: ruleAddOrSubtractOperatorRule
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
    // InternalDefinitionLanguage.g:6981:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleReadExpressionRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:6985:1: ( ( ruleReadExpressionRule ) )
            // InternalDefinitionLanguage.g:6986:2: ( ruleReadExpressionRule )
            {
            // InternalDefinitionLanguage.g:6986:2: ( ruleReadExpressionRule )
            // InternalDefinitionLanguage.g:6987:3: ruleReadExpressionRule
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
    // InternalDefinitionLanguage.g:6996:1: rule__ArrayRule__ValuesAssignment_2_0 : ( ruleReadExpressionRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7000:1: ( ( ruleReadExpressionRule ) )
            // InternalDefinitionLanguage.g:7001:2: ( ruleReadExpressionRule )
            {
            // InternalDefinitionLanguage.g:7001:2: ( ruleReadExpressionRule )
            // InternalDefinitionLanguage.g:7002:3: ruleReadExpressionRule
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
    // InternalDefinitionLanguage.g:7011:1: rule__ArrayRule__ValuesAssignment_2_1_1 : ( ruleReadExpressionRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7015:1: ( ( ruleReadExpressionRule ) )
            // InternalDefinitionLanguage.g:7016:2: ( ruleReadExpressionRule )
            {
            // InternalDefinitionLanguage.g:7016:2: ( ruleReadExpressionRule )
            // InternalDefinitionLanguage.g:7017:3: ruleReadExpressionRule
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
    // InternalDefinitionLanguage.g:7026:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7030:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:7031:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:7031:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:7032:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:7041:1: rule__CallRule__FunctionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7045:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7046:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7046:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7047:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionCrossReference_0_0()); 
            }
            // InternalDefinitionLanguage.g:7048:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7049:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7060:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7064:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:7065:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:7065:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:7066:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:7075:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7079:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:7080:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:7080:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:7081:3: ruleExpressionRule
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


    // $ANTLR start "rule__LiteralDefinitionReferenceRule__DefinitionAssignment"
    // InternalDefinitionLanguage.g:7090:1: rule__LiteralDefinitionReferenceRule__DefinitionAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__LiteralDefinitionReferenceRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7094:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7095:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7095:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7096:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralDefinitionReferenceRuleAccess().getDefinitionLiteralDefinitionCrossReference_0()); 
            }
            // InternalDefinitionLanguage.g:7097:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7098:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralDefinitionReferenceRuleAccess().getDefinitionLiteralDefinitionQualifiedNameParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralDefinitionReferenceRuleAccess().getDefinitionLiteralDefinitionQualifiedNameParserRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralDefinitionReferenceRuleAccess().getDefinitionLiteralDefinitionCrossReference_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralDefinitionReferenceRule__DefinitionAssignment"


    // $ANTLR start "rule__BaseDataReferenceRule__DefinitionAssignment_1"
    // InternalDefinitionLanguage.g:7109:1: rule__BaseDataReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__BaseDataReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7113:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7114:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7114:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7115:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionBaseDataDescriptionCrossReference_1_0()); 
            }
            // InternalDefinitionLanguage.g:7116:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7117:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7128:1: rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__StructuredDataDescriptionReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7132:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7133:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7133:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7134:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionStructuredDataDescriptionCrossReference_1_0()); 
            }
            // InternalDefinitionLanguage.g:7135:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7136:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7147:1: rule__InstanceLiteralRule__DefinitionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__InstanceLiteralRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7151:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7152:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7152:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7153:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionClassDefinitionCrossReference_0_0()); 
            }
            // InternalDefinitionLanguage.g:7154:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7155:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7166:1: rule__InstanceLiteralRule__AttributesAssignment_2 : ( ruleAttributeRule ) ;
    public final void rule__InstanceLiteralRule__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7170:1: ( ( ruleAttributeRule ) )
            // InternalDefinitionLanguage.g:7171:2: ( ruleAttributeRule )
            {
            // InternalDefinitionLanguage.g:7171:2: ( ruleAttributeRule )
            // InternalDefinitionLanguage.g:7172:3: ruleAttributeRule
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
    // InternalDefinitionLanguage.g:7181:1: rule__AttributeRule__DefinitionAssignment_0 : ( ( ruleStringOrId ) ) ;
    public final void rule__AttributeRule__DefinitionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7185:1: ( ( ( ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:7186:2: ( ( ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:7186:2: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7187:3: ( ruleStringOrId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0()); 
            }
            // InternalDefinitionLanguage.g:7188:3: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7189:4: ruleStringOrId
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
    // InternalDefinitionLanguage.g:7200:1: rule__AttributeRule__ValueAssignment_2 : ( ruleExpressionRule ) ;
    public final void rule__AttributeRule__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7204:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:7205:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:7205:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:7206:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:7215:1: rule__RealLiteralRule__LiteralAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__RealLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7219:1: ( ( RULE_DOUBLE ) )
            // InternalDefinitionLanguage.g:7220:2: ( RULE_DOUBLE )
            {
            // InternalDefinitionLanguage.g:7220:2: ( RULE_DOUBLE )
            // InternalDefinitionLanguage.g:7221:3: RULE_DOUBLE
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
    // InternalDefinitionLanguage.g:7230:1: rule__RealLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__RealLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7234:1: ( ( ruleFactorRule ) )
            // InternalDefinitionLanguage.g:7235:2: ( ruleFactorRule )
            {
            // InternalDefinitionLanguage.g:7235:2: ( ruleFactorRule )
            // InternalDefinitionLanguage.g:7236:3: ruleFactorRule
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
    // InternalDefinitionLanguage.g:7245:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7249:1: ( ( RULE_INT ) )
            // InternalDefinitionLanguage.g:7250:2: ( RULE_INT )
            {
            // InternalDefinitionLanguage.g:7250:2: ( RULE_INT )
            // InternalDefinitionLanguage.g:7251:3: RULE_INT
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
    // InternalDefinitionLanguage.g:7260:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7264:1: ( ( ruleFactorRule ) )
            // InternalDefinitionLanguage.g:7265:2: ( ruleFactorRule )
            {
            // InternalDefinitionLanguage.g:7265:2: ( ruleFactorRule )
            // InternalDefinitionLanguage.g:7266:3: ruleFactorRule
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
    // InternalDefinitionLanguage.g:7275:1: rule__StringLiteralRule__LiteralAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__LiteralAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7279:1: ( ( RULE_STRING ) )
            // InternalDefinitionLanguage.g:7280:2: ( RULE_STRING )
            {
            // InternalDefinitionLanguage.g:7280:2: ( RULE_STRING )
            // InternalDefinitionLanguage.g:7281:3: RULE_STRING
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
    // InternalDefinitionLanguage.g:7290:1: rule__BooleanLiteralRule__LiteralAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__LiteralAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7294:1: ( ( ( 'true' ) ) )
            // InternalDefinitionLanguage.g:7295:2: ( ( 'true' ) )
            {
            // InternalDefinitionLanguage.g:7295:2: ( ( 'true' ) )
            // InternalDefinitionLanguage.g:7296:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0()); 
            }
            // InternalDefinitionLanguage.g:7297:3: ( 'true' )
            // InternalDefinitionLanguage.g:7298:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0()); 
            }
            match(input,88,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:7309:1: rule__ClassDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__ClassDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7313:1: ( ( ruleConstraintRule ) )
            // InternalDefinitionLanguage.g:7314:2: ( ruleConstraintRule )
            {
            // InternalDefinitionLanguage.g:7314:2: ( ruleConstraintRule )
            // InternalDefinitionLanguage.g:7315:3: ruleConstraintRule
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
    // InternalDefinitionLanguage.g:7324:1: rule__ClassDefinitionRule__AbstractAssignment_1 : ( ( 'abstract' ) ) ;
    public final void rule__ClassDefinitionRule__AbstractAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7328:1: ( ( ( 'abstract' ) ) )
            // InternalDefinitionLanguage.g:7329:2: ( ( 'abstract' ) )
            {
            // InternalDefinitionLanguage.g:7329:2: ( ( 'abstract' ) )
            // InternalDefinitionLanguage.g:7330:3: ( 'abstract' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getAbstractAbstractKeyword_1_0()); 
            }
            // InternalDefinitionLanguage.g:7331:3: ( 'abstract' )
            // InternalDefinitionLanguage.g:7332:4: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getAbstractAbstractKeyword_1_0()); 
            }
            match(input,89,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:7343:1: rule__ClassDefinitionRule__NameAssignment_3 : ( ruleStringOrId ) ;
    public final void rule__ClassDefinitionRule__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7347:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7348:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:7348:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7349:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:7358:1: rule__ClassDefinitionRule__SuperTypeAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ClassDefinitionRule__SuperTypeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7362:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7363:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7363:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7364:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassDefinitionRuleAccess().getSuperTypeClassDefinitionCrossReference_4_1_0()); 
            }
            // InternalDefinitionLanguage.g:7365:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7366:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7377:1: rule__ClassDefinitionRule__AttributesAssignment_6 : ( ruleAttributeDefinitionRule ) ;
    public final void rule__ClassDefinitionRule__AttributesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7381:1: ( ( ruleAttributeDefinitionRule ) )
            // InternalDefinitionLanguage.g:7382:2: ( ruleAttributeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:7382:2: ( ruleAttributeDefinitionRule )
            // InternalDefinitionLanguage.g:7383:3: ruleAttributeDefinitionRule
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
    // InternalDefinitionLanguage.g:7392:1: rule__AttributeDefinitionRule__ConstraintsAssignment_0 : ( ruleConstraintRule ) ;
    public final void rule__AttributeDefinitionRule__ConstraintsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7396:1: ( ( ruleConstraintRule ) )
            // InternalDefinitionLanguage.g:7397:2: ( ruleConstraintRule )
            {
            // InternalDefinitionLanguage.g:7397:2: ( ruleConstraintRule )
            // InternalDefinitionLanguage.g:7398:3: ruleConstraintRule
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
    // InternalDefinitionLanguage.g:7407:1: rule__AttributeDefinitionRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__AttributeDefinitionRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7411:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7412:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:7412:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7413:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:7422:1: rule__AttributeDefinitionRule__OptionalAssignment_3 : ( ( 'optional' ) ) ;
    public final void rule__AttributeDefinitionRule__OptionalAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7426:1: ( ( ( 'optional' ) ) )
            // InternalDefinitionLanguage.g:7427:2: ( ( 'optional' ) )
            {
            // InternalDefinitionLanguage.g:7427:2: ( ( 'optional' ) )
            // InternalDefinitionLanguage.g:7428:3: ( 'optional' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0()); 
            }
            // InternalDefinitionLanguage.g:7429:3: ( 'optional' )
            // InternalDefinitionLanguage.g:7430:4: 'optional'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0()); 
            }
            match(input,90,FOLLOW_2); if (state.failed) return ;
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
    // InternalDefinitionLanguage.g:7441:1: rule__AttributeDefinitionRule__TypeAssignment_4 : ( ruleTypeRule ) ;
    public final void rule__AttributeDefinitionRule__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7445:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:7446:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:7446:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:7447:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:7456:1: rule__AttributeDefinitionRule__InitialisationAssignment_5_1 : ( ruleExpressionRule ) ;
    public final void rule__AttributeDefinitionRule__InitialisationAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7460:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:7461:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:7461:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:7462:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:7471:1: rule__EnumReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__EnumReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7475:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7476:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7476:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7477:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumReferenceRuleAccess().getDefinitionEnumDefinitionCrossReference_1_0()); 
            }
            // InternalDefinitionLanguage.g:7478:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7479:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7490:1: rule__TypeReferenceRule__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TypeReferenceRule__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7494:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:7495:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:7495:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7496:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRuleAccess().getDefinitionClassDefinitionCrossReference_1_0()); 
            }
            // InternalDefinitionLanguage.g:7497:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7498:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:7509:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7513:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:7514:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:7514:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:7515:3: ruleTypeRule
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


    // $ANTLR start "rule__FunctionDefinitionRule__TypeAssignment_1"
    // InternalDefinitionLanguage.g:7524:1: rule__FunctionDefinitionRule__TypeAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__FunctionDefinitionRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7528:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:7529:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:7529:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:7530:3: ruleTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__TypeAssignment_1"


    // $ANTLR start "rule__FunctionDefinitionRule__NameAssignment_2"
    // InternalDefinitionLanguage.g:7539:1: rule__FunctionDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__FunctionDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7543:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7544:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:7544:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7545:3: ruleStringOrId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__NameAssignment_2"


    // $ANTLR start "rule__FunctionDefinitionRule__ParametersAssignment_4_0"
    // InternalDefinitionLanguage.g:7554:1: rule__FunctionDefinitionRule__ParametersAssignment_4_0 : ( ruleParameterRule ) ;
    public final void rule__FunctionDefinitionRule__ParametersAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7558:1: ( ( ruleParameterRule ) )
            // InternalDefinitionLanguage.g:7559:2: ( ruleParameterRule )
            {
            // InternalDefinitionLanguage.g:7559:2: ( ruleParameterRule )
            // InternalDefinitionLanguage.g:7560:3: ruleParameterRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleParameterRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__ParametersAssignment_4_0"


    // $ANTLR start "rule__FunctionDefinitionRule__ParametersAssignment_4_1_1"
    // InternalDefinitionLanguage.g:7569:1: rule__FunctionDefinitionRule__ParametersAssignment_4_1_1 : ( ruleParameterRule ) ;
    public final void rule__FunctionDefinitionRule__ParametersAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7573:1: ( ( ruleParameterRule ) )
            // InternalDefinitionLanguage.g:7574:2: ( ruleParameterRule )
            {
            // InternalDefinitionLanguage.g:7574:2: ( ruleParameterRule )
            // InternalDefinitionLanguage.g:7575:3: ruleParameterRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleParameterRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionDefinitionRule__ParametersAssignment_4_1_1"


    // $ANTLR start "rule__ConstantDefinitionRule__TypeAssignment_1"
    // InternalDefinitionLanguage.g:7584:1: rule__ConstantDefinitionRule__TypeAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ConstantDefinitionRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7588:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:7589:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:7589:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:7590:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:7599:1: rule__ConstantDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__ConstantDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7603:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7604:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:7604:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7605:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:7614:1: rule__ConstantDefinitionRule__ValueAssignment_4 : ( ruleExpressionRule ) ;
    public final void rule__ConstantDefinitionRule__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7618:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:7619:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:7619:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:7620:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:7629:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7633:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:7634:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:7634:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:7635:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:7644:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7648:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:7649:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:7649:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:7650:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:7659:1: rule__ImportRule__LanguageAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ImportRule__LanguageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7663:1: ( ( RULE_STRING ) )
            // InternalDefinitionLanguage.g:7664:2: ( RULE_STRING )
            {
            // InternalDefinitionLanguage.g:7664:2: ( RULE_STRING )
            // InternalDefinitionLanguage.g:7665:3: RULE_STRING
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
    // InternalDefinitionLanguage.g:7674:1: rule__ImportRule__ImportedNamespaceAssignment_3 : ( ruleQualifiedName ) ;
    public final void rule__ImportRule__ImportedNamespaceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:7678:1: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:7679:2: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:7679:2: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:7680:3: ruleQualifiedName
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
        // InternalDefinitionLanguage.g:1489:2: ( ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) ) )
        // InternalDefinitionLanguage.g:1489:2: ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) )
        {
        // InternalDefinitionLanguage.g:1489:2: ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) )
        // InternalDefinitionLanguage.g:1490:3: ( rule__DefinitionModelRule__EnumsAssignment_4_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getDefinitionModelRuleAccess().getEnumsAssignment_4_0()); 
        }
        // InternalDefinitionLanguage.g:1491:3: ( rule__DefinitionModelRule__EnumsAssignment_4_0 )
        // InternalDefinitionLanguage.g:1491:4: rule__DefinitionModelRule__EnumsAssignment_4_0
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
        // InternalDefinitionLanguage.g:1495:2: ( ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) ) )
        // InternalDefinitionLanguage.g:1495:2: ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) )
        {
        // InternalDefinitionLanguage.g:1495:2: ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) )
        // InternalDefinitionLanguage.g:1496:3: ( rule__DefinitionModelRule__TypesAssignment_4_1 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getDefinitionModelRuleAccess().getTypesAssignment_4_1()); 
        }
        // InternalDefinitionLanguage.g:1497:3: ( rule__DefinitionModelRule__TypesAssignment_4_1 )
        // InternalDefinitionLanguage.g:1497:4: rule__DefinitionModelRule__TypesAssignment_4_1
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\20\1\0\10\uffff";
    static final String dfa_3s = "\1\131\1\0\10\uffff";
    static final String dfa_4s = "\2\uffff\1\1\3\uffff\1\2\1\uffff\1\3\1\4";
    static final String dfa_5s = "\1\uffff\1\0\10\uffff}>";
    static final String[] dfa_6s = {
            "\4\2\63\uffff\1\6\1\uffff\1\1\10\uffff\1\10\1\11\5\uffff\1\6",
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
            return "1484:1: rule__DefinitionModelRule__Alternatives_4 : ( ( ( rule__DefinitionModelRule__EnumsAssignment_4_0 ) ) | ( ( rule__DefinitionModelRule__TypesAssignment_4_1 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_4_2 ) ) | ( ( rule__DefinitionModelRule__ConstantsAssignment_4_3 ) ) );";
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
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_9s = "\1\4\1\uffff\2\24\3\uffff\1\4\1\uffff\2\24";
    static final String dfa_10s = "\1\130\1\uffff\2\126\3\uffff\1\5\1\uffff\2\126";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\1\3\3\4\6\uffff\1\4\47\uffff\1\5\12\uffff\1\1\1\uffff\2\6\22\uffff\1\4",
            "",
            "\13\6\25\uffff\1\4\2\uffff\1\10\3\6\3\uffff\4\6\1\uffff\1\6\22\uffff\1\7",
            "\13\6\25\uffff\1\4\2\uffff\1\10\3\6\3\uffff\4\6\1\uffff\1\6\22\uffff\1\7",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\13\6\25\uffff\1\4\2\uffff\1\10\3\6\3\uffff\4\6\1\uffff\1\6\22\uffff\1\7",
            "\13\6\25\uffff\1\4\2\uffff\1\10\3\6\3\uffff\4\6\1\uffff\1\6\22\uffff\1\7"
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
            return "1517:1: rule__ReadExpressionRule__Alternatives : ( ( ruleArrayRule ) | ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleReferenceRule ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00200000000F0000L,0x00000000020C0280L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000F0002L,0x00000000020C0280L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000F0000L,0x0000000000000200L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0500000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0A00000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x008000000C0081F0L,0x0000000001800034L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x008000000C0081F2L,0x0000000001800034L});
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
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x008000000C0081F0L,0x000000000180003CL});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x018000000C0081F0L,0x0000000001800034L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0020000000000030L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0007FFFF80000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000008000L,0x0000000001000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000280L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0020000000000030L,0x0000000000000200L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000200L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x00000000000081F0L,0x0000000001000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000200L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0040000000000000L,0x000000000403FC30L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x000000000001E800L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0140000000000000L,0x000000000403FC30L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});

}
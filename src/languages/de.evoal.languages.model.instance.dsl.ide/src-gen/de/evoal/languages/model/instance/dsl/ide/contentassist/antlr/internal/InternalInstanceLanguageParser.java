package de.evoal.languages.model.instance.dsl.ide.contentassist.antlr.internal;

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
import de.evoal.languages.model.instance.dsl.services.InstanceLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalInstanceLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'{'", "'}'", "':='", "';'", "'['", "']'", "','", "'data'", "'OR'", "'XOR'", "'AND'", "'^'", "'('", "')'", "'call'", "'value'", "'.'", "'!'", "'true'"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int RULE_QUOTED_ID=4;
    public static final int RULE_ANY_OTHER=11;
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
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__42=42;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalInstanceLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalInstanceLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalInstanceLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalInstanceLanguage.g"; }


    	private InstanceLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(InstanceLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleInstanceRule"
    // InternalInstanceLanguage.g:54:1: entryRuleInstanceRule : ruleInstanceRule EOF ;
    public final void entryRuleInstanceRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:55:1: ( ruleInstanceRule EOF )
            // InternalInstanceLanguage.g:56:1: ruleInstanceRule EOF
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
    // InternalInstanceLanguage.g:63:1: ruleInstanceRule : ( ( rule__InstanceRule__Group__0 ) ) ;
    public final void ruleInstanceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:67:2: ( ( ( rule__InstanceRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:68:2: ( ( rule__InstanceRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:68:2: ( ( rule__InstanceRule__Group__0 ) )
            // InternalInstanceLanguage.g:69:3: ( rule__InstanceRule__Group__0 )
            {
             before(grammarAccess.getInstanceRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:70:3: ( rule__InstanceRule__Group__0 )
            // InternalInstanceLanguage.g:70:4: rule__InstanceRule__Group__0
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
    // InternalInstanceLanguage.g:79:1: entryRuleAttributeRule : ruleAttributeRule EOF ;
    public final void entryRuleAttributeRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:80:1: ( ruleAttributeRule EOF )
            // InternalInstanceLanguage.g:81:1: ruleAttributeRule EOF
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
    // InternalInstanceLanguage.g:88:1: ruleAttributeRule : ( ( rule__AttributeRule__Group__0 ) ) ;
    public final void ruleAttributeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:92:2: ( ( ( rule__AttributeRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:93:2: ( ( rule__AttributeRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:93:2: ( ( rule__AttributeRule__Group__0 ) )
            // InternalInstanceLanguage.g:94:3: ( rule__AttributeRule__Group__0 )
            {
             before(grammarAccess.getAttributeRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:95:3: ( rule__AttributeRule__Group__0 )
            // InternalInstanceLanguage.g:95:4: rule__AttributeRule__Group__0
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


    // $ANTLR start "entryRuleNameOrMiscRule"
    // InternalInstanceLanguage.g:104:1: entryRuleNameOrMiscRule : ruleNameOrMiscRule EOF ;
    public final void entryRuleNameOrMiscRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:105:1: ( ruleNameOrMiscRule EOF )
            // InternalInstanceLanguage.g:106:1: ruleNameOrMiscRule EOF
            {
             before(grammarAccess.getNameOrMiscRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleNameOrMiscRule();

            state._fsp--;

             after(grammarAccess.getNameOrMiscRuleRule()); 
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
    // $ANTLR end "entryRuleNameOrMiscRule"


    // $ANTLR start "ruleNameOrMiscRule"
    // InternalInstanceLanguage.g:113:1: ruleNameOrMiscRule : ( ( rule__NameOrMiscRule__Alternatives ) ) ;
    public final void ruleNameOrMiscRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:117:2: ( ( ( rule__NameOrMiscRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:118:2: ( ( rule__NameOrMiscRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:118:2: ( ( rule__NameOrMiscRule__Alternatives ) )
            // InternalInstanceLanguage.g:119:3: ( rule__NameOrMiscRule__Alternatives )
            {
             before(grammarAccess.getNameOrMiscRuleAccess().getAlternatives()); 
            // InternalInstanceLanguage.g:120:3: ( rule__NameOrMiscRule__Alternatives )
            // InternalInstanceLanguage.g:120:4: rule__NameOrMiscRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NameOrMiscRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNameOrMiscRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNameOrMiscRule"


    // $ANTLR start "entryRuleNameRule"
    // InternalInstanceLanguage.g:129:1: entryRuleNameRule : ruleNameRule EOF ;
    public final void entryRuleNameRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:130:1: ( ruleNameRule EOF )
            // InternalInstanceLanguage.g:131:1: ruleNameRule EOF
            {
             before(grammarAccess.getNameRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleNameRule();

            state._fsp--;

             after(grammarAccess.getNameRuleRule()); 
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
    // $ANTLR end "entryRuleNameRule"


    // $ANTLR start "ruleNameRule"
    // InternalInstanceLanguage.g:138:1: ruleNameRule : ( ( rule__NameRule__NameAssignment ) ) ;
    public final void ruleNameRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:142:2: ( ( ( rule__NameRule__NameAssignment ) ) )
            // InternalInstanceLanguage.g:143:2: ( ( rule__NameRule__NameAssignment ) )
            {
            // InternalInstanceLanguage.g:143:2: ( ( rule__NameRule__NameAssignment ) )
            // InternalInstanceLanguage.g:144:3: ( rule__NameRule__NameAssignment )
            {
             before(grammarAccess.getNameRuleAccess().getNameAssignment()); 
            // InternalInstanceLanguage.g:145:3: ( rule__NameRule__NameAssignment )
            // InternalInstanceLanguage.g:145:4: rule__NameRule__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__NameRule__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getNameRuleAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNameRule"


    // $ANTLR start "entryRuleMiscRule"
    // InternalInstanceLanguage.g:154:1: entryRuleMiscRule : ruleMiscRule EOF ;
    public final void entryRuleMiscRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:155:1: ( ruleMiscRule EOF )
            // InternalInstanceLanguage.g:156:1: ruleMiscRule EOF
            {
             before(grammarAccess.getMiscRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleMiscRule();

            state._fsp--;

             after(grammarAccess.getMiscRuleRule()); 
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
    // $ANTLR end "entryRuleMiscRule"


    // $ANTLR start "ruleMiscRule"
    // InternalInstanceLanguage.g:163:1: ruleMiscRule : ( ( rule__MiscRule__NameAssignment ) ) ;
    public final void ruleMiscRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:167:2: ( ( ( rule__MiscRule__NameAssignment ) ) )
            // InternalInstanceLanguage.g:168:2: ( ( rule__MiscRule__NameAssignment ) )
            {
            // InternalInstanceLanguage.g:168:2: ( ( rule__MiscRule__NameAssignment ) )
            // InternalInstanceLanguage.g:169:3: ( rule__MiscRule__NameAssignment )
            {
             before(grammarAccess.getMiscRuleAccess().getNameAssignment()); 
            // InternalInstanceLanguage.g:170:3: ( rule__MiscRule__NameAssignment )
            // InternalInstanceLanguage.g:170:4: rule__MiscRule__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MiscRule__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMiscRuleAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMiscRule"


    // $ANTLR start "entryRuleValueRule"
    // InternalInstanceLanguage.g:179:1: entryRuleValueRule : ruleValueRule EOF ;
    public final void entryRuleValueRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:180:1: ( ruleValueRule EOF )
            // InternalInstanceLanguage.g:181:1: ruleValueRule EOF
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
    // InternalInstanceLanguage.g:188:1: ruleValueRule : ( ( rule__ValueRule__Alternatives ) ) ;
    public final void ruleValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:192:2: ( ( ( rule__ValueRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:193:2: ( ( rule__ValueRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:193:2: ( ( rule__ValueRule__Alternatives ) )
            // InternalInstanceLanguage.g:194:3: ( rule__ValueRule__Alternatives )
            {
             before(grammarAccess.getValueRuleAccess().getAlternatives()); 
            // InternalInstanceLanguage.g:195:3: ( rule__ValueRule__Alternatives )
            // InternalInstanceLanguage.g:195:4: rule__ValueRule__Alternatives
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
    // InternalInstanceLanguage.g:204:1: entryRuleArrayRule : ruleArrayRule EOF ;
    public final void entryRuleArrayRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:205:1: ( ruleArrayRule EOF )
            // InternalInstanceLanguage.g:206:1: ruleArrayRule EOF
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
    // InternalInstanceLanguage.g:213:1: ruleArrayRule : ( ( rule__ArrayRule__Group__0 ) ) ;
    public final void ruleArrayRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:217:2: ( ( ( rule__ArrayRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:218:2: ( ( rule__ArrayRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:218:2: ( ( rule__ArrayRule__Group__0 ) )
            // InternalInstanceLanguage.g:219:3: ( rule__ArrayRule__Group__0 )
            {
             before(grammarAccess.getArrayRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:220:3: ( rule__ArrayRule__Group__0 )
            // InternalInstanceLanguage.g:220:4: rule__ArrayRule__Group__0
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
    // InternalInstanceLanguage.g:229:1: entryRuleLiteralValueRule : ruleLiteralValueRule EOF ;
    public final void entryRuleLiteralValueRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:230:1: ( ruleLiteralValueRule EOF )
            // InternalInstanceLanguage.g:231:1: ruleLiteralValueRule EOF
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
    // InternalInstanceLanguage.g:238:1: ruleLiteralValueRule : ( ( rule__LiteralValueRule__LiteralAssignment ) ) ;
    public final void ruleLiteralValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:242:2: ( ( ( rule__LiteralValueRule__LiteralAssignment ) ) )
            // InternalInstanceLanguage.g:243:2: ( ( rule__LiteralValueRule__LiteralAssignment ) )
            {
            // InternalInstanceLanguage.g:243:2: ( ( rule__LiteralValueRule__LiteralAssignment ) )
            // InternalInstanceLanguage.g:244:3: ( rule__LiteralValueRule__LiteralAssignment )
            {
             before(grammarAccess.getLiteralValueRuleAccess().getLiteralAssignment()); 
            // InternalInstanceLanguage.g:245:3: ( rule__LiteralValueRule__LiteralAssignment )
            // InternalInstanceLanguage.g:245:4: rule__LiteralValueRule__LiteralAssignment
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
    // InternalInstanceLanguage.g:254:1: entryRuleDataReferenceRule : ruleDataReferenceRule EOF ;
    public final void entryRuleDataReferenceRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:255:1: ( ruleDataReferenceRule EOF )
            // InternalInstanceLanguage.g:256:1: ruleDataReferenceRule EOF
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
    // InternalInstanceLanguage.g:263:1: ruleDataReferenceRule : ( ( rule__DataReferenceRule__Group__0 ) ) ;
    public final void ruleDataReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:267:2: ( ( ( rule__DataReferenceRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:268:2: ( ( rule__DataReferenceRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:268:2: ( ( rule__DataReferenceRule__Group__0 ) )
            // InternalInstanceLanguage.g:269:3: ( rule__DataReferenceRule__Group__0 )
            {
             before(grammarAccess.getDataReferenceRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:270:3: ( rule__DataReferenceRule__Group__0 )
            // InternalInstanceLanguage.g:270:4: rule__DataReferenceRule__Group__0
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


    // $ANTLR start "entryRuleExpressionRule"
    // InternalInstanceLanguage.g:279:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:280:1: ( ruleExpressionRule EOF )
            // InternalInstanceLanguage.g:281:1: ruleExpressionRule EOF
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
    // InternalInstanceLanguage.g:288:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:292:2: ( ( ruleOrExpressionRule ) )
            // InternalInstanceLanguage.g:293:2: ( ruleOrExpressionRule )
            {
            // InternalInstanceLanguage.g:293:2: ( ruleOrExpressionRule )
            // InternalInstanceLanguage.g:294:3: ruleOrExpressionRule
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
    // InternalInstanceLanguage.g:304:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:305:1: ( ruleOrExpressionRule EOF )
            // InternalInstanceLanguage.g:306:1: ruleOrExpressionRule EOF
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
    // InternalInstanceLanguage.g:313:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:317:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:318:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:318:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:319:3: ( rule__OrExpressionRule__Group__0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:320:3: ( rule__OrExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:320:4: rule__OrExpressionRule__Group__0
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
    // InternalInstanceLanguage.g:329:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:330:1: ( ruleXorExpressionRule EOF )
            // InternalInstanceLanguage.g:331:1: ruleXorExpressionRule EOF
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
    // InternalInstanceLanguage.g:338:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:342:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:343:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:343:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:344:3: ( rule__XorExpressionRule__Group__0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:345:3: ( rule__XorExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:345:4: rule__XorExpressionRule__Group__0
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
    // InternalInstanceLanguage.g:354:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:355:1: ( ruleAndExpressionRule EOF )
            // InternalInstanceLanguage.g:356:1: ruleAndExpressionRule EOF
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
    // InternalInstanceLanguage.g:363:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:367:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:368:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:368:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:369:3: ( rule__AndExpressionRule__Group__0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:370:3: ( rule__AndExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:370:4: rule__AndExpressionRule__Group__0
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
    // InternalInstanceLanguage.g:379:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:380:1: ( ruleNotExpressionRule EOF )
            // InternalInstanceLanguage.g:381:1: ruleNotExpressionRule EOF
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
    // InternalInstanceLanguage.g:388:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:392:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:393:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:393:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:394:3: ( rule__NotExpressionRule__Group__0 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:395:3: ( rule__NotExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:395:4: rule__NotExpressionRule__Group__0
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
    // InternalInstanceLanguage.g:404:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:405:1: ( ruleComparisonExpressionRule EOF )
            // InternalInstanceLanguage.g:406:1: ruleComparisonExpressionRule EOF
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
    // InternalInstanceLanguage.g:413:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:417:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:418:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:418:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:419:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:420:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:420:4: rule__ComparisonExpressionRule__Group__0
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
    // InternalInstanceLanguage.g:429:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:430:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalInstanceLanguage.g:431:1: rulePartialComparisonExpressionRule EOF
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
    // InternalInstanceLanguage.g:438:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:442:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:443:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:443:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:444:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:445:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:445:4: rule__PartialComparisonExpressionRule__Group__0
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
    // InternalInstanceLanguage.g:454:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:455:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalInstanceLanguage.g:456:1: ruleAddOrSubtractExpressionRule EOF
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
    // InternalInstanceLanguage.g:463:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:467:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:468:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:468:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:469:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:470:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:470:4: rule__AddOrSubtractExpressionRule__Group__0
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
    // InternalInstanceLanguage.g:479:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:480:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalInstanceLanguage.g:481:1: ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalInstanceLanguage.g:488:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:492:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:493:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:493:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:494:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:495:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:495:4: rule__MultiplyDivideModuloExpressionRule__Group__0
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
    // InternalInstanceLanguage.g:504:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:505:1: ( rulePowerOfExpressionRule EOF )
            // InternalInstanceLanguage.g:506:1: rulePowerOfExpressionRule EOF
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
    // InternalInstanceLanguage.g:513:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:517:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:518:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:518:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:519:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:520:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:520:4: rule__PowerOfExpressionRule__Group__0
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
    // InternalInstanceLanguage.g:529:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:530:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalInstanceLanguage.g:531:1: ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalInstanceLanguage.g:538:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:542:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:543:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:543:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalInstanceLanguage.g:544:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:545:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalInstanceLanguage.g:545:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
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
    // InternalInstanceLanguage.g:554:1: entryRuleLiteralOrReferenceRule : ruleLiteralOrReferenceRule EOF ;
    public final void entryRuleLiteralOrReferenceRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:555:1: ( ruleLiteralOrReferenceRule EOF )
            // InternalInstanceLanguage.g:556:1: ruleLiteralOrReferenceRule EOF
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
    // InternalInstanceLanguage.g:563:1: ruleLiteralOrReferenceRule : ( ( rule__LiteralOrReferenceRule__Alternatives ) ) ;
    public final void ruleLiteralOrReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:567:2: ( ( ( rule__LiteralOrReferenceRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:568:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:568:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            // InternalInstanceLanguage.g:569:3: ( rule__LiteralOrReferenceRule__Alternatives )
            {
             before(grammarAccess.getLiteralOrReferenceRuleAccess().getAlternatives()); 
            // InternalInstanceLanguage.g:570:3: ( rule__LiteralOrReferenceRule__Alternatives )
            // InternalInstanceLanguage.g:570:4: rule__LiteralOrReferenceRule__Alternatives
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
    // InternalInstanceLanguage.g:579:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:580:1: ( ruleParanthesesRule EOF )
            // InternalInstanceLanguage.g:581:1: ruleParanthesesRule EOF
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
    // InternalInstanceLanguage.g:588:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:592:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:593:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:593:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalInstanceLanguage.g:594:3: ( rule__ParanthesesRule__Group__0 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:595:3: ( rule__ParanthesesRule__Group__0 )
            // InternalInstanceLanguage.g:595:4: rule__ParanthesesRule__Group__0
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
    // InternalInstanceLanguage.g:604:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:605:1: ( ruleCallRule EOF )
            // InternalInstanceLanguage.g:606:1: ruleCallRule EOF
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
    // InternalInstanceLanguage.g:613:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:617:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:618:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:618:2: ( ( rule__CallRule__Group__0 ) )
            // InternalInstanceLanguage.g:619:3: ( rule__CallRule__Group__0 )
            {
             before(grammarAccess.getCallRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:620:3: ( rule__CallRule__Group__0 )
            // InternalInstanceLanguage.g:620:4: rule__CallRule__Group__0
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


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalInstanceLanguage.g:629:1: entryRuleFunctionNameRule : ruleFunctionNameRule EOF ;
    public final void entryRuleFunctionNameRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:630:1: ( ruleFunctionNameRule EOF )
            // InternalInstanceLanguage.g:631:1: ruleFunctionNameRule EOF
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
    // InternalInstanceLanguage.g:638:1: ruleFunctionNameRule : ( ( rule__FunctionNameRule__Group__0 ) ) ;
    public final void ruleFunctionNameRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:642:2: ( ( ( rule__FunctionNameRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:643:2: ( ( rule__FunctionNameRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:643:2: ( ( rule__FunctionNameRule__Group__0 ) )
            // InternalInstanceLanguage.g:644:3: ( rule__FunctionNameRule__Group__0 )
            {
             before(grammarAccess.getFunctionNameRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:645:3: ( rule__FunctionNameRule__Group__0 )
            // InternalInstanceLanguage.g:645:4: rule__FunctionNameRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FunctionNameRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionNameRuleAccess().getGroup()); 

            }


            }

        }
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
    // InternalInstanceLanguage.g:654:1: entryRuleValueReferenceRule : ruleValueReferenceRule EOF ;
    public final void entryRuleValueReferenceRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:655:1: ( ruleValueReferenceRule EOF )
            // InternalInstanceLanguage.g:656:1: ruleValueReferenceRule EOF
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
    // InternalInstanceLanguage.g:663:1: ruleValueReferenceRule : ( ( rule__ValueReferenceRule__Group__0 ) ) ;
    public final void ruleValueReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:667:2: ( ( ( rule__ValueReferenceRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:668:2: ( ( rule__ValueReferenceRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:668:2: ( ( rule__ValueReferenceRule__Group__0 ) )
            // InternalInstanceLanguage.g:669:3: ( rule__ValueReferenceRule__Group__0 )
            {
             before(grammarAccess.getValueReferenceRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:670:3: ( rule__ValueReferenceRule__Group__0 )
            // InternalInstanceLanguage.g:670:4: rule__ValueReferenceRule__Group__0
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
    // InternalInstanceLanguage.g:679:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:680:1: ( ruleLiteralRule EOF )
            // InternalInstanceLanguage.g:681:1: ruleLiteralRule EOF
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
    // InternalInstanceLanguage.g:688:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:692:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:693:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:693:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalInstanceLanguage.g:694:3: ( rule__LiteralRule__Alternatives )
            {
             before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            // InternalInstanceLanguage.g:695:3: ( rule__LiteralRule__Alternatives )
            // InternalInstanceLanguage.g:695:4: rule__LiteralRule__Alternatives
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
    // InternalInstanceLanguage.g:704:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:705:1: ( ruleNumberLiteralRule EOF )
            // InternalInstanceLanguage.g:706:1: ruleNumberLiteralRule EOF
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
    // InternalInstanceLanguage.g:713:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:717:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:718:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:718:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalInstanceLanguage.g:719:3: ( rule__NumberLiteralRule__Alternatives )
            {
             before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            // InternalInstanceLanguage.g:720:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalInstanceLanguage.g:720:4: rule__NumberLiteralRule__Alternatives
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
    // InternalInstanceLanguage.g:729:1: entryRuleDoubleLiteralRule : ruleDoubleLiteralRule EOF ;
    public final void entryRuleDoubleLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:730:1: ( ruleDoubleLiteralRule EOF )
            // InternalInstanceLanguage.g:731:1: ruleDoubleLiteralRule EOF
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
    // InternalInstanceLanguage.g:738:1: ruleDoubleLiteralRule : ( ( rule__DoubleLiteralRule__ValueAssignment ) ) ;
    public final void ruleDoubleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:742:2: ( ( ( rule__DoubleLiteralRule__ValueAssignment ) ) )
            // InternalInstanceLanguage.g:743:2: ( ( rule__DoubleLiteralRule__ValueAssignment ) )
            {
            // InternalInstanceLanguage.g:743:2: ( ( rule__DoubleLiteralRule__ValueAssignment ) )
            // InternalInstanceLanguage.g:744:3: ( rule__DoubleLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getValueAssignment()); 
            // InternalInstanceLanguage.g:745:3: ( rule__DoubleLiteralRule__ValueAssignment )
            // InternalInstanceLanguage.g:745:4: rule__DoubleLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DoubleLiteralRule__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDoubleLiteralRuleAccess().getValueAssignment()); 

            }


            }

        }
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
    // InternalInstanceLanguage.g:754:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:755:1: ( ruleIntegerLiteralRule EOF )
            // InternalInstanceLanguage.g:756:1: ruleIntegerLiteralRule EOF
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
    // InternalInstanceLanguage.g:763:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__ValueAssignment ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:767:2: ( ( ( rule__IntegerLiteralRule__ValueAssignment ) ) )
            // InternalInstanceLanguage.g:768:2: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            {
            // InternalInstanceLanguage.g:768:2: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            // InternalInstanceLanguage.g:769:3: ( rule__IntegerLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getValueAssignment()); 
            // InternalInstanceLanguage.g:770:3: ( rule__IntegerLiteralRule__ValueAssignment )
            // InternalInstanceLanguage.g:770:4: rule__IntegerLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteralRule__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntegerLiteralRuleAccess().getValueAssignment()); 

            }


            }

        }
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
    // InternalInstanceLanguage.g:779:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:780:1: ( ruleStringLiteralRule EOF )
            // InternalInstanceLanguage.g:781:1: ruleStringLiteralRule EOF
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
    // InternalInstanceLanguage.g:788:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:792:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // InternalInstanceLanguage.g:793:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // InternalInstanceLanguage.g:793:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // InternalInstanceLanguage.g:794:3: ( rule__StringLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            // InternalInstanceLanguage.g:795:3: ( rule__StringLiteralRule__ValueAssignment )
            // InternalInstanceLanguage.g:795:4: rule__StringLiteralRule__ValueAssignment
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
    // InternalInstanceLanguage.g:804:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:805:1: ( ruleBooleanLiteralRule EOF )
            // InternalInstanceLanguage.g:806:1: ruleBooleanLiteralRule EOF
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
    // InternalInstanceLanguage.g:813:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:817:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalInstanceLanguage.g:818:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalInstanceLanguage.g:818:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalInstanceLanguage.g:819:3: ( rule__BooleanLiteralRule__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            // InternalInstanceLanguage.g:820:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalInstanceLanguage.g:820:4: rule__BooleanLiteralRule__Group__0
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


    // $ANTLR start "entryRuleStringOrId"
    // InternalInstanceLanguage.g:829:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:830:1: ( ruleStringOrId EOF )
            // InternalInstanceLanguage.g:831:1: ruleStringOrId EOF
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
    // InternalInstanceLanguage.g:838:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:842:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalInstanceLanguage.g:843:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalInstanceLanguage.g:843:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalInstanceLanguage.g:844:3: ( rule__StringOrId__Alternatives )
            {
             before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            // InternalInstanceLanguage.g:845:3: ( rule__StringOrId__Alternatives )
            // InternalInstanceLanguage.g:845:4: rule__StringOrId__Alternatives
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


    // $ANTLR start "entryRuleDOUBLE"
    // InternalInstanceLanguage.g:854:1: entryRuleDOUBLE : ruleDOUBLE EOF ;
    public final void entryRuleDOUBLE() throws RecognitionException {
        try {
            // InternalInstanceLanguage.g:855:1: ( ruleDOUBLE EOF )
            // InternalInstanceLanguage.g:856:1: ruleDOUBLE EOF
            {
             before(grammarAccess.getDOUBLERule()); 
            pushFollow(FOLLOW_1);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getDOUBLERule()); 
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
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // InternalInstanceLanguage.g:863:1: ruleDOUBLE : ( ( rule__DOUBLE__Group__0 ) ) ;
    public final void ruleDOUBLE() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:867:2: ( ( ( rule__DOUBLE__Group__0 ) ) )
            // InternalInstanceLanguage.g:868:2: ( ( rule__DOUBLE__Group__0 ) )
            {
            // InternalInstanceLanguage.g:868:2: ( ( rule__DOUBLE__Group__0 ) )
            // InternalInstanceLanguage.g:869:3: ( rule__DOUBLE__Group__0 )
            {
             before(grammarAccess.getDOUBLEAccess().getGroup()); 
            // InternalInstanceLanguage.g:870:3: ( rule__DOUBLE__Group__0 )
            // InternalInstanceLanguage.g:870:4: rule__DOUBLE__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDOUBLEAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalInstanceLanguage.g:879:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:883:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:884:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:884:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalInstanceLanguage.g:885:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
             before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            // InternalInstanceLanguage.g:886:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalInstanceLanguage.g:886:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalInstanceLanguage.g:895:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:899:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:900:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:900:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalInstanceLanguage.g:901:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
             before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            // InternalInstanceLanguage.g:902:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalInstanceLanguage.g:902:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalInstanceLanguage.g:911:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:915:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalInstanceLanguage.g:916:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalInstanceLanguage.g:916:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalInstanceLanguage.g:917:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
             before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            // InternalInstanceLanguage.g:918:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalInstanceLanguage.g:918:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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


    // $ANTLR start "rule__NameOrMiscRule__Alternatives"
    // InternalInstanceLanguage.g:926:1: rule__NameOrMiscRule__Alternatives : ( ( ruleNameRule ) | ( ruleMiscRule ) );
    public final void rule__NameOrMiscRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:930:1: ( ( ruleNameRule ) | ( ruleMiscRule ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_QUOTED_ID && LA1_0<=RULE_ID)) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_STRING) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalInstanceLanguage.g:931:2: ( ruleNameRule )
                    {
                    // InternalInstanceLanguage.g:931:2: ( ruleNameRule )
                    // InternalInstanceLanguage.g:932:3: ruleNameRule
                    {
                     before(grammarAccess.getNameOrMiscRuleAccess().getNameRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNameRule();

                    state._fsp--;

                     after(grammarAccess.getNameOrMiscRuleAccess().getNameRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:937:2: ( ruleMiscRule )
                    {
                    // InternalInstanceLanguage.g:937:2: ( ruleMiscRule )
                    // InternalInstanceLanguage.g:938:3: ruleMiscRule
                    {
                     before(grammarAccess.getNameOrMiscRuleAccess().getMiscRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleMiscRule();

                    state._fsp--;

                     after(grammarAccess.getNameOrMiscRuleAccess().getMiscRuleParserRuleCall_1()); 

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
    // $ANTLR end "rule__NameOrMiscRule__Alternatives"


    // $ANTLR start "rule__ValueRule__Alternatives"
    // InternalInstanceLanguage.g:947:1: rule__ValueRule__Alternatives : ( ( ruleArrayRule ) | ( ruleDataReferenceRule ) | ( ruleInstanceRule ) | ( ruleLiteralValueRule ) );
    public final void rule__ValueRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:951:1: ( ( ruleArrayRule ) | ( ruleDataReferenceRule ) | ( ruleInstanceRule ) | ( ruleLiteralValueRule ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt2=1;
                }
                break;
            case 31:
                {
                alt2=2;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt2=3;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 12:
            case 42:
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
                    // InternalInstanceLanguage.g:952:2: ( ruleArrayRule )
                    {
                    // InternalInstanceLanguage.g:952:2: ( ruleArrayRule )
                    // InternalInstanceLanguage.g:953:3: ruleArrayRule
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
                    // InternalInstanceLanguage.g:958:2: ( ruleDataReferenceRule )
                    {
                    // InternalInstanceLanguage.g:958:2: ( ruleDataReferenceRule )
                    // InternalInstanceLanguage.g:959:3: ruleDataReferenceRule
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
                    // InternalInstanceLanguage.g:964:2: ( ruleInstanceRule )
                    {
                    // InternalInstanceLanguage.g:964:2: ( ruleInstanceRule )
                    // InternalInstanceLanguage.g:965:3: ruleInstanceRule
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
                    // InternalInstanceLanguage.g:970:2: ( ruleLiteralValueRule )
                    {
                    // InternalInstanceLanguage.g:970:2: ( ruleLiteralValueRule )
                    // InternalInstanceLanguage.g:971:3: ruleLiteralValueRule
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
    // InternalInstanceLanguage.g:980:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );
    public final void rule__LiteralOrReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:984:1: ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt3=1;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 12:
            case 42:
                {
                alt3=2;
                }
                break;
            case 36:
                {
                alt3=3;
                }
                break;
            case 39:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalInstanceLanguage.g:985:2: ( ruleCallRule )
                    {
                    // InternalInstanceLanguage.g:985:2: ( ruleCallRule )
                    // InternalInstanceLanguage.g:986:3: ruleCallRule
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
                    // InternalInstanceLanguage.g:991:2: ( ruleLiteralRule )
                    {
                    // InternalInstanceLanguage.g:991:2: ( ruleLiteralRule )
                    // InternalInstanceLanguage.g:992:3: ruleLiteralRule
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
                    // InternalInstanceLanguage.g:997:2: ( ruleParanthesesRule )
                    {
                    // InternalInstanceLanguage.g:997:2: ( ruleParanthesesRule )
                    // InternalInstanceLanguage.g:998:3: ruleParanthesesRule
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
                    // InternalInstanceLanguage.g:1003:2: ( ruleValueReferenceRule )
                    {
                    // InternalInstanceLanguage.g:1003:2: ( ruleValueReferenceRule )
                    // InternalInstanceLanguage.g:1004:3: ruleValueReferenceRule
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
    // InternalInstanceLanguage.g:1013:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1017:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) )
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
            case 42:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalInstanceLanguage.g:1018:2: ( ruleNumberLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1018:2: ( ruleNumberLiteralRule )
                    // InternalInstanceLanguage.g:1019:3: ruleNumberLiteralRule
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
                    // InternalInstanceLanguage.g:1024:2: ( ruleStringLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1024:2: ( ruleStringLiteralRule )
                    // InternalInstanceLanguage.g:1025:3: ruleStringLiteralRule
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
                    // InternalInstanceLanguage.g:1030:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1030:2: ( ruleBooleanLiteralRule )
                    // InternalInstanceLanguage.g:1031:3: ruleBooleanLiteralRule
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
    // InternalInstanceLanguage.g:1040:1: rule__NumberLiteralRule__Alternatives : ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1044:1: ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==EOF||(LA5_1>=13 && LA5_1<=23)||LA5_1==27||(LA5_1>=29 && LA5_1<=30)||(LA5_1>=32 && LA5_1<=35)||LA5_1==37) ) {
                    alt5=2;
                }
                else if ( (LA5_1==40) ) {
                    alt5=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalInstanceLanguage.g:1045:2: ( ruleDoubleLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1045:2: ( ruleDoubleLiteralRule )
                    // InternalInstanceLanguage.g:1046:3: ruleDoubleLiteralRule
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
                    // InternalInstanceLanguage.g:1051:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalInstanceLanguage.g:1051:2: ( ruleIntegerLiteralRule )
                    // InternalInstanceLanguage.g:1052:3: ruleIntegerLiteralRule
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
    // InternalInstanceLanguage.g:1061:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1065:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==42) ) {
                alt6=1;
            }
            else if ( (LA6_0==12) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalInstanceLanguage.g:1066:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalInstanceLanguage.g:1066:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalInstanceLanguage.g:1067:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                     before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    // InternalInstanceLanguage.g:1068:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalInstanceLanguage.g:1068:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalInstanceLanguage.g:1072:2: ( 'false' )
                    {
                    // InternalInstanceLanguage.g:1072:2: ( 'false' )
                    // InternalInstanceLanguage.g:1073:3: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralRuleAccess().getFalseKeyword_1_1()); 
                    match(input,12,FOLLOW_2); 
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


    // $ANTLR start "rule__StringOrId__Alternatives"
    // InternalInstanceLanguage.g:1082:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1086:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
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
                    // InternalInstanceLanguage.g:1087:2: ( RULE_QUOTED_ID )
                    {
                    // InternalInstanceLanguage.g:1087:2: ( RULE_QUOTED_ID )
                    // InternalInstanceLanguage.g:1088:3: RULE_QUOTED_ID
                    {
                     before(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 
                    match(input,RULE_QUOTED_ID,FOLLOW_2); 
                     after(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1093:2: ( RULE_ID )
                    {
                    // InternalInstanceLanguage.g:1093:2: ( RULE_ID )
                    // InternalInstanceLanguage.g:1094:3: RULE_ID
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
    // InternalInstanceLanguage.g:1103:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1107:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt8=6;
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
            case 17:
                {
                alt8=5;
                }
                break;
            case 18:
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
                    // InternalInstanceLanguage.g:1108:2: ( ( '>=' ) )
                    {
                    // InternalInstanceLanguage.g:1108:2: ( ( '>=' ) )
                    // InternalInstanceLanguage.g:1109:3: ( '>=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    // InternalInstanceLanguage.g:1110:3: ( '>=' )
                    // InternalInstanceLanguage.g:1110:4: '>='
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1114:2: ( ( '>' ) )
                    {
                    // InternalInstanceLanguage.g:1114:2: ( ( '>' ) )
                    // InternalInstanceLanguage.g:1115:3: ( '>' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    // InternalInstanceLanguage.g:1116:3: ( '>' )
                    // InternalInstanceLanguage.g:1116:4: '>'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:1120:2: ( ( '=' ) )
                    {
                    // InternalInstanceLanguage.g:1120:2: ( ( '=' ) )
                    // InternalInstanceLanguage.g:1121:3: ( '=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    // InternalInstanceLanguage.g:1122:3: ( '=' )
                    // InternalInstanceLanguage.g:1122:4: '='
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:1126:2: ( ( '!=' ) )
                    {
                    // InternalInstanceLanguage.g:1126:2: ( ( '!=' ) )
                    // InternalInstanceLanguage.g:1127:3: ( '!=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    // InternalInstanceLanguage.g:1128:3: ( '!=' )
                    // InternalInstanceLanguage.g:1128:4: '!='
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalInstanceLanguage.g:1132:2: ( ( '<' ) )
                    {
                    // InternalInstanceLanguage.g:1132:2: ( ( '<' ) )
                    // InternalInstanceLanguage.g:1133:3: ( '<' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    // InternalInstanceLanguage.g:1134:3: ( '<' )
                    // InternalInstanceLanguage.g:1134:4: '<'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalInstanceLanguage.g:1138:2: ( ( '<=' ) )
                    {
                    // InternalInstanceLanguage.g:1138:2: ( ( '<=' ) )
                    // InternalInstanceLanguage.g:1139:3: ( '<=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    // InternalInstanceLanguage.g:1140:3: ( '<=' )
                    // InternalInstanceLanguage.g:1140:4: '<='
                    {
                    match(input,18,FOLLOW_2); 

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
    // InternalInstanceLanguage.g:1148:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1152:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            else if ( (LA9_0==20) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalInstanceLanguage.g:1153:2: ( ( '+' ) )
                    {
                    // InternalInstanceLanguage.g:1153:2: ( ( '+' ) )
                    // InternalInstanceLanguage.g:1154:3: ( '+' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    // InternalInstanceLanguage.g:1155:3: ( '+' )
                    // InternalInstanceLanguage.g:1155:4: '+'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1159:2: ( ( '-' ) )
                    {
                    // InternalInstanceLanguage.g:1159:2: ( ( '-' ) )
                    // InternalInstanceLanguage.g:1160:3: ( '-' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    // InternalInstanceLanguage.g:1161:3: ( '-' )
                    // InternalInstanceLanguage.g:1161:4: '-'
                    {
                    match(input,20,FOLLOW_2); 

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
    // InternalInstanceLanguage.g:1169:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1173:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt10=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalInstanceLanguage.g:1174:2: ( ( '*' ) )
                    {
                    // InternalInstanceLanguage.g:1174:2: ( ( '*' ) )
                    // InternalInstanceLanguage.g:1175:3: ( '*' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    // InternalInstanceLanguage.g:1176:3: ( '*' )
                    // InternalInstanceLanguage.g:1176:4: '*'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1180:2: ( ( '/' ) )
                    {
                    // InternalInstanceLanguage.g:1180:2: ( ( '/' ) )
                    // InternalInstanceLanguage.g:1181:3: ( '/' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    // InternalInstanceLanguage.g:1182:3: ( '/' )
                    // InternalInstanceLanguage.g:1182:4: '/'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:1186:2: ( ( '%' ) )
                    {
                    // InternalInstanceLanguage.g:1186:2: ( ( '%' ) )
                    // InternalInstanceLanguage.g:1187:3: ( '%' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    // InternalInstanceLanguage.g:1188:3: ( '%' )
                    // InternalInstanceLanguage.g:1188:4: '%'
                    {
                    match(input,23,FOLLOW_2); 

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


    // $ANTLR start "rule__InstanceRule__Group__0"
    // InternalInstanceLanguage.g:1196:1: rule__InstanceRule__Group__0 : rule__InstanceRule__Group__0__Impl rule__InstanceRule__Group__1 ;
    public final void rule__InstanceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1200:1: ( rule__InstanceRule__Group__0__Impl rule__InstanceRule__Group__1 )
            // InternalInstanceLanguage.g:1201:2: rule__InstanceRule__Group__0__Impl rule__InstanceRule__Group__1
            {
            pushFollow(FOLLOW_3);
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
    // InternalInstanceLanguage.g:1208:1: rule__InstanceRule__Group__0__Impl : ( ( rule__InstanceRule__NameAssignment_0 ) ) ;
    public final void rule__InstanceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1212:1: ( ( ( rule__InstanceRule__NameAssignment_0 ) ) )
            // InternalInstanceLanguage.g:1213:1: ( ( rule__InstanceRule__NameAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:1213:1: ( ( rule__InstanceRule__NameAssignment_0 ) )
            // InternalInstanceLanguage.g:1214:2: ( rule__InstanceRule__NameAssignment_0 )
            {
             before(grammarAccess.getInstanceRuleAccess().getNameAssignment_0()); 
            // InternalInstanceLanguage.g:1215:2: ( rule__InstanceRule__NameAssignment_0 )
            // InternalInstanceLanguage.g:1215:3: rule__InstanceRule__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__InstanceRule__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceRuleAccess().getNameAssignment_0()); 

            }


            }

        }
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
    // InternalInstanceLanguage.g:1223:1: rule__InstanceRule__Group__1 : rule__InstanceRule__Group__1__Impl ;
    public final void rule__InstanceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1227:1: ( rule__InstanceRule__Group__1__Impl )
            // InternalInstanceLanguage.g:1228:2: rule__InstanceRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:1234:1: rule__InstanceRule__Group__1__Impl : ( ( rule__InstanceRule__Group_1__0 )? ) ;
    public final void rule__InstanceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1238:1: ( ( ( rule__InstanceRule__Group_1__0 )? ) )
            // InternalInstanceLanguage.g:1239:1: ( ( rule__InstanceRule__Group_1__0 )? )
            {
            // InternalInstanceLanguage.g:1239:1: ( ( rule__InstanceRule__Group_1__0 )? )
            // InternalInstanceLanguage.g:1240:2: ( rule__InstanceRule__Group_1__0 )?
            {
             before(grammarAccess.getInstanceRuleAccess().getGroup_1()); 
            // InternalInstanceLanguage.g:1241:2: ( rule__InstanceRule__Group_1__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalInstanceLanguage.g:1241:3: rule__InstanceRule__Group_1__0
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
    // InternalInstanceLanguage.g:1250:1: rule__InstanceRule__Group_1__0 : rule__InstanceRule__Group_1__0__Impl rule__InstanceRule__Group_1__1 ;
    public final void rule__InstanceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1254:1: ( rule__InstanceRule__Group_1__0__Impl rule__InstanceRule__Group_1__1 )
            // InternalInstanceLanguage.g:1255:2: rule__InstanceRule__Group_1__0__Impl rule__InstanceRule__Group_1__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalInstanceLanguage.g:1262:1: rule__InstanceRule__Group_1__0__Impl : ( '{' ) ;
    public final void rule__InstanceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1266:1: ( ( '{' ) )
            // InternalInstanceLanguage.g:1267:1: ( '{' )
            {
            // InternalInstanceLanguage.g:1267:1: ( '{' )
            // InternalInstanceLanguage.g:1268:2: '{'
            {
             before(grammarAccess.getInstanceRuleAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:1277:1: rule__InstanceRule__Group_1__1 : rule__InstanceRule__Group_1__1__Impl rule__InstanceRule__Group_1__2 ;
    public final void rule__InstanceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1281:1: ( rule__InstanceRule__Group_1__1__Impl rule__InstanceRule__Group_1__2 )
            // InternalInstanceLanguage.g:1282:2: rule__InstanceRule__Group_1__1__Impl rule__InstanceRule__Group_1__2
            {
            pushFollow(FOLLOW_4);
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
    // InternalInstanceLanguage.g:1289:1: rule__InstanceRule__Group_1__1__Impl : ( ( rule__InstanceRule__AttributesAssignment_1_1 )* ) ;
    public final void rule__InstanceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1293:1: ( ( ( rule__InstanceRule__AttributesAssignment_1_1 )* ) )
            // InternalInstanceLanguage.g:1294:1: ( ( rule__InstanceRule__AttributesAssignment_1_1 )* )
            {
            // InternalInstanceLanguage.g:1294:1: ( ( rule__InstanceRule__AttributesAssignment_1_1 )* )
            // InternalInstanceLanguage.g:1295:2: ( rule__InstanceRule__AttributesAssignment_1_1 )*
            {
             before(grammarAccess.getInstanceRuleAccess().getAttributesAssignment_1_1()); 
            // InternalInstanceLanguage.g:1296:2: ( rule__InstanceRule__AttributesAssignment_1_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_QUOTED_ID && LA12_0<=RULE_ID)||LA12_0==RULE_STRING) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalInstanceLanguage.g:1296:3: rule__InstanceRule__AttributesAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__InstanceRule__AttributesAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // InternalInstanceLanguage.g:1304:1: rule__InstanceRule__Group_1__2 : rule__InstanceRule__Group_1__2__Impl ;
    public final void rule__InstanceRule__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1308:1: ( rule__InstanceRule__Group_1__2__Impl )
            // InternalInstanceLanguage.g:1309:2: rule__InstanceRule__Group_1__2__Impl
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
    // InternalInstanceLanguage.g:1315:1: rule__InstanceRule__Group_1__2__Impl : ( '}' ) ;
    public final void rule__InstanceRule__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1319:1: ( ( '}' ) )
            // InternalInstanceLanguage.g:1320:1: ( '}' )
            {
            // InternalInstanceLanguage.g:1320:1: ( '}' )
            // InternalInstanceLanguage.g:1321:2: '}'
            {
             before(grammarAccess.getInstanceRuleAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,25,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:1331:1: rule__AttributeRule__Group__0 : rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 ;
    public final void rule__AttributeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1335:1: ( rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1 )
            // InternalInstanceLanguage.g:1336:2: rule__AttributeRule__Group__0__Impl rule__AttributeRule__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalInstanceLanguage.g:1343:1: rule__AttributeRule__Group__0__Impl : ( ( rule__AttributeRule__NameAssignment_0 ) ) ;
    public final void rule__AttributeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1347:1: ( ( ( rule__AttributeRule__NameAssignment_0 ) ) )
            // InternalInstanceLanguage.g:1348:1: ( ( rule__AttributeRule__NameAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:1348:1: ( ( rule__AttributeRule__NameAssignment_0 ) )
            // InternalInstanceLanguage.g:1349:2: ( rule__AttributeRule__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeRuleAccess().getNameAssignment_0()); 
            // InternalInstanceLanguage.g:1350:2: ( rule__AttributeRule__NameAssignment_0 )
            // InternalInstanceLanguage.g:1350:3: rule__AttributeRule__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeRule__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeRuleAccess().getNameAssignment_0()); 

            }


            }

        }
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
    // InternalInstanceLanguage.g:1358:1: rule__AttributeRule__Group__1 : rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 ;
    public final void rule__AttributeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1362:1: ( rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2 )
            // InternalInstanceLanguage.g:1363:2: rule__AttributeRule__Group__1__Impl rule__AttributeRule__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalInstanceLanguage.g:1370:1: rule__AttributeRule__Group__1__Impl : ( ':=' ) ;
    public final void rule__AttributeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1374:1: ( ( ':=' ) )
            // InternalInstanceLanguage.g:1375:1: ( ':=' )
            {
            // InternalInstanceLanguage.g:1375:1: ( ':=' )
            // InternalInstanceLanguage.g:1376:2: ':='
            {
             before(grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:1385:1: rule__AttributeRule__Group__2 : rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 ;
    public final void rule__AttributeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1389:1: ( rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3 )
            // InternalInstanceLanguage.g:1390:2: rule__AttributeRule__Group__2__Impl rule__AttributeRule__Group__3
            {
            pushFollow(FOLLOW_8);
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
    // InternalInstanceLanguage.g:1397:1: rule__AttributeRule__Group__2__Impl : ( ( rule__AttributeRule__ValueAssignment_2 ) ) ;
    public final void rule__AttributeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1401:1: ( ( ( rule__AttributeRule__ValueAssignment_2 ) ) )
            // InternalInstanceLanguage.g:1402:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            {
            // InternalInstanceLanguage.g:1402:1: ( ( rule__AttributeRule__ValueAssignment_2 ) )
            // InternalInstanceLanguage.g:1403:2: ( rule__AttributeRule__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeRuleAccess().getValueAssignment_2()); 
            // InternalInstanceLanguage.g:1404:2: ( rule__AttributeRule__ValueAssignment_2 )
            // InternalInstanceLanguage.g:1404:3: rule__AttributeRule__ValueAssignment_2
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
    // InternalInstanceLanguage.g:1412:1: rule__AttributeRule__Group__3 : rule__AttributeRule__Group__3__Impl ;
    public final void rule__AttributeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1416:1: ( rule__AttributeRule__Group__3__Impl )
            // InternalInstanceLanguage.g:1417:2: rule__AttributeRule__Group__3__Impl
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
    // InternalInstanceLanguage.g:1423:1: rule__AttributeRule__Group__3__Impl : ( ';' ) ;
    public final void rule__AttributeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1427:1: ( ( ';' ) )
            // InternalInstanceLanguage.g:1428:1: ( ';' )
            {
            // InternalInstanceLanguage.g:1428:1: ( ';' )
            // InternalInstanceLanguage.g:1429:2: ';'
            {
             before(grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3()); 
            match(input,27,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:1439:1: rule__ArrayRule__Group__0 : rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 ;
    public final void rule__ArrayRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1443:1: ( rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1 )
            // InternalInstanceLanguage.g:1444:2: rule__ArrayRule__Group__0__Impl rule__ArrayRule__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalInstanceLanguage.g:1451:1: rule__ArrayRule__Group__0__Impl : ( () ) ;
    public final void rule__ArrayRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1455:1: ( ( () ) )
            // InternalInstanceLanguage.g:1456:1: ( () )
            {
            // InternalInstanceLanguage.g:1456:1: ( () )
            // InternalInstanceLanguage.g:1457:2: ()
            {
             before(grammarAccess.getArrayRuleAccess().getArrayAction_0()); 
            // InternalInstanceLanguage.g:1458:2: ()
            // InternalInstanceLanguage.g:1458:3: 
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
    // InternalInstanceLanguage.g:1466:1: rule__ArrayRule__Group__1 : rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 ;
    public final void rule__ArrayRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1470:1: ( rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2 )
            // InternalInstanceLanguage.g:1471:2: rule__ArrayRule__Group__1__Impl rule__ArrayRule__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalInstanceLanguage.g:1478:1: rule__ArrayRule__Group__1__Impl : ( '[' ) ;
    public final void rule__ArrayRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1482:1: ( ( '[' ) )
            // InternalInstanceLanguage.g:1483:1: ( '[' )
            {
            // InternalInstanceLanguage.g:1483:1: ( '[' )
            // InternalInstanceLanguage.g:1484:2: '['
            {
             before(grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1()); 
            match(input,28,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:1493:1: rule__ArrayRule__Group__2 : rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 ;
    public final void rule__ArrayRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1497:1: ( rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3 )
            // InternalInstanceLanguage.g:1498:2: rule__ArrayRule__Group__2__Impl rule__ArrayRule__Group__3
            {
            pushFollow(FOLLOW_10);
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
    // InternalInstanceLanguage.g:1505:1: rule__ArrayRule__Group__2__Impl : ( ( rule__ArrayRule__Group_2__0 )? ) ;
    public final void rule__ArrayRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1509:1: ( ( ( rule__ArrayRule__Group_2__0 )? ) )
            // InternalInstanceLanguage.g:1510:1: ( ( rule__ArrayRule__Group_2__0 )? )
            {
            // InternalInstanceLanguage.g:1510:1: ( ( rule__ArrayRule__Group_2__0 )? )
            // InternalInstanceLanguage.g:1511:2: ( rule__ArrayRule__Group_2__0 )?
            {
             before(grammarAccess.getArrayRuleAccess().getGroup_2()); 
            // InternalInstanceLanguage.g:1512:2: ( rule__ArrayRule__Group_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_QUOTED_ID && LA13_0<=RULE_STRING)||LA13_0==12||LA13_0==28||LA13_0==31||LA13_0==42) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalInstanceLanguage.g:1512:3: rule__ArrayRule__Group_2__0
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
    // InternalInstanceLanguage.g:1520:1: rule__ArrayRule__Group__3 : rule__ArrayRule__Group__3__Impl ;
    public final void rule__ArrayRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1524:1: ( rule__ArrayRule__Group__3__Impl )
            // InternalInstanceLanguage.g:1525:2: rule__ArrayRule__Group__3__Impl
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
    // InternalInstanceLanguage.g:1531:1: rule__ArrayRule__Group__3__Impl : ( ']' ) ;
    public final void rule__ArrayRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1535:1: ( ( ']' ) )
            // InternalInstanceLanguage.g:1536:1: ( ']' )
            {
            // InternalInstanceLanguage.g:1536:1: ( ']' )
            // InternalInstanceLanguage.g:1537:2: ']'
            {
             before(grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:1547:1: rule__ArrayRule__Group_2__0 : rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 ;
    public final void rule__ArrayRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1551:1: ( rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1 )
            // InternalInstanceLanguage.g:1552:2: rule__ArrayRule__Group_2__0__Impl rule__ArrayRule__Group_2__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalInstanceLanguage.g:1559:1: rule__ArrayRule__Group_2__0__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) ;
    public final void rule__ArrayRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1563:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_0 ) ) )
            // InternalInstanceLanguage.g:1564:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            {
            // InternalInstanceLanguage.g:1564:1: ( ( rule__ArrayRule__ValuesAssignment_2_0 ) )
            // InternalInstanceLanguage.g:1565:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            {
             before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_0()); 
            // InternalInstanceLanguage.g:1566:2: ( rule__ArrayRule__ValuesAssignment_2_0 )
            // InternalInstanceLanguage.g:1566:3: rule__ArrayRule__ValuesAssignment_2_0
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
    // InternalInstanceLanguage.g:1574:1: rule__ArrayRule__Group_2__1 : rule__ArrayRule__Group_2__1__Impl ;
    public final void rule__ArrayRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1578:1: ( rule__ArrayRule__Group_2__1__Impl )
            // InternalInstanceLanguage.g:1579:2: rule__ArrayRule__Group_2__1__Impl
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
    // InternalInstanceLanguage.g:1585:1: rule__ArrayRule__Group_2__1__Impl : ( ( rule__ArrayRule__Group_2_1__0 )* ) ;
    public final void rule__ArrayRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1589:1: ( ( ( rule__ArrayRule__Group_2_1__0 )* ) )
            // InternalInstanceLanguage.g:1590:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            {
            // InternalInstanceLanguage.g:1590:1: ( ( rule__ArrayRule__Group_2_1__0 )* )
            // InternalInstanceLanguage.g:1591:2: ( rule__ArrayRule__Group_2_1__0 )*
            {
             before(grammarAccess.getArrayRuleAccess().getGroup_2_1()); 
            // InternalInstanceLanguage.g:1592:2: ( rule__ArrayRule__Group_2_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==30) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalInstanceLanguage.g:1592:3: rule__ArrayRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__ArrayRule__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalInstanceLanguage.g:1601:1: rule__ArrayRule__Group_2_1__0 : rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 ;
    public final void rule__ArrayRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1605:1: ( rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1 )
            // InternalInstanceLanguage.g:1606:2: rule__ArrayRule__Group_2_1__0__Impl rule__ArrayRule__Group_2_1__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalInstanceLanguage.g:1613:1: rule__ArrayRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ArrayRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1617:1: ( ( ',' ) )
            // InternalInstanceLanguage.g:1618:1: ( ',' )
            {
            // InternalInstanceLanguage.g:1618:1: ( ',' )
            // InternalInstanceLanguage.g:1619:2: ','
            {
             before(grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:1628:1: rule__ArrayRule__Group_2_1__1 : rule__ArrayRule__Group_2_1__1__Impl ;
    public final void rule__ArrayRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1632:1: ( rule__ArrayRule__Group_2_1__1__Impl )
            // InternalInstanceLanguage.g:1633:2: rule__ArrayRule__Group_2_1__1__Impl
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
    // InternalInstanceLanguage.g:1639:1: rule__ArrayRule__Group_2_1__1__Impl : ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__ArrayRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1643:1: ( ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) ) )
            // InternalInstanceLanguage.g:1644:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            {
            // InternalInstanceLanguage.g:1644:1: ( ( rule__ArrayRule__ValuesAssignment_2_1_1 ) )
            // InternalInstanceLanguage.g:1645:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            {
             before(grammarAccess.getArrayRuleAccess().getValuesAssignment_2_1_1()); 
            // InternalInstanceLanguage.g:1646:2: ( rule__ArrayRule__ValuesAssignment_2_1_1 )
            // InternalInstanceLanguage.g:1646:3: rule__ArrayRule__ValuesAssignment_2_1_1
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
    // InternalInstanceLanguage.g:1655:1: rule__DataReferenceRule__Group__0 : rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1 ;
    public final void rule__DataReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1659:1: ( rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1 )
            // InternalInstanceLanguage.g:1660:2: rule__DataReferenceRule__Group__0__Impl rule__DataReferenceRule__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalInstanceLanguage.g:1667:1: rule__DataReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__DataReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1671:1: ( ( () ) )
            // InternalInstanceLanguage.g:1672:1: ( () )
            {
            // InternalInstanceLanguage.g:1672:1: ( () )
            // InternalInstanceLanguage.g:1673:2: ()
            {
             before(grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0()); 
            // InternalInstanceLanguage.g:1674:2: ()
            // InternalInstanceLanguage.g:1674:3: 
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
    // InternalInstanceLanguage.g:1682:1: rule__DataReferenceRule__Group__1 : rule__DataReferenceRule__Group__1__Impl rule__DataReferenceRule__Group__2 ;
    public final void rule__DataReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1686:1: ( rule__DataReferenceRule__Group__1__Impl rule__DataReferenceRule__Group__2 )
            // InternalInstanceLanguage.g:1687:2: rule__DataReferenceRule__Group__1__Impl rule__DataReferenceRule__Group__2
            {
            pushFollow(FOLLOW_14);
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
    // InternalInstanceLanguage.g:1694:1: rule__DataReferenceRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1698:1: ( ( 'data' ) )
            // InternalInstanceLanguage.g:1699:1: ( 'data' )
            {
            // InternalInstanceLanguage.g:1699:1: ( 'data' )
            // InternalInstanceLanguage.g:1700:2: 'data'
            {
             before(grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1()); 
            match(input,31,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:1709:1: rule__DataReferenceRule__Group__2 : rule__DataReferenceRule__Group__2__Impl ;
    public final void rule__DataReferenceRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1713:1: ( rule__DataReferenceRule__Group__2__Impl )
            // InternalInstanceLanguage.g:1714:2: rule__DataReferenceRule__Group__2__Impl
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
    // InternalInstanceLanguage.g:1720:1: rule__DataReferenceRule__Group__2__Impl : ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) ) ;
    public final void rule__DataReferenceRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1724:1: ( ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) ) )
            // InternalInstanceLanguage.g:1725:1: ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) )
            {
            // InternalInstanceLanguage.g:1725:1: ( ( rule__DataReferenceRule__DefinitionAssignment_2 ) )
            // InternalInstanceLanguage.g:1726:2: ( rule__DataReferenceRule__DefinitionAssignment_2 )
            {
             before(grammarAccess.getDataReferenceRuleAccess().getDefinitionAssignment_2()); 
            // InternalInstanceLanguage.g:1727:2: ( rule__DataReferenceRule__DefinitionAssignment_2 )
            // InternalInstanceLanguage.g:1727:3: rule__DataReferenceRule__DefinitionAssignment_2
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


    // $ANTLR start "rule__OrExpressionRule__Group__0"
    // InternalInstanceLanguage.g:1736:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1740:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:1741:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalInstanceLanguage.g:1748:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1752:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalInstanceLanguage.g:1753:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:1753:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalInstanceLanguage.g:1754:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalInstanceLanguage.g:1755:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalInstanceLanguage.g:1755:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalInstanceLanguage.g:1763:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1767:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:1768:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:1774:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1778:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:1779:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:1779:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalInstanceLanguage.g:1780:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            // InternalInstanceLanguage.g:1781:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==32) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalInstanceLanguage.g:1781:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalInstanceLanguage.g:1790:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1794:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:1795:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:1802:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1806:1: ( ( 'OR' ) )
            // InternalInstanceLanguage.g:1807:1: ( 'OR' )
            {
            // InternalInstanceLanguage.g:1807:1: ( 'OR' )
            // InternalInstanceLanguage.g:1808:2: 'OR'
            {
             before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:1817:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1821:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:1822:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalInstanceLanguage.g:1828:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1832:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:1833:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:1833:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalInstanceLanguage.g:1834:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalInstanceLanguage.g:1835:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalInstanceLanguage.g:1835:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalInstanceLanguage.g:1844:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1848:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:1849:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalInstanceLanguage.g:1856:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1860:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalInstanceLanguage.g:1861:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:1861:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalInstanceLanguage.g:1862:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalInstanceLanguage.g:1863:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalInstanceLanguage.g:1863:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalInstanceLanguage.g:1871:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1875:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:1876:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:1882:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1886:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:1887:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:1887:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalInstanceLanguage.g:1888:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            // InternalInstanceLanguage.g:1889:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==33) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalInstanceLanguage.g:1889:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalInstanceLanguage.g:1898:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1902:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:1903:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:1910:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1914:1: ( ( 'XOR' ) )
            // InternalInstanceLanguage.g:1915:1: ( 'XOR' )
            {
            // InternalInstanceLanguage.g:1915:1: ( 'XOR' )
            // InternalInstanceLanguage.g:1916:2: 'XOR'
            {
             before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:1925:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1929:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:1930:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalInstanceLanguage.g:1936:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1940:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:1941:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:1941:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalInstanceLanguage.g:1942:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalInstanceLanguage.g:1943:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalInstanceLanguage.g:1943:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalInstanceLanguage.g:1952:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1956:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:1957:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalInstanceLanguage.g:1964:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1968:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalInstanceLanguage.g:1969:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:1969:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalInstanceLanguage.g:1970:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalInstanceLanguage.g:1971:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalInstanceLanguage.g:1971:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalInstanceLanguage.g:1979:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1983:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:1984:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:1990:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:1994:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:1995:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:1995:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalInstanceLanguage.g:1996:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            // InternalInstanceLanguage.g:1997:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==34) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalInstanceLanguage.g:1997:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalInstanceLanguage.g:2006:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2010:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:2011:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:2018:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2022:1: ( ( 'AND' ) )
            // InternalInstanceLanguage.g:2023:1: ( 'AND' )
            {
            // InternalInstanceLanguage.g:2023:1: ( 'AND' )
            // InternalInstanceLanguage.g:2024:2: 'AND'
            {
             before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:2033:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2037:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:2038:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalInstanceLanguage.g:2044:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2048:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:2049:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:2049:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalInstanceLanguage.g:2050:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalInstanceLanguage.g:2051:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalInstanceLanguage.g:2051:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalInstanceLanguage.g:2060:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2064:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2065:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:2072:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2076:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalInstanceLanguage.g:2077:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalInstanceLanguage.g:2077:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalInstanceLanguage.g:2078:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            // InternalInstanceLanguage.g:2079:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==41) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalInstanceLanguage.g:2079:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalInstanceLanguage.g:2087:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2091:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2092:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:2098:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2102:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalInstanceLanguage.g:2103:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:2103:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalInstanceLanguage.g:2104:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            // InternalInstanceLanguage.g:2105:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalInstanceLanguage.g:2105:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalInstanceLanguage.g:2114:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2118:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2119:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalInstanceLanguage.g:2126:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2130:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2131:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2131:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalInstanceLanguage.g:2132:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalInstanceLanguage.g:2133:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalInstanceLanguage.g:2133:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalInstanceLanguage.g:2141:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2145:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2146:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:2152:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2156:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalInstanceLanguage.g:2157:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalInstanceLanguage.g:2157:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalInstanceLanguage.g:2158:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            // InternalInstanceLanguage.g:2159:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=13 && LA19_0<=18)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2159:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalInstanceLanguage.g:2168:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2172:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2173:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:2180:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2184:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2185:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2185:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalInstanceLanguage.g:2186:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            // InternalInstanceLanguage.g:2187:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalInstanceLanguage.g:2187:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalInstanceLanguage.g:2195:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2199:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2200:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:2206:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2210:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalInstanceLanguage.g:2211:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:2211:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalInstanceLanguage.g:2212:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalInstanceLanguage.g:2213:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalInstanceLanguage.g:2213:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalInstanceLanguage.g:2222:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2226:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2227:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalInstanceLanguage.g:2234:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2238:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2239:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2239:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalInstanceLanguage.g:2240:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalInstanceLanguage.g:2241:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalInstanceLanguage.g:2241:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalInstanceLanguage.g:2249:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2253:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2254:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:2260:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2264:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:2265:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:2265:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalInstanceLanguage.g:2266:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            // InternalInstanceLanguage.g:2267:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=19 && LA20_0<=20)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2267:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalInstanceLanguage.g:2276:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2280:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:2281:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:2288:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2292:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalInstanceLanguage.g:2293:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalInstanceLanguage.g:2293:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalInstanceLanguage.g:2294:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalInstanceLanguage.g:2295:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalInstanceLanguage.g:2295:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalInstanceLanguage.g:2303:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2307:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:2308:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalInstanceLanguage.g:2314:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2318:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:2319:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:2319:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalInstanceLanguage.g:2320:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalInstanceLanguage.g:2321:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalInstanceLanguage.g:2321:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalInstanceLanguage.g:2330:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2334:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2335:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalInstanceLanguage.g:2342:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2346:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2347:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2347:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalInstanceLanguage.g:2348:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalInstanceLanguage.g:2349:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalInstanceLanguage.g:2349:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalInstanceLanguage.g:2357:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2361:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2362:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:2368:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2372:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalInstanceLanguage.g:2373:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalInstanceLanguage.g:2373:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalInstanceLanguage.g:2374:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            // InternalInstanceLanguage.g:2375:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=21 && LA21_0<=23)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2375:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalInstanceLanguage.g:2384:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2388:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:2389:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:2396:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2400:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalInstanceLanguage.g:2401:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalInstanceLanguage.g:2401:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalInstanceLanguage.g:2402:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalInstanceLanguage.g:2403:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalInstanceLanguage.g:2403:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalInstanceLanguage.g:2411:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2415:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:2416:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalInstanceLanguage.g:2422:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2426:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:2427:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:2427:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalInstanceLanguage.g:2428:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalInstanceLanguage.g:2429:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalInstanceLanguage.g:2429:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalInstanceLanguage.g:2438:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2442:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2443:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalInstanceLanguage.g:2450:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2454:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2455:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2455:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalInstanceLanguage.g:2456:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalInstanceLanguage.g:2457:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalInstanceLanguage.g:2457:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalInstanceLanguage.g:2465:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2469:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2470:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:2476:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2480:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalInstanceLanguage.g:2481:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalInstanceLanguage.g:2481:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalInstanceLanguage.g:2482:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            // InternalInstanceLanguage.g:2483:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalInstanceLanguage.g:2483:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalInstanceLanguage.g:2492:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2496:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalInstanceLanguage.g:2497:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:2504:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2508:1: ( ( '^' ) )
            // InternalInstanceLanguage.g:2509:1: ( '^' )
            {
            // InternalInstanceLanguage.g:2509:1: ( '^' )
            // InternalInstanceLanguage.g:2510:2: '^'
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            match(input,35,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:2519:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2523:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalInstanceLanguage.g:2524:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalInstanceLanguage.g:2530:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2534:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalInstanceLanguage.g:2535:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalInstanceLanguage.g:2535:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalInstanceLanguage.g:2536:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            // InternalInstanceLanguage.g:2537:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalInstanceLanguage.g:2537:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalInstanceLanguage.g:2546:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2550:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalInstanceLanguage.g:2551:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:2558:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2562:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalInstanceLanguage.g:2563:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalInstanceLanguage.g:2563:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalInstanceLanguage.g:2564:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            // InternalInstanceLanguage.g:2565:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=19 && LA23_0<=20)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2565:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalInstanceLanguage.g:2573:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2577:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2578:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:2584:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2588:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalInstanceLanguage.g:2589:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:2589:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalInstanceLanguage.g:2590:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalInstanceLanguage.g:2591:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalInstanceLanguage.g:2591:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalInstanceLanguage.g:2600:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2604:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalInstanceLanguage.g:2605:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:2612:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2616:1: ( ( '(' ) )
            // InternalInstanceLanguage.g:2617:1: ( '(' )
            {
            // InternalInstanceLanguage.g:2617:1: ( '(' )
            // InternalInstanceLanguage.g:2618:2: '('
            {
             before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:2627:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2631:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalInstanceLanguage.g:2632:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalInstanceLanguage.g:2639:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2643:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalInstanceLanguage.g:2644:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalInstanceLanguage.g:2644:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalInstanceLanguage.g:2645:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            // InternalInstanceLanguage.g:2646:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalInstanceLanguage.g:2646:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalInstanceLanguage.g:2654:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2658:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalInstanceLanguage.g:2659:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalInstanceLanguage.g:2665:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2669:1: ( ( ')' ) )
            // InternalInstanceLanguage.g:2670:1: ( ')' )
            {
            // InternalInstanceLanguage.g:2670:1: ( ')' )
            // InternalInstanceLanguage.g:2671:2: ')'
            {
             before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            match(input,37,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:2681:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2685:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalInstanceLanguage.g:2686:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalInstanceLanguage.g:2693:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2697:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalInstanceLanguage.g:2698:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalInstanceLanguage.g:2698:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalInstanceLanguage.g:2699:2: ( rule__CallRule__FunctionAssignment_0 )
            {
             before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            // InternalInstanceLanguage.g:2700:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalInstanceLanguage.g:2700:3: rule__CallRule__FunctionAssignment_0
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
    // InternalInstanceLanguage.g:2708:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2712:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalInstanceLanguage.g:2713:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalInstanceLanguage.g:2720:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2724:1: ( ( '(' ) )
            // InternalInstanceLanguage.g:2725:1: ( '(' )
            {
            // InternalInstanceLanguage.g:2725:1: ( '(' )
            // InternalInstanceLanguage.g:2726:2: '('
            {
             before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            match(input,36,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:2735:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2739:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalInstanceLanguage.g:2740:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_31);
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
    // InternalInstanceLanguage.g:2747:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2751:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalInstanceLanguage.g:2752:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalInstanceLanguage.g:2752:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalInstanceLanguage.g:2753:2: ( rule__CallRule__Group_2__0 )?
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            // InternalInstanceLanguage.g:2754:2: ( rule__CallRule__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_INT && LA24_0<=RULE_STRING)||LA24_0==12||(LA24_0>=19 && LA24_0<=20)||LA24_0==36||(LA24_0>=38 && LA24_0<=39)||(LA24_0>=41 && LA24_0<=42)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalInstanceLanguage.g:2754:3: rule__CallRule__Group_2__0
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
    // InternalInstanceLanguage.g:2762:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2766:1: ( rule__CallRule__Group__3__Impl )
            // InternalInstanceLanguage.g:2767:2: rule__CallRule__Group__3__Impl
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
    // InternalInstanceLanguage.g:2773:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2777:1: ( ( ')' ) )
            // InternalInstanceLanguage.g:2778:1: ( ')' )
            {
            // InternalInstanceLanguage.g:2778:1: ( ')' )
            // InternalInstanceLanguage.g:2779:2: ')'
            {
             before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            match(input,37,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:2789:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2793:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalInstanceLanguage.g:2794:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalInstanceLanguage.g:2801:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2805:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalInstanceLanguage.g:2806:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalInstanceLanguage.g:2806:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalInstanceLanguage.g:2807:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            // InternalInstanceLanguage.g:2808:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalInstanceLanguage.g:2808:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalInstanceLanguage.g:2816:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2820:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalInstanceLanguage.g:2821:2: rule__CallRule__Group_2__1__Impl
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
    // InternalInstanceLanguage.g:2827:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2831:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalInstanceLanguage.g:2832:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalInstanceLanguage.g:2832:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalInstanceLanguage.g:2833:2: ( rule__CallRule__Group_2_1__0 )*
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            // InternalInstanceLanguage.g:2834:2: ( rule__CallRule__Group_2_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==30) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2834:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalInstanceLanguage.g:2843:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2847:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalInstanceLanguage.g:2848:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:2855:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2859:1: ( ( ',' ) )
            // InternalInstanceLanguage.g:2860:1: ( ',' )
            {
            // InternalInstanceLanguage.g:2860:1: ( ',' )
            // InternalInstanceLanguage.g:2861:2: ','
            {
             before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:2870:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2874:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalInstanceLanguage.g:2875:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalInstanceLanguage.g:2881:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2885:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalInstanceLanguage.g:2886:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalInstanceLanguage.g:2886:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalInstanceLanguage.g:2887:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            // InternalInstanceLanguage.g:2888:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalInstanceLanguage.g:2888:3: rule__CallRule__ParametersAssignment_2_1_1
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


    // $ANTLR start "rule__FunctionNameRule__Group__0"
    // InternalInstanceLanguage.g:2897:1: rule__FunctionNameRule__Group__0 : rule__FunctionNameRule__Group__0__Impl rule__FunctionNameRule__Group__1 ;
    public final void rule__FunctionNameRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2901:1: ( rule__FunctionNameRule__Group__0__Impl rule__FunctionNameRule__Group__1 )
            // InternalInstanceLanguage.g:2902:2: rule__FunctionNameRule__Group__0__Impl rule__FunctionNameRule__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__FunctionNameRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctionNameRule__Group__1();

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
    // $ANTLR end "rule__FunctionNameRule__Group__0"


    // $ANTLR start "rule__FunctionNameRule__Group__0__Impl"
    // InternalInstanceLanguage.g:2909:1: rule__FunctionNameRule__Group__0__Impl : ( () ) ;
    public final void rule__FunctionNameRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2913:1: ( ( () ) )
            // InternalInstanceLanguage.g:2914:1: ( () )
            {
            // InternalInstanceLanguage.g:2914:1: ( () )
            // InternalInstanceLanguage.g:2915:2: ()
            {
             before(grammarAccess.getFunctionNameRuleAccess().getFunctionNameAction_0()); 
            // InternalInstanceLanguage.g:2916:2: ()
            // InternalInstanceLanguage.g:2916:3: 
            {
            }

             after(grammarAccess.getFunctionNameRuleAccess().getFunctionNameAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionNameRule__Group__0__Impl"


    // $ANTLR start "rule__FunctionNameRule__Group__1"
    // InternalInstanceLanguage.g:2924:1: rule__FunctionNameRule__Group__1 : rule__FunctionNameRule__Group__1__Impl ;
    public final void rule__FunctionNameRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2928:1: ( rule__FunctionNameRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2929:2: rule__FunctionNameRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionNameRule__Group__1__Impl();

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
    // $ANTLR end "rule__FunctionNameRule__Group__1"


    // $ANTLR start "rule__FunctionNameRule__Group__1__Impl"
    // InternalInstanceLanguage.g:2935:1: rule__FunctionNameRule__Group__1__Impl : ( 'call' ) ;
    public final void rule__FunctionNameRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2939:1: ( ( 'call' ) )
            // InternalInstanceLanguage.g:2940:1: ( 'call' )
            {
            // InternalInstanceLanguage.g:2940:1: ( 'call' )
            // InternalInstanceLanguage.g:2941:2: 'call'
            {
             before(grammarAccess.getFunctionNameRuleAccess().getCallKeyword_1()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getFunctionNameRuleAccess().getCallKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionNameRule__Group__1__Impl"


    // $ANTLR start "rule__ValueReferenceRule__Group__0"
    // InternalInstanceLanguage.g:2951:1: rule__ValueReferenceRule__Group__0 : rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 ;
    public final void rule__ValueReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2955:1: ( rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 )
            // InternalInstanceLanguage.g:2956:2: rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalInstanceLanguage.g:2963:1: rule__ValueReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__ValueReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2967:1: ( ( () ) )
            // InternalInstanceLanguage.g:2968:1: ( () )
            {
            // InternalInstanceLanguage.g:2968:1: ( () )
            // InternalInstanceLanguage.g:2969:2: ()
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0()); 
            // InternalInstanceLanguage.g:2970:2: ()
            // InternalInstanceLanguage.g:2970:3: 
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
    // InternalInstanceLanguage.g:2978:1: rule__ValueReferenceRule__Group__1 : rule__ValueReferenceRule__Group__1__Impl ;
    public final void rule__ValueReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2982:1: ( rule__ValueReferenceRule__Group__1__Impl )
            // InternalInstanceLanguage.g:2983:2: rule__ValueReferenceRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:2989:1: rule__ValueReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__ValueReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:2993:1: ( ( 'value' ) )
            // InternalInstanceLanguage.g:2994:1: ( 'value' )
            {
            // InternalInstanceLanguage.g:2994:1: ( 'value' )
            // InternalInstanceLanguage.g:2995:2: 'value'
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueKeyword_1()); 
            match(input,39,FOLLOW_2); 
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


    // $ANTLR start "rule__BooleanLiteralRule__Group__0"
    // InternalInstanceLanguage.g:3005:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3009:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalInstanceLanguage.g:3010:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalInstanceLanguage.g:3017:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3021:1: ( ( () ) )
            // InternalInstanceLanguage.g:3022:1: ( () )
            {
            // InternalInstanceLanguage.g:3022:1: ( () )
            // InternalInstanceLanguage.g:3023:2: ()
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            // InternalInstanceLanguage.g:3024:2: ()
            // InternalInstanceLanguage.g:3024:3: 
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
    // InternalInstanceLanguage.g:3032:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3036:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalInstanceLanguage.g:3037:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalInstanceLanguage.g:3043:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3047:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalInstanceLanguage.g:3048:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalInstanceLanguage.g:3048:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalInstanceLanguage.g:3049:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            // InternalInstanceLanguage.g:3050:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalInstanceLanguage.g:3050:3: rule__BooleanLiteralRule__Alternatives_1
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


    // $ANTLR start "rule__DOUBLE__Group__0"
    // InternalInstanceLanguage.g:3059:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3063:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // InternalInstanceLanguage.g:3064:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__DOUBLE__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__1();

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
    // $ANTLR end "rule__DOUBLE__Group__0"


    // $ANTLR start "rule__DOUBLE__Group__0__Impl"
    // InternalInstanceLanguage.g:3071:1: rule__DOUBLE__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3075:1: ( ( RULE_INT ) )
            // InternalInstanceLanguage.g:3076:1: ( RULE_INT )
            {
            // InternalInstanceLanguage.g:3076:1: ( RULE_INT )
            // InternalInstanceLanguage.g:3077:2: RULE_INT
            {
             before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 

            }


            }

        }
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
    // InternalInstanceLanguage.g:3086:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3090:1: ( rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 )
            // InternalInstanceLanguage.g:3091:2: rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2
            {
            pushFollow(FOLLOW_34);
            rule__DOUBLE__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__2();

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
    // $ANTLR end "rule__DOUBLE__Group__1"


    // $ANTLR start "rule__DOUBLE__Group__1__Impl"
    // InternalInstanceLanguage.g:3098:1: rule__DOUBLE__Group__1__Impl : ( '.' ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3102:1: ( ( '.' ) )
            // InternalInstanceLanguage.g:3103:1: ( '.' )
            {
            // InternalInstanceLanguage.g:3103:1: ( '.' )
            // InternalInstanceLanguage.g:3104:2: '.'
            {
             before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 

            }


            }

        }
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
    // InternalInstanceLanguage.g:3113:1: rule__DOUBLE__Group__2 : rule__DOUBLE__Group__2__Impl ;
    public final void rule__DOUBLE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3117:1: ( rule__DOUBLE__Group__2__Impl )
            // InternalInstanceLanguage.g:3118:2: rule__DOUBLE__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__2__Impl();

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
    // $ANTLR end "rule__DOUBLE__Group__2"


    // $ANTLR start "rule__DOUBLE__Group__2__Impl"
    // InternalInstanceLanguage.g:3124:1: rule__DOUBLE__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3128:1: ( ( RULE_INT ) )
            // InternalInstanceLanguage.g:3129:1: ( RULE_INT )
            {
            // InternalInstanceLanguage.g:3129:1: ( RULE_INT )
            // InternalInstanceLanguage.g:3130:2: RULE_INT
            {
             before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__InstanceRule__NameAssignment_0"
    // InternalInstanceLanguage.g:3140:1: rule__InstanceRule__NameAssignment_0 : ( ( ruleStringOrId ) ) ;
    public final void rule__InstanceRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3144:1: ( ( ( ruleStringOrId ) ) )
            // InternalInstanceLanguage.g:3145:2: ( ( ruleStringOrId ) )
            {
            // InternalInstanceLanguage.g:3145:2: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:3146:3: ( ruleStringOrId )
            {
             before(grammarAccess.getInstanceRuleAccess().getNameTypeDefinitionCrossReference_0_0()); 
            // InternalInstanceLanguage.g:3147:3: ( ruleStringOrId )
            // InternalInstanceLanguage.g:3148:4: ruleStringOrId
            {
             before(grammarAccess.getInstanceRuleAccess().getNameTypeDefinitionStringOrIdParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getInstanceRuleAccess().getNameTypeDefinitionStringOrIdParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getInstanceRuleAccess().getNameTypeDefinitionCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceRule__NameAssignment_0"


    // $ANTLR start "rule__InstanceRule__AttributesAssignment_1_1"
    // InternalInstanceLanguage.g:3159:1: rule__InstanceRule__AttributesAssignment_1_1 : ( ruleAttributeRule ) ;
    public final void rule__InstanceRule__AttributesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3163:1: ( ( ruleAttributeRule ) )
            // InternalInstanceLanguage.g:3164:2: ( ruleAttributeRule )
            {
            // InternalInstanceLanguage.g:3164:2: ( ruleAttributeRule )
            // InternalInstanceLanguage.g:3165:3: ruleAttributeRule
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


    // $ANTLR start "rule__AttributeRule__NameAssignment_0"
    // InternalInstanceLanguage.g:3174:1: rule__AttributeRule__NameAssignment_0 : ( ruleNameOrMiscRule ) ;
    public final void rule__AttributeRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3178:1: ( ( ruleNameOrMiscRule ) )
            // InternalInstanceLanguage.g:3179:2: ( ruleNameOrMiscRule )
            {
            // InternalInstanceLanguage.g:3179:2: ( ruleNameOrMiscRule )
            // InternalInstanceLanguage.g:3180:3: ruleNameOrMiscRule
            {
             before(grammarAccess.getAttributeRuleAccess().getNameNameOrMiscRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNameOrMiscRule();

            state._fsp--;

             after(grammarAccess.getAttributeRuleAccess().getNameNameOrMiscRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeRule__NameAssignment_0"


    // $ANTLR start "rule__AttributeRule__ValueAssignment_2"
    // InternalInstanceLanguage.g:3189:1: rule__AttributeRule__ValueAssignment_2 : ( ruleValueRule ) ;
    public final void rule__AttributeRule__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3193:1: ( ( ruleValueRule ) )
            // InternalInstanceLanguage.g:3194:2: ( ruleValueRule )
            {
            // InternalInstanceLanguage.g:3194:2: ( ruleValueRule )
            // InternalInstanceLanguage.g:3195:3: ruleValueRule
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


    // $ANTLR start "rule__NameRule__NameAssignment"
    // InternalInstanceLanguage.g:3204:1: rule__NameRule__NameAssignment : ( ( ruleStringOrId ) ) ;
    public final void rule__NameRule__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3208:1: ( ( ( ruleStringOrId ) ) )
            // InternalInstanceLanguage.g:3209:2: ( ( ruleStringOrId ) )
            {
            // InternalInstanceLanguage.g:3209:2: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:3210:3: ( ruleStringOrId )
            {
             before(grammarAccess.getNameRuleAccess().getNameNamedAttributeDefinitionCrossReference_0()); 
            // InternalInstanceLanguage.g:3211:3: ( ruleStringOrId )
            // InternalInstanceLanguage.g:3212:4: ruleStringOrId
            {
             before(grammarAccess.getNameRuleAccess().getNameNamedAttributeDefinitionStringOrIdParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getNameRuleAccess().getNameNamedAttributeDefinitionStringOrIdParserRuleCall_0_1()); 

            }

             after(grammarAccess.getNameRuleAccess().getNameNamedAttributeDefinitionCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameRule__NameAssignment"


    // $ANTLR start "rule__MiscRule__NameAssignment"
    // InternalInstanceLanguage.g:3223:1: rule__MiscRule__NameAssignment : ( RULE_STRING ) ;
    public final void rule__MiscRule__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3227:1: ( ( RULE_STRING ) )
            // InternalInstanceLanguage.g:3228:2: ( RULE_STRING )
            {
            // InternalInstanceLanguage.g:3228:2: ( RULE_STRING )
            // InternalInstanceLanguage.g:3229:3: RULE_STRING
            {
             before(grammarAccess.getMiscRuleAccess().getNameSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getMiscRuleAccess().getNameSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MiscRule__NameAssignment"


    // $ANTLR start "rule__ArrayRule__ValuesAssignment_2_0"
    // InternalInstanceLanguage.g:3238:1: rule__ArrayRule__ValuesAssignment_2_0 : ( ruleValueRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3242:1: ( ( ruleValueRule ) )
            // InternalInstanceLanguage.g:3243:2: ( ruleValueRule )
            {
            // InternalInstanceLanguage.g:3243:2: ( ruleValueRule )
            // InternalInstanceLanguage.g:3244:3: ruleValueRule
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
    // InternalInstanceLanguage.g:3253:1: rule__ArrayRule__ValuesAssignment_2_1_1 : ( ruleValueRule ) ;
    public final void rule__ArrayRule__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3257:1: ( ( ruleValueRule ) )
            // InternalInstanceLanguage.g:3258:2: ( ruleValueRule )
            {
            // InternalInstanceLanguage.g:3258:2: ( ruleValueRule )
            // InternalInstanceLanguage.g:3259:3: ruleValueRule
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
    // InternalInstanceLanguage.g:3268:1: rule__LiteralValueRule__LiteralAssignment : ( ruleLiteralRule ) ;
    public final void rule__LiteralValueRule__LiteralAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3272:1: ( ( ruleLiteralRule ) )
            // InternalInstanceLanguage.g:3273:2: ( ruleLiteralRule )
            {
            // InternalInstanceLanguage.g:3273:2: ( ruleLiteralRule )
            // InternalInstanceLanguage.g:3274:3: ruleLiteralRule
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
    // InternalInstanceLanguage.g:3283:1: rule__DataReferenceRule__DefinitionAssignment_2 : ( ( ruleStringOrId ) ) ;
    public final void rule__DataReferenceRule__DefinitionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3287:1: ( ( ( ruleStringOrId ) ) )
            // InternalInstanceLanguage.g:3288:2: ( ( ruleStringOrId ) )
            {
            // InternalInstanceLanguage.g:3288:2: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:3289:3: ( ruleStringOrId )
            {
             before(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_2_0()); 
            // InternalInstanceLanguage.g:3290:3: ( ruleStringOrId )
            // InternalInstanceLanguage.g:3291:4: ruleStringOrId
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
    // InternalInstanceLanguage.g:3302:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3306:1: ( ( ruleXorExpressionRule ) )
            // InternalInstanceLanguage.g:3307:2: ( ruleXorExpressionRule )
            {
            // InternalInstanceLanguage.g:3307:2: ( ruleXorExpressionRule )
            // InternalInstanceLanguage.g:3308:3: ruleXorExpressionRule
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
    // InternalInstanceLanguage.g:3317:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3321:1: ( ( ruleXorExpressionRule ) )
            // InternalInstanceLanguage.g:3322:2: ( ruleXorExpressionRule )
            {
            // InternalInstanceLanguage.g:3322:2: ( ruleXorExpressionRule )
            // InternalInstanceLanguage.g:3323:3: ruleXorExpressionRule
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
    // InternalInstanceLanguage.g:3332:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3336:1: ( ( ruleAndExpressionRule ) )
            // InternalInstanceLanguage.g:3337:2: ( ruleAndExpressionRule )
            {
            // InternalInstanceLanguage.g:3337:2: ( ruleAndExpressionRule )
            // InternalInstanceLanguage.g:3338:3: ruleAndExpressionRule
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
    // InternalInstanceLanguage.g:3347:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3351:1: ( ( ruleAndExpressionRule ) )
            // InternalInstanceLanguage.g:3352:2: ( ruleAndExpressionRule )
            {
            // InternalInstanceLanguage.g:3352:2: ( ruleAndExpressionRule )
            // InternalInstanceLanguage.g:3353:3: ruleAndExpressionRule
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
    // InternalInstanceLanguage.g:3362:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3366:1: ( ( ruleNotExpressionRule ) )
            // InternalInstanceLanguage.g:3367:2: ( ruleNotExpressionRule )
            {
            // InternalInstanceLanguage.g:3367:2: ( ruleNotExpressionRule )
            // InternalInstanceLanguage.g:3368:3: ruleNotExpressionRule
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
    // InternalInstanceLanguage.g:3377:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3381:1: ( ( ruleNotExpressionRule ) )
            // InternalInstanceLanguage.g:3382:2: ( ruleNotExpressionRule )
            {
            // InternalInstanceLanguage.g:3382:2: ( ruleNotExpressionRule )
            // InternalInstanceLanguage.g:3383:3: ruleNotExpressionRule
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
    // InternalInstanceLanguage.g:3392:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3396:1: ( ( ( '!' ) ) )
            // InternalInstanceLanguage.g:3397:2: ( ( '!' ) )
            {
            // InternalInstanceLanguage.g:3397:2: ( ( '!' ) )
            // InternalInstanceLanguage.g:3398:3: ( '!' )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            // InternalInstanceLanguage.g:3399:3: ( '!' )
            // InternalInstanceLanguage.g:3400:4: '!'
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalInstanceLanguage.g:3411:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3415:1: ( ( ruleComparisonExpressionRule ) )
            // InternalInstanceLanguage.g:3416:2: ( ruleComparisonExpressionRule )
            {
            // InternalInstanceLanguage.g:3416:2: ( ruleComparisonExpressionRule )
            // InternalInstanceLanguage.g:3417:3: ruleComparisonExpressionRule
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
    // InternalInstanceLanguage.g:3426:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3430:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:3431:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:3431:2: ( ruleAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:3432:3: ruleAddOrSubtractExpressionRule
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
    // InternalInstanceLanguage.g:3441:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3445:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalInstanceLanguage.g:3446:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalInstanceLanguage.g:3446:2: ( rulePartialComparisonExpressionRule )
            // InternalInstanceLanguage.g:3447:3: rulePartialComparisonExpressionRule
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
    // InternalInstanceLanguage.g:3456:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3460:1: ( ( ruleComparisonOperatorRule ) )
            // InternalInstanceLanguage.g:3461:2: ( ruleComparisonOperatorRule )
            {
            // InternalInstanceLanguage.g:3461:2: ( ruleComparisonOperatorRule )
            // InternalInstanceLanguage.g:3462:3: ruleComparisonOperatorRule
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
    // InternalInstanceLanguage.g:3471:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3475:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:3476:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:3476:2: ( ruleAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:3477:3: ruleAddOrSubtractExpressionRule
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
    // InternalInstanceLanguage.g:3486:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3490:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalInstanceLanguage.g:3491:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalInstanceLanguage.g:3491:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalInstanceLanguage.g:3492:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalInstanceLanguage.g:3501:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3505:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalInstanceLanguage.g:3506:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalInstanceLanguage.g:3506:2: ( ruleAddOrSubtractOperatorRule )
            // InternalInstanceLanguage.g:3507:3: ruleAddOrSubtractOperatorRule
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
    // InternalInstanceLanguage.g:3516:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3520:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalInstanceLanguage.g:3521:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalInstanceLanguage.g:3521:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalInstanceLanguage.g:3522:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalInstanceLanguage.g:3531:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3535:1: ( ( rulePowerOfExpressionRule ) )
            // InternalInstanceLanguage.g:3536:2: ( rulePowerOfExpressionRule )
            {
            // InternalInstanceLanguage.g:3536:2: ( rulePowerOfExpressionRule )
            // InternalInstanceLanguage.g:3537:3: rulePowerOfExpressionRule
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
    // InternalInstanceLanguage.g:3546:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3550:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalInstanceLanguage.g:3551:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalInstanceLanguage.g:3551:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalInstanceLanguage.g:3552:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalInstanceLanguage.g:3561:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3565:1: ( ( rulePowerOfExpressionRule ) )
            // InternalInstanceLanguage.g:3566:2: ( rulePowerOfExpressionRule )
            {
            // InternalInstanceLanguage.g:3566:2: ( rulePowerOfExpressionRule )
            // InternalInstanceLanguage.g:3567:3: rulePowerOfExpressionRule
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
    // InternalInstanceLanguage.g:3576:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3580:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:3581:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:3581:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:3582:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalInstanceLanguage.g:3591:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3595:1: ( ( rulePowerOfExpressionRule ) )
            // InternalInstanceLanguage.g:3596:2: ( rulePowerOfExpressionRule )
            {
            // InternalInstanceLanguage.g:3596:2: ( rulePowerOfExpressionRule )
            // InternalInstanceLanguage.g:3597:3: rulePowerOfExpressionRule
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
    // InternalInstanceLanguage.g:3606:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3610:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalInstanceLanguage.g:3611:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalInstanceLanguage.g:3611:2: ( ruleAddOrSubtractOperatorRule )
            // InternalInstanceLanguage.g:3612:3: ruleAddOrSubtractOperatorRule
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
    // InternalInstanceLanguage.g:3621:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleLiteralOrReferenceRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3625:1: ( ( ruleLiteralOrReferenceRule ) )
            // InternalInstanceLanguage.g:3626:2: ( ruleLiteralOrReferenceRule )
            {
            // InternalInstanceLanguage.g:3626:2: ( ruleLiteralOrReferenceRule )
            // InternalInstanceLanguage.g:3627:3: ruleLiteralOrReferenceRule
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
    // InternalInstanceLanguage.g:3636:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3640:1: ( ( ruleExpressionRule ) )
            // InternalInstanceLanguage.g:3641:2: ( ruleExpressionRule )
            {
            // InternalInstanceLanguage.g:3641:2: ( ruleExpressionRule )
            // InternalInstanceLanguage.g:3642:3: ruleExpressionRule
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
    // InternalInstanceLanguage.g:3651:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3655:1: ( ( ruleFunctionNameRule ) )
            // InternalInstanceLanguage.g:3656:2: ( ruleFunctionNameRule )
            {
            // InternalInstanceLanguage.g:3656:2: ( ruleFunctionNameRule )
            // InternalInstanceLanguage.g:3657:3: ruleFunctionNameRule
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
    // InternalInstanceLanguage.g:3666:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3670:1: ( ( ruleExpressionRule ) )
            // InternalInstanceLanguage.g:3671:2: ( ruleExpressionRule )
            {
            // InternalInstanceLanguage.g:3671:2: ( ruleExpressionRule )
            // InternalInstanceLanguage.g:3672:3: ruleExpressionRule
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
    // InternalInstanceLanguage.g:3681:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3685:1: ( ( ruleExpressionRule ) )
            // InternalInstanceLanguage.g:3686:2: ( ruleExpressionRule )
            {
            // InternalInstanceLanguage.g:3686:2: ( ruleExpressionRule )
            // InternalInstanceLanguage.g:3687:3: ruleExpressionRule
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


    // $ANTLR start "rule__DoubleLiteralRule__ValueAssignment"
    // InternalInstanceLanguage.g:3696:1: rule__DoubleLiteralRule__ValueAssignment : ( ruleDOUBLE ) ;
    public final void rule__DoubleLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3700:1: ( ( ruleDOUBLE ) )
            // InternalInstanceLanguage.g:3701:2: ( ruleDOUBLE )
            {
            // InternalInstanceLanguage.g:3701:2: ( ruleDOUBLE )
            // InternalInstanceLanguage.g:3702:3: ruleDOUBLE
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getValueDOUBLEParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getDoubleLiteralRuleAccess().getValueDOUBLEParserRuleCall_0()); 

            }


            }

        }
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
    // InternalInstanceLanguage.g:3711:1: rule__IntegerLiteralRule__ValueAssignment : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3715:1: ( ( RULE_INT ) )
            // InternalInstanceLanguage.g:3716:2: ( RULE_INT )
            {
            // InternalInstanceLanguage.g:3716:2: ( RULE_INT )
            // InternalInstanceLanguage.g:3717:3: RULE_INT
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getValueINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getIntegerLiteralRuleAccess().getValueINTTerminalRuleCall_0()); 

            }


            }

        }
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
    // InternalInstanceLanguage.g:3726:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3730:1: ( ( RULE_STRING ) )
            // InternalInstanceLanguage.g:3731:2: ( RULE_STRING )
            {
            // InternalInstanceLanguage.g:3731:2: ( RULE_STRING )
            // InternalInstanceLanguage.g:3732:3: RULE_STRING
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
    // InternalInstanceLanguage.g:3741:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalInstanceLanguage.g:3745:1: ( ( ( 'true' ) ) )
            // InternalInstanceLanguage.g:3746:2: ( ( 'true' ) )
            {
            // InternalInstanceLanguage.g:3746:2: ( ( 'true' ) )
            // InternalInstanceLanguage.g:3747:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            // InternalInstanceLanguage.g:3748:3: ( 'true' )
            // InternalInstanceLanguage.g:3749:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            match(input,42,FOLLOW_2); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000020000B0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000000B2L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000400900010F0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000400B00010F0L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000006D0901810F0L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000000007E000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000006F0901810F0L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000040L});

}
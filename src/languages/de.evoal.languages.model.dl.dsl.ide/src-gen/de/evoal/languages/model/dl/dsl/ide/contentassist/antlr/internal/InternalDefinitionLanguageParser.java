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

@SuppressWarnings("all")
public class InternalDefinitionLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'type'", "'{'", "'}'", "'extends'", "'unnamed'", "':'", "';'", "'literal'", "'instance'", "'|'", "'string'", "'expression'", "'int'", "'float'", "'boolean'", "'void'", "'data'", "'array'", "'def'", "'('", "')'", "','", "'OR'", "'XOR'", "'AND'", "'^'", "'value'", "'.'", "'abstract'", "'!'", "'true'"
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
    public static final int T__53=53;
    public static final int T__54=54;
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
    // InternalDefinitionLanguage.g:54:1: entryRuleDefinitionModelRule : ruleDefinitionModelRule EOF ;
    public final void entryRuleDefinitionModelRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:55:1: ( ruleDefinitionModelRule EOF )
            // InternalDefinitionLanguage.g:56:1: ruleDefinitionModelRule EOF
            {
             before(grammarAccess.getDefinitionModelRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleDefinitionModelRule();

            state._fsp--;

             after(grammarAccess.getDefinitionModelRuleRule()); 
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
    // $ANTLR end "entryRuleDefinitionModelRule"


    // $ANTLR start "ruleDefinitionModelRule"
    // InternalDefinitionLanguage.g:63:1: ruleDefinitionModelRule : ( ( rule__DefinitionModelRule__Alternatives )* ) ;
    public final void ruleDefinitionModelRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:67:2: ( ( ( rule__DefinitionModelRule__Alternatives )* ) )
            // InternalDefinitionLanguage.g:68:2: ( ( rule__DefinitionModelRule__Alternatives )* )
            {
            // InternalDefinitionLanguage.g:68:2: ( ( rule__DefinitionModelRule__Alternatives )* )
            // InternalDefinitionLanguage.g:69:3: ( rule__DefinitionModelRule__Alternatives )*
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:70:3: ( rule__DefinitionModelRule__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==24||LA1_0==42||LA1_0==52) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:70:4: rule__DefinitionModelRule__Alternatives
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__DefinitionModelRule__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getDefinitionModelRuleAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleTypeDefinitionRule"
    // InternalDefinitionLanguage.g:79:1: entryRuleTypeDefinitionRule : ruleTypeDefinitionRule EOF ;
    public final void entryRuleTypeDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:80:1: ( ruleTypeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:81:1: ruleTypeDefinitionRule EOF
            {
             before(grammarAccess.getTypeDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeDefinitionRule();

            state._fsp--;

             after(grammarAccess.getTypeDefinitionRuleRule()); 
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
    // $ANTLR end "entryRuleTypeDefinitionRule"


    // $ANTLR start "ruleTypeDefinitionRule"
    // InternalDefinitionLanguage.g:88:1: ruleTypeDefinitionRule : ( ( rule__TypeDefinitionRule__Group__0 ) ) ;
    public final void ruleTypeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:92:2: ( ( ( rule__TypeDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:93:2: ( ( rule__TypeDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:93:2: ( ( rule__TypeDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:94:3: ( rule__TypeDefinitionRule__Group__0 )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:95:3: ( rule__TypeDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:95:4: rule__TypeDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getGroup()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:104:1: entryRuleAttributeDefinitionRule : ruleAttributeDefinitionRule EOF ;
    public final void entryRuleAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:105:1: ( ruleAttributeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:106:1: ruleAttributeDefinitionRule EOF
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
    // InternalDefinitionLanguage.g:113:1: ruleAttributeDefinitionRule : ( ( rule__AttributeDefinitionRule__Alternatives ) ) ;
    public final void ruleAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:117:2: ( ( ( rule__AttributeDefinitionRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:118:2: ( ( rule__AttributeDefinitionRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:118:2: ( ( rule__AttributeDefinitionRule__Alternatives ) )
            // InternalDefinitionLanguage.g:119:3: ( rule__AttributeDefinitionRule__Alternatives )
            {
             before(grammarAccess.getAttributeDefinitionRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:120:3: ( rule__AttributeDefinitionRule__Alternatives )
            // InternalDefinitionLanguage.g:120:4: rule__AttributeDefinitionRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAttributeDefinitionRuleAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleUnnamedAttributeDefinitionRule"
    // InternalDefinitionLanguage.g:129:1: entryRuleUnnamedAttributeDefinitionRule : ruleUnnamedAttributeDefinitionRule EOF ;
    public final void entryRuleUnnamedAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:130:1: ( ruleUnnamedAttributeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:131:1: ruleUnnamedAttributeDefinitionRule EOF
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleUnnamedAttributeDefinitionRule();

            state._fsp--;

             after(grammarAccess.getUnnamedAttributeDefinitionRuleRule()); 
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
    // $ANTLR end "entryRuleUnnamedAttributeDefinitionRule"


    // $ANTLR start "ruleUnnamedAttributeDefinitionRule"
    // InternalDefinitionLanguage.g:138:1: ruleUnnamedAttributeDefinitionRule : ( ( rule__UnnamedAttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleUnnamedAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:142:2: ( ( ( rule__UnnamedAttributeDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:143:2: ( ( rule__UnnamedAttributeDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:143:2: ( ( rule__UnnamedAttributeDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:144:3: ( rule__UnnamedAttributeDefinitionRule__Group__0 )
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:145:3: ( rule__UnnamedAttributeDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:145:4: rule__UnnamedAttributeDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnnamedAttributeDefinitionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnnamedAttributeDefinitionRule"


    // $ANTLR start "entryRuleNamedAttributeDefinitionRule"
    // InternalDefinitionLanguage.g:154:1: entryRuleNamedAttributeDefinitionRule : ruleNamedAttributeDefinitionRule EOF ;
    public final void entryRuleNamedAttributeDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:155:1: ( ruleNamedAttributeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:156:1: ruleNamedAttributeDefinitionRule EOF
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleNamedAttributeDefinitionRule();

            state._fsp--;

             after(grammarAccess.getNamedAttributeDefinitionRuleRule()); 
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
    // $ANTLR end "entryRuleNamedAttributeDefinitionRule"


    // $ANTLR start "ruleNamedAttributeDefinitionRule"
    // InternalDefinitionLanguage.g:163:1: ruleNamedAttributeDefinitionRule : ( ( rule__NamedAttributeDefinitionRule__Group__0 ) ) ;
    public final void ruleNamedAttributeDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:167:2: ( ( ( rule__NamedAttributeDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:168:2: ( ( rule__NamedAttributeDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:168:2: ( ( rule__NamedAttributeDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:169:3: ( rule__NamedAttributeDefinitionRule__Group__0 )
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:170:3: ( rule__NamedAttributeDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:170:4: rule__NamedAttributeDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NamedAttributeDefinitionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNamedAttributeDefinitionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamedAttributeDefinitionRule"


    // $ANTLR start "entryRuleTypeRule"
    // InternalDefinitionLanguage.g:179:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:180:1: ( ruleTypeRule EOF )
            // InternalDefinitionLanguage.g:181:1: ruleTypeRule EOF
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
    // InternalDefinitionLanguage.g:188:1: ruleTypeRule : ( ( rule__TypeRule__Alternatives ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:192:2: ( ( ( rule__TypeRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:193:2: ( ( rule__TypeRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:193:2: ( ( rule__TypeRule__Alternatives ) )
            // InternalDefinitionLanguage.g:194:3: ( rule__TypeRule__Alternatives )
            {
             before(grammarAccess.getTypeRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:195:3: ( rule__TypeRule__Alternatives )
            // InternalDefinitionLanguage.g:195:4: rule__TypeRule__Alternatives
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
    // InternalDefinitionLanguage.g:204:1: entryRuleLiteralTypeRule : ruleLiteralTypeRule EOF ;
    public final void entryRuleLiteralTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:205:1: ( ruleLiteralTypeRule EOF )
            // InternalDefinitionLanguage.g:206:1: ruleLiteralTypeRule EOF
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
    // InternalDefinitionLanguage.g:213:1: ruleLiteralTypeRule : ( ( rule__LiteralTypeRule__Group__0 ) ) ;
    public final void ruleLiteralTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:217:2: ( ( ( rule__LiteralTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:218:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:218:2: ( ( rule__LiteralTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:219:3: ( rule__LiteralTypeRule__Group__0 )
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:220:3: ( rule__LiteralTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:220:4: rule__LiteralTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:229:1: entryRuleInstanceTypeRule : ruleInstanceTypeRule EOF ;
    public final void entryRuleInstanceTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:230:1: ( ruleInstanceTypeRule EOF )
            // InternalDefinitionLanguage.g:231:1: ruleInstanceTypeRule EOF
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
    // InternalDefinitionLanguage.g:238:1: ruleInstanceTypeRule : ( ( rule__InstanceTypeRule__Group__0 ) ) ;
    public final void ruleInstanceTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:242:2: ( ( ( rule__InstanceTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:243:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:243:2: ( ( rule__InstanceTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:244:3: ( rule__InstanceTypeRule__Group__0 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:245:3: ( rule__InstanceTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:245:4: rule__InstanceTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:254:1: entryRuleStringTypeRule : ruleStringTypeRule EOF ;
    public final void entryRuleStringTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:255:1: ( ruleStringTypeRule EOF )
            // InternalDefinitionLanguage.g:256:1: ruleStringTypeRule EOF
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
    // InternalDefinitionLanguage.g:263:1: ruleStringTypeRule : ( ( rule__StringTypeRule__Group__0 ) ) ;
    public final void ruleStringTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:267:2: ( ( ( rule__StringTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:268:2: ( ( rule__StringTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:268:2: ( ( rule__StringTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:269:3: ( rule__StringTypeRule__Group__0 )
            {
             before(grammarAccess.getStringTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:270:3: ( rule__StringTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:270:4: rule__StringTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:279:1: entryRuleExpressionTypeRule : ruleExpressionTypeRule EOF ;
    public final void entryRuleExpressionTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:280:1: ( ruleExpressionTypeRule EOF )
            // InternalDefinitionLanguage.g:281:1: ruleExpressionTypeRule EOF
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
    // InternalDefinitionLanguage.g:288:1: ruleExpressionTypeRule : ( ( rule__ExpressionTypeRule__Group__0 ) ) ;
    public final void ruleExpressionTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:292:2: ( ( ( rule__ExpressionTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:293:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:293:2: ( ( rule__ExpressionTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:294:3: ( rule__ExpressionTypeRule__Group__0 )
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:295:3: ( rule__ExpressionTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:295:4: rule__ExpressionTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:304:1: entryRuleIntTypeRule : ruleIntTypeRule EOF ;
    public final void entryRuleIntTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:305:1: ( ruleIntTypeRule EOF )
            // InternalDefinitionLanguage.g:306:1: ruleIntTypeRule EOF
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
    // InternalDefinitionLanguage.g:313:1: ruleIntTypeRule : ( ( rule__IntTypeRule__Group__0 ) ) ;
    public final void ruleIntTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:317:2: ( ( ( rule__IntTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:318:2: ( ( rule__IntTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:318:2: ( ( rule__IntTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:319:3: ( rule__IntTypeRule__Group__0 )
            {
             before(grammarAccess.getIntTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:320:3: ( rule__IntTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:320:4: rule__IntTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:329:1: entryRuleFloatTypeRule : ruleFloatTypeRule EOF ;
    public final void entryRuleFloatTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:330:1: ( ruleFloatTypeRule EOF )
            // InternalDefinitionLanguage.g:331:1: ruleFloatTypeRule EOF
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
    // InternalDefinitionLanguage.g:338:1: ruleFloatTypeRule : ( ( rule__FloatTypeRule__Group__0 ) ) ;
    public final void ruleFloatTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:342:2: ( ( ( rule__FloatTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:343:2: ( ( rule__FloatTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:343:2: ( ( rule__FloatTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:344:3: ( rule__FloatTypeRule__Group__0 )
            {
             before(grammarAccess.getFloatTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:345:3: ( rule__FloatTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:345:4: rule__FloatTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:354:1: entryRuleBooleanTypeRule : ruleBooleanTypeRule EOF ;
    public final void entryRuleBooleanTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:355:1: ( ruleBooleanTypeRule EOF )
            // InternalDefinitionLanguage.g:356:1: ruleBooleanTypeRule EOF
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
    // InternalDefinitionLanguage.g:363:1: ruleBooleanTypeRule : ( ( rule__BooleanTypeRule__Group__0 ) ) ;
    public final void ruleBooleanTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:367:2: ( ( ( rule__BooleanTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:368:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:368:2: ( ( rule__BooleanTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:369:3: ( rule__BooleanTypeRule__Group__0 )
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:370:3: ( rule__BooleanTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:370:4: rule__BooleanTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:379:1: entryRuleVoidTypeRule : ruleVoidTypeRule EOF ;
    public final void entryRuleVoidTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:380:1: ( ruleVoidTypeRule EOF )
            // InternalDefinitionLanguage.g:381:1: ruleVoidTypeRule EOF
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
    // InternalDefinitionLanguage.g:388:1: ruleVoidTypeRule : ( ( rule__VoidTypeRule__Group__0 ) ) ;
    public final void ruleVoidTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:392:2: ( ( ( rule__VoidTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:393:2: ( ( rule__VoidTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:393:2: ( ( rule__VoidTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:394:3: ( rule__VoidTypeRule__Group__0 )
            {
             before(grammarAccess.getVoidTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:395:3: ( rule__VoidTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:395:4: rule__VoidTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:404:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:405:1: ( ruleDataTypeRule EOF )
            // InternalDefinitionLanguage.g:406:1: ruleDataTypeRule EOF
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
    // InternalDefinitionLanguage.g:413:1: ruleDataTypeRule : ( ( rule__DataTypeRule__Group__0 ) ) ;
    public final void ruleDataTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:417:2: ( ( ( rule__DataTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:418:2: ( ( rule__DataTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:418:2: ( ( rule__DataTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:419:3: ( rule__DataTypeRule__Group__0 )
            {
             before(grammarAccess.getDataTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:420:3: ( rule__DataTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:420:4: rule__DataTypeRule__Group__0
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
    // InternalDefinitionLanguage.g:429:1: entryRuleArrayTypeRule : ruleArrayTypeRule EOF ;
    public final void entryRuleArrayTypeRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:430:1: ( ruleArrayTypeRule EOF )
            // InternalDefinitionLanguage.g:431:1: ruleArrayTypeRule EOF
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
    // InternalDefinitionLanguage.g:438:1: ruleArrayTypeRule : ( ( rule__ArrayTypeRule__Group__0 ) ) ;
    public final void ruleArrayTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:442:2: ( ( ( rule__ArrayTypeRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:443:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:443:2: ( ( rule__ArrayTypeRule__Group__0 ) )
            // InternalDefinitionLanguage.g:444:3: ( rule__ArrayTypeRule__Group__0 )
            {
             before(grammarAccess.getArrayTypeRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:445:3: ( rule__ArrayTypeRule__Group__0 )
            // InternalDefinitionLanguage.g:445:4: rule__ArrayTypeRule__Group__0
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


    // $ANTLR start "entryRuleFunctioDefinitionRule"
    // InternalDefinitionLanguage.g:454:1: entryRuleFunctioDefinitionRule : ruleFunctioDefinitionRule EOF ;
    public final void entryRuleFunctioDefinitionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:455:1: ( ruleFunctioDefinitionRule EOF )
            // InternalDefinitionLanguage.g:456:1: ruleFunctioDefinitionRule EOF
            {
             before(grammarAccess.getFunctioDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleFunctioDefinitionRule();

            state._fsp--;

             after(grammarAccess.getFunctioDefinitionRuleRule()); 
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
    // $ANTLR end "entryRuleFunctioDefinitionRule"


    // $ANTLR start "ruleFunctioDefinitionRule"
    // InternalDefinitionLanguage.g:463:1: ruleFunctioDefinitionRule : ( ( rule__FunctioDefinitionRule__Group__0 ) ) ;
    public final void ruleFunctioDefinitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:467:2: ( ( ( rule__FunctioDefinitionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:468:2: ( ( rule__FunctioDefinitionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:468:2: ( ( rule__FunctioDefinitionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:469:3: ( rule__FunctioDefinitionRule__Group__0 )
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:470:3: ( rule__FunctioDefinitionRule__Group__0 )
            // InternalDefinitionLanguage.g:470:4: rule__FunctioDefinitionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFunctioDefinitionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunctioDefinitionRule"


    // $ANTLR start "entryRuleParameterRule"
    // InternalDefinitionLanguage.g:479:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:480:1: ( ruleParameterRule EOF )
            // InternalDefinitionLanguage.g:481:1: ruleParameterRule EOF
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
    // InternalDefinitionLanguage.g:488:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:492:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:493:2: ( ( rule__ParameterRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:493:2: ( ( rule__ParameterRule__Group__0 ) )
            // InternalDefinitionLanguage.g:494:3: ( rule__ParameterRule__Group__0 )
            {
             before(grammarAccess.getParameterRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:495:3: ( rule__ParameterRule__Group__0 )
            // InternalDefinitionLanguage.g:495:4: rule__ParameterRule__Group__0
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
    // InternalDefinitionLanguage.g:504:1: entryRuleFunctionNameRule : ruleFunctionNameRule EOF ;
    public final void entryRuleFunctionNameRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:505:1: ( ruleFunctionNameRule EOF )
            // InternalDefinitionLanguage.g:506:1: ruleFunctionNameRule EOF
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
    // InternalDefinitionLanguage.g:513:1: ruleFunctionNameRule : ( ( rule__FunctionNameRule__DefinitionAssignment ) ) ;
    public final void ruleFunctionNameRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:517:2: ( ( ( rule__FunctionNameRule__DefinitionAssignment ) ) )
            // InternalDefinitionLanguage.g:518:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            {
            // InternalDefinitionLanguage.g:518:2: ( ( rule__FunctionNameRule__DefinitionAssignment ) )
            // InternalDefinitionLanguage.g:519:3: ( rule__FunctionNameRule__DefinitionAssignment )
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionAssignment()); 
            // InternalDefinitionLanguage.g:520:3: ( rule__FunctionNameRule__DefinitionAssignment )
            // InternalDefinitionLanguage.g:520:4: rule__FunctionNameRule__DefinitionAssignment
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


    // $ANTLR start "entryRuleExpressionRule"
    // InternalDefinitionLanguage.g:529:1: entryRuleExpressionRule : ruleExpressionRule EOF ;
    public final void entryRuleExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:530:1: ( ruleExpressionRule EOF )
            // InternalDefinitionLanguage.g:531:1: ruleExpressionRule EOF
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
    // InternalDefinitionLanguage.g:538:1: ruleExpressionRule : ( ruleOrExpressionRule ) ;
    public final void ruleExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:542:2: ( ( ruleOrExpressionRule ) )
            // InternalDefinitionLanguage.g:543:2: ( ruleOrExpressionRule )
            {
            // InternalDefinitionLanguage.g:543:2: ( ruleOrExpressionRule )
            // InternalDefinitionLanguage.g:544:3: ruleOrExpressionRule
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
    // InternalDefinitionLanguage.g:554:1: entryRuleOrExpressionRule : ruleOrExpressionRule EOF ;
    public final void entryRuleOrExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:555:1: ( ruleOrExpressionRule EOF )
            // InternalDefinitionLanguage.g:556:1: ruleOrExpressionRule EOF
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
    // InternalDefinitionLanguage.g:563:1: ruleOrExpressionRule : ( ( rule__OrExpressionRule__Group__0 ) ) ;
    public final void ruleOrExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:567:2: ( ( ( rule__OrExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:568:2: ( ( rule__OrExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:568:2: ( ( rule__OrExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:569:3: ( rule__OrExpressionRule__Group__0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:570:3: ( rule__OrExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:570:4: rule__OrExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:579:1: entryRuleXorExpressionRule : ruleXorExpressionRule EOF ;
    public final void entryRuleXorExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:580:1: ( ruleXorExpressionRule EOF )
            // InternalDefinitionLanguage.g:581:1: ruleXorExpressionRule EOF
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
    // InternalDefinitionLanguage.g:588:1: ruleXorExpressionRule : ( ( rule__XorExpressionRule__Group__0 ) ) ;
    public final void ruleXorExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:592:2: ( ( ( rule__XorExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:593:2: ( ( rule__XorExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:593:2: ( ( rule__XorExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:594:3: ( rule__XorExpressionRule__Group__0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:595:3: ( rule__XorExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:595:4: rule__XorExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:604:1: entryRuleAndExpressionRule : ruleAndExpressionRule EOF ;
    public final void entryRuleAndExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:605:1: ( ruleAndExpressionRule EOF )
            // InternalDefinitionLanguage.g:606:1: ruleAndExpressionRule EOF
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
    // InternalDefinitionLanguage.g:613:1: ruleAndExpressionRule : ( ( rule__AndExpressionRule__Group__0 ) ) ;
    public final void ruleAndExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:617:2: ( ( ( rule__AndExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:618:2: ( ( rule__AndExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:618:2: ( ( rule__AndExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:619:3: ( rule__AndExpressionRule__Group__0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:620:3: ( rule__AndExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:620:4: rule__AndExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:629:1: entryRuleNotExpressionRule : ruleNotExpressionRule EOF ;
    public final void entryRuleNotExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:630:1: ( ruleNotExpressionRule EOF )
            // InternalDefinitionLanguage.g:631:1: ruleNotExpressionRule EOF
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
    // InternalDefinitionLanguage.g:638:1: ruleNotExpressionRule : ( ( rule__NotExpressionRule__Group__0 ) ) ;
    public final void ruleNotExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:642:2: ( ( ( rule__NotExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:643:2: ( ( rule__NotExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:643:2: ( ( rule__NotExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:644:3: ( rule__NotExpressionRule__Group__0 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:645:3: ( rule__NotExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:645:4: rule__NotExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:654:1: entryRuleComparisonExpressionRule : ruleComparisonExpressionRule EOF ;
    public final void entryRuleComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:655:1: ( ruleComparisonExpressionRule EOF )
            // InternalDefinitionLanguage.g:656:1: ruleComparisonExpressionRule EOF
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
    // InternalDefinitionLanguage.g:663:1: ruleComparisonExpressionRule : ( ( rule__ComparisonExpressionRule__Group__0 ) ) ;
    public final void ruleComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:667:2: ( ( ( rule__ComparisonExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:668:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:668:2: ( ( rule__ComparisonExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:669:3: ( rule__ComparisonExpressionRule__Group__0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:670:3: ( rule__ComparisonExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:670:4: rule__ComparisonExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:679:1: entryRulePartialComparisonExpressionRule : rulePartialComparisonExpressionRule EOF ;
    public final void entryRulePartialComparisonExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:680:1: ( rulePartialComparisonExpressionRule EOF )
            // InternalDefinitionLanguage.g:681:1: rulePartialComparisonExpressionRule EOF
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
    // InternalDefinitionLanguage.g:688:1: rulePartialComparisonExpressionRule : ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) ;
    public final void rulePartialComparisonExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:692:2: ( ( ( rule__PartialComparisonExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:693:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:693:2: ( ( rule__PartialComparisonExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:694:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:695:3: ( rule__PartialComparisonExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:695:4: rule__PartialComparisonExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:704:1: entryRuleAddOrSubtractExpressionRule : ruleAddOrSubtractExpressionRule EOF ;
    public final void entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:705:1: ( ruleAddOrSubtractExpressionRule EOF )
            // InternalDefinitionLanguage.g:706:1: ruleAddOrSubtractExpressionRule EOF
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
    // InternalDefinitionLanguage.g:713:1: ruleAddOrSubtractExpressionRule : ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:717:2: ( ( ( rule__AddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:718:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:718:2: ( ( rule__AddOrSubtractExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:719:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:720:3: ( rule__AddOrSubtractExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:720:4: rule__AddOrSubtractExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:729:1: entryRuleMultiplyDivideModuloExpressionRule : ruleMultiplyDivideModuloExpressionRule EOF ;
    public final void entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:730:1: ( ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDefinitionLanguage.g:731:1: ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalDefinitionLanguage.g:738:1: ruleMultiplyDivideModuloExpressionRule : ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) ;
    public final void ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:742:2: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:743:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:743:2: ( ( rule__MultiplyDivideModuloExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:744:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:745:3: ( rule__MultiplyDivideModuloExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:745:4: rule__MultiplyDivideModuloExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:754:1: entryRulePowerOfExpressionRule : rulePowerOfExpressionRule EOF ;
    public final void entryRulePowerOfExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:755:1: ( rulePowerOfExpressionRule EOF )
            // InternalDefinitionLanguage.g:756:1: rulePowerOfExpressionRule EOF
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
    // InternalDefinitionLanguage.g:763:1: rulePowerOfExpressionRule : ( ( rule__PowerOfExpressionRule__Group__0 ) ) ;
    public final void rulePowerOfExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:767:2: ( ( ( rule__PowerOfExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:768:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:768:2: ( ( rule__PowerOfExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:769:3: ( rule__PowerOfExpressionRule__Group__0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:770:3: ( rule__PowerOfExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:770:4: rule__PowerOfExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:779:1: entryRuleUnaryAddOrSubtractExpressionRule : ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final void entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:780:1: ( ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDefinitionLanguage.g:781:1: ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalDefinitionLanguage.g:788:1: ruleUnaryAddOrSubtractExpressionRule : ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) ;
    public final void ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:792:2: ( ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:793:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:793:2: ( ( rule__UnaryAddOrSubtractExpressionRule__Group__0 ) )
            // InternalDefinitionLanguage.g:794:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:795:3: ( rule__UnaryAddOrSubtractExpressionRule__Group__0 )
            // InternalDefinitionLanguage.g:795:4: rule__UnaryAddOrSubtractExpressionRule__Group__0
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
    // InternalDefinitionLanguage.g:804:1: entryRuleLiteralOrReferenceRule : ruleLiteralOrReferenceRule EOF ;
    public final void entryRuleLiteralOrReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:805:1: ( ruleLiteralOrReferenceRule EOF )
            // InternalDefinitionLanguage.g:806:1: ruleLiteralOrReferenceRule EOF
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
    // InternalDefinitionLanguage.g:813:1: ruleLiteralOrReferenceRule : ( ( rule__LiteralOrReferenceRule__Alternatives ) ) ;
    public final void ruleLiteralOrReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:817:2: ( ( ( rule__LiteralOrReferenceRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:818:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:818:2: ( ( rule__LiteralOrReferenceRule__Alternatives ) )
            // InternalDefinitionLanguage.g:819:3: ( rule__LiteralOrReferenceRule__Alternatives )
            {
             before(grammarAccess.getLiteralOrReferenceRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:820:3: ( rule__LiteralOrReferenceRule__Alternatives )
            // InternalDefinitionLanguage.g:820:4: rule__LiteralOrReferenceRule__Alternatives
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
    // InternalDefinitionLanguage.g:829:1: entryRuleParanthesesRule : ruleParanthesesRule EOF ;
    public final void entryRuleParanthesesRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:830:1: ( ruleParanthesesRule EOF )
            // InternalDefinitionLanguage.g:831:1: ruleParanthesesRule EOF
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
    // InternalDefinitionLanguage.g:838:1: ruleParanthesesRule : ( ( rule__ParanthesesRule__Group__0 ) ) ;
    public final void ruleParanthesesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:842:2: ( ( ( rule__ParanthesesRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:843:2: ( ( rule__ParanthesesRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:843:2: ( ( rule__ParanthesesRule__Group__0 ) )
            // InternalDefinitionLanguage.g:844:3: ( rule__ParanthesesRule__Group__0 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:845:3: ( rule__ParanthesesRule__Group__0 )
            // InternalDefinitionLanguage.g:845:4: rule__ParanthesesRule__Group__0
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
    // InternalDefinitionLanguage.g:854:1: entryRuleCallRule : ruleCallRule EOF ;
    public final void entryRuleCallRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:855:1: ( ruleCallRule EOF )
            // InternalDefinitionLanguage.g:856:1: ruleCallRule EOF
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
    // InternalDefinitionLanguage.g:863:1: ruleCallRule : ( ( rule__CallRule__Group__0 ) ) ;
    public final void ruleCallRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:867:2: ( ( ( rule__CallRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:868:2: ( ( rule__CallRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:868:2: ( ( rule__CallRule__Group__0 ) )
            // InternalDefinitionLanguage.g:869:3: ( rule__CallRule__Group__0 )
            {
             before(grammarAccess.getCallRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:870:3: ( rule__CallRule__Group__0 )
            // InternalDefinitionLanguage.g:870:4: rule__CallRule__Group__0
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
    // InternalDefinitionLanguage.g:879:1: entryRuleValueReferenceRule : ruleValueReferenceRule EOF ;
    public final void entryRuleValueReferenceRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:880:1: ( ruleValueReferenceRule EOF )
            // InternalDefinitionLanguage.g:881:1: ruleValueReferenceRule EOF
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
    // InternalDefinitionLanguage.g:888:1: ruleValueReferenceRule : ( ( rule__ValueReferenceRule__Group__0 ) ) ;
    public final void ruleValueReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:892:2: ( ( ( rule__ValueReferenceRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:893:2: ( ( rule__ValueReferenceRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:893:2: ( ( rule__ValueReferenceRule__Group__0 ) )
            // InternalDefinitionLanguage.g:894:3: ( rule__ValueReferenceRule__Group__0 )
            {
             before(grammarAccess.getValueReferenceRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:895:3: ( rule__ValueReferenceRule__Group__0 )
            // InternalDefinitionLanguage.g:895:4: rule__ValueReferenceRule__Group__0
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
    // InternalDefinitionLanguage.g:904:1: entryRuleLiteralRule : ruleLiteralRule EOF ;
    public final void entryRuleLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:905:1: ( ruleLiteralRule EOF )
            // InternalDefinitionLanguage.g:906:1: ruleLiteralRule EOF
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
    // InternalDefinitionLanguage.g:913:1: ruleLiteralRule : ( ( rule__LiteralRule__Alternatives ) ) ;
    public final void ruleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:917:2: ( ( ( rule__LiteralRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:918:2: ( ( rule__LiteralRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:918:2: ( ( rule__LiteralRule__Alternatives ) )
            // InternalDefinitionLanguage.g:919:3: ( rule__LiteralRule__Alternatives )
            {
             before(grammarAccess.getLiteralRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:920:3: ( rule__LiteralRule__Alternatives )
            // InternalDefinitionLanguage.g:920:4: rule__LiteralRule__Alternatives
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
    // InternalDefinitionLanguage.g:929:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:930:1: ( ruleNumberLiteralRule EOF )
            // InternalDefinitionLanguage.g:931:1: ruleNumberLiteralRule EOF
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
    // InternalDefinitionLanguage.g:938:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:942:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:943:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:943:2: ( ( rule__NumberLiteralRule__Alternatives ) )
            // InternalDefinitionLanguage.g:944:3: ( rule__NumberLiteralRule__Alternatives )
            {
             before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:945:3: ( rule__NumberLiteralRule__Alternatives )
            // InternalDefinitionLanguage.g:945:4: rule__NumberLiteralRule__Alternatives
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
    // InternalDefinitionLanguage.g:954:1: entryRuleDoubleLiteralRule : ruleDoubleLiteralRule EOF ;
    public final void entryRuleDoubleLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:955:1: ( ruleDoubleLiteralRule EOF )
            // InternalDefinitionLanguage.g:956:1: ruleDoubleLiteralRule EOF
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
    // InternalDefinitionLanguage.g:963:1: ruleDoubleLiteralRule : ( ( rule__DoubleLiteralRule__ValueAssignment ) ) ;
    public final void ruleDoubleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:967:2: ( ( ( rule__DoubleLiteralRule__ValueAssignment ) ) )
            // InternalDefinitionLanguage.g:968:2: ( ( rule__DoubleLiteralRule__ValueAssignment ) )
            {
            // InternalDefinitionLanguage.g:968:2: ( ( rule__DoubleLiteralRule__ValueAssignment ) )
            // InternalDefinitionLanguage.g:969:3: ( rule__DoubleLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getValueAssignment()); 
            // InternalDefinitionLanguage.g:970:3: ( rule__DoubleLiteralRule__ValueAssignment )
            // InternalDefinitionLanguage.g:970:4: rule__DoubleLiteralRule__ValueAssignment
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
    // InternalDefinitionLanguage.g:979:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:980:1: ( ruleIntegerLiteralRule EOF )
            // InternalDefinitionLanguage.g:981:1: ruleIntegerLiteralRule EOF
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
    // InternalDefinitionLanguage.g:988:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__ValueAssignment ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:992:2: ( ( ( rule__IntegerLiteralRule__ValueAssignment ) ) )
            // InternalDefinitionLanguage.g:993:2: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            {
            // InternalDefinitionLanguage.g:993:2: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            // InternalDefinitionLanguage.g:994:3: ( rule__IntegerLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getValueAssignment()); 
            // InternalDefinitionLanguage.g:995:3: ( rule__IntegerLiteralRule__ValueAssignment )
            // InternalDefinitionLanguage.g:995:4: rule__IntegerLiteralRule__ValueAssignment
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
    // InternalDefinitionLanguage.g:1004:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1005:1: ( ruleStringLiteralRule EOF )
            // InternalDefinitionLanguage.g:1006:1: ruleStringLiteralRule EOF
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
    // InternalDefinitionLanguage.g:1013:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1017:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // InternalDefinitionLanguage.g:1018:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // InternalDefinitionLanguage.g:1018:2: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // InternalDefinitionLanguage.g:1019:3: ( rule__StringLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            // InternalDefinitionLanguage.g:1020:3: ( rule__StringLiteralRule__ValueAssignment )
            // InternalDefinitionLanguage.g:1020:4: rule__StringLiteralRule__ValueAssignment
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
    // InternalDefinitionLanguage.g:1029:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1030:1: ( ruleBooleanLiteralRule EOF )
            // InternalDefinitionLanguage.g:1031:1: ruleBooleanLiteralRule EOF
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
    // InternalDefinitionLanguage.g:1038:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__Group__0 ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1042:2: ( ( ( rule__BooleanLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1043:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1043:2: ( ( rule__BooleanLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:1044:3: ( rule__BooleanLiteralRule__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:1045:3: ( rule__BooleanLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:1045:4: rule__BooleanLiteralRule__Group__0
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
    // InternalDefinitionLanguage.g:1054:1: entryRuleStringOrId : ruleStringOrId EOF ;
    public final void entryRuleStringOrId() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1055:1: ( ruleStringOrId EOF )
            // InternalDefinitionLanguage.g:1056:1: ruleStringOrId EOF
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
    // InternalDefinitionLanguage.g:1063:1: ruleStringOrId : ( ( rule__StringOrId__Alternatives ) ) ;
    public final void ruleStringOrId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1067:2: ( ( ( rule__StringOrId__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1068:2: ( ( rule__StringOrId__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1068:2: ( ( rule__StringOrId__Alternatives ) )
            // InternalDefinitionLanguage.g:1069:3: ( rule__StringOrId__Alternatives )
            {
             before(grammarAccess.getStringOrIdAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:1070:3: ( rule__StringOrId__Alternatives )
            // InternalDefinitionLanguage.g:1070:4: rule__StringOrId__Alternatives
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
    // InternalDefinitionLanguage.g:1079:1: entryRuleDOUBLE : ruleDOUBLE EOF ;
    public final void entryRuleDOUBLE() throws RecognitionException {
        try {
            // InternalDefinitionLanguage.g:1080:1: ( ruleDOUBLE EOF )
            // InternalDefinitionLanguage.g:1081:1: ruleDOUBLE EOF
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
    // InternalDefinitionLanguage.g:1088:1: ruleDOUBLE : ( ( rule__DOUBLE__Group__0 ) ) ;
    public final void ruleDOUBLE() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1092:2: ( ( ( rule__DOUBLE__Group__0 ) ) )
            // InternalDefinitionLanguage.g:1093:2: ( ( rule__DOUBLE__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:1093:2: ( ( rule__DOUBLE__Group__0 ) )
            // InternalDefinitionLanguage.g:1094:3: ( rule__DOUBLE__Group__0 )
            {
             before(grammarAccess.getDOUBLEAccess().getGroup()); 
            // InternalDefinitionLanguage.g:1095:3: ( rule__DOUBLE__Group__0 )
            // InternalDefinitionLanguage.g:1095:4: rule__DOUBLE__Group__0
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
    // InternalDefinitionLanguage.g:1104:1: ruleComparisonOperatorRule : ( ( rule__ComparisonOperatorRule__Alternatives ) ) ;
    public final void ruleComparisonOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1108:1: ( ( ( rule__ComparisonOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1109:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1109:2: ( ( rule__ComparisonOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1110:3: ( rule__ComparisonOperatorRule__Alternatives )
            {
             before(grammarAccess.getComparisonOperatorRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:1111:3: ( rule__ComparisonOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1111:4: rule__ComparisonOperatorRule__Alternatives
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
    // InternalDefinitionLanguage.g:1120:1: ruleAddOrSubtractOperatorRule : ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) ;
    public final void ruleAddOrSubtractOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1124:1: ( ( ( rule__AddOrSubtractOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1125:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1125:2: ( ( rule__AddOrSubtractOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1126:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            {
             before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:1127:3: ( rule__AddOrSubtractOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1127:4: rule__AddOrSubtractOperatorRule__Alternatives
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
    // InternalDefinitionLanguage.g:1136:1: ruleMultiplyDivideModuloOperatorRule : ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) ;
    public final void ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1140:1: ( ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1141:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1141:2: ( ( rule__MultiplyDivideModuloOperatorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1142:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            {
             before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:1143:3: ( rule__MultiplyDivideModuloOperatorRule__Alternatives )
            // InternalDefinitionLanguage.g:1143:4: rule__MultiplyDivideModuloOperatorRule__Alternatives
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


    // $ANTLR start "rule__DefinitionModelRule__Alternatives"
    // InternalDefinitionLanguage.g:1151:1: rule__DefinitionModelRule__Alternatives : ( ( ( rule__DefinitionModelRule__TypesAssignment_0 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_1 ) ) );
    public final void rule__DefinitionModelRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1155:1: ( ( ( rule__DefinitionModelRule__TypesAssignment_0 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==24||LA2_0==52) ) {
                alt2=1;
            }
            else if ( (LA2_0==42) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalDefinitionLanguage.g:1156:2: ( ( rule__DefinitionModelRule__TypesAssignment_0 ) )
                    {
                    // InternalDefinitionLanguage.g:1156:2: ( ( rule__DefinitionModelRule__TypesAssignment_0 ) )
                    // InternalDefinitionLanguage.g:1157:3: ( rule__DefinitionModelRule__TypesAssignment_0 )
                    {
                     before(grammarAccess.getDefinitionModelRuleAccess().getTypesAssignment_0()); 
                    // InternalDefinitionLanguage.g:1158:3: ( rule__DefinitionModelRule__TypesAssignment_0 )
                    // InternalDefinitionLanguage.g:1158:4: rule__DefinitionModelRule__TypesAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DefinitionModelRule__TypesAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionModelRuleAccess().getTypesAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1162:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_1 ) )
                    {
                    // InternalDefinitionLanguage.g:1162:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_1 ) )
                    // InternalDefinitionLanguage.g:1163:3: ( rule__DefinitionModelRule__FunctionsAssignment_1 )
                    {
                     before(grammarAccess.getDefinitionModelRuleAccess().getFunctionsAssignment_1()); 
                    // InternalDefinitionLanguage.g:1164:3: ( rule__DefinitionModelRule__FunctionsAssignment_1 )
                    // InternalDefinitionLanguage.g:1164:4: rule__DefinitionModelRule__FunctionsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DefinitionModelRule__FunctionsAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionModelRuleAccess().getFunctionsAssignment_1()); 

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
    // $ANTLR end "rule__DefinitionModelRule__Alternatives"


    // $ANTLR start "rule__AttributeDefinitionRule__Alternatives"
    // InternalDefinitionLanguage.g:1172:1: rule__AttributeDefinitionRule__Alternatives : ( ( ruleNamedAttributeDefinitionRule ) | ( ruleUnnamedAttributeDefinitionRule ) );
    public final void rule__AttributeDefinitionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1176:1: ( ( ruleNamedAttributeDefinitionRule ) | ( ruleUnnamedAttributeDefinitionRule ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_QUOTED_ID && LA3_0<=RULE_ID)) ) {
                alt3=1;
            }
            else if ( (LA3_0==28) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalDefinitionLanguage.g:1177:2: ( ruleNamedAttributeDefinitionRule )
                    {
                    // InternalDefinitionLanguage.g:1177:2: ( ruleNamedAttributeDefinitionRule )
                    // InternalDefinitionLanguage.g:1178:3: ruleNamedAttributeDefinitionRule
                    {
                     before(grammarAccess.getAttributeDefinitionRuleAccess().getNamedAttributeDefinitionRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNamedAttributeDefinitionRule();

                    state._fsp--;

                     after(grammarAccess.getAttributeDefinitionRuleAccess().getNamedAttributeDefinitionRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1183:2: ( ruleUnnamedAttributeDefinitionRule )
                    {
                    // InternalDefinitionLanguage.g:1183:2: ( ruleUnnamedAttributeDefinitionRule )
                    // InternalDefinitionLanguage.g:1184:3: ruleUnnamedAttributeDefinitionRule
                    {
                     before(grammarAccess.getAttributeDefinitionRuleAccess().getUnnamedAttributeDefinitionRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleUnnamedAttributeDefinitionRule();

                    state._fsp--;

                     after(grammarAccess.getAttributeDefinitionRuleAccess().getUnnamedAttributeDefinitionRuleParserRuleCall_1()); 

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
    // $ANTLR end "rule__AttributeDefinitionRule__Alternatives"


    // $ANTLR start "rule__TypeRule__Alternatives"
    // InternalDefinitionLanguage.g:1193:1: rule__TypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1197:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) )
            int alt4=10;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt4=1;
                }
                break;
            case 36:
                {
                alt4=2;
                }
                break;
            case 37:
                {
                alt4=3;
                }
                break;
            case 38:
                {
                alt4=4;
                }
                break;
            case 31:
                {
                alt4=5;
                }
                break;
            case 41:
                {
                alt4=6;
                }
                break;
            case 32:
                {
                alt4=7;
                }
                break;
            case 39:
                {
                alt4=8;
                }
                break;
            case 35:
                {
                alt4=9;
                }
                break;
            case 40:
                {
                alt4=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalDefinitionLanguage.g:1198:2: ( ruleStringTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1198:2: ( ruleStringTypeRule )
                    // InternalDefinitionLanguage.g:1199:3: ruleStringTypeRule
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
                    // InternalDefinitionLanguage.g:1204:2: ( ruleIntTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1204:2: ( ruleIntTypeRule )
                    // InternalDefinitionLanguage.g:1205:3: ruleIntTypeRule
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
                    // InternalDefinitionLanguage.g:1210:2: ( ruleFloatTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1210:2: ( ruleFloatTypeRule )
                    // InternalDefinitionLanguage.g:1211:3: ruleFloatTypeRule
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
                    // InternalDefinitionLanguage.g:1216:2: ( ruleBooleanTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1216:2: ( ruleBooleanTypeRule )
                    // InternalDefinitionLanguage.g:1217:3: ruleBooleanTypeRule
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
                    // InternalDefinitionLanguage.g:1222:2: ( ruleLiteralTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1222:2: ( ruleLiteralTypeRule )
                    // InternalDefinitionLanguage.g:1223:3: ruleLiteralTypeRule
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
                    // InternalDefinitionLanguage.g:1228:2: ( ruleArrayTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1228:2: ( ruleArrayTypeRule )
                    // InternalDefinitionLanguage.g:1229:3: ruleArrayTypeRule
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
                    // InternalDefinitionLanguage.g:1234:2: ( ruleInstanceTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1234:2: ( ruleInstanceTypeRule )
                    // InternalDefinitionLanguage.g:1235:3: ruleInstanceTypeRule
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
                    // InternalDefinitionLanguage.g:1240:2: ( ruleVoidTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1240:2: ( ruleVoidTypeRule )
                    // InternalDefinitionLanguage.g:1241:3: ruleVoidTypeRule
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
                    // InternalDefinitionLanguage.g:1246:2: ( ruleExpressionTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1246:2: ( ruleExpressionTypeRule )
                    // InternalDefinitionLanguage.g:1247:3: ruleExpressionTypeRule
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
                    // InternalDefinitionLanguage.g:1252:2: ( ruleDataTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1252:2: ( ruleDataTypeRule )
                    // InternalDefinitionLanguage.g:1253:3: ruleDataTypeRule
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


    // $ANTLR start "rule__LiteralOrReferenceRule__Alternatives"
    // InternalDefinitionLanguage.g:1262:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );
    public final void rule__LiteralOrReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1266:1: ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 12:
            case 54:
                {
                alt5=2;
                }
                break;
            case 43:
                {
                alt5=3;
                }
                break;
            case 50:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalDefinitionLanguage.g:1267:2: ( ruleCallRule )
                    {
                    // InternalDefinitionLanguage.g:1267:2: ( ruleCallRule )
                    // InternalDefinitionLanguage.g:1268:3: ruleCallRule
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
                    // InternalDefinitionLanguage.g:1273:2: ( ruleLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1273:2: ( ruleLiteralRule )
                    // InternalDefinitionLanguage.g:1274:3: ruleLiteralRule
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
                    // InternalDefinitionLanguage.g:1279:2: ( ruleParanthesesRule )
                    {
                    // InternalDefinitionLanguage.g:1279:2: ( ruleParanthesesRule )
                    // InternalDefinitionLanguage.g:1280:3: ruleParanthesesRule
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
                    // InternalDefinitionLanguage.g:1285:2: ( ruleValueReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1285:2: ( ruleValueReferenceRule )
                    // InternalDefinitionLanguage.g:1286:3: ruleValueReferenceRule
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
    // InternalDefinitionLanguage.g:1295:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1299:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) )
            int alt6=3;
            switch ( input.LA(1) ) {
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
            case 12:
            case 54:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalDefinitionLanguage.g:1300:2: ( ruleNumberLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1300:2: ( ruleNumberLiteralRule )
                    // InternalDefinitionLanguage.g:1301:3: ruleNumberLiteralRule
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
                    // InternalDefinitionLanguage.g:1306:2: ( ruleStringLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1306:2: ( ruleStringLiteralRule )
                    // InternalDefinitionLanguage.g:1307:3: ruleStringLiteralRule
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
                    // InternalDefinitionLanguage.g:1312:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1312:2: ( ruleBooleanLiteralRule )
                    // InternalDefinitionLanguage.g:1313:3: ruleBooleanLiteralRule
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
    // InternalDefinitionLanguage.g:1322:1: rule__NumberLiteralRule__Alternatives : ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1326:1: ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_INT) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==51) ) {
                    alt7=1;
                }
                else if ( (LA7_1==EOF||(LA7_1>=13 && LA7_1<=23)||(LA7_1>=44 && LA7_1<=49)) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalDefinitionLanguage.g:1327:2: ( ruleDoubleLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1327:2: ( ruleDoubleLiteralRule )
                    // InternalDefinitionLanguage.g:1328:3: ruleDoubleLiteralRule
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
                    // InternalDefinitionLanguage.g:1333:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1333:2: ( ruleIntegerLiteralRule )
                    // InternalDefinitionLanguage.g:1334:3: ruleIntegerLiteralRule
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
    // InternalDefinitionLanguage.g:1343:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1347:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==54) ) {
                alt8=1;
            }
            else if ( (LA8_0==12) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalDefinitionLanguage.g:1348:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalDefinitionLanguage.g:1348:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalDefinitionLanguage.g:1349:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                     before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    // InternalDefinitionLanguage.g:1350:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalDefinitionLanguage.g:1350:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalDefinitionLanguage.g:1354:2: ( 'false' )
                    {
                    // InternalDefinitionLanguage.g:1354:2: ( 'false' )
                    // InternalDefinitionLanguage.g:1355:3: 'false'
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
    // InternalDefinitionLanguage.g:1364:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1368:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_QUOTED_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalDefinitionLanguage.g:1369:2: ( RULE_QUOTED_ID )
                    {
                    // InternalDefinitionLanguage.g:1369:2: ( RULE_QUOTED_ID )
                    // InternalDefinitionLanguage.g:1370:3: RULE_QUOTED_ID
                    {
                     before(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 
                    match(input,RULE_QUOTED_ID,FOLLOW_2); 
                     after(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1375:2: ( RULE_ID )
                    {
                    // InternalDefinitionLanguage.g:1375:2: ( RULE_ID )
                    // InternalDefinitionLanguage.g:1376:3: RULE_ID
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
    // InternalDefinitionLanguage.g:1385:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1389:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt10=6;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt10=1;
                }
                break;
            case 14:
                {
                alt10=2;
                }
                break;
            case 15:
                {
                alt10=3;
                }
                break;
            case 16:
                {
                alt10=4;
                }
                break;
            case 17:
                {
                alt10=5;
                }
                break;
            case 18:
                {
                alt10=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalDefinitionLanguage.g:1390:2: ( ( '>=' ) )
                    {
                    // InternalDefinitionLanguage.g:1390:2: ( ( '>=' ) )
                    // InternalDefinitionLanguage.g:1391:3: ( '>=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1392:3: ( '>=' )
                    // InternalDefinitionLanguage.g:1392:4: '>='
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1396:2: ( ( '>' ) )
                    {
                    // InternalDefinitionLanguage.g:1396:2: ( ( '>' ) )
                    // InternalDefinitionLanguage.g:1397:3: ( '>' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1398:3: ( '>' )
                    // InternalDefinitionLanguage.g:1398:4: '>'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1402:2: ( ( '=' ) )
                    {
                    // InternalDefinitionLanguage.g:1402:2: ( ( '=' ) )
                    // InternalDefinitionLanguage.g:1403:3: ( '=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    // InternalDefinitionLanguage.g:1404:3: ( '=' )
                    // InternalDefinitionLanguage.g:1404:4: '='
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:1408:2: ( ( '!=' ) )
                    {
                    // InternalDefinitionLanguage.g:1408:2: ( ( '!=' ) )
                    // InternalDefinitionLanguage.g:1409:3: ( '!=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    // InternalDefinitionLanguage.g:1410:3: ( '!=' )
                    // InternalDefinitionLanguage.g:1410:4: '!='
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:1414:2: ( ( '<' ) )
                    {
                    // InternalDefinitionLanguage.g:1414:2: ( ( '<' ) )
                    // InternalDefinitionLanguage.g:1415:3: ( '<' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    // InternalDefinitionLanguage.g:1416:3: ( '<' )
                    // InternalDefinitionLanguage.g:1416:4: '<'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:1420:2: ( ( '<=' ) )
                    {
                    // InternalDefinitionLanguage.g:1420:2: ( ( '<=' ) )
                    // InternalDefinitionLanguage.g:1421:3: ( '<=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    // InternalDefinitionLanguage.g:1422:3: ( '<=' )
                    // InternalDefinitionLanguage.g:1422:4: '<='
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
    // InternalDefinitionLanguage.g:1430:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1434:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            else if ( (LA11_0==20) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalDefinitionLanguage.g:1435:2: ( ( '+' ) )
                    {
                    // InternalDefinitionLanguage.g:1435:2: ( ( '+' ) )
                    // InternalDefinitionLanguage.g:1436:3: ( '+' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1437:3: ( '+' )
                    // InternalDefinitionLanguage.g:1437:4: '+'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1441:2: ( ( '-' ) )
                    {
                    // InternalDefinitionLanguage.g:1441:2: ( ( '-' ) )
                    // InternalDefinitionLanguage.g:1442:3: ( '-' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1443:3: ( '-' )
                    // InternalDefinitionLanguage.g:1443:4: '-'
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
    // InternalDefinitionLanguage.g:1451:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1455:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt12=1;
                }
                break;
            case 22:
                {
                alt12=2;
                }
                break;
            case 23:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalDefinitionLanguage.g:1456:2: ( ( '*' ) )
                    {
                    // InternalDefinitionLanguage.g:1456:2: ( ( '*' ) )
                    // InternalDefinitionLanguage.g:1457:3: ( '*' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1458:3: ( '*' )
                    // InternalDefinitionLanguage.g:1458:4: '*'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1462:2: ( ( '/' ) )
                    {
                    // InternalDefinitionLanguage.g:1462:2: ( ( '/' ) )
                    // InternalDefinitionLanguage.g:1463:3: ( '/' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1464:3: ( '/' )
                    // InternalDefinitionLanguage.g:1464:4: '/'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1468:2: ( ( '%' ) )
                    {
                    // InternalDefinitionLanguage.g:1468:2: ( ( '%' ) )
                    // InternalDefinitionLanguage.g:1469:3: ( '%' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    // InternalDefinitionLanguage.g:1470:3: ( '%' )
                    // InternalDefinitionLanguage.g:1470:4: '%'
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


    // $ANTLR start "rule__TypeDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:1478:1: rule__TypeDefinitionRule__Group__0 : rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1 ;
    public final void rule__TypeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1482:1: ( rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:1483:2: rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__TypeDefinitionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__1();

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
    // $ANTLR end "rule__TypeDefinitionRule__Group__0"


    // $ANTLR start "rule__TypeDefinitionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:1490:1: rule__TypeDefinitionRule__Group__0__Impl : ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? ) ;
    public final void rule__TypeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1494:1: ( ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? ) )
            // InternalDefinitionLanguage.g:1495:1: ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? )
            {
            // InternalDefinitionLanguage.g:1495:1: ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? )
            // InternalDefinitionLanguage.g:1496:2: ( rule__TypeDefinitionRule__AbstractAssignment_0 )?
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAssignment_0()); 
            // InternalDefinitionLanguage.g:1497:2: ( rule__TypeDefinitionRule__AbstractAssignment_0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==52) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDefinitionLanguage.g:1497:3: rule__TypeDefinitionRule__AbstractAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeDefinitionRule__AbstractAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAssignment_0()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:1505:1: rule__TypeDefinitionRule__Group__1 : rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2 ;
    public final void rule__TypeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1509:1: ( rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:1510:2: rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__TypeDefinitionRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__2();

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
    // $ANTLR end "rule__TypeDefinitionRule__Group__1"


    // $ANTLR start "rule__TypeDefinitionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:1517:1: rule__TypeDefinitionRule__Group__1__Impl : ( 'type' ) ;
    public final void rule__TypeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1521:1: ( ( 'type' ) )
            // InternalDefinitionLanguage.g:1522:1: ( 'type' )
            {
            // InternalDefinitionLanguage.g:1522:1: ( 'type' )
            // InternalDefinitionLanguage.g:1523:2: 'type'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getTypeKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getTypeDefinitionRuleAccess().getTypeKeyword_1()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:1532:1: rule__TypeDefinitionRule__Group__2 : rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3 ;
    public final void rule__TypeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1536:1: ( rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:1537:2: rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__TypeDefinitionRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__3();

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
    // $ANTLR end "rule__TypeDefinitionRule__Group__2"


    // $ANTLR start "rule__TypeDefinitionRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:1544:1: rule__TypeDefinitionRule__Group__2__Impl : ( ( rule__TypeDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__TypeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1548:1: ( ( ( rule__TypeDefinitionRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:1549:1: ( ( rule__TypeDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:1549:1: ( ( rule__TypeDefinitionRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:1550:2: ( rule__TypeDefinitionRule__NameAssignment_2 )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getNameAssignment_2()); 
            // InternalDefinitionLanguage.g:1551:2: ( rule__TypeDefinitionRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:1551:3: rule__TypeDefinitionRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:1559:1: rule__TypeDefinitionRule__Group__3 : rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4 ;
    public final void rule__TypeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1563:1: ( rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:1564:2: rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__TypeDefinitionRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__4();

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
    // $ANTLR end "rule__TypeDefinitionRule__Group__3"


    // $ANTLR start "rule__TypeDefinitionRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:1571:1: rule__TypeDefinitionRule__Group__3__Impl : ( ( rule__TypeDefinitionRule__Group_3__0 )? ) ;
    public final void rule__TypeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1575:1: ( ( ( rule__TypeDefinitionRule__Group_3__0 )? ) )
            // InternalDefinitionLanguage.g:1576:1: ( ( rule__TypeDefinitionRule__Group_3__0 )? )
            {
            // InternalDefinitionLanguage.g:1576:1: ( ( rule__TypeDefinitionRule__Group_3__0 )? )
            // InternalDefinitionLanguage.g:1577:2: ( rule__TypeDefinitionRule__Group_3__0 )?
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getGroup_3()); 
            // InternalDefinitionLanguage.g:1578:2: ( rule__TypeDefinitionRule__Group_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDefinitionLanguage.g:1578:3: rule__TypeDefinitionRule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeDefinitionRule__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getGroup_3()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:1586:1: rule__TypeDefinitionRule__Group__4 : rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5 ;
    public final void rule__TypeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1590:1: ( rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:1591:2: rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__TypeDefinitionRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__5();

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
    // $ANTLR end "rule__TypeDefinitionRule__Group__4"


    // $ANTLR start "rule__TypeDefinitionRule__Group__4__Impl"
    // InternalDefinitionLanguage.g:1598:1: rule__TypeDefinitionRule__Group__4__Impl : ( '{' ) ;
    public final void rule__TypeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1602:1: ( ( '{' ) )
            // InternalDefinitionLanguage.g:1603:1: ( '{' )
            {
            // InternalDefinitionLanguage.g:1603:1: ( '{' )
            // InternalDefinitionLanguage.g:1604:2: '{'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getTypeDefinitionRuleAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:1613:1: rule__TypeDefinitionRule__Group__5 : rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6 ;
    public final void rule__TypeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1617:1: ( rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:1618:2: rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__TypeDefinitionRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__6();

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
    // $ANTLR end "rule__TypeDefinitionRule__Group__5"


    // $ANTLR start "rule__TypeDefinitionRule__Group__5__Impl"
    // InternalDefinitionLanguage.g:1625:1: rule__TypeDefinitionRule__Group__5__Impl : ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* ) ;
    public final void rule__TypeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1629:1: ( ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* ) )
            // InternalDefinitionLanguage.g:1630:1: ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* )
            {
            // InternalDefinitionLanguage.g:1630:1: ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* )
            // InternalDefinitionLanguage.g:1631:2: ( rule__TypeDefinitionRule__AttributesAssignment_5 )*
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAssignment_5()); 
            // InternalDefinitionLanguage.g:1632:2: ( rule__TypeDefinitionRule__AttributesAssignment_5 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_QUOTED_ID && LA15_0<=RULE_ID)||LA15_0==28) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1632:3: rule__TypeDefinitionRule__AttributesAssignment_5
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__TypeDefinitionRule__AttributesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAssignment_5()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:1640:1: rule__TypeDefinitionRule__Group__6 : rule__TypeDefinitionRule__Group__6__Impl ;
    public final void rule__TypeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1644:1: ( rule__TypeDefinitionRule__Group__6__Impl )
            // InternalDefinitionLanguage.g:1645:2: rule__TypeDefinitionRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group__6__Impl();

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
    // $ANTLR end "rule__TypeDefinitionRule__Group__6"


    // $ANTLR start "rule__TypeDefinitionRule__Group__6__Impl"
    // InternalDefinitionLanguage.g:1651:1: rule__TypeDefinitionRule__Group__6__Impl : ( '}' ) ;
    public final void rule__TypeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1655:1: ( ( '}' ) )
            // InternalDefinitionLanguage.g:1656:1: ( '}' )
            {
            // InternalDefinitionLanguage.g:1656:1: ( '}' )
            // InternalDefinitionLanguage.g:1657:2: '}'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getRightCurlyBracketKeyword_6()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getTypeDefinitionRuleAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:1667:1: rule__TypeDefinitionRule__Group_3__0 : rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1 ;
    public final void rule__TypeDefinitionRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1671:1: ( rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1 )
            // InternalDefinitionLanguage.g:1672:2: rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__TypeDefinitionRule__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group_3__1();

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
    // $ANTLR end "rule__TypeDefinitionRule__Group_3__0"


    // $ANTLR start "rule__TypeDefinitionRule__Group_3__0__Impl"
    // InternalDefinitionLanguage.g:1679:1: rule__TypeDefinitionRule__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__TypeDefinitionRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1683:1: ( ( 'extends' ) )
            // InternalDefinitionLanguage.g:1684:1: ( 'extends' )
            {
            // InternalDefinitionLanguage.g:1684:1: ( 'extends' )
            // InternalDefinitionLanguage.g:1685:2: 'extends'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getExtendsKeyword_3_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getTypeDefinitionRuleAccess().getExtendsKeyword_3_0()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:1694:1: rule__TypeDefinitionRule__Group_3__1 : rule__TypeDefinitionRule__Group_3__1__Impl ;
    public final void rule__TypeDefinitionRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1698:1: ( rule__TypeDefinitionRule__Group_3__1__Impl )
            // InternalDefinitionLanguage.g:1699:2: rule__TypeDefinitionRule__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__Group_3__1__Impl();

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
    // $ANTLR end "rule__TypeDefinitionRule__Group_3__1"


    // $ANTLR start "rule__TypeDefinitionRule__Group_3__1__Impl"
    // InternalDefinitionLanguage.g:1705:1: rule__TypeDefinitionRule__Group_3__1__Impl : ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) ) ;
    public final void rule__TypeDefinitionRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1709:1: ( ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) ) )
            // InternalDefinitionLanguage.g:1710:1: ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) )
            {
            // InternalDefinitionLanguage.g:1710:1: ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) )
            // InternalDefinitionLanguage.g:1711:2: ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeAssignment_3_1()); 
            // InternalDefinitionLanguage.g:1712:2: ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 )
            // InternalDefinitionLanguage.g:1712:3: rule__TypeDefinitionRule__SuperTypeAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeDefinitionRule__SuperTypeAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeAssignment_3_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__UnnamedAttributeDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:1721:1: rule__UnnamedAttributeDefinitionRule__Group__0 : rule__UnnamedAttributeDefinitionRule__Group__0__Impl rule__UnnamedAttributeDefinitionRule__Group__1 ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1725:1: ( rule__UnnamedAttributeDefinitionRule__Group__0__Impl rule__UnnamedAttributeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:1726:2: rule__UnnamedAttributeDefinitionRule__Group__0__Impl rule__UnnamedAttributeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__UnnamedAttributeDefinitionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnnamedAttributeDefinitionRule__Group__1();

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
    // $ANTLR end "rule__UnnamedAttributeDefinitionRule__Group__0"


    // $ANTLR start "rule__UnnamedAttributeDefinitionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:1733:1: rule__UnnamedAttributeDefinitionRule__Group__0__Impl : ( 'unnamed' ) ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1737:1: ( ( 'unnamed' ) )
            // InternalDefinitionLanguage.g:1738:1: ( 'unnamed' )
            {
            // InternalDefinitionLanguage.g:1738:1: ( 'unnamed' )
            // InternalDefinitionLanguage.g:1739:2: 'unnamed'
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getUnnamedKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getUnnamedKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnnamedAttributeDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__UnnamedAttributeDefinitionRule__Group__1"
    // InternalDefinitionLanguage.g:1748:1: rule__UnnamedAttributeDefinitionRule__Group__1 : rule__UnnamedAttributeDefinitionRule__Group__1__Impl rule__UnnamedAttributeDefinitionRule__Group__2 ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1752:1: ( rule__UnnamedAttributeDefinitionRule__Group__1__Impl rule__UnnamedAttributeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:1753:2: rule__UnnamedAttributeDefinitionRule__Group__1__Impl rule__UnnamedAttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__UnnamedAttributeDefinitionRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnnamedAttributeDefinitionRule__Group__2();

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
    // $ANTLR end "rule__UnnamedAttributeDefinitionRule__Group__1"


    // $ANTLR start "rule__UnnamedAttributeDefinitionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:1760:1: rule__UnnamedAttributeDefinitionRule__Group__1__Impl : ( ':' ) ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1764:1: ( ( ':' ) )
            // InternalDefinitionLanguage.g:1765:1: ( ':' )
            {
            // InternalDefinitionLanguage.g:1765:1: ( ':' )
            // InternalDefinitionLanguage.g:1766:2: ':'
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getColonKeyword_1()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnnamedAttributeDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__UnnamedAttributeDefinitionRule__Group__2"
    // InternalDefinitionLanguage.g:1775:1: rule__UnnamedAttributeDefinitionRule__Group__2 : rule__UnnamedAttributeDefinitionRule__Group__2__Impl rule__UnnamedAttributeDefinitionRule__Group__3 ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1779:1: ( rule__UnnamedAttributeDefinitionRule__Group__2__Impl rule__UnnamedAttributeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:1780:2: rule__UnnamedAttributeDefinitionRule__Group__2__Impl rule__UnnamedAttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__UnnamedAttributeDefinitionRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnnamedAttributeDefinitionRule__Group__3();

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
    // $ANTLR end "rule__UnnamedAttributeDefinitionRule__Group__2"


    // $ANTLR start "rule__UnnamedAttributeDefinitionRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:1787:1: rule__UnnamedAttributeDefinitionRule__Group__2__Impl : ( ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 ) ) ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1791:1: ( ( ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:1792:1: ( ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:1792:1: ( ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 ) )
            // InternalDefinitionLanguage.g:1793:2: ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 )
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getTypeAssignment_2()); 
            // InternalDefinitionLanguage.g:1794:2: ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 )
            // InternalDefinitionLanguage.g:1794:3: rule__UnnamedAttributeDefinitionRule__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__UnnamedAttributeDefinitionRule__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnnamedAttributeDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__UnnamedAttributeDefinitionRule__Group__3"
    // InternalDefinitionLanguage.g:1802:1: rule__UnnamedAttributeDefinitionRule__Group__3 : rule__UnnamedAttributeDefinitionRule__Group__3__Impl ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1806:1: ( rule__UnnamedAttributeDefinitionRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:1807:2: rule__UnnamedAttributeDefinitionRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnnamedAttributeDefinitionRule__Group__3__Impl();

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
    // $ANTLR end "rule__UnnamedAttributeDefinitionRule__Group__3"


    // $ANTLR start "rule__UnnamedAttributeDefinitionRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:1813:1: rule__UnnamedAttributeDefinitionRule__Group__3__Impl : ( ';' ) ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1817:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:1818:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:1818:1: ( ';' )
            // InternalDefinitionLanguage.g:1819:2: ';'
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getSemicolonKeyword_3()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnnamedAttributeDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__NamedAttributeDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:1829:1: rule__NamedAttributeDefinitionRule__Group__0 : rule__NamedAttributeDefinitionRule__Group__0__Impl rule__NamedAttributeDefinitionRule__Group__1 ;
    public final void rule__NamedAttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1833:1: ( rule__NamedAttributeDefinitionRule__Group__0__Impl rule__NamedAttributeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:1834:2: rule__NamedAttributeDefinitionRule__Group__0__Impl rule__NamedAttributeDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__NamedAttributeDefinitionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NamedAttributeDefinitionRule__Group__1();

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
    // $ANTLR end "rule__NamedAttributeDefinitionRule__Group__0"


    // $ANTLR start "rule__NamedAttributeDefinitionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:1841:1: rule__NamedAttributeDefinitionRule__Group__0__Impl : ( ( rule__NamedAttributeDefinitionRule__NameAssignment_0 ) ) ;
    public final void rule__NamedAttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1845:1: ( ( ( rule__NamedAttributeDefinitionRule__NameAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:1846:1: ( ( rule__NamedAttributeDefinitionRule__NameAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:1846:1: ( ( rule__NamedAttributeDefinitionRule__NameAssignment_0 ) )
            // InternalDefinitionLanguage.g:1847:2: ( rule__NamedAttributeDefinitionRule__NameAssignment_0 )
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getNameAssignment_0()); 
            // InternalDefinitionLanguage.g:1848:2: ( rule__NamedAttributeDefinitionRule__NameAssignment_0 )
            // InternalDefinitionLanguage.g:1848:3: rule__NamedAttributeDefinitionRule__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__NamedAttributeDefinitionRule__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNamedAttributeDefinitionRuleAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedAttributeDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__NamedAttributeDefinitionRule__Group__1"
    // InternalDefinitionLanguage.g:1856:1: rule__NamedAttributeDefinitionRule__Group__1 : rule__NamedAttributeDefinitionRule__Group__1__Impl rule__NamedAttributeDefinitionRule__Group__2 ;
    public final void rule__NamedAttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1860:1: ( rule__NamedAttributeDefinitionRule__Group__1__Impl rule__NamedAttributeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:1861:2: rule__NamedAttributeDefinitionRule__Group__1__Impl rule__NamedAttributeDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__NamedAttributeDefinitionRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NamedAttributeDefinitionRule__Group__2();

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
    // $ANTLR end "rule__NamedAttributeDefinitionRule__Group__1"


    // $ANTLR start "rule__NamedAttributeDefinitionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:1868:1: rule__NamedAttributeDefinitionRule__Group__1__Impl : ( ':' ) ;
    public final void rule__NamedAttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1872:1: ( ( ':' ) )
            // InternalDefinitionLanguage.g:1873:1: ( ':' )
            {
            // InternalDefinitionLanguage.g:1873:1: ( ':' )
            // InternalDefinitionLanguage.g:1874:2: ':'
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getColonKeyword_1()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getNamedAttributeDefinitionRuleAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedAttributeDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__NamedAttributeDefinitionRule__Group__2"
    // InternalDefinitionLanguage.g:1883:1: rule__NamedAttributeDefinitionRule__Group__2 : rule__NamedAttributeDefinitionRule__Group__2__Impl rule__NamedAttributeDefinitionRule__Group__3 ;
    public final void rule__NamedAttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1887:1: ( rule__NamedAttributeDefinitionRule__Group__2__Impl rule__NamedAttributeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:1888:2: rule__NamedAttributeDefinitionRule__Group__2__Impl rule__NamedAttributeDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__NamedAttributeDefinitionRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NamedAttributeDefinitionRule__Group__3();

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
    // $ANTLR end "rule__NamedAttributeDefinitionRule__Group__2"


    // $ANTLR start "rule__NamedAttributeDefinitionRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:1895:1: rule__NamedAttributeDefinitionRule__Group__2__Impl : ( ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 ) ) ;
    public final void rule__NamedAttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1899:1: ( ( ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:1900:1: ( ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:1900:1: ( ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 ) )
            // InternalDefinitionLanguage.g:1901:2: ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 )
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getTypeAssignment_2()); 
            // InternalDefinitionLanguage.g:1902:2: ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 )
            // InternalDefinitionLanguage.g:1902:3: rule__NamedAttributeDefinitionRule__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__NamedAttributeDefinitionRule__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getNamedAttributeDefinitionRuleAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedAttributeDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__NamedAttributeDefinitionRule__Group__3"
    // InternalDefinitionLanguage.g:1910:1: rule__NamedAttributeDefinitionRule__Group__3 : rule__NamedAttributeDefinitionRule__Group__3__Impl ;
    public final void rule__NamedAttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1914:1: ( rule__NamedAttributeDefinitionRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:1915:2: rule__NamedAttributeDefinitionRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NamedAttributeDefinitionRule__Group__3__Impl();

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
    // $ANTLR end "rule__NamedAttributeDefinitionRule__Group__3"


    // $ANTLR start "rule__NamedAttributeDefinitionRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:1921:1: rule__NamedAttributeDefinitionRule__Group__3__Impl : ( ';' ) ;
    public final void rule__NamedAttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1925:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:1926:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:1926:1: ( ';' )
            // InternalDefinitionLanguage.g:1927:2: ';'
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getSemicolonKeyword_3()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getNamedAttributeDefinitionRuleAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedAttributeDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__LiteralTypeRule__Group__0"
    // InternalDefinitionLanguage.g:1937:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1941:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:1942:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalDefinitionLanguage.g:1949:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1953:1: ( ( () ) )
            // InternalDefinitionLanguage.g:1954:1: ( () )
            {
            // InternalDefinitionLanguage.g:1954:1: ( () )
            // InternalDefinitionLanguage.g:1955:2: ()
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            // InternalDefinitionLanguage.g:1956:2: ()
            // InternalDefinitionLanguage.g:1956:3: 
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
    // InternalDefinitionLanguage.g:1964:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1968:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:1969:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:1975:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1979:1: ( ( 'literal' ) )
            // InternalDefinitionLanguage.g:1980:1: ( 'literal' )
            {
            // InternalDefinitionLanguage.g:1980:1: ( 'literal' )
            // InternalDefinitionLanguage.g:1981:2: 'literal'
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            match(input,31,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:1991:1: rule__InstanceTypeRule__Group__0 : rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 ;
    public final void rule__InstanceTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1995:1: ( rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:1996:2: rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalDefinitionLanguage.g:2003:1: rule__InstanceTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__InstanceTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2007:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2008:1: ( () )
            {
            // InternalDefinitionLanguage.g:2008:1: ( () )
            // InternalDefinitionLanguage.g:2009:2: ()
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 
            // InternalDefinitionLanguage.g:2010:2: ()
            // InternalDefinitionLanguage.g:2010:3: 
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
    // InternalDefinitionLanguage.g:2018:1: rule__InstanceTypeRule__Group__1 : rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 ;
    public final void rule__InstanceTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2022:1: ( rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 )
            // InternalDefinitionLanguage.g:2023:2: rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2
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
    // InternalDefinitionLanguage.g:2030:1: rule__InstanceTypeRule__Group__1__Impl : ( 'instance' ) ;
    public final void rule__InstanceTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2034:1: ( ( 'instance' ) )
            // InternalDefinitionLanguage.g:2035:1: ( 'instance' )
            {
            // InternalDefinitionLanguage.g:2035:1: ( 'instance' )
            // InternalDefinitionLanguage.g:2036:2: 'instance'
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 
            match(input,32,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2045:1: rule__InstanceTypeRule__Group__2 : rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 ;
    public final void rule__InstanceTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2049:1: ( rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 )
            // InternalDefinitionLanguage.g:2050:2: rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3
            {
            pushFollow(FOLLOW_14);
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
    // InternalDefinitionLanguage.g:2057:1: rule__InstanceTypeRule__Group__2__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) ;
    public final void rule__InstanceTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2061:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:2062:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:2062:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            // InternalDefinitionLanguage.g:2063:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_2()); 
            // InternalDefinitionLanguage.g:2064:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            // InternalDefinitionLanguage.g:2064:3: rule__InstanceTypeRule__DefinitionsAssignment_2
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
    // InternalDefinitionLanguage.g:2072:1: rule__InstanceTypeRule__Group__3 : rule__InstanceTypeRule__Group__3__Impl ;
    public final void rule__InstanceTypeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2076:1: ( rule__InstanceTypeRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:2077:2: rule__InstanceTypeRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:2083:1: rule__InstanceTypeRule__Group__3__Impl : ( ( rule__InstanceTypeRule__Group_3__0 )* ) ;
    public final void rule__InstanceTypeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2087:1: ( ( ( rule__InstanceTypeRule__Group_3__0 )* ) )
            // InternalDefinitionLanguage.g:2088:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            {
            // InternalDefinitionLanguage.g:2088:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            // InternalDefinitionLanguage.g:2089:2: ( rule__InstanceTypeRule__Group_3__0 )*
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getGroup_3()); 
            // InternalDefinitionLanguage.g:2090:2: ( rule__InstanceTypeRule__Group_3__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==33) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2090:3: rule__InstanceTypeRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__InstanceTypeRule__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalDefinitionLanguage.g:2099:1: rule__InstanceTypeRule__Group_3__0 : rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 ;
    public final void rule__InstanceTypeRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2103:1: ( rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 )
            // InternalDefinitionLanguage.g:2104:2: rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1
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
    // InternalDefinitionLanguage.g:2111:1: rule__InstanceTypeRule__Group_3__0__Impl : ( '|' ) ;
    public final void rule__InstanceTypeRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2115:1: ( ( '|' ) )
            // InternalDefinitionLanguage.g:2116:1: ( '|' )
            {
            // InternalDefinitionLanguage.g:2116:1: ( '|' )
            // InternalDefinitionLanguage.g:2117:2: '|'
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2126:1: rule__InstanceTypeRule__Group_3__1 : rule__InstanceTypeRule__Group_3__1__Impl ;
    public final void rule__InstanceTypeRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2130:1: ( rule__InstanceTypeRule__Group_3__1__Impl )
            // InternalDefinitionLanguage.g:2131:2: rule__InstanceTypeRule__Group_3__1__Impl
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
    // InternalDefinitionLanguage.g:2137:1: rule__InstanceTypeRule__Group_3__1__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) ;
    public final void rule__InstanceTypeRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2141:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) )
            // InternalDefinitionLanguage.g:2142:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            {
            // InternalDefinitionLanguage.g:2142:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            // InternalDefinitionLanguage.g:2143:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_3_1()); 
            // InternalDefinitionLanguage.g:2144:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            // InternalDefinitionLanguage.g:2144:3: rule__InstanceTypeRule__DefinitionsAssignment_3_1
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
    // InternalDefinitionLanguage.g:2153:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2157:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2158:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalDefinitionLanguage.g:2165:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2169:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2170:1: ( () )
            {
            // InternalDefinitionLanguage.g:2170:1: ( () )
            // InternalDefinitionLanguage.g:2171:2: ()
            {
             before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            // InternalDefinitionLanguage.g:2172:2: ()
            // InternalDefinitionLanguage.g:2172:3: 
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
    // InternalDefinitionLanguage.g:2180:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2184:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2185:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2191:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2195:1: ( ( 'string' ) )
            // InternalDefinitionLanguage.g:2196:1: ( 'string' )
            {
            // InternalDefinitionLanguage.g:2196:1: ( 'string' )
            // InternalDefinitionLanguage.g:2197:2: 'string'
            {
             before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            match(input,34,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2207:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2211:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2212:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalDefinitionLanguage.g:2219:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2223:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2224:1: ( () )
            {
            // InternalDefinitionLanguage.g:2224:1: ( () )
            // InternalDefinitionLanguage.g:2225:2: ()
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            // InternalDefinitionLanguage.g:2226:2: ()
            // InternalDefinitionLanguage.g:2226:3: 
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
    // InternalDefinitionLanguage.g:2234:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2238:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2239:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2245:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2249:1: ( ( 'expression' ) )
            // InternalDefinitionLanguage.g:2250:1: ( 'expression' )
            {
            // InternalDefinitionLanguage.g:2250:1: ( 'expression' )
            // InternalDefinitionLanguage.g:2251:2: 'expression'
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            match(input,35,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2261:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2265:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2266:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalDefinitionLanguage.g:2273:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2277:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2278:1: ( () )
            {
            // InternalDefinitionLanguage.g:2278:1: ( () )
            // InternalDefinitionLanguage.g:2279:2: ()
            {
             before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            // InternalDefinitionLanguage.g:2280:2: ()
            // InternalDefinitionLanguage.g:2280:3: 
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
    // InternalDefinitionLanguage.g:2288:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2292:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2293:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2299:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2303:1: ( ( 'int' ) )
            // InternalDefinitionLanguage.g:2304:1: ( 'int' )
            {
            // InternalDefinitionLanguage.g:2304:1: ( 'int' )
            // InternalDefinitionLanguage.g:2305:2: 'int'
            {
             before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            match(input,36,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2315:1: rule__FloatTypeRule__Group__0 : rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 ;
    public final void rule__FloatTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2319:1: ( rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2320:2: rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalDefinitionLanguage.g:2327:1: rule__FloatTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__FloatTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2331:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2332:1: ( () )
            {
            // InternalDefinitionLanguage.g:2332:1: ( () )
            // InternalDefinitionLanguage.g:2333:2: ()
            {
             before(grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0()); 
            // InternalDefinitionLanguage.g:2334:2: ()
            // InternalDefinitionLanguage.g:2334:3: 
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
    // InternalDefinitionLanguage.g:2342:1: rule__FloatTypeRule__Group__1 : rule__FloatTypeRule__Group__1__Impl ;
    public final void rule__FloatTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2346:1: ( rule__FloatTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2347:2: rule__FloatTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2353:1: rule__FloatTypeRule__Group__1__Impl : ( 'float' ) ;
    public final void rule__FloatTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2357:1: ( ( 'float' ) )
            // InternalDefinitionLanguage.g:2358:1: ( 'float' )
            {
            // InternalDefinitionLanguage.g:2358:1: ( 'float' )
            // InternalDefinitionLanguage.g:2359:2: 'float'
            {
             before(grammarAccess.getFloatTypeRuleAccess().getFloatKeyword_1()); 
            match(input,37,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2369:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2373:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2374:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalDefinitionLanguage.g:2381:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2385:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2386:1: ( () )
            {
            // InternalDefinitionLanguage.g:2386:1: ( () )
            // InternalDefinitionLanguage.g:2387:2: ()
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            // InternalDefinitionLanguage.g:2388:2: ()
            // InternalDefinitionLanguage.g:2388:3: 
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
    // InternalDefinitionLanguage.g:2396:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2400:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2401:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2407:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2411:1: ( ( 'boolean' ) )
            // InternalDefinitionLanguage.g:2412:1: ( 'boolean' )
            {
            // InternalDefinitionLanguage.g:2412:1: ( 'boolean' )
            // InternalDefinitionLanguage.g:2413:2: 'boolean'
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            match(input,38,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2423:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2427:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2428:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalDefinitionLanguage.g:2435:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2439:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2440:1: ( () )
            {
            // InternalDefinitionLanguage.g:2440:1: ( () )
            // InternalDefinitionLanguage.g:2441:2: ()
            {
             before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            // InternalDefinitionLanguage.g:2442:2: ()
            // InternalDefinitionLanguage.g:2442:3: 
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
    // InternalDefinitionLanguage.g:2450:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2454:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2455:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2461:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2465:1: ( ( 'void' ) )
            // InternalDefinitionLanguage.g:2466:1: ( 'void' )
            {
            // InternalDefinitionLanguage.g:2466:1: ( 'void' )
            // InternalDefinitionLanguage.g:2467:2: 'void'
            {
             before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            match(input,39,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2477:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2481:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2482:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDefinitionLanguage.g:2489:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2493:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2494:1: ( () )
            {
            // InternalDefinitionLanguage.g:2494:1: ( () )
            // InternalDefinitionLanguage.g:2495:2: ()
            {
             before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            // InternalDefinitionLanguage.g:2496:2: ()
            // InternalDefinitionLanguage.g:2496:3: 
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
    // InternalDefinitionLanguage.g:2504:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2508:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2509:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2515:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2519:1: ( ( 'data' ) )
            // InternalDefinitionLanguage.g:2520:1: ( 'data' )
            {
            // InternalDefinitionLanguage.g:2520:1: ( 'data' )
            // InternalDefinitionLanguage.g:2521:2: 'data'
            {
             before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            match(input,40,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2531:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2535:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2536:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalDefinitionLanguage.g:2543:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2547:1: ( ( 'array' ) )
            // InternalDefinitionLanguage.g:2548:1: ( 'array' )
            {
            // InternalDefinitionLanguage.g:2548:1: ( 'array' )
            // InternalDefinitionLanguage.g:2549:2: 'array'
            {
             before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2558:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2562:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2563:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2569:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2573:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2574:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2574:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalDefinitionLanguage.g:2575:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
             before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            // InternalDefinitionLanguage.g:2576:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalDefinitionLanguage.g:2576:3: rule__ArrayTypeRule__ElementsAssignment_1
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


    // $ANTLR start "rule__FunctioDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:2585:1: rule__FunctioDefinitionRule__Group__0 : rule__FunctioDefinitionRule__Group__0__Impl rule__FunctioDefinitionRule__Group__1 ;
    public final void rule__FunctioDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2589:1: ( rule__FunctioDefinitionRule__Group__0__Impl rule__FunctioDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:2590:2: rule__FunctioDefinitionRule__Group__0__Impl rule__FunctioDefinitionRule__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__FunctioDefinitionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group__1();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group__0"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__0__Impl"
    // InternalDefinitionLanguage.g:2597:1: rule__FunctioDefinitionRule__Group__0__Impl : ( 'def' ) ;
    public final void rule__FunctioDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2601:1: ( ( 'def' ) )
            // InternalDefinitionLanguage.g:2602:1: ( 'def' )
            {
            // InternalDefinitionLanguage.g:2602:1: ( 'def' )
            // InternalDefinitionLanguage.g:2603:2: 'def'
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getDefKeyword_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getFunctioDefinitionRuleAccess().getDefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group__0__Impl"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__1"
    // InternalDefinitionLanguage.g:2612:1: rule__FunctioDefinitionRule__Group__1 : rule__FunctioDefinitionRule__Group__1__Impl rule__FunctioDefinitionRule__Group__2 ;
    public final void rule__FunctioDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2616:1: ( rule__FunctioDefinitionRule__Group__1__Impl rule__FunctioDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:2617:2: rule__FunctioDefinitionRule__Group__1__Impl rule__FunctioDefinitionRule__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__FunctioDefinitionRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group__2();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group__1"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__1__Impl"
    // InternalDefinitionLanguage.g:2624:1: rule__FunctioDefinitionRule__Group__1__Impl : ( ( rule__FunctioDefinitionRule__TypeAssignment_1 ) ) ;
    public final void rule__FunctioDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2628:1: ( ( ( rule__FunctioDefinitionRule__TypeAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2629:1: ( ( rule__FunctioDefinitionRule__TypeAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2629:1: ( ( rule__FunctioDefinitionRule__TypeAssignment_1 ) )
            // InternalDefinitionLanguage.g:2630:2: ( rule__FunctioDefinitionRule__TypeAssignment_1 )
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getTypeAssignment_1()); 
            // InternalDefinitionLanguage.g:2631:2: ( rule__FunctioDefinitionRule__TypeAssignment_1 )
            // InternalDefinitionLanguage.g:2631:3: rule__FunctioDefinitionRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctioDefinitionRuleAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group__1__Impl"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__2"
    // InternalDefinitionLanguage.g:2639:1: rule__FunctioDefinitionRule__Group__2 : rule__FunctioDefinitionRule__Group__2__Impl rule__FunctioDefinitionRule__Group__3 ;
    public final void rule__FunctioDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2643:1: ( rule__FunctioDefinitionRule__Group__2__Impl rule__FunctioDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:2644:2: rule__FunctioDefinitionRule__Group__2__Impl rule__FunctioDefinitionRule__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__FunctioDefinitionRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group__3();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group__2"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__2__Impl"
    // InternalDefinitionLanguage.g:2651:1: rule__FunctioDefinitionRule__Group__2__Impl : ( ( rule__FunctioDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__FunctioDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2655:1: ( ( ( rule__FunctioDefinitionRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:2656:1: ( ( rule__FunctioDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:2656:1: ( ( rule__FunctioDefinitionRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:2657:2: ( rule__FunctioDefinitionRule__NameAssignment_2 )
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getNameAssignment_2()); 
            // InternalDefinitionLanguage.g:2658:2: ( rule__FunctioDefinitionRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:2658:3: rule__FunctioDefinitionRule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFunctioDefinitionRuleAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group__2__Impl"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__3"
    // InternalDefinitionLanguage.g:2666:1: rule__FunctioDefinitionRule__Group__3 : rule__FunctioDefinitionRule__Group__3__Impl rule__FunctioDefinitionRule__Group__4 ;
    public final void rule__FunctioDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2670:1: ( rule__FunctioDefinitionRule__Group__3__Impl rule__FunctioDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:2671:2: rule__FunctioDefinitionRule__Group__3__Impl rule__FunctioDefinitionRule__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__FunctioDefinitionRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group__4();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group__3"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__3__Impl"
    // InternalDefinitionLanguage.g:2678:1: rule__FunctioDefinitionRule__Group__3__Impl : ( '(' ) ;
    public final void rule__FunctioDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2682:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:2683:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:2683:1: ( '(' )
            // InternalDefinitionLanguage.g:2684:2: '('
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getLeftParenthesisKeyword_3()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getFunctioDefinitionRuleAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group__3__Impl"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__4"
    // InternalDefinitionLanguage.g:2693:1: rule__FunctioDefinitionRule__Group__4 : rule__FunctioDefinitionRule__Group__4__Impl rule__FunctioDefinitionRule__Group__5 ;
    public final void rule__FunctioDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2697:1: ( rule__FunctioDefinitionRule__Group__4__Impl rule__FunctioDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:2698:2: rule__FunctioDefinitionRule__Group__4__Impl rule__FunctioDefinitionRule__Group__5
            {
            pushFollow(FOLLOW_23);
            rule__FunctioDefinitionRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group__5();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group__4"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__4__Impl"
    // InternalDefinitionLanguage.g:2705:1: rule__FunctioDefinitionRule__Group__4__Impl : ( ( rule__FunctioDefinitionRule__Group_4__0 )? ) ;
    public final void rule__FunctioDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2709:1: ( ( ( rule__FunctioDefinitionRule__Group_4__0 )? ) )
            // InternalDefinitionLanguage.g:2710:1: ( ( rule__FunctioDefinitionRule__Group_4__0 )? )
            {
            // InternalDefinitionLanguage.g:2710:1: ( ( rule__FunctioDefinitionRule__Group_4__0 )? )
            // InternalDefinitionLanguage.g:2711:2: ( rule__FunctioDefinitionRule__Group_4__0 )?
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getGroup_4()); 
            // InternalDefinitionLanguage.g:2712:2: ( rule__FunctioDefinitionRule__Group_4__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=31 && LA17_0<=32)||(LA17_0>=34 && LA17_0<=41)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDefinitionLanguage.g:2712:3: rule__FunctioDefinitionRule__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FunctioDefinitionRule__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFunctioDefinitionRuleAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group__4__Impl"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__5"
    // InternalDefinitionLanguage.g:2720:1: rule__FunctioDefinitionRule__Group__5 : rule__FunctioDefinitionRule__Group__5__Impl rule__FunctioDefinitionRule__Group__6 ;
    public final void rule__FunctioDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2724:1: ( rule__FunctioDefinitionRule__Group__5__Impl rule__FunctioDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:2725:2: rule__FunctioDefinitionRule__Group__5__Impl rule__FunctioDefinitionRule__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__FunctioDefinitionRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group__6();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group__5"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__5__Impl"
    // InternalDefinitionLanguage.g:2732:1: rule__FunctioDefinitionRule__Group__5__Impl : ( ')' ) ;
    public final void rule__FunctioDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2736:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:2737:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:2737:1: ( ')' )
            // InternalDefinitionLanguage.g:2738:2: ')'
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getRightParenthesisKeyword_5()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getFunctioDefinitionRuleAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group__5__Impl"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__6"
    // InternalDefinitionLanguage.g:2747:1: rule__FunctioDefinitionRule__Group__6 : rule__FunctioDefinitionRule__Group__6__Impl ;
    public final void rule__FunctioDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2751:1: ( rule__FunctioDefinitionRule__Group__6__Impl )
            // InternalDefinitionLanguage.g:2752:2: rule__FunctioDefinitionRule__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group__6__Impl();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group__6"


    // $ANTLR start "rule__FunctioDefinitionRule__Group__6__Impl"
    // InternalDefinitionLanguage.g:2758:1: rule__FunctioDefinitionRule__Group__6__Impl : ( ';' ) ;
    public final void rule__FunctioDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2762:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:2763:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:2763:1: ( ';' )
            // InternalDefinitionLanguage.g:2764:2: ';'
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getSemicolonKeyword_6()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getFunctioDefinitionRuleAccess().getSemicolonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group__6__Impl"


    // $ANTLR start "rule__FunctioDefinitionRule__Group_4__0"
    // InternalDefinitionLanguage.g:2774:1: rule__FunctioDefinitionRule__Group_4__0 : rule__FunctioDefinitionRule__Group_4__0__Impl rule__FunctioDefinitionRule__Group_4__1 ;
    public final void rule__FunctioDefinitionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2778:1: ( rule__FunctioDefinitionRule__Group_4__0__Impl rule__FunctioDefinitionRule__Group_4__1 )
            // InternalDefinitionLanguage.g:2779:2: rule__FunctioDefinitionRule__Group_4__0__Impl rule__FunctioDefinitionRule__Group_4__1
            {
            pushFollow(FOLLOW_24);
            rule__FunctioDefinitionRule__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group_4__1();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group_4__0"


    // $ANTLR start "rule__FunctioDefinitionRule__Group_4__0__Impl"
    // InternalDefinitionLanguage.g:2786:1: rule__FunctioDefinitionRule__Group_4__0__Impl : ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 ) ) ;
    public final void rule__FunctioDefinitionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2790:1: ( ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 ) ) )
            // InternalDefinitionLanguage.g:2791:1: ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 ) )
            {
            // InternalDefinitionLanguage.g:2791:1: ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 ) )
            // InternalDefinitionLanguage.g:2792:2: ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 )
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getParametersAssignment_4_0()); 
            // InternalDefinitionLanguage.g:2793:2: ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 )
            // InternalDefinitionLanguage.g:2793:3: rule__FunctioDefinitionRule__ParametersAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__ParametersAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getFunctioDefinitionRuleAccess().getParametersAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group_4__0__Impl"


    // $ANTLR start "rule__FunctioDefinitionRule__Group_4__1"
    // InternalDefinitionLanguage.g:2801:1: rule__FunctioDefinitionRule__Group_4__1 : rule__FunctioDefinitionRule__Group_4__1__Impl ;
    public final void rule__FunctioDefinitionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2805:1: ( rule__FunctioDefinitionRule__Group_4__1__Impl )
            // InternalDefinitionLanguage.g:2806:2: rule__FunctioDefinitionRule__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group_4__1__Impl();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group_4__1"


    // $ANTLR start "rule__FunctioDefinitionRule__Group_4__1__Impl"
    // InternalDefinitionLanguage.g:2812:1: rule__FunctioDefinitionRule__Group_4__1__Impl : ( ( rule__FunctioDefinitionRule__Group_4_1__0 )* ) ;
    public final void rule__FunctioDefinitionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2816:1: ( ( ( rule__FunctioDefinitionRule__Group_4_1__0 )* ) )
            // InternalDefinitionLanguage.g:2817:1: ( ( rule__FunctioDefinitionRule__Group_4_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2817:1: ( ( rule__FunctioDefinitionRule__Group_4_1__0 )* )
            // InternalDefinitionLanguage.g:2818:2: ( rule__FunctioDefinitionRule__Group_4_1__0 )*
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getGroup_4_1()); 
            // InternalDefinitionLanguage.g:2819:2: ( rule__FunctioDefinitionRule__Group_4_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==45) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2819:3: rule__FunctioDefinitionRule__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__FunctioDefinitionRule__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getFunctioDefinitionRuleAccess().getGroup_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group_4__1__Impl"


    // $ANTLR start "rule__FunctioDefinitionRule__Group_4_1__0"
    // InternalDefinitionLanguage.g:2828:1: rule__FunctioDefinitionRule__Group_4_1__0 : rule__FunctioDefinitionRule__Group_4_1__0__Impl rule__FunctioDefinitionRule__Group_4_1__1 ;
    public final void rule__FunctioDefinitionRule__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2832:1: ( rule__FunctioDefinitionRule__Group_4_1__0__Impl rule__FunctioDefinitionRule__Group_4_1__1 )
            // InternalDefinitionLanguage.g:2833:2: rule__FunctioDefinitionRule__Group_4_1__0__Impl rule__FunctioDefinitionRule__Group_4_1__1
            {
            pushFollow(FOLLOW_10);
            rule__FunctioDefinitionRule__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group_4_1__1();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group_4_1__0"


    // $ANTLR start "rule__FunctioDefinitionRule__Group_4_1__0__Impl"
    // InternalDefinitionLanguage.g:2840:1: rule__FunctioDefinitionRule__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__FunctioDefinitionRule__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2844:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:2845:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:2845:1: ( ',' )
            // InternalDefinitionLanguage.g:2846:2: ','
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getCommaKeyword_4_1_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getFunctioDefinitionRuleAccess().getCommaKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group_4_1__0__Impl"


    // $ANTLR start "rule__FunctioDefinitionRule__Group_4_1__1"
    // InternalDefinitionLanguage.g:2855:1: rule__FunctioDefinitionRule__Group_4_1__1 : rule__FunctioDefinitionRule__Group_4_1__1__Impl ;
    public final void rule__FunctioDefinitionRule__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2859:1: ( rule__FunctioDefinitionRule__Group_4_1__1__Impl )
            // InternalDefinitionLanguage.g:2860:2: rule__FunctioDefinitionRule__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__Group_4_1__1__Impl();

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
    // $ANTLR end "rule__FunctioDefinitionRule__Group_4_1__1"


    // $ANTLR start "rule__FunctioDefinitionRule__Group_4_1__1__Impl"
    // InternalDefinitionLanguage.g:2866:1: rule__FunctioDefinitionRule__Group_4_1__1__Impl : ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 ) ) ;
    public final void rule__FunctioDefinitionRule__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2870:1: ( ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 ) ) )
            // InternalDefinitionLanguage.g:2871:1: ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 ) )
            {
            // InternalDefinitionLanguage.g:2871:1: ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 ) )
            // InternalDefinitionLanguage.g:2872:2: ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 )
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getParametersAssignment_4_1_1()); 
            // InternalDefinitionLanguage.g:2873:2: ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 )
            // InternalDefinitionLanguage.g:2873:3: rule__FunctioDefinitionRule__ParametersAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__FunctioDefinitionRule__ParametersAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctioDefinitionRuleAccess().getParametersAssignment_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__Group_4_1__1__Impl"


    // $ANTLR start "rule__ParameterRule__Group__0"
    // InternalDefinitionLanguage.g:2882:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2886:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalDefinitionLanguage.g:2887:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
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
    // InternalDefinitionLanguage.g:2894:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2898:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2899:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2899:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalDefinitionLanguage.g:2900:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
             before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            // InternalDefinitionLanguage.g:2901:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalDefinitionLanguage.g:2901:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalDefinitionLanguage.g:2909:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2913:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2914:2: rule__ParameterRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2920:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2924:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2925:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2925:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalDefinitionLanguage.g:2926:2: ( rule__ParameterRule__NameAssignment_1 )
            {
             before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            // InternalDefinitionLanguage.g:2927:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalDefinitionLanguage.g:2927:3: rule__ParameterRule__NameAssignment_1
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


    // $ANTLR start "rule__OrExpressionRule__Group__0"
    // InternalDefinitionLanguage.g:2936:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2940:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:2941:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalDefinitionLanguage.g:2948:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2952:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:2953:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:2953:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:2954:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalDefinitionLanguage.g:2955:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:2955:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:2963:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2967:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2968:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2974:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2978:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:2979:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2979:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:2980:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:2981:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==46) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2981:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalDefinitionLanguage.g:2990:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2994:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:2995:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:3002:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3006:1: ( ( 'OR' ) )
            // InternalDefinitionLanguage.g:3007:1: ( 'OR' )
            {
            // InternalDefinitionLanguage.g:3007:1: ( 'OR' )
            // InternalDefinitionLanguage.g:3008:2: 'OR'
            {
             before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3017:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3021:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3022:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3028:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3032:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3033:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3033:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3034:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3035:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3035:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3044:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3048:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3049:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalDefinitionLanguage.g:3056:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3060:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3061:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3061:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:3062:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalDefinitionLanguage.g:3063:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:3063:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:3071:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3075:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3076:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3082:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3086:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3087:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3087:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3088:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3089:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==47) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3089:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalDefinitionLanguage.g:3098:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3102:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3103:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:3110:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3114:1: ( ( 'XOR' ) )
            // InternalDefinitionLanguage.g:3115:1: ( 'XOR' )
            {
            // InternalDefinitionLanguage.g:3115:1: ( 'XOR' )
            // InternalDefinitionLanguage.g:3116:2: 'XOR'
            {
             before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3125:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3129:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3130:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3136:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3140:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3141:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3141:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3142:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3143:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3143:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3152:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3156:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3157:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalDefinitionLanguage.g:3164:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3168:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3169:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3169:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:3170:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalDefinitionLanguage.g:3171:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:3171:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:3179:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3183:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3184:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3190:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3194:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3195:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3195:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3196:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3197:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==48) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3197:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalDefinitionLanguage.g:3206:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3210:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3211:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:3218:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3222:1: ( ( 'AND' ) )
            // InternalDefinitionLanguage.g:3223:1: ( 'AND' )
            {
            // InternalDefinitionLanguage.g:3223:1: ( 'AND' )
            // InternalDefinitionLanguage.g:3224:2: 'AND'
            {
             before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            match(input,48,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3233:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3237:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3238:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3244:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3248:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3249:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3249:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3250:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3251:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3251:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3260:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3264:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3265:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:3272:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3276:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalDefinitionLanguage.g:3277:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalDefinitionLanguage.g:3277:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalDefinitionLanguage.g:3278:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            // InternalDefinitionLanguage.g:3279:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==53) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDefinitionLanguage.g:3279:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalDefinitionLanguage.g:3287:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3291:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3292:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3298:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3302:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3303:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3303:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalDefinitionLanguage.g:3304:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            // InternalDefinitionLanguage.g:3305:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalDefinitionLanguage.g:3305:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalDefinitionLanguage.g:3314:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3318:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3319:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalDefinitionLanguage.g:3326:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3330:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3331:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3331:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3332:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:3333:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3333:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3341:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3345:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3346:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3352:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3356:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalDefinitionLanguage.g:3357:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalDefinitionLanguage.g:3357:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalDefinitionLanguage.g:3358:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            // InternalDefinitionLanguage.g:3359:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=13 && LA23_0<=18)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3359:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalDefinitionLanguage.g:3368:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3372:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3373:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:3380:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3384:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3385:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3385:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalDefinitionLanguage.g:3386:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            // InternalDefinitionLanguage.g:3387:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalDefinitionLanguage.g:3387:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalDefinitionLanguage.g:3395:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3399:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3400:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3406:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3410:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3411:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3411:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3412:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalDefinitionLanguage.g:3413:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3413:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3422:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3426:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3427:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalDefinitionLanguage.g:3434:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3438:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3439:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3439:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3440:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:3441:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3441:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3449:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3453:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3454:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3460:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3464:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3465:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3465:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3466:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3467:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=19 && LA24_0<=20)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3467:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalDefinitionLanguage.g:3476:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3480:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3481:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:3488:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3492:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDefinitionLanguage.g:3493:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDefinitionLanguage.g:3493:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDefinitionLanguage.g:3494:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalDefinitionLanguage.g:3495:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalDefinitionLanguage.g:3495:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalDefinitionLanguage.g:3503:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3507:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3508:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3514:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3518:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3519:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3519:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3520:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3521:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3521:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3530:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3534:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3535:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalDefinitionLanguage.g:3542:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3546:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3547:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3547:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3548:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:3549:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3549:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3557:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3561:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3562:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3568:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3572:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3573:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3573:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3574:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3575:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=21 && LA25_0<=23)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3575:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalDefinitionLanguage.g:3584:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3588:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3589:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:3596:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3600:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDefinitionLanguage.g:3601:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDefinitionLanguage.g:3601:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDefinitionLanguage.g:3602:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalDefinitionLanguage.g:3603:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalDefinitionLanguage.g:3603:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalDefinitionLanguage.g:3611:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3615:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3616:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3622:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3626:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3627:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3627:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3628:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3629:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3629:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3638:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3642:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3643:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalDefinitionLanguage.g:3650:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3654:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3655:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3655:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3656:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:3657:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3657:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3665:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3669:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3670:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3676:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3680:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalDefinitionLanguage.g:3681:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalDefinitionLanguage.g:3681:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalDefinitionLanguage.g:3682:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3683:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==49) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDefinitionLanguage.g:3683:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalDefinitionLanguage.g:3692:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3696:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3697:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:3704:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3708:1: ( ( '^' ) )
            // InternalDefinitionLanguage.g:3709:1: ( '^' )
            {
            // InternalDefinitionLanguage.g:3709:1: ( '^' )
            // InternalDefinitionLanguage.g:3710:2: '^'
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            match(input,49,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3719:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3723:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3724:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3730:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3734:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3735:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3735:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3736:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3737:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalDefinitionLanguage.g:3737:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalDefinitionLanguage.g:3746:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3750:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3751:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:3758:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3762:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:3763:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:3763:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalDefinitionLanguage.g:3764:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            // InternalDefinitionLanguage.g:3765:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=19 && LA27_0<=20)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3765:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalDefinitionLanguage.g:3773:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3777:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3778:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3784:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3788:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3789:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3789:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3790:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalDefinitionLanguage.g:3791:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3791:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3800:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3804:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalDefinitionLanguage.g:3805:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:3812:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3816:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:3817:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:3817:1: ( '(' )
            // InternalDefinitionLanguage.g:3818:2: '('
            {
             before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3827:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3831:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalDefinitionLanguage.g:3832:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
            {
            pushFollow(FOLLOW_40);
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
    // InternalDefinitionLanguage.g:3839:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3843:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3844:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3844:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3845:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            // InternalDefinitionLanguage.g:3846:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3846:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3854:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3858:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalDefinitionLanguage.g:3859:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalDefinitionLanguage.g:3865:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3869:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:3870:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:3870:1: ( ')' )
            // InternalDefinitionLanguage.g:3871:2: ')'
            {
             before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            match(input,44,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3881:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3885:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalDefinitionLanguage.g:3886:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalDefinitionLanguage.g:3893:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3897:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3898:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3898:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalDefinitionLanguage.g:3899:2: ( rule__CallRule__FunctionAssignment_0 )
            {
             before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            // InternalDefinitionLanguage.g:3900:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalDefinitionLanguage.g:3900:3: rule__CallRule__FunctionAssignment_0
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
    // InternalDefinitionLanguage.g:3908:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3912:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalDefinitionLanguage.g:3913:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
            {
            pushFollow(FOLLOW_41);
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
    // InternalDefinitionLanguage.g:3920:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3924:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:3925:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:3925:1: ( '(' )
            // InternalDefinitionLanguage.g:3926:2: '('
            {
             before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            match(input,43,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3935:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3939:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalDefinitionLanguage.g:3940:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
            {
            pushFollow(FOLLOW_41);
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
    // InternalDefinitionLanguage.g:3947:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3951:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalDefinitionLanguage.g:3952:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalDefinitionLanguage.g:3952:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalDefinitionLanguage.g:3953:2: ( rule__CallRule__Group_2__0 )?
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            // InternalDefinitionLanguage.g:3954:2: ( rule__CallRule__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_QUOTED_ID && LA28_0<=RULE_STRING)||LA28_0==12||(LA28_0>=19 && LA28_0<=20)||LA28_0==43||LA28_0==50||(LA28_0>=53 && LA28_0<=54)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalDefinitionLanguage.g:3954:3: rule__CallRule__Group_2__0
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
    // InternalDefinitionLanguage.g:3962:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3966:1: ( rule__CallRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:3967:2: rule__CallRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:3973:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3977:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:3978:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:3978:1: ( ')' )
            // InternalDefinitionLanguage.g:3979:2: ')'
            {
             before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            match(input,44,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3989:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3993:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalDefinitionLanguage.g:3994:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalDefinitionLanguage.g:4001:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4005:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalDefinitionLanguage.g:4006:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalDefinitionLanguage.g:4006:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalDefinitionLanguage.g:4007:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            // InternalDefinitionLanguage.g:4008:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalDefinitionLanguage.g:4008:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalDefinitionLanguage.g:4016:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4020:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalDefinitionLanguage.g:4021:2: rule__CallRule__Group_2__1__Impl
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
    // InternalDefinitionLanguage.g:4027:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4031:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalDefinitionLanguage.g:4032:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalDefinitionLanguage.g:4032:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalDefinitionLanguage.g:4033:2: ( rule__CallRule__Group_2_1__0 )*
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            // InternalDefinitionLanguage.g:4034:2: ( rule__CallRule__Group_2_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==45) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4034:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalDefinitionLanguage.g:4043:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4047:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalDefinitionLanguage.g:4048:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:4055:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4059:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:4060:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:4060:1: ( ',' )
            // InternalDefinitionLanguage.g:4061:2: ','
            {
             before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4070:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4074:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalDefinitionLanguage.g:4075:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalDefinitionLanguage.g:4081:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4085:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalDefinitionLanguage.g:4086:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalDefinitionLanguage.g:4086:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalDefinitionLanguage.g:4087:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            // InternalDefinitionLanguage.g:4088:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalDefinitionLanguage.g:4088:3: rule__CallRule__ParametersAssignment_2_1_1
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
    // InternalDefinitionLanguage.g:4097:1: rule__ValueReferenceRule__Group__0 : rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 ;
    public final void rule__ValueReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4101:1: ( rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:4102:2: rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDefinitionLanguage.g:4109:1: rule__ValueReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__ValueReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4113:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4114:1: ( () )
            {
            // InternalDefinitionLanguage.g:4114:1: ( () )
            // InternalDefinitionLanguage.g:4115:2: ()
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0()); 
            // InternalDefinitionLanguage.g:4116:2: ()
            // InternalDefinitionLanguage.g:4116:3: 
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
    // InternalDefinitionLanguage.g:4124:1: rule__ValueReferenceRule__Group__1 : rule__ValueReferenceRule__Group__1__Impl ;
    public final void rule__ValueReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4128:1: ( rule__ValueReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4129:2: rule__ValueReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4135:1: rule__ValueReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__ValueReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4139:1: ( ( 'value' ) )
            // InternalDefinitionLanguage.g:4140:1: ( 'value' )
            {
            // InternalDefinitionLanguage.g:4140:1: ( 'value' )
            // InternalDefinitionLanguage.g:4141:2: 'value'
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueKeyword_1()); 
            match(input,50,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4151:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4155:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4156:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalDefinitionLanguage.g:4163:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4167:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4168:1: ( () )
            {
            // InternalDefinitionLanguage.g:4168:1: ( () )
            // InternalDefinitionLanguage.g:4169:2: ()
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            // InternalDefinitionLanguage.g:4170:2: ()
            // InternalDefinitionLanguage.g:4170:3: 
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
    // InternalDefinitionLanguage.g:4178:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4182:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4183:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4189:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4193:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalDefinitionLanguage.g:4194:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalDefinitionLanguage.g:4194:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalDefinitionLanguage.g:4195:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            // InternalDefinitionLanguage.g:4196:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalDefinitionLanguage.g:4196:3: rule__BooleanLiteralRule__Alternatives_1
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
    // InternalDefinitionLanguage.g:4205:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4209:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // InternalDefinitionLanguage.g:4210:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalDefinitionLanguage.g:4217:1: rule__DOUBLE__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4221:1: ( ( RULE_INT ) )
            // InternalDefinitionLanguage.g:4222:1: ( RULE_INT )
            {
            // InternalDefinitionLanguage.g:4222:1: ( RULE_INT )
            // InternalDefinitionLanguage.g:4223:2: RULE_INT
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
    // InternalDefinitionLanguage.g:4232:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4236:1: ( rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 )
            // InternalDefinitionLanguage.g:4237:2: rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2
            {
            pushFollow(FOLLOW_44);
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
    // InternalDefinitionLanguage.g:4244:1: rule__DOUBLE__Group__1__Impl : ( '.' ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4248:1: ( ( '.' ) )
            // InternalDefinitionLanguage.g:4249:1: ( '.' )
            {
            // InternalDefinitionLanguage.g:4249:1: ( '.' )
            // InternalDefinitionLanguage.g:4250:2: '.'
            {
             before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4259:1: rule__DOUBLE__Group__2 : rule__DOUBLE__Group__2__Impl ;
    public final void rule__DOUBLE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4263:1: ( rule__DOUBLE__Group__2__Impl )
            // InternalDefinitionLanguage.g:4264:2: rule__DOUBLE__Group__2__Impl
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
    // InternalDefinitionLanguage.g:4270:1: rule__DOUBLE__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4274:1: ( ( RULE_INT ) )
            // InternalDefinitionLanguage.g:4275:1: ( RULE_INT )
            {
            // InternalDefinitionLanguage.g:4275:1: ( RULE_INT )
            // InternalDefinitionLanguage.g:4276:2: RULE_INT
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


    // $ANTLR start "rule__DefinitionModelRule__TypesAssignment_0"
    // InternalDefinitionLanguage.g:4286:1: rule__DefinitionModelRule__TypesAssignment_0 : ( ruleTypeDefinitionRule ) ;
    public final void rule__DefinitionModelRule__TypesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4290:1: ( ( ruleTypeDefinitionRule ) )
            // InternalDefinitionLanguage.g:4291:2: ( ruleTypeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:4291:2: ( ruleTypeDefinitionRule )
            // InternalDefinitionLanguage.g:4292:3: ruleTypeDefinitionRule
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getTypesTypeDefinitionRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeDefinitionRule();

            state._fsp--;

             after(grammarAccess.getDefinitionModelRuleAccess().getTypesTypeDefinitionRuleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__TypesAssignment_0"


    // $ANTLR start "rule__DefinitionModelRule__FunctionsAssignment_1"
    // InternalDefinitionLanguage.g:4301:1: rule__DefinitionModelRule__FunctionsAssignment_1 : ( ruleFunctioDefinitionRule ) ;
    public final void rule__DefinitionModelRule__FunctionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4305:1: ( ( ruleFunctioDefinitionRule ) )
            // InternalDefinitionLanguage.g:4306:2: ( ruleFunctioDefinitionRule )
            {
            // InternalDefinitionLanguage.g:4306:2: ( ruleFunctioDefinitionRule )
            // InternalDefinitionLanguage.g:4307:3: ruleFunctioDefinitionRule
            {
             before(grammarAccess.getDefinitionModelRuleAccess().getFunctionsFunctioDefinitionRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFunctioDefinitionRule();

            state._fsp--;

             after(grammarAccess.getDefinitionModelRuleAccess().getFunctionsFunctioDefinitionRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefinitionModelRule__FunctionsAssignment_1"


    // $ANTLR start "rule__TypeDefinitionRule__AbstractAssignment_0"
    // InternalDefinitionLanguage.g:4316:1: rule__TypeDefinitionRule__AbstractAssignment_0 : ( ( 'abstract' ) ) ;
    public final void rule__TypeDefinitionRule__AbstractAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4320:1: ( ( ( 'abstract' ) ) )
            // InternalDefinitionLanguage.g:4321:2: ( ( 'abstract' ) )
            {
            // InternalDefinitionLanguage.g:4321:2: ( ( 'abstract' ) )
            // InternalDefinitionLanguage.g:4322:3: ( 'abstract' )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 
            // InternalDefinitionLanguage.g:4323:3: ( 'abstract' )
            // InternalDefinitionLanguage.g:4324:4: 'abstract'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 

            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:4335:1: rule__TypeDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__TypeDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4339:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4340:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:4340:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4341:3: ruleStringOrId
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:4350:1: rule__TypeDefinitionRule__SuperTypeAssignment_3_1 : ( ( ruleStringOrId ) ) ;
    public final void rule__TypeDefinitionRule__SuperTypeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4354:1: ( ( ( ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:4355:2: ( ( ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:4355:2: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4356:3: ( ruleStringOrId )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionCrossReference_3_1_0()); 
            // InternalDefinitionLanguage.g:4357:3: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4358:4: ruleStringOrId
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionStringOrIdParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionStringOrIdParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionCrossReference_3_1_0()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:4369:1: rule__TypeDefinitionRule__AttributesAssignment_5 : ( ruleAttributeDefinitionRule ) ;
    public final void rule__TypeDefinitionRule__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4373:1: ( ( ruleAttributeDefinitionRule ) )
            // InternalDefinitionLanguage.g:4374:2: ( ruleAttributeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:4374:2: ( ruleAttributeDefinitionRule )
            // InternalDefinitionLanguage.g:4375:3: ruleAttributeDefinitionRule
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAttributeDefinitionRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeDefinitionRule();

            state._fsp--;

             after(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAttributeDefinitionRuleParserRuleCall_5_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__UnnamedAttributeDefinitionRule__TypeAssignment_2"
    // InternalDefinitionLanguage.g:4384:1: rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 : ( ruleTypeRule ) ;
    public final void rule__UnnamedAttributeDefinitionRule__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4388:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:4389:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:4389:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:4390:3: ruleTypeRule
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnnamedAttributeDefinitionRule__TypeAssignment_2"


    // $ANTLR start "rule__NamedAttributeDefinitionRule__NameAssignment_0"
    // InternalDefinitionLanguage.g:4399:1: rule__NamedAttributeDefinitionRule__NameAssignment_0 : ( ruleStringOrId ) ;
    public final void rule__NamedAttributeDefinitionRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4403:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4404:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:4404:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4405:3: ruleStringOrId
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getNamedAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedAttributeDefinitionRule__NameAssignment_0"


    // $ANTLR start "rule__NamedAttributeDefinitionRule__TypeAssignment_2"
    // InternalDefinitionLanguage.g:4414:1: rule__NamedAttributeDefinitionRule__TypeAssignment_2 : ( ruleTypeRule ) ;
    public final void rule__NamedAttributeDefinitionRule__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4418:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:4419:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:4419:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:4420:3: ruleTypeRule
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getNamedAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedAttributeDefinitionRule__TypeAssignment_2"


    // $ANTLR start "rule__InstanceTypeRule__DefinitionsAssignment_2"
    // InternalDefinitionLanguage.g:4429:1: rule__InstanceTypeRule__DefinitionsAssignment_2 : ( ( ruleStringOrId ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4433:1: ( ( ( ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:4434:2: ( ( ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:4434:2: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4435:3: ( ruleStringOrId )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_2_0()); 
            // InternalDefinitionLanguage.g:4436:3: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4437:4: ruleStringOrId
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionStringOrIdParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionStringOrIdParserRuleCall_2_0_1()); 

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
    // InternalDefinitionLanguage.g:4448:1: rule__InstanceTypeRule__DefinitionsAssignment_3_1 : ( ( ruleStringOrId ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4452:1: ( ( ( ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:4453:2: ( ( ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:4453:2: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4454:3: ( ruleStringOrId )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_3_1_0()); 
            // InternalDefinitionLanguage.g:4455:3: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4456:4: ruleStringOrId
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionStringOrIdParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionStringOrIdParserRuleCall_3_1_0_1()); 

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
    // InternalDefinitionLanguage.g:4467:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4471:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:4472:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:4472:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:4473:3: ruleTypeRule
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


    // $ANTLR start "rule__FunctioDefinitionRule__TypeAssignment_1"
    // InternalDefinitionLanguage.g:4482:1: rule__FunctioDefinitionRule__TypeAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__FunctioDefinitionRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4486:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:4487:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:4487:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:4488:3: ruleTypeRule
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getFunctioDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__TypeAssignment_1"


    // $ANTLR start "rule__FunctioDefinitionRule__NameAssignment_2"
    // InternalDefinitionLanguage.g:4497:1: rule__FunctioDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__FunctioDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4501:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4502:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:4502:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4503:3: ruleStringOrId
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getFunctioDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__NameAssignment_2"


    // $ANTLR start "rule__FunctioDefinitionRule__ParametersAssignment_4_0"
    // InternalDefinitionLanguage.g:4512:1: rule__FunctioDefinitionRule__ParametersAssignment_4_0 : ( ruleParameterRule ) ;
    public final void rule__FunctioDefinitionRule__ParametersAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4516:1: ( ( ruleParameterRule ) )
            // InternalDefinitionLanguage.g:4517:2: ( ruleParameterRule )
            {
            // InternalDefinitionLanguage.g:4517:2: ( ruleParameterRule )
            // InternalDefinitionLanguage.g:4518:3: ruleParameterRule
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterRule();

            state._fsp--;

             after(grammarAccess.getFunctioDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__ParametersAssignment_4_0"


    // $ANTLR start "rule__FunctioDefinitionRule__ParametersAssignment_4_1_1"
    // InternalDefinitionLanguage.g:4527:1: rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 : ( ruleParameterRule ) ;
    public final void rule__FunctioDefinitionRule__ParametersAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4531:1: ( ( ruleParameterRule ) )
            // InternalDefinitionLanguage.g:4532:2: ( ruleParameterRule )
            {
            // InternalDefinitionLanguage.g:4532:2: ( ruleParameterRule )
            // InternalDefinitionLanguage.g:4533:3: ruleParameterRule
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterRule();

            state._fsp--;

             after(grammarAccess.getFunctioDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctioDefinitionRule__ParametersAssignment_4_1_1"


    // $ANTLR start "rule__ParameterRule__TypeAssignment_0"
    // InternalDefinitionLanguage.g:4542:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4546:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:4547:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:4547:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:4548:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:4557:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4561:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4562:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:4562:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4563:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:4572:1: rule__FunctionNameRule__DefinitionAssignment : ( ( ruleStringOrId ) ) ;
    public final void rule__FunctionNameRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4576:1: ( ( ( ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:4577:2: ( ( ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:4577:2: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4578:3: ( ruleStringOrId )
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
            // InternalDefinitionLanguage.g:4579:3: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4580:4: ruleStringOrId
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionStringOrIdParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;

             after(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionStringOrIdParserRuleCall_0_1()); 

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


    // $ANTLR start "rule__OrExpressionRule__SubExpressionsAssignment_0"
    // InternalDefinitionLanguage.g:4591:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4595:1: ( ( ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:4596:2: ( ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:4596:2: ( ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:4597:3: ruleXorExpressionRule
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
    // InternalDefinitionLanguage.g:4606:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4610:1: ( ( ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:4611:2: ( ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:4611:2: ( ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:4612:3: ruleXorExpressionRule
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
    // InternalDefinitionLanguage.g:4621:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4625:1: ( ( ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:4626:2: ( ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:4626:2: ( ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:4627:3: ruleAndExpressionRule
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
    // InternalDefinitionLanguage.g:4636:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4640:1: ( ( ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:4641:2: ( ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:4641:2: ( ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:4642:3: ruleAndExpressionRule
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
    // InternalDefinitionLanguage.g:4651:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4655:1: ( ( ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:4656:2: ( ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:4656:2: ( ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:4657:3: ruleNotExpressionRule
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
    // InternalDefinitionLanguage.g:4666:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4670:1: ( ( ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:4671:2: ( ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:4671:2: ( ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:4672:3: ruleNotExpressionRule
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
    // InternalDefinitionLanguage.g:4681:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4685:1: ( ( ( '!' ) ) )
            // InternalDefinitionLanguage.g:4686:2: ( ( '!' ) )
            {
            // InternalDefinitionLanguage.g:4686:2: ( ( '!' ) )
            // InternalDefinitionLanguage.g:4687:3: ( '!' )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            // InternalDefinitionLanguage.g:4688:3: ( '!' )
            // InternalDefinitionLanguage.g:4689:4: '!'
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4700:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4704:1: ( ( ruleComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:4705:2: ( ruleComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:4705:2: ( ruleComparisonExpressionRule )
            // InternalDefinitionLanguage.g:4706:3: ruleComparisonExpressionRule
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
    // InternalDefinitionLanguage.g:4715:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4719:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:4720:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:4720:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:4721:3: ruleAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:4730:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4734:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:4735:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:4735:2: ( rulePartialComparisonExpressionRule )
            // InternalDefinitionLanguage.g:4736:3: rulePartialComparisonExpressionRule
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
    // InternalDefinitionLanguage.g:4745:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4749:1: ( ( ruleComparisonOperatorRule ) )
            // InternalDefinitionLanguage.g:4750:2: ( ruleComparisonOperatorRule )
            {
            // InternalDefinitionLanguage.g:4750:2: ( ruleComparisonOperatorRule )
            // InternalDefinitionLanguage.g:4751:3: ruleComparisonOperatorRule
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
    // InternalDefinitionLanguage.g:4760:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4764:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:4765:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:4765:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:4766:3: ruleAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:4775:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4779:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:4780:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:4780:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:4781:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDefinitionLanguage.g:4790:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4794:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDefinitionLanguage.g:4795:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDefinitionLanguage.g:4795:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDefinitionLanguage.g:4796:3: ruleAddOrSubtractOperatorRule
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
    // InternalDefinitionLanguage.g:4805:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4809:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:4810:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:4810:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:4811:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDefinitionLanguage.g:4820:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4824:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:4825:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:4825:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:4826:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:4835:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4839:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalDefinitionLanguage.g:4840:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalDefinitionLanguage.g:4840:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalDefinitionLanguage.g:4841:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalDefinitionLanguage.g:4850:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4854:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:4855:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:4855:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:4856:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:4865:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4869:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:4870:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:4870:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:4871:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:4880:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4884:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:4885:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:4885:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:4886:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:4895:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4899:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDefinitionLanguage.g:4900:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDefinitionLanguage.g:4900:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDefinitionLanguage.g:4901:3: ruleAddOrSubtractOperatorRule
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
    // InternalDefinitionLanguage.g:4910:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleLiteralOrReferenceRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4914:1: ( ( ruleLiteralOrReferenceRule ) )
            // InternalDefinitionLanguage.g:4915:2: ( ruleLiteralOrReferenceRule )
            {
            // InternalDefinitionLanguage.g:4915:2: ( ruleLiteralOrReferenceRule )
            // InternalDefinitionLanguage.g:4916:3: ruleLiteralOrReferenceRule
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
    // InternalDefinitionLanguage.g:4925:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4929:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:4930:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:4930:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:4931:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:4940:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4944:1: ( ( ruleFunctionNameRule ) )
            // InternalDefinitionLanguage.g:4945:2: ( ruleFunctionNameRule )
            {
            // InternalDefinitionLanguage.g:4945:2: ( ruleFunctionNameRule )
            // InternalDefinitionLanguage.g:4946:3: ruleFunctionNameRule
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
    // InternalDefinitionLanguage.g:4955:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4959:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:4960:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:4960:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:4961:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:4970:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4974:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:4975:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:4975:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:4976:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:4985:1: rule__DoubleLiteralRule__ValueAssignment : ( ruleDOUBLE ) ;
    public final void rule__DoubleLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4989:1: ( ( ruleDOUBLE ) )
            // InternalDefinitionLanguage.g:4990:2: ( ruleDOUBLE )
            {
            // InternalDefinitionLanguage.g:4990:2: ( ruleDOUBLE )
            // InternalDefinitionLanguage.g:4991:3: ruleDOUBLE
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
    // InternalDefinitionLanguage.g:5000:1: rule__IntegerLiteralRule__ValueAssignment : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5004:1: ( ( RULE_INT ) )
            // InternalDefinitionLanguage.g:5005:2: ( RULE_INT )
            {
            // InternalDefinitionLanguage.g:5005:2: ( RULE_INT )
            // InternalDefinitionLanguage.g:5006:3: RULE_INT
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
    // InternalDefinitionLanguage.g:5015:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5019:1: ( ( RULE_STRING ) )
            // InternalDefinitionLanguage.g:5020:2: ( RULE_STRING )
            {
            // InternalDefinitionLanguage.g:5020:2: ( RULE_STRING )
            // InternalDefinitionLanguage.g:5021:3: RULE_STRING
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
    // InternalDefinitionLanguage.g:5030:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5034:1: ( ( ( 'true' ) ) )
            // InternalDefinitionLanguage.g:5035:2: ( ( 'true' ) )
            {
            // InternalDefinitionLanguage.g:5035:2: ( ( 'true' ) )
            // InternalDefinitionLanguage.g:5036:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            // InternalDefinitionLanguage.g:5037:3: ( 'true' )
            // InternalDefinitionLanguage.g:5038:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            match(input,54,FOLLOW_2); 
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0010040001000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0010000001000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000014000030L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000010000032L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000003FD80000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000013FD80000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00640800001810F0L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000000000007E000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00641800001810F0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00400000000010C0L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000040L});

}
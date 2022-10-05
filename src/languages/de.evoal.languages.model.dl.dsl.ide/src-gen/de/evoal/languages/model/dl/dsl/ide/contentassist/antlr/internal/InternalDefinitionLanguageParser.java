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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_ID", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", "'type'", "'{'", "'}'", "'extends'", "'unnamed'", "':'", "';'", "'literal'", "'instance'", "'|'", "'string'", "'expression'", "'int'", "'float'", "'boolean'", "'void'", "'data'", "'array'", "'def'", "'('", "')'", "','", "'OR'", "'XOR'", "'AND'", "'^'", "'value'", "'.'", "'abstract'", "'!'", "'true'"
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
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
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

                if ( (LA1_0==44||LA1_0==62||LA1_0==72) ) {
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
    // InternalDefinitionLanguage.g:963:1: ruleDoubleLiteralRule : ( ( rule__DoubleLiteralRule__Group__0 ) ) ;
    public final void ruleDoubleLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:967:2: ( ( ( rule__DoubleLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:968:2: ( ( rule__DoubleLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:968:2: ( ( rule__DoubleLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:969:3: ( rule__DoubleLiteralRule__Group__0 )
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:970:3: ( rule__DoubleLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:970:4: rule__DoubleLiteralRule__Group__0
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
    // InternalDefinitionLanguage.g:988:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__Group__0 ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:992:2: ( ( ( rule__IntegerLiteralRule__Group__0 ) ) )
            // InternalDefinitionLanguage.g:993:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            {
            // InternalDefinitionLanguage.g:993:2: ( ( rule__IntegerLiteralRule__Group__0 ) )
            // InternalDefinitionLanguage.g:994:3: ( rule__IntegerLiteralRule__Group__0 )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getGroup()); 
            // InternalDefinitionLanguage.g:995:3: ( rule__IntegerLiteralRule__Group__0 )
            // InternalDefinitionLanguage.g:995:4: rule__IntegerLiteralRule__Group__0
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


    // $ANTLR start "ruleFactorRule"
    // InternalDefinitionLanguage.g:1152:1: ruleFactorRule : ( ( rule__FactorRule__Alternatives ) ) ;
    public final void ruleFactorRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1156:1: ( ( ( rule__FactorRule__Alternatives ) ) )
            // InternalDefinitionLanguage.g:1157:2: ( ( rule__FactorRule__Alternatives ) )
            {
            // InternalDefinitionLanguage.g:1157:2: ( ( rule__FactorRule__Alternatives ) )
            // InternalDefinitionLanguage.g:1158:3: ( rule__FactorRule__Alternatives )
            {
             before(grammarAccess.getFactorRuleAccess().getAlternatives()); 
            // InternalDefinitionLanguage.g:1159:3: ( rule__FactorRule__Alternatives )
            // InternalDefinitionLanguage.g:1159:4: rule__FactorRule__Alternatives
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


    // $ANTLR start "rule__DefinitionModelRule__Alternatives"
    // InternalDefinitionLanguage.g:1167:1: rule__DefinitionModelRule__Alternatives : ( ( ( rule__DefinitionModelRule__TypesAssignment_0 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_1 ) ) );
    public final void rule__DefinitionModelRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1171:1: ( ( ( rule__DefinitionModelRule__TypesAssignment_0 ) ) | ( ( rule__DefinitionModelRule__FunctionsAssignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==44||LA2_0==72) ) {
                alt2=1;
            }
            else if ( (LA2_0==62) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalDefinitionLanguage.g:1172:2: ( ( rule__DefinitionModelRule__TypesAssignment_0 ) )
                    {
                    // InternalDefinitionLanguage.g:1172:2: ( ( rule__DefinitionModelRule__TypesAssignment_0 ) )
                    // InternalDefinitionLanguage.g:1173:3: ( rule__DefinitionModelRule__TypesAssignment_0 )
                    {
                     before(grammarAccess.getDefinitionModelRuleAccess().getTypesAssignment_0()); 
                    // InternalDefinitionLanguage.g:1174:3: ( rule__DefinitionModelRule__TypesAssignment_0 )
                    // InternalDefinitionLanguage.g:1174:4: rule__DefinitionModelRule__TypesAssignment_0
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
                    // InternalDefinitionLanguage.g:1178:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_1 ) )
                    {
                    // InternalDefinitionLanguage.g:1178:2: ( ( rule__DefinitionModelRule__FunctionsAssignment_1 ) )
                    // InternalDefinitionLanguage.g:1179:3: ( rule__DefinitionModelRule__FunctionsAssignment_1 )
                    {
                     before(grammarAccess.getDefinitionModelRuleAccess().getFunctionsAssignment_1()); 
                    // InternalDefinitionLanguage.g:1180:3: ( rule__DefinitionModelRule__FunctionsAssignment_1 )
                    // InternalDefinitionLanguage.g:1180:4: rule__DefinitionModelRule__FunctionsAssignment_1
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
    // InternalDefinitionLanguage.g:1188:1: rule__AttributeDefinitionRule__Alternatives : ( ( ruleNamedAttributeDefinitionRule ) | ( ruleUnnamedAttributeDefinitionRule ) );
    public final void rule__AttributeDefinitionRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1192:1: ( ( ruleNamedAttributeDefinitionRule ) | ( ruleUnnamedAttributeDefinitionRule ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_QUOTED_ID && LA3_0<=RULE_ID)) ) {
                alt3=1;
            }
            else if ( (LA3_0==48) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalDefinitionLanguage.g:1193:2: ( ruleNamedAttributeDefinitionRule )
                    {
                    // InternalDefinitionLanguage.g:1193:2: ( ruleNamedAttributeDefinitionRule )
                    // InternalDefinitionLanguage.g:1194:3: ruleNamedAttributeDefinitionRule
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
                    // InternalDefinitionLanguage.g:1199:2: ( ruleUnnamedAttributeDefinitionRule )
                    {
                    // InternalDefinitionLanguage.g:1199:2: ( ruleUnnamedAttributeDefinitionRule )
                    // InternalDefinitionLanguage.g:1200:3: ruleUnnamedAttributeDefinitionRule
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
    // InternalDefinitionLanguage.g:1209:1: rule__TypeRule__Alternatives : ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) );
    public final void rule__TypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1213:1: ( ( ruleStringTypeRule ) | ( ruleIntTypeRule ) | ( ruleFloatTypeRule ) | ( ruleBooleanTypeRule ) | ( ruleLiteralTypeRule ) | ( ruleArrayTypeRule ) | ( ruleInstanceTypeRule ) | ( ruleVoidTypeRule ) | ( ruleExpressionTypeRule ) | ( ruleDataTypeRule ) )
            int alt4=10;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt4=1;
                }
                break;
            case 56:
                {
                alt4=2;
                }
                break;
            case 57:
                {
                alt4=3;
                }
                break;
            case 58:
                {
                alt4=4;
                }
                break;
            case 51:
                {
                alt4=5;
                }
                break;
            case 61:
                {
                alt4=6;
                }
                break;
            case 52:
                {
                alt4=7;
                }
                break;
            case 59:
                {
                alt4=8;
                }
                break;
            case 55:
                {
                alt4=9;
                }
                break;
            case 60:
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
                    // InternalDefinitionLanguage.g:1214:2: ( ruleStringTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1214:2: ( ruleStringTypeRule )
                    // InternalDefinitionLanguage.g:1215:3: ruleStringTypeRule
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
                    // InternalDefinitionLanguage.g:1220:2: ( ruleIntTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1220:2: ( ruleIntTypeRule )
                    // InternalDefinitionLanguage.g:1221:3: ruleIntTypeRule
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
                    // InternalDefinitionLanguage.g:1226:2: ( ruleFloatTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1226:2: ( ruleFloatTypeRule )
                    // InternalDefinitionLanguage.g:1227:3: ruleFloatTypeRule
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
                    // InternalDefinitionLanguage.g:1232:2: ( ruleBooleanTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1232:2: ( ruleBooleanTypeRule )
                    // InternalDefinitionLanguage.g:1233:3: ruleBooleanTypeRule
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
                    // InternalDefinitionLanguage.g:1238:2: ( ruleLiteralTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1238:2: ( ruleLiteralTypeRule )
                    // InternalDefinitionLanguage.g:1239:3: ruleLiteralTypeRule
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
                    // InternalDefinitionLanguage.g:1244:2: ( ruleArrayTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1244:2: ( ruleArrayTypeRule )
                    // InternalDefinitionLanguage.g:1245:3: ruleArrayTypeRule
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
                    // InternalDefinitionLanguage.g:1250:2: ( ruleInstanceTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1250:2: ( ruleInstanceTypeRule )
                    // InternalDefinitionLanguage.g:1251:3: ruleInstanceTypeRule
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
                    // InternalDefinitionLanguage.g:1256:2: ( ruleVoidTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1256:2: ( ruleVoidTypeRule )
                    // InternalDefinitionLanguage.g:1257:3: ruleVoidTypeRule
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
                    // InternalDefinitionLanguage.g:1262:2: ( ruleExpressionTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1262:2: ( ruleExpressionTypeRule )
                    // InternalDefinitionLanguage.g:1263:3: ruleExpressionTypeRule
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
                    // InternalDefinitionLanguage.g:1268:2: ( ruleDataTypeRule )
                    {
                    // InternalDefinitionLanguage.g:1268:2: ( ruleDataTypeRule )
                    // InternalDefinitionLanguage.g:1269:3: ruleDataTypeRule
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
    // InternalDefinitionLanguage.g:1278:1: rule__LiteralOrReferenceRule__Alternatives : ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) );
    public final void rule__LiteralOrReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1282:1: ( ( ruleCallRule ) | ( ruleLiteralRule ) | ( ruleParanthesesRule ) | ( ruleValueReferenceRule ) )
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
            case 74:
                {
                alt5=2;
                }
                break;
            case 63:
                {
                alt5=3;
                }
                break;
            case 70:
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
                    // InternalDefinitionLanguage.g:1283:2: ( ruleCallRule )
                    {
                    // InternalDefinitionLanguage.g:1283:2: ( ruleCallRule )
                    // InternalDefinitionLanguage.g:1284:3: ruleCallRule
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
                    // InternalDefinitionLanguage.g:1289:2: ( ruleLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1289:2: ( ruleLiteralRule )
                    // InternalDefinitionLanguage.g:1290:3: ruleLiteralRule
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
                    // InternalDefinitionLanguage.g:1295:2: ( ruleParanthesesRule )
                    {
                    // InternalDefinitionLanguage.g:1295:2: ( ruleParanthesesRule )
                    // InternalDefinitionLanguage.g:1296:3: ruleParanthesesRule
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
                    // InternalDefinitionLanguage.g:1301:2: ( ruleValueReferenceRule )
                    {
                    // InternalDefinitionLanguage.g:1301:2: ( ruleValueReferenceRule )
                    // InternalDefinitionLanguage.g:1302:3: ruleValueReferenceRule
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
    // InternalDefinitionLanguage.g:1311:1: rule__LiteralRule__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) );
    public final void rule__LiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1315:1: ( ( ruleNumberLiteralRule ) | ( ruleStringLiteralRule ) | ( ruleBooleanLiteralRule ) )
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
            case 74:
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
                    // InternalDefinitionLanguage.g:1316:2: ( ruleNumberLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1316:2: ( ruleNumberLiteralRule )
                    // InternalDefinitionLanguage.g:1317:3: ruleNumberLiteralRule
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
                    // InternalDefinitionLanguage.g:1322:2: ( ruleStringLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1322:2: ( ruleStringLiteralRule )
                    // InternalDefinitionLanguage.g:1323:3: ruleStringLiteralRule
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
                    // InternalDefinitionLanguage.g:1328:2: ( ruleBooleanLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1328:2: ( ruleBooleanLiteralRule )
                    // InternalDefinitionLanguage.g:1329:3: ruleBooleanLiteralRule
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
    // InternalDefinitionLanguage.g:1338:1: rule__NumberLiteralRule__Alternatives : ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1342:1: ( ( ruleDoubleLiteralRule ) | ( ruleIntegerLiteralRule ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_INT) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==EOF||(LA7_1>=13 && LA7_1<=43)||(LA7_1>=64 && LA7_1<=69)) ) {
                    alt7=2;
                }
                else if ( (LA7_1==71) ) {
                    alt7=1;
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
                    // InternalDefinitionLanguage.g:1343:2: ( ruleDoubleLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1343:2: ( ruleDoubleLiteralRule )
                    // InternalDefinitionLanguage.g:1344:3: ruleDoubleLiteralRule
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
                    // InternalDefinitionLanguage.g:1349:2: ( ruleIntegerLiteralRule )
                    {
                    // InternalDefinitionLanguage.g:1349:2: ( ruleIntegerLiteralRule )
                    // InternalDefinitionLanguage.g:1350:3: ruleIntegerLiteralRule
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
    // InternalDefinitionLanguage.g:1359:1: rule__BooleanLiteralRule__Alternatives_1 : ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1363:1: ( ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) ) | ( 'false' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==74) ) {
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
                    // InternalDefinitionLanguage.g:1364:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    {
                    // InternalDefinitionLanguage.g:1364:2: ( ( rule__BooleanLiteralRule__ValueAssignment_1_0 ) )
                    // InternalDefinitionLanguage.g:1365:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    {
                     before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment_1_0()); 
                    // InternalDefinitionLanguage.g:1366:3: ( rule__BooleanLiteralRule__ValueAssignment_1_0 )
                    // InternalDefinitionLanguage.g:1366:4: rule__BooleanLiteralRule__ValueAssignment_1_0
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
                    // InternalDefinitionLanguage.g:1370:2: ( 'false' )
                    {
                    // InternalDefinitionLanguage.g:1370:2: ( 'false' )
                    // InternalDefinitionLanguage.g:1371:3: 'false'
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
    // InternalDefinitionLanguage.g:1380:1: rule__StringOrId__Alternatives : ( ( RULE_QUOTED_ID ) | ( RULE_ID ) );
    public final void rule__StringOrId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1384:1: ( ( RULE_QUOTED_ID ) | ( RULE_ID ) )
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
                    // InternalDefinitionLanguage.g:1385:2: ( RULE_QUOTED_ID )
                    {
                    // InternalDefinitionLanguage.g:1385:2: ( RULE_QUOTED_ID )
                    // InternalDefinitionLanguage.g:1386:3: RULE_QUOTED_ID
                    {
                     before(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 
                    match(input,RULE_QUOTED_ID,FOLLOW_2); 
                     after(grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1391:2: ( RULE_ID )
                    {
                    // InternalDefinitionLanguage.g:1391:2: ( RULE_ID )
                    // InternalDefinitionLanguage.g:1392:3: RULE_ID
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
    // InternalDefinitionLanguage.g:1401:1: rule__ComparisonOperatorRule__Alternatives : ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1405:1: ( ( ( '>=' ) ) | ( ( '>' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
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
                    // InternalDefinitionLanguage.g:1406:2: ( ( '>=' ) )
                    {
                    // InternalDefinitionLanguage.g:1406:2: ( ( '>=' ) )
                    // InternalDefinitionLanguage.g:1407:3: ( '>=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1408:3: ( '>=' )
                    // InternalDefinitionLanguage.g:1408:4: '>='
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1412:2: ( ( '>' ) )
                    {
                    // InternalDefinitionLanguage.g:1412:2: ( ( '>' ) )
                    // InternalDefinitionLanguage.g:1413:3: ( '>' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1414:3: ( '>' )
                    // InternalDefinitionLanguage.g:1414:4: '>'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1418:2: ( ( '=' ) )
                    {
                    // InternalDefinitionLanguage.g:1418:2: ( ( '=' ) )
                    // InternalDefinitionLanguage.g:1419:3: ( '=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 
                    // InternalDefinitionLanguage.g:1420:3: ( '=' )
                    // InternalDefinitionLanguage.g:1420:4: '='
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:1424:2: ( ( '!=' ) )
                    {
                    // InternalDefinitionLanguage.g:1424:2: ( ( '!=' ) )
                    // InternalDefinitionLanguage.g:1425:3: ( '!=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 
                    // InternalDefinitionLanguage.g:1426:3: ( '!=' )
                    // InternalDefinitionLanguage.g:1426:4: '!='
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:1430:2: ( ( '<' ) )
                    {
                    // InternalDefinitionLanguage.g:1430:2: ( ( '<' ) )
                    // InternalDefinitionLanguage.g:1431:3: ( '<' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 
                    // InternalDefinitionLanguage.g:1432:3: ( '<' )
                    // InternalDefinitionLanguage.g:1432:4: '<'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:1436:2: ( ( '<=' ) )
                    {
                    // InternalDefinitionLanguage.g:1436:2: ( ( '<=' ) )
                    // InternalDefinitionLanguage.g:1437:3: ( '<=' )
                    {
                     before(grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5()); 
                    // InternalDefinitionLanguage.g:1438:3: ( '<=' )
                    // InternalDefinitionLanguage.g:1438:4: '<='
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
    // InternalDefinitionLanguage.g:1446:1: rule__AddOrSubtractOperatorRule__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOrSubtractOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1450:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
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
                    // InternalDefinitionLanguage.g:1451:2: ( ( '+' ) )
                    {
                    // InternalDefinitionLanguage.g:1451:2: ( ( '+' ) )
                    // InternalDefinitionLanguage.g:1452:3: ( '+' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1453:3: ( '+' )
                    // InternalDefinitionLanguage.g:1453:4: '+'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1457:2: ( ( '-' ) )
                    {
                    // InternalDefinitionLanguage.g:1457:2: ( ( '-' ) )
                    // InternalDefinitionLanguage.g:1458:3: ( '-' )
                    {
                     before(grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1459:3: ( '-' )
                    // InternalDefinitionLanguage.g:1459:4: '-'
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
    // InternalDefinitionLanguage.g:1467:1: rule__MultiplyDivideModuloOperatorRule__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplyDivideModuloOperatorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1471:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
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
                    // InternalDefinitionLanguage.g:1472:2: ( ( '*' ) )
                    {
                    // InternalDefinitionLanguage.g:1472:2: ( ( '*' ) )
                    // InternalDefinitionLanguage.g:1473:3: ( '*' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1474:3: ( '*' )
                    // InternalDefinitionLanguage.g:1474:4: '*'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1478:2: ( ( '/' ) )
                    {
                    // InternalDefinitionLanguage.g:1478:2: ( ( '/' ) )
                    // InternalDefinitionLanguage.g:1479:3: ( '/' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1480:3: ( '/' )
                    // InternalDefinitionLanguage.g:1480:4: '/'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1484:2: ( ( '%' ) )
                    {
                    // InternalDefinitionLanguage.g:1484:2: ( ( '%' ) )
                    // InternalDefinitionLanguage.g:1485:3: ( '%' )
                    {
                     before(grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2()); 
                    // InternalDefinitionLanguage.g:1486:3: ( '%' )
                    // InternalDefinitionLanguage.g:1486:4: '%'
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


    // $ANTLR start "rule__FactorRule__Alternatives"
    // InternalDefinitionLanguage.g:1494:1: rule__FactorRule__Alternatives : ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) );
    public final void rule__FactorRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1498:1: ( ( ( 'Y' ) ) | ( ( 'Z' ) ) | ( ( 'E' ) ) | ( ( 'P' ) ) | ( ( 'T' ) ) | ( ( 'G' ) ) | ( ( 'M' ) ) | ( ( 'k' ) ) | ( ( 'h' ) ) | ( ( 'da' ) ) | ( ( 'd' ) ) | ( ( 'c' ) ) | ( ( 'm' ) ) | ( ( '\\u00B5' ) ) | ( ( 'n' ) ) | ( ( 'p' ) ) | ( ( 'f' ) ) | ( ( 'a' ) ) | ( ( 'z' ) ) | ( ( 'y' ) ) )
            int alt13=20;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt13=1;
                }
                break;
            case 25:
                {
                alt13=2;
                }
                break;
            case 26:
                {
                alt13=3;
                }
                break;
            case 27:
                {
                alt13=4;
                }
                break;
            case 28:
                {
                alt13=5;
                }
                break;
            case 29:
                {
                alt13=6;
                }
                break;
            case 30:
                {
                alt13=7;
                }
                break;
            case 31:
                {
                alt13=8;
                }
                break;
            case 32:
                {
                alt13=9;
                }
                break;
            case 33:
                {
                alt13=10;
                }
                break;
            case 34:
                {
                alt13=11;
                }
                break;
            case 35:
                {
                alt13=12;
                }
                break;
            case 36:
                {
                alt13=13;
                }
                break;
            case 37:
                {
                alt13=14;
                }
                break;
            case 38:
                {
                alt13=15;
                }
                break;
            case 39:
                {
                alt13=16;
                }
                break;
            case 40:
                {
                alt13=17;
                }
                break;
            case 41:
                {
                alt13=18;
                }
                break;
            case 42:
                {
                alt13=19;
                }
                break;
            case 43:
                {
                alt13=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalDefinitionLanguage.g:1499:2: ( ( 'Y' ) )
                    {
                    // InternalDefinitionLanguage.g:1499:2: ( ( 'Y' ) )
                    // InternalDefinitionLanguage.g:1500:3: ( 'Y' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 
                    // InternalDefinitionLanguage.g:1501:3: ( 'Y' )
                    // InternalDefinitionLanguage.g:1501:4: 'Y'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1505:2: ( ( 'Z' ) )
                    {
                    // InternalDefinitionLanguage.g:1505:2: ( ( 'Z' ) )
                    // InternalDefinitionLanguage.g:1506:3: ( 'Z' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 
                    // InternalDefinitionLanguage.g:1507:3: ( 'Z' )
                    // InternalDefinitionLanguage.g:1507:4: 'Z'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1511:2: ( ( 'E' ) )
                    {
                    // InternalDefinitionLanguage.g:1511:2: ( ( 'E' ) )
                    // InternalDefinitionLanguage.g:1512:3: ( 'E' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 
                    // InternalDefinitionLanguage.g:1513:3: ( 'E' )
                    // InternalDefinitionLanguage.g:1513:4: 'E'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:1517:2: ( ( 'P' ) )
                    {
                    // InternalDefinitionLanguage.g:1517:2: ( ( 'P' ) )
                    // InternalDefinitionLanguage.g:1518:3: ( 'P' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 
                    // InternalDefinitionLanguage.g:1519:3: ( 'P' )
                    // InternalDefinitionLanguage.g:1519:4: 'P'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:1523:2: ( ( 'T' ) )
                    {
                    // InternalDefinitionLanguage.g:1523:2: ( ( 'T' ) )
                    // InternalDefinitionLanguage.g:1524:3: ( 'T' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 
                    // InternalDefinitionLanguage.g:1525:3: ( 'T' )
                    // InternalDefinitionLanguage.g:1525:4: 'T'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:1529:2: ( ( 'G' ) )
                    {
                    // InternalDefinitionLanguage.g:1529:2: ( ( 'G' ) )
                    // InternalDefinitionLanguage.g:1530:3: ( 'G' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 
                    // InternalDefinitionLanguage.g:1531:3: ( 'G' )
                    // InternalDefinitionLanguage.g:1531:4: 'G'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDefinitionLanguage.g:1535:2: ( ( 'M' ) )
                    {
                    // InternalDefinitionLanguage.g:1535:2: ( ( 'M' ) )
                    // InternalDefinitionLanguage.g:1536:3: ( 'M' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 
                    // InternalDefinitionLanguage.g:1537:3: ( 'M' )
                    // InternalDefinitionLanguage.g:1537:4: 'M'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDefinitionLanguage.g:1541:2: ( ( 'k' ) )
                    {
                    // InternalDefinitionLanguage.g:1541:2: ( ( 'k' ) )
                    // InternalDefinitionLanguage.g:1542:3: ( 'k' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 
                    // InternalDefinitionLanguage.g:1543:3: ( 'k' )
                    // InternalDefinitionLanguage.g:1543:4: 'k'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDefinitionLanguage.g:1547:2: ( ( 'h' ) )
                    {
                    // InternalDefinitionLanguage.g:1547:2: ( ( 'h' ) )
                    // InternalDefinitionLanguage.g:1548:3: ( 'h' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 
                    // InternalDefinitionLanguage.g:1549:3: ( 'h' )
                    // InternalDefinitionLanguage.g:1549:4: 'h'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDefinitionLanguage.g:1553:2: ( ( 'da' ) )
                    {
                    // InternalDefinitionLanguage.g:1553:2: ( ( 'da' ) )
                    // InternalDefinitionLanguage.g:1554:3: ( 'da' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 
                    // InternalDefinitionLanguage.g:1555:3: ( 'da' )
                    // InternalDefinitionLanguage.g:1555:4: 'da'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDefinitionLanguage.g:1559:2: ( ( 'd' ) )
                    {
                    // InternalDefinitionLanguage.g:1559:2: ( ( 'd' ) )
                    // InternalDefinitionLanguage.g:1560:3: ( 'd' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 
                    // InternalDefinitionLanguage.g:1561:3: ( 'd' )
                    // InternalDefinitionLanguage.g:1561:4: 'd'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDefinitionLanguage.g:1565:2: ( ( 'c' ) )
                    {
                    // InternalDefinitionLanguage.g:1565:2: ( ( 'c' ) )
                    // InternalDefinitionLanguage.g:1566:3: ( 'c' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 
                    // InternalDefinitionLanguage.g:1567:3: ( 'c' )
                    // InternalDefinitionLanguage.g:1567:4: 'c'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDefinitionLanguage.g:1571:2: ( ( 'm' ) )
                    {
                    // InternalDefinitionLanguage.g:1571:2: ( ( 'm' ) )
                    // InternalDefinitionLanguage.g:1572:3: ( 'm' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 
                    // InternalDefinitionLanguage.g:1573:3: ( 'm' )
                    // InternalDefinitionLanguage.g:1573:4: 'm'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDefinitionLanguage.g:1577:2: ( ( '\\u00B5' ) )
                    {
                    // InternalDefinitionLanguage.g:1577:2: ( ( '\\u00B5' ) )
                    // InternalDefinitionLanguage.g:1578:3: ( '\\u00B5' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 
                    // InternalDefinitionLanguage.g:1579:3: ( '\\u00B5' )
                    // InternalDefinitionLanguage.g:1579:4: '\\u00B5'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDefinitionLanguage.g:1583:2: ( ( 'n' ) )
                    {
                    // InternalDefinitionLanguage.g:1583:2: ( ( 'n' ) )
                    // InternalDefinitionLanguage.g:1584:3: ( 'n' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 
                    // InternalDefinitionLanguage.g:1585:3: ( 'n' )
                    // InternalDefinitionLanguage.g:1585:4: 'n'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDefinitionLanguage.g:1589:2: ( ( 'p' ) )
                    {
                    // InternalDefinitionLanguage.g:1589:2: ( ( 'p' ) )
                    // InternalDefinitionLanguage.g:1590:3: ( 'p' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 
                    // InternalDefinitionLanguage.g:1591:3: ( 'p' )
                    // InternalDefinitionLanguage.g:1591:4: 'p'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDefinitionLanguage.g:1595:2: ( ( 'f' ) )
                    {
                    // InternalDefinitionLanguage.g:1595:2: ( ( 'f' ) )
                    // InternalDefinitionLanguage.g:1596:3: ( 'f' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 
                    // InternalDefinitionLanguage.g:1597:3: ( 'f' )
                    // InternalDefinitionLanguage.g:1597:4: 'f'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDefinitionLanguage.g:1601:2: ( ( 'a' ) )
                    {
                    // InternalDefinitionLanguage.g:1601:2: ( ( 'a' ) )
                    // InternalDefinitionLanguage.g:1602:3: ( 'a' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 
                    // InternalDefinitionLanguage.g:1603:3: ( 'a' )
                    // InternalDefinitionLanguage.g:1603:4: 'a'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalDefinitionLanguage.g:1607:2: ( ( 'z' ) )
                    {
                    // InternalDefinitionLanguage.g:1607:2: ( ( 'z' ) )
                    // InternalDefinitionLanguage.g:1608:3: ( 'z' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 
                    // InternalDefinitionLanguage.g:1609:3: ( 'z' )
                    // InternalDefinitionLanguage.g:1609:4: 'z'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalDefinitionLanguage.g:1613:2: ( ( 'y' ) )
                    {
                    // InternalDefinitionLanguage.g:1613:2: ( ( 'y' ) )
                    // InternalDefinitionLanguage.g:1614:3: ( 'y' )
                    {
                     before(grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19()); 
                    // InternalDefinitionLanguage.g:1615:3: ( 'y' )
                    // InternalDefinitionLanguage.g:1615:4: 'y'
                    {
                    match(input,43,FOLLOW_2); 

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


    // $ANTLR start "rule__TypeDefinitionRule__Group__0"
    // InternalDefinitionLanguage.g:1623:1: rule__TypeDefinitionRule__Group__0 : rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1 ;
    public final void rule__TypeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1627:1: ( rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:1628:2: rule__TypeDefinitionRule__Group__0__Impl rule__TypeDefinitionRule__Group__1
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
    // InternalDefinitionLanguage.g:1635:1: rule__TypeDefinitionRule__Group__0__Impl : ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? ) ;
    public final void rule__TypeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1639:1: ( ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? ) )
            // InternalDefinitionLanguage.g:1640:1: ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? )
            {
            // InternalDefinitionLanguage.g:1640:1: ( ( rule__TypeDefinitionRule__AbstractAssignment_0 )? )
            // InternalDefinitionLanguage.g:1641:2: ( rule__TypeDefinitionRule__AbstractAssignment_0 )?
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAssignment_0()); 
            // InternalDefinitionLanguage.g:1642:2: ( rule__TypeDefinitionRule__AbstractAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==72) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDefinitionLanguage.g:1642:3: rule__TypeDefinitionRule__AbstractAssignment_0
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
    // InternalDefinitionLanguage.g:1650:1: rule__TypeDefinitionRule__Group__1 : rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2 ;
    public final void rule__TypeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1654:1: ( rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:1655:2: rule__TypeDefinitionRule__Group__1__Impl rule__TypeDefinitionRule__Group__2
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
    // InternalDefinitionLanguage.g:1662:1: rule__TypeDefinitionRule__Group__1__Impl : ( 'type' ) ;
    public final void rule__TypeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1666:1: ( ( 'type' ) )
            // InternalDefinitionLanguage.g:1667:1: ( 'type' )
            {
            // InternalDefinitionLanguage.g:1667:1: ( 'type' )
            // InternalDefinitionLanguage.g:1668:2: 'type'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getTypeKeyword_1()); 
            match(input,44,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:1677:1: rule__TypeDefinitionRule__Group__2 : rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3 ;
    public final void rule__TypeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1681:1: ( rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:1682:2: rule__TypeDefinitionRule__Group__2__Impl rule__TypeDefinitionRule__Group__3
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
    // InternalDefinitionLanguage.g:1689:1: rule__TypeDefinitionRule__Group__2__Impl : ( ( rule__TypeDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__TypeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1693:1: ( ( ( rule__TypeDefinitionRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:1694:1: ( ( rule__TypeDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:1694:1: ( ( rule__TypeDefinitionRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:1695:2: ( rule__TypeDefinitionRule__NameAssignment_2 )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getNameAssignment_2()); 
            // InternalDefinitionLanguage.g:1696:2: ( rule__TypeDefinitionRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:1696:3: rule__TypeDefinitionRule__NameAssignment_2
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
    // InternalDefinitionLanguage.g:1704:1: rule__TypeDefinitionRule__Group__3 : rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4 ;
    public final void rule__TypeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1708:1: ( rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:1709:2: rule__TypeDefinitionRule__Group__3__Impl rule__TypeDefinitionRule__Group__4
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
    // InternalDefinitionLanguage.g:1716:1: rule__TypeDefinitionRule__Group__3__Impl : ( ( rule__TypeDefinitionRule__Group_3__0 )? ) ;
    public final void rule__TypeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1720:1: ( ( ( rule__TypeDefinitionRule__Group_3__0 )? ) )
            // InternalDefinitionLanguage.g:1721:1: ( ( rule__TypeDefinitionRule__Group_3__0 )? )
            {
            // InternalDefinitionLanguage.g:1721:1: ( ( rule__TypeDefinitionRule__Group_3__0 )? )
            // InternalDefinitionLanguage.g:1722:2: ( rule__TypeDefinitionRule__Group_3__0 )?
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getGroup_3()); 
            // InternalDefinitionLanguage.g:1723:2: ( rule__TypeDefinitionRule__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==47) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDefinitionLanguage.g:1723:3: rule__TypeDefinitionRule__Group_3__0
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
    // InternalDefinitionLanguage.g:1731:1: rule__TypeDefinitionRule__Group__4 : rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5 ;
    public final void rule__TypeDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1735:1: ( rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:1736:2: rule__TypeDefinitionRule__Group__4__Impl rule__TypeDefinitionRule__Group__5
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
    // InternalDefinitionLanguage.g:1743:1: rule__TypeDefinitionRule__Group__4__Impl : ( '{' ) ;
    public final void rule__TypeDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1747:1: ( ( '{' ) )
            // InternalDefinitionLanguage.g:1748:1: ( '{' )
            {
            // InternalDefinitionLanguage.g:1748:1: ( '{' )
            // InternalDefinitionLanguage.g:1749:2: '{'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,45,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:1758:1: rule__TypeDefinitionRule__Group__5 : rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6 ;
    public final void rule__TypeDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1762:1: ( rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:1763:2: rule__TypeDefinitionRule__Group__5__Impl rule__TypeDefinitionRule__Group__6
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
    // InternalDefinitionLanguage.g:1770:1: rule__TypeDefinitionRule__Group__5__Impl : ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* ) ;
    public final void rule__TypeDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1774:1: ( ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* ) )
            // InternalDefinitionLanguage.g:1775:1: ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* )
            {
            // InternalDefinitionLanguage.g:1775:1: ( ( rule__TypeDefinitionRule__AttributesAssignment_5 )* )
            // InternalDefinitionLanguage.g:1776:2: ( rule__TypeDefinitionRule__AttributesAssignment_5 )*
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAssignment_5()); 
            // InternalDefinitionLanguage.g:1777:2: ( rule__TypeDefinitionRule__AttributesAssignment_5 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_QUOTED_ID && LA16_0<=RULE_ID)||LA16_0==48) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1777:3: rule__TypeDefinitionRule__AttributesAssignment_5
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__TypeDefinitionRule__AttributesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalDefinitionLanguage.g:1785:1: rule__TypeDefinitionRule__Group__6 : rule__TypeDefinitionRule__Group__6__Impl ;
    public final void rule__TypeDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1789:1: ( rule__TypeDefinitionRule__Group__6__Impl )
            // InternalDefinitionLanguage.g:1790:2: rule__TypeDefinitionRule__Group__6__Impl
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
    // InternalDefinitionLanguage.g:1796:1: rule__TypeDefinitionRule__Group__6__Impl : ( '}' ) ;
    public final void rule__TypeDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1800:1: ( ( '}' ) )
            // InternalDefinitionLanguage.g:1801:1: ( '}' )
            {
            // InternalDefinitionLanguage.g:1801:1: ( '}' )
            // InternalDefinitionLanguage.g:1802:2: '}'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getRightCurlyBracketKeyword_6()); 
            match(input,46,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:1812:1: rule__TypeDefinitionRule__Group_3__0 : rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1 ;
    public final void rule__TypeDefinitionRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1816:1: ( rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1 )
            // InternalDefinitionLanguage.g:1817:2: rule__TypeDefinitionRule__Group_3__0__Impl rule__TypeDefinitionRule__Group_3__1
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
    // InternalDefinitionLanguage.g:1824:1: rule__TypeDefinitionRule__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__TypeDefinitionRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1828:1: ( ( 'extends' ) )
            // InternalDefinitionLanguage.g:1829:1: ( 'extends' )
            {
            // InternalDefinitionLanguage.g:1829:1: ( 'extends' )
            // InternalDefinitionLanguage.g:1830:2: 'extends'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getExtendsKeyword_3_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:1839:1: rule__TypeDefinitionRule__Group_3__1 : rule__TypeDefinitionRule__Group_3__1__Impl ;
    public final void rule__TypeDefinitionRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1843:1: ( rule__TypeDefinitionRule__Group_3__1__Impl )
            // InternalDefinitionLanguage.g:1844:2: rule__TypeDefinitionRule__Group_3__1__Impl
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
    // InternalDefinitionLanguage.g:1850:1: rule__TypeDefinitionRule__Group_3__1__Impl : ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) ) ;
    public final void rule__TypeDefinitionRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1854:1: ( ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) ) )
            // InternalDefinitionLanguage.g:1855:1: ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) )
            {
            // InternalDefinitionLanguage.g:1855:1: ( ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 ) )
            // InternalDefinitionLanguage.g:1856:2: ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeAssignment_3_1()); 
            // InternalDefinitionLanguage.g:1857:2: ( rule__TypeDefinitionRule__SuperTypeAssignment_3_1 )
            // InternalDefinitionLanguage.g:1857:3: rule__TypeDefinitionRule__SuperTypeAssignment_3_1
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
    // InternalDefinitionLanguage.g:1866:1: rule__UnnamedAttributeDefinitionRule__Group__0 : rule__UnnamedAttributeDefinitionRule__Group__0__Impl rule__UnnamedAttributeDefinitionRule__Group__1 ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1870:1: ( rule__UnnamedAttributeDefinitionRule__Group__0__Impl rule__UnnamedAttributeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:1871:2: rule__UnnamedAttributeDefinitionRule__Group__0__Impl rule__UnnamedAttributeDefinitionRule__Group__1
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
    // InternalDefinitionLanguage.g:1878:1: rule__UnnamedAttributeDefinitionRule__Group__0__Impl : ( 'unnamed' ) ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1882:1: ( ( 'unnamed' ) )
            // InternalDefinitionLanguage.g:1883:1: ( 'unnamed' )
            {
            // InternalDefinitionLanguage.g:1883:1: ( 'unnamed' )
            // InternalDefinitionLanguage.g:1884:2: 'unnamed'
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getUnnamedKeyword_0()); 
            match(input,48,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:1893:1: rule__UnnamedAttributeDefinitionRule__Group__1 : rule__UnnamedAttributeDefinitionRule__Group__1__Impl rule__UnnamedAttributeDefinitionRule__Group__2 ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1897:1: ( rule__UnnamedAttributeDefinitionRule__Group__1__Impl rule__UnnamedAttributeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:1898:2: rule__UnnamedAttributeDefinitionRule__Group__1__Impl rule__UnnamedAttributeDefinitionRule__Group__2
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
    // InternalDefinitionLanguage.g:1905:1: rule__UnnamedAttributeDefinitionRule__Group__1__Impl : ( ':' ) ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1909:1: ( ( ':' ) )
            // InternalDefinitionLanguage.g:1910:1: ( ':' )
            {
            // InternalDefinitionLanguage.g:1910:1: ( ':' )
            // InternalDefinitionLanguage.g:1911:2: ':'
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getColonKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:1920:1: rule__UnnamedAttributeDefinitionRule__Group__2 : rule__UnnamedAttributeDefinitionRule__Group__2__Impl rule__UnnamedAttributeDefinitionRule__Group__3 ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1924:1: ( rule__UnnamedAttributeDefinitionRule__Group__2__Impl rule__UnnamedAttributeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:1925:2: rule__UnnamedAttributeDefinitionRule__Group__2__Impl rule__UnnamedAttributeDefinitionRule__Group__3
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
    // InternalDefinitionLanguage.g:1932:1: rule__UnnamedAttributeDefinitionRule__Group__2__Impl : ( ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 ) ) ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1936:1: ( ( ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:1937:1: ( ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:1937:1: ( ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 ) )
            // InternalDefinitionLanguage.g:1938:2: ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 )
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getTypeAssignment_2()); 
            // InternalDefinitionLanguage.g:1939:2: ( rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 )
            // InternalDefinitionLanguage.g:1939:3: rule__UnnamedAttributeDefinitionRule__TypeAssignment_2
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
    // InternalDefinitionLanguage.g:1947:1: rule__UnnamedAttributeDefinitionRule__Group__3 : rule__UnnamedAttributeDefinitionRule__Group__3__Impl ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1951:1: ( rule__UnnamedAttributeDefinitionRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:1952:2: rule__UnnamedAttributeDefinitionRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:1958:1: rule__UnnamedAttributeDefinitionRule__Group__3__Impl : ( ';' ) ;
    public final void rule__UnnamedAttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1962:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:1963:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:1963:1: ( ';' )
            // InternalDefinitionLanguage.g:1964:2: ';'
            {
             before(grammarAccess.getUnnamedAttributeDefinitionRuleAccess().getSemicolonKeyword_3()); 
            match(input,50,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:1974:1: rule__NamedAttributeDefinitionRule__Group__0 : rule__NamedAttributeDefinitionRule__Group__0__Impl rule__NamedAttributeDefinitionRule__Group__1 ;
    public final void rule__NamedAttributeDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1978:1: ( rule__NamedAttributeDefinitionRule__Group__0__Impl rule__NamedAttributeDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:1979:2: rule__NamedAttributeDefinitionRule__Group__0__Impl rule__NamedAttributeDefinitionRule__Group__1
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
    // InternalDefinitionLanguage.g:1986:1: rule__NamedAttributeDefinitionRule__Group__0__Impl : ( ( rule__NamedAttributeDefinitionRule__NameAssignment_0 ) ) ;
    public final void rule__NamedAttributeDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:1990:1: ( ( ( rule__NamedAttributeDefinitionRule__NameAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:1991:1: ( ( rule__NamedAttributeDefinitionRule__NameAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:1991:1: ( ( rule__NamedAttributeDefinitionRule__NameAssignment_0 ) )
            // InternalDefinitionLanguage.g:1992:2: ( rule__NamedAttributeDefinitionRule__NameAssignment_0 )
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getNameAssignment_0()); 
            // InternalDefinitionLanguage.g:1993:2: ( rule__NamedAttributeDefinitionRule__NameAssignment_0 )
            // InternalDefinitionLanguage.g:1993:3: rule__NamedAttributeDefinitionRule__NameAssignment_0
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
    // InternalDefinitionLanguage.g:2001:1: rule__NamedAttributeDefinitionRule__Group__1 : rule__NamedAttributeDefinitionRule__Group__1__Impl rule__NamedAttributeDefinitionRule__Group__2 ;
    public final void rule__NamedAttributeDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2005:1: ( rule__NamedAttributeDefinitionRule__Group__1__Impl rule__NamedAttributeDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:2006:2: rule__NamedAttributeDefinitionRule__Group__1__Impl rule__NamedAttributeDefinitionRule__Group__2
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
    // InternalDefinitionLanguage.g:2013:1: rule__NamedAttributeDefinitionRule__Group__1__Impl : ( ':' ) ;
    public final void rule__NamedAttributeDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2017:1: ( ( ':' ) )
            // InternalDefinitionLanguage.g:2018:1: ( ':' )
            {
            // InternalDefinitionLanguage.g:2018:1: ( ':' )
            // InternalDefinitionLanguage.g:2019:2: ':'
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getColonKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2028:1: rule__NamedAttributeDefinitionRule__Group__2 : rule__NamedAttributeDefinitionRule__Group__2__Impl rule__NamedAttributeDefinitionRule__Group__3 ;
    public final void rule__NamedAttributeDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2032:1: ( rule__NamedAttributeDefinitionRule__Group__2__Impl rule__NamedAttributeDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:2033:2: rule__NamedAttributeDefinitionRule__Group__2__Impl rule__NamedAttributeDefinitionRule__Group__3
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
    // InternalDefinitionLanguage.g:2040:1: rule__NamedAttributeDefinitionRule__Group__2__Impl : ( ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 ) ) ;
    public final void rule__NamedAttributeDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2044:1: ( ( ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:2045:1: ( ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:2045:1: ( ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 ) )
            // InternalDefinitionLanguage.g:2046:2: ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 )
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getTypeAssignment_2()); 
            // InternalDefinitionLanguage.g:2047:2: ( rule__NamedAttributeDefinitionRule__TypeAssignment_2 )
            // InternalDefinitionLanguage.g:2047:3: rule__NamedAttributeDefinitionRule__TypeAssignment_2
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
    // InternalDefinitionLanguage.g:2055:1: rule__NamedAttributeDefinitionRule__Group__3 : rule__NamedAttributeDefinitionRule__Group__3__Impl ;
    public final void rule__NamedAttributeDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2059:1: ( rule__NamedAttributeDefinitionRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:2060:2: rule__NamedAttributeDefinitionRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:2066:1: rule__NamedAttributeDefinitionRule__Group__3__Impl : ( ';' ) ;
    public final void rule__NamedAttributeDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2070:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:2071:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:2071:1: ( ';' )
            // InternalDefinitionLanguage.g:2072:2: ';'
            {
             before(grammarAccess.getNamedAttributeDefinitionRuleAccess().getSemicolonKeyword_3()); 
            match(input,50,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2082:1: rule__LiteralTypeRule__Group__0 : rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 ;
    public final void rule__LiteralTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2086:1: ( rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2087:2: rule__LiteralTypeRule__Group__0__Impl rule__LiteralTypeRule__Group__1
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
    // InternalDefinitionLanguage.g:2094:1: rule__LiteralTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__LiteralTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2098:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2099:1: ( () )
            {
            // InternalDefinitionLanguage.g:2099:1: ( () )
            // InternalDefinitionLanguage.g:2100:2: ()
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0()); 
            // InternalDefinitionLanguage.g:2101:2: ()
            // InternalDefinitionLanguage.g:2101:3: 
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
    // InternalDefinitionLanguage.g:2109:1: rule__LiteralTypeRule__Group__1 : rule__LiteralTypeRule__Group__1__Impl ;
    public final void rule__LiteralTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2113:1: ( rule__LiteralTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2114:2: rule__LiteralTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2120:1: rule__LiteralTypeRule__Group__1__Impl : ( 'literal' ) ;
    public final void rule__LiteralTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2124:1: ( ( 'literal' ) )
            // InternalDefinitionLanguage.g:2125:1: ( 'literal' )
            {
            // InternalDefinitionLanguage.g:2125:1: ( 'literal' )
            // InternalDefinitionLanguage.g:2126:2: 'literal'
            {
             before(grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2136:1: rule__InstanceTypeRule__Group__0 : rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 ;
    public final void rule__InstanceTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2140:1: ( rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2141:2: rule__InstanceTypeRule__Group__0__Impl rule__InstanceTypeRule__Group__1
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
    // InternalDefinitionLanguage.g:2148:1: rule__InstanceTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__InstanceTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2152:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2153:1: ( () )
            {
            // InternalDefinitionLanguage.g:2153:1: ( () )
            // InternalDefinitionLanguage.g:2154:2: ()
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0()); 
            // InternalDefinitionLanguage.g:2155:2: ()
            // InternalDefinitionLanguage.g:2155:3: 
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
    // InternalDefinitionLanguage.g:2163:1: rule__InstanceTypeRule__Group__1 : rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 ;
    public final void rule__InstanceTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2167:1: ( rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2 )
            // InternalDefinitionLanguage.g:2168:2: rule__InstanceTypeRule__Group__1__Impl rule__InstanceTypeRule__Group__2
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
    // InternalDefinitionLanguage.g:2175:1: rule__InstanceTypeRule__Group__1__Impl : ( 'instance' ) ;
    public final void rule__InstanceTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2179:1: ( ( 'instance' ) )
            // InternalDefinitionLanguage.g:2180:1: ( 'instance' )
            {
            // InternalDefinitionLanguage.g:2180:1: ( 'instance' )
            // InternalDefinitionLanguage.g:2181:2: 'instance'
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2190:1: rule__InstanceTypeRule__Group__2 : rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 ;
    public final void rule__InstanceTypeRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2194:1: ( rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3 )
            // InternalDefinitionLanguage.g:2195:2: rule__InstanceTypeRule__Group__2__Impl rule__InstanceTypeRule__Group__3
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
    // InternalDefinitionLanguage.g:2202:1: rule__InstanceTypeRule__Group__2__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) ;
    public final void rule__InstanceTypeRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2206:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:2207:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:2207:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_2 ) )
            // InternalDefinitionLanguage.g:2208:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_2()); 
            // InternalDefinitionLanguage.g:2209:2: ( rule__InstanceTypeRule__DefinitionsAssignment_2 )
            // InternalDefinitionLanguage.g:2209:3: rule__InstanceTypeRule__DefinitionsAssignment_2
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
    // InternalDefinitionLanguage.g:2217:1: rule__InstanceTypeRule__Group__3 : rule__InstanceTypeRule__Group__3__Impl ;
    public final void rule__InstanceTypeRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2221:1: ( rule__InstanceTypeRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:2222:2: rule__InstanceTypeRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:2228:1: rule__InstanceTypeRule__Group__3__Impl : ( ( rule__InstanceTypeRule__Group_3__0 )* ) ;
    public final void rule__InstanceTypeRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2232:1: ( ( ( rule__InstanceTypeRule__Group_3__0 )* ) )
            // InternalDefinitionLanguage.g:2233:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            {
            // InternalDefinitionLanguage.g:2233:1: ( ( rule__InstanceTypeRule__Group_3__0 )* )
            // InternalDefinitionLanguage.g:2234:2: ( rule__InstanceTypeRule__Group_3__0 )*
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getGroup_3()); 
            // InternalDefinitionLanguage.g:2235:2: ( rule__InstanceTypeRule__Group_3__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==53) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2235:3: rule__InstanceTypeRule__Group_3__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__InstanceTypeRule__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalDefinitionLanguage.g:2244:1: rule__InstanceTypeRule__Group_3__0 : rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 ;
    public final void rule__InstanceTypeRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2248:1: ( rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1 )
            // InternalDefinitionLanguage.g:2249:2: rule__InstanceTypeRule__Group_3__0__Impl rule__InstanceTypeRule__Group_3__1
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
    // InternalDefinitionLanguage.g:2256:1: rule__InstanceTypeRule__Group_3__0__Impl : ( '|' ) ;
    public final void rule__InstanceTypeRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2260:1: ( ( '|' ) )
            // InternalDefinitionLanguage.g:2261:1: ( '|' )
            {
            // InternalDefinitionLanguage.g:2261:1: ( '|' )
            // InternalDefinitionLanguage.g:2262:2: '|'
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2271:1: rule__InstanceTypeRule__Group_3__1 : rule__InstanceTypeRule__Group_3__1__Impl ;
    public final void rule__InstanceTypeRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2275:1: ( rule__InstanceTypeRule__Group_3__1__Impl )
            // InternalDefinitionLanguage.g:2276:2: rule__InstanceTypeRule__Group_3__1__Impl
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
    // InternalDefinitionLanguage.g:2282:1: rule__InstanceTypeRule__Group_3__1__Impl : ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) ;
    public final void rule__InstanceTypeRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2286:1: ( ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) ) )
            // InternalDefinitionLanguage.g:2287:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            {
            // InternalDefinitionLanguage.g:2287:1: ( ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 ) )
            // InternalDefinitionLanguage.g:2288:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsAssignment_3_1()); 
            // InternalDefinitionLanguage.g:2289:2: ( rule__InstanceTypeRule__DefinitionsAssignment_3_1 )
            // InternalDefinitionLanguage.g:2289:3: rule__InstanceTypeRule__DefinitionsAssignment_3_1
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
    // InternalDefinitionLanguage.g:2298:1: rule__StringTypeRule__Group__0 : rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 ;
    public final void rule__StringTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2302:1: ( rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2303:2: rule__StringTypeRule__Group__0__Impl rule__StringTypeRule__Group__1
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
    // InternalDefinitionLanguage.g:2310:1: rule__StringTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__StringTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2314:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2315:1: ( () )
            {
            // InternalDefinitionLanguage.g:2315:1: ( () )
            // InternalDefinitionLanguage.g:2316:2: ()
            {
             before(grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0()); 
            // InternalDefinitionLanguage.g:2317:2: ()
            // InternalDefinitionLanguage.g:2317:3: 
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
    // InternalDefinitionLanguage.g:2325:1: rule__StringTypeRule__Group__1 : rule__StringTypeRule__Group__1__Impl ;
    public final void rule__StringTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2329:1: ( rule__StringTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2330:2: rule__StringTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2336:1: rule__StringTypeRule__Group__1__Impl : ( 'string' ) ;
    public final void rule__StringTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2340:1: ( ( 'string' ) )
            // InternalDefinitionLanguage.g:2341:1: ( 'string' )
            {
            // InternalDefinitionLanguage.g:2341:1: ( 'string' )
            // InternalDefinitionLanguage.g:2342:2: 'string'
            {
             before(grammarAccess.getStringTypeRuleAccess().getStringKeyword_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2352:1: rule__ExpressionTypeRule__Group__0 : rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 ;
    public final void rule__ExpressionTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2356:1: ( rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2357:2: rule__ExpressionTypeRule__Group__0__Impl rule__ExpressionTypeRule__Group__1
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
    // InternalDefinitionLanguage.g:2364:1: rule__ExpressionTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__ExpressionTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2368:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2369:1: ( () )
            {
            // InternalDefinitionLanguage.g:2369:1: ( () )
            // InternalDefinitionLanguage.g:2370:2: ()
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0()); 
            // InternalDefinitionLanguage.g:2371:2: ()
            // InternalDefinitionLanguage.g:2371:3: 
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
    // InternalDefinitionLanguage.g:2379:1: rule__ExpressionTypeRule__Group__1 : rule__ExpressionTypeRule__Group__1__Impl ;
    public final void rule__ExpressionTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2383:1: ( rule__ExpressionTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2384:2: rule__ExpressionTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2390:1: rule__ExpressionTypeRule__Group__1__Impl : ( 'expression' ) ;
    public final void rule__ExpressionTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2394:1: ( ( 'expression' ) )
            // InternalDefinitionLanguage.g:2395:1: ( 'expression' )
            {
            // InternalDefinitionLanguage.g:2395:1: ( 'expression' )
            // InternalDefinitionLanguage.g:2396:2: 'expression'
            {
             before(grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1()); 
            match(input,55,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2406:1: rule__IntTypeRule__Group__0 : rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 ;
    public final void rule__IntTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2410:1: ( rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2411:2: rule__IntTypeRule__Group__0__Impl rule__IntTypeRule__Group__1
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
    // InternalDefinitionLanguage.g:2418:1: rule__IntTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__IntTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2422:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2423:1: ( () )
            {
            // InternalDefinitionLanguage.g:2423:1: ( () )
            // InternalDefinitionLanguage.g:2424:2: ()
            {
             before(grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0()); 
            // InternalDefinitionLanguage.g:2425:2: ()
            // InternalDefinitionLanguage.g:2425:3: 
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
    // InternalDefinitionLanguage.g:2433:1: rule__IntTypeRule__Group__1 : rule__IntTypeRule__Group__1__Impl ;
    public final void rule__IntTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2437:1: ( rule__IntTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2438:2: rule__IntTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2444:1: rule__IntTypeRule__Group__1__Impl : ( 'int' ) ;
    public final void rule__IntTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2448:1: ( ( 'int' ) )
            // InternalDefinitionLanguage.g:2449:1: ( 'int' )
            {
            // InternalDefinitionLanguage.g:2449:1: ( 'int' )
            // InternalDefinitionLanguage.g:2450:2: 'int'
            {
             before(grammarAccess.getIntTypeRuleAccess().getIntKeyword_1()); 
            match(input,56,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2460:1: rule__FloatTypeRule__Group__0 : rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 ;
    public final void rule__FloatTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2464:1: ( rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2465:2: rule__FloatTypeRule__Group__0__Impl rule__FloatTypeRule__Group__1
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
    // InternalDefinitionLanguage.g:2472:1: rule__FloatTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__FloatTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2476:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2477:1: ( () )
            {
            // InternalDefinitionLanguage.g:2477:1: ( () )
            // InternalDefinitionLanguage.g:2478:2: ()
            {
             before(grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0()); 
            // InternalDefinitionLanguage.g:2479:2: ()
            // InternalDefinitionLanguage.g:2479:3: 
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
    // InternalDefinitionLanguage.g:2487:1: rule__FloatTypeRule__Group__1 : rule__FloatTypeRule__Group__1__Impl ;
    public final void rule__FloatTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2491:1: ( rule__FloatTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2492:2: rule__FloatTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2498:1: rule__FloatTypeRule__Group__1__Impl : ( 'float' ) ;
    public final void rule__FloatTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2502:1: ( ( 'float' ) )
            // InternalDefinitionLanguage.g:2503:1: ( 'float' )
            {
            // InternalDefinitionLanguage.g:2503:1: ( 'float' )
            // InternalDefinitionLanguage.g:2504:2: 'float'
            {
             before(grammarAccess.getFloatTypeRuleAccess().getFloatKeyword_1()); 
            match(input,57,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2514:1: rule__BooleanTypeRule__Group__0 : rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 ;
    public final void rule__BooleanTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2518:1: ( rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2519:2: rule__BooleanTypeRule__Group__0__Impl rule__BooleanTypeRule__Group__1
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
    // InternalDefinitionLanguage.g:2526:1: rule__BooleanTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2530:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2531:1: ( () )
            {
            // InternalDefinitionLanguage.g:2531:1: ( () )
            // InternalDefinitionLanguage.g:2532:2: ()
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0()); 
            // InternalDefinitionLanguage.g:2533:2: ()
            // InternalDefinitionLanguage.g:2533:3: 
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
    // InternalDefinitionLanguage.g:2541:1: rule__BooleanTypeRule__Group__1 : rule__BooleanTypeRule__Group__1__Impl ;
    public final void rule__BooleanTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2545:1: ( rule__BooleanTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2546:2: rule__BooleanTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2552:1: rule__BooleanTypeRule__Group__1__Impl : ( 'boolean' ) ;
    public final void rule__BooleanTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2556:1: ( ( 'boolean' ) )
            // InternalDefinitionLanguage.g:2557:1: ( 'boolean' )
            {
            // InternalDefinitionLanguage.g:2557:1: ( 'boolean' )
            // InternalDefinitionLanguage.g:2558:2: 'boolean'
            {
             before(grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1()); 
            match(input,58,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2568:1: rule__VoidTypeRule__Group__0 : rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 ;
    public final void rule__VoidTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2572:1: ( rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2573:2: rule__VoidTypeRule__Group__0__Impl rule__VoidTypeRule__Group__1
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
    // InternalDefinitionLanguage.g:2580:1: rule__VoidTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__VoidTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2584:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2585:1: ( () )
            {
            // InternalDefinitionLanguage.g:2585:1: ( () )
            // InternalDefinitionLanguage.g:2586:2: ()
            {
             before(grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0()); 
            // InternalDefinitionLanguage.g:2587:2: ()
            // InternalDefinitionLanguage.g:2587:3: 
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
    // InternalDefinitionLanguage.g:2595:1: rule__VoidTypeRule__Group__1 : rule__VoidTypeRule__Group__1__Impl ;
    public final void rule__VoidTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2599:1: ( rule__VoidTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2600:2: rule__VoidTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2606:1: rule__VoidTypeRule__Group__1__Impl : ( 'void' ) ;
    public final void rule__VoidTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2610:1: ( ( 'void' ) )
            // InternalDefinitionLanguage.g:2611:1: ( 'void' )
            {
            // InternalDefinitionLanguage.g:2611:1: ( 'void' )
            // InternalDefinitionLanguage.g:2612:2: 'void'
            {
             before(grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1()); 
            match(input,59,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2622:1: rule__DataTypeRule__Group__0 : rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 ;
    public final void rule__DataTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2626:1: ( rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2627:2: rule__DataTypeRule__Group__0__Impl rule__DataTypeRule__Group__1
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
    // InternalDefinitionLanguage.g:2634:1: rule__DataTypeRule__Group__0__Impl : ( () ) ;
    public final void rule__DataTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2638:1: ( ( () ) )
            // InternalDefinitionLanguage.g:2639:1: ( () )
            {
            // InternalDefinitionLanguage.g:2639:1: ( () )
            // InternalDefinitionLanguage.g:2640:2: ()
            {
             before(grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0()); 
            // InternalDefinitionLanguage.g:2641:2: ()
            // InternalDefinitionLanguage.g:2641:3: 
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
    // InternalDefinitionLanguage.g:2649:1: rule__DataTypeRule__Group__1 : rule__DataTypeRule__Group__1__Impl ;
    public final void rule__DataTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2653:1: ( rule__DataTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2654:2: rule__DataTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2660:1: rule__DataTypeRule__Group__1__Impl : ( 'data' ) ;
    public final void rule__DataTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2664:1: ( ( 'data' ) )
            // InternalDefinitionLanguage.g:2665:1: ( 'data' )
            {
            // InternalDefinitionLanguage.g:2665:1: ( 'data' )
            // InternalDefinitionLanguage.g:2666:2: 'data'
            {
             before(grammarAccess.getDataTypeRuleAccess().getDataKeyword_1()); 
            match(input,60,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2676:1: rule__ArrayTypeRule__Group__0 : rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 ;
    public final void rule__ArrayTypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2680:1: ( rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1 )
            // InternalDefinitionLanguage.g:2681:2: rule__ArrayTypeRule__Group__0__Impl rule__ArrayTypeRule__Group__1
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
    // InternalDefinitionLanguage.g:2688:1: rule__ArrayTypeRule__Group__0__Impl : ( 'array' ) ;
    public final void rule__ArrayTypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2692:1: ( ( 'array' ) )
            // InternalDefinitionLanguage.g:2693:1: ( 'array' )
            {
            // InternalDefinitionLanguage.g:2693:1: ( 'array' )
            // InternalDefinitionLanguage.g:2694:2: 'array'
            {
             before(grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0()); 
            match(input,61,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2703:1: rule__ArrayTypeRule__Group__1 : rule__ArrayTypeRule__Group__1__Impl ;
    public final void rule__ArrayTypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2707:1: ( rule__ArrayTypeRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:2708:2: rule__ArrayTypeRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:2714:1: rule__ArrayTypeRule__Group__1__Impl : ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) ;
    public final void rule__ArrayTypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2718:1: ( ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2719:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2719:1: ( ( rule__ArrayTypeRule__ElementsAssignment_1 ) )
            // InternalDefinitionLanguage.g:2720:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            {
             before(grammarAccess.getArrayTypeRuleAccess().getElementsAssignment_1()); 
            // InternalDefinitionLanguage.g:2721:2: ( rule__ArrayTypeRule__ElementsAssignment_1 )
            // InternalDefinitionLanguage.g:2721:3: rule__ArrayTypeRule__ElementsAssignment_1
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
    // InternalDefinitionLanguage.g:2730:1: rule__FunctioDefinitionRule__Group__0 : rule__FunctioDefinitionRule__Group__0__Impl rule__FunctioDefinitionRule__Group__1 ;
    public final void rule__FunctioDefinitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2734:1: ( rule__FunctioDefinitionRule__Group__0__Impl rule__FunctioDefinitionRule__Group__1 )
            // InternalDefinitionLanguage.g:2735:2: rule__FunctioDefinitionRule__Group__0__Impl rule__FunctioDefinitionRule__Group__1
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
    // InternalDefinitionLanguage.g:2742:1: rule__FunctioDefinitionRule__Group__0__Impl : ( 'def' ) ;
    public final void rule__FunctioDefinitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2746:1: ( ( 'def' ) )
            // InternalDefinitionLanguage.g:2747:1: ( 'def' )
            {
            // InternalDefinitionLanguage.g:2747:1: ( 'def' )
            // InternalDefinitionLanguage.g:2748:2: 'def'
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getDefKeyword_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2757:1: rule__FunctioDefinitionRule__Group__1 : rule__FunctioDefinitionRule__Group__1__Impl rule__FunctioDefinitionRule__Group__2 ;
    public final void rule__FunctioDefinitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2761:1: ( rule__FunctioDefinitionRule__Group__1__Impl rule__FunctioDefinitionRule__Group__2 )
            // InternalDefinitionLanguage.g:2762:2: rule__FunctioDefinitionRule__Group__1__Impl rule__FunctioDefinitionRule__Group__2
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
    // InternalDefinitionLanguage.g:2769:1: rule__FunctioDefinitionRule__Group__1__Impl : ( ( rule__FunctioDefinitionRule__TypeAssignment_1 ) ) ;
    public final void rule__FunctioDefinitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2773:1: ( ( ( rule__FunctioDefinitionRule__TypeAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:2774:1: ( ( rule__FunctioDefinitionRule__TypeAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:2774:1: ( ( rule__FunctioDefinitionRule__TypeAssignment_1 ) )
            // InternalDefinitionLanguage.g:2775:2: ( rule__FunctioDefinitionRule__TypeAssignment_1 )
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getTypeAssignment_1()); 
            // InternalDefinitionLanguage.g:2776:2: ( rule__FunctioDefinitionRule__TypeAssignment_1 )
            // InternalDefinitionLanguage.g:2776:3: rule__FunctioDefinitionRule__TypeAssignment_1
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
    // InternalDefinitionLanguage.g:2784:1: rule__FunctioDefinitionRule__Group__2 : rule__FunctioDefinitionRule__Group__2__Impl rule__FunctioDefinitionRule__Group__3 ;
    public final void rule__FunctioDefinitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2788:1: ( rule__FunctioDefinitionRule__Group__2__Impl rule__FunctioDefinitionRule__Group__3 )
            // InternalDefinitionLanguage.g:2789:2: rule__FunctioDefinitionRule__Group__2__Impl rule__FunctioDefinitionRule__Group__3
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
    // InternalDefinitionLanguage.g:2796:1: rule__FunctioDefinitionRule__Group__2__Impl : ( ( rule__FunctioDefinitionRule__NameAssignment_2 ) ) ;
    public final void rule__FunctioDefinitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2800:1: ( ( ( rule__FunctioDefinitionRule__NameAssignment_2 ) ) )
            // InternalDefinitionLanguage.g:2801:1: ( ( rule__FunctioDefinitionRule__NameAssignment_2 ) )
            {
            // InternalDefinitionLanguage.g:2801:1: ( ( rule__FunctioDefinitionRule__NameAssignment_2 ) )
            // InternalDefinitionLanguage.g:2802:2: ( rule__FunctioDefinitionRule__NameAssignment_2 )
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getNameAssignment_2()); 
            // InternalDefinitionLanguage.g:2803:2: ( rule__FunctioDefinitionRule__NameAssignment_2 )
            // InternalDefinitionLanguage.g:2803:3: rule__FunctioDefinitionRule__NameAssignment_2
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
    // InternalDefinitionLanguage.g:2811:1: rule__FunctioDefinitionRule__Group__3 : rule__FunctioDefinitionRule__Group__3__Impl rule__FunctioDefinitionRule__Group__4 ;
    public final void rule__FunctioDefinitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2815:1: ( rule__FunctioDefinitionRule__Group__3__Impl rule__FunctioDefinitionRule__Group__4 )
            // InternalDefinitionLanguage.g:2816:2: rule__FunctioDefinitionRule__Group__3__Impl rule__FunctioDefinitionRule__Group__4
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
    // InternalDefinitionLanguage.g:2823:1: rule__FunctioDefinitionRule__Group__3__Impl : ( '(' ) ;
    public final void rule__FunctioDefinitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2827:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:2828:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:2828:1: ( '(' )
            // InternalDefinitionLanguage.g:2829:2: '('
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getLeftParenthesisKeyword_3()); 
            match(input,63,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2838:1: rule__FunctioDefinitionRule__Group__4 : rule__FunctioDefinitionRule__Group__4__Impl rule__FunctioDefinitionRule__Group__5 ;
    public final void rule__FunctioDefinitionRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2842:1: ( rule__FunctioDefinitionRule__Group__4__Impl rule__FunctioDefinitionRule__Group__5 )
            // InternalDefinitionLanguage.g:2843:2: rule__FunctioDefinitionRule__Group__4__Impl rule__FunctioDefinitionRule__Group__5
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
    // InternalDefinitionLanguage.g:2850:1: rule__FunctioDefinitionRule__Group__4__Impl : ( ( rule__FunctioDefinitionRule__Group_4__0 )? ) ;
    public final void rule__FunctioDefinitionRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2854:1: ( ( ( rule__FunctioDefinitionRule__Group_4__0 )? ) )
            // InternalDefinitionLanguage.g:2855:1: ( ( rule__FunctioDefinitionRule__Group_4__0 )? )
            {
            // InternalDefinitionLanguage.g:2855:1: ( ( rule__FunctioDefinitionRule__Group_4__0 )? )
            // InternalDefinitionLanguage.g:2856:2: ( rule__FunctioDefinitionRule__Group_4__0 )?
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getGroup_4()); 
            // InternalDefinitionLanguage.g:2857:2: ( rule__FunctioDefinitionRule__Group_4__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=51 && LA18_0<=52)||(LA18_0>=54 && LA18_0<=61)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDefinitionLanguage.g:2857:3: rule__FunctioDefinitionRule__Group_4__0
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
    // InternalDefinitionLanguage.g:2865:1: rule__FunctioDefinitionRule__Group__5 : rule__FunctioDefinitionRule__Group__5__Impl rule__FunctioDefinitionRule__Group__6 ;
    public final void rule__FunctioDefinitionRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2869:1: ( rule__FunctioDefinitionRule__Group__5__Impl rule__FunctioDefinitionRule__Group__6 )
            // InternalDefinitionLanguage.g:2870:2: rule__FunctioDefinitionRule__Group__5__Impl rule__FunctioDefinitionRule__Group__6
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
    // InternalDefinitionLanguage.g:2877:1: rule__FunctioDefinitionRule__Group__5__Impl : ( ')' ) ;
    public final void rule__FunctioDefinitionRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2881:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:2882:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:2882:1: ( ')' )
            // InternalDefinitionLanguage.g:2883:2: ')'
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getRightParenthesisKeyword_5()); 
            match(input,64,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2892:1: rule__FunctioDefinitionRule__Group__6 : rule__FunctioDefinitionRule__Group__6__Impl ;
    public final void rule__FunctioDefinitionRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2896:1: ( rule__FunctioDefinitionRule__Group__6__Impl )
            // InternalDefinitionLanguage.g:2897:2: rule__FunctioDefinitionRule__Group__6__Impl
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
    // InternalDefinitionLanguage.g:2903:1: rule__FunctioDefinitionRule__Group__6__Impl : ( ';' ) ;
    public final void rule__FunctioDefinitionRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2907:1: ( ( ';' ) )
            // InternalDefinitionLanguage.g:2908:1: ( ';' )
            {
            // InternalDefinitionLanguage.g:2908:1: ( ';' )
            // InternalDefinitionLanguage.g:2909:2: ';'
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getSemicolonKeyword_6()); 
            match(input,50,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:2919:1: rule__FunctioDefinitionRule__Group_4__0 : rule__FunctioDefinitionRule__Group_4__0__Impl rule__FunctioDefinitionRule__Group_4__1 ;
    public final void rule__FunctioDefinitionRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2923:1: ( rule__FunctioDefinitionRule__Group_4__0__Impl rule__FunctioDefinitionRule__Group_4__1 )
            // InternalDefinitionLanguage.g:2924:2: rule__FunctioDefinitionRule__Group_4__0__Impl rule__FunctioDefinitionRule__Group_4__1
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
    // InternalDefinitionLanguage.g:2931:1: rule__FunctioDefinitionRule__Group_4__0__Impl : ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 ) ) ;
    public final void rule__FunctioDefinitionRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2935:1: ( ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 ) ) )
            // InternalDefinitionLanguage.g:2936:1: ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 ) )
            {
            // InternalDefinitionLanguage.g:2936:1: ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 ) )
            // InternalDefinitionLanguage.g:2937:2: ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 )
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getParametersAssignment_4_0()); 
            // InternalDefinitionLanguage.g:2938:2: ( rule__FunctioDefinitionRule__ParametersAssignment_4_0 )
            // InternalDefinitionLanguage.g:2938:3: rule__FunctioDefinitionRule__ParametersAssignment_4_0
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
    // InternalDefinitionLanguage.g:2946:1: rule__FunctioDefinitionRule__Group_4__1 : rule__FunctioDefinitionRule__Group_4__1__Impl ;
    public final void rule__FunctioDefinitionRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2950:1: ( rule__FunctioDefinitionRule__Group_4__1__Impl )
            // InternalDefinitionLanguage.g:2951:2: rule__FunctioDefinitionRule__Group_4__1__Impl
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
    // InternalDefinitionLanguage.g:2957:1: rule__FunctioDefinitionRule__Group_4__1__Impl : ( ( rule__FunctioDefinitionRule__Group_4_1__0 )* ) ;
    public final void rule__FunctioDefinitionRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2961:1: ( ( ( rule__FunctioDefinitionRule__Group_4_1__0 )* ) )
            // InternalDefinitionLanguage.g:2962:1: ( ( rule__FunctioDefinitionRule__Group_4_1__0 )* )
            {
            // InternalDefinitionLanguage.g:2962:1: ( ( rule__FunctioDefinitionRule__Group_4_1__0 )* )
            // InternalDefinitionLanguage.g:2963:2: ( rule__FunctioDefinitionRule__Group_4_1__0 )*
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getGroup_4_1()); 
            // InternalDefinitionLanguage.g:2964:2: ( rule__FunctioDefinitionRule__Group_4_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==65) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2964:3: rule__FunctioDefinitionRule__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__FunctioDefinitionRule__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalDefinitionLanguage.g:2973:1: rule__FunctioDefinitionRule__Group_4_1__0 : rule__FunctioDefinitionRule__Group_4_1__0__Impl rule__FunctioDefinitionRule__Group_4_1__1 ;
    public final void rule__FunctioDefinitionRule__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2977:1: ( rule__FunctioDefinitionRule__Group_4_1__0__Impl rule__FunctioDefinitionRule__Group_4_1__1 )
            // InternalDefinitionLanguage.g:2978:2: rule__FunctioDefinitionRule__Group_4_1__0__Impl rule__FunctioDefinitionRule__Group_4_1__1
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
    // InternalDefinitionLanguage.g:2985:1: rule__FunctioDefinitionRule__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__FunctioDefinitionRule__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:2989:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:2990:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:2990:1: ( ',' )
            // InternalDefinitionLanguage.g:2991:2: ','
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getCommaKeyword_4_1_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3000:1: rule__FunctioDefinitionRule__Group_4_1__1 : rule__FunctioDefinitionRule__Group_4_1__1__Impl ;
    public final void rule__FunctioDefinitionRule__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3004:1: ( rule__FunctioDefinitionRule__Group_4_1__1__Impl )
            // InternalDefinitionLanguage.g:3005:2: rule__FunctioDefinitionRule__Group_4_1__1__Impl
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
    // InternalDefinitionLanguage.g:3011:1: rule__FunctioDefinitionRule__Group_4_1__1__Impl : ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 ) ) ;
    public final void rule__FunctioDefinitionRule__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3015:1: ( ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 ) ) )
            // InternalDefinitionLanguage.g:3016:1: ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3016:1: ( ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 ) )
            // InternalDefinitionLanguage.g:3017:2: ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 )
            {
             before(grammarAccess.getFunctioDefinitionRuleAccess().getParametersAssignment_4_1_1()); 
            // InternalDefinitionLanguage.g:3018:2: ( rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 )
            // InternalDefinitionLanguage.g:3018:3: rule__FunctioDefinitionRule__ParametersAssignment_4_1_1
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
    // InternalDefinitionLanguage.g:3027:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3031:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // InternalDefinitionLanguage.g:3032:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
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
    // InternalDefinitionLanguage.g:3039:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__TypeAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3043:1: ( ( ( rule__ParameterRule__TypeAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3044:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3044:1: ( ( rule__ParameterRule__TypeAssignment_0 ) )
            // InternalDefinitionLanguage.g:3045:2: ( rule__ParameterRule__TypeAssignment_0 )
            {
             before(grammarAccess.getParameterRuleAccess().getTypeAssignment_0()); 
            // InternalDefinitionLanguage.g:3046:2: ( rule__ParameterRule__TypeAssignment_0 )
            // InternalDefinitionLanguage.g:3046:3: rule__ParameterRule__TypeAssignment_0
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
    // InternalDefinitionLanguage.g:3054:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3058:1: ( rule__ParameterRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3059:2: rule__ParameterRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3065:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__NameAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3069:1: ( ( ( rule__ParameterRule__NameAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3070:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3070:1: ( ( rule__ParameterRule__NameAssignment_1 ) )
            // InternalDefinitionLanguage.g:3071:2: ( rule__ParameterRule__NameAssignment_1 )
            {
             before(grammarAccess.getParameterRuleAccess().getNameAssignment_1()); 
            // InternalDefinitionLanguage.g:3072:2: ( rule__ParameterRule__NameAssignment_1 )
            // InternalDefinitionLanguage.g:3072:3: rule__ParameterRule__NameAssignment_1
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
    // InternalDefinitionLanguage.g:3081:1: rule__OrExpressionRule__Group__0 : rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 ;
    public final void rule__OrExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3085:1: ( rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3086:2: rule__OrExpressionRule__Group__0__Impl rule__OrExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3093:1: rule__OrExpressionRule__Group__0__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3097:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3098:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3098:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:3099:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalDefinitionLanguage.g:3100:2: ( rule__OrExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:3100:3: rule__OrExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:3108:1: rule__OrExpressionRule__Group__1 : rule__OrExpressionRule__Group__1__Impl ;
    public final void rule__OrExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3112:1: ( rule__OrExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3113:2: rule__OrExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3119:1: rule__OrExpressionRule__Group__1__Impl : ( ( rule__OrExpressionRule__Group_1__0 )* ) ;
    public final void rule__OrExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3123:1: ( ( ( rule__OrExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3124:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3124:1: ( ( rule__OrExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3125:2: ( rule__OrExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3126:2: ( rule__OrExpressionRule__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==66) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3126:3: rule__OrExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__OrExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalDefinitionLanguage.g:3135:1: rule__OrExpressionRule__Group_1__0 : rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 ;
    public final void rule__OrExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3139:1: ( rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3140:2: rule__OrExpressionRule__Group_1__0__Impl rule__OrExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:3147:1: rule__OrExpressionRule__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__OrExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3151:1: ( ( 'OR' ) )
            // InternalDefinitionLanguage.g:3152:1: ( 'OR' )
            {
            // InternalDefinitionLanguage.g:3152:1: ( 'OR' )
            // InternalDefinitionLanguage.g:3153:2: 'OR'
            {
             before(grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3162:1: rule__OrExpressionRule__Group_1__1 : rule__OrExpressionRule__Group_1__1__Impl ;
    public final void rule__OrExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3166:1: ( rule__OrExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3167:2: rule__OrExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3173:1: rule__OrExpressionRule__Group_1__1__Impl : ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3177:1: ( ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3178:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3178:1: ( ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3179:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3180:2: ( rule__OrExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3180:3: rule__OrExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3189:1: rule__XorExpressionRule__Group__0 : rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 ;
    public final void rule__XorExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3193:1: ( rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3194:2: rule__XorExpressionRule__Group__0__Impl rule__XorExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3201:1: rule__XorExpressionRule__Group__0__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__XorExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3205:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3206:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3206:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:3207:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalDefinitionLanguage.g:3208:2: ( rule__XorExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:3208:3: rule__XorExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:3216:1: rule__XorExpressionRule__Group__1 : rule__XorExpressionRule__Group__1__Impl ;
    public final void rule__XorExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3220:1: ( rule__XorExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3221:2: rule__XorExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3227:1: rule__XorExpressionRule__Group__1__Impl : ( ( rule__XorExpressionRule__Group_1__0 )* ) ;
    public final void rule__XorExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3231:1: ( ( ( rule__XorExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3232:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3232:1: ( ( rule__XorExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3233:2: ( rule__XorExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getXorExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3234:2: ( rule__XorExpressionRule__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==67) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3234:3: rule__XorExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__XorExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalDefinitionLanguage.g:3243:1: rule__XorExpressionRule__Group_1__0 : rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 ;
    public final void rule__XorExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3247:1: ( rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3248:2: rule__XorExpressionRule__Group_1__0__Impl rule__XorExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:3255:1: rule__XorExpressionRule__Group_1__0__Impl : ( 'XOR' ) ;
    public final void rule__XorExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3259:1: ( ( 'XOR' ) )
            // InternalDefinitionLanguage.g:3260:1: ( 'XOR' )
            {
            // InternalDefinitionLanguage.g:3260:1: ( 'XOR' )
            // InternalDefinitionLanguage.g:3261:2: 'XOR'
            {
             before(grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3270:1: rule__XorExpressionRule__Group_1__1 : rule__XorExpressionRule__Group_1__1__Impl ;
    public final void rule__XorExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3274:1: ( rule__XorExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3275:2: rule__XorExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3281:1: rule__XorExpressionRule__Group_1__1__Impl : ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__XorExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3285:1: ( ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3286:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3286:1: ( ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3287:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3288:2: ( rule__XorExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3288:3: rule__XorExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3297:1: rule__AndExpressionRule__Group__0 : rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 ;
    public final void rule__AndExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3301:1: ( rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3302:2: rule__AndExpressionRule__Group__0__Impl rule__AndExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3309:1: rule__AndExpressionRule__Group__0__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3313:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3314:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3314:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_0 ) )
            // InternalDefinitionLanguage.g:3315:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_0()); 
            // InternalDefinitionLanguage.g:3316:2: ( rule__AndExpressionRule__SubExpressionsAssignment_0 )
            // InternalDefinitionLanguage.g:3316:3: rule__AndExpressionRule__SubExpressionsAssignment_0
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
    // InternalDefinitionLanguage.g:3324:1: rule__AndExpressionRule__Group__1 : rule__AndExpressionRule__Group__1__Impl ;
    public final void rule__AndExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3328:1: ( rule__AndExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3329:2: rule__AndExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3335:1: rule__AndExpressionRule__Group__1__Impl : ( ( rule__AndExpressionRule__Group_1__0 )* ) ;
    public final void rule__AndExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3339:1: ( ( ( rule__AndExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3340:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3340:1: ( ( rule__AndExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3341:2: ( rule__AndExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3342:2: ( rule__AndExpressionRule__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==68) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3342:3: rule__AndExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__AndExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalDefinitionLanguage.g:3351:1: rule__AndExpressionRule__Group_1__0 : rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 ;
    public final void rule__AndExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3355:1: ( rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3356:2: rule__AndExpressionRule__Group_1__0__Impl rule__AndExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:3363:1: rule__AndExpressionRule__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__AndExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3367:1: ( ( 'AND' ) )
            // InternalDefinitionLanguage.g:3368:1: ( 'AND' )
            {
            // InternalDefinitionLanguage.g:3368:1: ( 'AND' )
            // InternalDefinitionLanguage.g:3369:2: 'AND'
            {
             before(grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3378:1: rule__AndExpressionRule__Group_1__1 : rule__AndExpressionRule__Group_1__1__Impl ;
    public final void rule__AndExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3382:1: ( rule__AndExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3383:2: rule__AndExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3389:1: rule__AndExpressionRule__Group_1__1__Impl : ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3393:1: ( ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3394:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3394:1: ( ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3395:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3396:2: ( rule__AndExpressionRule__SubExpressionsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3396:3: rule__AndExpressionRule__SubExpressionsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3405:1: rule__NotExpressionRule__Group__0 : rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 ;
    public final void rule__NotExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3409:1: ( rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3410:2: rule__NotExpressionRule__Group__0__Impl rule__NotExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3417:1: rule__NotExpressionRule__Group__0__Impl : ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) ;
    public final void rule__NotExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3421:1: ( ( ( rule__NotExpressionRule__NegatedAssignment_0 )? ) )
            // InternalDefinitionLanguage.g:3422:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            {
            // InternalDefinitionLanguage.g:3422:1: ( ( rule__NotExpressionRule__NegatedAssignment_0 )? )
            // InternalDefinitionLanguage.g:3423:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedAssignment_0()); 
            // InternalDefinitionLanguage.g:3424:2: ( rule__NotExpressionRule__NegatedAssignment_0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==73) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalDefinitionLanguage.g:3424:3: rule__NotExpressionRule__NegatedAssignment_0
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
    // InternalDefinitionLanguage.g:3432:1: rule__NotExpressionRule__Group__1 : rule__NotExpressionRule__Group__1__Impl ;
    public final void rule__NotExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3436:1: ( rule__NotExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3437:2: rule__NotExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3443:1: rule__NotExpressionRule__Group__1__Impl : ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) ;
    public final void rule__NotExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3447:1: ( ( ( rule__NotExpressionRule__OperandAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3448:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3448:1: ( ( rule__NotExpressionRule__OperandAssignment_1 ) )
            // InternalDefinitionLanguage.g:3449:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getOperandAssignment_1()); 
            // InternalDefinitionLanguage.g:3450:2: ( rule__NotExpressionRule__OperandAssignment_1 )
            // InternalDefinitionLanguage.g:3450:3: rule__NotExpressionRule__OperandAssignment_1
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
    // InternalDefinitionLanguage.g:3459:1: rule__ComparisonExpressionRule__Group__0 : rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 ;
    public final void rule__ComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3463:1: ( rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3464:2: rule__ComparisonExpressionRule__Group__0__Impl rule__ComparisonExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3471:1: rule__ComparisonExpressionRule__Group__0__Impl : ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__ComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3475:1: ( ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3476:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3476:1: ( ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3477:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:3478:2: ( rule__ComparisonExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3478:3: rule__ComparisonExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3486:1: rule__ComparisonExpressionRule__Group__1 : rule__ComparisonExpressionRule__Group__1__Impl ;
    public final void rule__ComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3490:1: ( rule__ComparisonExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3491:2: rule__ComparisonExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3497:1: rule__ComparisonExpressionRule__Group__1__Impl : ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) ;
    public final void rule__ComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3501:1: ( ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* ) )
            // InternalDefinitionLanguage.g:3502:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            {
            // InternalDefinitionLanguage.g:3502:1: ( ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )* )
            // InternalDefinitionLanguage.g:3503:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            {
             before(grammarAccess.getComparisonExpressionRuleAccess().getComparisonAssignment_1()); 
            // InternalDefinitionLanguage.g:3504:2: ( rule__ComparisonExpressionRule__ComparisonAssignment_1 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=13 && LA24_0<=18)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3504:3: rule__ComparisonExpressionRule__ComparisonAssignment_1
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__ComparisonExpressionRule__ComparisonAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalDefinitionLanguage.g:3513:1: rule__PartialComparisonExpressionRule__Group__0 : rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 ;
    public final void rule__PartialComparisonExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3517:1: ( rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3518:2: rule__PartialComparisonExpressionRule__Group__0__Impl rule__PartialComparisonExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3525:1: rule__PartialComparisonExpressionRule__Group__0__Impl : ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3529:1: ( ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3530:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3530:1: ( ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 ) )
            // InternalDefinitionLanguage.g:3531:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorAssignment_0()); 
            // InternalDefinitionLanguage.g:3532:2: ( rule__PartialComparisonExpressionRule__OperatorAssignment_0 )
            // InternalDefinitionLanguage.g:3532:3: rule__PartialComparisonExpressionRule__OperatorAssignment_0
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
    // InternalDefinitionLanguage.g:3540:1: rule__PartialComparisonExpressionRule__Group__1 : rule__PartialComparisonExpressionRule__Group__1__Impl ;
    public final void rule__PartialComparisonExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3544:1: ( rule__PartialComparisonExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3545:2: rule__PartialComparisonExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3551:1: rule__PartialComparisonExpressionRule__Group__1__Impl : ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__PartialComparisonExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3555:1: ( ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3556:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3556:1: ( ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3557:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalDefinitionLanguage.g:3558:2: ( rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3558:3: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3567:1: rule__AddOrSubtractExpressionRule__Group__0 : rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3571:1: ( rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3572:2: rule__AddOrSubtractExpressionRule__Group__0__Impl rule__AddOrSubtractExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3579:1: rule__AddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3583:1: ( ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3584:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3584:1: ( ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3585:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:3586:2: ( rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3586:3: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3594:1: rule__AddOrSubtractExpressionRule__Group__1 : rule__AddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3598:1: ( rule__AddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3599:2: rule__AddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3605:1: rule__AddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) ;
    public final void rule__AddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3609:1: ( ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3610:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3610:1: ( ( rule__AddOrSubtractExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3611:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3612:2: ( rule__AddOrSubtractExpressionRule__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=19 && LA25_0<=20)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3612:3: rule__AddOrSubtractExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__AddOrSubtractExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalDefinitionLanguage.g:3621:1: rule__AddOrSubtractExpressionRule__Group_1__0 : rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3625:1: ( rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3626:2: rule__AddOrSubtractExpressionRule__Group_1__0__Impl rule__AddOrSubtractExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:3633:1: rule__AddOrSubtractExpressionRule__Group_1__0__Impl : ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3637:1: ( ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDefinitionLanguage.g:3638:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDefinitionLanguage.g:3638:1: ( ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDefinitionLanguage.g:3639:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalDefinitionLanguage.g:3640:2: ( rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 )
            // InternalDefinitionLanguage.g:3640:3: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0
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
    // InternalDefinitionLanguage.g:3648:1: rule__AddOrSubtractExpressionRule__Group_1__1 : rule__AddOrSubtractExpressionRule__Group_1__1__Impl ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3652:1: ( rule__AddOrSubtractExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3653:2: rule__AddOrSubtractExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3659:1: rule__AddOrSubtractExpressionRule__Group_1__1__Impl : ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__AddOrSubtractExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3663:1: ( ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3664:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3664:1: ( ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3665:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3666:2: ( rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3666:3: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3675:1: rule__MultiplyDivideModuloExpressionRule__Group__0 : rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3679:1: ( rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3680:2: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl rule__MultiplyDivideModuloExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3687:1: rule__MultiplyDivideModuloExpressionRule__Group__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3691:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3692:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3692:1: ( ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3693:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:3694:2: ( rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3694:3: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3702:1: rule__MultiplyDivideModuloExpressionRule__Group__1 : rule__MultiplyDivideModuloExpressionRule__Group__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3706:1: ( rule__MultiplyDivideModuloExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3707:2: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3713:1: rule__MultiplyDivideModuloExpressionRule__Group__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3717:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* ) )
            // InternalDefinitionLanguage.g:3718:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            {
            // InternalDefinitionLanguage.g:3718:1: ( ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )* )
            // InternalDefinitionLanguage.g:3719:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3720:2: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=21 && LA26_0<=23)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3720:3: rule__MultiplyDivideModuloExpressionRule__Group_1__0
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__MultiplyDivideModuloExpressionRule__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalDefinitionLanguage.g:3729:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0 : rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3733:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3734:2: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl rule__MultiplyDivideModuloExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:3741:1: rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3745:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) ) )
            // InternalDefinitionLanguage.g:3746:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            {
            // InternalDefinitionLanguage.g:3746:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 ) )
            // InternalDefinitionLanguage.g:3747:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsAssignment_1_0()); 
            // InternalDefinitionLanguage.g:3748:2: ( rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 )
            // InternalDefinitionLanguage.g:3748:3: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0
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
    // InternalDefinitionLanguage.g:3756:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1 : rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3760:1: ( rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3761:2: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3767:1: rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl : ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3771:1: ( ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3772:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3772:1: ( ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3773:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            {
             before(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3774:2: ( rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 )
            // InternalDefinitionLanguage.g:3774:3: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1
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
    // InternalDefinitionLanguage.g:3783:1: rule__PowerOfExpressionRule__Group__0 : rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 ;
    public final void rule__PowerOfExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3787:1: ( rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3788:2: rule__PowerOfExpressionRule__Group__0__Impl rule__PowerOfExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3795:1: rule__PowerOfExpressionRule__Group__0__Impl : ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) ;
    public final void rule__PowerOfExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3799:1: ( ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:3800:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:3800:1: ( ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 ) )
            // InternalDefinitionLanguage.g:3801:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandAssignment_0()); 
            // InternalDefinitionLanguage.g:3802:2: ( rule__PowerOfExpressionRule__LeftOperandAssignment_0 )
            // InternalDefinitionLanguage.g:3802:3: rule__PowerOfExpressionRule__LeftOperandAssignment_0
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
    // InternalDefinitionLanguage.g:3810:1: rule__PowerOfExpressionRule__Group__1 : rule__PowerOfExpressionRule__Group__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3814:1: ( rule__PowerOfExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3815:2: rule__PowerOfExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3821:1: rule__PowerOfExpressionRule__Group__1__Impl : ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) ;
    public final void rule__PowerOfExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3825:1: ( ( ( rule__PowerOfExpressionRule__Group_1__0 )? ) )
            // InternalDefinitionLanguage.g:3826:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            {
            // InternalDefinitionLanguage.g:3826:1: ( ( rule__PowerOfExpressionRule__Group_1__0 )? )
            // InternalDefinitionLanguage.g:3827:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getGroup_1()); 
            // InternalDefinitionLanguage.g:3828:2: ( rule__PowerOfExpressionRule__Group_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==69) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDefinitionLanguage.g:3828:3: rule__PowerOfExpressionRule__Group_1__0
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
    // InternalDefinitionLanguage.g:3837:1: rule__PowerOfExpressionRule__Group_1__0 : rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 ;
    public final void rule__PowerOfExpressionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3841:1: ( rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1 )
            // InternalDefinitionLanguage.g:3842:2: rule__PowerOfExpressionRule__Group_1__0__Impl rule__PowerOfExpressionRule__Group_1__1
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
    // InternalDefinitionLanguage.g:3849:1: rule__PowerOfExpressionRule__Group_1__0__Impl : ( '^' ) ;
    public final void rule__PowerOfExpressionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3853:1: ( ( '^' ) )
            // InternalDefinitionLanguage.g:3854:1: ( '^' )
            {
            // InternalDefinitionLanguage.g:3854:1: ( '^' )
            // InternalDefinitionLanguage.g:3855:2: '^'
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3864:1: rule__PowerOfExpressionRule__Group_1__1 : rule__PowerOfExpressionRule__Group_1__1__Impl ;
    public final void rule__PowerOfExpressionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3868:1: ( rule__PowerOfExpressionRule__Group_1__1__Impl )
            // InternalDefinitionLanguage.g:3869:2: rule__PowerOfExpressionRule__Group_1__1__Impl
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
    // InternalDefinitionLanguage.g:3875:1: rule__PowerOfExpressionRule__Group_1__1__Impl : ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PowerOfExpressionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3879:1: ( ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) ) )
            // InternalDefinitionLanguage.g:3880:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            {
            // InternalDefinitionLanguage.g:3880:1: ( ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 ) )
            // InternalDefinitionLanguage.g:3881:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            {
             before(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandAssignment_1_1()); 
            // InternalDefinitionLanguage.g:3882:2: ( rule__PowerOfExpressionRule__RightOperandAssignment_1_1 )
            // InternalDefinitionLanguage.g:3882:3: rule__PowerOfExpressionRule__RightOperandAssignment_1_1
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
    // InternalDefinitionLanguage.g:3891:1: rule__UnaryAddOrSubtractExpressionRule__Group__0 : rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3895:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1 )
            // InternalDefinitionLanguage.g:3896:2: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl rule__UnaryAddOrSubtractExpressionRule__Group__1
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
    // InternalDefinitionLanguage.g:3903:1: rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3907:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* ) )
            // InternalDefinitionLanguage.g:3908:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            {
            // InternalDefinitionLanguage.g:3908:1: ( ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )* )
            // InternalDefinitionLanguage.g:3909:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAssignment_0()); 
            // InternalDefinitionLanguage.g:3910:2: ( rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=19 && LA28_0<=20)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3910:3: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalDefinitionLanguage.g:3918:1: rule__UnaryAddOrSubtractExpressionRule__Group__1 : rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3922:1: ( rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:3923:2: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:3929:1: rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl : ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3933:1: ( ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3934:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3934:1: ( ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3935:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionAssignment_1()); 
            // InternalDefinitionLanguage.g:3936:2: ( rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3936:3: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3945:1: rule__ParanthesesRule__Group__0 : rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 ;
    public final void rule__ParanthesesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3949:1: ( rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1 )
            // InternalDefinitionLanguage.g:3950:2: rule__ParanthesesRule__Group__0__Impl rule__ParanthesesRule__Group__1
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
    // InternalDefinitionLanguage.g:3957:1: rule__ParanthesesRule__Group__0__Impl : ( '(' ) ;
    public final void rule__ParanthesesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3961:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:3962:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:3962:1: ( '(' )
            // InternalDefinitionLanguage.g:3963:2: '('
            {
             before(grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:3972:1: rule__ParanthesesRule__Group__1 : rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 ;
    public final void rule__ParanthesesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3976:1: ( rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2 )
            // InternalDefinitionLanguage.g:3977:2: rule__ParanthesesRule__Group__1__Impl rule__ParanthesesRule__Group__2
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
    // InternalDefinitionLanguage.g:3984:1: rule__ParanthesesRule__Group__1__Impl : ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) ;
    public final void rule__ParanthesesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:3988:1: ( ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) ) )
            // InternalDefinitionLanguage.g:3989:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            {
            // InternalDefinitionLanguage.g:3989:1: ( ( rule__ParanthesesRule__SubExpressionAssignment_1 ) )
            // InternalDefinitionLanguage.g:3990:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            {
             before(grammarAccess.getParanthesesRuleAccess().getSubExpressionAssignment_1()); 
            // InternalDefinitionLanguage.g:3991:2: ( rule__ParanthesesRule__SubExpressionAssignment_1 )
            // InternalDefinitionLanguage.g:3991:3: rule__ParanthesesRule__SubExpressionAssignment_1
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
    // InternalDefinitionLanguage.g:3999:1: rule__ParanthesesRule__Group__2 : rule__ParanthesesRule__Group__2__Impl ;
    public final void rule__ParanthesesRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4003:1: ( rule__ParanthesesRule__Group__2__Impl )
            // InternalDefinitionLanguage.g:4004:2: rule__ParanthesesRule__Group__2__Impl
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
    // InternalDefinitionLanguage.g:4010:1: rule__ParanthesesRule__Group__2__Impl : ( ')' ) ;
    public final void rule__ParanthesesRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4014:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:4015:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:4015:1: ( ')' )
            // InternalDefinitionLanguage.g:4016:2: ')'
            {
             before(grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2()); 
            match(input,64,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4026:1: rule__CallRule__Group__0 : rule__CallRule__Group__0__Impl rule__CallRule__Group__1 ;
    public final void rule__CallRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4030:1: ( rule__CallRule__Group__0__Impl rule__CallRule__Group__1 )
            // InternalDefinitionLanguage.g:4031:2: rule__CallRule__Group__0__Impl rule__CallRule__Group__1
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
    // InternalDefinitionLanguage.g:4038:1: rule__CallRule__Group__0__Impl : ( ( rule__CallRule__FunctionAssignment_0 ) ) ;
    public final void rule__CallRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4042:1: ( ( ( rule__CallRule__FunctionAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4043:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4043:1: ( ( rule__CallRule__FunctionAssignment_0 ) )
            // InternalDefinitionLanguage.g:4044:2: ( rule__CallRule__FunctionAssignment_0 )
            {
             before(grammarAccess.getCallRuleAccess().getFunctionAssignment_0()); 
            // InternalDefinitionLanguage.g:4045:2: ( rule__CallRule__FunctionAssignment_0 )
            // InternalDefinitionLanguage.g:4045:3: rule__CallRule__FunctionAssignment_0
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
    // InternalDefinitionLanguage.g:4053:1: rule__CallRule__Group__1 : rule__CallRule__Group__1__Impl rule__CallRule__Group__2 ;
    public final void rule__CallRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4057:1: ( rule__CallRule__Group__1__Impl rule__CallRule__Group__2 )
            // InternalDefinitionLanguage.g:4058:2: rule__CallRule__Group__1__Impl rule__CallRule__Group__2
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
    // InternalDefinitionLanguage.g:4065:1: rule__CallRule__Group__1__Impl : ( '(' ) ;
    public final void rule__CallRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4069:1: ( ( '(' ) )
            // InternalDefinitionLanguage.g:4070:1: ( '(' )
            {
            // InternalDefinitionLanguage.g:4070:1: ( '(' )
            // InternalDefinitionLanguage.g:4071:2: '('
            {
             before(grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1()); 
            match(input,63,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4080:1: rule__CallRule__Group__2 : rule__CallRule__Group__2__Impl rule__CallRule__Group__3 ;
    public final void rule__CallRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4084:1: ( rule__CallRule__Group__2__Impl rule__CallRule__Group__3 )
            // InternalDefinitionLanguage.g:4085:2: rule__CallRule__Group__2__Impl rule__CallRule__Group__3
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
    // InternalDefinitionLanguage.g:4092:1: rule__CallRule__Group__2__Impl : ( ( rule__CallRule__Group_2__0 )? ) ;
    public final void rule__CallRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4096:1: ( ( ( rule__CallRule__Group_2__0 )? ) )
            // InternalDefinitionLanguage.g:4097:1: ( ( rule__CallRule__Group_2__0 )? )
            {
            // InternalDefinitionLanguage.g:4097:1: ( ( rule__CallRule__Group_2__0 )? )
            // InternalDefinitionLanguage.g:4098:2: ( rule__CallRule__Group_2__0 )?
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2()); 
            // InternalDefinitionLanguage.g:4099:2: ( rule__CallRule__Group_2__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_QUOTED_ID && LA29_0<=RULE_STRING)||LA29_0==12||(LA29_0>=19 && LA29_0<=20)||LA29_0==63||LA29_0==70||(LA29_0>=73 && LA29_0<=74)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDefinitionLanguage.g:4099:3: rule__CallRule__Group_2__0
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
    // InternalDefinitionLanguage.g:4107:1: rule__CallRule__Group__3 : rule__CallRule__Group__3__Impl ;
    public final void rule__CallRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4111:1: ( rule__CallRule__Group__3__Impl )
            // InternalDefinitionLanguage.g:4112:2: rule__CallRule__Group__3__Impl
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
    // InternalDefinitionLanguage.g:4118:1: rule__CallRule__Group__3__Impl : ( ')' ) ;
    public final void rule__CallRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4122:1: ( ( ')' ) )
            // InternalDefinitionLanguage.g:4123:1: ( ')' )
            {
            // InternalDefinitionLanguage.g:4123:1: ( ')' )
            // InternalDefinitionLanguage.g:4124:2: ')'
            {
             before(grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3()); 
            match(input,64,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4134:1: rule__CallRule__Group_2__0 : rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 ;
    public final void rule__CallRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4138:1: ( rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1 )
            // InternalDefinitionLanguage.g:4139:2: rule__CallRule__Group_2__0__Impl rule__CallRule__Group_2__1
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
    // InternalDefinitionLanguage.g:4146:1: rule__CallRule__Group_2__0__Impl : ( ( rule__CallRule__ParametersAssignment_2_0 ) ) ;
    public final void rule__CallRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4150:1: ( ( ( rule__CallRule__ParametersAssignment_2_0 ) ) )
            // InternalDefinitionLanguage.g:4151:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            {
            // InternalDefinitionLanguage.g:4151:1: ( ( rule__CallRule__ParametersAssignment_2_0 ) )
            // InternalDefinitionLanguage.g:4152:2: ( rule__CallRule__ParametersAssignment_2_0 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_0()); 
            // InternalDefinitionLanguage.g:4153:2: ( rule__CallRule__ParametersAssignment_2_0 )
            // InternalDefinitionLanguage.g:4153:3: rule__CallRule__ParametersAssignment_2_0
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
    // InternalDefinitionLanguage.g:4161:1: rule__CallRule__Group_2__1 : rule__CallRule__Group_2__1__Impl ;
    public final void rule__CallRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4165:1: ( rule__CallRule__Group_2__1__Impl )
            // InternalDefinitionLanguage.g:4166:2: rule__CallRule__Group_2__1__Impl
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
    // InternalDefinitionLanguage.g:4172:1: rule__CallRule__Group_2__1__Impl : ( ( rule__CallRule__Group_2_1__0 )* ) ;
    public final void rule__CallRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4176:1: ( ( ( rule__CallRule__Group_2_1__0 )* ) )
            // InternalDefinitionLanguage.g:4177:1: ( ( rule__CallRule__Group_2_1__0 )* )
            {
            // InternalDefinitionLanguage.g:4177:1: ( ( rule__CallRule__Group_2_1__0 )* )
            // InternalDefinitionLanguage.g:4178:2: ( rule__CallRule__Group_2_1__0 )*
            {
             before(grammarAccess.getCallRuleAccess().getGroup_2_1()); 
            // InternalDefinitionLanguage.g:4179:2: ( rule__CallRule__Group_2_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==65) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:4179:3: rule__CallRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__CallRule__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalDefinitionLanguage.g:4188:1: rule__CallRule__Group_2_1__0 : rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 ;
    public final void rule__CallRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4192:1: ( rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1 )
            // InternalDefinitionLanguage.g:4193:2: rule__CallRule__Group_2_1__0__Impl rule__CallRule__Group_2_1__1
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
    // InternalDefinitionLanguage.g:4200:1: rule__CallRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__CallRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4204:1: ( ( ',' ) )
            // InternalDefinitionLanguage.g:4205:1: ( ',' )
            {
            // InternalDefinitionLanguage.g:4205:1: ( ',' )
            // InternalDefinitionLanguage.g:4206:2: ','
            {
             before(grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4215:1: rule__CallRule__Group_2_1__1 : rule__CallRule__Group_2_1__1__Impl ;
    public final void rule__CallRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4219:1: ( rule__CallRule__Group_2_1__1__Impl )
            // InternalDefinitionLanguage.g:4220:2: rule__CallRule__Group_2_1__1__Impl
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
    // InternalDefinitionLanguage.g:4226:1: rule__CallRule__Group_2_1__1__Impl : ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) ;
    public final void rule__CallRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4230:1: ( ( ( rule__CallRule__ParametersAssignment_2_1_1 ) ) )
            // InternalDefinitionLanguage.g:4231:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            {
            // InternalDefinitionLanguage.g:4231:1: ( ( rule__CallRule__ParametersAssignment_2_1_1 ) )
            // InternalDefinitionLanguage.g:4232:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            {
             before(grammarAccess.getCallRuleAccess().getParametersAssignment_2_1_1()); 
            // InternalDefinitionLanguage.g:4233:2: ( rule__CallRule__ParametersAssignment_2_1_1 )
            // InternalDefinitionLanguage.g:4233:3: rule__CallRule__ParametersAssignment_2_1_1
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
    // InternalDefinitionLanguage.g:4242:1: rule__ValueReferenceRule__Group__0 : rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 ;
    public final void rule__ValueReferenceRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4246:1: ( rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1 )
            // InternalDefinitionLanguage.g:4247:2: rule__ValueReferenceRule__Group__0__Impl rule__ValueReferenceRule__Group__1
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
    // InternalDefinitionLanguage.g:4254:1: rule__ValueReferenceRule__Group__0__Impl : ( () ) ;
    public final void rule__ValueReferenceRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4258:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4259:1: ( () )
            {
            // InternalDefinitionLanguage.g:4259:1: ( () )
            // InternalDefinitionLanguage.g:4260:2: ()
            {
             before(grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0()); 
            // InternalDefinitionLanguage.g:4261:2: ()
            // InternalDefinitionLanguage.g:4261:3: 
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
    // InternalDefinitionLanguage.g:4269:1: rule__ValueReferenceRule__Group__1 : rule__ValueReferenceRule__Group__1__Impl ;
    public final void rule__ValueReferenceRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4273:1: ( rule__ValueReferenceRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4274:2: rule__ValueReferenceRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4280:1: rule__ValueReferenceRule__Group__1__Impl : ( 'value' ) ;
    public final void rule__ValueReferenceRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4284:1: ( ( 'value' ) )
            // InternalDefinitionLanguage.g:4285:1: ( 'value' )
            {
            // InternalDefinitionLanguage.g:4285:1: ( 'value' )
            // InternalDefinitionLanguage.g:4286:2: 'value'
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
    // InternalDefinitionLanguage.g:4296:1: rule__DoubleLiteralRule__Group__0 : rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 ;
    public final void rule__DoubleLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4300:1: ( rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4301:2: rule__DoubleLiteralRule__Group__0__Impl rule__DoubleLiteralRule__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalDefinitionLanguage.g:4308:1: rule__DoubleLiteralRule__Group__0__Impl : ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__DoubleLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4312:1: ( ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4313:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4313:1: ( ( rule__DoubleLiteralRule__LiteralAssignment_0 ) )
            // InternalDefinitionLanguage.g:4314:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralAssignment_0()); 
            // InternalDefinitionLanguage.g:4315:2: ( rule__DoubleLiteralRule__LiteralAssignment_0 )
            // InternalDefinitionLanguage.g:4315:3: rule__DoubleLiteralRule__LiteralAssignment_0
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
    // InternalDefinitionLanguage.g:4323:1: rule__DoubleLiteralRule__Group__1 : rule__DoubleLiteralRule__Group__1__Impl ;
    public final void rule__DoubleLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4327:1: ( rule__DoubleLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4328:2: rule__DoubleLiteralRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4334:1: rule__DoubleLiteralRule__Group__1__Impl : ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__DoubleLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4338:1: ( ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? ) )
            // InternalDefinitionLanguage.g:4339:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDefinitionLanguage.g:4339:1: ( ( rule__DoubleLiteralRule__FactorAssignment_1 )? )
            // InternalDefinitionLanguage.g:4340:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getFactorAssignment_1()); 
            // InternalDefinitionLanguage.g:4341:2: ( rule__DoubleLiteralRule__FactorAssignment_1 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=24 && LA31_0<=43)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDefinitionLanguage.g:4341:3: rule__DoubleLiteralRule__FactorAssignment_1
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
    // InternalDefinitionLanguage.g:4350:1: rule__IntegerLiteralRule__Group__0 : rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 ;
    public final void rule__IntegerLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4354:1: ( rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4355:2: rule__IntegerLiteralRule__Group__0__Impl rule__IntegerLiteralRule__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalDefinitionLanguage.g:4362:1: rule__IntegerLiteralRule__Group__0__Impl : ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) ;
    public final void rule__IntegerLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4366:1: ( ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) ) )
            // InternalDefinitionLanguage.g:4367:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            {
            // InternalDefinitionLanguage.g:4367:1: ( ( rule__IntegerLiteralRule__LiteralAssignment_0 ) )
            // InternalDefinitionLanguage.g:4368:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getLiteralAssignment_0()); 
            // InternalDefinitionLanguage.g:4369:2: ( rule__IntegerLiteralRule__LiteralAssignment_0 )
            // InternalDefinitionLanguage.g:4369:3: rule__IntegerLiteralRule__LiteralAssignment_0
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
    // InternalDefinitionLanguage.g:4377:1: rule__IntegerLiteralRule__Group__1 : rule__IntegerLiteralRule__Group__1__Impl ;
    public final void rule__IntegerLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4381:1: ( rule__IntegerLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4382:2: rule__IntegerLiteralRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4388:1: rule__IntegerLiteralRule__Group__1__Impl : ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) ;
    public final void rule__IntegerLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4392:1: ( ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? ) )
            // InternalDefinitionLanguage.g:4393:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            {
            // InternalDefinitionLanguage.g:4393:1: ( ( rule__IntegerLiteralRule__FactorAssignment_1 )? )
            // InternalDefinitionLanguage.g:4394:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getFactorAssignment_1()); 
            // InternalDefinitionLanguage.g:4395:2: ( rule__IntegerLiteralRule__FactorAssignment_1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=24 && LA32_0<=43)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalDefinitionLanguage.g:4395:3: rule__IntegerLiteralRule__FactorAssignment_1
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
    // InternalDefinitionLanguage.g:4404:1: rule__BooleanLiteralRule__Group__0 : rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 ;
    public final void rule__BooleanLiteralRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4408:1: ( rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1 )
            // InternalDefinitionLanguage.g:4409:2: rule__BooleanLiteralRule__Group__0__Impl rule__BooleanLiteralRule__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalDefinitionLanguage.g:4416:1: rule__BooleanLiteralRule__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4420:1: ( ( () ) )
            // InternalDefinitionLanguage.g:4421:1: ( () )
            {
            // InternalDefinitionLanguage.g:4421:1: ( () )
            // InternalDefinitionLanguage.g:4422:2: ()
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0()); 
            // InternalDefinitionLanguage.g:4423:2: ()
            // InternalDefinitionLanguage.g:4423:3: 
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
    // InternalDefinitionLanguage.g:4431:1: rule__BooleanLiteralRule__Group__1 : rule__BooleanLiteralRule__Group__1__Impl ;
    public final void rule__BooleanLiteralRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4435:1: ( rule__BooleanLiteralRule__Group__1__Impl )
            // InternalDefinitionLanguage.g:4436:2: rule__BooleanLiteralRule__Group__1__Impl
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
    // InternalDefinitionLanguage.g:4442:1: rule__BooleanLiteralRule__Group__1__Impl : ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4446:1: ( ( ( rule__BooleanLiteralRule__Alternatives_1 ) ) )
            // InternalDefinitionLanguage.g:4447:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            {
            // InternalDefinitionLanguage.g:4447:1: ( ( rule__BooleanLiteralRule__Alternatives_1 ) )
            // InternalDefinitionLanguage.g:4448:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getAlternatives_1()); 
            // InternalDefinitionLanguage.g:4449:2: ( rule__BooleanLiteralRule__Alternatives_1 )
            // InternalDefinitionLanguage.g:4449:3: rule__BooleanLiteralRule__Alternatives_1
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
    // InternalDefinitionLanguage.g:4458:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4462:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // InternalDefinitionLanguage.g:4463:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalDefinitionLanguage.g:4470:1: rule__DOUBLE__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4474:1: ( ( RULE_INT ) )
            // InternalDefinitionLanguage.g:4475:1: ( RULE_INT )
            {
            // InternalDefinitionLanguage.g:4475:1: ( RULE_INT )
            // InternalDefinitionLanguage.g:4476:2: RULE_INT
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
    // InternalDefinitionLanguage.g:4485:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4489:1: ( rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 )
            // InternalDefinitionLanguage.g:4490:2: rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2
            {
            pushFollow(FOLLOW_45);
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
    // InternalDefinitionLanguage.g:4497:1: rule__DOUBLE__Group__1__Impl : ( '.' ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4501:1: ( ( '.' ) )
            // InternalDefinitionLanguage.g:4502:1: ( '.' )
            {
            // InternalDefinitionLanguage.g:4502:1: ( '.' )
            // InternalDefinitionLanguage.g:4503:2: '.'
            {
             before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 
            match(input,71,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4512:1: rule__DOUBLE__Group__2 : rule__DOUBLE__Group__2__Impl ;
    public final void rule__DOUBLE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4516:1: ( rule__DOUBLE__Group__2__Impl )
            // InternalDefinitionLanguage.g:4517:2: rule__DOUBLE__Group__2__Impl
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
    // InternalDefinitionLanguage.g:4523:1: rule__DOUBLE__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4527:1: ( ( RULE_INT ) )
            // InternalDefinitionLanguage.g:4528:1: ( RULE_INT )
            {
            // InternalDefinitionLanguage.g:4528:1: ( RULE_INT )
            // InternalDefinitionLanguage.g:4529:2: RULE_INT
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
    // InternalDefinitionLanguage.g:4539:1: rule__DefinitionModelRule__TypesAssignment_0 : ( ruleTypeDefinitionRule ) ;
    public final void rule__DefinitionModelRule__TypesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4543:1: ( ( ruleTypeDefinitionRule ) )
            // InternalDefinitionLanguage.g:4544:2: ( ruleTypeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:4544:2: ( ruleTypeDefinitionRule )
            // InternalDefinitionLanguage.g:4545:3: ruleTypeDefinitionRule
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
    // InternalDefinitionLanguage.g:4554:1: rule__DefinitionModelRule__FunctionsAssignment_1 : ( ruleFunctioDefinitionRule ) ;
    public final void rule__DefinitionModelRule__FunctionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4558:1: ( ( ruleFunctioDefinitionRule ) )
            // InternalDefinitionLanguage.g:4559:2: ( ruleFunctioDefinitionRule )
            {
            // InternalDefinitionLanguage.g:4559:2: ( ruleFunctioDefinitionRule )
            // InternalDefinitionLanguage.g:4560:3: ruleFunctioDefinitionRule
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
    // InternalDefinitionLanguage.g:4569:1: rule__TypeDefinitionRule__AbstractAssignment_0 : ( ( 'abstract' ) ) ;
    public final void rule__TypeDefinitionRule__AbstractAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4573:1: ( ( ( 'abstract' ) ) )
            // InternalDefinitionLanguage.g:4574:2: ( ( 'abstract' ) )
            {
            // InternalDefinitionLanguage.g:4574:2: ( ( 'abstract' ) )
            // InternalDefinitionLanguage.g:4575:3: ( 'abstract' )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 
            // InternalDefinitionLanguage.g:4576:3: ( 'abstract' )
            // InternalDefinitionLanguage.g:4577:4: 'abstract'
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0()); 
            match(input,72,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4588:1: rule__TypeDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__TypeDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4592:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4593:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:4593:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4594:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:4603:1: rule__TypeDefinitionRule__SuperTypeAssignment_3_1 : ( ( ruleStringOrId ) ) ;
    public final void rule__TypeDefinitionRule__SuperTypeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4607:1: ( ( ( ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:4608:2: ( ( ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:4608:2: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4609:3: ( ruleStringOrId )
            {
             before(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionCrossReference_3_1_0()); 
            // InternalDefinitionLanguage.g:4610:3: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4611:4: ruleStringOrId
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
    // InternalDefinitionLanguage.g:4622:1: rule__TypeDefinitionRule__AttributesAssignment_5 : ( ruleAttributeDefinitionRule ) ;
    public final void rule__TypeDefinitionRule__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4626:1: ( ( ruleAttributeDefinitionRule ) )
            // InternalDefinitionLanguage.g:4627:2: ( ruleAttributeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:4627:2: ( ruleAttributeDefinitionRule )
            // InternalDefinitionLanguage.g:4628:3: ruleAttributeDefinitionRule
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
    // InternalDefinitionLanguage.g:4637:1: rule__UnnamedAttributeDefinitionRule__TypeAssignment_2 : ( ruleTypeRule ) ;
    public final void rule__UnnamedAttributeDefinitionRule__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4641:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:4642:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:4642:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:4643:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:4652:1: rule__NamedAttributeDefinitionRule__NameAssignment_0 : ( ruleStringOrId ) ;
    public final void rule__NamedAttributeDefinitionRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4656:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4657:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:4657:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4658:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:4667:1: rule__NamedAttributeDefinitionRule__TypeAssignment_2 : ( ruleTypeRule ) ;
    public final void rule__NamedAttributeDefinitionRule__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4671:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:4672:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:4672:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:4673:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:4682:1: rule__InstanceTypeRule__DefinitionsAssignment_2 : ( ( ruleStringOrId ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4686:1: ( ( ( ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:4687:2: ( ( ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:4687:2: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4688:3: ( ruleStringOrId )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_2_0()); 
            // InternalDefinitionLanguage.g:4689:3: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4690:4: ruleStringOrId
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
    // InternalDefinitionLanguage.g:4701:1: rule__InstanceTypeRule__DefinitionsAssignment_3_1 : ( ( ruleStringOrId ) ) ;
    public final void rule__InstanceTypeRule__DefinitionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4705:1: ( ( ( ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:4706:2: ( ( ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:4706:2: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4707:3: ( ruleStringOrId )
            {
             before(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_3_1_0()); 
            // InternalDefinitionLanguage.g:4708:3: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4709:4: ruleStringOrId
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
    // InternalDefinitionLanguage.g:4720:1: rule__ArrayTypeRule__ElementsAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__ArrayTypeRule__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4724:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:4725:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:4725:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:4726:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:4735:1: rule__FunctioDefinitionRule__TypeAssignment_1 : ( ruleTypeRule ) ;
    public final void rule__FunctioDefinitionRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4739:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:4740:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:4740:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:4741:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:4750:1: rule__FunctioDefinitionRule__NameAssignment_2 : ( ruleStringOrId ) ;
    public final void rule__FunctioDefinitionRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4754:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4755:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:4755:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4756:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:4765:1: rule__FunctioDefinitionRule__ParametersAssignment_4_0 : ( ruleParameterRule ) ;
    public final void rule__FunctioDefinitionRule__ParametersAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4769:1: ( ( ruleParameterRule ) )
            // InternalDefinitionLanguage.g:4770:2: ( ruleParameterRule )
            {
            // InternalDefinitionLanguage.g:4770:2: ( ruleParameterRule )
            // InternalDefinitionLanguage.g:4771:3: ruleParameterRule
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
    // InternalDefinitionLanguage.g:4780:1: rule__FunctioDefinitionRule__ParametersAssignment_4_1_1 : ( ruleParameterRule ) ;
    public final void rule__FunctioDefinitionRule__ParametersAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4784:1: ( ( ruleParameterRule ) )
            // InternalDefinitionLanguage.g:4785:2: ( ruleParameterRule )
            {
            // InternalDefinitionLanguage.g:4785:2: ( ruleParameterRule )
            // InternalDefinitionLanguage.g:4786:3: ruleParameterRule
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
    // InternalDefinitionLanguage.g:4795:1: rule__ParameterRule__TypeAssignment_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4799:1: ( ( ruleTypeRule ) )
            // InternalDefinitionLanguage.g:4800:2: ( ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:4800:2: ( ruleTypeRule )
            // InternalDefinitionLanguage.g:4801:3: ruleTypeRule
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
    // InternalDefinitionLanguage.g:4810:1: rule__ParameterRule__NameAssignment_1 : ( ruleStringOrId ) ;
    public final void rule__ParameterRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4814:1: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4815:2: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:4815:2: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4816:3: ruleStringOrId
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
    // InternalDefinitionLanguage.g:4825:1: rule__FunctionNameRule__DefinitionAssignment : ( ( ruleStringOrId ) ) ;
    public final void rule__FunctionNameRule__DefinitionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4829:1: ( ( ( ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:4830:2: ( ( ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:4830:2: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:4831:3: ( ruleStringOrId )
            {
             before(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0()); 
            // InternalDefinitionLanguage.g:4832:3: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:4833:4: ruleStringOrId
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
    // InternalDefinitionLanguage.g:4844:1: rule__OrExpressionRule__SubExpressionsAssignment_0 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4848:1: ( ( ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:4849:2: ( ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:4849:2: ( ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:4850:3: ruleXorExpressionRule
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
    // InternalDefinitionLanguage.g:4859:1: rule__OrExpressionRule__SubExpressionsAssignment_1_1 : ( ruleXorExpressionRule ) ;
    public final void rule__OrExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4863:1: ( ( ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:4864:2: ( ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:4864:2: ( ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:4865:3: ruleXorExpressionRule
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
    // InternalDefinitionLanguage.g:4874:1: rule__XorExpressionRule__SubExpressionsAssignment_0 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4878:1: ( ( ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:4879:2: ( ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:4879:2: ( ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:4880:3: ruleAndExpressionRule
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
    // InternalDefinitionLanguage.g:4889:1: rule__XorExpressionRule__SubExpressionsAssignment_1_1 : ( ruleAndExpressionRule ) ;
    public final void rule__XorExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4893:1: ( ( ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:4894:2: ( ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:4894:2: ( ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:4895:3: ruleAndExpressionRule
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
    // InternalDefinitionLanguage.g:4904:1: rule__AndExpressionRule__SubExpressionsAssignment_0 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4908:1: ( ( ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:4909:2: ( ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:4909:2: ( ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:4910:3: ruleNotExpressionRule
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
    // InternalDefinitionLanguage.g:4919:1: rule__AndExpressionRule__SubExpressionsAssignment_1_1 : ( ruleNotExpressionRule ) ;
    public final void rule__AndExpressionRule__SubExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4923:1: ( ( ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:4924:2: ( ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:4924:2: ( ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:4925:3: ruleNotExpressionRule
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
    // InternalDefinitionLanguage.g:4934:1: rule__NotExpressionRule__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__NotExpressionRule__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4938:1: ( ( ( '!' ) ) )
            // InternalDefinitionLanguage.g:4939:2: ( ( '!' ) )
            {
            // InternalDefinitionLanguage.g:4939:2: ( ( '!' ) )
            // InternalDefinitionLanguage.g:4940:3: ( '!' )
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            // InternalDefinitionLanguage.g:4941:3: ( '!' )
            // InternalDefinitionLanguage.g:4942:4: '!'
            {
             before(grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0()); 
            match(input,73,FOLLOW_2); 
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
    // InternalDefinitionLanguage.g:4953:1: rule__NotExpressionRule__OperandAssignment_1 : ( ruleComparisonExpressionRule ) ;
    public final void rule__NotExpressionRule__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4957:1: ( ( ruleComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:4958:2: ( ruleComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:4958:2: ( ruleComparisonExpressionRule )
            // InternalDefinitionLanguage.g:4959:3: ruleComparisonExpressionRule
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
    // InternalDefinitionLanguage.g:4968:1: rule__ComparisonExpressionRule__LeftOperandAssignment_0 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4972:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:4973:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:4973:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:4974:3: ruleAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:4983:1: rule__ComparisonExpressionRule__ComparisonAssignment_1 : ( rulePartialComparisonExpressionRule ) ;
    public final void rule__ComparisonExpressionRule__ComparisonAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:4987:1: ( ( rulePartialComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:4988:2: ( rulePartialComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:4988:2: ( rulePartialComparisonExpressionRule )
            // InternalDefinitionLanguage.g:4989:3: rulePartialComparisonExpressionRule
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
    // InternalDefinitionLanguage.g:4998:1: rule__PartialComparisonExpressionRule__OperatorAssignment_0 : ( ruleComparisonOperatorRule ) ;
    public final void rule__PartialComparisonExpressionRule__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5002:1: ( ( ruleComparisonOperatorRule ) )
            // InternalDefinitionLanguage.g:5003:2: ( ruleComparisonOperatorRule )
            {
            // InternalDefinitionLanguage.g:5003:2: ( ruleComparisonOperatorRule )
            // InternalDefinitionLanguage.g:5004:3: ruleComparisonOperatorRule
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
    // InternalDefinitionLanguage.g:5013:1: rule__PartialComparisonExpressionRule__SubExpressionAssignment_1 : ( ruleAddOrSubtractExpressionRule ) ;
    public final void rule__PartialComparisonExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5017:1: ( ( ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:5018:2: ( ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:5018:2: ( ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:5019:3: ruleAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:5028:1: rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5032:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:5033:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:5033:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:5034:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDefinitionLanguage.g:5043:1: rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5047:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDefinitionLanguage.g:5048:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDefinitionLanguage.g:5048:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDefinitionLanguage.g:5049:3: ruleAddOrSubtractOperatorRule
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
    // InternalDefinitionLanguage.g:5058:1: rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1 : ( ruleMultiplyDivideModuloExpressionRule ) ;
    public final void rule__AddOrSubtractExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5062:1: ( ( ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:5063:2: ( ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:5063:2: ( ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:5064:3: ruleMultiplyDivideModuloExpressionRule
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
    // InternalDefinitionLanguage.g:5073:1: rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5077:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:5078:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:5078:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:5079:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:5088:1: rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0 : ( ruleMultiplyDivideModuloOperatorRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperatorsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5092:1: ( ( ruleMultiplyDivideModuloOperatorRule ) )
            // InternalDefinitionLanguage.g:5093:2: ( ruleMultiplyDivideModuloOperatorRule )
            {
            // InternalDefinitionLanguage.g:5093:2: ( ruleMultiplyDivideModuloOperatorRule )
            // InternalDefinitionLanguage.g:5094:3: ruleMultiplyDivideModuloOperatorRule
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
    // InternalDefinitionLanguage.g:5103:1: rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__MultiplyDivideModuloExpressionRule__OperandsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5107:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:5108:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:5108:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:5109:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:5118:1: rule__PowerOfExpressionRule__LeftOperandAssignment_0 : ( ruleUnaryAddOrSubtractExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__LeftOperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5122:1: ( ( ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:5123:2: ( ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:5123:2: ( ruleUnaryAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:5124:3: ruleUnaryAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:5133:1: rule__PowerOfExpressionRule__RightOperandAssignment_1_1 : ( rulePowerOfExpressionRule ) ;
    public final void rule__PowerOfExpressionRule__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5137:1: ( ( rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:5138:2: ( rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:5138:2: ( rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:5139:3: rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:5148:1: rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0 : ( ruleAddOrSubtractOperatorRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5152:1: ( ( ruleAddOrSubtractOperatorRule ) )
            // InternalDefinitionLanguage.g:5153:2: ( ruleAddOrSubtractOperatorRule )
            {
            // InternalDefinitionLanguage.g:5153:2: ( ruleAddOrSubtractOperatorRule )
            // InternalDefinitionLanguage.g:5154:3: ruleAddOrSubtractOperatorRule
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
    // InternalDefinitionLanguage.g:5163:1: rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1 : ( ruleLiteralOrReferenceRule ) ;
    public final void rule__UnaryAddOrSubtractExpressionRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5167:1: ( ( ruleLiteralOrReferenceRule ) )
            // InternalDefinitionLanguage.g:5168:2: ( ruleLiteralOrReferenceRule )
            {
            // InternalDefinitionLanguage.g:5168:2: ( ruleLiteralOrReferenceRule )
            // InternalDefinitionLanguage.g:5169:3: ruleLiteralOrReferenceRule
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
    // InternalDefinitionLanguage.g:5178:1: rule__ParanthesesRule__SubExpressionAssignment_1 : ( ruleExpressionRule ) ;
    public final void rule__ParanthesesRule__SubExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5182:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:5183:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:5183:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:5184:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:5193:1: rule__CallRule__FunctionAssignment_0 : ( ruleFunctionNameRule ) ;
    public final void rule__CallRule__FunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5197:1: ( ( ruleFunctionNameRule ) )
            // InternalDefinitionLanguage.g:5198:2: ( ruleFunctionNameRule )
            {
            // InternalDefinitionLanguage.g:5198:2: ( ruleFunctionNameRule )
            // InternalDefinitionLanguage.g:5199:3: ruleFunctionNameRule
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
    // InternalDefinitionLanguage.g:5208:1: rule__CallRule__ParametersAssignment_2_0 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5212:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:5213:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:5213:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:5214:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:5223:1: rule__CallRule__ParametersAssignment_2_1_1 : ( ruleExpressionRule ) ;
    public final void rule__CallRule__ParametersAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5227:1: ( ( ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:5228:2: ( ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:5228:2: ( ruleExpressionRule )
            // InternalDefinitionLanguage.g:5229:3: ruleExpressionRule
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
    // InternalDefinitionLanguage.g:5238:1: rule__DoubleLiteralRule__LiteralAssignment_0 : ( ruleDOUBLE ) ;
    public final void rule__DoubleLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5242:1: ( ( ruleDOUBLE ) )
            // InternalDefinitionLanguage.g:5243:2: ( ruleDOUBLE )
            {
            // InternalDefinitionLanguage.g:5243:2: ( ruleDOUBLE )
            // InternalDefinitionLanguage.g:5244:3: ruleDOUBLE
            {
             before(grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLEParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLEParserRuleCall_0_0()); 

            }


            }

        }
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
    // InternalDefinitionLanguage.g:5253:1: rule__DoubleLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__DoubleLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5257:1: ( ( ruleFactorRule ) )
            // InternalDefinitionLanguage.g:5258:2: ( ruleFactorRule )
            {
            // InternalDefinitionLanguage.g:5258:2: ( ruleFactorRule )
            // InternalDefinitionLanguage.g:5259:3: ruleFactorRule
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
    // InternalDefinitionLanguage.g:5268:1: rule__IntegerLiteralRule__LiteralAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerLiteralRule__LiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5272:1: ( ( RULE_INT ) )
            // InternalDefinitionLanguage.g:5273:2: ( RULE_INT )
            {
            // InternalDefinitionLanguage.g:5273:2: ( RULE_INT )
            // InternalDefinitionLanguage.g:5274:3: RULE_INT
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
    // InternalDefinitionLanguage.g:5283:1: rule__IntegerLiteralRule__FactorAssignment_1 : ( ruleFactorRule ) ;
    public final void rule__IntegerLiteralRule__FactorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5287:1: ( ( ruleFactorRule ) )
            // InternalDefinitionLanguage.g:5288:2: ( ruleFactorRule )
            {
            // InternalDefinitionLanguage.g:5288:2: ( ruleFactorRule )
            // InternalDefinitionLanguage.g:5289:3: ruleFactorRule
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
    // InternalDefinitionLanguage.g:5298:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5302:1: ( ( RULE_STRING ) )
            // InternalDefinitionLanguage.g:5303:2: ( RULE_STRING )
            {
            // InternalDefinitionLanguage.g:5303:2: ( RULE_STRING )
            // InternalDefinitionLanguage.g:5304:3: RULE_STRING
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
    // InternalDefinitionLanguage.g:5313:1: rule__BooleanLiteralRule__ValueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDefinitionLanguage.g:5317:1: ( ( ( 'true' ) ) )
            // InternalDefinitionLanguage.g:5318:2: ( ( 'true' ) )
            {
            // InternalDefinitionLanguage.g:5318:2: ( ( 'true' ) )
            // InternalDefinitionLanguage.g:5319:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            // InternalDefinitionLanguage.g:5320:3: ( 'true' )
            // InternalDefinitionLanguage.g:5321:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0()); 
            match(input,74,FOLLOW_2); 
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x4000100000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0001400000000030L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0001000000000032L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x3FD8000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x3FD8000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x80000000001810F0L,0x0000000000000640L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000000000007E000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x80000000001810F0L,0x0000000000000641L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00000FFFFF000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x00000000000010C0L,0x0000000000000400L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000040L});

}
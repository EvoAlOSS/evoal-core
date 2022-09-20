package de.evoal.languages.model.generator.dsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.evoal.languages.model.generator.dsl.services.GeneratorDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGeneratorDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_QUOTED_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'use'", "';'", "'function'", "'using'", "'generator'", "'for'", "'in'", "'loop'", "'end'", "'['", "'to'", "']'", "'functions'", "','", "'generators'", "'write'", "'with'", "'samples'", "'from'", "'applying'", "'on'", "'definition'", "'{'", "'}'", "':='", "'data'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'('", "')'", "'call'", "'value'", "'true'", "'false'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'"
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
    public static final int RULE_ID=5;
    public static final int RULE_QUOTED_ID=7;
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
    public static final int RULE_STRING=4;
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


        public InternalGeneratorDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGeneratorDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGeneratorDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGeneratorDSL.g"; }



     	private GeneratorDSLGrammarAccess grammarAccess;

        public InternalGeneratorDSLParser(TokenStream input, GeneratorDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ConfigurationRule";
       	}

       	@Override
       	protected GeneratorDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleConfigurationRule"
    // InternalGeneratorDSL.g:65:1: entryRuleConfigurationRule returns [EObject current=null] : iv_ruleConfigurationRule= ruleConfigurationRule EOF ;
    public final EObject entryRuleConfigurationRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigurationRule = null;


        try {
            // InternalGeneratorDSL.g:65:58: (iv_ruleConfigurationRule= ruleConfigurationRule EOF )
            // InternalGeneratorDSL.g:66:2: iv_ruleConfigurationRule= ruleConfigurationRule EOF
            {
             newCompositeNode(grammarAccess.getConfigurationRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfigurationRule=ruleConfigurationRule();

            state._fsp--;

             current =iv_ruleConfigurationRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfigurationRule"


    // $ANTLR start "ruleConfigurationRule"
    // InternalGeneratorDSL.g:72:1: ruleConfigurationRule returns [EObject current=null] : ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_generators_1_0= ruleGeneratorDefinitionRule ) )* ( (lv_functions_2_0= ruleParametrizedFunctionDefinitionRule ) )* ( (lv_statements_3_0= ruleStatementRule ) )* ) ;
    public final EObject ruleConfigurationRule() throws RecognitionException {
        EObject current = null;

        EObject lv_uses_0_0 = null;

        EObject lv_generators_1_0 = null;

        EObject lv_functions_2_0 = null;

        EObject lv_statements_3_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:78:2: ( ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_generators_1_0= ruleGeneratorDefinitionRule ) )* ( (lv_functions_2_0= ruleParametrizedFunctionDefinitionRule ) )* ( (lv_statements_3_0= ruleStatementRule ) )* ) )
            // InternalGeneratorDSL.g:79:2: ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_generators_1_0= ruleGeneratorDefinitionRule ) )* ( (lv_functions_2_0= ruleParametrizedFunctionDefinitionRule ) )* ( (lv_statements_3_0= ruleStatementRule ) )* )
            {
            // InternalGeneratorDSL.g:79:2: ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_generators_1_0= ruleGeneratorDefinitionRule ) )* ( (lv_functions_2_0= ruleParametrizedFunctionDefinitionRule ) )* ( (lv_statements_3_0= ruleStatementRule ) )* )
            // InternalGeneratorDSL.g:80:3: ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_generators_1_0= ruleGeneratorDefinitionRule ) )* ( (lv_functions_2_0= ruleParametrizedFunctionDefinitionRule ) )* ( (lv_statements_3_0= ruleStatementRule ) )*
            {
            // InternalGeneratorDSL.g:80:3: ( (lv_uses_0_0= ruleUseRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalGeneratorDSL.g:81:4: (lv_uses_0_0= ruleUseRule )
            	    {
            	    // InternalGeneratorDSL.g:81:4: (lv_uses_0_0= ruleUseRule )
            	    // InternalGeneratorDSL.g:82:5: lv_uses_0_0= ruleUseRule
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationRuleAccess().getUsesUseRuleParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_uses_0_0=ruleUseRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"uses",
            	    						lv_uses_0_0,
            	    						"de.evoal.languages.model.generator.dsl.GeneratorDSL.UseRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalGeneratorDSL.g:99:3: ( (lv_generators_1_0= ruleGeneratorDefinitionRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGeneratorDSL.g:100:4: (lv_generators_1_0= ruleGeneratorDefinitionRule )
            	    {
            	    // InternalGeneratorDSL.g:100:4: (lv_generators_1_0= ruleGeneratorDefinitionRule )
            	    // InternalGeneratorDSL.g:101:5: lv_generators_1_0= ruleGeneratorDefinitionRule
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationRuleAccess().getGeneratorsGeneratorDefinitionRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_generators_1_0=ruleGeneratorDefinitionRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"generators",
            	    						lv_generators_1_0,
            	    						"de.evoal.languages.model.generator.dsl.GeneratorDSL.GeneratorDefinitionRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalGeneratorDSL.g:118:3: ( (lv_functions_2_0= ruleParametrizedFunctionDefinitionRule ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalGeneratorDSL.g:119:4: (lv_functions_2_0= ruleParametrizedFunctionDefinitionRule )
            	    {
            	    // InternalGeneratorDSL.g:119:4: (lv_functions_2_0= ruleParametrizedFunctionDefinitionRule )
            	    // InternalGeneratorDSL.g:120:5: lv_functions_2_0= ruleParametrizedFunctionDefinitionRule
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationRuleAccess().getFunctionsParametrizedFunctionDefinitionRuleParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_functions_2_0=ruleParametrizedFunctionDefinitionRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"functions",
            	    						lv_functions_2_0,
            	    						"de.evoal.languages.model.generator.dsl.GeneratorDSL.ParametrizedFunctionDefinitionRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalGeneratorDSL.g:137:3: ( (lv_statements_3_0= ruleStatementRule ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17||LA4_0==27) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalGeneratorDSL.g:138:4: (lv_statements_3_0= ruleStatementRule )
            	    {
            	    // InternalGeneratorDSL.g:138:4: (lv_statements_3_0= ruleStatementRule )
            	    // InternalGeneratorDSL.g:139:5: lv_statements_3_0= ruleStatementRule
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationRuleAccess().getStatementsStatementRuleParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_statements_3_0=ruleStatementRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_3_0,
            	    						"de.evoal.languages.model.generator.dsl.GeneratorDSL.StatementRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfigurationRule"


    // $ANTLR start "entryRuleUseRule"
    // InternalGeneratorDSL.g:160:1: entryRuleUseRule returns [EObject current=null] : iv_ruleUseRule= ruleUseRule EOF ;
    public final EObject entryRuleUseRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseRule = null;


        try {
            // InternalGeneratorDSL.g:160:48: (iv_ruleUseRule= ruleUseRule EOF )
            // InternalGeneratorDSL.g:161:2: iv_ruleUseRule= ruleUseRule EOF
            {
             newCompositeNode(grammarAccess.getUseRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUseRule=ruleUseRule();

            state._fsp--;

             current =iv_ruleUseRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUseRule"


    // $ANTLR start "ruleUseRule"
    // InternalGeneratorDSL.g:167:1: ruleUseRule returns [EObject current=null] : (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) ;
    public final EObject ruleUseRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:173:2: ( (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) )
            // InternalGeneratorDSL.g:174:2: (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            {
            // InternalGeneratorDSL.g:174:2: (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            // InternalGeneratorDSL.g:175:3: otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getUseRuleAccess().getUseKeyword_0());
            		
            // InternalGeneratorDSL.g:179:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:180:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:180:4: (lv_importURI_1_0= RULE_STRING )
            // InternalGeneratorDSL.g:181:5: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_importURI_1_0, grammarAccess.getUseRuleAccess().getImportURISTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUseRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getUseRuleAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUseRule"


    // $ANTLR start "entryRuleParametrizedFunctionDefinitionRule"
    // InternalGeneratorDSL.g:205:1: entryRuleParametrizedFunctionDefinitionRule returns [EObject current=null] : iv_ruleParametrizedFunctionDefinitionRule= ruleParametrizedFunctionDefinitionRule EOF ;
    public final EObject entryRuleParametrizedFunctionDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParametrizedFunctionDefinitionRule = null;


        try {
            // InternalGeneratorDSL.g:205:75: (iv_ruleParametrizedFunctionDefinitionRule= ruleParametrizedFunctionDefinitionRule EOF )
            // InternalGeneratorDSL.g:206:2: iv_ruleParametrizedFunctionDefinitionRule= ruleParametrizedFunctionDefinitionRule EOF
            {
             newCompositeNode(grammarAccess.getParametrizedFunctionDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParametrizedFunctionDefinitionRule=ruleParametrizedFunctionDefinitionRule();

            state._fsp--;

             current =iv_ruleParametrizedFunctionDefinitionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParametrizedFunctionDefinitionRule"


    // $ANTLR start "ruleParametrizedFunctionDefinitionRule"
    // InternalGeneratorDSL.g:212:1: ruleParametrizedFunctionDefinitionRule returns [EObject current=null] : (otherlv_0= 'function' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_definition_3_0= ruleInstanceRule ) ) otherlv_4= ';' ) ;
    public final EObject ruleParametrizedFunctionDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_definition_3_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:218:2: ( (otherlv_0= 'function' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_definition_3_0= ruleInstanceRule ) ) otherlv_4= ';' ) )
            // InternalGeneratorDSL.g:219:2: (otherlv_0= 'function' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_definition_3_0= ruleInstanceRule ) ) otherlv_4= ';' )
            {
            // InternalGeneratorDSL.g:219:2: (otherlv_0= 'function' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_definition_3_0= ruleInstanceRule ) ) otherlv_4= ';' )
            // InternalGeneratorDSL.g:220:3: otherlv_0= 'function' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_definition_3_0= ruleInstanceRule ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getParametrizedFunctionDefinitionRuleAccess().getFunctionKeyword_0());
            		
            // InternalGeneratorDSL.g:224:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalGeneratorDSL.g:225:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalGeneratorDSL.g:225:4: (lv_name_1_0= ruleStringOrId )
            // InternalGeneratorDSL.g:226:5: lv_name_1_0= ruleStringOrId
            {

            					newCompositeNode(grammarAccess.getParametrizedFunctionDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParametrizedFunctionDefinitionRuleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.StringOrId");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getParametrizedFunctionDefinitionRuleAccess().getUsingKeyword_2());
            		
            // InternalGeneratorDSL.g:247:3: ( (lv_definition_3_0= ruleInstanceRule ) )
            // InternalGeneratorDSL.g:248:4: (lv_definition_3_0= ruleInstanceRule )
            {
            // InternalGeneratorDSL.g:248:4: (lv_definition_3_0= ruleInstanceRule )
            // InternalGeneratorDSL.g:249:5: lv_definition_3_0= ruleInstanceRule
            {

            					newCompositeNode(grammarAccess.getParametrizedFunctionDefinitionRuleAccess().getDefinitionInstanceRuleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_definition_3_0=ruleInstanceRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParametrizedFunctionDefinitionRuleRule());
            					}
            					set(
            						current,
            						"definition",
            						lv_definition_3_0,
            						"de.evoal.languages.model.instance.dsl.InstanceLanguage.InstanceRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getParametrizedFunctionDefinitionRuleAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParametrizedFunctionDefinitionRule"


    // $ANTLR start "entryRuleGeneratorDefinitionRule"
    // InternalGeneratorDSL.g:274:1: entryRuleGeneratorDefinitionRule returns [EObject current=null] : iv_ruleGeneratorDefinitionRule= ruleGeneratorDefinitionRule EOF ;
    public final EObject entryRuleGeneratorDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorDefinitionRule = null;


        try {
            // InternalGeneratorDSL.g:274:64: (iv_ruleGeneratorDefinitionRule= ruleGeneratorDefinitionRule EOF )
            // InternalGeneratorDSL.g:275:2: iv_ruleGeneratorDefinitionRule= ruleGeneratorDefinitionRule EOF
            {
             newCompositeNode(grammarAccess.getGeneratorDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneratorDefinitionRule=ruleGeneratorDefinitionRule();

            state._fsp--;

             current =iv_ruleGeneratorDefinitionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratorDefinitionRule"


    // $ANTLR start "ruleGeneratorDefinitionRule"
    // InternalGeneratorDSL.g:281:1: ruleGeneratorDefinitionRule returns [EObject current=null] : (otherlv_0= 'generator' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_definition_3_0= ruleInstanceRule ) ) otherlv_4= ';' ) ;
    public final EObject ruleGeneratorDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_definition_3_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:287:2: ( (otherlv_0= 'generator' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_definition_3_0= ruleInstanceRule ) ) otherlv_4= ';' ) )
            // InternalGeneratorDSL.g:288:2: (otherlv_0= 'generator' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_definition_3_0= ruleInstanceRule ) ) otherlv_4= ';' )
            {
            // InternalGeneratorDSL.g:288:2: (otherlv_0= 'generator' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_definition_3_0= ruleInstanceRule ) ) otherlv_4= ';' )
            // InternalGeneratorDSL.g:289:3: otherlv_0= 'generator' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_definition_3_0= ruleInstanceRule ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getGeneratorDefinitionRuleAccess().getGeneratorKeyword_0());
            		
            // InternalGeneratorDSL.g:293:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalGeneratorDSL.g:294:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalGeneratorDSL.g:294:4: (lv_name_1_0= ruleStringOrId )
            // InternalGeneratorDSL.g:295:5: lv_name_1_0= ruleStringOrId
            {

            					newCompositeNode(grammarAccess.getGeneratorDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGeneratorDefinitionRuleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.StringOrId");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getGeneratorDefinitionRuleAccess().getUsingKeyword_2());
            		
            // InternalGeneratorDSL.g:316:3: ( (lv_definition_3_0= ruleInstanceRule ) )
            // InternalGeneratorDSL.g:317:4: (lv_definition_3_0= ruleInstanceRule )
            {
            // InternalGeneratorDSL.g:317:4: (lv_definition_3_0= ruleInstanceRule )
            // InternalGeneratorDSL.g:318:5: lv_definition_3_0= ruleInstanceRule
            {

            					newCompositeNode(grammarAccess.getGeneratorDefinitionRuleAccess().getDefinitionInstanceRuleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_definition_3_0=ruleInstanceRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGeneratorDefinitionRuleRule());
            					}
            					set(
            						current,
            						"definition",
            						lv_definition_3_0,
            						"de.evoal.languages.model.instance.dsl.InstanceLanguage.InstanceRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGeneratorDefinitionRuleAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneratorDefinitionRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalGeneratorDSL.g:343:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalGeneratorDSL.g:343:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalGeneratorDSL.g:344:2: iv_ruleStatementRule= ruleStatementRule EOF
            {
             newCompositeNode(grammarAccess.getStatementRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatementRule=ruleStatementRule();

            state._fsp--;

             current =iv_ruleStatementRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatementRule"


    // $ANTLR start "ruleStatementRule"
    // InternalGeneratorDSL.g:350:1: ruleStatementRule returns [EObject current=null] : (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatementRule_0 = null;

        EObject this_ApplyStatementRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:356:2: ( (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule ) )
            // InternalGeneratorDSL.g:357:2: (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule )
            {
            // InternalGeneratorDSL.g:357:2: (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            else if ( (LA5_0==27) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalGeneratorDSL.g:358:3: this_ForStatementRule_0= ruleForStatementRule
                    {

                    			newCompositeNode(grammarAccess.getStatementRuleAccess().getForStatementRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForStatementRule_0=ruleForStatementRule();

                    state._fsp--;


                    			current = this_ForStatementRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:367:3: this_ApplyStatementRule_1= ruleApplyStatementRule
                    {

                    			newCompositeNode(grammarAccess.getStatementRuleAccess().getApplyStatementRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ApplyStatementRule_1=ruleApplyStatementRule();

                    state._fsp--;


                    			current = this_ApplyStatementRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementRule"


    // $ANTLR start "entryRuleForStatementRule"
    // InternalGeneratorDSL.g:379:1: entryRuleForStatementRule returns [EObject current=null] : iv_ruleForStatementRule= ruleForStatementRule EOF ;
    public final EObject entryRuleForStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatementRule = null;


        try {
            // InternalGeneratorDSL.g:379:57: (iv_ruleForStatementRule= ruleForStatementRule EOF )
            // InternalGeneratorDSL.g:380:2: iv_ruleForStatementRule= ruleForStatementRule EOF
            {
             newCompositeNode(grammarAccess.getForStatementRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForStatementRule=ruleForStatementRule();

            state._fsp--;

             current =iv_ruleForStatementRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForStatementRule"


    // $ANTLR start "ruleForStatementRule"
    // InternalGeneratorDSL.g:386:1: ruleForStatementRule returns [EObject current=null] : (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' ) ;
    public final EObject ruleForStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_range_3_0 = null;

        EObject lv_statements_5_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:392:2: ( (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' ) )
            // InternalGeneratorDSL.g:393:2: (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' )
            {
            // InternalGeneratorDSL.g:393:2: (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' )
            // InternalGeneratorDSL.g:394:3: otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementRuleAccess().getForKeyword_0());
            		
            // InternalGeneratorDSL.g:398:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGeneratorDSL.g:399:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGeneratorDSL.g:399:4: (lv_name_1_0= RULE_ID )
            // InternalGeneratorDSL.g:400:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(lv_name_1_0, grammarAccess.getForStatementRuleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getForStatementRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getForStatementRuleAccess().getInKeyword_2());
            		
            // InternalGeneratorDSL.g:420:3: ( (lv_range_3_0= ruleRangeRule ) )
            // InternalGeneratorDSL.g:421:4: (lv_range_3_0= ruleRangeRule )
            {
            // InternalGeneratorDSL.g:421:4: (lv_range_3_0= ruleRangeRule )
            // InternalGeneratorDSL.g:422:5: lv_range_3_0= ruleRangeRule
            {

            					newCompositeNode(grammarAccess.getForStatementRuleAccess().getRangeRangeRuleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_14);
            lv_range_3_0=ruleRangeRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForStatementRuleRule());
            					}
            					set(
            						current,
            						"range",
            						lv_range_3_0,
            						"de.evoal.languages.model.generator.dsl.GeneratorDSL.RangeRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getForStatementRuleAccess().getLoopKeyword_4());
            		
            // InternalGeneratorDSL.g:443:3: ( (lv_statements_5_0= ruleStatementRule ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17||LA6_0==27) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalGeneratorDSL.g:444:4: (lv_statements_5_0= ruleStatementRule )
            	    {
            	    // InternalGeneratorDSL.g:444:4: (lv_statements_5_0= ruleStatementRule )
            	    // InternalGeneratorDSL.g:445:5: lv_statements_5_0= ruleStatementRule
            	    {

            	    					newCompositeNode(grammarAccess.getForStatementRuleAccess().getStatementsStatementRuleParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_statements_5_0=ruleStatementRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getForStatementRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_5_0,
            	    						"de.evoal.languages.model.generator.dsl.GeneratorDSL.StatementRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_6=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getForStatementRuleAccess().getEndKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForStatementRule"


    // $ANTLR start "entryRuleRangeRule"
    // InternalGeneratorDSL.g:470:1: entryRuleRangeRule returns [EObject current=null] : iv_ruleRangeRule= ruleRangeRule EOF ;
    public final EObject entryRuleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeRule = null;


        try {
            // InternalGeneratorDSL.g:470:50: (iv_ruleRangeRule= ruleRangeRule EOF )
            // InternalGeneratorDSL.g:471:2: iv_ruleRangeRule= ruleRangeRule EOF
            {
             newCompositeNode(grammarAccess.getRangeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRangeRule=ruleRangeRule();

            state._fsp--;

             current =iv_ruleRangeRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeRule"


    // $ANTLR start "ruleRangeRule"
    // InternalGeneratorDSL.g:477:1: ruleRangeRule returns [EObject current=null] : (this_FunctionsRule_0= ruleFunctionsRule | this_GeneratorsRule_1= ruleGeneratorsRule | this_CounterRangeRule_2= ruleCounterRangeRule ) ;
    public final EObject ruleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionsRule_0 = null;

        EObject this_GeneratorsRule_1 = null;

        EObject this_CounterRangeRule_2 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:483:2: ( (this_FunctionsRule_0= ruleFunctionsRule | this_GeneratorsRule_1= ruleGeneratorsRule | this_CounterRangeRule_2= ruleCounterRangeRule ) )
            // InternalGeneratorDSL.g:484:2: (this_FunctionsRule_0= ruleFunctionsRule | this_GeneratorsRule_1= ruleGeneratorsRule | this_CounterRangeRule_2= ruleCounterRangeRule )
            {
            // InternalGeneratorDSL.g:484:2: (this_FunctionsRule_0= ruleFunctionsRule | this_GeneratorsRule_1= ruleGeneratorsRule | this_CounterRangeRule_2= ruleCounterRangeRule )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt7=1;
                }
                break;
            case 26:
                {
                alt7=2;
                }
                break;
            case 21:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalGeneratorDSL.g:485:3: this_FunctionsRule_0= ruleFunctionsRule
                    {

                    			newCompositeNode(grammarAccess.getRangeRuleAccess().getFunctionsRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FunctionsRule_0=ruleFunctionsRule();

                    state._fsp--;


                    			current = this_FunctionsRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:494:3: this_GeneratorsRule_1= ruleGeneratorsRule
                    {

                    			newCompositeNode(grammarAccess.getRangeRuleAccess().getGeneratorsRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_GeneratorsRule_1=ruleGeneratorsRule();

                    state._fsp--;


                    			current = this_GeneratorsRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:503:3: this_CounterRangeRule_2= ruleCounterRangeRule
                    {

                    			newCompositeNode(grammarAccess.getRangeRuleAccess().getCounterRangeRuleParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_CounterRangeRule_2=ruleCounterRangeRule();

                    state._fsp--;


                    			current = this_CounterRangeRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeRule"


    // $ANTLR start "entryRuleCounterRangeRule"
    // InternalGeneratorDSL.g:515:1: entryRuleCounterRangeRule returns [EObject current=null] : iv_ruleCounterRangeRule= ruleCounterRangeRule EOF ;
    public final EObject entryRuleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCounterRangeRule = null;


        try {
            // InternalGeneratorDSL.g:515:57: (iv_ruleCounterRangeRule= ruleCounterRangeRule EOF )
            // InternalGeneratorDSL.g:516:2: iv_ruleCounterRangeRule= ruleCounterRangeRule EOF
            {
             newCompositeNode(grammarAccess.getCounterRangeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCounterRangeRule=ruleCounterRangeRule();

            state._fsp--;

             current =iv_ruleCounterRangeRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCounterRangeRule"


    // $ANTLR start "ruleCounterRangeRule"
    // InternalGeneratorDSL.g:522:1: ruleCounterRangeRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' ) ;
    public final EObject ruleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_start_1_0=null;
        Token otherlv_2=null;
        Token lv_end_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:528:2: ( (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' ) )
            // InternalGeneratorDSL.g:529:2: (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' )
            {
            // InternalGeneratorDSL.g:529:2: (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' )
            // InternalGeneratorDSL.g:530:3: otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getCounterRangeRuleAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalGeneratorDSL.g:534:3: ( (lv_start_1_0= RULE_INT ) )
            // InternalGeneratorDSL.g:535:4: (lv_start_1_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:535:4: (lv_start_1_0= RULE_INT )
            // InternalGeneratorDSL.g:536:5: lv_start_1_0= RULE_INT
            {
            lv_start_1_0=(Token)match(input,RULE_INT,FOLLOW_17); 

            					newLeafNode(lv_start_1_0, grammarAccess.getCounterRangeRuleAccess().getStartINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCounterRangeRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"start",
            						lv_start_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getCounterRangeRuleAccess().getToKeyword_2());
            		
            // InternalGeneratorDSL.g:556:3: ( (lv_end_3_0= RULE_INT ) )
            // InternalGeneratorDSL.g:557:4: (lv_end_3_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:557:4: (lv_end_3_0= RULE_INT )
            // InternalGeneratorDSL.g:558:5: lv_end_3_0= RULE_INT
            {
            lv_end_3_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            					newLeafNode(lv_end_3_0, grammarAccess.getCounterRangeRuleAccess().getEndINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCounterRangeRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"end",
            						lv_end_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getCounterRangeRuleAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCounterRangeRule"


    // $ANTLR start "entryRuleFunctionsRule"
    // InternalGeneratorDSL.g:582:1: entryRuleFunctionsRule returns [EObject current=null] : iv_ruleFunctionsRule= ruleFunctionsRule EOF ;
    public final EObject entryRuleFunctionsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionsRule = null;


        try {
            // InternalGeneratorDSL.g:582:54: (iv_ruleFunctionsRule= ruleFunctionsRule EOF )
            // InternalGeneratorDSL.g:583:2: iv_ruleFunctionsRule= ruleFunctionsRule EOF
            {
             newCompositeNode(grammarAccess.getFunctionsRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionsRule=ruleFunctionsRule();

            state._fsp--;

             current =iv_ruleFunctionsRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionsRule"


    // $ANTLR start "ruleFunctionsRule"
    // InternalGeneratorDSL.g:589:1: ruleFunctionsRule returns [EObject current=null] : ( () otherlv_1= 'functions' ( (lv_functionReferences_2_0= ruleFunctionReferencesRule ) )? ) ;
    public final EObject ruleFunctionsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_functionReferences_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:595:2: ( ( () otherlv_1= 'functions' ( (lv_functionReferences_2_0= ruleFunctionReferencesRule ) )? ) )
            // InternalGeneratorDSL.g:596:2: ( () otherlv_1= 'functions' ( (lv_functionReferences_2_0= ruleFunctionReferencesRule ) )? )
            {
            // InternalGeneratorDSL.g:596:2: ( () otherlv_1= 'functions' ( (lv_functionReferences_2_0= ruleFunctionReferencesRule ) )? )
            // InternalGeneratorDSL.g:597:3: () otherlv_1= 'functions' ( (lv_functionReferences_2_0= ruleFunctionReferencesRule ) )?
            {
            // InternalGeneratorDSL.g:597:3: ()
            // InternalGeneratorDSL.g:598:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFunctionsRuleAccess().getFunctionsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getFunctionsRuleAccess().getFunctionsKeyword_1());
            		
            // InternalGeneratorDSL.g:608:3: ( (lv_functionReferences_2_0= ruleFunctionReferencesRule ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalGeneratorDSL.g:609:4: (lv_functionReferences_2_0= ruleFunctionReferencesRule )
                    {
                    // InternalGeneratorDSL.g:609:4: (lv_functionReferences_2_0= ruleFunctionReferencesRule )
                    // InternalGeneratorDSL.g:610:5: lv_functionReferences_2_0= ruleFunctionReferencesRule
                    {

                    					newCompositeNode(grammarAccess.getFunctionsRuleAccess().getFunctionReferencesFunctionReferencesRuleParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_functionReferences_2_0=ruleFunctionReferencesRule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFunctionsRuleRule());
                    					}
                    					set(
                    						current,
                    						"functionReferences",
                    						lv_functionReferences_2_0,
                    						"de.evoal.languages.model.generator.dsl.GeneratorDSL.FunctionReferencesRule");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionsRule"


    // $ANTLR start "entryRuleFunctionReferencesRule"
    // InternalGeneratorDSL.g:631:1: entryRuleFunctionReferencesRule returns [EObject current=null] : iv_ruleFunctionReferencesRule= ruleFunctionReferencesRule EOF ;
    public final EObject entryRuleFunctionReferencesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionReferencesRule = null;


        try {
            // InternalGeneratorDSL.g:631:63: (iv_ruleFunctionReferencesRule= ruleFunctionReferencesRule EOF )
            // InternalGeneratorDSL.g:632:2: iv_ruleFunctionReferencesRule= ruleFunctionReferencesRule EOF
            {
             newCompositeNode(grammarAccess.getFunctionReferencesRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionReferencesRule=ruleFunctionReferencesRule();

            state._fsp--;

             current =iv_ruleFunctionReferencesRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionReferencesRule"


    // $ANTLR start "ruleFunctionReferencesRule"
    // InternalGeneratorDSL.g:638:1: ruleFunctionReferencesRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_functions_1_0= ruleFunctionDefReferenceRule ) ) (otherlv_2= ',' ( (lv_functions_3_0= ruleFunctionDefReferenceRule ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleFunctionReferencesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_functions_1_0 = null;

        EObject lv_functions_3_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:644:2: ( (otherlv_0= '[' ( (lv_functions_1_0= ruleFunctionDefReferenceRule ) ) (otherlv_2= ',' ( (lv_functions_3_0= ruleFunctionDefReferenceRule ) ) )* otherlv_4= ']' ) )
            // InternalGeneratorDSL.g:645:2: (otherlv_0= '[' ( (lv_functions_1_0= ruleFunctionDefReferenceRule ) ) (otherlv_2= ',' ( (lv_functions_3_0= ruleFunctionDefReferenceRule ) ) )* otherlv_4= ']' )
            {
            // InternalGeneratorDSL.g:645:2: (otherlv_0= '[' ( (lv_functions_1_0= ruleFunctionDefReferenceRule ) ) (otherlv_2= ',' ( (lv_functions_3_0= ruleFunctionDefReferenceRule ) ) )* otherlv_4= ']' )
            // InternalGeneratorDSL.g:646:3: otherlv_0= '[' ( (lv_functions_1_0= ruleFunctionDefReferenceRule ) ) (otherlv_2= ',' ( (lv_functions_3_0= ruleFunctionDefReferenceRule ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionReferencesRuleAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalGeneratorDSL.g:650:3: ( (lv_functions_1_0= ruleFunctionDefReferenceRule ) )
            // InternalGeneratorDSL.g:651:4: (lv_functions_1_0= ruleFunctionDefReferenceRule )
            {
            // InternalGeneratorDSL.g:651:4: (lv_functions_1_0= ruleFunctionDefReferenceRule )
            // InternalGeneratorDSL.g:652:5: lv_functions_1_0= ruleFunctionDefReferenceRule
            {

            					newCompositeNode(grammarAccess.getFunctionReferencesRuleAccess().getFunctionsFunctionDefReferenceRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_21);
            lv_functions_1_0=ruleFunctionDefReferenceRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionReferencesRuleRule());
            					}
            					add(
            						current,
            						"functions",
            						lv_functions_1_0,
            						"de.evoal.languages.model.generator.dsl.GeneratorDSL.FunctionDefReferenceRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:669:3: (otherlv_2= ',' ( (lv_functions_3_0= ruleFunctionDefReferenceRule ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalGeneratorDSL.g:670:4: otherlv_2= ',' ( (lv_functions_3_0= ruleFunctionDefReferenceRule ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_20); 

            	    				newLeafNode(otherlv_2, grammarAccess.getFunctionReferencesRuleAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalGeneratorDSL.g:674:4: ( (lv_functions_3_0= ruleFunctionDefReferenceRule ) )
            	    // InternalGeneratorDSL.g:675:5: (lv_functions_3_0= ruleFunctionDefReferenceRule )
            	    {
            	    // InternalGeneratorDSL.g:675:5: (lv_functions_3_0= ruleFunctionDefReferenceRule )
            	    // InternalGeneratorDSL.g:676:6: lv_functions_3_0= ruleFunctionDefReferenceRule
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionReferencesRuleAccess().getFunctionsFunctionDefReferenceRuleParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_functions_3_0=ruleFunctionDefReferenceRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionReferencesRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"functions",
            	    							lv_functions_3_0,
            	    							"de.evoal.languages.model.generator.dsl.GeneratorDSL.FunctionDefReferenceRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getFunctionReferencesRuleAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionReferencesRule"


    // $ANTLR start "entryRuleGeneratorsRule"
    // InternalGeneratorDSL.g:702:1: entryRuleGeneratorsRule returns [EObject current=null] : iv_ruleGeneratorsRule= ruleGeneratorsRule EOF ;
    public final EObject entryRuleGeneratorsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorsRule = null;


        try {
            // InternalGeneratorDSL.g:702:55: (iv_ruleGeneratorsRule= ruleGeneratorsRule EOF )
            // InternalGeneratorDSL.g:703:2: iv_ruleGeneratorsRule= ruleGeneratorsRule EOF
            {
             newCompositeNode(grammarAccess.getGeneratorsRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneratorsRule=ruleGeneratorsRule();

            state._fsp--;

             current =iv_ruleGeneratorsRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratorsRule"


    // $ANTLR start "ruleGeneratorsRule"
    // InternalGeneratorDSL.g:709:1: ruleGeneratorsRule returns [EObject current=null] : ( () otherlv_1= 'generators' ( (lv_generatorReferences_2_0= ruleGeneratorReferencesRule ) )? ) ;
    public final EObject ruleGeneratorsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_generatorReferences_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:715:2: ( ( () otherlv_1= 'generators' ( (lv_generatorReferences_2_0= ruleGeneratorReferencesRule ) )? ) )
            // InternalGeneratorDSL.g:716:2: ( () otherlv_1= 'generators' ( (lv_generatorReferences_2_0= ruleGeneratorReferencesRule ) )? )
            {
            // InternalGeneratorDSL.g:716:2: ( () otherlv_1= 'generators' ( (lv_generatorReferences_2_0= ruleGeneratorReferencesRule ) )? )
            // InternalGeneratorDSL.g:717:3: () otherlv_1= 'generators' ( (lv_generatorReferences_2_0= ruleGeneratorReferencesRule ) )?
            {
            // InternalGeneratorDSL.g:717:3: ()
            // InternalGeneratorDSL.g:718:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGeneratorsRuleAccess().getGeneratorsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,26,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getGeneratorsRuleAccess().getGeneratorsKeyword_1());
            		
            // InternalGeneratorDSL.g:728:3: ( (lv_generatorReferences_2_0= ruleGeneratorReferencesRule ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalGeneratorDSL.g:729:4: (lv_generatorReferences_2_0= ruleGeneratorReferencesRule )
                    {
                    // InternalGeneratorDSL.g:729:4: (lv_generatorReferences_2_0= ruleGeneratorReferencesRule )
                    // InternalGeneratorDSL.g:730:5: lv_generatorReferences_2_0= ruleGeneratorReferencesRule
                    {

                    					newCompositeNode(grammarAccess.getGeneratorsRuleAccess().getGeneratorReferencesGeneratorReferencesRuleParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_generatorReferences_2_0=ruleGeneratorReferencesRule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getGeneratorsRuleRule());
                    					}
                    					set(
                    						current,
                    						"generatorReferences",
                    						lv_generatorReferences_2_0,
                    						"de.evoal.languages.model.generator.dsl.GeneratorDSL.GeneratorReferencesRule");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneratorsRule"


    // $ANTLR start "entryRuleGeneratorReferencesRule"
    // InternalGeneratorDSL.g:751:1: entryRuleGeneratorReferencesRule returns [EObject current=null] : iv_ruleGeneratorReferencesRule= ruleGeneratorReferencesRule EOF ;
    public final EObject entryRuleGeneratorReferencesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorReferencesRule = null;


        try {
            // InternalGeneratorDSL.g:751:64: (iv_ruleGeneratorReferencesRule= ruleGeneratorReferencesRule EOF )
            // InternalGeneratorDSL.g:752:2: iv_ruleGeneratorReferencesRule= ruleGeneratorReferencesRule EOF
            {
             newCompositeNode(grammarAccess.getGeneratorReferencesRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneratorReferencesRule=ruleGeneratorReferencesRule();

            state._fsp--;

             current =iv_ruleGeneratorReferencesRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratorReferencesRule"


    // $ANTLR start "ruleGeneratorReferencesRule"
    // InternalGeneratorDSL.g:758:1: ruleGeneratorReferencesRule returns [EObject current=null] : (otherlv_0= '[' ( ( ruleStringOrId ) ) (otherlv_2= ',' ( ( ruleStringOrId ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleGeneratorReferencesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:764:2: ( (otherlv_0= '[' ( ( ruleStringOrId ) ) (otherlv_2= ',' ( ( ruleStringOrId ) ) )* otherlv_4= ']' ) )
            // InternalGeneratorDSL.g:765:2: (otherlv_0= '[' ( ( ruleStringOrId ) ) (otherlv_2= ',' ( ( ruleStringOrId ) ) )* otherlv_4= ']' )
            {
            // InternalGeneratorDSL.g:765:2: (otherlv_0= '[' ( ( ruleStringOrId ) ) (otherlv_2= ',' ( ( ruleStringOrId ) ) )* otherlv_4= ']' )
            // InternalGeneratorDSL.g:766:3: otherlv_0= '[' ( ( ruleStringOrId ) ) (otherlv_2= ',' ( ( ruleStringOrId ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getGeneratorReferencesRuleAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalGeneratorDSL.g:770:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:771:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:771:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:772:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneratorReferencesRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGeneratorReferencesRuleAccess().getGeneratorsGeneratorDefinitionCrossReference_1_0());
            				
            pushFollow(FOLLOW_21);
            ruleStringOrId();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:786:3: (otherlv_2= ',' ( ( ruleStringOrId ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalGeneratorDSL.g:787:4: otherlv_2= ',' ( ( ruleStringOrId ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_9); 

            	    				newLeafNode(otherlv_2, grammarAccess.getGeneratorReferencesRuleAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalGeneratorDSL.g:791:4: ( ( ruleStringOrId ) )
            	    // InternalGeneratorDSL.g:792:5: ( ruleStringOrId )
            	    {
            	    // InternalGeneratorDSL.g:792:5: ( ruleStringOrId )
            	    // InternalGeneratorDSL.g:793:6: ruleStringOrId
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getGeneratorReferencesRuleRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getGeneratorReferencesRuleAccess().getGeneratorsGeneratorDefinitionCrossReference_2_1_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    ruleStringOrId();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGeneratorReferencesRuleAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneratorReferencesRule"


    // $ANTLR start "entryRuleApplyStatementRule"
    // InternalGeneratorDSL.g:816:1: entryRuleApplyStatementRule returns [EObject current=null] : iv_ruleApplyStatementRule= ruleApplyStatementRule EOF ;
    public final EObject entryRuleApplyStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplyStatementRule = null;


        try {
            // InternalGeneratorDSL.g:816:59: (iv_ruleApplyStatementRule= ruleApplyStatementRule EOF )
            // InternalGeneratorDSL.g:817:2: iv_ruleApplyStatementRule= ruleApplyStatementRule EOF
            {
             newCompositeNode(grammarAccess.getApplyStatementRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleApplyStatementRule=ruleApplyStatementRule();

            state._fsp--;

             current =iv_ruleApplyStatementRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleApplyStatementRule"


    // $ANTLR start "ruleApplyStatementRule"
    // InternalGeneratorDSL.g:823:1: ruleApplyStatementRule returns [EObject current=null] : (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'applying' ( (lv_function_7_0= ruleFunctionReferenceRule ) ) otherlv_8= 'on' ( (lv_generator_9_0= ruleGeneratorReferenceRule ) ) otherlv_10= ';' ) ;
    public final EObject ruleApplyStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_file_1_0=null;
        Token otherlv_2=null;
        Token lv_count_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_function_7_0 = null;

        EObject lv_generator_9_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:829:2: ( (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'applying' ( (lv_function_7_0= ruleFunctionReferenceRule ) ) otherlv_8= 'on' ( (lv_generator_9_0= ruleGeneratorReferenceRule ) ) otherlv_10= ';' ) )
            // InternalGeneratorDSL.g:830:2: (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'applying' ( (lv_function_7_0= ruleFunctionReferenceRule ) ) otherlv_8= 'on' ( (lv_generator_9_0= ruleGeneratorReferenceRule ) ) otherlv_10= ';' )
            {
            // InternalGeneratorDSL.g:830:2: (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'applying' ( (lv_function_7_0= ruleFunctionReferenceRule ) ) otherlv_8= 'on' ( (lv_generator_9_0= ruleGeneratorReferenceRule ) ) otherlv_10= ';' )
            // InternalGeneratorDSL.g:831:3: otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'applying' ( (lv_function_7_0= ruleFunctionReferenceRule ) ) otherlv_8= 'on' ( (lv_generator_9_0= ruleGeneratorReferenceRule ) ) otherlv_10= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getApplyStatementRuleAccess().getWriteKeyword_0());
            		
            // InternalGeneratorDSL.g:835:3: ( (lv_file_1_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:836:4: (lv_file_1_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:836:4: (lv_file_1_0= RULE_STRING )
            // InternalGeneratorDSL.g:837:5: lv_file_1_0= RULE_STRING
            {
            lv_file_1_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					newLeafNode(lv_file_1_0, grammarAccess.getApplyStatementRuleAccess().getFileSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getApplyStatementRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"file",
            						lv_file_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getApplyStatementRuleAccess().getWithKeyword_2());
            		
            // InternalGeneratorDSL.g:857:3: ( (lv_count_3_0= RULE_INT ) )
            // InternalGeneratorDSL.g:858:4: (lv_count_3_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:858:4: (lv_count_3_0= RULE_INT )
            // InternalGeneratorDSL.g:859:5: lv_count_3_0= RULE_INT
            {
            lv_count_3_0=(Token)match(input,RULE_INT,FOLLOW_23); 

            					newLeafNode(lv_count_3_0, grammarAccess.getApplyStatementRuleAccess().getCountINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getApplyStatementRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"count",
            						lv_count_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_24); 

            			newLeafNode(otherlv_4, grammarAccess.getApplyStatementRuleAccess().getSamplesKeyword_4());
            		
            otherlv_5=(Token)match(input,30,FOLLOW_25); 

            			newLeafNode(otherlv_5, grammarAccess.getApplyStatementRuleAccess().getFromKeyword_5());
            		
            otherlv_6=(Token)match(input,31,FOLLOW_26); 

            			newLeafNode(otherlv_6, grammarAccess.getApplyStatementRuleAccess().getApplyingKeyword_6());
            		
            // InternalGeneratorDSL.g:887:3: ( (lv_function_7_0= ruleFunctionReferenceRule ) )
            // InternalGeneratorDSL.g:888:4: (lv_function_7_0= ruleFunctionReferenceRule )
            {
            // InternalGeneratorDSL.g:888:4: (lv_function_7_0= ruleFunctionReferenceRule )
            // InternalGeneratorDSL.g:889:5: lv_function_7_0= ruleFunctionReferenceRule
            {

            					newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getFunctionFunctionReferenceRuleParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_27);
            lv_function_7_0=ruleFunctionReferenceRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getApplyStatementRuleRule());
            					}
            					set(
            						current,
            						"function",
            						lv_function_7_0,
            						"de.evoal.languages.model.generator.dsl.GeneratorDSL.FunctionReferenceRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,32,FOLLOW_28); 

            			newLeafNode(otherlv_8, grammarAccess.getApplyStatementRuleAccess().getOnKeyword_8());
            		
            // InternalGeneratorDSL.g:910:3: ( (lv_generator_9_0= ruleGeneratorReferenceRule ) )
            // InternalGeneratorDSL.g:911:4: (lv_generator_9_0= ruleGeneratorReferenceRule )
            {
            // InternalGeneratorDSL.g:911:4: (lv_generator_9_0= ruleGeneratorReferenceRule )
            // InternalGeneratorDSL.g:912:5: lv_generator_9_0= ruleGeneratorReferenceRule
            {

            					newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getGeneratorGeneratorReferenceRuleParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_8);
            lv_generator_9_0=ruleGeneratorReferenceRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getApplyStatementRuleRule());
            					}
            					set(
            						current,
            						"generator",
            						lv_generator_9_0,
            						"de.evoal.languages.model.generator.dsl.GeneratorDSL.GeneratorReferenceRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getApplyStatementRuleAccess().getSemicolonKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleApplyStatementRule"


    // $ANTLR start "entryRuleGeneratorReferenceRule"
    // InternalGeneratorDSL.g:937:1: entryRuleGeneratorReferenceRule returns [EObject current=null] : iv_ruleGeneratorReferenceRule= ruleGeneratorReferenceRule EOF ;
    public final EObject entryRuleGeneratorReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:937:63: (iv_ruleGeneratorReferenceRule= ruleGeneratorReferenceRule EOF )
            // InternalGeneratorDSL.g:938:2: iv_ruleGeneratorReferenceRule= ruleGeneratorReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getGeneratorReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneratorReferenceRule=ruleGeneratorReferenceRule();

            state._fsp--;

             current =iv_ruleGeneratorReferenceRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratorReferenceRule"


    // $ANTLR start "ruleGeneratorReferenceRule"
    // InternalGeneratorDSL.g:944:1: ruleGeneratorReferenceRule returns [EObject current=null] : (this_GeneratorDefinitionReferenceRule_0= ruleGeneratorDefinitionReferenceRule | this_LoopVariableReference_1= ruleLoopVariableReference ) ;
    public final EObject ruleGeneratorReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratorDefinitionReferenceRule_0 = null;

        EObject this_LoopVariableReference_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:950:2: ( (this_GeneratorDefinitionReferenceRule_0= ruleGeneratorDefinitionReferenceRule | this_LoopVariableReference_1= ruleLoopVariableReference ) )
            // InternalGeneratorDSL.g:951:2: (this_GeneratorDefinitionReferenceRule_0= ruleGeneratorDefinitionReferenceRule | this_LoopVariableReference_1= ruleLoopVariableReference )
            {
            // InternalGeneratorDSL.g:951:2: (this_GeneratorDefinitionReferenceRule_0= ruleGeneratorDefinitionReferenceRule | this_LoopVariableReference_1= ruleLoopVariableReference )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==16) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalGeneratorDSL.g:952:3: this_GeneratorDefinitionReferenceRule_0= ruleGeneratorDefinitionReferenceRule
                    {

                    			newCompositeNode(grammarAccess.getGeneratorReferenceRuleAccess().getGeneratorDefinitionReferenceRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_GeneratorDefinitionReferenceRule_0=ruleGeneratorDefinitionReferenceRule();

                    state._fsp--;


                    			current = this_GeneratorDefinitionReferenceRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:961:3: this_LoopVariableReference_1= ruleLoopVariableReference
                    {

                    			newCompositeNode(grammarAccess.getGeneratorReferenceRuleAccess().getLoopVariableReferenceParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LoopVariableReference_1=ruleLoopVariableReference();

                    state._fsp--;


                    			current = this_LoopVariableReference_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneratorReferenceRule"


    // $ANTLR start "entryRuleGeneratorDefinitionReferenceRule"
    // InternalGeneratorDSL.g:973:1: entryRuleGeneratorDefinitionReferenceRule returns [EObject current=null] : iv_ruleGeneratorDefinitionReferenceRule= ruleGeneratorDefinitionReferenceRule EOF ;
    public final EObject entryRuleGeneratorDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorDefinitionReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:973:73: (iv_ruleGeneratorDefinitionReferenceRule= ruleGeneratorDefinitionReferenceRule EOF )
            // InternalGeneratorDSL.g:974:2: iv_ruleGeneratorDefinitionReferenceRule= ruleGeneratorDefinitionReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getGeneratorDefinitionReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneratorDefinitionReferenceRule=ruleGeneratorDefinitionReferenceRule();

            state._fsp--;

             current =iv_ruleGeneratorDefinitionReferenceRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratorDefinitionReferenceRule"


    // $ANTLR start "ruleGeneratorDefinitionReferenceRule"
    // InternalGeneratorDSL.g:980:1: ruleGeneratorDefinitionReferenceRule returns [EObject current=null] : (otherlv_0= 'generator' ( ( ruleStringOrId ) ) ) ;
    public final EObject ruleGeneratorDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:986:2: ( (otherlv_0= 'generator' ( ( ruleStringOrId ) ) ) )
            // InternalGeneratorDSL.g:987:2: (otherlv_0= 'generator' ( ( ruleStringOrId ) ) )
            {
            // InternalGeneratorDSL.g:987:2: (otherlv_0= 'generator' ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:988:3: otherlv_0= 'generator' ( ( ruleStringOrId ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getGeneratorDefinitionReferenceRuleAccess().getGeneratorKeyword_0());
            		
            // InternalGeneratorDSL.g:992:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:993:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:993:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:994:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneratorDefinitionReferenceRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGeneratorDefinitionReferenceRuleAccess().getDefinitionGeneratorDefinitionCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneratorDefinitionReferenceRule"


    // $ANTLR start "entryRuleFunctionReferenceRule"
    // InternalGeneratorDSL.g:1012:1: entryRuleFunctionReferenceRule returns [EObject current=null] : iv_ruleFunctionReferenceRule= ruleFunctionReferenceRule EOF ;
    public final EObject entryRuleFunctionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:1012:62: (iv_ruleFunctionReferenceRule= ruleFunctionReferenceRule EOF )
            // InternalGeneratorDSL.g:1013:2: iv_ruleFunctionReferenceRule= ruleFunctionReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getFunctionReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionReferenceRule=ruleFunctionReferenceRule();

            state._fsp--;

             current =iv_ruleFunctionReferenceRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionReferenceRule"


    // $ANTLR start "ruleFunctionReferenceRule"
    // InternalGeneratorDSL.g:1019:1: ruleFunctionReferenceRule returns [EObject current=null] : (this_FunctionDefReferenceRule_0= ruleFunctionDefReferenceRule | this_LoopVariableReference_1= ruleLoopVariableReference ) ;
    public final EObject ruleFunctionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionDefReferenceRule_0 = null;

        EObject this_LoopVariableReference_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1025:2: ( (this_FunctionDefReferenceRule_0= ruleFunctionDefReferenceRule | this_LoopVariableReference_1= ruleLoopVariableReference ) )
            // InternalGeneratorDSL.g:1026:2: (this_FunctionDefReferenceRule_0= ruleFunctionDefReferenceRule | this_LoopVariableReference_1= ruleLoopVariableReference )
            {
            // InternalGeneratorDSL.g:1026:2: (this_FunctionDefReferenceRule_0= ruleFunctionDefReferenceRule | this_LoopVariableReference_1= ruleLoopVariableReference )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14||LA13_0==33) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalGeneratorDSL.g:1027:3: this_FunctionDefReferenceRule_0= ruleFunctionDefReferenceRule
                    {

                    			newCompositeNode(grammarAccess.getFunctionReferenceRuleAccess().getFunctionDefReferenceRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FunctionDefReferenceRule_0=ruleFunctionDefReferenceRule();

                    state._fsp--;


                    			current = this_FunctionDefReferenceRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:1036:3: this_LoopVariableReference_1= ruleLoopVariableReference
                    {

                    			newCompositeNode(grammarAccess.getFunctionReferenceRuleAccess().getLoopVariableReferenceParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LoopVariableReference_1=ruleLoopVariableReference();

                    state._fsp--;


                    			current = this_LoopVariableReference_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionReferenceRule"


    // $ANTLR start "entryRuleFunctionDefReferenceRule"
    // InternalGeneratorDSL.g:1048:1: entryRuleFunctionDefReferenceRule returns [EObject current=null] : iv_ruleFunctionDefReferenceRule= ruleFunctionDefReferenceRule EOF ;
    public final EObject entryRuleFunctionDefReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:1048:65: (iv_ruleFunctionDefReferenceRule= ruleFunctionDefReferenceRule EOF )
            // InternalGeneratorDSL.g:1049:2: iv_ruleFunctionDefReferenceRule= ruleFunctionDefReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getFunctionDefReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDefReferenceRule=ruleFunctionDefReferenceRule();

            state._fsp--;

             current =iv_ruleFunctionDefReferenceRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDefReferenceRule"


    // $ANTLR start "ruleFunctionDefReferenceRule"
    // InternalGeneratorDSL.g:1055:1: ruleFunctionDefReferenceRule returns [EObject current=null] : (this_FunctionDefinitionReferenceRule_0= ruleFunctionDefinitionReferenceRule | this_ParametrizedFunctionDefinitionReferenceRule_1= ruleParametrizedFunctionDefinitionReferenceRule ) ;
    public final EObject ruleFunctionDefReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionDefinitionReferenceRule_0 = null;

        EObject this_ParametrizedFunctionDefinitionReferenceRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1061:2: ( (this_FunctionDefinitionReferenceRule_0= ruleFunctionDefinitionReferenceRule | this_ParametrizedFunctionDefinitionReferenceRule_1= ruleParametrizedFunctionDefinitionReferenceRule ) )
            // InternalGeneratorDSL.g:1062:2: (this_FunctionDefinitionReferenceRule_0= ruleFunctionDefinitionReferenceRule | this_ParametrizedFunctionDefinitionReferenceRule_1= ruleParametrizedFunctionDefinitionReferenceRule )
            {
            // InternalGeneratorDSL.g:1062:2: (this_FunctionDefinitionReferenceRule_0= ruleFunctionDefinitionReferenceRule | this_ParametrizedFunctionDefinitionReferenceRule_1= ruleParametrizedFunctionDefinitionReferenceRule )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==33) ) {
                alt14=1;
            }
            else if ( (LA14_0==14) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalGeneratorDSL.g:1063:3: this_FunctionDefinitionReferenceRule_0= ruleFunctionDefinitionReferenceRule
                    {

                    			newCompositeNode(grammarAccess.getFunctionDefReferenceRuleAccess().getFunctionDefinitionReferenceRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FunctionDefinitionReferenceRule_0=ruleFunctionDefinitionReferenceRule();

                    state._fsp--;


                    			current = this_FunctionDefinitionReferenceRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:1072:3: this_ParametrizedFunctionDefinitionReferenceRule_1= ruleParametrizedFunctionDefinitionReferenceRule
                    {

                    			newCompositeNode(grammarAccess.getFunctionDefReferenceRuleAccess().getParametrizedFunctionDefinitionReferenceRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParametrizedFunctionDefinitionReferenceRule_1=ruleParametrizedFunctionDefinitionReferenceRule();

                    state._fsp--;


                    			current = this_ParametrizedFunctionDefinitionReferenceRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDefReferenceRule"


    // $ANTLR start "entryRuleLoopVariableReference"
    // InternalGeneratorDSL.g:1084:1: entryRuleLoopVariableReference returns [EObject current=null] : iv_ruleLoopVariableReference= ruleLoopVariableReference EOF ;
    public final EObject entryRuleLoopVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopVariableReference = null;


        try {
            // InternalGeneratorDSL.g:1084:62: (iv_ruleLoopVariableReference= ruleLoopVariableReference EOF )
            // InternalGeneratorDSL.g:1085:2: iv_ruleLoopVariableReference= ruleLoopVariableReference EOF
            {
             newCompositeNode(grammarAccess.getLoopVariableReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoopVariableReference=ruleLoopVariableReference();

            state._fsp--;

             current =iv_ruleLoopVariableReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopVariableReference"


    // $ANTLR start "ruleLoopVariableReference"
    // InternalGeneratorDSL.g:1091:1: ruleLoopVariableReference returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleLoopVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1097:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // InternalGeneratorDSL.g:1098:2: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalGeneratorDSL.g:1098:2: ( () ( (otherlv_1= RULE_ID ) ) )
            // InternalGeneratorDSL.g:1099:3: () ( (otherlv_1= RULE_ID ) )
            {
            // InternalGeneratorDSL.g:1099:3: ()
            // InternalGeneratorDSL.g:1100:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLoopVariableReferenceAccess().getLoopVariableAction_0(),
            					current);
            			

            }

            // InternalGeneratorDSL.g:1106:3: ( (otherlv_1= RULE_ID ) )
            // InternalGeneratorDSL.g:1107:4: (otherlv_1= RULE_ID )
            {
            // InternalGeneratorDSL.g:1107:4: (otherlv_1= RULE_ID )
            // InternalGeneratorDSL.g:1108:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopVariableReferenceRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getLoopVariableReferenceAccess().getDefinitionForStatementCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopVariableReference"


    // $ANTLR start "entryRuleFunctionDefinitionReferenceRule"
    // InternalGeneratorDSL.g:1123:1: entryRuleFunctionDefinitionReferenceRule returns [EObject current=null] : iv_ruleFunctionDefinitionReferenceRule= ruleFunctionDefinitionReferenceRule EOF ;
    public final EObject entryRuleFunctionDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinitionReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:1123:72: (iv_ruleFunctionDefinitionReferenceRule= ruleFunctionDefinitionReferenceRule EOF )
            // InternalGeneratorDSL.g:1124:2: iv_ruleFunctionDefinitionReferenceRule= ruleFunctionDefinitionReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getFunctionDefinitionReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDefinitionReferenceRule=ruleFunctionDefinitionReferenceRule();

            state._fsp--;

             current =iv_ruleFunctionDefinitionReferenceRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDefinitionReferenceRule"


    // $ANTLR start "ruleFunctionDefinitionReferenceRule"
    // InternalGeneratorDSL.g:1130:1: ruleFunctionDefinitionReferenceRule returns [EObject current=null] : ( () otherlv_1= 'definition' ( ( ruleStringOrId ) ) ) ;
    public final EObject ruleFunctionDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1136:2: ( ( () otherlv_1= 'definition' ( ( ruleStringOrId ) ) ) )
            // InternalGeneratorDSL.g:1137:2: ( () otherlv_1= 'definition' ( ( ruleStringOrId ) ) )
            {
            // InternalGeneratorDSL.g:1137:2: ( () otherlv_1= 'definition' ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:1138:3: () otherlv_1= 'definition' ( ( ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:1138:3: ()
            // InternalGeneratorDSL.g:1139:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFunctionDefinitionReferenceRuleAccess().getFunctionDefinitionReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,33,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionReferenceRuleAccess().getDefinitionKeyword_1());
            		
            // InternalGeneratorDSL.g:1149:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:1150:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:1150:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:1151:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionDefinitionReferenceRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFunctionDefinitionReferenceRuleAccess().getDefinitionFunctionDefinitionCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDefinitionReferenceRule"


    // $ANTLR start "entryRuleParametrizedFunctionDefinitionReferenceRule"
    // InternalGeneratorDSL.g:1169:1: entryRuleParametrizedFunctionDefinitionReferenceRule returns [EObject current=null] : iv_ruleParametrizedFunctionDefinitionReferenceRule= ruleParametrizedFunctionDefinitionReferenceRule EOF ;
    public final EObject entryRuleParametrizedFunctionDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParametrizedFunctionDefinitionReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:1169:84: (iv_ruleParametrizedFunctionDefinitionReferenceRule= ruleParametrizedFunctionDefinitionReferenceRule EOF )
            // InternalGeneratorDSL.g:1170:2: iv_ruleParametrizedFunctionDefinitionReferenceRule= ruleParametrizedFunctionDefinitionReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getParametrizedFunctionDefinitionReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParametrizedFunctionDefinitionReferenceRule=ruleParametrizedFunctionDefinitionReferenceRule();

            state._fsp--;

             current =iv_ruleParametrizedFunctionDefinitionReferenceRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParametrizedFunctionDefinitionReferenceRule"


    // $ANTLR start "ruleParametrizedFunctionDefinitionReferenceRule"
    // InternalGeneratorDSL.g:1176:1: ruleParametrizedFunctionDefinitionReferenceRule returns [EObject current=null] : ( () otherlv_1= 'function' ( ( ruleStringOrId ) ) ) ;
    public final EObject ruleParametrizedFunctionDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1182:2: ( ( () otherlv_1= 'function' ( ( ruleStringOrId ) ) ) )
            // InternalGeneratorDSL.g:1183:2: ( () otherlv_1= 'function' ( ( ruleStringOrId ) ) )
            {
            // InternalGeneratorDSL.g:1183:2: ( () otherlv_1= 'function' ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:1184:3: () otherlv_1= 'function' ( ( ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:1184:3: ()
            // InternalGeneratorDSL.g:1185:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParametrizedFunctionDefinitionReferenceRuleAccess().getParametrizedFunctionDefinitionReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getParametrizedFunctionDefinitionReferenceRuleAccess().getFunctionKeyword_1());
            		
            // InternalGeneratorDSL.g:1195:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:1196:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:1196:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:1197:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParametrizedFunctionDefinitionReferenceRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParametrizedFunctionDefinitionReferenceRuleAccess().getDefinitionFunctionDefinitionReferenceCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParametrizedFunctionDefinitionReferenceRule"


    // $ANTLR start "entryRuleInstanceRule"
    // InternalGeneratorDSL.g:1215:1: entryRuleInstanceRule returns [EObject current=null] : iv_ruleInstanceRule= ruleInstanceRule EOF ;
    public final EObject entryRuleInstanceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceRule = null;


        try {
            // InternalGeneratorDSL.g:1215:53: (iv_ruleInstanceRule= ruleInstanceRule EOF )
            // InternalGeneratorDSL.g:1216:2: iv_ruleInstanceRule= ruleInstanceRule EOF
            {
             newCompositeNode(grammarAccess.getInstanceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstanceRule=ruleInstanceRule();

            state._fsp--;

             current =iv_ruleInstanceRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceRule"


    // $ANTLR start "ruleInstanceRule"
    // InternalGeneratorDSL.g:1222:1: ruleInstanceRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleInstanceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1228:2: ( ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) )
            // InternalGeneratorDSL.g:1229:2: ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            {
            // InternalGeneratorDSL.g:1229:2: ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            // InternalGeneratorDSL.g:1230:3: ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            {
            // InternalGeneratorDSL.g:1230:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:1231:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:1231:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:1232:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInstanceRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInstanceRuleAccess().getNameTypeDefinitionCrossReference_0_0());
            				
            pushFollow(FOLLOW_29);
            ruleStringOrId();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:1246:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==34) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalGeneratorDSL.g:1247:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_30); 

                    				newLeafNode(otherlv_1, grammarAccess.getInstanceRuleAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalGeneratorDSL.g:1251:4: ( (lv_attributes_2_0= ruleAttributeRule ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_ID)||LA15_0==RULE_QUOTED_ID) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:1252:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    {
                    	    // InternalGeneratorDSL.g:1252:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    // InternalGeneratorDSL.g:1253:6: lv_attributes_2_0= ruleAttributeRule
                    	    {

                    	    						newCompositeNode(grammarAccess.getInstanceRuleAccess().getAttributesAttributeRuleParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_30);
                    	    lv_attributes_2_0=ruleAttributeRule();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInstanceRuleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"attributes",
                    	    							lv_attributes_2_0,
                    	    							"de.evoal.languages.model.instance.dsl.InstanceLanguage.AttributeRule");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,35,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getInstanceRuleAccess().getRightCurlyBracketKeyword_1_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceRule"


    // $ANTLR start "entryRuleAttributeRule"
    // InternalGeneratorDSL.g:1279:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalGeneratorDSL.g:1279:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalGeneratorDSL.g:1280:2: iv_ruleAttributeRule= ruleAttributeRule EOF
            {
             newCompositeNode(grammarAccess.getAttributeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeRule=ruleAttributeRule();

            state._fsp--;

             current =iv_ruleAttributeRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeRule"


    // $ANTLR start "ruleAttributeRule"
    // InternalGeneratorDSL.g:1286:1: ruleAttributeRule returns [EObject current=null] : ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1292:2: ( ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) )
            // InternalGeneratorDSL.g:1293:2: ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            {
            // InternalGeneratorDSL.g:1293:2: ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            // InternalGeneratorDSL.g:1294:3: ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';'
            {
            // InternalGeneratorDSL.g:1294:3: ( (lv_name_0_0= ruleNameOrMiscRule ) )
            // InternalGeneratorDSL.g:1295:4: (lv_name_0_0= ruleNameOrMiscRule )
            {
            // InternalGeneratorDSL.g:1295:4: (lv_name_0_0= ruleNameOrMiscRule )
            // InternalGeneratorDSL.g:1296:5: lv_name_0_0= ruleNameOrMiscRule
            {

            					newCompositeNode(grammarAccess.getAttributeRuleAccess().getNameNameOrMiscRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_31);
            lv_name_0_0=ruleNameOrMiscRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRuleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"de.evoal.languages.model.instance.dsl.InstanceLanguage.NameOrMiscRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
            		
            // InternalGeneratorDSL.g:1317:3: ( (lv_value_2_0= ruleValueRule ) )
            // InternalGeneratorDSL.g:1318:4: (lv_value_2_0= ruleValueRule )
            {
            // InternalGeneratorDSL.g:1318:4: (lv_value_2_0= ruleValueRule )
            // InternalGeneratorDSL.g:1319:5: lv_value_2_0= ruleValueRule
            {

            					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueValueRuleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_8);
            lv_value_2_0=ruleValueRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRuleRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"de.evoal.languages.model.instance.dsl.InstanceLanguage.ValueRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeRule"


    // $ANTLR start "entryRuleNameOrMiscRule"
    // InternalGeneratorDSL.g:1344:1: entryRuleNameOrMiscRule returns [EObject current=null] : iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF ;
    public final EObject entryRuleNameOrMiscRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrMiscRule = null;


        try {
            // InternalGeneratorDSL.g:1344:55: (iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF )
            // InternalGeneratorDSL.g:1345:2: iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF
            {
             newCompositeNode(grammarAccess.getNameOrMiscRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNameOrMiscRule=ruleNameOrMiscRule();

            state._fsp--;

             current =iv_ruleNameOrMiscRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNameOrMiscRule"


    // $ANTLR start "ruleNameOrMiscRule"
    // InternalGeneratorDSL.g:1351:1: ruleNameOrMiscRule returns [EObject current=null] : (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule ) ;
    public final EObject ruleNameOrMiscRule() throws RecognitionException {
        EObject current = null;

        EObject this_NameRule_0 = null;

        EObject this_MiscRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1357:2: ( (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule ) )
            // InternalGeneratorDSL.g:1358:2: (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule )
            {
            // InternalGeneratorDSL.g:1358:2: (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||LA17_0==RULE_QUOTED_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_STRING) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalGeneratorDSL.g:1359:3: this_NameRule_0= ruleNameRule
                    {

                    			newCompositeNode(grammarAccess.getNameOrMiscRuleAccess().getNameRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NameRule_0=ruleNameRule();

                    state._fsp--;


                    			current = this_NameRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:1368:3: this_MiscRule_1= ruleMiscRule
                    {

                    			newCompositeNode(grammarAccess.getNameOrMiscRuleAccess().getMiscRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MiscRule_1=ruleMiscRule();

                    state._fsp--;


                    			current = this_MiscRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNameOrMiscRule"


    // $ANTLR start "entryRuleNameRule"
    // InternalGeneratorDSL.g:1380:1: entryRuleNameRule returns [EObject current=null] : iv_ruleNameRule= ruleNameRule EOF ;
    public final EObject entryRuleNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameRule = null;


        try {
            // InternalGeneratorDSL.g:1380:49: (iv_ruleNameRule= ruleNameRule EOF )
            // InternalGeneratorDSL.g:1381:2: iv_ruleNameRule= ruleNameRule EOF
            {
             newCompositeNode(grammarAccess.getNameRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNameRule=ruleNameRule();

            state._fsp--;

             current =iv_ruleNameRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNameRule"


    // $ANTLR start "ruleNameRule"
    // InternalGeneratorDSL.g:1387:1: ruleNameRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1393:2: ( ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:1394:2: ( ( ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:1394:2: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:1395:3: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:1395:3: ( ruleStringOrId )
            // InternalGeneratorDSL.g:1396:4: ruleStringOrId
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNameRuleRule());
            				}
            			

            				newCompositeNode(grammarAccess.getNameRuleAccess().getNameNamedAttributeDefinitionCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNameRule"


    // $ANTLR start "entryRuleMiscRule"
    // InternalGeneratorDSL.g:1413:1: entryRuleMiscRule returns [EObject current=null] : iv_ruleMiscRule= ruleMiscRule EOF ;
    public final EObject entryRuleMiscRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMiscRule = null;


        try {
            // InternalGeneratorDSL.g:1413:49: (iv_ruleMiscRule= ruleMiscRule EOF )
            // InternalGeneratorDSL.g:1414:2: iv_ruleMiscRule= ruleMiscRule EOF
            {
             newCompositeNode(grammarAccess.getMiscRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMiscRule=ruleMiscRule();

            state._fsp--;

             current =iv_ruleMiscRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMiscRule"


    // $ANTLR start "ruleMiscRule"
    // InternalGeneratorDSL.g:1420:1: ruleMiscRule returns [EObject current=null] : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final EObject ruleMiscRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1426:2: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // InternalGeneratorDSL.g:1427:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // InternalGeneratorDSL.g:1427:2: ( (lv_name_0_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:1428:3: (lv_name_0_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:1428:3: (lv_name_0_0= RULE_STRING )
            // InternalGeneratorDSL.g:1429:4: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getMiscRuleAccess().getNameSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getMiscRuleRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"de.evoal.languages.model.el.dsl.ExpressionLanguage.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMiscRule"


    // $ANTLR start "entryRuleValueRule"
    // InternalGeneratorDSL.g:1448:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // InternalGeneratorDSL.g:1448:50: (iv_ruleValueRule= ruleValueRule EOF )
            // InternalGeneratorDSL.g:1449:2: iv_ruleValueRule= ruleValueRule EOF
            {
             newCompositeNode(grammarAccess.getValueRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueRule=ruleValueRule();

            state._fsp--;

             current =iv_ruleValueRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueRule"


    // $ANTLR start "ruleValueRule"
    // InternalGeneratorDSL.g:1455:1: ruleValueRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_DataReferenceRule_1 = null;

        EObject this_InstanceRule_2 = null;

        EObject this_LiteralValueRule_3 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1461:2: ( (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) )
            // InternalGeneratorDSL.g:1462:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            {
            // InternalGeneratorDSL.g:1462:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt18=1;
                }
                break;
            case 37:
                {
                alt18=2;
                }
                break;
            case RULE_ID:
            case RULE_QUOTED_ID:
                {
                alt18=3;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case 47:
            case 48:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalGeneratorDSL.g:1463:3: this_ArrayRule_0= ruleArrayRule
                    {

                    			newCompositeNode(grammarAccess.getValueRuleAccess().getArrayRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArrayRule_0=ruleArrayRule();

                    state._fsp--;


                    			current = this_ArrayRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:1472:3: this_DataReferenceRule_1= ruleDataReferenceRule
                    {

                    			newCompositeNode(grammarAccess.getValueRuleAccess().getDataReferenceRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataReferenceRule_1=ruleDataReferenceRule();

                    state._fsp--;


                    			current = this_DataReferenceRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:1481:3: this_InstanceRule_2= ruleInstanceRule
                    {

                    			newCompositeNode(grammarAccess.getValueRuleAccess().getInstanceRuleParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_InstanceRule_2=ruleInstanceRule();

                    state._fsp--;


                    			current = this_InstanceRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:1490:3: this_LiteralValueRule_3= ruleLiteralValueRule
                    {

                    			newCompositeNode(grammarAccess.getValueRuleAccess().getLiteralValueRuleParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralValueRule_3=ruleLiteralValueRule();

                    state._fsp--;


                    			current = this_LiteralValueRule_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueRule"


    // $ANTLR start "entryRuleArrayRule"
    // InternalGeneratorDSL.g:1502:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalGeneratorDSL.g:1502:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalGeneratorDSL.g:1503:2: iv_ruleArrayRule= ruleArrayRule EOF
            {
             newCompositeNode(grammarAccess.getArrayRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayRule=ruleArrayRule();

            state._fsp--;

             current =iv_ruleArrayRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayRule"


    // $ANTLR start "ruleArrayRule"
    // InternalGeneratorDSL.g:1509:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1515:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) )
            // InternalGeneratorDSL.g:1516:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalGeneratorDSL.g:1516:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            // InternalGeneratorDSL.g:1517:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']'
            {
            // InternalGeneratorDSL.g:1517:3: ()
            // InternalGeneratorDSL.g:1518:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArrayRuleAccess().getArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_33); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalGeneratorDSL.g:1528:3: ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_QUOTED_ID)||LA20_0==21||LA20_0==37||(LA20_0>=47 && LA20_0<=48)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalGeneratorDSL.g:1529:4: ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    {
                    // InternalGeneratorDSL.g:1529:4: ( (lv_values_2_0= ruleValueRule ) )
                    // InternalGeneratorDSL.g:1530:5: (lv_values_2_0= ruleValueRule )
                    {
                    // InternalGeneratorDSL.g:1530:5: (lv_values_2_0= ruleValueRule )
                    // InternalGeneratorDSL.g:1531:6: lv_values_2_0= ruleValueRule
                    {

                    						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_values_2_0=ruleValueRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArrayRuleRule());
                    						}
                    						add(
                    							current,
                    							"values",
                    							lv_values_2_0,
                    							"de.evoal.languages.model.instance.dsl.InstanceLanguage.ValueRule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGeneratorDSL.g:1548:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==25) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:1549:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_32); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalGeneratorDSL.g:1553:5: ( (lv_values_4_0= ruleValueRule ) )
                    	    // InternalGeneratorDSL.g:1554:6: (lv_values_4_0= ruleValueRule )
                    	    {
                    	    // InternalGeneratorDSL.g:1554:6: (lv_values_4_0= ruleValueRule )
                    	    // InternalGeneratorDSL.g:1555:7: lv_values_4_0= ruleValueRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_values_4_0=ruleValueRule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getArrayRuleRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"values",
                    	    								lv_values_4_0,
                    	    								"de.evoal.languages.model.instance.dsl.InstanceLanguage.ValueRule");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayRule"


    // $ANTLR start "entryRuleLiteralValueRule"
    // InternalGeneratorDSL.g:1582:1: entryRuleLiteralValueRule returns [EObject current=null] : iv_ruleLiteralValueRule= ruleLiteralValueRule EOF ;
    public final EObject entryRuleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValueRule = null;


        try {
            // InternalGeneratorDSL.g:1582:57: (iv_ruleLiteralValueRule= ruleLiteralValueRule EOF )
            // InternalGeneratorDSL.g:1583:2: iv_ruleLiteralValueRule= ruleLiteralValueRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralValueRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralValueRule=ruleLiteralValueRule();

            state._fsp--;

             current =iv_ruleLiteralValueRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralValueRule"


    // $ANTLR start "ruleLiteralValueRule"
    // InternalGeneratorDSL.g:1589:1: ruleLiteralValueRule returns [EObject current=null] : ( (lv_literal_0_0= ruleLiteralRule ) ) ;
    public final EObject ruleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject lv_literal_0_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1595:2: ( ( (lv_literal_0_0= ruleLiteralRule ) ) )
            // InternalGeneratorDSL.g:1596:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            {
            // InternalGeneratorDSL.g:1596:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            // InternalGeneratorDSL.g:1597:3: (lv_literal_0_0= ruleLiteralRule )
            {
            // InternalGeneratorDSL.g:1597:3: (lv_literal_0_0= ruleLiteralRule )
            // InternalGeneratorDSL.g:1598:4: lv_literal_0_0= ruleLiteralRule
            {

            				newCompositeNode(grammarAccess.getLiteralValueRuleAccess().getLiteralLiteralRuleParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_literal_0_0=ruleLiteralRule();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getLiteralValueRuleRule());
            				}
            				set(
            					current,
            					"literal",
            					lv_literal_0_0,
            					"de.evoal.languages.model.el.dsl.ExpressionLanguage.LiteralRule");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralValueRule"


    // $ANTLR start "entryRuleDataReferenceRule"
    // InternalGeneratorDSL.g:1618:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:1618:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalGeneratorDSL.g:1619:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getDataReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataReferenceRule=ruleDataReferenceRule();

            state._fsp--;

             current =iv_ruleDataReferenceRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataReferenceRule"


    // $ANTLR start "ruleDataReferenceRule"
    // InternalGeneratorDSL.g:1625:1: ruleDataReferenceRule returns [EObject current=null] : ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1631:2: ( ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) )
            // InternalGeneratorDSL.g:1632:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            {
            // InternalGeneratorDSL.g:1632:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:1633:3: () otherlv_1= 'data' ( ( ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:1633:3: ()
            // InternalGeneratorDSL.g:1634:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,37,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1());
            		
            // InternalGeneratorDSL.g:1644:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:1645:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:1645:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:1646:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataReferenceRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataReferenceRule"


    // $ANTLR start "entryRuleExpressionRule"
    // InternalGeneratorDSL.g:1664:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1664:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalGeneratorDSL.g:1665:2: iv_ruleExpressionRule= ruleExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionRule=ruleExpressionRule();

            state._fsp--;

             current =iv_ruleExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionRule"


    // $ANTLR start "ruleExpressionRule"
    // InternalGeneratorDSL.g:1671:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1677:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalGeneratorDSL.g:1678:2: this_OrExpressionRule_0= ruleOrExpressionRule
            {

            		newCompositeNode(grammarAccess.getExpressionRuleAccess().getOrExpressionRuleParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_OrExpressionRule_0=ruleOrExpressionRule();

            state._fsp--;


            		current = this_OrExpressionRule_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionRule"


    // $ANTLR start "entryRuleOrExpressionRule"
    // InternalGeneratorDSL.g:1689:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1689:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalGeneratorDSL.g:1690:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getOrExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrExpressionRule=ruleOrExpressionRule();

            state._fsp--;

             current =iv_ruleOrExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpressionRule"


    // $ANTLR start "ruleOrExpressionRule"
    // InternalGeneratorDSL.g:1696:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1702:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1703:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1703:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1704:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1704:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalGeneratorDSL.g:1705:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalGeneratorDSL.g:1705:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalGeneratorDSL.g:1706:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {

            					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_34);
            lv_subExpressions_0_0=ruleXorExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrExpressionRuleRule());
            					}
            					add(
            						current,
            						"subExpressions",
            						lv_subExpressions_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.XorExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:1723:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==38) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1724:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,38,FOLLOW_35); 

            	    				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	    			
            	    // InternalGeneratorDSL.g:1728:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalGeneratorDSL.g:1729:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1729:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalGeneratorDSL.g:1730:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_34);
            	    lv_subExpressions_2_0=ruleXorExpressionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"subExpressions",
            	    							lv_subExpressions_2_0,
            	    							"de.evoal.languages.model.el.dsl.ExpressionLanguage.XorExpressionRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpressionRule"


    // $ANTLR start "entryRuleXorExpressionRule"
    // InternalGeneratorDSL.g:1752:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1752:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalGeneratorDSL.g:1753:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getXorExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXorExpressionRule=ruleXorExpressionRule();

            state._fsp--;

             current =iv_ruleXorExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXorExpressionRule"


    // $ANTLR start "ruleXorExpressionRule"
    // InternalGeneratorDSL.g:1759:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1765:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1766:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1766:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1767:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1767:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalGeneratorDSL.g:1768:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalGeneratorDSL.g:1768:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalGeneratorDSL.g:1769:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {

            					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_36);
            lv_subExpressions_0_0=ruleAndExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getXorExpressionRuleRule());
            					}
            					add(
            						current,
            						"subExpressions",
            						lv_subExpressions_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.AndExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:1786:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==39) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1787:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,39,FOLLOW_35); 

            	    				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	    			
            	    // InternalGeneratorDSL.g:1791:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalGeneratorDSL.g:1792:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1792:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalGeneratorDSL.g:1793:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_36);
            	    lv_subExpressions_2_0=ruleAndExpressionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXorExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"subExpressions",
            	    							lv_subExpressions_2_0,
            	    							"de.evoal.languages.model.el.dsl.ExpressionLanguage.AndExpressionRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXorExpressionRule"


    // $ANTLR start "entryRuleAndExpressionRule"
    // InternalGeneratorDSL.g:1815:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1815:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalGeneratorDSL.g:1816:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpressionRule=ruleAndExpressionRule();

            state._fsp--;

             current =iv_ruleAndExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpressionRule"


    // $ANTLR start "ruleAndExpressionRule"
    // InternalGeneratorDSL.g:1822:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1828:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1829:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1829:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1830:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1830:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalGeneratorDSL.g:1831:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalGeneratorDSL.g:1831:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalGeneratorDSL.g:1832:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {

            					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_37);
            lv_subExpressions_0_0=ruleNotExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndExpressionRuleRule());
            					}
            					add(
            						current,
            						"subExpressions",
            						lv_subExpressions_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.NotExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:1849:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==40) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1850:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,40,FOLLOW_35); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	    			
            	    // InternalGeneratorDSL.g:1854:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalGeneratorDSL.g:1855:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1855:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalGeneratorDSL.g:1856:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_37);
            	    lv_subExpressions_2_0=ruleNotExpressionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"subExpressions",
            	    							lv_subExpressions_2_0,
            	    							"de.evoal.languages.model.el.dsl.ExpressionLanguage.NotExpressionRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpressionRule"


    // $ANTLR start "entryRuleNotExpressionRule"
    // InternalGeneratorDSL.g:1878:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1878:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalGeneratorDSL.g:1879:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getNotExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotExpressionRule=ruleNotExpressionRule();

            state._fsp--;

             current =iv_ruleNotExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotExpressionRule"


    // $ANTLR start "ruleNotExpressionRule"
    // InternalGeneratorDSL.g:1885:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1891:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalGeneratorDSL.g:1892:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalGeneratorDSL.g:1892:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalGeneratorDSL.g:1893:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalGeneratorDSL.g:1893:3: ( (lv_negated_0_0= '!' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==41) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalGeneratorDSL.g:1894:4: (lv_negated_0_0= '!' )
                    {
                    // InternalGeneratorDSL.g:1894:4: (lv_negated_0_0= '!' )
                    // InternalGeneratorDSL.g:1895:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,41,FOLLOW_35); 

                    					newLeafNode(lv_negated_0_0, grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNotExpressionRuleRule());
                    					}
                    					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "!");
                    				

                    }


                    }
                    break;

            }

            // InternalGeneratorDSL.g:1907:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalGeneratorDSL.g:1908:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalGeneratorDSL.g:1908:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalGeneratorDSL.g:1909:5: lv_operand_1_0= ruleComparisonExpressionRule
            {

            					newCompositeNode(grammarAccess.getNotExpressionRuleAccess().getOperandComparisonExpressionRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_operand_1_0=ruleComparisonExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotExpressionRuleRule());
            					}
            					set(
            						current,
            						"operand",
            						lv_operand_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.ComparisonExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotExpressionRule"


    // $ANTLR start "entryRuleComparisonExpressionRule"
    // InternalGeneratorDSL.g:1930:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1930:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalGeneratorDSL.g:1931:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getComparisonExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparisonExpressionRule=ruleComparisonExpressionRule();

            state._fsp--;

             current =iv_ruleComparisonExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparisonExpressionRule"


    // $ANTLR start "ruleComparisonExpressionRule"
    // InternalGeneratorDSL.g:1937:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1943:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalGeneratorDSL.g:1944:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalGeneratorDSL.g:1944:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalGeneratorDSL.g:1945:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalGeneratorDSL.g:1945:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:1946:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:1946:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:1947:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
            lv_leftOperand_0_0=ruleAddOrSubtractExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonExpressionRuleRule());
            					}
            					set(
            						current,
            						"leftOperand",
            						lv_leftOperand_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.AddOrSubtractExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:1964:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=50 && LA25_0<=55)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1965:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1965:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalGeneratorDSL.g:1966:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {

            	    					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_38);
            	    lv_comparison_1_0=rulePartialComparisonExpressionRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComparisonExpressionRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"comparison",
            	    						lv_comparison_1_0,
            	    						"de.evoal.languages.model.el.dsl.ExpressionLanguage.PartialComparisonExpressionRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparisonExpressionRule"


    // $ANTLR start "entryRulePartialComparisonExpressionRule"
    // InternalGeneratorDSL.g:1987:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1987:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalGeneratorDSL.g:1988:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePartialComparisonExpressionRule=rulePartialComparisonExpressionRule();

            state._fsp--;

             current =iv_rulePartialComparisonExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePartialComparisonExpressionRule"


    // $ANTLR start "rulePartialComparisonExpressionRule"
    // InternalGeneratorDSL.g:1994:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2000:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalGeneratorDSL.g:2001:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalGeneratorDSL.g:2001:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalGeneratorDSL.g:2002:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalGeneratorDSL.g:2002:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalGeneratorDSL.g:2003:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalGeneratorDSL.g:2003:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalGeneratorDSL.g:2004:5: lv_operator_0_0= ruleComparisonOperatorRule
            {

            					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_35);
            lv_operator_0_0=ruleComparisonOperatorRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPartialComparisonExpressionRuleRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.ComparisonOperatorRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:2021:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:2022:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:2022:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:2023:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAddOrSubtractExpressionRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_subExpression_1_0=ruleAddOrSubtractExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPartialComparisonExpressionRuleRule());
            					}
            					set(
            						current,
            						"subExpression",
            						lv_subExpression_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.AddOrSubtractExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePartialComparisonExpressionRule"


    // $ANTLR start "entryRuleAddOrSubtractExpressionRule"
    // InternalGeneratorDSL.g:2044:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:2044:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalGeneratorDSL.g:2045:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddOrSubtractExpressionRule=ruleAddOrSubtractExpressionRule();

            state._fsp--;

             current =iv_ruleAddOrSubtractExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddOrSubtractExpressionRule"


    // $ANTLR start "ruleAddOrSubtractExpressionRule"
    // InternalGeneratorDSL.g:2051:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2057:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:2058:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:2058:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:2059:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:2059:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalGeneratorDSL.g:2060:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalGeneratorDSL.g:2060:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalGeneratorDSL.g:2061:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {

            					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_39);
            lv_leftOperand_0_0=ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAddOrSubtractExpressionRuleRule());
            					}
            					set(
            						current,
            						"leftOperand",
            						lv_leftOperand_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.MultiplyDivideModuloExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:2078:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=56 && LA26_0<=57)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalGeneratorDSL.g:2079:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalGeneratorDSL.g:2079:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalGeneratorDSL.g:2080:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:2080:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalGeneratorDSL.g:2081:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_35);
            	    lv_operators_1_0=ruleAddOrSubtractOperatorRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAddOrSubtractExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operators",
            	    							lv_operators_1_0,
            	    							"de.evoal.languages.model.el.dsl.ExpressionLanguage.AddOrSubtractOperatorRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalGeneratorDSL.g:2098:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalGeneratorDSL.g:2099:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:2099:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalGeneratorDSL.g:2100:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_39);
            	    lv_operands_2_0=ruleMultiplyDivideModuloExpressionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAddOrSubtractExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operands",
            	    							lv_operands_2_0,
            	    							"de.evoal.languages.model.el.dsl.ExpressionLanguage.MultiplyDivideModuloExpressionRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleMultiplyDivideModuloExpressionRule"
    // InternalGeneratorDSL.g:2122:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:2122:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalGeneratorDSL.g:2123:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplyDivideModuloExpressionRule=ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;

             current =iv_ruleMultiplyDivideModuloExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "ruleMultiplyDivideModuloExpressionRule"
    // InternalGeneratorDSL.g:2129:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2135:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:2136:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:2136:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:2137:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:2137:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalGeneratorDSL.g:2138:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalGeneratorDSL.g:2138:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalGeneratorDSL.g:2139:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {

            					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_40);
            lv_leftOperand_0_0=rulePowerOfExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiplyDivideModuloExpressionRuleRule());
            					}
            					set(
            						current,
            						"leftOperand",
            						lv_leftOperand_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.PowerOfExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:2156:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=58 && LA27_0<=60)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalGeneratorDSL.g:2157:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalGeneratorDSL.g:2157:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalGeneratorDSL.g:2158:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:2158:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalGeneratorDSL.g:2159:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_35);
            	    lv_operators_1_0=ruleMultiplyDivideModuloOperatorRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplyDivideModuloExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operators",
            	    							lv_operators_1_0,
            	    							"de.evoal.languages.model.el.dsl.ExpressionLanguage.MultiplyDivideModuloOperatorRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalGeneratorDSL.g:2176:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalGeneratorDSL.g:2177:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:2177:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalGeneratorDSL.g:2178:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
            	    lv_operands_2_0=rulePowerOfExpressionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplyDivideModuloExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operands",
            	    							lv_operands_2_0,
            	    							"de.evoal.languages.model.el.dsl.ExpressionLanguage.PowerOfExpressionRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "entryRulePowerOfExpressionRule"
    // InternalGeneratorDSL.g:2200:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:2200:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalGeneratorDSL.g:2201:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getPowerOfExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerOfExpressionRule=rulePowerOfExpressionRule();

            state._fsp--;

             current =iv_rulePowerOfExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerOfExpressionRule"


    // $ANTLR start "rulePowerOfExpressionRule"
    // InternalGeneratorDSL.g:2207:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2213:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalGeneratorDSL.g:2214:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalGeneratorDSL.g:2214:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalGeneratorDSL.g:2215:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalGeneratorDSL.g:2215:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:2216:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:2216:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:2217:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_41);
            lv_leftOperand_0_0=ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerOfExpressionRuleRule());
            					}
            					set(
            						current,
            						"leftOperand",
            						lv_leftOperand_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.UnaryAddOrSubtractExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:2234:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==42) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalGeneratorDSL.g:2235:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,42,FOLLOW_35); 

                    				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                    			
                    // InternalGeneratorDSL.g:2239:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalGeneratorDSL.g:2240:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalGeneratorDSL.g:2240:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalGeneratorDSL.g:2241:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
                    {

                    						newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandPowerOfExpressionRuleParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_rightOperand_2_0=rulePowerOfExpressionRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPowerOfExpressionRuleRule());
                    						}
                    						set(
                    							current,
                    							"rightOperand",
                    							lv_rightOperand_2_0,
                    							"de.evoal.languages.model.el.dsl.ExpressionLanguage.PowerOfExpressionRule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerOfExpressionRule"


    // $ANTLR start "entryRuleUnaryAddOrSubtractExpressionRule"
    // InternalGeneratorDSL.g:2263:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:2263:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalGeneratorDSL.g:2264:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
            {
             newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryAddOrSubtractExpressionRule=ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;

             current =iv_ruleUnaryAddOrSubtractExpressionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryAddOrSubtractExpressionRule"


    // $ANTLR start "ruleUnaryAddOrSubtractExpressionRule"
    // InternalGeneratorDSL.g:2270:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2276:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) )
            // InternalGeneratorDSL.g:2277:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            {
            // InternalGeneratorDSL.g:2277:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            // InternalGeneratorDSL.g:2278:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            {
            // InternalGeneratorDSL.g:2278:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=56 && LA29_0<=57)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalGeneratorDSL.g:2279:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:2279:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalGeneratorDSL.g:2280:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {

            	    					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_35);
            	    lv_operators_0_0=ruleAddOrSubtractOperatorRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operators",
            	    						lv_operators_0_0,
            	    						"de.evoal.languages.model.el.dsl.ExpressionLanguage.AddOrSubtractOperatorRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // InternalGeneratorDSL.g:2297:3: ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            // InternalGeneratorDSL.g:2298:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            {
            // InternalGeneratorDSL.g:2298:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            // InternalGeneratorDSL.g:2299:5: lv_subExpression_1_0= ruleLiteralOrReferenceRule
            {

            					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionLiteralOrReferenceRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_subExpression_1_0=ruleLiteralOrReferenceRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule());
            					}
            					set(
            						current,
            						"subExpression",
            						lv_subExpression_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.LiteralOrReferenceRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleLiteralOrReferenceRule"
    // InternalGeneratorDSL.g:2320:1: entryRuleLiteralOrReferenceRule returns [EObject current=null] : iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF ;
    public final EObject entryRuleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:2320:63: (iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF )
            // InternalGeneratorDSL.g:2321:2: iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralOrReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralOrReferenceRule=ruleLiteralOrReferenceRule();

            state._fsp--;

             current =iv_ruleLiteralOrReferenceRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralOrReferenceRule"


    // $ANTLR start "ruleLiteralOrReferenceRule"
    // InternalGeneratorDSL.g:2327:1: ruleLiteralOrReferenceRule returns [EObject current=null] : (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) ;
    public final EObject ruleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallRule_0 = null;

        EObject this_LiteralRule_1 = null;

        EObject this_ParanthesesRule_2 = null;

        EObject this_ValueReferenceRule_3 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2333:2: ( (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) )
            // InternalGeneratorDSL.g:2334:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            {
            // InternalGeneratorDSL.g:2334:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt30=1;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case 47:
            case 48:
                {
                alt30=2;
                }
                break;
            case 43:
                {
                alt30=3;
                }
                break;
            case 46:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalGeneratorDSL.g:2335:3: this_CallRule_0= ruleCallRule
                    {

                    			newCompositeNode(grammarAccess.getLiteralOrReferenceRuleAccess().getCallRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_CallRule_0=ruleCallRule();

                    state._fsp--;


                    			current = this_CallRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2344:3: this_LiteralRule_1= ruleLiteralRule
                    {

                    			newCompositeNode(grammarAccess.getLiteralOrReferenceRuleAccess().getLiteralRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralRule_1=ruleLiteralRule();

                    state._fsp--;


                    			current = this_LiteralRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:2353:3: this_ParanthesesRule_2= ruleParanthesesRule
                    {

                    			newCompositeNode(grammarAccess.getLiteralOrReferenceRuleAccess().getParanthesesRuleParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParanthesesRule_2=ruleParanthesesRule();

                    state._fsp--;


                    			current = this_ParanthesesRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:2362:3: this_ValueReferenceRule_3= ruleValueReferenceRule
                    {

                    			newCompositeNode(grammarAccess.getLiteralOrReferenceRuleAccess().getValueReferenceRuleParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValueReferenceRule_3=ruleValueReferenceRule();

                    state._fsp--;


                    			current = this_ValueReferenceRule_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralOrReferenceRule"


    // $ANTLR start "entryRuleParanthesesRule"
    // InternalGeneratorDSL.g:2374:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalGeneratorDSL.g:2374:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalGeneratorDSL.g:2375:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
            {
             newCompositeNode(grammarAccess.getParanthesesRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParanthesesRule=ruleParanthesesRule();

            state._fsp--;

             current =iv_ruleParanthesesRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParanthesesRule"


    // $ANTLR start "ruleParanthesesRule"
    // InternalGeneratorDSL.g:2381:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2387:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalGeneratorDSL.g:2388:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalGeneratorDSL.g:2388:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalGeneratorDSL.g:2389:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_35); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
            		
            // InternalGeneratorDSL.g:2393:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalGeneratorDSL.g:2394:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalGeneratorDSL.g:2394:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalGeneratorDSL.g:2395:5: lv_subExpression_1_0= ruleExpressionRule
            {

            					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_42);
            lv_subExpression_1_0=ruleExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParanthesesRuleRule());
            					}
            					set(
            						current,
            						"subExpression",
            						lv_subExpression_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.ExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,44,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParanthesesRule"


    // $ANTLR start "entryRuleCallRule"
    // InternalGeneratorDSL.g:2420:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalGeneratorDSL.g:2420:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalGeneratorDSL.g:2421:2: iv_ruleCallRule= ruleCallRule EOF
            {
             newCompositeNode(grammarAccess.getCallRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCallRule=ruleCallRule();

            state._fsp--;

             current =iv_ruleCallRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallRule"


    // $ANTLR start "ruleCallRule"
    // InternalGeneratorDSL.g:2427:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleCallRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_function_0_0 = null;

        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2433:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalGeneratorDSL.g:2434:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalGeneratorDSL.g:2434:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalGeneratorDSL.g:2435:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalGeneratorDSL.g:2435:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalGeneratorDSL.g:2436:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalGeneratorDSL.g:2436:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalGeneratorDSL.g:2437:5: lv_function_0_0= ruleFunctionNameRule
            {

            					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_43);
            lv_function_0_0=ruleFunctionNameRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCallRuleRule());
            					}
            					set(
            						current,
            						"function",
            						lv_function_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.FunctionNameRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,43,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
            		
            // InternalGeneratorDSL.g:2458:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_STRING||LA32_0==RULE_INT||LA32_0==41||LA32_0==43||(LA32_0>=45 && LA32_0<=48)||(LA32_0>=56 && LA32_0<=57)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalGeneratorDSL.g:2459:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalGeneratorDSL.g:2459:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalGeneratorDSL.g:2460:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalGeneratorDSL.g:2460:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalGeneratorDSL.g:2461:6: lv_parameters_2_0= ruleExpressionRule
                    {

                    						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_parameters_2_0=ruleExpressionRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCallRuleRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_2_0,
                    							"de.evoal.languages.model.el.dsl.ExpressionLanguage.ExpressionRule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGeneratorDSL.g:2478:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==25) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:2479:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_35); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalGeneratorDSL.g:2483:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalGeneratorDSL.g:2484:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalGeneratorDSL.g:2484:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalGeneratorDSL.g:2485:7: lv_parameters_4_0= ruleExpressionRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_45);
                    	    lv_parameters_4_0=ruleExpressionRule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCallRuleRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_4_0,
                    	    								"de.evoal.languages.model.el.dsl.ExpressionLanguage.ExpressionRule");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,44,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallRule"


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalGeneratorDSL.g:2512:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalGeneratorDSL.g:2512:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalGeneratorDSL.g:2513:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
            {
             newCompositeNode(grammarAccess.getFunctionNameRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionNameRule=ruleFunctionNameRule();

            state._fsp--;

             current =iv_ruleFunctionNameRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionNameRule"


    // $ANTLR start "ruleFunctionNameRule"
    // InternalGeneratorDSL.g:2519:1: ruleFunctionNameRule returns [EObject current=null] : ( () otherlv_1= 'call' ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2525:2: ( ( () otherlv_1= 'call' ) )
            // InternalGeneratorDSL.g:2526:2: ( () otherlv_1= 'call' )
            {
            // InternalGeneratorDSL.g:2526:2: ( () otherlv_1= 'call' )
            // InternalGeneratorDSL.g:2527:3: () otherlv_1= 'call'
            {
            // InternalGeneratorDSL.g:2527:3: ()
            // InternalGeneratorDSL.g:2528:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFunctionNameRuleAccess().getFunctionNameAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,45,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFunctionNameRuleAccess().getCallKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionNameRule"


    // $ANTLR start "entryRuleValueReferenceRule"
    // InternalGeneratorDSL.g:2542:1: entryRuleValueReferenceRule returns [EObject current=null] : iv_ruleValueReferenceRule= ruleValueReferenceRule EOF ;
    public final EObject entryRuleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:2542:59: (iv_ruleValueReferenceRule= ruleValueReferenceRule EOF )
            // InternalGeneratorDSL.g:2543:2: iv_ruleValueReferenceRule= ruleValueReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getValueReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueReferenceRule=ruleValueReferenceRule();

            state._fsp--;

             current =iv_ruleValueReferenceRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueReferenceRule"


    // $ANTLR start "ruleValueReferenceRule"
    // InternalGeneratorDSL.g:2549:1: ruleValueReferenceRule returns [EObject current=null] : ( () otherlv_1= 'value' ) ;
    public final EObject ruleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2555:2: ( ( () otherlv_1= 'value' ) )
            // InternalGeneratorDSL.g:2556:2: ( () otherlv_1= 'value' )
            {
            // InternalGeneratorDSL.g:2556:2: ( () otherlv_1= 'value' )
            // InternalGeneratorDSL.g:2557:3: () otherlv_1= 'value'
            {
            // InternalGeneratorDSL.g:2557:3: ()
            // InternalGeneratorDSL.g:2558:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,46,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getValueReferenceRuleAccess().getValueKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueReferenceRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalGeneratorDSL.g:2572:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2572:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalGeneratorDSL.g:2573:2: iv_ruleLiteralRule= ruleLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralRule=ruleLiteralRule();

            state._fsp--;

             current =iv_ruleLiteralRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralRule"


    // $ANTLR start "ruleLiteralRule"
    // InternalGeneratorDSL.g:2579:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2585:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) )
            // InternalGeneratorDSL.g:2586:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            {
            // InternalGeneratorDSL.g:2586:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            int alt33=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt33=1;
                }
                break;
            case RULE_STRING:
                {
                alt33=2;
                }
                break;
            case 47:
            case 48:
                {
                alt33=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalGeneratorDSL.g:2587:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {

                    			newCompositeNode(grammarAccess.getLiteralRuleAccess().getNumberLiteralRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();

                    state._fsp--;


                    			current = this_NumberLiteralRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2596:3: this_StringLiteralRule_1= ruleStringLiteralRule
                    {

                    			newCompositeNode(grammarAccess.getLiteralRuleAccess().getStringLiteralRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringLiteralRule_1=ruleStringLiteralRule();

                    state._fsp--;


                    			current = this_StringLiteralRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:2605:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {

                    			newCompositeNode(grammarAccess.getLiteralRuleAccess().getBooleanLiteralRuleParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();

                    state._fsp--;


                    			current = this_BooleanLiteralRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralRule"


    // $ANTLR start "entryRuleNumberLiteralRule"
    // InternalGeneratorDSL.g:2617:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2617:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalGeneratorDSL.g:2618:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();

            state._fsp--;

             current =iv_ruleNumberLiteralRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteralRule"


    // $ANTLR start "ruleNumberLiteralRule"
    // InternalGeneratorDSL.g:2624:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2630:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalGeneratorDSL.g:2631:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalGeneratorDSL.g:2631:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_INT) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==49) ) {
                    alt34=1;
                }
                else if ( (LA34_1==EOF||LA34_1==13||LA34_1==23||LA34_1==25||(LA34_1>=38 && LA34_1<=40)||LA34_1==42||LA34_1==44||(LA34_1>=50 && LA34_1<=60)) ) {
                    alt34=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalGeneratorDSL.g:2632:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
                    {

                    			newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getDoubleLiteralRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DoubleLiteralRule_0=ruleDoubleLiteralRule();

                    state._fsp--;


                    			current = this_DoubleLiteralRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2641:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
                    {

                    			newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerLiteralRule_1=ruleIntegerLiteralRule();

                    state._fsp--;


                    			current = this_IntegerLiteralRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteralRule"


    // $ANTLR start "entryRuleDoubleLiteralRule"
    // InternalGeneratorDSL.g:2653:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2653:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalGeneratorDSL.g:2654:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getDoubleLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDoubleLiteralRule=ruleDoubleLiteralRule();

            state._fsp--;

             current =iv_ruleDoubleLiteralRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleLiteralRule"


    // $ANTLR start "ruleDoubleLiteralRule"
    // InternalGeneratorDSL.g:2660:1: ruleDoubleLiteralRule returns [EObject current=null] : ( (lv_value_0_0= ruleDOUBLE ) ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2666:2: ( ( (lv_value_0_0= ruleDOUBLE ) ) )
            // InternalGeneratorDSL.g:2667:2: ( (lv_value_0_0= ruleDOUBLE ) )
            {
            // InternalGeneratorDSL.g:2667:2: ( (lv_value_0_0= ruleDOUBLE ) )
            // InternalGeneratorDSL.g:2668:3: (lv_value_0_0= ruleDOUBLE )
            {
            // InternalGeneratorDSL.g:2668:3: (lv_value_0_0= ruleDOUBLE )
            // InternalGeneratorDSL.g:2669:4: lv_value_0_0= ruleDOUBLE
            {

            				newCompositeNode(grammarAccess.getDoubleLiteralRuleAccess().getValueDOUBLEParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDOUBLE();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getDoubleLiteralRuleRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"de.evoal.languages.model.el.dsl.ExpressionLanguage.DOUBLE");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoubleLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // InternalGeneratorDSL.g:2689:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2689:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalGeneratorDSL.g:2690:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getIntegerLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();

            state._fsp--;

             current =iv_ruleIntegerLiteralRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerLiteralRule"


    // $ANTLR start "ruleIntegerLiteralRule"
    // InternalGeneratorDSL.g:2696:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2702:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalGeneratorDSL.g:2703:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalGeneratorDSL.g:2703:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalGeneratorDSL.g:2704:3: (lv_value_0_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:2704:3: (lv_value_0_0= RULE_INT )
            // InternalGeneratorDSL.g:2705:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getIntegerLiteralRuleAccess().getValueINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIntegerLiteralRuleRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerLiteralRule"


    // $ANTLR start "entryRuleStringLiteralRule"
    // InternalGeneratorDSL.g:2724:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2724:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalGeneratorDSL.g:2725:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();

            state._fsp--;

             current =iv_ruleStringLiteralRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteralRule"


    // $ANTLR start "ruleStringLiteralRule"
    // InternalGeneratorDSL.g:2731:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2737:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalGeneratorDSL.g:2738:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalGeneratorDSL.g:2738:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:2739:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:2739:3: (lv_value_0_0= RULE_STRING )
            // InternalGeneratorDSL.g:2740:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringLiteralRuleRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"de.evoal.languages.model.el.dsl.ExpressionLanguage.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteralRule"


    // $ANTLR start "entryRuleBooleanLiteralRule"
    // InternalGeneratorDSL.g:2759:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2759:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalGeneratorDSL.g:2760:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();

            state._fsp--;

             current =iv_ruleBooleanLiteralRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteralRule"


    // $ANTLR start "ruleBooleanLiteralRule"
    // InternalGeneratorDSL.g:2766:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2772:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalGeneratorDSL.g:2773:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalGeneratorDSL.g:2773:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalGeneratorDSL.g:2774:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalGeneratorDSL.g:2774:3: ()
            // InternalGeneratorDSL.g:2775:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalGeneratorDSL.g:2781:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==47) ) {
                alt35=1;
            }
            else if ( (LA35_0==48) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalGeneratorDSL.g:2782:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalGeneratorDSL.g:2782:4: ( (lv_value_1_0= 'true' ) )
                    // InternalGeneratorDSL.g:2783:5: (lv_value_1_0= 'true' )
                    {
                    // InternalGeneratorDSL.g:2783:5: (lv_value_1_0= 'true' )
                    // InternalGeneratorDSL.g:2784:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,47,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBooleanLiteralRuleRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2797:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,48,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralRuleAccess().getFalseKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteralRule"


    // $ANTLR start "entryRuleStringOrId"
    // InternalGeneratorDSL.g:2806:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalGeneratorDSL.g:2806:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalGeneratorDSL.g:2807:2: iv_ruleStringOrId= ruleStringOrId EOF
            {
             newCompositeNode(grammarAccess.getStringOrIdRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringOrId=ruleStringOrId();

            state._fsp--;

             current =iv_ruleStringOrId.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringOrId"


    // $ANTLR start "ruleStringOrId"
    // InternalGeneratorDSL.g:2813:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2819:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalGeneratorDSL.g:2820:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalGeneratorDSL.g:2820:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_QUOTED_ID) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_ID) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalGeneratorDSL.g:2821:3: this_QUOTED_ID_0= RULE_QUOTED_ID
                    {
                    this_QUOTED_ID_0=(Token)match(input,RULE_QUOTED_ID,FOLLOW_2); 

                    			current.merge(this_QUOTED_ID_0);
                    		

                    			newLeafNode(this_QUOTED_ID_0, grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2829:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getStringOrIdAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringOrId"


    // $ANTLR start "entryRuleDOUBLE"
    // InternalGeneratorDSL.g:2840:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // InternalGeneratorDSL.g:2840:46: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // InternalGeneratorDSL.g:2841:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
             newCompositeNode(grammarAccess.getDOUBLERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;

             current =iv_ruleDOUBLE.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // InternalGeneratorDSL.g:2847:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2853:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalGeneratorDSL.g:2854:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalGeneratorDSL.g:2854:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalGeneratorDSL.g:2855:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_46); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,49,FOLLOW_16); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDOUBLEAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalGeneratorDSL.g:2878:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
    public final Enumerator ruleComparisonOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2884:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalGeneratorDSL.g:2885:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalGeneratorDSL.g:2885:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt37=6;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt37=1;
                }
                break;
            case 51:
                {
                alt37=2;
                }
                break;
            case 52:
                {
                alt37=3;
                }
                break;
            case 53:
                {
                alt37=4;
                }
                break;
            case 54:
                {
                alt37=5;
                }
                break;
            case 55:
                {
                alt37=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalGeneratorDSL.g:2886:3: (enumLiteral_0= '>=' )
                    {
                    // InternalGeneratorDSL.g:2886:3: (enumLiteral_0= '>=' )
                    // InternalGeneratorDSL.g:2887:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2894:3: (enumLiteral_1= '>' )
                    {
                    // InternalGeneratorDSL.g:2894:3: (enumLiteral_1= '>' )
                    // InternalGeneratorDSL.g:2895:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:2902:3: (enumLiteral_2= '=' )
                    {
                    // InternalGeneratorDSL.g:2902:3: (enumLiteral_2= '=' )
                    // InternalGeneratorDSL.g:2903:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:2910:3: (enumLiteral_3= '!=' )
                    {
                    // InternalGeneratorDSL.g:2910:3: (enumLiteral_3= '!=' )
                    // InternalGeneratorDSL.g:2911:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGeneratorDSL.g:2918:3: (enumLiteral_4= '<' )
                    {
                    // InternalGeneratorDSL.g:2918:3: (enumLiteral_4= '<' )
                    // InternalGeneratorDSL.g:2919:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalGeneratorDSL.g:2926:3: (enumLiteral_5= '<=' )
                    {
                    // InternalGeneratorDSL.g:2926:3: (enumLiteral_5= '<=' )
                    // InternalGeneratorDSL.g:2927:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparisonOperatorRule"


    // $ANTLR start "ruleAddOrSubtractOperatorRule"
    // InternalGeneratorDSL.g:2937:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2943:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalGeneratorDSL.g:2944:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalGeneratorDSL.g:2944:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==56) ) {
                alt38=1;
            }
            else if ( (LA38_0==57) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalGeneratorDSL.g:2945:3: (enumLiteral_0= '+' )
                    {
                    // InternalGeneratorDSL.g:2945:3: (enumLiteral_0= '+' )
                    // InternalGeneratorDSL.g:2946:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2953:3: (enumLiteral_1= '-' )
                    {
                    // InternalGeneratorDSL.g:2953:3: (enumLiteral_1= '-' )
                    // InternalGeneratorDSL.g:2954:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddOrSubtractOperatorRule"


    // $ANTLR start "ruleMultiplyDivideModuloOperatorRule"
    // InternalGeneratorDSL.g:2964:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2970:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalGeneratorDSL.g:2971:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalGeneratorDSL.g:2971:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt39=1;
                }
                break;
            case 59:
                {
                alt39=2;
                }
                break;
            case 60:
                {
                alt39=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalGeneratorDSL.g:2972:3: (enumLiteral_0= '*' )
                    {
                    // InternalGeneratorDSL.g:2972:3: (enumLiteral_0= '*' )
                    // InternalGeneratorDSL.g:2973:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2980:3: (enumLiteral_1= '/' )
                    {
                    // InternalGeneratorDSL.g:2980:3: (enumLiteral_1= '/' )
                    // InternalGeneratorDSL.g:2981:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:2988:3: (enumLiteral_2= '%' )
                    {
                    // InternalGeneratorDSL.g:2988:3: (enumLiteral_2= '%' )
                    // InternalGeneratorDSL.g:2989:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplyDivideModuloOperatorRule"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000008035002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000008034002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000008024002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000008020002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000005200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008120000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000200004000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200004020L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000200014020L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00000008000000B0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00018020002000F0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0001802000A000F0L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0301EA20002000F0L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00FC000000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x1C00000000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0301FA20002000F0L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000100002000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0002000000000000L});

}
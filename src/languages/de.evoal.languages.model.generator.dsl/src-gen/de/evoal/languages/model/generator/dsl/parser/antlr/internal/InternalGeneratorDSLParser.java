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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_QUOTED_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'use'", "';'", "'pipeline'", "'['", "','", "']'", "'for'", "'in'", "'loop'", "'end'", "'to'", "'pipelines'", "'write'", "'with'", "'samples'", "'from'", "'executing'", "'s;'", "'{'", "'}'", "':='", "'data'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'('", "')'", "'call'", "'value'", "'true'", "'false'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
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
    // InternalGeneratorDSL.g:72:1: ruleConfigurationRule returns [EObject current=null] : ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_pipelines_1_0= rulePipelineDefinitionRule ) )* ( (lv_statements_2_0= ruleStatementRule ) )* ) ;
    public final EObject ruleConfigurationRule() throws RecognitionException {
        EObject current = null;

        EObject lv_uses_0_0 = null;

        EObject lv_pipelines_1_0 = null;

        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:78:2: ( ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_pipelines_1_0= rulePipelineDefinitionRule ) )* ( (lv_statements_2_0= ruleStatementRule ) )* ) )
            // InternalGeneratorDSL.g:79:2: ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_pipelines_1_0= rulePipelineDefinitionRule ) )* ( (lv_statements_2_0= ruleStatementRule ) )* )
            {
            // InternalGeneratorDSL.g:79:2: ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_pipelines_1_0= rulePipelineDefinitionRule ) )* ( (lv_statements_2_0= ruleStatementRule ) )* )
            // InternalGeneratorDSL.g:80:3: ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_pipelines_1_0= rulePipelineDefinitionRule ) )* ( (lv_statements_2_0= ruleStatementRule ) )*
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

            // InternalGeneratorDSL.g:99:3: ( (lv_pipelines_1_0= rulePipelineDefinitionRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGeneratorDSL.g:100:4: (lv_pipelines_1_0= rulePipelineDefinitionRule )
            	    {
            	    // InternalGeneratorDSL.g:100:4: (lv_pipelines_1_0= rulePipelineDefinitionRule )
            	    // InternalGeneratorDSL.g:101:5: lv_pipelines_1_0= rulePipelineDefinitionRule
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationRuleAccess().getPipelinesPipelineDefinitionRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_pipelines_1_0=rulePipelineDefinitionRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"pipelines",
            	    						lv_pipelines_1_0,
            	    						"de.evoal.languages.model.generator.dsl.GeneratorDSL.PipelineDefinitionRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalGeneratorDSL.g:118:3: ( (lv_statements_2_0= ruleStatementRule ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18||LA3_0==24) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalGeneratorDSL.g:119:4: (lv_statements_2_0= ruleStatementRule )
            	    {
            	    // InternalGeneratorDSL.g:119:4: (lv_statements_2_0= ruleStatementRule )
            	    // InternalGeneratorDSL.g:120:5: lv_statements_2_0= ruleStatementRule
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationRuleAccess().getStatementsStatementRuleParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_statements_2_0=ruleStatementRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_2_0,
            	    						"de.evoal.languages.model.generator.dsl.GeneratorDSL.StatementRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // InternalGeneratorDSL.g:141:1: entryRuleUseRule returns [EObject current=null] : iv_ruleUseRule= ruleUseRule EOF ;
    public final EObject entryRuleUseRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseRule = null;


        try {
            // InternalGeneratorDSL.g:141:48: (iv_ruleUseRule= ruleUseRule EOF )
            // InternalGeneratorDSL.g:142:2: iv_ruleUseRule= ruleUseRule EOF
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
    // InternalGeneratorDSL.g:148:1: ruleUseRule returns [EObject current=null] : (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) ;
    public final EObject ruleUseRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:154:2: ( (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) )
            // InternalGeneratorDSL.g:155:2: (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            {
            // InternalGeneratorDSL.g:155:2: (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            // InternalGeneratorDSL.g:156:3: otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getUseRuleAccess().getUseKeyword_0());
            		
            // InternalGeneratorDSL.g:160:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:161:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:161:4: (lv_importURI_1_0= RULE_STRING )
            // InternalGeneratorDSL.g:162:5: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

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


    // $ANTLR start "entryRulePipelineDefinitionRule"
    // InternalGeneratorDSL.g:186:1: entryRulePipelineDefinitionRule returns [EObject current=null] : iv_rulePipelineDefinitionRule= rulePipelineDefinitionRule EOF ;
    public final EObject entryRulePipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineDefinitionRule = null;


        try {
            // InternalGeneratorDSL.g:186:63: (iv_rulePipelineDefinitionRule= rulePipelineDefinitionRule EOF )
            // InternalGeneratorDSL.g:187:2: iv_rulePipelineDefinitionRule= rulePipelineDefinitionRule EOF
            {
             newCompositeNode(grammarAccess.getPipelineDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineDefinitionRule=rulePipelineDefinitionRule();

            state._fsp--;

             current =iv_rulePipelineDefinitionRule; 
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
    // $ANTLR end "entryRulePipelineDefinitionRule"


    // $ANTLR start "rulePipelineDefinitionRule"
    // InternalGeneratorDSL.g:193:1: rulePipelineDefinitionRule returns [EObject current=null] : (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( ( (lv_definitions_3_0= ruleInstanceRule ) ) (otherlv_4= ',' ( (lv_definitions_5_0= ruleInstanceRule ) ) )* )? otherlv_6= ']' ) ;
    public final EObject rulePipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_definitions_3_0 = null;

        EObject lv_definitions_5_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:199:2: ( (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( ( (lv_definitions_3_0= ruleInstanceRule ) ) (otherlv_4= ',' ( (lv_definitions_5_0= ruleInstanceRule ) ) )* )? otherlv_6= ']' ) )
            // InternalGeneratorDSL.g:200:2: (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( ( (lv_definitions_3_0= ruleInstanceRule ) ) (otherlv_4= ',' ( (lv_definitions_5_0= ruleInstanceRule ) ) )* )? otherlv_6= ']' )
            {
            // InternalGeneratorDSL.g:200:2: (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( ( (lv_definitions_3_0= ruleInstanceRule ) ) (otherlv_4= ',' ( (lv_definitions_5_0= ruleInstanceRule ) ) )* )? otherlv_6= ']' )
            // InternalGeneratorDSL.g:201:3: otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( ( (lv_definitions_3_0= ruleInstanceRule ) ) (otherlv_4= ',' ( (lv_definitions_5_0= ruleInstanceRule ) ) )* )? otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getPipelineDefinitionRuleAccess().getPipelineKeyword_0());
            		
            // InternalGeneratorDSL.g:205:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalGeneratorDSL.g:206:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalGeneratorDSL.g:206:4: (lv_name_1_0= ruleStringOrId )
            // InternalGeneratorDSL.g:207:5: lv_name_1_0= ruleStringOrId
            {

            					newCompositeNode(grammarAccess.getPipelineDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPipelineDefinitionRuleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.StringOrId");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getPipelineDefinitionRuleAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalGeneratorDSL.g:228:3: ( ( (lv_definitions_3_0= ruleInstanceRule ) ) (otherlv_4= ',' ( (lv_definitions_5_0= ruleInstanceRule ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID||LA5_0==RULE_QUOTED_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalGeneratorDSL.g:229:4: ( (lv_definitions_3_0= ruleInstanceRule ) ) (otherlv_4= ',' ( (lv_definitions_5_0= ruleInstanceRule ) ) )*
                    {
                    // InternalGeneratorDSL.g:229:4: ( (lv_definitions_3_0= ruleInstanceRule ) )
                    // InternalGeneratorDSL.g:230:5: (lv_definitions_3_0= ruleInstanceRule )
                    {
                    // InternalGeneratorDSL.g:230:5: (lv_definitions_3_0= ruleInstanceRule )
                    // InternalGeneratorDSL.g:231:6: lv_definitions_3_0= ruleInstanceRule
                    {

                    						newCompositeNode(grammarAccess.getPipelineDefinitionRuleAccess().getDefinitionsInstanceRuleParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_definitions_3_0=ruleInstanceRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineDefinitionRuleRule());
                    						}
                    						add(
                    							current,
                    							"definitions",
                    							lv_definitions_3_0,
                    							"de.evoal.languages.model.instance.dsl.InstanceLanguage.InstanceRule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGeneratorDSL.g:248:4: (otherlv_4= ',' ( (lv_definitions_5_0= ruleInstanceRule ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:249:5: otherlv_4= ',' ( (lv_definitions_5_0= ruleInstanceRule ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_8); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPipelineDefinitionRuleAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalGeneratorDSL.g:253:5: ( (lv_definitions_5_0= ruleInstanceRule ) )
                    	    // InternalGeneratorDSL.g:254:6: (lv_definitions_5_0= ruleInstanceRule )
                    	    {
                    	    // InternalGeneratorDSL.g:254:6: (lv_definitions_5_0= ruleInstanceRule )
                    	    // InternalGeneratorDSL.g:255:7: lv_definitions_5_0= ruleInstanceRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getPipelineDefinitionRuleAccess().getDefinitionsInstanceRuleParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_definitions_5_0=ruleInstanceRule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPipelineDefinitionRuleRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"definitions",
                    	    								lv_definitions_5_0,
                    	    								"de.evoal.languages.model.instance.dsl.InstanceLanguage.InstanceRule");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getPipelineDefinitionRuleAccess().getRightSquareBracketKeyword_4());
            		

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
    // $ANTLR end "rulePipelineDefinitionRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalGeneratorDSL.g:282:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalGeneratorDSL.g:282:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalGeneratorDSL.g:283:2: iv_ruleStatementRule= ruleStatementRule EOF
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
    // InternalGeneratorDSL.g:289:1: ruleStatementRule returns [EObject current=null] : (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatementRule_0 = null;

        EObject this_ApplyStatementRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:295:2: ( (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule ) )
            // InternalGeneratorDSL.g:296:2: (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule )
            {
            // InternalGeneratorDSL.g:296:2: (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            else if ( (LA6_0==24) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalGeneratorDSL.g:297:3: this_ForStatementRule_0= ruleForStatementRule
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
                    // InternalGeneratorDSL.g:306:3: this_ApplyStatementRule_1= ruleApplyStatementRule
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
    // InternalGeneratorDSL.g:318:1: entryRuleForStatementRule returns [EObject current=null] : iv_ruleForStatementRule= ruleForStatementRule EOF ;
    public final EObject entryRuleForStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatementRule = null;


        try {
            // InternalGeneratorDSL.g:318:57: (iv_ruleForStatementRule= ruleForStatementRule EOF )
            // InternalGeneratorDSL.g:319:2: iv_ruleForStatementRule= ruleForStatementRule EOF
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
    // InternalGeneratorDSL.g:325:1: ruleForStatementRule returns [EObject current=null] : (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' ) ;
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
            // InternalGeneratorDSL.g:331:2: ( (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' ) )
            // InternalGeneratorDSL.g:332:2: (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' )
            {
            // InternalGeneratorDSL.g:332:2: (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' )
            // InternalGeneratorDSL.g:333:3: otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementRuleAccess().getForKeyword_0());
            		
            // InternalGeneratorDSL.g:337:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGeneratorDSL.g:338:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGeneratorDSL.g:338:4: (lv_name_1_0= RULE_ID )
            // InternalGeneratorDSL.g:339:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_2=(Token)match(input,19,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getForStatementRuleAccess().getInKeyword_2());
            		
            // InternalGeneratorDSL.g:359:3: ( (lv_range_3_0= ruleRangeRule ) )
            // InternalGeneratorDSL.g:360:4: (lv_range_3_0= ruleRangeRule )
            {
            // InternalGeneratorDSL.g:360:4: (lv_range_3_0= ruleRangeRule )
            // InternalGeneratorDSL.g:361:5: lv_range_3_0= ruleRangeRule
            {

            					newCompositeNode(grammarAccess.getForStatementRuleAccess().getRangeRangeRuleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_15);
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

            otherlv_4=(Token)match(input,20,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getForStatementRuleAccess().getLoopKeyword_4());
            		
            // InternalGeneratorDSL.g:382:3: ( (lv_statements_5_0= ruleStatementRule ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18||LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalGeneratorDSL.g:383:4: (lv_statements_5_0= ruleStatementRule )
            	    {
            	    // InternalGeneratorDSL.g:383:4: (lv_statements_5_0= ruleStatementRule )
            	    // InternalGeneratorDSL.g:384:5: lv_statements_5_0= ruleStatementRule
            	    {

            	    					newCompositeNode(grammarAccess.getForStatementRuleAccess().getStatementsStatementRuleParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop7;
                }
            } while (true);

            otherlv_6=(Token)match(input,21,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:409:1: entryRuleRangeRule returns [EObject current=null] : iv_ruleRangeRule= ruleRangeRule EOF ;
    public final EObject entryRuleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeRule = null;


        try {
            // InternalGeneratorDSL.g:409:50: (iv_ruleRangeRule= ruleRangeRule EOF )
            // InternalGeneratorDSL.g:410:2: iv_ruleRangeRule= ruleRangeRule EOF
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
    // InternalGeneratorDSL.g:416:1: ruleRangeRule returns [EObject current=null] : (this_PipelineArrayRule_0= rulePipelineArrayRule | this_CounterRangeRule_1= ruleCounterRangeRule ) ;
    public final EObject ruleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineArrayRule_0 = null;

        EObject this_CounterRangeRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:422:2: ( (this_PipelineArrayRule_0= rulePipelineArrayRule | this_CounterRangeRule_1= ruleCounterRangeRule ) )
            // InternalGeneratorDSL.g:423:2: (this_PipelineArrayRule_0= rulePipelineArrayRule | this_CounterRangeRule_1= ruleCounterRangeRule )
            {
            // InternalGeneratorDSL.g:423:2: (this_PipelineArrayRule_0= rulePipelineArrayRule | this_CounterRangeRule_1= ruleCounterRangeRule )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            else if ( (LA8_0==15) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalGeneratorDSL.g:424:3: this_PipelineArrayRule_0= rulePipelineArrayRule
                    {

                    			newCompositeNode(grammarAccess.getRangeRuleAccess().getPipelineArrayRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineArrayRule_0=rulePipelineArrayRule();

                    state._fsp--;


                    			current = this_PipelineArrayRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:433:3: this_CounterRangeRule_1= ruleCounterRangeRule
                    {

                    			newCompositeNode(grammarAccess.getRangeRuleAccess().getCounterRangeRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CounterRangeRule_1=ruleCounterRangeRule();

                    state._fsp--;


                    			current = this_CounterRangeRule_1;
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
    // InternalGeneratorDSL.g:445:1: entryRuleCounterRangeRule returns [EObject current=null] : iv_ruleCounterRangeRule= ruleCounterRangeRule EOF ;
    public final EObject entryRuleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCounterRangeRule = null;


        try {
            // InternalGeneratorDSL.g:445:57: (iv_ruleCounterRangeRule= ruleCounterRangeRule EOF )
            // InternalGeneratorDSL.g:446:2: iv_ruleCounterRangeRule= ruleCounterRangeRule EOF
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
    // InternalGeneratorDSL.g:452:1: ruleCounterRangeRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' ) ;
    public final EObject ruleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_start_1_0=null;
        Token otherlv_2=null;
        Token lv_end_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:458:2: ( (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' ) )
            // InternalGeneratorDSL.g:459:2: (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' )
            {
            // InternalGeneratorDSL.g:459:2: (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' )
            // InternalGeneratorDSL.g:460:3: otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getCounterRangeRuleAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalGeneratorDSL.g:464:3: ( (lv_start_1_0= RULE_INT ) )
            // InternalGeneratorDSL.g:465:4: (lv_start_1_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:465:4: (lv_start_1_0= RULE_INT )
            // InternalGeneratorDSL.g:466:5: lv_start_1_0= RULE_INT
            {
            lv_start_1_0=(Token)match(input,RULE_INT,FOLLOW_18); 

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

            otherlv_2=(Token)match(input,22,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getCounterRangeRuleAccess().getToKeyword_2());
            		
            // InternalGeneratorDSL.g:486:3: ( (lv_end_3_0= RULE_INT ) )
            // InternalGeneratorDSL.g:487:4: (lv_end_3_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:487:4: (lv_end_3_0= RULE_INT )
            // InternalGeneratorDSL.g:488:5: lv_end_3_0= RULE_INT
            {
            lv_end_3_0=(Token)match(input,RULE_INT,FOLLOW_19); 

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

            otherlv_4=(Token)match(input,17,FOLLOW_2); 

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


    // $ANTLR start "entryRulePipelineArrayRule"
    // InternalGeneratorDSL.g:512:1: entryRulePipelineArrayRule returns [EObject current=null] : iv_rulePipelineArrayRule= rulePipelineArrayRule EOF ;
    public final EObject entryRulePipelineArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineArrayRule = null;


        try {
            // InternalGeneratorDSL.g:512:58: (iv_rulePipelineArrayRule= rulePipelineArrayRule EOF )
            // InternalGeneratorDSL.g:513:2: iv_rulePipelineArrayRule= rulePipelineArrayRule EOF
            {
             newCompositeNode(grammarAccess.getPipelineArrayRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineArrayRule=rulePipelineArrayRule();

            state._fsp--;

             current =iv_rulePipelineArrayRule; 
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
    // $ANTLR end "entryRulePipelineArrayRule"


    // $ANTLR start "rulePipelineArrayRule"
    // InternalGeneratorDSL.g:519:1: rulePipelineArrayRule returns [EObject current=null] : ( () otherlv_1= 'pipelines' (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )? ) ;
    public final EObject rulePipelineArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_references_3_0 = null;

        EObject lv_references_5_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:525:2: ( ( () otherlv_1= 'pipelines' (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )? ) )
            // InternalGeneratorDSL.g:526:2: ( () otherlv_1= 'pipelines' (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )? )
            {
            // InternalGeneratorDSL.g:526:2: ( () otherlv_1= 'pipelines' (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )? )
            // InternalGeneratorDSL.g:527:3: () otherlv_1= 'pipelines' (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )?
            {
            // InternalGeneratorDSL.g:527:3: ()
            // InternalGeneratorDSL.g:528:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPipelineArrayRuleAccess().getPipelineArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getPipelineArrayRuleAccess().getPipelinesKeyword_1());
            		
            // InternalGeneratorDSL.g:538:3: (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalGeneratorDSL.g:539:4: otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_2, grammarAccess.getPipelineArrayRuleAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalGeneratorDSL.g:543:4: ( (lv_references_3_0= rulePipelineReferenceRule ) )
                    // InternalGeneratorDSL.g:544:5: (lv_references_3_0= rulePipelineReferenceRule )
                    {
                    // InternalGeneratorDSL.g:544:5: (lv_references_3_0= rulePipelineReferenceRule )
                    // InternalGeneratorDSL.g:545:6: lv_references_3_0= rulePipelineReferenceRule
                    {

                    						newCompositeNode(grammarAccess.getPipelineArrayRuleAccess().getReferencesPipelineReferenceRuleParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_references_3_0=rulePipelineReferenceRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineArrayRuleRule());
                    						}
                    						add(
                    							current,
                    							"references",
                    							lv_references_3_0,
                    							"de.evoal.languages.model.generator.dsl.GeneratorDSL.PipelineReferenceRule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGeneratorDSL.g:562:4: (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==16) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:563:5: otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_8); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPipelineArrayRuleAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalGeneratorDSL.g:567:5: ( (lv_references_5_0= rulePipelineReferenceRule ) )
                    	    // InternalGeneratorDSL.g:568:6: (lv_references_5_0= rulePipelineReferenceRule )
                    	    {
                    	    // InternalGeneratorDSL.g:568:6: (lv_references_5_0= rulePipelineReferenceRule )
                    	    // InternalGeneratorDSL.g:569:7: lv_references_5_0= rulePipelineReferenceRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getPipelineArrayRuleAccess().getReferencesPipelineReferenceRuleParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_references_5_0=rulePipelineReferenceRule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPipelineArrayRuleRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"references",
                    	    								lv_references_5_0,
                    	    								"de.evoal.languages.model.generator.dsl.GeneratorDSL.PipelineReferenceRule");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getPipelineArrayRuleAccess().getRightSquareBracketKeyword_2_3());
                    			

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
    // $ANTLR end "rulePipelineArrayRule"


    // $ANTLR start "entryRulePipelineReferenceRule"
    // InternalGeneratorDSL.g:596:1: entryRulePipelineReferenceRule returns [EObject current=null] : iv_rulePipelineReferenceRule= rulePipelineReferenceRule EOF ;
    public final EObject entryRulePipelineReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:596:62: (iv_rulePipelineReferenceRule= rulePipelineReferenceRule EOF )
            // InternalGeneratorDSL.g:597:2: iv_rulePipelineReferenceRule= rulePipelineReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getPipelineReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineReferenceRule=rulePipelineReferenceRule();

            state._fsp--;

             current =iv_rulePipelineReferenceRule; 
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
    // $ANTLR end "entryRulePipelineReferenceRule"


    // $ANTLR start "rulePipelineReferenceRule"
    // InternalGeneratorDSL.g:603:1: rulePipelineReferenceRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject rulePipelineReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:609:2: ( ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:610:2: ( ( ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:610:2: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:611:3: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:611:3: ( ruleStringOrId )
            // InternalGeneratorDSL.g:612:4: ruleStringOrId
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPipelineReferenceRuleRule());
            				}
            			

            				newCompositeNode(grammarAccess.getPipelineReferenceRuleAccess().getPipelinePipelineDefinitionCrossReference_0());
            			
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
    // $ANTLR end "rulePipelineReferenceRule"


    // $ANTLR start "entryRuleApplyStatementRule"
    // InternalGeneratorDSL.g:629:1: entryRuleApplyStatementRule returns [EObject current=null] : iv_ruleApplyStatementRule= ruleApplyStatementRule EOF ;
    public final EObject entryRuleApplyStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplyStatementRule = null;


        try {
            // InternalGeneratorDSL.g:629:59: (iv_ruleApplyStatementRule= ruleApplyStatementRule EOF )
            // InternalGeneratorDSL.g:630:2: iv_ruleApplyStatementRule= ruleApplyStatementRule EOF
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
    // InternalGeneratorDSL.g:636:1: ruleApplyStatementRule returns [EObject current=null] : (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= rulePipelineReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )* otherlv_11= ']' otherlv_12= 's;' ) ;
    public final EObject ruleApplyStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_file_1_0=null;
        Token otherlv_2=null;
        Token lv_count_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_pipelines_8_0 = null;

        EObject lv_pipelines_10_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:642:2: ( (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= rulePipelineReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )* otherlv_11= ']' otherlv_12= 's;' ) )
            // InternalGeneratorDSL.g:643:2: (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= rulePipelineReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )* otherlv_11= ']' otherlv_12= 's;' )
            {
            // InternalGeneratorDSL.g:643:2: (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= rulePipelineReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )* otherlv_11= ']' otherlv_12= 's;' )
            // InternalGeneratorDSL.g:644:3: otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= rulePipelineReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )* otherlv_11= ']' otherlv_12= 's;'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getApplyStatementRuleAccess().getWriteKeyword_0());
            		
            // InternalGeneratorDSL.g:648:3: ( (lv_file_1_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:649:4: (lv_file_1_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:649:4: (lv_file_1_0= RULE_STRING )
            // InternalGeneratorDSL.g:650:5: lv_file_1_0= RULE_STRING
            {
            lv_file_1_0=(Token)match(input,RULE_STRING,FOLLOW_21); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getApplyStatementRuleAccess().getWithKeyword_2());
            		
            // InternalGeneratorDSL.g:670:3: ( (lv_count_3_0= RULE_INT ) )
            // InternalGeneratorDSL.g:671:4: (lv_count_3_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:671:4: (lv_count_3_0= RULE_INT )
            // InternalGeneratorDSL.g:672:5: lv_count_3_0= RULE_INT
            {
            lv_count_3_0=(Token)match(input,RULE_INT,FOLLOW_22); 

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

            otherlv_4=(Token)match(input,26,FOLLOW_23); 

            			newLeafNode(otherlv_4, grammarAccess.getApplyStatementRuleAccess().getSamplesKeyword_4());
            		
            otherlv_5=(Token)match(input,27,FOLLOW_24); 

            			newLeafNode(otherlv_5, grammarAccess.getApplyStatementRuleAccess().getFromKeyword_5());
            		
            otherlv_6=(Token)match(input,28,FOLLOW_9); 

            			newLeafNode(otherlv_6, grammarAccess.getApplyStatementRuleAccess().getExecutingKeyword_6());
            		
            otherlv_7=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_7, grammarAccess.getApplyStatementRuleAccess().getLeftSquareBracketKeyword_7());
            		
            // InternalGeneratorDSL.g:704:3: ( (lv_pipelines_8_0= rulePipelineReferenceRule ) )
            // InternalGeneratorDSL.g:705:4: (lv_pipelines_8_0= rulePipelineReferenceRule )
            {
            // InternalGeneratorDSL.g:705:4: (lv_pipelines_8_0= rulePipelineReferenceRule )
            // InternalGeneratorDSL.g:706:5: lv_pipelines_8_0= rulePipelineReferenceRule
            {

            					newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getPipelinesPipelineReferenceRuleParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_11);
            lv_pipelines_8_0=rulePipelineReferenceRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getApplyStatementRuleRule());
            					}
            					add(
            						current,
            						"pipelines",
            						lv_pipelines_8_0,
            						"de.evoal.languages.model.generator.dsl.GeneratorDSL.PipelineReferenceRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:723:3: (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==16) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalGeneratorDSL.g:724:4: otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) )
            	    {
            	    otherlv_9=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_9, grammarAccess.getApplyStatementRuleAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalGeneratorDSL.g:728:4: ( (lv_pipelines_10_0= rulePipelineReferenceRule ) )
            	    // InternalGeneratorDSL.g:729:5: (lv_pipelines_10_0= rulePipelineReferenceRule )
            	    {
            	    // InternalGeneratorDSL.g:729:5: (lv_pipelines_10_0= rulePipelineReferenceRule )
            	    // InternalGeneratorDSL.g:730:6: lv_pipelines_10_0= rulePipelineReferenceRule
            	    {

            	    						newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getPipelinesPipelineReferenceRuleParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_pipelines_10_0=rulePipelineReferenceRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getApplyStatementRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pipelines",
            	    							lv_pipelines_10_0,
            	    							"de.evoal.languages.model.generator.dsl.GeneratorDSL.PipelineReferenceRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_11=(Token)match(input,17,FOLLOW_25); 

            			newLeafNode(otherlv_11, grammarAccess.getApplyStatementRuleAccess().getRightSquareBracketKeyword_10());
            		
            otherlv_12=(Token)match(input,29,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getApplyStatementRuleAccess().getSKeyword_11());
            		

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


    // $ANTLR start "entryRuleInstanceRule"
    // InternalGeneratorDSL.g:760:1: entryRuleInstanceRule returns [EObject current=null] : iv_ruleInstanceRule= ruleInstanceRule EOF ;
    public final EObject entryRuleInstanceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceRule = null;


        try {
            // InternalGeneratorDSL.g:760:53: (iv_ruleInstanceRule= ruleInstanceRule EOF )
            // InternalGeneratorDSL.g:761:2: iv_ruleInstanceRule= ruleInstanceRule EOF
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
    // InternalGeneratorDSL.g:767:1: ruleInstanceRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleInstanceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:773:2: ( ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) )
            // InternalGeneratorDSL.g:774:2: ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            {
            // InternalGeneratorDSL.g:774:2: ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            // InternalGeneratorDSL.g:775:3: ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            {
            // InternalGeneratorDSL.g:775:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:776:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:776:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:777:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInstanceRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInstanceRuleAccess().getNameTypeDefinitionCrossReference_0_0());
            				
            pushFollow(FOLLOW_26);
            ruleStringOrId();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:791:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==30) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalGeneratorDSL.g:792:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_27); 

                    				newLeafNode(otherlv_1, grammarAccess.getInstanceRuleAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalGeneratorDSL.g:796:4: ( (lv_attributes_2_0= ruleAttributeRule ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)||LA12_0==RULE_QUOTED_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:797:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    {
                    	    // InternalGeneratorDSL.g:797:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    // InternalGeneratorDSL.g:798:6: lv_attributes_2_0= ruleAttributeRule
                    	    {

                    	    						newCompositeNode(grammarAccess.getInstanceRuleAccess().getAttributesAttributeRuleParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_27);
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
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,31,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:824:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalGeneratorDSL.g:824:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalGeneratorDSL.g:825:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalGeneratorDSL.g:831:1: ruleAttributeRule returns [EObject current=null] : ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:837:2: ( ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) )
            // InternalGeneratorDSL.g:838:2: ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            {
            // InternalGeneratorDSL.g:838:2: ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            // InternalGeneratorDSL.g:839:3: ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';'
            {
            // InternalGeneratorDSL.g:839:3: ( (lv_name_0_0= ruleNameOrMiscRule ) )
            // InternalGeneratorDSL.g:840:4: (lv_name_0_0= ruleNameOrMiscRule )
            {
            // InternalGeneratorDSL.g:840:4: (lv_name_0_0= ruleNameOrMiscRule )
            // InternalGeneratorDSL.g:841:5: lv_name_0_0= ruleNameOrMiscRule
            {

            					newCompositeNode(grammarAccess.getAttributeRuleAccess().getNameNameOrMiscRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_28);
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

            otherlv_1=(Token)match(input,32,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
            		
            // InternalGeneratorDSL.g:862:3: ( (lv_value_2_0= ruleValueRule ) )
            // InternalGeneratorDSL.g:863:4: (lv_value_2_0= ruleValueRule )
            {
            // InternalGeneratorDSL.g:863:4: (lv_value_2_0= ruleValueRule )
            // InternalGeneratorDSL.g:864:5: lv_value_2_0= ruleValueRule
            {

            					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueValueRuleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
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
    // InternalGeneratorDSL.g:889:1: entryRuleNameOrMiscRule returns [EObject current=null] : iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF ;
    public final EObject entryRuleNameOrMiscRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrMiscRule = null;


        try {
            // InternalGeneratorDSL.g:889:55: (iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF )
            // InternalGeneratorDSL.g:890:2: iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF
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
    // InternalGeneratorDSL.g:896:1: ruleNameOrMiscRule returns [EObject current=null] : (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule ) ;
    public final EObject ruleNameOrMiscRule() throws RecognitionException {
        EObject current = null;

        EObject this_NameRule_0 = null;

        EObject this_MiscRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:902:2: ( (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule ) )
            // InternalGeneratorDSL.g:903:2: (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule )
            {
            // InternalGeneratorDSL.g:903:2: (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID||LA14_0==RULE_QUOTED_ID) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_STRING) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalGeneratorDSL.g:904:3: this_NameRule_0= ruleNameRule
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
                    // InternalGeneratorDSL.g:913:3: this_MiscRule_1= ruleMiscRule
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
    // InternalGeneratorDSL.g:925:1: entryRuleNameRule returns [EObject current=null] : iv_ruleNameRule= ruleNameRule EOF ;
    public final EObject entryRuleNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameRule = null;


        try {
            // InternalGeneratorDSL.g:925:49: (iv_ruleNameRule= ruleNameRule EOF )
            // InternalGeneratorDSL.g:926:2: iv_ruleNameRule= ruleNameRule EOF
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
    // InternalGeneratorDSL.g:932:1: ruleNameRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:938:2: ( ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:939:2: ( ( ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:939:2: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:940:3: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:940:3: ( ruleStringOrId )
            // InternalGeneratorDSL.g:941:4: ruleStringOrId
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
    // InternalGeneratorDSL.g:958:1: entryRuleMiscRule returns [EObject current=null] : iv_ruleMiscRule= ruleMiscRule EOF ;
    public final EObject entryRuleMiscRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMiscRule = null;


        try {
            // InternalGeneratorDSL.g:958:49: (iv_ruleMiscRule= ruleMiscRule EOF )
            // InternalGeneratorDSL.g:959:2: iv_ruleMiscRule= ruleMiscRule EOF
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
    // InternalGeneratorDSL.g:965:1: ruleMiscRule returns [EObject current=null] : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final EObject ruleMiscRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:971:2: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // InternalGeneratorDSL.g:972:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // InternalGeneratorDSL.g:972:2: ( (lv_name_0_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:973:3: (lv_name_0_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:973:3: (lv_name_0_0= RULE_STRING )
            // InternalGeneratorDSL.g:974:4: lv_name_0_0= RULE_STRING
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
    // InternalGeneratorDSL.g:993:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // InternalGeneratorDSL.g:993:50: (iv_ruleValueRule= ruleValueRule EOF )
            // InternalGeneratorDSL.g:994:2: iv_ruleValueRule= ruleValueRule EOF
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
    // InternalGeneratorDSL.g:1000:1: ruleValueRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_DataReferenceRule_1 = null;

        EObject this_InstanceRule_2 = null;

        EObject this_LiteralValueRule_3 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1006:2: ( (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) )
            // InternalGeneratorDSL.g:1007:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            {
            // InternalGeneratorDSL.g:1007:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt15=1;
                }
                break;
            case 33:
                {
                alt15=2;
                }
                break;
            case RULE_ID:
            case RULE_QUOTED_ID:
                {
                alt15=3;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case 43:
            case 44:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalGeneratorDSL.g:1008:3: this_ArrayRule_0= ruleArrayRule
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
                    // InternalGeneratorDSL.g:1017:3: this_DataReferenceRule_1= ruleDataReferenceRule
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
                    // InternalGeneratorDSL.g:1026:3: this_InstanceRule_2= ruleInstanceRule
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
                    // InternalGeneratorDSL.g:1035:3: this_LiteralValueRule_3= ruleLiteralValueRule
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
    // InternalGeneratorDSL.g:1047:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalGeneratorDSL.g:1047:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalGeneratorDSL.g:1048:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalGeneratorDSL.g:1054:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1060:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) )
            // InternalGeneratorDSL.g:1061:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalGeneratorDSL.g:1061:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            // InternalGeneratorDSL.g:1062:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']'
            {
            // InternalGeneratorDSL.g:1062:3: ()
            // InternalGeneratorDSL.g:1063:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArrayRuleAccess().getArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_30); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalGeneratorDSL.g:1073:3: ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_STRING && LA17_0<=RULE_QUOTED_ID)||LA17_0==15||LA17_0==33||(LA17_0>=43 && LA17_0<=44)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalGeneratorDSL.g:1074:4: ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    {
                    // InternalGeneratorDSL.g:1074:4: ( (lv_values_2_0= ruleValueRule ) )
                    // InternalGeneratorDSL.g:1075:5: (lv_values_2_0= ruleValueRule )
                    {
                    // InternalGeneratorDSL.g:1075:5: (lv_values_2_0= ruleValueRule )
                    // InternalGeneratorDSL.g:1076:6: lv_values_2_0= ruleValueRule
                    {

                    						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    // InternalGeneratorDSL.g:1093:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==16) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:1094:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FOLLOW_29); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalGeneratorDSL.g:1098:5: ( (lv_values_4_0= ruleValueRule ) )
                    	    // InternalGeneratorDSL.g:1099:6: (lv_values_4_0= ruleValueRule )
                    	    {
                    	    // InternalGeneratorDSL.g:1099:6: (lv_values_4_0= ruleValueRule )
                    	    // InternalGeneratorDSL.g:1100:7: lv_values_4_0= ruleValueRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
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
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,17,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:1127:1: entryRuleLiteralValueRule returns [EObject current=null] : iv_ruleLiteralValueRule= ruleLiteralValueRule EOF ;
    public final EObject entryRuleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValueRule = null;


        try {
            // InternalGeneratorDSL.g:1127:57: (iv_ruleLiteralValueRule= ruleLiteralValueRule EOF )
            // InternalGeneratorDSL.g:1128:2: iv_ruleLiteralValueRule= ruleLiteralValueRule EOF
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
    // InternalGeneratorDSL.g:1134:1: ruleLiteralValueRule returns [EObject current=null] : ( (lv_literal_0_0= ruleLiteralRule ) ) ;
    public final EObject ruleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject lv_literal_0_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1140:2: ( ( (lv_literal_0_0= ruleLiteralRule ) ) )
            // InternalGeneratorDSL.g:1141:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            {
            // InternalGeneratorDSL.g:1141:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            // InternalGeneratorDSL.g:1142:3: (lv_literal_0_0= ruleLiteralRule )
            {
            // InternalGeneratorDSL.g:1142:3: (lv_literal_0_0= ruleLiteralRule )
            // InternalGeneratorDSL.g:1143:4: lv_literal_0_0= ruleLiteralRule
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
    // InternalGeneratorDSL.g:1163:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:1163:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalGeneratorDSL.g:1164:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
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
    // InternalGeneratorDSL.g:1170:1: ruleDataReferenceRule returns [EObject current=null] : ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1176:2: ( ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) )
            // InternalGeneratorDSL.g:1177:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            {
            // InternalGeneratorDSL.g:1177:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:1178:3: () otherlv_1= 'data' ( ( ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:1178:3: ()
            // InternalGeneratorDSL.g:1179:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,33,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1());
            		
            // InternalGeneratorDSL.g:1189:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:1190:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:1190:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:1191:5: ruleStringOrId
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
    // InternalGeneratorDSL.g:1209:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1209:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalGeneratorDSL.g:1210:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalGeneratorDSL.g:1216:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1222:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalGeneratorDSL.g:1223:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalGeneratorDSL.g:1234:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1234:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalGeneratorDSL.g:1235:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalGeneratorDSL.g:1241:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1247:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1248:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1248:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1249:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1249:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalGeneratorDSL.g:1250:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalGeneratorDSL.g:1250:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalGeneratorDSL.g:1251:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {

            					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_31);
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

            // InternalGeneratorDSL.g:1268:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==34) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1269:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,34,FOLLOW_32); 

            	    				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	    			
            	    // InternalGeneratorDSL.g:1273:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalGeneratorDSL.g:1274:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1274:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalGeneratorDSL.g:1275:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_31);
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
            	    break loop18;
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
    // InternalGeneratorDSL.g:1297:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1297:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalGeneratorDSL.g:1298:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalGeneratorDSL.g:1304:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1310:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1311:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1311:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1312:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1312:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalGeneratorDSL.g:1313:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalGeneratorDSL.g:1313:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalGeneratorDSL.g:1314:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {

            					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_33);
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

            // InternalGeneratorDSL.g:1331:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==35) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1332:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_32); 

            	    				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	    			
            	    // InternalGeneratorDSL.g:1336:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalGeneratorDSL.g:1337:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1337:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalGeneratorDSL.g:1338:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_33);
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
            	    break loop19;
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
    // InternalGeneratorDSL.g:1360:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1360:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalGeneratorDSL.g:1361:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalGeneratorDSL.g:1367:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1373:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1374:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1374:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1375:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1375:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalGeneratorDSL.g:1376:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalGeneratorDSL.g:1376:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalGeneratorDSL.g:1377:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {

            					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_34);
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

            // InternalGeneratorDSL.g:1394:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==36) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1395:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,36,FOLLOW_32); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	    			
            	    // InternalGeneratorDSL.g:1399:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalGeneratorDSL.g:1400:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1400:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalGeneratorDSL.g:1401:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_34);
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
            	    break loop20;
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
    // InternalGeneratorDSL.g:1423:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1423:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalGeneratorDSL.g:1424:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalGeneratorDSL.g:1430:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1436:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalGeneratorDSL.g:1437:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalGeneratorDSL.g:1437:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalGeneratorDSL.g:1438:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalGeneratorDSL.g:1438:3: ( (lv_negated_0_0= '!' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==37) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalGeneratorDSL.g:1439:4: (lv_negated_0_0= '!' )
                    {
                    // InternalGeneratorDSL.g:1439:4: (lv_negated_0_0= '!' )
                    // InternalGeneratorDSL.g:1440:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,37,FOLLOW_32); 

                    					newLeafNode(lv_negated_0_0, grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNotExpressionRuleRule());
                    					}
                    					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "!");
                    				

                    }


                    }
                    break;

            }

            // InternalGeneratorDSL.g:1452:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalGeneratorDSL.g:1453:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalGeneratorDSL.g:1453:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalGeneratorDSL.g:1454:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalGeneratorDSL.g:1475:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1475:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalGeneratorDSL.g:1476:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalGeneratorDSL.g:1482:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1488:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalGeneratorDSL.g:1489:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalGeneratorDSL.g:1489:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalGeneratorDSL.g:1490:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalGeneratorDSL.g:1490:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:1491:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:1491:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:1492:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_35);
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

            // InternalGeneratorDSL.g:1509:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=46 && LA22_0<=51)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1510:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1510:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalGeneratorDSL.g:1511:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {

            	    					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_35);
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
    // $ANTLR end "ruleComparisonExpressionRule"


    // $ANTLR start "entryRulePartialComparisonExpressionRule"
    // InternalGeneratorDSL.g:1532:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1532:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalGeneratorDSL.g:1533:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalGeneratorDSL.g:1539:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1545:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalGeneratorDSL.g:1546:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalGeneratorDSL.g:1546:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalGeneratorDSL.g:1547:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalGeneratorDSL.g:1547:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalGeneratorDSL.g:1548:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalGeneratorDSL.g:1548:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalGeneratorDSL.g:1549:5: lv_operator_0_0= ruleComparisonOperatorRule
            {

            					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_32);
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

            // InternalGeneratorDSL.g:1566:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:1567:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:1567:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:1568:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalGeneratorDSL.g:1589:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1589:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalGeneratorDSL.g:1590:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalGeneratorDSL.g:1596:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1602:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1603:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1603:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1604:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1604:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalGeneratorDSL.g:1605:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalGeneratorDSL.g:1605:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalGeneratorDSL.g:1606:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {

            					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_36);
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

            // InternalGeneratorDSL.g:1623:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=52 && LA23_0<=53)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1624:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalGeneratorDSL.g:1624:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalGeneratorDSL.g:1625:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:1625:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalGeneratorDSL.g:1626:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_32);
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

            	    // InternalGeneratorDSL.g:1643:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalGeneratorDSL.g:1644:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1644:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalGeneratorDSL.g:1645:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_36);
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
    // $ANTLR end "ruleAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleMultiplyDivideModuloExpressionRule"
    // InternalGeneratorDSL.g:1667:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1667:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalGeneratorDSL.g:1668:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalGeneratorDSL.g:1674:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1680:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1681:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1681:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1682:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1682:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalGeneratorDSL.g:1683:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalGeneratorDSL.g:1683:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalGeneratorDSL.g:1684:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {

            					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_37);
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

            // InternalGeneratorDSL.g:1701:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=54 && LA24_0<=56)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1702:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalGeneratorDSL.g:1702:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalGeneratorDSL.g:1703:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:1703:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalGeneratorDSL.g:1704:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_32);
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

            	    // InternalGeneratorDSL.g:1721:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalGeneratorDSL.g:1722:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1722:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalGeneratorDSL.g:1723:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_37);
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
            	    break loop24;
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
    // InternalGeneratorDSL.g:1745:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1745:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalGeneratorDSL.g:1746:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalGeneratorDSL.g:1752:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1758:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalGeneratorDSL.g:1759:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalGeneratorDSL.g:1759:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalGeneratorDSL.g:1760:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalGeneratorDSL.g:1760:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:1761:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:1761:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:1762:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
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

            // InternalGeneratorDSL.g:1779:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==38) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalGeneratorDSL.g:1780:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_32); 

                    				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                    			
                    // InternalGeneratorDSL.g:1784:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalGeneratorDSL.g:1785:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalGeneratorDSL.g:1785:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalGeneratorDSL.g:1786:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalGeneratorDSL.g:1808:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1808:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalGeneratorDSL.g:1809:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalGeneratorDSL.g:1815:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1821:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) )
            // InternalGeneratorDSL.g:1822:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            {
            // InternalGeneratorDSL.g:1822:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            // InternalGeneratorDSL.g:1823:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            {
            // InternalGeneratorDSL.g:1823:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=52 && LA26_0<=53)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1824:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:1824:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalGeneratorDSL.g:1825:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {

            	    					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_32);
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
            	    break loop26;
                }
            } while (true);

            // InternalGeneratorDSL.g:1842:3: ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            // InternalGeneratorDSL.g:1843:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            {
            // InternalGeneratorDSL.g:1843:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            // InternalGeneratorDSL.g:1844:5: lv_subExpression_1_0= ruleLiteralOrReferenceRule
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
    // InternalGeneratorDSL.g:1865:1: entryRuleLiteralOrReferenceRule returns [EObject current=null] : iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF ;
    public final EObject entryRuleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:1865:63: (iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF )
            // InternalGeneratorDSL.g:1866:2: iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF
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
    // InternalGeneratorDSL.g:1872:1: ruleLiteralOrReferenceRule returns [EObject current=null] : (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) ;
    public final EObject ruleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallRule_0 = null;

        EObject this_LiteralRule_1 = null;

        EObject this_ParanthesesRule_2 = null;

        EObject this_ValueReferenceRule_3 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1878:2: ( (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) )
            // InternalGeneratorDSL.g:1879:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            {
            // InternalGeneratorDSL.g:1879:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            int alt27=4;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt27=1;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case 43:
            case 44:
                {
                alt27=2;
                }
                break;
            case 39:
                {
                alt27=3;
                }
                break;
            case 42:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalGeneratorDSL.g:1880:3: this_CallRule_0= ruleCallRule
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
                    // InternalGeneratorDSL.g:1889:3: this_LiteralRule_1= ruleLiteralRule
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
                    // InternalGeneratorDSL.g:1898:3: this_ParanthesesRule_2= ruleParanthesesRule
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
                    // InternalGeneratorDSL.g:1907:3: this_ValueReferenceRule_3= ruleValueReferenceRule
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
    // InternalGeneratorDSL.g:1919:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalGeneratorDSL.g:1919:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalGeneratorDSL.g:1920:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalGeneratorDSL.g:1926:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1932:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalGeneratorDSL.g:1933:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalGeneratorDSL.g:1933:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalGeneratorDSL.g:1934:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
            		
            // InternalGeneratorDSL.g:1938:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalGeneratorDSL.g:1939:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalGeneratorDSL.g:1939:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalGeneratorDSL.g:1940:5: lv_subExpression_1_0= ruleExpressionRule
            {

            					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_39);
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

            otherlv_2=(Token)match(input,40,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:1965:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalGeneratorDSL.g:1965:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalGeneratorDSL.g:1966:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalGeneratorDSL.g:1972:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalGeneratorDSL.g:1978:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalGeneratorDSL.g:1979:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalGeneratorDSL.g:1979:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalGeneratorDSL.g:1980:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalGeneratorDSL.g:1980:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalGeneratorDSL.g:1981:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalGeneratorDSL.g:1981:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalGeneratorDSL.g:1982:5: lv_function_0_0= ruleFunctionNameRule
            {

            					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_40);
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

            otherlv_1=(Token)match(input,39,FOLLOW_41); 

            			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
            		
            // InternalGeneratorDSL.g:2003:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_STRING||LA29_0==RULE_INT||LA29_0==37||LA29_0==39||(LA29_0>=41 && LA29_0<=44)||(LA29_0>=52 && LA29_0<=53)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalGeneratorDSL.g:2004:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalGeneratorDSL.g:2004:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalGeneratorDSL.g:2005:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalGeneratorDSL.g:2005:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalGeneratorDSL.g:2006:6: lv_parameters_2_0= ruleExpressionRule
                    {

                    						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_42);
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

                    // InternalGeneratorDSL.g:2023:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==16) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:2024:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FOLLOW_32); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalGeneratorDSL.g:2028:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalGeneratorDSL.g:2029:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalGeneratorDSL.g:2029:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalGeneratorDSL.g:2030:7: lv_parameters_4_0= ruleExpressionRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_42);
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
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,40,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2057:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalGeneratorDSL.g:2057:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalGeneratorDSL.g:2058:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
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
    // InternalGeneratorDSL.g:2064:1: ruleFunctionNameRule returns [EObject current=null] : ( () otherlv_1= 'call' ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2070:2: ( ( () otherlv_1= 'call' ) )
            // InternalGeneratorDSL.g:2071:2: ( () otherlv_1= 'call' )
            {
            // InternalGeneratorDSL.g:2071:2: ( () otherlv_1= 'call' )
            // InternalGeneratorDSL.g:2072:3: () otherlv_1= 'call'
            {
            // InternalGeneratorDSL.g:2072:3: ()
            // InternalGeneratorDSL.g:2073:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFunctionNameRuleAccess().getFunctionNameAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,41,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2087:1: entryRuleValueReferenceRule returns [EObject current=null] : iv_ruleValueReferenceRule= ruleValueReferenceRule EOF ;
    public final EObject entryRuleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:2087:59: (iv_ruleValueReferenceRule= ruleValueReferenceRule EOF )
            // InternalGeneratorDSL.g:2088:2: iv_ruleValueReferenceRule= ruleValueReferenceRule EOF
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
    // InternalGeneratorDSL.g:2094:1: ruleValueReferenceRule returns [EObject current=null] : ( () otherlv_1= 'value' ) ;
    public final EObject ruleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2100:2: ( ( () otherlv_1= 'value' ) )
            // InternalGeneratorDSL.g:2101:2: ( () otherlv_1= 'value' )
            {
            // InternalGeneratorDSL.g:2101:2: ( () otherlv_1= 'value' )
            // InternalGeneratorDSL.g:2102:3: () otherlv_1= 'value'
            {
            // InternalGeneratorDSL.g:2102:3: ()
            // InternalGeneratorDSL.g:2103:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,42,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2117:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2117:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalGeneratorDSL.g:2118:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalGeneratorDSL.g:2124:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2130:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) )
            // InternalGeneratorDSL.g:2131:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            {
            // InternalGeneratorDSL.g:2131:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            int alt30=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt30=1;
                }
                break;
            case RULE_STRING:
                {
                alt30=2;
                }
                break;
            case 43:
            case 44:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalGeneratorDSL.g:2132:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalGeneratorDSL.g:2141:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalGeneratorDSL.g:2150:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
    // InternalGeneratorDSL.g:2162:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2162:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalGeneratorDSL.g:2163:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalGeneratorDSL.g:2169:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2175:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalGeneratorDSL.g:2176:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalGeneratorDSL.g:2176:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_INT) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==45) ) {
                    alt31=1;
                }
                else if ( (LA31_1==EOF||LA31_1==13||(LA31_1>=16 && LA31_1<=17)||(LA31_1>=34 && LA31_1<=36)||LA31_1==38||LA31_1==40||(LA31_1>=46 && LA31_1<=56)) ) {
                    alt31=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalGeneratorDSL.g:2177:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
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
                    // InternalGeneratorDSL.g:2186:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalGeneratorDSL.g:2198:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2198:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalGeneratorDSL.g:2199:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
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
    // InternalGeneratorDSL.g:2205:1: ruleDoubleLiteralRule returns [EObject current=null] : ( (lv_value_0_0= ruleDOUBLE ) ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2211:2: ( ( (lv_value_0_0= ruleDOUBLE ) ) )
            // InternalGeneratorDSL.g:2212:2: ( (lv_value_0_0= ruleDOUBLE ) )
            {
            // InternalGeneratorDSL.g:2212:2: ( (lv_value_0_0= ruleDOUBLE ) )
            // InternalGeneratorDSL.g:2213:3: (lv_value_0_0= ruleDOUBLE )
            {
            // InternalGeneratorDSL.g:2213:3: (lv_value_0_0= ruleDOUBLE )
            // InternalGeneratorDSL.g:2214:4: lv_value_0_0= ruleDOUBLE
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
    // InternalGeneratorDSL.g:2234:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2234:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalGeneratorDSL.g:2235:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalGeneratorDSL.g:2241:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2247:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalGeneratorDSL.g:2248:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalGeneratorDSL.g:2248:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalGeneratorDSL.g:2249:3: (lv_value_0_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:2249:3: (lv_value_0_0= RULE_INT )
            // InternalGeneratorDSL.g:2250:4: lv_value_0_0= RULE_INT
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
    // InternalGeneratorDSL.g:2269:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2269:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalGeneratorDSL.g:2270:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalGeneratorDSL.g:2276:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2282:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalGeneratorDSL.g:2283:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalGeneratorDSL.g:2283:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:2284:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:2284:3: (lv_value_0_0= RULE_STRING )
            // InternalGeneratorDSL.g:2285:4: lv_value_0_0= RULE_STRING
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
    // InternalGeneratorDSL.g:2304:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2304:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalGeneratorDSL.g:2305:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalGeneratorDSL.g:2311:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2317:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalGeneratorDSL.g:2318:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalGeneratorDSL.g:2318:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalGeneratorDSL.g:2319:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalGeneratorDSL.g:2319:3: ()
            // InternalGeneratorDSL.g:2320:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalGeneratorDSL.g:2326:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==43) ) {
                alt32=1;
            }
            else if ( (LA32_0==44) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalGeneratorDSL.g:2327:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalGeneratorDSL.g:2327:4: ( (lv_value_1_0= 'true' ) )
                    // InternalGeneratorDSL.g:2328:5: (lv_value_1_0= 'true' )
                    {
                    // InternalGeneratorDSL.g:2328:5: (lv_value_1_0= 'true' )
                    // InternalGeneratorDSL.g:2329:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,43,FOLLOW_2); 

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
                    // InternalGeneratorDSL.g:2342:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2351:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalGeneratorDSL.g:2351:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalGeneratorDSL.g:2352:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalGeneratorDSL.g:2358:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2364:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalGeneratorDSL.g:2365:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalGeneratorDSL.g:2365:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_QUOTED_ID) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_ID) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalGeneratorDSL.g:2366:3: this_QUOTED_ID_0= RULE_QUOTED_ID
                    {
                    this_QUOTED_ID_0=(Token)match(input,RULE_QUOTED_ID,FOLLOW_2); 

                    			current.merge(this_QUOTED_ID_0);
                    		

                    			newLeafNode(this_QUOTED_ID_0, grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2374:3: this_ID_1= RULE_ID
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
    // InternalGeneratorDSL.g:2385:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // InternalGeneratorDSL.g:2385:46: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // InternalGeneratorDSL.g:2386:2: iv_ruleDOUBLE= ruleDOUBLE EOF
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
    // InternalGeneratorDSL.g:2392:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2398:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalGeneratorDSL.g:2399:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalGeneratorDSL.g:2399:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalGeneratorDSL.g:2400:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_43); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,45,FOLLOW_17); 

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
    // InternalGeneratorDSL.g:2423:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalGeneratorDSL.g:2429:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalGeneratorDSL.g:2430:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalGeneratorDSL.g:2430:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt34=6;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt34=1;
                }
                break;
            case 47:
                {
                alt34=2;
                }
                break;
            case 48:
                {
                alt34=3;
                }
                break;
            case 49:
                {
                alt34=4;
                }
                break;
            case 50:
                {
                alt34=5;
                }
                break;
            case 51:
                {
                alt34=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalGeneratorDSL.g:2431:3: (enumLiteral_0= '>=' )
                    {
                    // InternalGeneratorDSL.g:2431:3: (enumLiteral_0= '>=' )
                    // InternalGeneratorDSL.g:2432:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2439:3: (enumLiteral_1= '>' )
                    {
                    // InternalGeneratorDSL.g:2439:3: (enumLiteral_1= '>' )
                    // InternalGeneratorDSL.g:2440:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:2447:3: (enumLiteral_2= '=' )
                    {
                    // InternalGeneratorDSL.g:2447:3: (enumLiteral_2= '=' )
                    // InternalGeneratorDSL.g:2448:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:2455:3: (enumLiteral_3= '!=' )
                    {
                    // InternalGeneratorDSL.g:2455:3: (enumLiteral_3= '!=' )
                    // InternalGeneratorDSL.g:2456:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGeneratorDSL.g:2463:3: (enumLiteral_4= '<' )
                    {
                    // InternalGeneratorDSL.g:2463:3: (enumLiteral_4= '<' )
                    // InternalGeneratorDSL.g:2464:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalGeneratorDSL.g:2471:3: (enumLiteral_5= '<=' )
                    {
                    // InternalGeneratorDSL.g:2471:3: (enumLiteral_5= '<=' )
                    // InternalGeneratorDSL.g:2472:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,51,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2482:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2488:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalGeneratorDSL.g:2489:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalGeneratorDSL.g:2489:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==52) ) {
                alt35=1;
            }
            else if ( (LA35_0==53) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalGeneratorDSL.g:2490:3: (enumLiteral_0= '+' )
                    {
                    // InternalGeneratorDSL.g:2490:3: (enumLiteral_0= '+' )
                    // InternalGeneratorDSL.g:2491:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2498:3: (enumLiteral_1= '-' )
                    {
                    // InternalGeneratorDSL.g:2498:3: (enumLiteral_1= '-' )
                    // InternalGeneratorDSL.g:2499:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2509:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2515:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalGeneratorDSL.g:2516:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalGeneratorDSL.g:2516:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt36=1;
                }
                break;
            case 55:
                {
                alt36=2;
                }
                break;
            case 56:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalGeneratorDSL.g:2517:3: (enumLiteral_0= '*' )
                    {
                    // InternalGeneratorDSL.g:2517:3: (enumLiteral_0= '*' )
                    // InternalGeneratorDSL.g:2518:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2525:3: (enumLiteral_1= '/' )
                    {
                    // InternalGeneratorDSL.g:2525:3: (enumLiteral_1= '/' )
                    // InternalGeneratorDSL.g:2526:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:2533:3: (enumLiteral_2= '%' )
                    {
                    // InternalGeneratorDSL.g:2533:3: (enumLiteral_2= '%' )
                    // InternalGeneratorDSL.g:2534:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_2); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001045002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000001044002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000001040002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000200A0L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001240000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000000800000B0L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00001802000080F0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00001802000280F0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00301EA2000080F0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000FC00000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x01C0000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00301FA2000080F0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000010000010000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000200000000000L});

}
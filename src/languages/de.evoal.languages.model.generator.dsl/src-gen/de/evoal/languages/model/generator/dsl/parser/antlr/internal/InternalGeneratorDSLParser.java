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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_QUOTED_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'use'", "';'", "'pipeline'", "'['", "']'", "'step'", "'{'", "'component'", "'reads'", "','", "'writes'", "'}'", "'for'", "'in'", "'loop'", "'end'", "'to'", "'pipelines'", "'write'", "'with'", "'samples'", "'from'", "'executing'", "':='", "'data'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'('", "')'", "'call'", "'value'", "'true'", "'false'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
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
    public static final int RULE_QUOTED_ID=7;
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
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
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

                if ( (LA3_0==24||LA3_0==30) ) {
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
    // InternalGeneratorDSL.g:193:1: rulePipelineDefinitionRule returns [EObject current=null] : (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' ) ;
    public final EObject rulePipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_steps_3_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:199:2: ( (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' ) )
            // InternalGeneratorDSL.g:200:2: (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' )
            {
            // InternalGeneratorDSL.g:200:2: (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' )
            // InternalGeneratorDSL.g:201:3: otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']'
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
            		
            // InternalGeneratorDSL.g:228:3: ( (lv_steps_3_0= ruleStepRule ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalGeneratorDSL.g:229:4: (lv_steps_3_0= ruleStepRule )
            	    {
            	    // InternalGeneratorDSL.g:229:4: (lv_steps_3_0= ruleStepRule )
            	    // InternalGeneratorDSL.g:230:5: lv_steps_3_0= ruleStepRule
            	    {

            	    					newCompositeNode(grammarAccess.getPipelineDefinitionRuleAccess().getStepsStepRuleParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_steps_3_0=ruleStepRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPipelineDefinitionRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_3_0,
            	    						"de.evoal.languages.model.generator.dsl.GeneratorDSL.StepRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPipelineDefinitionRuleAccess().getRightSquareBracketKeyword_4());
            		

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


    // $ANTLR start "entryRuleStepRule"
    // InternalGeneratorDSL.g:255:1: entryRuleStepRule returns [EObject current=null] : iv_ruleStepRule= ruleStepRule EOF ;
    public final EObject entryRuleStepRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepRule = null;


        try {
            // InternalGeneratorDSL.g:255:49: (iv_ruleStepRule= ruleStepRule EOF )
            // InternalGeneratorDSL.g:256:2: iv_ruleStepRule= ruleStepRule EOF
            {
             newCompositeNode(grammarAccess.getStepRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStepRule=ruleStepRule();

            state._fsp--;

             current =iv_ruleStepRule; 
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
    // $ANTLR end "entryRuleStepRule"


    // $ANTLR start "ruleStepRule"
    // InternalGeneratorDSL.g:262:1: ruleStepRule returns [EObject current=null] : (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' ) ;
    public final EObject ruleStepRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        EObject lv_instance_3_0 = null;

        EObject lv_reads_6_0 = null;

        EObject lv_reads_8_0 = null;

        EObject lv_writes_13_0 = null;

        EObject lv_writes_15_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:268:2: ( (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' ) )
            // InternalGeneratorDSL.g:269:2: (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' )
            {
            // InternalGeneratorDSL.g:269:2: (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' )
            // InternalGeneratorDSL.g:270:3: otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getStepRuleAccess().getStepKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getStepRuleAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getStepRuleAccess().getComponentKeyword_2());
            		
            // InternalGeneratorDSL.g:282:3: ( (lv_instance_3_0= ruleInstanceRule ) )
            // InternalGeneratorDSL.g:283:4: (lv_instance_3_0= ruleInstanceRule )
            {
            // InternalGeneratorDSL.g:283:4: (lv_instance_3_0= ruleInstanceRule )
            // InternalGeneratorDSL.g:284:5: lv_instance_3_0= ruleInstanceRule
            {

            					newCompositeNode(grammarAccess.getStepRuleAccess().getInstanceInstanceRuleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_13);
            lv_instance_3_0=ruleInstanceRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepRuleRule());
            					}
            					set(
            						current,
            						"instance",
            						lv_instance_3_0,
            						"de.evoal.languages.model.instance.dsl.InstanceLanguage.InstanceRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:301:3: (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalGeneratorDSL.g:302:4: otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';'
                    {
                    otherlv_4=(Token)match(input,20,FOLLOW_9); 

                    				newLeafNode(otherlv_4, grammarAccess.getStepRuleAccess().getReadsKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,15,FOLLOW_14); 

                    				newLeafNode(otherlv_5, grammarAccess.getStepRuleAccess().getLeftSquareBracketKeyword_4_1());
                    			
                    // InternalGeneratorDSL.g:310:4: ( ( (lv_reads_6_0= ruleDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) ) )* )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==36) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalGeneratorDSL.g:311:5: ( (lv_reads_6_0= ruleDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) ) )*
                            {
                            // InternalGeneratorDSL.g:311:5: ( (lv_reads_6_0= ruleDataReferenceRule ) )
                            // InternalGeneratorDSL.g:312:6: (lv_reads_6_0= ruleDataReferenceRule )
                            {
                            // InternalGeneratorDSL.g:312:6: (lv_reads_6_0= ruleDataReferenceRule )
                            // InternalGeneratorDSL.g:313:7: lv_reads_6_0= ruleDataReferenceRule
                            {

                            							newCompositeNode(grammarAccess.getStepRuleAccess().getReadsDataReferenceRuleParserRuleCall_4_2_0_0());
                            						
                            pushFollow(FOLLOW_15);
                            lv_reads_6_0=ruleDataReferenceRule();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getStepRuleRule());
                            							}
                            							add(
                            								current,
                            								"reads",
                            								lv_reads_6_0,
                            								"de.evoal.languages.model.instance.dsl.InstanceLanguage.DataReferenceRule");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalGeneratorDSL.g:330:5: (otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) ) )*
                            loop5:
                            do {
                                int alt5=2;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0==21) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // InternalGeneratorDSL.g:331:6: otherlv_7= ',' ( (lv_reads_8_0= ruleDataReferenceRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,21,FOLLOW_16); 

                            	    						newLeafNode(otherlv_7, grammarAccess.getStepRuleAccess().getCommaKeyword_4_2_1_0());
                            	    					
                            	    // InternalGeneratorDSL.g:335:6: ( (lv_reads_8_0= ruleDataReferenceRule ) )
                            	    // InternalGeneratorDSL.g:336:7: (lv_reads_8_0= ruleDataReferenceRule )
                            	    {
                            	    // InternalGeneratorDSL.g:336:7: (lv_reads_8_0= ruleDataReferenceRule )
                            	    // InternalGeneratorDSL.g:337:8: lv_reads_8_0= ruleDataReferenceRule
                            	    {

                            	    								newCompositeNode(grammarAccess.getStepRuleAccess().getReadsDataReferenceRuleParserRuleCall_4_2_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_15);
                            	    lv_reads_8_0=ruleDataReferenceRule();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getStepRuleRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"reads",
                            	    									lv_reads_8_0,
                            	    									"de.evoal.languages.model.instance.dsl.InstanceLanguage.DataReferenceRule");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop5;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getStepRuleAccess().getRightSquareBracketKeyword_4_3());
                    			
                    otherlv_10=(Token)match(input,13,FOLLOW_17); 

                    				newLeafNode(otherlv_10, grammarAccess.getStepRuleAccess().getSemicolonKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalGeneratorDSL.g:365:3: (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalGeneratorDSL.g:366:4: otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';'
                    {
                    otherlv_11=(Token)match(input,22,FOLLOW_9); 

                    				newLeafNode(otherlv_11, grammarAccess.getStepRuleAccess().getWritesKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,15,FOLLOW_14); 

                    				newLeafNode(otherlv_12, grammarAccess.getStepRuleAccess().getLeftSquareBracketKeyword_5_1());
                    			
                    // InternalGeneratorDSL.g:374:4: ( ( (lv_writes_13_0= ruleDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) ) )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==36) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalGeneratorDSL.g:375:5: ( (lv_writes_13_0= ruleDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) ) )*
                            {
                            // InternalGeneratorDSL.g:375:5: ( (lv_writes_13_0= ruleDataReferenceRule ) )
                            // InternalGeneratorDSL.g:376:6: (lv_writes_13_0= ruleDataReferenceRule )
                            {
                            // InternalGeneratorDSL.g:376:6: (lv_writes_13_0= ruleDataReferenceRule )
                            // InternalGeneratorDSL.g:377:7: lv_writes_13_0= ruleDataReferenceRule
                            {

                            							newCompositeNode(grammarAccess.getStepRuleAccess().getWritesDataReferenceRuleParserRuleCall_5_2_0_0());
                            						
                            pushFollow(FOLLOW_15);
                            lv_writes_13_0=ruleDataReferenceRule();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getStepRuleRule());
                            							}
                            							add(
                            								current,
                            								"writes",
                            								lv_writes_13_0,
                            								"de.evoal.languages.model.instance.dsl.InstanceLanguage.DataReferenceRule");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalGeneratorDSL.g:394:5: (otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) ) )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==21) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // InternalGeneratorDSL.g:395:6: otherlv_14= ',' ( (lv_writes_15_0= ruleDataReferenceRule ) )
                            	    {
                            	    otherlv_14=(Token)match(input,21,FOLLOW_16); 

                            	    						newLeafNode(otherlv_14, grammarAccess.getStepRuleAccess().getCommaKeyword_5_2_1_0());
                            	    					
                            	    // InternalGeneratorDSL.g:399:6: ( (lv_writes_15_0= ruleDataReferenceRule ) )
                            	    // InternalGeneratorDSL.g:400:7: (lv_writes_15_0= ruleDataReferenceRule )
                            	    {
                            	    // InternalGeneratorDSL.g:400:7: (lv_writes_15_0= ruleDataReferenceRule )
                            	    // InternalGeneratorDSL.g:401:8: lv_writes_15_0= ruleDataReferenceRule
                            	    {

                            	    								newCompositeNode(grammarAccess.getStepRuleAccess().getWritesDataReferenceRuleParserRuleCall_5_2_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_15);
                            	    lv_writes_15_0=ruleDataReferenceRule();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getStepRuleRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"writes",
                            	    									lv_writes_15_0,
                            	    									"de.evoal.languages.model.instance.dsl.InstanceLanguage.DataReferenceRule");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_16=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_16, grammarAccess.getStepRuleAccess().getRightSquareBracketKeyword_5_3());
                    			
                    otherlv_17=(Token)match(input,13,FOLLOW_18); 

                    				newLeafNode(otherlv_17, grammarAccess.getStepRuleAccess().getSemicolonKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_18=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getStepRuleAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleStepRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalGeneratorDSL.g:437:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalGeneratorDSL.g:437:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalGeneratorDSL.g:438:2: iv_ruleStatementRule= ruleStatementRule EOF
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
    // InternalGeneratorDSL.g:444:1: ruleStatementRule returns [EObject current=null] : (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatementRule_0 = null;

        EObject this_ApplyStatementRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:450:2: ( (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule ) )
            // InternalGeneratorDSL.g:451:2: (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule )
            {
            // InternalGeneratorDSL.g:451:2: (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            else if ( (LA11_0==30) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalGeneratorDSL.g:452:3: this_ForStatementRule_0= ruleForStatementRule
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
                    // InternalGeneratorDSL.g:461:3: this_ApplyStatementRule_1= ruleApplyStatementRule
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
    // InternalGeneratorDSL.g:473:1: entryRuleForStatementRule returns [EObject current=null] : iv_ruleForStatementRule= ruleForStatementRule EOF ;
    public final EObject entryRuleForStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatementRule = null;


        try {
            // InternalGeneratorDSL.g:473:57: (iv_ruleForStatementRule= ruleForStatementRule EOF )
            // InternalGeneratorDSL.g:474:2: iv_ruleForStatementRule= ruleForStatementRule EOF
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
    // InternalGeneratorDSL.g:480:1: ruleForStatementRule returns [EObject current=null] : (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' ) ;
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
            // InternalGeneratorDSL.g:486:2: ( (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' ) )
            // InternalGeneratorDSL.g:487:2: (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' )
            {
            // InternalGeneratorDSL.g:487:2: (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end' )
            // InternalGeneratorDSL.g:488:3: otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) otherlv_4= 'loop' ( (lv_statements_5_0= ruleStatementRule ) )* otherlv_6= 'end'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementRuleAccess().getForKeyword_0());
            		
            // InternalGeneratorDSL.g:492:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGeneratorDSL.g:493:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGeneratorDSL.g:493:4: (lv_name_1_0= RULE_ID )
            // InternalGeneratorDSL.g:494:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getForStatementRuleAccess().getInKeyword_2());
            		
            // InternalGeneratorDSL.g:514:3: ( (lv_range_3_0= ruleRangeRule ) )
            // InternalGeneratorDSL.g:515:4: (lv_range_3_0= ruleRangeRule )
            {
            // InternalGeneratorDSL.g:515:4: (lv_range_3_0= ruleRangeRule )
            // InternalGeneratorDSL.g:516:5: lv_range_3_0= ruleRangeRule
            {

            					newCompositeNode(grammarAccess.getForStatementRuleAccess().getRangeRangeRuleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_22);
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

            otherlv_4=(Token)match(input,26,FOLLOW_23); 

            			newLeafNode(otherlv_4, grammarAccess.getForStatementRuleAccess().getLoopKeyword_4());
            		
            // InternalGeneratorDSL.g:537:3: ( (lv_statements_5_0= ruleStatementRule ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24||LA12_0==30) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalGeneratorDSL.g:538:4: (lv_statements_5_0= ruleStatementRule )
            	    {
            	    // InternalGeneratorDSL.g:538:4: (lv_statements_5_0= ruleStatementRule )
            	    // InternalGeneratorDSL.g:539:5: lv_statements_5_0= ruleStatementRule
            	    {

            	    					newCompositeNode(grammarAccess.getForStatementRuleAccess().getStatementsStatementRuleParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_23);
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
            	    break loop12;
                }
            } while (true);

            otherlv_6=(Token)match(input,27,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:564:1: entryRuleRangeRule returns [EObject current=null] : iv_ruleRangeRule= ruleRangeRule EOF ;
    public final EObject entryRuleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeRule = null;


        try {
            // InternalGeneratorDSL.g:564:50: (iv_ruleRangeRule= ruleRangeRule EOF )
            // InternalGeneratorDSL.g:565:2: iv_ruleRangeRule= ruleRangeRule EOF
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
    // InternalGeneratorDSL.g:571:1: ruleRangeRule returns [EObject current=null] : (this_PipelineArrayRule_0= rulePipelineArrayRule | this_CounterRangeRule_1= ruleCounterRangeRule ) ;
    public final EObject ruleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineArrayRule_0 = null;

        EObject this_CounterRangeRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:577:2: ( (this_PipelineArrayRule_0= rulePipelineArrayRule | this_CounterRangeRule_1= ruleCounterRangeRule ) )
            // InternalGeneratorDSL.g:578:2: (this_PipelineArrayRule_0= rulePipelineArrayRule | this_CounterRangeRule_1= ruleCounterRangeRule )
            {
            // InternalGeneratorDSL.g:578:2: (this_PipelineArrayRule_0= rulePipelineArrayRule | this_CounterRangeRule_1= ruleCounterRangeRule )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==29) ) {
                alt13=1;
            }
            else if ( (LA13_0==15) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalGeneratorDSL.g:579:3: this_PipelineArrayRule_0= rulePipelineArrayRule
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
                    // InternalGeneratorDSL.g:588:3: this_CounterRangeRule_1= ruleCounterRangeRule
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
    // InternalGeneratorDSL.g:600:1: entryRuleCounterRangeRule returns [EObject current=null] : iv_ruleCounterRangeRule= ruleCounterRangeRule EOF ;
    public final EObject entryRuleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCounterRangeRule = null;


        try {
            // InternalGeneratorDSL.g:600:57: (iv_ruleCounterRangeRule= ruleCounterRangeRule EOF )
            // InternalGeneratorDSL.g:601:2: iv_ruleCounterRangeRule= ruleCounterRangeRule EOF
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
    // InternalGeneratorDSL.g:607:1: ruleCounterRangeRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' ) ;
    public final EObject ruleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_start_1_0=null;
        Token otherlv_2=null;
        Token lv_end_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:613:2: ( (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' ) )
            // InternalGeneratorDSL.g:614:2: (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' )
            {
            // InternalGeneratorDSL.g:614:2: (otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']' )
            // InternalGeneratorDSL.g:615:3: otherlv_0= '[' ( (lv_start_1_0= RULE_INT ) ) otherlv_2= 'to' ( (lv_end_3_0= RULE_INT ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_24); 

            			newLeafNode(otherlv_0, grammarAccess.getCounterRangeRuleAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalGeneratorDSL.g:619:3: ( (lv_start_1_0= RULE_INT ) )
            // InternalGeneratorDSL.g:620:4: (lv_start_1_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:620:4: (lv_start_1_0= RULE_INT )
            // InternalGeneratorDSL.g:621:5: lv_start_1_0= RULE_INT
            {
            lv_start_1_0=(Token)match(input,RULE_INT,FOLLOW_25); 

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

            otherlv_2=(Token)match(input,28,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getCounterRangeRuleAccess().getToKeyword_2());
            		
            // InternalGeneratorDSL.g:641:3: ( (lv_end_3_0= RULE_INT ) )
            // InternalGeneratorDSL.g:642:4: (lv_end_3_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:642:4: (lv_end_3_0= RULE_INT )
            // InternalGeneratorDSL.g:643:5: lv_end_3_0= RULE_INT
            {
            lv_end_3_0=(Token)match(input,RULE_INT,FOLLOW_26); 

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

            otherlv_4=(Token)match(input,16,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:667:1: entryRulePipelineArrayRule returns [EObject current=null] : iv_rulePipelineArrayRule= rulePipelineArrayRule EOF ;
    public final EObject entryRulePipelineArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineArrayRule = null;


        try {
            // InternalGeneratorDSL.g:667:58: (iv_rulePipelineArrayRule= rulePipelineArrayRule EOF )
            // InternalGeneratorDSL.g:668:2: iv_rulePipelineArrayRule= rulePipelineArrayRule EOF
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
    // InternalGeneratorDSL.g:674:1: rulePipelineArrayRule returns [EObject current=null] : ( () otherlv_1= 'pipelines' (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )? ) ;
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
            // InternalGeneratorDSL.g:680:2: ( ( () otherlv_1= 'pipelines' (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )? ) )
            // InternalGeneratorDSL.g:681:2: ( () otherlv_1= 'pipelines' (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )? )
            {
            // InternalGeneratorDSL.g:681:2: ( () otherlv_1= 'pipelines' (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )? )
            // InternalGeneratorDSL.g:682:3: () otherlv_1= 'pipelines' (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )?
            {
            // InternalGeneratorDSL.g:682:3: ()
            // InternalGeneratorDSL.g:683:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPipelineArrayRuleAccess().getPipelineArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,29,FOLLOW_27); 

            			newLeafNode(otherlv_1, grammarAccess.getPipelineArrayRuleAccess().getPipelinesKeyword_1());
            		
            // InternalGeneratorDSL.g:693:3: (otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalGeneratorDSL.g:694:4: otherlv_2= '[' ( (lv_references_3_0= rulePipelineReferenceRule ) ) (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_28); 

                    				newLeafNode(otherlv_2, grammarAccess.getPipelineArrayRuleAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalGeneratorDSL.g:698:4: ( (lv_references_3_0= rulePipelineReferenceRule ) )
                    // InternalGeneratorDSL.g:699:5: (lv_references_3_0= rulePipelineReferenceRule )
                    {
                    // InternalGeneratorDSL.g:699:5: (lv_references_3_0= rulePipelineReferenceRule )
                    // InternalGeneratorDSL.g:700:6: lv_references_3_0= rulePipelineReferenceRule
                    {

                    						newCompositeNode(grammarAccess.getPipelineArrayRuleAccess().getReferencesPipelineReferenceRuleParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_15);
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

                    // InternalGeneratorDSL.g:717:4: (otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==21) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:718:5: otherlv_4= ',' ( (lv_references_5_0= rulePipelineReferenceRule ) )
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_28); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPipelineArrayRuleAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalGeneratorDSL.g:722:5: ( (lv_references_5_0= rulePipelineReferenceRule ) )
                    	    // InternalGeneratorDSL.g:723:6: (lv_references_5_0= rulePipelineReferenceRule )
                    	    {
                    	    // InternalGeneratorDSL.g:723:6: (lv_references_5_0= rulePipelineReferenceRule )
                    	    // InternalGeneratorDSL.g:724:7: lv_references_5_0= rulePipelineReferenceRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getPipelineArrayRuleAccess().getReferencesPipelineReferenceRuleParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_15);
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
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:751:1: entryRulePipelineReferenceRule returns [EObject current=null] : iv_rulePipelineReferenceRule= rulePipelineReferenceRule EOF ;
    public final EObject entryRulePipelineReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:751:62: (iv_rulePipelineReferenceRule= rulePipelineReferenceRule EOF )
            // InternalGeneratorDSL.g:752:2: iv_rulePipelineReferenceRule= rulePipelineReferenceRule EOF
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
    // InternalGeneratorDSL.g:758:1: rulePipelineReferenceRule returns [EObject current=null] : (this_PipelineDefinitionReferenceRule_0= rulePipelineDefinitionReferenceRule | this_VariableReferenceRule_1= ruleVariableReferenceRule ) ;
    public final EObject rulePipelineReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineDefinitionReferenceRule_0 = null;

        EObject this_VariableReferenceRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:764:2: ( (this_PipelineDefinitionReferenceRule_0= rulePipelineDefinitionReferenceRule | this_VariableReferenceRule_1= ruleVariableReferenceRule ) )
            // InternalGeneratorDSL.g:765:2: (this_PipelineDefinitionReferenceRule_0= rulePipelineDefinitionReferenceRule | this_VariableReferenceRule_1= ruleVariableReferenceRule )
            {
            // InternalGeneratorDSL.g:765:2: (this_PipelineDefinitionReferenceRule_0= rulePipelineDefinitionReferenceRule | this_VariableReferenceRule_1= ruleVariableReferenceRule )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_ID) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalGeneratorDSL.g:766:3: this_PipelineDefinitionReferenceRule_0= rulePipelineDefinitionReferenceRule
                    {

                    			newCompositeNode(grammarAccess.getPipelineReferenceRuleAccess().getPipelineDefinitionReferenceRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineDefinitionReferenceRule_0=rulePipelineDefinitionReferenceRule();

                    state._fsp--;


                    			current = this_PipelineDefinitionReferenceRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:775:3: this_VariableReferenceRule_1= ruleVariableReferenceRule
                    {

                    			newCompositeNode(grammarAccess.getPipelineReferenceRuleAccess().getVariableReferenceRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableReferenceRule_1=ruleVariableReferenceRule();

                    state._fsp--;


                    			current = this_VariableReferenceRule_1;
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
    // $ANTLR end "rulePipelineReferenceRule"


    // $ANTLR start "entryRulePipelineDefinitionReferenceRule"
    // InternalGeneratorDSL.g:787:1: entryRulePipelineDefinitionReferenceRule returns [EObject current=null] : iv_rulePipelineDefinitionReferenceRule= rulePipelineDefinitionReferenceRule EOF ;
    public final EObject entryRulePipelineDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineDefinitionReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:787:72: (iv_rulePipelineDefinitionReferenceRule= rulePipelineDefinitionReferenceRule EOF )
            // InternalGeneratorDSL.g:788:2: iv_rulePipelineDefinitionReferenceRule= rulePipelineDefinitionReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getPipelineDefinitionReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineDefinitionReferenceRule=rulePipelineDefinitionReferenceRule();

            state._fsp--;

             current =iv_rulePipelineDefinitionReferenceRule; 
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
    // $ANTLR end "entryRulePipelineDefinitionReferenceRule"


    // $ANTLR start "rulePipelineDefinitionReferenceRule"
    // InternalGeneratorDSL.g:794:1: rulePipelineDefinitionReferenceRule returns [EObject current=null] : (otherlv_0= 'pipeline' ( ( ruleStringOrId ) ) ) ;
    public final EObject rulePipelineDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:800:2: ( (otherlv_0= 'pipeline' ( ( ruleStringOrId ) ) ) )
            // InternalGeneratorDSL.g:801:2: (otherlv_0= 'pipeline' ( ( ruleStringOrId ) ) )
            {
            // InternalGeneratorDSL.g:801:2: (otherlv_0= 'pipeline' ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:802:3: otherlv_0= 'pipeline' ( ( ruleStringOrId ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getPipelineDefinitionReferenceRuleAccess().getPipelineKeyword_0());
            		
            // InternalGeneratorDSL.g:806:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:807:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:807:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:808:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPipelineDefinitionReferenceRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPipelineDefinitionReferenceRuleAccess().getPipelinePipelineDefinitionCrossReference_1_0());
            				
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
    // $ANTLR end "rulePipelineDefinitionReferenceRule"


    // $ANTLR start "entryRuleVariableReferenceRule"
    // InternalGeneratorDSL.g:826:1: entryRuleVariableReferenceRule returns [EObject current=null] : iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF ;
    public final EObject entryRuleVariableReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:826:62: (iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF )
            // InternalGeneratorDSL.g:827:2: iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getVariableReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableReferenceRule=ruleVariableReferenceRule();

            state._fsp--;

             current =iv_ruleVariableReferenceRule; 
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
    // $ANTLR end "entryRuleVariableReferenceRule"


    // $ANTLR start "ruleVariableReferenceRule"
    // InternalGeneratorDSL.g:833:1: ruleVariableReferenceRule returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVariableReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:839:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalGeneratorDSL.g:840:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalGeneratorDSL.g:840:2: ( (otherlv_0= RULE_ID ) )
            // InternalGeneratorDSL.g:841:3: (otherlv_0= RULE_ID )
            {
            // InternalGeneratorDSL.g:841:3: (otherlv_0= RULE_ID )
            // InternalGeneratorDSL.g:842:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVariableReferenceRuleRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getVariableReferenceRuleAccess().getLoopForStatementCrossReference_0());
            			

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
    // $ANTLR end "ruleVariableReferenceRule"


    // $ANTLR start "entryRuleApplyStatementRule"
    // InternalGeneratorDSL.g:856:1: entryRuleApplyStatementRule returns [EObject current=null] : iv_ruleApplyStatementRule= ruleApplyStatementRule EOF ;
    public final EObject entryRuleApplyStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplyStatementRule = null;


        try {
            // InternalGeneratorDSL.g:856:59: (iv_ruleApplyStatementRule= ruleApplyStatementRule EOF )
            // InternalGeneratorDSL.g:857:2: iv_ruleApplyStatementRule= ruleApplyStatementRule EOF
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
    // InternalGeneratorDSL.g:863:1: ruleApplyStatementRule returns [EObject current=null] : (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= rulePipelineReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' ) ;
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
            // InternalGeneratorDSL.g:869:2: ( (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= rulePipelineReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' ) )
            // InternalGeneratorDSL.g:870:2: (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= rulePipelineReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' )
            {
            // InternalGeneratorDSL.g:870:2: (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= rulePipelineReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' )
            // InternalGeneratorDSL.g:871:3: otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= RULE_INT ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= rulePipelineReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getApplyStatementRuleAccess().getWriteKeyword_0());
            		
            // InternalGeneratorDSL.g:875:3: ( (lv_file_1_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:876:4: (lv_file_1_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:876:4: (lv_file_1_0= RULE_STRING )
            // InternalGeneratorDSL.g:877:5: lv_file_1_0= RULE_STRING
            {
            lv_file_1_0=(Token)match(input,RULE_STRING,FOLLOW_29); 

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

            otherlv_2=(Token)match(input,31,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getApplyStatementRuleAccess().getWithKeyword_2());
            		
            // InternalGeneratorDSL.g:897:3: ( (lv_count_3_0= RULE_INT ) )
            // InternalGeneratorDSL.g:898:4: (lv_count_3_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:898:4: (lv_count_3_0= RULE_INT )
            // InternalGeneratorDSL.g:899:5: lv_count_3_0= RULE_INT
            {
            lv_count_3_0=(Token)match(input,RULE_INT,FOLLOW_30); 

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

            otherlv_4=(Token)match(input,32,FOLLOW_31); 

            			newLeafNode(otherlv_4, grammarAccess.getApplyStatementRuleAccess().getSamplesKeyword_4());
            		
            otherlv_5=(Token)match(input,33,FOLLOW_32); 

            			newLeafNode(otherlv_5, grammarAccess.getApplyStatementRuleAccess().getFromKeyword_5());
            		
            otherlv_6=(Token)match(input,34,FOLLOW_9); 

            			newLeafNode(otherlv_6, grammarAccess.getApplyStatementRuleAccess().getExecutingKeyword_6());
            		
            otherlv_7=(Token)match(input,15,FOLLOW_28); 

            			newLeafNode(otherlv_7, grammarAccess.getApplyStatementRuleAccess().getLeftSquareBracketKeyword_7());
            		
            // InternalGeneratorDSL.g:931:3: ( (lv_pipelines_8_0= rulePipelineReferenceRule ) )
            // InternalGeneratorDSL.g:932:4: (lv_pipelines_8_0= rulePipelineReferenceRule )
            {
            // InternalGeneratorDSL.g:932:4: (lv_pipelines_8_0= rulePipelineReferenceRule )
            // InternalGeneratorDSL.g:933:5: lv_pipelines_8_0= rulePipelineReferenceRule
            {

            					newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getPipelinesPipelineReferenceRuleParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_15);
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

            // InternalGeneratorDSL.g:950:3: (otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==21) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalGeneratorDSL.g:951:4: otherlv_9= ',' ( (lv_pipelines_10_0= rulePipelineReferenceRule ) )
            	    {
            	    otherlv_9=(Token)match(input,21,FOLLOW_28); 

            	    				newLeafNode(otherlv_9, grammarAccess.getApplyStatementRuleAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalGeneratorDSL.g:955:4: ( (lv_pipelines_10_0= rulePipelineReferenceRule ) )
            	    // InternalGeneratorDSL.g:956:5: (lv_pipelines_10_0= rulePipelineReferenceRule )
            	    {
            	    // InternalGeneratorDSL.g:956:5: (lv_pipelines_10_0= rulePipelineReferenceRule )
            	    // InternalGeneratorDSL.g:957:6: lv_pipelines_10_0= rulePipelineReferenceRule
            	    {

            	    						newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getPipelinesPipelineReferenceRuleParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
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
            	    break loop17;
                }
            } while (true);

            otherlv_11=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_11, grammarAccess.getApplyStatementRuleAccess().getRightSquareBracketKeyword_10());
            		
            otherlv_12=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getApplyStatementRuleAccess().getSemicolonKeyword_11());
            		

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
    // InternalGeneratorDSL.g:987:1: entryRuleInstanceRule returns [EObject current=null] : iv_ruleInstanceRule= ruleInstanceRule EOF ;
    public final EObject entryRuleInstanceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceRule = null;


        try {
            // InternalGeneratorDSL.g:987:53: (iv_ruleInstanceRule= ruleInstanceRule EOF )
            // InternalGeneratorDSL.g:988:2: iv_ruleInstanceRule= ruleInstanceRule EOF
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
    // InternalGeneratorDSL.g:994:1: ruleInstanceRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleInstanceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1000:2: ( ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) )
            // InternalGeneratorDSL.g:1001:2: ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            {
            // InternalGeneratorDSL.g:1001:2: ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            // InternalGeneratorDSL.g:1002:3: ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            {
            // InternalGeneratorDSL.g:1002:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:1003:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:1003:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:1004:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInstanceRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInstanceRuleAccess().getNameTypeDefinitionCrossReference_0_0());
            				
            pushFollow(FOLLOW_33);
            ruleStringOrId();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:1018:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==18) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalGeneratorDSL.g:1019:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_1, grammarAccess.getInstanceRuleAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalGeneratorDSL.g:1023:4: ( (lv_attributes_2_0= ruleAttributeRule ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_ID)||LA18_0==RULE_QUOTED_ID) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:1024:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    {
                    	    // InternalGeneratorDSL.g:1024:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    // InternalGeneratorDSL.g:1025:6: lv_attributes_2_0= ruleAttributeRule
                    	    {

                    	    						newCompositeNode(grammarAccess.getInstanceRuleAccess().getAttributesAttributeRuleParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_34);
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
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,23,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:1051:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalGeneratorDSL.g:1051:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalGeneratorDSL.g:1052:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalGeneratorDSL.g:1058:1: ruleAttributeRule returns [EObject current=null] : ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1064:2: ( ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) )
            // InternalGeneratorDSL.g:1065:2: ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            {
            // InternalGeneratorDSL.g:1065:2: ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            // InternalGeneratorDSL.g:1066:3: ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';'
            {
            // InternalGeneratorDSL.g:1066:3: ( (lv_name_0_0= ruleNameOrMiscRule ) )
            // InternalGeneratorDSL.g:1067:4: (lv_name_0_0= ruleNameOrMiscRule )
            {
            // InternalGeneratorDSL.g:1067:4: (lv_name_0_0= ruleNameOrMiscRule )
            // InternalGeneratorDSL.g:1068:5: lv_name_0_0= ruleNameOrMiscRule
            {

            					newCompositeNode(grammarAccess.getAttributeRuleAccess().getNameNameOrMiscRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_35);
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

            otherlv_1=(Token)match(input,35,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
            		
            // InternalGeneratorDSL.g:1089:3: ( (lv_value_2_0= ruleValueRule ) )
            // InternalGeneratorDSL.g:1090:4: (lv_value_2_0= ruleValueRule )
            {
            // InternalGeneratorDSL.g:1090:4: (lv_value_2_0= ruleValueRule )
            // InternalGeneratorDSL.g:1091:5: lv_value_2_0= ruleValueRule
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
    // InternalGeneratorDSL.g:1116:1: entryRuleNameOrMiscRule returns [EObject current=null] : iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF ;
    public final EObject entryRuleNameOrMiscRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrMiscRule = null;


        try {
            // InternalGeneratorDSL.g:1116:55: (iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF )
            // InternalGeneratorDSL.g:1117:2: iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF
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
    // InternalGeneratorDSL.g:1123:1: ruleNameOrMiscRule returns [EObject current=null] : (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule ) ;
    public final EObject ruleNameOrMiscRule() throws RecognitionException {
        EObject current = null;

        EObject this_NameRule_0 = null;

        EObject this_MiscRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1129:2: ( (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule ) )
            // InternalGeneratorDSL.g:1130:2: (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule )
            {
            // InternalGeneratorDSL.g:1130:2: (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID||LA20_0==RULE_QUOTED_ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_STRING) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalGeneratorDSL.g:1131:3: this_NameRule_0= ruleNameRule
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
                    // InternalGeneratorDSL.g:1140:3: this_MiscRule_1= ruleMiscRule
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
    // InternalGeneratorDSL.g:1152:1: entryRuleNameRule returns [EObject current=null] : iv_ruleNameRule= ruleNameRule EOF ;
    public final EObject entryRuleNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameRule = null;


        try {
            // InternalGeneratorDSL.g:1152:49: (iv_ruleNameRule= ruleNameRule EOF )
            // InternalGeneratorDSL.g:1153:2: iv_ruleNameRule= ruleNameRule EOF
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
    // InternalGeneratorDSL.g:1159:1: ruleNameRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1165:2: ( ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:1166:2: ( ( ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:1166:2: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:1167:3: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:1167:3: ( ruleStringOrId )
            // InternalGeneratorDSL.g:1168:4: ruleStringOrId
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
    // InternalGeneratorDSL.g:1185:1: entryRuleMiscRule returns [EObject current=null] : iv_ruleMiscRule= ruleMiscRule EOF ;
    public final EObject entryRuleMiscRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMiscRule = null;


        try {
            // InternalGeneratorDSL.g:1185:49: (iv_ruleMiscRule= ruleMiscRule EOF )
            // InternalGeneratorDSL.g:1186:2: iv_ruleMiscRule= ruleMiscRule EOF
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
    // InternalGeneratorDSL.g:1192:1: ruleMiscRule returns [EObject current=null] : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final EObject ruleMiscRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1198:2: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // InternalGeneratorDSL.g:1199:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // InternalGeneratorDSL.g:1199:2: ( (lv_name_0_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:1200:3: (lv_name_0_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:1200:3: (lv_name_0_0= RULE_STRING )
            // InternalGeneratorDSL.g:1201:4: lv_name_0_0= RULE_STRING
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
    // InternalGeneratorDSL.g:1220:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // InternalGeneratorDSL.g:1220:50: (iv_ruleValueRule= ruleValueRule EOF )
            // InternalGeneratorDSL.g:1221:2: iv_ruleValueRule= ruleValueRule EOF
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
    // InternalGeneratorDSL.g:1227:1: ruleValueRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_DataReferenceRule_1 = null;

        EObject this_InstanceRule_2 = null;

        EObject this_LiteralValueRule_3 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1233:2: ( (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) )
            // InternalGeneratorDSL.g:1234:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            {
            // InternalGeneratorDSL.g:1234:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt21=1;
                }
                break;
            case 36:
                {
                alt21=2;
                }
                break;
            case RULE_ID:
            case RULE_QUOTED_ID:
                {
                alt21=3;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case 46:
            case 47:
                {
                alt21=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalGeneratorDSL.g:1235:3: this_ArrayRule_0= ruleArrayRule
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
                    // InternalGeneratorDSL.g:1244:3: this_DataReferenceRule_1= ruleDataReferenceRule
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
                    // InternalGeneratorDSL.g:1253:3: this_InstanceRule_2= ruleInstanceRule
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
                    // InternalGeneratorDSL.g:1262:3: this_LiteralValueRule_3= ruleLiteralValueRule
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
    // InternalGeneratorDSL.g:1274:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalGeneratorDSL.g:1274:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalGeneratorDSL.g:1275:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalGeneratorDSL.g:1281:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1287:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) )
            // InternalGeneratorDSL.g:1288:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalGeneratorDSL.g:1288:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            // InternalGeneratorDSL.g:1289:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']'
            {
            // InternalGeneratorDSL.g:1289:3: ()
            // InternalGeneratorDSL.g:1290:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArrayRuleAccess().getArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalGeneratorDSL.g:1300:3: ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_STRING && LA23_0<=RULE_QUOTED_ID)||LA23_0==15||LA23_0==36||(LA23_0>=46 && LA23_0<=47)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalGeneratorDSL.g:1301:4: ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    {
                    // InternalGeneratorDSL.g:1301:4: ( (lv_values_2_0= ruleValueRule ) )
                    // InternalGeneratorDSL.g:1302:5: (lv_values_2_0= ruleValueRule )
                    {
                    // InternalGeneratorDSL.g:1302:5: (lv_values_2_0= ruleValueRule )
                    // InternalGeneratorDSL.g:1303:6: lv_values_2_0= ruleValueRule
                    {

                    						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_15);
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

                    // InternalGeneratorDSL.g:1320:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==21) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:1321:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_36); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalGeneratorDSL.g:1325:5: ( (lv_values_4_0= ruleValueRule ) )
                    	    // InternalGeneratorDSL.g:1326:6: (lv_values_4_0= ruleValueRule )
                    	    {
                    	    // InternalGeneratorDSL.g:1326:6: (lv_values_4_0= ruleValueRule )
                    	    // InternalGeneratorDSL.g:1327:7: lv_values_4_0= ruleValueRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_15);
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
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:1354:1: entryRuleLiteralValueRule returns [EObject current=null] : iv_ruleLiteralValueRule= ruleLiteralValueRule EOF ;
    public final EObject entryRuleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValueRule = null;


        try {
            // InternalGeneratorDSL.g:1354:57: (iv_ruleLiteralValueRule= ruleLiteralValueRule EOF )
            // InternalGeneratorDSL.g:1355:2: iv_ruleLiteralValueRule= ruleLiteralValueRule EOF
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
    // InternalGeneratorDSL.g:1361:1: ruleLiteralValueRule returns [EObject current=null] : ( (lv_literal_0_0= ruleLiteralRule ) ) ;
    public final EObject ruleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject lv_literal_0_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1367:2: ( ( (lv_literal_0_0= ruleLiteralRule ) ) )
            // InternalGeneratorDSL.g:1368:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            {
            // InternalGeneratorDSL.g:1368:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            // InternalGeneratorDSL.g:1369:3: (lv_literal_0_0= ruleLiteralRule )
            {
            // InternalGeneratorDSL.g:1369:3: (lv_literal_0_0= ruleLiteralRule )
            // InternalGeneratorDSL.g:1370:4: lv_literal_0_0= ruleLiteralRule
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
    // InternalGeneratorDSL.g:1390:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:1390:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalGeneratorDSL.g:1391:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
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
    // InternalGeneratorDSL.g:1397:1: ruleDataReferenceRule returns [EObject current=null] : ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1403:2: ( ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) )
            // InternalGeneratorDSL.g:1404:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            {
            // InternalGeneratorDSL.g:1404:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:1405:3: () otherlv_1= 'data' ( ( ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:1405:3: ()
            // InternalGeneratorDSL.g:1406:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,36,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1());
            		
            // InternalGeneratorDSL.g:1416:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:1417:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:1417:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:1418:5: ruleStringOrId
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
    // InternalGeneratorDSL.g:1436:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1436:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalGeneratorDSL.g:1437:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalGeneratorDSL.g:1443:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1449:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalGeneratorDSL.g:1450:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalGeneratorDSL.g:1461:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1461:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalGeneratorDSL.g:1462:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalGeneratorDSL.g:1468:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1474:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1475:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1475:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1476:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1476:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalGeneratorDSL.g:1477:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalGeneratorDSL.g:1477:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalGeneratorDSL.g:1478:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {

            					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
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

            // InternalGeneratorDSL.g:1495:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==37) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1496:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FOLLOW_39); 

            	    				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	    			
            	    // InternalGeneratorDSL.g:1500:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalGeneratorDSL.g:1501:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1501:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalGeneratorDSL.g:1502:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_38);
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
    // $ANTLR end "ruleOrExpressionRule"


    // $ANTLR start "entryRuleXorExpressionRule"
    // InternalGeneratorDSL.g:1524:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1524:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalGeneratorDSL.g:1525:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalGeneratorDSL.g:1531:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1537:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1538:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1538:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1539:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1539:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalGeneratorDSL.g:1540:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalGeneratorDSL.g:1540:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalGeneratorDSL.g:1541:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {

            					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_40);
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

            // InternalGeneratorDSL.g:1558:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==38) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1559:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,38,FOLLOW_39); 

            	    				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	    			
            	    // InternalGeneratorDSL.g:1563:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalGeneratorDSL.g:1564:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1564:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalGeneratorDSL.g:1565:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
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
    // $ANTLR end "ruleXorExpressionRule"


    // $ANTLR start "entryRuleAndExpressionRule"
    // InternalGeneratorDSL.g:1587:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1587:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalGeneratorDSL.g:1588:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalGeneratorDSL.g:1594:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1600:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1601:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1601:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1602:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1602:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalGeneratorDSL.g:1603:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalGeneratorDSL.g:1603:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalGeneratorDSL.g:1604:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {

            					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_41);
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

            // InternalGeneratorDSL.g:1621:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==39) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1622:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,39,FOLLOW_39); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	    			
            	    // InternalGeneratorDSL.g:1626:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalGeneratorDSL.g:1627:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1627:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalGeneratorDSL.g:1628:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
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
    // $ANTLR end "ruleAndExpressionRule"


    // $ANTLR start "entryRuleNotExpressionRule"
    // InternalGeneratorDSL.g:1650:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1650:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalGeneratorDSL.g:1651:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalGeneratorDSL.g:1657:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1663:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalGeneratorDSL.g:1664:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalGeneratorDSL.g:1664:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalGeneratorDSL.g:1665:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalGeneratorDSL.g:1665:3: ( (lv_negated_0_0= '!' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalGeneratorDSL.g:1666:4: (lv_negated_0_0= '!' )
                    {
                    // InternalGeneratorDSL.g:1666:4: (lv_negated_0_0= '!' )
                    // InternalGeneratorDSL.g:1667:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,40,FOLLOW_39); 

                    					newLeafNode(lv_negated_0_0, grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNotExpressionRuleRule());
                    					}
                    					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "!");
                    				

                    }


                    }
                    break;

            }

            // InternalGeneratorDSL.g:1679:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalGeneratorDSL.g:1680:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalGeneratorDSL.g:1680:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalGeneratorDSL.g:1681:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalGeneratorDSL.g:1702:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1702:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalGeneratorDSL.g:1703:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalGeneratorDSL.g:1709:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1715:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalGeneratorDSL.g:1716:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalGeneratorDSL.g:1716:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalGeneratorDSL.g:1717:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalGeneratorDSL.g:1717:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:1718:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:1718:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:1719:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_42);
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

            // InternalGeneratorDSL.g:1736:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=49 && LA28_0<=54)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1737:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1737:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalGeneratorDSL.g:1738:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {

            	    					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_42);
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
            	    break loop28;
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
    // InternalGeneratorDSL.g:1759:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1759:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalGeneratorDSL.g:1760:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalGeneratorDSL.g:1766:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1772:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalGeneratorDSL.g:1773:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalGeneratorDSL.g:1773:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalGeneratorDSL.g:1774:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalGeneratorDSL.g:1774:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalGeneratorDSL.g:1775:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalGeneratorDSL.g:1775:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalGeneratorDSL.g:1776:5: lv_operator_0_0= ruleComparisonOperatorRule
            {

            					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_39);
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

            // InternalGeneratorDSL.g:1793:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:1794:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:1794:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:1795:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalGeneratorDSL.g:1816:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1816:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalGeneratorDSL.g:1817:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalGeneratorDSL.g:1823:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1829:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1830:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1830:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1831:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1831:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalGeneratorDSL.g:1832:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalGeneratorDSL.g:1832:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalGeneratorDSL.g:1833:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {

            					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_43);
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

            // InternalGeneratorDSL.g:1850:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=55 && LA29_0<=56)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1851:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalGeneratorDSL.g:1851:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalGeneratorDSL.g:1852:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:1852:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalGeneratorDSL.g:1853:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_39);
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

            	    // InternalGeneratorDSL.g:1870:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalGeneratorDSL.g:1871:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1871:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalGeneratorDSL.g:1872:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_43);
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
            	    break loop29;
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
    // InternalGeneratorDSL.g:1894:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1894:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalGeneratorDSL.g:1895:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalGeneratorDSL.g:1901:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1907:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1908:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1908:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1909:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1909:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalGeneratorDSL.g:1910:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalGeneratorDSL.g:1910:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalGeneratorDSL.g:1911:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {

            					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_44);
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

            // InternalGeneratorDSL.g:1928:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=57 && LA30_0<=59)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1929:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalGeneratorDSL.g:1929:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalGeneratorDSL.g:1930:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:1930:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalGeneratorDSL.g:1931:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_39);
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

            	    // InternalGeneratorDSL.g:1948:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalGeneratorDSL.g:1949:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1949:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalGeneratorDSL.g:1950:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	    break loop30;
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
    // InternalGeneratorDSL.g:1972:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1972:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalGeneratorDSL.g:1973:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalGeneratorDSL.g:1979:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1985:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalGeneratorDSL.g:1986:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalGeneratorDSL.g:1986:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalGeneratorDSL.g:1987:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalGeneratorDSL.g:1987:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:1988:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:1988:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:1989:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_45);
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

            // InternalGeneratorDSL.g:2006:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==41) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalGeneratorDSL.g:2007:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,41,FOLLOW_39); 

                    				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                    			
                    // InternalGeneratorDSL.g:2011:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalGeneratorDSL.g:2012:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalGeneratorDSL.g:2012:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalGeneratorDSL.g:2013:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalGeneratorDSL.g:2035:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:2035:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalGeneratorDSL.g:2036:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalGeneratorDSL.g:2042:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2048:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) )
            // InternalGeneratorDSL.g:2049:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            {
            // InternalGeneratorDSL.g:2049:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            // InternalGeneratorDSL.g:2050:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            {
            // InternalGeneratorDSL.g:2050:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=55 && LA32_0<=56)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalGeneratorDSL.g:2051:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:2051:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalGeneratorDSL.g:2052:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {

            	    					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_39);
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
            	    break loop32;
                }
            } while (true);

            // InternalGeneratorDSL.g:2069:3: ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            // InternalGeneratorDSL.g:2070:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            {
            // InternalGeneratorDSL.g:2070:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            // InternalGeneratorDSL.g:2071:5: lv_subExpression_1_0= ruleLiteralOrReferenceRule
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
    // InternalGeneratorDSL.g:2092:1: entryRuleLiteralOrReferenceRule returns [EObject current=null] : iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF ;
    public final EObject entryRuleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:2092:63: (iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF )
            // InternalGeneratorDSL.g:2093:2: iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF
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
    // InternalGeneratorDSL.g:2099:1: ruleLiteralOrReferenceRule returns [EObject current=null] : (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) ;
    public final EObject ruleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallRule_0 = null;

        EObject this_LiteralRule_1 = null;

        EObject this_ParanthesesRule_2 = null;

        EObject this_ValueReferenceRule_3 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2105:2: ( (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) )
            // InternalGeneratorDSL.g:2106:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            {
            // InternalGeneratorDSL.g:2106:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            int alt33=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt33=1;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case 46:
            case 47:
                {
                alt33=2;
                }
                break;
            case 42:
                {
                alt33=3;
                }
                break;
            case 45:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalGeneratorDSL.g:2107:3: this_CallRule_0= ruleCallRule
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
                    // InternalGeneratorDSL.g:2116:3: this_LiteralRule_1= ruleLiteralRule
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
                    // InternalGeneratorDSL.g:2125:3: this_ParanthesesRule_2= ruleParanthesesRule
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
                    // InternalGeneratorDSL.g:2134:3: this_ValueReferenceRule_3= ruleValueReferenceRule
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
    // InternalGeneratorDSL.g:2146:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalGeneratorDSL.g:2146:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalGeneratorDSL.g:2147:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalGeneratorDSL.g:2153:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2159:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalGeneratorDSL.g:2160:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalGeneratorDSL.g:2160:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalGeneratorDSL.g:2161:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_39); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
            		
            // InternalGeneratorDSL.g:2165:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalGeneratorDSL.g:2166:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalGeneratorDSL.g:2166:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalGeneratorDSL.g:2167:5: lv_subExpression_1_0= ruleExpressionRule
            {

            					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_46);
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

            otherlv_2=(Token)match(input,43,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2192:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalGeneratorDSL.g:2192:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalGeneratorDSL.g:2193:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalGeneratorDSL.g:2199:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalGeneratorDSL.g:2205:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalGeneratorDSL.g:2206:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalGeneratorDSL.g:2206:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalGeneratorDSL.g:2207:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalGeneratorDSL.g:2207:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalGeneratorDSL.g:2208:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalGeneratorDSL.g:2208:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalGeneratorDSL.g:2209:5: lv_function_0_0= ruleFunctionNameRule
            {

            					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_47);
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

            otherlv_1=(Token)match(input,42,FOLLOW_48); 

            			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
            		
            // InternalGeneratorDSL.g:2230:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_STRING||LA35_0==RULE_INT||LA35_0==40||LA35_0==42||(LA35_0>=44 && LA35_0<=47)||(LA35_0>=55 && LA35_0<=56)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalGeneratorDSL.g:2231:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalGeneratorDSL.g:2231:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalGeneratorDSL.g:2232:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalGeneratorDSL.g:2232:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalGeneratorDSL.g:2233:6: lv_parameters_2_0= ruleExpressionRule
                    {

                    						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_49);
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

                    // InternalGeneratorDSL.g:2250:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==21) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:2251:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_39); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalGeneratorDSL.g:2255:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalGeneratorDSL.g:2256:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalGeneratorDSL.g:2256:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalGeneratorDSL.g:2257:7: lv_parameters_4_0= ruleExpressionRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_49);
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
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,43,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2284:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalGeneratorDSL.g:2284:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalGeneratorDSL.g:2285:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
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
    // InternalGeneratorDSL.g:2291:1: ruleFunctionNameRule returns [EObject current=null] : ( () otherlv_1= 'call' ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2297:2: ( ( () otherlv_1= 'call' ) )
            // InternalGeneratorDSL.g:2298:2: ( () otherlv_1= 'call' )
            {
            // InternalGeneratorDSL.g:2298:2: ( () otherlv_1= 'call' )
            // InternalGeneratorDSL.g:2299:3: () otherlv_1= 'call'
            {
            // InternalGeneratorDSL.g:2299:3: ()
            // InternalGeneratorDSL.g:2300:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFunctionNameRuleAccess().getFunctionNameAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,44,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2314:1: entryRuleValueReferenceRule returns [EObject current=null] : iv_ruleValueReferenceRule= ruleValueReferenceRule EOF ;
    public final EObject entryRuleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:2314:59: (iv_ruleValueReferenceRule= ruleValueReferenceRule EOF )
            // InternalGeneratorDSL.g:2315:2: iv_ruleValueReferenceRule= ruleValueReferenceRule EOF
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
    // InternalGeneratorDSL.g:2321:1: ruleValueReferenceRule returns [EObject current=null] : ( () otherlv_1= 'value' ) ;
    public final EObject ruleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2327:2: ( ( () otherlv_1= 'value' ) )
            // InternalGeneratorDSL.g:2328:2: ( () otherlv_1= 'value' )
            {
            // InternalGeneratorDSL.g:2328:2: ( () otherlv_1= 'value' )
            // InternalGeneratorDSL.g:2329:3: () otherlv_1= 'value'
            {
            // InternalGeneratorDSL.g:2329:3: ()
            // InternalGeneratorDSL.g:2330:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,45,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2344:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2344:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalGeneratorDSL.g:2345:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalGeneratorDSL.g:2351:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2357:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) )
            // InternalGeneratorDSL.g:2358:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            {
            // InternalGeneratorDSL.g:2358:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            int alt36=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt36=1;
                }
                break;
            case RULE_STRING:
                {
                alt36=2;
                }
                break;
            case 46:
            case 47:
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
                    // InternalGeneratorDSL.g:2359:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalGeneratorDSL.g:2368:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalGeneratorDSL.g:2377:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
    // InternalGeneratorDSL.g:2389:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2389:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalGeneratorDSL.g:2390:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalGeneratorDSL.g:2396:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2402:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalGeneratorDSL.g:2403:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalGeneratorDSL.g:2403:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_INT) ) {
                int LA37_1 = input.LA(2);

                if ( ((LA37_1>=60 && LA37_1<=79)) ) {
                    alt37=2;
                }
                else if ( (LA37_1==48) ) {
                    alt37=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalGeneratorDSL.g:2404:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
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
                    // InternalGeneratorDSL.g:2413:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalGeneratorDSL.g:2425:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2425:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalGeneratorDSL.g:2426:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
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
    // InternalGeneratorDSL.g:2432:1: ruleDoubleLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= ruleDOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) ) ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_literal_0_0 = null;

        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2438:2: ( ( ( (lv_literal_0_0= ruleDOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) ) ) )
            // InternalGeneratorDSL.g:2439:2: ( ( (lv_literal_0_0= ruleDOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) ) )
            {
            // InternalGeneratorDSL.g:2439:2: ( ( (lv_literal_0_0= ruleDOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) ) )
            // InternalGeneratorDSL.g:2440:3: ( (lv_literal_0_0= ruleDOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )
            {
            // InternalGeneratorDSL.g:2440:3: ( (lv_literal_0_0= ruleDOUBLE ) )
            // InternalGeneratorDSL.g:2441:4: (lv_literal_0_0= ruleDOUBLE )
            {
            // InternalGeneratorDSL.g:2441:4: (lv_literal_0_0= ruleDOUBLE )
            // InternalGeneratorDSL.g:2442:5: lv_literal_0_0= ruleDOUBLE
            {

            					newCompositeNode(grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLEParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_50);
            lv_literal_0_0=ruleDOUBLE();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDoubleLiteralRuleRule());
            					}
            					set(
            						current,
            						"literal",
            						lv_literal_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.DOUBLE");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGeneratorDSL.g:2459:3: ( (lv_factor_1_0= ruleFactorRule ) )
            // InternalGeneratorDSL.g:2460:4: (lv_factor_1_0= ruleFactorRule )
            {
            // InternalGeneratorDSL.g:2460:4: (lv_factor_1_0= ruleFactorRule )
            // InternalGeneratorDSL.g:2461:5: lv_factor_1_0= ruleFactorRule
            {

            					newCompositeNode(grammarAccess.getDoubleLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_factor_1_0=ruleFactorRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDoubleLiteralRuleRule());
            					}
            					set(
            						current,
            						"factor",
            						lv_factor_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.FactorRule");
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
    // $ANTLR end "ruleDoubleLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // InternalGeneratorDSL.g:2482:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2482:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalGeneratorDSL.g:2483:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalGeneratorDSL.g:2489:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2495:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) ) ) )
            // InternalGeneratorDSL.g:2496:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) ) )
            {
            // InternalGeneratorDSL.g:2496:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) ) )
            // InternalGeneratorDSL.g:2497:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )
            {
            // InternalGeneratorDSL.g:2497:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalGeneratorDSL.g:2498:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:2498:4: (lv_literal_0_0= RULE_INT )
            // InternalGeneratorDSL.g:2499:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_50); 

            					newLeafNode(lv_literal_0_0, grammarAccess.getIntegerLiteralRuleAccess().getLiteralINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntegerLiteralRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"literal",
            						lv_literal_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGeneratorDSL.g:2515:3: ( (lv_factor_1_0= ruleFactorRule ) )
            // InternalGeneratorDSL.g:2516:4: (lv_factor_1_0= ruleFactorRule )
            {
            // InternalGeneratorDSL.g:2516:4: (lv_factor_1_0= ruleFactorRule )
            // InternalGeneratorDSL.g:2517:5: lv_factor_1_0= ruleFactorRule
            {

            					newCompositeNode(grammarAccess.getIntegerLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_factor_1_0=ruleFactorRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntegerLiteralRuleRule());
            					}
            					set(
            						current,
            						"factor",
            						lv_factor_1_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.FactorRule");
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
    // $ANTLR end "ruleIntegerLiteralRule"


    // $ANTLR start "entryRuleStringLiteralRule"
    // InternalGeneratorDSL.g:2538:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2538:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalGeneratorDSL.g:2539:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalGeneratorDSL.g:2545:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2551:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalGeneratorDSL.g:2552:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalGeneratorDSL.g:2552:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:2553:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:2553:3: (lv_value_0_0= RULE_STRING )
            // InternalGeneratorDSL.g:2554:4: lv_value_0_0= RULE_STRING
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
    // InternalGeneratorDSL.g:2573:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2573:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalGeneratorDSL.g:2574:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalGeneratorDSL.g:2580:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2586:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalGeneratorDSL.g:2587:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalGeneratorDSL.g:2587:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalGeneratorDSL.g:2588:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalGeneratorDSL.g:2588:3: ()
            // InternalGeneratorDSL.g:2589:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalGeneratorDSL.g:2595:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==46) ) {
                alt38=1;
            }
            else if ( (LA38_0==47) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalGeneratorDSL.g:2596:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalGeneratorDSL.g:2596:4: ( (lv_value_1_0= 'true' ) )
                    // InternalGeneratorDSL.g:2597:5: (lv_value_1_0= 'true' )
                    {
                    // InternalGeneratorDSL.g:2597:5: (lv_value_1_0= 'true' )
                    // InternalGeneratorDSL.g:2598:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,46,FOLLOW_2); 

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
                    // InternalGeneratorDSL.g:2611:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2620:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalGeneratorDSL.g:2620:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalGeneratorDSL.g:2621:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalGeneratorDSL.g:2627:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2633:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalGeneratorDSL.g:2634:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalGeneratorDSL.g:2634:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_QUOTED_ID) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_ID) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalGeneratorDSL.g:2635:3: this_QUOTED_ID_0= RULE_QUOTED_ID
                    {
                    this_QUOTED_ID_0=(Token)match(input,RULE_QUOTED_ID,FOLLOW_2); 

                    			current.merge(this_QUOTED_ID_0);
                    		

                    			newLeafNode(this_QUOTED_ID_0, grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2643:3: this_ID_1= RULE_ID
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
    // InternalGeneratorDSL.g:2654:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // InternalGeneratorDSL.g:2654:46: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // InternalGeneratorDSL.g:2655:2: iv_ruleDOUBLE= ruleDOUBLE EOF
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
    // InternalGeneratorDSL.g:2661:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2667:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalGeneratorDSL.g:2668:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalGeneratorDSL.g:2668:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalGeneratorDSL.g:2669:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_51); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,48,FOLLOW_24); 

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
    // InternalGeneratorDSL.g:2692:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalGeneratorDSL.g:2698:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalGeneratorDSL.g:2699:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalGeneratorDSL.g:2699:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt40=6;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt40=1;
                }
                break;
            case 50:
                {
                alt40=2;
                }
                break;
            case 51:
                {
                alt40=3;
                }
                break;
            case 52:
                {
                alt40=4;
                }
                break;
            case 53:
                {
                alt40=5;
                }
                break;
            case 54:
                {
                alt40=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalGeneratorDSL.g:2700:3: (enumLiteral_0= '>=' )
                    {
                    // InternalGeneratorDSL.g:2700:3: (enumLiteral_0= '>=' )
                    // InternalGeneratorDSL.g:2701:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2708:3: (enumLiteral_1= '>' )
                    {
                    // InternalGeneratorDSL.g:2708:3: (enumLiteral_1= '>' )
                    // InternalGeneratorDSL.g:2709:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:2716:3: (enumLiteral_2= '=' )
                    {
                    // InternalGeneratorDSL.g:2716:3: (enumLiteral_2= '=' )
                    // InternalGeneratorDSL.g:2717:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:2724:3: (enumLiteral_3= '!=' )
                    {
                    // InternalGeneratorDSL.g:2724:3: (enumLiteral_3= '!=' )
                    // InternalGeneratorDSL.g:2725:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGeneratorDSL.g:2732:3: (enumLiteral_4= '<' )
                    {
                    // InternalGeneratorDSL.g:2732:3: (enumLiteral_4= '<' )
                    // InternalGeneratorDSL.g:2733:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalGeneratorDSL.g:2740:3: (enumLiteral_5= '<=' )
                    {
                    // InternalGeneratorDSL.g:2740:3: (enumLiteral_5= '<=' )
                    // InternalGeneratorDSL.g:2741:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,54,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2751:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2757:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalGeneratorDSL.g:2758:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalGeneratorDSL.g:2758:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==55) ) {
                alt41=1;
            }
            else if ( (LA41_0==56) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalGeneratorDSL.g:2759:3: (enumLiteral_0= '+' )
                    {
                    // InternalGeneratorDSL.g:2759:3: (enumLiteral_0= '+' )
                    // InternalGeneratorDSL.g:2760:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2767:3: (enumLiteral_1= '-' )
                    {
                    // InternalGeneratorDSL.g:2767:3: (enumLiteral_1= '-' )
                    // InternalGeneratorDSL.g:2768:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); 

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
    // InternalGeneratorDSL.g:2778:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2784:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalGeneratorDSL.g:2785:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalGeneratorDSL.g:2785:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt42=3;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt42=1;
                }
                break;
            case 58:
                {
                alt42=2;
                }
                break;
            case 59:
                {
                alt42=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalGeneratorDSL.g:2786:3: (enumLiteral_0= '*' )
                    {
                    // InternalGeneratorDSL.g:2786:3: (enumLiteral_0= '*' )
                    // InternalGeneratorDSL.g:2787:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2794:3: (enumLiteral_1= '/' )
                    {
                    // InternalGeneratorDSL.g:2794:3: (enumLiteral_1= '/' )
                    // InternalGeneratorDSL.g:2795:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:2802:3: (enumLiteral_2= '%' )
                    {
                    // InternalGeneratorDSL.g:2802:3: (enumLiteral_2= '%' )
                    // InternalGeneratorDSL.g:2803:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_2); 

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


    // $ANTLR start "ruleFactorRule"
    // InternalGeneratorDSL.g:2813:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
    public final Enumerator ruleFactorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2819:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalGeneratorDSL.g:2820:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalGeneratorDSL.g:2820:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt43=20;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt43=1;
                }
                break;
            case 61:
                {
                alt43=2;
                }
                break;
            case 62:
                {
                alt43=3;
                }
                break;
            case 63:
                {
                alt43=4;
                }
                break;
            case 64:
                {
                alt43=5;
                }
                break;
            case 65:
                {
                alt43=6;
                }
                break;
            case 66:
                {
                alt43=7;
                }
                break;
            case 67:
                {
                alt43=8;
                }
                break;
            case 68:
                {
                alt43=9;
                }
                break;
            case 69:
                {
                alt43=10;
                }
                break;
            case 70:
                {
                alt43=11;
                }
                break;
            case 71:
                {
                alt43=12;
                }
                break;
            case 72:
                {
                alt43=13;
                }
                break;
            case 73:
                {
                alt43=14;
                }
                break;
            case 74:
                {
                alt43=15;
                }
                break;
            case 75:
                {
                alt43=16;
                }
                break;
            case 76:
                {
                alt43=17;
                }
                break;
            case 77:
                {
                alt43=18;
                }
                break;
            case 78:
                {
                alt43=19;
                }
                break;
            case 79:
                {
                alt43=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalGeneratorDSL.g:2821:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalGeneratorDSL.g:2821:3: (enumLiteral_0= 'Y' )
                    // InternalGeneratorDSL.g:2822:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2829:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalGeneratorDSL.g:2829:3: (enumLiteral_1= 'Z' )
                    // InternalGeneratorDSL.g:2830:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:2837:3: (enumLiteral_2= 'E' )
                    {
                    // InternalGeneratorDSL.g:2837:3: (enumLiteral_2= 'E' )
                    // InternalGeneratorDSL.g:2838:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:2845:3: (enumLiteral_3= 'P' )
                    {
                    // InternalGeneratorDSL.g:2845:3: (enumLiteral_3= 'P' )
                    // InternalGeneratorDSL.g:2846:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGeneratorDSL.g:2853:3: (enumLiteral_4= 'T' )
                    {
                    // InternalGeneratorDSL.g:2853:3: (enumLiteral_4= 'T' )
                    // InternalGeneratorDSL.g:2854:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalGeneratorDSL.g:2861:3: (enumLiteral_5= 'G' )
                    {
                    // InternalGeneratorDSL.g:2861:3: (enumLiteral_5= 'G' )
                    // InternalGeneratorDSL.g:2862:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalGeneratorDSL.g:2869:3: (enumLiteral_6= 'M' )
                    {
                    // InternalGeneratorDSL.g:2869:3: (enumLiteral_6= 'M' )
                    // InternalGeneratorDSL.g:2870:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalGeneratorDSL.g:2877:3: (enumLiteral_7= 'k' )
                    {
                    // InternalGeneratorDSL.g:2877:3: (enumLiteral_7= 'k' )
                    // InternalGeneratorDSL.g:2878:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalGeneratorDSL.g:2885:3: (enumLiteral_8= 'h' )
                    {
                    // InternalGeneratorDSL.g:2885:3: (enumLiteral_8= 'h' )
                    // InternalGeneratorDSL.g:2886:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalGeneratorDSL.g:2893:3: (enumLiteral_9= 'da' )
                    {
                    // InternalGeneratorDSL.g:2893:3: (enumLiteral_9= 'da' )
                    // InternalGeneratorDSL.g:2894:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalGeneratorDSL.g:2901:3: (enumLiteral_10= 'd' )
                    {
                    // InternalGeneratorDSL.g:2901:3: (enumLiteral_10= 'd' )
                    // InternalGeneratorDSL.g:2902:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalGeneratorDSL.g:2909:3: (enumLiteral_11= 'c' )
                    {
                    // InternalGeneratorDSL.g:2909:3: (enumLiteral_11= 'c' )
                    // InternalGeneratorDSL.g:2910:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalGeneratorDSL.g:2917:3: (enumLiteral_12= 'm' )
                    {
                    // InternalGeneratorDSL.g:2917:3: (enumLiteral_12= 'm' )
                    // InternalGeneratorDSL.g:2918:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalGeneratorDSL.g:2925:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalGeneratorDSL.g:2925:3: (enumLiteral_13= '\\u00B5' )
                    // InternalGeneratorDSL.g:2926:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalGeneratorDSL.g:2933:3: (enumLiteral_14= 'n' )
                    {
                    // InternalGeneratorDSL.g:2933:3: (enumLiteral_14= 'n' )
                    // InternalGeneratorDSL.g:2934:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalGeneratorDSL.g:2941:3: (enumLiteral_15= 'p' )
                    {
                    // InternalGeneratorDSL.g:2941:3: (enumLiteral_15= 'p' )
                    // InternalGeneratorDSL.g:2942:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalGeneratorDSL.g:2949:3: (enumLiteral_16= 'f' )
                    {
                    // InternalGeneratorDSL.g:2949:3: (enumLiteral_16= 'f' )
                    // InternalGeneratorDSL.g:2950:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalGeneratorDSL.g:2957:3: (enumLiteral_17= 'a' )
                    {
                    // InternalGeneratorDSL.g:2957:3: (enumLiteral_17= 'a' )
                    // InternalGeneratorDSL.g:2958:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalGeneratorDSL.g:2965:3: (enumLiteral_18= 'z' )
                    {
                    // InternalGeneratorDSL.g:2965:3: (enumLiteral_18= 'z' )
                    // InternalGeneratorDSL.g:2966:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalGeneratorDSL.g:2973:3: (enumLiteral_19= 'y' )
                    {
                    // InternalGeneratorDSL.g:2973:3: (enumLiteral_19= 'y' )
                    // InternalGeneratorDSL.g:2974:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19());
                    			

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
    // $ANTLR end "ruleFactorRule"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000041005002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000041004002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000041000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000D00000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000001000010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000049000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00000000008000B0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000C010000080F0L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000C010000180F0L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0180F510000080F0L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x007E000000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0E00000000000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0180FD10000080F0L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000080000200000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0xF000000000000000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001000000000000L});

}
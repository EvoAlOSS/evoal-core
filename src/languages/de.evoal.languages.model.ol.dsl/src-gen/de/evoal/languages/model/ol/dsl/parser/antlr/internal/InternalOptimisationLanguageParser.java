package de.evoal.languages.model.ol.dsl.parser.antlr.internal;

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
import de.evoal.languages.model.ol.dsl.services.OptimisationLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOptimisationLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_QUOTED_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'use'", "';'", "'constraints'", "'{'", "'}'", "':='", "'['", "','", "']'", "'data'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'('", "')'", "'value'", "'true'", "'false'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
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
    public static final int RULE_QUOTED_ID=8;
    public static final int RULE_DIGIT=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__37=37;
    public static final int RULE_DOUBLE=6;
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
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
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

    // delegates
    // delegators


        public InternalOptimisationLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOptimisationLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOptimisationLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOptimisationLanguage.g"; }



     	private OptimisationLanguageGrammarAccess grammarAccess;

        public InternalOptimisationLanguageParser(TokenStream input, OptimisationLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "OptimisationModelRule";
       	}

       	@Override
       	protected OptimisationLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleOptimisationModelRule"
    // InternalOptimisationLanguage.g:66:1: entryRuleOptimisationModelRule returns [EObject current=null] : iv_ruleOptimisationModelRule= ruleOptimisationModelRule EOF ;
    public final EObject entryRuleOptimisationModelRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptimisationModelRule = null;


        try {
            // InternalOptimisationLanguage.g:66:62: (iv_ruleOptimisationModelRule= ruleOptimisationModelRule EOF )
            // InternalOptimisationLanguage.g:67:2: iv_ruleOptimisationModelRule= ruleOptimisationModelRule EOF
            {
             newCompositeNode(grammarAccess.getOptimisationModelRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptimisationModelRule=ruleOptimisationModelRule();

            state._fsp--;

             current =iv_ruleOptimisationModelRule; 
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
    // $ANTLR end "entryRuleOptimisationModelRule"


    // $ANTLR start "ruleOptimisationModelRule"
    // InternalOptimisationLanguage.g:73:1: ruleOptimisationModelRule returns [EObject current=null] : ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_instance_1_0= ruleInstanceRule ) ) ( (lv_constraints_2_0= ruleConstraintRule ) )? ) ;
    public final EObject ruleOptimisationModelRule() throws RecognitionException {
        EObject current = null;

        EObject lv_uses_0_0 = null;

        EObject lv_instance_1_0 = null;

        EObject lv_constraints_2_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:79:2: ( ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_instance_1_0= ruleInstanceRule ) ) ( (lv_constraints_2_0= ruleConstraintRule ) )? ) )
            // InternalOptimisationLanguage.g:80:2: ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_instance_1_0= ruleInstanceRule ) ) ( (lv_constraints_2_0= ruleConstraintRule ) )? )
            {
            // InternalOptimisationLanguage.g:80:2: ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_instance_1_0= ruleInstanceRule ) ) ( (lv_constraints_2_0= ruleConstraintRule ) )? )
            // InternalOptimisationLanguage.g:81:3: ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_instance_1_0= ruleInstanceRule ) ) ( (lv_constraints_2_0= ruleConstraintRule ) )?
            {
            // InternalOptimisationLanguage.g:81:3: ( (lv_uses_0_0= ruleUseRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:82:4: (lv_uses_0_0= ruleUseRule )
            	    {
            	    // InternalOptimisationLanguage.g:82:4: (lv_uses_0_0= ruleUseRule )
            	    // InternalOptimisationLanguage.g:83:5: lv_uses_0_0= ruleUseRule
            	    {

            	    					newCompositeNode(grammarAccess.getOptimisationModelRuleAccess().getUsesUseRuleParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_uses_0_0=ruleUseRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOptimisationModelRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"uses",
            	    						lv_uses_0_0,
            	    						"de.evoal.languages.model.ol.dsl.OptimisationLanguage.UseRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalOptimisationLanguage.g:100:3: ( (lv_instance_1_0= ruleInstanceRule ) )
            // InternalOptimisationLanguage.g:101:4: (lv_instance_1_0= ruleInstanceRule )
            {
            // InternalOptimisationLanguage.g:101:4: (lv_instance_1_0= ruleInstanceRule )
            // InternalOptimisationLanguage.g:102:5: lv_instance_1_0= ruleInstanceRule
            {

            					newCompositeNode(grammarAccess.getOptimisationModelRuleAccess().getInstanceInstanceRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_instance_1_0=ruleInstanceRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOptimisationModelRuleRule());
            					}
            					set(
            						current,
            						"instance",
            						lv_instance_1_0,
            						"de.evoal.languages.model.instance.dsl.InstanceLanguage.InstanceRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOptimisationLanguage.g:119:3: ( (lv_constraints_2_0= ruleConstraintRule ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalOptimisationLanguage.g:120:4: (lv_constraints_2_0= ruleConstraintRule )
                    {
                    // InternalOptimisationLanguage.g:120:4: (lv_constraints_2_0= ruleConstraintRule )
                    // InternalOptimisationLanguage.g:121:5: lv_constraints_2_0= ruleConstraintRule
                    {

                    					newCompositeNode(grammarAccess.getOptimisationModelRuleAccess().getConstraintsConstraintRuleParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_constraints_2_0=ruleConstraintRule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOptimisationModelRuleRule());
                    					}
                    					set(
                    						current,
                    						"constraints",
                    						lv_constraints_2_0,
                    						"de.evoal.languages.model.ol.dsl.OptimisationLanguage.ConstraintRule");
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
    // $ANTLR end "ruleOptimisationModelRule"


    // $ANTLR start "entryRuleUseRule"
    // InternalOptimisationLanguage.g:142:1: entryRuleUseRule returns [EObject current=null] : iv_ruleUseRule= ruleUseRule EOF ;
    public final EObject entryRuleUseRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseRule = null;


        try {
            // InternalOptimisationLanguage.g:142:48: (iv_ruleUseRule= ruleUseRule EOF )
            // InternalOptimisationLanguage.g:143:2: iv_ruleUseRule= ruleUseRule EOF
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
    // InternalOptimisationLanguage.g:149:1: ruleUseRule returns [EObject current=null] : (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) ;
    public final EObject ruleUseRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:155:2: ( (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) )
            // InternalOptimisationLanguage.g:156:2: (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            {
            // InternalOptimisationLanguage.g:156:2: (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            // InternalOptimisationLanguage.g:157:3: otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getUseRuleAccess().getUseKeyword_0());
            		
            // InternalOptimisationLanguage.g:161:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalOptimisationLanguage.g:162:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalOptimisationLanguage.g:162:4: (lv_importURI_1_0= RULE_STRING )
            // InternalOptimisationLanguage.g:163:5: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_6); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_2); 

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


    // $ANTLR start "entryRuleConstraintRule"
    // InternalOptimisationLanguage.g:187:1: entryRuleConstraintRule returns [EObject current=null] : iv_ruleConstraintRule= ruleConstraintRule EOF ;
    public final EObject entryRuleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRule = null;


        try {
            // InternalOptimisationLanguage.g:187:55: (iv_ruleConstraintRule= ruleConstraintRule EOF )
            // InternalOptimisationLanguage.g:188:2: iv_ruleConstraintRule= ruleConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraintRule=ruleConstraintRule();

            state._fsp--;

             current =iv_ruleConstraintRule; 
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
    // $ANTLR end "entryRuleConstraintRule"


    // $ANTLR start "ruleConstraintRule"
    // InternalOptimisationLanguage.g:194:1: ruleConstraintRule returns [EObject current=null] : ( () otherlv_1= 'constraints' otherlv_2= '{' ( (lv_statements_3_0= ruleConstraintStatementRule ) )* otherlv_4= '}' ) ;
    public final EObject ruleConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_statements_3_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:200:2: ( ( () otherlv_1= 'constraints' otherlv_2= '{' ( (lv_statements_3_0= ruleConstraintStatementRule ) )* otherlv_4= '}' ) )
            // InternalOptimisationLanguage.g:201:2: ( () otherlv_1= 'constraints' otherlv_2= '{' ( (lv_statements_3_0= ruleConstraintStatementRule ) )* otherlv_4= '}' )
            {
            // InternalOptimisationLanguage.g:201:2: ( () otherlv_1= 'constraints' otherlv_2= '{' ( (lv_statements_3_0= ruleConstraintStatementRule ) )* otherlv_4= '}' )
            // InternalOptimisationLanguage.g:202:3: () otherlv_1= 'constraints' otherlv_2= '{' ( (lv_statements_3_0= ruleConstraintStatementRule ) )* otherlv_4= '}'
            {
            // InternalOptimisationLanguage.g:202:3: ()
            // InternalOptimisationLanguage.g:203:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConstraintRuleAccess().getConstraintAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getConstraintRuleAccess().getConstraintsKeyword_1());
            		
            otherlv_2=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintRuleAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOptimisationLanguage.g:217:3: ( (lv_statements_3_0= ruleConstraintStatementRule ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:218:4: (lv_statements_3_0= ruleConstraintStatementRule )
            	    {
            	    // InternalOptimisationLanguage.g:218:4: (lv_statements_3_0= ruleConstraintStatementRule )
            	    // InternalOptimisationLanguage.g:219:5: lv_statements_3_0= ruleConstraintStatementRule
            	    {

            	    					newCompositeNode(grammarAccess.getConstraintRuleAccess().getStatementsConstraintStatementRuleParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_statements_3_0=ruleConstraintStatementRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConstraintRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_3_0,
            	    						"de.evoal.languages.model.ol.dsl.OptimisationLanguage.ConstraintStatementRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getConstraintRuleAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleConstraintRule"


    // $ANTLR start "entryRuleConstraintStatementRule"
    // InternalOptimisationLanguage.g:244:1: entryRuleConstraintStatementRule returns [EObject current=null] : iv_ruleConstraintStatementRule= ruleConstraintStatementRule EOF ;
    public final EObject entryRuleConstraintStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintStatementRule = null;


        try {
            // InternalOptimisationLanguage.g:244:64: (iv_ruleConstraintStatementRule= ruleConstraintStatementRule EOF )
            // InternalOptimisationLanguage.g:245:2: iv_ruleConstraintStatementRule= ruleConstraintStatementRule EOF
            {
             newCompositeNode(grammarAccess.getConstraintStatementRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraintStatementRule=ruleConstraintStatementRule();

            state._fsp--;

             current =iv_ruleConstraintStatementRule; 
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
    // $ANTLR end "entryRuleConstraintStatementRule"


    // $ANTLR start "ruleConstraintStatementRule"
    // InternalOptimisationLanguage.g:251:1: ruleConstraintStatementRule returns [EObject current=null] : ( ( (lv_constraintExpression_0_0= ruleCallRule ) ) otherlv_1= ';' ) ;
    public final EObject ruleConstraintStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraintExpression_0_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:257:2: ( ( ( (lv_constraintExpression_0_0= ruleCallRule ) ) otherlv_1= ';' ) )
            // InternalOptimisationLanguage.g:258:2: ( ( (lv_constraintExpression_0_0= ruleCallRule ) ) otherlv_1= ';' )
            {
            // InternalOptimisationLanguage.g:258:2: ( ( (lv_constraintExpression_0_0= ruleCallRule ) ) otherlv_1= ';' )
            // InternalOptimisationLanguage.g:259:3: ( (lv_constraintExpression_0_0= ruleCallRule ) ) otherlv_1= ';'
            {
            // InternalOptimisationLanguage.g:259:3: ( (lv_constraintExpression_0_0= ruleCallRule ) )
            // InternalOptimisationLanguage.g:260:4: (lv_constraintExpression_0_0= ruleCallRule )
            {
            // InternalOptimisationLanguage.g:260:4: (lv_constraintExpression_0_0= ruleCallRule )
            // InternalOptimisationLanguage.g:261:5: lv_constraintExpression_0_0= ruleCallRule
            {

            					newCompositeNode(grammarAccess.getConstraintStatementRuleAccess().getConstraintExpressionCallRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_6);
            lv_constraintExpression_0_0=ruleCallRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintStatementRuleRule());
            					}
            					set(
            						current,
            						"constraintExpression",
            						lv_constraintExpression_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.CallRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getConstraintStatementRuleAccess().getSemicolonKeyword_1());
            		

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
    // $ANTLR end "ruleConstraintStatementRule"


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalOptimisationLanguage.g:286:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalOptimisationLanguage.g:286:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalOptimisationLanguage.g:287:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
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
    // InternalOptimisationLanguage.g:293:1: ruleFunctionNameRule returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:299:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalOptimisationLanguage.g:300:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalOptimisationLanguage.g:300:2: ( (otherlv_0= RULE_ID ) )
            // InternalOptimisationLanguage.g:301:3: (otherlv_0= RULE_ID )
            {
            // InternalOptimisationLanguage.g:301:3: (otherlv_0= RULE_ID )
            // InternalOptimisationLanguage.g:302:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getFunctionNameRuleRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0());
            			

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
    // $ANTLR end "ruleFunctionNameRule"


    // $ANTLR start "entryRuleInstanceRule"
    // InternalOptimisationLanguage.g:316:1: entryRuleInstanceRule returns [EObject current=null] : iv_ruleInstanceRule= ruleInstanceRule EOF ;
    public final EObject entryRuleInstanceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceRule = null;


        try {
            // InternalOptimisationLanguage.g:316:53: (iv_ruleInstanceRule= ruleInstanceRule EOF )
            // InternalOptimisationLanguage.g:317:2: iv_ruleInstanceRule= ruleInstanceRule EOF
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
    // InternalOptimisationLanguage.g:323:1: ruleInstanceRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleInstanceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:329:2: ( ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) )
            // InternalOptimisationLanguage.g:330:2: ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            {
            // InternalOptimisationLanguage.g:330:2: ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            // InternalOptimisationLanguage.g:331:3: ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            {
            // InternalOptimisationLanguage.g:331:3: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:332:4: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:332:4: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:333:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInstanceRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInstanceRuleAccess().getNameTypeDefinitionCrossReference_0_0());
            				
            pushFollow(FOLLOW_9);
            ruleStringOrId();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOptimisationLanguage.g:347:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalOptimisationLanguage.g:348:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_10); 

                    				newLeafNode(otherlv_1, grammarAccess.getInstanceRuleAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalOptimisationLanguage.g:352:4: ( (lv_attributes_2_0= ruleAttributeRule ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=RULE_STRING && LA4_0<=RULE_ID)||LA4_0==RULE_QUOTED_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalOptimisationLanguage.g:353:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    {
                    	    // InternalOptimisationLanguage.g:353:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    // InternalOptimisationLanguage.g:354:6: lv_attributes_2_0= ruleAttributeRule
                    	    {

                    	    						newCompositeNode(grammarAccess.getInstanceRuleAccess().getAttributesAttributeRuleParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
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
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,19,FOLLOW_2); 

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
    // InternalOptimisationLanguage.g:380:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalOptimisationLanguage.g:380:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalOptimisationLanguage.g:381:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalOptimisationLanguage.g:387:1: ruleAttributeRule returns [EObject current=null] : ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:393:2: ( ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) )
            // InternalOptimisationLanguage.g:394:2: ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            {
            // InternalOptimisationLanguage.g:394:2: ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            // InternalOptimisationLanguage.g:395:3: ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';'
            {
            // InternalOptimisationLanguage.g:395:3: ( (lv_name_0_0= ruleNameOrMiscRule ) )
            // InternalOptimisationLanguage.g:396:4: (lv_name_0_0= ruleNameOrMiscRule )
            {
            // InternalOptimisationLanguage.g:396:4: (lv_name_0_0= ruleNameOrMiscRule )
            // InternalOptimisationLanguage.g:397:5: lv_name_0_0= ruleNameOrMiscRule
            {

            					newCompositeNode(grammarAccess.getAttributeRuleAccess().getNameNameOrMiscRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
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

            otherlv_1=(Token)match(input,20,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
            		
            // InternalOptimisationLanguage.g:418:3: ( (lv_value_2_0= ruleValueRule ) )
            // InternalOptimisationLanguage.g:419:4: (lv_value_2_0= ruleValueRule )
            {
            // InternalOptimisationLanguage.g:419:4: (lv_value_2_0= ruleValueRule )
            // InternalOptimisationLanguage.g:420:5: lv_value_2_0= ruleValueRule
            {

            					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueValueRuleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
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

            otherlv_3=(Token)match(input,16,FOLLOW_2); 

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
    // InternalOptimisationLanguage.g:445:1: entryRuleNameOrMiscRule returns [EObject current=null] : iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF ;
    public final EObject entryRuleNameOrMiscRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrMiscRule = null;


        try {
            // InternalOptimisationLanguage.g:445:55: (iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF )
            // InternalOptimisationLanguage.g:446:2: iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF
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
    // InternalOptimisationLanguage.g:452:1: ruleNameOrMiscRule returns [EObject current=null] : (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule ) ;
    public final EObject ruleNameOrMiscRule() throws RecognitionException {
        EObject current = null;

        EObject this_NameRule_0 = null;

        EObject this_MiscRule_1 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:458:2: ( (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule ) )
            // InternalOptimisationLanguage.g:459:2: (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule )
            {
            // InternalOptimisationLanguage.g:459:2: (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||LA6_0==RULE_QUOTED_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_STRING) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalOptimisationLanguage.g:460:3: this_NameRule_0= ruleNameRule
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
                    // InternalOptimisationLanguage.g:469:3: this_MiscRule_1= ruleMiscRule
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
    // InternalOptimisationLanguage.g:481:1: entryRuleNameRule returns [EObject current=null] : iv_ruleNameRule= ruleNameRule EOF ;
    public final EObject entryRuleNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameRule = null;


        try {
            // InternalOptimisationLanguage.g:481:49: (iv_ruleNameRule= ruleNameRule EOF )
            // InternalOptimisationLanguage.g:482:2: iv_ruleNameRule= ruleNameRule EOF
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
    // InternalOptimisationLanguage.g:488:1: ruleNameRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:494:2: ( ( ( ruleStringOrId ) ) )
            // InternalOptimisationLanguage.g:495:2: ( ( ruleStringOrId ) )
            {
            // InternalOptimisationLanguage.g:495:2: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:496:3: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:496:3: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:497:4: ruleStringOrId
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
    // InternalOptimisationLanguage.g:514:1: entryRuleMiscRule returns [EObject current=null] : iv_ruleMiscRule= ruleMiscRule EOF ;
    public final EObject entryRuleMiscRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMiscRule = null;


        try {
            // InternalOptimisationLanguage.g:514:49: (iv_ruleMiscRule= ruleMiscRule EOF )
            // InternalOptimisationLanguage.g:515:2: iv_ruleMiscRule= ruleMiscRule EOF
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
    // InternalOptimisationLanguage.g:521:1: ruleMiscRule returns [EObject current=null] : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final EObject ruleMiscRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:527:2: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // InternalOptimisationLanguage.g:528:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // InternalOptimisationLanguage.g:528:2: ( (lv_name_0_0= RULE_STRING ) )
            // InternalOptimisationLanguage.g:529:3: (lv_name_0_0= RULE_STRING )
            {
            // InternalOptimisationLanguage.g:529:3: (lv_name_0_0= RULE_STRING )
            // InternalOptimisationLanguage.g:530:4: lv_name_0_0= RULE_STRING
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
    // InternalOptimisationLanguage.g:549:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // InternalOptimisationLanguage.g:549:50: (iv_ruleValueRule= ruleValueRule EOF )
            // InternalOptimisationLanguage.g:550:2: iv_ruleValueRule= ruleValueRule EOF
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
    // InternalOptimisationLanguage.g:556:1: ruleValueRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_DataReferenceRule_1 = null;

        EObject this_InstanceRule_2 = null;

        EObject this_LiteralValueRule_3 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:562:2: ( (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) )
            // InternalOptimisationLanguage.g:563:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            {
            // InternalOptimisationLanguage.g:563:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt7=1;
                }
                break;
            case 24:
                {
                alt7=2;
                }
                break;
            case RULE_ID:
            case RULE_QUOTED_ID:
                {
                alt7=3;
                }
                break;
            case RULE_STRING:
            case RULE_DOUBLE:
            case RULE_INT:
            case 33:
            case 34:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalOptimisationLanguage.g:564:3: this_ArrayRule_0= ruleArrayRule
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
                    // InternalOptimisationLanguage.g:573:3: this_DataReferenceRule_1= ruleDataReferenceRule
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
                    // InternalOptimisationLanguage.g:582:3: this_InstanceRule_2= ruleInstanceRule
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
                    // InternalOptimisationLanguage.g:591:3: this_LiteralValueRule_3= ruleLiteralValueRule
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
    // InternalOptimisationLanguage.g:603:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalOptimisationLanguage.g:603:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalOptimisationLanguage.g:604:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalOptimisationLanguage.g:610:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:616:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) )
            // InternalOptimisationLanguage.g:617:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalOptimisationLanguage.g:617:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            // InternalOptimisationLanguage.g:618:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']'
            {
            // InternalOptimisationLanguage.g:618:3: ()
            // InternalOptimisationLanguage.g:619:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArrayRuleAccess().getArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalOptimisationLanguage.g:629:3: ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_QUOTED_ID)||LA9_0==21||LA9_0==24||(LA9_0>=33 && LA9_0<=34)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalOptimisationLanguage.g:630:4: ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    {
                    // InternalOptimisationLanguage.g:630:4: ( (lv_values_2_0= ruleValueRule ) )
                    // InternalOptimisationLanguage.g:631:5: (lv_values_2_0= ruleValueRule )
                    {
                    // InternalOptimisationLanguage.g:631:5: (lv_values_2_0= ruleValueRule )
                    // InternalOptimisationLanguage.g:632:6: lv_values_2_0= ruleValueRule
                    {

                    						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_14);
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

                    // InternalOptimisationLanguage.g:649:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==22) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalOptimisationLanguage.g:650:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_12); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalOptimisationLanguage.g:654:5: ( (lv_values_4_0= ruleValueRule ) )
                    	    // InternalOptimisationLanguage.g:655:6: (lv_values_4_0= ruleValueRule )
                    	    {
                    	    // InternalOptimisationLanguage.g:655:6: (lv_values_4_0= ruleValueRule )
                    	    // InternalOptimisationLanguage.g:656:7: lv_values_4_0= ruleValueRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_14);
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
                    	    break loop8;
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
    // InternalOptimisationLanguage.g:683:1: entryRuleLiteralValueRule returns [EObject current=null] : iv_ruleLiteralValueRule= ruleLiteralValueRule EOF ;
    public final EObject entryRuleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValueRule = null;


        try {
            // InternalOptimisationLanguage.g:683:57: (iv_ruleLiteralValueRule= ruleLiteralValueRule EOF )
            // InternalOptimisationLanguage.g:684:2: iv_ruleLiteralValueRule= ruleLiteralValueRule EOF
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
    // InternalOptimisationLanguage.g:690:1: ruleLiteralValueRule returns [EObject current=null] : ( (lv_literal_0_0= ruleLiteralRule ) ) ;
    public final EObject ruleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject lv_literal_0_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:696:2: ( ( (lv_literal_0_0= ruleLiteralRule ) ) )
            // InternalOptimisationLanguage.g:697:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            {
            // InternalOptimisationLanguage.g:697:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            // InternalOptimisationLanguage.g:698:3: (lv_literal_0_0= ruleLiteralRule )
            {
            // InternalOptimisationLanguage.g:698:3: (lv_literal_0_0= ruleLiteralRule )
            // InternalOptimisationLanguage.g:699:4: lv_literal_0_0= ruleLiteralRule
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
    // InternalOptimisationLanguage.g:719:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalOptimisationLanguage.g:719:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalOptimisationLanguage.g:720:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
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
    // InternalOptimisationLanguage.g:726:1: ruleDataReferenceRule returns [EObject current=null] : ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:732:2: ( ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) )
            // InternalOptimisationLanguage.g:733:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            {
            // InternalOptimisationLanguage.g:733:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            // InternalOptimisationLanguage.g:734:3: () otherlv_1= 'data' ( ( ruleStringOrId ) )
            {
            // InternalOptimisationLanguage.g:734:3: ()
            // InternalOptimisationLanguage.g:735:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1());
            		
            // InternalOptimisationLanguage.g:745:3: ( ( ruleStringOrId ) )
            // InternalOptimisationLanguage.g:746:4: ( ruleStringOrId )
            {
            // InternalOptimisationLanguage.g:746:4: ( ruleStringOrId )
            // InternalOptimisationLanguage.g:747:5: ruleStringOrId
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
    // InternalOptimisationLanguage.g:765:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:765:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalOptimisationLanguage.g:766:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalOptimisationLanguage.g:772:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:778:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalOptimisationLanguage.g:779:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalOptimisationLanguage.g:790:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:790:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalOptimisationLanguage.g:791:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalOptimisationLanguage.g:797:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:803:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalOptimisationLanguage.g:804:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalOptimisationLanguage.g:804:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalOptimisationLanguage.g:805:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalOptimisationLanguage.g:805:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalOptimisationLanguage.g:806:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalOptimisationLanguage.g:806:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalOptimisationLanguage.g:807:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {

            					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_16);
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

            // InternalOptimisationLanguage.g:824:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==25) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:825:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_17); 

            	    				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	    			
            	    // InternalOptimisationLanguage.g:829:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalOptimisationLanguage.g:830:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalOptimisationLanguage.g:830:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalOptimisationLanguage.g:831:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
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
            	    break loop10;
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
    // InternalOptimisationLanguage.g:853:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:853:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalOptimisationLanguage.g:854:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalOptimisationLanguage.g:860:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:866:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalOptimisationLanguage.g:867:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalOptimisationLanguage.g:867:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalOptimisationLanguage.g:868:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalOptimisationLanguage.g:868:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalOptimisationLanguage.g:869:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalOptimisationLanguage.g:869:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalOptimisationLanguage.g:870:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {

            					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_18);
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

            // InternalOptimisationLanguage.g:887:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:888:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,26,FOLLOW_17); 

            	    				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	    			
            	    // InternalOptimisationLanguage.g:892:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalOptimisationLanguage.g:893:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalOptimisationLanguage.g:893:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalOptimisationLanguage.g:894:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_18);
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
            	    break loop11;
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
    // InternalOptimisationLanguage.g:916:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:916:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalOptimisationLanguage.g:917:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalOptimisationLanguage.g:923:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:929:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalOptimisationLanguage.g:930:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalOptimisationLanguage.g:930:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalOptimisationLanguage.g:931:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalOptimisationLanguage.g:931:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalOptimisationLanguage.g:932:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalOptimisationLanguage.g:932:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalOptimisationLanguage.g:933:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {

            					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_19);
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

            // InternalOptimisationLanguage.g:950:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==27) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:951:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,27,FOLLOW_17); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	    			
            	    // InternalOptimisationLanguage.g:955:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalOptimisationLanguage.g:956:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalOptimisationLanguage.g:956:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalOptimisationLanguage.g:957:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
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
            	    break loop12;
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
    // InternalOptimisationLanguage.g:979:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:979:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalOptimisationLanguage.g:980:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalOptimisationLanguage.g:986:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:992:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalOptimisationLanguage.g:993:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalOptimisationLanguage.g:993:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalOptimisationLanguage.g:994:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalOptimisationLanguage.g:994:3: ( (lv_negated_0_0= '!' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==28) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalOptimisationLanguage.g:995:4: (lv_negated_0_0= '!' )
                    {
                    // InternalOptimisationLanguage.g:995:4: (lv_negated_0_0= '!' )
                    // InternalOptimisationLanguage.g:996:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,28,FOLLOW_17); 

                    					newLeafNode(lv_negated_0_0, grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNotExpressionRuleRule());
                    					}
                    					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "!");
                    				

                    }


                    }
                    break;

            }

            // InternalOptimisationLanguage.g:1008:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalOptimisationLanguage.g:1009:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalOptimisationLanguage.g:1009:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalOptimisationLanguage.g:1010:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalOptimisationLanguage.g:1031:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:1031:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalOptimisationLanguage.g:1032:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalOptimisationLanguage.g:1038:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1044:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalOptimisationLanguage.g:1045:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalOptimisationLanguage.g:1045:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalOptimisationLanguage.g:1046:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalOptimisationLanguage.g:1046:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:1047:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:1047:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:1048:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
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

            // InternalOptimisationLanguage.g:1065:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=35 && LA14_0<=40)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:1066:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalOptimisationLanguage.g:1066:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalOptimisationLanguage.g:1067:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {

            	    					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_20);
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
            	    break loop14;
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
    // InternalOptimisationLanguage.g:1088:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:1088:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalOptimisationLanguage.g:1089:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalOptimisationLanguage.g:1095:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1101:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalOptimisationLanguage.g:1102:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalOptimisationLanguage.g:1102:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalOptimisationLanguage.g:1103:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalOptimisationLanguage.g:1103:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalOptimisationLanguage.g:1104:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalOptimisationLanguage.g:1104:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalOptimisationLanguage.g:1105:5: lv_operator_0_0= ruleComparisonOperatorRule
            {

            					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
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

            // InternalOptimisationLanguage.g:1122:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:1123:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:1123:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:1124:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalOptimisationLanguage.g:1145:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:1145:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalOptimisationLanguage.g:1146:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalOptimisationLanguage.g:1152:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1158:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalOptimisationLanguage.g:1159:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalOptimisationLanguage.g:1159:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalOptimisationLanguage.g:1160:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalOptimisationLanguage.g:1160:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalOptimisationLanguage.g:1161:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalOptimisationLanguage.g:1161:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalOptimisationLanguage.g:1162:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {

            					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_21);
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

            // InternalOptimisationLanguage.g:1179:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=41 && LA15_0<=42)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:1180:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalOptimisationLanguage.g:1180:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalOptimisationLanguage.g:1181:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalOptimisationLanguage.g:1181:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalOptimisationLanguage.g:1182:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_17);
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

            	    // InternalOptimisationLanguage.g:1199:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalOptimisationLanguage.g:1200:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalOptimisationLanguage.g:1200:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalOptimisationLanguage.g:1201:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_21);
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
            	    break loop15;
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
    // InternalOptimisationLanguage.g:1223:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:1223:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalOptimisationLanguage.g:1224:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalOptimisationLanguage.g:1230:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1236:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalOptimisationLanguage.g:1237:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalOptimisationLanguage.g:1237:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalOptimisationLanguage.g:1238:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalOptimisationLanguage.g:1238:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalOptimisationLanguage.g:1239:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalOptimisationLanguage.g:1239:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalOptimisationLanguage.g:1240:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {

            					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_22);
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

            // InternalOptimisationLanguage.g:1257:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=43 && LA16_0<=45)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:1258:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalOptimisationLanguage.g:1258:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalOptimisationLanguage.g:1259:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalOptimisationLanguage.g:1259:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalOptimisationLanguage.g:1260:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_17);
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

            	    // InternalOptimisationLanguage.g:1277:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalOptimisationLanguage.g:1278:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalOptimisationLanguage.g:1278:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalOptimisationLanguage.g:1279:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_22);
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
            	    break loop16;
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
    // InternalOptimisationLanguage.g:1301:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:1301:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalOptimisationLanguage.g:1302:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalOptimisationLanguage.g:1308:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1314:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalOptimisationLanguage.g:1315:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalOptimisationLanguage.g:1315:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalOptimisationLanguage.g:1316:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalOptimisationLanguage.g:1316:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalOptimisationLanguage.g:1317:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalOptimisationLanguage.g:1317:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalOptimisationLanguage.g:1318:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
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

            // InternalOptimisationLanguage.g:1335:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalOptimisationLanguage.g:1336:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_17); 

                    				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                    			
                    // InternalOptimisationLanguage.g:1340:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalOptimisationLanguage.g:1341:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalOptimisationLanguage.g:1341:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalOptimisationLanguage.g:1342:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalOptimisationLanguage.g:1364:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalOptimisationLanguage.g:1364:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalOptimisationLanguage.g:1365:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalOptimisationLanguage.g:1371:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1377:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) )
            // InternalOptimisationLanguage.g:1378:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            {
            // InternalOptimisationLanguage.g:1378:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            // InternalOptimisationLanguage.g:1379:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            {
            // InternalOptimisationLanguage.g:1379:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=41 && LA18_0<=42)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalOptimisationLanguage.g:1380:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalOptimisationLanguage.g:1380:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalOptimisationLanguage.g:1381:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {

            	    					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_17);
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
            	    break loop18;
                }
            } while (true);

            // InternalOptimisationLanguage.g:1398:3: ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            // InternalOptimisationLanguage.g:1399:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            {
            // InternalOptimisationLanguage.g:1399:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            // InternalOptimisationLanguage.g:1400:5: lv_subExpression_1_0= ruleLiteralOrReferenceRule
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
    // InternalOptimisationLanguage.g:1421:1: entryRuleLiteralOrReferenceRule returns [EObject current=null] : iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF ;
    public final EObject entryRuleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrReferenceRule = null;


        try {
            // InternalOptimisationLanguage.g:1421:63: (iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF )
            // InternalOptimisationLanguage.g:1422:2: iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF
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
    // InternalOptimisationLanguage.g:1428:1: ruleLiteralOrReferenceRule returns [EObject current=null] : (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) ;
    public final EObject ruleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallRule_0 = null;

        EObject this_LiteralRule_1 = null;

        EObject this_ParanthesesRule_2 = null;

        EObject this_ValueReferenceRule_3 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1434:2: ( (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) )
            // InternalOptimisationLanguage.g:1435:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            {
            // InternalOptimisationLanguage.g:1435:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            int alt19=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt19=1;
                }
                break;
            case RULE_STRING:
            case RULE_DOUBLE:
            case RULE_INT:
            case 33:
            case 34:
                {
                alt19=2;
                }
                break;
            case 30:
                {
                alt19=3;
                }
                break;
            case 32:
                {
                alt19=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalOptimisationLanguage.g:1436:3: this_CallRule_0= ruleCallRule
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
                    // InternalOptimisationLanguage.g:1445:3: this_LiteralRule_1= ruleLiteralRule
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
                    // InternalOptimisationLanguage.g:1454:3: this_ParanthesesRule_2= ruleParanthesesRule
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
                    // InternalOptimisationLanguage.g:1463:3: this_ValueReferenceRule_3= ruleValueReferenceRule
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
    // InternalOptimisationLanguage.g:1475:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalOptimisationLanguage.g:1475:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalOptimisationLanguage.g:1476:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalOptimisationLanguage.g:1482:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1488:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalOptimisationLanguage.g:1489:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalOptimisationLanguage.g:1489:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalOptimisationLanguage.g:1490:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
            		
            // InternalOptimisationLanguage.g:1494:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalOptimisationLanguage.g:1495:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalOptimisationLanguage.g:1495:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalOptimisationLanguage.g:1496:5: lv_subExpression_1_0= ruleExpressionRule
            {

            					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_2=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOptimisationLanguage.g:1521:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalOptimisationLanguage.g:1521:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalOptimisationLanguage.g:1522:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalOptimisationLanguage.g:1528:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalOptimisationLanguage.g:1534:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalOptimisationLanguage.g:1535:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalOptimisationLanguage.g:1535:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalOptimisationLanguage.g:1536:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalOptimisationLanguage.g:1536:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalOptimisationLanguage.g:1537:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalOptimisationLanguage.g:1537:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalOptimisationLanguage.g:1538:5: lv_function_0_0= ruleFunctionNameRule
            {

            					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_25);
            lv_function_0_0=ruleFunctionNameRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCallRuleRule());
            					}
            					set(
            						current,
            						"function",
            						lv_function_0_0,
            						"de.evoal.languages.model.ol.dsl.OptimisationLanguage.FunctionNameRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOptimisationLanguage.g:1559:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_STRING && LA21_0<=RULE_INT)||LA21_0==28||LA21_0==30||(LA21_0>=32 && LA21_0<=34)||(LA21_0>=41 && LA21_0<=42)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalOptimisationLanguage.g:1560:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalOptimisationLanguage.g:1560:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalOptimisationLanguage.g:1561:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalOptimisationLanguage.g:1561:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalOptimisationLanguage.g:1562:6: lv_parameters_2_0= ruleExpressionRule
                    {

                    						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_27);
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

                    // InternalOptimisationLanguage.g:1579:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==22) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalOptimisationLanguage.g:1580:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_17); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalOptimisationLanguage.g:1584:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalOptimisationLanguage.g:1585:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalOptimisationLanguage.g:1585:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalOptimisationLanguage.g:1586:7: lv_parameters_4_0= ruleExpressionRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_27);
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
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,31,FOLLOW_2); 

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


    // $ANTLR start "entryRuleValueReferenceRule"
    // InternalOptimisationLanguage.g:1613:1: entryRuleValueReferenceRule returns [EObject current=null] : iv_ruleValueReferenceRule= ruleValueReferenceRule EOF ;
    public final EObject entryRuleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueReferenceRule = null;


        try {
            // InternalOptimisationLanguage.g:1613:59: (iv_ruleValueReferenceRule= ruleValueReferenceRule EOF )
            // InternalOptimisationLanguage.g:1614:2: iv_ruleValueReferenceRule= ruleValueReferenceRule EOF
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
    // InternalOptimisationLanguage.g:1620:1: ruleValueReferenceRule returns [EObject current=null] : ( () otherlv_1= 'value' ) ;
    public final EObject ruleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1626:2: ( ( () otherlv_1= 'value' ) )
            // InternalOptimisationLanguage.g:1627:2: ( () otherlv_1= 'value' )
            {
            // InternalOptimisationLanguage.g:1627:2: ( () otherlv_1= 'value' )
            // InternalOptimisationLanguage.g:1628:3: () otherlv_1= 'value'
            {
            // InternalOptimisationLanguage.g:1628:3: ()
            // InternalOptimisationLanguage.g:1629:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,32,FOLLOW_2); 

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
    // InternalOptimisationLanguage.g:1643:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalOptimisationLanguage.g:1643:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalOptimisationLanguage.g:1644:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalOptimisationLanguage.g:1650:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1656:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) )
            // InternalOptimisationLanguage.g:1657:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            {
            // InternalOptimisationLanguage.g:1657:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            int alt22=3;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt22=1;
                }
                break;
            case RULE_STRING:
                {
                alt22=2;
                }
                break;
            case 33:
            case 34:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalOptimisationLanguage.g:1658:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalOptimisationLanguage.g:1667:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalOptimisationLanguage.g:1676:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
    // InternalOptimisationLanguage.g:1688:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalOptimisationLanguage.g:1688:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalOptimisationLanguage.g:1689:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalOptimisationLanguage.g:1695:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1701:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalOptimisationLanguage.g:1702:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalOptimisationLanguage.g:1702:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_DOUBLE) ) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_INT) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalOptimisationLanguage.g:1703:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
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
                    // InternalOptimisationLanguage.g:1712:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalOptimisationLanguage.g:1724:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalOptimisationLanguage.g:1724:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalOptimisationLanguage.g:1725:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
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
    // InternalOptimisationLanguage.g:1731:1: ruleDoubleLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1737:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalOptimisationLanguage.g:1738:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalOptimisationLanguage.g:1738:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalOptimisationLanguage.g:1739:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalOptimisationLanguage.g:1739:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalOptimisationLanguage.g:1740:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalOptimisationLanguage.g:1740:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalOptimisationLanguage.g:1741:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_28); 

            					newLeafNode(lv_literal_0_0, grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDoubleLiteralRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"literal",
            						lv_literal_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.DOUBLE");
            				

            }


            }

            // InternalOptimisationLanguage.g:1757:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=46 && LA24_0<=65)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalOptimisationLanguage.g:1758:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalOptimisationLanguage.g:1758:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalOptimisationLanguage.g:1759:5: lv_factor_1_0= ruleFactorRule
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
    // $ANTLR end "ruleDoubleLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // InternalOptimisationLanguage.g:1780:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalOptimisationLanguage.g:1780:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalOptimisationLanguage.g:1781:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalOptimisationLanguage.g:1787:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1793:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalOptimisationLanguage.g:1794:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalOptimisationLanguage.g:1794:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalOptimisationLanguage.g:1795:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalOptimisationLanguage.g:1795:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalOptimisationLanguage.g:1796:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalOptimisationLanguage.g:1796:4: (lv_literal_0_0= RULE_INT )
            // InternalOptimisationLanguage.g:1797:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_28); 

            					newLeafNode(lv_literal_0_0, grammarAccess.getIntegerLiteralRuleAccess().getLiteralINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntegerLiteralRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"literal",
            						lv_literal_0_0,
            						"de.evoal.languages.model.el.dsl.ExpressionLanguage.INT");
            				

            }


            }

            // InternalOptimisationLanguage.g:1813:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=46 && LA25_0<=65)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalOptimisationLanguage.g:1814:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalOptimisationLanguage.g:1814:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalOptimisationLanguage.g:1815:5: lv_factor_1_0= ruleFactorRule
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
    // $ANTLR end "ruleIntegerLiteralRule"


    // $ANTLR start "entryRuleStringLiteralRule"
    // InternalOptimisationLanguage.g:1836:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalOptimisationLanguage.g:1836:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalOptimisationLanguage.g:1837:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalOptimisationLanguage.g:1843:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1849:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalOptimisationLanguage.g:1850:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalOptimisationLanguage.g:1850:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalOptimisationLanguage.g:1851:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalOptimisationLanguage.g:1851:3: (lv_value_0_0= RULE_STRING )
            // InternalOptimisationLanguage.g:1852:4: lv_value_0_0= RULE_STRING
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
    // InternalOptimisationLanguage.g:1871:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalOptimisationLanguage.g:1871:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalOptimisationLanguage.g:1872:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalOptimisationLanguage.g:1878:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1884:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalOptimisationLanguage.g:1885:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalOptimisationLanguage.g:1885:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalOptimisationLanguage.g:1886:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalOptimisationLanguage.g:1886:3: ()
            // InternalOptimisationLanguage.g:1887:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalOptimisationLanguage.g:1893:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            else if ( (LA26_0==34) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalOptimisationLanguage.g:1894:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalOptimisationLanguage.g:1894:4: ( (lv_value_1_0= 'true' ) )
                    // InternalOptimisationLanguage.g:1895:5: (lv_value_1_0= 'true' )
                    {
                    // InternalOptimisationLanguage.g:1895:5: (lv_value_1_0= 'true' )
                    // InternalOptimisationLanguage.g:1896:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,33,FOLLOW_2); 

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
                    // InternalOptimisationLanguage.g:1909:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_2); 

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
    // InternalOptimisationLanguage.g:1918:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalOptimisationLanguage.g:1918:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalOptimisationLanguage.g:1919:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalOptimisationLanguage.g:1925:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:1931:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalOptimisationLanguage.g:1932:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalOptimisationLanguage.g:1932:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_QUOTED_ID) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_ID) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalOptimisationLanguage.g:1933:3: this_QUOTED_ID_0= RULE_QUOTED_ID
                    {
                    this_QUOTED_ID_0=(Token)match(input,RULE_QUOTED_ID,FOLLOW_2); 

                    			current.merge(this_QUOTED_ID_0);
                    		

                    			newLeafNode(this_QUOTED_ID_0, grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1941:3: this_ID_1= RULE_ID
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


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalOptimisationLanguage.g:1952:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalOptimisationLanguage.g:1958:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalOptimisationLanguage.g:1959:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalOptimisationLanguage.g:1959:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt28=6;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt28=1;
                }
                break;
            case 36:
                {
                alt28=2;
                }
                break;
            case 37:
                {
                alt28=3;
                }
                break;
            case 38:
                {
                alt28=4;
                }
                break;
            case 39:
                {
                alt28=5;
                }
                break;
            case 40:
                {
                alt28=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalOptimisationLanguage.g:1960:3: (enumLiteral_0= '>=' )
                    {
                    // InternalOptimisationLanguage.g:1960:3: (enumLiteral_0= '>=' )
                    // InternalOptimisationLanguage.g:1961:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:1968:3: (enumLiteral_1= '>' )
                    {
                    // InternalOptimisationLanguage.g:1968:3: (enumLiteral_1= '>' )
                    // InternalOptimisationLanguage.g:1969:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:1976:3: (enumLiteral_2= '=' )
                    {
                    // InternalOptimisationLanguage.g:1976:3: (enumLiteral_2= '=' )
                    // InternalOptimisationLanguage.g:1977:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOptimisationLanguage.g:1984:3: (enumLiteral_3= '!=' )
                    {
                    // InternalOptimisationLanguage.g:1984:3: (enumLiteral_3= '!=' )
                    // InternalOptimisationLanguage.g:1985:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOptimisationLanguage.g:1992:3: (enumLiteral_4= '<' )
                    {
                    // InternalOptimisationLanguage.g:1992:3: (enumLiteral_4= '<' )
                    // InternalOptimisationLanguage.g:1993:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOptimisationLanguage.g:2000:3: (enumLiteral_5= '<=' )
                    {
                    // InternalOptimisationLanguage.g:2000:3: (enumLiteral_5= '<=' )
                    // InternalOptimisationLanguage.g:2001:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,40,FOLLOW_2); 

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
    // InternalOptimisationLanguage.g:2011:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:2017:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalOptimisationLanguage.g:2018:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalOptimisationLanguage.g:2018:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==41) ) {
                alt29=1;
            }
            else if ( (LA29_0==42) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalOptimisationLanguage.g:2019:3: (enumLiteral_0= '+' )
                    {
                    // InternalOptimisationLanguage.g:2019:3: (enumLiteral_0= '+' )
                    // InternalOptimisationLanguage.g:2020:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:2027:3: (enumLiteral_1= '-' )
                    {
                    // InternalOptimisationLanguage.g:2027:3: (enumLiteral_1= '-' )
                    // InternalOptimisationLanguage.g:2028:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); 

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
    // InternalOptimisationLanguage.g:2038:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOptimisationLanguage.g:2044:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalOptimisationLanguage.g:2045:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalOptimisationLanguage.g:2045:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt30=1;
                }
                break;
            case 44:
                {
                alt30=2;
                }
                break;
            case 45:
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
                    // InternalOptimisationLanguage.g:2046:3: (enumLiteral_0= '*' )
                    {
                    // InternalOptimisationLanguage.g:2046:3: (enumLiteral_0= '*' )
                    // InternalOptimisationLanguage.g:2047:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:2054:3: (enumLiteral_1= '/' )
                    {
                    // InternalOptimisationLanguage.g:2054:3: (enumLiteral_1= '/' )
                    // InternalOptimisationLanguage.g:2055:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:2062:3: (enumLiteral_2= '%' )
                    {
                    // InternalOptimisationLanguage.g:2062:3: (enumLiteral_2= '%' )
                    // InternalOptimisationLanguage.g:2063:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,45,FOLLOW_2); 

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
    // InternalOptimisationLanguage.g:2073:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalOptimisationLanguage.g:2079:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalOptimisationLanguage.g:2080:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalOptimisationLanguage.g:2080:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt31=20;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt31=1;
                }
                break;
            case 47:
                {
                alt31=2;
                }
                break;
            case 48:
                {
                alt31=3;
                }
                break;
            case 49:
                {
                alt31=4;
                }
                break;
            case 50:
                {
                alt31=5;
                }
                break;
            case 51:
                {
                alt31=6;
                }
                break;
            case 52:
                {
                alt31=7;
                }
                break;
            case 53:
                {
                alt31=8;
                }
                break;
            case 54:
                {
                alt31=9;
                }
                break;
            case 55:
                {
                alt31=10;
                }
                break;
            case 56:
                {
                alt31=11;
                }
                break;
            case 57:
                {
                alt31=12;
                }
                break;
            case 58:
                {
                alt31=13;
                }
                break;
            case 59:
                {
                alt31=14;
                }
                break;
            case 60:
                {
                alt31=15;
                }
                break;
            case 61:
                {
                alt31=16;
                }
                break;
            case 62:
                {
                alt31=17;
                }
                break;
            case 63:
                {
                alt31=18;
                }
                break;
            case 64:
                {
                alt31=19;
                }
                break;
            case 65:
                {
                alt31=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalOptimisationLanguage.g:2081:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalOptimisationLanguage.g:2081:3: (enumLiteral_0= 'Y' )
                    // InternalOptimisationLanguage.g:2082:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOptimisationLanguage.g:2089:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalOptimisationLanguage.g:2089:3: (enumLiteral_1= 'Z' )
                    // InternalOptimisationLanguage.g:2090:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOptimisationLanguage.g:2097:3: (enumLiteral_2= 'E' )
                    {
                    // InternalOptimisationLanguage.g:2097:3: (enumLiteral_2= 'E' )
                    // InternalOptimisationLanguage.g:2098:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOptimisationLanguage.g:2105:3: (enumLiteral_3= 'P' )
                    {
                    // InternalOptimisationLanguage.g:2105:3: (enumLiteral_3= 'P' )
                    // InternalOptimisationLanguage.g:2106:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOptimisationLanguage.g:2113:3: (enumLiteral_4= 'T' )
                    {
                    // InternalOptimisationLanguage.g:2113:3: (enumLiteral_4= 'T' )
                    // InternalOptimisationLanguage.g:2114:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOptimisationLanguage.g:2121:3: (enumLiteral_5= 'G' )
                    {
                    // InternalOptimisationLanguage.g:2121:3: (enumLiteral_5= 'G' )
                    // InternalOptimisationLanguage.g:2122:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalOptimisationLanguage.g:2129:3: (enumLiteral_6= 'M' )
                    {
                    // InternalOptimisationLanguage.g:2129:3: (enumLiteral_6= 'M' )
                    // InternalOptimisationLanguage.g:2130:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalOptimisationLanguage.g:2137:3: (enumLiteral_7= 'k' )
                    {
                    // InternalOptimisationLanguage.g:2137:3: (enumLiteral_7= 'k' )
                    // InternalOptimisationLanguage.g:2138:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalOptimisationLanguage.g:2145:3: (enumLiteral_8= 'h' )
                    {
                    // InternalOptimisationLanguage.g:2145:3: (enumLiteral_8= 'h' )
                    // InternalOptimisationLanguage.g:2146:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalOptimisationLanguage.g:2153:3: (enumLiteral_9= 'da' )
                    {
                    // InternalOptimisationLanguage.g:2153:3: (enumLiteral_9= 'da' )
                    // InternalOptimisationLanguage.g:2154:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalOptimisationLanguage.g:2161:3: (enumLiteral_10= 'd' )
                    {
                    // InternalOptimisationLanguage.g:2161:3: (enumLiteral_10= 'd' )
                    // InternalOptimisationLanguage.g:2162:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalOptimisationLanguage.g:2169:3: (enumLiteral_11= 'c' )
                    {
                    // InternalOptimisationLanguage.g:2169:3: (enumLiteral_11= 'c' )
                    // InternalOptimisationLanguage.g:2170:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalOptimisationLanguage.g:2177:3: (enumLiteral_12= 'm' )
                    {
                    // InternalOptimisationLanguage.g:2177:3: (enumLiteral_12= 'm' )
                    // InternalOptimisationLanguage.g:2178:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalOptimisationLanguage.g:2185:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalOptimisationLanguage.g:2185:3: (enumLiteral_13= '\\u00B5' )
                    // InternalOptimisationLanguage.g:2186:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalOptimisationLanguage.g:2193:3: (enumLiteral_14= 'n' )
                    {
                    // InternalOptimisationLanguage.g:2193:3: (enumLiteral_14= 'n' )
                    // InternalOptimisationLanguage.g:2194:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalOptimisationLanguage.g:2201:3: (enumLiteral_15= 'p' )
                    {
                    // InternalOptimisationLanguage.g:2201:3: (enumLiteral_15= 'p' )
                    // InternalOptimisationLanguage.g:2202:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalOptimisationLanguage.g:2209:3: (enumLiteral_16= 'f' )
                    {
                    // InternalOptimisationLanguage.g:2209:3: (enumLiteral_16= 'f' )
                    // InternalOptimisationLanguage.g:2210:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalOptimisationLanguage.g:2217:3: (enumLiteral_17= 'a' )
                    {
                    // InternalOptimisationLanguage.g:2217:3: (enumLiteral_17= 'a' )
                    // InternalOptimisationLanguage.g:2218:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalOptimisationLanguage.g:2225:3: (enumLiteral_18= 'z' )
                    {
                    // InternalOptimisationLanguage.g:2225:3: (enumLiteral_18= 'z' )
                    // InternalOptimisationLanguage.g:2226:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalOptimisationLanguage.g:2233:3: (enumLiteral_19= 'y' )
                    {
                    // InternalOptimisationLanguage.g:2233:3: (enumLiteral_19= 'y' )
                    // InternalOptimisationLanguage.g:2234:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,65,FOLLOW_2); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008120L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080130L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000006012001F0L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000601A001F0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000607512001F0L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000001F800000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000607D12001F0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080400000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0xFFFFC00000000002L,0x0000000000000003L});

}
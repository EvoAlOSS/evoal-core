package de.evoal.languages.model.el.dsl.parser.antlr.internal;

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
import de.evoal.languages.model.el.dsl.services.ExpressionLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExpressionLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_QUOTED_ID", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'('", "')'", "','", "'call'", "'value'", "'true'", "'false'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=7;
    public static final int RULE_QUOTED_ID=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
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


        public InternalExpressionLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExpressionLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExpressionLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalExpressionLanguage.g"; }



     	private ExpressionLanguageGrammarAccess grammarAccess;

        public InternalExpressionLanguageParser(TokenStream input, ExpressionLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ExpressionRule";
       	}

       	@Override
       	protected ExpressionLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleExpressionRule"
    // InternalExpressionLanguage.g:66:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:66:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalExpressionLanguage.g:67:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalExpressionLanguage.g:73:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:79:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalExpressionLanguage.g:80:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalExpressionLanguage.g:91:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:91:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalExpressionLanguage.g:92:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalExpressionLanguage.g:98:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:104:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalExpressionLanguage.g:105:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalExpressionLanguage.g:105:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalExpressionLanguage.g:106:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalExpressionLanguage.g:106:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalExpressionLanguage.g:107:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalExpressionLanguage.g:107:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalExpressionLanguage.g:108:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {

            					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
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

            // InternalExpressionLanguage.g:125:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalExpressionLanguage.g:126:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,12,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	    			
            	    // InternalExpressionLanguage.g:130:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalExpressionLanguage.g:131:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalExpressionLanguage.g:131:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalExpressionLanguage.g:132:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_3);
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
            	    break loop1;
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
    // InternalExpressionLanguage.g:154:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:154:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalExpressionLanguage.g:155:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalExpressionLanguage.g:161:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:167:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalExpressionLanguage.g:168:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalExpressionLanguage.g:168:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalExpressionLanguage.g:169:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalExpressionLanguage.g:169:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalExpressionLanguage.g:170:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalExpressionLanguage.g:170:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalExpressionLanguage.g:171:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {

            					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
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

            // InternalExpressionLanguage.g:188:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalExpressionLanguage.g:189:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	    			
            	    // InternalExpressionLanguage.g:193:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalExpressionLanguage.g:194:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalExpressionLanguage.g:194:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalExpressionLanguage.g:195:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_5);
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
            	    break loop2;
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
    // InternalExpressionLanguage.g:217:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:217:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalExpressionLanguage.g:218:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalExpressionLanguage.g:224:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:230:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalExpressionLanguage.g:231:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalExpressionLanguage.g:231:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalExpressionLanguage.g:232:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalExpressionLanguage.g:232:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalExpressionLanguage.g:233:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalExpressionLanguage.g:233:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalExpressionLanguage.g:234:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {

            					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_6);
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

            // InternalExpressionLanguage.g:251:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalExpressionLanguage.g:252:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	    			
            	    // InternalExpressionLanguage.g:256:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalExpressionLanguage.g:257:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalExpressionLanguage.g:257:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalExpressionLanguage.g:258:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
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
    // $ANTLR end "ruleAndExpressionRule"


    // $ANTLR start "entryRuleNotExpressionRule"
    // InternalExpressionLanguage.g:280:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:280:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalExpressionLanguage.g:281:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalExpressionLanguage.g:287:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:293:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalExpressionLanguage.g:294:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalExpressionLanguage.g:294:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalExpressionLanguage.g:295:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalExpressionLanguage.g:295:3: ( (lv_negated_0_0= '!' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalExpressionLanguage.g:296:4: (lv_negated_0_0= '!' )
                    {
                    // InternalExpressionLanguage.g:296:4: (lv_negated_0_0= '!' )
                    // InternalExpressionLanguage.g:297:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,15,FOLLOW_4); 

                    					newLeafNode(lv_negated_0_0, grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNotExpressionRuleRule());
                    					}
                    					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "!");
                    				

                    }


                    }
                    break;

            }

            // InternalExpressionLanguage.g:309:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalExpressionLanguage.g:310:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalExpressionLanguage.g:310:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalExpressionLanguage.g:311:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalExpressionLanguage.g:332:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:332:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalExpressionLanguage.g:333:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalExpressionLanguage.g:339:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:345:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalExpressionLanguage.g:346:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalExpressionLanguage.g:346:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalExpressionLanguage.g:347:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalExpressionLanguage.g:347:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalExpressionLanguage.g:348:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalExpressionLanguage.g:348:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalExpressionLanguage.g:349:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
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

            // InternalExpressionLanguage.g:366:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=25 && LA5_0<=30)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalExpressionLanguage.g:367:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalExpressionLanguage.g:367:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalExpressionLanguage.g:368:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {

            	    					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_7);
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
            	    break loop5;
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
    // InternalExpressionLanguage.g:389:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:389:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalExpressionLanguage.g:390:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalExpressionLanguage.g:396:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:402:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalExpressionLanguage.g:403:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalExpressionLanguage.g:403:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalExpressionLanguage.g:404:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalExpressionLanguage.g:404:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalExpressionLanguage.g:405:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalExpressionLanguage.g:405:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalExpressionLanguage.g:406:5: lv_operator_0_0= ruleComparisonOperatorRule
            {

            					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
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

            // InternalExpressionLanguage.g:423:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalExpressionLanguage.g:424:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalExpressionLanguage.g:424:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalExpressionLanguage.g:425:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalExpressionLanguage.g:446:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:446:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalExpressionLanguage.g:447:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalExpressionLanguage.g:453:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:459:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalExpressionLanguage.g:460:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalExpressionLanguage.g:460:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalExpressionLanguage.g:461:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalExpressionLanguage.g:461:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalExpressionLanguage.g:462:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalExpressionLanguage.g:462:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalExpressionLanguage.g:463:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {

            					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
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

            // InternalExpressionLanguage.g:480:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=31 && LA6_0<=32)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalExpressionLanguage.g:481:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalExpressionLanguage.g:481:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalExpressionLanguage.g:482:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalExpressionLanguage.g:482:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalExpressionLanguage.g:483:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
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

            	    // InternalExpressionLanguage.g:500:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalExpressionLanguage.g:501:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalExpressionLanguage.g:501:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalExpressionLanguage.g:502:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
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
            	    break loop6;
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
    // InternalExpressionLanguage.g:524:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:524:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalExpressionLanguage.g:525:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalExpressionLanguage.g:531:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:537:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalExpressionLanguage.g:538:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalExpressionLanguage.g:538:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalExpressionLanguage.g:539:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalExpressionLanguage.g:539:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalExpressionLanguage.g:540:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalExpressionLanguage.g:540:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalExpressionLanguage.g:541:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {

            					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalExpressionLanguage.g:558:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=33 && LA7_0<=35)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalExpressionLanguage.g:559:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalExpressionLanguage.g:559:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalExpressionLanguage.g:560:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalExpressionLanguage.g:560:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalExpressionLanguage.g:561:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
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

            	    // InternalExpressionLanguage.g:578:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalExpressionLanguage.g:579:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalExpressionLanguage.g:579:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalExpressionLanguage.g:580:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
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
            	    break loop7;
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
    // InternalExpressionLanguage.g:602:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:602:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalExpressionLanguage.g:603:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalExpressionLanguage.g:609:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:615:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalExpressionLanguage.g:616:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalExpressionLanguage.g:616:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalExpressionLanguage.g:617:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalExpressionLanguage.g:617:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalExpressionLanguage.g:618:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalExpressionLanguage.g:618:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalExpressionLanguage.g:619:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
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

            // InternalExpressionLanguage.g:636:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalExpressionLanguage.g:637:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                    			
                    // InternalExpressionLanguage.g:641:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalExpressionLanguage.g:642:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalExpressionLanguage.g:642:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalExpressionLanguage.g:643:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalExpressionLanguage.g:665:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalExpressionLanguage.g:665:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalExpressionLanguage.g:666:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalExpressionLanguage.g:672:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:678:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) )
            // InternalExpressionLanguage.g:679:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            {
            // InternalExpressionLanguage.g:679:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            // InternalExpressionLanguage.g:680:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            {
            // InternalExpressionLanguage.g:680:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=31 && LA9_0<=32)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalExpressionLanguage.g:681:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalExpressionLanguage.g:681:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalExpressionLanguage.g:682:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {

            	    					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_4);
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
            	    break loop9;
                }
            } while (true);

            // InternalExpressionLanguage.g:699:3: ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            // InternalExpressionLanguage.g:700:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            {
            // InternalExpressionLanguage.g:700:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            // InternalExpressionLanguage.g:701:5: lv_subExpression_1_0= ruleLiteralOrReferenceRule
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
    // InternalExpressionLanguage.g:722:1: entryRuleLiteralOrReferenceRule returns [EObject current=null] : iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF ;
    public final EObject entryRuleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrReferenceRule = null;


        try {
            // InternalExpressionLanguage.g:722:63: (iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF )
            // InternalExpressionLanguage.g:723:2: iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF
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
    // InternalExpressionLanguage.g:729:1: ruleLiteralOrReferenceRule returns [EObject current=null] : (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) ;
    public final EObject ruleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallRule_0 = null;

        EObject this_LiteralRule_1 = null;

        EObject this_ParanthesesRule_2 = null;

        EObject this_ValueReferenceRule_3 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:735:2: ( (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) )
            // InternalExpressionLanguage.g:736:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            {
            // InternalExpressionLanguage.g:736:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt10=1;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 22:
            case 23:
                {
                alt10=2;
                }
                break;
            case 17:
                {
                alt10=3;
                }
                break;
            case 21:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalExpressionLanguage.g:737:3: this_CallRule_0= ruleCallRule
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
                    // InternalExpressionLanguage.g:746:3: this_LiteralRule_1= ruleLiteralRule
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
                    // InternalExpressionLanguage.g:755:3: this_ParanthesesRule_2= ruleParanthesesRule
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
                    // InternalExpressionLanguage.g:764:3: this_ValueReferenceRule_3= ruleValueReferenceRule
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
    // InternalExpressionLanguage.g:776:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalExpressionLanguage.g:776:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalExpressionLanguage.g:777:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalExpressionLanguage.g:783:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:789:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalExpressionLanguage.g:790:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalExpressionLanguage.g:790:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalExpressionLanguage.g:791:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
            		
            // InternalExpressionLanguage.g:795:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalExpressionLanguage.g:796:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalExpressionLanguage.g:796:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalExpressionLanguage.g:797:5: lv_subExpression_1_0= ruleExpressionRule
            {

            					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
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

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

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
    // InternalExpressionLanguage.g:822:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalExpressionLanguage.g:822:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalExpressionLanguage.g:823:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalExpressionLanguage.g:829:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalExpressionLanguage.g:835:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalExpressionLanguage.g:836:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalExpressionLanguage.g:836:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalExpressionLanguage.g:837:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalExpressionLanguage.g:837:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalExpressionLanguage.g:838:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalExpressionLanguage.g:838:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalExpressionLanguage.g:839:5: lv_function_0_0= ruleFunctionNameRule
            {

            					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
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

            otherlv_1=(Token)match(input,17,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
            		
            // InternalExpressionLanguage.g:860:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_INT && LA12_0<=RULE_STRING)||LA12_0==15||LA12_0==17||(LA12_0>=20 && LA12_0<=23)||(LA12_0>=31 && LA12_0<=32)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalExpressionLanguage.g:861:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalExpressionLanguage.g:861:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalExpressionLanguage.g:862:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalExpressionLanguage.g:862:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalExpressionLanguage.g:863:6: lv_parameters_2_0= ruleExpressionRule
                    {

                    						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_14);
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

                    // InternalExpressionLanguage.g:880:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==19) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalExpressionLanguage.g:881:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_4); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalExpressionLanguage.g:885:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalExpressionLanguage.g:886:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalExpressionLanguage.g:886:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalExpressionLanguage.g:887:7: lv_parameters_4_0= ruleExpressionRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_14);
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
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); 

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
    // InternalExpressionLanguage.g:914:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalExpressionLanguage.g:914:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalExpressionLanguage.g:915:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
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
    // InternalExpressionLanguage.g:921:1: ruleFunctionNameRule returns [EObject current=null] : ( () otherlv_1= 'call' ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalExpressionLanguage.g:927:2: ( ( () otherlv_1= 'call' ) )
            // InternalExpressionLanguage.g:928:2: ( () otherlv_1= 'call' )
            {
            // InternalExpressionLanguage.g:928:2: ( () otherlv_1= 'call' )
            // InternalExpressionLanguage.g:929:3: () otherlv_1= 'call'
            {
            // InternalExpressionLanguage.g:929:3: ()
            // InternalExpressionLanguage.g:930:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFunctionNameRuleAccess().getFunctionNameAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_2); 

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
    // InternalExpressionLanguage.g:944:1: entryRuleValueReferenceRule returns [EObject current=null] : iv_ruleValueReferenceRule= ruleValueReferenceRule EOF ;
    public final EObject entryRuleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueReferenceRule = null;


        try {
            // InternalExpressionLanguage.g:944:59: (iv_ruleValueReferenceRule= ruleValueReferenceRule EOF )
            // InternalExpressionLanguage.g:945:2: iv_ruleValueReferenceRule= ruleValueReferenceRule EOF
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
    // InternalExpressionLanguage.g:951:1: ruleValueReferenceRule returns [EObject current=null] : ( () otherlv_1= 'value' ) ;
    public final EObject ruleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalExpressionLanguage.g:957:2: ( ( () otherlv_1= 'value' ) )
            // InternalExpressionLanguage.g:958:2: ( () otherlv_1= 'value' )
            {
            // InternalExpressionLanguage.g:958:2: ( () otherlv_1= 'value' )
            // InternalExpressionLanguage.g:959:3: () otherlv_1= 'value'
            {
            // InternalExpressionLanguage.g:959:3: ()
            // InternalExpressionLanguage.g:960:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_2); 

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
    // InternalExpressionLanguage.g:974:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalExpressionLanguage.g:974:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalExpressionLanguage.g:975:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalExpressionLanguage.g:981:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:987:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) )
            // InternalExpressionLanguage.g:988:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            {
            // InternalExpressionLanguage.g:988:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            int alt13=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt13=1;
                }
                break;
            case RULE_STRING:
                {
                alt13=2;
                }
                break;
            case 22:
            case 23:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalExpressionLanguage.g:989:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalExpressionLanguage.g:998:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalExpressionLanguage.g:1007:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
    // InternalExpressionLanguage.g:1019:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalExpressionLanguage.g:1019:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalExpressionLanguage.g:1020:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalExpressionLanguage.g:1026:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:1032:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalExpressionLanguage.g:1033:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalExpressionLanguage.g:1033:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_INT) ) {
                int LA14_1 = input.LA(2);

                if ( ((LA14_1>=36 && LA14_1<=55)) ) {
                    alt14=2;
                }
                else if ( (LA14_1==24) ) {
                    alt14=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalExpressionLanguage.g:1034:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
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
                    // InternalExpressionLanguage.g:1043:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalExpressionLanguage.g:1055:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalExpressionLanguage.g:1055:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalExpressionLanguage.g:1056:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
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
    // InternalExpressionLanguage.g:1062:1: ruleDoubleLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= ruleDOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) ) ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_literal_0_0 = null;

        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:1068:2: ( ( ( (lv_literal_0_0= ruleDOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) ) ) )
            // InternalExpressionLanguage.g:1069:2: ( ( (lv_literal_0_0= ruleDOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) ) )
            {
            // InternalExpressionLanguage.g:1069:2: ( ( (lv_literal_0_0= ruleDOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) ) )
            // InternalExpressionLanguage.g:1070:3: ( (lv_literal_0_0= ruleDOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )
            {
            // InternalExpressionLanguage.g:1070:3: ( (lv_literal_0_0= ruleDOUBLE ) )
            // InternalExpressionLanguage.g:1071:4: (lv_literal_0_0= ruleDOUBLE )
            {
            // InternalExpressionLanguage.g:1071:4: (lv_literal_0_0= ruleDOUBLE )
            // InternalExpressionLanguage.g:1072:5: lv_literal_0_0= ruleDOUBLE
            {

            					newCompositeNode(grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLEParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_15);
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

            // InternalExpressionLanguage.g:1089:3: ( (lv_factor_1_0= ruleFactorRule ) )
            // InternalExpressionLanguage.g:1090:4: (lv_factor_1_0= ruleFactorRule )
            {
            // InternalExpressionLanguage.g:1090:4: (lv_factor_1_0= ruleFactorRule )
            // InternalExpressionLanguage.g:1091:5: lv_factor_1_0= ruleFactorRule
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
    // InternalExpressionLanguage.g:1112:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalExpressionLanguage.g:1112:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalExpressionLanguage.g:1113:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalExpressionLanguage.g:1119:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionLanguage.g:1125:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) ) ) )
            // InternalExpressionLanguage.g:1126:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) ) )
            {
            // InternalExpressionLanguage.g:1126:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) ) )
            // InternalExpressionLanguage.g:1127:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )
            {
            // InternalExpressionLanguage.g:1127:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalExpressionLanguage.g:1128:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalExpressionLanguage.g:1128:4: (lv_literal_0_0= RULE_INT )
            // InternalExpressionLanguage.g:1129:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_15); 

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

            // InternalExpressionLanguage.g:1145:3: ( (lv_factor_1_0= ruleFactorRule ) )
            // InternalExpressionLanguage.g:1146:4: (lv_factor_1_0= ruleFactorRule )
            {
            // InternalExpressionLanguage.g:1146:4: (lv_factor_1_0= ruleFactorRule )
            // InternalExpressionLanguage.g:1147:5: lv_factor_1_0= ruleFactorRule
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
    // InternalExpressionLanguage.g:1168:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalExpressionLanguage.g:1168:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalExpressionLanguage.g:1169:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalExpressionLanguage.g:1175:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalExpressionLanguage.g:1181:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalExpressionLanguage.g:1182:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalExpressionLanguage.g:1182:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalExpressionLanguage.g:1183:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalExpressionLanguage.g:1183:3: (lv_value_0_0= RULE_STRING )
            // InternalExpressionLanguage.g:1184:4: lv_value_0_0= RULE_STRING
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
    // InternalExpressionLanguage.g:1203:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalExpressionLanguage.g:1203:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalExpressionLanguage.g:1204:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalExpressionLanguage.g:1210:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExpressionLanguage.g:1216:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalExpressionLanguage.g:1217:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalExpressionLanguage.g:1217:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalExpressionLanguage.g:1218:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalExpressionLanguage.g:1218:3: ()
            // InternalExpressionLanguage.g:1219:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalExpressionLanguage.g:1225:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            else if ( (LA15_0==23) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalExpressionLanguage.g:1226:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalExpressionLanguage.g:1226:4: ( (lv_value_1_0= 'true' ) )
                    // InternalExpressionLanguage.g:1227:5: (lv_value_1_0= 'true' )
                    {
                    // InternalExpressionLanguage.g:1227:5: (lv_value_1_0= 'true' )
                    // InternalExpressionLanguage.g:1228:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,22,FOLLOW_2); 

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
                    // InternalExpressionLanguage.g:1241:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_2); 

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


    // $ANTLR start "entryRuleDOUBLE"
    // InternalExpressionLanguage.g:1250:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // InternalExpressionLanguage.g:1250:46: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // InternalExpressionLanguage.g:1251:2: iv_ruleDOUBLE= ruleDOUBLE EOF
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
    // InternalExpressionLanguage.g:1257:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalExpressionLanguage.g:1263:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalExpressionLanguage.g:1264:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalExpressionLanguage.g:1264:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalExpressionLanguage.g:1265:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_16); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,24,FOLLOW_17); 

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
    // InternalExpressionLanguage.g:1288:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalExpressionLanguage.g:1294:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalExpressionLanguage.g:1295:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalExpressionLanguage.g:1295:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt16=6;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt16=1;
                }
                break;
            case 26:
                {
                alt16=2;
                }
                break;
            case 27:
                {
                alt16=3;
                }
                break;
            case 28:
                {
                alt16=4;
                }
                break;
            case 29:
                {
                alt16=5;
                }
                break;
            case 30:
                {
                alt16=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalExpressionLanguage.g:1296:3: (enumLiteral_0= '>=' )
                    {
                    // InternalExpressionLanguage.g:1296:3: (enumLiteral_0= '>=' )
                    // InternalExpressionLanguage.g:1297:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalExpressionLanguage.g:1304:3: (enumLiteral_1= '>' )
                    {
                    // InternalExpressionLanguage.g:1304:3: (enumLiteral_1= '>' )
                    // InternalExpressionLanguage.g:1305:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalExpressionLanguage.g:1312:3: (enumLiteral_2= '=' )
                    {
                    // InternalExpressionLanguage.g:1312:3: (enumLiteral_2= '=' )
                    // InternalExpressionLanguage.g:1313:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalExpressionLanguage.g:1320:3: (enumLiteral_3= '!=' )
                    {
                    // InternalExpressionLanguage.g:1320:3: (enumLiteral_3= '!=' )
                    // InternalExpressionLanguage.g:1321:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalExpressionLanguage.g:1328:3: (enumLiteral_4= '<' )
                    {
                    // InternalExpressionLanguage.g:1328:3: (enumLiteral_4= '<' )
                    // InternalExpressionLanguage.g:1329:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalExpressionLanguage.g:1336:3: (enumLiteral_5= '<=' )
                    {
                    // InternalExpressionLanguage.g:1336:3: (enumLiteral_5= '<=' )
                    // InternalExpressionLanguage.g:1337:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,30,FOLLOW_2); 

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
    // InternalExpressionLanguage.g:1347:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalExpressionLanguage.g:1353:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalExpressionLanguage.g:1354:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalExpressionLanguage.g:1354:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==31) ) {
                alt17=1;
            }
            else if ( (LA17_0==32) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalExpressionLanguage.g:1355:3: (enumLiteral_0= '+' )
                    {
                    // InternalExpressionLanguage.g:1355:3: (enumLiteral_0= '+' )
                    // InternalExpressionLanguage.g:1356:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalExpressionLanguage.g:1363:3: (enumLiteral_1= '-' )
                    {
                    // InternalExpressionLanguage.g:1363:3: (enumLiteral_1= '-' )
                    // InternalExpressionLanguage.g:1364:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,32,FOLLOW_2); 

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
    // InternalExpressionLanguage.g:1374:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalExpressionLanguage.g:1380:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalExpressionLanguage.g:1381:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalExpressionLanguage.g:1381:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt18=1;
                }
                break;
            case 34:
                {
                alt18=2;
                }
                break;
            case 35:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalExpressionLanguage.g:1382:3: (enumLiteral_0= '*' )
                    {
                    // InternalExpressionLanguage.g:1382:3: (enumLiteral_0= '*' )
                    // InternalExpressionLanguage.g:1383:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalExpressionLanguage.g:1390:3: (enumLiteral_1= '/' )
                    {
                    // InternalExpressionLanguage.g:1390:3: (enumLiteral_1= '/' )
                    // InternalExpressionLanguage.g:1391:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalExpressionLanguage.g:1398:3: (enumLiteral_2= '%' )
                    {
                    // InternalExpressionLanguage.g:1398:3: (enumLiteral_2= '%' )
                    // InternalExpressionLanguage.g:1399:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,35,FOLLOW_2); 

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
    // InternalExpressionLanguage.g:1409:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalExpressionLanguage.g:1415:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalExpressionLanguage.g:1416:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalExpressionLanguage.g:1416:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt19=20;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt19=1;
                }
                break;
            case 37:
                {
                alt19=2;
                }
                break;
            case 38:
                {
                alt19=3;
                }
                break;
            case 39:
                {
                alt19=4;
                }
                break;
            case 40:
                {
                alt19=5;
                }
                break;
            case 41:
                {
                alt19=6;
                }
                break;
            case 42:
                {
                alt19=7;
                }
                break;
            case 43:
                {
                alt19=8;
                }
                break;
            case 44:
                {
                alt19=9;
                }
                break;
            case 45:
                {
                alt19=10;
                }
                break;
            case 46:
                {
                alt19=11;
                }
                break;
            case 47:
                {
                alt19=12;
                }
                break;
            case 48:
                {
                alt19=13;
                }
                break;
            case 49:
                {
                alt19=14;
                }
                break;
            case 50:
                {
                alt19=15;
                }
                break;
            case 51:
                {
                alt19=16;
                }
                break;
            case 52:
                {
                alt19=17;
                }
                break;
            case 53:
                {
                alt19=18;
                }
                break;
            case 54:
                {
                alt19=19;
                }
                break;
            case 55:
                {
                alt19=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalExpressionLanguage.g:1417:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalExpressionLanguage.g:1417:3: (enumLiteral_0= 'Y' )
                    // InternalExpressionLanguage.g:1418:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalExpressionLanguage.g:1425:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalExpressionLanguage.g:1425:3: (enumLiteral_1= 'Z' )
                    // InternalExpressionLanguage.g:1426:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalExpressionLanguage.g:1433:3: (enumLiteral_2= 'E' )
                    {
                    // InternalExpressionLanguage.g:1433:3: (enumLiteral_2= 'E' )
                    // InternalExpressionLanguage.g:1434:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalExpressionLanguage.g:1441:3: (enumLiteral_3= 'P' )
                    {
                    // InternalExpressionLanguage.g:1441:3: (enumLiteral_3= 'P' )
                    // InternalExpressionLanguage.g:1442:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalExpressionLanguage.g:1449:3: (enumLiteral_4= 'T' )
                    {
                    // InternalExpressionLanguage.g:1449:3: (enumLiteral_4= 'T' )
                    // InternalExpressionLanguage.g:1450:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalExpressionLanguage.g:1457:3: (enumLiteral_5= 'G' )
                    {
                    // InternalExpressionLanguage.g:1457:3: (enumLiteral_5= 'G' )
                    // InternalExpressionLanguage.g:1458:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalExpressionLanguage.g:1465:3: (enumLiteral_6= 'M' )
                    {
                    // InternalExpressionLanguage.g:1465:3: (enumLiteral_6= 'M' )
                    // InternalExpressionLanguage.g:1466:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalExpressionLanguage.g:1473:3: (enumLiteral_7= 'k' )
                    {
                    // InternalExpressionLanguage.g:1473:3: (enumLiteral_7= 'k' )
                    // InternalExpressionLanguage.g:1474:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalExpressionLanguage.g:1481:3: (enumLiteral_8= 'h' )
                    {
                    // InternalExpressionLanguage.g:1481:3: (enumLiteral_8= 'h' )
                    // InternalExpressionLanguage.g:1482:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalExpressionLanguage.g:1489:3: (enumLiteral_9= 'da' )
                    {
                    // InternalExpressionLanguage.g:1489:3: (enumLiteral_9= 'da' )
                    // InternalExpressionLanguage.g:1490:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalExpressionLanguage.g:1497:3: (enumLiteral_10= 'd' )
                    {
                    // InternalExpressionLanguage.g:1497:3: (enumLiteral_10= 'd' )
                    // InternalExpressionLanguage.g:1498:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalExpressionLanguage.g:1505:3: (enumLiteral_11= 'c' )
                    {
                    // InternalExpressionLanguage.g:1505:3: (enumLiteral_11= 'c' )
                    // InternalExpressionLanguage.g:1506:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalExpressionLanguage.g:1513:3: (enumLiteral_12= 'm' )
                    {
                    // InternalExpressionLanguage.g:1513:3: (enumLiteral_12= 'm' )
                    // InternalExpressionLanguage.g:1514:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalExpressionLanguage.g:1521:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalExpressionLanguage.g:1521:3: (enumLiteral_13= '\\u00B5' )
                    // InternalExpressionLanguage.g:1522:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalExpressionLanguage.g:1529:3: (enumLiteral_14= 'n' )
                    {
                    // InternalExpressionLanguage.g:1529:3: (enumLiteral_14= 'n' )
                    // InternalExpressionLanguage.g:1530:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalExpressionLanguage.g:1537:3: (enumLiteral_15= 'p' )
                    {
                    // InternalExpressionLanguage.g:1537:3: (enumLiteral_15= 'p' )
                    // InternalExpressionLanguage.g:1538:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalExpressionLanguage.g:1545:3: (enumLiteral_16= 'f' )
                    {
                    // InternalExpressionLanguage.g:1545:3: (enumLiteral_16= 'f' )
                    // InternalExpressionLanguage.g:1546:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalExpressionLanguage.g:1553:3: (enumLiteral_17= 'a' )
                    {
                    // InternalExpressionLanguage.g:1553:3: (enumLiteral_17= 'a' )
                    // InternalExpressionLanguage.g:1554:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalExpressionLanguage.g:1561:3: (enumLiteral_18= 'z' )
                    {
                    // InternalExpressionLanguage.g:1561:3: (enumLiteral_18= 'z' )
                    // InternalExpressionLanguage.g:1562:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalExpressionLanguage.g:1569:3: (enumLiteral_19= 'y' )
                    {
                    // InternalExpressionLanguage.g:1569:3: (enumLiteral_19= 'y' )
                    // InternalExpressionLanguage.g:1570:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,55,FOLLOW_2); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000180F28030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000007E000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000E00000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000180F68030L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00FFFFF000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000010L});

}
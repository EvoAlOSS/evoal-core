package de.evoal.languages.model.instance.dsl.parser.antlr.internal;

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
import de.evoal.languages.model.instance.dsl.services.InstanceLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalInstanceLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_QUOTED_ID", "RULE_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "':='", "';'", "'['", "','", "']'", "'data'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'('", "')'", "'true'", "'false'", "':'", "'literal'", "'instance'", "'|'", "'string'", "'expression'", "'int'", "'float'", "'boolean'", "'void'", "'array'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
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
    public static final int RULE_ID=8;
    public static final int RULE_QUOTED_ID=7;
    public static final int RULE_DIGIT=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
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
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__37=37;
    public static final int RULE_DOUBLE=4;
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


        public InternalInstanceLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalInstanceLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalInstanceLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalInstanceLanguage.g"; }



     	private InstanceLanguageGrammarAccess grammarAccess;

        public InternalInstanceLanguageParser(TokenStream input, InstanceLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "InstanceRule";
       	}

       	@Override
       	protected InstanceLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleInstanceRule"
    // InternalInstanceLanguage.g:66:1: entryRuleInstanceRule returns [EObject current=null] : iv_ruleInstanceRule= ruleInstanceRule EOF ;
    public final EObject entryRuleInstanceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceRule = null;


        try {
            // InternalInstanceLanguage.g:66:53: (iv_ruleInstanceRule= ruleInstanceRule EOF )
            // InternalInstanceLanguage.g:67:2: iv_ruleInstanceRule= ruleInstanceRule EOF
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
    // InternalInstanceLanguage.g:73:1: ruleInstanceRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleInstanceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:79:2: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) )
            // InternalInstanceLanguage.g:80:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            {
            // InternalInstanceLanguage.g:80:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            // InternalInstanceLanguage.g:81:3: ( ( ruleQualifiedName ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            {
            // InternalInstanceLanguage.g:81:3: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:82:4: ( ruleQualifiedName )
            {
            // InternalInstanceLanguage.g:82:4: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:83:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInstanceRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInstanceRuleAccess().getDefinitionTypeDefinitionCrossReference_0_0());
            				
            pushFollow(FOLLOW_3);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:97:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalInstanceLanguage.g:98:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getInstanceRuleAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalInstanceLanguage.g:102:4: ( (lv_attributes_2_0= ruleAttributeRule ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=RULE_QUOTED_ID && LA1_0<=RULE_ID)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalInstanceLanguage.g:103:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    {
                    	    // InternalInstanceLanguage.g:103:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    // InternalInstanceLanguage.g:104:6: lv_attributes_2_0= ruleAttributeRule
                    	    {

                    	    						newCompositeNode(grammarAccess.getInstanceRuleAccess().getAttributesAttributeRuleParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_4);
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
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,16,FOLLOW_2); 

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
    // InternalInstanceLanguage.g:130:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalInstanceLanguage.g:130:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalInstanceLanguage.g:131:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalInstanceLanguage.g:137:1: ruleAttributeRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:143:2: ( ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) )
            // InternalInstanceLanguage.g:144:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            {
            // InternalInstanceLanguage.g:144:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            // InternalInstanceLanguage.g:145:3: ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';'
            {
            // InternalInstanceLanguage.g:145:3: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:146:4: ( ruleStringOrId )
            {
            // InternalInstanceLanguage.g:146:4: ( ruleStringOrId )
            // InternalInstanceLanguage.g:147:5: ruleStringOrId
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0());
            				
            pushFollow(FOLLOW_5);
            ruleStringOrId();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
            		
            // InternalInstanceLanguage.g:165:3: ( (lv_value_2_0= ruleValueRule ) )
            // InternalInstanceLanguage.g:166:4: (lv_value_2_0= ruleValueRule )
            {
            // InternalInstanceLanguage.g:166:4: (lv_value_2_0= ruleValueRule )
            // InternalInstanceLanguage.g:167:5: lv_value_2_0= ruleValueRule
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

            otherlv_3=(Token)match(input,18,FOLLOW_2); 

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


    // $ANTLR start "entryRuleValueRule"
    // InternalInstanceLanguage.g:192:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // InternalInstanceLanguage.g:192:50: (iv_ruleValueRule= ruleValueRule EOF )
            // InternalInstanceLanguage.g:193:2: iv_ruleValueRule= ruleValueRule EOF
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
    // InternalInstanceLanguage.g:199:1: ruleValueRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_DataReferenceRule_1 = null;

        EObject this_InstanceRule_2 = null;

        EObject this_LiteralValueRule_3 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:205:2: ( (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) )
            // InternalInstanceLanguage.g:206:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            {
            // InternalInstanceLanguage.g:206:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt3=1;
                }
                break;
            case 22:
                {
                alt3=2;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt3=3;
                }
                break;
            case RULE_DOUBLE:
            case RULE_INT:
            case RULE_STRING:
            case 30:
            case 31:
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
                    // InternalInstanceLanguage.g:207:3: this_ArrayRule_0= ruleArrayRule
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
                    // InternalInstanceLanguage.g:216:3: this_DataReferenceRule_1= ruleDataReferenceRule
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
                    // InternalInstanceLanguage.g:225:3: this_InstanceRule_2= ruleInstanceRule
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
                    // InternalInstanceLanguage.g:234:3: this_LiteralValueRule_3= ruleLiteralValueRule
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
    // InternalInstanceLanguage.g:246:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalInstanceLanguage.g:246:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalInstanceLanguage.g:247:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalInstanceLanguage.g:253:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:259:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) )
            // InternalInstanceLanguage.g:260:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalInstanceLanguage.g:260:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            // InternalInstanceLanguage.g:261:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']'
            {
            // InternalInstanceLanguage.g:261:3: ()
            // InternalInstanceLanguage.g:262:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArrayRuleAccess().getArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalInstanceLanguage.g:272:3: ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_DOUBLE && LA5_0<=RULE_ID)||LA5_0==19||LA5_0==22||(LA5_0>=30 && LA5_0<=31)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalInstanceLanguage.g:273:4: ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    {
                    // InternalInstanceLanguage.g:273:4: ( (lv_values_2_0= ruleValueRule ) )
                    // InternalInstanceLanguage.g:274:5: (lv_values_2_0= ruleValueRule )
                    {
                    // InternalInstanceLanguage.g:274:5: (lv_values_2_0= ruleValueRule )
                    // InternalInstanceLanguage.g:275:6: lv_values_2_0= ruleValueRule
                    {

                    						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_9);
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

                    // InternalInstanceLanguage.g:292:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==20) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalInstanceLanguage.g:293:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_6); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalInstanceLanguage.g:297:5: ( (lv_values_4_0= ruleValueRule ) )
                    	    // InternalInstanceLanguage.g:298:6: (lv_values_4_0= ruleValueRule )
                    	    {
                    	    // InternalInstanceLanguage.g:298:6: (lv_values_4_0= ruleValueRule )
                    	    // InternalInstanceLanguage.g:299:7: lv_values_4_0= ruleValueRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
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
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,21,FOLLOW_2); 

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
    // InternalInstanceLanguage.g:326:1: entryRuleLiteralValueRule returns [EObject current=null] : iv_ruleLiteralValueRule= ruleLiteralValueRule EOF ;
    public final EObject entryRuleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValueRule = null;


        try {
            // InternalInstanceLanguage.g:326:57: (iv_ruleLiteralValueRule= ruleLiteralValueRule EOF )
            // InternalInstanceLanguage.g:327:2: iv_ruleLiteralValueRule= ruleLiteralValueRule EOF
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
    // InternalInstanceLanguage.g:333:1: ruleLiteralValueRule returns [EObject current=null] : ( (lv_literal_0_0= ruleLiteralRule ) ) ;
    public final EObject ruleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject lv_literal_0_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:339:2: ( ( (lv_literal_0_0= ruleLiteralRule ) ) )
            // InternalInstanceLanguage.g:340:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            {
            // InternalInstanceLanguage.g:340:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            // InternalInstanceLanguage.g:341:3: (lv_literal_0_0= ruleLiteralRule )
            {
            // InternalInstanceLanguage.g:341:3: (lv_literal_0_0= ruleLiteralRule )
            // InternalInstanceLanguage.g:342:4: lv_literal_0_0= ruleLiteralRule
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
            					"de.evoal.languages.model.base.dsl.BaseLanguage.LiteralRule");
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
    // InternalInstanceLanguage.g:362:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalInstanceLanguage.g:362:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalInstanceLanguage.g:363:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
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
    // InternalInstanceLanguage.g:369:1: ruleDataReferenceRule returns [EObject current=null] : ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:375:2: ( ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) )
            // InternalInstanceLanguage.g:376:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            {
            // InternalInstanceLanguage.g:376:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            // InternalInstanceLanguage.g:377:3: () otherlv_1= 'data' ( ( ruleStringOrId ) )
            {
            // InternalInstanceLanguage.g:377:3: ()
            // InternalInstanceLanguage.g:378:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1());
            		
            // InternalInstanceLanguage.g:388:3: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:389:4: ( ruleStringOrId )
            {
            // InternalInstanceLanguage.g:389:4: ( ruleStringOrId )
            // InternalInstanceLanguage.g:390:5: ruleStringOrId
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
    // InternalInstanceLanguage.g:408:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:408:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalInstanceLanguage.g:409:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalInstanceLanguage.g:415:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:421:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalInstanceLanguage.g:422:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalInstanceLanguage.g:433:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:433:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalInstanceLanguage.g:434:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalInstanceLanguage.g:440:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:446:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalInstanceLanguage.g:447:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalInstanceLanguage.g:447:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalInstanceLanguage.g:448:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalInstanceLanguage.g:448:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalInstanceLanguage.g:449:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalInstanceLanguage.g:449:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalInstanceLanguage.g:450:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {

            					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_subExpressions_0_0=ruleXorExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrExpressionRuleRule());
            					}
            					add(
            						current,
            						"subExpressions",
            						lv_subExpressions_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.XorExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:467:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==23) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalInstanceLanguage.g:468:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_12); 

            	    				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	    			
            	    // InternalInstanceLanguage.g:472:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalInstanceLanguage.g:473:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:473:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalInstanceLanguage.g:474:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_subExpressions_2_0=ruleXorExpressionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"subExpressions",
            	    							lv_subExpressions_2_0,
            	    							"de.evoal.languages.model.base.dsl.BaseLanguage.XorExpressionRule");
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
    // $ANTLR end "ruleOrExpressionRule"


    // $ANTLR start "entryRuleXorExpressionRule"
    // InternalInstanceLanguage.g:496:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:496:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalInstanceLanguage.g:497:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalInstanceLanguage.g:503:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:509:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalInstanceLanguage.g:510:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalInstanceLanguage.g:510:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalInstanceLanguage.g:511:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalInstanceLanguage.g:511:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalInstanceLanguage.g:512:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalInstanceLanguage.g:512:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalInstanceLanguage.g:513:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {

            					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_13);
            lv_subExpressions_0_0=ruleAndExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getXorExpressionRuleRule());
            					}
            					add(
            						current,
            						"subExpressions",
            						lv_subExpressions_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.AndExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:530:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalInstanceLanguage.g:531:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_12); 

            	    				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	    			
            	    // InternalInstanceLanguage.g:535:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalInstanceLanguage.g:536:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:536:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalInstanceLanguage.g:537:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_subExpressions_2_0=ruleAndExpressionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXorExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"subExpressions",
            	    							lv_subExpressions_2_0,
            	    							"de.evoal.languages.model.base.dsl.BaseLanguage.AndExpressionRule");
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
    // $ANTLR end "ruleXorExpressionRule"


    // $ANTLR start "entryRuleAndExpressionRule"
    // InternalInstanceLanguage.g:559:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:559:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalInstanceLanguage.g:560:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalInstanceLanguage.g:566:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:572:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalInstanceLanguage.g:573:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalInstanceLanguage.g:573:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalInstanceLanguage.g:574:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalInstanceLanguage.g:574:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalInstanceLanguage.g:575:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalInstanceLanguage.g:575:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalInstanceLanguage.g:576:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {

            					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_14);
            lv_subExpressions_0_0=ruleNotExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndExpressionRuleRule());
            					}
            					add(
            						current,
            						"subExpressions",
            						lv_subExpressions_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.NotExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:593:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==25) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalInstanceLanguage.g:594:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_12); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	    			
            	    // InternalInstanceLanguage.g:598:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalInstanceLanguage.g:599:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:599:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalInstanceLanguage.g:600:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    lv_subExpressions_2_0=ruleNotExpressionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"subExpressions",
            	    							lv_subExpressions_2_0,
            	    							"de.evoal.languages.model.base.dsl.BaseLanguage.NotExpressionRule");
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
    // InternalInstanceLanguage.g:622:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:622:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalInstanceLanguage.g:623:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalInstanceLanguage.g:629:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:635:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalInstanceLanguage.g:636:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalInstanceLanguage.g:636:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalInstanceLanguage.g:637:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalInstanceLanguage.g:637:3: ( (lv_negated_0_0= '!' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalInstanceLanguage.g:638:4: (lv_negated_0_0= '!' )
                    {
                    // InternalInstanceLanguage.g:638:4: (lv_negated_0_0= '!' )
                    // InternalInstanceLanguage.g:639:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,26,FOLLOW_12); 

                    					newLeafNode(lv_negated_0_0, grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNotExpressionRuleRule());
                    					}
                    					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "!");
                    				

                    }


                    }
                    break;

            }

            // InternalInstanceLanguage.g:651:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalInstanceLanguage.g:652:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalInstanceLanguage.g:652:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalInstanceLanguage.g:653:5: lv_operand_1_0= ruleComparisonExpressionRule
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
            						"de.evoal.languages.model.base.dsl.BaseLanguage.ComparisonExpressionRule");
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
    // InternalInstanceLanguage.g:674:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:674:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalInstanceLanguage.g:675:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalInstanceLanguage.g:681:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:687:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalInstanceLanguage.g:688:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalInstanceLanguage.g:688:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalInstanceLanguage.g:689:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalInstanceLanguage.g:689:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:690:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:690:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:691:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_15);
            lv_leftOperand_0_0=ruleAddOrSubtractExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonExpressionRuleRule());
            					}
            					set(
            						current,
            						"leftOperand",
            						lv_leftOperand_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.AddOrSubtractExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:708:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=44 && LA10_0<=49)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalInstanceLanguage.g:709:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:709:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalInstanceLanguage.g:710:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {

            	    					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_comparison_1_0=rulePartialComparisonExpressionRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComparisonExpressionRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"comparison",
            	    						lv_comparison_1_0,
            	    						"de.evoal.languages.model.base.dsl.BaseLanguage.PartialComparisonExpressionRule");
            	    					afterParserOrEnumRuleCall();
            	    				

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
    // $ANTLR end "ruleComparisonExpressionRule"


    // $ANTLR start "entryRulePartialComparisonExpressionRule"
    // InternalInstanceLanguage.g:731:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:731:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalInstanceLanguage.g:732:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalInstanceLanguage.g:738:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:744:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalInstanceLanguage.g:745:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalInstanceLanguage.g:745:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalInstanceLanguage.g:746:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalInstanceLanguage.g:746:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalInstanceLanguage.g:747:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalInstanceLanguage.g:747:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalInstanceLanguage.g:748:5: lv_operator_0_0= ruleComparisonOperatorRule
            {

            					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_operator_0_0=ruleComparisonOperatorRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPartialComparisonExpressionRuleRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.ComparisonOperatorRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:765:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:766:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:766:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:767:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
            						"de.evoal.languages.model.base.dsl.BaseLanguage.AddOrSubtractExpressionRule");
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
    // InternalInstanceLanguage.g:788:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:788:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalInstanceLanguage.g:789:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalInstanceLanguage.g:795:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:801:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalInstanceLanguage.g:802:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalInstanceLanguage.g:802:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalInstanceLanguage.g:803:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalInstanceLanguage.g:803:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalInstanceLanguage.g:804:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalInstanceLanguage.g:804:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalInstanceLanguage.g:805:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {

            					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_16);
            lv_leftOperand_0_0=ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAddOrSubtractExpressionRuleRule());
            					}
            					set(
            						current,
            						"leftOperand",
            						lv_leftOperand_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.MultiplyDivideModuloExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:822:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=50 && LA11_0<=51)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalInstanceLanguage.g:823:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalInstanceLanguage.g:823:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalInstanceLanguage.g:824:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalInstanceLanguage.g:824:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalInstanceLanguage.g:825:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_operators_1_0=ruleAddOrSubtractOperatorRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAddOrSubtractExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operators",
            	    							lv_operators_1_0,
            	    							"de.evoal.languages.model.base.dsl.BaseLanguage.AddOrSubtractOperatorRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalInstanceLanguage.g:842:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalInstanceLanguage.g:843:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:843:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalInstanceLanguage.g:844:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_operands_2_0=ruleMultiplyDivideModuloExpressionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAddOrSubtractExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operands",
            	    							lv_operands_2_0,
            	    							"de.evoal.languages.model.base.dsl.BaseLanguage.MultiplyDivideModuloExpressionRule");
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
    // $ANTLR end "ruleAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleMultiplyDivideModuloExpressionRule"
    // InternalInstanceLanguage.g:866:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:866:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalInstanceLanguage.g:867:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalInstanceLanguage.g:873:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:879:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalInstanceLanguage.g:880:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalInstanceLanguage.g:880:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalInstanceLanguage.g:881:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalInstanceLanguage.g:881:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalInstanceLanguage.g:882:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalInstanceLanguage.g:882:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalInstanceLanguage.g:883:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {

            					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
            lv_leftOperand_0_0=rulePowerOfExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiplyDivideModuloExpressionRuleRule());
            					}
            					set(
            						current,
            						"leftOperand",
            						lv_leftOperand_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.PowerOfExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:900:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=52 && LA12_0<=54)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalInstanceLanguage.g:901:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalInstanceLanguage.g:901:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalInstanceLanguage.g:902:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalInstanceLanguage.g:902:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalInstanceLanguage.g:903:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_operators_1_0=ruleMultiplyDivideModuloOperatorRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplyDivideModuloExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operators",
            	    							lv_operators_1_0,
            	    							"de.evoal.languages.model.base.dsl.BaseLanguage.MultiplyDivideModuloOperatorRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalInstanceLanguage.g:920:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalInstanceLanguage.g:921:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:921:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalInstanceLanguage.g:922:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_17);
            	    lv_operands_2_0=rulePowerOfExpressionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplyDivideModuloExpressionRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operands",
            	    							lv_operands_2_0,
            	    							"de.evoal.languages.model.base.dsl.BaseLanguage.PowerOfExpressionRule");
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
    // $ANTLR end "ruleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "entryRulePowerOfExpressionRule"
    // InternalInstanceLanguage.g:944:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:944:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalInstanceLanguage.g:945:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalInstanceLanguage.g:951:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:957:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalInstanceLanguage.g:958:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalInstanceLanguage.g:958:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalInstanceLanguage.g:959:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalInstanceLanguage.g:959:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:960:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:960:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:961:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_18);
            lv_leftOperand_0_0=ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerOfExpressionRuleRule());
            					}
            					set(
            						current,
            						"leftOperand",
            						lv_leftOperand_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.UnaryAddOrSubtractExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:978:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalInstanceLanguage.g:979:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                    			
                    // InternalInstanceLanguage.g:983:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalInstanceLanguage.g:984:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalInstanceLanguage.g:984:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalInstanceLanguage.g:985:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
                    							"de.evoal.languages.model.base.dsl.BaseLanguage.PowerOfExpressionRule");
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
    // InternalInstanceLanguage.g:1007:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:1007:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalInstanceLanguage.g:1008:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalInstanceLanguage.g:1014:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1020:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) )
            // InternalInstanceLanguage.g:1021:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            {
            // InternalInstanceLanguage.g:1021:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            // InternalInstanceLanguage.g:1022:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            {
            // InternalInstanceLanguage.g:1022:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=50 && LA14_0<=51)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalInstanceLanguage.g:1023:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalInstanceLanguage.g:1023:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalInstanceLanguage.g:1024:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {

            	    					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_operators_0_0=ruleAddOrSubtractOperatorRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operators",
            	    						lv_operators_0_0,
            	    						"de.evoal.languages.model.base.dsl.BaseLanguage.AddOrSubtractOperatorRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // InternalInstanceLanguage.g:1041:3: ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            // InternalInstanceLanguage.g:1042:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            {
            // InternalInstanceLanguage.g:1042:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            // InternalInstanceLanguage.g:1043:5: lv_subExpression_1_0= ruleLiteralOrReferenceRule
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
            						"de.evoal.languages.model.base.dsl.BaseLanguage.LiteralOrReferenceRule");
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
    // InternalInstanceLanguage.g:1064:1: entryRuleLiteralOrReferenceRule returns [EObject current=null] : iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF ;
    public final EObject entryRuleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrReferenceRule = null;


        try {
            // InternalInstanceLanguage.g:1064:63: (iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF )
            // InternalInstanceLanguage.g:1065:2: iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF
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
    // InternalInstanceLanguage.g:1071:1: ruleLiteralOrReferenceRule returns [EObject current=null] : (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) ;
    public final EObject ruleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallRule_0 = null;

        EObject this_LiteralRule_1 = null;

        EObject this_ParanthesesRule_2 = null;

        EObject this_ValueReferenceRule_3 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1077:2: ( (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) )
            // InternalInstanceLanguage.g:1078:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            {
            // InternalInstanceLanguage.g:1078:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            int alt15=4;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalInstanceLanguage.g:1079:3: this_CallRule_0= ruleCallRule
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
                    // InternalInstanceLanguage.g:1088:3: this_LiteralRule_1= ruleLiteralRule
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
                    // InternalInstanceLanguage.g:1097:3: this_ParanthesesRule_2= ruleParanthesesRule
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
                    // InternalInstanceLanguage.g:1106:3: this_ValueReferenceRule_3= ruleValueReferenceRule
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
    // InternalInstanceLanguage.g:1118:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalInstanceLanguage.g:1118:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalInstanceLanguage.g:1119:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalInstanceLanguage.g:1125:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1131:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalInstanceLanguage.g:1132:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalInstanceLanguage.g:1132:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalInstanceLanguage.g:1133:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
            		
            // InternalInstanceLanguage.g:1137:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalInstanceLanguage.g:1138:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalInstanceLanguage.g:1138:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalInstanceLanguage.g:1139:5: lv_subExpression_1_0= ruleExpressionRule
            {

            					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_19);
            lv_subExpression_1_0=ruleExpressionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParanthesesRuleRule());
            					}
            					set(
            						current,
            						"subExpression",
            						lv_subExpression_1_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_2); 

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
    // InternalInstanceLanguage.g:1164:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalInstanceLanguage.g:1164:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalInstanceLanguage.g:1165:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalInstanceLanguage.g:1171:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalInstanceLanguage.g:1177:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalInstanceLanguage.g:1178:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalInstanceLanguage.g:1178:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalInstanceLanguage.g:1179:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalInstanceLanguage.g:1179:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalInstanceLanguage.g:1180:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalInstanceLanguage.g:1180:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalInstanceLanguage.g:1181:5: lv_function_0_0= ruleFunctionNameRule
            {

            					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
            lv_function_0_0=ruleFunctionNameRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCallRuleRule());
            					}
            					set(
            						current,
            						"function",
            						lv_function_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.FunctionNameRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
            		
            // InternalInstanceLanguage.g:1202:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_DOUBLE && LA17_0<=RULE_ID)||LA17_0==26||LA17_0==28||(LA17_0>=30 && LA17_0<=31)||(LA17_0>=50 && LA17_0<=51)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalInstanceLanguage.g:1203:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalInstanceLanguage.g:1203:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalInstanceLanguage.g:1204:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalInstanceLanguage.g:1204:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalInstanceLanguage.g:1205:6: lv_parameters_2_0= ruleExpressionRule
                    {

                    						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_parameters_2_0=ruleExpressionRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCallRuleRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_2_0,
                    							"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalInstanceLanguage.g:1222:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==20) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalInstanceLanguage.g:1223:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_12); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalInstanceLanguage.g:1227:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalInstanceLanguage.g:1228:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalInstanceLanguage.g:1228:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalInstanceLanguage.g:1229:7: lv_parameters_4_0= ruleExpressionRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_22);
                    	    lv_parameters_4_0=ruleExpressionRule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCallRuleRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_4_0,
                    	    								"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
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

            otherlv_5=(Token)match(input,29,FOLLOW_2); 

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
    // InternalInstanceLanguage.g:1256:1: entryRuleValueReferenceRule returns [EObject current=null] : iv_ruleValueReferenceRule= ruleValueReferenceRule EOF ;
    public final EObject entryRuleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueReferenceRule = null;


        try {
            // InternalInstanceLanguage.g:1256:59: (iv_ruleValueReferenceRule= ruleValueReferenceRule EOF )
            // InternalInstanceLanguage.g:1257:2: iv_ruleValueReferenceRule= ruleValueReferenceRule EOF
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
    // InternalInstanceLanguage.g:1263:1: ruleValueReferenceRule returns [EObject current=null] : this_ConstantReferenceRule_0= ruleConstantReferenceRule ;
    public final EObject ruleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantReferenceRule_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1269:2: (this_ConstantReferenceRule_0= ruleConstantReferenceRule )
            // InternalInstanceLanguage.g:1270:2: this_ConstantReferenceRule_0= ruleConstantReferenceRule
            {

            		newCompositeNode(grammarAccess.getValueReferenceRuleAccess().getConstantReferenceRuleParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_ConstantReferenceRule_0=ruleConstantReferenceRule();

            state._fsp--;


            		current = this_ConstantReferenceRule_0;
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
    // $ANTLR end "ruleValueReferenceRule"


    // $ANTLR start "entryRuleConstantReferenceRule"
    // InternalInstanceLanguage.g:1281:1: entryRuleConstantReferenceRule returns [EObject current=null] : iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF ;
    public final EObject entryRuleConstantReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantReferenceRule = null;


        try {
            // InternalInstanceLanguage.g:1281:62: (iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF )
            // InternalInstanceLanguage.g:1282:2: iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getConstantReferenceRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstantReferenceRule=ruleConstantReferenceRule();

            state._fsp--;

             current =iv_ruleConstantReferenceRule; 
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
    // $ANTLR end "entryRuleConstantReferenceRule"


    // $ANTLR start "ruleConstantReferenceRule"
    // InternalInstanceLanguage.g:1288:1: ruleConstantReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleConstantReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1294:2: ( ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:1295:2: ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:1295:2: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:1296:3: ( ruleQualifiedName )
            {
            // InternalInstanceLanguage.g:1296:3: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:1297:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getConstantReferenceRuleRule());
            				}
            			

            				newCompositeNode(grammarAccess.getConstantReferenceRuleAccess().getDefinitionConstantDefinitionCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

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
    // $ANTLR end "ruleConstantReferenceRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalInstanceLanguage.g:1314:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1314:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalInstanceLanguage.g:1315:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalInstanceLanguage.g:1321:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1327:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) )
            // InternalInstanceLanguage.g:1328:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            {
            // InternalInstanceLanguage.g:1328:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt18=1;
                }
                break;
            case RULE_STRING:
                {
                alt18=2;
                }
                break;
            case 30:
            case 31:
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
                    // InternalInstanceLanguage.g:1329:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalInstanceLanguage.g:1338:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalInstanceLanguage.g:1347:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
    // InternalInstanceLanguage.g:1359:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1359:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalInstanceLanguage.g:1360:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalInstanceLanguage.g:1366:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1372:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalInstanceLanguage.g:1373:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalInstanceLanguage.g:1373:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_DOUBLE) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_INT) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalInstanceLanguage.g:1374:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
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
                    // InternalInstanceLanguage.g:1383:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalInstanceLanguage.g:1395:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1395:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalInstanceLanguage.g:1396:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
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
    // InternalInstanceLanguage.g:1402:1: ruleDoubleLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1408:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalInstanceLanguage.g:1409:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalInstanceLanguage.g:1409:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalInstanceLanguage.g:1410:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalInstanceLanguage.g:1410:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalInstanceLanguage.g:1411:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalInstanceLanguage.g:1411:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalInstanceLanguage.g:1412:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_23); 

            					newLeafNode(lv_literal_0_0, grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDoubleLiteralRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"literal",
            						lv_literal_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.DOUBLE");
            				

            }


            }

            // InternalInstanceLanguage.g:1428:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=55 && LA20_0<=74)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalInstanceLanguage.g:1429:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalInstanceLanguage.g:1429:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalInstanceLanguage.g:1430:5: lv_factor_1_0= ruleFactorRule
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
                    						"de.evoal.languages.model.base.dsl.BaseLanguage.FactorRule");
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
    // InternalInstanceLanguage.g:1451:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1451:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalInstanceLanguage.g:1452:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalInstanceLanguage.g:1458:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1464:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalInstanceLanguage.g:1465:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalInstanceLanguage.g:1465:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalInstanceLanguage.g:1466:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalInstanceLanguage.g:1466:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalInstanceLanguage.g:1467:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalInstanceLanguage.g:1467:4: (lv_literal_0_0= RULE_INT )
            // InternalInstanceLanguage.g:1468:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_23); 

            					newLeafNode(lv_literal_0_0, grammarAccess.getIntegerLiteralRuleAccess().getLiteralINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntegerLiteralRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"literal",
            						lv_literal_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.INT");
            				

            }


            }

            // InternalInstanceLanguage.g:1484:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=55 && LA21_0<=74)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalInstanceLanguage.g:1485:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalInstanceLanguage.g:1485:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalInstanceLanguage.g:1486:5: lv_factor_1_0= ruleFactorRule
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
                    						"de.evoal.languages.model.base.dsl.BaseLanguage.FactorRule");
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
    // InternalInstanceLanguage.g:1507:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1507:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalInstanceLanguage.g:1508:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalInstanceLanguage.g:1514:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1520:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalInstanceLanguage.g:1521:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalInstanceLanguage.g:1521:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalInstanceLanguage.g:1522:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalInstanceLanguage.g:1522:3: (lv_value_0_0= RULE_STRING )
            // InternalInstanceLanguage.g:1523:4: lv_value_0_0= RULE_STRING
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
            					"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
            			

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
    // InternalInstanceLanguage.g:1542:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1542:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalInstanceLanguage.g:1543:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalInstanceLanguage.g:1549:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1555:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalInstanceLanguage.g:1556:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalInstanceLanguage.g:1556:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalInstanceLanguage.g:1557:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalInstanceLanguage.g:1557:3: ()
            // InternalInstanceLanguage.g:1558:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalInstanceLanguage.g:1564:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            else if ( (LA22_0==31) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalInstanceLanguage.g:1565:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalInstanceLanguage.g:1565:4: ( (lv_value_1_0= 'true' ) )
                    // InternalInstanceLanguage.g:1566:5: (lv_value_1_0= 'true' )
                    {
                    // InternalInstanceLanguage.g:1566:5: (lv_value_1_0= 'true' )
                    // InternalInstanceLanguage.g:1567:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,30,FOLLOW_2); 

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
                    // InternalInstanceLanguage.g:1580:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_2); 

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


    // $ANTLR start "entryRuleAttributeDefinitionRule"
    // InternalInstanceLanguage.g:1589:1: entryRuleAttributeDefinitionRule returns [EObject current=null] : iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF ;
    public final EObject entryRuleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDefinitionRule = null;


        try {
            // InternalInstanceLanguage.g:1589:64: (iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF )
            // InternalInstanceLanguage.g:1590:2: iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF
            {
             newCompositeNode(grammarAccess.getAttributeDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeDefinitionRule=ruleAttributeDefinitionRule();

            state._fsp--;

             current =iv_ruleAttributeDefinitionRule; 
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
    // $ANTLR end "entryRuleAttributeDefinitionRule"


    // $ANTLR start "ruleAttributeDefinitionRule"
    // InternalInstanceLanguage.g:1596:1: ruleAttributeDefinitionRule returns [EObject current=null] : ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' ) ;
    public final EObject ruleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initialisation_4_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1602:2: ( ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' ) )
            // InternalInstanceLanguage.g:1603:2: ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' )
            {
            // InternalInstanceLanguage.g:1603:2: ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' )
            // InternalInstanceLanguage.g:1604:3: ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';'
            {
            // InternalInstanceLanguage.g:1604:3: ( (lv_name_0_0= ruleStringOrId ) )
            // InternalInstanceLanguage.g:1605:4: (lv_name_0_0= ruleStringOrId )
            {
            // InternalInstanceLanguage.g:1605:4: (lv_name_0_0= ruleStringOrId )
            // InternalInstanceLanguage.g:1606:5: lv_name_0_0= ruleStringOrId
            {

            					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_24);
            lv_name_0_0=ruleStringOrId();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1());
            		
            // InternalInstanceLanguage.g:1627:3: ( (lv_type_2_0= ruleTypeRule ) )
            // InternalInstanceLanguage.g:1628:4: (lv_type_2_0= ruleTypeRule )
            {
            // InternalInstanceLanguage.g:1628:4: (lv_type_2_0= ruleTypeRule )
            // InternalInstanceLanguage.g:1629:5: lv_type_2_0= ruleTypeRule
            {

            					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_type_2_0=ruleTypeRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:1646:3: (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==17) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalInstanceLanguage.g:1647:4: otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_3_0());
                    			
                    // InternalInstanceLanguage.g:1651:4: ( (lv_initialisation_4_0= ruleExpressionRule ) )
                    // InternalInstanceLanguage.g:1652:5: (lv_initialisation_4_0= ruleExpressionRule )
                    {
                    // InternalInstanceLanguage.g:1652:5: (lv_initialisation_4_0= ruleExpressionRule )
                    // InternalInstanceLanguage.g:1653:6: lv_initialisation_4_0= ruleExpressionRule
                    {

                    						newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_initialisation_4_0=ruleExpressionRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
                    						}
                    						set(
                    							current,
                    							"initialisation",
                    							lv_initialisation_4_0,
                    							"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_4());
            		

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
    // $ANTLR end "ruleAttributeDefinitionRule"


    // $ANTLR start "entryRuleTypeRule"
    // InternalInstanceLanguage.g:1679:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1679:49: (iv_ruleTypeRule= ruleTypeRule EOF )
            // InternalInstanceLanguage.g:1680:2: iv_ruleTypeRule= ruleTypeRule EOF
            {
             newCompositeNode(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeRule=ruleTypeRule();

            state._fsp--;

             current =iv_ruleTypeRule; 
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
    // $ANTLR end "entryRuleTypeRule"


    // $ANTLR start "ruleTypeRule"
    // InternalInstanceLanguage.g:1686:1: ruleTypeRule returns [EObject current=null] : (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject this_StringTypeRule_0 = null;

        EObject this_IntTypeRule_1 = null;

        EObject this_FloatTypeRule_2 = null;

        EObject this_BooleanTypeRule_3 = null;

        EObject this_LiteralTypeRule_4 = null;

        EObject this_ArrayTypeRule_5 = null;

        EObject this_InstanceTypeRule_6 = null;

        EObject this_VoidTypeRule_7 = null;

        EObject this_ExpressionTypeRule_8 = null;

        EObject this_DataTypeRule_9 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1692:2: ( (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) )
            // InternalInstanceLanguage.g:1693:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            {
            // InternalInstanceLanguage.g:1693:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            int alt24=10;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt24=1;
                }
                break;
            case 38:
                {
                alt24=2;
                }
                break;
            case 39:
                {
                alt24=3;
                }
                break;
            case 40:
                {
                alt24=4;
                }
                break;
            case 33:
                {
                alt24=5;
                }
                break;
            case 42:
                {
                alt24=6;
                }
                break;
            case 34:
                {
                alt24=7;
                }
                break;
            case 41:
                {
                alt24=8;
                }
                break;
            case 37:
                {
                alt24=9;
                }
                break;
            case 22:
                {
                alt24=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalInstanceLanguage.g:1694:3: this_StringTypeRule_0= ruleStringTypeRule
                    {

                    			newCompositeNode(grammarAccess.getTypeRuleAccess().getStringTypeRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringTypeRule_0=ruleStringTypeRule();

                    state._fsp--;


                    			current = this_StringTypeRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1703:3: this_IntTypeRule_1= ruleIntTypeRule
                    {

                    			newCompositeNode(grammarAccess.getTypeRuleAccess().getIntTypeRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntTypeRule_1=ruleIntTypeRule();

                    state._fsp--;


                    			current = this_IntTypeRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:1712:3: this_FloatTypeRule_2= ruleFloatTypeRule
                    {

                    			newCompositeNode(grammarAccess.getTypeRuleAccess().getFloatTypeRuleParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_FloatTypeRule_2=ruleFloatTypeRule();

                    state._fsp--;


                    			current = this_FloatTypeRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:1721:3: this_BooleanTypeRule_3= ruleBooleanTypeRule
                    {

                    			newCompositeNode(grammarAccess.getTypeRuleAccess().getBooleanTypeRuleParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanTypeRule_3=ruleBooleanTypeRule();

                    state._fsp--;


                    			current = this_BooleanTypeRule_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalInstanceLanguage.g:1730:3: this_LiteralTypeRule_4= ruleLiteralTypeRule
                    {

                    			newCompositeNode(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralTypeRule_4=ruleLiteralTypeRule();

                    state._fsp--;


                    			current = this_LiteralTypeRule_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalInstanceLanguage.g:1739:3: this_ArrayTypeRule_5= ruleArrayTypeRule
                    {

                    			newCompositeNode(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArrayTypeRule_5=ruleArrayTypeRule();

                    state._fsp--;


                    			current = this_ArrayTypeRule_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalInstanceLanguage.g:1748:3: this_InstanceTypeRule_6= ruleInstanceTypeRule
                    {

                    			newCompositeNode(grammarAccess.getTypeRuleAccess().getInstanceTypeRuleParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_InstanceTypeRule_6=ruleInstanceTypeRule();

                    state._fsp--;


                    			current = this_InstanceTypeRule_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalInstanceLanguage.g:1757:3: this_VoidTypeRule_7= ruleVoidTypeRule
                    {

                    			newCompositeNode(grammarAccess.getTypeRuleAccess().getVoidTypeRuleParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_VoidTypeRule_7=ruleVoidTypeRule();

                    state._fsp--;


                    			current = this_VoidTypeRule_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalInstanceLanguage.g:1766:3: this_ExpressionTypeRule_8= ruleExpressionTypeRule
                    {

                    			newCompositeNode(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExpressionTypeRule_8=ruleExpressionTypeRule();

                    state._fsp--;


                    			current = this_ExpressionTypeRule_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalInstanceLanguage.g:1775:3: this_DataTypeRule_9= ruleDataTypeRule
                    {

                    			newCompositeNode(grammarAccess.getTypeRuleAccess().getDataTypeRuleParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataTypeRule_9=ruleDataTypeRule();

                    state._fsp--;


                    			current = this_DataTypeRule_9;
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
    // $ANTLR end "ruleTypeRule"


    // $ANTLR start "entryRuleLiteralTypeRule"
    // InternalInstanceLanguage.g:1787:1: entryRuleLiteralTypeRule returns [EObject current=null] : iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF ;
    public final EObject entryRuleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1787:56: (iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF )
            // InternalInstanceLanguage.g:1788:2: iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralTypeRule=ruleLiteralTypeRule();

            state._fsp--;

             current =iv_ruleLiteralTypeRule; 
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
    // $ANTLR end "entryRuleLiteralTypeRule"


    // $ANTLR start "ruleLiteralTypeRule"
    // InternalInstanceLanguage.g:1794:1: ruleLiteralTypeRule returns [EObject current=null] : ( () otherlv_1= 'literal' ) ;
    public final EObject ruleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1800:2: ( ( () otherlv_1= 'literal' ) )
            // InternalInstanceLanguage.g:1801:2: ( () otherlv_1= 'literal' )
            {
            // InternalInstanceLanguage.g:1801:2: ( () otherlv_1= 'literal' )
            // InternalInstanceLanguage.g:1802:3: () otherlv_1= 'literal'
            {
            // InternalInstanceLanguage.g:1802:3: ()
            // InternalInstanceLanguage.g:1803:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,33,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1());
            		

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
    // $ANTLR end "ruleLiteralTypeRule"


    // $ANTLR start "entryRuleInstanceTypeRule"
    // InternalInstanceLanguage.g:1817:1: entryRuleInstanceTypeRule returns [EObject current=null] : iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF ;
    public final EObject entryRuleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1817:57: (iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF )
            // InternalInstanceLanguage.g:1818:2: iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF
            {
             newCompositeNode(grammarAccess.getInstanceTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstanceTypeRule=ruleInstanceTypeRule();

            state._fsp--;

             current =iv_ruleInstanceTypeRule; 
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
    // $ANTLR end "entryRuleInstanceTypeRule"


    // $ANTLR start "ruleInstanceTypeRule"
    // InternalInstanceLanguage.g:1824:1: ruleInstanceTypeRule returns [EObject current=null] : ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* ) ;
    public final EObject ruleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1830:2: ( ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* ) )
            // InternalInstanceLanguage.g:1831:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* )
            {
            // InternalInstanceLanguage.g:1831:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* )
            // InternalInstanceLanguage.g:1832:3: () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )*
            {
            // InternalInstanceLanguage.g:1832:3: ()
            // InternalInstanceLanguage.g:1833:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,34,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1());
            		
            // InternalInstanceLanguage.g:1843:3: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:1844:4: ( ruleQualifiedName )
            {
            // InternalInstanceLanguage.g:1844:4: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:1845:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInstanceTypeRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_2_0());
            				
            pushFollow(FOLLOW_27);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:1859:3: (otherlv_3= '|' ( ( ruleQualifiedName ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==35) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalInstanceLanguage.g:1860:4: otherlv_3= '|' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_3=(Token)match(input,35,FOLLOW_10); 

            	    				newLeafNode(otherlv_3, grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0());
            	    			
            	    // InternalInstanceLanguage.g:1864:4: ( ( ruleQualifiedName ) )
            	    // InternalInstanceLanguage.g:1865:5: ( ruleQualifiedName )
            	    {
            	    // InternalInstanceLanguage.g:1865:5: ( ruleQualifiedName )
            	    // InternalInstanceLanguage.g:1866:6: ruleQualifiedName
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getInstanceTypeRuleRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_3_1_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    ruleQualifiedName();

            	    state._fsp--;


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
    // $ANTLR end "ruleInstanceTypeRule"


    // $ANTLR start "entryRuleStringTypeRule"
    // InternalInstanceLanguage.g:1885:1: entryRuleStringTypeRule returns [EObject current=null] : iv_ruleStringTypeRule= ruleStringTypeRule EOF ;
    public final EObject entryRuleStringTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1885:55: (iv_ruleStringTypeRule= ruleStringTypeRule EOF )
            // InternalInstanceLanguage.g:1886:2: iv_ruleStringTypeRule= ruleStringTypeRule EOF
            {
             newCompositeNode(grammarAccess.getStringTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringTypeRule=ruleStringTypeRule();

            state._fsp--;

             current =iv_ruleStringTypeRule; 
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
    // $ANTLR end "entryRuleStringTypeRule"


    // $ANTLR start "ruleStringTypeRule"
    // InternalInstanceLanguage.g:1892:1: ruleStringTypeRule returns [EObject current=null] : ( () otherlv_1= 'string' ) ;
    public final EObject ruleStringTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1898:2: ( ( () otherlv_1= 'string' ) )
            // InternalInstanceLanguage.g:1899:2: ( () otherlv_1= 'string' )
            {
            // InternalInstanceLanguage.g:1899:2: ( () otherlv_1= 'string' )
            // InternalInstanceLanguage.g:1900:3: () otherlv_1= 'string'
            {
            // InternalInstanceLanguage.g:1900:3: ()
            // InternalInstanceLanguage.g:1901:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getStringTypeRuleAccess().getStringKeyword_1());
            		

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
    // $ANTLR end "ruleStringTypeRule"


    // $ANTLR start "entryRuleExpressionTypeRule"
    // InternalInstanceLanguage.g:1915:1: entryRuleExpressionTypeRule returns [EObject current=null] : iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF ;
    public final EObject entryRuleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1915:59: (iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF )
            // InternalInstanceLanguage.g:1916:2: iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF
            {
             newCompositeNode(grammarAccess.getExpressionTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionTypeRule=ruleExpressionTypeRule();

            state._fsp--;

             current =iv_ruleExpressionTypeRule; 
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
    // $ANTLR end "entryRuleExpressionTypeRule"


    // $ANTLR start "ruleExpressionTypeRule"
    // InternalInstanceLanguage.g:1922:1: ruleExpressionTypeRule returns [EObject current=null] : ( () otherlv_1= 'expression' ) ;
    public final EObject ruleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1928:2: ( ( () otherlv_1= 'expression' ) )
            // InternalInstanceLanguage.g:1929:2: ( () otherlv_1= 'expression' )
            {
            // InternalInstanceLanguage.g:1929:2: ( () otherlv_1= 'expression' )
            // InternalInstanceLanguage.g:1930:3: () otherlv_1= 'expression'
            {
            // InternalInstanceLanguage.g:1930:3: ()
            // InternalInstanceLanguage.g:1931:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,37,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1());
            		

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
    // $ANTLR end "ruleExpressionTypeRule"


    // $ANTLR start "entryRuleIntTypeRule"
    // InternalInstanceLanguage.g:1945:1: entryRuleIntTypeRule returns [EObject current=null] : iv_ruleIntTypeRule= ruleIntTypeRule EOF ;
    public final EObject entryRuleIntTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1945:52: (iv_ruleIntTypeRule= ruleIntTypeRule EOF )
            // InternalInstanceLanguage.g:1946:2: iv_ruleIntTypeRule= ruleIntTypeRule EOF
            {
             newCompositeNode(grammarAccess.getIntTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntTypeRule=ruleIntTypeRule();

            state._fsp--;

             current =iv_ruleIntTypeRule; 
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
    // $ANTLR end "entryRuleIntTypeRule"


    // $ANTLR start "ruleIntTypeRule"
    // InternalInstanceLanguage.g:1952:1: ruleIntTypeRule returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1958:2: ( ( () otherlv_1= 'int' ) )
            // InternalInstanceLanguage.g:1959:2: ( () otherlv_1= 'int' )
            {
            // InternalInstanceLanguage.g:1959:2: ( () otherlv_1= 'int' )
            // InternalInstanceLanguage.g:1960:3: () otherlv_1= 'int'
            {
            // InternalInstanceLanguage.g:1960:3: ()
            // InternalInstanceLanguage.g:1961:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,38,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getIntTypeRuleAccess().getIntKeyword_1());
            		

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
    // $ANTLR end "ruleIntTypeRule"


    // $ANTLR start "entryRuleFloatTypeRule"
    // InternalInstanceLanguage.g:1975:1: entryRuleFloatTypeRule returns [EObject current=null] : iv_ruleFloatTypeRule= ruleFloatTypeRule EOF ;
    public final EObject entryRuleFloatTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1975:54: (iv_ruleFloatTypeRule= ruleFloatTypeRule EOF )
            // InternalInstanceLanguage.g:1976:2: iv_ruleFloatTypeRule= ruleFloatTypeRule EOF
            {
             newCompositeNode(grammarAccess.getFloatTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatTypeRule=ruleFloatTypeRule();

            state._fsp--;

             current =iv_ruleFloatTypeRule; 
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
    // $ANTLR end "entryRuleFloatTypeRule"


    // $ANTLR start "ruleFloatTypeRule"
    // InternalInstanceLanguage.g:1982:1: ruleFloatTypeRule returns [EObject current=null] : ( () otherlv_1= 'float' ) ;
    public final EObject ruleFloatTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1988:2: ( ( () otherlv_1= 'float' ) )
            // InternalInstanceLanguage.g:1989:2: ( () otherlv_1= 'float' )
            {
            // InternalInstanceLanguage.g:1989:2: ( () otherlv_1= 'float' )
            // InternalInstanceLanguage.g:1990:3: () otherlv_1= 'float'
            {
            // InternalInstanceLanguage.g:1990:3: ()
            // InternalInstanceLanguage.g:1991:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFloatTypeRuleAccess().getFloatKeyword_1());
            		

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
    // $ANTLR end "ruleFloatTypeRule"


    // $ANTLR start "entryRuleBooleanTypeRule"
    // InternalInstanceLanguage.g:2005:1: entryRuleBooleanTypeRule returns [EObject current=null] : iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF ;
    public final EObject entryRuleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeRule = null;


        try {
            // InternalInstanceLanguage.g:2005:56: (iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF )
            // InternalInstanceLanguage.g:2006:2: iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanTypeRule=ruleBooleanTypeRule();

            state._fsp--;

             current =iv_ruleBooleanTypeRule; 
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
    // $ANTLR end "entryRuleBooleanTypeRule"


    // $ANTLR start "ruleBooleanTypeRule"
    // InternalInstanceLanguage.g:2012:1: ruleBooleanTypeRule returns [EObject current=null] : ( () otherlv_1= 'boolean' ) ;
    public final EObject ruleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2018:2: ( ( () otherlv_1= 'boolean' ) )
            // InternalInstanceLanguage.g:2019:2: ( () otherlv_1= 'boolean' )
            {
            // InternalInstanceLanguage.g:2019:2: ( () otherlv_1= 'boolean' )
            // InternalInstanceLanguage.g:2020:3: () otherlv_1= 'boolean'
            {
            // InternalInstanceLanguage.g:2020:3: ()
            // InternalInstanceLanguage.g:2021:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1());
            		

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
    // $ANTLR end "ruleBooleanTypeRule"


    // $ANTLR start "entryRuleVoidTypeRule"
    // InternalInstanceLanguage.g:2035:1: entryRuleVoidTypeRule returns [EObject current=null] : iv_ruleVoidTypeRule= ruleVoidTypeRule EOF ;
    public final EObject entryRuleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoidTypeRule = null;


        try {
            // InternalInstanceLanguage.g:2035:53: (iv_ruleVoidTypeRule= ruleVoidTypeRule EOF )
            // InternalInstanceLanguage.g:2036:2: iv_ruleVoidTypeRule= ruleVoidTypeRule EOF
            {
             newCompositeNode(grammarAccess.getVoidTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVoidTypeRule=ruleVoidTypeRule();

            state._fsp--;

             current =iv_ruleVoidTypeRule; 
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
    // $ANTLR end "entryRuleVoidTypeRule"


    // $ANTLR start "ruleVoidTypeRule"
    // InternalInstanceLanguage.g:2042:1: ruleVoidTypeRule returns [EObject current=null] : ( () otherlv_1= 'void' ) ;
    public final EObject ruleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2048:2: ( ( () otherlv_1= 'void' ) )
            // InternalInstanceLanguage.g:2049:2: ( () otherlv_1= 'void' )
            {
            // InternalInstanceLanguage.g:2049:2: ( () otherlv_1= 'void' )
            // InternalInstanceLanguage.g:2050:3: () otherlv_1= 'void'
            {
            // InternalInstanceLanguage.g:2050:3: ()
            // InternalInstanceLanguage.g:2051:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1());
            		

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
    // $ANTLR end "ruleVoidTypeRule"


    // $ANTLR start "entryRuleDataTypeRule"
    // InternalInstanceLanguage.g:2065:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalInstanceLanguage.g:2065:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalInstanceLanguage.g:2066:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeRule=ruleDataTypeRule();

            state._fsp--;

             current =iv_ruleDataTypeRule; 
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
    // $ANTLR end "entryRuleDataTypeRule"


    // $ANTLR start "ruleDataTypeRule"
    // InternalInstanceLanguage.g:2072:1: ruleDataTypeRule returns [EObject current=null] : ( () otherlv_1= 'data' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2078:2: ( ( () otherlv_1= 'data' ) )
            // InternalInstanceLanguage.g:2079:2: ( () otherlv_1= 'data' )
            {
            // InternalInstanceLanguage.g:2079:2: ( () otherlv_1= 'data' )
            // InternalInstanceLanguage.g:2080:3: () otherlv_1= 'data'
            {
            // InternalInstanceLanguage.g:2080:3: ()
            // InternalInstanceLanguage.g:2081:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getDataTypeRuleAccess().getDataKeyword_1());
            		

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
    // $ANTLR end "ruleDataTypeRule"


    // $ANTLR start "entryRuleArrayTypeRule"
    // InternalInstanceLanguage.g:2095:1: entryRuleArrayTypeRule returns [EObject current=null] : iv_ruleArrayTypeRule= ruleArrayTypeRule EOF ;
    public final EObject entryRuleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTypeRule = null;


        try {
            // InternalInstanceLanguage.g:2095:54: (iv_ruleArrayTypeRule= ruleArrayTypeRule EOF )
            // InternalInstanceLanguage.g:2096:2: iv_ruleArrayTypeRule= ruleArrayTypeRule EOF
            {
             newCompositeNode(grammarAccess.getArrayTypeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayTypeRule=ruleArrayTypeRule();

            state._fsp--;

             current =iv_ruleArrayTypeRule; 
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
    // $ANTLR end "entryRuleArrayTypeRule"


    // $ANTLR start "ruleArrayTypeRule"
    // InternalInstanceLanguage.g:2102:1: ruleArrayTypeRule returns [EObject current=null] : (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) ;
    public final EObject ruleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:2108:2: ( (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) )
            // InternalInstanceLanguage.g:2109:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            {
            // InternalInstanceLanguage.g:2109:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            // InternalInstanceLanguage.g:2110:3: otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0());
            		
            // InternalInstanceLanguage.g:2114:3: ( (lv_elements_1_0= ruleTypeRule ) )
            // InternalInstanceLanguage.g:2115:4: (lv_elements_1_0= ruleTypeRule )
            {
            // InternalInstanceLanguage.g:2115:4: (lv_elements_1_0= ruleTypeRule )
            // InternalInstanceLanguage.g:2116:5: lv_elements_1_0= ruleTypeRule
            {

            					newCompositeNode(grammarAccess.getArrayTypeRuleAccess().getElementsTypeRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_elements_1_0=ruleTypeRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArrayTypeRuleRule());
            					}
            					add(
            						current,
            						"elements",
            						lv_elements_1_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
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
    // $ANTLR end "ruleArrayTypeRule"


    // $ANTLR start "entryRuleParameterRule"
    // InternalInstanceLanguage.g:2137:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // InternalInstanceLanguage.g:2137:54: (iv_ruleParameterRule= ruleParameterRule EOF )
            // InternalInstanceLanguage.g:2138:2: iv_ruleParameterRule= ruleParameterRule EOF
            {
             newCompositeNode(grammarAccess.getParameterRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterRule=ruleParameterRule();

            state._fsp--;

             current =iv_ruleParameterRule; 
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
    // $ANTLR end "entryRuleParameterRule"


    // $ANTLR start "ruleParameterRule"
    // InternalInstanceLanguage.g:2144:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:2150:2: ( ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) )
            // InternalInstanceLanguage.g:2151:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            {
            // InternalInstanceLanguage.g:2151:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            // InternalInstanceLanguage.g:2152:3: ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) )
            {
            // InternalInstanceLanguage.g:2152:3: ( (lv_type_0_0= ruleTypeRule ) )
            // InternalInstanceLanguage.g:2153:4: (lv_type_0_0= ruleTypeRule )
            {
            // InternalInstanceLanguage.g:2153:4: (lv_type_0_0= ruleTypeRule )
            // InternalInstanceLanguage.g:2154:5: lv_type_0_0= ruleTypeRule
            {

            					newCompositeNode(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
            lv_type_0_0=ruleTypeRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRuleRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalInstanceLanguage.g:2171:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalInstanceLanguage.g:2172:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalInstanceLanguage.g:2172:4: (lv_name_1_0= ruleStringOrId )
            // InternalInstanceLanguage.g:2173:5: lv_name_1_0= ruleStringOrId
            {

            					newCompositeNode(grammarAccess.getParameterRuleAccess().getNameStringOrIdParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRuleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
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
    // $ANTLR end "ruleParameterRule"


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalInstanceLanguage.g:2194:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalInstanceLanguage.g:2194:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalInstanceLanguage.g:2195:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
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
    // InternalInstanceLanguage.g:2201:1: ruleFunctionNameRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2207:2: ( ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:2208:2: ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:2208:2: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:2209:3: ( ruleQualifiedName )
            {
            // InternalInstanceLanguage.g:2209:3: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:2210:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getFunctionNameRuleRule());
            				}
            			

            				newCompositeNode(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

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
    // $ANTLR end "ruleFunctionNameRule"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalInstanceLanguage.g:2227:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalInstanceLanguage.g:2227:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalInstanceLanguage.g:2228:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalInstanceLanguage.g:2234:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_0 = null;

        AntlrDatatypeRuleToken this_StringOrId_2 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:2240:2: ( (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) )
            // InternalInstanceLanguage.g:2241:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            {
            // InternalInstanceLanguage.g:2241:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            // InternalInstanceLanguage.g:2242:3: this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )*
            {

            			newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0());
            		
            pushFollow(FOLLOW_28);
            this_StringOrId_0=ruleStringOrId();

            state._fsp--;


            			current.merge(this_StringOrId_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalInstanceLanguage.g:2252:3: (kw= '.' this_StringOrId_2= ruleStringOrId )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==43) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2253:4: kw= '.' this_StringOrId_2= ruleStringOrId
            	    {
            	    kw=(Token)match(input,43,FOLLOW_10); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_28);
            	    this_StringOrId_2=ruleStringOrId();

            	    state._fsp--;


            	    				current.merge(this_StringOrId_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleStringOrId"
    // InternalInstanceLanguage.g:2273:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalInstanceLanguage.g:2273:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalInstanceLanguage.g:2274:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalInstanceLanguage.g:2280:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2286:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalInstanceLanguage.g:2287:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalInstanceLanguage.g:2287:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
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
                    // InternalInstanceLanguage.g:2288:3: this_QUOTED_ID_0= RULE_QUOTED_ID
                    {
                    this_QUOTED_ID_0=(Token)match(input,RULE_QUOTED_ID,FOLLOW_2); 

                    			current.merge(this_QUOTED_ID_0);
                    		

                    			newLeafNode(this_QUOTED_ID_0, grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:2296:3: this_ID_1= RULE_ID
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
    // InternalInstanceLanguage.g:2307:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalInstanceLanguage.g:2313:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalInstanceLanguage.g:2314:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalInstanceLanguage.g:2314:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt28=6;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt28=1;
                }
                break;
            case 45:
                {
                alt28=2;
                }
                break;
            case 46:
                {
                alt28=3;
                }
                break;
            case 47:
                {
                alt28=4;
                }
                break;
            case 48:
                {
                alt28=5;
                }
                break;
            case 49:
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
                    // InternalInstanceLanguage.g:2315:3: (enumLiteral_0= '>=' )
                    {
                    // InternalInstanceLanguage.g:2315:3: (enumLiteral_0= '>=' )
                    // InternalInstanceLanguage.g:2316:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:2323:3: (enumLiteral_1= '>' )
                    {
                    // InternalInstanceLanguage.g:2323:3: (enumLiteral_1= '>' )
                    // InternalInstanceLanguage.g:2324:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:2331:3: (enumLiteral_2= '=' )
                    {
                    // InternalInstanceLanguage.g:2331:3: (enumLiteral_2= '=' )
                    // InternalInstanceLanguage.g:2332:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:2339:3: (enumLiteral_3= '!=' )
                    {
                    // InternalInstanceLanguage.g:2339:3: (enumLiteral_3= '!=' )
                    // InternalInstanceLanguage.g:2340:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalInstanceLanguage.g:2347:3: (enumLiteral_4= '<' )
                    {
                    // InternalInstanceLanguage.g:2347:3: (enumLiteral_4= '<' )
                    // InternalInstanceLanguage.g:2348:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalInstanceLanguage.g:2355:3: (enumLiteral_5= '<=' )
                    {
                    // InternalInstanceLanguage.g:2355:3: (enumLiteral_5= '<=' )
                    // InternalInstanceLanguage.g:2356:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,49,FOLLOW_2); 

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
    // InternalInstanceLanguage.g:2366:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2372:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalInstanceLanguage.g:2373:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalInstanceLanguage.g:2373:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==50) ) {
                alt29=1;
            }
            else if ( (LA29_0==51) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalInstanceLanguage.g:2374:3: (enumLiteral_0= '+' )
                    {
                    // InternalInstanceLanguage.g:2374:3: (enumLiteral_0= '+' )
                    // InternalInstanceLanguage.g:2375:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:2382:3: (enumLiteral_1= '-' )
                    {
                    // InternalInstanceLanguage.g:2382:3: (enumLiteral_1= '-' )
                    // InternalInstanceLanguage.g:2383:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); 

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
    // InternalInstanceLanguage.g:2393:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2399:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalInstanceLanguage.g:2400:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalInstanceLanguage.g:2400:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt30=1;
                }
                break;
            case 53:
                {
                alt30=2;
                }
                break;
            case 54:
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
                    // InternalInstanceLanguage.g:2401:3: (enumLiteral_0= '*' )
                    {
                    // InternalInstanceLanguage.g:2401:3: (enumLiteral_0= '*' )
                    // InternalInstanceLanguage.g:2402:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:2409:3: (enumLiteral_1= '/' )
                    {
                    // InternalInstanceLanguage.g:2409:3: (enumLiteral_1= '/' )
                    // InternalInstanceLanguage.g:2410:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:2417:3: (enumLiteral_2= '%' )
                    {
                    // InternalInstanceLanguage.g:2417:3: (enumLiteral_2= '%' )
                    // InternalInstanceLanguage.g:2418:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,54,FOLLOW_2); 

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
    // InternalInstanceLanguage.g:2428:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalInstanceLanguage.g:2434:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalInstanceLanguage.g:2435:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalInstanceLanguage.g:2435:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt31=20;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt31=1;
                }
                break;
            case 56:
                {
                alt31=2;
                }
                break;
            case 57:
                {
                alt31=3;
                }
                break;
            case 58:
                {
                alt31=4;
                }
                break;
            case 59:
                {
                alt31=5;
                }
                break;
            case 60:
                {
                alt31=6;
                }
                break;
            case 61:
                {
                alt31=7;
                }
                break;
            case 62:
                {
                alt31=8;
                }
                break;
            case 63:
                {
                alt31=9;
                }
                break;
            case 64:
                {
                alt31=10;
                }
                break;
            case 65:
                {
                alt31=11;
                }
                break;
            case 66:
                {
                alt31=12;
                }
                break;
            case 67:
                {
                alt31=13;
                }
                break;
            case 68:
                {
                alt31=14;
                }
                break;
            case 69:
                {
                alt31=15;
                }
                break;
            case 70:
                {
                alt31=16;
                }
                break;
            case 71:
                {
                alt31=17;
                }
                break;
            case 72:
                {
                alt31=18;
                }
                break;
            case 73:
                {
                alt31=19;
                }
                break;
            case 74:
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
                    // InternalInstanceLanguage.g:2436:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalInstanceLanguage.g:2436:3: (enumLiteral_0= 'Y' )
                    // InternalInstanceLanguage.g:2437:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:2444:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalInstanceLanguage.g:2444:3: (enumLiteral_1= 'Z' )
                    // InternalInstanceLanguage.g:2445:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:2452:3: (enumLiteral_2= 'E' )
                    {
                    // InternalInstanceLanguage.g:2452:3: (enumLiteral_2= 'E' )
                    // InternalInstanceLanguage.g:2453:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:2460:3: (enumLiteral_3= 'P' )
                    {
                    // InternalInstanceLanguage.g:2460:3: (enumLiteral_3= 'P' )
                    // InternalInstanceLanguage.g:2461:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalInstanceLanguage.g:2468:3: (enumLiteral_4= 'T' )
                    {
                    // InternalInstanceLanguage.g:2468:3: (enumLiteral_4= 'T' )
                    // InternalInstanceLanguage.g:2469:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalInstanceLanguage.g:2476:3: (enumLiteral_5= 'G' )
                    {
                    // InternalInstanceLanguage.g:2476:3: (enumLiteral_5= 'G' )
                    // InternalInstanceLanguage.g:2477:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalInstanceLanguage.g:2484:3: (enumLiteral_6= 'M' )
                    {
                    // InternalInstanceLanguage.g:2484:3: (enumLiteral_6= 'M' )
                    // InternalInstanceLanguage.g:2485:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalInstanceLanguage.g:2492:3: (enumLiteral_7= 'k' )
                    {
                    // InternalInstanceLanguage.g:2492:3: (enumLiteral_7= 'k' )
                    // InternalInstanceLanguage.g:2493:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalInstanceLanguage.g:2500:3: (enumLiteral_8= 'h' )
                    {
                    // InternalInstanceLanguage.g:2500:3: (enumLiteral_8= 'h' )
                    // InternalInstanceLanguage.g:2501:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalInstanceLanguage.g:2508:3: (enumLiteral_9= 'da' )
                    {
                    // InternalInstanceLanguage.g:2508:3: (enumLiteral_9= 'da' )
                    // InternalInstanceLanguage.g:2509:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalInstanceLanguage.g:2516:3: (enumLiteral_10= 'd' )
                    {
                    // InternalInstanceLanguage.g:2516:3: (enumLiteral_10= 'd' )
                    // InternalInstanceLanguage.g:2517:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalInstanceLanguage.g:2524:3: (enumLiteral_11= 'c' )
                    {
                    // InternalInstanceLanguage.g:2524:3: (enumLiteral_11= 'c' )
                    // InternalInstanceLanguage.g:2525:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalInstanceLanguage.g:2532:3: (enumLiteral_12= 'm' )
                    {
                    // InternalInstanceLanguage.g:2532:3: (enumLiteral_12= 'm' )
                    // InternalInstanceLanguage.g:2533:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalInstanceLanguage.g:2540:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalInstanceLanguage.g:2540:3: (enumLiteral_13= '\\u00B5' )
                    // InternalInstanceLanguage.g:2541:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalInstanceLanguage.g:2548:3: (enumLiteral_14= 'n' )
                    {
                    // InternalInstanceLanguage.g:2548:3: (enumLiteral_14= 'n' )
                    // InternalInstanceLanguage.g:2549:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalInstanceLanguage.g:2556:3: (enumLiteral_15= 'p' )
                    {
                    // InternalInstanceLanguage.g:2556:3: (enumLiteral_15= 'p' )
                    // InternalInstanceLanguage.g:2557:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalInstanceLanguage.g:2564:3: (enumLiteral_16= 'f' )
                    {
                    // InternalInstanceLanguage.g:2564:3: (enumLiteral_16= 'f' )
                    // InternalInstanceLanguage.g:2565:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalInstanceLanguage.g:2572:3: (enumLiteral_17= 'a' )
                    {
                    // InternalInstanceLanguage.g:2572:3: (enumLiteral_17= 'a' )
                    // InternalInstanceLanguage.g:2573:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalInstanceLanguage.g:2580:3: (enumLiteral_18= 'z' )
                    {
                    // InternalInstanceLanguage.g:2580:3: (enumLiteral_18= 'z' )
                    // InternalInstanceLanguage.g:2581:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalInstanceLanguage.g:2588:3: (enumLiteral_19= 'y' )
                    {
                    // InternalInstanceLanguage.g:2588:3: (enumLiteral_19= 'y' )
                    // InternalInstanceLanguage.g:2589:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,74,FOLLOW_2); 

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


    protected DFA15 dfa15 = new DFA15(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\uffff\2\6\5\uffff\2\6";
    static final String dfa_3s = "\1\4\2\22\2\uffff\1\7\2\uffff\2\22";
    static final String dfa_4s = "\1\37\2\66\2\uffff\1\10\2\uffff\2\66";
    static final String dfa_5s = "\3\uffff\1\2\1\3\1\uffff\1\4\1\1\2\uffff";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\3\3\1\1\1\2\23\uffff\1\4\1\uffff\2\3",
            "\1\6\1\uffff\1\6\2\uffff\3\6\1\uffff\1\6\1\7\1\6\15\uffff\1\5\13\6",
            "\1\6\1\uffff\1\6\2\uffff\3\6\1\uffff\1\6\1\7\1\6\15\uffff\1\5\13\6",
            "",
            "",
            "\1\10\1\11",
            "",
            "",
            "\1\6\1\uffff\1\6\2\uffff\3\6\1\uffff\1\6\1\7\1\6\15\uffff\1\5\13\6",
            "\1\6\1\uffff\1\6\2\uffff\3\6\1\uffff\1\6\1\7\1\6\15\uffff\1\5\13\6"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1078:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000010180L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000C04801F0L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000C06801F0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000C0000D44801F0L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0003F00000000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000C0000F44801F0L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020100000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xFF80000000000002L,0x00000000000007FFL});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000007F600400000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000080000000002L});

}
package de.evoal.languages.model.base.dsl.parser.antlr.internal;

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
import de.evoal.languages.model.base.dsl.services.BaseLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBaseLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_QUOTED_ID", "RULE_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'['", "','", "']'", "'('", "')'", "'data'", "'instance'", "'{'", "'}'", "':='", "';'", "'true'", "'false'", "'@'", "':'", "'optional'", "'enum'", "'literal'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
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
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
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


        public InternalBaseLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBaseLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBaseLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private BaseLanguageGrammarAccess grammarAccess;

        public InternalBaseLanguageParser(TokenStream input, BaseLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ExpressionRule";
       	}

       	@Override
       	protected BaseLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleExpressionRule"
    // InternalBaseLanguage.g:72:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalBaseLanguage.g:72:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalBaseLanguage.g:73:2: iv_ruleExpressionRule= ruleExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionRule=ruleExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:79:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:85:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalBaseLanguage.g:86:2: this_OrExpressionRule_0= ruleOrExpressionRule
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionRuleAccess().getOrExpressionRuleParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_OrExpressionRule_0=ruleOrExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_OrExpressionRule_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleExpressionRule"


    // $ANTLR start "entryRuleOrExpressionRule"
    // InternalBaseLanguage.g:100:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalBaseLanguage.g:100:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalBaseLanguage.g:101:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrExpressionRule=ruleOrExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:107:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:113:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalBaseLanguage.g:114:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalBaseLanguage.g:114:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalBaseLanguage.g:115:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalBaseLanguage.g:115:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalBaseLanguage.g:116:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalBaseLanguage.g:116:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalBaseLanguage.g:117:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_subExpressions_0_0=ruleXorExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // InternalBaseLanguage.g:134:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBaseLanguage.g:135:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	      			
            	    }
            	    // InternalBaseLanguage.g:139:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalBaseLanguage.g:140:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalBaseLanguage.g:140:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalBaseLanguage.g:141:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_subExpressions_2_0=ruleXorExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOrExpressionRule"


    // $ANTLR start "entryRuleXorExpressionRule"
    // InternalBaseLanguage.g:163:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalBaseLanguage.g:163:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalBaseLanguage.g:164:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXorExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXorExpressionRule=ruleXorExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXorExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:170:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:176:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalBaseLanguage.g:177:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalBaseLanguage.g:177:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalBaseLanguage.g:178:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalBaseLanguage.g:178:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalBaseLanguage.g:179:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalBaseLanguage.g:179:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalBaseLanguage.g:180:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_subExpressions_0_0=ruleAndExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // InternalBaseLanguage.g:197:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBaseLanguage.g:198:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	      			
            	    }
            	    // InternalBaseLanguage.g:202:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalBaseLanguage.g:203:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalBaseLanguage.g:203:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalBaseLanguage.g:204:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_subExpressions_2_0=ruleAndExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXorExpressionRule"


    // $ANTLR start "entryRuleAndExpressionRule"
    // InternalBaseLanguage.g:226:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalBaseLanguage.g:226:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalBaseLanguage.g:227:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpressionRule=ruleAndExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:233:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:239:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalBaseLanguage.g:240:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalBaseLanguage.g:240:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalBaseLanguage.g:241:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalBaseLanguage.g:241:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalBaseLanguage.g:242:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalBaseLanguage.g:242:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalBaseLanguage.g:243:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_subExpressions_0_0=ruleNotExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // InternalBaseLanguage.g:260:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBaseLanguage.g:261:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	      			
            	    }
            	    // InternalBaseLanguage.g:265:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalBaseLanguage.g:266:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalBaseLanguage.g:266:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalBaseLanguage.g:267:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_subExpressions_2_0=ruleNotExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAndExpressionRule"


    // $ANTLR start "entryRuleNotExpressionRule"
    // InternalBaseLanguage.g:289:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalBaseLanguage.g:289:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalBaseLanguage.g:290:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNotExpressionRule=ruleNotExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:296:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:302:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalBaseLanguage.g:303:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalBaseLanguage.g:303:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalBaseLanguage.g:304:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalBaseLanguage.g:304:3: ( (lv_negated_0_0= '!' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBaseLanguage.g:305:4: (lv_negated_0_0= '!' )
                    {
                    // InternalBaseLanguage.g:305:4: (lv_negated_0_0= '!' )
                    // InternalBaseLanguage.g:306:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_negated_0_0, grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getNotExpressionRuleRule());
                      					}
                      					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "!");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBaseLanguage.g:318:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalBaseLanguage.g:319:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalBaseLanguage.g:319:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalBaseLanguage.g:320:5: lv_operand_1_0= ruleComparisonExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNotExpressionRuleAccess().getOperandComparisonExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_1_0=ruleComparisonExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleNotExpressionRule"


    // $ANTLR start "entryRuleComparisonExpressionRule"
    // InternalBaseLanguage.g:341:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalBaseLanguage.g:341:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalBaseLanguage.g:342:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparisonExpressionRule=ruleComparisonExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparisonExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:348:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:354:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalBaseLanguage.g:355:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalBaseLanguage.g:355:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalBaseLanguage.g:356:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalBaseLanguage.g:356:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalBaseLanguage.g:357:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalBaseLanguage.g:357:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalBaseLanguage.g:358:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_7);
            lv_leftOperand_0_0=ruleAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // InternalBaseLanguage.g:375:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=46 && LA5_0<=51)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBaseLanguage.g:376:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalBaseLanguage.g:376:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalBaseLanguage.g:377:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_comparison_1_0=rulePartialComparisonExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleComparisonExpressionRule"


    // $ANTLR start "entryRulePartialComparisonExpressionRule"
    // InternalBaseLanguage.g:398:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalBaseLanguage.g:398:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalBaseLanguage.g:399:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartialComparisonExpressionRule=rulePartialComparisonExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartialComparisonExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:405:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:411:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalBaseLanguage.g:412:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalBaseLanguage.g:412:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalBaseLanguage.g:413:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalBaseLanguage.g:413:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalBaseLanguage.g:414:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalBaseLanguage.g:414:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalBaseLanguage.g:415:5: lv_operator_0_0= ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_operator_0_0=ruleComparisonOperatorRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // InternalBaseLanguage.g:432:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalBaseLanguage.g:433:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalBaseLanguage.g:433:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalBaseLanguage.g:434:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAddOrSubtractExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_subExpression_1_0=ruleAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "rulePartialComparisonExpressionRule"


    // $ANTLR start "entryRuleAddOrSubtractExpressionRule"
    // InternalBaseLanguage.g:455:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalBaseLanguage.g:455:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalBaseLanguage.g:456:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddOrSubtractExpressionRule=ruleAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddOrSubtractExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:462:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:468:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalBaseLanguage.g:469:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalBaseLanguage.g:469:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalBaseLanguage.g:470:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalBaseLanguage.g:470:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalBaseLanguage.g:471:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalBaseLanguage.g:471:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalBaseLanguage.g:472:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_leftOperand_0_0=ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // InternalBaseLanguage.g:489:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=52 && LA6_0<=53)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBaseLanguage.g:490:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalBaseLanguage.g:490:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalBaseLanguage.g:491:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalBaseLanguage.g:491:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalBaseLanguage.g:492:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_operators_1_0=ruleAddOrSubtractOperatorRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }

            	    // InternalBaseLanguage.g:509:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalBaseLanguage.g:510:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalBaseLanguage.g:510:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalBaseLanguage.g:511:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_operands_2_0=ruleMultiplyDivideModuloExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleMultiplyDivideModuloExpressionRule"
    // InternalBaseLanguage.g:533:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalBaseLanguage.g:533:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalBaseLanguage.g:534:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplyDivideModuloExpressionRule=ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplyDivideModuloExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:540:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:546:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalBaseLanguage.g:547:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalBaseLanguage.g:547:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalBaseLanguage.g:548:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalBaseLanguage.g:548:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalBaseLanguage.g:549:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalBaseLanguage.g:549:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalBaseLanguage.g:550:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_leftOperand_0_0=rulePowerOfExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // InternalBaseLanguage.g:567:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=54 && LA7_0<=56)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBaseLanguage.g:568:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalBaseLanguage.g:568:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalBaseLanguage.g:569:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalBaseLanguage.g:569:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalBaseLanguage.g:570:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_operators_1_0=ruleMultiplyDivideModuloOperatorRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }

            	    // InternalBaseLanguage.g:587:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalBaseLanguage.g:588:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalBaseLanguage.g:588:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalBaseLanguage.g:589:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_operands_2_0=rulePowerOfExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "entryRulePowerOfExpressionRule"
    // InternalBaseLanguage.g:611:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalBaseLanguage.g:611:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalBaseLanguage.g:612:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPowerOfExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePowerOfExpressionRule=rulePowerOfExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePowerOfExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:618:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:624:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalBaseLanguage.g:625:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalBaseLanguage.g:625:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalBaseLanguage.g:626:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalBaseLanguage.g:626:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalBaseLanguage.g:627:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalBaseLanguage.g:627:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalBaseLanguage.g:628:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_leftOperand_0_0=ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // InternalBaseLanguage.g:645:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBaseLanguage.g:646:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                      			
                    }
                    // InternalBaseLanguage.g:650:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalBaseLanguage.g:651:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalBaseLanguage.g:651:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalBaseLanguage.g:652:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandPowerOfExpressionRuleParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_rightOperand_2_0=rulePowerOfExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "rulePowerOfExpressionRule"


    // $ANTLR start "entryRuleUnaryAddOrSubtractExpressionRule"
    // InternalBaseLanguage.g:674:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalBaseLanguage.g:674:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalBaseLanguage.g:675:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryAddOrSubtractExpressionRule=ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryAddOrSubtractExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:681:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:687:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) ) )
            // InternalBaseLanguage.g:688:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) )
            {
            // InternalBaseLanguage.g:688:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) )
            // InternalBaseLanguage.g:689:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) )
            {
            // InternalBaseLanguage.g:689:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=52 && LA9_0<=53)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBaseLanguage.g:690:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalBaseLanguage.g:690:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalBaseLanguage.g:691:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_operators_0_0=ruleAddOrSubtractOperatorRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalBaseLanguage.g:708:3: ( (lv_subExpression_1_0= ruleReadExpressionRule ) )
            // InternalBaseLanguage.g:709:4: (lv_subExpression_1_0= ruleReadExpressionRule )
            {
            // InternalBaseLanguage.g:709:4: (lv_subExpression_1_0= ruleReadExpressionRule )
            // InternalBaseLanguage.g:710:5: lv_subExpression_1_0= ruleReadExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionReadExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_subExpression_1_0=ruleReadExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule());
              					}
              					set(
              						current,
              						"subExpression",
              						lv_subExpression_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ReadExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleUnaryAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleReadExpressionRule"
    // InternalBaseLanguage.g:731:1: entryRuleReadExpressionRule returns [EObject current=null] : iv_ruleReadExpressionRule= ruleReadExpressionRule EOF ;
    public final EObject entryRuleReadExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReadExpressionRule = null;


        try {
            // InternalBaseLanguage.g:731:59: (iv_ruleReadExpressionRule= ruleReadExpressionRule EOF )
            // InternalBaseLanguage.g:732:2: iv_ruleReadExpressionRule= ruleReadExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReadExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReadExpressionRule=ruleReadExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReadExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleReadExpressionRule"


    // $ANTLR start "ruleReadExpressionRule"
    // InternalBaseLanguage.g:738:1: ruleReadExpressionRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) ;
    public final EObject ruleReadExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_CallRule_1 = null;

        EObject this_LiteralRule_2 = null;

        EObject this_ParanthesesRule_3 = null;

        EObject this_ReferenceRule_4 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:744:2: ( (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) )
            // InternalBaseLanguage.g:745:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            {
            // InternalBaseLanguage.g:745:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            int alt10=5;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalBaseLanguage.g:746:3: this_ArrayRule_0= ruleArrayRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReadExpressionRuleAccess().getArrayRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArrayRule_0=ruleArrayRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArrayRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:758:3: this_CallRule_1= ruleCallRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReadExpressionRuleAccess().getCallRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CallRule_1=ruleCallRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CallRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBaseLanguage.g:770:3: this_LiteralRule_2= ruleLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReadExpressionRuleAccess().getLiteralRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralRule_2=ruleLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBaseLanguage.g:782:3: this_ParanthesesRule_3= ruleParanthesesRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReadExpressionRuleAccess().getParanthesesRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParanthesesRule_3=ruleParanthesesRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParanthesesRule_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBaseLanguage.g:794:3: this_ReferenceRule_4= ruleReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReadExpressionRuleAccess().getReferenceRuleParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ReferenceRule_4=ruleReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ReferenceRule_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleReadExpressionRule"


    // $ANTLR start "entryRuleArrayRule"
    // InternalBaseLanguage.g:809:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalBaseLanguage.g:809:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalBaseLanguage.g:810:2: iv_ruleArrayRule= ruleArrayRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayRule=ruleArrayRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:816:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:822:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' ) )
            // InternalBaseLanguage.g:823:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalBaseLanguage.g:823:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' )
            // InternalBaseLanguage.g:824:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']'
            {
            // InternalBaseLanguage.g:824:3: ()
            // InternalBaseLanguage.g:825:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getArrayRuleAccess().getArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalBaseLanguage.g:838:3: ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_DOUBLE && LA12_0<=RULE_ID)||LA12_0==20||LA12_0==23||(LA12_0>=25 && LA12_0<=26)||(LA12_0>=31 && LA12_0<=32)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalBaseLanguage.g:839:4: ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )*
                    {
                    // InternalBaseLanguage.g:839:4: ( (lv_values_2_0= ruleReadExpressionRule ) )
                    // InternalBaseLanguage.g:840:5: (lv_values_2_0= ruleReadExpressionRule )
                    {
                    // InternalBaseLanguage.g:840:5: (lv_values_2_0= ruleReadExpressionRule )
                    // InternalBaseLanguage.g:841:6: lv_values_2_0= ruleReadExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
                    lv_values_2_0=ruleReadExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getArrayRuleRule());
                      						}
                      						add(
                      							current,
                      							"values",
                      							lv_values_2_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.ReadExpressionRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBaseLanguage.g:858:4: (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==21) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalBaseLanguage.g:859:5: otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalBaseLanguage.g:863:5: ( (lv_values_4_0= ruleReadExpressionRule ) )
                    	    // InternalBaseLanguage.g:864:6: (lv_values_4_0= ruleReadExpressionRule )
                    	    {
                    	    // InternalBaseLanguage.g:864:6: (lv_values_4_0= ruleReadExpressionRule )
                    	    // InternalBaseLanguage.g:865:7: lv_values_4_0= ruleReadExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_12);
                    	    lv_values_4_0=ruleReadExpressionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getArrayRuleRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"values",
                    	      								lv_values_4_0,
                    	      								"de.evoal.languages.model.base.dsl.BaseLanguage.ReadExpressionRule");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

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

            otherlv_5=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleArrayRule"


    // $ANTLR start "entryRuleParanthesesRule"
    // InternalBaseLanguage.g:892:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalBaseLanguage.g:892:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalBaseLanguage.g:893:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParanthesesRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParanthesesRule=ruleParanthesesRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParanthesesRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:899:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:905:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalBaseLanguage.g:906:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalBaseLanguage.g:906:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalBaseLanguage.g:907:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalBaseLanguage.g:911:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalBaseLanguage.g:912:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalBaseLanguage.g:912:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalBaseLanguage.g:913:5: lv_subExpression_1_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_subExpression_1_0=ruleExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            otherlv_2=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleParanthesesRule"


    // $ANTLR start "entryRuleCallRule"
    // InternalBaseLanguage.g:938:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalBaseLanguage.g:938:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalBaseLanguage.g:939:2: iv_ruleCallRule= ruleCallRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCallRule=ruleCallRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:945:1: ruleCallRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleCallRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:951:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalBaseLanguage.g:952:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalBaseLanguage.g:952:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalBaseLanguage.g:953:3: ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalBaseLanguage.g:953:3: ( ( ruleQualifiedName ) )
            // InternalBaseLanguage.g:954:4: ( ruleQualifiedName )
            {
            // InternalBaseLanguage.g:954:4: ( ruleQualifiedName )
            // InternalBaseLanguage.g:955:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCallRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_14);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBaseLanguage.g:976:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_DOUBLE && LA14_0<=RULE_ID)||LA14_0==18||LA14_0==20||LA14_0==23||(LA14_0>=25 && LA14_0<=26)||(LA14_0>=31 && LA14_0<=32)||(LA14_0>=52 && LA14_0<=53)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalBaseLanguage.g:977:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalBaseLanguage.g:977:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalBaseLanguage.g:978:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalBaseLanguage.g:978:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalBaseLanguage.g:979:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_parameters_2_0=ruleExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }

                    // InternalBaseLanguage.g:996:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==21) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalBaseLanguage.g:997:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalBaseLanguage.g:1001:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalBaseLanguage.g:1002:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalBaseLanguage.g:1002:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalBaseLanguage.g:1003:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_16);
                    	    lv_parameters_4_0=ruleExpressionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleCallRule"


    // $ANTLR start "entryRuleReferenceRule"
    // InternalBaseLanguage.g:1030:1: entryRuleReferenceRule returns [EObject current=null] : iv_ruleReferenceRule= ruleReferenceRule EOF ;
    public final EObject entryRuleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceRule = null;


        try {
            // InternalBaseLanguage.g:1030:54: (iv_ruleReferenceRule= ruleReferenceRule EOF )
            // InternalBaseLanguage.g:1031:2: iv_ruleReferenceRule= ruleReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReferenceRule=ruleReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleReferenceRule"


    // $ANTLR start "ruleReferenceRule"
    // InternalBaseLanguage.g:1037:1: ruleReferenceRule returns [EObject current=null] : (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule ) ;
    public final EObject ruleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_ValuelDefinitionReferenceRule_0 = null;

        EObject this_TypeDefinitionReferenceRule_1 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1043:2: ( (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule ) )
            // InternalBaseLanguage.g:1044:2: (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule )
            {
            // InternalBaseLanguage.g:1044:2: (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_QUOTED_ID && LA15_0<=RULE_ID)) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=25 && LA15_0<=26)) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalBaseLanguage.g:1045:3: this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getValuelDefinitionReferenceRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ValuelDefinitionReferenceRule_0=ruleValuelDefinitionReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValuelDefinitionReferenceRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1057:3: this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getTypeDefinitionReferenceRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeDefinitionReferenceRule_1=ruleTypeDefinitionReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeDefinitionReferenceRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleReferenceRule"


    // $ANTLR start "entryRuleValuelDefinitionReferenceRule"
    // InternalBaseLanguage.g:1072:1: entryRuleValuelDefinitionReferenceRule returns [EObject current=null] : iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF ;
    public final EObject entryRuleValuelDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuelDefinitionReferenceRule = null;


        try {
            // InternalBaseLanguage.g:1072:70: (iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF )
            // InternalBaseLanguage.g:1073:2: iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValuelDefinitionReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValuelDefinitionReferenceRule=ruleValuelDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValuelDefinitionReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleValuelDefinitionReferenceRule"


    // $ANTLR start "ruleValuelDefinitionReferenceRule"
    // InternalBaseLanguage.g:1079:1: ruleValuelDefinitionReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleValuelDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:1085:2: ( ( ( ruleQualifiedName ) ) )
            // InternalBaseLanguage.g:1086:2: ( ( ruleQualifiedName ) )
            {
            // InternalBaseLanguage.g:1086:2: ( ( ruleQualifiedName ) )
            // InternalBaseLanguage.g:1087:3: ( ruleQualifiedName )
            {
            // InternalBaseLanguage.g:1087:3: ( ruleQualifiedName )
            // InternalBaseLanguage.g:1088:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getValuelDefinitionReferenceRuleRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionValueDefinitionCrossReference_0());
              			
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleValuelDefinitionReferenceRule"


    // $ANTLR start "entryRuleTypeDefinitionReferenceRule"
    // InternalBaseLanguage.g:1108:1: entryRuleTypeDefinitionReferenceRule returns [EObject current=null] : iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF ;
    public final EObject entryRuleTypeDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinitionReferenceRule = null;


        try {
            // InternalBaseLanguage.g:1108:68: (iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF )
            // InternalBaseLanguage.g:1109:2: iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefinitionReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeDefinitionReferenceRule=ruleTypeDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDefinitionReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeDefinitionReferenceRule"


    // $ANTLR start "ruleTypeDefinitionReferenceRule"
    // InternalBaseLanguage.g:1115:1: ruleTypeDefinitionReferenceRule returns [EObject current=null] : (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule ) ;
    public final EObject ruleTypeDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_BaseDataReferenceRule_0 = null;

        EObject this_StructuredDataDescriptionReferenceRule_1 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1121:2: ( (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule ) )
            // InternalBaseLanguage.g:1122:2: (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule )
            {
            // InternalBaseLanguage.g:1122:2: (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            else if ( (LA16_0==26) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalBaseLanguage.g:1123:3: this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeDefinitionReferenceRuleAccess().getBaseDataReferenceRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BaseDataReferenceRule_0=ruleBaseDataReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BaseDataReferenceRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1135:3: this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeDefinitionReferenceRuleAccess().getStructuredDataDescriptionReferenceRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StructuredDataDescriptionReferenceRule_1=ruleStructuredDataDescriptionReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StructuredDataDescriptionReferenceRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleTypeDefinitionReferenceRule"


    // $ANTLR start "entryRuleBaseDataReferenceRule"
    // InternalBaseLanguage.g:1150:1: entryRuleBaseDataReferenceRule returns [EObject current=null] : iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF ;
    public final EObject entryRuleBaseDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseDataReferenceRule = null;


        try {
            // InternalBaseLanguage.g:1150:62: (iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF )
            // InternalBaseLanguage.g:1151:2: iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBaseDataReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBaseDataReferenceRule=ruleBaseDataReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBaseDataReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBaseDataReferenceRule"


    // $ANTLR start "ruleBaseDataReferenceRule"
    // InternalBaseLanguage.g:1157:1: ruleBaseDataReferenceRule returns [EObject current=null] : (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleBaseDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:1163:2: ( (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) )
            // InternalBaseLanguage.g:1164:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            {
            // InternalBaseLanguage.g:1164:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            // InternalBaseLanguage.g:1165:3: otherlv_0= 'data' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBaseDataReferenceRuleAccess().getDataKeyword_0());
              		
            }
            // InternalBaseLanguage.g:1169:3: ( ( ruleQualifiedName ) )
            // InternalBaseLanguage.g:1170:4: ( ruleQualifiedName )
            {
            // InternalBaseLanguage.g:1170:4: ( ruleQualifiedName )
            // InternalBaseLanguage.g:1171:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBaseDataReferenceRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionBaseDataDescriptionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleBaseDataReferenceRule"


    // $ANTLR start "entryRuleStructuredDataDescriptionReferenceRule"
    // InternalBaseLanguage.g:1192:1: entryRuleStructuredDataDescriptionReferenceRule returns [EObject current=null] : iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF ;
    public final EObject entryRuleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataDescriptionReferenceRule = null;


        try {
            // InternalBaseLanguage.g:1192:79: (iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF )
            // InternalBaseLanguage.g:1193:2: iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStructuredDataDescriptionReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStructuredDataDescriptionReferenceRule=ruleStructuredDataDescriptionReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStructuredDataDescriptionReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleStructuredDataDescriptionReferenceRule"


    // $ANTLR start "ruleStructuredDataDescriptionReferenceRule"
    // InternalBaseLanguage.g:1199:1: ruleStructuredDataDescriptionReferenceRule returns [EObject current=null] : (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:1205:2: ( (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalBaseLanguage.g:1206:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalBaseLanguage.g:1206:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalBaseLanguage.g:1207:3: otherlv_0= 'instance' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getInstanceKeyword_0());
              		
            }
            // InternalBaseLanguage.g:1211:3: ( ( ruleQualifiedName ) )
            // InternalBaseLanguage.g:1212:4: ( ruleQualifiedName )
            {
            // InternalBaseLanguage.g:1212:4: ( ruleQualifiedName )
            // InternalBaseLanguage.g:1213:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStructuredDataDescriptionReferenceRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionStructuredDataDescriptionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleStructuredDataDescriptionReferenceRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalBaseLanguage.g:1234:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalBaseLanguage.g:1234:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalBaseLanguage.g:1235:2: iv_ruleLiteralRule= ruleLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralRule=ruleLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:1241:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_InstanceLiteralRule_3 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1247:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) )
            // InternalBaseLanguage.g:1248:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            {
            // InternalBaseLanguage.g:1248:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            int alt17=4;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt17=1;
                }
                break;
            case RULE_STRING:
                {
                alt17=2;
                }
                break;
            case 31:
            case 32:
                {
                alt17=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt17=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalBaseLanguage.g:1249:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralRuleAccess().getNumberLiteralRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NumberLiteralRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1261:3: this_StringLiteralRule_1= ruleStringLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralRuleAccess().getStringLiteralRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteralRule_1=ruleStringLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringLiteralRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBaseLanguage.g:1273:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralRuleAccess().getBooleanLiteralRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanLiteralRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBaseLanguage.g:1285:3: this_InstanceLiteralRule_3= ruleInstanceLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralRuleAccess().getInstanceLiteralRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_InstanceLiteralRule_3=ruleInstanceLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_InstanceLiteralRule_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralRule"


    // $ANTLR start "entryRuleInstanceLiteralRule"
    // InternalBaseLanguage.g:1300:1: entryRuleInstanceLiteralRule returns [EObject current=null] : iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF ;
    public final EObject entryRuleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceLiteralRule = null;


        try {
            // InternalBaseLanguage.g:1300:60: (iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF )
            // InternalBaseLanguage.g:1301:2: iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstanceLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstanceLiteralRule=ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstanceLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleInstanceLiteralRule"


    // $ANTLR start "ruleInstanceLiteralRule"
    // InternalBaseLanguage.g:1307:1: ruleInstanceLiteralRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) ;
    public final EObject ruleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1313:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) )
            // InternalBaseLanguage.g:1314:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            {
            // InternalBaseLanguage.g:1314:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            // InternalBaseLanguage.g:1315:3: ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
            {
            // InternalBaseLanguage.g:1315:3: ( ( ruleQualifiedName ) )
            // InternalBaseLanguage.g:1316:4: ( ruleQualifiedName )
            {
            // InternalBaseLanguage.g:1316:4: ( ruleQualifiedName )
            // InternalBaseLanguage.g:1317:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInstanceLiteralRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionClassDefinitionCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_18);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalBaseLanguage.g:1338:3: ( (lv_attributes_2_0= ruleAttributeRule ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_QUOTED_ID && LA18_0<=RULE_ID)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBaseLanguage.g:1339:4: (lv_attributes_2_0= ruleAttributeRule )
            	    {
            	    // InternalBaseLanguage.g:1339:4: (lv_attributes_2_0= ruleAttributeRule )
            	    // InternalBaseLanguage.g:1340:5: lv_attributes_2_0= ruleAttributeRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAttributeRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_19);
            	    lv_attributes_2_0=ruleAttributeRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getInstanceLiteralRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"attributes",
            	      						lv_attributes_2_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.AttributeRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getInstanceLiteralRuleAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleInstanceLiteralRule"


    // $ANTLR start "entryRuleAttributeRule"
    // InternalBaseLanguage.g:1365:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalBaseLanguage.g:1365:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalBaseLanguage.g:1366:2: iv_ruleAttributeRule= ruleAttributeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttributeRule=ruleAttributeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttributeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:1372:1: ruleAttributeRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1378:2: ( ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) )
            // InternalBaseLanguage.g:1379:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            {
            // InternalBaseLanguage.g:1379:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            // InternalBaseLanguage.g:1380:3: ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';'
            {
            // InternalBaseLanguage.g:1380:3: ( ( ruleStringOrId ) )
            // InternalBaseLanguage.g:1381:4: ( ruleStringOrId )
            {
            // InternalBaseLanguage.g:1381:4: ( ruleStringOrId )
            // InternalBaseLanguage.g:1382:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAttributeRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_20);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalBaseLanguage.g:1403:3: ( (lv_value_2_0= ruleExpressionRule ) )
            // InternalBaseLanguage.g:1404:4: (lv_value_2_0= ruleExpressionRule )
            {
            // InternalBaseLanguage.g:1404:4: (lv_value_2_0= ruleExpressionRule )
            // InternalBaseLanguage.g:1405:5: lv_value_2_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueExpressionRuleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_value_2_0=ruleExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeRuleRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAttributeRule"


    // $ANTLR start "entryRuleNumberLiteralRule"
    // InternalBaseLanguage.g:1430:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalBaseLanguage.g:1430:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalBaseLanguage.g:1431:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:1437:1: ruleNumberLiteralRule returns [EObject current=null] : (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1443:2: ( (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalBaseLanguage.g:1444:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalBaseLanguage.g:1444:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_DOUBLE) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_INT) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalBaseLanguage.g:1445:3: this_RealLiteralRule_0= ruleRealLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RealLiteralRule_0=ruleRealLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RealLiteralRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1457:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IntegerLiteralRule_1=ruleIntegerLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntegerLiteralRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleNumberLiteralRule"


    // $ANTLR start "entryRuleRealLiteralRule"
    // InternalBaseLanguage.g:1472:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // InternalBaseLanguage.g:1472:56: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // InternalBaseLanguage.g:1473:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRealLiteralRule=ruleRealLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRealLiteralRule"


    // $ANTLR start "ruleRealLiteralRule"
    // InternalBaseLanguage.g:1479:1: ruleRealLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1485:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalBaseLanguage.g:1486:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalBaseLanguage.g:1486:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalBaseLanguage.g:1487:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalBaseLanguage.g:1487:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalBaseLanguage.g:1488:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalBaseLanguage.g:1488:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalBaseLanguage.g:1489:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_literal_0_0, grammarAccess.getRealLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRealLiteralRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"literal",
              						lv_literal_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.DOUBLE");
              				
            }

            }


            }

            // InternalBaseLanguage.g:1505:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=57 && LA20_0<=76)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBaseLanguage.g:1506:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalBaseLanguage.g:1506:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalBaseLanguage.g:1507:5: lv_factor_1_0= ruleFactorRule
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRealLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_factor_1_0=ruleFactorRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRealLiteralRuleRule());
                      					}
                      					set(
                      						current,
                      						"factor",
                      						lv_factor_1_0,
                      						"de.evoal.languages.model.base.dsl.BaseLanguage.FactorRule");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleRealLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // InternalBaseLanguage.g:1528:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalBaseLanguage.g:1528:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalBaseLanguage.g:1529:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:1535:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1541:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalBaseLanguage.g:1542:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalBaseLanguage.g:1542:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalBaseLanguage.g:1543:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalBaseLanguage.g:1543:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalBaseLanguage.g:1544:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalBaseLanguage.g:1544:4: (lv_literal_0_0= RULE_INT )
            // InternalBaseLanguage.g:1545:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_literal_0_0, grammarAccess.getIntegerLiteralRuleAccess().getLiteralINTTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

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


            }

            // InternalBaseLanguage.g:1561:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=57 && LA21_0<=76)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalBaseLanguage.g:1562:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalBaseLanguage.g:1562:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalBaseLanguage.g:1563:5: lv_factor_1_0= ruleFactorRule
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIntegerLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_factor_1_0=ruleFactorRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIntegerLiteralRule"


    // $ANTLR start "entryRuleStringLiteralRule"
    // InternalBaseLanguage.g:1584:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalBaseLanguage.g:1584:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalBaseLanguage.g:1585:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:1591:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_literal_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:1597:2: ( ( (lv_literal_0_0= RULE_STRING ) ) )
            // InternalBaseLanguage.g:1598:2: ( (lv_literal_0_0= RULE_STRING ) )
            {
            // InternalBaseLanguage.g:1598:2: ( (lv_literal_0_0= RULE_STRING ) )
            // InternalBaseLanguage.g:1599:3: (lv_literal_0_0= RULE_STRING )
            {
            // InternalBaseLanguage.g:1599:3: (lv_literal_0_0= RULE_STRING )
            // InternalBaseLanguage.g:1600:4: lv_literal_0_0= RULE_STRING
            {
            lv_literal_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_literal_0_0, grammarAccess.getStringLiteralRuleAccess().getLiteralSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getStringLiteralRuleRule());
              				}
              				setWithLastConsumed(
              					current,
              					"literal",
              					lv_literal_0_0,
              					"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleStringLiteralRule"


    // $ANTLR start "entryRuleBooleanLiteralRule"
    // InternalBaseLanguage.g:1619:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalBaseLanguage.g:1619:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalBaseLanguage.g:1620:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:1626:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:1632:2: ( ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalBaseLanguage.g:1633:2: ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalBaseLanguage.g:1633:2: ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalBaseLanguage.g:1634:3: () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalBaseLanguage.g:1634:3: ()
            // InternalBaseLanguage.g:1635:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalBaseLanguage.g:1644:3: ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            else if ( (LA22_0==32) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalBaseLanguage.g:1645:4: ( (lv_literal_1_0= 'true' ) )
                    {
                    // InternalBaseLanguage.g:1645:4: ( (lv_literal_1_0= 'true' ) )
                    // InternalBaseLanguage.g:1646:5: (lv_literal_1_0= 'true' )
                    {
                    // InternalBaseLanguage.g:1646:5: (lv_literal_1_0= 'true' )
                    // InternalBaseLanguage.g:1647:6: lv_literal_1_0= 'true'
                    {
                    lv_literal_1_0=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_literal_1_0, grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBooleanLiteralRuleRule());
                      						}
                      						setWithLastConsumed(current, "literal", lv_literal_1_0 != null, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1660:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralRuleAccess().getFalseKeyword_1_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleBooleanLiteralRule"


    // $ANTLR start "entryRuleConstraintRule"
    // InternalBaseLanguage.g:1669:1: entryRuleConstraintRule returns [EObject current=null] : iv_ruleConstraintRule= ruleConstraintRule EOF ;
    public final EObject entryRuleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRule = null;


        try {
            // InternalBaseLanguage.g:1669:55: (iv_ruleConstraintRule= ruleConstraintRule EOF )
            // InternalBaseLanguage.g:1670:2: iv_ruleConstraintRule= ruleConstraintRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstraintRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstraintRule=ruleConstraintRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstraintRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:1676:1: ruleConstraintRule returns [EObject current=null] : (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) ;
    public final EObject ruleConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_InstanceLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1682:2: ( (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) )
            // InternalBaseLanguage.g:1683:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            {
            // InternalBaseLanguage.g:1683:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            // InternalBaseLanguage.g:1684:3: otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule
            {
            otherlv_0=(Token)match(input,33,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstraintRuleAccess().getCommercialAtKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConstraintRuleAccess().getInstanceLiteralRuleParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_2);
            this_InstanceLiteralRule_1=ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_InstanceLiteralRule_1;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleConstraintRule"


    // $ANTLR start "entryRuleAttributeDefinitionRule"
    // InternalBaseLanguage.g:1703:1: entryRuleAttributeDefinitionRule returns [EObject current=null] : iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF ;
    public final EObject entryRuleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDefinitionRule = null;


        try {
            // InternalBaseLanguage.g:1703:64: (iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF )
            // InternalBaseLanguage.g:1704:2: iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttributeDefinitionRule=ruleAttributeDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttributeDefinitionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:1710:1: ruleAttributeDefinitionRule returns [EObject current=null] : ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' ) ;
    public final EObject ruleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_optional_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_constraints_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_initialisation_6_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1716:2: ( ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' ) )
            // InternalBaseLanguage.g:1717:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' )
            {
            // InternalBaseLanguage.g:1717:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' )
            // InternalBaseLanguage.g:1718:3: ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';'
            {
            // InternalBaseLanguage.g:1718:3: ( (lv_constraints_0_0= ruleConstraintRule ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==33) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBaseLanguage.g:1719:4: (lv_constraints_0_0= ruleConstraintRule )
            	    {
            	    // InternalBaseLanguage.g:1719:4: (lv_constraints_0_0= ruleConstraintRule )
            	    // InternalBaseLanguage.g:1720:5: lv_constraints_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_constraints_0_0=ruleConstraintRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"constraints",
            	      						lv_constraints_0_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.ConstraintRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // InternalBaseLanguage.g:1737:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalBaseLanguage.g:1738:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalBaseLanguage.g:1738:4: (lv_name_1_0= ruleStringOrId )
            // InternalBaseLanguage.g:1739:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
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

            otherlv_2=(Token)match(input,34,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2());
              		
            }
            // InternalBaseLanguage.g:1760:3: ( (lv_optional_3_0= 'optional' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBaseLanguage.g:1761:4: (lv_optional_3_0= 'optional' )
                    {
                    // InternalBaseLanguage.g:1761:4: (lv_optional_3_0= 'optional' )
                    // InternalBaseLanguage.g:1762:5: lv_optional_3_0= 'optional'
                    {
                    lv_optional_3_0=(Token)match(input,35,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_optional_3_0, grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getAttributeDefinitionRuleRule());
                      					}
                      					setWithLastConsumed(current, "optional", lv_optional_3_0 != null, "optional");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBaseLanguage.g:1774:3: ( (lv_type_4_0= ruleTypeRule ) )
            // InternalBaseLanguage.g:1775:4: (lv_type_4_0= ruleTypeRule )
            {
            // InternalBaseLanguage.g:1775:4: (lv_type_4_0= ruleTypeRule )
            // InternalBaseLanguage.g:1776:5: lv_type_4_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_type_4_0=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_4_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBaseLanguage.g:1793:3: (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==29) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBaseLanguage.g:1794:4: otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) )
                    {
                    otherlv_5=(Token)match(input,29,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_5_0());
                      			
                    }
                    // InternalBaseLanguage.g:1798:4: ( (lv_initialisation_6_0= ruleExpressionRule ) )
                    // InternalBaseLanguage.g:1799:5: (lv_initialisation_6_0= ruleExpressionRule )
                    {
                    // InternalBaseLanguage.g:1799:5: (lv_initialisation_6_0= ruleExpressionRule )
                    // InternalBaseLanguage.g:1800:6: lv_initialisation_6_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_initialisation_6_0=ruleExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
                      						}
                      						set(
                      							current,
                      							"initialisation",
                      							lv_initialisation_6_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAttributeDefinitionRule"


    // $ANTLR start "entryRuleTypeRule"
    // InternalBaseLanguage.g:1826:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // InternalBaseLanguage.g:1826:49: (iv_ruleTypeRule= ruleTypeRule EOF )
            // InternalBaseLanguage.g:1827:2: iv_ruleTypeRule= ruleTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeRule=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:1833:1: ruleTypeRule returns [EObject current=null] : (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayTypeRule_0 = null;

        EObject this_BaseTypeRule_1 = null;

        EObject this_TypeReferenceRule_2 = null;

        EObject this_EnumReferenceRule_3 = null;

        EObject this_ExpressionTypeRule_4 = null;

        EObject this_LiteralTypeRule_5 = null;

        EObject this_DataTypeRule_6 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1839:2: ( (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule ) )
            // InternalBaseLanguage.g:1840:2: (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule )
            {
            // InternalBaseLanguage.g:1840:2: (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule )
            int alt26=7;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt26=1;
                }
                break;
            case 38:
            case 40:
            case 41:
            case 42:
            case 43:
                {
                alt26=2;
                }
                break;
            case 26:
                {
                alt26=3;
                }
                break;
            case 36:
                {
                alt26=4;
                }
                break;
            case 39:
                {
                alt26=5;
                }
                break;
            case 37:
                {
                alt26=6;
                }
                break;
            case 25:
                {
                alt26=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalBaseLanguage.g:1841:3: this_ArrayTypeRule_0= ruleArrayTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArrayTypeRule_0=ruleArrayTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArrayTypeRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1853:3: this_BaseTypeRule_1= ruleBaseTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getBaseTypeRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BaseTypeRule_1=ruleBaseTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BaseTypeRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBaseLanguage.g:1865:3: this_TypeReferenceRule_2= ruleTypeReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getTypeReferenceRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeReferenceRule_2=ruleTypeReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeReferenceRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBaseLanguage.g:1877:3: this_EnumReferenceRule_3= ruleEnumReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getEnumReferenceRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EnumReferenceRule_3=ruleEnumReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EnumReferenceRule_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBaseLanguage.g:1889:3: this_ExpressionTypeRule_4= ruleExpressionTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExpressionTypeRule_4=ruleExpressionTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExpressionTypeRule_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBaseLanguage.g:1901:3: this_LiteralTypeRule_5= ruleLiteralTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralTypeRule_5=ruleLiteralTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralTypeRule_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalBaseLanguage.g:1913:3: this_DataTypeRule_6= ruleDataTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getDataTypeRuleParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DataTypeRule_6=ruleDataTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DataTypeRule_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleTypeRule"


    // $ANTLR start "entryRuleBaseTypeRule"
    // InternalBaseLanguage.g:1928:1: entryRuleBaseTypeRule returns [EObject current=null] : iv_ruleBaseTypeRule= ruleBaseTypeRule EOF ;
    public final EObject entryRuleBaseTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseTypeRule = null;


        try {
            // InternalBaseLanguage.g:1928:53: (iv_ruleBaseTypeRule= ruleBaseTypeRule EOF )
            // InternalBaseLanguage.g:1929:2: iv_ruleBaseTypeRule= ruleBaseTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBaseTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBaseTypeRule=ruleBaseTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBaseTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBaseTypeRule"


    // $ANTLR start "ruleBaseTypeRule"
    // InternalBaseLanguage.g:1935:1: ruleBaseTypeRule returns [EObject current=null] : (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule ) ;
    public final EObject ruleBaseTypeRule() throws RecognitionException {
        EObject current = null;

        EObject this_StringTypeRule_0 = null;

        EObject this_IntTypeRule_1 = null;

        EObject this_RealTypeRule_2 = null;

        EObject this_BooleanTypeRule_3 = null;

        EObject this_VoidTypeRule_4 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:1941:2: ( (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule ) )
            // InternalBaseLanguage.g:1942:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule )
            {
            // InternalBaseLanguage.g:1942:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule )
            int alt27=5;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt27=1;
                }
                break;
            case 40:
                {
                alt27=2;
                }
                break;
            case 41:
                {
                alt27=3;
                }
                break;
            case 42:
                {
                alt27=4;
                }
                break;
            case 43:
                {
                alt27=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalBaseLanguage.g:1943:3: this_StringTypeRule_0= ruleStringTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBaseTypeRuleAccess().getStringTypeRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringTypeRule_0=ruleStringTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringTypeRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:1955:3: this_IntTypeRule_1= ruleIntTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBaseTypeRuleAccess().getIntTypeRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IntTypeRule_1=ruleIntTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntTypeRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBaseLanguage.g:1967:3: this_RealTypeRule_2= ruleRealTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBaseTypeRuleAccess().getRealTypeRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RealTypeRule_2=ruleRealTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RealTypeRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBaseLanguage.g:1979:3: this_BooleanTypeRule_3= ruleBooleanTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBaseTypeRuleAccess().getBooleanTypeRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanTypeRule_3=ruleBooleanTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanTypeRule_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBaseLanguage.g:1991:3: this_VoidTypeRule_4= ruleVoidTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBaseTypeRuleAccess().getVoidTypeRuleParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VoidTypeRule_4=ruleVoidTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VoidTypeRule_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleBaseTypeRule"


    // $ANTLR start "entryRuleEnumReferenceRule"
    // InternalBaseLanguage.g:2006:1: entryRuleEnumReferenceRule returns [EObject current=null] : iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF ;
    public final EObject entryRuleEnumReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumReferenceRule = null;


        try {
            // InternalBaseLanguage.g:2006:58: (iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF )
            // InternalBaseLanguage.g:2007:2: iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumReferenceRule=ruleEnumReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEnumReferenceRule"


    // $ANTLR start "ruleEnumReferenceRule"
    // InternalBaseLanguage.g:2013:1: ruleEnumReferenceRule returns [EObject current=null] : (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleEnumReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2019:2: ( (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) ) )
            // InternalBaseLanguage.g:2020:2: (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) )
            {
            // InternalBaseLanguage.g:2020:2: (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) )
            // InternalBaseLanguage.g:2021:3: otherlv_0= 'enum' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumReferenceRuleAccess().getEnumKeyword_0());
              		
            }
            // InternalBaseLanguage.g:2025:3: ( ( ruleQualifiedName ) )
            // InternalBaseLanguage.g:2026:4: ( ruleQualifiedName )
            {
            // InternalBaseLanguage.g:2026:4: ( ruleQualifiedName )
            // InternalBaseLanguage.g:2027:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumReferenceRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumReferenceRuleAccess().getDefinitionEnumDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleEnumReferenceRule"


    // $ANTLR start "entryRuleTypeReferenceRule"
    // InternalBaseLanguage.g:2048:1: entryRuleTypeReferenceRule returns [EObject current=null] : iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF ;
    public final EObject entryRuleTypeReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReferenceRule = null;


        try {
            // InternalBaseLanguage.g:2048:58: (iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF )
            // InternalBaseLanguage.g:2049:2: iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeReferenceRule=ruleTypeReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeReferenceRule"


    // $ANTLR start "ruleTypeReferenceRule"
    // InternalBaseLanguage.g:2055:1: ruleTypeReferenceRule returns [EObject current=null] : (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleTypeReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2061:2: ( (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalBaseLanguage.g:2062:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalBaseLanguage.g:2062:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalBaseLanguage.g:2063:3: otherlv_0= 'instance' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeReferenceRuleAccess().getInstanceKeyword_0());
              		
            }
            // InternalBaseLanguage.g:2067:3: ( ( ruleQualifiedName ) )
            // InternalBaseLanguage.g:2068:4: ( ruleQualifiedName )
            {
            // InternalBaseLanguage.g:2068:4: ( ruleQualifiedName )
            // InternalBaseLanguage.g:2069:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypeReferenceRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeReferenceRuleAccess().getDefinitionClassDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleTypeReferenceRule"


    // $ANTLR start "entryRuleLiteralTypeRule"
    // InternalBaseLanguage.g:2090:1: entryRuleLiteralTypeRule returns [EObject current=null] : iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF ;
    public final EObject entryRuleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTypeRule = null;


        try {
            // InternalBaseLanguage.g:2090:56: (iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF )
            // InternalBaseLanguage.g:2091:2: iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralTypeRule=ruleLiteralTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2097:1: ruleLiteralTypeRule returns [EObject current=null] : ( () otherlv_1= 'literal' ) ;
    public final EObject ruleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2103:2: ( ( () otherlv_1= 'literal' ) )
            // InternalBaseLanguage.g:2104:2: ( () otherlv_1= 'literal' )
            {
            // InternalBaseLanguage.g:2104:2: ( () otherlv_1= 'literal' )
            // InternalBaseLanguage.g:2105:3: () otherlv_1= 'literal'
            {
            // InternalBaseLanguage.g:2105:3: ()
            // InternalBaseLanguage.g:2106:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralTypeRule"


    // $ANTLR start "entryRuleDataTypeRule"
    // InternalBaseLanguage.g:2123:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalBaseLanguage.g:2123:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalBaseLanguage.g:2124:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeRule=ruleDataTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2130:1: ruleDataTypeRule returns [EObject current=null] : ( () otherlv_1= 'data' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2136:2: ( ( () otherlv_1= 'data' ) )
            // InternalBaseLanguage.g:2137:2: ( () otherlv_1= 'data' )
            {
            // InternalBaseLanguage.g:2137:2: ( () otherlv_1= 'data' )
            // InternalBaseLanguage.g:2138:3: () otherlv_1= 'data'
            {
            // InternalBaseLanguage.g:2138:3: ()
            // InternalBaseLanguage.g:2139:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDataTypeRuleAccess().getDataKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDataTypeRule"


    // $ANTLR start "entryRuleStringTypeRule"
    // InternalBaseLanguage.g:2156:1: entryRuleStringTypeRule returns [EObject current=null] : iv_ruleStringTypeRule= ruleStringTypeRule EOF ;
    public final EObject entryRuleStringTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeRule = null;


        try {
            // InternalBaseLanguage.g:2156:55: (iv_ruleStringTypeRule= ruleStringTypeRule EOF )
            // InternalBaseLanguage.g:2157:2: iv_ruleStringTypeRule= ruleStringTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringTypeRule=ruleStringTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2163:1: ruleStringTypeRule returns [EObject current=null] : ( () otherlv_1= 'string' ) ;
    public final EObject ruleStringTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2169:2: ( ( () otherlv_1= 'string' ) )
            // InternalBaseLanguage.g:2170:2: ( () otherlv_1= 'string' )
            {
            // InternalBaseLanguage.g:2170:2: ( () otherlv_1= 'string' )
            // InternalBaseLanguage.g:2171:3: () otherlv_1= 'string'
            {
            // InternalBaseLanguage.g:2171:3: ()
            // InternalBaseLanguage.g:2172:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStringTypeRuleAccess().getStringKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleStringTypeRule"


    // $ANTLR start "entryRuleExpressionTypeRule"
    // InternalBaseLanguage.g:2189:1: entryRuleExpressionTypeRule returns [EObject current=null] : iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF ;
    public final EObject entryRuleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionTypeRule = null;


        try {
            // InternalBaseLanguage.g:2189:59: (iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF )
            // InternalBaseLanguage.g:2190:2: iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionTypeRule=ruleExpressionTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2196:1: ruleExpressionTypeRule returns [EObject current=null] : ( () otherlv_1= 'expression' ) ;
    public final EObject ruleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2202:2: ( ( () otherlv_1= 'expression' ) )
            // InternalBaseLanguage.g:2203:2: ( () otherlv_1= 'expression' )
            {
            // InternalBaseLanguage.g:2203:2: ( () otherlv_1= 'expression' )
            // InternalBaseLanguage.g:2204:3: () otherlv_1= 'expression'
            {
            // InternalBaseLanguage.g:2204:3: ()
            // InternalBaseLanguage.g:2205:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleExpressionTypeRule"


    // $ANTLR start "entryRuleIntTypeRule"
    // InternalBaseLanguage.g:2222:1: entryRuleIntTypeRule returns [EObject current=null] : iv_ruleIntTypeRule= ruleIntTypeRule EOF ;
    public final EObject entryRuleIntTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntTypeRule = null;


        try {
            // InternalBaseLanguage.g:2222:52: (iv_ruleIntTypeRule= ruleIntTypeRule EOF )
            // InternalBaseLanguage.g:2223:2: iv_ruleIntTypeRule= ruleIntTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntTypeRule=ruleIntTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2229:1: ruleIntTypeRule returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2235:2: ( ( () otherlv_1= 'int' ) )
            // InternalBaseLanguage.g:2236:2: ( () otherlv_1= 'int' )
            {
            // InternalBaseLanguage.g:2236:2: ( () otherlv_1= 'int' )
            // InternalBaseLanguage.g:2237:3: () otherlv_1= 'int'
            {
            // InternalBaseLanguage.g:2237:3: ()
            // InternalBaseLanguage.g:2238:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIntTypeRuleAccess().getIntKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIntTypeRule"


    // $ANTLR start "entryRuleRealTypeRule"
    // InternalBaseLanguage.g:2255:1: entryRuleRealTypeRule returns [EObject current=null] : iv_ruleRealTypeRule= ruleRealTypeRule EOF ;
    public final EObject entryRuleRealTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeRule = null;


        try {
            // InternalBaseLanguage.g:2255:53: (iv_ruleRealTypeRule= ruleRealTypeRule EOF )
            // InternalBaseLanguage.g:2256:2: iv_ruleRealTypeRule= ruleRealTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRealTypeRule=ruleRealTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRealTypeRule"


    // $ANTLR start "ruleRealTypeRule"
    // InternalBaseLanguage.g:2262:1: ruleRealTypeRule returns [EObject current=null] : ( () otherlv_1= 'real' ) ;
    public final EObject ruleRealTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2268:2: ( ( () otherlv_1= 'real' ) )
            // InternalBaseLanguage.g:2269:2: ( () otherlv_1= 'real' )
            {
            // InternalBaseLanguage.g:2269:2: ( () otherlv_1= 'real' )
            // InternalBaseLanguage.g:2270:3: () otherlv_1= 'real'
            {
            // InternalBaseLanguage.g:2270:3: ()
            // InternalBaseLanguage.g:2271:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRealTypeRuleAccess().getRealTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRealTypeRuleAccess().getRealKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleRealTypeRule"


    // $ANTLR start "entryRuleBooleanTypeRule"
    // InternalBaseLanguage.g:2288:1: entryRuleBooleanTypeRule returns [EObject current=null] : iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF ;
    public final EObject entryRuleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeRule = null;


        try {
            // InternalBaseLanguage.g:2288:56: (iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF )
            // InternalBaseLanguage.g:2289:2: iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanTypeRule=ruleBooleanTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2295:1: ruleBooleanTypeRule returns [EObject current=null] : ( () otherlv_1= 'boolean' ) ;
    public final EObject ruleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2301:2: ( ( () otherlv_1= 'boolean' ) )
            // InternalBaseLanguage.g:2302:2: ( () otherlv_1= 'boolean' )
            {
            // InternalBaseLanguage.g:2302:2: ( () otherlv_1= 'boolean' )
            // InternalBaseLanguage.g:2303:3: () otherlv_1= 'boolean'
            {
            // InternalBaseLanguage.g:2303:3: ()
            // InternalBaseLanguage.g:2304:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleBooleanTypeRule"


    // $ANTLR start "entryRuleVoidTypeRule"
    // InternalBaseLanguage.g:2321:1: entryRuleVoidTypeRule returns [EObject current=null] : iv_ruleVoidTypeRule= ruleVoidTypeRule EOF ;
    public final EObject entryRuleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoidTypeRule = null;


        try {
            // InternalBaseLanguage.g:2321:53: (iv_ruleVoidTypeRule= ruleVoidTypeRule EOF )
            // InternalBaseLanguage.g:2322:2: iv_ruleVoidTypeRule= ruleVoidTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVoidTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVoidTypeRule=ruleVoidTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVoidTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2328:1: ruleVoidTypeRule returns [EObject current=null] : ( () otherlv_1= 'void' ) ;
    public final EObject ruleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2334:2: ( ( () otherlv_1= 'void' ) )
            // InternalBaseLanguage.g:2335:2: ( () otherlv_1= 'void' )
            {
            // InternalBaseLanguage.g:2335:2: ( () otherlv_1= 'void' )
            // InternalBaseLanguage.g:2336:3: () otherlv_1= 'void'
            {
            // InternalBaseLanguage.g:2336:3: ()
            // InternalBaseLanguage.g:2337:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleVoidTypeRule"


    // $ANTLR start "entryRuleArrayTypeRule"
    // InternalBaseLanguage.g:2354:1: entryRuleArrayTypeRule returns [EObject current=null] : iv_ruleArrayTypeRule= ruleArrayTypeRule EOF ;
    public final EObject entryRuleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTypeRule = null;


        try {
            // InternalBaseLanguage.g:2354:54: (iv_ruleArrayTypeRule= ruleArrayTypeRule EOF )
            // InternalBaseLanguage.g:2355:2: iv_ruleArrayTypeRule= ruleArrayTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayTypeRule=ruleArrayTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2361:1: ruleArrayTypeRule returns [EObject current=null] : (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) ;
    public final EObject ruleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:2367:2: ( (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) )
            // InternalBaseLanguage.g:2368:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            {
            // InternalBaseLanguage.g:2368:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            // InternalBaseLanguage.g:2369:3: otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0());
              		
            }
            // InternalBaseLanguage.g:2373:3: ( (lv_elements_1_0= ruleTypeRule ) )
            // InternalBaseLanguage.g:2374:4: (lv_elements_1_0= ruleTypeRule )
            {
            // InternalBaseLanguage.g:2374:4: (lv_elements_1_0= ruleTypeRule )
            // InternalBaseLanguage.g:2375:5: lv_elements_1_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArrayTypeRuleAccess().getElementsTypeRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_elements_1_0=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArrayTypeRuleRule());
              					}
              					set(
              						current,
              						"elements",
              						lv_elements_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleArrayTypeRule"


    // $ANTLR start "entryRuleParameterRule"
    // InternalBaseLanguage.g:2396:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // InternalBaseLanguage.g:2396:54: (iv_ruleParameterRule= ruleParameterRule EOF )
            // InternalBaseLanguage.g:2397:2: iv_ruleParameterRule= ruleParameterRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterRule=ruleParameterRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2403:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:2409:2: ( ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) )
            // InternalBaseLanguage.g:2410:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            {
            // InternalBaseLanguage.g:2410:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            // InternalBaseLanguage.g:2411:3: ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) )
            {
            // InternalBaseLanguage.g:2411:3: ( (lv_type_0_0= ruleTypeRule ) )
            // InternalBaseLanguage.g:2412:4: (lv_type_0_0= ruleTypeRule )
            {
            // InternalBaseLanguage.g:2412:4: (lv_type_0_0= ruleTypeRule )
            // InternalBaseLanguage.g:2413:5: lv_type_0_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_17);
            lv_type_0_0=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // InternalBaseLanguage.g:2430:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalBaseLanguage.g:2431:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalBaseLanguage.g:2431:4: (lv_name_1_0= ruleStringOrId )
            // InternalBaseLanguage.g:2432:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleParameterRule"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalBaseLanguage.g:2453:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalBaseLanguage.g:2453:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalBaseLanguage.g:2454:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2460:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_0 = null;

        AntlrDatatypeRuleToken this_StringOrId_2 = null;



        	enterRule();

        try {
            // InternalBaseLanguage.g:2466:2: ( (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) )
            // InternalBaseLanguage.g:2467:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            {
            // InternalBaseLanguage.g:2467:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            // InternalBaseLanguage.g:2468:3: this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_28);
            this_StringOrId_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_StringOrId_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBaseLanguage.g:2478:3: (kw= '.' this_StringOrId_2= ruleStringOrId )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==45) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBaseLanguage.g:2479:4: kw= '.' this_StringOrId_2= ruleStringOrId
            	    {
            	    kw=(Token)match(input,45,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_28);
            	    this_StringOrId_2=ruleStringOrId();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_StringOrId_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleStringOrId"
    // InternalBaseLanguage.g:2499:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalBaseLanguage.g:2499:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalBaseLanguage.g:2500:2: iv_ruleStringOrId= ruleStringOrId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringOrIdRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringOrId=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringOrId.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalBaseLanguage.g:2506:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2512:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalBaseLanguage.g:2513:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalBaseLanguage.g:2513:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_QUOTED_ID) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_ID) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalBaseLanguage.g:2514:3: this_QUOTED_ID_0= RULE_QUOTED_ID
                    {
                    this_QUOTED_ID_0=(Token)match(input,RULE_QUOTED_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_QUOTED_ID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_QUOTED_ID_0, grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:2522:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_1, grammarAccess.getStringOrIdAccess().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleStringOrId"


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalBaseLanguage.g:2533:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalBaseLanguage.g:2539:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalBaseLanguage.g:2540:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalBaseLanguage.g:2540:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt30=6;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt30=1;
                }
                break;
            case 47:
                {
                alt30=2;
                }
                break;
            case 48:
                {
                alt30=3;
                }
                break;
            case 49:
                {
                alt30=4;
                }
                break;
            case 50:
                {
                alt30=5;
                }
                break;
            case 51:
                {
                alt30=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalBaseLanguage.g:2541:3: (enumLiteral_0= '>=' )
                    {
                    // InternalBaseLanguage.g:2541:3: (enumLiteral_0= '>=' )
                    // InternalBaseLanguage.g:2542:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:2549:3: (enumLiteral_1= '>' )
                    {
                    // InternalBaseLanguage.g:2549:3: (enumLiteral_1= '>' )
                    // InternalBaseLanguage.g:2550:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalBaseLanguage.g:2557:3: (enumLiteral_2= '=' )
                    {
                    // InternalBaseLanguage.g:2557:3: (enumLiteral_2= '=' )
                    // InternalBaseLanguage.g:2558:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalBaseLanguage.g:2565:3: (enumLiteral_3= '!=' )
                    {
                    // InternalBaseLanguage.g:2565:3: (enumLiteral_3= '!=' )
                    // InternalBaseLanguage.g:2566:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalBaseLanguage.g:2573:3: (enumLiteral_4= '<' )
                    {
                    // InternalBaseLanguage.g:2573:3: (enumLiteral_4= '<' )
                    // InternalBaseLanguage.g:2574:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalBaseLanguage.g:2581:3: (enumLiteral_5= '<=' )
                    {
                    // InternalBaseLanguage.g:2581:3: (enumLiteral_5= '<=' )
                    // InternalBaseLanguage.g:2582:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleComparisonOperatorRule"


    // $ANTLR start "ruleAddOrSubtractOperatorRule"
    // InternalBaseLanguage.g:2592:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2598:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalBaseLanguage.g:2599:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalBaseLanguage.g:2599:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==52) ) {
                alt31=1;
            }
            else if ( (LA31_0==53) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalBaseLanguage.g:2600:3: (enumLiteral_0= '+' )
                    {
                    // InternalBaseLanguage.g:2600:3: (enumLiteral_0= '+' )
                    // InternalBaseLanguage.g:2601:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:2608:3: (enumLiteral_1= '-' )
                    {
                    // InternalBaseLanguage.g:2608:3: (enumLiteral_1= '-' )
                    // InternalBaseLanguage.g:2609:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAddOrSubtractOperatorRule"


    // $ANTLR start "ruleMultiplyDivideModuloOperatorRule"
    // InternalBaseLanguage.g:2619:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalBaseLanguage.g:2625:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalBaseLanguage.g:2626:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalBaseLanguage.g:2626:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt32=1;
                }
                break;
            case 55:
                {
                alt32=2;
                }
                break;
            case 56:
                {
                alt32=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalBaseLanguage.g:2627:3: (enumLiteral_0= '*' )
                    {
                    // InternalBaseLanguage.g:2627:3: (enumLiteral_0= '*' )
                    // InternalBaseLanguage.g:2628:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:2635:3: (enumLiteral_1= '/' )
                    {
                    // InternalBaseLanguage.g:2635:3: (enumLiteral_1= '/' )
                    // InternalBaseLanguage.g:2636:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalBaseLanguage.g:2643:3: (enumLiteral_2= '%' )
                    {
                    // InternalBaseLanguage.g:2643:3: (enumLiteral_2= '%' )
                    // InternalBaseLanguage.g:2644:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleMultiplyDivideModuloOperatorRule"


    // $ANTLR start "ruleFactorRule"
    // InternalBaseLanguage.g:2654:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalBaseLanguage.g:2660:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalBaseLanguage.g:2661:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalBaseLanguage.g:2661:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt33=20;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt33=1;
                }
                break;
            case 58:
                {
                alt33=2;
                }
                break;
            case 59:
                {
                alt33=3;
                }
                break;
            case 60:
                {
                alt33=4;
                }
                break;
            case 61:
                {
                alt33=5;
                }
                break;
            case 62:
                {
                alt33=6;
                }
                break;
            case 63:
                {
                alt33=7;
                }
                break;
            case 64:
                {
                alt33=8;
                }
                break;
            case 65:
                {
                alt33=9;
                }
                break;
            case 66:
                {
                alt33=10;
                }
                break;
            case 67:
                {
                alt33=11;
                }
                break;
            case 68:
                {
                alt33=12;
                }
                break;
            case 69:
                {
                alt33=13;
                }
                break;
            case 70:
                {
                alt33=14;
                }
                break;
            case 71:
                {
                alt33=15;
                }
                break;
            case 72:
                {
                alt33=16;
                }
                break;
            case 73:
                {
                alt33=17;
                }
                break;
            case 74:
                {
                alt33=18;
                }
                break;
            case 75:
                {
                alt33=19;
                }
                break;
            case 76:
                {
                alt33=20;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalBaseLanguage.g:2662:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalBaseLanguage.g:2662:3: (enumLiteral_0= 'Y' )
                    // InternalBaseLanguage.g:2663:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBaseLanguage.g:2670:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalBaseLanguage.g:2670:3: (enumLiteral_1= 'Z' )
                    // InternalBaseLanguage.g:2671:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalBaseLanguage.g:2678:3: (enumLiteral_2= 'E' )
                    {
                    // InternalBaseLanguage.g:2678:3: (enumLiteral_2= 'E' )
                    // InternalBaseLanguage.g:2679:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalBaseLanguage.g:2686:3: (enumLiteral_3= 'P' )
                    {
                    // InternalBaseLanguage.g:2686:3: (enumLiteral_3= 'P' )
                    // InternalBaseLanguage.g:2687:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalBaseLanguage.g:2694:3: (enumLiteral_4= 'T' )
                    {
                    // InternalBaseLanguage.g:2694:3: (enumLiteral_4= 'T' )
                    // InternalBaseLanguage.g:2695:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalBaseLanguage.g:2702:3: (enumLiteral_5= 'G' )
                    {
                    // InternalBaseLanguage.g:2702:3: (enumLiteral_5= 'G' )
                    // InternalBaseLanguage.g:2703:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalBaseLanguage.g:2710:3: (enumLiteral_6= 'M' )
                    {
                    // InternalBaseLanguage.g:2710:3: (enumLiteral_6= 'M' )
                    // InternalBaseLanguage.g:2711:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalBaseLanguage.g:2718:3: (enumLiteral_7= 'k' )
                    {
                    // InternalBaseLanguage.g:2718:3: (enumLiteral_7= 'k' )
                    // InternalBaseLanguage.g:2719:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalBaseLanguage.g:2726:3: (enumLiteral_8= 'h' )
                    {
                    // InternalBaseLanguage.g:2726:3: (enumLiteral_8= 'h' )
                    // InternalBaseLanguage.g:2727:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalBaseLanguage.g:2734:3: (enumLiteral_9= 'da' )
                    {
                    // InternalBaseLanguage.g:2734:3: (enumLiteral_9= 'da' )
                    // InternalBaseLanguage.g:2735:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalBaseLanguage.g:2742:3: (enumLiteral_10= 'd' )
                    {
                    // InternalBaseLanguage.g:2742:3: (enumLiteral_10= 'd' )
                    // InternalBaseLanguage.g:2743:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalBaseLanguage.g:2750:3: (enumLiteral_11= 'c' )
                    {
                    // InternalBaseLanguage.g:2750:3: (enumLiteral_11= 'c' )
                    // InternalBaseLanguage.g:2751:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalBaseLanguage.g:2758:3: (enumLiteral_12= 'm' )
                    {
                    // InternalBaseLanguage.g:2758:3: (enumLiteral_12= 'm' )
                    // InternalBaseLanguage.g:2759:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalBaseLanguage.g:2766:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalBaseLanguage.g:2766:3: (enumLiteral_13= '\\u00B5' )
                    // InternalBaseLanguage.g:2767:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalBaseLanguage.g:2774:3: (enumLiteral_14= 'n' )
                    {
                    // InternalBaseLanguage.g:2774:3: (enumLiteral_14= 'n' )
                    // InternalBaseLanguage.g:2775:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalBaseLanguage.g:2782:3: (enumLiteral_15= 'p' )
                    {
                    // InternalBaseLanguage.g:2782:3: (enumLiteral_15= 'p' )
                    // InternalBaseLanguage.g:2783:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                      			
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalBaseLanguage.g:2790:3: (enumLiteral_16= 'f' )
                    {
                    // InternalBaseLanguage.g:2790:3: (enumLiteral_16= 'f' )
                    // InternalBaseLanguage.g:2791:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalBaseLanguage.g:2798:3: (enumLiteral_17= 'a' )
                    {
                    // InternalBaseLanguage.g:2798:3: (enumLiteral_17= 'a' )
                    // InternalBaseLanguage.g:2799:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                      			
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalBaseLanguage.g:2806:3: (enumLiteral_18= 'z' )
                    {
                    // InternalBaseLanguage.g:2806:3: (enumLiteral_18= 'z' )
                    // InternalBaseLanguage.g:2807:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                      			
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalBaseLanguage.g:2814:3: (enumLiteral_19= 'y' )
                    {
                    // InternalBaseLanguage.g:2814:3: (enumLiteral_19= 'y' )
                    // InternalBaseLanguage.g:2815:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_19, grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFactorRule"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_3s = "\1\4\1\uffff\2\17\3\uffff\1\7\1\uffff\2\17";
    static final String dfa_4s = "\1\40\1\uffff\2\70\3\uffff\1\10\1\uffff\2\70";
    static final String dfa_5s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\3\4\1\2\1\3\13\uffff\1\1\2\uffff\1\5\1\uffff\2\6\4\uffff\2\4",
            "",
            "\3\6\1\uffff\1\6\1\uffff\2\6\1\10\1\6\2\uffff\1\4\2\uffff\1\6\16\uffff\1\7\13\6",
            "\3\6\1\uffff\1\6\1\uffff\2\6\1\10\1\6\2\uffff\1\4\2\uffff\1\6\16\uffff\1\7\13\6",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\3\6\1\uffff\1\6\1\uffff\2\6\1\10\1\6\2\uffff\1\4\2\uffff\1\6\16\uffff\1\7\13\6",
            "\3\6\1\uffff\1\6\1\uffff\2\6\1\10\1\6\2\uffff\1\4\2\uffff\1\6\16\uffff\1\7\13\6"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "745:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00300001869401F0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000FC00000000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x01C0000000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0030000186D401F0L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00300001879401F0L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000180L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xFE00000000000002L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000001800001F0L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000180L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00001FF806000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000200000000002L});

}
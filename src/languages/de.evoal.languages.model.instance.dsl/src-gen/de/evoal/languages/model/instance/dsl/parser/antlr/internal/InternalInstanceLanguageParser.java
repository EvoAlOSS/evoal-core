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
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalInstanceLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_QUOTED_ID", "RULE_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'data'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'['", "','", "']'", "'('", "')'", "'{'", "'}'", "':='", "';'", "'true'", "'false'", "':'", "'literal'", "'instance'", "'string'", "'expression'", "'int'", "'float'", "'boolean'", "'void'", "'array'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
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



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private InstanceLanguageGrammarAccess grammarAccess;

        public InternalInstanceLanguageParser(TokenStream input, InstanceLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ReferenceRule";
       	}

       	@Override
       	protected InstanceLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleReferenceRule"
    // InternalInstanceLanguage.g:72:1: entryRuleReferenceRule returns [EObject current=null] : iv_ruleReferenceRule= ruleReferenceRule EOF ;
    public final EObject entryRuleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceRule = null;


        try {
            // InternalInstanceLanguage.g:72:54: (iv_ruleReferenceRule= ruleReferenceRule EOF )
            // InternalInstanceLanguage.g:73:2: iv_ruleReferenceRule= ruleReferenceRule EOF
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
    // InternalInstanceLanguage.g:79:1: ruleReferenceRule returns [EObject current=null] : (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule ) ;
    public final EObject ruleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantReferenceRule_0 = null;

        EObject this_DataReferenceRule_1 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:85:2: ( (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule ) )
            // InternalInstanceLanguage.g:86:2: (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule )
            {
            // InternalInstanceLanguage.g:86:2: (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_QUOTED_ID && LA1_0<=RULE_ID)) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalInstanceLanguage.g:87:3: this_ConstantReferenceRule_0= ruleConstantReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getConstantReferenceRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConstantReferenceRule_0=ruleConstantReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConstantReferenceRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:99:3: this_DataReferenceRule_1= ruleDataReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getDataReferenceRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DataReferenceRule_1=ruleDataReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DataReferenceRule_1;
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


    // $ANTLR start "entryRuleDataReferenceRule"
    // InternalInstanceLanguage.g:114:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalInstanceLanguage.g:114:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalInstanceLanguage.g:115:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDataReferenceRule=ruleDataReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataReferenceRule; 
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
    // $ANTLR end "entryRuleDataReferenceRule"


    // $ANTLR start "ruleDataReferenceRule"
    // InternalInstanceLanguage.g:121:1: ruleDataReferenceRule returns [EObject current=null] : ( () otherlv_1= 'data' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:127:2: ( ( () otherlv_1= 'data' ( ( ruleQualifiedName ) ) ) )
            // InternalInstanceLanguage.g:128:2: ( () otherlv_1= 'data' ( ( ruleQualifiedName ) ) )
            {
            // InternalInstanceLanguage.g:128:2: ( () otherlv_1= 'data' ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:129:3: () otherlv_1= 'data' ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:129:3: ()
            // InternalInstanceLanguage.g:130:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDataReferenceRuleAccess().getDataReferenceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1());
              		
            }
            // InternalInstanceLanguage.g:143:3: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:144:4: ( ruleQualifiedName )
            {
            // InternalInstanceLanguage.g:144:4: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:145:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDataReferenceRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_2_0());
              				
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
    // $ANTLR end "ruleDataReferenceRule"


    // $ANTLR start "entryRuleExpressionRule"
    // InternalInstanceLanguage.g:166:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:166:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalInstanceLanguage.g:167:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalInstanceLanguage.g:173:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:179:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalInstanceLanguage.g:180:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalInstanceLanguage.g:194:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:194:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalInstanceLanguage.g:195:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalInstanceLanguage.g:201:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:207:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalInstanceLanguage.g:208:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalInstanceLanguage.g:208:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalInstanceLanguage.g:209:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalInstanceLanguage.g:209:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalInstanceLanguage.g:210:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalInstanceLanguage.g:210:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalInstanceLanguage.g:211:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_4);
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

            // InternalInstanceLanguage.g:228:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalInstanceLanguage.g:229:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	      			
            	    }
            	    // InternalInstanceLanguage.g:233:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalInstanceLanguage.g:234:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:234:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalInstanceLanguage.g:235:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
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
    // $ANTLR end "ruleOrExpressionRule"


    // $ANTLR start "entryRuleXorExpressionRule"
    // InternalInstanceLanguage.g:257:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:257:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalInstanceLanguage.g:258:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalInstanceLanguage.g:264:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:270:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalInstanceLanguage.g:271:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalInstanceLanguage.g:271:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalInstanceLanguage.g:272:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalInstanceLanguage.g:272:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalInstanceLanguage.g:273:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalInstanceLanguage.g:273:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalInstanceLanguage.g:274:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_6);
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

            // InternalInstanceLanguage.g:291:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalInstanceLanguage.g:292:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	      			
            	    }
            	    // InternalInstanceLanguage.g:296:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalInstanceLanguage.g:297:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:297:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalInstanceLanguage.g:298:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
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
    // $ANTLR end "ruleXorExpressionRule"


    // $ANTLR start "entryRuleAndExpressionRule"
    // InternalInstanceLanguage.g:320:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:320:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalInstanceLanguage.g:321:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalInstanceLanguage.g:327:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:333:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalInstanceLanguage.g:334:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalInstanceLanguage.g:334:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalInstanceLanguage.g:335:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalInstanceLanguage.g:335:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalInstanceLanguage.g:336:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalInstanceLanguage.g:336:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalInstanceLanguage.g:337:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_7);
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

            // InternalInstanceLanguage.g:354:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalInstanceLanguage.g:355:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	      			
            	    }
            	    // InternalInstanceLanguage.g:359:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalInstanceLanguage.g:360:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:360:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalInstanceLanguage.g:361:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_7);
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
            	    break loop4;
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
    // InternalInstanceLanguage.g:383:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:383:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalInstanceLanguage.g:384:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalInstanceLanguage.g:390:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:396:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalInstanceLanguage.g:397:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalInstanceLanguage.g:397:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalInstanceLanguage.g:398:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalInstanceLanguage.g:398:3: ( (lv_negated_0_0= '!' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalInstanceLanguage.g:399:4: (lv_negated_0_0= '!' )
                    {
                    // InternalInstanceLanguage.g:399:4: (lv_negated_0_0= '!' )
                    // InternalInstanceLanguage.g:400:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,19,FOLLOW_5); if (state.failed) return current;
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

            // InternalInstanceLanguage.g:412:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalInstanceLanguage.g:413:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalInstanceLanguage.g:413:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalInstanceLanguage.g:414:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalInstanceLanguage.g:435:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:435:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalInstanceLanguage.g:436:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalInstanceLanguage.g:442:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:448:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalInstanceLanguage.g:449:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalInstanceLanguage.g:449:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalInstanceLanguage.g:450:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalInstanceLanguage.g:450:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:451:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:451:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:452:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_8);
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

            // InternalInstanceLanguage.g:469:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=43 && LA6_0<=48)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalInstanceLanguage.g:470:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:470:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalInstanceLanguage.g:471:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_8);
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
    // $ANTLR end "ruleComparisonExpressionRule"


    // $ANTLR start "entryRulePartialComparisonExpressionRule"
    // InternalInstanceLanguage.g:492:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:492:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalInstanceLanguage.g:493:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalInstanceLanguage.g:499:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:505:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalInstanceLanguage.g:506:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalInstanceLanguage.g:506:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalInstanceLanguage.g:507:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalInstanceLanguage.g:507:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalInstanceLanguage.g:508:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalInstanceLanguage.g:508:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalInstanceLanguage.g:509:5: lv_operator_0_0= ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_5);
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

            // InternalInstanceLanguage.g:526:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:527:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:527:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:528:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalInstanceLanguage.g:549:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:549:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalInstanceLanguage.g:550:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalInstanceLanguage.g:556:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:562:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalInstanceLanguage.g:563:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalInstanceLanguage.g:563:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalInstanceLanguage.g:564:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalInstanceLanguage.g:564:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalInstanceLanguage.g:565:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalInstanceLanguage.g:565:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalInstanceLanguage.g:566:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_9);
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

            // InternalInstanceLanguage.g:583:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=49 && LA7_0<=50)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalInstanceLanguage.g:584:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalInstanceLanguage.g:584:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalInstanceLanguage.g:585:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalInstanceLanguage.g:585:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalInstanceLanguage.g:586:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_5);
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

            	    // InternalInstanceLanguage.g:603:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalInstanceLanguage.g:604:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:604:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalInstanceLanguage.g:605:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_9);
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
    // $ANTLR end "ruleAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleMultiplyDivideModuloExpressionRule"
    // InternalInstanceLanguage.g:627:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:627:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalInstanceLanguage.g:628:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalInstanceLanguage.g:634:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:640:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalInstanceLanguage.g:641:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalInstanceLanguage.g:641:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalInstanceLanguage.g:642:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalInstanceLanguage.g:642:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalInstanceLanguage.g:643:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalInstanceLanguage.g:643:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalInstanceLanguage.g:644:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_10);
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

            // InternalInstanceLanguage.g:661:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=51 && LA8_0<=53)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalInstanceLanguage.g:662:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalInstanceLanguage.g:662:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalInstanceLanguage.g:663:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalInstanceLanguage.g:663:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalInstanceLanguage.g:664:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_5);
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

            	    // InternalInstanceLanguage.g:681:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalInstanceLanguage.g:682:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalInstanceLanguage.g:682:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalInstanceLanguage.g:683:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
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
            	    break loop8;
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
    // InternalInstanceLanguage.g:705:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:705:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalInstanceLanguage.g:706:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalInstanceLanguage.g:712:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:718:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalInstanceLanguage.g:719:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalInstanceLanguage.g:719:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalInstanceLanguage.g:720:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalInstanceLanguage.g:720:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalInstanceLanguage.g:721:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalInstanceLanguage.g:721:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalInstanceLanguage.g:722:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_11);
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

            // InternalInstanceLanguage.g:739:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalInstanceLanguage.g:740:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                      			
                    }
                    // InternalInstanceLanguage.g:744:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalInstanceLanguage.g:745:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalInstanceLanguage.g:745:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalInstanceLanguage.g:746:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalInstanceLanguage.g:768:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalInstanceLanguage.g:768:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalInstanceLanguage.g:769:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalInstanceLanguage.g:775:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:781:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) ) )
            // InternalInstanceLanguage.g:782:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) )
            {
            // InternalInstanceLanguage.g:782:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) )
            // InternalInstanceLanguage.g:783:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) )
            {
            // InternalInstanceLanguage.g:783:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=49 && LA10_0<=50)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalInstanceLanguage.g:784:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalInstanceLanguage.g:784:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalInstanceLanguage.g:785:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_5);
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
            	    break loop10;
                }
            } while (true);

            // InternalInstanceLanguage.g:802:3: ( (lv_subExpression_1_0= ruleValueRule ) )
            // InternalInstanceLanguage.g:803:4: (lv_subExpression_1_0= ruleValueRule )
            {
            // InternalInstanceLanguage.g:803:4: (lv_subExpression_1_0= ruleValueRule )
            // InternalInstanceLanguage.g:804:5: lv_subExpression_1_0= ruleValueRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionValueRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_subExpression_1_0=ruleValueRule();

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
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ValueRule");
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


    // $ANTLR start "entryRuleValueRule"
    // InternalInstanceLanguage.g:825:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // InternalInstanceLanguage.g:825:50: (iv_ruleValueRule= ruleValueRule EOF )
            // InternalInstanceLanguage.g:826:2: iv_ruleValueRule= ruleValueRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValueRule=ruleValueRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueRule; 
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
    // $ANTLR end "entryRuleValueRule"


    // $ANTLR start "ruleValueRule"
    // InternalInstanceLanguage.g:832:1: ruleValueRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_CallRule_1 = null;

        EObject this_LiteralRule_2 = null;

        EObject this_ParanthesesRule_3 = null;

        EObject this_ReferenceRule_4 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:838:2: ( (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) )
            // InternalInstanceLanguage.g:839:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            {
            // InternalInstanceLanguage.g:839:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            int alt11=5;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalInstanceLanguage.g:840:3: this_ArrayRule_0= ruleArrayRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueRuleAccess().getArrayRuleParserRuleCall_0());
                      		
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
                    // InternalInstanceLanguage.g:852:3: this_CallRule_1= ruleCallRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueRuleAccess().getCallRuleParserRuleCall_1());
                      		
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
                    // InternalInstanceLanguage.g:864:3: this_LiteralRule_2= ruleLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueRuleAccess().getLiteralRuleParserRuleCall_2());
                      		
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
                    // InternalInstanceLanguage.g:876:3: this_ParanthesesRule_3= ruleParanthesesRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueRuleAccess().getParanthesesRuleParserRuleCall_3());
                      		
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
                    // InternalInstanceLanguage.g:888:3: this_ReferenceRule_4= ruleReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueRuleAccess().getReferenceRuleParserRuleCall_4());
                      		
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
    // $ANTLR end "ruleValueRule"


    // $ANTLR start "entryRuleArrayRule"
    // InternalInstanceLanguage.g:903:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalInstanceLanguage.g:903:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalInstanceLanguage.g:904:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalInstanceLanguage.g:910:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:916:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) )
            // InternalInstanceLanguage.g:917:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalInstanceLanguage.g:917:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            // InternalInstanceLanguage.g:918:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']'
            {
            // InternalInstanceLanguage.g:918:3: ()
            // InternalInstanceLanguage.g:919:4: 
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

            otherlv_1=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalInstanceLanguage.g:932:3: ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_DOUBLE && LA13_0<=RULE_ID)||LA13_0==15||LA13_0==21||LA13_0==24||(LA13_0>=30 && LA13_0<=31)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalInstanceLanguage.g:933:4: ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    {
                    // InternalInstanceLanguage.g:933:4: ( (lv_values_2_0= ruleValueRule ) )
                    // InternalInstanceLanguage.g:934:5: (lv_values_2_0= ruleValueRule )
                    {
                    // InternalInstanceLanguage.g:934:5: (lv_values_2_0= ruleValueRule )
                    // InternalInstanceLanguage.g:935:6: lv_values_2_0= ruleValueRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_values_2_0=ruleValueRule();

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
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.ValueRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalInstanceLanguage.g:952:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==22) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalInstanceLanguage.g:953:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalInstanceLanguage.g:957:5: ( (lv_values_4_0= ruleValueRule ) )
                    	    // InternalInstanceLanguage.g:958:6: (lv_values_4_0= ruleValueRule )
                    	    {
                    	    // InternalInstanceLanguage.g:958:6: (lv_values_4_0= ruleValueRule )
                    	    // InternalInstanceLanguage.g:959:7: lv_values_4_0= ruleValueRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
                    	    lv_values_4_0=ruleValueRule();

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
                    	      								"de.evoal.languages.model.base.dsl.BaseLanguage.ValueRule");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
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
    // InternalInstanceLanguage.g:986:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalInstanceLanguage.g:986:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalInstanceLanguage.g:987:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalInstanceLanguage.g:993:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:999:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalInstanceLanguage.g:1000:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalInstanceLanguage.g:1000:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalInstanceLanguage.g:1001:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalInstanceLanguage.g:1005:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalInstanceLanguage.g:1006:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalInstanceLanguage.g:1006:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalInstanceLanguage.g:1007:5: lv_subExpression_1_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_14);
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

            otherlv_2=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
    // InternalInstanceLanguage.g:1032:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalInstanceLanguage.g:1032:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalInstanceLanguage.g:1033:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalInstanceLanguage.g:1039:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalInstanceLanguage.g:1045:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalInstanceLanguage.g:1046:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalInstanceLanguage.g:1046:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalInstanceLanguage.g:1047:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalInstanceLanguage.g:1047:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalInstanceLanguage.g:1048:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalInstanceLanguage.g:1048:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalInstanceLanguage.g:1049:5: lv_function_0_0= ruleFunctionNameRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_function_0_0=ruleFunctionNameRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            otherlv_1=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalInstanceLanguage.g:1070:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_DOUBLE && LA15_0<=RULE_ID)||LA15_0==15||LA15_0==19||LA15_0==21||LA15_0==24||(LA15_0>=30 && LA15_0<=31)||(LA15_0>=49 && LA15_0<=50)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalInstanceLanguage.g:1071:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalInstanceLanguage.g:1071:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalInstanceLanguage.g:1072:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalInstanceLanguage.g:1072:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalInstanceLanguage.g:1073:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_17);
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

                    // InternalInstanceLanguage.g:1090:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==22) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalInstanceLanguage.g:1091:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalInstanceLanguage.g:1095:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalInstanceLanguage.g:1096:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalInstanceLanguage.g:1096:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalInstanceLanguage.g:1097:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_17);
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
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleConstantReferenceRule"
    // InternalInstanceLanguage.g:1124:1: entryRuleConstantReferenceRule returns [EObject current=null] : iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF ;
    public final EObject entryRuleConstantReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantReferenceRule = null;


        try {
            // InternalInstanceLanguage.g:1124:62: (iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF )
            // InternalInstanceLanguage.g:1125:2: iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantReferenceRule=ruleConstantReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantReferenceRule; 
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
    // $ANTLR end "entryRuleConstantReferenceRule"


    // $ANTLR start "ruleConstantReferenceRule"
    // InternalInstanceLanguage.g:1131:1: ruleConstantReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleConstantReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1137:2: ( ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:1138:2: ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:1138:2: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:1139:3: ( ruleQualifiedName )
            {
            // InternalInstanceLanguage.g:1139:3: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:1140:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getConstantReferenceRuleRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getConstantReferenceRuleAccess().getDefinitionConstantDefinitionCrossReference_0());
              			
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
    // $ANTLR end "ruleConstantReferenceRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalInstanceLanguage.g:1160:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1160:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalInstanceLanguage.g:1161:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalInstanceLanguage.g:1167:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_InstanceLiteralRule_3 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1173:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) )
            // InternalInstanceLanguage.g:1174:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            {
            // InternalInstanceLanguage.g:1174:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            int alt16=4;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt16=1;
                }
                break;
            case RULE_STRING:
                {
                alt16=2;
                }
                break;
            case 30:
            case 31:
                {
                alt16=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt16=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalInstanceLanguage.g:1175:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalInstanceLanguage.g:1187:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalInstanceLanguage.g:1199:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
                    // InternalInstanceLanguage.g:1211:3: this_InstanceLiteralRule_3= ruleInstanceLiteralRule
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
    // InternalInstanceLanguage.g:1226:1: entryRuleInstanceLiteralRule returns [EObject current=null] : iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF ;
    public final EObject entryRuleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1226:60: (iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF )
            // InternalInstanceLanguage.g:1227:2: iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF
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
    // InternalInstanceLanguage.g:1233:1: ruleInstanceLiteralRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) ;
    public final EObject ruleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1239:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) )
            // InternalInstanceLanguage.g:1240:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            {
            // InternalInstanceLanguage.g:1240:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            // InternalInstanceLanguage.g:1241:3: ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
            {
            // InternalInstanceLanguage.g:1241:3: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:1242:4: ( ruleQualifiedName )
            {
            // InternalInstanceLanguage.g:1242:4: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:1243:5: ruleQualifiedName
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

              					newCompositeNode(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionTypeDefinitionCrossReference_0_0());
              				
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

            otherlv_1=(Token)match(input,26,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalInstanceLanguage.g:1264:3: ( (lv_attributes_2_0= ruleAttributeRule ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_QUOTED_ID && LA17_0<=RULE_ID)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalInstanceLanguage.g:1265:4: (lv_attributes_2_0= ruleAttributeRule )
            	    {
            	    // InternalInstanceLanguage.g:1265:4: (lv_attributes_2_0= ruleAttributeRule )
            	    // InternalInstanceLanguage.g:1266:5: lv_attributes_2_0= ruleAttributeRule
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
            	    break loop17;
                }
            } while (true);

            otherlv_3=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
    // InternalInstanceLanguage.g:1291:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalInstanceLanguage.g:1291:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalInstanceLanguage.g:1292:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalInstanceLanguage.g:1298:1: ruleAttributeRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1304:2: ( ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) )
            // InternalInstanceLanguage.g:1305:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            {
            // InternalInstanceLanguage.g:1305:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            // InternalInstanceLanguage.g:1306:3: ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';'
            {
            // InternalInstanceLanguage.g:1306:3: ( ( ruleStringOrId ) )
            // InternalInstanceLanguage.g:1307:4: ( ruleStringOrId )
            {
            // InternalInstanceLanguage.g:1307:4: ( ruleStringOrId )
            // InternalInstanceLanguage.g:1308:5: ruleStringOrId
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

            otherlv_1=(Token)match(input,28,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalInstanceLanguage.g:1329:3: ( (lv_value_2_0= ruleValueRule ) )
            // InternalInstanceLanguage.g:1330:4: (lv_value_2_0= ruleValueRule )
            {
            // InternalInstanceLanguage.g:1330:4: (lv_value_2_0= ruleValueRule )
            // InternalInstanceLanguage.g:1331:5: lv_value_2_0= ruleValueRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueValueRuleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_value_2_0=ruleValueRule();

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
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ValueRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalInstanceLanguage.g:1356:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1356:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalInstanceLanguage.g:1357:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalInstanceLanguage.g:1363:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1369:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalInstanceLanguage.g:1370:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalInstanceLanguage.g:1370:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_DOUBLE) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_INT) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalInstanceLanguage.g:1371:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getDoubleLiteralRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DoubleLiteralRule_0=ruleDoubleLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DoubleLiteralRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1383:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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


    // $ANTLR start "entryRuleDoubleLiteralRule"
    // InternalInstanceLanguage.g:1398:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1398:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalInstanceLanguage.g:1399:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoubleLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDoubleLiteralRule=ruleDoubleLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDoubleLiteralRule; 
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
    // $ANTLR end "entryRuleDoubleLiteralRule"


    // $ANTLR start "ruleDoubleLiteralRule"
    // InternalInstanceLanguage.g:1405:1: ruleDoubleLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1411:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalInstanceLanguage.g:1412:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalInstanceLanguage.g:1412:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalInstanceLanguage.g:1413:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalInstanceLanguage.g:1413:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalInstanceLanguage.g:1414:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalInstanceLanguage.g:1414:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalInstanceLanguage.g:1415:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_literal_0_0, grammarAccess.getDoubleLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

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


            }

            // InternalInstanceLanguage.g:1431:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=54 && LA19_0<=73)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalInstanceLanguage.g:1432:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalInstanceLanguage.g:1432:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalInstanceLanguage.g:1433:5: lv_factor_1_0= ruleFactorRule
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDoubleLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_factor_1_0=ruleFactorRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleDoubleLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // InternalInstanceLanguage.g:1454:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1454:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalInstanceLanguage.g:1455:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalInstanceLanguage.g:1461:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:1467:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalInstanceLanguage.g:1468:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalInstanceLanguage.g:1468:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalInstanceLanguage.g:1469:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalInstanceLanguage.g:1469:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalInstanceLanguage.g:1470:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalInstanceLanguage.g:1470:4: (lv_literal_0_0= RULE_INT )
            // InternalInstanceLanguage.g:1471:5: lv_literal_0_0= RULE_INT
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

            // InternalInstanceLanguage.g:1487:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=54 && LA20_0<=73)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalInstanceLanguage.g:1488:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalInstanceLanguage.g:1488:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalInstanceLanguage.g:1489:5: lv_factor_1_0= ruleFactorRule
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
    // InternalInstanceLanguage.g:1510:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1510:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalInstanceLanguage.g:1511:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalInstanceLanguage.g:1517:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1523:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalInstanceLanguage.g:1524:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalInstanceLanguage.g:1524:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalInstanceLanguage.g:1525:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalInstanceLanguage.g:1525:3: (lv_value_0_0= RULE_STRING )
            // InternalInstanceLanguage.g:1526:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

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
    // InternalInstanceLanguage.g:1545:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalInstanceLanguage.g:1545:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalInstanceLanguage.g:1546:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalInstanceLanguage.g:1552:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1558:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalInstanceLanguage.g:1559:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalInstanceLanguage.g:1559:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalInstanceLanguage.g:1560:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalInstanceLanguage.g:1560:3: ()
            // InternalInstanceLanguage.g:1561:4: 
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

            // InternalInstanceLanguage.g:1570:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            else if ( (LA21_0==31) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalInstanceLanguage.g:1571:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalInstanceLanguage.g:1571:4: ( (lv_value_1_0= 'true' ) )
                    // InternalInstanceLanguage.g:1572:5: (lv_value_1_0= 'true' )
                    {
                    // InternalInstanceLanguage.g:1572:5: (lv_value_1_0= 'true' )
                    // InternalInstanceLanguage.g:1573:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralRuleAccess().getValueTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBooleanLiteralRuleRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_1_0 != null, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:1586:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAttributeDefinitionRule"
    // InternalInstanceLanguage.g:1595:1: entryRuleAttributeDefinitionRule returns [EObject current=null] : iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF ;
    public final EObject entryRuleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDefinitionRule = null;


        try {
            // InternalInstanceLanguage.g:1595:64: (iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF )
            // InternalInstanceLanguage.g:1596:2: iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF
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
    // InternalInstanceLanguage.g:1602:1: ruleAttributeDefinitionRule returns [EObject current=null] : ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' ) ;
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
            // InternalInstanceLanguage.g:1608:2: ( ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' ) )
            // InternalInstanceLanguage.g:1609:2: ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' )
            {
            // InternalInstanceLanguage.g:1609:2: ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' )
            // InternalInstanceLanguage.g:1610:3: ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';'
            {
            // InternalInstanceLanguage.g:1610:3: ( (lv_name_0_0= ruleStringOrId ) )
            // InternalInstanceLanguage.g:1611:4: (lv_name_0_0= ruleStringOrId )
            {
            // InternalInstanceLanguage.g:1611:4: (lv_name_0_0= ruleStringOrId )
            // InternalInstanceLanguage.g:1612:5: lv_name_0_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_23);
            lv_name_0_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            otherlv_1=(Token)match(input,32,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1());
              		
            }
            // InternalInstanceLanguage.g:1633:3: ( (lv_type_2_0= ruleTypeRule ) )
            // InternalInstanceLanguage.g:1634:4: (lv_type_2_0= ruleTypeRule )
            {
            // InternalInstanceLanguage.g:1634:4: (lv_type_2_0= ruleTypeRule )
            // InternalInstanceLanguage.g:1635:5: lv_type_2_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_type_2_0=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // InternalInstanceLanguage.g:1652:3: (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==28) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalInstanceLanguage.g:1653:4: otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalInstanceLanguage.g:1657:4: ( (lv_initialisation_4_0= ruleExpressionRule ) )
                    // InternalInstanceLanguage.g:1658:5: (lv_initialisation_4_0= ruleExpressionRule )
                    {
                    // InternalInstanceLanguage.g:1658:5: (lv_initialisation_4_0= ruleExpressionRule )
                    // InternalInstanceLanguage.g:1659:6: lv_initialisation_4_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_initialisation_4_0=ruleExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;

            }

            otherlv_5=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_4());
              		
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
    // InternalInstanceLanguage.g:1685:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1685:49: (iv_ruleTypeRule= ruleTypeRule EOF )
            // InternalInstanceLanguage.g:1686:2: iv_ruleTypeRule= ruleTypeRule EOF
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
    // InternalInstanceLanguage.g:1692:1: ruleTypeRule returns [EObject current=null] : (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) ;
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
            // InternalInstanceLanguage.g:1698:2: ( (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) )
            // InternalInstanceLanguage.g:1699:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            {
            // InternalInstanceLanguage.g:1699:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            int alt23=10;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt23=1;
                }
                break;
            case 37:
                {
                alt23=2;
                }
                break;
            case 38:
                {
                alt23=3;
                }
                break;
            case 39:
                {
                alt23=4;
                }
                break;
            case 33:
                {
                alt23=5;
                }
                break;
            case 41:
                {
                alt23=6;
                }
                break;
            case 34:
                {
                alt23=7;
                }
                break;
            case 40:
                {
                alt23=8;
                }
                break;
            case 36:
                {
                alt23=9;
                }
                break;
            case 15:
                {
                alt23=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalInstanceLanguage.g:1700:3: this_StringTypeRule_0= ruleStringTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getStringTypeRuleParserRuleCall_0());
                      		
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
                    // InternalInstanceLanguage.g:1712:3: this_IntTypeRule_1= ruleIntTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getIntTypeRuleParserRuleCall_1());
                      		
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
                    // InternalInstanceLanguage.g:1724:3: this_FloatTypeRule_2= ruleFloatTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getFloatTypeRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FloatTypeRule_2=ruleFloatTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FloatTypeRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:1736:3: this_BooleanTypeRule_3= ruleBooleanTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getBooleanTypeRuleParserRuleCall_3());
                      		
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
                    // InternalInstanceLanguage.g:1748:3: this_LiteralTypeRule_4= ruleLiteralTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralTypeRule_4=ruleLiteralTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralTypeRule_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalInstanceLanguage.g:1760:3: this_ArrayTypeRule_5= ruleArrayTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArrayTypeRule_5=ruleArrayTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArrayTypeRule_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalInstanceLanguage.g:1772:3: this_InstanceTypeRule_6= ruleInstanceTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getInstanceTypeRuleParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_InstanceTypeRule_6=ruleInstanceTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_InstanceTypeRule_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalInstanceLanguage.g:1784:3: this_VoidTypeRule_7= ruleVoidTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getVoidTypeRuleParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VoidTypeRule_7=ruleVoidTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VoidTypeRule_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalInstanceLanguage.g:1796:3: this_ExpressionTypeRule_8= ruleExpressionTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExpressionTypeRule_8=ruleExpressionTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExpressionTypeRule_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalInstanceLanguage.g:1808:3: this_DataTypeRule_9= ruleDataTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getDataTypeRuleParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DataTypeRule_9=ruleDataTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DataTypeRule_9;
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


    // $ANTLR start "entryRuleLiteralTypeRule"
    // InternalInstanceLanguage.g:1823:1: entryRuleLiteralTypeRule returns [EObject current=null] : iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF ;
    public final EObject entryRuleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1823:56: (iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF )
            // InternalInstanceLanguage.g:1824:2: iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF
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
    // InternalInstanceLanguage.g:1830:1: ruleLiteralTypeRule returns [EObject current=null] : ( () otherlv_1= 'literal' ) ;
    public final EObject ruleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1836:2: ( ( () otherlv_1= 'literal' ) )
            // InternalInstanceLanguage.g:1837:2: ( () otherlv_1= 'literal' )
            {
            // InternalInstanceLanguage.g:1837:2: ( () otherlv_1= 'literal' )
            // InternalInstanceLanguage.g:1838:3: () otherlv_1= 'literal'
            {
            // InternalInstanceLanguage.g:1838:3: ()
            // InternalInstanceLanguage.g:1839:4: 
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

            otherlv_1=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleInstanceTypeRule"
    // InternalInstanceLanguage.g:1856:1: entryRuleInstanceTypeRule returns [EObject current=null] : iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF ;
    public final EObject entryRuleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1856:57: (iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF )
            // InternalInstanceLanguage.g:1857:2: iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstanceTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstanceTypeRule=ruleInstanceTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstanceTypeRule; 
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
    // $ANTLR end "entryRuleInstanceTypeRule"


    // $ANTLR start "ruleInstanceTypeRule"
    // InternalInstanceLanguage.g:1863:1: ruleInstanceTypeRule returns [EObject current=null] : ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1869:2: ( ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalInstanceLanguage.g:1870:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalInstanceLanguage.g:1870:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:1871:3: () otherlv_1= 'instance' ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:1871:3: ()
            // InternalInstanceLanguage.g:1872:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,34,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1());
              		
            }
            // InternalInstanceLanguage.g:1885:3: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:1886:4: ( ruleQualifiedName )
            {
            // InternalInstanceLanguage.g:1886:4: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:1887:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInstanceTypeRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInstanceTypeRuleAccess().getDefinitionTypeDefinitionCrossReference_2_0());
              				
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
    // $ANTLR end "ruleInstanceTypeRule"


    // $ANTLR start "entryRuleStringTypeRule"
    // InternalInstanceLanguage.g:1908:1: entryRuleStringTypeRule returns [EObject current=null] : iv_ruleStringTypeRule= ruleStringTypeRule EOF ;
    public final EObject entryRuleStringTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1908:55: (iv_ruleStringTypeRule= ruleStringTypeRule EOF )
            // InternalInstanceLanguage.g:1909:2: iv_ruleStringTypeRule= ruleStringTypeRule EOF
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
    // InternalInstanceLanguage.g:1915:1: ruleStringTypeRule returns [EObject current=null] : ( () otherlv_1= 'string' ) ;
    public final EObject ruleStringTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1921:2: ( ( () otherlv_1= 'string' ) )
            // InternalInstanceLanguage.g:1922:2: ( () otherlv_1= 'string' )
            {
            // InternalInstanceLanguage.g:1922:2: ( () otherlv_1= 'string' )
            // InternalInstanceLanguage.g:1923:3: () otherlv_1= 'string'
            {
            // InternalInstanceLanguage.g:1923:3: ()
            // InternalInstanceLanguage.g:1924:4: 
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

            otherlv_1=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
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
    // InternalInstanceLanguage.g:1941:1: entryRuleExpressionTypeRule returns [EObject current=null] : iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF ;
    public final EObject entryRuleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1941:59: (iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF )
            // InternalInstanceLanguage.g:1942:2: iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF
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
    // InternalInstanceLanguage.g:1948:1: ruleExpressionTypeRule returns [EObject current=null] : ( () otherlv_1= 'expression' ) ;
    public final EObject ruleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1954:2: ( ( () otherlv_1= 'expression' ) )
            // InternalInstanceLanguage.g:1955:2: ( () otherlv_1= 'expression' )
            {
            // InternalInstanceLanguage.g:1955:2: ( () otherlv_1= 'expression' )
            // InternalInstanceLanguage.g:1956:3: () otherlv_1= 'expression'
            {
            // InternalInstanceLanguage.g:1956:3: ()
            // InternalInstanceLanguage.g:1957:4: 
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

            otherlv_1=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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
    // InternalInstanceLanguage.g:1974:1: entryRuleIntTypeRule returns [EObject current=null] : iv_ruleIntTypeRule= ruleIntTypeRule EOF ;
    public final EObject entryRuleIntTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntTypeRule = null;


        try {
            // InternalInstanceLanguage.g:1974:52: (iv_ruleIntTypeRule= ruleIntTypeRule EOF )
            // InternalInstanceLanguage.g:1975:2: iv_ruleIntTypeRule= ruleIntTypeRule EOF
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
    // InternalInstanceLanguage.g:1981:1: ruleIntTypeRule returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:1987:2: ( ( () otherlv_1= 'int' ) )
            // InternalInstanceLanguage.g:1988:2: ( () otherlv_1= 'int' )
            {
            // InternalInstanceLanguage.g:1988:2: ( () otherlv_1= 'int' )
            // InternalInstanceLanguage.g:1989:3: () otherlv_1= 'int'
            {
            // InternalInstanceLanguage.g:1989:3: ()
            // InternalInstanceLanguage.g:1990:4: 
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

            otherlv_1=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleFloatTypeRule"
    // InternalInstanceLanguage.g:2007:1: entryRuleFloatTypeRule returns [EObject current=null] : iv_ruleFloatTypeRule= ruleFloatTypeRule EOF ;
    public final EObject entryRuleFloatTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatTypeRule = null;


        try {
            // InternalInstanceLanguage.g:2007:54: (iv_ruleFloatTypeRule= ruleFloatTypeRule EOF )
            // InternalInstanceLanguage.g:2008:2: iv_ruleFloatTypeRule= ruleFloatTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFloatTypeRule=ruleFloatTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloatTypeRule; 
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
    // $ANTLR end "entryRuleFloatTypeRule"


    // $ANTLR start "ruleFloatTypeRule"
    // InternalInstanceLanguage.g:2014:1: ruleFloatTypeRule returns [EObject current=null] : ( () otherlv_1= 'float' ) ;
    public final EObject ruleFloatTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2020:2: ( ( () otherlv_1= 'float' ) )
            // InternalInstanceLanguage.g:2021:2: ( () otherlv_1= 'float' )
            {
            // InternalInstanceLanguage.g:2021:2: ( () otherlv_1= 'float' )
            // InternalInstanceLanguage.g:2022:3: () otherlv_1= 'float'
            {
            // InternalInstanceLanguage.g:2022:3: ()
            // InternalInstanceLanguage.g:2023:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFloatTypeRuleAccess().getFloatKeyword_1());
              		
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
    // $ANTLR end "ruleFloatTypeRule"


    // $ANTLR start "entryRuleBooleanTypeRule"
    // InternalInstanceLanguage.g:2040:1: entryRuleBooleanTypeRule returns [EObject current=null] : iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF ;
    public final EObject entryRuleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeRule = null;


        try {
            // InternalInstanceLanguage.g:2040:56: (iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF )
            // InternalInstanceLanguage.g:2041:2: iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF
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
    // InternalInstanceLanguage.g:2047:1: ruleBooleanTypeRule returns [EObject current=null] : ( () otherlv_1= 'boolean' ) ;
    public final EObject ruleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2053:2: ( ( () otherlv_1= 'boolean' ) )
            // InternalInstanceLanguage.g:2054:2: ( () otherlv_1= 'boolean' )
            {
            // InternalInstanceLanguage.g:2054:2: ( () otherlv_1= 'boolean' )
            // InternalInstanceLanguage.g:2055:3: () otherlv_1= 'boolean'
            {
            // InternalInstanceLanguage.g:2055:3: ()
            // InternalInstanceLanguage.g:2056:4: 
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

            otherlv_1=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalInstanceLanguage.g:2073:1: entryRuleVoidTypeRule returns [EObject current=null] : iv_ruleVoidTypeRule= ruleVoidTypeRule EOF ;
    public final EObject entryRuleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoidTypeRule = null;


        try {
            // InternalInstanceLanguage.g:2073:53: (iv_ruleVoidTypeRule= ruleVoidTypeRule EOF )
            // InternalInstanceLanguage.g:2074:2: iv_ruleVoidTypeRule= ruleVoidTypeRule EOF
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
    // InternalInstanceLanguage.g:2080:1: ruleVoidTypeRule returns [EObject current=null] : ( () otherlv_1= 'void' ) ;
    public final EObject ruleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2086:2: ( ( () otherlv_1= 'void' ) )
            // InternalInstanceLanguage.g:2087:2: ( () otherlv_1= 'void' )
            {
            // InternalInstanceLanguage.g:2087:2: ( () otherlv_1= 'void' )
            // InternalInstanceLanguage.g:2088:3: () otherlv_1= 'void'
            {
            // InternalInstanceLanguage.g:2088:3: ()
            // InternalInstanceLanguage.g:2089:4: 
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

            otherlv_1=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDataTypeRule"
    // InternalInstanceLanguage.g:2106:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalInstanceLanguage.g:2106:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalInstanceLanguage.g:2107:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
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
    // InternalInstanceLanguage.g:2113:1: ruleDataTypeRule returns [EObject current=null] : ( () otherlv_1= 'data' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2119:2: ( ( () otherlv_1= 'data' ) )
            // InternalInstanceLanguage.g:2120:2: ( () otherlv_1= 'data' )
            {
            // InternalInstanceLanguage.g:2120:2: ( () otherlv_1= 'data' )
            // InternalInstanceLanguage.g:2121:3: () otherlv_1= 'data'
            {
            // InternalInstanceLanguage.g:2121:3: ()
            // InternalInstanceLanguage.g:2122:4: 
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

            otherlv_1=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleArrayTypeRule"
    // InternalInstanceLanguage.g:2139:1: entryRuleArrayTypeRule returns [EObject current=null] : iv_ruleArrayTypeRule= ruleArrayTypeRule EOF ;
    public final EObject entryRuleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTypeRule = null;


        try {
            // InternalInstanceLanguage.g:2139:54: (iv_ruleArrayTypeRule= ruleArrayTypeRule EOF )
            // InternalInstanceLanguage.g:2140:2: iv_ruleArrayTypeRule= ruleArrayTypeRule EOF
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
    // InternalInstanceLanguage.g:2146:1: ruleArrayTypeRule returns [EObject current=null] : (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) ;
    public final EObject ruleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:2152:2: ( (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) )
            // InternalInstanceLanguage.g:2153:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            {
            // InternalInstanceLanguage.g:2153:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            // InternalInstanceLanguage.g:2154:3: otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0());
              		
            }
            // InternalInstanceLanguage.g:2158:3: ( (lv_elements_1_0= ruleTypeRule ) )
            // InternalInstanceLanguage.g:2159:4: (lv_elements_1_0= ruleTypeRule )
            {
            // InternalInstanceLanguage.g:2159:4: (lv_elements_1_0= ruleTypeRule )
            // InternalInstanceLanguage.g:2160:5: lv_elements_1_0= ruleTypeRule
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
    // InternalInstanceLanguage.g:2181:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // InternalInstanceLanguage.g:2181:54: (iv_ruleParameterRule= ruleParameterRule EOF )
            // InternalInstanceLanguage.g:2182:2: iv_ruleParameterRule= ruleParameterRule EOF
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
    // InternalInstanceLanguage.g:2188:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:2194:2: ( ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) )
            // InternalInstanceLanguage.g:2195:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            {
            // InternalInstanceLanguage.g:2195:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            // InternalInstanceLanguage.g:2196:3: ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) )
            {
            // InternalInstanceLanguage.g:2196:3: ( (lv_type_0_0= ruleTypeRule ) )
            // InternalInstanceLanguage.g:2197:4: (lv_type_0_0= ruleTypeRule )
            {
            // InternalInstanceLanguage.g:2197:4: (lv_type_0_0= ruleTypeRule )
            // InternalInstanceLanguage.g:2198:5: lv_type_0_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
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

            // InternalInstanceLanguage.g:2215:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalInstanceLanguage.g:2216:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalInstanceLanguage.g:2216:4: (lv_name_1_0= ruleStringOrId )
            // InternalInstanceLanguage.g:2217:5: lv_name_1_0= ruleStringOrId
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


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalInstanceLanguage.g:2238:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalInstanceLanguage.g:2238:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalInstanceLanguage.g:2239:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionNameRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionNameRule=ruleFunctionNameRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionNameRule; 
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
    // $ANTLR end "entryRuleFunctionNameRule"


    // $ANTLR start "ruleFunctionNameRule"
    // InternalInstanceLanguage.g:2245:1: ruleFunctionNameRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2251:2: ( ( ( ruleQualifiedName ) ) )
            // InternalInstanceLanguage.g:2252:2: ( ( ruleQualifiedName ) )
            {
            // InternalInstanceLanguage.g:2252:2: ( ( ruleQualifiedName ) )
            // InternalInstanceLanguage.g:2253:3: ( ruleQualifiedName )
            {
            // InternalInstanceLanguage.g:2253:3: ( ruleQualifiedName )
            // InternalInstanceLanguage.g:2254:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getFunctionNameRuleRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0());
              			
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
    // $ANTLR end "ruleFunctionNameRule"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalInstanceLanguage.g:2274:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalInstanceLanguage.g:2274:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalInstanceLanguage.g:2275:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalInstanceLanguage.g:2281:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_0 = null;

        AntlrDatatypeRuleToken this_StringOrId_2 = null;



        	enterRule();

        try {
            // InternalInstanceLanguage.g:2287:2: ( (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) )
            // InternalInstanceLanguage.g:2288:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            {
            // InternalInstanceLanguage.g:2288:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            // InternalInstanceLanguage.g:2289:3: this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_26);
            this_StringOrId_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_StringOrId_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalInstanceLanguage.g:2299:3: (kw= '.' this_StringOrId_2= ruleStringOrId )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==42) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalInstanceLanguage.g:2300:4: kw= '.' this_StringOrId_2= ruleStringOrId
            	    {
            	    kw=(Token)match(input,42,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_26);
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
            	    break loop24;
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
    // InternalInstanceLanguage.g:2320:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalInstanceLanguage.g:2320:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalInstanceLanguage.g:2321:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalInstanceLanguage.g:2327:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2333:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalInstanceLanguage.g:2334:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalInstanceLanguage.g:2334:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_QUOTED_ID) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_ID) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalInstanceLanguage.g:2335:3: this_QUOTED_ID_0= RULE_QUOTED_ID
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
                    // InternalInstanceLanguage.g:2343:3: this_ID_1= RULE_ID
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
    // InternalInstanceLanguage.g:2354:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalInstanceLanguage.g:2360:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalInstanceLanguage.g:2361:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalInstanceLanguage.g:2361:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt26=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt26=1;
                }
                break;
            case 44:
                {
                alt26=2;
                }
                break;
            case 45:
                {
                alt26=3;
                }
                break;
            case 46:
                {
                alt26=4;
                }
                break;
            case 47:
                {
                alt26=5;
                }
                break;
            case 48:
                {
                alt26=6;
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
                    // InternalInstanceLanguage.g:2362:3: (enumLiteral_0= '>=' )
                    {
                    // InternalInstanceLanguage.g:2362:3: (enumLiteral_0= '>=' )
                    // InternalInstanceLanguage.g:2363:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:2370:3: (enumLiteral_1= '>' )
                    {
                    // InternalInstanceLanguage.g:2370:3: (enumLiteral_1= '>' )
                    // InternalInstanceLanguage.g:2371:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:2378:3: (enumLiteral_2= '=' )
                    {
                    // InternalInstanceLanguage.g:2378:3: (enumLiteral_2= '=' )
                    // InternalInstanceLanguage.g:2379:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:2386:3: (enumLiteral_3= '!=' )
                    {
                    // InternalInstanceLanguage.g:2386:3: (enumLiteral_3= '!=' )
                    // InternalInstanceLanguage.g:2387:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalInstanceLanguage.g:2394:3: (enumLiteral_4= '<' )
                    {
                    // InternalInstanceLanguage.g:2394:3: (enumLiteral_4= '<' )
                    // InternalInstanceLanguage.g:2395:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalInstanceLanguage.g:2402:3: (enumLiteral_5= '<=' )
                    {
                    // InternalInstanceLanguage.g:2402:3: (enumLiteral_5= '<=' )
                    // InternalInstanceLanguage.g:2403:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalInstanceLanguage.g:2413:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2419:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalInstanceLanguage.g:2420:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalInstanceLanguage.g:2420:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==49) ) {
                alt27=1;
            }
            else if ( (LA27_0==50) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalInstanceLanguage.g:2421:3: (enumLiteral_0= '+' )
                    {
                    // InternalInstanceLanguage.g:2421:3: (enumLiteral_0= '+' )
                    // InternalInstanceLanguage.g:2422:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:2429:3: (enumLiteral_1= '-' )
                    {
                    // InternalInstanceLanguage.g:2429:3: (enumLiteral_1= '-' )
                    // InternalInstanceLanguage.g:2430:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
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
    // InternalInstanceLanguage.g:2440:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalInstanceLanguage.g:2446:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalInstanceLanguage.g:2447:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalInstanceLanguage.g:2447:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt28=1;
                }
                break;
            case 52:
                {
                alt28=2;
                }
                break;
            case 53:
                {
                alt28=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalInstanceLanguage.g:2448:3: (enumLiteral_0= '*' )
                    {
                    // InternalInstanceLanguage.g:2448:3: (enumLiteral_0= '*' )
                    // InternalInstanceLanguage.g:2449:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:2456:3: (enumLiteral_1= '/' )
                    {
                    // InternalInstanceLanguage.g:2456:3: (enumLiteral_1= '/' )
                    // InternalInstanceLanguage.g:2457:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:2464:3: (enumLiteral_2= '%' )
                    {
                    // InternalInstanceLanguage.g:2464:3: (enumLiteral_2= '%' )
                    // InternalInstanceLanguage.g:2465:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
    // InternalInstanceLanguage.g:2475:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalInstanceLanguage.g:2481:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalInstanceLanguage.g:2482:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalInstanceLanguage.g:2482:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt29=20;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt29=1;
                }
                break;
            case 55:
                {
                alt29=2;
                }
                break;
            case 56:
                {
                alt29=3;
                }
                break;
            case 57:
                {
                alt29=4;
                }
                break;
            case 58:
                {
                alt29=5;
                }
                break;
            case 59:
                {
                alt29=6;
                }
                break;
            case 60:
                {
                alt29=7;
                }
                break;
            case 61:
                {
                alt29=8;
                }
                break;
            case 62:
                {
                alt29=9;
                }
                break;
            case 63:
                {
                alt29=10;
                }
                break;
            case 64:
                {
                alt29=11;
                }
                break;
            case 65:
                {
                alt29=12;
                }
                break;
            case 66:
                {
                alt29=13;
                }
                break;
            case 67:
                {
                alt29=14;
                }
                break;
            case 68:
                {
                alt29=15;
                }
                break;
            case 69:
                {
                alt29=16;
                }
                break;
            case 70:
                {
                alt29=17;
                }
                break;
            case 71:
                {
                alt29=18;
                }
                break;
            case 72:
                {
                alt29=19;
                }
                break;
            case 73:
                {
                alt29=20;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalInstanceLanguage.g:2483:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalInstanceLanguage.g:2483:3: (enumLiteral_0= 'Y' )
                    // InternalInstanceLanguage.g:2484:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalInstanceLanguage.g:2491:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalInstanceLanguage.g:2491:3: (enumLiteral_1= 'Z' )
                    // InternalInstanceLanguage.g:2492:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalInstanceLanguage.g:2499:3: (enumLiteral_2= 'E' )
                    {
                    // InternalInstanceLanguage.g:2499:3: (enumLiteral_2= 'E' )
                    // InternalInstanceLanguage.g:2500:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalInstanceLanguage.g:2507:3: (enumLiteral_3= 'P' )
                    {
                    // InternalInstanceLanguage.g:2507:3: (enumLiteral_3= 'P' )
                    // InternalInstanceLanguage.g:2508:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalInstanceLanguage.g:2515:3: (enumLiteral_4= 'T' )
                    {
                    // InternalInstanceLanguage.g:2515:3: (enumLiteral_4= 'T' )
                    // InternalInstanceLanguage.g:2516:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalInstanceLanguage.g:2523:3: (enumLiteral_5= 'G' )
                    {
                    // InternalInstanceLanguage.g:2523:3: (enumLiteral_5= 'G' )
                    // InternalInstanceLanguage.g:2524:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalInstanceLanguage.g:2531:3: (enumLiteral_6= 'M' )
                    {
                    // InternalInstanceLanguage.g:2531:3: (enumLiteral_6= 'M' )
                    // InternalInstanceLanguage.g:2532:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalInstanceLanguage.g:2539:3: (enumLiteral_7= 'k' )
                    {
                    // InternalInstanceLanguage.g:2539:3: (enumLiteral_7= 'k' )
                    // InternalInstanceLanguage.g:2540:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalInstanceLanguage.g:2547:3: (enumLiteral_8= 'h' )
                    {
                    // InternalInstanceLanguage.g:2547:3: (enumLiteral_8= 'h' )
                    // InternalInstanceLanguage.g:2548:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalInstanceLanguage.g:2555:3: (enumLiteral_9= 'da' )
                    {
                    // InternalInstanceLanguage.g:2555:3: (enumLiteral_9= 'da' )
                    // InternalInstanceLanguage.g:2556:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalInstanceLanguage.g:2563:3: (enumLiteral_10= 'd' )
                    {
                    // InternalInstanceLanguage.g:2563:3: (enumLiteral_10= 'd' )
                    // InternalInstanceLanguage.g:2564:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalInstanceLanguage.g:2571:3: (enumLiteral_11= 'c' )
                    {
                    // InternalInstanceLanguage.g:2571:3: (enumLiteral_11= 'c' )
                    // InternalInstanceLanguage.g:2572:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalInstanceLanguage.g:2579:3: (enumLiteral_12= 'm' )
                    {
                    // InternalInstanceLanguage.g:2579:3: (enumLiteral_12= 'm' )
                    // InternalInstanceLanguage.g:2580:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalInstanceLanguage.g:2587:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalInstanceLanguage.g:2587:3: (enumLiteral_13= '\\u00B5' )
                    // InternalInstanceLanguage.g:2588:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalInstanceLanguage.g:2595:3: (enumLiteral_14= 'n' )
                    {
                    // InternalInstanceLanguage.g:2595:3: (enumLiteral_14= 'n' )
                    // InternalInstanceLanguage.g:2596:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalInstanceLanguage.g:2603:3: (enumLiteral_15= 'p' )
                    {
                    // InternalInstanceLanguage.g:2603:3: (enumLiteral_15= 'p' )
                    // InternalInstanceLanguage.g:2604:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                      			
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalInstanceLanguage.g:2611:3: (enumLiteral_16= 'f' )
                    {
                    // InternalInstanceLanguage.g:2611:3: (enumLiteral_16= 'f' )
                    // InternalInstanceLanguage.g:2612:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalInstanceLanguage.g:2619:3: (enumLiteral_17= 'a' )
                    {
                    // InternalInstanceLanguage.g:2619:3: (enumLiteral_17= 'a' )
                    // InternalInstanceLanguage.g:2620:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                      			
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalInstanceLanguage.g:2627:3: (enumLiteral_18= 'z' )
                    {
                    // InternalInstanceLanguage.g:2627:3: (enumLiteral_18= 'z' )
                    // InternalInstanceLanguage.g:2628:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                      			
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalInstanceLanguage.g:2635:3: (enumLiteral_19= 'y' )
                    {
                    // InternalInstanceLanguage.g:2635:3: (enumLiteral_19= 'y' )
                    // InternalInstanceLanguage.g:2636:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
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


    protected DFA11 dfa11 = new DFA11(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_3s = "\1\4\1\uffff\2\20\3\uffff\1\7\1\uffff\2\20";
    static final String dfa_4s = "\1\37\1\uffff\2\65\3\uffff\1\10\1\uffff\2\65";
    static final String dfa_5s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\3\4\1\2\1\3\6\uffff\1\6\5\uffff\1\1\2\uffff\1\5\5\uffff\2\4",
            "",
            "\3\6\1\uffff\1\6\1\uffff\2\6\1\10\1\6\1\4\2\uffff\1\6\14\uffff\1\7\13\6",
            "\3\6\1\uffff\1\6\1\uffff\2\6\1\10\1\6\1\4\2\uffff\1\6\14\uffff\1\7\13\6",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\3\6\1\uffff\1\6\1\uffff\2\6\1\10\1\6\1\4\2\uffff\1\6\14\uffff\1\7\13\6",
            "\3\6\1\uffff\1\6\1\uffff\2\6\1\10\1\6\1\4\2\uffff\1\6\14\uffff\1\7\13\6"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "839:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00060000C12881F0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0001F80000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0038000000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00060000C1A881F0L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00060000C32881F0L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000180L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xFFC0000000000002L,0x00000000000003FFL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000003FE00008000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000040000000002L});

}
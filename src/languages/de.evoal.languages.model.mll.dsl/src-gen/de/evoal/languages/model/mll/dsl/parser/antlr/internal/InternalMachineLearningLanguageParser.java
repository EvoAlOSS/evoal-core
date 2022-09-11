package de.evoal.languages.model.mll.dsl.parser.antlr.internal;

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
import de.evoal.languages.model.mll.dsl.services.MachineLearningLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMachineLearningLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_QUOTED_ID", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'use'", "';'", "'prediction'", "'maps'", "','", "'to'", "'using'", "'layer'", "'with'", "'function'", "'mapping'", "'parameters'", "'predict'", "'from'", "'measure'", "'{'", "'}'", "':='", "'['", "']'", "'data'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'('", "')'", "'value'", "'true'", "'false'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'"
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
    public static final int RULE_ID=7;
    public static final int RULE_QUOTED_ID=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
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


        public InternalMachineLearningLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMachineLearningLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMachineLearningLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMachineLearningLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private MachineLearningLanguageGrammarAccess grammarAccess;

        public InternalMachineLearningLanguageParser(TokenStream input, MachineLearningLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "MachineLearningConfigurationRule";
       	}

       	@Override
       	protected MachineLearningLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMachineLearningConfigurationRule"
    // InternalMachineLearningLanguage.g:72:1: entryRuleMachineLearningConfigurationRule returns [EObject current=null] : iv_ruleMachineLearningConfigurationRule= ruleMachineLearningConfigurationRule EOF ;
    public final EObject entryRuleMachineLearningConfigurationRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMachineLearningConfigurationRule = null;


        try {
            // InternalMachineLearningLanguage.g:72:73: (iv_ruleMachineLearningConfigurationRule= ruleMachineLearningConfigurationRule EOF )
            // InternalMachineLearningLanguage.g:73:2: iv_ruleMachineLearningConfigurationRule= ruleMachineLearningConfigurationRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMachineLearningConfigurationRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMachineLearningConfigurationRule=ruleMachineLearningConfigurationRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMachineLearningConfigurationRule; 
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
    // $ANTLR end "entryRuleMachineLearningConfigurationRule"


    // $ANTLR start "ruleMachineLearningConfigurationRule"
    // InternalMachineLearningLanguage.g:79:1: ruleMachineLearningConfigurationRule returns [EObject current=null] : ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_definitions_1_0= ruleSurrogateDefinitionRule ) )* ( (lv_predictions_2_0= rulePredictionRule ) )* ) ;
    public final EObject ruleMachineLearningConfigurationRule() throws RecognitionException {
        EObject current = null;

        EObject lv_uses_0_0 = null;

        EObject lv_definitions_1_0 = null;

        EObject lv_predictions_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:85:2: ( ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_definitions_1_0= ruleSurrogateDefinitionRule ) )* ( (lv_predictions_2_0= rulePredictionRule ) )* ) )
            // InternalMachineLearningLanguage.g:86:2: ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_definitions_1_0= ruleSurrogateDefinitionRule ) )* ( (lv_predictions_2_0= rulePredictionRule ) )* )
            {
            // InternalMachineLearningLanguage.g:86:2: ( ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_definitions_1_0= ruleSurrogateDefinitionRule ) )* ( (lv_predictions_2_0= rulePredictionRule ) )* )
            // InternalMachineLearningLanguage.g:87:3: ( (lv_uses_0_0= ruleUseRule ) )* ( (lv_definitions_1_0= ruleSurrogateDefinitionRule ) )* ( (lv_predictions_2_0= rulePredictionRule ) )*
            {
            // InternalMachineLearningLanguage.g:87:3: ( (lv_uses_0_0= ruleUseRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:88:4: (lv_uses_0_0= ruleUseRule )
            	    {
            	    // InternalMachineLearningLanguage.g:88:4: (lv_uses_0_0= ruleUseRule )
            	    // InternalMachineLearningLanguage.g:89:5: lv_uses_0_0= ruleUseRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMachineLearningConfigurationRuleAccess().getUsesUseRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_uses_0_0=ruleUseRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMachineLearningConfigurationRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"uses",
            	      						lv_uses_0_0,
            	      						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.UseRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalMachineLearningLanguage.g:106:3: ( (lv_definitions_1_0= ruleSurrogateDefinitionRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:107:4: (lv_definitions_1_0= ruleSurrogateDefinitionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:107:4: (lv_definitions_1_0= ruleSurrogateDefinitionRule )
            	    // InternalMachineLearningLanguage.g:108:5: lv_definitions_1_0= ruleSurrogateDefinitionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMachineLearningConfigurationRuleAccess().getDefinitionsSurrogateDefinitionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_definitions_1_0=ruleSurrogateDefinitionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMachineLearningConfigurationRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"definitions",
            	      						lv_definitions_1_0,
            	      						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.SurrogateDefinitionRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalMachineLearningLanguage.g:125:3: ( (lv_predictions_2_0= rulePredictionRule ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==24) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:126:4: (lv_predictions_2_0= rulePredictionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:126:4: (lv_predictions_2_0= rulePredictionRule )
            	    // InternalMachineLearningLanguage.g:127:5: lv_predictions_2_0= rulePredictionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMachineLearningConfigurationRuleAccess().getPredictionsPredictionRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_predictions_2_0=rulePredictionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMachineLearningConfigurationRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"predictions",
            	      						lv_predictions_2_0,
            	      						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.PredictionRule");
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
    // $ANTLR end "ruleMachineLearningConfigurationRule"


    // $ANTLR start "entryRuleUseRule"
    // InternalMachineLearningLanguage.g:148:1: entryRuleUseRule returns [EObject current=null] : iv_ruleUseRule= ruleUseRule EOF ;
    public final EObject entryRuleUseRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseRule = null;


        try {
            // InternalMachineLearningLanguage.g:148:48: (iv_ruleUseRule= ruleUseRule EOF )
            // InternalMachineLearningLanguage.g:149:2: iv_ruleUseRule= ruleUseRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUseRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUseRule=ruleUseRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUseRule; 
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
    // $ANTLR end "entryRuleUseRule"


    // $ANTLR start "ruleUseRule"
    // InternalMachineLearningLanguage.g:155:1: ruleUseRule returns [EObject current=null] : (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) ;
    public final EObject ruleUseRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:161:2: ( (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) )
            // InternalMachineLearningLanguage.g:162:2: (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            {
            // InternalMachineLearningLanguage.g:162:2: (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            // InternalMachineLearningLanguage.g:163:3: otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getUseRuleAccess().getUseKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:167:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:168:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:168:4: (lv_importURI_1_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:169:5: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_importURI_1_0, grammarAccess.getUseRuleAccess().getImportURISTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

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


            }

            otherlv_2=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUseRuleAccess().getSemicolonKeyword_2());
              		
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
    // $ANTLR end "ruleUseRule"


    // $ANTLR start "entryRuleSurrogateDefinitionRule"
    // InternalMachineLearningLanguage.g:193:1: entryRuleSurrogateDefinitionRule returns [EObject current=null] : iv_ruleSurrogateDefinitionRule= ruleSurrogateDefinitionRule EOF ;
    public final EObject entryRuleSurrogateDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSurrogateDefinitionRule = null;


        try {
            // InternalMachineLearningLanguage.g:193:64: (iv_ruleSurrogateDefinitionRule= ruleSurrogateDefinitionRule EOF )
            // InternalMachineLearningLanguage.g:194:2: iv_ruleSurrogateDefinitionRule= ruleSurrogateDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSurrogateDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSurrogateDefinitionRule=ruleSurrogateDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSurrogateDefinitionRule; 
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
    // $ANTLR end "entryRuleSurrogateDefinitionRule"


    // $ANTLR start "ruleSurrogateDefinitionRule"
    // InternalMachineLearningLanguage.g:200:1: ruleSurrogateDefinitionRule returns [EObject current=null] : (otherlv_0= 'prediction' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'maps' ( ( ruleStringOrId ) ) (otherlv_4= ',' ( ( ruleStringOrId ) ) )* otherlv_6= 'to' ( ( ruleStringOrId ) ) (otherlv_8= ',' ( ( ruleStringOrId ) ) )* otherlv_10= 'using' ( (lv_layers_11_0= ruleSurrogateLayerRule ) )+ ) ;
    public final EObject ruleSurrogateDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_layers_11_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:206:2: ( (otherlv_0= 'prediction' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'maps' ( ( ruleStringOrId ) ) (otherlv_4= ',' ( ( ruleStringOrId ) ) )* otherlv_6= 'to' ( ( ruleStringOrId ) ) (otherlv_8= ',' ( ( ruleStringOrId ) ) )* otherlv_10= 'using' ( (lv_layers_11_0= ruleSurrogateLayerRule ) )+ ) )
            // InternalMachineLearningLanguage.g:207:2: (otherlv_0= 'prediction' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'maps' ( ( ruleStringOrId ) ) (otherlv_4= ',' ( ( ruleStringOrId ) ) )* otherlv_6= 'to' ( ( ruleStringOrId ) ) (otherlv_8= ',' ( ( ruleStringOrId ) ) )* otherlv_10= 'using' ( (lv_layers_11_0= ruleSurrogateLayerRule ) )+ )
            {
            // InternalMachineLearningLanguage.g:207:2: (otherlv_0= 'prediction' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'maps' ( ( ruleStringOrId ) ) (otherlv_4= ',' ( ( ruleStringOrId ) ) )* otherlv_6= 'to' ( ( ruleStringOrId ) ) (otherlv_8= ',' ( ( ruleStringOrId ) ) )* otherlv_10= 'using' ( (lv_layers_11_0= ruleSurrogateLayerRule ) )+ )
            // InternalMachineLearningLanguage.g:208:3: otherlv_0= 'prediction' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'maps' ( ( ruleStringOrId ) ) (otherlv_4= ',' ( ( ruleStringOrId ) ) )* otherlv_6= 'to' ( ( ruleStringOrId ) ) (otherlv_8= ',' ( ( ruleStringOrId ) ) )* otherlv_10= 'using' ( (lv_layers_11_0= ruleSurrogateLayerRule ) )+
            {
            otherlv_0=(Token)match(input,14,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSurrogateDefinitionRuleAccess().getPredictionKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:212:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:213:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:213:4: (lv_name_1_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:214:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getSurrogateDefinitionRuleAccess().getNameSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSurrogateDefinitionRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.STRING");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getSurrogateDefinitionRuleAccess().getMapsKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:234:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:235:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:235:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:236:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSurrogateDefinitionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSurrogateDefinitionRuleAccess().getInputsDataDescriptionCrossReference_3_0());
              				
            }
            pushFollow(FOLLOW_10);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:253:3: (otherlv_4= ',' ( ( ruleStringOrId ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:254:4: otherlv_4= ',' ( ( ruleStringOrId ) )
            	    {
            	    otherlv_4=(Token)match(input,16,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getSurrogateDefinitionRuleAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:258:4: ( ( ruleStringOrId ) )
            	    // InternalMachineLearningLanguage.g:259:5: ( ruleStringOrId )
            	    {
            	    // InternalMachineLearningLanguage.g:259:5: ( ruleStringOrId )
            	    // InternalMachineLearningLanguage.g:260:6: ruleStringOrId
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getSurrogateDefinitionRuleRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSurrogateDefinitionRuleAccess().getInputsDataDescriptionCrossReference_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    ruleStringOrId();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            otherlv_6=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSurrogateDefinitionRuleAccess().getToKeyword_5());
              		
            }
            // InternalMachineLearningLanguage.g:282:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:283:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:283:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:284:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSurrogateDefinitionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSurrogateDefinitionRuleAccess().getOutputsDataDescriptionCrossReference_6_0());
              				
            }
            pushFollow(FOLLOW_11);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:301:3: (otherlv_8= ',' ( ( ruleStringOrId ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:302:4: otherlv_8= ',' ( ( ruleStringOrId ) )
            	    {
            	    otherlv_8=(Token)match(input,16,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_8, grammarAccess.getSurrogateDefinitionRuleAccess().getCommaKeyword_7_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:306:4: ( ( ruleStringOrId ) )
            	    // InternalMachineLearningLanguage.g:307:5: ( ruleStringOrId )
            	    {
            	    // InternalMachineLearningLanguage.g:307:5: ( ruleStringOrId )
            	    // InternalMachineLearningLanguage.g:308:6: ruleStringOrId
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getSurrogateDefinitionRuleRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSurrogateDefinitionRuleAccess().getOutputsDataDescriptionCrossReference_7_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    ruleStringOrId();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_10=(Token)match(input,18,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getSurrogateDefinitionRuleAccess().getUsingKeyword_8());
              		
            }
            // InternalMachineLearningLanguage.g:330:3: ( (lv_layers_11_0= ruleSurrogateLayerRule ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:331:4: (lv_layers_11_0= ruleSurrogateLayerRule )
            	    {
            	    // InternalMachineLearningLanguage.g:331:4: (lv_layers_11_0= ruleSurrogateLayerRule )
            	    // InternalMachineLearningLanguage.g:332:5: lv_layers_11_0= ruleSurrogateLayerRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSurrogateDefinitionRuleAccess().getLayersSurrogateLayerRuleParserRuleCall_9_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_layers_11_0=ruleSurrogateLayerRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSurrogateDefinitionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"layers",
            	      						lv_layers_11_0,
            	      						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.SurrogateLayerRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
    // $ANTLR end "ruleSurrogateDefinitionRule"


    // $ANTLR start "entryRuleSurrogateLayerRule"
    // InternalMachineLearningLanguage.g:353:1: entryRuleSurrogateLayerRule returns [EObject current=null] : iv_ruleSurrogateLayerRule= ruleSurrogateLayerRule EOF ;
    public final EObject entryRuleSurrogateLayerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSurrogateLayerRule = null;


        try {
            // InternalMachineLearningLanguage.g:353:59: (iv_ruleSurrogateLayerRule= ruleSurrogateLayerRule EOF )
            // InternalMachineLearningLanguage.g:354:2: iv_ruleSurrogateLayerRule= ruleSurrogateLayerRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSurrogateLayerRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSurrogateLayerRule=ruleSurrogateLayerRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSurrogateLayerRule; 
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
    // $ANTLR end "entryRuleSurrogateLayerRule"


    // $ANTLR start "ruleSurrogateLayerRule"
    // InternalMachineLearningLanguage.g:360:1: ruleSurrogateLayerRule returns [EObject current=null] : (otherlv_0= 'layer' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_functions_3_0= rulePartialSurrogateFunctionRule ) )+ ) ;
    public final EObject ruleSurrogateLayerRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_functions_3_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:366:2: ( (otherlv_0= 'layer' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_functions_3_0= rulePartialSurrogateFunctionRule ) )+ ) )
            // InternalMachineLearningLanguage.g:367:2: (otherlv_0= 'layer' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_functions_3_0= rulePartialSurrogateFunctionRule ) )+ )
            {
            // InternalMachineLearningLanguage.g:367:2: (otherlv_0= 'layer' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_functions_3_0= rulePartialSurrogateFunctionRule ) )+ )
            // InternalMachineLearningLanguage.g:368:3: otherlv_0= 'layer' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_functions_3_0= rulePartialSurrogateFunctionRule ) )+
            {
            otherlv_0=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSurrogateLayerRuleAccess().getLayerKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:372:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:373:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:373:4: (lv_name_1_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:374:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getSurrogateLayerRuleAccess().getNameSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSurrogateLayerRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.STRING");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getSurrogateLayerRuleAccess().getWithKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:394:3: ( (lv_functions_3_0= rulePartialSurrogateFunctionRule ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:395:4: (lv_functions_3_0= rulePartialSurrogateFunctionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:395:4: (lv_functions_3_0= rulePartialSurrogateFunctionRule )
            	    // InternalMachineLearningLanguage.g:396:5: lv_functions_3_0= rulePartialSurrogateFunctionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSurrogateLayerRuleAccess().getFunctionsPartialSurrogateFunctionRuleParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_functions_3_0=rulePartialSurrogateFunctionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSurrogateLayerRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"functions",
            	      						lv_functions_3_0,
            	      						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.PartialSurrogateFunctionRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
    // $ANTLR end "ruleSurrogateLayerRule"


    // $ANTLR start "entryRulePartialSurrogateFunctionRule"
    // InternalMachineLearningLanguage.g:417:1: entryRulePartialSurrogateFunctionRule returns [EObject current=null] : iv_rulePartialSurrogateFunctionRule= rulePartialSurrogateFunctionRule EOF ;
    public final EObject entryRulePartialSurrogateFunctionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialSurrogateFunctionRule = null;


        try {
            // InternalMachineLearningLanguage.g:417:69: (iv_rulePartialSurrogateFunctionRule= rulePartialSurrogateFunctionRule EOF )
            // InternalMachineLearningLanguage.g:418:2: iv_rulePartialSurrogateFunctionRule= rulePartialSurrogateFunctionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartialSurrogateFunctionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartialSurrogateFunctionRule=rulePartialSurrogateFunctionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartialSurrogateFunctionRule; 
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
    // $ANTLR end "entryRulePartialSurrogateFunctionRule"


    // $ANTLR start "rulePartialSurrogateFunctionRule"
    // InternalMachineLearningLanguage.g:424:1: rulePartialSurrogateFunctionRule returns [EObject current=null] : (otherlv_0= 'function' ( ( ruleStringOrId ) ) otherlv_2= 'mapping' ( ( ruleStringOrId ) ) (otherlv_4= ',' ( ( ruleStringOrId ) ) )* otherlv_6= 'to' ( ( ruleStringOrId ) ) (otherlv_8= ',' ( ( ruleStringOrId ) ) )* (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_parameters_12_0= ruleAttributeRule ) )+ )? ) ;
    public final EObject rulePartialSurrogateFunctionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_parameters_12_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:430:2: ( (otherlv_0= 'function' ( ( ruleStringOrId ) ) otherlv_2= 'mapping' ( ( ruleStringOrId ) ) (otherlv_4= ',' ( ( ruleStringOrId ) ) )* otherlv_6= 'to' ( ( ruleStringOrId ) ) (otherlv_8= ',' ( ( ruleStringOrId ) ) )* (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_parameters_12_0= ruleAttributeRule ) )+ )? ) )
            // InternalMachineLearningLanguage.g:431:2: (otherlv_0= 'function' ( ( ruleStringOrId ) ) otherlv_2= 'mapping' ( ( ruleStringOrId ) ) (otherlv_4= ',' ( ( ruleStringOrId ) ) )* otherlv_6= 'to' ( ( ruleStringOrId ) ) (otherlv_8= ',' ( ( ruleStringOrId ) ) )* (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_parameters_12_0= ruleAttributeRule ) )+ )? )
            {
            // InternalMachineLearningLanguage.g:431:2: (otherlv_0= 'function' ( ( ruleStringOrId ) ) otherlv_2= 'mapping' ( ( ruleStringOrId ) ) (otherlv_4= ',' ( ( ruleStringOrId ) ) )* otherlv_6= 'to' ( ( ruleStringOrId ) ) (otherlv_8= ',' ( ( ruleStringOrId ) ) )* (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_parameters_12_0= ruleAttributeRule ) )+ )? )
            // InternalMachineLearningLanguage.g:432:3: otherlv_0= 'function' ( ( ruleStringOrId ) ) otherlv_2= 'mapping' ( ( ruleStringOrId ) ) (otherlv_4= ',' ( ( ruleStringOrId ) ) )* otherlv_6= 'to' ( ( ruleStringOrId ) ) (otherlv_8= ',' ( ( ruleStringOrId ) ) )* (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_parameters_12_0= ruleAttributeRule ) )+ )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPartialSurrogateFunctionRuleAccess().getFunctionKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:436:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:437:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:437:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:438:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPartialSurrogateFunctionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialSurrogateFunctionRuleAccess().getNameTypeDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_17);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPartialSurrogateFunctionRuleAccess().getMappingKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:459:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:460:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:460:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:461:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPartialSurrogateFunctionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialSurrogateFunctionRuleAccess().getInputsDataDescriptionCrossReference_3_0());
              				
            }
            pushFollow(FOLLOW_10);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:478:3: (otherlv_4= ',' ( ( ruleStringOrId ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==16) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:479:4: otherlv_4= ',' ( ( ruleStringOrId ) )
            	    {
            	    otherlv_4=(Token)match(input,16,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getPartialSurrogateFunctionRuleAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:483:4: ( ( ruleStringOrId ) )
            	    // InternalMachineLearningLanguage.g:484:5: ( ruleStringOrId )
            	    {
            	    // InternalMachineLearningLanguage.g:484:5: ( ruleStringOrId )
            	    // InternalMachineLearningLanguage.g:485:6: ruleStringOrId
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getPartialSurrogateFunctionRuleRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPartialSurrogateFunctionRuleAccess().getInputsDataDescriptionCrossReference_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    ruleStringOrId();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            otherlv_6=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getPartialSurrogateFunctionRuleAccess().getToKeyword_5());
              		
            }
            // InternalMachineLearningLanguage.g:507:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:508:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:508:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:509:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPartialSurrogateFunctionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialSurrogateFunctionRuleAccess().getOutputsDataDescriptionCrossReference_6_0());
              				
            }
            pushFollow(FOLLOW_18);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:526:3: (otherlv_8= ',' ( ( ruleStringOrId ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:527:4: otherlv_8= ',' ( ( ruleStringOrId ) )
            	    {
            	    otherlv_8=(Token)match(input,16,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_8, grammarAccess.getPartialSurrogateFunctionRuleAccess().getCommaKeyword_7_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:531:4: ( ( ruleStringOrId ) )
            	    // InternalMachineLearningLanguage.g:532:5: ( ruleStringOrId )
            	    {
            	    // InternalMachineLearningLanguage.g:532:5: ( ruleStringOrId )
            	    // InternalMachineLearningLanguage.g:533:6: ruleStringOrId
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getPartialSurrogateFunctionRuleRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPartialSurrogateFunctionRuleAccess().getOutputsDataDescriptionCrossReference_7_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
            	    ruleStringOrId();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalMachineLearningLanguage.g:551:3: (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_parameters_12_0= ruleAttributeRule ) )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMachineLearningLanguage.g:552:4: otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_parameters_12_0= ruleAttributeRule ) )+
                    {
                    otherlv_10=(Token)match(input,20,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getPartialSurrogateFunctionRuleAccess().getWithKeyword_8_0());
                      			
                    }
                    otherlv_11=(Token)match(input,23,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getPartialSurrogateFunctionRuleAccess().getParametersKeyword_8_1());
                      			
                    }
                    // InternalMachineLearningLanguage.g:560:4: ( (lv_parameters_12_0= ruleAttributeRule ) )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_STRING||(LA10_0>=RULE_QUOTED_ID && LA10_0<=RULE_ID)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:561:5: (lv_parameters_12_0= ruleAttributeRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:561:5: (lv_parameters_12_0= ruleAttributeRule )
                    	    // InternalMachineLearningLanguage.g:562:6: lv_parameters_12_0= ruleAttributeRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getPartialSurrogateFunctionRuleAccess().getParametersAttributeRuleParserRuleCall_8_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_21);
                    	    lv_parameters_12_0=ruleAttributeRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getPartialSurrogateFunctionRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"parameters",
                    	      							lv_parameters_12_0,
                    	      							"de.evoal.languages.model.instance.dsl.InstanceLanguage.AttributeRule");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


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
    // $ANTLR end "rulePartialSurrogateFunctionRule"


    // $ANTLR start "entryRulePredictionRule"
    // InternalMachineLearningLanguage.g:584:1: entryRulePredictionRule returns [EObject current=null] : iv_rulePredictionRule= rulePredictionRule EOF ;
    public final EObject entryRulePredictionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredictionRule = null;


        try {
            // InternalMachineLearningLanguage.g:584:55: (iv_rulePredictionRule= rulePredictionRule EOF )
            // InternalMachineLearningLanguage.g:585:2: iv_rulePredictionRule= rulePredictionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredictionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePredictionRule=rulePredictionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredictionRule; 
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
    // $ANTLR end "entryRulePredictionRule"


    // $ANTLR start "rulePredictionRule"
    // InternalMachineLearningLanguage.g:591:1: rulePredictionRule returns [EObject current=null] : (otherlv_0= 'predict' ( ( ruleStringOrId ) ) (otherlv_2= ',' ( ( ruleStringOrId ) ) )* otherlv_4= 'from' ( ( ruleStringOrId ) ) (otherlv_6= ',' ( ( ruleStringOrId ) ) )* otherlv_8= 'using' ( ( ruleStringOrId ) ) otherlv_10= 'measure' ( (lv_quality_11_0= ruleBlockStatementRule ) ) ) ;
    public final EObject rulePredictionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_quality_11_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:597:2: ( (otherlv_0= 'predict' ( ( ruleStringOrId ) ) (otherlv_2= ',' ( ( ruleStringOrId ) ) )* otherlv_4= 'from' ( ( ruleStringOrId ) ) (otherlv_6= ',' ( ( ruleStringOrId ) ) )* otherlv_8= 'using' ( ( ruleStringOrId ) ) otherlv_10= 'measure' ( (lv_quality_11_0= ruleBlockStatementRule ) ) ) )
            // InternalMachineLearningLanguage.g:598:2: (otherlv_0= 'predict' ( ( ruleStringOrId ) ) (otherlv_2= ',' ( ( ruleStringOrId ) ) )* otherlv_4= 'from' ( ( ruleStringOrId ) ) (otherlv_6= ',' ( ( ruleStringOrId ) ) )* otherlv_8= 'using' ( ( ruleStringOrId ) ) otherlv_10= 'measure' ( (lv_quality_11_0= ruleBlockStatementRule ) ) )
            {
            // InternalMachineLearningLanguage.g:598:2: (otherlv_0= 'predict' ( ( ruleStringOrId ) ) (otherlv_2= ',' ( ( ruleStringOrId ) ) )* otherlv_4= 'from' ( ( ruleStringOrId ) ) (otherlv_6= ',' ( ( ruleStringOrId ) ) )* otherlv_8= 'using' ( ( ruleStringOrId ) ) otherlv_10= 'measure' ( (lv_quality_11_0= ruleBlockStatementRule ) ) )
            // InternalMachineLearningLanguage.g:599:3: otherlv_0= 'predict' ( ( ruleStringOrId ) ) (otherlv_2= ',' ( ( ruleStringOrId ) ) )* otherlv_4= 'from' ( ( ruleStringOrId ) ) (otherlv_6= ',' ( ( ruleStringOrId ) ) )* otherlv_8= 'using' ( ( ruleStringOrId ) ) otherlv_10= 'measure' ( (lv_quality_11_0= ruleBlockStatementRule ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPredictionRuleAccess().getPredictKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:603:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:604:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:604:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:605:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPredictionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPredictionRuleAccess().getOutputsDataDescriptionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_22);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:622:3: (otherlv_2= ',' ( ( ruleStringOrId ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==16) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:623:4: otherlv_2= ',' ( ( ruleStringOrId ) )
            	    {
            	    otherlv_2=(Token)match(input,16,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getPredictionRuleAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:627:4: ( ( ruleStringOrId ) )
            	    // InternalMachineLearningLanguage.g:628:5: ( ruleStringOrId )
            	    {
            	    // InternalMachineLearningLanguage.g:628:5: ( ruleStringOrId )
            	    // InternalMachineLearningLanguage.g:629:6: ruleStringOrId
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getPredictionRuleRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPredictionRuleAccess().getOutputsDataDescriptionCrossReference_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
            	    ruleStringOrId();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            otherlv_4=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPredictionRuleAccess().getFromKeyword_3());
              		
            }
            // InternalMachineLearningLanguage.g:651:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:652:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:652:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:653:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPredictionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPredictionRuleAccess().getInputsDataDescriptionCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_11);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:670:3: (otherlv_6= ',' ( ( ruleStringOrId ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==16) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:671:4: otherlv_6= ',' ( ( ruleStringOrId ) )
            	    {
            	    otherlv_6=(Token)match(input,16,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getPredictionRuleAccess().getCommaKeyword_5_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:675:4: ( ( ruleStringOrId ) )
            	    // InternalMachineLearningLanguage.g:676:5: ( ruleStringOrId )
            	    {
            	    // InternalMachineLearningLanguage.g:676:5: ( ruleStringOrId )
            	    // InternalMachineLearningLanguage.g:677:6: ruleStringOrId
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getPredictionRuleRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPredictionRuleAccess().getInputsDataDescriptionCrossReference_5_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    ruleStringOrId();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            otherlv_8=(Token)match(input,18,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getPredictionRuleAccess().getUsingKeyword_6());
              		
            }
            // InternalMachineLearningLanguage.g:699:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:700:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:700:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:701:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPredictionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPredictionRuleAccess().getDefinitionSurrogateDefinitionCrossReference_7_0());
              				
            }
            pushFollow(FOLLOW_23);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_10=(Token)match(input,26,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getPredictionRuleAccess().getMeasureKeyword_8());
              		
            }
            // InternalMachineLearningLanguage.g:722:3: ( (lv_quality_11_0= ruleBlockStatementRule ) )
            // InternalMachineLearningLanguage.g:723:4: (lv_quality_11_0= ruleBlockStatementRule )
            {
            // InternalMachineLearningLanguage.g:723:4: (lv_quality_11_0= ruleBlockStatementRule )
            // InternalMachineLearningLanguage.g:724:5: lv_quality_11_0= ruleBlockStatementRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPredictionRuleAccess().getQualityBlockStatementRuleParserRuleCall_9_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_quality_11_0=ruleBlockStatementRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPredictionRuleRule());
              					}
              					set(
              						current,
              						"quality",
              						lv_quality_11_0,
              						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.BlockStatementRule");
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
    // $ANTLR end "rulePredictionRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalMachineLearningLanguage.g:745:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalMachineLearningLanguage.g:745:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalMachineLearningLanguage.g:746:2: iv_ruleStatementRule= ruleStatementRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatementRule=ruleStatementRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatementRule; 
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
    // $ANTLR end "entryRuleStatementRule"


    // $ANTLR start "ruleStatementRule"
    // InternalMachineLearningLanguage.g:752:1: ruleStatementRule returns [EObject current=null] : (this_CallStatementRule_0= ruleCallStatementRule | this_BlockStatementRule_1= ruleBlockStatementRule ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallStatementRule_0 = null;

        EObject this_BlockStatementRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:758:2: ( (this_CallStatementRule_0= ruleCallStatementRule | this_BlockStatementRule_1= ruleBlockStatementRule ) )
            // InternalMachineLearningLanguage.g:759:2: (this_CallStatementRule_0= ruleCallStatementRule | this_BlockStatementRule_1= ruleBlockStatementRule )
            {
            // InternalMachineLearningLanguage.g:759:2: (this_CallStatementRule_0= ruleCallStatementRule | this_BlockStatementRule_1= ruleBlockStatementRule )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_QUOTED_ID && LA14_0<=RULE_ID)) ) {
                alt14=1;
            }
            else if ( (LA14_0==27) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalMachineLearningLanguage.g:760:3: this_CallStatementRule_0= ruleCallStatementRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementRuleAccess().getCallStatementRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CallStatementRule_0=ruleCallStatementRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CallStatementRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:772:3: this_BlockStatementRule_1= ruleBlockStatementRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementRuleAccess().getBlockStatementRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BlockStatementRule_1=ruleBlockStatementRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockStatementRule_1;
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
    // $ANTLR end "ruleStatementRule"


    // $ANTLR start "entryRuleBlockStatementRule"
    // InternalMachineLearningLanguage.g:787:1: entryRuleBlockStatementRule returns [EObject current=null] : iv_ruleBlockStatementRule= ruleBlockStatementRule EOF ;
    public final EObject entryRuleBlockStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockStatementRule = null;


        try {
            // InternalMachineLearningLanguage.g:787:59: (iv_ruleBlockStatementRule= ruleBlockStatementRule EOF )
            // InternalMachineLearningLanguage.g:788:2: iv_ruleBlockStatementRule= ruleBlockStatementRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockStatementRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlockStatementRule=ruleBlockStatementRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockStatementRule; 
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
    // $ANTLR end "entryRuleBlockStatementRule"


    // $ANTLR start "ruleBlockStatementRule"
    // InternalMachineLearningLanguage.g:794:1: ruleBlockStatementRule returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlockStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:800:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= '}' ) )
            // InternalMachineLearningLanguage.g:801:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= '}' )
            {
            // InternalMachineLearningLanguage.g:801:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= '}' )
            // InternalMachineLearningLanguage.g:802:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= '}'
            {
            // InternalMachineLearningLanguage.g:802:3: ()
            // InternalMachineLearningLanguage.g:803:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockStatementRuleAccess().getBlockStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,27,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockStatementRuleAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:816:3: ( (lv_statements_2_0= ruleStatementRule ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_QUOTED_ID && LA15_0<=RULE_ID)||LA15_0==27) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:817:4: (lv_statements_2_0= ruleStatementRule )
            	    {
            	    // InternalMachineLearningLanguage.g:817:4: (lv_statements_2_0= ruleStatementRule )
            	    // InternalMachineLearningLanguage.g:818:5: lv_statements_2_0= ruleStatementRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBlockStatementRuleAccess().getStatementsStatementRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_statements_2_0=ruleStatementRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBlockStatementRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.StatementRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBlockStatementRuleAccess().getRightCurlyBracketKeyword_3());
              		
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
    // $ANTLR end "ruleBlockStatementRule"


    // $ANTLR start "entryRuleCallStatementRule"
    // InternalMachineLearningLanguage.g:843:1: entryRuleCallStatementRule returns [EObject current=null] : iv_ruleCallStatementRule= ruleCallStatementRule EOF ;
    public final EObject entryRuleCallStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallStatementRule = null;


        try {
            // InternalMachineLearningLanguage.g:843:58: (iv_ruleCallStatementRule= ruleCallStatementRule EOF )
            // InternalMachineLearningLanguage.g:844:2: iv_ruleCallStatementRule= ruleCallStatementRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallStatementRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCallStatementRule=ruleCallStatementRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallStatementRule; 
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
    // $ANTLR end "entryRuleCallStatementRule"


    // $ANTLR start "ruleCallStatementRule"
    // InternalMachineLearningLanguage.g:850:1: ruleCallStatementRule returns [EObject current=null] : ( ( (lv_call_0_0= ruleCallRule ) ) otherlv_1= ';' ) ;
    public final EObject ruleCallStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_call_0_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:856:2: ( ( ( (lv_call_0_0= ruleCallRule ) ) otherlv_1= ';' ) )
            // InternalMachineLearningLanguage.g:857:2: ( ( (lv_call_0_0= ruleCallRule ) ) otherlv_1= ';' )
            {
            // InternalMachineLearningLanguage.g:857:2: ( ( (lv_call_0_0= ruleCallRule ) ) otherlv_1= ';' )
            // InternalMachineLearningLanguage.g:858:3: ( (lv_call_0_0= ruleCallRule ) ) otherlv_1= ';'
            {
            // InternalMachineLearningLanguage.g:858:3: ( (lv_call_0_0= ruleCallRule ) )
            // InternalMachineLearningLanguage.g:859:4: (lv_call_0_0= ruleCallRule )
            {
            // InternalMachineLearningLanguage.g:859:4: (lv_call_0_0= ruleCallRule )
            // InternalMachineLearningLanguage.g:860:5: lv_call_0_0= ruleCallRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallStatementRuleAccess().getCallCallRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_7);
            lv_call_0_0=ruleCallRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCallStatementRuleRule());
              					}
              					set(
              						current,
              						"call",
              						lv_call_0_0,
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.CallRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallStatementRuleAccess().getSemicolonKeyword_1());
              		
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
    // $ANTLR end "ruleCallStatementRule"


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalMachineLearningLanguage.g:885:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalMachineLearningLanguage.g:885:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalMachineLearningLanguage.g:886:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
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
    // InternalMachineLearningLanguage.g:892:1: ruleFunctionNameRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:898:2: ( ( ( ruleStringOrId ) ) )
            // InternalMachineLearningLanguage.g:899:2: ( ( ruleStringOrId ) )
            {
            // InternalMachineLearningLanguage.g:899:2: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:900:3: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:900:3: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:901:4: ruleStringOrId
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
            ruleStringOrId();

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


    // $ANTLR start "entryRuleInstanceRule"
    // InternalMachineLearningLanguage.g:921:1: entryRuleInstanceRule returns [EObject current=null] : iv_ruleInstanceRule= ruleInstanceRule EOF ;
    public final EObject entryRuleInstanceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceRule = null;


        try {
            // InternalMachineLearningLanguage.g:921:53: (iv_ruleInstanceRule= ruleInstanceRule EOF )
            // InternalMachineLearningLanguage.g:922:2: iv_ruleInstanceRule= ruleInstanceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstanceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstanceRule=ruleInstanceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstanceRule; 
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
    // $ANTLR end "entryRuleInstanceRule"


    // $ANTLR start "ruleInstanceRule"
    // InternalMachineLearningLanguage.g:928:1: ruleInstanceRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleInstanceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:934:2: ( ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) )
            // InternalMachineLearningLanguage.g:935:2: ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            {
            // InternalMachineLearningLanguage.g:935:2: ( ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            // InternalMachineLearningLanguage.g:936:3: ( ( ruleStringOrId ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            {
            // InternalMachineLearningLanguage.g:936:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:937:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:937:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:938:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInstanceRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInstanceRuleAccess().getNameTypeDefinitionCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_26);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:955:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMachineLearningLanguage.g:956:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInstanceRuleAccess().getLeftCurlyBracketKeyword_1_0());
                      			
                    }
                    // InternalMachineLearningLanguage.g:960:4: ( (lv_attributes_2_0= ruleAttributeRule ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_STRING||(LA16_0>=RULE_QUOTED_ID && LA16_0<=RULE_ID)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:961:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:961:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    // InternalMachineLearningLanguage.g:962:6: lv_attributes_2_0= ruleAttributeRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getInstanceRuleAccess().getAttributesAttributeRuleParserRuleCall_1_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_27);
                    	    lv_attributes_2_0=ruleAttributeRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getInstanceRuleAccess().getRightCurlyBracketKeyword_1_2());
                      			
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
    // $ANTLR end "ruleInstanceRule"


    // $ANTLR start "entryRuleAttributeRule"
    // InternalMachineLearningLanguage.g:988:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalMachineLearningLanguage.g:988:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalMachineLearningLanguage.g:989:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalMachineLearningLanguage.g:995:1: ruleAttributeRule returns [EObject current=null] : ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1001:2: ( ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) )
            // InternalMachineLearningLanguage.g:1002:2: ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            {
            // InternalMachineLearningLanguage.g:1002:2: ( ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            // InternalMachineLearningLanguage.g:1003:3: ( (lv_name_0_0= ruleNameOrMiscRule ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';'
            {
            // InternalMachineLearningLanguage.g:1003:3: ( (lv_name_0_0= ruleNameOrMiscRule ) )
            // InternalMachineLearningLanguage.g:1004:4: (lv_name_0_0= ruleNameOrMiscRule )
            {
            // InternalMachineLearningLanguage.g:1004:4: (lv_name_0_0= ruleNameOrMiscRule )
            // InternalMachineLearningLanguage.g:1005:5: lv_name_0_0= ruleNameOrMiscRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getNameNameOrMiscRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_name_0_0=ruleNameOrMiscRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            otherlv_1=(Token)match(input,29,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:1026:3: ( (lv_value_2_0= ruleValueRule ) )
            // InternalMachineLearningLanguage.g:1027:4: (lv_value_2_0= ruleValueRule )
            {
            // InternalMachineLearningLanguage.g:1027:4: (lv_value_2_0= ruleValueRule )
            // InternalMachineLearningLanguage.g:1028:5: lv_value_2_0= ruleValueRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueValueRuleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_7);
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
              						"de.evoal.languages.model.instance.dsl.InstanceLanguage.ValueRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleNameOrMiscRule"
    // InternalMachineLearningLanguage.g:1053:1: entryRuleNameOrMiscRule returns [EObject current=null] : iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF ;
    public final EObject entryRuleNameOrMiscRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrMiscRule = null;


        try {
            // InternalMachineLearningLanguage.g:1053:55: (iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF )
            // InternalMachineLearningLanguage.g:1054:2: iv_ruleNameOrMiscRule= ruleNameOrMiscRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameOrMiscRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNameOrMiscRule=ruleNameOrMiscRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameOrMiscRule; 
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
    // $ANTLR end "entryRuleNameOrMiscRule"


    // $ANTLR start "ruleNameOrMiscRule"
    // InternalMachineLearningLanguage.g:1060:1: ruleNameOrMiscRule returns [EObject current=null] : (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule ) ;
    public final EObject ruleNameOrMiscRule() throws RecognitionException {
        EObject current = null;

        EObject this_NameRule_0 = null;

        EObject this_MiscRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1066:2: ( (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule ) )
            // InternalMachineLearningLanguage.g:1067:2: (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule )
            {
            // InternalMachineLearningLanguage.g:1067:2: (this_NameRule_0= ruleNameRule | this_MiscRule_1= ruleMiscRule )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_QUOTED_ID && LA18_0<=RULE_ID)) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_STRING) ) {
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
                    // InternalMachineLearningLanguage.g:1068:3: this_NameRule_0= ruleNameRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNameOrMiscRuleAccess().getNameRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NameRule_0=ruleNameRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NameRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:1080:3: this_MiscRule_1= ruleMiscRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNameOrMiscRuleAccess().getMiscRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_MiscRule_1=ruleMiscRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_MiscRule_1;
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
    // $ANTLR end "ruleNameOrMiscRule"


    // $ANTLR start "entryRuleNameRule"
    // InternalMachineLearningLanguage.g:1095:1: entryRuleNameRule returns [EObject current=null] : iv_ruleNameRule= ruleNameRule EOF ;
    public final EObject entryRuleNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameRule = null;


        try {
            // InternalMachineLearningLanguage.g:1095:49: (iv_ruleNameRule= ruleNameRule EOF )
            // InternalMachineLearningLanguage.g:1096:2: iv_ruleNameRule= ruleNameRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNameRule=ruleNameRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameRule; 
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
    // $ANTLR end "entryRuleNameRule"


    // $ANTLR start "ruleNameRule"
    // InternalMachineLearningLanguage.g:1102:1: ruleNameRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1108:2: ( ( ( ruleStringOrId ) ) )
            // InternalMachineLearningLanguage.g:1109:2: ( ( ruleStringOrId ) )
            {
            // InternalMachineLearningLanguage.g:1109:2: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:1110:3: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:1110:3: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:1111:4: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getNameRuleRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getNameRuleAccess().getNameNamedAttributeDefinitionCrossReference_0());
              			
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

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
    // $ANTLR end "ruleNameRule"


    // $ANTLR start "entryRuleMiscRule"
    // InternalMachineLearningLanguage.g:1131:1: entryRuleMiscRule returns [EObject current=null] : iv_ruleMiscRule= ruleMiscRule EOF ;
    public final EObject entryRuleMiscRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMiscRule = null;


        try {
            // InternalMachineLearningLanguage.g:1131:49: (iv_ruleMiscRule= ruleMiscRule EOF )
            // InternalMachineLearningLanguage.g:1132:2: iv_ruleMiscRule= ruleMiscRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMiscRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMiscRule=ruleMiscRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMiscRule; 
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
    // $ANTLR end "entryRuleMiscRule"


    // $ANTLR start "ruleMiscRule"
    // InternalMachineLearningLanguage.g:1138:1: ruleMiscRule returns [EObject current=null] : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final EObject ruleMiscRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1144:2: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // InternalMachineLearningLanguage.g:1145:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // InternalMachineLearningLanguage.g:1145:2: ( (lv_name_0_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:1146:3: (lv_name_0_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:1146:3: (lv_name_0_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:1147:4: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_name_0_0, grammarAccess.getMiscRuleAccess().getNameSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleMiscRule"


    // $ANTLR start "entryRuleValueRule"
    // InternalMachineLearningLanguage.g:1166:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // InternalMachineLearningLanguage.g:1166:50: (iv_ruleValueRule= ruleValueRule EOF )
            // InternalMachineLearningLanguage.g:1167:2: iv_ruleValueRule= ruleValueRule EOF
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
    // InternalMachineLearningLanguage.g:1173:1: ruleValueRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_DataReferenceRule_1 = null;

        EObject this_InstanceRule_2 = null;

        EObject this_LiteralValueRule_3 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1179:2: ( (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule ) )
            // InternalMachineLearningLanguage.g:1180:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            {
            // InternalMachineLearningLanguage.g:1180:2: (this_ArrayRule_0= ruleArrayRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_InstanceRule_2= ruleInstanceRule | this_LiteralValueRule_3= ruleLiteralValueRule )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt19=1;
                }
                break;
            case 32:
                {
                alt19=2;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt19=3;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case 41:
            case 42:
                {
                alt19=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1181:3: this_ArrayRule_0= ruleArrayRule
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
                    // InternalMachineLearningLanguage.g:1193:3: this_DataReferenceRule_1= ruleDataReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueRuleAccess().getDataReferenceRuleParserRuleCall_1());
                      		
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
                case 3 :
                    // InternalMachineLearningLanguage.g:1205:3: this_InstanceRule_2= ruleInstanceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueRuleAccess().getInstanceRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_InstanceRule_2=ruleInstanceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_InstanceRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMachineLearningLanguage.g:1217:3: this_LiteralValueRule_3= ruleLiteralValueRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueRuleAccess().getLiteralValueRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralValueRule_3=ruleLiteralValueRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralValueRule_3;
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
    // InternalMachineLearningLanguage.g:1232:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalMachineLearningLanguage.g:1232:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalMachineLearningLanguage.g:1233:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalMachineLearningLanguage.g:1239:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1245:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) )
            // InternalMachineLearningLanguage.g:1246:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalMachineLearningLanguage.g:1246:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            // InternalMachineLearningLanguage.g:1247:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']'
            {
            // InternalMachineLearningLanguage.g:1247:3: ()
            // InternalMachineLearningLanguage.g:1248:4: 
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

            otherlv_1=(Token)match(input,30,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:1261:3: ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_STRING && LA21_0<=RULE_ID)||LA21_0==30||LA21_0==32||(LA21_0>=41 && LA21_0<=42)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1262:4: ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    {
                    // InternalMachineLearningLanguage.g:1262:4: ( (lv_values_2_0= ruleValueRule ) )
                    // InternalMachineLearningLanguage.g:1263:5: (lv_values_2_0= ruleValueRule )
                    {
                    // InternalMachineLearningLanguage.g:1263:5: (lv_values_2_0= ruleValueRule )
                    // InternalMachineLearningLanguage.g:1264:6: lv_values_2_0= ruleValueRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
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
                      							"de.evoal.languages.model.instance.dsl.InstanceLanguage.ValueRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMachineLearningLanguage.g:1281:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==16) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:1282:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FOLLOW_29); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMachineLearningLanguage.g:1286:5: ( (lv_values_4_0= ruleValueRule ) )
                    	    // InternalMachineLearningLanguage.g:1287:6: (lv_values_4_0= ruleValueRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:1287:6: (lv_values_4_0= ruleValueRule )
                    	    // InternalMachineLearningLanguage.g:1288:7: lv_values_4_0= ruleValueRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_31);
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
                    	      								"de.evoal.languages.model.instance.dsl.InstanceLanguage.ValueRule");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

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

            otherlv_5=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleLiteralValueRule"
    // InternalMachineLearningLanguage.g:1315:1: entryRuleLiteralValueRule returns [EObject current=null] : iv_ruleLiteralValueRule= ruleLiteralValueRule EOF ;
    public final EObject entryRuleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValueRule = null;


        try {
            // InternalMachineLearningLanguage.g:1315:57: (iv_ruleLiteralValueRule= ruleLiteralValueRule EOF )
            // InternalMachineLearningLanguage.g:1316:2: iv_ruleLiteralValueRule= ruleLiteralValueRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralValueRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralValueRule=ruleLiteralValueRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralValueRule; 
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
    // $ANTLR end "entryRuleLiteralValueRule"


    // $ANTLR start "ruleLiteralValueRule"
    // InternalMachineLearningLanguage.g:1322:1: ruleLiteralValueRule returns [EObject current=null] : ( (lv_literal_0_0= ruleLiteralRule ) ) ;
    public final EObject ruleLiteralValueRule() throws RecognitionException {
        EObject current = null;

        EObject lv_literal_0_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1328:2: ( ( (lv_literal_0_0= ruleLiteralRule ) ) )
            // InternalMachineLearningLanguage.g:1329:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            {
            // InternalMachineLearningLanguage.g:1329:2: ( (lv_literal_0_0= ruleLiteralRule ) )
            // InternalMachineLearningLanguage.g:1330:3: (lv_literal_0_0= ruleLiteralRule )
            {
            // InternalMachineLearningLanguage.g:1330:3: (lv_literal_0_0= ruleLiteralRule )
            // InternalMachineLearningLanguage.g:1331:4: lv_literal_0_0= ruleLiteralRule
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getLiteralValueRuleAccess().getLiteralLiteralRuleParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_literal_0_0=ruleLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleLiteralValueRule"


    // $ANTLR start "entryRuleDataReferenceRule"
    // InternalMachineLearningLanguage.g:1351:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:1351:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalMachineLearningLanguage.g:1352:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:1358:1: ruleDataReferenceRule returns [EObject current=null] : ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1364:2: ( ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) ) )
            // InternalMachineLearningLanguage.g:1365:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            {
            // InternalMachineLearningLanguage.g:1365:2: ( () otherlv_1= 'data' ( ( ruleStringOrId ) ) )
            // InternalMachineLearningLanguage.g:1366:3: () otherlv_1= 'data' ( ( ruleStringOrId ) )
            {
            // InternalMachineLearningLanguage.g:1366:3: ()
            // InternalMachineLearningLanguage.g:1367:4: 
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

            otherlv_1=(Token)match(input,32,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDataReferenceRuleAccess().getDataKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:1380:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:1381:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:1381:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:1382:5: ruleStringOrId
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
            ruleStringOrId();

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
    // InternalMachineLearningLanguage.g:1403:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1403:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1404:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1410:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1416:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalMachineLearningLanguage.g:1417:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalMachineLearningLanguage.g:1431:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1431:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1432:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1438:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1444:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:1445:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:1445:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:1446:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:1446:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalMachineLearningLanguage.g:1447:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1447:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalMachineLearningLanguage.g:1448:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_32);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.XorExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:1465:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==33) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1466:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_33); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:1470:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1471:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1471:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalMachineLearningLanguage.g:1472:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
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
            	      							"de.evoal.languages.model.el.dsl.ExpressionLanguage.XorExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

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
    // InternalMachineLearningLanguage.g:1494:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1494:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1495:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1501:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1507:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:1508:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:1508:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:1509:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:1509:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalMachineLearningLanguage.g:1510:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1510:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalMachineLearningLanguage.g:1511:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_34);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.AndExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:1528:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1529:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,34,FOLLOW_33); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:1533:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1534:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1534:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalMachineLearningLanguage.g:1535:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
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
            	      							"de.evoal.languages.model.el.dsl.ExpressionLanguage.AndExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

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
    // InternalMachineLearningLanguage.g:1557:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1557:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1558:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1564:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1570:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:1571:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:1571:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:1572:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:1572:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalMachineLearningLanguage.g:1573:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1573:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalMachineLearningLanguage.g:1574:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.NotExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:1591:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==35) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1592:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_33); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:1596:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1597:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1597:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalMachineLearningLanguage.g:1598:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
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
            	      							"de.evoal.languages.model.el.dsl.ExpressionLanguage.NotExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

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
    // InternalMachineLearningLanguage.g:1620:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1620:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1621:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1627:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1633:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalMachineLearningLanguage.g:1634:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalMachineLearningLanguage.g:1634:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalMachineLearningLanguage.g:1635:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalMachineLearningLanguage.g:1635:3: ( (lv_negated_0_0= '!' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==36) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1636:4: (lv_negated_0_0= '!' )
                    {
                    // InternalMachineLearningLanguage.g:1636:4: (lv_negated_0_0= '!' )
                    // InternalMachineLearningLanguage.g:1637:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,36,FOLLOW_33); if (state.failed) return current;
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

            // InternalMachineLearningLanguage.g:1649:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalMachineLearningLanguage.g:1650:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1650:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalMachineLearningLanguage.g:1651:5: lv_operand_1_0= ruleComparisonExpressionRule
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.ComparisonExpressionRule");
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
    // InternalMachineLearningLanguage.g:1672:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1672:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1673:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1679:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1685:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalMachineLearningLanguage.g:1686:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalMachineLearningLanguage.g:1686:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalMachineLearningLanguage.g:1687:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalMachineLearningLanguage.g:1687:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalMachineLearningLanguage.g:1688:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1688:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalMachineLearningLanguage.g:1689:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_36);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.AddOrSubtractExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:1706:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=44 && LA26_0<=49)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1707:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1707:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalMachineLearningLanguage.g:1708:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_36);
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
            	      						"de.evoal.languages.model.el.dsl.ExpressionLanguage.PartialComparisonExpressionRule");
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
    // InternalMachineLearningLanguage.g:1729:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1729:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1730:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1736:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1742:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalMachineLearningLanguage.g:1743:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalMachineLearningLanguage.g:1743:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalMachineLearningLanguage.g:1744:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalMachineLearningLanguage.g:1744:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalMachineLearningLanguage.g:1745:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalMachineLearningLanguage.g:1745:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalMachineLearningLanguage.g:1746:5: lv_operator_0_0= ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_33);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.ComparisonOperatorRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:1763:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalMachineLearningLanguage.g:1764:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1764:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalMachineLearningLanguage.g:1765:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.AddOrSubtractExpressionRule");
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
    // InternalMachineLearningLanguage.g:1786:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1786:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1787:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1793:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1799:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:1800:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:1800:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:1801:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:1801:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalMachineLearningLanguage.g:1802:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1802:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalMachineLearningLanguage.g:1803:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_37);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.MultiplyDivideModuloExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:1820:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=50 && LA27_0<=51)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1821:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalMachineLearningLanguage.g:1821:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalMachineLearningLanguage.g:1822:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1822:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalMachineLearningLanguage.g:1823:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
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
            	      							"de.evoal.languages.model.el.dsl.ExpressionLanguage.AddOrSubtractOperatorRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalMachineLearningLanguage.g:1840:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1841:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1841:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalMachineLearningLanguage.g:1842:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
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
            	      							"de.evoal.languages.model.el.dsl.ExpressionLanguage.MultiplyDivideModuloExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

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
    // InternalMachineLearningLanguage.g:1864:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1864:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1865:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1871:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1877:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:1878:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:1878:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:1879:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:1879:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalMachineLearningLanguage.g:1880:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1880:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalMachineLearningLanguage.g:1881:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_38);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.PowerOfExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:1898:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=52 && LA28_0<=54)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1899:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalMachineLearningLanguage.g:1899:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalMachineLearningLanguage.g:1900:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1900:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalMachineLearningLanguage.g:1901:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
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
            	      							"de.evoal.languages.model.el.dsl.ExpressionLanguage.MultiplyDivideModuloOperatorRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalMachineLearningLanguage.g:1918:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1919:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1919:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalMachineLearningLanguage.g:1920:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
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
            	      							"de.evoal.languages.model.el.dsl.ExpressionLanguage.PowerOfExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


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
    // $ANTLR end "ruleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "entryRulePowerOfExpressionRule"
    // InternalMachineLearningLanguage.g:1942:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1942:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1943:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1949:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1955:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalMachineLearningLanguage.g:1956:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalMachineLearningLanguage.g:1956:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalMachineLearningLanguage.g:1957:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalMachineLearningLanguage.g:1957:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalMachineLearningLanguage.g:1958:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1958:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalMachineLearningLanguage.g:1959:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_39);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.UnaryAddOrSubtractExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:1976:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==37) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1977:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                      			
                    }
                    // InternalMachineLearningLanguage.g:1981:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalMachineLearningLanguage.g:1982:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:1982:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalMachineLearningLanguage.g:1983:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
                      							"de.evoal.languages.model.el.dsl.ExpressionLanguage.PowerOfExpressionRule");
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
    // InternalMachineLearningLanguage.g:2005:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2005:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2006:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2012:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2018:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) )
            // InternalMachineLearningLanguage.g:2019:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            {
            // InternalMachineLearningLanguage.g:2019:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            // InternalMachineLearningLanguage.g:2020:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            {
            // InternalMachineLearningLanguage.g:2020:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=50 && LA30_0<=51)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:2021:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2021:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalMachineLearningLanguage.g:2022:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_33);
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
            	      						"de.evoal.languages.model.el.dsl.ExpressionLanguage.AddOrSubtractOperatorRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            // InternalMachineLearningLanguage.g:2039:3: ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            // InternalMachineLearningLanguage.g:2040:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            {
            // InternalMachineLearningLanguage.g:2040:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            // InternalMachineLearningLanguage.g:2041:5: lv_subExpression_1_0= ruleLiteralOrReferenceRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionLiteralOrReferenceRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_subExpression_1_0=ruleLiteralOrReferenceRule();

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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.LiteralOrReferenceRule");
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


    // $ANTLR start "entryRuleLiteralOrReferenceRule"
    // InternalMachineLearningLanguage.g:2062:1: entryRuleLiteralOrReferenceRule returns [EObject current=null] : iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF ;
    public final EObject entryRuleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:2062:63: (iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF )
            // InternalMachineLearningLanguage.g:2063:2: iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralOrReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralOrReferenceRule=ruleLiteralOrReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralOrReferenceRule; 
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
    // $ANTLR end "entryRuleLiteralOrReferenceRule"


    // $ANTLR start "ruleLiteralOrReferenceRule"
    // InternalMachineLearningLanguage.g:2069:1: ruleLiteralOrReferenceRule returns [EObject current=null] : (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) ;
    public final EObject ruleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallRule_0 = null;

        EObject this_LiteralRule_1 = null;

        EObject this_ParanthesesRule_2 = null;

        EObject this_ValueReferenceRule_3 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2075:2: ( (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) )
            // InternalMachineLearningLanguage.g:2076:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            {
            // InternalMachineLearningLanguage.g:2076:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            int alt31=4;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt31=1;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case 41:
            case 42:
                {
                alt31=2;
                }
                break;
            case 38:
                {
                alt31=3;
                }
                break;
            case 40:
                {
                alt31=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2077:3: this_CallRule_0= ruleCallRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralOrReferenceRuleAccess().getCallRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CallRule_0=ruleCallRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CallRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:2089:3: this_LiteralRule_1= ruleLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralOrReferenceRuleAccess().getLiteralRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralRule_1=ruleLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMachineLearningLanguage.g:2101:3: this_ParanthesesRule_2= ruleParanthesesRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralOrReferenceRuleAccess().getParanthesesRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParanthesesRule_2=ruleParanthesesRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParanthesesRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMachineLearningLanguage.g:2113:3: this_ValueReferenceRule_3= ruleValueReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralOrReferenceRuleAccess().getValueReferenceRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ValueReferenceRule_3=ruleValueReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValueReferenceRule_3;
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
    // $ANTLR end "ruleLiteralOrReferenceRule"


    // $ANTLR start "entryRuleParanthesesRule"
    // InternalMachineLearningLanguage.g:2128:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalMachineLearningLanguage.g:2128:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalMachineLearningLanguage.g:2129:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalMachineLearningLanguage.g:2135:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2141:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalMachineLearningLanguage.g:2142:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalMachineLearningLanguage.g:2142:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalMachineLearningLanguage.g:2143:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:2147:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalMachineLearningLanguage.g:2148:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2148:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalMachineLearningLanguage.g:2149:5: lv_subExpression_1_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_40);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.ExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2174:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalMachineLearningLanguage.g:2174:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalMachineLearningLanguage.g:2175:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalMachineLearningLanguage.g:2181:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalMachineLearningLanguage.g:2187:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalMachineLearningLanguage.g:2188:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalMachineLearningLanguage.g:2188:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalMachineLearningLanguage.g:2189:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalMachineLearningLanguage.g:2189:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalMachineLearningLanguage.g:2190:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalMachineLearningLanguage.g:2190:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalMachineLearningLanguage.g:2191:5: lv_function_0_0= ruleFunctionNameRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_41);
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
              						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.FunctionNameRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:2212:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_ID)||LA33_0==36||LA33_0==38||(LA33_0>=40 && LA33_0<=42)||(LA33_0>=50 && LA33_0<=51)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2213:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalMachineLearningLanguage.g:2213:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalMachineLearningLanguage.g:2214:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:2214:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalMachineLearningLanguage.g:2215:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
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
                      							"de.evoal.languages.model.el.dsl.ExpressionLanguage.ExpressionRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMachineLearningLanguage.g:2232:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==16) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:2233:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FOLLOW_33); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMachineLearningLanguage.g:2237:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalMachineLearningLanguage.g:2238:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:2238:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalMachineLearningLanguage.g:2239:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_43);
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
                    	      								"de.evoal.languages.model.el.dsl.ExpressionLanguage.ExpressionRule");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleValueReferenceRule"
    // InternalMachineLearningLanguage.g:2266:1: entryRuleValueReferenceRule returns [EObject current=null] : iv_ruleValueReferenceRule= ruleValueReferenceRule EOF ;
    public final EObject entryRuleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:2266:59: (iv_ruleValueReferenceRule= ruleValueReferenceRule EOF )
            // InternalMachineLearningLanguage.g:2267:2: iv_ruleValueReferenceRule= ruleValueReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValueReferenceRule=ruleValueReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueReferenceRule; 
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
    // $ANTLR end "entryRuleValueReferenceRule"


    // $ANTLR start "ruleValueReferenceRule"
    // InternalMachineLearningLanguage.g:2273:1: ruleValueReferenceRule returns [EObject current=null] : ( () otherlv_1= 'value' ) ;
    public final EObject ruleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2279:2: ( ( () otherlv_1= 'value' ) )
            // InternalMachineLearningLanguage.g:2280:2: ( () otherlv_1= 'value' )
            {
            // InternalMachineLearningLanguage.g:2280:2: ( () otherlv_1= 'value' )
            // InternalMachineLearningLanguage.g:2281:3: () otherlv_1= 'value'
            {
            // InternalMachineLearningLanguage.g:2281:3: ()
            // InternalMachineLearningLanguage.g:2282:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getValueReferenceRuleAccess().getValueReferenceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getValueReferenceRuleAccess().getValueKeyword_1());
              		
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
    // $ANTLR end "ruleValueReferenceRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalMachineLearningLanguage.g:2299:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2299:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2300:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2306:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2312:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) )
            // InternalMachineLearningLanguage.g:2313:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            {
            // InternalMachineLearningLanguage.g:2313:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            int alt34=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt34=1;
                }
                break;
            case RULE_STRING:
                {
                alt34=2;
                }
                break;
            case 41:
            case 42:
                {
                alt34=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2314:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalMachineLearningLanguage.g:2326:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalMachineLearningLanguage.g:2338:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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


    // $ANTLR start "entryRuleNumberLiteralRule"
    // InternalMachineLearningLanguage.g:2353:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2353:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2354:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2360:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2366:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalMachineLearningLanguage.g:2367:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalMachineLearningLanguage.g:2367:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_INT) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==43) ) {
                    alt35=1;
                }
                else if ( (LA35_1==EOF||LA35_1==13||LA35_1==16||LA35_1==31||(LA35_1>=33 && LA35_1<=35)||LA35_1==37||LA35_1==39||(LA35_1>=44 && LA35_1<=54)) ) {
                    alt35=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2368:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
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
                    // InternalMachineLearningLanguage.g:2380:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalMachineLearningLanguage.g:2395:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2395:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2396:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2402:1: ruleDoubleLiteralRule returns [EObject current=null] : ( (lv_value_0_0= ruleDOUBLE ) ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2408:2: ( ( (lv_value_0_0= ruleDOUBLE ) ) )
            // InternalMachineLearningLanguage.g:2409:2: ( (lv_value_0_0= ruleDOUBLE ) )
            {
            // InternalMachineLearningLanguage.g:2409:2: ( (lv_value_0_0= ruleDOUBLE ) )
            // InternalMachineLearningLanguage.g:2410:3: (lv_value_0_0= ruleDOUBLE )
            {
            // InternalMachineLearningLanguage.g:2410:3: (lv_value_0_0= ruleDOUBLE )
            // InternalMachineLearningLanguage.g:2411:4: lv_value_0_0= ruleDOUBLE
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getDoubleLiteralRuleAccess().getValueDOUBLEParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDOUBLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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
    // InternalMachineLearningLanguage.g:2431:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2431:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2432:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2438:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2444:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalMachineLearningLanguage.g:2445:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalMachineLearningLanguage.g:2445:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalMachineLearningLanguage.g:2446:3: (lv_value_0_0= RULE_INT )
            {
            // InternalMachineLearningLanguage.g:2446:3: (lv_value_0_0= RULE_INT )
            // InternalMachineLearningLanguage.g:2447:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getIntegerLiteralRuleAccess().getValueINTTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

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
    // InternalMachineLearningLanguage.g:2466:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2466:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2467:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2473:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2479:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalMachineLearningLanguage.g:2480:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalMachineLearningLanguage.g:2480:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:2481:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:2481:3: (lv_value_0_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:2482:4: lv_value_0_0= RULE_STRING
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
              					"de.evoal.languages.model.el.dsl.ExpressionLanguage.STRING");
              			
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
    // InternalMachineLearningLanguage.g:2501:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2501:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2502:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2508:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2514:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalMachineLearningLanguage.g:2515:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalMachineLearningLanguage.g:2515:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalMachineLearningLanguage.g:2516:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalMachineLearningLanguage.g:2516:3: ()
            // InternalMachineLearningLanguage.g:2517:4: 
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

            // InternalMachineLearningLanguage.g:2526:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==41) ) {
                alt36=1;
            }
            else if ( (LA36_0==42) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2527:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalMachineLearningLanguage.g:2527:4: ( (lv_value_1_0= 'true' ) )
                    // InternalMachineLearningLanguage.g:2528:5: (lv_value_1_0= 'true' )
                    {
                    // InternalMachineLearningLanguage.g:2528:5: (lv_value_1_0= 'true' )
                    // InternalMachineLearningLanguage.g:2529:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
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
                    // InternalMachineLearningLanguage.g:2542:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleStringOrId"
    // InternalMachineLearningLanguage.g:2551:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalMachineLearningLanguage.g:2551:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalMachineLearningLanguage.g:2552:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalMachineLearningLanguage.g:2558:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2564:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalMachineLearningLanguage.g:2565:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalMachineLearningLanguage.g:2565:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_QUOTED_ID) ) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_ID) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2566:3: this_QUOTED_ID_0= RULE_QUOTED_ID
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
                    // InternalMachineLearningLanguage.g:2574:3: this_ID_1= RULE_ID
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


    // $ANTLR start "entryRuleDOUBLE"
    // InternalMachineLearningLanguage.g:2585:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // InternalMachineLearningLanguage.g:2585:46: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // InternalMachineLearningLanguage.g:2586:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDOUBLERule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDOUBLE.getText(); 
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
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // InternalMachineLearningLanguage.g:2592:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2598:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalMachineLearningLanguage.g:2599:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalMachineLearningLanguage.g:2599:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalMachineLearningLanguage.g:2600:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_INT_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0());
              		
            }
            kw=(Token)match(input,43,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getDOUBLEAccess().getFullStopKeyword_1());
              		
            }
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_INT_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INT_2, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2());
              		
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
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalMachineLearningLanguage.g:2623:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalMachineLearningLanguage.g:2629:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalMachineLearningLanguage.g:2630:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalMachineLearningLanguage.g:2630:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt38=6;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt38=1;
                }
                break;
            case 45:
                {
                alt38=2;
                }
                break;
            case 46:
                {
                alt38=3;
                }
                break;
            case 47:
                {
                alt38=4;
                }
                break;
            case 48:
                {
                alt38=5;
                }
                break;
            case 49:
                {
                alt38=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2631:3: (enumLiteral_0= '>=' )
                    {
                    // InternalMachineLearningLanguage.g:2631:3: (enumLiteral_0= '>=' )
                    // InternalMachineLearningLanguage.g:2632:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:2639:3: (enumLiteral_1= '>' )
                    {
                    // InternalMachineLearningLanguage.g:2639:3: (enumLiteral_1= '>' )
                    // InternalMachineLearningLanguage.g:2640:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMachineLearningLanguage.g:2647:3: (enumLiteral_2= '=' )
                    {
                    // InternalMachineLearningLanguage.g:2647:3: (enumLiteral_2= '=' )
                    // InternalMachineLearningLanguage.g:2648:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMachineLearningLanguage.g:2655:3: (enumLiteral_3= '!=' )
                    {
                    // InternalMachineLearningLanguage.g:2655:3: (enumLiteral_3= '!=' )
                    // InternalMachineLearningLanguage.g:2656:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalMachineLearningLanguage.g:2663:3: (enumLiteral_4= '<' )
                    {
                    // InternalMachineLearningLanguage.g:2663:3: (enumLiteral_4= '<' )
                    // InternalMachineLearningLanguage.g:2664:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMachineLearningLanguage.g:2671:3: (enumLiteral_5= '<=' )
                    {
                    // InternalMachineLearningLanguage.g:2671:3: (enumLiteral_5= '<=' )
                    // InternalMachineLearningLanguage.g:2672:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2682:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2688:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalMachineLearningLanguage.g:2689:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalMachineLearningLanguage.g:2689:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==50) ) {
                alt39=1;
            }
            else if ( (LA39_0==51) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2690:3: (enumLiteral_0= '+' )
                    {
                    // InternalMachineLearningLanguage.g:2690:3: (enumLiteral_0= '+' )
                    // InternalMachineLearningLanguage.g:2691:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:2698:3: (enumLiteral_1= '-' )
                    {
                    // InternalMachineLearningLanguage.g:2698:3: (enumLiteral_1= '-' )
                    // InternalMachineLearningLanguage.g:2699:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2709:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2715:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalMachineLearningLanguage.g:2716:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalMachineLearningLanguage.g:2716:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt40=1;
                }
                break;
            case 53:
                {
                alt40=2;
                }
                break;
            case 54:
                {
                alt40=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2717:3: (enumLiteral_0= '*' )
                    {
                    // InternalMachineLearningLanguage.g:2717:3: (enumLiteral_0= '*' )
                    // InternalMachineLearningLanguage.g:2718:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:2725:3: (enumLiteral_1= '/' )
                    {
                    // InternalMachineLearningLanguage.g:2725:3: (enumLiteral_1= '/' )
                    // InternalMachineLearningLanguage.g:2726:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMachineLearningLanguage.g:2733:3: (enumLiteral_2= '%' )
                    {
                    // InternalMachineLearningLanguage.g:2733:3: (enumLiteral_2= '%' )
                    // InternalMachineLearningLanguage.g:2734:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001005002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000001004002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000110002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000000000000D2L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000000180000C0L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000000100000D0L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000601400000F0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00000601C00000F0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000080010000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000C0751400000F0L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0003F00000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x000C07D1400000F0L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000020L});

}
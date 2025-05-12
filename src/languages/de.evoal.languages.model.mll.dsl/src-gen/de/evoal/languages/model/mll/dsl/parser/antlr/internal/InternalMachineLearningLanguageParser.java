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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_DOUBLE", "RULE_INT", "RULE_QUOTED_ID", "RULE_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'{'", "'}'", "'function'", "'using'", "'model'", "'mapping'", "','", "'to'", "'with'", "'parameters'", "'predict'", "'from'", "'and'", "'measure'", "'store'", "'begin'", "'end'", "'('", "')'", "';'", "'for'", "'in'", "'['", "']'", "'increment'", "'by'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'data'", "':='", "'true'", "'false'", "'@'", "':'", "'literal'", "'instance'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'import'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
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
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_DOUBLE=5;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

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
        	return "MachineLearningModuleRule";
       	}

       	@Override
       	protected MachineLearningLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMachineLearningModuleRule"
    // InternalMachineLearningLanguage.g:72:1: entryRuleMachineLearningModuleRule returns [EObject current=null] : iv_ruleMachineLearningModuleRule= ruleMachineLearningModuleRule EOF ;
    public final EObject entryRuleMachineLearningModuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMachineLearningModuleRule = null;


        try {
            // InternalMachineLearningLanguage.g:72:66: (iv_ruleMachineLearningModuleRule= ruleMachineLearningModuleRule EOF )
            // InternalMachineLearningLanguage.g:73:2: iv_ruleMachineLearningModuleRule= ruleMachineLearningModuleRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMachineLearningModuleRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMachineLearningModuleRule=ruleMachineLearningModuleRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMachineLearningModuleRule; 
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
    // $ANTLR end "entryRuleMachineLearningModuleRule"


    // $ANTLR start "ruleMachineLearningModuleRule"
    // InternalMachineLearningLanguage.g:79:1: ruleMachineLearningModuleRule returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_definitions_4_0= ruleSurrogateDefinitionRule ) )* ( (lv_body_5_0= ruleBodyRule ) ) otherlv_6= '}' ) ;
    public final EObject ruleMachineLearningModuleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_imports_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_definitions_4_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:85:2: ( ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_definitions_4_0= ruleSurrogateDefinitionRule ) )* ( (lv_body_5_0= ruleBodyRule ) ) otherlv_6= '}' ) )
            // InternalMachineLearningLanguage.g:86:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_definitions_4_0= ruleSurrogateDefinitionRule ) )* ( (lv_body_5_0= ruleBodyRule ) ) otherlv_6= '}' )
            {
            // InternalMachineLearningLanguage.g:86:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_definitions_4_0= ruleSurrogateDefinitionRule ) )* ( (lv_body_5_0= ruleBodyRule ) ) otherlv_6= '}' )
            // InternalMachineLearningLanguage.g:87:3: ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_definitions_4_0= ruleSurrogateDefinitionRule ) )* ( (lv_body_5_0= ruleBodyRule ) ) otherlv_6= '}'
            {
            // InternalMachineLearningLanguage.g:87:3: ( (lv_imports_0_0= ruleImportRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==62) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:88:4: (lv_imports_0_0= ruleImportRule )
            	    {
            	    // InternalMachineLearningLanguage.g:88:4: (lv_imports_0_0= ruleImportRule )
            	    // InternalMachineLearningLanguage.g:89:5: lv_imports_0_0= ruleImportRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getImportsImportRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImportRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"imports",
            	      						lv_imports_0_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.ImportRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_1=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMachineLearningModuleRuleAccess().getModuleKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:110:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:111:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:111:4: (lv_name_2_0= ruleQualifiedName )
            // InternalMachineLearningLanguage.g:112:5: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getNameQualifiedNameParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getMachineLearningModuleRuleAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalMachineLearningLanguage.g:133:3: ( (lv_definitions_4_0= ruleSurrogateDefinitionRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:134:4: (lv_definitions_4_0= ruleSurrogateDefinitionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:134:4: (lv_definitions_4_0= ruleSurrogateDefinitionRule )
            	    // InternalMachineLearningLanguage.g:135:5: lv_definitions_4_0= ruleSurrogateDefinitionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getDefinitionsSurrogateDefinitionRuleParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_definitions_4_0=ruleSurrogateDefinitionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"definitions",
            	      						lv_definitions_4_0,
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

            // InternalMachineLearningLanguage.g:152:3: ( (lv_body_5_0= ruleBodyRule ) )
            // InternalMachineLearningLanguage.g:153:4: (lv_body_5_0= ruleBodyRule )
            {
            // InternalMachineLearningLanguage.g:153:4: (lv_body_5_0= ruleBodyRule )
            // InternalMachineLearningLanguage.g:154:5: lv_body_5_0= ruleBodyRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getBodyBodyRuleParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_7);
            lv_body_5_0=ruleBodyRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_5_0,
              						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.BodyRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getMachineLearningModuleRuleAccess().getRightCurlyBracketKeyword_6());
              		
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
    // $ANTLR end "ruleMachineLearningModuleRule"


    // $ANTLR start "entryRuleSurrogateDefinitionRule"
    // InternalMachineLearningLanguage.g:179:1: entryRuleSurrogateDefinitionRule returns [EObject current=null] : iv_ruleSurrogateDefinitionRule= ruleSurrogateDefinitionRule EOF ;
    public final EObject entryRuleSurrogateDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSurrogateDefinitionRule = null;


        try {
            // InternalMachineLearningLanguage.g:179:64: (iv_ruleSurrogateDefinitionRule= ruleSurrogateDefinitionRule EOF )
            // InternalMachineLearningLanguage.g:180:2: iv_ruleSurrogateDefinitionRule= ruleSurrogateDefinitionRule EOF
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
    // InternalMachineLearningLanguage.g:186:1: ruleSurrogateDefinitionRule returns [EObject current=null] : (otherlv_0= 'function' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_functions_3_0= rulePartialSurrogateFunctionDefinitionRule ) )+ ) ;
    public final EObject ruleSurrogateDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_functions_3_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:192:2: ( (otherlv_0= 'function' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_functions_3_0= rulePartialSurrogateFunctionDefinitionRule ) )+ ) )
            // InternalMachineLearningLanguage.g:193:2: (otherlv_0= 'function' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_functions_3_0= rulePartialSurrogateFunctionDefinitionRule ) )+ )
            {
            // InternalMachineLearningLanguage.g:193:2: (otherlv_0= 'function' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_functions_3_0= rulePartialSurrogateFunctionDefinitionRule ) )+ )
            // InternalMachineLearningLanguage.g:194:3: otherlv_0= 'function' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'using' ( (lv_functions_3_0= rulePartialSurrogateFunctionDefinitionRule ) )+
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSurrogateDefinitionRuleAccess().getFunctionKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:198:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:199:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:199:4: (lv_name_1_0= ruleStringOrId )
            // InternalMachineLearningLanguage.g:200:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSurrogateDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSurrogateDefinitionRuleRule());
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

            otherlv_2=(Token)match(input,19,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getSurrogateDefinitionRuleAccess().getUsingKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:221:3: ( (lv_functions_3_0= rulePartialSurrogateFunctionDefinitionRule ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:222:4: (lv_functions_3_0= rulePartialSurrogateFunctionDefinitionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:222:4: (lv_functions_3_0= rulePartialSurrogateFunctionDefinitionRule )
            	    // InternalMachineLearningLanguage.g:223:5: lv_functions_3_0= rulePartialSurrogateFunctionDefinitionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSurrogateDefinitionRuleAccess().getFunctionsPartialSurrogateFunctionDefinitionRuleParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_functions_3_0=rulePartialSurrogateFunctionDefinitionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSurrogateDefinitionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"functions",
            	      						lv_functions_3_0,
            	      						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.PartialSurrogateFunctionDefinitionRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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


    // $ANTLR start "entryRulePartialSurrogateFunctionDefinitionRule"
    // InternalMachineLearningLanguage.g:244:1: entryRulePartialSurrogateFunctionDefinitionRule returns [EObject current=null] : iv_rulePartialSurrogateFunctionDefinitionRule= rulePartialSurrogateFunctionDefinitionRule EOF ;
    public final EObject entryRulePartialSurrogateFunctionDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialSurrogateFunctionDefinitionRule = null;


        try {
            // InternalMachineLearningLanguage.g:244:79: (iv_rulePartialSurrogateFunctionDefinitionRule= rulePartialSurrogateFunctionDefinitionRule EOF )
            // InternalMachineLearningLanguage.g:245:2: iv_rulePartialSurrogateFunctionDefinitionRule= rulePartialSurrogateFunctionDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartialSurrogateFunctionDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartialSurrogateFunctionDefinitionRule=rulePartialSurrogateFunctionDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartialSurrogateFunctionDefinitionRule; 
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
    // $ANTLR end "entryRulePartialSurrogateFunctionDefinitionRule"


    // $ANTLR start "rulePartialSurrogateFunctionDefinitionRule"
    // InternalMachineLearningLanguage.g:251:1: rulePartialSurrogateFunctionDefinitionRule returns [EObject current=null] : (otherlv_0= 'model' ( ( ruleQualifiedName ) ) otherlv_2= 'mapping' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* otherlv_6= 'to' ( ( ruleQualifiedName ) ) (otherlv_8= ',' ( ( ruleQualifiedName ) ) )* (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_attributes_12_0= ruleAttributeRule ) )+ )? ) ;
    public final EObject rulePartialSurrogateFunctionDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_attributes_12_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:257:2: ( (otherlv_0= 'model' ( ( ruleQualifiedName ) ) otherlv_2= 'mapping' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* otherlv_6= 'to' ( ( ruleQualifiedName ) ) (otherlv_8= ',' ( ( ruleQualifiedName ) ) )* (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_attributes_12_0= ruleAttributeRule ) )+ )? ) )
            // InternalMachineLearningLanguage.g:258:2: (otherlv_0= 'model' ( ( ruleQualifiedName ) ) otherlv_2= 'mapping' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* otherlv_6= 'to' ( ( ruleQualifiedName ) ) (otherlv_8= ',' ( ( ruleQualifiedName ) ) )* (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_attributes_12_0= ruleAttributeRule ) )+ )? )
            {
            // InternalMachineLearningLanguage.g:258:2: (otherlv_0= 'model' ( ( ruleQualifiedName ) ) otherlv_2= 'mapping' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* otherlv_6= 'to' ( ( ruleQualifiedName ) ) (otherlv_8= ',' ( ( ruleQualifiedName ) ) )* (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_attributes_12_0= ruleAttributeRule ) )+ )? )
            // InternalMachineLearningLanguage.g:259:3: otherlv_0= 'model' ( ( ruleQualifiedName ) ) otherlv_2= 'mapping' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* otherlv_6= 'to' ( ( ruleQualifiedName ) ) (otherlv_8= ',' ( ( ruleQualifiedName ) ) )* (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_attributes_12_0= ruleAttributeRule ) )+ )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getModelKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:263:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:264:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:264:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:265:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPartialSurrogateFunctionDefinitionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getDefinitionTypeDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_11);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getMappingKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:286:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:287:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:287:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:288:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPartialSurrogateFunctionDefinitionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getInputsDataDescriptionCrossReference_3_0());
              				
            }
            pushFollow(FOLLOW_12);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:305:3: (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==22) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:306:4: otherlv_4= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_4=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:310:4: ( ( ruleQualifiedName ) )
            	    // InternalMachineLearningLanguage.g:311:5: ( ruleQualifiedName )
            	    {
            	    // InternalMachineLearningLanguage.g:311:5: ( ruleQualifiedName )
            	    // InternalMachineLearningLanguage.g:312:6: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getPartialSurrogateFunctionDefinitionRuleRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getInputsDataDescriptionCrossReference_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_12);
            	    ruleQualifiedName();

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

            otherlv_6=(Token)match(input,23,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getToKeyword_5());
              		
            }
            // InternalMachineLearningLanguage.g:334:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:335:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:335:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:336:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPartialSurrogateFunctionDefinitionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getOutputsDataDescriptionCrossReference_6_0());
              				
            }
            pushFollow(FOLLOW_13);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:353:3: (otherlv_8= ',' ( ( ruleQualifiedName ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:354:4: otherlv_8= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_8=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_8, grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getCommaKeyword_7_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:358:4: ( ( ruleQualifiedName ) )
            	    // InternalMachineLearningLanguage.g:359:5: ( ruleQualifiedName )
            	    {
            	    // InternalMachineLearningLanguage.g:359:5: ( ruleQualifiedName )
            	    // InternalMachineLearningLanguage.g:360:6: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getPartialSurrogateFunctionDefinitionRuleRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getOutputsDataDescriptionCrossReference_7_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
            	    ruleQualifiedName();

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

            // InternalMachineLearningLanguage.g:378:3: (otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_attributes_12_0= ruleAttributeRule ) )+ )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMachineLearningLanguage.g:379:4: otherlv_10= 'with' otherlv_11= 'parameters' ( (lv_attributes_12_0= ruleAttributeRule ) )+
                    {
                    otherlv_10=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getWithKeyword_8_0());
                      			
                    }
                    otherlv_11=(Token)match(input,25,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getParametersKeyword_8_1());
                      			
                    }
                    // InternalMachineLearningLanguage.g:387:4: ( (lv_attributes_12_0= ruleAttributeRule ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=RULE_QUOTED_ID && LA6_0<=RULE_ID)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:388:5: (lv_attributes_12_0= ruleAttributeRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:388:5: (lv_attributes_12_0= ruleAttributeRule )
                    	    // InternalMachineLearningLanguage.g:389:6: lv_attributes_12_0= ruleAttributeRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getPartialSurrogateFunctionDefinitionRuleAccess().getAttributesAttributeRuleParserRuleCall_8_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_15);
                    	    lv_attributes_12_0=ruleAttributeRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getPartialSurrogateFunctionDefinitionRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"attributes",
                    	      							lv_attributes_12_0,
                    	      							"de.evoal.languages.model.base.dsl.BaseLanguage.AttributeRule");
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
    // $ANTLR end "rulePartialSurrogateFunctionDefinitionRule"


    // $ANTLR start "entryRulePredictStatementRule"
    // InternalMachineLearningLanguage.g:411:1: entryRulePredictStatementRule returns [EObject current=null] : iv_rulePredictStatementRule= rulePredictStatementRule EOF ;
    public final EObject entryRulePredictStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredictStatementRule = null;


        try {
            // InternalMachineLearningLanguage.g:411:61: (iv_rulePredictStatementRule= rulePredictStatementRule EOF )
            // InternalMachineLearningLanguage.g:412:2: iv_rulePredictStatementRule= rulePredictStatementRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredictStatementRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePredictStatementRule=rulePredictStatementRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredictStatementRule; 
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
    // $ANTLR end "entryRulePredictStatementRule"


    // $ANTLR start "rulePredictStatementRule"
    // InternalMachineLearningLanguage.g:418:1: rulePredictStatementRule returns [EObject current=null] : (otherlv_0= 'predict' ( ( ruleQualifiedName ) ) otherlv_2= 'from' ( (lv_trainingData_3_0= RULE_STRING ) ) (otherlv_4= 'and' otherlv_5= 'measure' ( (lv_measurements_6_0= ruleBodyRule ) ) )? otherlv_7= 'and' otherlv_8= 'store' otherlv_9= 'to' ( (lv_modelFilename_10_0= RULE_STRING ) ) ) ;
    public final EObject rulePredictStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_trainingData_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_modelFilename_10_0=null;
        EObject lv_measurements_6_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:424:2: ( (otherlv_0= 'predict' ( ( ruleQualifiedName ) ) otherlv_2= 'from' ( (lv_trainingData_3_0= RULE_STRING ) ) (otherlv_4= 'and' otherlv_5= 'measure' ( (lv_measurements_6_0= ruleBodyRule ) ) )? otherlv_7= 'and' otherlv_8= 'store' otherlv_9= 'to' ( (lv_modelFilename_10_0= RULE_STRING ) ) ) )
            // InternalMachineLearningLanguage.g:425:2: (otherlv_0= 'predict' ( ( ruleQualifiedName ) ) otherlv_2= 'from' ( (lv_trainingData_3_0= RULE_STRING ) ) (otherlv_4= 'and' otherlv_5= 'measure' ( (lv_measurements_6_0= ruleBodyRule ) ) )? otherlv_7= 'and' otherlv_8= 'store' otherlv_9= 'to' ( (lv_modelFilename_10_0= RULE_STRING ) ) )
            {
            // InternalMachineLearningLanguage.g:425:2: (otherlv_0= 'predict' ( ( ruleQualifiedName ) ) otherlv_2= 'from' ( (lv_trainingData_3_0= RULE_STRING ) ) (otherlv_4= 'and' otherlv_5= 'measure' ( (lv_measurements_6_0= ruleBodyRule ) ) )? otherlv_7= 'and' otherlv_8= 'store' otherlv_9= 'to' ( (lv_modelFilename_10_0= RULE_STRING ) ) )
            // InternalMachineLearningLanguage.g:426:3: otherlv_0= 'predict' ( ( ruleQualifiedName ) ) otherlv_2= 'from' ( (lv_trainingData_3_0= RULE_STRING ) ) (otherlv_4= 'and' otherlv_5= 'measure' ( (lv_measurements_6_0= ruleBodyRule ) ) )? otherlv_7= 'and' otherlv_8= 'store' otherlv_9= 'to' ( (lv_modelFilename_10_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPredictStatementRuleAccess().getPredictKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:430:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:431:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:431:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:432:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPredictStatementRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPredictStatementRuleAccess().getSurrogateSurrogateDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_16);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPredictStatementRuleAccess().getFromKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:453:3: ( (lv_trainingData_3_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:454:4: (lv_trainingData_3_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:454:4: (lv_trainingData_3_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:455:5: lv_trainingData_3_0= RULE_STRING
            {
            lv_trainingData_3_0=(Token)match(input,RULE_STRING,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_trainingData_3_0, grammarAccess.getPredictStatementRuleAccess().getTrainingDataSTRINGTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPredictStatementRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"trainingData",
              						lv_trainingData_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:471:3: (otherlv_4= 'and' otherlv_5= 'measure' ( (lv_measurements_6_0= ruleBodyRule ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==28) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==29) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // InternalMachineLearningLanguage.g:472:4: otherlv_4= 'and' otherlv_5= 'measure' ( (lv_measurements_6_0= ruleBodyRule ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPredictStatementRuleAccess().getAndKeyword_4_0());
                      			
                    }
                    otherlv_5=(Token)match(input,29,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPredictStatementRuleAccess().getMeasureKeyword_4_1());
                      			
                    }
                    // InternalMachineLearningLanguage.g:480:4: ( (lv_measurements_6_0= ruleBodyRule ) )
                    // InternalMachineLearningLanguage.g:481:5: (lv_measurements_6_0= ruleBodyRule )
                    {
                    // InternalMachineLearningLanguage.g:481:5: (lv_measurements_6_0= ruleBodyRule )
                    // InternalMachineLearningLanguage.g:482:6: lv_measurements_6_0= ruleBodyRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPredictStatementRuleAccess().getMeasurementsBodyRuleParserRuleCall_4_2_0());
                      					
                    }
                    pushFollow(FOLLOW_18);
                    lv_measurements_6_0=ruleBodyRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPredictStatementRuleRule());
                      						}
                      						set(
                      							current,
                      							"measurements",
                      							lv_measurements_6_0,
                      							"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.BodyRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,28,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getPredictStatementRuleAccess().getAndKeyword_5());
              		
            }
            otherlv_8=(Token)match(input,30,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getPredictStatementRuleAccess().getStoreKeyword_6());
              		
            }
            otherlv_9=(Token)match(input,23,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getPredictStatementRuleAccess().getToKeyword_7());
              		
            }
            // InternalMachineLearningLanguage.g:512:3: ( (lv_modelFilename_10_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:513:4: (lv_modelFilename_10_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:513:4: (lv_modelFilename_10_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:514:5: lv_modelFilename_10_0= RULE_STRING
            {
            lv_modelFilename_10_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_modelFilename_10_0, grammarAccess.getPredictStatementRuleAccess().getModelFilenameSTRINGTerminalRuleCall_8_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPredictStatementRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"modelFilename",
              						lv_modelFilename_10_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
              				
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
    // $ANTLR end "rulePredictStatementRule"


    // $ANTLR start "entryRuleBodyRule"
    // InternalMachineLearningLanguage.g:534:1: entryRuleBodyRule returns [EObject current=null] : iv_ruleBodyRule= ruleBodyRule EOF ;
    public final EObject entryRuleBodyRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBodyRule = null;


        try {
            // InternalMachineLearningLanguage.g:534:49: (iv_ruleBodyRule= ruleBodyRule EOF )
            // InternalMachineLearningLanguage.g:535:2: iv_ruleBodyRule= ruleBodyRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBodyRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBodyRule=ruleBodyRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBodyRule; 
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
    // $ANTLR end "entryRuleBodyRule"


    // $ANTLR start "ruleBodyRule"
    // InternalMachineLearningLanguage.g:541:1: ruleBodyRule returns [EObject current=null] : ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' ) ;
    public final EObject ruleBodyRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:547:2: ( ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' ) )
            // InternalMachineLearningLanguage.g:548:2: ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' )
            {
            // InternalMachineLearningLanguage.g:548:2: ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' )
            // InternalMachineLearningLanguage.g:549:3: () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end'
            {
            // InternalMachineLearningLanguage.g:549:3: ()
            // InternalMachineLearningLanguage.g:550:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBodyRuleAccess().getBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBodyRuleAccess().getBeginKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:563:3: ( (lv_statements_2_0= ruleStatementRule ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_QUOTED_ID && LA9_0<=RULE_ID)||LA9_0==26||LA9_0==36) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:564:4: (lv_statements_2_0= ruleStatementRule )
            	    {
            	    // InternalMachineLearningLanguage.g:564:4: (lv_statements_2_0= ruleStatementRule )
            	    // InternalMachineLearningLanguage.g:565:5: lv_statements_2_0= ruleStatementRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBodyRuleAccess().getStatementsStatementRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_statements_2_0=ruleStatementRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBodyRuleRule());
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
            	    break loop9;
                }
            } while (true);

            otherlv_3=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBodyRuleAccess().getEndKeyword_3());
              		
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
    // $ANTLR end "ruleBodyRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalMachineLearningLanguage.g:590:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalMachineLearningLanguage.g:590:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalMachineLearningLanguage.g:591:2: iv_ruleStatementRule= ruleStatementRule EOF
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
    // InternalMachineLearningLanguage.g:597:1: ruleStatementRule returns [EObject current=null] : (this_ForStatementRule_0= ruleForStatementRule | this_PredictStatementRule_1= rulePredictStatementRule | this_CallBuiltinFunctionRule_2= ruleCallBuiltinFunctionRule ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatementRule_0 = null;

        EObject this_PredictStatementRule_1 = null;

        EObject this_CallBuiltinFunctionRule_2 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:603:2: ( (this_ForStatementRule_0= ruleForStatementRule | this_PredictStatementRule_1= rulePredictStatementRule | this_CallBuiltinFunctionRule_2= ruleCallBuiltinFunctionRule ) )
            // InternalMachineLearningLanguage.g:604:2: (this_ForStatementRule_0= ruleForStatementRule | this_PredictStatementRule_1= rulePredictStatementRule | this_CallBuiltinFunctionRule_2= ruleCallBuiltinFunctionRule )
            {
            // InternalMachineLearningLanguage.g:604:2: (this_ForStatementRule_0= ruleForStatementRule | this_PredictStatementRule_1= rulePredictStatementRule | this_CallBuiltinFunctionRule_2= ruleCallBuiltinFunctionRule )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt10=1;
                }
                break;
            case 26:
                {
                alt10=2;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalMachineLearningLanguage.g:605:3: this_ForStatementRule_0= ruleForStatementRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementRuleAccess().getForStatementRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ForStatementRule_0=ruleForStatementRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ForStatementRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:617:3: this_PredictStatementRule_1= rulePredictStatementRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementRuleAccess().getPredictStatementRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PredictStatementRule_1=rulePredictStatementRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PredictStatementRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMachineLearningLanguage.g:629:3: this_CallBuiltinFunctionRule_2= ruleCallBuiltinFunctionRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementRuleAccess().getCallBuiltinFunctionRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CallBuiltinFunctionRule_2=ruleCallBuiltinFunctionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CallBuiltinFunctionRule_2;
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


    // $ANTLR start "entryRuleCallBuiltinFunctionRule"
    // InternalMachineLearningLanguage.g:644:1: entryRuleCallBuiltinFunctionRule returns [EObject current=null] : iv_ruleCallBuiltinFunctionRule= ruleCallBuiltinFunctionRule EOF ;
    public final EObject entryRuleCallBuiltinFunctionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallBuiltinFunctionRule = null;


        try {
            // InternalMachineLearningLanguage.g:644:64: (iv_ruleCallBuiltinFunctionRule= ruleCallBuiltinFunctionRule EOF )
            // InternalMachineLearningLanguage.g:645:2: iv_ruleCallBuiltinFunctionRule= ruleCallBuiltinFunctionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallBuiltinFunctionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCallBuiltinFunctionRule=ruleCallBuiltinFunctionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallBuiltinFunctionRule; 
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
    // $ANTLR end "entryRuleCallBuiltinFunctionRule"


    // $ANTLR start "ruleCallBuiltinFunctionRule"
    // InternalMachineLearningLanguage.g:651:1: ruleCallBuiltinFunctionRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' ) ;
    public final EObject ruleCallBuiltinFunctionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:657:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' ) )
            // InternalMachineLearningLanguage.g:658:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalMachineLearningLanguage.g:658:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' )
            // InternalMachineLearningLanguage.g:659:3: ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';'
            {
            // InternalMachineLearningLanguage.g:659:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:660:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:660:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:661:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCallBuiltinFunctionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallBuiltinFunctionRuleAccess().getDefinitionFunctionDefinitionCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_23);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallBuiltinFunctionRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:682:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)||LA12_0==33||LA12_0==38||LA12_0==45||LA12_0==47||(LA12_0>=49 && LA12_0<=50)||(LA12_0>=70 && LA12_0<=71)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMachineLearningLanguage.g:683:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalMachineLearningLanguage.g:683:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalMachineLearningLanguage.g:684:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:684:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalMachineLearningLanguage.g:685:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallBuiltinFunctionRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
                    lv_parameters_2_0=ruleExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCallBuiltinFunctionRuleRule());
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

                    // InternalMachineLearningLanguage.g:702:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==22) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:703:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallBuiltinFunctionRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMachineLearningLanguage.g:707:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalMachineLearningLanguage.g:708:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:708:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalMachineLearningLanguage.g:709:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallBuiltinFunctionRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_25);
                    	    lv_parameters_4_0=ruleExpressionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getCallBuiltinFunctionRuleRule());
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
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,34,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCallBuiltinFunctionRuleAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_6=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getCallBuiltinFunctionRuleAccess().getSemicolonKeyword_4());
              		
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
    // $ANTLR end "ruleCallBuiltinFunctionRule"


    // $ANTLR start "entryRuleForStatementRule"
    // InternalMachineLearningLanguage.g:740:1: entryRuleForStatementRule returns [EObject current=null] : iv_ruleForStatementRule= ruleForStatementRule EOF ;
    public final EObject entryRuleForStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatementRule = null;


        try {
            // InternalMachineLearningLanguage.g:740:57: (iv_ruleForStatementRule= ruleForStatementRule EOF )
            // InternalMachineLearningLanguage.g:741:2: iv_ruleForStatementRule= ruleForStatementRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForStatementRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForStatementRule=ruleForStatementRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForStatementRule; 
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
    // $ANTLR end "entryRuleForStatementRule"


    // $ANTLR start "ruleForStatementRule"
    // InternalMachineLearningLanguage.g:747:1: ruleForStatementRule returns [EObject current=null] : (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) ) ;
    public final EObject ruleForStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_var_1_0 = null;

        EObject lv_range_3_0 = null;

        EObject lv_body_4_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:753:2: ( (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) ) )
            // InternalMachineLearningLanguage.g:754:2: (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) )
            {
            // InternalMachineLearningLanguage.g:754:2: (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) )
            // InternalMachineLearningLanguage.g:755:3: otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getForStatementRuleAccess().getForKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:759:3: ( (lv_var_1_0= ruleNamedVariableRule ) )
            // InternalMachineLearningLanguage.g:760:4: (lv_var_1_0= ruleNamedVariableRule )
            {
            // InternalMachineLearningLanguage.g:760:4: (lv_var_1_0= ruleNamedVariableRule )
            // InternalMachineLearningLanguage.g:761:5: lv_var_1_0= ruleNamedVariableRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementRuleAccess().getVarNamedVariableRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_var_1_0=ruleNamedVariableRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRuleRule());
              					}
              					set(
              						current,
              						"var",
              						lv_var_1_0,
              						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.NamedVariableRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getForStatementRuleAccess().getInKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:782:3: ( (lv_range_3_0= ruleRangeRule ) )
            // InternalMachineLearningLanguage.g:783:4: (lv_range_3_0= ruleRangeRule )
            {
            // InternalMachineLearningLanguage.g:783:4: (lv_range_3_0= ruleRangeRule )
            // InternalMachineLearningLanguage.g:784:5: lv_range_3_0= ruleRangeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementRuleAccess().getRangeRangeRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_range_3_0=ruleRangeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRuleRule());
              					}
              					set(
              						current,
              						"range",
              						lv_range_3_0,
              						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.RangeRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:801:3: ( (lv_body_4_0= ruleBodyRule ) )
            // InternalMachineLearningLanguage.g:802:4: (lv_body_4_0= ruleBodyRule )
            {
            // InternalMachineLearningLanguage.g:802:4: (lv_body_4_0= ruleBodyRule )
            // InternalMachineLearningLanguage.g:803:5: lv_body_4_0= ruleBodyRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementRuleAccess().getBodyBodyRuleParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_4_0=ruleBodyRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRuleRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_4_0,
              						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.BodyRule");
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
    // $ANTLR end "ruleForStatementRule"


    // $ANTLR start "entryRuleNamedVariableRule"
    // InternalMachineLearningLanguage.g:824:1: entryRuleNamedVariableRule returns [EObject current=null] : iv_ruleNamedVariableRule= ruleNamedVariableRule EOF ;
    public final EObject entryRuleNamedVariableRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedVariableRule = null;


        try {
            // InternalMachineLearningLanguage.g:824:58: (iv_ruleNamedVariableRule= ruleNamedVariableRule EOF )
            // InternalMachineLearningLanguage.g:825:2: iv_ruleNamedVariableRule= ruleNamedVariableRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedVariableRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNamedVariableRule=ruleNamedVariableRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedVariableRule; 
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
    // $ANTLR end "entryRuleNamedVariableRule"


    // $ANTLR start "ruleNamedVariableRule"
    // InternalMachineLearningLanguage.g:831:1: ruleNamedVariableRule returns [EObject current=null] : ( (lv_name_0_0= ruleStringOrId ) ) ;
    public final EObject ruleNamedVariableRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:837:2: ( ( (lv_name_0_0= ruleStringOrId ) ) )
            // InternalMachineLearningLanguage.g:838:2: ( (lv_name_0_0= ruleStringOrId ) )
            {
            // InternalMachineLearningLanguage.g:838:2: ( (lv_name_0_0= ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:839:3: (lv_name_0_0= ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:839:3: (lv_name_0_0= ruleStringOrId )
            // InternalMachineLearningLanguage.g:840:4: lv_name_0_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getNamedVariableRuleAccess().getNameStringOrIdParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getNamedVariableRuleRule());
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
    // $ANTLR end "ruleNamedVariableRule"


    // $ANTLR start "entryRuleRangeRule"
    // InternalMachineLearningLanguage.g:860:1: entryRuleRangeRule returns [EObject current=null] : iv_ruleRangeRule= ruleRangeRule EOF ;
    public final EObject entryRuleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeRule = null;


        try {
            // InternalMachineLearningLanguage.g:860:50: (iv_ruleRangeRule= ruleRangeRule EOF )
            // InternalMachineLearningLanguage.g:861:2: iv_ruleRangeRule= ruleRangeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRangeRule=ruleRangeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeRule; 
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
    // $ANTLR end "entryRuleRangeRule"


    // $ANTLR start "ruleRangeRule"
    // InternalMachineLearningLanguage.g:867:1: ruleRangeRule returns [EObject current=null] : (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule ) ;
    public final EObject ruleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject this_CounterRangeRule_0 = null;

        EObject this_LiteralRangeRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:873:2: ( (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule ) )
            // InternalMachineLearningLanguage.g:874:2: (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule )
            {
            // InternalMachineLearningLanguage.g:874:2: (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule )
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalMachineLearningLanguage.g:875:3: this_CounterRangeRule_0= ruleCounterRangeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRangeRuleAccess().getCounterRangeRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CounterRangeRule_0=ruleCounterRangeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CounterRangeRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:887:3: this_LiteralRangeRule_1= ruleLiteralRangeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRangeRuleAccess().getLiteralRangeRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralRangeRule_1=ruleLiteralRangeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralRangeRule_1;
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
    // $ANTLR end "ruleRangeRule"


    // $ANTLR start "entryRuleLiteralRangeRule"
    // InternalMachineLearningLanguage.g:902:1: entryRuleLiteralRangeRule returns [EObject current=null] : iv_ruleLiteralRangeRule= ruleLiteralRangeRule EOF ;
    public final EObject entryRuleLiteralRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRangeRule = null;


        try {
            // InternalMachineLearningLanguage.g:902:57: (iv_ruleLiteralRangeRule= ruleLiteralRangeRule EOF )
            // InternalMachineLearningLanguage.g:903:2: iv_ruleLiteralRangeRule= ruleLiteralRangeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRangeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralRangeRule=ruleLiteralRangeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralRangeRule; 
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
    // $ANTLR end "entryRuleLiteralRangeRule"


    // $ANTLR start "ruleLiteralRangeRule"
    // InternalMachineLearningLanguage.g:909:1: ruleLiteralRangeRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_elements_1_0= ruleValueRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleValueRule ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleLiteralRangeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:915:2: ( (otherlv_0= '[' ( (lv_elements_1_0= ruleValueRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleValueRule ) ) )* otherlv_4= ']' ) )
            // InternalMachineLearningLanguage.g:916:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleValueRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleValueRule ) ) )* otherlv_4= ']' )
            {
            // InternalMachineLearningLanguage.g:916:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleValueRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleValueRule ) ) )* otherlv_4= ']' )
            // InternalMachineLearningLanguage.g:917:3: otherlv_0= '[' ( (lv_elements_1_0= ruleValueRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleValueRule ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLiteralRangeRuleAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:921:3: ( (lv_elements_1_0= ruleValueRule ) )
            // InternalMachineLearningLanguage.g:922:4: (lv_elements_1_0= ruleValueRule )
            {
            // InternalMachineLearningLanguage.g:922:4: (lv_elements_1_0= ruleValueRule )
            // InternalMachineLearningLanguage.g:923:5: lv_elements_1_0= ruleValueRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLiteralRangeRuleAccess().getElementsValueRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_30);
            lv_elements_1_0=ruleValueRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLiteralRangeRuleRule());
              					}
              					add(
              						current,
              						"elements",
              						lv_elements_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ValueRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:940:3: (otherlv_2= ',' ( (lv_elements_3_0= ruleValueRule ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==22) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:941:4: otherlv_2= ',' ( (lv_elements_3_0= ruleValueRule ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLiteralRangeRuleAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:945:4: ( (lv_elements_3_0= ruleValueRule ) )
            	    // InternalMachineLearningLanguage.g:946:5: (lv_elements_3_0= ruleValueRule )
            	    {
            	    // InternalMachineLearningLanguage.g:946:5: (lv_elements_3_0= ruleValueRule )
            	    // InternalMachineLearningLanguage.g:947:6: lv_elements_3_0= ruleValueRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLiteralRangeRuleAccess().getElementsValueRuleParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_elements_3_0=ruleValueRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLiteralRangeRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_3_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.ValueRule");
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

            otherlv_4=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLiteralRangeRuleAccess().getRightSquareBracketKeyword_3());
              		
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
    // $ANTLR end "ruleLiteralRangeRule"


    // $ANTLR start "entryRuleCounterRangeRule"
    // InternalMachineLearningLanguage.g:973:1: entryRuleCounterRangeRule returns [EObject current=null] : iv_ruleCounterRangeRule= ruleCounterRangeRule EOF ;
    public final EObject entryRuleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCounterRangeRule = null;


        try {
            // InternalMachineLearningLanguage.g:973:57: (iv_ruleCounterRangeRule= ruleCounterRangeRule EOF )
            // InternalMachineLearningLanguage.g:974:2: iv_ruleCounterRangeRule= ruleCounterRangeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCounterRangeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCounterRangeRule=ruleCounterRangeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCounterRangeRule; 
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
    // $ANTLR end "entryRuleCounterRangeRule"


    // $ANTLR start "ruleCounterRangeRule"
    // InternalMachineLearningLanguage.g:980:1: ruleCounterRangeRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' ) ;
    public final EObject ruleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_start_1_0 = null;

        EObject lv_end_3_0 = null;

        EObject lv_increment_6_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:986:2: ( (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' ) )
            // InternalMachineLearningLanguage.g:987:2: (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' )
            {
            // InternalMachineLearningLanguage.g:987:2: (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' )
            // InternalMachineLearningLanguage.g:988:3: otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCounterRangeRuleAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:992:3: ( (lv_start_1_0= ruleIntegerLiteralRule ) )
            // InternalMachineLearningLanguage.g:993:4: (lv_start_1_0= ruleIntegerLiteralRule )
            {
            // InternalMachineLearningLanguage.g:993:4: (lv_start_1_0= ruleIntegerLiteralRule )
            // InternalMachineLearningLanguage.g:994:5: lv_start_1_0= ruleIntegerLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCounterRangeRuleAccess().getStartIntegerLiteralRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_start_1_0=ruleIntegerLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCounterRangeRuleRule());
              					}
              					set(
              						current,
              						"start",
              						lv_start_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.IntegerLiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCounterRangeRuleAccess().getToKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:1015:3: ( (lv_end_3_0= ruleIntegerLiteralRule ) )
            // InternalMachineLearningLanguage.g:1016:4: (lv_end_3_0= ruleIntegerLiteralRule )
            {
            // InternalMachineLearningLanguage.g:1016:4: (lv_end_3_0= ruleIntegerLiteralRule )
            // InternalMachineLearningLanguage.g:1017:5: lv_end_3_0= ruleIntegerLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCounterRangeRuleAccess().getEndIntegerLiteralRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_32);
            lv_end_3_0=ruleIntegerLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCounterRangeRuleRule());
              					}
              					set(
              						current,
              						"end",
              						lv_end_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.IntegerLiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,40,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getCounterRangeRuleAccess().getIncrementKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,41,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCounterRangeRuleAccess().getByKeyword_5());
              		
            }
            // InternalMachineLearningLanguage.g:1042:3: ( (lv_increment_6_0= ruleIntegerLiteralRule ) )
            // InternalMachineLearningLanguage.g:1043:4: (lv_increment_6_0= ruleIntegerLiteralRule )
            {
            // InternalMachineLearningLanguage.g:1043:4: (lv_increment_6_0= ruleIntegerLiteralRule )
            // InternalMachineLearningLanguage.g:1044:5: lv_increment_6_0= ruleIntegerLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCounterRangeRuleAccess().getIncrementIntegerLiteralRuleParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_increment_6_0=ruleIntegerLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCounterRangeRuleRule());
              					}
              					set(
              						current,
              						"increment",
              						lv_increment_6_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.IntegerLiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getCounterRangeRuleAccess().getRightSquareBracketKeyword_7());
              		
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
    // $ANTLR end "ruleCounterRangeRule"


    // $ANTLR start "entryRuleReferenceRule"
    // InternalMachineLearningLanguage.g:1069:1: entryRuleReferenceRule returns [EObject current=null] : iv_ruleReferenceRule= ruleReferenceRule EOF ;
    public final EObject entryRuleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:1069:54: (iv_ruleReferenceRule= ruleReferenceRule EOF )
            // InternalMachineLearningLanguage.g:1070:2: iv_ruleReferenceRule= ruleReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:1076:1: ruleReferenceRule returns [EObject current=null] : (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule ) ;
    public final EObject ruleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantReferenceRule_0 = null;

        EObject this_DataReferenceRule_1 = null;

        EObject this_VariableReferenceRule_2 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1082:2: ( (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule ) )
            // InternalMachineLearningLanguage.g:1083:2: (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule )
            {
            // InternalMachineLearningLanguage.g:1083:2: (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule )
            int alt15=3;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
                {
                int LA15_1 = input.LA(2);

                if ( (synpred16_InternalMachineLearningLanguage()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA15_2 = input.LA(2);

                if ( (synpred16_InternalMachineLearningLanguage()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
                }
                break;
            case 47:
                {
                alt15=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1084:3: this_ConstantReferenceRule_0= ruleConstantReferenceRule
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
                    // InternalMachineLearningLanguage.g:1096:3: this_DataReferenceRule_1= ruleDataReferenceRule
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
                case 3 :
                    // InternalMachineLearningLanguage.g:1108:3: this_VariableReferenceRule_2= ruleVariableReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getVariableReferenceRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableReferenceRule_2=ruleVariableReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableReferenceRule_2;
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


    // $ANTLR start "entryRuleVariableReferenceRule"
    // InternalMachineLearningLanguage.g:1123:1: entryRuleVariableReferenceRule returns [EObject current=null] : iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF ;
    public final EObject entryRuleVariableReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:1123:62: (iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF )
            // InternalMachineLearningLanguage.g:1124:2: iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableReferenceRule=ruleVariableReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableReferenceRule; 
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
    // $ANTLR end "entryRuleVariableReferenceRule"


    // $ANTLR start "ruleVariableReferenceRule"
    // InternalMachineLearningLanguage.g:1130:1: ruleVariableReferenceRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleVariableReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1136:2: ( ( ( ruleStringOrId ) ) )
            // InternalMachineLearningLanguage.g:1137:2: ( ( ruleStringOrId ) )
            {
            // InternalMachineLearningLanguage.g:1137:2: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:1138:3: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:1138:3: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:1139:4: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getVariableReferenceRuleRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getVariableReferenceRuleAccess().getVariableNamedVariableCrossReference_0());
              			
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
    // $ANTLR end "ruleVariableReferenceRule"


    // $ANTLR start "entryRuleExpressionRule"
    // InternalMachineLearningLanguage.g:1159:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1159:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1160:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1166:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1172:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalMachineLearningLanguage.g:1173:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalMachineLearningLanguage.g:1187:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1187:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1188:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1194:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1200:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:1201:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:1201:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:1202:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:1202:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalMachineLearningLanguage.g:1203:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1203:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalMachineLearningLanguage.g:1204:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
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

            // InternalMachineLearningLanguage.g:1221:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==42) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1222:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,42,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:1226:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1227:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1227:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalMachineLearningLanguage.g:1228:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
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
            	    break loop16;
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
    // InternalMachineLearningLanguage.g:1250:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1250:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1251:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1257:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1263:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:1264:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:1264:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:1265:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:1265:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalMachineLearningLanguage.g:1266:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1266:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalMachineLearningLanguage.g:1267:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_36);
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

            // InternalMachineLearningLanguage.g:1284:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==43) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1285:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,43,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:1289:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1290:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1290:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalMachineLearningLanguage.g:1291:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
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
            	    break loop17;
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
    // InternalMachineLearningLanguage.g:1313:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1313:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1314:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1320:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1326:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:1327:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:1327:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:1328:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:1328:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalMachineLearningLanguage.g:1329:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1329:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalMachineLearningLanguage.g:1330:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_37);
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

            // InternalMachineLearningLanguage.g:1347:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==44) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1348:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,44,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:1352:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1353:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1353:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalMachineLearningLanguage.g:1354:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
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
            	    break loop18;
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
    // InternalMachineLearningLanguage.g:1376:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1376:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1377:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1383:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1389:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalMachineLearningLanguage.g:1390:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalMachineLearningLanguage.g:1390:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalMachineLearningLanguage.g:1391:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalMachineLearningLanguage.g:1391:3: ( (lv_negated_0_0= '!' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==45) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1392:4: (lv_negated_0_0= '!' )
                    {
                    // InternalMachineLearningLanguage.g:1392:4: (lv_negated_0_0= '!' )
                    // InternalMachineLearningLanguage.g:1393:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,45,FOLLOW_26); if (state.failed) return current;
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

            // InternalMachineLearningLanguage.g:1405:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalMachineLearningLanguage.g:1406:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1406:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalMachineLearningLanguage.g:1407:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalMachineLearningLanguage.g:1428:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1428:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1429:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1435:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1441:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalMachineLearningLanguage.g:1442:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalMachineLearningLanguage.g:1442:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalMachineLearningLanguage.g:1443:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalMachineLearningLanguage.g:1443:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalMachineLearningLanguage.g:1444:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1444:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalMachineLearningLanguage.g:1445:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_38);
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

            // InternalMachineLearningLanguage.g:1462:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=64 && LA20_0<=69)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1463:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1463:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalMachineLearningLanguage.g:1464:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_38);
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
            	    break loop20;
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
    // InternalMachineLearningLanguage.g:1485:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1485:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1486:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1492:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1498:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalMachineLearningLanguage.g:1499:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalMachineLearningLanguage.g:1499:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalMachineLearningLanguage.g:1500:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalMachineLearningLanguage.g:1500:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalMachineLearningLanguage.g:1501:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalMachineLearningLanguage.g:1501:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalMachineLearningLanguage.g:1502:5: lv_operator_0_0= ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            // InternalMachineLearningLanguage.g:1519:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalMachineLearningLanguage.g:1520:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1520:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalMachineLearningLanguage.g:1521:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalMachineLearningLanguage.g:1542:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1542:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1543:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1549:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1555:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:1556:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:1556:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:1557:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:1557:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalMachineLearningLanguage.g:1558:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1558:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalMachineLearningLanguage.g:1559:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_39);
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

            // InternalMachineLearningLanguage.g:1576:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=70 && LA21_0<=71)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1577:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalMachineLearningLanguage.g:1577:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalMachineLearningLanguage.g:1578:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1578:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalMachineLearningLanguage.g:1579:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
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

            	    // InternalMachineLearningLanguage.g:1596:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1597:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1597:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalMachineLearningLanguage.g:1598:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_39);
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
            	    break loop21;
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
    // InternalMachineLearningLanguage.g:1620:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1620:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1621:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1627:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1633:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:1634:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:1634:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:1635:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:1635:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalMachineLearningLanguage.g:1636:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1636:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalMachineLearningLanguage.g:1637:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_40);
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

            // InternalMachineLearningLanguage.g:1654:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=72 && LA22_0<=74)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1655:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalMachineLearningLanguage.g:1655:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalMachineLearningLanguage.g:1656:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1656:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalMachineLearningLanguage.g:1657:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
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

            	    // InternalMachineLearningLanguage.g:1674:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1675:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1675:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalMachineLearningLanguage.g:1676:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
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
    // $ANTLR end "ruleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "entryRulePowerOfExpressionRule"
    // InternalMachineLearningLanguage.g:1698:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1698:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1699:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1705:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1711:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalMachineLearningLanguage.g:1712:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalMachineLearningLanguage.g:1712:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalMachineLearningLanguage.g:1713:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalMachineLearningLanguage.g:1713:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalMachineLearningLanguage.g:1714:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1714:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalMachineLearningLanguage.g:1715:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_41);
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

            // InternalMachineLearningLanguage.g:1732:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==46) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1733:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,46,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                      			
                    }
                    // InternalMachineLearningLanguage.g:1737:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalMachineLearningLanguage.g:1738:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:1738:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalMachineLearningLanguage.g:1739:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalMachineLearningLanguage.g:1761:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1761:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalMachineLearningLanguage.g:1762:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:1768:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1774:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) ) )
            // InternalMachineLearningLanguage.g:1775:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) )
            {
            // InternalMachineLearningLanguage.g:1775:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) )
            // InternalMachineLearningLanguage.g:1776:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) )
            {
            // InternalMachineLearningLanguage.g:1776:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=70 && LA24_0<=71)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1777:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1777:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalMachineLearningLanguage.g:1778:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_26);
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
            	    break loop24;
                }
            } while (true);

            // InternalMachineLearningLanguage.g:1795:3: ( (lv_subExpression_1_0= ruleValueRule ) )
            // InternalMachineLearningLanguage.g:1796:4: (lv_subExpression_1_0= ruleValueRule )
            {
            // InternalMachineLearningLanguage.g:1796:4: (lv_subExpression_1_0= ruleValueRule )
            // InternalMachineLearningLanguage.g:1797:5: lv_subExpression_1_0= ruleValueRule
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
    // InternalMachineLearningLanguage.g:1818:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // InternalMachineLearningLanguage.g:1818:50: (iv_ruleValueRule= ruleValueRule EOF )
            // InternalMachineLearningLanguage.g:1819:2: iv_ruleValueRule= ruleValueRule EOF
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
    // InternalMachineLearningLanguage.g:1825:1: ruleValueRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_CallRule_1 = null;

        EObject this_LiteralRule_2 = null;

        EObject this_ParanthesesRule_3 = null;

        EObject this_ReferenceRule_4 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1831:2: ( (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) )
            // InternalMachineLearningLanguage.g:1832:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            {
            // InternalMachineLearningLanguage.g:1832:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            int alt25=5;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1833:3: this_ArrayRule_0= ruleArrayRule
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
                    // InternalMachineLearningLanguage.g:1845:3: this_CallRule_1= ruleCallRule
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
                    // InternalMachineLearningLanguage.g:1857:3: this_LiteralRule_2= ruleLiteralRule
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
                    // InternalMachineLearningLanguage.g:1869:3: this_ParanthesesRule_3= ruleParanthesesRule
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
                    // InternalMachineLearningLanguage.g:1881:3: this_ReferenceRule_4= ruleReferenceRule
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
    // InternalMachineLearningLanguage.g:1896:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalMachineLearningLanguage.g:1896:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalMachineLearningLanguage.g:1897:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalMachineLearningLanguage.g:1903:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1909:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) )
            // InternalMachineLearningLanguage.g:1910:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalMachineLearningLanguage.g:1910:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            // InternalMachineLearningLanguage.g:1911:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']'
            {
            // InternalMachineLearningLanguage.g:1911:3: ()
            // InternalMachineLearningLanguage.g:1912:4: 
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

            otherlv_1=(Token)match(input,38,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:1925:3: ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=RULE_STRING && LA27_0<=RULE_ID)||LA27_0==33||LA27_0==38||LA27_0==47||(LA27_0>=49 && LA27_0<=50)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1926:4: ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    {
                    // InternalMachineLearningLanguage.g:1926:4: ( (lv_values_2_0= ruleValueRule ) )
                    // InternalMachineLearningLanguage.g:1927:5: (lv_values_2_0= ruleValueRule )
                    {
                    // InternalMachineLearningLanguage.g:1927:5: (lv_values_2_0= ruleValueRule )
                    // InternalMachineLearningLanguage.g:1928:6: lv_values_2_0= ruleValueRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_30);
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

                    // InternalMachineLearningLanguage.g:1945:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==22) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:1946:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMachineLearningLanguage.g:1950:5: ( (lv_values_4_0= ruleValueRule ) )
                    	    // InternalMachineLearningLanguage.g:1951:6: (lv_values_4_0= ruleValueRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:1951:6: (lv_values_4_0= ruleValueRule )
                    	    // InternalMachineLearningLanguage.g:1952:7: lv_values_4_0= ruleValueRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_30);
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
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:1979:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalMachineLearningLanguage.g:1979:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalMachineLearningLanguage.g:1980:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalMachineLearningLanguage.g:1986:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1992:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalMachineLearningLanguage.g:1993:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalMachineLearningLanguage.g:1993:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalMachineLearningLanguage.g:1994:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:1998:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalMachineLearningLanguage.g:1999:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1999:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalMachineLearningLanguage.g:2000:5: lv_subExpression_1_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_43);
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

            otherlv_2=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2025:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalMachineLearningLanguage.g:2025:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalMachineLearningLanguage.g:2026:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalMachineLearningLanguage.g:2032:1: ruleCallRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleCallRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2038:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalMachineLearningLanguage.g:2039:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalMachineLearningLanguage.g:2039:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalMachineLearningLanguage.g:2040:3: ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalMachineLearningLanguage.g:2040:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:2041:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:2041:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:2042:5: ruleQualifiedName
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
            pushFollow(FOLLOW_23);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:2063:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_ID)||LA29_0==33||LA29_0==38||LA29_0==45||LA29_0==47||(LA29_0>=49 && LA29_0<=50)||(LA29_0>=70 && LA29_0<=71)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2064:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalMachineLearningLanguage.g:2064:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalMachineLearningLanguage.g:2065:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:2065:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalMachineLearningLanguage.g:2066:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
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

                    // InternalMachineLearningLanguage.g:2083:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==22) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:2084:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMachineLearningLanguage.g:2088:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalMachineLearningLanguage.g:2089:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:2089:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalMachineLearningLanguage.g:2090:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_25);
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
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDataReferenceRule"
    // InternalMachineLearningLanguage.g:2117:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:2117:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalMachineLearningLanguage.g:2118:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:2124:1: ruleDataReferenceRule returns [EObject current=null] : (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2130:2: ( (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) )
            // InternalMachineLearningLanguage.g:2131:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            {
            // InternalMachineLearningLanguage.g:2131:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            // InternalMachineLearningLanguage.g:2132:3: otherlv_0= 'data' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDataReferenceRuleAccess().getDataKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:2136:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:2137:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:2137:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:2138:5: ruleQualifiedName
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

              					newCompositeNode(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_1_0());
              				
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


    // $ANTLR start "entryRuleConstantReferenceRule"
    // InternalMachineLearningLanguage.g:2159:1: entryRuleConstantReferenceRule returns [EObject current=null] : iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF ;
    public final EObject entryRuleConstantReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:2159:62: (iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF )
            // InternalMachineLearningLanguage.g:2160:2: iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:2166:1: ruleConstantReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleConstantReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2172:2: ( ( ( ruleQualifiedName ) ) )
            // InternalMachineLearningLanguage.g:2173:2: ( ( ruleQualifiedName ) )
            {
            // InternalMachineLearningLanguage.g:2173:2: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:2174:3: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:2174:3: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:2175:4: ruleQualifiedName
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
    // InternalMachineLearningLanguage.g:2195:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2195:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2196:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2202:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_InstanceLiteralRule_3 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2208:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) )
            // InternalMachineLearningLanguage.g:2209:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            {
            // InternalMachineLearningLanguage.g:2209:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            int alt30=4;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
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
            case 49:
            case 50:
                {
                alt30=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt30=4;
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
                    // InternalMachineLearningLanguage.g:2210:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalMachineLearningLanguage.g:2222:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalMachineLearningLanguage.g:2234:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
                    // InternalMachineLearningLanguage.g:2246:3: this_InstanceLiteralRule_3= ruleInstanceLiteralRule
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
    // InternalMachineLearningLanguage.g:2261:1: entryRuleInstanceLiteralRule returns [EObject current=null] : iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF ;
    public final EObject entryRuleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2261:60: (iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2262:2: iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2268:1: ruleInstanceLiteralRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) ;
    public final EObject ruleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2274:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) )
            // InternalMachineLearningLanguage.g:2275:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            {
            // InternalMachineLearningLanguage.g:2275:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            // InternalMachineLearningLanguage.g:2276:3: ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
            {
            // InternalMachineLearningLanguage.g:2276:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:2277:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:2277:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:2278:5: ruleQualifiedName
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
            pushFollow(FOLLOW_5);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:2299:3: ( (lv_attributes_2_0= ruleAttributeRule ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=RULE_QUOTED_ID && LA31_0<=RULE_ID)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:2300:4: (lv_attributes_2_0= ruleAttributeRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2300:4: (lv_attributes_2_0= ruleAttributeRule )
            	    // InternalMachineLearningLanguage.g:2301:5: lv_attributes_2_0= ruleAttributeRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAttributeRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_44);
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
            	    break loop31;
                }
            } while (true);

            otherlv_3=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2326:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalMachineLearningLanguage.g:2326:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalMachineLearningLanguage.g:2327:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalMachineLearningLanguage.g:2333:1: ruleAttributeRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2339:2: ( ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) )
            // InternalMachineLearningLanguage.g:2340:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            {
            // InternalMachineLearningLanguage.g:2340:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            // InternalMachineLearningLanguage.g:2341:3: ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';'
            {
            // InternalMachineLearningLanguage.g:2341:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:2342:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:2342:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:2343:5: ruleStringOrId
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
            pushFollow(FOLLOW_45);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,48,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:2364:3: ( (lv_value_2_0= ruleExpressionRule ) )
            // InternalMachineLearningLanguage.g:2365:4: (lv_value_2_0= ruleExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2365:4: (lv_value_2_0= ruleExpressionRule )
            // InternalMachineLearningLanguage.g:2366:5: lv_value_2_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueExpressionRuleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            otherlv_3=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2391:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2391:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2392:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2398:1: ruleNumberLiteralRule returns [EObject current=null] : (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2404:2: ( (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalMachineLearningLanguage.g:2405:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalMachineLearningLanguage.g:2405:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_DOUBLE) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_INT) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2406:3: this_RealLiteralRule_0= ruleRealLiteralRule
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
                    // InternalMachineLearningLanguage.g:2418:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalMachineLearningLanguage.g:2433:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2433:56: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2434:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2440:1: ruleRealLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2446:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalMachineLearningLanguage.g:2447:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalMachineLearningLanguage.g:2447:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalMachineLearningLanguage.g:2448:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalMachineLearningLanguage.g:2448:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalMachineLearningLanguage.g:2449:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalMachineLearningLanguage.g:2449:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalMachineLearningLanguage.g:2450:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_46); if (state.failed) return current;
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

            // InternalMachineLearningLanguage.g:2466:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=75 && LA33_0<=94)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2467:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalMachineLearningLanguage.g:2467:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalMachineLearningLanguage.g:2468:5: lv_factor_1_0= ruleFactorRule
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
    // InternalMachineLearningLanguage.g:2489:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2489:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2490:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2496:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2502:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalMachineLearningLanguage.g:2503:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalMachineLearningLanguage.g:2503:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalMachineLearningLanguage.g:2504:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalMachineLearningLanguage.g:2504:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalMachineLearningLanguage.g:2505:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalMachineLearningLanguage.g:2505:4: (lv_literal_0_0= RULE_INT )
            // InternalMachineLearningLanguage.g:2506:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_46); if (state.failed) return current;
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

            // InternalMachineLearningLanguage.g:2522:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=75 && LA34_0<=94)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2523:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalMachineLearningLanguage.g:2523:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalMachineLearningLanguage.g:2524:5: lv_factor_1_0= ruleFactorRule
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
    // InternalMachineLearningLanguage.g:2545:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2545:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2546:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2552:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2558:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalMachineLearningLanguage.g:2559:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalMachineLearningLanguage.g:2559:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:2560:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:2560:3: (lv_value_0_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:2561:4: lv_value_0_0= RULE_STRING
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
    // InternalMachineLearningLanguage.g:2580:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:2580:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalMachineLearningLanguage.g:2581:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:2587:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2593:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalMachineLearningLanguage.g:2594:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalMachineLearningLanguage.g:2594:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalMachineLearningLanguage.g:2595:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalMachineLearningLanguage.g:2595:3: ()
            // InternalMachineLearningLanguage.g:2596:4: 
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

            // InternalMachineLearningLanguage.g:2605:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==49) ) {
                alt35=1;
            }
            else if ( (LA35_0==50) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2606:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalMachineLearningLanguage.g:2606:4: ( (lv_value_1_0= 'true' ) )
                    // InternalMachineLearningLanguage.g:2607:5: (lv_value_1_0= 'true' )
                    {
                    // InternalMachineLearningLanguage.g:2607:5: (lv_value_1_0= 'true' )
                    // InternalMachineLearningLanguage.g:2608:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
                    // InternalMachineLearningLanguage.g:2621:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2630:1: entryRuleConstraintRule returns [EObject current=null] : iv_ruleConstraintRule= ruleConstraintRule EOF ;
    public final EObject entryRuleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRule = null;


        try {
            // InternalMachineLearningLanguage.g:2630:55: (iv_ruleConstraintRule= ruleConstraintRule EOF )
            // InternalMachineLearningLanguage.g:2631:2: iv_ruleConstraintRule= ruleConstraintRule EOF
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
    // InternalMachineLearningLanguage.g:2637:1: ruleConstraintRule returns [EObject current=null] : (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) ;
    public final EObject ruleConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_InstanceLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2643:2: ( (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) )
            // InternalMachineLearningLanguage.g:2644:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            {
            // InternalMachineLearningLanguage.g:2644:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            // InternalMachineLearningLanguage.g:2645:3: otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule
            {
            otherlv_0=(Token)match(input,51,FOLLOW_47); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2664:1: entryRuleAttributeDefinitionRule returns [EObject current=null] : iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF ;
    public final EObject entryRuleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDefinitionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2664:64: (iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF )
            // InternalMachineLearningLanguage.g:2665:2: iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF
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
    // InternalMachineLearningLanguage.g:2671:1: ruleAttributeDefinitionRule returns [EObject current=null] : ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeRule ) ) (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )? otherlv_6= ';' ) ;
    public final EObject ruleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_constraints_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_initialisation_5_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2677:2: ( ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeRule ) ) (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )? otherlv_6= ';' ) )
            // InternalMachineLearningLanguage.g:2678:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeRule ) ) (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )? otherlv_6= ';' )
            {
            // InternalMachineLearningLanguage.g:2678:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeRule ) ) (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )? otherlv_6= ';' )
            // InternalMachineLearningLanguage.g:2679:3: ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeRule ) ) (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )? otherlv_6= ';'
            {
            // InternalMachineLearningLanguage.g:2679:3: ( (lv_constraints_0_0= ruleConstraintRule ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==51) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:2680:4: (lv_constraints_0_0= ruleConstraintRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2680:4: (lv_constraints_0_0= ruleConstraintRule )
            	    // InternalMachineLearningLanguage.g:2681:5: lv_constraints_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_48);
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
            	    break loop36;
                }
            } while (true);

            // InternalMachineLearningLanguage.g:2698:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:2699:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:2699:4: (lv_name_1_0= ruleStringOrId )
            // InternalMachineLearningLanguage.g:2700:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_49);
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

            otherlv_2=(Token)match(input,52,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:2721:3: ( (lv_type_3_0= ruleTypeRule ) )
            // InternalMachineLearningLanguage.g:2722:4: (lv_type_3_0= ruleTypeRule )
            {
            // InternalMachineLearningLanguage.g:2722:4: (lv_type_3_0= ruleTypeRule )
            // InternalMachineLearningLanguage.g:2723:5: lv_type_3_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_51);
            lv_type_3_0=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:2740:3: (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==48) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2741:4: otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) )
                    {
                    otherlv_4=(Token)match(input,48,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_4_0());
                      			
                    }
                    // InternalMachineLearningLanguage.g:2745:4: ( (lv_initialisation_5_0= ruleExpressionRule ) )
                    // InternalMachineLearningLanguage.g:2746:5: (lv_initialisation_5_0= ruleExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:2746:5: (lv_initialisation_5_0= ruleExpressionRule )
                    // InternalMachineLearningLanguage.g:2747:6: lv_initialisation_5_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    lv_initialisation_5_0=ruleExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
                      						}
                      						set(
                      							current,
                      							"initialisation",
                      							lv_initialisation_5_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_5());
              		
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
    // InternalMachineLearningLanguage.g:2773:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:2773:49: (iv_ruleTypeRule= ruleTypeRule EOF )
            // InternalMachineLearningLanguage.g:2774:2: iv_ruleTypeRule= ruleTypeRule EOF
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
    // InternalMachineLearningLanguage.g:2780:1: ruleTypeRule returns [EObject current=null] : (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_ArrayTypeRule_4= ruleArrayTypeRule | this_InstanceTypeRule_5= ruleInstanceTypeRule | this_VoidTypeRule_6= ruleVoidTypeRule | this_ExpressionTypeRule_7= ruleExpressionTypeRule | this_LiteralTypeRule_8= ruleLiteralTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject this_StringTypeRule_0 = null;

        EObject this_IntTypeRule_1 = null;

        EObject this_RealTypeRule_2 = null;

        EObject this_BooleanTypeRule_3 = null;

        EObject this_ArrayTypeRule_4 = null;

        EObject this_InstanceTypeRule_5 = null;

        EObject this_VoidTypeRule_6 = null;

        EObject this_ExpressionTypeRule_7 = null;

        EObject this_LiteralTypeRule_8 = null;

        EObject this_DataTypeRule_9 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2786:2: ( (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_ArrayTypeRule_4= ruleArrayTypeRule | this_InstanceTypeRule_5= ruleInstanceTypeRule | this_VoidTypeRule_6= ruleVoidTypeRule | this_ExpressionTypeRule_7= ruleExpressionTypeRule | this_LiteralTypeRule_8= ruleLiteralTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) )
            // InternalMachineLearningLanguage.g:2787:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_ArrayTypeRule_4= ruleArrayTypeRule | this_InstanceTypeRule_5= ruleInstanceTypeRule | this_VoidTypeRule_6= ruleVoidTypeRule | this_ExpressionTypeRule_7= ruleExpressionTypeRule | this_LiteralTypeRule_8= ruleLiteralTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            {
            // InternalMachineLearningLanguage.g:2787:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_ArrayTypeRule_4= ruleArrayTypeRule | this_InstanceTypeRule_5= ruleInstanceTypeRule | this_VoidTypeRule_6= ruleVoidTypeRule | this_ExpressionTypeRule_7= ruleExpressionTypeRule | this_LiteralTypeRule_8= ruleLiteralTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            int alt38=10;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt38=1;
                }
                break;
            case 57:
                {
                alt38=2;
                }
                break;
            case 58:
                {
                alt38=3;
                }
                break;
            case 59:
                {
                alt38=4;
                }
                break;
            case 61:
                {
                alt38=5;
                }
                break;
            case 54:
                {
                alt38=6;
                }
                break;
            case 60:
                {
                alt38=7;
                }
                break;
            case 56:
                {
                alt38=8;
                }
                break;
            case 53:
                {
                alt38=9;
                }
                break;
            case 47:
                {
                alt38=10;
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
                    // InternalMachineLearningLanguage.g:2788:3: this_StringTypeRule_0= ruleStringTypeRule
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
                    // InternalMachineLearningLanguage.g:2800:3: this_IntTypeRule_1= ruleIntTypeRule
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
                    // InternalMachineLearningLanguage.g:2812:3: this_RealTypeRule_2= ruleRealTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getRealTypeRuleParserRuleCall_2());
                      		
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
                    // InternalMachineLearningLanguage.g:2824:3: this_BooleanTypeRule_3= ruleBooleanTypeRule
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
                    // InternalMachineLearningLanguage.g:2836:3: this_ArrayTypeRule_4= ruleArrayTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArrayTypeRule_4=ruleArrayTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArrayTypeRule_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalMachineLearningLanguage.g:2848:3: this_InstanceTypeRule_5= ruleInstanceTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getInstanceTypeRuleParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_InstanceTypeRule_5=ruleInstanceTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_InstanceTypeRule_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalMachineLearningLanguage.g:2860:3: this_VoidTypeRule_6= ruleVoidTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getVoidTypeRuleParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VoidTypeRule_6=ruleVoidTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VoidTypeRule_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalMachineLearningLanguage.g:2872:3: this_ExpressionTypeRule_7= ruleExpressionTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExpressionTypeRule_7=ruleExpressionTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExpressionTypeRule_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalMachineLearningLanguage.g:2884:3: this_LiteralTypeRule_8= ruleLiteralTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralTypeRule_8=ruleLiteralTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralTypeRule_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalMachineLearningLanguage.g:2896:3: this_DataTypeRule_9= ruleDataTypeRule
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
    // InternalMachineLearningLanguage.g:2911:1: entryRuleLiteralTypeRule returns [EObject current=null] : iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF ;
    public final EObject entryRuleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:2911:56: (iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF )
            // InternalMachineLearningLanguage.g:2912:2: iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF
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
    // InternalMachineLearningLanguage.g:2918:1: ruleLiteralTypeRule returns [EObject current=null] : ( () otherlv_1= 'literal' ) ;
    public final EObject ruleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2924:2: ( ( () otherlv_1= 'literal' ) )
            // InternalMachineLearningLanguage.g:2925:2: ( () otherlv_1= 'literal' )
            {
            // InternalMachineLearningLanguage.g:2925:2: ( () otherlv_1= 'literal' )
            // InternalMachineLearningLanguage.g:2926:3: () otherlv_1= 'literal'
            {
            // InternalMachineLearningLanguage.g:2926:3: ()
            // InternalMachineLearningLanguage.g:2927:4: 
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

            otherlv_1=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2944:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:2944:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalMachineLearningLanguage.g:2945:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
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
    // InternalMachineLearningLanguage.g:2951:1: ruleDataTypeRule returns [EObject current=null] : ( () otherlv_1= 'data' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2957:2: ( ( () otherlv_1= 'data' ) )
            // InternalMachineLearningLanguage.g:2958:2: ( () otherlv_1= 'data' )
            {
            // InternalMachineLearningLanguage.g:2958:2: ( () otherlv_1= 'data' )
            // InternalMachineLearningLanguage.g:2959:3: () otherlv_1= 'data'
            {
            // InternalMachineLearningLanguage.g:2959:3: ()
            // InternalMachineLearningLanguage.g:2960:4: 
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

            otherlv_1=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleInstanceTypeRule"
    // InternalMachineLearningLanguage.g:2977:1: entryRuleInstanceTypeRule returns [EObject current=null] : iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF ;
    public final EObject entryRuleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:2977:57: (iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF )
            // InternalMachineLearningLanguage.g:2978:2: iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF
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
    // InternalMachineLearningLanguage.g:2984:1: ruleInstanceTypeRule returns [EObject current=null] : ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2990:2: ( ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalMachineLearningLanguage.g:2991:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalMachineLearningLanguage.g:2991:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalMachineLearningLanguage.g:2992:3: () otherlv_1= 'instance' ( ( ruleQualifiedName ) )
            {
            // InternalMachineLearningLanguage.g:2992:3: ()
            // InternalMachineLearningLanguage.g:2993:4: 
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

            otherlv_1=(Token)match(input,54,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:3006:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:3007:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:3007:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:3008:5: ruleQualifiedName
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
    // InternalMachineLearningLanguage.g:3029:1: entryRuleStringTypeRule returns [EObject current=null] : iv_ruleStringTypeRule= ruleStringTypeRule EOF ;
    public final EObject entryRuleStringTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:3029:55: (iv_ruleStringTypeRule= ruleStringTypeRule EOF )
            // InternalMachineLearningLanguage.g:3030:2: iv_ruleStringTypeRule= ruleStringTypeRule EOF
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
    // InternalMachineLearningLanguage.g:3036:1: ruleStringTypeRule returns [EObject current=null] : ( () otherlv_1= 'string' ) ;
    public final EObject ruleStringTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3042:2: ( ( () otherlv_1= 'string' ) )
            // InternalMachineLearningLanguage.g:3043:2: ( () otherlv_1= 'string' )
            {
            // InternalMachineLearningLanguage.g:3043:2: ( () otherlv_1= 'string' )
            // InternalMachineLearningLanguage.g:3044:3: () otherlv_1= 'string'
            {
            // InternalMachineLearningLanguage.g:3044:3: ()
            // InternalMachineLearningLanguage.g:3045:4: 
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

            otherlv_1=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3062:1: entryRuleExpressionTypeRule returns [EObject current=null] : iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF ;
    public final EObject entryRuleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:3062:59: (iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF )
            // InternalMachineLearningLanguage.g:3063:2: iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF
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
    // InternalMachineLearningLanguage.g:3069:1: ruleExpressionTypeRule returns [EObject current=null] : ( () otherlv_1= 'expression' ) ;
    public final EObject ruleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3075:2: ( ( () otherlv_1= 'expression' ) )
            // InternalMachineLearningLanguage.g:3076:2: ( () otherlv_1= 'expression' )
            {
            // InternalMachineLearningLanguage.g:3076:2: ( () otherlv_1= 'expression' )
            // InternalMachineLearningLanguage.g:3077:3: () otherlv_1= 'expression'
            {
            // InternalMachineLearningLanguage.g:3077:3: ()
            // InternalMachineLearningLanguage.g:3078:4: 
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

            otherlv_1=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3095:1: entryRuleIntTypeRule returns [EObject current=null] : iv_ruleIntTypeRule= ruleIntTypeRule EOF ;
    public final EObject entryRuleIntTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:3095:52: (iv_ruleIntTypeRule= ruleIntTypeRule EOF )
            // InternalMachineLearningLanguage.g:3096:2: iv_ruleIntTypeRule= ruleIntTypeRule EOF
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
    // InternalMachineLearningLanguage.g:3102:1: ruleIntTypeRule returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3108:2: ( ( () otherlv_1= 'int' ) )
            // InternalMachineLearningLanguage.g:3109:2: ( () otherlv_1= 'int' )
            {
            // InternalMachineLearningLanguage.g:3109:2: ( () otherlv_1= 'int' )
            // InternalMachineLearningLanguage.g:3110:3: () otherlv_1= 'int'
            {
            // InternalMachineLearningLanguage.g:3110:3: ()
            // InternalMachineLearningLanguage.g:3111:4: 
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

            otherlv_1=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3128:1: entryRuleRealTypeRule returns [EObject current=null] : iv_ruleRealTypeRule= ruleRealTypeRule EOF ;
    public final EObject entryRuleRealTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:3128:53: (iv_ruleRealTypeRule= ruleRealTypeRule EOF )
            // InternalMachineLearningLanguage.g:3129:2: iv_ruleRealTypeRule= ruleRealTypeRule EOF
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
    // InternalMachineLearningLanguage.g:3135:1: ruleRealTypeRule returns [EObject current=null] : ( () otherlv_1= 'real' ) ;
    public final EObject ruleRealTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3141:2: ( ( () otherlv_1= 'real' ) )
            // InternalMachineLearningLanguage.g:3142:2: ( () otherlv_1= 'real' )
            {
            // InternalMachineLearningLanguage.g:3142:2: ( () otherlv_1= 'real' )
            // InternalMachineLearningLanguage.g:3143:3: () otherlv_1= 'real'
            {
            // InternalMachineLearningLanguage.g:3143:3: ()
            // InternalMachineLearningLanguage.g:3144:4: 
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

            otherlv_1=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3161:1: entryRuleBooleanTypeRule returns [EObject current=null] : iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF ;
    public final EObject entryRuleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:3161:56: (iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF )
            // InternalMachineLearningLanguage.g:3162:2: iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF
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
    // InternalMachineLearningLanguage.g:3168:1: ruleBooleanTypeRule returns [EObject current=null] : ( () otherlv_1= 'boolean' ) ;
    public final EObject ruleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3174:2: ( ( () otherlv_1= 'boolean' ) )
            // InternalMachineLearningLanguage.g:3175:2: ( () otherlv_1= 'boolean' )
            {
            // InternalMachineLearningLanguage.g:3175:2: ( () otherlv_1= 'boolean' )
            // InternalMachineLearningLanguage.g:3176:3: () otherlv_1= 'boolean'
            {
            // InternalMachineLearningLanguage.g:3176:3: ()
            // InternalMachineLearningLanguage.g:3177:4: 
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

            otherlv_1=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3194:1: entryRuleVoidTypeRule returns [EObject current=null] : iv_ruleVoidTypeRule= ruleVoidTypeRule EOF ;
    public final EObject entryRuleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoidTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:3194:53: (iv_ruleVoidTypeRule= ruleVoidTypeRule EOF )
            // InternalMachineLearningLanguage.g:3195:2: iv_ruleVoidTypeRule= ruleVoidTypeRule EOF
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
    // InternalMachineLearningLanguage.g:3201:1: ruleVoidTypeRule returns [EObject current=null] : ( () otherlv_1= 'void' ) ;
    public final EObject ruleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3207:2: ( ( () otherlv_1= 'void' ) )
            // InternalMachineLearningLanguage.g:3208:2: ( () otherlv_1= 'void' )
            {
            // InternalMachineLearningLanguage.g:3208:2: ( () otherlv_1= 'void' )
            // InternalMachineLearningLanguage.g:3209:3: () otherlv_1= 'void'
            {
            // InternalMachineLearningLanguage.g:3209:3: ()
            // InternalMachineLearningLanguage.g:3210:4: 
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

            otherlv_1=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3227:1: entryRuleArrayTypeRule returns [EObject current=null] : iv_ruleArrayTypeRule= ruleArrayTypeRule EOF ;
    public final EObject entryRuleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:3227:54: (iv_ruleArrayTypeRule= ruleArrayTypeRule EOF )
            // InternalMachineLearningLanguage.g:3228:2: iv_ruleArrayTypeRule= ruleArrayTypeRule EOF
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
    // InternalMachineLearningLanguage.g:3234:1: ruleArrayTypeRule returns [EObject current=null] : (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) ;
    public final EObject ruleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3240:2: ( (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) )
            // InternalMachineLearningLanguage.g:3241:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            {
            // InternalMachineLearningLanguage.g:3241:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            // InternalMachineLearningLanguage.g:3242:3: otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:3246:3: ( (lv_elements_1_0= ruleTypeRule ) )
            // InternalMachineLearningLanguage.g:3247:4: (lv_elements_1_0= ruleTypeRule )
            {
            // InternalMachineLearningLanguage.g:3247:4: (lv_elements_1_0= ruleTypeRule )
            // InternalMachineLearningLanguage.g:3248:5: lv_elements_1_0= ruleTypeRule
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
    // InternalMachineLearningLanguage.g:3269:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // InternalMachineLearningLanguage.g:3269:54: (iv_ruleParameterRule= ruleParameterRule EOF )
            // InternalMachineLearningLanguage.g:3270:2: iv_ruleParameterRule= ruleParameterRule EOF
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
    // InternalMachineLearningLanguage.g:3276:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3282:2: ( ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) )
            // InternalMachineLearningLanguage.g:3283:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            {
            // InternalMachineLearningLanguage.g:3283:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            // InternalMachineLearningLanguage.g:3284:3: ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) )
            {
            // InternalMachineLearningLanguage.g:3284:3: ( (lv_type_0_0= ruleTypeRule ) )
            // InternalMachineLearningLanguage.g:3285:4: (lv_type_0_0= ruleTypeRule )
            {
            // InternalMachineLearningLanguage.g:3285:4: (lv_type_0_0= ruleTypeRule )
            // InternalMachineLearningLanguage.g:3286:5: lv_type_0_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_4);
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

            // InternalMachineLearningLanguage.g:3303:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:3304:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:3304:4: (lv_name_1_0= ruleStringOrId )
            // InternalMachineLearningLanguage.g:3305:5: lv_name_1_0= ruleStringOrId
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


    // $ANTLR start "entryRuleImportRule"
    // InternalMachineLearningLanguage.g:3326:1: entryRuleImportRule returns [EObject current=null] : iv_ruleImportRule= ruleImportRule EOF ;
    public final EObject entryRuleImportRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRule = null;


        try {
            // InternalMachineLearningLanguage.g:3326:51: (iv_ruleImportRule= ruleImportRule EOF )
            // InternalMachineLearningLanguage.g:3327:2: iv_ruleImportRule= ruleImportRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportRule=ruleImportRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportRule; 
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
    // $ANTLR end "entryRuleImportRule"


    // $ANTLR start "ruleImportRule"
    // InternalMachineLearningLanguage.g:3333:1: ruleImportRule returns [EObject current=null] : (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' ) ;
    public final EObject ruleImportRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_language_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_importedNamespace_3_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3339:2: ( (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' ) )
            // InternalMachineLearningLanguage.g:3340:2: (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' )
            {
            // InternalMachineLearningLanguage.g:3340:2: (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' )
            // InternalMachineLearningLanguage.g:3341:3: otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportRuleAccess().getImportKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:3345:3: ( (lv_language_1_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:3346:4: (lv_language_1_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:3346:4: (lv_language_1_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:3347:5: lv_language_1_0= RULE_STRING
            {
            lv_language_1_0=(Token)match(input,RULE_STRING,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_language_1_0, grammarAccess.getImportRuleAccess().getLanguageSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"language",
              						lv_language_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getImportRuleAccess().getFromKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:3367:3: ( (lv_importedNamespace_3_0= ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:3368:4: (lv_importedNamespace_3_0= ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:3368:4: (lv_importedNamespace_3_0= ruleQualifiedName )
            // InternalMachineLearningLanguage.g:3369:5: lv_importedNamespace_3_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_importedNamespace_3_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getImportRuleRule());
              					}
              					set(
              						current,
              						"importedNamespace",
              						lv_importedNamespace_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getImportRuleAccess().getSemicolonKeyword_4());
              		
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
    // $ANTLR end "ruleImportRule"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalMachineLearningLanguage.g:3394:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalMachineLearningLanguage.g:3394:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalMachineLearningLanguage.g:3395:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalMachineLearningLanguage.g:3401:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_0 = null;

        AntlrDatatypeRuleToken this_StringOrId_2 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3407:2: ( (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) )
            // InternalMachineLearningLanguage.g:3408:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            {
            // InternalMachineLearningLanguage.g:3408:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            // InternalMachineLearningLanguage.g:3409:3: this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_52);
            this_StringOrId_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_StringOrId_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMachineLearningLanguage.g:3419:3: (kw= '.' this_StringOrId_2= ruleStringOrId )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==63) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:3420:4: kw= '.' this_StringOrId_2= ruleStringOrId
            	    {
            	    kw=(Token)match(input,63,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_52);
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
            	    break loop39;
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
    // InternalMachineLearningLanguage.g:3440:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalMachineLearningLanguage.g:3440:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalMachineLearningLanguage.g:3441:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalMachineLearningLanguage.g:3447:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3453:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalMachineLearningLanguage.g:3454:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalMachineLearningLanguage.g:3454:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_QUOTED_ID) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3455:3: this_QUOTED_ID_0= RULE_QUOTED_ID
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
                    // InternalMachineLearningLanguage.g:3463:3: this_ID_1= RULE_ID
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
    // InternalMachineLearningLanguage.g:3474:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalMachineLearningLanguage.g:3480:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalMachineLearningLanguage.g:3481:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalMachineLearningLanguage.g:3481:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt41=6;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt41=1;
                }
                break;
            case 65:
                {
                alt41=2;
                }
                break;
            case 66:
                {
                alt41=3;
                }
                break;
            case 67:
                {
                alt41=4;
                }
                break;
            case 68:
                {
                alt41=5;
                }
                break;
            case 69:
                {
                alt41=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3482:3: (enumLiteral_0= '>=' )
                    {
                    // InternalMachineLearningLanguage.g:3482:3: (enumLiteral_0= '>=' )
                    // InternalMachineLearningLanguage.g:3483:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:3490:3: (enumLiteral_1= '>' )
                    {
                    // InternalMachineLearningLanguage.g:3490:3: (enumLiteral_1= '>' )
                    // InternalMachineLearningLanguage.g:3491:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMachineLearningLanguage.g:3498:3: (enumLiteral_2= '=' )
                    {
                    // InternalMachineLearningLanguage.g:3498:3: (enumLiteral_2= '=' )
                    // InternalMachineLearningLanguage.g:3499:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMachineLearningLanguage.g:3506:3: (enumLiteral_3= '!=' )
                    {
                    // InternalMachineLearningLanguage.g:3506:3: (enumLiteral_3= '!=' )
                    // InternalMachineLearningLanguage.g:3507:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalMachineLearningLanguage.g:3514:3: (enumLiteral_4= '<' )
                    {
                    // InternalMachineLearningLanguage.g:3514:3: (enumLiteral_4= '<' )
                    // InternalMachineLearningLanguage.g:3515:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMachineLearningLanguage.g:3522:3: (enumLiteral_5= '<=' )
                    {
                    // InternalMachineLearningLanguage.g:3522:3: (enumLiteral_5= '<=' )
                    // InternalMachineLearningLanguage.g:3523:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3533:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3539:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalMachineLearningLanguage.g:3540:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalMachineLearningLanguage.g:3540:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==70) ) {
                alt42=1;
            }
            else if ( (LA42_0==71) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3541:3: (enumLiteral_0= '+' )
                    {
                    // InternalMachineLearningLanguage.g:3541:3: (enumLiteral_0= '+' )
                    // InternalMachineLearningLanguage.g:3542:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:3549:3: (enumLiteral_1= '-' )
                    {
                    // InternalMachineLearningLanguage.g:3549:3: (enumLiteral_1= '-' )
                    // InternalMachineLearningLanguage.g:3550:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3560:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3566:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalMachineLearningLanguage.g:3567:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalMachineLearningLanguage.g:3567:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt43=1;
                }
                break;
            case 73:
                {
                alt43=2;
                }
                break;
            case 74:
                {
                alt43=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3568:3: (enumLiteral_0= '*' )
                    {
                    // InternalMachineLearningLanguage.g:3568:3: (enumLiteral_0= '*' )
                    // InternalMachineLearningLanguage.g:3569:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:3576:3: (enumLiteral_1= '/' )
                    {
                    // InternalMachineLearningLanguage.g:3576:3: (enumLiteral_1= '/' )
                    // InternalMachineLearningLanguage.g:3577:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMachineLearningLanguage.g:3584:3: (enumLiteral_2= '%' )
                    {
                    // InternalMachineLearningLanguage.g:3584:3: (enumLiteral_2= '%' )
                    // InternalMachineLearningLanguage.g:3585:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3595:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalMachineLearningLanguage.g:3601:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalMachineLearningLanguage.g:3602:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalMachineLearningLanguage.g:3602:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt44=20;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt44=1;
                }
                break;
            case 76:
                {
                alt44=2;
                }
                break;
            case 77:
                {
                alt44=3;
                }
                break;
            case 78:
                {
                alt44=4;
                }
                break;
            case 79:
                {
                alt44=5;
                }
                break;
            case 80:
                {
                alt44=6;
                }
                break;
            case 81:
                {
                alt44=7;
                }
                break;
            case 82:
                {
                alt44=8;
                }
                break;
            case 83:
                {
                alt44=9;
                }
                break;
            case 84:
                {
                alt44=10;
                }
                break;
            case 85:
                {
                alt44=11;
                }
                break;
            case 86:
                {
                alt44=12;
                }
                break;
            case 87:
                {
                alt44=13;
                }
                break;
            case 88:
                {
                alt44=14;
                }
                break;
            case 89:
                {
                alt44=15;
                }
                break;
            case 90:
                {
                alt44=16;
                }
                break;
            case 91:
                {
                alt44=17;
                }
                break;
            case 92:
                {
                alt44=18;
                }
                break;
            case 93:
                {
                alt44=19;
                }
                break;
            case 94:
                {
                alt44=20;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3603:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalMachineLearningLanguage.g:3603:3: (enumLiteral_0= 'Y' )
                    // InternalMachineLearningLanguage.g:3604:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:3611:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalMachineLearningLanguage.g:3611:3: (enumLiteral_1= 'Z' )
                    // InternalMachineLearningLanguage.g:3612:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMachineLearningLanguage.g:3619:3: (enumLiteral_2= 'E' )
                    {
                    // InternalMachineLearningLanguage.g:3619:3: (enumLiteral_2= 'E' )
                    // InternalMachineLearningLanguage.g:3620:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMachineLearningLanguage.g:3627:3: (enumLiteral_3= 'P' )
                    {
                    // InternalMachineLearningLanguage.g:3627:3: (enumLiteral_3= 'P' )
                    // InternalMachineLearningLanguage.g:3628:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalMachineLearningLanguage.g:3635:3: (enumLiteral_4= 'T' )
                    {
                    // InternalMachineLearningLanguage.g:3635:3: (enumLiteral_4= 'T' )
                    // InternalMachineLearningLanguage.g:3636:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMachineLearningLanguage.g:3643:3: (enumLiteral_5= 'G' )
                    {
                    // InternalMachineLearningLanguage.g:3643:3: (enumLiteral_5= 'G' )
                    // InternalMachineLearningLanguage.g:3644:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalMachineLearningLanguage.g:3651:3: (enumLiteral_6= 'M' )
                    {
                    // InternalMachineLearningLanguage.g:3651:3: (enumLiteral_6= 'M' )
                    // InternalMachineLearningLanguage.g:3652:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalMachineLearningLanguage.g:3659:3: (enumLiteral_7= 'k' )
                    {
                    // InternalMachineLearningLanguage.g:3659:3: (enumLiteral_7= 'k' )
                    // InternalMachineLearningLanguage.g:3660:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalMachineLearningLanguage.g:3667:3: (enumLiteral_8= 'h' )
                    {
                    // InternalMachineLearningLanguage.g:3667:3: (enumLiteral_8= 'h' )
                    // InternalMachineLearningLanguage.g:3668:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalMachineLearningLanguage.g:3675:3: (enumLiteral_9= 'da' )
                    {
                    // InternalMachineLearningLanguage.g:3675:3: (enumLiteral_9= 'da' )
                    // InternalMachineLearningLanguage.g:3676:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalMachineLearningLanguage.g:3683:3: (enumLiteral_10= 'd' )
                    {
                    // InternalMachineLearningLanguage.g:3683:3: (enumLiteral_10= 'd' )
                    // InternalMachineLearningLanguage.g:3684:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalMachineLearningLanguage.g:3691:3: (enumLiteral_11= 'c' )
                    {
                    // InternalMachineLearningLanguage.g:3691:3: (enumLiteral_11= 'c' )
                    // InternalMachineLearningLanguage.g:3692:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalMachineLearningLanguage.g:3699:3: (enumLiteral_12= 'm' )
                    {
                    // InternalMachineLearningLanguage.g:3699:3: (enumLiteral_12= 'm' )
                    // InternalMachineLearningLanguage.g:3700:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalMachineLearningLanguage.g:3707:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalMachineLearningLanguage.g:3707:3: (enumLiteral_13= '\\u00B5' )
                    // InternalMachineLearningLanguage.g:3708:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalMachineLearningLanguage.g:3715:3: (enumLiteral_14= 'n' )
                    {
                    // InternalMachineLearningLanguage.g:3715:3: (enumLiteral_14= 'n' )
                    // InternalMachineLearningLanguage.g:3716:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalMachineLearningLanguage.g:3723:3: (enumLiteral_15= 'p' )
                    {
                    // InternalMachineLearningLanguage.g:3723:3: (enumLiteral_15= 'p' )
                    // InternalMachineLearningLanguage.g:3724:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                      			
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalMachineLearningLanguage.g:3731:3: (enumLiteral_16= 'f' )
                    {
                    // InternalMachineLearningLanguage.g:3731:3: (enumLiteral_16= 'f' )
                    // InternalMachineLearningLanguage.g:3732:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalMachineLearningLanguage.g:3739:3: (enumLiteral_17= 'a' )
                    {
                    // InternalMachineLearningLanguage.g:3739:3: (enumLiteral_17= 'a' )
                    // InternalMachineLearningLanguage.g:3740:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                      			
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalMachineLearningLanguage.g:3747:3: (enumLiteral_18= 'z' )
                    {
                    // InternalMachineLearningLanguage.g:3747:3: (enumLiteral_18= 'z' )
                    // InternalMachineLearningLanguage.g:3748:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                      			
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalMachineLearningLanguage.g:3755:3: (enumLiteral_19= 'y' )
                    {
                    // InternalMachineLearningLanguage.g:3755:3: (enumLiteral_19= 'y' )
                    // InternalMachineLearningLanguage.g:3756:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
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

    // $ANTLR start synpred16_InternalMachineLearningLanguage
    public final void synpred16_InternalMachineLearningLanguage_fragment() throws RecognitionException {   
        EObject this_ConstantReferenceRule_0 = null;


        // InternalMachineLearningLanguage.g:1084:3: (this_ConstantReferenceRule_0= ruleConstantReferenceRule )
        // InternalMachineLearningLanguage.g:1084:3: this_ConstantReferenceRule_0= ruleConstantReferenceRule
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_ConstantReferenceRule_0=ruleConstantReferenceRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalMachineLearningLanguage

    // Delegated rules

    public final boolean synpred16_InternalMachineLearningLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalMachineLearningLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA25 dfa25 = new DFA25(this);
    static final String dfa_1s = "\31\uffff";
    static final String dfa_2s = "\1\46\1\4\1\26\1\uffff\24\26\1\uffff";
    static final String dfa_3s = "\1\46\1\62\1\136\1\uffff\24\47\1\uffff";
    static final String dfa_4s = "\3\uffff\1\2\24\uffff\1\1";
    static final String dfa_5s = "\31\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\2\3\1\2\2\3\30\uffff\1\3\4\uffff\1\3\10\uffff\1\3\1\uffff\2\3",
            "\1\3\1\30\17\uffff\1\3\43\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27",
            "",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            "\1\3\1\30\17\uffff\1\3",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "874:2: (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule )";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_9s = "\1\4\1\uffff\2\20\3\uffff\1\7\1\uffff\2\20";
    static final String dfa_10s = "\1\62\1\uffff\2\112\3\uffff\1\10\1\uffff\2\112";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\3\4\1\2\1\3\30\uffff\1\5\4\uffff\1\1\10\uffff\1\6\1\uffff\2\4",
            "",
            "\1\4\5\uffff\1\6\12\uffff\1\10\2\6\3\uffff\1\6\2\uffff\3\6\1\uffff\1\6\20\uffff\1\7\13\6",
            "\1\4\5\uffff\1\6\12\uffff\1\10\2\6\3\uffff\1\6\2\uffff\3\6\1\uffff\1\6\20\uffff\1\7\13\6",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\1\4\5\uffff\1\6\12\uffff\1\10\2\6\3\uffff\1\6\2\uffff\3\6\1\uffff\1\6\20\uffff\1\7\13\6",
            "\1\4\5\uffff\1\6\12\uffff\1\10\2\6\3\uffff\1\6\2\uffff\3\6\1\uffff\1\6\20\uffff\1\7\13\6"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1832:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x4000000000008000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000080040000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001400002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001104000180L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0006A046000001F0L,0x00000000000000C0L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0006A042000001F0L,0x00000000000000C0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008000400000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003FL});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000700L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0006A0C2000001F0L,0x00000000000000C0L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000020180L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000002L,0x000000007FFFF800L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x00060000000001F0L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0008000000000180L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x3FE0800000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001000800000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x8000000000000002L});

}
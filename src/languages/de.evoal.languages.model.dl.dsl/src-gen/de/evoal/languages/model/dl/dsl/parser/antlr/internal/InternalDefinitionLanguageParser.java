package de.evoal.languages.model.dl.dsl.parser.antlr.internal;

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
import de.evoal.languages.model.dl.dsl.services.DefinitionLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalDefinitionLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_QUOTED_ID", "RULE_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'{'", "'}'", "'enum'", "'('", "','", "')'", "'with'", "'constraints'", "':'", "';'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'['", "']'", "'self'", "'value'", "'.'", "'tree'", "'data'", "'instance'", "':='", "'true'", "'false'", "'abstract'", "'type'", "'extends'", "'@'", "'optional'", "'literal'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'def'", "'const'", "'import'", "'from'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
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
    public static final int RULE_INT=5;
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
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_DOUBLE=4;
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


        public InternalDefinitionLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDefinitionLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDefinitionLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDefinitionLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private DefinitionLanguageGrammarAccess grammarAccess;

        public InternalDefinitionLanguageParser(TokenStream input, DefinitionLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "DefinitionModelRule";
       	}

       	@Override
       	protected DefinitionLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDefinitionModelRule"
    // InternalDefinitionLanguage.g:72:1: entryRuleDefinitionModelRule returns [EObject current=null] : iv_ruleDefinitionModelRule= ruleDefinitionModelRule EOF ;
    public final EObject entryRuleDefinitionModelRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionModelRule = null;


        try {
            // InternalDefinitionLanguage.g:72:60: (iv_ruleDefinitionModelRule= ruleDefinitionModelRule EOF )
            // InternalDefinitionLanguage.g:73:2: iv_ruleDefinitionModelRule= ruleDefinitionModelRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefinitionModelRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefinitionModelRule=ruleDefinitionModelRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefinitionModelRule; 
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
    // $ANTLR end "entryRuleDefinitionModelRule"


    // $ANTLR start "ruleDefinitionModelRule"
    // InternalDefinitionLanguage.g:79:1: ruleDefinitionModelRule returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) ) | ( (lv_types_5_0= ruleClassDefinitionRule ) ) | ( (lv_functions_6_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_7_0= ruleConstantDefinitionRule ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleDefinitionModelRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_imports_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_enums_4_0 = null;

        EObject lv_types_5_0 = null;

        EObject lv_functions_6_0 = null;

        EObject lv_constants_7_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:85:2: ( ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) ) | ( (lv_types_5_0= ruleClassDefinitionRule ) ) | ( (lv_functions_6_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_7_0= ruleConstantDefinitionRule ) ) )* otherlv_8= '}' ) )
            // InternalDefinitionLanguage.g:86:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) ) | ( (lv_types_5_0= ruleClassDefinitionRule ) ) | ( (lv_functions_6_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_7_0= ruleConstantDefinitionRule ) ) )* otherlv_8= '}' )
            {
            // InternalDefinitionLanguage.g:86:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) ) | ( (lv_types_5_0= ruleClassDefinitionRule ) ) | ( (lv_functions_6_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_7_0= ruleConstantDefinitionRule ) ) )* otherlv_8= '}' )
            // InternalDefinitionLanguage.g:87:3: ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) ) | ( (lv_types_5_0= ruleClassDefinitionRule ) ) | ( (lv_functions_6_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_7_0= ruleConstantDefinitionRule ) ) )* otherlv_8= '}'
            {
            // InternalDefinitionLanguage.g:87:3: ( (lv_imports_0_0= ruleImportRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==57) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:88:4: (lv_imports_0_0= ruleImportRule )
            	    {
            	    // InternalDefinitionLanguage.g:88:4: (lv_imports_0_0= ruleImportRule )
            	    // InternalDefinitionLanguage.g:89:5: lv_imports_0_0= ruleImportRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getImportsImportRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImportRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDefinitionModelRuleRule());
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

              			newLeafNode(otherlv_1, grammarAccess.getDefinitionModelRuleAccess().getModuleKeyword_1());
              		
            }
            // InternalDefinitionLanguage.g:110:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:111:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:111:4: (lv_name_2_0= ruleQualifiedName )
            // InternalDefinitionLanguage.g:112:5: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDefinitionModelRuleRule());
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

              			newLeafNode(otherlv_3, grammarAccess.getDefinitionModelRuleAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalDefinitionLanguage.g:133:3: ( ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) ) | ( (lv_types_5_0= ruleClassDefinitionRule ) ) | ( (lv_functions_6_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_7_0= ruleConstantDefinitionRule ) ) )*
            loop2:
            do {
                int alt2=5;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:134:4: ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:134:4: ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) )
            	    // InternalDefinitionLanguage.g:135:5: (lv_enums_4_0= ruleEnumTypeDefinitionRule )
            	    {
            	    // InternalDefinitionLanguage.g:135:5: (lv_enums_4_0= ruleEnumTypeDefinitionRule )
            	    // InternalDefinitionLanguage.g:136:6: lv_enums_4_0= ruleEnumTypeDefinitionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getEnumsEnumTypeDefinitionRuleParserRuleCall_4_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_enums_4_0=ruleEnumTypeDefinitionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getDefinitionModelRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enums",
            	      							lv_enums_4_0,
            	      							"de.evoal.languages.model.dl.dsl.DefinitionLanguage.EnumTypeDefinitionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalDefinitionLanguage.g:154:4: ( (lv_types_5_0= ruleClassDefinitionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:154:4: ( (lv_types_5_0= ruleClassDefinitionRule ) )
            	    // InternalDefinitionLanguage.g:155:5: (lv_types_5_0= ruleClassDefinitionRule )
            	    {
            	    // InternalDefinitionLanguage.g:155:5: (lv_types_5_0= ruleClassDefinitionRule )
            	    // InternalDefinitionLanguage.g:156:6: lv_types_5_0= ruleClassDefinitionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getTypesClassDefinitionRuleParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_types_5_0=ruleClassDefinitionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getDefinitionModelRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"types",
            	      							lv_types_5_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.ClassDefinitionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalDefinitionLanguage.g:174:4: ( (lv_functions_6_0= ruleFunctionDefinitionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:174:4: ( (lv_functions_6_0= ruleFunctionDefinitionRule ) )
            	    // InternalDefinitionLanguage.g:175:5: (lv_functions_6_0= ruleFunctionDefinitionRule )
            	    {
            	    // InternalDefinitionLanguage.g:175:5: (lv_functions_6_0= ruleFunctionDefinitionRule )
            	    // InternalDefinitionLanguage.g:176:6: lv_functions_6_0= ruleFunctionDefinitionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getFunctionsFunctionDefinitionRuleParserRuleCall_4_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_functions_6_0=ruleFunctionDefinitionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getDefinitionModelRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"functions",
            	      							lv_functions_6_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.FunctionDefinitionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalDefinitionLanguage.g:194:4: ( (lv_constants_7_0= ruleConstantDefinitionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:194:4: ( (lv_constants_7_0= ruleConstantDefinitionRule ) )
            	    // InternalDefinitionLanguage.g:195:5: (lv_constants_7_0= ruleConstantDefinitionRule )
            	    {
            	    // InternalDefinitionLanguage.g:195:5: (lv_constants_7_0= ruleConstantDefinitionRule )
            	    // InternalDefinitionLanguage.g:196:6: lv_constants_7_0= ruleConstantDefinitionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getConstantsConstantDefinitionRuleParserRuleCall_4_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_constants_7_0=ruleConstantDefinitionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getDefinitionModelRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"constants",
            	      							lv_constants_7_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.ConstantDefinitionRule");
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

            otherlv_8=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getDefinitionModelRuleAccess().getRightCurlyBracketKeyword_5());
              		
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
    // $ANTLR end "ruleDefinitionModelRule"


    // $ANTLR start "entryRuleEnumLiteralRule"
    // InternalDefinitionLanguage.g:222:1: entryRuleEnumLiteralRule returns [EObject current=null] : iv_ruleEnumLiteralRule= ruleEnumLiteralRule EOF ;
    public final EObject entryRuleEnumLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:222:56: (iv_ruleEnumLiteralRule= ruleEnumLiteralRule EOF )
            // InternalDefinitionLanguage.g:223:2: iv_ruleEnumLiteralRule= ruleEnumLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteralRule=ruleEnumLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumLiteralRule; 
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
    // $ANTLR end "entryRuleEnumLiteralRule"


    // $ANTLR start "ruleEnumLiteralRule"
    // InternalDefinitionLanguage.g:229:1: ruleEnumLiteralRule returns [EObject current=null] : ( (lv_name_0_0= ruleStringOrId ) ) ;
    public final EObject ruleEnumLiteralRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:235:2: ( ( (lv_name_0_0= ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:236:2: ( (lv_name_0_0= ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:236:2: ( (lv_name_0_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:237:3: (lv_name_0_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:237:3: (lv_name_0_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:238:4: lv_name_0_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getEnumLiteralRuleAccess().getNameStringOrIdParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getEnumLiteralRuleRule());
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
    // $ANTLR end "ruleEnumLiteralRule"


    // $ANTLR start "entryRuleEnumTypeDefinitionRule"
    // InternalDefinitionLanguage.g:258:1: entryRuleEnumTypeDefinitionRule returns [EObject current=null] : iv_ruleEnumTypeDefinitionRule= ruleEnumTypeDefinitionRule EOF ;
    public final EObject entryRuleEnumTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumTypeDefinitionRule = null;


        try {
            // InternalDefinitionLanguage.g:258:63: (iv_ruleEnumTypeDefinitionRule= ruleEnumTypeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:259:2: iv_ruleEnumTypeDefinitionRule= ruleEnumTypeDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumTypeDefinitionRule=ruleEnumTypeDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumTypeDefinitionRule; 
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
    // $ANTLR end "entryRuleEnumTypeDefinitionRule"


    // $ANTLR start "ruleEnumTypeDefinitionRule"
    // InternalDefinitionLanguage.g:265:1: ruleEnumTypeDefinitionRule returns [EObject current=null] : ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'enum' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= '(' ( (lv_literals_5_0= ruleEnumLiteralRule ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )* otherlv_8= ')' (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= ';' ) ;
    public final EObject ruleEnumTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_constraints_0_0 = null;

        Enumerator lv_scale_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_literals_5_0 = null;

        EObject lv_literals_7_0 = null;

        EObject lv_constraints_12_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:271:2: ( ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'enum' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= '(' ( (lv_literals_5_0= ruleEnumLiteralRule ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )* otherlv_8= ')' (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= ';' ) )
            // InternalDefinitionLanguage.g:272:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'enum' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= '(' ( (lv_literals_5_0= ruleEnumLiteralRule ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )* otherlv_8= ')' (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= ';' )
            {
            // InternalDefinitionLanguage.g:272:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'enum' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= '(' ( (lv_literals_5_0= ruleEnumLiteralRule ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )* otherlv_8= ')' (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= ';' )
            // InternalDefinitionLanguage.g:273:3: ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'enum' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= '(' ( (lv_literals_5_0= ruleEnumLiteralRule ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )* otherlv_8= ')' (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= ';'
            {
            // InternalDefinitionLanguage.g:273:3: ( (lv_constraints_0_0= ruleConstraintRule ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==45) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:274:4: (lv_constraints_0_0= ruleConstraintRule )
            	    {
            	    // InternalDefinitionLanguage.g:274:4: (lv_constraints_0_0= ruleConstraintRule )
            	    // InternalDefinitionLanguage.g:275:5: lv_constraints_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_constraints_0_0=ruleConstraintRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getEnumTypeDefinitionRuleRule());
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
            	    break loop3;
                }
            } while (true);

            // InternalDefinitionLanguage.g:292:3: ( (lv_scale_1_0= ruleScaleType ) )
            // InternalDefinitionLanguage.g:293:4: (lv_scale_1_0= ruleScaleType )
            {
            // InternalDefinitionLanguage.g:293:4: (lv_scale_1_0= ruleScaleType )
            // InternalDefinitionLanguage.g:294:5: lv_scale_1_0= ruleScaleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getScaleScaleTypeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_scale_1_0=ruleScaleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumTypeDefinitionRuleRule());
              					}
              					set(
              						current,
              						"scale",
              						lv_scale_1_0,
              						"de.evoal.languages.model.dl.dsl.DefinitionLanguage.ScaleType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEnumTypeDefinitionRuleAccess().getEnumKeyword_2());
              		
            }
            // InternalDefinitionLanguage.g:315:3: ( (lv_name_3_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:316:4: (lv_name_3_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:316:4: (lv_name_3_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:317:5: lv_name_3_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_name_3_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumTypeDefinitionRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getEnumTypeDefinitionRuleAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalDefinitionLanguage.g:338:3: ( (lv_literals_5_0= ruleEnumLiteralRule ) )
            // InternalDefinitionLanguage.g:339:4: (lv_literals_5_0= ruleEnumLiteralRule )
            {
            // InternalDefinitionLanguage.g:339:4: (lv_literals_5_0= ruleEnumLiteralRule )
            // InternalDefinitionLanguage.g:340:5: lv_literals_5_0= ruleEnumLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsEnumLiteralRuleParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_literals_5_0=ruleEnumLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumTypeDefinitionRuleRule());
              					}
              					add(
              						current,
              						"literals",
              						lv_literals_5_0,
              						"de.evoal.languages.model.dl.dsl.DefinitionLanguage.EnumLiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDefinitionLanguage.g:357:3: (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:358:4: otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) )
            	    {
            	    otherlv_6=(Token)match(input,20,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getEnumTypeDefinitionRuleAccess().getCommaKeyword_6_0());
            	      			
            	    }
            	    // InternalDefinitionLanguage.g:362:4: ( (lv_literals_7_0= ruleEnumLiteralRule ) )
            	    // InternalDefinitionLanguage.g:363:5: (lv_literals_7_0= ruleEnumLiteralRule )
            	    {
            	    // InternalDefinitionLanguage.g:363:5: (lv_literals_7_0= ruleEnumLiteralRule )
            	    // InternalDefinitionLanguage.g:364:6: lv_literals_7_0= ruleEnumLiteralRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsEnumLiteralRuleParserRuleCall_6_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_literals_7_0=ruleEnumLiteralRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEnumTypeDefinitionRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"literals",
            	      							lv_literals_7_0,
            	      							"de.evoal.languages.model.dl.dsl.DefinitionLanguage.EnumLiteralRule");
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

            otherlv_8=(Token)match(input,21,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getEnumTypeDefinitionRuleAccess().getRightParenthesisKeyword_7());
              		
            }
            // InternalDefinitionLanguage.g:386:3: (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==22) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDefinitionLanguage.g:387:4: otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )*
                    {
                    otherlv_9=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getEnumTypeDefinitionRuleAccess().getWithKeyword_8_0());
                      			
                    }
                    otherlv_10=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsKeyword_8_1());
                      			
                    }
                    otherlv_11=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getEnumTypeDefinitionRuleAccess().getColonKeyword_8_2());
                      			
                    }
                    // InternalDefinitionLanguage.g:399:4: ( (lv_constraints_12_0= ruleStatementRule ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=RULE_DOUBLE && LA5_0<=RULE_ID)||LA5_0==19||LA5_0==29||LA5_0==31||(LA5_0>=33 && LA5_0<=34)||(LA5_0>=36 && LA5_0<=38)||(LA5_0>=40 && LA5_0<=41)||(LA5_0>=69 && LA5_0<=70)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalDefinitionLanguage.g:400:5: (lv_constraints_12_0= ruleStatementRule )
                    	    {
                    	    // InternalDefinitionLanguage.g:400:5: (lv_constraints_12_0= ruleStatementRule )
                    	    // InternalDefinitionLanguage.g:401:6: lv_constraints_12_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsStatementRuleParserRuleCall_8_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_14);
                    	    lv_constraints_12_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getEnumTypeDefinitionRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constraints",
                    	      							lv_constraints_12_0,
                    	      							"de.evoal.languages.model.dl.dsl.DefinitionLanguage.StatementRule");
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

            otherlv_13=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getEnumTypeDefinitionRuleAccess().getSemicolonKeyword_9());
              		
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
    // $ANTLR end "ruleEnumTypeDefinitionRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalDefinitionLanguage.g:427:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalDefinitionLanguage.g:427:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalDefinitionLanguage.g:428:2: iv_ruleStatementRule= ruleStatementRule EOF
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
    // InternalDefinitionLanguage.g:434:1: ruleStatementRule returns [EObject current=null] : (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:440:2: ( (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' ) )
            // InternalDefinitionLanguage.g:441:2: (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' )
            {
            // InternalDefinitionLanguage.g:441:2: (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' )
            // InternalDefinitionLanguage.g:442:3: this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';'
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getStatementRuleAccess().getExpressionRuleParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_15);
            this_ExpressionRule_0=ruleExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExpressionRule_0;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_1=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStatementRuleAccess().getSemicolonKeyword_1());
              		
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
    // $ANTLR end "ruleStatementRule"


    // $ANTLR start "entryRuleExpressionRule"
    // InternalDefinitionLanguage.g:461:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:461:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalDefinitionLanguage.g:462:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalDefinitionLanguage.g:468:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:474:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalDefinitionLanguage.g:475:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalDefinitionLanguage.g:489:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:489:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalDefinitionLanguage.g:490:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalDefinitionLanguage.g:496:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:502:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalDefinitionLanguage.g:503:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:503:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalDefinitionLanguage.g:504:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalDefinitionLanguage.g:504:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:505:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:505:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:506:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_16);
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

            // InternalDefinitionLanguage.g:523:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==26) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:524:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	      			
            	    }
            	    // InternalDefinitionLanguage.g:528:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalDefinitionLanguage.g:529:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:529:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalDefinitionLanguage.g:530:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
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
    // $ANTLR end "ruleOrExpressionRule"


    // $ANTLR start "entryRuleXorExpressionRule"
    // InternalDefinitionLanguage.g:552:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:552:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalDefinitionLanguage.g:553:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalDefinitionLanguage.g:559:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:565:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalDefinitionLanguage.g:566:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:566:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalDefinitionLanguage.g:567:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalDefinitionLanguage.g:567:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:568:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:568:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:569:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
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

            // InternalDefinitionLanguage.g:586:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==27) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:587:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,27,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	      			
            	    }
            	    // InternalDefinitionLanguage.g:591:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalDefinitionLanguage.g:592:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:592:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalDefinitionLanguage.g:593:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
    // $ANTLR end "ruleXorExpressionRule"


    // $ANTLR start "entryRuleAndExpressionRule"
    // InternalDefinitionLanguage.g:615:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:615:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalDefinitionLanguage.g:616:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalDefinitionLanguage.g:622:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:628:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalDefinitionLanguage.g:629:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:629:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalDefinitionLanguage.g:630:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalDefinitionLanguage.g:630:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:631:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:631:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:632:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_19);
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

            // InternalDefinitionLanguage.g:649:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==28) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:650:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	      			
            	    }
            	    // InternalDefinitionLanguage.g:654:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalDefinitionLanguage.g:655:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:655:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalDefinitionLanguage.g:656:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_19);
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
            	    break loop9;
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
    // InternalDefinitionLanguage.g:678:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:678:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalDefinitionLanguage.g:679:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalDefinitionLanguage.g:685:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:691:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalDefinitionLanguage.g:692:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalDefinitionLanguage.g:692:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalDefinitionLanguage.g:693:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalDefinitionLanguage.g:693:3: ( (lv_negated_0_0= '!' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDefinitionLanguage.g:694:4: (lv_negated_0_0= '!' )
                    {
                    // InternalDefinitionLanguage.g:694:4: (lv_negated_0_0= '!' )
                    // InternalDefinitionLanguage.g:695:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,29,FOLLOW_17); if (state.failed) return current;
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

            // InternalDefinitionLanguage.g:707:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:708:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:708:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalDefinitionLanguage.g:709:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalDefinitionLanguage.g:730:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:730:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalDefinitionLanguage.g:731:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalDefinitionLanguage.g:737:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:743:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalDefinitionLanguage.g:744:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalDefinitionLanguage.g:744:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalDefinitionLanguage.g:745:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalDefinitionLanguage.g:745:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:746:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:746:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:747:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_20);
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

            // InternalDefinitionLanguage.g:764:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=63 && LA11_0<=68)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:765:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:765:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalDefinitionLanguage.g:766:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_20);
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
            	    break loop11;
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
    // InternalDefinitionLanguage.g:787:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:787:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalDefinitionLanguage.g:788:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalDefinitionLanguage.g:794:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:800:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalDefinitionLanguage.g:801:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalDefinitionLanguage.g:801:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalDefinitionLanguage.g:802:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalDefinitionLanguage.g:802:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalDefinitionLanguage.g:803:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalDefinitionLanguage.g:803:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalDefinitionLanguage.g:804:5: lv_operator_0_0= ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_17);
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

            // InternalDefinitionLanguage.g:821:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:822:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:822:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:823:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:844:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:844:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalDefinitionLanguage.g:845:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalDefinitionLanguage.g:851:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:857:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalDefinitionLanguage.g:858:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:858:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalDefinitionLanguage.g:859:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalDefinitionLanguage.g:859:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:860:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:860:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:861:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_21);
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

            // InternalDefinitionLanguage.g:878:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=69 && LA12_0<=70)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:879:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:879:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalDefinitionLanguage.g:880:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalDefinitionLanguage.g:880:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalDefinitionLanguage.g:881:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
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

            	    // InternalDefinitionLanguage.g:898:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalDefinitionLanguage.g:899:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:899:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalDefinitionLanguage.g:900:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
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
            	    break loop12;
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
    // InternalDefinitionLanguage.g:922:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:922:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDefinitionLanguage.g:923:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalDefinitionLanguage.g:929:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:935:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalDefinitionLanguage.g:936:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:936:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalDefinitionLanguage.g:937:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalDefinitionLanguage.g:937:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:938:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:938:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:939:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_22);
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

            // InternalDefinitionLanguage.g:956:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=71 && LA13_0<=73)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:957:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:957:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalDefinitionLanguage.g:958:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalDefinitionLanguage.g:958:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalDefinitionLanguage.g:959:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
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

            	    // InternalDefinitionLanguage.g:976:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalDefinitionLanguage.g:977:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:977:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalDefinitionLanguage.g:978:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
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
            	    break loop13;
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
    // InternalDefinitionLanguage.g:1000:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:1000:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalDefinitionLanguage.g:1001:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalDefinitionLanguage.g:1007:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1013:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalDefinitionLanguage.g:1014:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalDefinitionLanguage.g:1014:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalDefinitionLanguage.g:1015:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalDefinitionLanguage.g:1015:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:1016:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:1016:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:1017:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_23);
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

            // InternalDefinitionLanguage.g:1034:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDefinitionLanguage.g:1035:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                      			
                    }
                    // InternalDefinitionLanguage.g:1039:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalDefinitionLanguage.g:1040:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalDefinitionLanguage.g:1040:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalDefinitionLanguage.g:1041:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:1063:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:1063:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDefinitionLanguage.g:1064:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalDefinitionLanguage.g:1070:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1076:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) ) )
            // InternalDefinitionLanguage.g:1077:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) )
            {
            // InternalDefinitionLanguage.g:1077:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) )
            // InternalDefinitionLanguage.g:1078:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) )
            {
            // InternalDefinitionLanguage.g:1078:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=69 && LA15_0<=70)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1079:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalDefinitionLanguage.g:1079:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalDefinitionLanguage.g:1080:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_17);
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
            	    break loop15;
                }
            } while (true);

            // InternalDefinitionLanguage.g:1097:3: ( (lv_subExpression_1_0= ruleReadExpressionRule ) )
            // InternalDefinitionLanguage.g:1098:4: (lv_subExpression_1_0= ruleReadExpressionRule )
            {
            // InternalDefinitionLanguage.g:1098:4: (lv_subExpression_1_0= ruleReadExpressionRule )
            // InternalDefinitionLanguage.g:1099:5: lv_subExpression_1_0= ruleReadExpressionRule
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
    // InternalDefinitionLanguage.g:1120:1: entryRuleReadExpressionRule returns [EObject current=null] : iv_ruleReadExpressionRule= ruleReadExpressionRule EOF ;
    public final EObject entryRuleReadExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReadExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:1120:59: (iv_ruleReadExpressionRule= ruleReadExpressionRule EOF )
            // InternalDefinitionLanguage.g:1121:2: iv_ruleReadExpressionRule= ruleReadExpressionRule EOF
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
    // InternalDefinitionLanguage.g:1127:1: ruleReadExpressionRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) ;
    public final EObject ruleReadExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_CallRule_1 = null;

        EObject this_LiteralRule_2 = null;

        EObject this_ParanthesesRule_3 = null;

        EObject this_ReferenceRule_4 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1133:2: ( (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) )
            // InternalDefinitionLanguage.g:1134:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            {
            // InternalDefinitionLanguage.g:1134:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            int alt16=5;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalDefinitionLanguage.g:1135:3: this_ArrayRule_0= ruleArrayRule
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
                    // InternalDefinitionLanguage.g:1147:3: this_CallRule_1= ruleCallRule
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
                    // InternalDefinitionLanguage.g:1159:3: this_LiteralRule_2= ruleLiteralRule
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
                    // InternalDefinitionLanguage.g:1171:3: this_ParanthesesRule_3= ruleParanthesesRule
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
                    // InternalDefinitionLanguage.g:1183:3: this_ReferenceRule_4= ruleReferenceRule
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
    // InternalDefinitionLanguage.g:1198:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalDefinitionLanguage.g:1198:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalDefinitionLanguage.g:1199:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalDefinitionLanguage.g:1205:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1211:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' ) )
            // InternalDefinitionLanguage.g:1212:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalDefinitionLanguage.g:1212:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' )
            // InternalDefinitionLanguage.g:1213:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']'
            {
            // InternalDefinitionLanguage.g:1213:3: ()
            // InternalDefinitionLanguage.g:1214:4: 
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

            otherlv_1=(Token)match(input,31,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalDefinitionLanguage.g:1227:3: ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_DOUBLE && LA18_0<=RULE_ID)||LA18_0==19||LA18_0==31||(LA18_0>=33 && LA18_0<=34)||(LA18_0>=36 && LA18_0<=38)||(LA18_0>=40 && LA18_0<=41)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDefinitionLanguage.g:1228:4: ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )*
                    {
                    // InternalDefinitionLanguage.g:1228:4: ( (lv_values_2_0= ruleReadExpressionRule ) )
                    // InternalDefinitionLanguage.g:1229:5: (lv_values_2_0= ruleReadExpressionRule )
                    {
                    // InternalDefinitionLanguage.g:1229:5: (lv_values_2_0= ruleReadExpressionRule )
                    // InternalDefinitionLanguage.g:1230:6: lv_values_2_0= ruleReadExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
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

                    // InternalDefinitionLanguage.g:1247:4: (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==20) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalDefinitionLanguage.g:1248:5: otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalDefinitionLanguage.g:1252:5: ( (lv_values_4_0= ruleReadExpressionRule ) )
                    	    // InternalDefinitionLanguage.g:1253:6: (lv_values_4_0= ruleReadExpressionRule )
                    	    {
                    	    // InternalDefinitionLanguage.g:1253:6: (lv_values_4_0= ruleReadExpressionRule )
                    	    // InternalDefinitionLanguage.g:1254:7: lv_values_4_0= ruleReadExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_25);
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
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:1281:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalDefinitionLanguage.g:1281:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalDefinitionLanguage.g:1282:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalDefinitionLanguage.g:1288:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1294:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalDefinitionLanguage.g:1295:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalDefinitionLanguage.g:1295:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalDefinitionLanguage.g:1296:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalDefinitionLanguage.g:1300:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:1301:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:1301:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalDefinitionLanguage.g:1302:5: lv_subExpression_1_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            otherlv_2=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:1327:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalDefinitionLanguage.g:1327:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalDefinitionLanguage.g:1328:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalDefinitionLanguage.g:1334:1: ruleCallRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleCallRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1340:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalDefinitionLanguage.g:1341:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalDefinitionLanguage.g:1341:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalDefinitionLanguage.g:1342:3: ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalDefinitionLanguage.g:1342:3: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:1343:4: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:1343:4: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:1344:5: ruleQualifiedName
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
            pushFollow(FOLLOW_9);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalDefinitionLanguage.g:1365:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_DOUBLE && LA20_0<=RULE_ID)||LA20_0==19||LA20_0==29||LA20_0==31||(LA20_0>=33 && LA20_0<=34)||(LA20_0>=36 && LA20_0<=38)||(LA20_0>=40 && LA20_0<=41)||(LA20_0>=69 && LA20_0<=70)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDefinitionLanguage.g:1366:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalDefinitionLanguage.g:1366:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalDefinitionLanguage.g:1367:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalDefinitionLanguage.g:1367:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalDefinitionLanguage.g:1368:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
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

                    // InternalDefinitionLanguage.g:1385:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==20) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalDefinitionLanguage.g:1386:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalDefinitionLanguage.g:1390:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalDefinitionLanguage.g:1391:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalDefinitionLanguage.g:1391:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalDefinitionLanguage.g:1392:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
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
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:1419:1: entryRuleReferenceRule returns [EObject current=null] : iv_ruleReferenceRule= ruleReferenceRule EOF ;
    public final EObject entryRuleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:1419:54: (iv_ruleReferenceRule= ruleReferenceRule EOF )
            // InternalDefinitionLanguage.g:1420:2: iv_ruleReferenceRule= ruleReferenceRule EOF
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
    // InternalDefinitionLanguage.g:1426:1: ruleReferenceRule returns [EObject current=null] : (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_ConfigurationReferenceRule_1= ruleConfigurationReferenceRule | this_TypeDefinitionReferenceRule_2= ruleTypeDefinitionReferenceRule | this_AttributeReferenceRule_3= ruleAttributeReferenceRule ) ;
    public final EObject ruleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_ValuelDefinitionReferenceRule_0 = null;

        EObject this_ConfigurationReferenceRule_1 = null;

        EObject this_TypeDefinitionReferenceRule_2 = null;

        EObject this_AttributeReferenceRule_3 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1432:2: ( (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_ConfigurationReferenceRule_1= ruleConfigurationReferenceRule | this_TypeDefinitionReferenceRule_2= ruleTypeDefinitionReferenceRule | this_AttributeReferenceRule_3= ruleAttributeReferenceRule ) )
            // InternalDefinitionLanguage.g:1433:2: (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_ConfigurationReferenceRule_1= ruleConfigurationReferenceRule | this_TypeDefinitionReferenceRule_2= ruleTypeDefinitionReferenceRule | this_AttributeReferenceRule_3= ruleAttributeReferenceRule )
            {
            // InternalDefinitionLanguage.g:1433:2: (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_ConfigurationReferenceRule_1= ruleConfigurationReferenceRule | this_TypeDefinitionReferenceRule_2= ruleTypeDefinitionReferenceRule | this_AttributeReferenceRule_3= ruleAttributeReferenceRule )
            int alt21=4;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt21=1;
                }
                break;
            case 36:
                {
                alt21=2;
                }
                break;
            case 37:
            case 38:
                {
                alt21=3;
                }
                break;
            case 33:
            case 34:
                {
                alt21=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalDefinitionLanguage.g:1434:3: this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule
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
                    // InternalDefinitionLanguage.g:1446:3: this_ConfigurationReferenceRule_1= ruleConfigurationReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getConfigurationReferenceRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConfigurationReferenceRule_1=ruleConfigurationReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConfigurationReferenceRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:1458:3: this_TypeDefinitionReferenceRule_2= ruleTypeDefinitionReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getTypeDefinitionReferenceRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeDefinitionReferenceRule_2=ruleTypeDefinitionReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeDefinitionReferenceRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:1470:3: this_AttributeReferenceRule_3= ruleAttributeReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getAttributeReferenceRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AttributeReferenceRule_3=ruleAttributeReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AttributeReferenceRule_3;
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


    // $ANTLR start "entryRuleSelfReferenceRule"
    // InternalDefinitionLanguage.g:1485:1: entryRuleSelfReferenceRule returns [EObject current=null] : iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF ;
    public final EObject entryRuleSelfReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:1485:58: (iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF )
            // InternalDefinitionLanguage.g:1486:2: iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSelfReferenceRule=ruleSelfReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfReferenceRule; 
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
    // $ANTLR end "entryRuleSelfReferenceRule"


    // $ANTLR start "ruleSelfReferenceRule"
    // InternalDefinitionLanguage.g:1492:1: ruleSelfReferenceRule returns [EObject current=null] : ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'value' ) ) ;
    public final EObject ruleSelfReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1498:2: ( ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'value' ) ) )
            // InternalDefinitionLanguage.g:1499:2: ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'value' ) )
            {
            // InternalDefinitionLanguage.g:1499:2: ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'value' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            else if ( (LA22_0==34) ) {
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
                    // InternalDefinitionLanguage.g:1500:3: ( () otherlv_1= 'self' )
                    {
                    // InternalDefinitionLanguage.g:1500:3: ( () otherlv_1= 'self' )
                    // InternalDefinitionLanguage.g:1501:4: () otherlv_1= 'self'
                    {
                    // InternalDefinitionLanguage.g:1501:4: ()
                    // InternalDefinitionLanguage.g:1502:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSelfReferenceRuleAccess().getSelfKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:1517:3: ( () otherlv_3= 'value' )
                    {
                    // InternalDefinitionLanguage.g:1517:3: ( () otherlv_3= 'value' )
                    // InternalDefinitionLanguage.g:1518:4: () otherlv_3= 'value'
                    {
                    // InternalDefinitionLanguage.g:1518:4: ()
                    // InternalDefinitionLanguage.g:1519:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1_1());
                      			
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
    // $ANTLR end "ruleSelfReferenceRule"


    // $ANTLR start "entryRuleAttributeReferenceRule"
    // InternalDefinitionLanguage.g:1537:1: entryRuleAttributeReferenceRule returns [EObject current=null] : iv_ruleAttributeReferenceRule= ruleAttributeReferenceRule EOF ;
    public final EObject entryRuleAttributeReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:1537:63: (iv_ruleAttributeReferenceRule= ruleAttributeReferenceRule EOF )
            // InternalDefinitionLanguage.g:1538:2: iv_ruleAttributeReferenceRule= ruleAttributeReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttributeReferenceRule=ruleAttributeReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttributeReferenceRule; 
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
    // $ANTLR end "entryRuleAttributeReferenceRule"


    // $ANTLR start "ruleAttributeReferenceRule"
    // InternalDefinitionLanguage.g:1544:1: ruleAttributeReferenceRule returns [EObject current=null] : ( ( (lv_self_0_0= ruleSelfReferenceRule ) ) (otherlv_1= '.' ( (lv_chain_2_0= ruleValuelDefinitionReferenceRule ) ) )* ) ;
    public final EObject ruleAttributeReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_self_0_0 = null;

        EObject lv_chain_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1550:2: ( ( ( (lv_self_0_0= ruleSelfReferenceRule ) ) (otherlv_1= '.' ( (lv_chain_2_0= ruleValuelDefinitionReferenceRule ) ) )* ) )
            // InternalDefinitionLanguage.g:1551:2: ( ( (lv_self_0_0= ruleSelfReferenceRule ) ) (otherlv_1= '.' ( (lv_chain_2_0= ruleValuelDefinitionReferenceRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:1551:2: ( ( (lv_self_0_0= ruleSelfReferenceRule ) ) (otherlv_1= '.' ( (lv_chain_2_0= ruleValuelDefinitionReferenceRule ) ) )* )
            // InternalDefinitionLanguage.g:1552:3: ( (lv_self_0_0= ruleSelfReferenceRule ) ) (otherlv_1= '.' ( (lv_chain_2_0= ruleValuelDefinitionReferenceRule ) ) )*
            {
            // InternalDefinitionLanguage.g:1552:3: ( (lv_self_0_0= ruleSelfReferenceRule ) )
            // InternalDefinitionLanguage.g:1553:4: (lv_self_0_0= ruleSelfReferenceRule )
            {
            // InternalDefinitionLanguage.g:1553:4: (lv_self_0_0= ruleSelfReferenceRule )
            // InternalDefinitionLanguage.g:1554:5: lv_self_0_0= ruleSelfReferenceRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeReferenceRuleAccess().getSelfSelfReferenceRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_self_0_0=ruleSelfReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeReferenceRuleRule());
              					}
              					set(
              						current,
              						"self",
              						lv_self_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.SelfReferenceRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDefinitionLanguage.g:1571:3: (otherlv_1= '.' ( (lv_chain_2_0= ruleValuelDefinitionReferenceRule ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==35) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1572:4: otherlv_1= '.' ( (lv_chain_2_0= ruleValuelDefinitionReferenceRule ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAttributeReferenceRuleAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    // InternalDefinitionLanguage.g:1576:4: ( (lv_chain_2_0= ruleValuelDefinitionReferenceRule ) )
            	    // InternalDefinitionLanguage.g:1577:5: (lv_chain_2_0= ruleValuelDefinitionReferenceRule )
            	    {
            	    // InternalDefinitionLanguage.g:1577:5: (lv_chain_2_0= ruleValuelDefinitionReferenceRule )
            	    // InternalDefinitionLanguage.g:1578:6: lv_chain_2_0= ruleValuelDefinitionReferenceRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAttributeReferenceRuleAccess().getChainValuelDefinitionReferenceRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_chain_2_0=ruleValuelDefinitionReferenceRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAttributeReferenceRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"chain",
            	      							lv_chain_2_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.ValuelDefinitionReferenceRule");
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
    // $ANTLR end "ruleAttributeReferenceRule"


    // $ANTLR start "entryRuleConfigurationReferenceRule"
    // InternalDefinitionLanguage.g:1600:1: entryRuleConfigurationReferenceRule returns [EObject current=null] : iv_ruleConfigurationReferenceRule= ruleConfigurationReferenceRule EOF ;
    public final EObject entryRuleConfigurationReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigurationReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:1600:67: (iv_ruleConfigurationReferenceRule= ruleConfigurationReferenceRule EOF )
            // InternalDefinitionLanguage.g:1601:2: iv_ruleConfigurationReferenceRule= ruleConfigurationReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConfigurationReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConfigurationReferenceRule=ruleConfigurationReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConfigurationReferenceRule; 
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
    // $ANTLR end "entryRuleConfigurationReferenceRule"


    // $ANTLR start "ruleConfigurationReferenceRule"
    // InternalDefinitionLanguage.g:1607:1: ruleConfigurationReferenceRule returns [EObject current=null] : (otherlv_0= 'tree' ( (lv_reference_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleConfigurationReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_reference_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1613:2: ( (otherlv_0= 'tree' ( (lv_reference_1_0= ruleStringOrId ) ) ) )
            // InternalDefinitionLanguage.g:1614:2: (otherlv_0= 'tree' ( (lv_reference_1_0= ruleStringOrId ) ) )
            {
            // InternalDefinitionLanguage.g:1614:2: (otherlv_0= 'tree' ( (lv_reference_1_0= ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:1615:3: otherlv_0= 'tree' ( (lv_reference_1_0= ruleStringOrId ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConfigurationReferenceRuleAccess().getTreeKeyword_0());
              		
            }
            // InternalDefinitionLanguage.g:1619:3: ( (lv_reference_1_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:1620:4: (lv_reference_1_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:1620:4: (lv_reference_1_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:1621:5: lv_reference_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConfigurationReferenceRuleAccess().getReferenceStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_reference_1_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConfigurationReferenceRuleRule());
              					}
              					set(
              						current,
              						"reference",
              						lv_reference_1_0,
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
    // $ANTLR end "ruleConfigurationReferenceRule"


    // $ANTLR start "entryRuleValuelDefinitionReferenceRule"
    // InternalDefinitionLanguage.g:1642:1: entryRuleValuelDefinitionReferenceRule returns [EObject current=null] : iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF ;
    public final EObject entryRuleValuelDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuelDefinitionReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:1642:70: (iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF )
            // InternalDefinitionLanguage.g:1643:2: iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF
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
    // InternalDefinitionLanguage.g:1649:1: ruleValuelDefinitionReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleValuelDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1655:2: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:1656:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:1656:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:1657:3: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:1657:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:1658:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:1678:1: entryRuleTypeDefinitionReferenceRule returns [EObject current=null] : iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF ;
    public final EObject entryRuleTypeDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinitionReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:1678:68: (iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF )
            // InternalDefinitionLanguage.g:1679:2: iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF
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
    // InternalDefinitionLanguage.g:1685:1: ruleTypeDefinitionReferenceRule returns [EObject current=null] : (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule ) ;
    public final EObject ruleTypeDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_BaseDataReferenceRule_0 = null;

        EObject this_StructuredDataDescriptionReferenceRule_1 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1691:2: ( (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule ) )
            // InternalDefinitionLanguage.g:1692:2: (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule )
            {
            // InternalDefinitionLanguage.g:1692:2: (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==37) ) {
                alt24=1;
            }
            else if ( (LA24_0==38) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalDefinitionLanguage.g:1693:3: this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule
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
                    // InternalDefinitionLanguage.g:1705:3: this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule
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
    // InternalDefinitionLanguage.g:1720:1: entryRuleBaseDataReferenceRule returns [EObject current=null] : iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF ;
    public final EObject entryRuleBaseDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseDataReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:1720:62: (iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF )
            // InternalDefinitionLanguage.g:1721:2: iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF
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
    // InternalDefinitionLanguage.g:1727:1: ruleBaseDataReferenceRule returns [EObject current=null] : (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleBaseDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1733:2: ( (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) )
            // InternalDefinitionLanguage.g:1734:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            {
            // InternalDefinitionLanguage.g:1734:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:1735:3: otherlv_0= 'data' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBaseDataReferenceRuleAccess().getDataKeyword_0());
              		
            }
            // InternalDefinitionLanguage.g:1739:3: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:1740:4: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:1740:4: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:1741:5: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:1762:1: entryRuleStructuredDataDescriptionReferenceRule returns [EObject current=null] : iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF ;
    public final EObject entryRuleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataDescriptionReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:1762:79: (iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF )
            // InternalDefinitionLanguage.g:1763:2: iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF
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
    // InternalDefinitionLanguage.g:1769:1: ruleStructuredDataDescriptionReferenceRule returns [EObject current=null] : (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1775:2: ( (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalDefinitionLanguage.g:1776:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalDefinitionLanguage.g:1776:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:1777:3: otherlv_0= 'instance' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getInstanceKeyword_0());
              		
            }
            // InternalDefinitionLanguage.g:1781:3: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:1782:4: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:1782:4: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:1783:5: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:1804:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:1804:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalDefinitionLanguage.g:1805:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalDefinitionLanguage.g:1811:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_InstanceLiteralRule_3 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1817:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) )
            // InternalDefinitionLanguage.g:1818:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            {
            // InternalDefinitionLanguage.g:1818:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            int alt25=4;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt25=1;
                }
                break;
            case RULE_STRING:
                {
                alt25=2;
                }
                break;
            case 40:
            case 41:
                {
                alt25=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt25=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalDefinitionLanguage.g:1819:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalDefinitionLanguage.g:1831:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalDefinitionLanguage.g:1843:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
                    // InternalDefinitionLanguage.g:1855:3: this_InstanceLiteralRule_3= ruleInstanceLiteralRule
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
    // InternalDefinitionLanguage.g:1870:1: entryRuleInstanceLiteralRule returns [EObject current=null] : iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF ;
    public final EObject entryRuleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:1870:60: (iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF )
            // InternalDefinitionLanguage.g:1871:2: iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF
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
    // InternalDefinitionLanguage.g:1877:1: ruleInstanceLiteralRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) ;
    public final EObject ruleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1883:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) )
            // InternalDefinitionLanguage.g:1884:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            {
            // InternalDefinitionLanguage.g:1884:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            // InternalDefinitionLanguage.g:1885:3: ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
            {
            // InternalDefinitionLanguage.g:1885:3: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:1886:4: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:1886:4: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:1887:5: ruleQualifiedName
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
            pushFollow(FOLLOW_5);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalDefinitionLanguage.g:1908:3: ( (lv_attributes_2_0= ruleAttributeRule ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=RULE_QUOTED_ID && LA26_0<=RULE_ID)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1909:4: (lv_attributes_2_0= ruleAttributeRule )
            	    {
            	    // InternalDefinitionLanguage.g:1909:4: (lv_attributes_2_0= ruleAttributeRule )
            	    // InternalDefinitionLanguage.g:1910:5: lv_attributes_2_0= ruleAttributeRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAttributeRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_29);
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
            	    break loop26;
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
    // InternalDefinitionLanguage.g:1935:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalDefinitionLanguage.g:1935:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalDefinitionLanguage.g:1936:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalDefinitionLanguage.g:1942:1: ruleAttributeRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1948:2: ( ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) )
            // InternalDefinitionLanguage.g:1949:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            {
            // InternalDefinitionLanguage.g:1949:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            // InternalDefinitionLanguage.g:1950:3: ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';'
            {
            // InternalDefinitionLanguage.g:1950:3: ( ( ruleStringOrId ) )
            // InternalDefinitionLanguage.g:1951:4: ( ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:1951:4: ( ruleStringOrId )
            // InternalDefinitionLanguage.g:1952:5: ruleStringOrId
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
            pushFollow(FOLLOW_30);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalDefinitionLanguage.g:1973:3: ( (lv_value_2_0= ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:1974:4: (lv_value_2_0= ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:1974:4: (lv_value_2_0= ruleExpressionRule )
            // InternalDefinitionLanguage.g:1975:5: lv_value_2_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueExpressionRuleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_15);
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

            otherlv_3=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:2000:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:2000:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalDefinitionLanguage.g:2001:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalDefinitionLanguage.g:2007:1: ruleNumberLiteralRule returns [EObject current=null] : (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2013:2: ( (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalDefinitionLanguage.g:2014:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalDefinitionLanguage.g:2014:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_DOUBLE) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_INT) ) {
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
                    // InternalDefinitionLanguage.g:2015:3: this_RealLiteralRule_0= ruleRealLiteralRule
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
                    // InternalDefinitionLanguage.g:2027:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalDefinitionLanguage.g:2042:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:2042:56: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // InternalDefinitionLanguage.g:2043:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
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
    // InternalDefinitionLanguage.g:2049:1: ruleRealLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2055:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalDefinitionLanguage.g:2056:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalDefinitionLanguage.g:2056:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalDefinitionLanguage.g:2057:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalDefinitionLanguage.g:2057:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalDefinitionLanguage.g:2058:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalDefinitionLanguage.g:2058:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalDefinitionLanguage.g:2059:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_31); if (state.failed) return current;
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

            // InternalDefinitionLanguage.g:2075:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=74 && LA28_0<=93)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalDefinitionLanguage.g:2076:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalDefinitionLanguage.g:2076:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalDefinitionLanguage.g:2077:5: lv_factor_1_0= ruleFactorRule
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
    // InternalDefinitionLanguage.g:2098:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:2098:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalDefinitionLanguage.g:2099:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalDefinitionLanguage.g:2105:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2111:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalDefinitionLanguage.g:2112:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalDefinitionLanguage.g:2112:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalDefinitionLanguage.g:2113:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalDefinitionLanguage.g:2113:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalDefinitionLanguage.g:2114:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalDefinitionLanguage.g:2114:4: (lv_literal_0_0= RULE_INT )
            // InternalDefinitionLanguage.g:2115:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_31); if (state.failed) return current;
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

            // InternalDefinitionLanguage.g:2131:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=74 && LA29_0<=93)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDefinitionLanguage.g:2132:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalDefinitionLanguage.g:2132:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalDefinitionLanguage.g:2133:5: lv_factor_1_0= ruleFactorRule
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
    // InternalDefinitionLanguage.g:2154:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:2154:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalDefinitionLanguage.g:2155:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalDefinitionLanguage.g:2161:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_literal_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2167:2: ( ( (lv_literal_0_0= RULE_STRING ) ) )
            // InternalDefinitionLanguage.g:2168:2: ( (lv_literal_0_0= RULE_STRING ) )
            {
            // InternalDefinitionLanguage.g:2168:2: ( (lv_literal_0_0= RULE_STRING ) )
            // InternalDefinitionLanguage.g:2169:3: (lv_literal_0_0= RULE_STRING )
            {
            // InternalDefinitionLanguage.g:2169:3: (lv_literal_0_0= RULE_STRING )
            // InternalDefinitionLanguage.g:2170:4: lv_literal_0_0= RULE_STRING
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
    // InternalDefinitionLanguage.g:2189:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:2189:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalDefinitionLanguage.g:2190:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalDefinitionLanguage.g:2196:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2202:2: ( ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalDefinitionLanguage.g:2203:2: ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalDefinitionLanguage.g:2203:2: ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalDefinitionLanguage.g:2204:3: () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalDefinitionLanguage.g:2204:3: ()
            // InternalDefinitionLanguage.g:2205:4: 
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

            // InternalDefinitionLanguage.g:2214:3: ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==40) ) {
                alt30=1;
            }
            else if ( (LA30_0==41) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalDefinitionLanguage.g:2215:4: ( (lv_literal_1_0= 'true' ) )
                    {
                    // InternalDefinitionLanguage.g:2215:4: ( (lv_literal_1_0= 'true' ) )
                    // InternalDefinitionLanguage.g:2216:5: (lv_literal_1_0= 'true' )
                    {
                    // InternalDefinitionLanguage.g:2216:5: (lv_literal_1_0= 'true' )
                    // InternalDefinitionLanguage.g:2217:6: lv_literal_1_0= 'true'
                    {
                    lv_literal_1_0=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
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
                    // InternalDefinitionLanguage.g:2230:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleClassDefinitionRule"
    // InternalDefinitionLanguage.g:2239:1: entryRuleClassDefinitionRule returns [EObject current=null] : iv_ruleClassDefinitionRule= ruleClassDefinitionRule EOF ;
    public final EObject entryRuleClassDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassDefinitionRule = null;


        try {
            // InternalDefinitionLanguage.g:2239:60: (iv_ruleClassDefinitionRule= ruleClassDefinitionRule EOF )
            // InternalDefinitionLanguage.g:2240:2: iv_ruleClassDefinitionRule= ruleClassDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClassDefinitionRule=ruleClassDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassDefinitionRule; 
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
    // $ANTLR end "entryRuleClassDefinitionRule"


    // $ANTLR start "ruleClassDefinitionRule"
    // InternalDefinitionLanguage.g:2246:1: ruleClassDefinitionRule returns [EObject current=null] : ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_abstract_1_0= 'abstract' ) )? otherlv_2= 'type' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_6= '{' ( (lv_attributes_7_0= ruleAttributeDefinitionRule ) )* otherlv_8= '}' ) ;
    public final EObject ruleClassDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_constraints_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_attributes_7_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2252:2: ( ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_abstract_1_0= 'abstract' ) )? otherlv_2= 'type' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_6= '{' ( (lv_attributes_7_0= ruleAttributeDefinitionRule ) )* otherlv_8= '}' ) )
            // InternalDefinitionLanguage.g:2253:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_abstract_1_0= 'abstract' ) )? otherlv_2= 'type' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_6= '{' ( (lv_attributes_7_0= ruleAttributeDefinitionRule ) )* otherlv_8= '}' )
            {
            // InternalDefinitionLanguage.g:2253:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_abstract_1_0= 'abstract' ) )? otherlv_2= 'type' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_6= '{' ( (lv_attributes_7_0= ruleAttributeDefinitionRule ) )* otherlv_8= '}' )
            // InternalDefinitionLanguage.g:2254:3: ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_abstract_1_0= 'abstract' ) )? otherlv_2= 'type' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_6= '{' ( (lv_attributes_7_0= ruleAttributeDefinitionRule ) )* otherlv_8= '}'
            {
            // InternalDefinitionLanguage.g:2254:3: ( (lv_constraints_0_0= ruleConstraintRule ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==45) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2255:4: (lv_constraints_0_0= ruleConstraintRule )
            	    {
            	    // InternalDefinitionLanguage.g:2255:4: (lv_constraints_0_0= ruleConstraintRule )
            	    // InternalDefinitionLanguage.g:2256:5: lv_constraints_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getClassDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_constraints_0_0=ruleConstraintRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getClassDefinitionRuleRule());
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
            	    break loop31;
                }
            } while (true);

            // InternalDefinitionLanguage.g:2273:3: ( (lv_abstract_1_0= 'abstract' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==42) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalDefinitionLanguage.g:2274:4: (lv_abstract_1_0= 'abstract' )
                    {
                    // InternalDefinitionLanguage.g:2274:4: (lv_abstract_1_0= 'abstract' )
                    // InternalDefinitionLanguage.g:2275:5: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)match(input,42,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_abstract_1_0, grammarAccess.getClassDefinitionRuleAccess().getAbstractAbstractKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getClassDefinitionRuleRule());
                      					}
                      					setWithLastConsumed(current, "abstract", lv_abstract_1_0 != null, "abstract");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,43,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getClassDefinitionRuleAccess().getTypeKeyword_2());
              		
            }
            // InternalDefinitionLanguage.g:2291:3: ( (lv_name_3_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:2292:4: (lv_name_3_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:2292:4: (lv_name_3_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:2293:5: lv_name_3_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getClassDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_name_3_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getClassDefinitionRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDefinitionLanguage.g:2310:3: (otherlv_4= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==44) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalDefinitionLanguage.g:2311:4: otherlv_4= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_4=(Token)match(input,44,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getClassDefinitionRuleAccess().getExtendsKeyword_4_0());
                      			
                    }
                    // InternalDefinitionLanguage.g:2315:4: ( ( ruleQualifiedName ) )
                    // InternalDefinitionLanguage.g:2316:5: ( ruleQualifiedName )
                    {
                    // InternalDefinitionLanguage.g:2316:5: ( ruleQualifiedName )
                    // InternalDefinitionLanguage.g:2317:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getClassDefinitionRuleRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getClassDefinitionRuleAccess().getSuperTypeClassDefinitionCrossReference_4_1_0());
                      					
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


                    }
                    break;

            }

            otherlv_6=(Token)match(input,16,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getClassDefinitionRuleAccess().getLeftCurlyBracketKeyword_5());
              		
            }
            // InternalDefinitionLanguage.g:2339:3: ( (lv_attributes_7_0= ruleAttributeDefinitionRule ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=RULE_QUOTED_ID && LA34_0<=RULE_ID)||LA34_0==45) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2340:4: (lv_attributes_7_0= ruleAttributeDefinitionRule )
            	    {
            	    // InternalDefinitionLanguage.g:2340:4: (lv_attributes_7_0= ruleAttributeDefinitionRule )
            	    // InternalDefinitionLanguage.g:2341:5: lv_attributes_7_0= ruleAttributeDefinitionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getClassDefinitionRuleAccess().getAttributesAttributeDefinitionRuleParserRuleCall_6_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_attributes_7_0=ruleAttributeDefinitionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getClassDefinitionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"attributes",
            	      						lv_attributes_7_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.AttributeDefinitionRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getClassDefinitionRuleAccess().getRightCurlyBracketKeyword_7());
              		
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
    // $ANTLR end "ruleClassDefinitionRule"


    // $ANTLR start "entryRuleConstraintRule"
    // InternalDefinitionLanguage.g:2366:1: entryRuleConstraintRule returns [EObject current=null] : iv_ruleConstraintRule= ruleConstraintRule EOF ;
    public final EObject entryRuleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRule = null;


        try {
            // InternalDefinitionLanguage.g:2366:55: (iv_ruleConstraintRule= ruleConstraintRule EOF )
            // InternalDefinitionLanguage.g:2367:2: iv_ruleConstraintRule= ruleConstraintRule EOF
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
    // InternalDefinitionLanguage.g:2373:1: ruleConstraintRule returns [EObject current=null] : (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) ;
    public final EObject ruleConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_InstanceLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2379:2: ( (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) )
            // InternalDefinitionLanguage.g:2380:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            {
            // InternalDefinitionLanguage.g:2380:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            // InternalDefinitionLanguage.g:2381:3: otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule
            {
            otherlv_0=(Token)match(input,45,FOLLOW_36); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:2400:1: entryRuleAttributeDefinitionRule returns [EObject current=null] : iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF ;
    public final EObject entryRuleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDefinitionRule = null;


        try {
            // InternalDefinitionLanguage.g:2400:64: (iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:2401:2: iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF
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
    // InternalDefinitionLanguage.g:2407:1: ruleAttributeDefinitionRule returns [EObject current=null] : ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' ) ;
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
            // InternalDefinitionLanguage.g:2413:2: ( ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' ) )
            // InternalDefinitionLanguage.g:2414:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' )
            {
            // InternalDefinitionLanguage.g:2414:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' )
            // InternalDefinitionLanguage.g:2415:3: ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';'
            {
            // InternalDefinitionLanguage.g:2415:3: ( (lv_constraints_0_0= ruleConstraintRule ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==45) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2416:4: (lv_constraints_0_0= ruleConstraintRule )
            	    {
            	    // InternalDefinitionLanguage.g:2416:4: (lv_constraints_0_0= ruleConstraintRule )
            	    // InternalDefinitionLanguage.g:2417:5: lv_constraints_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_37);
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
            	    break loop35;
                }
            } while (true);

            // InternalDefinitionLanguage.g:2434:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:2435:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:2435:4: (lv_name_1_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:2436:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_13);
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

            otherlv_2=(Token)match(input,24,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2());
              		
            }
            // InternalDefinitionLanguage.g:2457:3: ( (lv_optional_3_0= 'optional' ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==46) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDefinitionLanguage.g:2458:4: (lv_optional_3_0= 'optional' )
                    {
                    // InternalDefinitionLanguage.g:2458:4: (lv_optional_3_0= 'optional' )
                    // InternalDefinitionLanguage.g:2459:5: lv_optional_3_0= 'optional'
                    {
                    lv_optional_3_0=(Token)match(input,46,FOLLOW_38); if (state.failed) return current;
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

            // InternalDefinitionLanguage.g:2471:3: ( (lv_type_4_0= ruleTypeRule ) )
            // InternalDefinitionLanguage.g:2472:4: (lv_type_4_0= ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:2472:4: (lv_type_4_0= ruleTypeRule )
            // InternalDefinitionLanguage.g:2473:5: lv_type_4_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_39);
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

            // InternalDefinitionLanguage.g:2490:3: (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==39) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalDefinitionLanguage.g:2491:4: otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) )
                    {
                    otherlv_5=(Token)match(input,39,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_5_0());
                      			
                    }
                    // InternalDefinitionLanguage.g:2495:4: ( (lv_initialisation_6_0= ruleExpressionRule ) )
                    // InternalDefinitionLanguage.g:2496:5: (lv_initialisation_6_0= ruleExpressionRule )
                    {
                    // InternalDefinitionLanguage.g:2496:5: (lv_initialisation_6_0= ruleExpressionRule )
                    // InternalDefinitionLanguage.g:2497:6: lv_initialisation_6_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
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

            otherlv_7=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:2523:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2523:49: (iv_ruleTypeRule= ruleTypeRule EOF )
            // InternalDefinitionLanguage.g:2524:2: iv_ruleTypeRule= ruleTypeRule EOF
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
    // InternalDefinitionLanguage.g:2530:1: ruleTypeRule returns [EObject current=null] : (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule ) ;
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
            // InternalDefinitionLanguage.g:2536:2: ( (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule ) )
            // InternalDefinitionLanguage.g:2537:2: (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule )
            {
            // InternalDefinitionLanguage.g:2537:2: (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule )
            int alt38=7;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt38=1;
                }
                break;
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
                {
                alt38=2;
                }
                break;
            case 38:
                {
                alt38=3;
                }
                break;
            case 18:
                {
                alt38=4;
                }
                break;
            case 49:
                {
                alt38=5;
                }
                break;
            case 47:
                {
                alt38=6;
                }
                break;
            case 37:
                {
                alt38=7;
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
                    // InternalDefinitionLanguage.g:2538:3: this_ArrayTypeRule_0= ruleArrayTypeRule
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
                    // InternalDefinitionLanguage.g:2550:3: this_BaseTypeRule_1= ruleBaseTypeRule
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
                    // InternalDefinitionLanguage.g:2562:3: this_TypeReferenceRule_2= ruleTypeReferenceRule
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
                    // InternalDefinitionLanguage.g:2574:3: this_EnumReferenceRule_3= ruleEnumReferenceRule
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
                    // InternalDefinitionLanguage.g:2586:3: this_ExpressionTypeRule_4= ruleExpressionTypeRule
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
                    // InternalDefinitionLanguage.g:2598:3: this_LiteralTypeRule_5= ruleLiteralTypeRule
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
                    // InternalDefinitionLanguage.g:2610:3: this_DataTypeRule_6= ruleDataTypeRule
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
    // InternalDefinitionLanguage.g:2625:1: entryRuleBaseTypeRule returns [EObject current=null] : iv_ruleBaseTypeRule= ruleBaseTypeRule EOF ;
    public final EObject entryRuleBaseTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2625:53: (iv_ruleBaseTypeRule= ruleBaseTypeRule EOF )
            // InternalDefinitionLanguage.g:2626:2: iv_ruleBaseTypeRule= ruleBaseTypeRule EOF
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
    // InternalDefinitionLanguage.g:2632:1: ruleBaseTypeRule returns [EObject current=null] : (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule ) ;
    public final EObject ruleBaseTypeRule() throws RecognitionException {
        EObject current = null;

        EObject this_StringTypeRule_0 = null;

        EObject this_IntTypeRule_1 = null;

        EObject this_RealTypeRule_2 = null;

        EObject this_BooleanTypeRule_3 = null;

        EObject this_VoidTypeRule_4 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2638:2: ( (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule ) )
            // InternalDefinitionLanguage.g:2639:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule )
            {
            // InternalDefinitionLanguage.g:2639:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule )
            int alt39=5;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt39=1;
                }
                break;
            case 50:
                {
                alt39=2;
                }
                break;
            case 51:
                {
                alt39=3;
                }
                break;
            case 52:
                {
                alt39=4;
                }
                break;
            case 53:
                {
                alt39=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalDefinitionLanguage.g:2640:3: this_StringTypeRule_0= ruleStringTypeRule
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
                    // InternalDefinitionLanguage.g:2652:3: this_IntTypeRule_1= ruleIntTypeRule
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
                    // InternalDefinitionLanguage.g:2664:3: this_RealTypeRule_2= ruleRealTypeRule
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
                    // InternalDefinitionLanguage.g:2676:3: this_BooleanTypeRule_3= ruleBooleanTypeRule
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
                    // InternalDefinitionLanguage.g:2688:3: this_VoidTypeRule_4= ruleVoidTypeRule
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
    // InternalDefinitionLanguage.g:2703:1: entryRuleEnumReferenceRule returns [EObject current=null] : iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF ;
    public final EObject entryRuleEnumReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:2703:58: (iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF )
            // InternalDefinitionLanguage.g:2704:2: iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF
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
    // InternalDefinitionLanguage.g:2710:1: ruleEnumReferenceRule returns [EObject current=null] : (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleEnumReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2716:2: ( (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) ) )
            // InternalDefinitionLanguage.g:2717:2: (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) )
            {
            // InternalDefinitionLanguage.g:2717:2: (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:2718:3: otherlv_0= 'enum' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumReferenceRuleAccess().getEnumKeyword_0());
              		
            }
            // InternalDefinitionLanguage.g:2722:3: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:2723:4: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:2723:4: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:2724:5: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:2745:1: entryRuleTypeReferenceRule returns [EObject current=null] : iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF ;
    public final EObject entryRuleTypeReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:2745:58: (iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF )
            // InternalDefinitionLanguage.g:2746:2: iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF
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
    // InternalDefinitionLanguage.g:2752:1: ruleTypeReferenceRule returns [EObject current=null] : (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleTypeReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2758:2: ( (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalDefinitionLanguage.g:2759:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalDefinitionLanguage.g:2759:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:2760:3: otherlv_0= 'instance' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeReferenceRuleAccess().getInstanceKeyword_0());
              		
            }
            // InternalDefinitionLanguage.g:2764:3: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:2765:4: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:2765:4: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:2766:5: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:2787:1: entryRuleLiteralTypeRule returns [EObject current=null] : iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF ;
    public final EObject entryRuleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2787:56: (iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF )
            // InternalDefinitionLanguage.g:2788:2: iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF
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
    // InternalDefinitionLanguage.g:2794:1: ruleLiteralTypeRule returns [EObject current=null] : ( () otherlv_1= 'literal' ) ;
    public final EObject ruleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2800:2: ( ( () otherlv_1= 'literal' ) )
            // InternalDefinitionLanguage.g:2801:2: ( () otherlv_1= 'literal' )
            {
            // InternalDefinitionLanguage.g:2801:2: ( () otherlv_1= 'literal' )
            // InternalDefinitionLanguage.g:2802:3: () otherlv_1= 'literal'
            {
            // InternalDefinitionLanguage.g:2802:3: ()
            // InternalDefinitionLanguage.g:2803:4: 
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

            otherlv_1=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:2820:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2820:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalDefinitionLanguage.g:2821:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
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
    // InternalDefinitionLanguage.g:2827:1: ruleDataTypeRule returns [EObject current=null] : ( () otherlv_1= 'data' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2833:2: ( ( () otherlv_1= 'data' ) )
            // InternalDefinitionLanguage.g:2834:2: ( () otherlv_1= 'data' )
            {
            // InternalDefinitionLanguage.g:2834:2: ( () otherlv_1= 'data' )
            // InternalDefinitionLanguage.g:2835:3: () otherlv_1= 'data'
            {
            // InternalDefinitionLanguage.g:2835:3: ()
            // InternalDefinitionLanguage.g:2836:4: 
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

            otherlv_1=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:2853:1: entryRuleStringTypeRule returns [EObject current=null] : iv_ruleStringTypeRule= ruleStringTypeRule EOF ;
    public final EObject entryRuleStringTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2853:55: (iv_ruleStringTypeRule= ruleStringTypeRule EOF )
            // InternalDefinitionLanguage.g:2854:2: iv_ruleStringTypeRule= ruleStringTypeRule EOF
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
    // InternalDefinitionLanguage.g:2860:1: ruleStringTypeRule returns [EObject current=null] : ( () otherlv_1= 'string' ) ;
    public final EObject ruleStringTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2866:2: ( ( () otherlv_1= 'string' ) )
            // InternalDefinitionLanguage.g:2867:2: ( () otherlv_1= 'string' )
            {
            // InternalDefinitionLanguage.g:2867:2: ( () otherlv_1= 'string' )
            // InternalDefinitionLanguage.g:2868:3: () otherlv_1= 'string'
            {
            // InternalDefinitionLanguage.g:2868:3: ()
            // InternalDefinitionLanguage.g:2869:4: 
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

            otherlv_1=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:2886:1: entryRuleExpressionTypeRule returns [EObject current=null] : iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF ;
    public final EObject entryRuleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2886:59: (iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF )
            // InternalDefinitionLanguage.g:2887:2: iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF
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
    // InternalDefinitionLanguage.g:2893:1: ruleExpressionTypeRule returns [EObject current=null] : ( () otherlv_1= 'expression' ) ;
    public final EObject ruleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2899:2: ( ( () otherlv_1= 'expression' ) )
            // InternalDefinitionLanguage.g:2900:2: ( () otherlv_1= 'expression' )
            {
            // InternalDefinitionLanguage.g:2900:2: ( () otherlv_1= 'expression' )
            // InternalDefinitionLanguage.g:2901:3: () otherlv_1= 'expression'
            {
            // InternalDefinitionLanguage.g:2901:3: ()
            // InternalDefinitionLanguage.g:2902:4: 
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

            otherlv_1=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:2919:1: entryRuleIntTypeRule returns [EObject current=null] : iv_ruleIntTypeRule= ruleIntTypeRule EOF ;
    public final EObject entryRuleIntTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2919:52: (iv_ruleIntTypeRule= ruleIntTypeRule EOF )
            // InternalDefinitionLanguage.g:2920:2: iv_ruleIntTypeRule= ruleIntTypeRule EOF
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
    // InternalDefinitionLanguage.g:2926:1: ruleIntTypeRule returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2932:2: ( ( () otherlv_1= 'int' ) )
            // InternalDefinitionLanguage.g:2933:2: ( () otherlv_1= 'int' )
            {
            // InternalDefinitionLanguage.g:2933:2: ( () otherlv_1= 'int' )
            // InternalDefinitionLanguage.g:2934:3: () otherlv_1= 'int'
            {
            // InternalDefinitionLanguage.g:2934:3: ()
            // InternalDefinitionLanguage.g:2935:4: 
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

            otherlv_1=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:2952:1: entryRuleRealTypeRule returns [EObject current=null] : iv_ruleRealTypeRule= ruleRealTypeRule EOF ;
    public final EObject entryRuleRealTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2952:53: (iv_ruleRealTypeRule= ruleRealTypeRule EOF )
            // InternalDefinitionLanguage.g:2953:2: iv_ruleRealTypeRule= ruleRealTypeRule EOF
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
    // InternalDefinitionLanguage.g:2959:1: ruleRealTypeRule returns [EObject current=null] : ( () otherlv_1= 'real' ) ;
    public final EObject ruleRealTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2965:2: ( ( () otherlv_1= 'real' ) )
            // InternalDefinitionLanguage.g:2966:2: ( () otherlv_1= 'real' )
            {
            // InternalDefinitionLanguage.g:2966:2: ( () otherlv_1= 'real' )
            // InternalDefinitionLanguage.g:2967:3: () otherlv_1= 'real'
            {
            // InternalDefinitionLanguage.g:2967:3: ()
            // InternalDefinitionLanguage.g:2968:4: 
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

            otherlv_1=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:2985:1: entryRuleBooleanTypeRule returns [EObject current=null] : iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF ;
    public final EObject entryRuleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2985:56: (iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF )
            // InternalDefinitionLanguage.g:2986:2: iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF
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
    // InternalDefinitionLanguage.g:2992:1: ruleBooleanTypeRule returns [EObject current=null] : ( () otherlv_1= 'boolean' ) ;
    public final EObject ruleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2998:2: ( ( () otherlv_1= 'boolean' ) )
            // InternalDefinitionLanguage.g:2999:2: ( () otherlv_1= 'boolean' )
            {
            // InternalDefinitionLanguage.g:2999:2: ( () otherlv_1= 'boolean' )
            // InternalDefinitionLanguage.g:3000:3: () otherlv_1= 'boolean'
            {
            // InternalDefinitionLanguage.g:3000:3: ()
            // InternalDefinitionLanguage.g:3001:4: 
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

            otherlv_1=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:3018:1: entryRuleVoidTypeRule returns [EObject current=null] : iv_ruleVoidTypeRule= ruleVoidTypeRule EOF ;
    public final EObject entryRuleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoidTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:3018:53: (iv_ruleVoidTypeRule= ruleVoidTypeRule EOF )
            // InternalDefinitionLanguage.g:3019:2: iv_ruleVoidTypeRule= ruleVoidTypeRule EOF
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
    // InternalDefinitionLanguage.g:3025:1: ruleVoidTypeRule returns [EObject current=null] : ( () otherlv_1= 'void' ) ;
    public final EObject ruleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3031:2: ( ( () otherlv_1= 'void' ) )
            // InternalDefinitionLanguage.g:3032:2: ( () otherlv_1= 'void' )
            {
            // InternalDefinitionLanguage.g:3032:2: ( () otherlv_1= 'void' )
            // InternalDefinitionLanguage.g:3033:3: () otherlv_1= 'void'
            {
            // InternalDefinitionLanguage.g:3033:3: ()
            // InternalDefinitionLanguage.g:3034:4: 
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

            otherlv_1=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:3051:1: entryRuleArrayTypeRule returns [EObject current=null] : iv_ruleArrayTypeRule= ruleArrayTypeRule EOF ;
    public final EObject entryRuleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:3051:54: (iv_ruleArrayTypeRule= ruleArrayTypeRule EOF )
            // InternalDefinitionLanguage.g:3052:2: iv_ruleArrayTypeRule= ruleArrayTypeRule EOF
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
    // InternalDefinitionLanguage.g:3058:1: ruleArrayTypeRule returns [EObject current=null] : (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) ;
    public final EObject ruleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3064:2: ( (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) )
            // InternalDefinitionLanguage.g:3065:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            {
            // InternalDefinitionLanguage.g:3065:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            // InternalDefinitionLanguage.g:3066:3: otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0());
              		
            }
            // InternalDefinitionLanguage.g:3070:3: ( (lv_elements_1_0= ruleTypeRule ) )
            // InternalDefinitionLanguage.g:3071:4: (lv_elements_1_0= ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:3071:4: (lv_elements_1_0= ruleTypeRule )
            // InternalDefinitionLanguage.g:3072:5: lv_elements_1_0= ruleTypeRule
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


    // $ANTLR start "entryRuleFunctionDefinitionRule"
    // InternalDefinitionLanguage.g:3093:1: entryRuleFunctionDefinitionRule returns [EObject current=null] : iv_ruleFunctionDefinitionRule= ruleFunctionDefinitionRule EOF ;
    public final EObject entryRuleFunctionDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinitionRule = null;


        try {
            // InternalDefinitionLanguage.g:3093:63: (iv_ruleFunctionDefinitionRule= ruleFunctionDefinitionRule EOF )
            // InternalDefinitionLanguage.g:3094:2: iv_ruleFunctionDefinitionRule= ruleFunctionDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDefinitionRule=ruleFunctionDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinitionRule; 
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
    // $ANTLR end "entryRuleFunctionDefinitionRule"


    // $ANTLR start "ruleFunctionDefinitionRule"
    // InternalDefinitionLanguage.g:3100:1: ruleFunctionDefinitionRule returns [EObject current=null] : (otherlv_0= 'def' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )? otherlv_7= ')' otherlv_8= ';' ) ;
    public final EObject ruleFunctionDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_parameters_4_0 = null;

        EObject lv_parameters_6_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3106:2: ( (otherlv_0= 'def' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )? otherlv_7= ')' otherlv_8= ';' ) )
            // InternalDefinitionLanguage.g:3107:2: (otherlv_0= 'def' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )? otherlv_7= ')' otherlv_8= ';' )
            {
            // InternalDefinitionLanguage.g:3107:2: (otherlv_0= 'def' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )? otherlv_7= ')' otherlv_8= ';' )
            // InternalDefinitionLanguage.g:3108:3: otherlv_0= 'def' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )? otherlv_7= ')' otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFunctionDefinitionRuleAccess().getDefKeyword_0());
              		
            }
            // InternalDefinitionLanguage.g:3112:3: ( (lv_type_1_0= ruleTypeRule ) )
            // InternalDefinitionLanguage.g:3113:4: (lv_type_1_0= ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:3113:4: (lv_type_1_0= ruleTypeRule )
            // InternalDefinitionLanguage.g:3114:5: lv_type_1_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_type_1_0=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionDefinitionRuleRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDefinitionLanguage.g:3131:3: ( (lv_name_2_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:3132:4: (lv_name_2_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:3132:4: (lv_name_2_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:3133:5: lv_name_2_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_name_2_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionDefinitionRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionRuleAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalDefinitionLanguage.g:3154:3: ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==18||(LA41_0>=37 && LA41_0<=38)||(LA41_0>=47 && LA41_0<=54)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalDefinitionLanguage.g:3155:4: ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )*
                    {
                    // InternalDefinitionLanguage.g:3155:4: ( (lv_parameters_4_0= ruleParameterRule ) )
                    // InternalDefinitionLanguage.g:3156:5: (lv_parameters_4_0= ruleParameterRule )
                    {
                    // InternalDefinitionLanguage.g:3156:5: (lv_parameters_4_0= ruleParameterRule )
                    // InternalDefinitionLanguage.g:3157:6: lv_parameters_4_0= ruleParameterRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_parameters_4_0=ruleParameterRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefinitionRuleRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_4_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.ParameterRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalDefinitionLanguage.g:3174:4: (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==20) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalDefinitionLanguage.g:3175:5: otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) )
                    	    {
                    	    otherlv_5=(Token)match(input,20,FOLLOW_38); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionRuleAccess().getCommaKeyword_4_1_0());
                    	      				
                    	    }
                    	    // InternalDefinitionLanguage.g:3179:5: ( (lv_parameters_6_0= ruleParameterRule ) )
                    	    // InternalDefinitionLanguage.g:3180:6: (lv_parameters_6_0= ruleParameterRule )
                    	    {
                    	    // InternalDefinitionLanguage.g:3180:6: (lv_parameters_6_0= ruleParameterRule )
                    	    // InternalDefinitionLanguage.g:3181:7: lv_parameters_6_0= ruleParameterRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_parameters_6_0=ruleParameterRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getFunctionDefinitionRuleRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_6_0,
                    	      								"de.evoal.languages.model.base.dsl.BaseLanguage.ParameterRule");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,21,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getFunctionDefinitionRuleAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_8=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getFunctionDefinitionRuleAccess().getSemicolonKeyword_6());
              		
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
    // $ANTLR end "ruleFunctionDefinitionRule"


    // $ANTLR start "entryRuleConstantDefinitionRule"
    // InternalDefinitionLanguage.g:3212:1: entryRuleConstantDefinitionRule returns [EObject current=null] : iv_ruleConstantDefinitionRule= ruleConstantDefinitionRule EOF ;
    public final EObject entryRuleConstantDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinitionRule = null;


        try {
            // InternalDefinitionLanguage.g:3212:63: (iv_ruleConstantDefinitionRule= ruleConstantDefinitionRule EOF )
            // InternalDefinitionLanguage.g:3213:2: iv_ruleConstantDefinitionRule= ruleConstantDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantDefinitionRule=ruleConstantDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantDefinitionRule; 
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
    // $ANTLR end "entryRuleConstantDefinitionRule"


    // $ANTLR start "ruleConstantDefinitionRule"
    // InternalDefinitionLanguage.g:3219:1: ruleConstantDefinitionRule returns [EObject current=null] : (otherlv_0= 'const' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= ':=' ( (lv_value_4_0= ruleExpressionRule ) ) otherlv_5= ';' ) ;
    public final EObject ruleConstantDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3225:2: ( (otherlv_0= 'const' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= ':=' ( (lv_value_4_0= ruleExpressionRule ) ) otherlv_5= ';' ) )
            // InternalDefinitionLanguage.g:3226:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= ':=' ( (lv_value_4_0= ruleExpressionRule ) ) otherlv_5= ';' )
            {
            // InternalDefinitionLanguage.g:3226:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= ':=' ( (lv_value_4_0= ruleExpressionRule ) ) otherlv_5= ';' )
            // InternalDefinitionLanguage.g:3227:3: otherlv_0= 'const' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= ':=' ( (lv_value_4_0= ruleExpressionRule ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstantDefinitionRuleAccess().getConstKeyword_0());
              		
            }
            // InternalDefinitionLanguage.g:3231:3: ( (lv_type_1_0= ruleTypeRule ) )
            // InternalDefinitionLanguage.g:3232:4: (lv_type_1_0= ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:3232:4: (lv_type_1_0= ruleTypeRule )
            // InternalDefinitionLanguage.g:3233:5: lv_type_1_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstantDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_type_1_0=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstantDefinitionRuleRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDefinitionLanguage.g:3250:3: ( (lv_name_2_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:3251:4: (lv_name_2_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:3251:4: (lv_name_2_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:3252:5: lv_name_2_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstantDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_30);
            lv_name_2_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstantDefinitionRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,39,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConstantDefinitionRuleAccess().getColonEqualsSignKeyword_3());
              		
            }
            // InternalDefinitionLanguage.g:3273:3: ( (lv_value_4_0= ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:3274:4: (lv_value_4_0= ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:3274:4: (lv_value_4_0= ruleExpressionRule )
            // InternalDefinitionLanguage.g:3275:5: lv_value_4_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstantDefinitionRuleAccess().getValueExpressionRuleParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_value_4_0=ruleExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstantDefinitionRuleRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_4_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getConstantDefinitionRuleAccess().getSemicolonKeyword_5());
              		
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
    // $ANTLR end "ruleConstantDefinitionRule"


    // $ANTLR start "entryRuleParameterRule"
    // InternalDefinitionLanguage.g:3300:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // InternalDefinitionLanguage.g:3300:54: (iv_ruleParameterRule= ruleParameterRule EOF )
            // InternalDefinitionLanguage.g:3301:2: iv_ruleParameterRule= ruleParameterRule EOF
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
    // InternalDefinitionLanguage.g:3307:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3313:2: ( ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) )
            // InternalDefinitionLanguage.g:3314:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            {
            // InternalDefinitionLanguage.g:3314:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:3315:3: ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:3315:3: ( (lv_type_0_0= ruleTypeRule ) )
            // InternalDefinitionLanguage.g:3316:4: (lv_type_0_0= ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:3316:4: (lv_type_0_0= ruleTypeRule )
            // InternalDefinitionLanguage.g:3317:5: lv_type_0_0= ruleTypeRule
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

            // InternalDefinitionLanguage.g:3334:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:3335:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:3335:4: (lv_name_1_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:3336:5: lv_name_1_0= ruleStringOrId
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
    // InternalDefinitionLanguage.g:3357:1: entryRuleImportRule returns [EObject current=null] : iv_ruleImportRule= ruleImportRule EOF ;
    public final EObject entryRuleImportRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRule = null;


        try {
            // InternalDefinitionLanguage.g:3357:51: (iv_ruleImportRule= ruleImportRule EOF )
            // InternalDefinitionLanguage.g:3358:2: iv_ruleImportRule= ruleImportRule EOF
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
    // InternalDefinitionLanguage.g:3364:1: ruleImportRule returns [EObject current=null] : (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' ) ;
    public final EObject ruleImportRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_language_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_importedNamespace_3_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3370:2: ( (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' ) )
            // InternalDefinitionLanguage.g:3371:2: (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' )
            {
            // InternalDefinitionLanguage.g:3371:2: (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' )
            // InternalDefinitionLanguage.g:3372:3: otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportRuleAccess().getImportKeyword_0());
              		
            }
            // InternalDefinitionLanguage.g:3376:3: ( (lv_language_1_0= RULE_STRING ) )
            // InternalDefinitionLanguage.g:3377:4: (lv_language_1_0= RULE_STRING )
            {
            // InternalDefinitionLanguage.g:3377:4: (lv_language_1_0= RULE_STRING )
            // InternalDefinitionLanguage.g:3378:5: lv_language_1_0= RULE_STRING
            {
            lv_language_1_0=(Token)match(input,RULE_STRING,FOLLOW_42); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,58,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getImportRuleAccess().getFromKeyword_2());
              		
            }
            // InternalDefinitionLanguage.g:3398:3: ( (lv_importedNamespace_3_0= ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:3399:4: (lv_importedNamespace_3_0= ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:3399:4: (lv_importedNamespace_3_0= ruleQualifiedName )
            // InternalDefinitionLanguage.g:3400:5: lv_importedNamespace_3_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_15);
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

            otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:3425:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDefinitionLanguage.g:3425:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDefinitionLanguage.g:3426:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalDefinitionLanguage.g:3432:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_0 = null;

        AntlrDatatypeRuleToken this_StringOrId_2 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3438:2: ( (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) )
            // InternalDefinitionLanguage.g:3439:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            {
            // InternalDefinitionLanguage.g:3439:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            // InternalDefinitionLanguage.g:3440:3: this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )*
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
            // InternalDefinitionLanguage.g:3450:3: (kw= '.' this_StringOrId_2= ruleStringOrId )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==35) ) {
                    int LA42_2 = input.LA(2);

                    if ( (LA42_2==RULE_QUOTED_ID) ) {
                        int LA42_3 = input.LA(3);

                        if ( (synpred60_InternalDefinitionLanguage()) ) {
                            alt42=1;
                        }


                    }
                    else if ( (LA42_2==RULE_ID) ) {
                        int LA42_4 = input.LA(3);

                        if ( (synpred60_InternalDefinitionLanguage()) ) {
                            alt42=1;
                        }


                    }


                }


                switch (alt42) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:3451:4: kw= '.' this_StringOrId_2= ruleStringOrId
            	    {
            	    kw=(Token)match(input,35,FOLLOW_4); if (state.failed) return current;
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
            	    break loop42;
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
    // InternalDefinitionLanguage.g:3471:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalDefinitionLanguage.g:3471:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalDefinitionLanguage.g:3472:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalDefinitionLanguage.g:3478:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3484:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalDefinitionLanguage.g:3485:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalDefinitionLanguage.g:3485:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_QUOTED_ID) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_ID) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalDefinitionLanguage.g:3486:3: this_QUOTED_ID_0= RULE_QUOTED_ID
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
                    // InternalDefinitionLanguage.g:3494:3: this_ID_1= RULE_ID
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


    // $ANTLR start "ruleScaleType"
    // InternalDefinitionLanguage.g:3505:1: ruleScaleType returns [Enumerator current=null] : ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) ) ;
    public final Enumerator ruleScaleType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3511:2: ( ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) ) )
            // InternalDefinitionLanguage.g:3512:2: ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) )
            {
            // InternalDefinitionLanguage.g:3512:2: ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt44=1;
                }
                break;
            case 60:
                {
                alt44=2;
                }
                break;
            case 61:
                {
                alt44=3;
                }
                break;
            case 62:
                {
                alt44=4;
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
                    // InternalDefinitionLanguage.g:3513:3: (enumLiteral_0= 'nominal' )
                    {
                    // InternalDefinitionLanguage.g:3513:3: (enumLiteral_0= 'nominal' )
                    // InternalDefinitionLanguage.g:3514:4: enumLiteral_0= 'nominal'
                    {
                    enumLiteral_0=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:3521:3: (enumLiteral_1= 'ordinal' )
                    {
                    // InternalDefinitionLanguage.g:3521:3: (enumLiteral_1= 'ordinal' )
                    // InternalDefinitionLanguage.g:3522:4: enumLiteral_1= 'ordinal'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:3529:3: (enumLiteral_2= 'cardinal' )
                    {
                    // InternalDefinitionLanguage.g:3529:3: (enumLiteral_2= 'cardinal' )
                    // InternalDefinitionLanguage.g:3530:4: enumLiteral_2= 'cardinal'
                    {
                    enumLiteral_2=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:3537:3: (enumLiteral_3= 'quotient' )
                    {
                    // InternalDefinitionLanguage.g:3537:3: (enumLiteral_3= 'quotient' )
                    // InternalDefinitionLanguage.g:3538:4: enumLiteral_3= 'quotient'
                    {
                    enumLiteral_3=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getQuotientEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getScaleTypeAccess().getQuotientEnumLiteralDeclaration_3());
                      			
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
    // $ANTLR end "ruleScaleType"


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalDefinitionLanguage.g:3548:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalDefinitionLanguage.g:3554:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalDefinitionLanguage.g:3555:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalDefinitionLanguage.g:3555:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt45=6;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt45=1;
                }
                break;
            case 64:
                {
                alt45=2;
                }
                break;
            case 65:
                {
                alt45=3;
                }
                break;
            case 66:
                {
                alt45=4;
                }
                break;
            case 67:
                {
                alt45=5;
                }
                break;
            case 68:
                {
                alt45=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalDefinitionLanguage.g:3556:3: (enumLiteral_0= '>=' )
                    {
                    // InternalDefinitionLanguage.g:3556:3: (enumLiteral_0= '>=' )
                    // InternalDefinitionLanguage.g:3557:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:3564:3: (enumLiteral_1= '>' )
                    {
                    // InternalDefinitionLanguage.g:3564:3: (enumLiteral_1= '>' )
                    // InternalDefinitionLanguage.g:3565:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:3572:3: (enumLiteral_2= '=' )
                    {
                    // InternalDefinitionLanguage.g:3572:3: (enumLiteral_2= '=' )
                    // InternalDefinitionLanguage.g:3573:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:3580:3: (enumLiteral_3= '!=' )
                    {
                    // InternalDefinitionLanguage.g:3580:3: (enumLiteral_3= '!=' )
                    // InternalDefinitionLanguage.g:3581:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:3588:3: (enumLiteral_4= '<' )
                    {
                    // InternalDefinitionLanguage.g:3588:3: (enumLiteral_4= '<' )
                    // InternalDefinitionLanguage.g:3589:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:3596:3: (enumLiteral_5= '<=' )
                    {
                    // InternalDefinitionLanguage.g:3596:3: (enumLiteral_5= '<=' )
                    // InternalDefinitionLanguage.g:3597:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:3607:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3613:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalDefinitionLanguage.g:3614:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalDefinitionLanguage.g:3614:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==69) ) {
                alt46=1;
            }
            else if ( (LA46_0==70) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalDefinitionLanguage.g:3615:3: (enumLiteral_0= '+' )
                    {
                    // InternalDefinitionLanguage.g:3615:3: (enumLiteral_0= '+' )
                    // InternalDefinitionLanguage.g:3616:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:3623:3: (enumLiteral_1= '-' )
                    {
                    // InternalDefinitionLanguage.g:3623:3: (enumLiteral_1= '-' )
                    // InternalDefinitionLanguage.g:3624:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:3634:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:3640:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalDefinitionLanguage.g:3641:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalDefinitionLanguage.g:3641:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt47=1;
                }
                break;
            case 72:
                {
                alt47=2;
                }
                break;
            case 73:
                {
                alt47=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalDefinitionLanguage.g:3642:3: (enumLiteral_0= '*' )
                    {
                    // InternalDefinitionLanguage.g:3642:3: (enumLiteral_0= '*' )
                    // InternalDefinitionLanguage.g:3643:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:3650:3: (enumLiteral_1= '/' )
                    {
                    // InternalDefinitionLanguage.g:3650:3: (enumLiteral_1= '/' )
                    // InternalDefinitionLanguage.g:3651:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:3658:3: (enumLiteral_2= '%' )
                    {
                    // InternalDefinitionLanguage.g:3658:3: (enumLiteral_2= '%' )
                    // InternalDefinitionLanguage.g:3659:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
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
    // InternalDefinitionLanguage.g:3669:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalDefinitionLanguage.g:3675:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalDefinitionLanguage.g:3676:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalDefinitionLanguage.g:3676:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt48=20;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt48=1;
                }
                break;
            case 75:
                {
                alt48=2;
                }
                break;
            case 76:
                {
                alt48=3;
                }
                break;
            case 77:
                {
                alt48=4;
                }
                break;
            case 78:
                {
                alt48=5;
                }
                break;
            case 79:
                {
                alt48=6;
                }
                break;
            case 80:
                {
                alt48=7;
                }
                break;
            case 81:
                {
                alt48=8;
                }
                break;
            case 82:
                {
                alt48=9;
                }
                break;
            case 83:
                {
                alt48=10;
                }
                break;
            case 84:
                {
                alt48=11;
                }
                break;
            case 85:
                {
                alt48=12;
                }
                break;
            case 86:
                {
                alt48=13;
                }
                break;
            case 87:
                {
                alt48=14;
                }
                break;
            case 88:
                {
                alt48=15;
                }
                break;
            case 89:
                {
                alt48=16;
                }
                break;
            case 90:
                {
                alt48=17;
                }
                break;
            case 91:
                {
                alt48=18;
                }
                break;
            case 92:
                {
                alt48=19;
                }
                break;
            case 93:
                {
                alt48=20;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalDefinitionLanguage.g:3677:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalDefinitionLanguage.g:3677:3: (enumLiteral_0= 'Y' )
                    // InternalDefinitionLanguage.g:3678:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:3685:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalDefinitionLanguage.g:3685:3: (enumLiteral_1= 'Z' )
                    // InternalDefinitionLanguage.g:3686:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:3693:3: (enumLiteral_2= 'E' )
                    {
                    // InternalDefinitionLanguage.g:3693:3: (enumLiteral_2= 'E' )
                    // InternalDefinitionLanguage.g:3694:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:3701:3: (enumLiteral_3= 'P' )
                    {
                    // InternalDefinitionLanguage.g:3701:3: (enumLiteral_3= 'P' )
                    // InternalDefinitionLanguage.g:3702:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:3709:3: (enumLiteral_4= 'T' )
                    {
                    // InternalDefinitionLanguage.g:3709:3: (enumLiteral_4= 'T' )
                    // InternalDefinitionLanguage.g:3710:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:3717:3: (enumLiteral_5= 'G' )
                    {
                    // InternalDefinitionLanguage.g:3717:3: (enumLiteral_5= 'G' )
                    // InternalDefinitionLanguage.g:3718:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalDefinitionLanguage.g:3725:3: (enumLiteral_6= 'M' )
                    {
                    // InternalDefinitionLanguage.g:3725:3: (enumLiteral_6= 'M' )
                    // InternalDefinitionLanguage.g:3726:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalDefinitionLanguage.g:3733:3: (enumLiteral_7= 'k' )
                    {
                    // InternalDefinitionLanguage.g:3733:3: (enumLiteral_7= 'k' )
                    // InternalDefinitionLanguage.g:3734:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalDefinitionLanguage.g:3741:3: (enumLiteral_8= 'h' )
                    {
                    // InternalDefinitionLanguage.g:3741:3: (enumLiteral_8= 'h' )
                    // InternalDefinitionLanguage.g:3742:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalDefinitionLanguage.g:3749:3: (enumLiteral_9= 'da' )
                    {
                    // InternalDefinitionLanguage.g:3749:3: (enumLiteral_9= 'da' )
                    // InternalDefinitionLanguage.g:3750:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalDefinitionLanguage.g:3757:3: (enumLiteral_10= 'd' )
                    {
                    // InternalDefinitionLanguage.g:3757:3: (enumLiteral_10= 'd' )
                    // InternalDefinitionLanguage.g:3758:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalDefinitionLanguage.g:3765:3: (enumLiteral_11= 'c' )
                    {
                    // InternalDefinitionLanguage.g:3765:3: (enumLiteral_11= 'c' )
                    // InternalDefinitionLanguage.g:3766:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalDefinitionLanguage.g:3773:3: (enumLiteral_12= 'm' )
                    {
                    // InternalDefinitionLanguage.g:3773:3: (enumLiteral_12= 'm' )
                    // InternalDefinitionLanguage.g:3774:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalDefinitionLanguage.g:3781:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalDefinitionLanguage.g:3781:3: (enumLiteral_13= '\\u00B5' )
                    // InternalDefinitionLanguage.g:3782:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalDefinitionLanguage.g:3789:3: (enumLiteral_14= 'n' )
                    {
                    // InternalDefinitionLanguage.g:3789:3: (enumLiteral_14= 'n' )
                    // InternalDefinitionLanguage.g:3790:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalDefinitionLanguage.g:3797:3: (enumLiteral_15= 'p' )
                    {
                    // InternalDefinitionLanguage.g:3797:3: (enumLiteral_15= 'p' )
                    // InternalDefinitionLanguage.g:3798:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                      			
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalDefinitionLanguage.g:3805:3: (enumLiteral_16= 'f' )
                    {
                    // InternalDefinitionLanguage.g:3805:3: (enumLiteral_16= 'f' )
                    // InternalDefinitionLanguage.g:3806:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalDefinitionLanguage.g:3813:3: (enumLiteral_17= 'a' )
                    {
                    // InternalDefinitionLanguage.g:3813:3: (enumLiteral_17= 'a' )
                    // InternalDefinitionLanguage.g:3814:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                      			
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalDefinitionLanguage.g:3821:3: (enumLiteral_18= 'z' )
                    {
                    // InternalDefinitionLanguage.g:3821:3: (enumLiteral_18= 'z' )
                    // InternalDefinitionLanguage.g:3822:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                      			
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalDefinitionLanguage.g:3829:3: (enumLiteral_19= 'y' )
                    {
                    // InternalDefinitionLanguage.g:3829:3: (enumLiteral_19= 'y' )
                    // InternalDefinitionLanguage.g:3830:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
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

    // $ANTLR start synpred2_InternalDefinitionLanguage
    public final void synpred2_InternalDefinitionLanguage_fragment() throws RecognitionException {   
        EObject lv_enums_4_0 = null;


        // InternalDefinitionLanguage.g:134:4: ( ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) ) )
        // InternalDefinitionLanguage.g:134:4: ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) )
        {
        // InternalDefinitionLanguage.g:134:4: ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) )
        // InternalDefinitionLanguage.g:135:5: (lv_enums_4_0= ruleEnumTypeDefinitionRule )
        {
        // InternalDefinitionLanguage.g:135:5: (lv_enums_4_0= ruleEnumTypeDefinitionRule )
        // InternalDefinitionLanguage.g:136:6: lv_enums_4_0= ruleEnumTypeDefinitionRule
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getEnumsEnumTypeDefinitionRuleParserRuleCall_4_0_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_enums_4_0=ruleEnumTypeDefinitionRule();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_InternalDefinitionLanguage

    // $ANTLR start synpred3_InternalDefinitionLanguage
    public final void synpred3_InternalDefinitionLanguage_fragment() throws RecognitionException {   
        EObject lv_types_5_0 = null;


        // InternalDefinitionLanguage.g:154:4: ( ( (lv_types_5_0= ruleClassDefinitionRule ) ) )
        // InternalDefinitionLanguage.g:154:4: ( (lv_types_5_0= ruleClassDefinitionRule ) )
        {
        // InternalDefinitionLanguage.g:154:4: ( (lv_types_5_0= ruleClassDefinitionRule ) )
        // InternalDefinitionLanguage.g:155:5: (lv_types_5_0= ruleClassDefinitionRule )
        {
        // InternalDefinitionLanguage.g:155:5: (lv_types_5_0= ruleClassDefinitionRule )
        // InternalDefinitionLanguage.g:156:6: lv_types_5_0= ruleClassDefinitionRule
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getTypesClassDefinitionRuleParserRuleCall_4_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_types_5_0=ruleClassDefinitionRule();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalDefinitionLanguage

    // $ANTLR start synpred60_InternalDefinitionLanguage
    public final void synpred60_InternalDefinitionLanguage_fragment() throws RecognitionException {   
        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_2 = null;


        // InternalDefinitionLanguage.g:3451:4: (kw= '.' this_StringOrId_2= ruleStringOrId )
        // InternalDefinitionLanguage.g:3451:4: kw= '.' this_StringOrId_2= ruleStringOrId
        {
        kw=(Token)match(input,35,FOLLOW_4); if (state.failed) return ;
        pushFollow(FOLLOW_2);
        this_StringOrId_2=ruleStringOrId();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_InternalDefinitionLanguage

    // Delegated rules

    public final boolean synpred60_InternalDefinitionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalDefinitionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalDefinitionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalDefinitionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalDefinitionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalDefinitionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA16 dfa16 = new DFA16(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\21\1\uffff\1\0\10\uffff";
    static final String dfa_3s = "\1\76\1\uffff\1\0\10\uffff";
    static final String dfa_4s = "\1\uffff\1\5\1\uffff\1\1\3\uffff\1\2\1\uffff\1\3\1\4";
    static final String dfa_5s = "\2\uffff\1\0\10\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\30\uffff\2\7\1\uffff\1\2\11\uffff\1\11\1\12\2\uffff\4\3",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 133:3: ( ( (lv_enums_4_0= ruleEnumTypeDefinitionRule ) ) | ( (lv_types_5_0= ruleClassDefinitionRule ) ) | ( (lv_functions_6_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_7_0= ruleConstantDefinitionRule ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_2 = input.LA(1);

                         
                        int index2_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalDefinitionLanguage()) ) {s = 3;}

                        else if ( (synpred3_InternalDefinitionLanguage()) ) {s = 7;}

                         
                        input.seek(index2_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_8s = "\1\4\1\uffff\2\20\3\uffff\1\7\1\uffff\2\20";
    static final String dfa_9s = "\1\51\1\uffff\2\111\3\uffff\1\10\1\uffff\2\111";
    static final String dfa_10s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_11s = "\13\uffff}>";
    static final String[] dfa_12s = {
            "\3\4\1\2\1\3\12\uffff\1\5\13\uffff\1\1\1\uffff\2\6\1\uffff\3\6\1\uffff\2\4",
            "",
            "\1\4\2\uffff\1\10\2\6\3\uffff\4\6\1\uffff\1\6\1\uffff\1\6\2\uffff\1\7\33\uffff\13\6",
            "\1\4\2\uffff\1\10\2\6\3\uffff\4\6\1\uffff\1\6\1\uffff\1\6\2\uffff\1\7\33\uffff\13\6",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\1\4\2\uffff\1\10\2\6\3\uffff\4\6\1\uffff\1\6\1\uffff\1\6\2\uffff\1\7\33\uffff\13\6",
            "\1\4\2\uffff\1\10\2\6\3\uffff\4\6\1\uffff\1\6\1\uffff\1\6\2\uffff\1\7\33\uffff\13\6"
    };
    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_1;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1134:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0200000000008000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x79802C0000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x7800200000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000376A20801F0L,0x0000000000000060L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000376A00801F0L,0x0000000000000060L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x8000000000000002L,0x000000000000001FL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000380L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000377A00801F0L,0x0000000000000060L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000376A02801F0L,0x0000000000000060L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000020180L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x000000003FFFFC00L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00002C0000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000100000010000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000200000020180L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00000300000001F0L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000200000000180L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x007FC06000040000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x007FC06000240000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0400000000000000L});

}